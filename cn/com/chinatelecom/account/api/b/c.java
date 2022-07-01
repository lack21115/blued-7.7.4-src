package cn.com.chinatelecom.account.api.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.Looper;
import cn.com.chinatelecom.account.api.CtAuth;
import java.net.InetAddress;

public class c {
  private static final String a = c.class.getSimpleName();
  
  private static Handler b = new Handler(Looper.getMainLooper());
  
  private boolean c;
  
  private Context d;
  
  private ConnectivityManager.NetworkCallback e;
  
  public c(Context paramContext) {
    this.d = paramContext;
  }
  
  public static int a(String paramString) {
    try {
      InetAddress inetAddress = InetAddress.getByName(paramString);
      byte[] arrayOfByte = inetAddress.getAddress();
      byte b1 = arrayOfByte[3];
      return arrayOfByte[0] & 0xFF | (b1 & 0xFF) << 24 | (b2 & 0xFF) << 16 | (b3 & 0xFF) << 8;
    } finally {
      paramString = null;
      CtAuth.warn(a, "When InetAddress.getByName(),throws exception", (Throwable)paramString);
    } 
  }
  
  public static String b(String paramString) {
    int i = paramString.indexOf("://");
    String str = paramString;
    if (i > 0)
      str = paramString.substring(i + 3); 
    i = str.indexOf(':');
    paramString = str;
    if (i >= 0)
      paramString = str.substring(0, i); 
    i = paramString.indexOf('/');
    str = paramString;
    if (i >= 0)
      str = paramString.substring(0, i); 
    i = str.indexOf('?');
    paramString = str;
    if (i >= 0)
      paramString = str.substring(0, i); 
    return paramString;
  }
  
  private void b(b paramb) {
    b.postDelayed(new Runnable(this, paramb) {
          public void run() {
            if (!c.a(this.b) && this.a != null) {
              c.b(this.b);
              this.a.a();
            } 
          }
        }2500L);
  }
  
  private int c(String paramString) {
    // Byte code:
    //   0: ldc 'android.net.ConnectivityManager'
    //   2: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   5: astore #4
    //   7: aload_0
    //   8: getfield d : Landroid/content/Context;
    //   11: ldc 'connectivity'
    //   13: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   16: checkcast android/net/ConnectivityManager
    //   19: astore #5
    //   21: aload #5
    //   23: iconst_5
    //   24: invokevirtual getNetworkInfo : (I)Landroid/net/NetworkInfo;
    //   27: invokevirtual getState : ()Landroid/net/NetworkInfo$State;
    //   30: getstatic android/net/NetworkInfo$State.CONNECTED : Landroid/net/NetworkInfo$State;
    //   33: invokevirtual compareTo : (Ljava/lang/Enum;)I
    //   36: ifeq -> 136
    //   39: aload #4
    //   41: ldc 'startUsingNetworkFeature'
    //   43: iconst_2
    //   44: anewarray java/lang/Class
    //   47: dup
    //   48: iconst_0
    //   49: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   52: aastore
    //   53: dup
    //   54: iconst_1
    //   55: ldc java/lang/String
    //   57: aastore
    //   58: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   61: aload #5
    //   63: iconst_2
    //   64: anewarray java/lang/Object
    //   67: dup
    //   68: iconst_0
    //   69: iconst_0
    //   70: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   73: aastore
    //   74: dup
    //   75: iconst_1
    //   76: ldc 'enableHIPRI'
    //   78: aastore
    //   79: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   82: pop
    //   83: iconst_0
    //   84: istore_2
    //   85: iload_2
    //   86: iconst_5
    //   87: if_icmpge -> 136
    //   90: aload #5
    //   92: iconst_5
    //   93: invokevirtual getNetworkInfo : (I)Landroid/net/NetworkInfo;
    //   96: invokevirtual getState : ()Landroid/net/NetworkInfo$State;
    //   99: getstatic android/net/NetworkInfo$State.CONNECTED : Landroid/net/NetworkInfo$State;
    //   102: invokevirtual compareTo : (Ljava/lang/Enum;)I
    //   105: ifne -> 111
    //   108: goto -> 136
    //   111: ldc2_w 500
    //   114: invokestatic sleep : (J)V
    //   117: iload_2
    //   118: iconst_1
    //   119: iadd
    //   120: istore_2
    //   121: goto -> 85
    //   124: astore #6
    //   126: getstatic cn/com/chinatelecom/account/api/b/c.a : Ljava/lang/String;
    //   129: ldc 'STMN_V4'
    //   131: aload #6
    //   133: invokestatic warn : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   136: aload_1
    //   137: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   140: invokestatic a : (Ljava/lang/String;)I
    //   143: istore_2
    //   144: aload #4
    //   146: ldc 'requestRouteToHost'
    //   148: iconst_2
    //   149: anewarray java/lang/Class
    //   152: dup
    //   153: iconst_0
    //   154: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   157: aastore
    //   158: dup
    //   159: iconst_1
    //   160: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   163: aastore
    //   164: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   167: aload #5
    //   169: iconst_2
    //   170: anewarray java/lang/Object
    //   173: dup
    //   174: iconst_0
    //   175: iconst_5
    //   176: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   179: aastore
    //   180: dup
    //   181: iconst_1
    //   182: iload_2
    //   183: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   186: aastore
    //   187: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   190: checkcast java/lang/Boolean
    //   193: invokevirtual booleanValue : ()Z
    //   196: istore_3
    //   197: getstatic cn/com/chinatelecom/account/api/b/c.a : Ljava/lang/String;
    //   200: astore_1
    //   201: new java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial <init> : ()V
    //   208: astore #4
    //   210: aload #4
    //   212: ldc 'STMN_V4 ：'
    //   214: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: aload #4
    //   220: iload_3
    //   221: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload_1
    //   226: aload #4
    //   228: invokevirtual toString : ()Ljava/lang/String;
    //   231: invokestatic info : (Ljava/lang/String;Ljava/lang/String;)V
    //   234: iload_3
    //   235: ifeq -> 240
    //   238: iconst_0
    //   239: ireturn
    //   240: bipush #-2
    //   242: ireturn
    //   243: astore_1
    //   244: getstatic cn/com/chinatelecom/account/api/b/c.a : Ljava/lang/String;
    //   247: ldc 'STMN_V4_T'
    //   249: aload_1
    //   250: invokestatic warn : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   253: iconst_m1
    //   254: ireturn
    // Exception table:
    //   from	to	target	type
    //   0	83	243	finally
    //   90	108	124	finally
    //   111	117	124	finally
    //   126	136	243	finally
    //   136	234	243	finally
  }
  
  private void c() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield c : Z
    //   7: aload_0
    //   8: monitorexit
    //   9: return
    //   10: astore_1
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_1
    //   14: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	10	finally
  }
  
  private boolean d() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield c : Z
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public void a() {
    try {
      if (this.e != null) {
        ((ConnectivityManager)this.d.getSystemService("connectivity")).unregisterNetworkCallback(this.e);
        return;
      } 
    } finally {
      Exception exception = null;
    } 
  }
  
  public void a(b paramb) {
    long l = System.currentTimeMillis();
    try {
      b(paramb);
      ConnectivityManager connectivityManager = (ConnectivityManager)this.d.getSystemService("connectivity");
      NetworkRequest.Builder builder = new NetworkRequest.Builder();
      builder.addCapability(12);
      builder.addTransportType(0);
      NetworkRequest networkRequest = builder.build();
      return;
    } finally {
      Exception exception = null;
      if (!d() && paramb != null)
        paramb.a(System.currentTimeMillis() - l); 
    } 
  }
  
  public void a(b paramb, String paramString) {
    (new d()).a(new e(this, paramString, paramb) {
          public void a() {
            long l = System.currentTimeMillis();
            int i = c.a(this.c, this.a);
            if (i == 0) {
              this.b.a(null, System.currentTimeMillis() - l);
              return;
            } 
            if (i == -1) {
              c.b().post(new Runnable(this, l) {
                    public void run() {
                      this.b.b.a(System.currentTimeMillis() - this.a);
                    }
                  });
              return;
            } 
            c.b().post(new Runnable(this) {
                  public void run() {
                    this.a.b.a();
                  }
                });
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\com\chinatelecom\account\api\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */