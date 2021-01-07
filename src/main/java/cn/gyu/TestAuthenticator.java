package cn.gyu;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;

/**
 * 测试shiro，无数据库连接
 *
 * @author 五斤斤
 */
public class TestAuthenticator
{
    public static void main( String[] args ) {
        //创建安全管理器对象
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        //给安全管理器设置Realm
        securityManager.setRealm(new IniRealm("classpath:shiro.ini"));

        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("wuqing","123");

        try{
            System.out.println("认证前，认证状态："+subject.isAuthenticated());
            subject.login(token);
            System.out.println("认证后，认证状态："+subject.isAuthenticated());
        }catch (UnknownAccountException e){
            System.out.println("认证失败，没有该账号");
        }catch (IncorrectCredentialsException e){
            System.out.println("认证失败，密码错误");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
