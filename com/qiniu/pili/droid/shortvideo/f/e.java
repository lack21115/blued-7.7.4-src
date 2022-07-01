package com.qiniu.pili.droid.shortvideo.f;

import android.util.Log;

public class e {
  public static final e a = new e("");
  
  public static final e b = new e("Pili-System");
  
  public static final e c = new e("Pili-SCREEN");
  
  public static final e d = new e("Pili-Record");
  
  public static final e e = new e("Pili-Editor");
  
  public static final e f = new e("Pili-Capture");
  
  public static final e g = new e("Pili-Processing");
  
  public static final e h = new e("Pili-Encode");
  
  public static final e i = new e("Pili-Decode");
  
  public static final e j = new e("Pili-OpenGL");
  
  public static final e k = new e("Pili-Player");
  
  public static final e l = new e("Pili-Stat");
  
  public static final e m = new e("Pili-Network");
  
  public static final e n = new e("Pili-Muxer");
  
  public static final e o = new e("Pili-Upload");
  
  public static final e p = new e("Pili-Trim");
  
  public static final e q = new e("Pili-AudioMix");
  
  public static final e r = new e("Pili-Resampler");
  
  public static final e s = new e("Pili-Transcode");
  
  public static final e t = new e("Pili-Composer");
  
  public static final e u = new e("Pili-Parser");
  
  public static final e v = new e("Pili-Transition");
  
  public static final e w = new e("Pili-Utils");
  
  public static final e x = new e("Pili-VideoMix");
  
  private static String y = "PLDroidShortVideo";
  
  private static int z = 4;
  
  private final String A;
  
  private e(String paramString) {
    this.A = paramString;
  }
  
  public static void a(int paramInt) {
    z = paramInt;
  }
  
  private String e(String paramString) {
    String str1 = this.A;
    if (str1 != null && !"".equals(str1)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("");
      stringBuilder.append(this.A);
      stringBuilder.append(":");
      String str = stringBuilder.toString();
    } else {
      str1 = "";
    } 
    String str2 = str1;
    if (paramString != null) {
      str2 = str1;
      if (!"".equals(paramString)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str1);
        stringBuilder.append(paramString);
        stringBuilder.append(":");
        str2 = stringBuilder.toString();
      } 
    } 
    return str2;
  }
  
  public void a(String paramString) {
    a(null, paramString);
  }
  
  public void a(String paramString1, String paramString2) {
    if (z > 2)
      return; 
    String str = y;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(e(paramString1));
    stringBuilder.append(paramString2);
    Log.v(str, stringBuilder.toString());
  }
  
  public void b(String paramString) {
    c(null, paramString);
  }
  
  public void b(String paramString1, String paramString2) {
    if (z > 3)
      return; 
    String str = y;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(e(paramString1));
    stringBuilder.append(paramString2);
    Log.d(str, stringBuilder.toString());
  }
  
  public void c(String paramString) {
    d(null, paramString);
  }
  
  public void c(String paramString1, String paramString2) {
    if (z > 4)
      return; 
    String str = y;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(e(paramString1));
    stringBuilder.append(paramString2);
    Log.i(str, stringBuilder.toString());
  }
  
  public void d(String paramString) {
    e(null, paramString);
  }
  
  public void d(String paramString1, String paramString2) {
    if (z > 5)
      return; 
    String str = y;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(e(paramString1));
    stringBuilder.append(paramString2);
    Log.w(str, stringBuilder.toString());
  }
  
  public void e(String paramString1, String paramString2) {
    if (z > 6)
      return; 
    String str = y;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(e(paramString1));
    stringBuilder.append(paramString2);
    Log.e(str, stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\f\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */