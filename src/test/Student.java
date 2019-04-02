package test;

/**
 * <pre>
 *     author: Chestnut
 *     blog  : http://www.jianshu.com/u/a0206b5f4526
 *     time  : 2018/10/19 10:04
 *     desc  :
 *     thanks To:
 *     dependent on:
 *     update log:
 * </pre>
 */
public class Student implements Cloneable{

    public String name;
    public int age;

    public Teacher teacher;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", teacher=" + teacher.toString() +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student newStudent = (Student) super.clone();
        newStudent.teacher = (Teacher) teacher.clone();
        return newStudent;
    }
}
