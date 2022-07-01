package com.alibaba.mtl.appmonitor;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.mtl.log.e.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

public final class AppMonitor {
  public static final String TAG = "AppMonitor";
  
  private static Application a;
  
  private static ServiceConnection a;
  
  private static HandlerThread a;
  
  private static b a;
  
  private static c a;
  
  protected static IMonitor a;
  
  private static Object a = new Object();
  
  private static String a;
  
  private static List<a> a = (List)Collections.synchronizedList(new ArrayList());
  
  private static volatile boolean a;
  
  private static String b;
  
  private static boolean b = false;
  
  private static String c;
  
  private static boolean c;
  
  private static String d;
  
  private static Context mContext;
  
  static {
    a = b.b;
    try {
      System.loadLibrary("ut_c_api");
      Log.i("AppMonitor", "load ut_c_api.so success");
    } finally {
      Exception exception = null;
    } 
  }
  
  private static int a(f paramf) {
    return paramf.a();
  }
  
  private static Runnable a() {
    return new Runnable() {
        public void run() {
          // Byte code:
          //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
          //   3: invokeinterface init : ()V
          //   8: return
          //   9: invokestatic d : ()V
          //   12: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
          //   15: invokeinterface init : ()V
          //   20: return
          //   21: astore_1
          //   22: goto -> 9
          //   25: astore_1
          //   26: return
          // Exception table:
          //   from	to	target	type
          //   0	8	21	android/os/RemoteException
          //   12	20	25	finally
        }
      };
  }
  
  private static Runnable a(String paramString) {
    return new Runnable(paramString) {
        public void run() {
          // Byte code:
          //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
          //   3: aload_0
          //   4: getfield h : Ljava/lang/String;
          //   7: invokeinterface setChannel : (Ljava/lang/String;)V
          //   12: return
          //   13: astore_1
          //   14: return
          // Exception table:
          //   from	to	target	type
          //   0	12	13	finally
        }
      };
  }
  
  private static Runnable a(String paramString1, String paramString2, MeasureSet paramMeasureSet, DimensionSet paramDimensionSet, boolean paramBoolean) {
    return new Runnable(paramString1, paramString2, paramMeasureSet, paramDimensionSet, paramBoolean) {
        public void run() {
          // Byte code:
          //   0: ldc 'AppMonitor'
          //   2: iconst_4
          //   3: anewarray java/lang/Object
          //   6: dup
          //   7: iconst_0
          //   8: ldc 'register stat event. module: '
          //   10: aastore
          //   11: dup
          //   12: iconst_1
          //   13: aload_0
          //   14: getfield i : Ljava/lang/String;
          //   17: aastore
          //   18: dup
          //   19: iconst_2
          //   20: ldc ' monitorPoint: '
          //   22: aastore
          //   23: dup
          //   24: iconst_3
          //   25: aload_0
          //   26: getfield j : Ljava/lang/String;
          //   29: aastore
          //   30: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
          //   33: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
          //   36: aload_0
          //   37: getfield i : Ljava/lang/String;
          //   40: aload_0
          //   41: getfield j : Ljava/lang/String;
          //   44: aload_0
          //   45: getfield a : Lcom/alibaba/mtl/appmonitor/model/MeasureSet;
          //   48: aload_0
          //   49: getfield a : Lcom/alibaba/mtl/appmonitor/model/DimensionSet;
          //   52: aload_0
          //   53: getfield e : Z
          //   56: invokeinterface register4 : (Ljava/lang/String;Ljava/lang/String;Lcom/alibaba/mtl/appmonitor/model/MeasureSet;Lcom/alibaba/mtl/appmonitor/model/DimensionSet;Z)V
          //   61: return
          //   62: astore_1
          //   63: aload_1
          //   64: invokestatic b : (Ljava/lang/Exception;)V
          //   67: return
          // Exception table:
          //   from	to	target	type
          //   0	61	62	android/os/RemoteException
        }
      };
  }
  
  private static Runnable a(boolean paramBoolean, String paramString1, String paramString2, String paramString3) {
    return new Runnable(paramBoolean, paramString1, paramString2, paramString3) {
        public void run() {
          // Byte code:
          //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
          //   3: aload_0
          //   4: getfield d : Z
          //   7: aload_0
          //   8: getfield e : Ljava/lang/String;
          //   11: aload_0
          //   12: getfield f : Ljava/lang/String;
          //   15: aload_0
          //   16: getfield g : Ljava/lang/String;
          //   19: invokeinterface setRequestAuthInfo : (ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
          //   24: return
          //   25: astore_1
          //   26: return
          // Exception table:
          //   from	to	target	type
          //   0	24	25	finally
        }
      };
  }
  
  private static void a() {
    // Byte code:
    //   0: ldc com/alibaba/mtl/appmonitor/AppMonitor
    //   2: monitorenter
    //   3: iconst_0
    //   4: istore_0
    //   5: ldc 'AppMonitor'
    //   7: iconst_1
    //   8: anewarray java/lang/Object
    //   11: dup
    //   12: iconst_0
    //   13: ldc '[restart]'
    //   15: aastore
    //   16: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   19: getstatic com/alibaba/mtl/appmonitor/AppMonitor.b : Z
    //   22: ifeq -> 151
    //   25: iconst_0
    //   26: putstatic com/alibaba/mtl/appmonitor/AppMonitor.b : Z
    //   29: invokestatic b : ()V
    //   32: invokestatic a : ()Ljava/lang/Runnable;
    //   35: invokeinterface run : ()V
    //   40: getstatic com/alibaba/mtl/appmonitor/AppMonitor.c : Z
    //   43: getstatic com/alibaba/mtl/appmonitor/AppMonitor.b : Ljava/lang/String;
    //   46: getstatic com/alibaba/mtl/appmonitor/AppMonitor.c : Ljava/lang/String;
    //   49: getstatic com/alibaba/mtl/appmonitor/AppMonitor.d : Ljava/lang/String;
    //   52: invokestatic a : (ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Runnable;
    //   55: invokeinterface run : ()V
    //   60: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Ljava/lang/String;
    //   63: invokestatic a : (Ljava/lang/String;)Ljava/lang/Runnable;
    //   66: invokeinterface run : ()V
    //   71: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Ljava/util/List;
    //   74: astore_1
    //   75: aload_1
    //   76: monitorenter
    //   77: iload_0
    //   78: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Ljava/util/List;
    //   81: invokeinterface size : ()I
    //   86: if_icmpge -> 141
    //   89: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Ljava/util/List;
    //   92: iload_0
    //   93: invokeinterface get : (I)Ljava/lang/Object;
    //   98: checkcast com/alibaba/mtl/appmonitor/AppMonitor$a
    //   101: astore_2
    //   102: aload_2
    //   103: ifnull -> 134
    //   106: aload_2
    //   107: getfield o : Ljava/lang/String;
    //   110: aload_2
    //   111: getfield p : Ljava/lang/String;
    //   114: aload_2
    //   115: getfield b : Lcom/alibaba/mtl/appmonitor/model/MeasureSet;
    //   118: aload_2
    //   119: getfield b : Lcom/alibaba/mtl/appmonitor/model/DimensionSet;
    //   122: aload_2
    //   123: getfield g : Z
    //   126: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Lcom/alibaba/mtl/appmonitor/model/MeasureSet;Lcom/alibaba/mtl/appmonitor/model/DimensionSet;Z)Ljava/lang/Runnable;
    //   129: invokeinterface run : ()V
    //   134: iload_0
    //   135: iconst_1
    //   136: iadd
    //   137: istore_0
    //   138: goto -> 77
    //   141: aload_1
    //   142: monitorexit
    //   143: goto -> 151
    //   146: astore_2
    //   147: aload_1
    //   148: monitorexit
    //   149: aload_2
    //   150: athrow
    //   151: ldc com/alibaba/mtl/appmonitor/AppMonitor
    //   153: monitorexit
    //   154: return
    //   155: astore_1
    //   156: ldc com/alibaba/mtl/appmonitor/AppMonitor
    //   158: monitorexit
    //   159: aload_1
    //   160: athrow
    //   161: astore_1
    //   162: goto -> 151
    //   165: astore_2
    //   166: goto -> 134
    // Exception table:
    //   from	to	target	type
    //   5	19	155	finally
    //   19	77	161	finally
    //   77	102	146	finally
    //   106	134	165	finally
    //   141	143	146	finally
    //   147	149	146	finally
    //   149	151	161	finally
  }
  
  private static void a(Exception paramException) {
    i.a("AppMonitor", "", paramException);
    if (paramException instanceof android.os.DeadObjectException)
      a(); 
  }
  
  private static void a(String paramString1, String paramString2, MeasureSet paramMeasureSet, DimensionSet paramDimensionSet, boolean paramBoolean) {
    // Byte code:
    //   0: new com/alibaba/mtl/appmonitor/AppMonitor$a
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #5
    //   9: aload #5
    //   11: aload_0
    //   12: putfield o : Ljava/lang/String;
    //   15: aload #5
    //   17: aload_1
    //   18: putfield p : Ljava/lang/String;
    //   21: aload #5
    //   23: aload_2
    //   24: putfield b : Lcom/alibaba/mtl/appmonitor/model/MeasureSet;
    //   27: aload #5
    //   29: aload_3
    //   30: putfield b : Lcom/alibaba/mtl/appmonitor/model/DimensionSet;
    //   33: aload #5
    //   35: iload #4
    //   37: putfield g : Z
    //   40: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Ljava/util/List;
    //   43: aload #5
    //   45: invokeinterface add : (Ljava/lang/Object;)Z
    //   50: pop
    //   51: return
    //   52: astore_0
    //   53: return
    // Exception table:
    //   from	to	target	type
    //   0	51	52	finally
  }
  
  private static boolean a() {
    boolean bool2 = a;
    if (bool2 == null)
      return false; 
    boolean bool1 = bool2.getApplicationContext().bindService(new Intent(a.getApplicationContext(), AppMonitorService.class), a, 1);
    if (!bool1)
      b(); 
    i.a("AppMonitor", new Object[] { "bindsuccess:", Boolean.valueOf(bool1) });
    return bool1;
  }
  
  private static void b() {
    a = new Monitor(a);
    a = b.b;
    i.a("AppMonitor", "Start AppMonitor Service failed,AppMonitor run in local Mode...");
  }
  
  private static boolean b() {
    if (!a)
      i.a("AppMonitor", new Object[] { "Please call init() before call other method" }); 
    return a;
  }
  
  @Deprecated
  public static void destroy() {
    // Byte code:
    //   0: ldc com/alibaba/mtl/appmonitor/AppMonitor
    //   2: monitorenter
    //   3: invokestatic b : ()Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifne -> 15
    //   11: ldc com/alibaba/mtl/appmonitor/AppMonitor
    //   13: monitorexit
    //   14: return
    //   15: new com/alibaba/mtl/appmonitor/AppMonitor$1
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: astore_1
    //   23: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/AppMonitor$c;
    //   26: aload_1
    //   27: invokevirtual a : (Ljava/lang/Runnable;)V
    //   30: ldc com/alibaba/mtl/appmonitor/AppMonitor
    //   32: monitorexit
    //   33: return
    //   34: astore_1
    //   35: ldc com/alibaba/mtl/appmonitor/AppMonitor
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	34	finally
    //   15	30	34	finally
  }
  
  public static void enableLog(boolean paramBoolean) {
    // Byte code:
    //   0: invokestatic b : ()Z
    //   3: ifne -> 7
    //   6: return
    //   7: new com/alibaba/mtl/appmonitor/AppMonitor$13
    //   10: dup
    //   11: iload_0
    //   12: invokespecial <init> : (Z)V
    //   15: astore_1
    //   16: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/AppMonitor$c;
    //   19: aload_1
    //   20: invokevirtual a : (Ljava/lang/Runnable;)V
    //   23: return
  }
  
  public static void init(Application paramApplication) {
    // Byte code:
    //   0: ldc com/alibaba/mtl/appmonitor/AppMonitor
    //   2: monitorenter
    //   3: ldc 'AppMonitor'
    //   5: iconst_1
    //   6: anewarray java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: ldc_w '[init]'
    //   14: aastore
    //   15: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   18: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Z
    //   21: ifne -> 118
    //   24: aload_0
    //   25: putstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Landroid/app/Application;
    //   28: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Landroid/app/Application;
    //   31: ifnull -> 43
    //   34: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Landroid/app/Application;
    //   37: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   40: putstatic com/alibaba/mtl/appmonitor/AppMonitor.mContext : Landroid/content/Context;
    //   43: new android/os/HandlerThread
    //   46: dup
    //   47: ldc_w 'AppMonitor_Client'
    //   50: invokespecial <init> : (Ljava/lang/String;)V
    //   53: putstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Landroid/os/HandlerThread;
    //   56: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Landroid/os/HandlerThread;
    //   59: invokevirtual start : ()V
    //   62: new com/alibaba/mtl/appmonitor/AppMonitor$c
    //   65: dup
    //   66: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Landroid/os/HandlerThread;
    //   69: invokevirtual getLooper : ()Landroid/os/Looper;
    //   72: invokespecial <init> : (Landroid/os/Looper;)V
    //   75: putstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/AppMonitor$c;
    //   78: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/AppMonitor$b;
    //   81: getstatic com/alibaba/mtl/appmonitor/AppMonitor$b.b : Lcom/alibaba/mtl/appmonitor/AppMonitor$b;
    //   84: if_acmpne -> 93
    //   87: invokestatic b : ()V
    //   90: goto -> 106
    //   93: invokestatic a : ()Z
    //   96: ifeq -> 106
    //   99: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/AppMonitor$c;
    //   102: iconst_1
    //   103: invokevirtual a : (Z)V
    //   106: invokestatic a : ()Ljava/lang/Runnable;
    //   109: invokeinterface run : ()V
    //   114: iconst_1
    //   115: putstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Z
    //   118: ldc com/alibaba/mtl/appmonitor/AppMonitor
    //   120: monitorexit
    //   121: return
    //   122: astore_0
    //   123: ldc com/alibaba/mtl/appmonitor/AppMonitor
    //   125: monitorexit
    //   126: aload_0
    //   127: athrow
    //   128: astore_0
    //   129: goto -> 118
    // Exception table:
    //   from	to	target	type
    //   3	18	122	finally
    //   18	43	128	finally
    //   43	90	128	finally
    //   93	106	128	finally
    //   106	118	128	finally
  }
  
  public static void register(String paramString1, String paramString2, MeasureSet paramMeasureSet) {
    // Byte code:
    //   0: invokestatic b : ()Z
    //   3: ifne -> 7
    //   6: return
    //   7: new com/alibaba/mtl/appmonitor/AppMonitor$14
    //   10: dup
    //   11: aload_0
    //   12: aload_1
    //   13: aload_2
    //   14: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Lcom/alibaba/mtl/appmonitor/model/MeasureSet;)V
    //   17: astore_3
    //   18: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/AppMonitor$c;
    //   21: aload_3
    //   22: invokevirtual a : (Ljava/lang/Runnable;)V
    //   25: aload_0
    //   26: aload_1
    //   27: aload_2
    //   28: aconst_null
    //   29: iconst_0
    //   30: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Lcom/alibaba/mtl/appmonitor/model/MeasureSet;Lcom/alibaba/mtl/appmonitor/model/DimensionSet;Z)V
    //   33: return
  }
  
  public static void register(String paramString1, String paramString2, MeasureSet paramMeasureSet, DimensionSet paramDimensionSet) {
    // Byte code:
    //   0: invokestatic b : ()Z
    //   3: ifne -> 7
    //   6: return
    //   7: new com/alibaba/mtl/appmonitor/AppMonitor$16
    //   10: dup
    //   11: aload_0
    //   12: aload_1
    //   13: aload_2
    //   14: aload_3
    //   15: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Lcom/alibaba/mtl/appmonitor/model/MeasureSet;Lcom/alibaba/mtl/appmonitor/model/DimensionSet;)V
    //   18: astore #4
    //   20: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/AppMonitor$c;
    //   23: aload #4
    //   25: invokevirtual a : (Ljava/lang/Runnable;)V
    //   28: aload_0
    //   29: aload_1
    //   30: aload_2
    //   31: aload_3
    //   32: iconst_0
    //   33: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Lcom/alibaba/mtl/appmonitor/model/MeasureSet;Lcom/alibaba/mtl/appmonitor/model/DimensionSet;Z)V
    //   36: return
  }
  
  public static void register(String paramString1, String paramString2, MeasureSet paramMeasureSet, DimensionSet paramDimensionSet, boolean paramBoolean) {
    if (!b())
      return; 
    registerInternal(paramString1, paramString2, paramMeasureSet, paramDimensionSet, paramBoolean, false);
  }
  
  public static void register(String paramString1, String paramString2, MeasureSet paramMeasureSet, boolean paramBoolean) {
    // Byte code:
    //   0: invokestatic b : ()Z
    //   3: ifne -> 7
    //   6: return
    //   7: new com/alibaba/mtl/appmonitor/AppMonitor$15
    //   10: dup
    //   11: aload_0
    //   12: aload_1
    //   13: aload_2
    //   14: iload_3
    //   15: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Lcom/alibaba/mtl/appmonitor/model/MeasureSet;Z)V
    //   18: astore #4
    //   20: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/AppMonitor$c;
    //   23: aload #4
    //   25: invokevirtual a : (Ljava/lang/Runnable;)V
    //   28: aload_0
    //   29: aload_1
    //   30: aload_2
    //   31: aconst_null
    //   32: iload_3
    //   33: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Lcom/alibaba/mtl/appmonitor/model/MeasureSet;Lcom/alibaba/mtl/appmonitor/model/DimensionSet;Z)V
    //   36: return
  }
  
  public static void register(String paramString1, String paramString2, String[] paramArrayOfString1, String[] paramArrayOfString2, boolean paramBoolean) {
    String str1;
    boolean bool = false;
    String str2 = "null";
    if (paramArrayOfString1 == null) {
      str1 = "null";
    } else {
      str1 = (new JSONArray(Arrays.asList(paramArrayOfString1))).toString();
    } 
    if (paramArrayOfString2 != null)
      str2 = (new JSONArray(Arrays.asList(paramArrayOfString2))).toString(); 
    i.a("AppMonitor", new Object[] { "[register]", "module:", paramString1, "measures:", str1, "dimensions:", str2, "isCommitDetail:", Boolean.valueOf(paramBoolean) });
    if (paramArrayOfString1 != null) {
      DimensionSet dimensionSet;
      MeasureSet measureSet = MeasureSet.create();
      int i;
      for (i = 0; i < paramArrayOfString1.length; i++)
        measureSet.addMeasure(paramArrayOfString1[i]); 
      paramArrayOfString1 = null;
      if (paramArrayOfString2 != null) {
        DimensionSet dimensionSet1 = DimensionSet.create();
        i = bool;
        while (true) {
          dimensionSet = dimensionSet1;
          if (i < paramArrayOfString2.length) {
            dimensionSet1.addDimension(paramArrayOfString2[i]);
            i++;
            continue;
          } 
          break;
        } 
      } 
      register(paramString1, paramString2, measureSet, dimensionSet, paramBoolean);
      return;
    } 
    i.a("AppMonitor", new Object[] { "register failed:no mearsure" });
  }
  
  public static void registerInternal(String paramString1, String paramString2, MeasureSet paramMeasureSet, DimensionSet paramDimensionSet, boolean paramBoolean1, boolean paramBoolean2) {
    // Byte code:
    //   0: invokestatic b : ()Z
    //   3: ifne -> 7
    //   6: return
    //   7: ldc 'AppMonitor'
    //   9: bipush #12
    //   11: anewarray java/lang/Object
    //   14: dup
    //   15: iconst_0
    //   16: ldc_w '[registerInternal] : module:'
    //   19: aastore
    //   20: dup
    //   21: iconst_1
    //   22: aload_0
    //   23: aastore
    //   24: dup
    //   25: iconst_2
    //   26: ldc_w 'monitorPoint:'
    //   29: aastore
    //   30: dup
    //   31: iconst_3
    //   32: aload_1
    //   33: aastore
    //   34: dup
    //   35: iconst_4
    //   36: ldc_w 'measures:'
    //   39: aastore
    //   40: dup
    //   41: iconst_5
    //   42: aload_2
    //   43: aastore
    //   44: dup
    //   45: bipush #6
    //   47: ldc_w 'dimensions:'
    //   50: aastore
    //   51: dup
    //   52: bipush #7
    //   54: aload_3
    //   55: aastore
    //   56: dup
    //   57: bipush #8
    //   59: ldc_w 'isCommitDetail:'
    //   62: aastore
    //   63: dup
    //   64: bipush #9
    //   66: iload #4
    //   68: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   71: aastore
    //   72: dup
    //   73: bipush #10
    //   75: ldc_w 'isInternal:'
    //   78: aastore
    //   79: dup
    //   80: bipush #11
    //   82: iload #5
    //   84: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   87: aastore
    //   88: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   91: iload #5
    //   93: ifne -> 105
    //   96: aload_0
    //   97: aload_1
    //   98: aload_2
    //   99: aload_3
    //   100: iload #4
    //   102: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Lcom/alibaba/mtl/appmonitor/model/MeasureSet;Lcom/alibaba/mtl/appmonitor/model/DimensionSet;Z)V
    //   105: aload_0
    //   106: aload_1
    //   107: aload_2
    //   108: aload_3
    //   109: iload #4
    //   111: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Lcom/alibaba/mtl/appmonitor/model/MeasureSet;Lcom/alibaba/mtl/appmonitor/model/DimensionSet;Z)Ljava/lang/Runnable;
    //   114: astore_0
    //   115: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/AppMonitor$c;
    //   118: aload_0
    //   119: invokevirtual a : (Ljava/lang/Runnable;)V
    //   122: return
  }
  
  public static void setChannel(String paramString) {
    // Byte code:
    //   0: invokestatic b : ()Z
    //   3: ifne -> 7
    //   6: return
    //   7: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/AppMonitor$c;
    //   10: aload_0
    //   11: invokestatic a : (Ljava/lang/String;)Ljava/lang/Runnable;
    //   14: invokevirtual a : (Ljava/lang/Runnable;)V
    //   17: aload_0
    //   18: putstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Ljava/lang/String;
    //   21: return
  }
  
  public static void setRequestAuthInfo(boolean paramBoolean, String paramString1, String paramString2, String paramString3) {
    // Byte code:
    //   0: invokestatic b : ()Z
    //   3: ifne -> 7
    //   6: return
    //   7: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/AppMonitor$c;
    //   10: iload_0
    //   11: aload_1
    //   12: aload_2
    //   13: aload_3
    //   14: invokestatic a : (ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Runnable;
    //   17: invokevirtual a : (Ljava/lang/Runnable;)V
    //   20: iload_0
    //   21: putstatic com/alibaba/mtl/appmonitor/AppMonitor.c : Z
    //   24: aload_1
    //   25: putstatic com/alibaba/mtl/appmonitor/AppMonitor.b : Ljava/lang/String;
    //   28: aload_2
    //   29: putstatic com/alibaba/mtl/appmonitor/AppMonitor.c : Ljava/lang/String;
    //   32: aload_3
    //   33: putstatic com/alibaba/mtl/appmonitor/AppMonitor.d : Ljava/lang/String;
    //   36: return
  }
  
  public static void setSampling(int paramInt) {
    // Byte code:
    //   0: invokestatic b : ()Z
    //   3: ifne -> 7
    //   6: return
    //   7: new com/alibaba/mtl/appmonitor/AppMonitor$12
    //   10: dup
    //   11: iload_0
    //   12: invokespecial <init> : (I)V
    //   15: astore_1
    //   16: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/AppMonitor$c;
    //   19: aload_1
    //   20: invokevirtual a : (Ljava/lang/Runnable;)V
    //   23: return
  }
  
  public static void setStatisticsInterval(int paramInt) {
    // Byte code:
    //   0: invokestatic b : ()Z
    //   3: ifne -> 7
    //   6: return
    //   7: new com/alibaba/mtl/appmonitor/AppMonitor$11
    //   10: dup
    //   11: iload_0
    //   12: invokespecial <init> : (I)V
    //   15: astore_1
    //   16: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/AppMonitor$c;
    //   19: aload_1
    //   20: invokevirtual a : (Ljava/lang/Runnable;)V
    //   23: return
  }
  
  public static void setStatisticsInterval(f paramf, int paramInt) {
    // Byte code:
    //   0: invokestatic b : ()Z
    //   3: ifne -> 7
    //   6: return
    //   7: new com/alibaba/mtl/appmonitor/AppMonitor$2
    //   10: dup
    //   11: aload_0
    //   12: invokestatic a : (Lcom/alibaba/mtl/appmonitor/a/f;)I
    //   15: iload_1
    //   16: invokespecial <init> : (II)V
    //   19: astore_0
    //   20: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/AppMonitor$c;
    //   23: aload_0
    //   24: invokevirtual a : (Ljava/lang/Runnable;)V
    //   27: return
  }
  
  @Deprecated
  public static void triggerUpload() {
    // Byte code:
    //   0: ldc com/alibaba/mtl/appmonitor/AppMonitor
    //   2: monitorenter
    //   3: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifne -> 15
    //   11: ldc com/alibaba/mtl/appmonitor/AppMonitor
    //   13: monitorexit
    //   14: return
    //   15: new com/alibaba/mtl/appmonitor/AppMonitor$10
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: astore_1
    //   23: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/AppMonitor$c;
    //   26: aload_1
    //   27: invokevirtual a : (Ljava/lang/Runnable;)V
    //   30: ldc com/alibaba/mtl/appmonitor/AppMonitor
    //   32: monitorexit
    //   33: return
    //   34: astore_1
    //   35: ldc com/alibaba/mtl/appmonitor/AppMonitor
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	34	finally
    //   15	30	34	finally
  }
  
  public static void turnOffRealTimeDebug() {
    // Byte code:
    //   0: invokestatic b : ()Z
    //   3: ifne -> 7
    //   6: return
    //   7: new com/alibaba/mtl/appmonitor/AppMonitor$4
    //   10: dup
    //   11: invokespecial <init> : ()V
    //   14: astore_0
    //   15: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/AppMonitor$c;
    //   18: aload_0
    //   19: invokevirtual a : (Ljava/lang/Runnable;)V
    //   22: return
  }
  
  public static void turnOnRealTimeDebug(Map<String, String> paramMap) {
    // Byte code:
    //   0: invokestatic b : ()Z
    //   3: ifne -> 7
    //   6: return
    //   7: new com/alibaba/mtl/appmonitor/AppMonitor$3
    //   10: dup
    //   11: aload_0
    //   12: invokespecial <init> : (Ljava/util/Map;)V
    //   15: astore_0
    //   16: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/AppMonitor$c;
    //   19: aload_0
    //   20: invokevirtual a : (Ljava/lang/Runnable;)V
    //   23: return
  }
  
  public static void updateMeasure(String paramString1, String paramString2, String paramString3, double paramDouble1, double paramDouble2, double paramDouble3) {
    // Byte code:
    //   0: ldc 'AppMonitor'
    //   2: iconst_1
    //   3: anewarray java/lang/Object
    //   6: dup
    //   7: iconst_0
    //   8: ldc_w '[updateMeasure]'
    //   11: aastore
    //   12: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   15: invokestatic b : ()Z
    //   18: ifne -> 22
    //   21: return
    //   22: new com/alibaba/mtl/appmonitor/AppMonitor$17
    //   25: dup
    //   26: aload_0
    //   27: aload_1
    //   28: aload_2
    //   29: dload_3
    //   30: dload #5
    //   32: dload #7
    //   34: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DDD)V
    //   37: astore_0
    //   38: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/AppMonitor$c;
    //   41: aload_0
    //   42: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   45: pop
    //   46: return
  }
  
  public static class Alarm {
    @Deprecated
    public static boolean checkSampled(String param1String1, String param1String2) {
      // Byte code:
      //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
      //   3: ifnonnull -> 8
      //   6: iconst_0
      //   7: ireturn
      //   8: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
      //   11: aload_0
      //   12: aload_1
      //   13: invokeinterface alarm_checkSampled : (Ljava/lang/String;Ljava/lang/String;)Z
      //   18: istore_2
      //   19: iload_2
      //   20: ireturn
      //   21: astore_0
      //   22: aload_0
      //   23: invokestatic b : (Ljava/lang/Exception;)V
      //   26: iconst_0
      //   27: ireturn
      // Exception table:
      //   from	to	target	type
      //   8	19	21	android/os/RemoteException
    }
    
    public static void commitFail(String param1String1, String param1String2, String param1String3, String param1String4) {
      if (!AppMonitor.c())
        return; 
      Runnable runnable = new Runnable(param1String1, param1String2, param1String3, param1String4) {
          public void run() {
            // Byte code:
            //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
            //   3: aload_0
            //   4: getfield i : Ljava/lang/String;
            //   7: aload_0
            //   8: getfield j : Ljava/lang/String;
            //   11: aload_0
            //   12: getfield m : Ljava/lang/String;
            //   15: aload_0
            //   16: getfield n : Ljava/lang/String;
            //   19: invokeinterface alarm_commitFail1 : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
            //   24: return
            //   25: astore_1
            //   26: aload_1
            //   27: invokestatic b : (Ljava/lang/Exception;)V
            //   30: return
            // Exception table:
            //   from	to	target	type
            //   0	24	25	android/os/RemoteException
          }
        };
      AppMonitor.a().a(runnable);
    }
    
    public static void commitFail(String param1String1, String param1String2, String param1String3, String param1String4, String param1String5) {
      if (!AppMonitor.c())
        return; 
      Runnable runnable = new Runnable(param1String1, param1String2, param1String3, param1String4, param1String5) {
          public void run() {
            // Byte code:
            //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
            //   3: aload_0
            //   4: getfield i : Ljava/lang/String;
            //   7: aload_0
            //   8: getfield j : Ljava/lang/String;
            //   11: aload_0
            //   12: getfield l : Ljava/lang/String;
            //   15: aload_0
            //   16: getfield m : Ljava/lang/String;
            //   19: aload_0
            //   20: getfield n : Ljava/lang/String;
            //   23: invokeinterface alarm_commitFail2 : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
            //   28: return
            //   29: astore_1
            //   30: aload_1
            //   31: invokestatic b : (Ljava/lang/Exception;)V
            //   34: return
            // Exception table:
            //   from	to	target	type
            //   0	28	29	android/os/RemoteException
          }
        };
      AppMonitor.a().a(runnable);
    }
    
    public static void commitSuccess(String param1String1, String param1String2) {
      if (!AppMonitor.c())
        return; 
      Runnable runnable = new Runnable(param1String1, param1String2) {
          public void run() {
            // Byte code:
            //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
            //   3: aload_0
            //   4: getfield i : Ljava/lang/String;
            //   7: aload_0
            //   8: getfield j : Ljava/lang/String;
            //   11: invokeinterface alarm_commitSuccess1 : (Ljava/lang/String;Ljava/lang/String;)V
            //   16: return
            //   17: astore_1
            //   18: aload_1
            //   19: invokestatic b : (Ljava/lang/Exception;)V
            //   22: return
            // Exception table:
            //   from	to	target	type
            //   0	16	17	android/os/RemoteException
          }
        };
      AppMonitor.a().a(runnable);
    }
    
    public static void commitSuccess(String param1String1, String param1String2, String param1String3) {
      if (!AppMonitor.c())
        return; 
      Runnable runnable = new Runnable(param1String1, param1String2, param1String3) {
          public void run() {
            // Byte code:
            //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
            //   3: aload_0
            //   4: getfield i : Ljava/lang/String;
            //   7: aload_0
            //   8: getfield j : Ljava/lang/String;
            //   11: aload_0
            //   12: getfield l : Ljava/lang/String;
            //   15: invokeinterface alarm_commitSuccess2 : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
            //   20: return
            //   21: astore_1
            //   22: aload_1
            //   23: invokestatic b : (Ljava/lang/Exception;)V
            //   26: return
            // Exception table:
            //   from	to	target	type
            //   0	20	21	android/os/RemoteException
          }
        };
      AppMonitor.a().a(runnable);
    }
    
    public static void setSampling(int param1Int) {
      if (!AppMonitor.c())
        return; 
      Runnable runnable = new Runnable(param1Int) {
          public void run() {
            // Byte code:
            //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
            //   3: aload_0
            //   4: getfield c : I
            //   7: invokeinterface alarm_setSampling : (I)V
            //   12: return
            //   13: astore_1
            //   14: aload_1
            //   15: invokestatic b : (Ljava/lang/Exception;)V
            //   18: return
            // Exception table:
            //   from	to	target	type
            //   0	12	13	android/os/RemoteException
          }
        };
      AppMonitor.a().a(runnable);
    }
    
    public static void setStatisticsInterval(int param1Int) {
      if (!AppMonitor.c())
        return; 
      Runnable runnable = new Runnable(param1Int) {
          public void run() {
            // Byte code:
            //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
            //   3: aload_0
            //   4: getfield b : I
            //   7: invokeinterface alarm_setStatisticsInterval : (I)V
            //   12: return
            //   13: astore_1
            //   14: aload_1
            //   15: invokestatic b : (Ljava/lang/Exception;)V
            //   18: return
            // Exception table:
            //   from	to	target	type
            //   0	12	13	android/os/RemoteException
          }
        };
      AppMonitor.a().a(runnable);
    }
  }
  
  static final class null implements Runnable {
    null(int param1Int) {}
    
    public void run() {
      // Byte code:
      //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
      //   3: aload_0
      //   4: getfield b : I
      //   7: invokeinterface alarm_setStatisticsInterval : (I)V
      //   12: return
      //   13: astore_1
      //   14: aload_1
      //   15: invokestatic b : (Ljava/lang/Exception;)V
      //   18: return
      // Exception table:
      //   from	to	target	type
      //   0	12	13	android/os/RemoteException
    }
  }
  
  static final class null implements Runnable {
    null(int param1Int) {}
    
    public void run() {
      // Byte code:
      //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
      //   3: aload_0
      //   4: getfield c : I
      //   7: invokeinterface alarm_setSampling : (I)V
      //   12: return
      //   13: astore_1
      //   14: aload_1
      //   15: invokestatic b : (Ljava/lang/Exception;)V
      //   18: return
      // Exception table:
      //   from	to	target	type
      //   0	12	13	android/os/RemoteException
    }
  }
  
  static final class null implements Runnable {
    null(String param1String1, String param1String2) {}
    
    public void run() {
      // Byte code:
      //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
      //   3: aload_0
      //   4: getfield i : Ljava/lang/String;
      //   7: aload_0
      //   8: getfield j : Ljava/lang/String;
      //   11: invokeinterface alarm_commitSuccess1 : (Ljava/lang/String;Ljava/lang/String;)V
      //   16: return
      //   17: astore_1
      //   18: aload_1
      //   19: invokestatic b : (Ljava/lang/Exception;)V
      //   22: return
      // Exception table:
      //   from	to	target	type
      //   0	16	17	android/os/RemoteException
    }
  }
  
  static final class null implements Runnable {
    null(String param1String1, String param1String2, String param1String3) {}
    
    public void run() {
      // Byte code:
      //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
      //   3: aload_0
      //   4: getfield i : Ljava/lang/String;
      //   7: aload_0
      //   8: getfield j : Ljava/lang/String;
      //   11: aload_0
      //   12: getfield l : Ljava/lang/String;
      //   15: invokeinterface alarm_commitSuccess2 : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
      //   20: return
      //   21: astore_1
      //   22: aload_1
      //   23: invokestatic b : (Ljava/lang/Exception;)V
      //   26: return
      // Exception table:
      //   from	to	target	type
      //   0	20	21	android/os/RemoteException
    }
  }
  
  static final class null implements Runnable {
    null(String param1String1, String param1String2, String param1String3, String param1String4) {}
    
    public void run() {
      // Byte code:
      //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
      //   3: aload_0
      //   4: getfield i : Ljava/lang/String;
      //   7: aload_0
      //   8: getfield j : Ljava/lang/String;
      //   11: aload_0
      //   12: getfield m : Ljava/lang/String;
      //   15: aload_0
      //   16: getfield n : Ljava/lang/String;
      //   19: invokeinterface alarm_commitFail1 : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
      //   24: return
      //   25: astore_1
      //   26: aload_1
      //   27: invokestatic b : (Ljava/lang/Exception;)V
      //   30: return
      // Exception table:
      //   from	to	target	type
      //   0	24	25	android/os/RemoteException
    }
  }
  
  static final class null implements Runnable {
    null(String param1String1, String param1String2, String param1String3, String param1String4, String param1String5) {}
    
    public void run() {
      // Byte code:
      //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
      //   3: aload_0
      //   4: getfield i : Ljava/lang/String;
      //   7: aload_0
      //   8: getfield j : Ljava/lang/String;
      //   11: aload_0
      //   12: getfield l : Ljava/lang/String;
      //   15: aload_0
      //   16: getfield m : Ljava/lang/String;
      //   19: aload_0
      //   20: getfield n : Ljava/lang/String;
      //   23: invokeinterface alarm_commitFail2 : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
      //   28: return
      //   29: astore_1
      //   30: aload_1
      //   31: invokestatic b : (Ljava/lang/Exception;)V
      //   34: return
      // Exception table:
      //   from	to	target	type
      //   0	28	29	android/os/RemoteException
    }
  }
  
  public static class Counter {
    @Deprecated
    public static boolean checkSampled(String param1String1, String param1String2) {
      // Byte code:
      //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
      //   3: ifnonnull -> 8
      //   6: iconst_0
      //   7: ireturn
      //   8: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
      //   11: aload_0
      //   12: aload_1
      //   13: invokeinterface counter_checkSampled : (Ljava/lang/String;Ljava/lang/String;)Z
      //   18: istore_2
      //   19: iload_2
      //   20: ireturn
      //   21: astore_0
      //   22: aload_0
      //   23: invokestatic b : (Ljava/lang/Exception;)V
      //   26: iconst_0
      //   27: ireturn
      // Exception table:
      //   from	to	target	type
      //   8	19	21	android/os/RemoteException
    }
    
    public static void commit(String param1String1, String param1String2, double param1Double) {
      if (!AppMonitor.c())
        return; 
      Runnable runnable = new Runnable(param1String1, param1String2, param1Double) {
          public void run() {
            // Byte code:
            //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
            //   3: aload_0
            //   4: getfield i : Ljava/lang/String;
            //   7: aload_0
            //   8: getfield j : Ljava/lang/String;
            //   11: aload_0
            //   12: getfield d : D
            //   15: invokeinterface counter_commit1 : (Ljava/lang/String;Ljava/lang/String;D)V
            //   20: return
            //   21: astore_1
            //   22: aload_1
            //   23: invokestatic b : (Ljava/lang/Exception;)V
            //   26: return
            // Exception table:
            //   from	to	target	type
            //   0	20	21	android/os/RemoteException
          }
        };
      AppMonitor.a().a(runnable);
    }
    
    public static void commit(String param1String1, String param1String2, String param1String3, double param1Double) {
      if (!AppMonitor.c())
        return; 
      Runnable runnable = new Runnable(param1String1, param1String2, param1String3, param1Double) {
          public void run() {
            // Byte code:
            //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
            //   3: aload_0
            //   4: getfield i : Ljava/lang/String;
            //   7: aload_0
            //   8: getfield j : Ljava/lang/String;
            //   11: aload_0
            //   12: getfield l : Ljava/lang/String;
            //   15: aload_0
            //   16: getfield d : D
            //   19: invokeinterface counter_commit2 : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;D)V
            //   24: return
            //   25: astore_1
            //   26: aload_1
            //   27: invokestatic b : (Ljava/lang/Exception;)V
            //   30: return
            // Exception table:
            //   from	to	target	type
            //   0	24	25	android/os/RemoteException
          }
        };
      AppMonitor.a().a(runnable);
    }
    
    public static void setSampling(int param1Int) {
      if (!AppMonitor.c())
        return; 
      Runnable runnable = new Runnable(param1Int) {
          public void run() {
            // Byte code:
            //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
            //   3: aload_0
            //   4: getfield c : I
            //   7: invokeinterface counter_setSampling : (I)V
            //   12: return
            //   13: astore_1
            //   14: aload_1
            //   15: invokestatic b : (Ljava/lang/Exception;)V
            //   18: return
            // Exception table:
            //   from	to	target	type
            //   0	12	13	android/os/RemoteException
          }
        };
      AppMonitor.a().a(runnable);
    }
    
    public static void setStatisticsInterval(int param1Int) {
      if (!AppMonitor.c())
        return; 
      Runnable runnable = new Runnable(param1Int) {
          public void run() {
            // Byte code:
            //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
            //   3: aload_0
            //   4: getfield b : I
            //   7: invokeinterface counter_setStatisticsInterval : (I)V
            //   12: return
            //   13: astore_1
            //   14: aload_1
            //   15: invokestatic b : (Ljava/lang/Exception;)V
            //   18: return
            // Exception table:
            //   from	to	target	type
            //   0	12	13	android/os/RemoteException
          }
        };
      AppMonitor.a().a(runnable);
    }
  }
  
  static final class null implements Runnable {
    null(int param1Int) {}
    
    public void run() {
      // Byte code:
      //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
      //   3: aload_0
      //   4: getfield b : I
      //   7: invokeinterface counter_setStatisticsInterval : (I)V
      //   12: return
      //   13: astore_1
      //   14: aload_1
      //   15: invokestatic b : (Ljava/lang/Exception;)V
      //   18: return
      // Exception table:
      //   from	to	target	type
      //   0	12	13	android/os/RemoteException
    }
  }
  
  static final class null implements Runnable {
    null(int param1Int) {}
    
    public void run() {
      // Byte code:
      //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
      //   3: aload_0
      //   4: getfield c : I
      //   7: invokeinterface counter_setSampling : (I)V
      //   12: return
      //   13: astore_1
      //   14: aload_1
      //   15: invokestatic b : (Ljava/lang/Exception;)V
      //   18: return
      // Exception table:
      //   from	to	target	type
      //   0	12	13	android/os/RemoteException
    }
  }
  
  static final class null implements Runnable {
    null(String param1String1, String param1String2, double param1Double) {}
    
    public void run() {
      // Byte code:
      //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
      //   3: aload_0
      //   4: getfield i : Ljava/lang/String;
      //   7: aload_0
      //   8: getfield j : Ljava/lang/String;
      //   11: aload_0
      //   12: getfield d : D
      //   15: invokeinterface counter_commit1 : (Ljava/lang/String;Ljava/lang/String;D)V
      //   20: return
      //   21: astore_1
      //   22: aload_1
      //   23: invokestatic b : (Ljava/lang/Exception;)V
      //   26: return
      // Exception table:
      //   from	to	target	type
      //   0	20	21	android/os/RemoteException
    }
  }
  
  static final class null implements Runnable {
    null(String param1String1, String param1String2, String param1String3, double param1Double) {}
    
    public void run() {
      // Byte code:
      //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
      //   3: aload_0
      //   4: getfield i : Ljava/lang/String;
      //   7: aload_0
      //   8: getfield j : Ljava/lang/String;
      //   11: aload_0
      //   12: getfield l : Ljava/lang/String;
      //   15: aload_0
      //   16: getfield d : D
      //   19: invokeinterface counter_commit2 : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;D)V
      //   24: return
      //   25: astore_1
      //   26: aload_1
      //   27: invokestatic b : (Ljava/lang/Exception;)V
      //   30: return
      // Exception table:
      //   from	to	target	type
      //   0	24	25	android/os/RemoteException
    }
  }
  
  public static class OffLineCounter {
    @Deprecated
    public static boolean checkSampled(String param1String1, String param1String2) {
      // Byte code:
      //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
      //   3: ifnonnull -> 8
      //   6: iconst_0
      //   7: ireturn
      //   8: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
      //   11: aload_0
      //   12: aload_1
      //   13: invokeinterface offlinecounter_checkSampled : (Ljava/lang/String;Ljava/lang/String;)Z
      //   18: istore_2
      //   19: iload_2
      //   20: ireturn
      //   21: astore_0
      //   22: aload_0
      //   23: invokestatic b : (Ljava/lang/Exception;)V
      //   26: iconst_0
      //   27: ireturn
      // Exception table:
      //   from	to	target	type
      //   8	19	21	android/os/RemoteException
    }
    
    public static void commit(String param1String1, String param1String2, double param1Double) {
      if (!AppMonitor.c())
        return; 
      Runnable runnable = new Runnable(param1String1, param1String2, param1Double) {
          public void run() {
            // Byte code:
            //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
            //   3: aload_0
            //   4: getfield i : Ljava/lang/String;
            //   7: aload_0
            //   8: getfield j : Ljava/lang/String;
            //   11: aload_0
            //   12: getfield d : D
            //   15: invokeinterface offlinecounter_commit : (Ljava/lang/String;Ljava/lang/String;D)V
            //   20: return
            //   21: astore_1
            //   22: aload_1
            //   23: invokestatic b : (Ljava/lang/Exception;)V
            //   26: return
            // Exception table:
            //   from	to	target	type
            //   0	20	21	android/os/RemoteException
          }
        };
      AppMonitor.a().a(runnable);
    }
    
    public static void setSampling(int param1Int) {
      if (!AppMonitor.c())
        return; 
      Runnable runnable = new Runnable(param1Int) {
          public void run() {
            // Byte code:
            //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
            //   3: aload_0
            //   4: getfield c : I
            //   7: invokeinterface offlinecounter_setSampling : (I)V
            //   12: return
            //   13: astore_1
            //   14: aload_1
            //   15: invokestatic b : (Ljava/lang/Exception;)V
            //   18: return
            // Exception table:
            //   from	to	target	type
            //   0	12	13	android/os/RemoteException
          }
        };
      AppMonitor.a().a(runnable);
    }
    
    public static void setStatisticsInterval(int param1Int) {
      if (!AppMonitor.c())
        return; 
      Runnable runnable = new Runnable(param1Int) {
          public void run() {
            // Byte code:
            //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
            //   3: aload_0
            //   4: getfield b : I
            //   7: invokeinterface offlinecounter_setStatisticsInterval : (I)V
            //   12: return
            //   13: astore_1
            //   14: aload_1
            //   15: invokestatic b : (Ljava/lang/Exception;)V
            //   18: return
            // Exception table:
            //   from	to	target	type
            //   0	12	13	android/os/RemoteException
          }
        };
      AppMonitor.a().a(runnable);
    }
  }
  
  static final class null implements Runnable {
    null(int param1Int) {}
    
    public void run() {
      // Byte code:
      //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
      //   3: aload_0
      //   4: getfield b : I
      //   7: invokeinterface offlinecounter_setStatisticsInterval : (I)V
      //   12: return
      //   13: astore_1
      //   14: aload_1
      //   15: invokestatic b : (Ljava/lang/Exception;)V
      //   18: return
      // Exception table:
      //   from	to	target	type
      //   0	12	13	android/os/RemoteException
    }
  }
  
  static final class null implements Runnable {
    null(int param1Int) {}
    
    public void run() {
      // Byte code:
      //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
      //   3: aload_0
      //   4: getfield c : I
      //   7: invokeinterface offlinecounter_setSampling : (I)V
      //   12: return
      //   13: astore_1
      //   14: aload_1
      //   15: invokestatic b : (Ljava/lang/Exception;)V
      //   18: return
      // Exception table:
      //   from	to	target	type
      //   0	12	13	android/os/RemoteException
    }
  }
  
  static final class null implements Runnable {
    null(String param1String1, String param1String2, double param1Double) {}
    
    public void run() {
      // Byte code:
      //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
      //   3: aload_0
      //   4: getfield i : Ljava/lang/String;
      //   7: aload_0
      //   8: getfield j : Ljava/lang/String;
      //   11: aload_0
      //   12: getfield d : D
      //   15: invokeinterface offlinecounter_commit : (Ljava/lang/String;Ljava/lang/String;D)V
      //   20: return
      //   21: astore_1
      //   22: aload_1
      //   23: invokestatic b : (Ljava/lang/Exception;)V
      //   26: return
      // Exception table:
      //   from	to	target	type
      //   0	20	21	android/os/RemoteException
    }
  }
  
  public static class Stat {
    public static void begin(String param1String1, String param1String2, String param1String3) {
      if (!AppMonitor.c())
        return; 
      Runnable runnable = new Runnable(param1String1, param1String2, param1String3) {
          public void run() {
            // Byte code:
            //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
            //   3: aload_0
            //   4: getfield i : Ljava/lang/String;
            //   7: aload_0
            //   8: getfield j : Ljava/lang/String;
            //   11: aload_0
            //   12: getfield q : Ljava/lang/String;
            //   15: invokeinterface stat_begin : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
            //   20: return
            //   21: astore_1
            //   22: aload_1
            //   23: invokestatic b : (Ljava/lang/Exception;)V
            //   26: return
            // Exception table:
            //   from	to	target	type
            //   0	20	21	android/os/RemoteException
          }
        };
      AppMonitor.a().a(runnable);
    }
    
    public static boolean checkSampled(String param1String1, String param1String2) {
      // Byte code:
      //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
      //   3: ifnonnull -> 8
      //   6: iconst_0
      //   7: ireturn
      //   8: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
      //   11: aload_0
      //   12: aload_1
      //   13: invokeinterface stat_checkSampled : (Ljava/lang/String;Ljava/lang/String;)Z
      //   18: istore_2
      //   19: iload_2
      //   20: ireturn
      //   21: astore_0
      //   22: aload_0
      //   23: invokestatic b : (Ljava/lang/Exception;)V
      //   26: iconst_0
      //   27: ireturn
      // Exception table:
      //   from	to	target	type
      //   8	19	21	android/os/RemoteException
    }
    
    public static void commit(String param1String1, String param1String2, double param1Double) {
      commit(param1String1, param1String2, (DimensionValueSet)null, param1Double);
    }
    
    public static void commit(String param1String1, String param1String2, DimensionValueSet param1DimensionValueSet, double param1Double) {
      if (!AppMonitor.c())
        return; 
      Runnable runnable = new Runnable(param1String1, param1String2, param1DimensionValueSet, param1Double) {
          public void run() {
            // Byte code:
            //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
            //   3: aload_0
            //   4: getfield i : Ljava/lang/String;
            //   7: aload_0
            //   8: getfield j : Ljava/lang/String;
            //   11: aload_0
            //   12: getfield a : Lcom/alibaba/mtl/appmonitor/model/DimensionValueSet;
            //   15: aload_0
            //   16: getfield d : D
            //   19: invokeinterface stat_commit2 : (Ljava/lang/String;Ljava/lang/String;Lcom/alibaba/mtl/appmonitor/model/DimensionValueSet;D)V
            //   24: return
            //   25: astore_1
            //   26: aload_1
            //   27: invokestatic b : (Ljava/lang/Exception;)V
            //   30: return
            // Exception table:
            //   from	to	target	type
            //   0	24	25	android/os/RemoteException
          }
        };
      AppMonitor.a().a(runnable);
    }
    
    public static void commit(String param1String1, String param1String2, DimensionValueSet param1DimensionValueSet, MeasureValueSet param1MeasureValueSet) {
      if (!AppMonitor.c())
        return; 
      Runnable runnable = new Runnable(param1String1, param1String2, param1DimensionValueSet, param1MeasureValueSet) {
          public void run() {
            // Byte code:
            //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
            //   3: aload_0
            //   4: getfield i : Ljava/lang/String;
            //   7: aload_0
            //   8: getfield j : Ljava/lang/String;
            //   11: aload_0
            //   12: getfield a : Lcom/alibaba/mtl/appmonitor/model/DimensionValueSet;
            //   15: aload_0
            //   16: getfield a : Lcom/alibaba/mtl/appmonitor/model/MeasureValueSet;
            //   19: invokeinterface stat_commit3 : (Ljava/lang/String;Ljava/lang/String;Lcom/alibaba/mtl/appmonitor/model/DimensionValueSet;Lcom/alibaba/mtl/appmonitor/model/MeasureValueSet;)V
            //   24: return
            //   25: astore_1
            //   26: aload_1
            //   27: invokestatic b : (Ljava/lang/Exception;)V
            //   30: return
            // Exception table:
            //   from	to	target	type
            //   0	24	25	android/os/RemoteException
          }
        };
      AppMonitor.a().a(runnable);
    }
    
    public static void commit(String param1String1, String param1String2, String[] param1ArrayOfString1, String[] param1ArrayOfString2, String[] param1ArrayOfString3, String[] param1ArrayOfString4) {
      DimensionValueSet dimensionValueSet;
      i.a("AppMonitor", new Object[] { "[commit from jni]" });
      String[] arrayOfString = null;
      if (param1ArrayOfString1 != null && param1ArrayOfString2 != null && param1ArrayOfString1.length == param1ArrayOfString2.length) {
        DimensionValueSet dimensionValueSet1 = DimensionValueSet.create();
        int i = 0;
        while (true) {
          dimensionValueSet = dimensionValueSet1;
          if (i < param1ArrayOfString2.length) {
            dimensionValueSet1.setValue(param1ArrayOfString1[i], param1ArrayOfString2[i]);
            i++;
            continue;
          } 
          break;
        } 
      } else {
        dimensionValueSet = null;
      } 
      if (param1ArrayOfString3 != null && param1ArrayOfString4 != null && param1ArrayOfString3.length == param1ArrayOfString4.length) {
        MeasureValueSet measureValueSet = MeasureValueSet.create();
        int i = 0;
        while (true) {
          StringBuilder stringBuilder;
          MeasureValueSet measureValueSet1 = measureValueSet;
          if (i < param1ArrayOfString4.length) {
            double d2 = 0.0D;
            double d1 = d2;
            if (!TextUtils.isEmpty(param1ArrayOfString4[i]))
              try {
                d1 = Double.valueOf(param1ArrayOfString4[i]).doubleValue();
              } catch (Exception exception) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("measure's value cannot convert to double. measurevalue:");
                stringBuilder.append(param1ArrayOfString4[i]);
                i.a("AppMonitor", new Object[] { stringBuilder.toString() });
                d1 = d2;
              }  
            measureValueSet.setValue(param1ArrayOfString3[i], d1);
            i++;
            continue;
          } 
          commit(param1String1, param1String2, dimensionValueSet, (MeasureValueSet)stringBuilder);
          return;
        } 
      } 
      i.a("AppMonitor", new Object[] { "measure is null ,or lenght not match" });
      param1ArrayOfString1 = arrayOfString;
      commit(param1String1, param1String2, dimensionValueSet, (MeasureValueSet)param1ArrayOfString1);
    }
    
    public static Transaction createTransaction(String param1String1, String param1String2) {
      return createTransaction(param1String1, param1String2, null);
    }
    
    public static Transaction createTransaction(String param1String1, String param1String2, DimensionValueSet param1DimensionValueSet) {
      return new Transaction(Integer.valueOf(f.d.a()), param1String1, param1String2, param1DimensionValueSet);
    }
    
    public static void end(String param1String1, String param1String2, String param1String3) {
      if (!AppMonitor.c())
        return; 
      Runnable runnable = new Runnable(param1String1, param1String2, param1String3) {
          public void run() {
            // Byte code:
            //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
            //   3: aload_0
            //   4: getfield i : Ljava/lang/String;
            //   7: aload_0
            //   8: getfield j : Ljava/lang/String;
            //   11: aload_0
            //   12: getfield q : Ljava/lang/String;
            //   15: invokeinterface stat_end : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
            //   20: return
            //   21: astore_1
            //   22: aload_1
            //   23: invokestatic b : (Ljava/lang/Exception;)V
            //   26: return
            // Exception table:
            //   from	to	target	type
            //   0	20	21	android/os/RemoteException
          }
        };
      AppMonitor.a().a(runnable);
    }
    
    public static void setSampling(int param1Int) {
      if (!AppMonitor.c())
        return; 
      Runnable runnable = new Runnable(param1Int) {
          public void run() {
            // Byte code:
            //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
            //   3: aload_0
            //   4: getfield c : I
            //   7: invokeinterface stat_setSampling : (I)V
            //   12: return
            //   13: astore_1
            //   14: aload_1
            //   15: invokestatic b : (Ljava/lang/Exception;)V
            //   18: return
            // Exception table:
            //   from	to	target	type
            //   0	12	13	android/os/RemoteException
          }
        };
      AppMonitor.a().a(runnable);
    }
    
    public static void setStatisticsInterval(int param1Int) {
      if (!AppMonitor.c())
        return; 
      Runnable runnable = new Runnable(param1Int) {
          public void run() {
            // Byte code:
            //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
            //   3: aload_0
            //   4: getfield b : I
            //   7: invokeinterface stat_setStatisticsInterval : (I)V
            //   12: return
            //   13: astore_1
            //   14: aload_1
            //   15: invokestatic b : (Ljava/lang/Exception;)V
            //   18: return
            // Exception table:
            //   from	to	target	type
            //   0	12	13	android/os/RemoteException
          }
        };
      AppMonitor.a().a(runnable);
    }
  }
  
  static final class null implements Runnable {
    null(int param1Int) {}
    
    public void run() {
      // Byte code:
      //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
      //   3: aload_0
      //   4: getfield b : I
      //   7: invokeinterface stat_setStatisticsInterval : (I)V
      //   12: return
      //   13: astore_1
      //   14: aload_1
      //   15: invokestatic b : (Ljava/lang/Exception;)V
      //   18: return
      // Exception table:
      //   from	to	target	type
      //   0	12	13	android/os/RemoteException
    }
  }
  
  static final class null implements Runnable {
    null(int param1Int) {}
    
    public void run() {
      // Byte code:
      //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
      //   3: aload_0
      //   4: getfield c : I
      //   7: invokeinterface stat_setSampling : (I)V
      //   12: return
      //   13: astore_1
      //   14: aload_1
      //   15: invokestatic b : (Ljava/lang/Exception;)V
      //   18: return
      // Exception table:
      //   from	to	target	type
      //   0	12	13	android/os/RemoteException
    }
  }
  
  static final class null implements Runnable {
    null(String param1String1, String param1String2, String param1String3) {}
    
    public void run() {
      // Byte code:
      //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
      //   3: aload_0
      //   4: getfield i : Ljava/lang/String;
      //   7: aload_0
      //   8: getfield j : Ljava/lang/String;
      //   11: aload_0
      //   12: getfield q : Ljava/lang/String;
      //   15: invokeinterface stat_begin : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
      //   20: return
      //   21: astore_1
      //   22: aload_1
      //   23: invokestatic b : (Ljava/lang/Exception;)V
      //   26: return
      // Exception table:
      //   from	to	target	type
      //   0	20	21	android/os/RemoteException
    }
  }
  
  static final class null implements Runnable {
    null(String param1String1, String param1String2, String param1String3) {}
    
    public void run() {
      // Byte code:
      //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
      //   3: aload_0
      //   4: getfield i : Ljava/lang/String;
      //   7: aload_0
      //   8: getfield j : Ljava/lang/String;
      //   11: aload_0
      //   12: getfield q : Ljava/lang/String;
      //   15: invokeinterface stat_end : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
      //   20: return
      //   21: astore_1
      //   22: aload_1
      //   23: invokestatic b : (Ljava/lang/Exception;)V
      //   26: return
      // Exception table:
      //   from	to	target	type
      //   0	20	21	android/os/RemoteException
    }
  }
  
  static final class null implements Runnable {
    null(String param1String1, String param1String2, DimensionValueSet param1DimensionValueSet, double param1Double) {}
    
    public void run() {
      // Byte code:
      //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
      //   3: aload_0
      //   4: getfield i : Ljava/lang/String;
      //   7: aload_0
      //   8: getfield j : Ljava/lang/String;
      //   11: aload_0
      //   12: getfield a : Lcom/alibaba/mtl/appmonitor/model/DimensionValueSet;
      //   15: aload_0
      //   16: getfield d : D
      //   19: invokeinterface stat_commit2 : (Ljava/lang/String;Ljava/lang/String;Lcom/alibaba/mtl/appmonitor/model/DimensionValueSet;D)V
      //   24: return
      //   25: astore_1
      //   26: aload_1
      //   27: invokestatic b : (Ljava/lang/Exception;)V
      //   30: return
      // Exception table:
      //   from	to	target	type
      //   0	24	25	android/os/RemoteException
    }
  }
  
  static final class null implements Runnable {
    null(String param1String1, String param1String2, DimensionValueSet param1DimensionValueSet, MeasureValueSet param1MeasureValueSet) {}
    
    public void run() {
      // Byte code:
      //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
      //   3: aload_0
      //   4: getfield i : Ljava/lang/String;
      //   7: aload_0
      //   8: getfield j : Ljava/lang/String;
      //   11: aload_0
      //   12: getfield a : Lcom/alibaba/mtl/appmonitor/model/DimensionValueSet;
      //   15: aload_0
      //   16: getfield a : Lcom/alibaba/mtl/appmonitor/model/MeasureValueSet;
      //   19: invokeinterface stat_commit3 : (Ljava/lang/String;Ljava/lang/String;Lcom/alibaba/mtl/appmonitor/model/DimensionValueSet;Lcom/alibaba/mtl/appmonitor/model/MeasureValueSet;)V
      //   24: return
      //   25: astore_1
      //   26: aload_1
      //   27: invokestatic b : (Ljava/lang/Exception;)V
      //   30: return
      // Exception table:
      //   from	to	target	type
      //   0	24	25	android/os/RemoteException
    }
  }
  
  static class a {
    public DimensionSet b;
    
    public MeasureSet b;
    
    public boolean g;
    
    public String o;
    
    public String p;
  }
  
  enum b {
    b, c;
    
    static {
    
    }
  }
  
  static class c extends Handler {
    private boolean h = false;
    
    public c(Looper param1Looper) {
      super(param1Looper);
    }
    
    public void a(Runnable param1Runnable) {
      if (param1Runnable == null)
        return; 
      try {
        Message message = Message.obtain();
        message.what = 1;
        message.obj = param1Runnable;
        return;
      } finally {
        param1Runnable = null;
      } 
    }
    
    public void a(boolean param1Boolean) {
      this.h = true;
    }
    
    public void handleMessage(Message param1Message) {
      try {
        if (this.h) {
          this.h = false;
          synchronized (AppMonitor.a()) {
            AppMonitor.a().wait(5000L);
          } 
          /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_2} */
        } 
        if (param1Message.obj != null && param1Message.obj instanceof Runnable)
          ((Runnable)param1Message.obj).run(); 
      } finally {
        Exception exception;
      } 
      super.handleMessage(param1Message);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\AppMonitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */