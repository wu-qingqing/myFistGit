package cn.gyu.shiro1;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 自定义Realm
 * @author 五斤斤
 */
public class CustomRealm extends AuthorizingRealm {
    //授权方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
    //认证方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户输入的密码
        String principal = (String) authenticationToken.getPrincipal();
        //模拟输入的信息等于数据库中的数据
        if(principal.equals("wuqing")){
            //参数1：用户名       参数2：密码      参数3：类名
            return new SimpleAuthenticationInfo(principal, "123", this.getName());
        }
        return null;
    }
}
