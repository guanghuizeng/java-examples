package corejava9.v1ch03.BasicTypes;


import sun.jvm.hotspot.utilities.Assert;

import static com.sun.jna.Native.getNativeSize;

public class BasicTypes {
    public static void main(String[] args) {

        // integer types
        Assert.that(getNativeSize(byte.class) == 1, "size of byte is not 1");
        Assert.that(getNativeSize(short.class) == 2, "size of byte is not 2");
        Assert.that(getNativeSize(int.class) == 4, "size of byte is not 4");
        Assert.that(getNativeSize(long.class) == 8, "size of byte is not 8");


        // floating point
        Assert.that(getNativeSize(float.class) == 4, "size of byte is not 32");
        Assert.that(getNativeSize(double.class) == 8, "size of byte is not 64");


        // boolean
        Assert.that(getNativeSize(boolean.class) == 4, "size of byte is not 4");


        // char, UTF-16 encoding
        Assert.that(getNativeSize(char.class) == 4, "size of byte is not 4");

    }

}
