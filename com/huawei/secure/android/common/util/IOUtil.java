package com.huawei.secure.android.common.util;

import android.util.Log;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtil {
  public static void a(Closeable paramCloseable) {
    if (paramCloseable != null)
      try {
        paramCloseable.close();
        return;
      } catch (IOException iOException) {
        Log.e("IOUtil", "closeSecure IOException");
      }  
  }
  
  public static void a(InputStream paramInputStream) {
    a(paramInputStream);
  }
  
  public static void a(OutputStream paramOutputStream) {
    a(paramOutputStream);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\secure\android\commo\\util\IOUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */