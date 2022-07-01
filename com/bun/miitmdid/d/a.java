package com.bun.miitmdid.d;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class a {
  public static String a(Context paramContext, String paramString) {
    try {
      InputStream inputStream = paramContext.getAssets().open(paramString);
      int i = inputStream.available();
      byte[] arrayOfByte = new byte[i];
      inputStream.read(arrayOfByte);
      inputStream.close();
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      byteArrayOutputStream.write(arrayOfByte, 0, i);
      return byteArrayOutputStream.toString();
    } catch (IOException iOException) {
      iOException.printStackTrace();
      return "";
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\bun\miitmdid\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */