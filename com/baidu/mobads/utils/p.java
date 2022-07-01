package com.baidu.mobads.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.mobads.MobadsPermissionSettings;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class p implements IXAdIOUtils {
  private static File a() {
    return Environment.getExternalStorageDirectory();
  }
  
  public static String a(Context paramContext) {
    return !r.a(paramContext) ? a(paramContext, "/mnt/sdcard") : (r.c(paramContext) ? a(paramContext, "/mnt/sdcard") : a(paramContext.getExternalFilesDir(null).getPath()));
  }
  
  public static String a(Context paramContext, String paramString) {
    try {
      return a(b(paramContext).getPath());
    } catch (Exception exception) {
      return a(paramString);
    } 
  }
  
  public static String a(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("/bddownload/");
    return stringBuilder.toString();
  }
  
  public static boolean a(File paramFile) {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramFile != null) {
      bool1 = bool2;
      try {
        if (paramFile.exists()) {
          bool1 = bool2;
          if (paramFile.canRead()) {
            long l = paramFile.length();
            bool1 = bool2;
            if (l > 0L)
              bool1 = true; 
          } 
        } 
        return bool1;
      } catch (Exception exception) {
        return false;
      } 
    } 
    return bool1;
  }
  
  public static File b(Context paramContext) {
    try {
      return (Build.VERSION.SDK_INT > 28) ? paramContext.getExternalFilesDir(null) : ("mounted".equals(Environment.getExternalStorageState()) ? ((h.b(paramContext, "android.permission.WRITE_EXTERNAL_STORAGE") && MobadsPermissionSettings.hasPermissionGranted("permission_storage")) ? a() : ((Build.VERSION.SDK_INT >= 19) ? paramContext.getExternalFilesDir(null) : paramContext.getFilesDir())) : paramContext.getFilesDir());
    } catch (Exception exception) {
      XAdSDKFoundationFacade.getInstance().getAdLogger().e(new Object[] { "XAdIOUtils", exception.getMessage() });
      return null;
    } 
  }
  
  public static boolean b(String paramString) {
    boolean bool = false;
    try {
      if (TextUtils.isEmpty(paramString))
        return false; 
      File file = new File(paramString);
      boolean bool1 = bool;
      if (file.exists()) {
        bool1 = bool;
        if (file.canRead()) {
          long l = file.length();
          bool1 = bool;
          if (l > 0L)
            bool1 = true; 
        } 
      } 
      return bool1;
    } catch (Exception exception) {
      return false;
    } 
  }
  
  public void copyFileFromAssetsTo(Context paramContext, String paramString1, String paramString2) {
    try {
      InputStream inputStream = paramContext.getAssets().open(paramString1);
      XAdSDKFoundationFacade.getInstance().getIoUtils().copyFileInputStream(inputStream, paramString2);
      return;
    } catch (Exception exception) {
      XAdSDKFoundationFacade.getInstance().getAdLogger().d(exception);
      return;
    } 
  }
  
  public void copyFileInputStream(InputStream paramInputStream, String paramString) {
    Exception exception;
    try {
      FileOutputStream fileOutputStream = new FileOutputStream(paramString);
    } finally {
      exception = null;
    } 
    if (paramInputStream != null)
      paramInputStream.close(); 
    if (paramString != null)
      paramString.close(); 
    throw exception;
  }
  
  public File deleteFileRecursive(File paramFile) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual isDirectory : ()Z
    //   4: ifeq -> 40
    //   7: aload_1
    //   8: invokevirtual listFiles : ()[Ljava/io/File;
    //   11: astore #4
    //   13: iconst_0
    //   14: istore_2
    //   15: iload_2
    //   16: aload #4
    //   18: arraylength
    //   19: if_icmpge -> 40
    //   22: aload_0
    //   23: aload #4
    //   25: iload_2
    //   26: aaload
    //   27: invokevirtual deleteFileRecursive : (Ljava/io/File;)Ljava/io/File;
    //   30: astore #5
    //   32: aload #5
    //   34: ifnull -> 74
    //   37: aload #5
    //   39: areturn
    //   40: aload_1
    //   41: invokevirtual delete : ()Z
    //   44: istore_3
    //   45: iload_3
    //   46: ifeq -> 51
    //   49: aconst_null
    //   50: astore_1
    //   51: aload_1
    //   52: areturn
    //   53: aload_1
    //   54: astore #4
    //   56: aload_1
    //   57: invokevirtual delete : ()Z
    //   60: ifeq -> 66
    //   63: aconst_null
    //   64: astore #4
    //   66: aload #4
    //   68: areturn
    //   69: astore #4
    //   71: goto -> 53
    //   74: iload_2
    //   75: iconst_1
    //   76: iadd
    //   77: istore_2
    //   78: goto -> 15
    // Exception table:
    //   from	to	target	type
    //   0	13	69	java/lang/Exception
    //   15	32	69	java/lang/Exception
    //   40	45	69	java/lang/Exception
  }
  
  public File deleteFileRecursive(String paramString) {
    return deleteFileRecursive(new File(paramString));
  }
  
  public File getExternalFilesDir(Context paramContext) {
    return b(paramContext);
  }
  
  public String getStoreagePath(Context paramContext) {
    return a(paramContext, "/mnt/sdcard");
  }
  
  @Deprecated
  public String getStoreagePath(Context paramContext, String paramString1, String paramString2) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(getExternalFilesDir(paramContext).getPath());
      stringBuilder.append(paramString2);
      return stringBuilder.toString();
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString1);
      stringBuilder.append(paramString2);
      return stringBuilder.toString();
    } 
  }
  
  public boolean renameFile(String paramString1, String paramString2) {
    boolean bool = false;
    try {
      File file1 = new File(paramString1);
      File file2 = new File(paramString2);
      if (file1.exists())
        bool = file1.renameTo(file2); 
      return bool;
    } catch (Exception exception) {
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobad\\utils\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */