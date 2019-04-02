package sourceCode.overideOverload;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *     author: Chestnut
 *     blog  : http://www.jianshu.com/u/a0206b5f4526
 *     time  : 2018/11/9 9:32
 *     desc  :
 *     thanks To:
 *     dependent on:
 *     update log:
 * </pre>
 */
public class Main {

    public static void main(String[] args ) throws IOException {

        Person person = new Person("小王",22);
        Map<String,Integer> map = new HashMap<>();
        map.put("饭",1);
        map.put("蔬菜",2);
        map.put("肉",1);
        person.eat(map);

        Teacher teacher = new Teacher("李老师", 25);
        teacher.eat(map);

    }

}
