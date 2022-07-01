package com.blued.android.module.common.utils;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;

public class AvatarUtils {
  public static String a(int paramInt, String paramString) {
    if (TextUtils.isEmpty(paramString))
      return paramString; 
    if (paramInt != 0) {
      if (paramInt != 2) {
        if (paramInt != 3) {
          StringBuilder stringBuilder3 = new StringBuilder();
          stringBuilder3.append(paramString);
          stringBuilder3.append("!100x100.png");
          return stringBuilder3.toString();
        } 
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(paramString);
        stringBuilder2.append("!480x480.png");
        return stringBuilder2.toString();
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramString);
      stringBuilder1.append("!300x300.png");
      return stringBuilder1.toString();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("!200x200.png");
    return stringBuilder.toString();
  }
  
  public static String a(String paramString) {
    return a(paramString, AppInfo.l);
  }
  
  public static String a(String paramString, int paramInt) {
    return a(paramString, paramInt, false);
  }
  
  public static String a(String paramString, int paramInt, boolean paramBoolean) {
    String str;
    if (TextUtils.isEmpty(paramString))
      return paramString; 
    int i = paramInt;
    if (paramInt == 0)
      i = AppInfo.l; 
    if (paramBoolean) {
      if (i > 480) {
        str = "!640x640.png";
      } else {
        str = "!480x480.png";
      } 
      if (i > 640)
        str = "!720x720.png"; 
      if (i > 720)
        str = "!1080x1080.png"; 
      if (i > 1080) {
        str = "!original.png";
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramString);
        stringBuilder1.append(str);
        return stringBuilder1.toString();
      } 
    } else {
      if (i > 480) {
        str = "!640x960.png";
      } else {
        str = "!480x720.png";
      } 
      if (i > 640)
        str = "!720x1080.png"; 
      if (i > 720)
        str = "!1080x1620.png"; 
      if (i > 1080) {
        str = "!original.png";
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramString);
        stringBuilder1.append(str);
        return stringBuilder1.toString();
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(str);
    return stringBuilder.toString();
  }
  
  public static String b(String paramString) {
    String str;
    if (TextUtils.isEmpty(paramString))
      return paramString; 
    int i = AppInfo.l;
    if (i > 480) {
      str = "!640x640.png";
    } else {
      str = "!480x480.png";
    } 
    if (i > 640)
      str = "!720x720.png"; 
    if (i > 720)
      str = "!1080x1080.png"; 
    if (i > 1080)
      str = "!original.png"; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(str);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\commo\\utils\AvatarUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */