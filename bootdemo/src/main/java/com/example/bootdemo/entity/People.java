package com.example.bootdemo.entity;

public class People {

    private String id;

    private Integer age;

    private User user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "People{" +
                "id='" + id + '\'' +
                ", age=" + age +
                ", user=" + user +
                '}';
    }
}
