package com.huawei.hms.framework.network.grs.d;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class c {
  private static final String a = "c";
  
  public static String a(String paramString, Context paramContext) {
    if (TextUtils.isEmpty(paramString))
      return ""; 
    InputStream inputStream2 = null;
    InputStream inputStream1 = null;
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    try {
      InputStream inputStream = paramContext.getAssets().open(paramString);
      inputStream1 = inputStream;
      inputStream2 = inputStream;
      byte[] arrayOfByte = new byte[8192];
      while (true) {
        inputStream1 = inputStream;
        inputStream2 = inputStream;
        int i = inputStream.read(arrayOfByte);
        if (i != -1) {
          inputStream1 = inputStream;
          inputStream2 = inputStream;
          byteArrayOutputStream.write(arrayOfByte, 0, i);
          continue;
        } 
        inputStream1 = inputStream;
        inputStream2 = inputStream;
        byteArrayOutputStream.flush();
        inputStream1 = inputStream;
        inputStream2 = inputStream;
        arrayOfByte = byteArrayOutputStream.toByteArray();
        inputStream1 = inputStream;
        inputStream2 = inputStream;
        return new String(arrayOfByte, "UTF-8");
      } 
    } catch (IOException iOException) {
      inputStream1 = inputStream2;
      String str = a;
      inputStream1 = inputStream2;
      Logger.w(str, "local config file is not exist.filename is {%s}", new Object[] { paramString });
      return "";
    } finally {
      a(byteArrayOutputStream);
      a(inputStream1);
    } 
  }
  
  public static void a(Closeable paramCloseable) {
    if (paramCloseable != null)
      try {
        paramCloseable.close();
        return;
      } catch (IOException iOException) {
        Logger.e(a, "closeQuietly IOException", iOException);
      }  
  }
  
  public static void a(InputStream paramInputStream) {
    a(paramInputStream);
  }
  
  public static void a(OutputStream paramOutputStream) {
    a(paramOutputStream);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\network\grs\d\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */