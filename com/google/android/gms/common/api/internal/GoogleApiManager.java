package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zal;
import com.google.android.gms.common.internal.zaz;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.internal.base.zap;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public class GoogleApiManager implements Handler.Callback {
  public static final Status zaa = new Status(4, "Sign-out occurred while this API call was in progress.");
  
  private static final Status zab = new Status(4, "The user must be signed in to make this API call.");
  
  private static final Object zaf = new Object();
  
  private static GoogleApiManager zag;
  
  private long zac = 5000L;
  
  private long zad = 120000L;
  
  private long zae = 10000L;
  
  private final Context zah;
  
  private final GoogleApiAvailability zai;
  
  private final zal zaj;
  
  private final AtomicInteger zak = new AtomicInteger(1);
  
  private final AtomicInteger zal = new AtomicInteger(0);
  
  private final Map<ApiKey<?>, zaa<?>> zam = new ConcurrentHashMap<ApiKey<?>, zaa<?>>(5, 0.75F, 1);
  
  private zay zan = null;
  
  private final Set<ApiKey<?>> zao = (Set<ApiKey<?>>)new ArraySet();
  
  private final Set<ApiKey<?>> zap = (Set<ApiKey<?>>)new ArraySet();
  
  @NotOnlyInitialized
  private final Handler zaq;
  
  private volatile boolean zar = true;
  
  private GoogleApiManager(Context paramContext, Looper paramLooper, GoogleApiAvailability paramGoogleApiAvailability) {
    this.zah = paramContext;
    this.zaq = (Handler)new zap(paramLooper, this);
    this.zai = paramGoogleApiAvailability;
    this.zaj = new zal((GoogleApiAvailabilityLight)paramGoogleApiAvailability);
    if (DeviceProperties.isAuto(paramContext))
      this.zar = false; 
    Handler handler = this.zaq;
    handler.sendMessage(handler.obtainMessage(6));
  }
  
  public static void reportSignOut() {
    synchronized (zaf) {
      if (zag != null) {
        GoogleApiManager googleApiManager = zag;
        googleApiManager.zal.incrementAndGet();
        googleApiManager.zaq.sendMessageAtFrontOfQueue(googleApiManager.zaq.obtainMessage(10));
      } 
      return;
    } 
  }
  
  public static GoogleApiManager zaa() {
    synchronized (zaf) {
      Preconditions.checkNotNull(zag, "Must guarantee manager is non-null before using getInstance");
      return zag;
    } 
  }
  
  public static GoogleApiManager zaa(Context paramContext) {
    synchronized (zaf) {
      if (zag == null) {
        HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        zag = new GoogleApiManager(paramContext.getApplicationContext(), looper, GoogleApiAvailability.getInstance());
      } 
      return zag;
    } 
  }
  
  private final zaa<?> zac(GoogleApi<?> paramGoogleApi) {
    ApiKey<?> apiKey = paramGoogleApi.getApiKey();
    zaa<?> zaa2 = this.zam.get(apiKey);
    zaa<?> zaa1 = zaa2;
    if (zaa2 == null) {
      zaa1 = new zaa(this, paramGoogleApi);
      this.zam.put(apiKey, zaa1);
    } 
    if (zaa1.zak())
      this.zap.add(apiKey); 
    zaa1.zai();
    return zaa1;
  }
  
  public boolean handleMessage(Message paramMessage) {
    // Byte code:
    //   0: aload_1
    //   1: getfield what : I
    //   4: istore_2
    //   5: ldc2_w 300000
    //   8: lstore_3
    //   9: iload_2
    //   10: tableswitch default -> 88, 1 -> 1070, 2 -> 922, 3 -> 874, 4 -> 775, 5 -> 551, 6 -> 492, 7 -> 478, 8 -> 775, 9 -> 441, 10 -> 371, 11 -> 334, 12 -> 296, 13 -> 775, 14 -> 221, 15 -> 175, 16 -> 129
    //   88: aload_1
    //   89: getfield what : I
    //   92: istore_2
    //   93: new java/lang/StringBuilder
    //   96: dup
    //   97: bipush #31
    //   99: invokespecial <init> : (I)V
    //   102: astore_1
    //   103: aload_1
    //   104: ldc 'Unknown message id: '
    //   106: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload_1
    //   111: iload_2
    //   112: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: ldc_w 'GoogleApiManager'
    //   119: aload_1
    //   120: invokevirtual toString : ()Ljava/lang/String;
    //   123: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   126: pop
    //   127: iconst_0
    //   128: ireturn
    //   129: aload_1
    //   130: getfield obj : Ljava/lang/Object;
    //   133: checkcast com/google/android/gms/common/api/internal/GoogleApiManager$zac
    //   136: astore_1
    //   137: aload_0
    //   138: getfield zam : Ljava/util/Map;
    //   141: aload_1
    //   142: invokestatic zaa : (Lcom/google/android/gms/common/api/internal/GoogleApiManager$zac;)Lcom/google/android/gms/common/api/internal/ApiKey;
    //   145: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   150: ifeq -> 1164
    //   153: aload_0
    //   154: getfield zam : Ljava/util/Map;
    //   157: aload_1
    //   158: invokestatic zaa : (Lcom/google/android/gms/common/api/internal/GoogleApiManager$zac;)Lcom/google/android/gms/common/api/internal/ApiKey;
    //   161: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   166: checkcast com/google/android/gms/common/api/internal/GoogleApiManager$zaa
    //   169: aload_1
    //   170: invokestatic zab : (Lcom/google/android/gms/common/api/internal/GoogleApiManager$zaa;Lcom/google/android/gms/common/api/internal/GoogleApiManager$zac;)V
    //   173: iconst_1
    //   174: ireturn
    //   175: aload_1
    //   176: getfield obj : Ljava/lang/Object;
    //   179: checkcast com/google/android/gms/common/api/internal/GoogleApiManager$zac
    //   182: astore_1
    //   183: aload_0
    //   184: getfield zam : Ljava/util/Map;
    //   187: aload_1
    //   188: invokestatic zaa : (Lcom/google/android/gms/common/api/internal/GoogleApiManager$zac;)Lcom/google/android/gms/common/api/internal/ApiKey;
    //   191: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   196: ifeq -> 1164
    //   199: aload_0
    //   200: getfield zam : Ljava/util/Map;
    //   203: aload_1
    //   204: invokestatic zaa : (Lcom/google/android/gms/common/api/internal/GoogleApiManager$zac;)Lcom/google/android/gms/common/api/internal/ApiKey;
    //   207: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   212: checkcast com/google/android/gms/common/api/internal/GoogleApiManager$zaa
    //   215: aload_1
    //   216: invokestatic zaa : (Lcom/google/android/gms/common/api/internal/GoogleApiManager$zaa;Lcom/google/android/gms/common/api/internal/GoogleApiManager$zac;)V
    //   219: iconst_1
    //   220: ireturn
    //   221: aload_1
    //   222: getfield obj : Ljava/lang/Object;
    //   225: checkcast com/google/android/gms/common/api/internal/zaz
    //   228: astore_1
    //   229: aload_1
    //   230: invokevirtual zaa : ()Lcom/google/android/gms/common/api/internal/ApiKey;
    //   233: astore #6
    //   235: aload_0
    //   236: getfield zam : Ljava/util/Map;
    //   239: aload #6
    //   241: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   246: ifne -> 262
    //   249: aload_1
    //   250: invokevirtual zab : ()Lcom/google/android/gms/tasks/TaskCompletionSource;
    //   253: iconst_0
    //   254: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   257: invokevirtual setResult : (Ljava/lang/Object;)V
    //   260: iconst_1
    //   261: ireturn
    //   262: aload_0
    //   263: getfield zam : Ljava/util/Map;
    //   266: aload #6
    //   268: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   273: checkcast com/google/android/gms/common/api/internal/GoogleApiManager$zaa
    //   276: iconst_0
    //   277: invokestatic zaa : (Lcom/google/android/gms/common/api/internal/GoogleApiManager$zaa;Z)Z
    //   280: istore #5
    //   282: aload_1
    //   283: invokevirtual zab : ()Lcom/google/android/gms/tasks/TaskCompletionSource;
    //   286: iload #5
    //   288: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   291: invokevirtual setResult : (Ljava/lang/Object;)V
    //   294: iconst_1
    //   295: ireturn
    //   296: aload_0
    //   297: getfield zam : Ljava/util/Map;
    //   300: aload_1
    //   301: getfield obj : Ljava/lang/Object;
    //   304: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   309: ifeq -> 1164
    //   312: aload_0
    //   313: getfield zam : Ljava/util/Map;
    //   316: aload_1
    //   317: getfield obj : Ljava/lang/Object;
    //   320: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   325: checkcast com/google/android/gms/common/api/internal/GoogleApiManager$zaa
    //   328: invokevirtual zah : ()Z
    //   331: pop
    //   332: iconst_1
    //   333: ireturn
    //   334: aload_0
    //   335: getfield zam : Ljava/util/Map;
    //   338: aload_1
    //   339: getfield obj : Ljava/lang/Object;
    //   342: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   347: ifeq -> 1164
    //   350: aload_0
    //   351: getfield zam : Ljava/util/Map;
    //   354: aload_1
    //   355: getfield obj : Ljava/lang/Object;
    //   358: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   363: checkcast com/google/android/gms/common/api/internal/GoogleApiManager$zaa
    //   366: invokevirtual zag : ()V
    //   369: iconst_1
    //   370: ireturn
    //   371: aload_0
    //   372: getfield zap : Ljava/util/Set;
    //   375: invokeinterface iterator : ()Ljava/util/Iterator;
    //   380: astore_1
    //   381: aload_1
    //   382: invokeinterface hasNext : ()Z
    //   387: ifeq -> 430
    //   390: aload_1
    //   391: invokeinterface next : ()Ljava/lang/Object;
    //   396: checkcast com/google/android/gms/common/api/internal/ApiKey
    //   399: astore #6
    //   401: aload_0
    //   402: getfield zam : Ljava/util/Map;
    //   405: aload #6
    //   407: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   412: checkcast com/google/android/gms/common/api/internal/GoogleApiManager$zaa
    //   415: astore #6
    //   417: aload #6
    //   419: ifnull -> 381
    //   422: aload #6
    //   424: invokevirtual zaa : ()V
    //   427: goto -> 381
    //   430: aload_0
    //   431: getfield zap : Ljava/util/Set;
    //   434: invokeinterface clear : ()V
    //   439: iconst_1
    //   440: ireturn
    //   441: aload_0
    //   442: getfield zam : Ljava/util/Map;
    //   445: aload_1
    //   446: getfield obj : Ljava/lang/Object;
    //   449: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   454: ifeq -> 1164
    //   457: aload_0
    //   458: getfield zam : Ljava/util/Map;
    //   461: aload_1
    //   462: getfield obj : Ljava/lang/Object;
    //   465: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   470: checkcast com/google/android/gms/common/api/internal/GoogleApiManager$zaa
    //   473: invokevirtual zaf : ()V
    //   476: iconst_1
    //   477: ireturn
    //   478: aload_0
    //   479: aload_1
    //   480: getfield obj : Ljava/lang/Object;
    //   483: checkcast com/google/android/gms/common/api/GoogleApi
    //   486: invokespecial zac : (Lcom/google/android/gms/common/api/GoogleApi;)Lcom/google/android/gms/common/api/internal/GoogleApiManager$zaa;
    //   489: pop
    //   490: iconst_1
    //   491: ireturn
    //   492: aload_0
    //   493: getfield zah : Landroid/content/Context;
    //   496: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   499: instanceof android/app/Application
    //   502: ifeq -> 1164
    //   505: aload_0
    //   506: getfield zah : Landroid/content/Context;
    //   509: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   512: checkcast android/app/Application
    //   515: invokestatic initialize : (Landroid/app/Application;)V
    //   518: invokestatic getInstance : ()Lcom/google/android/gms/common/api/internal/BackgroundDetector;
    //   521: new com/google/android/gms/common/api/internal/zabc
    //   524: dup
    //   525: aload_0
    //   526: invokespecial <init> : (Lcom/google/android/gms/common/api/internal/GoogleApiManager;)V
    //   529: invokevirtual addListener : (Lcom/google/android/gms/common/api/internal/BackgroundDetector$BackgroundStateChangeListener;)V
    //   532: invokestatic getInstance : ()Lcom/google/android/gms/common/api/internal/BackgroundDetector;
    //   535: iconst_1
    //   536: invokevirtual readCurrentStateIfPossible : (Z)Z
    //   539: ifne -> 1164
    //   542: aload_0
    //   543: ldc2_w 300000
    //   546: putfield zae : J
    //   549: iconst_1
    //   550: ireturn
    //   551: aload_1
    //   552: getfield arg1 : I
    //   555: istore_2
    //   556: aload_1
    //   557: getfield obj : Ljava/lang/Object;
    //   560: checkcast com/google/android/gms/common/ConnectionResult
    //   563: astore #6
    //   565: aload_0
    //   566: getfield zam : Ljava/util/Map;
    //   569: invokeinterface values : ()Ljava/util/Collection;
    //   574: invokeinterface iterator : ()Ljava/util/Iterator;
    //   579: astore #7
    //   581: aload #7
    //   583: invokeinterface hasNext : ()Z
    //   588: ifeq -> 613
    //   591: aload #7
    //   593: invokeinterface next : ()Ljava/lang/Object;
    //   598: checkcast com/google/android/gms/common/api/internal/GoogleApiManager$zaa
    //   601: astore_1
    //   602: aload_1
    //   603: invokevirtual zal : ()I
    //   606: iload_2
    //   607: if_icmpne -> 581
    //   610: goto -> 615
    //   613: aconst_null
    //   614: astore_1
    //   615: aload_1
    //   616: ifnull -> 723
    //   619: aload_0
    //   620: getfield zai : Lcom/google/android/gms/common/GoogleApiAvailability;
    //   623: aload #6
    //   625: invokevirtual getErrorCode : ()I
    //   628: invokevirtual getErrorString : (I)Ljava/lang/String;
    //   631: astore #7
    //   633: aload #6
    //   635: invokevirtual getErrorMessage : ()Ljava/lang/String;
    //   638: astore #6
    //   640: new java/lang/StringBuilder
    //   643: dup
    //   644: aload #7
    //   646: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   649: invokevirtual length : ()I
    //   652: bipush #69
    //   654: iadd
    //   655: aload #6
    //   657: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   660: invokevirtual length : ()I
    //   663: iadd
    //   664: invokespecial <init> : (I)V
    //   667: astore #8
    //   669: aload #8
    //   671: ldc_w 'Error resolution was canceled by the user, original error message: '
    //   674: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   677: pop
    //   678: aload #8
    //   680: aload #7
    //   682: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: pop
    //   686: aload #8
    //   688: ldc_w ': '
    //   691: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   694: pop
    //   695: aload #8
    //   697: aload #6
    //   699: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: pop
    //   703: aload_1
    //   704: new com/google/android/gms/common/api/Status
    //   707: dup
    //   708: bipush #17
    //   710: aload #8
    //   712: invokevirtual toString : ()Ljava/lang/String;
    //   715: invokespecial <init> : (ILjava/lang/String;)V
    //   718: invokestatic zaa : (Lcom/google/android/gms/common/api/internal/GoogleApiManager$zaa;Lcom/google/android/gms/common/api/Status;)V
    //   721: iconst_1
    //   722: ireturn
    //   723: new java/lang/StringBuilder
    //   726: dup
    //   727: bipush #76
    //   729: invokespecial <init> : (I)V
    //   732: astore_1
    //   733: aload_1
    //   734: ldc_w 'Could not find API instance '
    //   737: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: pop
    //   741: aload_1
    //   742: iload_2
    //   743: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   746: pop
    //   747: aload_1
    //   748: ldc_w ' while trying to fail enqueued calls.'
    //   751: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   754: pop
    //   755: ldc_w 'GoogleApiManager'
    //   758: aload_1
    //   759: invokevirtual toString : ()Ljava/lang/String;
    //   762: new java/lang/Exception
    //   765: dup
    //   766: invokespecial <init> : ()V
    //   769: invokestatic wtf : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   772: pop
    //   773: iconst_1
    //   774: ireturn
    //   775: aload_1
    //   776: getfield obj : Ljava/lang/Object;
    //   779: checkcast com/google/android/gms/common/api/internal/zabr
    //   782: astore #7
    //   784: aload_0
    //   785: getfield zam : Ljava/util/Map;
    //   788: aload #7
    //   790: getfield zac : Lcom/google/android/gms/common/api/GoogleApi;
    //   793: invokevirtual getApiKey : ()Lcom/google/android/gms/common/api/internal/ApiKey;
    //   796: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   801: checkcast com/google/android/gms/common/api/internal/GoogleApiManager$zaa
    //   804: astore #6
    //   806: aload #6
    //   808: astore_1
    //   809: aload #6
    //   811: ifnonnull -> 824
    //   814: aload_0
    //   815: aload #7
    //   817: getfield zac : Lcom/google/android/gms/common/api/GoogleApi;
    //   820: invokespecial zac : (Lcom/google/android/gms/common/api/GoogleApi;)Lcom/google/android/gms/common/api/internal/GoogleApiManager$zaa;
    //   823: astore_1
    //   824: aload_1
    //   825: invokevirtual zak : ()Z
    //   828: ifeq -> 863
    //   831: aload_0
    //   832: getfield zal : Ljava/util/concurrent/atomic/AtomicInteger;
    //   835: invokevirtual get : ()I
    //   838: aload #7
    //   840: getfield zab : I
    //   843: if_icmpeq -> 863
    //   846: aload #7
    //   848: getfield zaa : Lcom/google/android/gms/common/api/internal/zab;
    //   851: getstatic com/google/android/gms/common/api/internal/GoogleApiManager.zaa : Lcom/google/android/gms/common/api/Status;
    //   854: invokevirtual zaa : (Lcom/google/android/gms/common/api/Status;)V
    //   857: aload_1
    //   858: invokevirtual zaa : ()V
    //   861: iconst_1
    //   862: ireturn
    //   863: aload_1
    //   864: aload #7
    //   866: getfield zaa : Lcom/google/android/gms/common/api/internal/zab;
    //   869: invokevirtual zaa : (Lcom/google/android/gms/common/api/internal/zab;)V
    //   872: iconst_1
    //   873: ireturn
    //   874: aload_0
    //   875: getfield zam : Ljava/util/Map;
    //   878: invokeinterface values : ()Ljava/util/Collection;
    //   883: invokeinterface iterator : ()Ljava/util/Iterator;
    //   888: astore_1
    //   889: aload_1
    //   890: invokeinterface hasNext : ()Z
    //   895: ifeq -> 1164
    //   898: aload_1
    //   899: invokeinterface next : ()Ljava/lang/Object;
    //   904: checkcast com/google/android/gms/common/api/internal/GoogleApiManager$zaa
    //   907: astore #6
    //   909: aload #6
    //   911: invokevirtual zad : ()V
    //   914: aload #6
    //   916: invokevirtual zai : ()V
    //   919: goto -> 889
    //   922: aload_1
    //   923: getfield obj : Ljava/lang/Object;
    //   926: checkcast com/google/android/gms/common/api/internal/zaj
    //   929: astore_1
    //   930: aload_1
    //   931: invokevirtual zaa : ()Ljava/util/Set;
    //   934: invokeinterface iterator : ()Ljava/util/Iterator;
    //   939: astore #6
    //   941: aload #6
    //   943: invokeinterface hasNext : ()Z
    //   948: ifeq -> 1164
    //   951: aload #6
    //   953: invokeinterface next : ()Ljava/lang/Object;
    //   958: checkcast com/google/android/gms/common/api/internal/ApiKey
    //   961: astore #7
    //   963: aload_0
    //   964: getfield zam : Ljava/util/Map;
    //   967: aload #7
    //   969: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   974: checkcast com/google/android/gms/common/api/internal/GoogleApiManager$zaa
    //   977: astore #8
    //   979: aload #8
    //   981: ifnonnull -> 1002
    //   984: aload_1
    //   985: aload #7
    //   987: new com/google/android/gms/common/ConnectionResult
    //   990: dup
    //   991: bipush #13
    //   993: invokespecial <init> : (I)V
    //   996: aconst_null
    //   997: invokevirtual zaa : (Lcom/google/android/gms/common/api/internal/ApiKey;Lcom/google/android/gms/common/ConnectionResult;Ljava/lang/String;)V
    //   1000: iconst_1
    //   1001: ireturn
    //   1002: aload #8
    //   1004: invokevirtual zaj : ()Z
    //   1007: ifeq -> 1032
    //   1010: aload_1
    //   1011: aload #7
    //   1013: getstatic com/google/android/gms/common/ConnectionResult.RESULT_SUCCESS : Lcom/google/android/gms/common/ConnectionResult;
    //   1016: aload #8
    //   1018: invokevirtual zab : ()Lcom/google/android/gms/common/api/Api$Client;
    //   1021: invokeinterface getEndpointPackageName : ()Ljava/lang/String;
    //   1026: invokevirtual zaa : (Lcom/google/android/gms/common/api/internal/ApiKey;Lcom/google/android/gms/common/ConnectionResult;Ljava/lang/String;)V
    //   1029: goto -> 941
    //   1032: aload #8
    //   1034: invokevirtual zae : ()Lcom/google/android/gms/common/ConnectionResult;
    //   1037: astore #9
    //   1039: aload #9
    //   1041: ifnull -> 1056
    //   1044: aload_1
    //   1045: aload #7
    //   1047: aload #9
    //   1049: aconst_null
    //   1050: invokevirtual zaa : (Lcom/google/android/gms/common/api/internal/ApiKey;Lcom/google/android/gms/common/ConnectionResult;Ljava/lang/String;)V
    //   1053: goto -> 941
    //   1056: aload #8
    //   1058: aload_1
    //   1059: invokevirtual zaa : (Lcom/google/android/gms/common/api/internal/zaj;)V
    //   1062: aload #8
    //   1064: invokevirtual zai : ()V
    //   1067: goto -> 941
    //   1070: aload_1
    //   1071: getfield obj : Ljava/lang/Object;
    //   1074: checkcast java/lang/Boolean
    //   1077: invokevirtual booleanValue : ()Z
    //   1080: ifeq -> 1087
    //   1083: ldc2_w 10000
    //   1086: lstore_3
    //   1087: aload_0
    //   1088: lload_3
    //   1089: putfield zae : J
    //   1092: aload_0
    //   1093: getfield zaq : Landroid/os/Handler;
    //   1096: bipush #12
    //   1098: invokevirtual removeMessages : (I)V
    //   1101: aload_0
    //   1102: getfield zam : Ljava/util/Map;
    //   1105: invokeinterface keySet : ()Ljava/util/Set;
    //   1110: invokeinterface iterator : ()Ljava/util/Iterator;
    //   1115: astore_1
    //   1116: aload_1
    //   1117: invokeinterface hasNext : ()Z
    //   1122: ifeq -> 1164
    //   1125: aload_1
    //   1126: invokeinterface next : ()Ljava/lang/Object;
    //   1131: checkcast com/google/android/gms/common/api/internal/ApiKey
    //   1134: astore #6
    //   1136: aload_0
    //   1137: getfield zaq : Landroid/os/Handler;
    //   1140: astore #7
    //   1142: aload #7
    //   1144: aload #7
    //   1146: bipush #12
    //   1148: aload #6
    //   1150: invokevirtual obtainMessage : (ILjava/lang/Object;)Landroid/os/Message;
    //   1153: aload_0
    //   1154: getfield zae : J
    //   1157: invokevirtual sendMessageDelayed : (Landroid/os/Message;J)Z
    //   1160: pop
    //   1161: goto -> 1116
    //   1164: iconst_1
    //   1165: ireturn
  }
  
  public final <O extends Api.ApiOptions> Task<Boolean> zaa(GoogleApi<O> paramGoogleApi, ListenerHolder.ListenerKey<?> paramListenerKey) {
    TaskCompletionSource<Boolean> taskCompletionSource = new TaskCompletionSource();
    zag zag = new zag(paramListenerKey, taskCompletionSource);
    Handler handler = this.zaq;
    handler.sendMessage(handler.obtainMessage(13, new zabr(zag, this.zal.get(), paramGoogleApi)));
    return taskCompletionSource.getTask();
  }
  
  public final <O extends Api.ApiOptions> Task<Void> zaa(GoogleApi<O> paramGoogleApi, RegisterListenerMethod<Api.AnyClient, ?> paramRegisterListenerMethod, UnregisterListenerMethod<Api.AnyClient, ?> paramUnregisterListenerMethod, Runnable paramRunnable) {
    TaskCompletionSource<Void> taskCompletionSource = new TaskCompletionSource();
    zae zae = new zae(new zabs(paramRegisterListenerMethod, paramUnregisterListenerMethod, paramRunnable), taskCompletionSource);
    Handler handler = this.zaq;
    handler.sendMessage(handler.obtainMessage(8, new zabr(zae, this.zal.get(), paramGoogleApi)));
    return taskCompletionSource.getTask();
  }
  
  public final Task<Map<ApiKey<?>, String>> zaa(Iterable<? extends HasApiKey<?>> paramIterable) {
    zaj zaj = new zaj(paramIterable);
    Handler handler = this.zaq;
    handler.sendMessage(handler.obtainMessage(2, zaj));
    return zaj.zab();
  }
  
  public final void zaa(GoogleApi<?> paramGoogleApi) {
    Handler handler = this.zaq;
    handler.sendMessage(handler.obtainMessage(7, paramGoogleApi));
  }
  
  public final <O extends Api.ApiOptions> void zaa(GoogleApi<O> paramGoogleApi, int paramInt, BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient> paramApiMethodImpl) {
    zaf<BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient>> zaf = new zaf<BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient>>(paramInt, paramApiMethodImpl);
    Handler handler = this.zaq;
    handler.sendMessage(handler.obtainMessage(4, new zabr(zaf, this.zal.get(), paramGoogleApi)));
  }
  
  public final <O extends Api.ApiOptions, ResultT> void zaa(GoogleApi<O> paramGoogleApi, int paramInt, TaskApiCall<Api.AnyClient, ResultT> paramTaskApiCall, TaskCompletionSource<ResultT> paramTaskCompletionSource, StatusExceptionMapper paramStatusExceptionMapper) {
    zah<ResultT> zah = new zah<ResultT>(paramInt, paramTaskApiCall, paramTaskCompletionSource, paramStatusExceptionMapper);
    Handler handler = this.zaq;
    handler.sendMessage(handler.obtainMessage(4, new zabr(zah, this.zal.get(), paramGoogleApi)));
  }
  
  public final void zaa(zay paramzay) {
    synchronized (zaf) {
      if (this.zan != paramzay) {
        this.zan = paramzay;
        this.zao.clear();
      } 
      this.zao.addAll((Collection<? extends ApiKey<?>>)paramzay.zac());
      return;
    } 
  }
  
  final boolean zaa(ConnectionResult paramConnectionResult, int paramInt) {
    return this.zai.zaa(this.zah, paramConnectionResult, paramInt);
  }
  
  public final int zab() {
    return this.zak.getAndIncrement();
  }
  
  public final Task<Boolean> zab(GoogleApi<?> paramGoogleApi) {
    zaz zaz = new zaz(paramGoogleApi.getApiKey());
    Handler handler = this.zaq;
    handler.sendMessage(handler.obtainMessage(14, zaz));
    return zaz.zab().getTask();
  }
  
  public final void zab(ConnectionResult paramConnectionResult, int paramInt) {
    if (!zaa(paramConnectionResult, paramInt)) {
      Handler handler = this.zaq;
      handler.sendMessage(handler.obtainMessage(5, paramInt, 0, paramConnectionResult));
    } 
  }
  
  final void zab(zay paramzay) {
    synchronized (zaf) {
      if (this.zan == paramzay) {
        this.zan = null;
        this.zao.clear();
      } 
      return;
    } 
  }
  
  public final void zac() {
    Handler handler = this.zaq;
    handler.sendMessage(handler.obtainMessage(3));
  }
  
  public final class zaa<O extends Api.ApiOptions> implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, zap {
    private final Queue<zab> zab;
    
    @NotOnlyInitialized
    private final Api.Client zac;
    
    private final Api.AnyClient zad;
    
    private final ApiKey<O> zae;
    
    private final zav zaf;
    
    private final Set<zaj> zag;
    
    private final Map<ListenerHolder.ListenerKey<?>, zabs> zah;
    
    private final int zai;
    
    private final zacc zaj;
    
    private boolean zak;
    
    private final List<GoogleApiManager.zac> zal;
    
    private ConnectionResult zam;
    
    public zaa(GoogleApiManager this$0, GoogleApi<O> param1GoogleApi) {
      zaz zaz;
      this.zab = new LinkedList<zab>();
      this.zag = new HashSet<zaj>();
      this.zah = new HashMap<ListenerHolder.ListenerKey<?>, zabs>();
      this.zal = new ArrayList<GoogleApiManager.zac>();
      this.zam = null;
      this.zac = param1GoogleApi.zaa(GoogleApiManager.zaa(this$0).getLooper(), this);
      Api.Client client = this.zac;
      if (client instanceof zaz) {
        zaz = (zaz)client;
        this.zad = (Api.AnyClient)zaz.zaa();
      } else {
        this.zad = (Api.AnyClient)zaz;
      } 
      this.zae = param1GoogleApi.getApiKey();
      this.zaf = new zav();
      this.zai = param1GoogleApi.zaa();
      if (this.zac.requiresSignIn()) {
        this.zaj = param1GoogleApi.zaa(GoogleApiManager.zab(this$0), GoogleApiManager.zaa(this$0));
        return;
      } 
      this.zaj = null;
    }
    
    private final Feature zaa(Feature[] param1ArrayOfFeature) {
      if (param1ArrayOfFeature != null) {
        if (param1ArrayOfFeature.length == 0)
          return null; 
        Feature[] arrayOfFeature2 = this.zac.getAvailableFeatures();
        boolean bool = false;
        Feature[] arrayOfFeature1 = arrayOfFeature2;
        if (arrayOfFeature2 == null)
          arrayOfFeature1 = new Feature[0]; 
        ArrayMap<String, Long> arrayMap = new ArrayMap(arrayOfFeature1.length);
        int j = arrayOfFeature1.length;
        int i;
        for (i = 0; i < j; i++) {
          Feature feature = arrayOfFeature1[i];
          arrayMap.put(feature.getName(), Long.valueOf(feature.getVersion()));
        } 
        j = param1ArrayOfFeature.length;
        i = bool;
        while (i < j) {
          Feature feature = param1ArrayOfFeature[i];
          Long long_ = arrayMap.get(feature.getName());
          if (long_ != null) {
            if (long_.longValue() < feature.getVersion())
              return feature; 
            i++;
            continue;
          } 
          return feature;
        } 
      } 
      return null;
    }
    
    private final void zaa(int param1Int) {
      zad();
      this.zak = true;
      this.zaf.zaa(param1Int, this.zac.getLastDisconnectMessage());
      GoogleApiManager.zaa(this.zaa).sendMessageDelayed(Message.obtain(GoogleApiManager.zaa(this.zaa), 9, this.zae), GoogleApiManager.zac(this.zaa));
      GoogleApiManager.zaa(this.zaa).sendMessageDelayed(Message.obtain(GoogleApiManager.zaa(this.zaa), 11, this.zae), GoogleApiManager.zad(this.zaa));
      GoogleApiManager.zae(this.zaa).zaa();
      Iterator iterator = this.zah.values().iterator();
      while (iterator.hasNext())
        ((zabs)iterator.next()).zac.run(); 
    }
    
    private final void zaa(ConnectionResult param1ConnectionResult, Exception param1Exception) {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(this.zaa));
      zacc zacc1 = this.zaj;
      if (zacc1 != null)
        zacc1.zaa(); 
      zad();
      GoogleApiManager.zae(this.zaa).zaa();
      zac(param1ConnectionResult);
      if (param1ConnectionResult.getErrorCode() == 4) {
        zaa(GoogleApiManager.zae());
        return;
      } 
      if (this.zab.isEmpty()) {
        this.zam = param1ConnectionResult;
        return;
      } 
      if (param1Exception != null) {
        Preconditions.checkHandlerThread(GoogleApiManager.zaa(this.zaa));
        zaa((Status)null, param1Exception, false);
        return;
      } 
      if (!GoogleApiManager.zah(this.zaa)) {
        zaa(zad(param1ConnectionResult));
        return;
      } 
      zaa(zad(param1ConnectionResult), (Exception)null, true);
      if (this.zab.isEmpty())
        return; 
      if (zab(param1ConnectionResult))
        return; 
      if (!this.zaa.zaa(param1ConnectionResult, this.zai)) {
        if (param1ConnectionResult.getErrorCode() == 18)
          this.zak = true; 
        if (this.zak) {
          GoogleApiManager.zaa(this.zaa).sendMessageDelayed(Message.obtain(GoogleApiManager.zaa(this.zaa), 9, this.zae), GoogleApiManager.zac(this.zaa));
          return;
        } 
        zaa(zad(param1ConnectionResult));
      } 
    }
    
    private final void zaa(Status param1Status) {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(this.zaa));
      zaa(param1Status, (Exception)null, false);
    }
    
    private final void zaa(Status param1Status, Exception param1Exception, boolean param1Boolean) {
      boolean bool1;
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(this.zaa));
      boolean bool2 = true;
      if (param1Status == null) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      if (param1Exception != null)
        bool2 = false; 
      if (bool1 != bool2) {
        Iterator<zab> iterator = this.zab.iterator();
        while (iterator.hasNext()) {
          zab zab = iterator.next();
          if (!param1Boolean || zab.zaa == 2) {
            if (param1Status != null) {
              zab.zaa(param1Status);
            } else {
              zab.zaa(param1Exception);
            } 
            iterator.remove();
          } 
        } 
        return;
      } 
      throw new IllegalArgumentException("Status XOR exception should be null");
    }
    
    private final void zaa(GoogleApiManager.zac param1zac) {
      if (!this.zal.contains(param1zac))
        return; 
      if (!this.zak) {
        if (!this.zac.isConnected()) {
          zai();
          return;
        } 
        zan();
      } 
    }
    
    private final boolean zaa(boolean param1Boolean) {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(this.zaa));
      if (this.zac.isConnected() && this.zah.size() == 0) {
        if (this.zaf.zaa()) {
          if (param1Boolean)
            zap(); 
          return false;
        } 
        this.zac.disconnect("Timing out service connection.");
        return true;
      } 
      return false;
    }
    
    private final void zab(GoogleApiManager.zac param1zac) {
      if (this.zal.remove(param1zac)) {
        GoogleApiManager.zaa(this.zaa).removeMessages(15, param1zac);
        GoogleApiManager.zaa(this.zaa).removeMessages(16, param1zac);
        Feature feature = GoogleApiManager.zac.zab(param1zac);
        ArrayList<zab> arrayList = new ArrayList(this.zab.size());
        for (zab zab : this.zab) {
          if (zab instanceof zad) {
            Feature[] arrayOfFeature = ((zad)zab).zac(this);
            if (arrayOfFeature != null && ArrayUtils.contains((Object[])arrayOfFeature, feature))
              arrayList.add(zab); 
          } 
        } 
        arrayList = arrayList;
        int j = arrayList.size();
        int i = 0;
        while (i < j) {
          zab zab = (zab)arrayList.get(i);
          i++;
          zab = zab;
          this.zab.remove(zab);
          zab.zaa((Exception)new UnsupportedApiCallException(feature));
        } 
      } 
    }
    
    private final boolean zab(ConnectionResult param1ConnectionResult) {
      synchronized (GoogleApiManager.zad()) {
        if (GoogleApiManager.zaf(this.zaa) != null && GoogleApiManager.zag(this.zaa).contains(this.zae)) {
          GoogleApiManager.zaf(this.zaa).zab(param1ConnectionResult, this.zai);
          return true;
        } 
        return false;
      } 
    }
    
    private final boolean zab(zab param1zab) {
      if (!(param1zab instanceof zad)) {
        zac(param1zab);
        return true;
      } 
      zad zad = (zad)param1zab;
      Feature feature = zaa(zad.zac(this));
      if (feature == null) {
        zac(param1zab);
        return true;
      } 
      String str1 = this.zad.getClass().getName();
      String str2 = feature.getName();
      long l = feature.getVersion();
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(str1).length() + 77 + String.valueOf(str2).length());
      stringBuilder.append(str1);
      stringBuilder.append(" could not execute call because it requires feature (");
      stringBuilder.append(str2);
      stringBuilder.append(", ");
      stringBuilder.append(l);
      stringBuilder.append(").");
      Log.w("GoogleApiManager", stringBuilder.toString());
      if (GoogleApiManager.zah(this.zaa) && zad.zad(this)) {
        GoogleApiManager.zac zac = new GoogleApiManager.zac(this.zae, feature, null);
        int i = this.zal.indexOf(zac);
        if (i >= 0) {
          zac = this.zal.get(i);
          GoogleApiManager.zaa(this.zaa).removeMessages(15, zac);
          GoogleApiManager.zaa(this.zaa).sendMessageDelayed(Message.obtain(GoogleApiManager.zaa(this.zaa), 15, zac), GoogleApiManager.zac(this.zaa));
        } else {
          this.zal.add(zac);
          GoogleApiManager.zaa(this.zaa).sendMessageDelayed(Message.obtain(GoogleApiManager.zaa(this.zaa), 15, zac), GoogleApiManager.zac(this.zaa));
          GoogleApiManager.zaa(this.zaa).sendMessageDelayed(Message.obtain(GoogleApiManager.zaa(this.zaa), 16, zac), GoogleApiManager.zad(this.zaa));
          ConnectionResult connectionResult = new ConnectionResult(2, null);
          if (!zab(connectionResult))
            this.zaa.zaa(connectionResult, this.zai); 
        } 
        return false;
      } 
      zad.zaa((Exception)new UnsupportedApiCallException(feature));
      return true;
    }
    
    private final void zac(ConnectionResult param1ConnectionResult) {
      for (zaj zaj : this.zag) {
        String str = null;
        if (Objects.equal(param1ConnectionResult, ConnectionResult.RESULT_SUCCESS))
          str = this.zac.getEndpointPackageName(); 
        zaj.zaa(this.zae, param1ConnectionResult, str);
      } 
      this.zag.clear();
    }
    
    private final void zac(zab param1zab) {
      param1zab.zaa(this.zaf, zak());
      try {
        return;
      } catch (DeadObjectException deadObjectException) {
        onConnectionSuspended(1);
        return;
      } finally {
        param1zab = null;
      } 
    }
    
    private final Status zad(ConnectionResult param1ConnectionResult) {
      String str2 = this.zae.getApiName();
      String str1 = String.valueOf(param1ConnectionResult);
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(str2).length() + 63 + String.valueOf(str1).length());
      stringBuilder.append("API: ");
      stringBuilder.append(str2);
      stringBuilder.append(" is not available on this device. Connection failed with: ");
      stringBuilder.append(str1);
      return new Status(17, stringBuilder.toString());
    }
    
    private final void zam() {
      zad();
      zac(ConnectionResult.RESULT_SUCCESS);
      zao();
      Iterator<zabs> iterator = this.zah.values().iterator();
      while (true) {
        if (iterator.hasNext()) {
          zabs zabs = iterator.next();
          if (zaa(zabs.zaa.getRequiredFeatures()) != null) {
            iterator.remove();
            continue;
          } 
          try {
            zabs.zaa.registerListener(this.zad, new TaskCompletionSource());
            continue;
          } catch (DeadObjectException deadObjectException) {
            onConnectionSuspended(3);
            this.zac.disconnect("DeadObjectException thrown while calling register listener method.");
            zan();
            zap();
            return;
          } catch (RemoteException remoteException) {
            deadObjectException.remove();
            continue;
          } 
        } 
        zan();
        zap();
        return;
      } 
    }
    
    private final void zan() {
      ArrayList<zab> arrayList = new ArrayList<zab>(this.zab);
      int j = arrayList.size();
      int i = 0;
      while (i < j) {
        zab zab = (zab)arrayList.get(i);
        int k = i + 1;
        zab = zab;
        if (this.zac.isConnected()) {
          i = k;
          if (zab(zab)) {
            this.zab.remove(zab);
            i = k;
          } 
        } 
      } 
    }
    
    private final void zao() {
      if (this.zak) {
        GoogleApiManager.zaa(this.zaa).removeMessages(11, this.zae);
        GoogleApiManager.zaa(this.zaa).removeMessages(9, this.zae);
        this.zak = false;
      } 
    }
    
    private final void zap() {
      GoogleApiManager.zaa(this.zaa).removeMessages(12, this.zae);
      GoogleApiManager.zaa(this.zaa).sendMessageDelayed(GoogleApiManager.zaa(this.zaa).obtainMessage(12, this.zae), GoogleApiManager.zaj(this.zaa));
    }
    
    public final void onConnected(Bundle param1Bundle) {
      if (Looper.myLooper() == GoogleApiManager.zaa(this.zaa).getLooper()) {
        zam();
        return;
      } 
      GoogleApiManager.zaa(this.zaa).post(new zabd(this));
    }
    
    public final void onConnectionFailed(ConnectionResult param1ConnectionResult) {
      zaa(param1ConnectionResult, (Exception)null);
    }
    
    public final void onConnectionSuspended(int param1Int) {
      if (Looper.myLooper() == GoogleApiManager.zaa(this.zaa).getLooper()) {
        zaa(param1Int);
        return;
      } 
      GoogleApiManager.zaa(this.zaa).post(new zabf(this, param1Int));
    }
    
    public final void zaa() {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(this.zaa));
      zaa(GoogleApiManager.zaa);
      this.zaf.zab();
      Set<ListenerHolder.ListenerKey<?>> set = this.zah.keySet();
      int i = 0;
      ListenerHolder.ListenerKey[] arrayOfListenerKey = set.<ListenerHolder.ListenerKey>toArray(new ListenerHolder.ListenerKey[0]);
      int j = arrayOfListenerKey.length;
      while (i < j) {
        zaa(new zag(arrayOfListenerKey[i], new TaskCompletionSource()));
        i++;
      } 
      zac(new ConnectionResult(4));
      if (this.zac.isConnected())
        this.zac.onUserSignOut(new zabh(this)); 
    }
    
    public final void zaa(ConnectionResult param1ConnectionResult) {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(this.zaa));
      Api.Client client = this.zac;
      String str1 = this.zad.getClass().getName();
      String str2 = String.valueOf(param1ConnectionResult);
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(str1).length() + 25 + String.valueOf(str2).length());
      stringBuilder.append("onSignInFailed for ");
      stringBuilder.append(str1);
      stringBuilder.append(" with ");
      stringBuilder.append(str2);
      client.disconnect(stringBuilder.toString());
      onConnectionFailed(param1ConnectionResult);
    }
    
    public final void zaa(ConnectionResult param1ConnectionResult, Api<?> param1Api, boolean param1Boolean) {
      if (Looper.myLooper() == GoogleApiManager.zaa(this.zaa).getLooper()) {
        onConnectionFailed(param1ConnectionResult);
        return;
      } 
      GoogleApiManager.zaa(this.zaa).post(new zabe(this, param1ConnectionResult));
    }
    
    public final void zaa(zab param1zab) {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(this.zaa));
      if (this.zac.isConnected()) {
        if (zab(param1zab)) {
          zap();
          return;
        } 
        this.zab.add(param1zab);
        return;
      } 
      this.zab.add(param1zab);
      ConnectionResult connectionResult = this.zam;
      if (connectionResult != null && connectionResult.hasResolution()) {
        onConnectionFailed(this.zam);
        return;
      } 
      zai();
    }
    
    public final void zaa(zaj param1zaj) {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(this.zaa));
      this.zag.add(param1zaj);
    }
    
    public final Api.Client zab() {
      return this.zac;
    }
    
    public final Map<ListenerHolder.ListenerKey<?>, zabs> zac() {
      return this.zah;
    }
    
    public final void zad() {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(this.zaa));
      this.zam = null;
    }
    
    public final ConnectionResult zae() {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(this.zaa));
      return this.zam;
    }
    
    public final void zaf() {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(this.zaa));
      if (this.zak)
        zai(); 
    }
    
    public final void zag() {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(this.zaa));
      if (this.zak) {
        Status status;
        zao();
        if (GoogleApiManager.zai(this.zaa).isGooglePlayServicesAvailable(GoogleApiManager.zab(this.zaa)) == 18) {
          status = new Status(8, "Connection timed out while waiting for Google Play services update to complete.");
        } else {
          status = new Status(8, "API failed to connect while resuming due to an unknown error.");
        } 
        zaa(status);
        this.zac.disconnect("Timing out connection while resuming.");
      } 
    }
    
    public final boolean zah() {
      return zaa(true);
    }
    
    public final void zai() {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(this.zaa));
      if (!this.zac.isConnected()) {
        if (this.zac.isConnecting())
          return; 
        try {
          int i = GoogleApiManager.zae(this.zaa).zaa(GoogleApiManager.zab(this.zaa), this.zac);
          if (i != 0) {
            ConnectionResult connectionResult = new ConnectionResult(i, null);
            String str1 = this.zad.getClass().getName();
            String str2 = String.valueOf(connectionResult);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str1).length() + 35 + String.valueOf(str2).length());
            stringBuilder.append("The service for ");
            stringBuilder.append(str1);
            stringBuilder.append(" is not available: ");
            stringBuilder.append(str2);
            Log.w("GoogleApiManager", stringBuilder.toString());
            onConnectionFailed(connectionResult);
            return;
          } 
          GoogleApiManager.zab zab = new GoogleApiManager.zab(this.zaa, this.zac, this.zae);
          if (this.zac.requiresSignIn())
            ((zacc)Preconditions.checkNotNull(this.zaj)).zaa(zab); 
          try {
            this.zac.connect(zab);
            return;
          } catch (SecurityException securityException) {
            zaa(new ConnectionResult(10), securityException);
            return;
          } 
        } catch (IllegalStateException illegalStateException) {
          zaa(new ConnectionResult(10), illegalStateException);
        } 
      } 
    }
    
    final boolean zaj() {
      return this.zac.isConnected();
    }
    
    public final boolean zak() {
      return this.zac.requiresSignIn();
    }
    
    public final int zal() {
      return this.zai;
    }
  }
  
  final class zab implements zacd, BaseGmsClient.ConnectionProgressReportCallbacks {
    private final Api.Client zab;
    
    private final ApiKey<?> zac;
    
    private IAccountAccessor zad = null;
    
    private Set<Scope> zae = null;
    
    private boolean zaf = false;
    
    public zab(GoogleApiManager this$0, Api.Client param1Client, ApiKey<?> param1ApiKey) {
      this.zab = param1Client;
      this.zac = param1ApiKey;
    }
    
    private final void zaa() {
      if (this.zaf) {
        IAccountAccessor iAccountAccessor = this.zad;
        if (iAccountAccessor != null)
          this.zab.getRemoteService(iAccountAccessor, this.zae); 
      } 
    }
    
    public final void onReportServiceBinding(ConnectionResult param1ConnectionResult) {
      GoogleApiManager.zaa(this.zaa).post(new zabj(this, param1ConnectionResult));
    }
    
    public final void zaa(ConnectionResult param1ConnectionResult) {
      GoogleApiManager.zaa zaa = (GoogleApiManager.zaa)GoogleApiManager.zak(this.zaa).get(this.zac);
      if (zaa != null)
        zaa.zaa(param1ConnectionResult); 
    }
    
    public final void zaa(IAccountAccessor param1IAccountAccessor, Set<Scope> param1Set) {
      if (param1IAccountAccessor == null || param1Set == null) {
        Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
        zaa(new ConnectionResult(4));
        return;
      } 
      this.zad = param1IAccountAccessor;
      this.zae = param1Set;
      zaa();
    }
  }
  
  static final class zac {
    private final ApiKey<?> zaa;
    
    private final Feature zab;
    
    private zac(ApiKey<?> param1ApiKey, Feature param1Feature) {
      this.zaa = param1ApiKey;
      this.zab = param1Feature;
    }
    
    public final boolean equals(Object param1Object) {
      if (param1Object != null && param1Object instanceof zac) {
        param1Object = param1Object;
        if (Objects.equal(this.zaa, ((zac)param1Object).zaa) && Objects.equal(this.zab, ((zac)param1Object).zab))
          return true; 
      } 
      return false;
    }
    
    public final int hashCode() {
      return Objects.hashCode(new Object[] { this.zaa, this.zab });
    }
    
    public final String toString() {
      return Objects.toStringHelper(this).add("key", this.zaa).add("feature", this.zab).toString();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\GoogleApiManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */