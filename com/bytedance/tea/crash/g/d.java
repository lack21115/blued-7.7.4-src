package com.bytedance.tea.crash.g;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.tea.crash.c.c;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONException;
import org.json.JSONObject;

public class d {
  public static String a(File paramFile, String paramString1, String paramString2, JSONObject paramJSONObject, String paramString3, boolean paramBoolean) {
    if (!paramFile.exists())
      paramFile.mkdirs(); 
    File file = new File(paramFile, paramString1);
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("url", paramString2);
      jSONObject.put("body", paramJSONObject);
      String str = paramString3;
      if (paramString3 == null)
        str = ""; 
      jSONObject.put("dump_file", str);
      jSONObject.put("encrypt", paramBoolean);
      a(file, jSONObject.toString(), false);
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } catch (IOException iOException) {
      iOException.printStackTrace();
    } 
    return file.getAbsolutePath();
  }
  
  public static String a(File paramFile, String paramString1, String paramString2, JSONObject paramJSONObject, boolean paramBoolean) {
    return a(paramFile, paramString1, paramString2, paramJSONObject, null, paramBoolean);
  }
  
  public static String a(String paramString1, String paramString2) throws IOException {
    String str1;
    boolean bool = TextUtils.isEmpty(paramString1);
    String str2 = null;
    if (bool)
      return null; 
    File file = new File(paramString1);
    StringBuilder stringBuilder = new StringBuilder();
    try {
      BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
    } finally {
      paramString2 = null;
    } 
    f.a((Closeable)str1);
    throw paramString2;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(System.currentTimeMillis());
      stringBuilder.append(" ");
      String str = paramString1;
      if (paramString1 == null)
        str = "null"; 
      stringBuilder.append(str);
      stringBuilder.append(" ");
      paramString1 = paramString2;
      if (paramString2 == null)
        paramString1 = "null"; 
      stringBuilder.append(paramString1);
      stringBuilder.append("\n");
      paramString1 = stringBuilder.toString();
      a(h.b(paramContext), paramString1, true);
      return;
    } catch (IOException iOException) {
      iOException.printStackTrace();
      return;
    } 
  }
  
  public static void a(File paramFile, String paramString, boolean paramBoolean) throws IOException {
    if (TextUtils.isEmpty(paramString))
      return; 
    paramFile.getParentFile().mkdirs();
    try {
      FileOutputStream fileOutputStream = new FileOutputStream(paramFile, paramBoolean);
    } finally {
      paramString = null;
    } 
    f.a((Closeable)paramFile);
    throw paramString;
  }
  
  public static boolean a(File paramFile) {
    return (paramFile.exists() && paramFile.delete());
  }
  
  public static boolean a(File paramFile, boolean paramBoolean) {
    if (!paramBoolean || paramFile.isFile())
      return a(paramFile); 
    boolean bool = paramFile.isDirectory();
    paramBoolean = true;
    if (bool) {
      File[] arrayOfFile = paramFile.listFiles();
      int i = 0;
      boolean bool1 = true;
      while (arrayOfFile != null && i < arrayOfFile.length) {
        if (arrayOfFile[i].isFile()) {
          paramBoolean = a(arrayOfFile[i]);
        } else {
          paramBoolean = a(arrayOfFile[i], true);
        } 
        bool1 &= paramBoolean;
        i++;
      } 
      paramBoolean = bool1 & a(paramFile);
    } 
    return paramBoolean;
  }
  
  public static boolean a(String paramString) {
    boolean bool = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool)
      return false; 
    File file = new File(paramString);
    bool = bool1;
    if (file.exists()) {
      bool = bool1;
      if (file.delete())
        bool = true; 
    } 
    return bool;
  }
  
  public static String b(String paramString) throws IOException {
    return a(paramString, (String)null);
  }
  
  public static c c(String paramString) {
    try {
      JSONObject jSONObject = new JSONObject(b(paramString));
      c c = new c();
      c.a(jSONObject.optString("url"));
      c.a(jSONObject.optJSONObject("body"));
      c.b(jSONObject.optString("dump_file"));
      return c;
    } finally {
      paramString = null;
    } 
  }
  
  public static String[] d(String paramString) {
    Exception exception2;
    try {
      BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(paramString)), 1000);
      BufferedReader bufferedReader1 = bufferedReader2;
    } catch (Exception exception3) {
    
    } finally {
      exception2 = null;
    } 
    Exception exception1 = exception2;
    exception3.printStackTrace();
    f.a((Closeable)exception2);
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\g\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */