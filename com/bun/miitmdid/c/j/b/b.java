package com.bun.miitmdid.c.j.b;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
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
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static b a(Context paramContext) {
    if (c == null) {
      c = new b();
      a = paramContext;
      f();
      d = new a(a);
      e();
    } 
    return c;
  }
  
  public static String a(String paramString1, String paramString2) {
    try {
      return (String)clazz.getMethod("get", new Class[] { String.class, String.class }).invoke(clazz, new Object[] { paramString1, "unknown" });
    } catch (Exception exception) {
      return paramString2;
    } finally {
      paramString1 = null;
    } 
  }
  
  private static void a(Context paramContext, int paramInt, String paramString) {
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt != 2)
          return; 
        g = new c(c, 2, paramString);
        paramContext.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + paramString), false, g);
        return;
      } 
      f = new c(c, 1, paramString);
      paramContext.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + paramString), false, f);
      return;
    } 
    e = new c(c, 0, null);
    paramContext.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, e);
  }
  
  private void b(int paramInt, String paramString) {
    Message message = j.obtainMessage();
    message.what = 11;
    Bundle bundle = new Bundle();
    bundle.putInt("type", paramInt);
    if (paramInt == 1 || paramInt == 2)
      bundle.putString("appid", paramString); 
    message.setData(bundle);
    j.sendMessage(message);
  }
  
  public static void e() {
    b = "1".equals(a("persist.sys.identifierid.supported", "0"));
  }
  
  private static void f() {
    i = new HandlerThread("SqlWorkThread");
    i.start();
    j = new a(i.getLooper());
  }
  
  public String a() {
    if (!b())
      return null; 
    String str = l;
    if (str != null)
      return str; 
    a(0, (String)null);
    if (e == null)
      a(a, 0, null); 
    return l;
  }
  
  public String a(String paramString) {
    if (!b())
      return null; 
    String str2 = n;
    String str1 = str2;
    if (str2 == null) {
      a(2, paramString);
      if (g == null && n != null)
        a(a, 2, paramString); 
      return n;
    } 
    return str1;
  }
  
  public void a(int paramInt, String paramString) {
    // Byte code:
    //   0: getstatic com/bun/miitmdid/c/j/b/b.h : Ljava/lang/Object;
    //   3: astore #5
    //   5: aload #5
    //   7: monitorenter
    //   8: aload_0
    //   9: iload_1
    //   10: aload_2
    //   11: invokespecial b : (ILjava/lang/String;)V
    //   14: invokestatic uptimeMillis : ()J
    //   17: lstore_3
    //   18: getstatic com/bun/miitmdid/c/j/b/b.h : Ljava/lang/Object;
    //   21: ldc2_w 2000
    //   24: invokevirtual wait : (J)V
    //   27: invokestatic uptimeMillis : ()J
    //   30: lload_3
    //   31: lsub
    //   32: ldc2_w 2000
    //   35: lcmp
    //   36: ifge -> 134
    //   39: iload_1
    //   40: ifeq -> 125
    //   43: iload_1
    //   44: iconst_1
    //   45: if_icmpeq -> 100
    //   48: iload_1
    //   49: iconst_2
    //   50: if_icmpeq -> 71
    //   53: aload #5
    //   55: monitorexit
    //   56: return
    //   57: astore_2
    //   58: aload_2
    //   59: invokevirtual printStackTrace : ()V
    //   62: goto -> 27
    //   65: astore_2
    //   66: aload #5
    //   68: monitorexit
    //   69: aload_2
    //   70: athrow
    //   71: getstatic com/bun/miitmdid/c/j/b/b.k : Ljava/lang/String;
    //   74: ifnull -> 90
    //   77: getstatic com/bun/miitmdid/c/j/b/b.k : Ljava/lang/String;
    //   80: putstatic com/bun/miitmdid/c/j/b/b.n : Ljava/lang/String;
    //   83: aconst_null
    //   84: putstatic com/bun/miitmdid/c/j/b/b.k : Ljava/lang/String;
    //   87: goto -> 53
    //   90: ldc 'VMS_IDLG_SDK_Client'
    //   92: ldc 'get aaid failed'
    //   94: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   97: goto -> 53
    //   100: getstatic com/bun/miitmdid/c/j/b/b.k : Ljava/lang/String;
    //   103: ifnull -> 115
    //   106: getstatic com/bun/miitmdid/c/j/b/b.k : Ljava/lang/String;
    //   109: putstatic com/bun/miitmdid/c/j/b/b.m : Ljava/lang/String;
    //   112: goto -> 83
    //   115: ldc 'VMS_IDLG_SDK_Client'
    //   117: ldc 'get vaid failed'
    //   119: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   122: goto -> 53
    //   125: getstatic com/bun/miitmdid/c/j/b/b.k : Ljava/lang/String;
    //   128: putstatic com/bun/miitmdid/c/j/b/b.l : Ljava/lang/String;
    //   131: goto -> 83
    //   134: ldc 'VMS_IDLG_SDK_Client'
    //   136: ldc 'query timeout'
    //   138: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   141: goto -> 53
    // Exception table:
    //   from	to	target	type
    //   8	18	65	finally
    //   18	27	57	java/lang/InterruptedException
    //   18	27	65	finally
    //   27	39	65	finally
    //   53	56	65	finally
    //   58	62	65	finally
    //   66	69	65	finally
    //   71	83	65	finally
    //   83	87	65	finally
    //   90	97	65	finally
    //   100	112	65	finally
    //   115	122	65	finally
    //   125	131	65	finally
    //   134	141	65	finally
  }
  
  public String b(String paramString) {
    if (!b())
      return null; 
    String str2 = m;
    String str1 = str2;
    if (str2 == null) {
      a(1, paramString);
      if (f == null && m != null)
        a(a, 1, paramString); 
      return m;
    } 
    return str1;
  }
  
  public boolean b() {
    return b;
  }
  
  static final class a extends Handler {
    a(Looper param1Looper) {
      super(param1Looper);
    }
    
    public void handleMessage(Message param1Message) {
      // Byte code:
      //   0: aload_1
      //   1: getfield what : I
      //   4: bipush #11
      //   6: if_icmpne -> 79
      //   9: aload_1
      //   10: invokevirtual getData : ()Landroid/os/Bundle;
      //   13: ldc 'type'
      //   15: invokevirtual getInt : (Ljava/lang/String;)I
      //   18: istore_2
      //   19: aload_1
      //   20: invokevirtual getData : ()Landroid/os/Bundle;
      //   23: ldc 'appid'
      //   25: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
      //   28: astore_1
      //   29: invokestatic c : ()Lcom/bun/miitmdid/c/j/b/a;
      //   32: iload_2
      //   33: aload_1
      //   34: invokevirtual a : (ILjava/lang/String;)Ljava/lang/String;
      //   37: invokestatic c : (Ljava/lang/String;)Ljava/lang/String;
      //   40: pop
      //   41: invokestatic d : ()Ljava/lang/Object;
      //   44: astore_1
      //   45: aload_1
      //   46: monitorenter
      //   47: invokestatic d : ()Ljava/lang/Object;
      //   50: invokevirtual notify : ()V
      //   53: aload_1
      //   54: monitorexit
      //   55: return
      //   56: astore_1
      //   57: ldc ''
      //   59: invokestatic c : (Ljava/lang/String;)Ljava/lang/String;
      //   62: pop
      //   63: ldc 'VMS_IDLG_SDK_Client'
      //   65: ldc 'exception'
      //   67: aload_1
      //   68: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   71: goto -> 41
      //   74: astore_3
      //   75: aload_1
      //   76: monitorexit
      //   77: aload_3
      //   78: athrow
      //   79: ldc 'VMS_IDLG_SDK_Client'
      //   81: ldc 'message type valid'
      //   83: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
      //   86: return
      // Exception table:
      //   from	to	target	type
      //   29	41	56	java/lang/Exception
      //   47	55	74	finally
      //   75	77	74	finally
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\bun\miitmdid\c\j\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */