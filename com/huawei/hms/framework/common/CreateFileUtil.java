package com.huawei.hms.framework.common;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.android.os.BuildEx;
import com.huawei.libcore.io.ExternalStorageFile;
import com.huawei.libcore.io.ExternalStorageFileInputStream;
import com.huawei.libcore.io.ExternalStorageFileOutputStream;
import com.huawei.libcore.io.ExternalStorageRandomAccessFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CreateFileUtil {
  private static final String BUILDEX_NAME = "com.huawei.android.os.BuildEx";
  
  private static final String EXTERNAL_FILE_NAME = "com.huawei.libcore.io.ExternalStorageFile";
  
  private static final String EXTERNAL_INPUTSTREAM_NAME = "com.huawei.libcore.io.ExternalStorageFileInputStream";
  
  private static final String EXTERNAL_OUTPUTSTREAM_NAME = "com.huawei.libcore.io.ExternalStorageFileOutputStream";
  
  private static final String RANDOM_ACCESS_FILE_NAME = "com.huawei.libcore.io.ExternalStorageRandomAccessFile";
  
  private static final String TAG = "CreateFileUtil";
  
  private static boolean checkCompatible(String paramString) {
    try {
      tryLoadClass(paramString);
      return true;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append("ClassNotFoundException");
      Logger.w("CreateFileUtil", stringBuilder.toString());
      return false;
    } 
  }
  
  public static void deleteSecure(File paramFile) {
    if (paramFile != null && paramFile.exists() && !paramFile.delete())
      Logger.w("CreateFileUtil", "deleteSecure exception"); 
  }
  
  public static void deleteSecure(String paramString) {
    if (!TextUtils.isEmpty(paramString))
      deleteSecure(newFile(paramString)); 
  }
  
  public static String getCacheDirPath(Context paramContext) {
    if (paramContext == null)
      return ""; 
    if (Build.VERSION.SDK_INT >= 24)
      paramContext = paramContext.createDeviceProtectedStorageContext(); 
    return paramContext.getCacheDir().getPath();
  }
  
  public static String getCanonicalPath(String paramString) {
    String str;
    try {
      return newFile(paramString).getCanonicalPath();
    } catch (IOException null) {
      str = "the canonicalPath has IOException";
    } catch (SecurityException null) {
      str = "the canonicalPath has securityException";
    } catch (Exception exception) {
      str = "the canonicalPath has other Exception";
    } 
    Logger.w("CreateFileUtil", str, exception);
    return paramString;
  }
  
  public static boolean isPVersion() {
    return (checkCompatible("com.huawei.android.os.BuildEx") && BuildEx.VERSION.EMUI_SDK_INT >= 17);
  }
  
  public static File newFile(String paramString) {
    return (File)((paramString == null) ? null : (isPVersion() ? (checkCompatible("com.huawei.libcore.io.ExternalStorageFile") ? new ExternalStorageFile(paramString) : new File(paramString)) : new File(paramString)));
  }
  
  public static FileInputStream newFileInputStream(String paramString) {
    if (paramString != null)
      return (FileInputStream)(isPVersion() ? (checkCompatible("com.huawei.libcore.io.ExternalStorageFileInputStream") ? new ExternalStorageFileInputStream(paramString) : new FileInputStream(paramString)) : new FileInputStream(paramString)); 
    Logger.w("CreateFileUtil", "newFileInputStream  file is null");
    throw new FileNotFoundException("file is null");
  }
  
  public static FileOutputStream newFileOutputStream(File paramFile) {
    if (paramFile != null)
      return (FileOutputStream)(isPVersion() ? (checkCompatible("com.huawei.libcore.io.ExternalStorageFileOutputStream") ? new ExternalStorageFileOutputStream(paramFile) : new FileOutputStream(paramFile)) : new FileOutputStream(paramFile)); 
    Logger.e("CreateFileUtil", "newFileOutputStream  file is null");
    throw new FileNotFoundException("file is null");
  }
  
  public static RandomAccessFile newRandomAccessFile(String paramString1, String paramString2) {
    if (paramString1 != null)
      return (RandomAccessFile)(isPVersion() ? (checkCompatible("com.huawei.libcore.io.ExternalStorageRandomAccessFile") ? new ExternalStorageRandomAccessFile(paramString1, paramString2) : new RandomAccessFile(paramString1, paramString2)) : new RandomAccessFile(paramString1, paramString2)); 
    Logger.w("CreateFileUtil", "newFileOutputStream  file is null");
    throw new FileNotFoundException("file is null");
  }
  
  private static void tryLoadClass(String paramString) {
    ClassLoader classLoader = CreateFileUtil.class.getClassLoader();
    if (classLoader != null) {
      classLoader.loadClass(paramString);
      return;
    } 
    throw new ClassNotFoundException("not found classloader");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\common\CreateFileUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */