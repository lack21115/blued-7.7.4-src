package com.bun.miitmdid.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.zip.CRC32;

public class Utils {
  public static final String CPU_ABI_X86 = "x86";
  
  private static String CPUABI() {
    try {
      boolean bool = (new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.product.cpu.abi").getInputStream()))).readLine().contains("x86");
    } finally {
      Exception exception = null;
    } 
    return "arm";
  }
  
  public static void PrintClassMethod(Class<?> paramClass) {
    Method[] arrayOfMethod = paramClass.getMethods();
    int j = arrayOfMethod.length;
    for (int i = 0;; i++) {
      if (i >= j)
        return; 
      Method method = arrayOfMethod[i];
      System.out.println(method.getName());
    } 
  }
  
  public static void PrintObjectType(Class<?> paramClass) {
    String str = paramClass.getName();
    PrintStream printStream = System.out;
    StringBuilder stringBuilder = new StringBuilder("PrintObjectType:");
    stringBuilder.append(str);
    printStream.println(stringBuilder.toString());
  }
  
  public static void PrintObjectType(Object paramObject) {
    paramObject = paramObject.getClass().getName();
    PrintStream printStream = System.out;
    StringBuilder stringBuilder = new StringBuilder("PrintObjectType:");
    stringBuilder.append((String)paramObject);
    printStream.println(stringBuilder.toString());
  }
  
  public static long getFileCRC(String paramString) {
    try {
      File file = new File(paramString);
      if (file.exists()) {
        int j = (int)file.length();
        FileInputStream fileInputStream = new FileInputStream(paramString);
        CRC32 cRC32 = new CRC32();
        byte[] arrayOfByte = new byte[j];
        for (int i = 0;; i += k) {
          if (i >= j) {
            cRC32.update(j);
            return cRC32.getValue();
          } 
          int k = fileInputStream.read(arrayOfByte, i, j - i);
        } 
      } 
    } catch (IOException iOException) {}
    return -1L;
  }
  
  public static void getFileListame(String paramString) {
    File[] arrayOfFile = (new File(paramString)).listFiles();
    if (arrayOfFile != null)
      for (int i = 0;; i++) {
        if (i >= arrayOfFile.length)
          return; 
        Log.i("Utils", arrayOfFile[i].getName());
        if (arrayOfFile[i].isDirectory()) {
          getFileListame(arrayOfFile[i].getAbsolutePath());
          StringBuilder stringBuilder = new StringBuilder(String.valueOf(arrayOfFile[i].getAbsolutePath()));
          stringBuilder.append(arrayOfFile[i].getName());
          Log.i("Utils", stringBuilder.toString());
        } 
      }  
  }
  
  public static String getLibraryDir(Context paramContext) {
    return (paramContext.getApplicationInfo()).nativeLibraryDir;
  }
  
  public static String getUserDir(Context paramContext) {
    return paramContext.getFilesDir().getParent();
  }
  
  public static String getXdataDir(Context paramContext, String paramString) {
    StringBuffer stringBuffer = new StringBuffer();
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(getUserDir(paramContext)));
    stringBuilder.append("/");
    stringBuilder.append(JLibrary.xdata);
    stringBuilder.append("/");
    stringBuilder.append(paramString);
    stringBuffer.append(stringBuilder.toString());
    return stringBuffer.toString();
  }
  
  public static String getYdataDir(Context paramContext, String paramString) {
    StringBuffer stringBuffer = new StringBuffer();
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(getUserDir(paramContext)));
    stringBuilder.append("/");
    stringBuilder.append(JLibrary.ydata);
    stringBuilder.append("/");
    stringBuilder.append(paramString);
    stringBuffer.append(stringBuilder.toString());
    return stringBuffer.toString();
  }
  
  public static boolean isX86() {
    return (Build.CPU_ABI.equals("x86") || CPUABI().equals("x86"));
  }
  
  public static boolean update(Context paramContext) throws Exception {
    long l = ZipUtils.getZipCrc(new File((paramContext.getApplicationInfo()).sourceDir));
    boolean bool = false;
    SharedPreferences sharedPreferences = paramContext.getSharedPreferences("update", 0);
    if (l != sharedPreferences.getLong("crc", 0L))
      bool = true; 
    sharedPreferences.edit().putLong("crc", l).commit();
    return bool;
  }
  
  public static void x0xooXdata(InputStream paramInputStream, String paramString, Context paramContext) throws Exception {
    try {
      File file = new File(paramString);
      byte[] arrayOfByte = new byte[65536];
      paramInputStream = new BufferedInputStream(paramInputStream);
      BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
      while (true) {
        int i = paramInputStream.read(arrayOfByte);
        if (i <= 0) {
          bufferedOutputStream.flush();
          bufferedOutputStream.close();
          paramInputStream.close();
          return;
        } 
        bufferedOutputStream.write(arrayOfByte, 0, i);
      } 
    } catch (Exception exception) {
      throw exception;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bun\miitmdid\core\Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */