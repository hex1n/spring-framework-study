package com.iu.eight.entity;

/**
 * @Author hex1n
 * @Time 2020/5/10 20:54
 */
public class Address {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Address{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
