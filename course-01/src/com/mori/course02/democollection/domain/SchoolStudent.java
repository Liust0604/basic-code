package com.mori.course02.democollection.domain;

import java.util.Objects;

//要求：同名和同年龄就可以判断为同一个人
public class SchoolStudent implements Comparable {
    private String name;
    private int age;

    public SchoolStudent() {
    }

    public SchoolStudent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "SchoolStudent{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //集合存储自定义元素，需要重新equals和hashCode方法，保证元素唯一性
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SchoolStudent that = (SchoolStudent) o;

        if (this.age != that.age) return false;
        return Objects.equals(this.name, that.name);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof SchoolStudent) {
            SchoolStudent s = (SchoolStudent) o;
            return this.getAge() - s.getAge(); //升序
        }
        return 0;
    }
}
