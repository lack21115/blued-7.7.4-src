package com.huawei.hms.base.log;

import android.os.Process;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class c {
  private final StringBuilder a = new StringBuilder();
  
  private String b = null;
  
  private String c = "HMS";
  
  private int d = 0;
  
  private long e = 0L;
  
  private long f = 0L;
  
  private String g;
  
  private int h;
  
  private int i;
  
  private int j = 0;
  
  c(int paramInt1, String paramString1, int paramInt2, String paramString2) {
    this.j = paramInt1;
    this.b = paramString1;
    this.d = paramInt2;
    if (paramString2 != null)
      this.c = paramString2; 
    c();
  }
  
  public static String a(int paramInt) {
    return (paramInt != 3) ? ((paramInt != 4) ? ((paramInt != 5) ? ((paramInt != 6) ? String.valueOf(paramInt) : "E") : "W") : "I") : "D";
  }
  
  private StringBuilder a(StringBuilder paramStringBuilder) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
    paramStringBuilder.append('[');
    paramStringBuilder.append(simpleDateFormat.format(Long.valueOf(this.e)));
    String str = a(this.d);
    paramStringBuilder.append(' ');
    paramStringBuilder.append(str);
    paramStringBuilder.append('/');
    paramStringBuilder.append(this.c);
    paramStringBuilder.append('/');
    paramStringBuilder.append(this.b);
    paramStringBuilder.append(' ');
    paramStringBuilder.append(this.h);
    paramStringBuilder.append(':');
    paramStringBuilder.append(this.f);
    paramStringBuilder.append(' ');
    paramStringBuilder.append(this.g);
    paramStringBuilder.append(':');
    paramStringBuilder.append(this.i);
    paramStringBuilder.append(']');
    return paramStringBuilder;
  }
  
  private StringBuilder b(StringBuilder paramStringBuilder) {
    paramStringBuilder.append(' ');
    paramStringBuilder.append(this.a.toString());
    return paramStringBuilder;
  }
  
  private c c() {
    this.e = System.currentTimeMillis();
    Thread thread = Thread.currentThread();
    this.f = thread.getId();
    this.h = Process.myPid();
    StackTraceElement[] arrayOfStackTraceElement = thread.getStackTrace();
    int i = arrayOfStackTraceElement.length;
    int j = this.j;
    if (i > j) {
      StackTraceElement stackTraceElement = arrayOfStackTraceElement[j];
      this.g = stackTraceElement.getFileName();
      this.i = stackTraceElement.getLineNumber();
    } 
    return this;
  }
  
  public <T> c a(T paramT) {
    this.a.append(paramT);
    return this;
  }
  
  public c a(Throwable paramThrowable) {
    a(Character.valueOf('\n')).a(Log.getStackTraceString(paramThrowable));
    return this;
  }
  
  public String a() {
    StringBuilder stringBuilder = new StringBuilder();
    a(stringBuilder);
    return stringBuilder.toString();
  }
  
  public String b() {
    StringBuilder stringBuilder = new StringBuilder();
    b(stringBuilder);
    return stringBuilder.toString();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    a(stringBuilder);
    b(stringBuilder);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\base\log\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */