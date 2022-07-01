package com.amap.api.col.s;

import android.content.Context;
import android.os.Build;
import java.io.ByteArrayOutputStream;

public final class dl extends dn {
  public static int a = 13;
  
  public static int b = 6;
  
  private Context e;
  
  public dl(Context paramContext, dn paramdn) {
    super(paramdn);
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
      bs.a(byteArrayOutputStream, stringBuilder.toString());
      bs.a(byteArrayOutputStream, "Android");
      bs.a(byteArrayOutputStream, bm.t(paramContext));
      bs.a(byteArrayOutputStream, bm.m(paramContext));
      bs.a(byteArrayOutputStream, bm.h(paramContext));
      bs.a(byteArrayOutputStream, Build.MANUFACTURER);
      bs.a(byteArrayOutputStream, Build.MODEL);
      bs.a(byteArrayOutputStream, Build.DEVICE);
      bs.a(byteArrayOutputStream, bm.v(paramContext));
      bs.a(byteArrayOutputStream, bi.c(paramContext));
      bs.a(byteArrayOutputStream, bi.d(paramContext));
      bs.a(byteArrayOutputStream, bi.f(paramContext));
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\dl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */