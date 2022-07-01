package com.baidu.idl.license;

import android.content.Context;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

class LicenseReaderUtils {
  public static final String TAG = "License-SDK";
  
  public static InputStream get_local_license_file_inputstream(Context paramContext, String paramString) {
    if (paramContext == null)
      return null; 
    FileInputStream fileInputStream = read_license_from_data(paramContext, paramString);
    Log.e("License-SDK", "read_license_from_data");
    InputStream inputStream = fileInputStream;
    if (fileInputStream == null) {
      Log.e("License-SDK", "read_license_from_asset");
      inputStream = read_license_from_asset(paramContext, paramString);
    } 
    return inputStream;
  }
  
  private static ArrayList<String> read_license_content(InputStream paramInputStream) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
    ArrayList<String> arrayList = new ArrayList();
    while (true) {
      String str = bufferedReader.readLine();
      if (str != null) {
        arrayList.add(str);
        continue;
      } 
      return arrayList;
    } 
  }
  
  private static InputStream read_license_from_asset(Context paramContext, String paramString) {
    if (paramContext == null) {
      Log.e("License-SDK", "read_license_from_asset context is null");
      return null;
    } 
    try {
      return paramContext.getAssets().open(paramString);
    } catch (IOException iOException) {
      Log.e("License-SDK", "read_license_from_asset IOException");
      iOException.printStackTrace();
      return null;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("read_license_from_asset Exception ");
      stringBuilder.append(exception.getMessage());
      Log.e("License-SDK", stringBuilder.toString());
      exception.printStackTrace();
      return null;
    } 
  }
  
  private static FileInputStream read_license_from_data(Context paramContext, String paramString) {
    if (paramContext == null)
      return null; 
    try {
      File file = paramContext.getDir(paramString, 0);
      if (file == null || !file.exists() || !file.isFile()) {
        Log.e("License-SDK", "read_license_from_data file not found");
        return null;
      } 
      if (file.length() == 0L) {
        Log.e("License-SDK", "read_license_from_data file is empty");
        return null;
      } 
      return new FileInputStream(file);
    } catch (FileNotFoundException fileNotFoundException) {
      Log.e("License-SDK", "read_license_from_data FileNotFoundException");
      fileNotFoundException.printStackTrace();
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("read_license_from_data Exception ");
      stringBuilder.append(exception.getMessage());
      Log.e("License-SDK", stringBuilder.toString());
      exception.printStackTrace();
    } 
    return null;
  }
  
  public static boolean write_license_content(Context paramContext, String paramString, ArrayList<String> paramArrayList) {
    Log.e("License-SDK", "write_license_content");
    if (paramArrayList != null && paramArrayList.size() != 0) {
      if (paramContext == null)
        return false; 
      File file2 = paramContext.getDir(paramString, 0);
      if (file2 != null && file2.exists())
        file2.delete(); 
      if (file2 != null && !file2.exists())
        try {
          file2.createNewFile();
        } catch (IOException iOException1) {
          Log.e("License-SDK", "write_license_content IOException");
          iOException1.printStackTrace();
        }  
      File file3 = null;
      File file4 = null;
      paramContext = null;
      try {
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        try {
          Iterator<String> iterator = paramArrayList.iterator();
        } catch (FileNotFoundException null) {
        
        } catch (IOException null) {
        
        } finally {
          ArrayList<String> arrayList;
          paramArrayList = null;
          FileOutputStream fileOutputStream1 = fileOutputStream;
        } 
      } catch (FileNotFoundException null) {
        file2 = file4;
      } catch (IOException iOException) {
        file2 = file3;
        File file = file2;
        Log.e("License-SDK", "write_license_content IOException");
        file = file2;
        iOException.printStackTrace();
        if (file2 != null) {
          file2.close();
          return false;
        } 
      } finally {}
      File file1 = file2;
      Log.e("License-SDK", "write_license_content FileNotFoundException");
      file1 = file2;
      iOException.printStackTrace();
      if (file2 != null) {
        file2.close();
        return false;
      } 
      return false;
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\idl\license\LicenseReaderUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */