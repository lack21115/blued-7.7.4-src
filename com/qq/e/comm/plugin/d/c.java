package com.qq.e.comm.plugin.d;

import android.content.Context;
import android.net.Uri;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.lang.reflect.Method;

public class c {
  private static Class a;
  
  private static Class b;
  
  private static Class c;
  
  static {
    try {
      a = Class.forName("androidx.core.content.FileProvider");
    } catch (ClassNotFoundException classNotFoundException) {
      a = null;
    } 
    try {
      b = Class.forName("androidx.core.content.FileProvider");
    } catch (ClassNotFoundException classNotFoundException) {
      b = null;
    } 
    try {
      c = Class.forName("com.qq.e.comm.GDTFileProvider");
      return;
    } catch (ClassNotFoundException classNotFoundException) {
      c = null;
    } 
  }
  
  public static Uri a(Context paramContext, File paramFile) {
    // Byte code:
    //   0: getstatic android/os/Build$VERSION.SDK_INT : I
    //   3: bipush #29
    //   5: if_icmpge -> 36
    //   8: getstatic android/os/Build$VERSION.SDK_INT : I
    //   11: bipush #24
    //   13: if_icmplt -> 31
    //   16: aload_0
    //   17: invokevirtual getApplicationInfo : ()Landroid/content/pm/ApplicationInfo;
    //   20: getfield targetSdkVersion : I
    //   23: bipush #24
    //   25: if_icmplt -> 31
    //   28: goto -> 36
    //   31: aload_1
    //   32: invokestatic fromFile : (Ljava/io/File;)Landroid/net/Uri;
    //   35: areturn
    //   36: aload_0
    //   37: invokevirtual getPackageName : ()Ljava/lang/String;
    //   40: astore #4
    //   42: new java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial <init> : ()V
    //   49: astore_2
    //   50: aload_2
    //   51: aload #4
    //   53: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_2
    //   58: ldc '.fileprovider'
    //   60: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload_0
    //   65: aload_2
    //   66: invokevirtual toString : ()Ljava/lang/String;
    //   69: aload_1
    //   70: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/io/File;)Landroid/net/Uri;
    //   73: astore_3
    //   74: aload_3
    //   75: ifnull -> 90
    //   78: aload_3
    //   79: astore_2
    //   80: aload_3
    //   81: invokevirtual getPath : ()Ljava/lang/String;
    //   84: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   87: ifeq -> 122
    //   90: new java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial <init> : ()V
    //   97: astore_2
    //   98: aload_2
    //   99: aload #4
    //   101: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload_2
    //   106: ldc '.gdt.fileprovider'
    //   108: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload_0
    //   113: aload_2
    //   114: invokevirtual toString : ()Ljava/lang/String;
    //   117: aload_1
    //   118: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/io/File;)Landroid/net/Uri;
    //   121: astore_2
    //   122: aload_2
    //   123: ifnull -> 147
    //   126: aload_2
    //   127: invokevirtual getPath : ()Ljava/lang/String;
    //   130: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   133: ifeq -> 145
    //   136: getstatic com/qq/e/comm/plugin/d/c.c : Ljava/lang/Class;
    //   139: ifnull -> 145
    //   142: goto -> 147
    //   145: aload_2
    //   146: areturn
    //   147: new java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial <init> : ()V
    //   154: astore_2
    //   155: aload_2
    //   156: aload #4
    //   158: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload_2
    //   163: ldc '.gdt.fileprovider'
    //   165: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload_0
    //   170: aload_2
    //   171: invokevirtual toString : ()Ljava/lang/String;
    //   174: aload_1
    //   175: invokestatic getUriForFile : (Landroid/content/Context;Ljava/lang/String;Ljava/io/File;)Landroid/net/Uri;
    //   178: areturn
  }
  
  private static Uri a(Context paramContext, String paramString, File paramFile) {
    Uri uri = Uri.EMPTY;
    try {
      String str;
      Class clazz = a;
      if (clazz != null) {
        Method method = a.getMethod("getUriForFile", new Class[] { Context.class, String.class, File.class });
        str = "FileProvider androidx support->androidx";
      } else if (b != null) {
        Method method = b.getMethod("getUriForFile", new Class[] { Context.class, String.class, File.class });
        str = "FileProvider support support->androidx";
      } else {
        clazz = null;
        if (clazz != null)
          return (Uri)clazz.invoke(null, new Object[] { paramContext, paramString, paramFile }); 
      } 
      GDTLogger.d(str);
    } finally {
      paramContext = null;
    } 
    return uri;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\d\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */