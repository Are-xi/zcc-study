package jdk;

public class Test {

    public static void main(String[] args) {
        Star liu = new Liudehua();
        JdProxy jdProxy = new JdProxy();

        jdProxy.setTarget(liu);

        Object object = jdProxy.createProxyObj();

        Star star = (Star) object;
        star.dance("sf");
    }

}
