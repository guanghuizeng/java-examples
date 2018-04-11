package corejava9.v2ch01.objectStream;

import java.io.*;

public class SerialSecretField implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private transient Integer age;

    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private void writeObject(ObjectOutputStream out) {
        try {
            ObjectOutputStream.PutField putField = out.putFields();
            System.out.println("原密码：" + password);
            password = "enc"; // 模拟加密
            putField.put("password", password);
            System.out.println("加密后的密码：" + password);
            out.writeFields();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream in) {
        try {
            ObjectInputStream.GetField getField = in.readFields();
            Object object = getField.get("password", "");
            System.out.println("要解密的字符串：" + object);
            password = "pass";  // 模拟解密
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("result.obj"));
            SerialSecretField serialSecretField = new SerialSecretField();
            serialSecretField.setAge(1);
            serialSecretField.setName("n");
            serialSecretField.setPassword("pass");
            out.writeObject(serialSecretField);
            out.close();


            ObjectInputStream in = new ObjectInputStream(new FileInputStream("result.obj"));
            SerialSecretField serialSecretField1 = (SerialSecretField) in.readObject();
            System.out.println("解密后的密码：" + serialSecretField1.getPassword());
            in.close();

            /* 输出：

                原密码：pass
                加密后的密码：enc
                要解密的字符串：enc
                解密后的密码：pass

             */
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {

        }
    }
}

