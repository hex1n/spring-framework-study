package com.iu.eight.ioc;


import com.iu.eight.entity.Address;

/**
 * @Author hex1n
 * @Time 2020/5/10 21:17
 */
public class IocTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Address address = (Address) context.getBean("address");
        System.out.println(address);
    }
}
