package p1_1;

import java.util.Objects;

/**
 * @Author yongz
 * @Date 2020/8/11、9:37
 */
public class Student {
    private String name;    // 姓名
    private int age;   //年龄
    private int core;   //分数

    public Student(String name, int age, int core) {
        this.name = name;
        this.age = age;
        this.core = core;
    }
       // 重写equals方法。
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                name.equals(student.name);    // 我这里是：如果年龄和姓名一样，我们认为是统一student
    }

       // 注意重写equals之前要重写hashCode方法。
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", core=" + core +
                '}';
    }
}
