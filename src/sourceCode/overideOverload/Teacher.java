package sourceCode.overideOverload;

import java.io.IOException;
import java.util.Map;

/**
 * <pre>
 *     author: Chestnut
 *     blog  : http://www.jianshu.com/u/a0206b5f4526
 *     time  : 2018/11/9 9:34
 *     desc  :
 *     thanks To:
 *     dependent on:
 *     update log:
 * </pre>
 */
public class Teacher extends Person{

    public Teacher(String name, int age) {
        super(name, age);
    }

    public void say() {
        System.out.print("my name is " + super.name+"," + age + " years old this year," + "i'm a teacher");
    }

    @Override
    public void eat(Map<String, ? extends Integer> map) {
        try {
            super.eat(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
