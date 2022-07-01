package com.loc;

import android.content.Context;
import android.os.Build;
import java.io.ByteArrayOutputStream;

public final class bi extends bk {
  public static int a = 13;
  
  public static int b = 6;
  
  private Context e;
  
  public bi(Context paramContext, bk parambk) {
    super(parambk);
    this.e = paramContext;
  }
  
  private static byte[] a(Context paramContext) {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[0];
    try {
      StringBuilder stringBuilder = new StringBuilder("1.2.");
      stringBuilder.append(a);
      stringBuilder.append(".");
      stringBuilder.append(b);
      u.a(byteArrayOutputStream, stringBuilder.toString());
      u.a(byteArrayOutputStream, "Android");
      u.a(byteArrayOutputStream, n.x(paramContext));
      u.a(byteArrayOutputStream, n.m(paramContext));
      u.a(byteArrayOutputStream, n.h(paramContext));
      u.a(byteArrayOutputStream, Build.MANUFACTURER);
      u.a(byteArrayOutputStream, Build.MODEL);
      u.a(byteArrayOutputStream, Build.DEVICE);
      u.a(byteArrayOutputStream, n.A(paramContext));
      u.a(byteArrayOutputStream, k.c(paramContext));
      u.a(byteArrayOutputStream, k.d(paramContext));
      u.a(byteArrayOutputStream, k.f(paramContext));
      byteArrayOutputStream.write(new byte[] { 0 });
      byte[] arrayOfByte2 = byteArrayOutputStream.toByteArray();
      byte[] arrayOfByte1 = arrayOfByte2;
    } finally {
      paramContext = null;
    } 
  }
  
  protected final byte[] a(byte[] paramArrayOfbyte) {
    byte[] arrayOfByte1 = a(this.e);
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + paramArrayOfbyte.length];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
    System.arraycopy(paramArrayOfbyte, 0, arrayOfByte2, arrayOfByte1.length, paramArrayOfbyte.length);
    return arrayOfByte2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */