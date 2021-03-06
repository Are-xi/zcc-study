package cgilb1;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    private Object target;

    public CglibProxy(Object target){
        this.target=target;
    }

    //为目标类生成代理对象
    public Object getProxyInstance(){
        //工具类
        Enhancer en = new Enhancer();
        //设置父类
        en.setSuperclass(target.getClass());
        //设置回调函数
        en.setCallback(this);
        //返回子类代理对象
        return en.create();
    }



    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始");
        Object returnValue = method.invoke(target,objects);
        System.out.println("介绍");
        return null;
    }
}
