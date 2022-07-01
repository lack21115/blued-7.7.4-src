package com.blued.android.module.external_sense_library.utils;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.blued.android.framework.utils.LogUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class AppLogger {
  private static String a;
  
  private static AppLogger b;
  
  private Handler c;
  
  private File d;
  
  private Writer e;
  
  private int f = 0;
  
  private final int g = 20;
  
  private AppLogger() {
    a = Environment.getExternalStorageDirectory().getPath();
    if (this.c == null)
      this.c = new Handler(this, ThreadHandlerManager.a().b().getLooper()) {
          public void handleMessage(Message param1Message) {
            String str = String.format("%s %s  %s", new Object[] { TimeUtil.a(), "sense_log", param1Message.obj });
            AppLogger.a(this.a, str);
            AppLogger.b(this.a, str);
          }
        }; 
    c();
  }
  
  public static AppLogger a() {
    // Byte code:
    //   0: getstatic com/blued/android/module/external_sense_library/utils/AppLogger.b : Lcom/blued/android/module/external_sense_library/utils/AppLogger;
    //   3: ifnonnull -> 37
    //   6: ldc com/blued/android/module/external_sense_library/utils/AppLogger
    //   8: monitorenter
    //   9: getstatic com/blued/android/module/external_sense_library/utils/AppLogger.b : Lcom/blued/android/module/external_sense_library/utils/AppLogger;
    //   12: ifnonnull -> 25
    //   15: new com/blued/android/module/external_sense_library/utils/AppLogger
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/blued/android/module/external_sense_library/utils/AppLogger.b : Lcom/blued/android/module/external_sense_library/utils/AppLogger;
    //   25: ldc com/blued/android/module/external_sense_library/utils/AppLogger
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/blued/android/module/external_sense_library/utils/AppLogger
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/blued/android/module/external_sense_library/utils/AppLogger.b : Lcom/blued/android/module/external_sense_library/utils/AppLogger;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private String a(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("external_sense_");
    stringBuilder.append(paramInt);
    stringBuilder.append(".txt");
    return stringBuilder.toString();
  }
  
  private void a(String paramString) {
    int i = paramString.length();
    if (i > 4000) {
      byte b;
      int m = i / 2000;
      if (i % 2000 == 0) {
        b = 0;
      } else {
        b = 1;
      } 
      int j = 0;
      int k = 1;
      while (j < i) {
        int n = j + 2000;
        if (n >= i)
          n = i; 
        Log.v("sense_log", String.format("[%d/%d] %s", new Object[] { Integer.valueOf(k), Integer.valueOf(m + b), paramString.substring(j, n) }));
        k++;
        j = n;
      } 
    } else {
      LogUtils.a("sense_log", paramString);
    } 
  }
  
  private void b(String paramString) {
    this.f++;
    Writer writer = this.e;
    if (writer != null)
      try {
        writer.write(paramString);
        this.e.write("\r\n");
        if (this.f >= 20)
          this.e.flush(); 
      } catch (IOException iOException) {
        iOException.printStackTrace();
      }  
    if (this.f >= 20 && this.d.length() >= 10485760L) {
      this.f = 0;
      d();
    } 
  }
  
  private void c() {
    d();
  }
  
  private void d() {
    this.c.post(new Runnable(this) {
          public void run() {
            AppLogger.a(this.a);
            AppLogger.a(this.a, new File(AppLogger.b(), "external_sense.txt"));
            try {
              if (!AppLogger.b(this.a).exists())
                AppLogger.b(this.a).createNewFile(); 
              AppLogger.a(this.a, new BufferedWriter(new FileWriter(AppLogger.b(this.a), true)));
              return;
            } catch (IOException iOException) {
              return;
            } 
          }
        });
  }
  
  private void e() {
    File file = new File(a, "external_sense.txt");
    if (file.exists() && file.length() >= 10485760L)
      for (int i = 0; i <= 6; i++) {
        File file1 = new File(a, a(i));
        if (!file1.exists()) {
          f();
          file.renameTo(file1);
          return;
        } 
        if (i == 6)
          for (int j = 0; j <= 6; j++) {
            file1 = new File(a, a(j));
            if (file1.exists()) {
              file1.delete();
              if (j == 0) {
                f();
                file.renameTo(file1);
              } 
            } 
          }  
      }  
  }
  
  private void f() {
    Writer writer = this.e;
    if (writer != null)
      try {
        writer.close();
        return;
      } catch (IOException iOException) {
        iOException.printStackTrace();
      }  
  }
  
  public void a(String paramString, Object... paramVarArgs) {
    if (paramVarArgs.length != 0)
      paramString = String.format(paramString, paramVarArgs); 
    Message message = Message.obtain();
    message.what = 0;
    message.obj = paramString;
    this.c.sendMessage(message);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_librar\\utils\AppLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */