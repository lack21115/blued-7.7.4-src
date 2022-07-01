package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzbq;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzbm implements Handler.Callback {
  static final Object sLock;
  
  public static final Status zzfzg = new Status(4, "Sign-out occurred while this API call was in progress.");
  
  private static final Status zzfzh = new Status(4, "The user must be signed in to make this API call.");
  
  private static zzbm zzfzj;
  
  final Context mContext;
  
  public final Handler mHandler;
  
  private final GoogleApiAvailability zzftg;
  
  final Map zzfwg = new ConcurrentHashMap<Object, Object>(5, 0.75F, 1);
  
  private long zzfyf = 120000L;
  
  private long zzfyg = 5000L;
  
  private long zzfzi = 10000L;
  
  private int zzfzk = -1;
  
  public final AtomicInteger zzfzl = new AtomicInteger(1);
  
  public final AtomicInteger zzfzm = new AtomicInteger(0);
  
  zzah zzfzn = null;
  
  final Set zzfzo = (Set)new ArraySet();
  
  private final Set zzfzp = (Set)new ArraySet();
  
  static {
    sLock = new Object();
    throw new VerifyError("bad dex opcode");
  }
  
  private zzbm(Context paramContext, Looper paramLooper, GoogleApiAvailability paramGoogleApiAvailability) {
    this.mContext = paramContext;
    this.mHandler = new Handler(paramLooper, this);
    this.zzftg = paramGoogleApiAvailability;
    this.mHandler.sendMessage(this.mHandler.obtainMessage(6));
  }
  
  public static zzbm zzajy() {
    synchronized (sLock) {
      zzbq.checkNotNull(zzfzj, "Must guarantee manager is non-null before using getInstance");
      return zzfzj;
    } 
  }
  
  private final void zzakb() {
    for (zzh zzh : this.zzfzp)
      ((zzbo)this.zzfwg.remove(zzh)).signOut(); 
    this.zzfzp.clear();
  }
  
  private final void zzb(GoogleApi paramGoogleApi) {
    zzh zzh = paramGoogleApi.zzfsn;
    zzbo zzbo2 = (zzbo)this.zzfwg.get(zzh);
    zzbo zzbo1 = zzbo2;
    if (zzbo2 == null) {
      zzbo1 = new zzbo(this, paramGoogleApi);
      this.zzfwg.put(zzh, zzbo1);
    } 
    if (zzbo1.zzacc())
      this.zzfzp.add(zzh); 
    zzbo1.connect();
  }
  
  public static zzbm zzck(Context paramContext) {
    synchronized (sLock) {
      if (zzfzj == null) {
        HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        zzfzj = new zzbm(paramContext.getApplicationContext(), looper, GoogleApiAvailability.getInstance());
      } 
      return zzfzj;
    } 
  }
  
  public final boolean handleMessage(Message paramMessage) {
    // Byte code:
    //   0: aload_1
    //   1: getfield what : I
    //   4: istore #4
    //   6: ldc2_w 300000
    //   9: lstore #5
    //   11: iconst_0
    //   12: istore_3
    //   13: iconst_0
    //   14: istore_2
    //   15: iload #4
    //   17: tableswitch default -> 84, 1 -> 1186, 2 -> 1024, 3 -> 976, 4 -> 857, 5 -> 633, 6 -> 458, 7 -> 445, 8 -> 857, 9 -> 389, 10 -> 383, 11 -> 254, 12 -> 126, 13 -> 857
    //   84: aload_1
    //   85: getfield what : I
    //   88: istore_2
    //   89: new java/lang/StringBuilder
    //   92: dup
    //   93: bipush #31
    //   95: invokespecial <init> : (I)V
    //   98: astore_1
    //   99: aload_1
    //   100: ldc_w 'Unknown message id: '
    //   103: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload_1
    //   108: iload_2
    //   109: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: ldc_w 'GoogleApiManager'
    //   116: aload_1
    //   117: invokevirtual toString : ()Ljava/lang/String;
    //   120: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   123: pop
    //   124: iconst_0
    //   125: ireturn
    //   126: aload_0
    //   127: getfield zzfwg : Ljava/util/Map;
    //   130: aload_1
    //   131: getfield obj : Ljava/lang/Object;
    //   134: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   139: ifeq -> 1280
    //   142: aload_0
    //   143: getfield zzfwg : Ljava/util/Map;
    //   146: aload_1
    //   147: getfield obj : Ljava/lang/Object;
    //   150: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   155: checkcast com/google/android/gms/common/api/internal/zzbo
    //   158: astore_1
    //   159: aload_1
    //   160: getfield zzfzq : Lcom/google/android/gms/common/api/internal/zzbm;
    //   163: getfield mHandler : Landroid/os/Handler;
    //   166: invokestatic zza : (Landroid/os/Handler;)V
    //   169: aload_1
    //   170: getfield zzfwd : Lcom/google/android/gms/common/api/Api$zze;
    //   173: invokeinterface isConnected : ()Z
    //   178: ifeq -> 1280
    //   181: aload_1
    //   182: getfield zzfzv : Ljava/util/Map;
    //   185: invokeinterface size : ()I
    //   190: ifne -> 1280
    //   193: aload_1
    //   194: getfield zzfzt : Lcom/google/android/gms/common/api/internal/zzae;
    //   197: astore #8
    //   199: aload #8
    //   201: getfield zzfww : Ljava/util/Map;
    //   204: invokeinterface isEmpty : ()Z
    //   209: ifeq -> 231
    //   212: aload #8
    //   214: getfield zzfwx : Ljava/util/Map;
    //   217: invokeinterface isEmpty : ()Z
    //   222: ifne -> 228
    //   225: goto -> 231
    //   228: goto -> 233
    //   231: iconst_1
    //   232: istore_2
    //   233: iload_2
    //   234: ifeq -> 243
    //   237: aload_1
    //   238: invokevirtual zzakl : ()V
    //   241: iconst_1
    //   242: ireturn
    //   243: aload_1
    //   244: getfield zzfwd : Lcom/google/android/gms/common/api/Api$zze;
    //   247: invokeinterface disconnect : ()V
    //   252: iconst_1
    //   253: ireturn
    //   254: aload_0
    //   255: getfield zzfwg : Ljava/util/Map;
    //   258: aload_1
    //   259: getfield obj : Ljava/lang/Object;
    //   262: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   267: ifeq -> 1280
    //   270: aload_0
    //   271: getfield zzfwg : Ljava/util/Map;
    //   274: aload_1
    //   275: getfield obj : Ljava/lang/Object;
    //   278: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   283: checkcast com/google/android/gms/common/api/internal/zzbo
    //   286: astore #8
    //   288: aload #8
    //   290: getfield zzfzq : Lcom/google/android/gms/common/api/internal/zzbm;
    //   293: getfield mHandler : Landroid/os/Handler;
    //   296: invokestatic zza : (Landroid/os/Handler;)V
    //   299: aload #8
    //   301: getfield zzfye : Z
    //   304: ifeq -> 1280
    //   307: aload #8
    //   309: invokevirtual zzakk : ()V
    //   312: aload #8
    //   314: getfield zzfzq : Lcom/google/android/gms/common/api/internal/zzbm;
    //   317: getfield zzftg : Lcom/google/android/gms/common/GoogleApiAvailability;
    //   320: aload #8
    //   322: getfield zzfzq : Lcom/google/android/gms/common/api/internal/zzbm;
    //   325: getfield mContext : Landroid/content/Context;
    //   328: invokevirtual isGooglePlayServicesAvailable : (Landroid/content/Context;)I
    //   331: bipush #18
    //   333: if_icmpne -> 352
    //   336: new com/google/android/gms/common/api/Status
    //   339: dup
    //   340: bipush #8
    //   342: ldc_w 'Connection timed out while waiting for Google Play services update to complete.'
    //   345: invokespecial <init> : (ILjava/lang/String;)V
    //   348: astore_1
    //   349: goto -> 365
    //   352: new com/google/android/gms/common/api/Status
    //   355: dup
    //   356: bipush #8
    //   358: ldc_w 'API failed to connect while resuming due to an unknown error.'
    //   361: invokespecial <init> : (ILjava/lang/String;)V
    //   364: astore_1
    //   365: aload #8
    //   367: aload_1
    //   368: invokevirtual zzw : (Lcom/google/android/gms/common/api/Status;)V
    //   371: aload #8
    //   373: getfield zzfwd : Lcom/google/android/gms/common/api/Api$zze;
    //   376: invokeinterface disconnect : ()V
    //   381: iconst_1
    //   382: ireturn
    //   383: aload_0
    //   384: invokespecial zzakb : ()V
    //   387: iconst_1
    //   388: ireturn
    //   389: aload_0
    //   390: getfield zzfwg : Ljava/util/Map;
    //   393: aload_1
    //   394: getfield obj : Ljava/lang/Object;
    //   397: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   402: ifeq -> 1280
    //   405: aload_0
    //   406: getfield zzfwg : Ljava/util/Map;
    //   409: aload_1
    //   410: getfield obj : Ljava/lang/Object;
    //   413: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   418: checkcast com/google/android/gms/common/api/internal/zzbo
    //   421: astore_1
    //   422: aload_1
    //   423: getfield zzfzq : Lcom/google/android/gms/common/api/internal/zzbm;
    //   426: getfield mHandler : Landroid/os/Handler;
    //   429: invokestatic zza : (Landroid/os/Handler;)V
    //   432: aload_1
    //   433: getfield zzfye : Z
    //   436: ifeq -> 1280
    //   439: aload_1
    //   440: invokevirtual connect : ()V
    //   443: iconst_1
    //   444: ireturn
    //   445: aload_0
    //   446: aload_1
    //   447: getfield obj : Ljava/lang/Object;
    //   450: checkcast com/google/android/gms/common/api/GoogleApi
    //   453: invokespecial zzb : (Lcom/google/android/gms/common/api/GoogleApi;)V
    //   456: iconst_1
    //   457: ireturn
    //   458: aload_0
    //   459: getfield mContext : Landroid/content/Context;
    //   462: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   465: instanceof android/app/Application
    //   468: ifeq -> 1280
    //   471: aload_0
    //   472: getfield mContext : Landroid/content/Context;
    //   475: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   478: checkcast android/app/Application
    //   481: invokestatic zza : (Landroid/app/Application;)V
    //   484: invokestatic zzaij : ()Lcom/google/android/gms/common/api/internal/zzk;
    //   487: astore #8
    //   489: new com/google/android/gms/common/api/internal/zzbn
    //   492: dup
    //   493: aload_0
    //   494: invokespecial <init> : (Lcom/google/android/gms/common/api/internal/zzbm;)V
    //   497: astore #9
    //   499: getstatic com/google/android/gms/common/api/internal/zzk.zzfuo : Lcom/google/android/gms/common/api/internal/zzk;
    //   502: astore_1
    //   503: aload_1
    //   504: monitorenter
    //   505: aload #8
    //   507: getfield zzfur : Ljava/util/ArrayList;
    //   510: aload #9
    //   512: invokevirtual add : (Ljava/lang/Object;)Z
    //   515: pop
    //   516: aload_1
    //   517: monitorexit
    //   518: invokestatic zzaij : ()Lcom/google/android/gms/common/api/internal/zzk;
    //   521: astore_1
    //   522: aload_1
    //   523: getfield zzfuq : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   526: invokevirtual get : ()Z
    //   529: ifne -> 603
    //   532: getstatic android/os/Build$VERSION.SDK_INT : I
    //   535: bipush #16
    //   537: if_icmplt -> 545
    //   540: iconst_1
    //   541: istore_2
    //   542: goto -> 547
    //   545: iload_3
    //   546: istore_2
    //   547: iload_2
    //   548: ifeq -> 597
    //   551: new android/app/ActivityManager$RunningAppProcessInfo
    //   554: dup
    //   555: invokespecial <init> : ()V
    //   558: astore #8
    //   560: aload #8
    //   562: invokestatic getMyMemoryState : (Landroid/app/ActivityManager$RunningAppProcessInfo;)V
    //   565: aload_1
    //   566: getfield zzfuq : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   569: iconst_1
    //   570: invokevirtual getAndSet : (Z)Z
    //   573: ifne -> 603
    //   576: aload #8
    //   578: getfield importance : I
    //   581: bipush #100
    //   583: if_icmple -> 603
    //   586: aload_1
    //   587: getfield zzfup : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   590: iconst_1
    //   591: invokevirtual set : (Z)V
    //   594: goto -> 603
    //   597: iconst_1
    //   598: istore #7
    //   600: goto -> 612
    //   603: aload_1
    //   604: getfield zzfup : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   607: invokevirtual get : ()Z
    //   610: istore #7
    //   612: iload #7
    //   614: ifne -> 1280
    //   617: aload_0
    //   618: ldc2_w 300000
    //   621: putfield zzfzi : J
    //   624: iconst_1
    //   625: ireturn
    //   626: astore #8
    //   628: aload_1
    //   629: monitorexit
    //   630: aload #8
    //   632: athrow
    //   633: aload_1
    //   634: getfield arg1 : I
    //   637: istore_2
    //   638: aload_1
    //   639: getfield obj : Ljava/lang/Object;
    //   642: checkcast com/google/android/gms/common/ConnectionResult
    //   645: astore #8
    //   647: aload_0
    //   648: getfield zzfwg : Ljava/util/Map;
    //   651: invokeinterface values : ()Ljava/util/Collection;
    //   656: invokeinterface iterator : ()Ljava/util/Iterator;
    //   661: astore #9
    //   663: aload #9
    //   665: invokeinterface hasNext : ()Z
    //   670: ifeq -> 695
    //   673: aload #9
    //   675: invokeinterface next : ()Ljava/lang/Object;
    //   680: checkcast com/google/android/gms/common/api/internal/zzbo
    //   683: astore_1
    //   684: aload_1
    //   685: getfield zzfzw : I
    //   688: iload_2
    //   689: if_icmpne -> 663
    //   692: goto -> 697
    //   695: aconst_null
    //   696: astore_1
    //   697: aload_1
    //   698: ifnull -> 805
    //   701: aload_0
    //   702: getfield zzftg : Lcom/google/android/gms/common/GoogleApiAvailability;
    //   705: aload #8
    //   707: getfield zzcc : I
    //   710: invokevirtual getErrorString : (I)Ljava/lang/String;
    //   713: astore #9
    //   715: aload #8
    //   717: getfield zzfqu : Ljava/lang/String;
    //   720: astore #8
    //   722: new java/lang/StringBuilder
    //   725: dup
    //   726: aload #9
    //   728: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   731: invokevirtual length : ()I
    //   734: bipush #69
    //   736: iadd
    //   737: aload #8
    //   739: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   742: invokevirtual length : ()I
    //   745: iadd
    //   746: invokespecial <init> : (I)V
    //   749: astore #10
    //   751: aload #10
    //   753: ldc_w 'Error resolution was canceled by the user, original error message: '
    //   756: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   759: pop
    //   760: aload #10
    //   762: aload #9
    //   764: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   767: pop
    //   768: aload #10
    //   770: ldc_w ': '
    //   773: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   776: pop
    //   777: aload #10
    //   779: aload #8
    //   781: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   784: pop
    //   785: aload_1
    //   786: new com/google/android/gms/common/api/Status
    //   789: dup
    //   790: bipush #17
    //   792: aload #10
    //   794: invokevirtual toString : ()Ljava/lang/String;
    //   797: invokespecial <init> : (ILjava/lang/String;)V
    //   800: invokevirtual zzw : (Lcom/google/android/gms/common/api/Status;)V
    //   803: iconst_1
    //   804: ireturn
    //   805: new java/lang/StringBuilder
    //   808: dup
    //   809: bipush #76
    //   811: invokespecial <init> : (I)V
    //   814: astore_1
    //   815: aload_1
    //   816: ldc_w 'Could not find API instance '
    //   819: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   822: pop
    //   823: aload_1
    //   824: iload_2
    //   825: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   828: pop
    //   829: aload_1
    //   830: ldc_w ' while trying to fail enqueued calls.'
    //   833: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   836: pop
    //   837: ldc_w 'GoogleApiManager'
    //   840: aload_1
    //   841: invokevirtual toString : ()Ljava/lang/String;
    //   844: new java/lang/Exception
    //   847: dup
    //   848: invokespecial <init> : ()V
    //   851: invokestatic wtf : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   854: pop
    //   855: iconst_1
    //   856: ireturn
    //   857: aload_1
    //   858: getfield obj : Ljava/lang/Object;
    //   861: checkcast com/google/android/gms/common/api/internal/zzcp
    //   864: astore #9
    //   866: aload_0
    //   867: getfield zzfwg : Ljava/util/Map;
    //   870: aload #9
    //   872: getfield zzgba : Lcom/google/android/gms/common/api/GoogleApi;
    //   875: getfield zzfsn : Lcom/google/android/gms/common/api/internal/zzh;
    //   878: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   883: checkcast com/google/android/gms/common/api/internal/zzbo
    //   886: astore #8
    //   888: aload #8
    //   890: astore_1
    //   891: aload #8
    //   893: ifnonnull -> 926
    //   896: aload_0
    //   897: aload #9
    //   899: getfield zzgba : Lcom/google/android/gms/common/api/GoogleApi;
    //   902: invokespecial zzb : (Lcom/google/android/gms/common/api/GoogleApi;)V
    //   905: aload_0
    //   906: getfield zzfwg : Ljava/util/Map;
    //   909: aload #9
    //   911: getfield zzgba : Lcom/google/android/gms/common/api/GoogleApi;
    //   914: getfield zzfsn : Lcom/google/android/gms/common/api/internal/zzh;
    //   917: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   922: checkcast com/google/android/gms/common/api/internal/zzbo
    //   925: astore_1
    //   926: aload_1
    //   927: invokevirtual zzacc : ()Z
    //   930: ifeq -> 965
    //   933: aload_0
    //   934: getfield zzfzm : Ljava/util/concurrent/atomic/AtomicInteger;
    //   937: invokevirtual get : ()I
    //   940: aload #9
    //   942: getfield zzgaz : I
    //   945: if_icmpeq -> 965
    //   948: aload #9
    //   950: getfield zzgay : Lcom/google/android/gms/common/api/internal/zza;
    //   953: getstatic com/google/android/gms/common/api/internal/zzbm.zzfzg : Lcom/google/android/gms/common/api/Status;
    //   956: invokevirtual zzs : (Lcom/google/android/gms/common/api/Status;)V
    //   959: aload_1
    //   960: invokevirtual signOut : ()V
    //   963: iconst_1
    //   964: ireturn
    //   965: aload_1
    //   966: aload #9
    //   968: getfield zzgay : Lcom/google/android/gms/common/api/internal/zza;
    //   971: invokevirtual zza : (Lcom/google/android/gms/common/api/internal/zza;)V
    //   974: iconst_1
    //   975: ireturn
    //   976: aload_0
    //   977: getfield zzfwg : Ljava/util/Map;
    //   980: invokeinterface values : ()Ljava/util/Collection;
    //   985: invokeinterface iterator : ()Ljava/util/Iterator;
    //   990: astore_1
    //   991: aload_1
    //   992: invokeinterface hasNext : ()Z
    //   997: ifeq -> 1280
    //   1000: aload_1
    //   1001: invokeinterface next : ()Ljava/lang/Object;
    //   1006: checkcast com/google/android/gms/common/api/internal/zzbo
    //   1009: astore #8
    //   1011: aload #8
    //   1013: invokevirtual zzaki : ()V
    //   1016: aload #8
    //   1018: invokevirtual connect : ()V
    //   1021: goto -> 991
    //   1024: aload_1
    //   1025: getfield obj : Ljava/lang/Object;
    //   1028: checkcast com/google/android/gms/common/api/internal/zzj
    //   1031: astore_1
    //   1032: aload_1
    //   1033: getfield zzfse : Landroid/support/v4/util/ArrayMap;
    //   1036: invokevirtual keySet : ()Ljava/util/Set;
    //   1039: invokeinterface iterator : ()Ljava/util/Iterator;
    //   1044: astore #8
    //   1046: aload #8
    //   1048: invokeinterface hasNext : ()Z
    //   1053: ifeq -> 1280
    //   1056: aload #8
    //   1058: invokeinterface next : ()Ljava/lang/Object;
    //   1063: checkcast com/google/android/gms/common/api/internal/zzh
    //   1066: astore #9
    //   1068: aload_0
    //   1069: getfield zzfwg : Ljava/util/Map;
    //   1072: aload #9
    //   1074: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1079: checkcast com/google/android/gms/common/api/internal/zzbo
    //   1082: astore #10
    //   1084: aload #10
    //   1086: ifnonnull -> 1107
    //   1089: aload_1
    //   1090: aload #9
    //   1092: new com/google/android/gms/common/ConnectionResult
    //   1095: dup
    //   1096: bipush #13
    //   1098: invokespecial <init> : (I)V
    //   1101: aconst_null
    //   1102: invokevirtual zza : (Lcom/google/android/gms/common/api/internal/zzh;Lcom/google/android/gms/common/ConnectionResult;Ljava/lang/String;)V
    //   1105: iconst_1
    //   1106: ireturn
    //   1107: aload #10
    //   1109: invokevirtual isConnected : ()Z
    //   1112: ifeq -> 1137
    //   1115: aload_1
    //   1116: aload #9
    //   1118: getstatic com/google/android/gms/common/ConnectionResult.zzfqt : Lcom/google/android/gms/common/ConnectionResult;
    //   1121: aload #10
    //   1123: getfield zzfwd : Lcom/google/android/gms/common/api/Api$zze;
    //   1126: invokeinterface zzahp : ()Ljava/lang/String;
    //   1131: invokevirtual zza : (Lcom/google/android/gms/common/api/internal/zzh;Lcom/google/android/gms/common/ConnectionResult;Ljava/lang/String;)V
    //   1134: goto -> 1046
    //   1137: aload #10
    //   1139: invokevirtual zzakj : ()Lcom/google/android/gms/common/ConnectionResult;
    //   1142: ifnull -> 1160
    //   1145: aload_1
    //   1146: aload #9
    //   1148: aload #10
    //   1150: invokevirtual zzakj : ()Lcom/google/android/gms/common/ConnectionResult;
    //   1153: aconst_null
    //   1154: invokevirtual zza : (Lcom/google/android/gms/common/api/internal/zzh;Lcom/google/android/gms/common/ConnectionResult;Ljava/lang/String;)V
    //   1157: goto -> 1046
    //   1160: aload #10
    //   1162: getfield zzfzq : Lcom/google/android/gms/common/api/internal/zzbm;
    //   1165: getfield mHandler : Landroid/os/Handler;
    //   1168: invokestatic zza : (Landroid/os/Handler;)V
    //   1171: aload #10
    //   1173: getfield zzfzu : Ljava/util/Set;
    //   1176: aload_1
    //   1177: invokeinterface add : (Ljava/lang/Object;)Z
    //   1182: pop
    //   1183: goto -> 1046
    //   1186: aload_1
    //   1187: getfield obj : Ljava/lang/Object;
    //   1190: checkcast java/lang/Boolean
    //   1193: invokevirtual booleanValue : ()Z
    //   1196: ifeq -> 1204
    //   1199: ldc2_w 10000
    //   1202: lstore #5
    //   1204: aload_0
    //   1205: lload #5
    //   1207: putfield zzfzi : J
    //   1210: aload_0
    //   1211: getfield mHandler : Landroid/os/Handler;
    //   1214: bipush #12
    //   1216: invokevirtual removeMessages : (I)V
    //   1219: aload_0
    //   1220: getfield zzfwg : Ljava/util/Map;
    //   1223: invokeinterface keySet : ()Ljava/util/Set;
    //   1228: invokeinterface iterator : ()Ljava/util/Iterator;
    //   1233: astore_1
    //   1234: aload_1
    //   1235: invokeinterface hasNext : ()Z
    //   1240: ifeq -> 1280
    //   1243: aload_1
    //   1244: invokeinterface next : ()Ljava/lang/Object;
    //   1249: checkcast com/google/android/gms/common/api/internal/zzh
    //   1252: astore #8
    //   1254: aload_0
    //   1255: getfield mHandler : Landroid/os/Handler;
    //   1258: aload_0
    //   1259: getfield mHandler : Landroid/os/Handler;
    //   1262: bipush #12
    //   1264: aload #8
    //   1266: invokevirtual obtainMessage : (ILjava/lang/Object;)Landroid/os/Message;
    //   1269: aload_0
    //   1270: getfield zzfzi : J
    //   1273: invokevirtual sendMessageDelayed : (Landroid/os/Message;J)Z
    //   1276: pop
    //   1277: goto -> 1234
    //   1280: iconst_1
    //   1281: ireturn
    // Exception table:
    //   from	to	target	type
    //   505	518	626	finally
    //   628	630	626	finally
  }
  
  public final void zza(ConnectionResult paramConnectionResult, int paramInt) {
    if (!zzc(paramConnectionResult, paramInt))
      this.mHandler.sendMessage(this.mHandler.obtainMessage(5, paramInt, 0, paramConnectionResult)); 
  }
  
  public final void zzaih() {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
  }
  
  final boolean zzc(ConnectionResult paramConnectionResult, int paramInt) {
    PendingIntent pendingIntent;
    GoogleApiAvailability googleApiAvailability = this.zzftg;
    Context context = this.mContext;
    if (paramConnectionResult.hasResolution()) {
      pendingIntent = paramConnectionResult.zzekd;
    } else {
      pendingIntent = googleApiAvailability.getErrorResolutionPendingIntent(context, paramConnectionResult.zzcc, 0);
    } 
    if (pendingIntent != null) {
      googleApiAvailability.zza$53da80fe(context, paramConnectionResult.zzcc, GoogleApiActivity.zza(context, pendingIntent, paramInt));
      return true;
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzbm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */