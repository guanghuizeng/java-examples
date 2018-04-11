package corejava9.v2ch01.objectStream;

import java.io.*;


/**
 * Parent类没有实现序列化接口；Child类实现了Child类接口
 */
public class Child extends Parent implements Serializable {
    private static final long serialVersionUID = 1L;

    private String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public static void main(String[] args) {
        try {
            Child child= new Child();
            child.setName("abc");
            child.setAge(1);
            child.setGender("Man");

            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream("result.obj"));
            out.writeObject(child);
            out.close();

            ObjectInputStream oin = new ObjectInputStream(new FileInputStream(
                    "result.obj"));

            Child child1 = (Child) oin.readObject();
            oin.close();

            //再读取
            System.out.println(child1.getName());
            System.out.println(child1.getAge());
            System.out.println(child1.getGender());

            /* 在Parent没有实现序列化接口的情况下输出：

                null
                null
                Man

             说明Parent对象的属性没有被序列化。
             */
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
