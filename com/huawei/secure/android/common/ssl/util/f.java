package com.huawei.secure.android.common.ssl.util;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;

public abstract class f {
  public static void a(Closeable paramCloseable) {
    if (paramCloseable != null)
      try {
        paramCloseable.close();
        return;
      } catch (IOException iOException) {
        g.d("IOUtil", "closeSecure IOException");
      }  
  }
  
  public static void a(InputStream paramInputStream) {
    a(paramInputStream);
  }
  
  public static void a(OutputStream paramOutputStream) {
    a(paramOutputStream);
  }
  
  public static void a(Reader paramReader) {
    a(paramReader);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\secure\android\common\ss\\util\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */