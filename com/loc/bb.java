package com.loc;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;

public final class bb {
  private Context a;
  
  private String b;
  
  private String c;
  
  private String d;
  
  private String e;
  
  public bb(Context paramContext, String paramString1, String paramString2, String paramString3) throws j {
    if (!TextUtils.isEmpty(paramString3) && paramString3.length() <= 256) {
      this.a = paramContext.getApplicationContext();
      this.c = paramString1;
      this.d = paramString2;
      this.b = paramString3;
      return;
    } 
    throw new j("无效的参数 - IllegalArgumentException");
  }
  
  public final void a(String paramString) throws j {
    if (!TextUtils.isEmpty(paramString) && paramString.length() <= 65536) {
      this.e = paramString;
      return;
    } 
    throw new j("无效的参数 - IllegalArgumentException");
  }
  
  public final byte[] a() {
    ByteArrayOutputStream byteArrayOutputStream;
    byte[] arrayOfByte = new byte[0];
    try {
      byteArrayOutputStream = new ByteArrayOutputStream();
    } finally {
      null = null;
    } 
    try {
      ab.b(null, "se", "tds");
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
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */