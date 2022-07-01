package com.amap.api.mapcore2d;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;

public class ff {
  private Context a;
  
  private String b;
  
  private String c;
  
  private String d;
  
  private String e;
  
  public ff(Context paramContext, String paramString1, String paramString2, String paramString3) throws cp {
    if (!TextUtils.isEmpty(paramString3) && paramString3.length() <= 256) {
      this.a = paramContext.getApplicationContext();
      this.c = paramString1;
      this.d = paramString2;
      this.b = paramString3;
      return;
    } 
    throw new cp("无效的参数 - IllegalArgumentException");
  }
  
  public void a(String paramString) throws cp {
    if (!TextUtils.isEmpty(paramString) && paramString.length() <= 65536) {
      this.e = paramString;
      return;
    } 
    throw new cp("无效的参数 - IllegalArgumentException");
  }
  
  public byte[] a() {
    ByteArrayOutputStream byteArrayOutputStream;
    int i = 0;
    byte[] arrayOfByte = new byte[0];
    try {
      byteArrayOutputStream = new ByteArrayOutputStream();
    } finally {
      null = null;
    } 
    try {
      do.c(null, "se", "tds");
      return arrayOfByte;
    } finally {
      if (byteArrayOutputStream != null)
        try {
          byteArrayOutputStream.close();
        } finally {
          byteArrayOutputStream = null;
        }  
    } 
  }
  
  public byte[] a(int paramInt) {
    return new byte[] { (byte)(paramInt >> 24 & 0xFF), (byte)(paramInt >> 16 & 0xFF), (byte)(paramInt >> 8 & 0xFF), (byte)(paramInt & 0xFF) };
  }
  
  public byte[] b(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return new byte[] { 0, 0 }; 
    byte[] arrayOfByte = db.a(this.e);
    if (arrayOfByte == null)
      return new byte[] { 0, 0 }; 
    int i = arrayOfByte.length;
    return new byte[] { (byte)(i / 256), (byte)(i % 256) };
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\ff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */