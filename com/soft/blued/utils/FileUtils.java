package com.soft.blued.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.ClipboardManager;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.core.utils.Md5;
import com.blued.android.framework.utils.RegExpUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileUtils {
  public static Uri a(File paramFile) {
    return (Build.VERSION.SDK_INT < 24) ? Uri.fromFile(paramFile) : FileProvider.getUriForFile(AppInfo.d(), "com.soft.blued.fileprovider", paramFile);
  }
  
  public static String a(String paramString1, String paramString2) {
    paramString1 = d(paramString1);
    return TextUtils.isEmpty(paramString1) ? paramString2 : (AppMethods.a(paramString2, paramString1) ? paramString1 : paramString2);
  }
  
  public static void a(Context paramContext, String paramString) {
    if (StringUtils.e(paramString))
      return; 
    paramString = RegExpUtils.a(paramString);
    if (Build.VERSION.SDK_INT >= 11 && Build.VERSION.SDK_INT != 18) {
      ((ClipboardManager)paramContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("simple text", paramString));
      return;
    } 
    ((ClipboardManager)paramContext.getSystemService("clipboard")).setText(paramString);
  }
  
  public static void a(String paramString, FileHttpResponseHandler paramFileHttpResponseHandler) {
    FileDownloader.a(paramString, d(paramString), paramFileHttpResponseHandler, null);
  }
  
  public static byte[] a(String paramString) {
    try {
      FileInputStream fileInputStream = new FileInputStream(new File(paramString));
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
      byte[] arrayOfByte = new byte[1024];
      while (true) {
        int i = fileInputStream.read(arrayOfByte);
        if (i != -1) {
          byteArrayOutputStream.write(arrayOfByte, 0, i);
          continue;
        } 
        fileInputStream.close();
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
      } 
    } catch (FileNotFoundException fileNotFoundException) {
      fileNotFoundException.printStackTrace();
    } catch (IOException iOException) {
      iOException.printStackTrace();
    } 
    return null;
  }
  
  public static Uri b(String paramString) {
    return TextUtils.isEmpty(paramString) ? null : a(new File(paramString));
  }
  
  public static void b(File paramFile) {
    if (paramFile != null) {
      if (!paramFile.exists())
        return; 
      Intent intent = new Intent();
      intent.addFlags(268435456);
      intent.addFlags(1);
      intent.addFlags(2);
      intent.setAction("android.intent.action.VIEW");
      intent.setDataAndType(a(paramFile), "application/vnd.android.package-archive");
      AppInfo.d().startActivity(intent);
    } 
  }
  
  public static File c(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    if (paramString.startsWith("http"))
      paramString = d(paramString); 
    if (TextUtils.isEmpty(paramString))
      return null; 
    File file = new File(paramString);
    return file.exists() ? file : null;
  }
  
  private static String d(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    String str = AppMethods.b("video");
    paramString = Md5.a(paramString.toLowerCase());
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append(File.separator);
    stringBuilder.append(paramString);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\FileUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */