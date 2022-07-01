package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import com.ss.android.socialbase.downloader.downloader.b;

public class k {
  public static int a(Context paramContext, String paramString) {
    try {
      return paramContext.getResources().getIdentifier(paramString, "string", paramContext.getPackageName());
    } catch (Exception exception) {
      exception.printStackTrace();
      return 0;
    } 
  }
  
  public static int a(String paramString) {
    try {
      return b.B().getResources().getIdentifier(paramString, "layout", b.B().getPackageName());
    } catch (Exception exception) {
      exception.printStackTrace();
      return 0;
    } 
  }
  
  public static int a(String paramString1, String paramString2) {
    try {
      return b.B().getResources().getIdentifier(paramString1, "drawable", paramString2);
    } catch (Exception exception) {
      exception.printStackTrace();
      return 0;
    } 
  }
  
  public static int b(String paramString) {
    return a(b.B(), paramString);
  }
  
  public static int b(String paramString1, String paramString2) {
    try {
      return b.B().getResources().getIdentifier(paramString1, "attr", paramString2);
    } catch (Exception exception) {
      exception.printStackTrace();
      return 0;
    } 
  }
  
  public static int c(String paramString) {
    try {
      return b.B().getResources().getIdentifier(paramString, "style", b.B().getPackageName());
    } catch (Exception exception) {
      exception.printStackTrace();
      return 0;
    } 
  }
  
  public static int d(String paramString) {
    try {
      return b.B().getResources().getIdentifier(paramString, "id", b.B().getPackageName());
    } catch (Exception exception) {
      exception.printStackTrace();
      return 0;
    } 
  }
  
  public static int e(String paramString) {
    try {
      return b.B().getResources().getIdentifier(paramString, "color", b.B().getPackageName());
    } catch (Exception exception) {
      exception.printStackTrace();
      return 0;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\appdownloader\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */