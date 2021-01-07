package cn.gyu.shiro1;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;

/**
 * 测试自定义Realm
 * @author 五斤斤
 */
public class TestMyRealm {
    public static void main(String[] args) {
        //创建SercurityManager
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        //设置自定义Realm获取认证数据
        defaultSecurityManager.setRealm(new CustomRealm());
        //在工具类中设置安全管理器
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        //获取主体对象
        Subject subject = SecurityUtils.getSubject();
        //创建token令牌
        UsernamePasswordToken token = new UsernamePasswordToken("wuqing","123");
        try{
            subject.login(token);//用户登陆
            System.out.println("登陆成功");
        }catch (UnknownAccountException e){
            System.out.println("认证失败，没有该用户名！");
        }catch (IncorrectCredentialsException e){
            System.out.println("认证失败，密码错误！");
        }
    }
}
