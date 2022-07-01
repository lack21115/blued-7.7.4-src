package com.blued.android.core.utils;

import android.content.Context;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class Log {
  private static File a;
  
  private static BufferedWriter b;
  
  private static boolean c;
  
  private static Context d;
  
  private static final String[] e = new String[] { "", "", "V", "D", "I", "W", "E", "A" };
  
  private static int a(int paramInt, String paramString1, String paramString2) {
    if (c) {
      a();
      StringBuilder stringBuilder = new StringBuilder((new SimpleDateFormat("HH:mm:ss.SSS")).format(new Date()));
      stringBuilder.append("\t");
      stringBuilder.append(Thread.currentThread().getId());
      stringBuilder.append("\t");
      stringBuilder.append(a(paramInt));
      stringBuilder.append("\t");
      stringBuilder.append(paramString1);
      stringBuilder.append("\t");
      stringBuilder.append(paramString2);
      try {
        if (b != null) {
          b.write(stringBuilder.toString(), 0, stringBuilder.length());
          b.newLine();
          b.flush();
        } 
      } catch (IOException iOException) {
        iOException.printStackTrace();
      } 
    } 
    return android.util.Log.println(paramInt, paramString1, paramString2);
  }
  
  public static int a(String paramString1, String paramString2) {
    return a(2, paramString1, paramString2);
  }
  
  public static int a(String paramString1, String paramString2, Throwable paramThrowable) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString2);
    stringBuilder.append('\n');
    stringBuilder.append(a(paramThrowable));
    return a(6, paramString1, stringBuilder.toString());
  }
  
  private static String a(int paramInt) {
    return e[paramInt];
  }
  
  public static String a(Throwable paramThrowable) {
    if (paramThrowable == null)
      return ""; 
    for (Throwable throwable = paramThrowable; throwable != null; throwable = throwable.getCause()) {
      if (throwable instanceof java.net.UnknownHostException)
        return ""; 
    } 
    StringWriter stringWriter = new StringWriter();
    PrintWriter printWriter = new PrintWriter(stringWriter);
    paramThrowable.printStackTrace(printWriter);
    printWriter.flush();
    return stringWriter.toString();
  }
  
  private static void a() {
    if (a != null)
      return; 
    throw new IllegalStateException("File path not initialized. Have you called Log.init() method?");
  }
  
  public static void a(Context paramContext, boolean paramBoolean, File paramFile) throws IOException {
    d = paramContext;
    c = paramBoolean;
    if (c) {
      a = paramFile;
      b = new BufferedWriter(new FileWriter(a, true));
    } 
  }
  
  public static int b(String paramString1, String paramString2) {
    return a(3, paramString1, paramString2);
  }
  
  public static int c(String paramString1, String paramString2) {
    return a(4, paramString1, paramString2);
  }
  
  public static int d(String paramString1, String paramString2) {
    return a(5, paramString1, paramString2);
  }
  
  public static int e(String paramString1, String paramString2) {
    return a(6, paramString1, paramString2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\cor\\utils\Log.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */