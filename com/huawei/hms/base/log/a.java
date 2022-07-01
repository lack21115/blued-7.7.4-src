package com.huawei.hms.base.log;

import android.content.Context;
import android.util.Log;

public class a {
  private static final b a = new d();
  
  private int b = 4;
  
  private String c;
  
  private c b(int paramInt, String paramString1, String paramString2, Throwable paramThrowable) {
    c c = new c(8, this.c, paramInt, paramString1);
    c.a(paramString2);
    c.a(paramThrowable);
    return c;
  }
  
  public void a(int paramInt, String paramString1, String paramString2) {
    if (a(paramInt)) {
      c c = b(paramInt, paramString1, paramString2, null);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(c.a());
      stringBuilder.append(c.b());
      String str = stringBuilder.toString();
      a.a(str, paramInt, paramString1, paramString2);
    } 
  }
  
  public void a(int paramInt, String paramString1, String paramString2, Throwable paramThrowable) {
    if (a(paramInt)) {
      c c = b(paramInt, paramString1, paramString2, paramThrowable);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(c.a());
      stringBuilder1.append(c.b());
      String str = stringBuilder1.toString();
      b b1 = a;
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(paramString2);
      stringBuilder2.append('\n');
      stringBuilder2.append(Log.getStackTraceString(paramThrowable));
      b1.a(str, paramInt, paramString1, stringBuilder2.toString());
    } 
  }
  
  public void a(Context paramContext, int paramInt, String paramString) {
    this.b = paramInt;
    this.c = paramString;
    a.a(paramContext, "HMSCore");
  }
  
  public void a(String paramString1, String paramString2) {
    c c = b(4, paramString1, paramString2, null);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(c.a());
    stringBuilder.append('\n');
    stringBuilder.append(c.b());
    String str = stringBuilder.toString();
    a.a(str, 4, paramString1, paramString2);
  }
  
  public boolean a(int paramInt) {
    return (paramInt >= this.b);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\base\log\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */