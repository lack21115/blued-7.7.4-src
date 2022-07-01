package c.t.maploc.lite.tsa;

import android.content.Context;
import android.telephony.TelephonyManager;

public final class al {
  private static al a;
  
  private int b = -1;
  
  private int c = -1;
  
  private int d = 1;
  
  public static int a(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull -> 6
    //   4: iconst_m1
    //   5: ireturn
    //   6: aload_0
    //   7: invokestatic b : (Landroid/content/Context;)Z
    //   10: istore #10
    //   12: iconst_0
    //   13: istore #9
    //   15: iconst_0
    //   16: istore #7
    //   18: aload_0
    //   19: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   22: ldc 'wifi'
    //   24: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   27: checkcast android/net/wifi/WifiManager
    //   30: astore #11
    //   32: aload #11
    //   34: ifnull -> 82
    //   37: aload #11
    //   39: invokevirtual isWifiEnabled : ()Z
    //   42: istore #6
    //   44: getstatic android/os/Build$VERSION.SDK_INT : I
    //   47: bipush #18
    //   49: if_icmplt -> 77
    //   52: aload #11
    //   54: invokevirtual isScanAlwaysAvailable : ()Z
    //   57: istore #8
    //   59: iload #8
    //   61: ifeq -> 77
    //   64: iconst_1
    //   65: istore #5
    //   67: iconst_1
    //   68: istore #4
    //   70: iload #6
    //   72: istore #8
    //   74: goto -> 105
    //   77: iconst_1
    //   78: istore_1
    //   79: goto -> 87
    //   82: iconst_0
    //   83: istore_1
    //   84: iconst_0
    //   85: istore #6
    //   87: goto -> 95
    //   90: iconst_0
    //   91: istore #6
    //   93: iconst_0
    //   94: istore_1
    //   95: iconst_0
    //   96: istore #4
    //   98: iload #6
    //   100: istore #8
    //   102: iload_1
    //   103: istore #5
    //   105: aload_0
    //   106: ldc 'location'
    //   108: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   111: checkcast android/location/LocationManager
    //   114: astore #11
    //   116: aload #11
    //   118: ifnull -> 175
    //   121: aload_0
    //   122: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   125: ldc 'location_mode'
    //   127: invokestatic getInt : (Landroid/content/ContentResolver;Ljava/lang/String;)I
    //   130: istore_1
    //   131: goto -> 136
    //   134: iconst_0
    //   135: istore_1
    //   136: aload #11
    //   138: ldc 'gps'
    //   140: invokevirtual isProviderEnabled : (Ljava/lang/String;)Z
    //   143: istore #6
    //   145: aload #11
    //   147: invokevirtual getAllProviders : ()Ljava/util/List;
    //   150: astore_0
    //   151: aload_0
    //   152: ifnonnull -> 158
    //   155: goto -> 193
    //   158: aload_0
    //   159: ldc 'gps'
    //   161: invokeinterface contains : (Ljava/lang/Object;)Z
    //   166: istore #9
    //   168: iload #9
    //   170: istore #7
    //   172: goto -> 196
    //   175: iconst_0
    //   176: istore #7
    //   178: iconst_0
    //   179: istore_1
    //   180: iload #9
    //   182: istore #6
    //   184: goto -> 196
    //   187: iconst_0
    //   188: istore_1
    //   189: iload #7
    //   191: istore #6
    //   193: iconst_0
    //   194: istore #7
    //   196: iload #10
    //   198: iconst_1
    //   199: ixor
    //   200: istore_3
    //   201: iload_3
    //   202: istore_2
    //   203: iload #8
    //   205: ifne -> 212
    //   208: iload_3
    //   209: iconst_2
    //   210: iadd
    //   211: istore_2
    //   212: iload_2
    //   213: istore_3
    //   214: iload #6
    //   216: ifne -> 223
    //   219: iload_2
    //   220: iconst_4
    //   221: iadd
    //   222: istore_3
    //   223: iload_3
    //   224: istore_2
    //   225: iload #5
    //   227: ifne -> 235
    //   230: iload_3
    //   231: bipush #8
    //   233: iadd
    //   234: istore_2
    //   235: iload_2
    //   236: istore_3
    //   237: iload #7
    //   239: ifne -> 247
    //   242: iload_2
    //   243: bipush #16
    //   245: iadd
    //   246: istore_3
    //   247: iload_3
    //   248: istore_2
    //   249: iload #4
    //   251: ifne -> 259
    //   254: iload_3
    //   255: bipush #32
    //   257: iadd
    //   258: istore_2
    //   259: iload_1
    //   260: ifeq -> 298
    //   263: iload_1
    //   264: iconst_1
    //   265: if_icmpeq -> 292
    //   268: iload_1
    //   269: iconst_2
    //   270: if_icmpeq -> 286
    //   273: iload_1
    //   274: iconst_3
    //   275: if_icmpeq -> 280
    //   278: iload_2
    //   279: ireturn
    //   280: iload_2
    //   281: sipush #512
    //   284: iadd
    //   285: ireturn
    //   286: iload_2
    //   287: sipush #256
    //   290: iadd
    //   291: ireturn
    //   292: iload_2
    //   293: sipush #128
    //   296: iadd
    //   297: ireturn
    //   298: iload_2
    //   299: bipush #64
    //   301: iadd
    //   302: ireturn
    //   303: astore #11
    //   305: goto -> 90
    //   308: astore #11
    //   310: goto -> 93
    //   313: astore_0
    //   314: goto -> 187
    //   317: astore_0
    //   318: goto -> 134
    //   321: astore_0
    //   322: goto -> 189
    // Exception table:
    //   from	to	target	type
    //   18	32	303	finally
    //   37	44	303	finally
    //   44	59	308	finally
    //   105	116	313	java/lang/Exception
    //   121	131	317	finally
    //   136	151	321	java/lang/Exception
    //   158	168	321	java/lang/Exception
  }
  
  public static al a() {
    if (a == null)
      a = new al(); 
    return a;
  }
  
  private static boolean b(Context paramContext) {
    boolean bool = false;
    try {
      TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      if (telephonyManager == null)
        return false; 
      int i = telephonyManager.getSimState();
      if (i == 5)
        bool = true; 
      return bool;
    } catch (Exception exception) {
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\c\t\maploc\lite\tsa\al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */