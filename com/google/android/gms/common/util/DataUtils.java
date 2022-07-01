package com.google.android.gms.common.util;

import android.database.CharArrayBuffer;
import android.graphics.Bitmap;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;

public final class DataUtils {
  public static void copyStringToBuffer(String paramString, CharArrayBuffer paramCharArrayBuffer) {
    if (TextUtils.isEmpty(paramString)) {
      paramCharArrayBuffer.sizeCopied = 0;
    } else if (paramCharArrayBuffer.data == null || paramCharArrayBuffer.data.length < paramString.length()) {
      paramCharArrayBuffer.data = paramString.toCharArray();
    } else {
      paramString.getChars(0, paramString.length(), paramCharArrayBuffer.data, 0);
    } 
    paramCharArrayBuffer.sizeCopied = paramString.length();
  }
  
  public static byte[] loadImageBytes(Bitmap paramBitmap) {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
    return byteArrayOutputStream.toByteArray();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\commo\\util\DataUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */