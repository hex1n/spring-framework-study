package com.iu.eight.ioc;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author hex1n
 * @Time 2020/5/10 20:56
 */
public class ClassPathXmlApplicationContext implements ApplicationContext {
    private final Map<String, Object> ioc = new HashMap<String, Object>();

    public ClassPathXmlApplicationContext(String path) {
        try {
            SAXReader reader = new SAXReader();
            Document document = reader.read("./src/main/resources/" + path);
            Element rootElement = document.getRootElement();
            Iterator<Element> iterator = rootElement.elementIterator();
            while (iterator.hasNext()) {
                Element element = iterator.next();
                String id = element.attributeValue("id");
                String className = element.attributeValue("class");
                //通过反射机制创建对象
                Class clazz = Class.forName(className);
                //获取无参构造函数,创建目标对象
                Constructor constructor = clazz.getConstructor();
                Object obj = constructor.newInstance();
                //给目标赋值
                Iterator<Element> beanIterator = element.elementIterator();
                while (beanIterator.hasNext()) {
                    Element property = beanIterator.next();
                    String name = property.attributeValue("name");
                    String valueStr = property.attributeValue("value");
                    String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
                    Field field = clazz.getDeclaredField(name);
                    Method method = clazz.getDeclaredMethod(methodName, field.getType());
                    //根据成员变量的数据类型将value进行转换
                    Object value = null;
                    if ("long".equals(field.getType().getName())) {
                        value = Long.parseLong(valueStr);
                    }
                    if ("java.lang.String".equals(field.getType().getName())) {
                        value = valueStr;
                    }
                    if ("java.lang.Integer".equals(field.getType().getName())) {
                        value = Integer.valueOf(valueStr);
                    }
                    if ("int".equals(field.getType().getName())) {
                        value = Integer.parseInt(valueStr);
                    }
                    method.invoke(obj, value);
                    ioc.put(id, obj);
                }
            }
        } catch (DocumentException | NoSuchFieldException | ClassNotFoundException | NoSuchMethodException |
            IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object getBean(String id) {
        return ioc.get(id);
    }
}
