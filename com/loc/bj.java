package com.loc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public final class bj extends bk {
  public bj() {}
  
  public bj(bk parambk) {
    super(parambk);
  }
  
  protected final byte[] a(byte[] paramArrayOfbyte) {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append((new SimpleDateFormat("yyyyMMdd HHmmss")).format(new Date()));
    stringBuffer.append(" ");
    stringBuffer.append(UUID.randomUUID().toString());
    stringBuffer.append(" ");
    if (stringBuffer.length() != 53)
      return new byte[0]; 
    byte[] arrayOfByte1 = u.a(stringBuffer.toString());
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + paramArrayOfbyte.length];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
    System.arraycopy(paramArrayOfbyte, 0, arrayOfByte2, arrayOfByte1.length, paramArrayOfbyte.length);
    return arrayOfByte2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */