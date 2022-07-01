package com.ishumei.l111l1111llIl;

import java.io.ByteArrayOutputStream;
import java.util.zip.Inflater;

public final class l11l1111lIIl {
  public static byte[] l1111l111111Il(byte[] paramArrayOfbyte) {
    byte[] arrayOfByte = new byte[4096];
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(paramArrayOfbyte.length);
    Inflater inflater = new Inflater();
    inflater.setInput(paramArrayOfbyte, 0, paramArrayOfbyte.length);
    while (!inflater.finished()) {
      int i = inflater.inflate(arrayOfByte);
      if (i > 0)
        byteArrayOutputStream.write(arrayOfByte, 0, i); 
    } 
    inflater.end();
    return byteArrayOutputStream.toByteArray();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l111l1111llIl\l11l1111lIIl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */