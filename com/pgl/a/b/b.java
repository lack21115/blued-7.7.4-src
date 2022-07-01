package com.pgl.a.b;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.zip.ZipFile;

public class b {
  public static void a(Closeable paramCloseable) {
    if (paramCloseable == null)
      return; 
    try {
      paramCloseable.close();
      return;
    } catch (IOException iOException) {
      return;
    } 
  }
  
  public static void a(String paramString, int paramInt) {
    Integer integer = Integer.valueOf(-1);
    c.a("android.os.FileUtils", paramString, new Object[] { Integer.valueOf(paramInt), integer, integer });
  }
  
  public static void a(ZipFile paramZipFile) {
    if (paramZipFile == null)
      return; 
    try {
      paramZipFile.close();
      return;
    } catch (IOException iOException) {
      return;
    } 
  }
  
  public static boolean a(String paramString) {
    return (new File(paramString)).mkdirs();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\pgl\a\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */