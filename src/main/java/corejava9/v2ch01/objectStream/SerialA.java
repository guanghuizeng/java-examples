package corejava9.v2ch01.objectStream;

import java.io.Serializable;

public class SerialA implements Serializable {

    private static final long serialVersionUID = 2L;

    private String name = "name";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SerialA{" +
                "name='" + name + '\'' +
                '}';
    }
}
