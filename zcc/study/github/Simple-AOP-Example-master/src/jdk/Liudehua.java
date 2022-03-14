package jdk;

public class Liudehua implements Star {
    @Override
    public String sing(String name) {

        System.out.println("liu sing");

        return "sing ok";
    }

    @Override
    public String dance(String name) {
        System.out.println("liu dance");
        return "dance ok";
    }
}
