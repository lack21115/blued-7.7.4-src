package com.ss.android.socialbase.appdownloader.b;

import android.os.Build;
import android.text.TextUtils;

public class a {
  public static final String a;
  
  static {
    StringBuilder stringBuilder = new StringBuilder();
    boolean bool1 = TextUtils.isEmpty(Build.VERSION.RELEASE);
    boolean bool = true;
    int i = bool1 ^ true;
    int j = TextUtils.isEmpty(Build.ID) ^ true;
    if (!"REL".equals(Build.VERSION.CODENAME) || TextUtils.isEmpty(Build.MODEL))
      bool = false; 
    stringBuilder.append("AppDownloader");
    if (i != 0) {
      stringBuilder.append("/");
      stringBuilder.append(Build.VERSION.RELEASE);
    } 
    stringBuilder.append(" (Linux; U; Android");
    if (i != 0) {
      stringBuilder.append(" ");
      stringBuilder.append(Build.VERSION.RELEASE);
    } 
    if (bool || j != 0) {
      stringBuilder.append(";");
      if (bool) {
        stringBuilder.append(" ");
        stringBuilder.append(Build.MODEL);
      } 
      if (j != 0) {
        stringBuilder.append(" Build/");
        stringBuilder.append(Build.ID);
      } 
    } 
    stringBuilder.append(")");
    a = stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\appdownloader\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */