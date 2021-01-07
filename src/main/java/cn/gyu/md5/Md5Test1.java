package cn.gyu.md5;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;

import java.sql.SQLOutput;

/**
 * 测试MD5加密，随机盐，自定义Realm，认证
 * @author 五斤斤
 */
public class Md5Test1 {
    public static void main(String[] args) {
        //设置SecurityManager
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        //设置自定义Realm获取认证数据
        MyMd5Realm1 myMd5Realm1 = new MyMd5Realm1();
        //设置MD5加密
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("MD5");//加密方式
        credentialsMatcher.setHashIterations(1024);//散列次数
        myMd5Realm1.setCredentialsMatcher(credentialsMatcher);
        defaultSecurityManager.setRealm(myMd5Realm1);
        //在安全工具类中设置安全管理器
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        //获取主体对象
        Subject subject = SecurityUtils.getSubject();
        //创建用户令牌
        UsernamePasswordToken token = new UsernamePasswordToken("wuqing", "123");
        try{
            subject.login(token);//用户登陆
            System.out.println("登陆成功");
        }catch (UnknownAccountException e){
            System.out.println("用户名错误");
        }catch (IncorrectCredentialsException e){
            System.out.println("密码错误");
        }
        System.out.println("====================================");

        if(subject.isAuthenticated()){
            boolean isAdmin = subject.hasRole("admin");
            System.out.println("是否有admin权限："+isAdmin);
            boolean permitted = subject.isPermitted("product:*:*");
            System.out.println("是否有对product的所有权限："+permitted);
        }else {
            System.out.println("您没有权限！");
        }
    }
}
