package sourceCode.overideOverload;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *     author: Chestnut
 *     blog  : http://www.jianshu.com/u/a0206b5f4526
 *     time  : 2018/11/9 9:29
 *     desc  :
 *     thanks To:
 *     dependent on:
 *     update log:
 * </pre>
 */
public class Person {

    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    protected void eat(Map<String, ? extends Integer> map) throws IOException{
        System.out.println("eat Map");
    }

    public void eat(HashMap map) {
        System.out.println("eat HashMap");
    }

    public void eat() {
        System.out.println("eat null");
    }

    public boolean eat(int a) {
        System.out.println("eat a");
        return true;
    }
}
