package corejava9.v2ch01.objectStream;

import java.io.*;

public class ChildSerial extends ParentSerial implements Serializable {

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
            ChildSerial child= new ChildSerial();
            child.setName("abc");
            child.setAge(1);
            child.setGender("Man");

            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream("result.obj"));
            out.writeObject(child);
            out.close();

            ObjectInputStream oin = new ObjectInputStream(new FileInputStream(
                    "result.obj"));

            ChildSerial child1 = (ChildSerial) oin.readObject();
            oin.close();

            //再读取
            System.out.println(child1.getName());
            System.out.println(child1.getAge());
            System.out.println(child1.getGender());

            /* 在Parent实现了序列化接口的情况下输出：

                abc
                1
                Man

             说明Parent对象也被序列化了。
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
