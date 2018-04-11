package corejava9.v2ch01.objectStream;

import java.io.*;

public class SerialTransient implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private transient Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public static void main(String[] args) {


        try {
            SerialTransient serialTransient= new SerialTransient();
            serialTransient.setName("name");
            serialTransient.setAge(1);

            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream("result.obj"));
            out.writeObject(serialTransient);
            out.close();

            ObjectInputStream oin = new ObjectInputStream(new FileInputStream(
                    "result.obj"));

            SerialTransient serialTransient1 = (SerialTransient) oin.readObject();
            oin.close();

            //再读取
            System.out.println(serialTransient1 .getName());
            System.out.println(serialTransient1 .getAge());

            /* 用transient关键字修饰age属性的情况下输出：

                name
                null

             说明age属性没有被序列化。
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
