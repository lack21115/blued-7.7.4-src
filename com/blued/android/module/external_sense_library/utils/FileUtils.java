package com.blued.android.module.external_sense_library.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.blued.android.module.external_sense_library.config.BluedFilterType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class FileUtils {
  public static File a(int paramInt) {
    File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "Camera");
    if (!file.exists() && !file.mkdirs()) {
      LogUtils.d("FileUtil", "failed to create directory", new Object[0]);
      return null;
    } 
    String str = (new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.CHINESE)).format(new Date());
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(file.getPath());
    stringBuilder.append(File.separator);
    stringBuilder.append(paramInt);
    stringBuilder.append("_IMG_");
    stringBuilder.append(str);
    stringBuilder.append(".jpg");
    return new File(stringBuilder.toString());
  }
  
  public static String a() {
    return "M_SenseME_Face_Video_5.3.3.model";
  }
  
  public static String a(Context paramContext, String paramString) {
    String str;
    Context context = paramContext.getApplicationContext();
    paramContext = null;
    File file = context.getExternalFilesDir(null);
    if (file != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(file.getAbsolutePath());
      stringBuilder.append(File.separator);
      stringBuilder.append(paramString);
      str = stringBuilder.toString();
    } 
    return str;
  }
  
  public static String a(File paramFile1, File paramFile2) {
    if (paramFile1 != null && paramFile1.exists()) {
      File file;
      if (paramFile2 == null)
        return ""; 
      if (!paramFile2.exists())
        paramFile2.mkdir(); 
      if (paramFile1.isDirectory()) {
        File[] arrayOfFile = paramFile1.listFiles();
        if (arrayOfFile.length > 0) {
          file = arrayOfFile[0];
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(paramFile2.getAbsolutePath());
          stringBuilder1.append(File.separator);
          stringBuilder1.append(file.getName());
          paramFile2 = new File(stringBuilder1.toString());
          return file.isDirectory() ? a(file, paramFile2) : b(file, paramFile2);
        } 
        return "";
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramFile2.getAbsolutePath());
      stringBuilder.append(File.separator);
      stringBuilder.append(file.getName());
      return b(file, new File(stringBuilder.toString()));
    } 
    return "";
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString2);
    stringBuilder.append(File.separator);
    stringBuilder.append(paramString1);
    String str = a(paramContext, stringBuilder.toString());
    if (str != null) {
      File file = new File(str);
      if (!file.exists())
        try {
          if (file.exists())
            file.delete(); 
          file.createNewFile();
          AssetManager assetManager = paramContext.getAssets();
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(paramString2);
          stringBuilder1.append(File.separator);
          stringBuilder1.append(paramString1);
          InputStream inputStream = assetManager.open(stringBuilder1.toString());
          if (inputStream == null) {
            LogUtils.d("copyMode", "the src is not existed", new Object[0]);
            return false;
          } 
          FileOutputStream fileOutputStream = new FileOutputStream(file);
          byte[] arrayOfByte = new byte[4096];
          while (true) {
            int i = inputStream.read(arrayOfByte);
            if (i > 0) {
              fileOutputStream.write(arrayOfByte, 0, i);
              continue;
            } 
            inputStream.close();
            fileOutputStream.close();
            break;
          } 
          return true;
        } catch (IOException iOException) {
          file.delete();
          return false;
        }  
    } 
    return true;
  }
  
  private static String b(File paramFile1, File paramFile2) {
    if (paramFile1 != null)
      try {
        if (paramFile1.exists() && paramFile2 != null) {
          if (!paramFile2.exists())
            paramFile2.createNewFile(); 
          FileInputStream fileInputStream = new FileInputStream(paramFile1);
          FileOutputStream fileOutputStream = new FileOutputStream(paramFile2);
          byte[] arrayOfByte = new byte[1026];
          while (true) {
            int i = fileInputStream.read(arrayOfByte, 0, arrayOfByte.length);
            if (i != -1) {
              fileOutputStream.write(arrayOfByte, 0, i);
              continue;
            } 
            fileOutputStream.flush();
            fileOutputStream.close();
            fileInputStream.close();
            break;
          } 
        } 
        return paramFile2.getAbsolutePath();
      } catch (Exception exception) {
        return "";
      }  
    return paramFile2.getAbsolutePath();
  }
  
  public static Map<BluedFilterType.FILER, String> b(Context paramContext, String paramString) {
    String str;
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (paramContext == null)
      return (Map)hashMap; 
    boolean bool = false;
    StringBuilder stringBuilder = null;
    try {
      if (Build.VERSION.SDK_INT == 22 && Build.MANUFACTURER.toLowerCase().contains("oppo")) {
        String[] arrayOfString = new String[1];
        arrayOfString[0] = paramString;
      } else {
        String[] arrayOfString = paramContext.getAssets().list(paramString);
      } 
    } catch (IOException iOException) {
      iOException.printStackTrace();
      iOException = null;
    } 
    File file = paramContext.getExternalFilesDir(null);
    if (file != null) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(file.getAbsolutePath());
      stringBuilder.append(File.separator);
      stringBuilder.append(paramString);
      String str1 = stringBuilder.toString();
      File file1 = new File(str1);
      str = str1;
      if (!file1.exists()) {
        file1.mkdir();
        str = str1;
      } 
    } 
    int i;
    for (i = 0; i < iOException.length; i++) {
      IOException iOException1 = iOException[i];
      if (iOException1.indexOf(".model") != -1)
        a(paramContext, (String)iOException1, paramString); 
    } 
    if (TextUtils.isEmpty(str))
      return (Map)hashMap; 
    File[] arrayOfFile = (new File(str)).listFiles();
    if (arrayOfFile != null) {
      i = bool;
      if (arrayOfFile.length == 0)
        return (Map)hashMap; 
      while (i < arrayOfFile.length) {
        if (!arrayOfFile[i].isDirectory()) {
          String str1 = arrayOfFile[i].getName();
          paramString = arrayOfFile[i].getAbsolutePath();
          arrayOfFile[i].getPath();
          if (str1.trim().toLowerCase().endsWith(".model") && str1.indexOf("filter") != -1) {
            BluedFilterType.FILER fILER = FilterUitls.a(str1);
            if (fILER != null)
              hashMap.put(fILER, paramString); 
          } 
        } 
        i++;
      } 
    } 
    return (Map)hashMap;
  }
  
  public static List<String> c(Context paramContext, String paramString) {
    ArrayList<String> arrayList = new ArrayList();
    try {
      String[] arrayOfString;
      int j = Build.VERSION.SDK_INT;
      int i = 0;
      if (j == 22 && Build.MANUFACTURER.toLowerCase().contains("oppo")) {
        arrayOfString = new String[1];
        arrayOfString[0] = paramString;
      } else {
        arrayOfString = arrayOfString.getAssets().list(paramString);
      } 
      while (i < arrayOfString.length) {
        paramString = arrayOfString[i];
        if (paramString.indexOf(".model") != -1)
          arrayList.add(paramString); 
        i++;
      } 
    } catch (IOException iOException) {
      iOException.printStackTrace();
    } 
    return arrayList;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_librar\\utils\FileUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */