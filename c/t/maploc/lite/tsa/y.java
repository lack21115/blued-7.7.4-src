package c.t.maploc.lite.tsa;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import java.text.SimpleDateFormat;
import java.util.Date;

public class y {
  private static Context c;
  
  private static volatile y d;
  
  private static String e = "";
  
  private static j f;
  
  public z a;
  
  public boolean b = false;
  
  private volatile boolean g = false;
  
  private volatile boolean h = false;
  
  private byte[] i = new byte[0];
  
  private SimpleDateFormat j = new SimpleDateFormat("HHmmss");
  
  private SimpleDateFormat k = new SimpleDateFormat("yyyyMMdd-HHmmss");
  
  public static y a() {
    // Byte code:
    //   0: getstatic c/t/maploc/lite/tsa/y.d : Lc/t/maploc/lite/tsa/y;
    //   3: ifnonnull -> 37
    //   6: ldc c/t/maploc/lite/tsa/y
    //   8: monitorenter
    //   9: getstatic c/t/maploc/lite/tsa/y.d : Lc/t/maploc/lite/tsa/y;
    //   12: ifnonnull -> 25
    //   15: new c/t/maploc/lite/tsa/y
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic c/t/maploc/lite/tsa/y.d : Lc/t/maploc/lite/tsa/y;
    //   25: ldc c/t/maploc/lite/tsa/y
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc c/t/maploc/lite/tsa/y
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic c/t/maploc/lite/tsa/y.d : Lc/t/maploc/lite/tsa/y;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public static void a(Context paramContext, String paramString) {
    c = paramContext.getApplicationContext();
    e = paramString;
    f = j.a(c);
  }
  
  private void a(String paramString, boolean paramBoolean) {
    (new Thread(new aa(this, paramString, paramBoolean), "th_mllc")).start();
  }
  
  private static String b(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getApplicationInfo : ()Landroid/content/pm/ApplicationInfo;
    //   4: getfield targetSdkVersion : I
    //   7: istore #5
    //   9: iconst_0
    //   10: istore_1
    //   11: iconst_0
    //   12: istore_2
    //   13: iload_1
    //   14: istore_3
    //   15: iload_2
    //   16: bipush #7
    //   18: if_icmpge -> 137
    //   21: bipush #7
    //   23: anewarray java/lang/String
    //   26: dup
    //   27: iconst_0
    //   28: ldc 'android.permission.ACCESS_FINE_LOCATION'
    //   30: aastore
    //   31: dup
    //   32: iconst_1
    //   33: ldc 'android.permission.ACCESS_COARSE_LOCATION'
    //   35: aastore
    //   36: dup
    //   37: iconst_2
    //   38: ldc 'android.permission.ACCESS_WIFI_STATE'
    //   40: aastore
    //   41: dup
    //   42: iconst_3
    //   43: ldc 'android.permission.CHANGE_WIFI_STATE'
    //   45: aastore
    //   46: dup
    //   47: iconst_4
    //   48: ldc 'android.permission.ACCESS_NETWORK_STATE'
    //   50: aastore
    //   51: dup
    //   52: iconst_5
    //   53: ldc 'android.permission.CHANGE_NETWORK_STATE'
    //   55: aastore
    //   56: dup
    //   57: bipush #6
    //   59: ldc 'android.permission.READ_PHONE_STATE'
    //   61: aastore
    //   62: iload_2
    //   63: aaload
    //   64: astore #6
    //   66: getstatic android/os/Build$VERSION.SDK_INT : I
    //   69: bipush #23
    //   71: if_icmplt -> 110
    //   74: iload #5
    //   76: bipush #23
    //   78: if_icmpge -> 93
    //   81: aload_0
    //   82: aload #6
    //   84: invokestatic checkSelfPermission : (Landroid/content/Context;Ljava/lang/String;)I
    //   87: ifeq -> 110
    //   90: goto -> 104
    //   93: aload_0
    //   94: aload #6
    //   96: invokevirtual checkSelfPermission : (Ljava/lang/String;)I
    //   99: istore_3
    //   100: iload_3
    //   101: ifeq -> 110
    //   104: iconst_0
    //   105: istore #4
    //   107: goto -> 113
    //   110: iconst_1
    //   111: istore #4
    //   113: iload_1
    //   114: istore_3
    //   115: iload #4
    //   117: ifne -> 126
    //   120: iload_1
    //   121: iconst_1
    //   122: iload_2
    //   123: ishl
    //   124: ior
    //   125: istore_3
    //   126: iload_2
    //   127: iconst_1
    //   128: iadd
    //   129: istore_2
    //   130: iload_3
    //   131: istore_1
    //   132: goto -> 13
    //   135: iconst_m1
    //   136: istore_3
    //   137: invokestatic a : ()Lc/t/maploc/lite/tsa/al;
    //   140: pop
    //   141: aload_0
    //   142: invokestatic a : (Landroid/content/Context;)I
    //   145: istore_1
    //   146: new java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial <init> : ()V
    //   153: astore_0
    //   154: aload_0
    //   155: getstatic android/os/Build$VERSION.SDK_INT : I
    //   158: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload_0
    //   163: ldc '&'
    //   165: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload_0
    //   170: iload #5
    //   172: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload_0
    //   177: ldc '&'
    //   179: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload_0
    //   184: iload_3
    //   185: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload_0
    //   190: ldc '&'
    //   192: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload_0
    //   197: iload_1
    //   198: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: aload_0
    //   203: invokevirtual toString : ()Ljava/lang/String;
    //   206: areturn
    //   207: astore #6
    //   209: goto -> 135
    // Exception table:
    //   from	to	target	type
    //   21	74	207	finally
    //   81	90	207	finally
    //   93	100	207	finally
  }
  
  public final int a(Looper paramLooper) {
    synchronized (this.i) {
      if (this.g)
        return -1; 
      this.g = true;
      if (this.b) {
        this.a = new z(this, paramLooper);
        b.a(this.a, 1);
      } 
    } 
    boolean bool = false;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_3} */
    return bool;
  }
  
  public final void a(String paramString1, String paramString2) {
    if (e()) {
      z z1 = this.a;
      if (z1 != null) {
        Message message = z1.obtainMessage(3);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.j.format(new Date()));
        stringBuilder.append(",");
        stringBuilder.append(paramString1);
        stringBuilder.append(",");
        stringBuilder.append(paramString2);
        message.obj = stringBuilder.toString();
        message.sendToTarget();
      } 
    } 
  }
  
  public final boolean e() {
    synchronized (this.i) {
      return this.g;
    } 
  }
  
  public final void f() {
    if (e()) {
      z z1 = this.a;
      if (z1 != null)
        b.a(z1, 5); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\c\t\maploc\lite\tsa\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */