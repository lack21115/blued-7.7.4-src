package com.bun.miitmdid.c.j.b;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

public class b {
  private static Context a;
  
  private static boolean b;
  
  private static b c;
  
  private static a d;
  
  private static c e;
  
  private static c f;
  
  private static c g;
  
  private static Object h = new Object();
  
  private static HandlerThread i;
  
  private static Handler j;
  
  private static String k;
  
  private static String l;
  
  private static String m;
  
  private static String n;
  
  public static native b a(Context paramContext);
  
  public static native String a(String paramString1, String paramString2);
  
  private static native void a(Context paramContext, int paramInt, String paramString);
  
  private native void b(int paramInt, String paramString);
  
  public static native void e();
  
  private static native void f();
  
  public native String a();
  
  public native String a(String paramString);
  
  public native void a(int paramInt, String paramString);
  
  public native String b(String paramString);
  
  public native boolean b();
  
  static final class a extends Handler {
    a(Looper param1Looper) {
      super(param1Looper);
    }
    
    public native void handleMessage(Message param1Message);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bun\miitmdid\c\j\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */