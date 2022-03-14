package cgilb1;

public class Test {

    public static void main(String[] args) {
        UserDao target = new UserDao();

        UserDao proxy = (UserDao) new CglibProxy(target).getProxyInstance();

        proxy.save();

    }

}
