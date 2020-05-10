package com.iu.eight.aop;

import org.springframework.stereotype.Service;

/**
 * @Author hex1n
 * @Time 2020/5/10 22:11
 */
@Service
public class CalImpl implements Cal {

    @Override
    public int add(int num1, int num2) {
        return num1 + num2;
    }

    @Override
    public int sub(int num1, int num2) {
        return num1 - num2;
    }

    @Override
    public int mul(int num1, int num2) {
        return num1 * num2;
    }

    @Override
    public int div(int num1, int num2) {
        return num1 / num2;
    }
}
