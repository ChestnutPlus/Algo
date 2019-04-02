package test;

/**
 * <pre>
 *     author: Chestnut
 *     blog  : http://www.jianshu.com/u/a0206b5f4526
 *     time  : 2018/10/19 10:05
 *     desc  :
 *     thanks To:
 *     dependent on:
 *     update log:
 * </pre>
 */
public class CloneTest {

    public static void main(String[] args) throws CloneNotSupportedException {

        Teacher teacher = new Teacher();
        teacher.name = "波多老师";

        Student s1 = new Student();
        s1.name = "小明";
        s1.age = 17;
        s1.teacher = teacher;

        System.out.println(s1.toString()+","+s1.hashCode());

        Student s2 = (Student) s1.clone();
        s2.name = "小红";
        s2.teacher.name = "苍老师";

        System.out.println(s1.toString()+","+s1.hashCode());
        System.out.println(s2.toString()+","+s2.hashCode());


        // Example 1: == comparison pure primitive – no autoboxing
        int i1 = 1;
        int i2 = 1;
        System.out.println("i1==i2 : " + (i1 == i2)); // true

        // Example 2: equality operator mixing object and primitive
        Integer num1 = 1; // autoboxing
        int num2 = 1;
        System.out.println("num1 == num2 : " + (num1 == num2)); // true

        // Example 3: special case - arises due to autoboxing in Java
        Integer obj1 = -129; // autoboxing will call Integer.valueOf()
        Integer obj2 = -129; // same call to Integer.valueOf() will return same
        // cached Object

        System.out.println("obj1 == obj2 : " + (obj1 == obj2)); // true

        // Example 4: equality operator - pure object comparison
        Integer one = new Integer(1); // no autoboxing
        Integer anotherOne = new Integer(1);
        System.out.println("one == anotherOne : " + (one == anotherOne)); // false

    }

}
