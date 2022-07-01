package com.blued.android.module.external_sense_library.utils;

import android.content.Context;
import java.io.File;

public class StickerConfig {
  private static String a;
  
  public static String a() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a);
    stringBuilder.append("sticker");
    stringBuilder.append(File.separator);
    return stringBuilder.toString();
  }
  
  public static String a(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a);
    stringBuilder.append("sticker");
    stringBuilder.append(File.separator);
    stringBuilder.append(paramString);
    stringBuilder.append(".zip");
    return stringBuilder.toString();
  }
  
  public static void a(Context paramContext) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramContext.getExternalFilesDir((String)null));
    stringBuilder.append(File.separator);
    a = stringBuilder.toString();
  }
  
  public static String b() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a);
    stringBuilder.append("temp");
    stringBuilder.append(File.separator);
    return stringBuilder.toString();
  }
  
  public static String b(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a);
    stringBuilder.append("temp");
    stringBuilder.append(File.separator);
    stringBuilder.append(paramString);
    stringBuilder.append(".zip");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_librar\\utils\StickerConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */