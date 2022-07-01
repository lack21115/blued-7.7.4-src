package com.geetest.onelogin.j;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class h {
  public static int a = 1;
  
  public static String b = "Geetest_OneLogin";
  
  private static a c;
  
  public static void a(int paramInt, String paramString) {
    a = paramInt;
    b = paramString;
    paramString = b;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("init log level: ");
    stringBuilder.append(paramInt);
    Log.i(paramString, stringBuilder.toString());
  }
  
  public static void a(String paramString) {
    if (a <= 1) {
      Log.v(b, paramString);
      b(b, paramString);
    } 
  }
  
  public static void a(String paramString1, String paramString2) {
    if (a <= 3) {
      Log.i(paramString1, paramString2);
      b(paramString1, paramString2);
    } 
  }
  
  public static void b(String paramString) {
    if (a <= 3) {
      Log.i(b, paramString);
      b(b, paramString);
    } 
  }
  
  private static void b(String paramString1, String paramString2) {
    if (c == null) {
      c = new a();
      c.a();
      c.b();
    } 
    c.a(paramString1, paramString2);
  }
  
  public static void c(String paramString) {
    if (a <= 5) {
      Log.e(b, paramString);
      b(b, paramString);
    } 
  }
  
  public static void d(String paramString) {
    Log.e(b, paramString);
    b(b, paramString);
  }
  
  static class a {
    private HandlerThread a;
    
    private Handler b;
    
    private SimpleDateFormat c = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    
    private void a(String param1String) {
      File file1 = new File(d());
      if (!file1.exists())
        file1.mkdirs(); 
      File file3 = null;
      File file2 = null;
      try {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(file1, "onelogin_log.txt"), true));
        try {
          bufferedOutputStream.write(param1String.getBytes("utf-8"));
        } catch (Exception exception) {
          return;
        } finally {
          param1String = null;
        } 
        throw param1String;
      } catch (Exception exception) {
      
      } finally {
        param1String = null;
        file1 = file2;
      } 
      if (iOException != null)
        iOException.close(); 
    }
    
    private static String b(SimpleDateFormat param1SimpleDateFormat, long param1Long, String param1String1, String param1String2) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(param1SimpleDateFormat.format(new Date(param1Long)));
      stringBuilder.append('\t');
      stringBuilder.append(param1String1);
      stringBuilder.append('\n');
      stringBuilder.append(param1String2);
      stringBuilder.append('\n');
      return stringBuilder.toString();
    }
    
    private static String d() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(m.b());
      stringBuilder.append(File.separator);
      stringBuilder.append("geetest");
      return stringBuilder.toString();
    }
    
    private static boolean e() {
      File file = new File(d());
      if (!file.exists())
        return false; 
      file = new File(file, "onelogin_log.txt");
      return !file.exists() ? false : ((file.length() < 10485760L) ? false : file.delete());
    }
    
    public void a() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: new android/os/HandlerThread
      //   6: dup
      //   7: ldc 'Geetest Thread'
      //   9: invokespecial <init> : (Ljava/lang/String;)V
      //   12: putfield a : Landroid/os/HandlerThread;
      //   15: aload_0
      //   16: getfield a : Landroid/os/HandlerThread;
      //   19: invokevirtual start : ()V
      //   22: aload_0
      //   23: new com/geetest/onelogin/j/h$a$1
      //   26: dup
      //   27: aload_0
      //   28: aload_0
      //   29: getfield a : Landroid/os/HandlerThread;
      //   32: invokevirtual getLooper : ()Landroid/os/Looper;
      //   35: invokespecial <init> : (Lcom/geetest/onelogin/j/h$a;Landroid/os/Looper;)V
      //   38: putfield b : Landroid/os/Handler;
      //   41: aload_0
      //   42: monitorexit
      //   43: return
      //   44: astore_1
      //   45: aload_0
      //   46: monitorexit
      //   47: aload_1
      //   48: athrow
      // Exception table:
      //   from	to	target	type
      //   2	41	44	finally
    }
    
    public void a(String param1String1, String param1String2) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: invokestatic a : ()Z
      //   5: istore_3
      //   6: iload_3
      //   7: ifne -> 13
      //   10: aload_0
      //   11: monitorexit
      //   12: return
      //   13: aload_0
      //   14: getfield b : Landroid/os/Handler;
      //   17: invokevirtual obtainMessage : ()Landroid/os/Message;
      //   20: astore #4
      //   22: aload #4
      //   24: iconst_0
      //   25: putfield what : I
      //   28: new com/geetest/onelogin/j/h$a$a
      //   31: dup
      //   32: aconst_null
      //   33: invokespecial <init> : (Lcom/geetest/onelogin/j/h$1;)V
      //   36: astore #5
      //   38: aload #5
      //   40: invokestatic currentTimeMillis : ()J
      //   43: putfield a : J
      //   46: aload #5
      //   48: aload_1
      //   49: putfield b : Ljava/lang/String;
      //   52: aload #5
      //   54: aload_2
      //   55: putfield c : Ljava/lang/String;
      //   58: aload #4
      //   60: aload #5
      //   62: putfield obj : Ljava/lang/Object;
      //   65: aload_0
      //   66: getfield b : Landroid/os/Handler;
      //   69: aload #4
      //   71: invokevirtual sendMessage : (Landroid/os/Message;)Z
      //   74: pop
      //   75: aload_0
      //   76: monitorexit
      //   77: return
      //   78: astore_1
      //   79: aload_0
      //   80: monitorexit
      //   81: aload_1
      //   82: athrow
      // Exception table:
      //   from	to	target	type
      //   2	6	78	finally
      //   13	75	78	finally
    }
    
    public void b() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: invokestatic a : ()Z
      //   5: istore_1
      //   6: iload_1
      //   7: ifne -> 13
      //   10: aload_0
      //   11: monitorexit
      //   12: return
      //   13: aload_0
      //   14: getfield b : Landroid/os/Handler;
      //   17: invokevirtual obtainMessage : ()Landroid/os/Message;
      //   20: astore_2
      //   21: aload_2
      //   22: iconst_1
      //   23: putfield what : I
      //   26: aload_0
      //   27: getfield b : Landroid/os/Handler;
      //   30: aload_2
      //   31: invokevirtual sendMessage : (Landroid/os/Message;)Z
      //   34: pop
      //   35: aload_0
      //   36: monitorexit
      //   37: return
      //   38: astore_2
      //   39: aload_0
      //   40: monitorexit
      //   41: aload_2
      //   42: athrow
      // Exception table:
      //   from	to	target	type
      //   2	6	38	finally
      //   13	35	38	finally
    }
    
    static class a {
      public long a;
      
      public String b;
      
      public String c;
      
      private a() {}
    }
  }
  
  class null extends Handler {
    null(h this$0, Looper param1Looper) {
      super(param1Looper);
    }
    
    public void handleMessage(Message param1Message) {
      h.a.a a1;
      super.handleMessage(param1Message);
      if (Thread.interrupted())
        return; 
      if (!m.a())
        return; 
      if (param1Message.what == 0) {
        a1 = (h.a.a)param1Message.obj;
        h.a a2 = this.a;
        h.a.a(a2, h.a.a(h.a.a(a2), a1.a, a1.b, a1.c));
        return;
      } 
      if (((Message)a1).what == 1)
        h.a.c(); 
    }
  }
  
  static class a {
    public long a;
    
    public String b;
    
    public String c;
    
    private a() {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\j\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */