package cn.com.chinatelecom.account.api.c;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import cn.com.chinatelecom.account.api.b.d;
import cn.com.chinatelecom.account.api.b.e;
import cn.com.chinatelecom.account.api.d.f;
import cn.com.chinatelecom.account.api.d.g;
import java.net.InetAddress;
import java.util.Iterator;

public class c {
  private static final String a = c.class.getSimpleName();
  
  private static String b = null;
  
  private static long c = 0L;
  
  private static long d = 1800000L;
  
  public static String a() {
    // Byte code:
    //   0: ldc cn/com/chinatelecom/account/api/c/c
    //   2: monitorenter
    //   3: invokestatic currentTimeMillis : ()J
    //   6: getstatic cn/com/chinatelecom/account/api/c/c.c : J
    //   9: lcmp
    //   10: ifge -> 31
    //   13: getstatic cn/com/chinatelecom/account/api/c/c.b : Ljava/lang/String;
    //   16: invokestatic a : (Ljava/lang/String;)Z
    //   19: ifeq -> 31
    //   22: getstatic cn/com/chinatelecom/account/api/c/c.b : Ljava/lang/String;
    //   25: astore_0
    //   26: ldc cn/com/chinatelecom/account/api/c/c
    //   28: monitorexit
    //   29: aload_0
    //   30: areturn
    //   31: ldc cn/com/chinatelecom/account/api/c/c
    //   33: monitorexit
    //   34: aconst_null
    //   35: areturn
    //   36: astore_0
    //   37: ldc cn/com/chinatelecom/account/api/c/c
    //   39: monitorexit
    //   40: aload_0
    //   41: athrow
    // Exception table:
    //   from	to	target	type
    //   3	26	36	finally
  }
  
  public static void a(Context paramContext) {
    if (b(paramContext) && b == null) {
      if (g.a() != null)
        return; 
      (new d()).a(new e(paramContext) {
            public void a() {
              // Byte code:
              //   0: invokestatic a : ()Ljava/lang/String;
              //   3: astore_3
              //   4: aload_0
              //   5: getfield a : Landroid/content/Context;
              //   8: invokestatic a : (Landroid/content/Context;)Ljava/lang/String;
              //   11: astore_1
              //   12: aload_3
              //   13: invokestatic a : (Ljava/lang/String;)Lcn/com/chinatelecom/account/api/d/e;
              //   16: aload_1
              //   17: invokevirtual a : (Ljava/lang/String;)Lcn/com/chinatelecom/account/api/d/e;
              //   20: ldc 'dns'
              //   22: invokevirtual c : (Ljava/lang/String;)Lcn/com/chinatelecom/account/api/d/e;
              //   25: aload_0
              //   26: getfield a : Landroid/content/Context;
              //   29: invokestatic f : (Landroid/content/Context;)Ljava/lang/String;
              //   32: invokevirtual b : (Ljava/lang/String;)Lcn/com/chinatelecom/account/api/d/e;
              //   35: pop
              //   36: getstatic cn/com/chinatelecom/account/api/d/b.e : [B
              //   39: invokestatic a : ([B)Ljava/lang/String;
              //   42: astore #4
              //   44: aload #4
              //   46: aload_3
              //   47: iconst_0
              //   48: invokestatic a : (Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
              //   51: astore_2
              //   52: aload_2
              //   53: astore_1
              //   54: aload_2
              //   55: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
              //   58: ifeq -> 69
              //   61: aload #4
              //   63: aload_3
              //   64: iconst_1
              //   65: invokestatic a : (Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
              //   68: astore_1
              //   69: ldc cn/com/chinatelecom/account/api/c/c
              //   71: monitorenter
              //   72: aload_1
              //   73: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
              //   76: ifne -> 116
              //   79: aload_1
              //   80: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
              //   83: pop
              //   84: invokestatic currentTimeMillis : ()J
              //   87: invokestatic b : ()J
              //   90: ladd
              //   91: invokestatic a : (J)J
              //   94: pop2
              //   95: aload_3
              //   96: invokestatic a : (Ljava/lang/String;)Lcn/com/chinatelecom/account/api/d/e;
              //   99: iconst_0
              //   100: invokevirtual a : (I)Lcn/com/chinatelecom/account/api/d/e;
              //   103: astore_1
              //   104: ldc 'success'
              //   106: astore_2
              //   107: aload_1
              //   108: aload_2
              //   109: invokevirtual e : (Ljava/lang/String;)Lcn/com/chinatelecom/account/api/d/e;
              //   112: pop
              //   113: goto -> 136
              //   116: aload_3
              //   117: invokestatic a : (Ljava/lang/String;)Lcn/com/chinatelecom/account/api/d/e;
              //   120: ldc 80011
              //   122: invokevirtual a : (I)Lcn/com/chinatelecom/account/api/d/e;
              //   125: astore_1
              //   126: getstatic cn/com/chinatelecom/account/api/d/j.q : [B
              //   129: invokestatic a : ([B)Ljava/lang/String;
              //   132: astore_2
              //   133: goto -> 107
              //   136: ldc cn/com/chinatelecom/account/api/c/c
              //   138: monitorexit
              //   139: aload_3
              //   140: invokestatic b : (Ljava/lang/String;)V
              //   143: return
              //   144: astore_1
              //   145: ldc cn/com/chinatelecom/account/api/c/c
              //   147: monitorexit
              //   148: aload_1
              //   149: athrow
              //   150: astore_1
              //   151: aload_1
              //   152: invokevirtual printStackTrace : ()V
              //   155: return
              // Exception table:
              //   from	to	target	type
              //   0	52	150	finally
              //   54	69	150	finally
              //   69	72	150	finally
              //   72	104	144	finally
              //   107	113	144	finally
              //   116	133	144	finally
              //   136	139	144	finally
              //   139	143	150	finally
              //   145	148	144	finally
              //   148	150	150	finally
            }
          });
    } 
  }
  
  private static String b(String paramString1, String paramString2, int paramInt) {
    try {
      f.a(paramString2).b(paramInt);
      return InetAddress.getByName(paramString1).getHostAddress();
    } catch (Exception exception) {
      StringBuilder stringBuilder;
      if (paramInt == 0) {
        stringBuilder = new StringBuilder();
        paramString1 = "first exception: ";
      } else {
        stringBuilder = new StringBuilder();
        paramString1 = "retry exception: ";
      } 
      stringBuilder.append(paramString1);
      stringBuilder.append(exception.getMessage());
      paramString1 = stringBuilder.toString();
      f.a(paramString2).g(paramString1);
      return null;
    } 
  }
  
  public static boolean b(Context paramContext) {
    try {
      return paramContext.getPackageName().equals(c(paramContext));
    } catch (Exception exception) {
      exception.printStackTrace();
      return true;
    } 
  }
  
  private static String c(Context paramContext) {
    int i = Process.myPid();
    Iterator<ActivityManager.RunningAppProcessInfo> iterator = ((ActivityManager)paramContext.getApplicationContext().getSystemService("activity")).getRunningAppProcesses().iterator();
    String str = "";
    while (iterator.hasNext()) {
      ActivityManager.RunningAppProcessInfo runningAppProcessInfo = iterator.next();
      if (runningAppProcessInfo.pid == i)
        str = runningAppProcessInfo.processName; 
    } 
    return str;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\com\chinatelecom\account\api\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */