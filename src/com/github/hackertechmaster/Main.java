package com.github.hackertechmaster;

import com.github.hackertechmaster.implement.ConcreteIBuy;
import com.github.hackertechmaster.implement.ConcreteILogin;
import com.github.hackertechmaster.implement.ConcreteRegister;
import com.github.hackertechmaster.interfaces.IBuy;
import com.github.hackertechmaster.interfaces.ILogin;
import com.github.hackertechmaster.interfaces.IRegister;

public class Main {
    private static IRegister iRegister;
    private static ILogin iLogin;
    private static IBuy iBuy;
    private static User user;

    public static void main(String[] args) {
        String username = "John";
        String password = "123";
        int moneyRequired = 20;
        //TODO 用新的实现类实现接口并实例化对象
         iRegister = new ConcreteRegister();
         iBuy = new ConcreteIBuy();
         iLogin = new ConcreteILogin();
        final boolean registerSuccess = iRegister.register(username, password);
        if(registerSuccess) {
            final boolean loginSuccess = iLogin.login(username, password) == ILogin.OK;
            if(loginSuccess) {
                user = UserManager.INSTANCE.findUserByName(username);
                user.setMoneyRemain(23);
                System.out.println("该用户剩余金额" + (iBuy.hasMoney(username, moneyRequired) ? "足够" : "不足"));
            }
        }
    }
}
