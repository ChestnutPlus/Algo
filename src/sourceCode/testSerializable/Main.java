package sourceCode.testSerializable;

import java.io.*;

/**
 * <pre>
 *     author: Chestnut
 *     blog  : http://www.jianshu.com/u/a0206b5f4526
 *     time  : 2018/11/6 10:47
 *     desc  :
 *     thanks To:
 *     dependent on:
 *     update log:
 * </pre>
 */
public class Main {
    public static void main(String args[]) throws IOException, ClassNotFoundException {
        FileOutputStream fos = new FileOutputStream("temp.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Person person = new Person();
        person.name = "王尼玛";
        person.height = 190;
        person.age = 28;
        oos.writeObject(person);
        oos.flush();
        oos.close();
    }
}
