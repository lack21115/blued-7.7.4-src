package a.a.a.a.a.e;

import android.util.Log;

public class e {
  public static String a = "PLDroidMediaStreaming";
  
  public static int b = 4;
  
  public static final e c = new e("");
  
  public static final e d = new e("Pili-Interface");
  
  public static final e e = new e("Pili-System");
  
  public static final e f = new e("Pili-Streaming");
  
  public static final e g = new e("Pili-Capture");
  
  public static final e h = new e("Pili-Processing");
  
  public static final e i = new e("Pili-Encode");
  
  public static final e j = new e("Pili-Decode");
  
  public static final e k = new e("Pili-Network");
  
  public static boolean l = false;
  
  public final String m;
  
  public e(String paramString) {
    this.m = paramString;
  }
  
  public static void a(int paramInt) {
    b = paramInt;
    if (paramInt == 2)
      a(true); 
  }
  
  public static void a(boolean paramBoolean) {
    l = paramBoolean;
  }
  
  public static boolean a() {
    return l;
  }
  
  public void a(String paramString) {
    c(null, paramString);
  }
  
  public void a(String paramString1, String paramString2) {
    if (b > 2)
      return; 
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(c(paramString1));
    stringBuilder.append(paramString2);
    Log.v(str, stringBuilder.toString());
  }
  
  public void b(String paramString) {
    d(null, paramString);
  }
  
  public void b(String paramString1, String paramString2) {
    if (b > 3)
      return; 
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(c(paramString1));
    stringBuilder.append(paramString2);
    Log.d(str, stringBuilder.toString());
  }
  
  public final String c(String paramString) {
    String str1 = this.m;
    if (str1 != null && !"".equals(str1)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("");
      stringBuilder.append(this.m);
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
  
  public void c(String paramString1, String paramString2) {
    if (b > 4)
      return; 
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(c(paramString1));
    stringBuilder.append(paramString2);
    Log.i(str, stringBuilder.toString());
  }
  
  public void d(String paramString1, String paramString2) {
    if (b > 5)
      return; 
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(c(paramString1));
    stringBuilder.append(paramString2);
    Log.w(str, stringBuilder.toString());
  }
  
  public void e(String paramString1, String paramString2) {
    if (b > 6)
      return; 
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(c(paramString1));
    stringBuilder.append(paramString2);
    Log.e(str, stringBuilder.toString());
  }
  
  static {
    new e("Pili-OpenGL");
    new e("Pili-Stat");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\e\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */