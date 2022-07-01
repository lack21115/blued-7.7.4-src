package com.pgl.a.b;

import android.content.Context;
import java.io.Closeable;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class e {
  private static List<String> a = new ArrayList<String>();
  
  private static File a(Context paramContext) {
    if (paramContext == null || paramContext.getFilesDir() == null)
      return null; 
    File file = new File(paramContext.getFilesDir(), "libso");
    if (!file.exists())
      b.a(file.getAbsolutePath()); 
    return file;
  }
  
  private static String a(Context paramContext, String paramString, File paramFile) {
    String str;
    ZipEntry zipEntry1;
    ZipEntry zipEntry2 = null;
    try {
      ZipEntry zipEntry;
    } finally {
      paramContext = null;
      paramString = null;
      str = paramString;
    } 
    try {
      String str2 = paramContext.getMessage();
      b.a((Closeable)zipEntry1);
    } finally {
      b.a((Closeable)zipEntry1);
      b.a((Closeable)paramString);
      b.a((ZipFile)str);
    } 
    b.a((ZipFile)paramContext);
    return paramString;
  }
  
  public static boolean a(Context paramContext, String paramString) {
    // Byte code:
    //   0: ldc com/pgl/a/b/e
    //   2: monitorenter
    //   3: getstatic com/pgl/a/b/e.a : Ljava/util/List;
    //   6: aload_1
    //   7: invokeinterface contains : (Ljava/lang/Object;)Z
    //   12: istore_2
    //   13: iload_2
    //   14: ifeq -> 22
    //   17: ldc com/pgl/a/b/e
    //   19: monitorexit
    //   20: iconst_1
    //   21: ireturn
    //   22: aload_1
    //   23: invokestatic loadLibrary : (Ljava/lang/String;)V
    //   26: getstatic com/pgl/a/b/e.a : Ljava/util/List;
    //   29: aload_1
    //   30: invokeinterface add : (Ljava/lang/Object;)Z
    //   35: pop
    //   36: goto -> 104
    //   39: ldc com/pgl/a/b/e
    //   41: monitorexit
    //   42: iconst_0
    //   43: ireturn
    //   44: aload_0
    //   45: aload_1
    //   46: invokestatic b : (Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   49: astore_3
    //   50: aload_3
    //   51: ifnonnull -> 59
    //   54: ldc com/pgl/a/b/e
    //   56: monitorexit
    //   57: iconst_0
    //   58: ireturn
    //   59: aload_3
    //   60: invokevirtual exists : ()Z
    //   63: ifeq -> 71
    //   66: aload_3
    //   67: invokevirtual delete : ()Z
    //   70: pop
    //   71: aload_0
    //   72: aload_1
    //   73: aload_3
    //   74: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/io/File;)Ljava/lang/String;
    //   77: astore_0
    //   78: aload_0
    //   79: ifnull -> 87
    //   82: ldc com/pgl/a/b/e
    //   84: monitorexit
    //   85: iconst_0
    //   86: ireturn
    //   87: aload_3
    //   88: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   91: invokestatic load : (Ljava/lang/String;)V
    //   94: getstatic com/pgl/a/b/e.a : Ljava/util/List;
    //   97: aload_1
    //   98: invokeinterface add : (Ljava/lang/Object;)Z
    //   103: pop
    //   104: ldc com/pgl/a/b/e
    //   106: monitorexit
    //   107: iconst_1
    //   108: ireturn
    //   109: ldc com/pgl/a/b/e
    //   111: monitorexit
    //   112: iconst_0
    //   113: ireturn
    //   114: astore_0
    //   115: ldc com/pgl/a/b/e
    //   117: monitorexit
    //   118: aload_0
    //   119: athrow
    //   120: astore_3
    //   121: goto -> 44
    //   124: astore_0
    //   125: goto -> 39
    //   128: astore_0
    //   129: goto -> 109
    // Exception table:
    //   from	to	target	type
    //   3	13	114	finally
    //   22	36	120	java/lang/UnsatisfiedLinkError
    //   22	36	124	finally
    //   44	50	114	finally
    //   59	71	114	finally
    //   71	78	114	finally
    //   87	104	128	finally
  }
  
  private static File b(Context paramContext, String paramString) {
    paramString = System.mapLibraryName(paramString);
    File file = a(paramContext);
    return (file != null) ? new File(file, paramString) : null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\pgl\a\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */