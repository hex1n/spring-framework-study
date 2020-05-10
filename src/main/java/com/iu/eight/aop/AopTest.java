package com.iu.eight.aop;


import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author hex1n
 * @Time 2020/5/10 22:12
 */
public class AopTest {
    public static void main(String[] args) {
      /*  CalImpl cal = new CalImpl();
        MyInvocationHandler handler = new MyInvocationHandler();
        Cal cal1 = (Cal) handler.bind(cal);
        cal1.add(10, 3);
        cal1.sub(10, 3);
        cal1.mul(10, 3);
        cal1.div(10, 3);*/

        //加载spring.xml
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Cal cal2 = (Cal) context.getBean("calImpl");
        cal2.add(10, 3);
        cal2.sub(10, 3);
        cal2.mul(10, 3);
        cal2.div(10, 3);
    }
}
