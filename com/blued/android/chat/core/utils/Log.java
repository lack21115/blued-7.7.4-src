package com.blued.android.chat.core.utils;

import android.content.Context;
import com.blued.android.chat.listener.ILogCallback;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class Log {
  public static final int ASSERT = 7;
  
  public static final int DEBUG = 3;
  
  public static final int ERROR = 6;
  
  public static final int INFO = 4;
  
  private static final String LOG_TIME_STAMP_FORMAT = "HH:mm:ss.SSS";
  
  private static final String[] PRIORITY_DISPLAY_STRINGS = new String[] { "", "", "V", "D", "I", "W", "E", "A" };
  
  public static final int VERBOSE = 2;
  
  public static final int WARN = 5;
  
  private static BufferedWriter sBufferedFileWriter;
  
  private static Context sContext;
  
  private static ILogCallback sExternalLogger;
  
  private static File sLogFile;
  
  private static boolean sLogToFile;
  
  public static int d(String paramString1, String paramString2) {
    return printlnInternal(3, paramString1, paramString2);
  }
  
  public static int d(String paramString1, String paramString2, Throwable paramThrowable) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString2);
    stringBuilder.append('\n');
    stringBuilder.append(getStackTraceString(paramThrowable));
    return printlnInternal(3, paramString1, stringBuilder.toString());
  }
  
  public static int e(String paramString1, String paramString2) {
    return printlnInternal(6, paramString1, paramString2);
  }
  
  public static int e(String paramString1, String paramString2, Throwable paramThrowable) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString2);
    stringBuilder.append('\n');
    stringBuilder.append(getStackTraceString(paramThrowable));
    return printlnInternal(6, paramString1, stringBuilder.toString());
  }
  
  private static void ensurePathInitialized() {
    if (sLogFile != null)
      return; 
    throw new IllegalStateException("File path not initialized. Have you called Log.init() method?");
  }
  
  private static String getDisplayForPriority(int paramInt) {
    return PRIORITY_DISPLAY_STRINGS[paramInt];
  }
  
  public static String getStackTraceString(Throwable paramThrowable) {
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
  
  public static int i(String paramString1, String paramString2) {
    return printlnInternal(4, paramString1, paramString2);
  }
  
  public static int i(String paramString1, String paramString2, Throwable paramThrowable) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString2);
    stringBuilder.append('\n');
    stringBuilder.append(getStackTraceString(paramThrowable));
    return printlnInternal(4, paramString1, stringBuilder.toString());
  }
  
  public static void init(Context paramContext, ILogCallback paramILogCallback) {
    sContext = paramContext;
    sLogToFile = false;
    sExternalLogger = paramILogCallback;
  }
  
  public static void init(Context paramContext, boolean paramBoolean, File paramFile) throws IOException {
    sContext = paramContext;
    sLogToFile = paramBoolean;
    if (sLogToFile) {
      sLogFile = paramFile;
      sBufferedFileWriter = new BufferedWriter(new FileWriter(sLogFile, true));
    } 
  }
  
  public static boolean isLoggable(String paramString, int paramInt) {
    return android.util.Log.isLoggable(paramString, paramInt);
  }
  
  public static int println(int paramInt, String paramString1, String paramString2) {
    return printlnInternal(paramInt, paramString1, paramString2);
  }
  
  private static int printlnInternal(int paramInt, String paramString1, String paramString2) {
    if (sLogToFile || sExternalLogger != null) {
      if (sLogToFile)
        ensurePathInitialized(); 
      StringBuilder stringBuilder = new StringBuilder((new SimpleDateFormat("HH:mm:ss.SSS")).format(new Date()));
      stringBuilder.append("\t");
      stringBuilder.append(Thread.currentThread().getId());
      stringBuilder.append("\t");
      stringBuilder.append(getDisplayForPriority(paramInt));
      stringBuilder.append("\t");
      stringBuilder.append(paramString1);
      stringBuilder.append("\t");
      stringBuilder.append(paramString2);
      try {
        if (sExternalLogger != null) {
          sExternalLogger.logger(stringBuilder.toString());
        } else if (sBufferedFileWriter != null) {
          sBufferedFileWriter.write(stringBuilder.toString(), 0, stringBuilder.length());
          sBufferedFileWriter.newLine();
          sBufferedFileWriter.flush();
        } 
      } catch (IOException iOException) {
        iOException.printStackTrace();
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
    } 
    return android.util.Log.println(paramInt, paramString1, paramString2);
  }
  
  public static int v(String paramString1, String paramString2) {
    return printlnInternal(2, paramString1, paramString2);
  }
  
  public static int v(String paramString1, String paramString2, Throwable paramThrowable) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString2);
    stringBuilder.append('\n');
    stringBuilder.append(getStackTraceString(paramThrowable));
    return printlnInternal(2, paramString1, stringBuilder.toString());
  }
  
  public static int w(String paramString1, String paramString2) {
    return printlnInternal(5, paramString1, paramString2);
  }
  
  public static int w(String paramString1, String paramString2, Throwable paramThrowable) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString2);
    stringBuilder.append('\n');
    stringBuilder.append(getStackTraceString(paramThrowable));
    return printlnInternal(5, paramString1, stringBuilder.toString());
  }
  
  public static int w(String paramString, Throwable paramThrowable) {
    return printlnInternal(5, paramString, getStackTraceString(paramThrowable));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\cor\\utils\Log.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */