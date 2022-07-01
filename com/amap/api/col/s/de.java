package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;

public final class de {
  private Context a;
  
  private String b;
  
  private String c;
  
  private String d;
  
  private String e;
  
  public de(Context paramContext, String paramString1, String paramString2, String paramString3) throws bh {
    if (!TextUtils.isEmpty(paramString3) && paramString3.length() <= 256) {
      this.a = paramContext.getApplicationContext();
      this.c = paramString1;
      this.d = paramString2;
      this.b = paramString3;
      return;
    } 
    throw new bh("无效的参数 - IllegalArgumentException");
  }
  
  public final void a(String paramString) throws bh {
    if (!TextUtils.isEmpty(paramString) && paramString.length() <= 65536) {
      this.e = paramString;
      return;
    } 
    throw new bh("无效的参数 - IllegalArgumentException");
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
      cg.c(null, "se", "tds");
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\de.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */