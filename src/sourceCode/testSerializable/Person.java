package sourceCode.testSerializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * <pre>
 *     author: Chestnut
 *     blog  : http://www.jianshu.com/u/a0206b5f4526
 *     time  : 2018/11/6 10:46
 *     desc  :
 *     thanks To:
 *     dependent on:
 *     update log:
 * </pre>
 */
public class Person implements Serializable{

    private static final long serialVersionUID = 1L;
    private transient final String psdStr = "psdStr";
    public String name;
    public int height = 0;
    public int age= 0;

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", height=" + height +
                ", age=" + age +
                '}';
    }

    private void writeObject(ObjectOutputStream out) {
        try {
            ObjectOutputStream.PutField putFields = out.putFields();
            putFields.put("name", EncoderUtils.AESEncode(psdStr,String.valueOf(name)));
            putFields.put("height", height*1234);
            putFields.put("age", age*1234);
            out.writeFields();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream in) {
        try {
            ObjectInputStream.GetField readFields = in.readFields();
            name = EncoderUtils.AESDecode(psdStr, (String) readFields.get("name", ""));
            height = (readFields.get("height", 0))/1234;
            age = (readFields.get("age", 0))/1234;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
