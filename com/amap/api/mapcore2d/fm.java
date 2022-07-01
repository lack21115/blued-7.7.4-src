package com.amap.api.mapcore2d;

import android.content.Context;
import android.os.Build;
import java.io.ByteArrayOutputStream;

public class fm extends fo {
  public static int a = 13;
  
  public static int b = 6;
  
  private Context e;
  
  public fm(Context paramContext, fo paramfo) {
    super(paramfo);
    this.e = paramContext;
  }
  
  private byte[] a(Context paramContext) {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[0];
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("1.2.");
      stringBuilder.append(a);
      stringBuilder.append(".");
      stringBuilder.append(b);
      db.a(byteArrayOutputStream, stringBuilder.toString());
      db.a(byteArrayOutputStream, "Android");
      db.a(byteArrayOutputStream, cu.v(paramContext));
      db.a(byteArrayOutputStream, cu.m(paramContext));
      db.a(byteArrayOutputStream, cu.h(paramContext));
      db.a(byteArrayOutputStream, Build.MANUFACTURER);
      db.a(byteArrayOutputStream, Build.MODEL);
      db.a(byteArrayOutputStream, Build.DEVICE);
      db.a(byteArrayOutputStream, cu.x(paramContext));
      db.a(byteArrayOutputStream, cq.c(paramContext));
      db.a(byteArrayOutputStream, cq.d(paramContext));
      db.a(byteArrayOutputStream, cq.f(paramContext));
      byteArrayOutputStream.write(new byte[] { 0 });
      byte[] arrayOfByte2 = byteArrayOutputStream.toByteArray();
      byte[] arrayOfByte1 = arrayOfByte2;
    } finally {
      paramContext = null;
    } 
  }
  
  protected byte[] a(byte[] paramArrayOfbyte) {
    byte[] arrayOfByte1 = a(this.e);
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + paramArrayOfbyte.length];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
    System.arraycopy(paramArrayOfbyte, 0, arrayOfByte2, arrayOfByte1.length, paramArrayOfbyte.length);
    return arrayOfByte2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\fm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */