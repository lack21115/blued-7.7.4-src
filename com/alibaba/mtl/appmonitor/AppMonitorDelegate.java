package com.alibaba.mtl.appmonitor;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.appmonitor.b.a;
import com.alibaba.mtl.appmonitor.b.b;
import com.alibaba.mtl.appmonitor.d.j;
import com.alibaba.mtl.appmonitor.f.b;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.mtl.appmonitor.model.Metric;
import com.alibaba.mtl.appmonitor.model.MetricRepo;
import com.alibaba.mtl.log.a;
import com.alibaba.mtl.log.a.a;
import com.alibaba.mtl.log.b.a;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.sign.BaseRequestAuth;
import com.alibaba.mtl.log.sign.IRequestAuth;
import com.alibaba.mtl.log.sign.SecurityRequestAuth;
import java.util.HashMap;
import java.util.Map;

public final class AppMonitorDelegate {
  public static final String DEFAULT_VALUE = "defaultValue";
  
  public static boolean IS_DEBUG = false;
  
  public static final String MAX_VALUE = "maxValue";
  
  public static final String MIN_VALUE = "minValue";
  
  public static final String TAG = "AppMonitorDelegate";
  
  private static Application b;
  
  static volatile boolean i = false;
  
  public static void destroy() {
    // Byte code:
    //   0: ldc com/alibaba/mtl/appmonitor/AppMonitorDelegate
    //   2: monitorenter
    //   3: ldc 'AppMonitorDelegate'
    //   5: iconst_1
    //   6: anewarray java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: ldc 'start destory'
    //   13: aastore
    //   14: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   17: getstatic com/alibaba/mtl/appmonitor/AppMonitorDelegate.i : Z
    //   20: ifeq -> 59
    //   23: invokestatic e : ()V
    //   26: invokestatic destroy : ()V
    //   29: invokestatic destroy : ()V
    //   32: getstatic com/alibaba/mtl/appmonitor/AppMonitorDelegate.b : Landroid/app/Application;
    //   35: ifnull -> 47
    //   38: getstatic com/alibaba/mtl/appmonitor/AppMonitorDelegate.b : Landroid/app/Application;
    //   41: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   44: invokestatic b : (Landroid/content/Context;)V
    //   47: iconst_0
    //   48: putstatic com/alibaba/mtl/appmonitor/AppMonitorDelegate.i : Z
    //   51: goto -> 59
    //   54: astore_0
    //   55: aload_0
    //   56: invokestatic a : (Ljava/lang/Throwable;)V
    //   59: ldc com/alibaba/mtl/appmonitor/AppMonitorDelegate
    //   61: monitorexit
    //   62: return
    //   63: astore_0
    //   64: ldc com/alibaba/mtl/appmonitor/AppMonitorDelegate
    //   66: monitorexit
    //   67: aload_0
    //   68: athrow
    // Exception table:
    //   from	to	target	type
    //   3	47	54	finally
    //   47	51	54	finally
    //   55	59	63	finally
  }
  
  public static void enableLog(boolean paramBoolean) {
    i.a("AppMonitorDelegate", new Object[] { "[enableLog]" });
    i.d(paramBoolean);
  }
  
  public static void init(Application paramApplication) {
    // Byte code:
    //   0: ldc com/alibaba/mtl/appmonitor/AppMonitorDelegate
    //   2: monitorenter
    //   3: ldc 'AppMonitorDelegate'
    //   5: iconst_1
    //   6: anewarray java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: ldc 'start init'
    //   13: aastore
    //   14: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   17: getstatic com/alibaba/mtl/appmonitor/AppMonitorDelegate.i : Z
    //   20: ifne -> 61
    //   23: aload_0
    //   24: putstatic com/alibaba/mtl/appmonitor/AppMonitorDelegate.b : Landroid/app/Application;
    //   27: aload_0
    //   28: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   31: invokestatic init : (Landroid/content/Context;)V
    //   34: invokestatic init : ()V
    //   37: invokestatic init : ()V
    //   40: aload_0
    //   41: invokestatic init : (Landroid/app/Application;)V
    //   44: aload_0
    //   45: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   48: invokestatic a : (Landroid/content/Context;)V
    //   51: iconst_1
    //   52: putstatic com/alibaba/mtl/appmonitor/AppMonitorDelegate.i : Z
    //   55: goto -> 61
    //   58: invokestatic destroy : ()V
    //   61: ldc com/alibaba/mtl/appmonitor/AppMonitorDelegate
    //   63: monitorexit
    //   64: return
    //   65: astore_0
    //   66: ldc com/alibaba/mtl/appmonitor/AppMonitorDelegate
    //   68: monitorexit
    //   69: aload_0
    //   70: athrow
    //   71: astore_0
    //   72: goto -> 58
    // Exception table:
    //   from	to	target	type
    //   3	17	65	finally
    //   17	55	71	finally
    //   58	61	65	finally
  }
  
  public static void register(String paramString1, String paramString2, MeasureSet paramMeasureSet) {
    register(paramString1, paramString2, paramMeasureSet, (DimensionSet)null);
  }
  
  public static void register(String paramString1, String paramString2, MeasureSet paramMeasureSet, DimensionSet paramDimensionSet) {
    register(paramString1, paramString2, paramMeasureSet, paramDimensionSet, false);
  }
  
  public static void register(String paramString1, String paramString2, MeasureSet paramMeasureSet, DimensionSet paramDimensionSet, boolean paramBoolean) {
    try {
      if (i) {
        if (b.isBlank(paramString1) || b.isBlank(paramString2)) {
          i.a("AppMonitorDelegate", new Object[] { "register stat event. module: ", paramString1, " monitorPoint: ", paramString2 });
          if (!IS_DEBUG)
            return; 
          throw new a("register error. module and monitorPoint can't be null");
        } 
        Metric metric = new Metric(paramString1, paramString2, paramMeasureSet, paramDimensionSet, paramBoolean);
        return;
      } 
    } finally {
      paramString1 = null;
    } 
  }
  
  public static void register(String paramString1, String paramString2, MeasureSet paramMeasureSet, boolean paramBoolean) {
    register(paramString1, paramString2, paramMeasureSet, null, paramBoolean);
  }
  
  public static void setChannel(String paramString) {
    a.setChannel(paramString);
  }
  
  public static void setRequestAuthInfo(boolean paramBoolean, String paramString1, String paramString2, String paramString3) {
    SecurityRequestAuth securityRequestAuth;
    BaseRequestAuth baseRequestAuth;
    if (paramBoolean) {
      securityRequestAuth = new SecurityRequestAuth(paramString1, paramString3);
    } else {
      baseRequestAuth = new BaseRequestAuth((String)securityRequestAuth, paramString2);
    } 
    a.a((IRequestAuth)baseRequestAuth);
    a.init((Context)b);
  }
  
  public static void setSampling(int paramInt) {
    int i = 0;
    i.a("AppMonitorDelegate", new Object[] { "[setSampling]" });
    f[] arrayOfF = f.a();
    int j = arrayOfF.length;
    while (i < j) {
      f f = arrayOfF[i];
      f.c(paramInt);
      j.a().a(f, paramInt);
      i++;
    } 
  }
  
  public static void setStatisticsInterval(int paramInt) {
    for (f f : f.a()) {
      f.setStatisticsInterval(paramInt);
      setStatisticsInterval(f, paramInt);
    } 
  }
  
  static void setStatisticsInterval(f paramf, int paramInt) {
    try {
      if (i && paramf != null) {
        c.a(paramf.a(), paramInt);
        if (paramInt > 0)
          return; 
        return;
      } 
    } finally {
      paramf = null;
    } 
  }
  
  public static void triggerUpload() {
    // Byte code:
    //   0: ldc com/alibaba/mtl/appmonitor/AppMonitorDelegate
    //   2: monitorenter
    //   3: ldc 'AppMonitorDelegate'
    //   5: iconst_1
    //   6: anewarray java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: ldc 'triggerUpload'
    //   13: aastore
    //   14: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   17: getstatic com/alibaba/mtl/appmonitor/AppMonitorDelegate.i : Z
    //   20: ifeq -> 40
    //   23: invokestatic h : ()Z
    //   26: ifeq -> 40
    //   29: invokestatic e : ()V
    //   32: goto -> 40
    //   35: astore_0
    //   36: aload_0
    //   37: invokestatic a : (Ljava/lang/Throwable;)V
    //   40: ldc com/alibaba/mtl/appmonitor/AppMonitorDelegate
    //   42: monitorexit
    //   43: return
    //   44: astore_0
    //   45: ldc com/alibaba/mtl/appmonitor/AppMonitorDelegate
    //   47: monitorexit
    //   48: aload_0
    //   49: athrow
    // Exception table:
    //   from	to	target	type
    //   3	32	35	finally
    //   36	40	44	finally
  }
  
  public static void turnOffRealTimeDebug() {
    i.a("AppMonitorDelegate", new Object[] { "[turnOffRealTimeDebug]" });
  }
  
  public static void turnOnRealTimeDebug(Map<String, String> paramMap) {
    a.turnOnRealTimeDebug(paramMap);
  }
  
  public static void updateMeasure(String paramString1, String paramString2, String paramString3, double paramDouble1, double paramDouble2, double paramDouble3) {
    i.a("AppMonitorDelegate", new Object[] { "[updateMeasure]" });
    try {
      if (i && !b.isBlank(paramString1)) {
        if (b.isBlank(paramString2))
          return; 
        Metric metric = MetricRepo.getRepo().getMetric(paramString1, paramString2);
        if (metric != null && metric.getMeasureSet() != null)
          metric.getMeasureSet().upateMeasure(new Measure(paramString3, Double.valueOf(paramDouble3), Double.valueOf(paramDouble1), Double.valueOf(paramDouble2))); 
      } 
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public static class Alarm {
    @Deprecated
    public static boolean checkSampled(String param1String1, String param1String2) {
      return j.a(f.a, param1String1, param1String2);
    }
    
    public static void commitFail(String param1String1, String param1String2, String param1String3, String param1String4) {
      commitFail(param1String1, param1String2, null, param1String3, param1String4);
    }
    
    public static void commitFail(String param1String1, String param1String2, String param1String3, String param1String4, String param1String5) {
      try {
        boolean bool = TextUtils.isEmpty(param1String1);
        if (bool || TextUtils.isEmpty(param1String2))
          return; 
        a.B();
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        hashMap.put("_status", "0");
        return;
      } finally {
        param1String1 = null;
        b.a((Throwable)param1String1);
      } 
    }
    
    public static void commitSuccess(String param1String1, String param1String2) {
      commitSuccess(param1String1, param1String2, null);
    }
    
    public static void commitSuccess(String param1String1, String param1String2, String param1String3) {
      try {
        boolean bool = TextUtils.isEmpty(param1String1);
        if (bool || TextUtils.isEmpty(param1String2))
          return; 
        a.B();
        return;
      } finally {
        param1String1 = null;
        b.a((Throwable)param1String1);
      } 
    }
    
    public static void setSampling(int param1Int) {
      j.a().a(f.a, param1Int);
    }
    
    public static void setStatisticsInterval(int param1Int) {
      f.a.setStatisticsInterval(param1Int);
      AppMonitorDelegate.setStatisticsInterval(f.a, param1Int);
    }
  }
  
  public static class Counter {
    @Deprecated
    public static boolean checkSampled(String param1String1, String param1String2) {
      return j.a(f.b, param1String1, param1String2);
    }
    
    public static void commit(String param1String1, String param1String2, double param1Double) {
      commit(param1String1, param1String2, null, param1Double);
    }
    
    public static void commit(String param1String1, String param1String2, String param1String3, double param1Double) {
      try {
        boolean bool = TextUtils.isEmpty(param1String1);
        if (bool || TextUtils.isEmpty(param1String2))
          return; 
        a.z();
      } finally {
        param1String1 = null;
      } 
    }
    
    public static void setSampling(int param1Int) {
      j.a().a(f.b, param1Int);
    }
    
    public static void setStatisticsInterval(int param1Int) {
      f.b.setStatisticsInterval(param1Int);
      AppMonitorDelegate.setStatisticsInterval(f.b, param1Int);
    }
  }
  
  public static class OffLineCounter {
    @Deprecated
    public static boolean checkSampled(String param1String1, String param1String2) {
      return j.a(f.c, param1String1, param1String2);
    }
    
    public static void commit(String param1String1, String param1String2, double param1Double) {
      try {
        boolean bool = TextUtils.isEmpty(param1String1);
        if (bool || TextUtils.isEmpty(param1String2))
          return; 
        a.x();
      } finally {
        param1String1 = null;
      } 
    }
    
    public static void setSampling(int param1Int) {
      j.a().a(f.c, param1Int);
    }
    
    public static void setStatisticsInterval(int param1Int) {
      f.c.setStatisticsInterval(param1Int);
      AppMonitorDelegate.setStatisticsInterval(f.c, param1Int);
    }
  }
  
  public static class Stat {
    public static void begin(String param1String1, String param1String2, String param1String3) {
      try {
        if (AppMonitorDelegate.i && a.h() && f.d.isOpen() && (AppMonitorDelegate.IS_DEBUG || j.a(f.d, param1String1, param1String2))) {
          i.a("AppMonitorDelegate", new Object[] { "statEvent begin. module: ", param1String1, " monitorPoint: ", param1String2, " measureName: ", param1String3 });
          return;
        } 
      } finally {
        param1String1 = null;
      } 
    }
    
    @Deprecated
    public static boolean checkSampled(String param1String1, String param1String2) {
      return j.a(f.d, param1String1, param1String2);
    }
    
    public static void commit(String param1String1, String param1String2, double param1Double) {
      commit(param1String1, param1String2, (DimensionValueSet)null, param1Double);
    }
    
    public static void commit(String param1String1, String param1String2, DimensionValueSet param1DimensionValueSet, double param1Double) {
      try {
        boolean bool = TextUtils.isEmpty(param1String1);
        if (bool || TextUtils.isEmpty(param1String2))
          return; 
        a.v();
      } finally {
        param1String1 = null;
      } 
    }
    
    public static void commit(String param1String1, String param1String2, DimensionValueSet param1DimensionValueSet, MeasureValueSet param1MeasureValueSet) {
      // Byte code:
      //   0: aload_0
      //   1: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
      //   4: ifne -> 156
      //   7: aload_1
      //   8: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
      //   11: ifeq -> 17
      //   14: goto -> 156
      //   17: invokestatic v : ()V
      //   20: getstatic com/alibaba/mtl/appmonitor/AppMonitorDelegate.i : Z
      //   23: istore #4
      //   25: iload #4
      //   27: ifeq -> 128
      //   30: invokestatic h : ()Z
      //   33: ifeq -> 128
      //   36: getstatic com/alibaba/mtl/appmonitor/a/f.d : Lcom/alibaba/mtl/appmonitor/a/f;
      //   39: invokevirtual isOpen : ()Z
      //   42: ifeq -> 128
      //   45: getstatic com/alibaba/mtl/appmonitor/AppMonitorDelegate.IS_DEBUG : Z
      //   48: ifne -> 81
      //   51: getstatic com/alibaba/mtl/appmonitor/a/f.d : Lcom/alibaba/mtl/appmonitor/a/f;
      //   54: astore #6
      //   56: aload_2
      //   57: ifnull -> 170
      //   60: aload_2
      //   61: invokevirtual getMap : ()Ljava/util/Map;
      //   64: astore #5
      //   66: goto -> 69
      //   69: aload #6
      //   71: aload_0
      //   72: aload_1
      //   73: aload #5
      //   75: invokestatic a : (Lcom/alibaba/mtl/appmonitor/a/f;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Z
      //   78: ifeq -> 128
      //   81: ldc 'statEvent commit success'
      //   83: iconst_4
      //   84: anewarray java/lang/Object
      //   87: dup
      //   88: iconst_0
      //   89: ldc 'statEvent commit. module: '
      //   91: aastore
      //   92: dup
      //   93: iconst_1
      //   94: aload_0
      //   95: aastore
      //   96: dup
      //   97: iconst_2
      //   98: ldc ' monitorPoint: '
      //   100: aastore
      //   101: dup
      //   102: iconst_3
      //   103: aload_1
      //   104: aastore
      //   105: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
      //   108: invokestatic w : ()V
      //   111: invokestatic a : ()Lcom/alibaba/mtl/appmonitor/a/e;
      //   114: getstatic com/alibaba/mtl/appmonitor/a/f.d : Lcom/alibaba/mtl/appmonitor/a/f;
      //   117: invokevirtual a : ()I
      //   120: aload_0
      //   121: aload_1
      //   122: aload_3
      //   123: aload_2
      //   124: invokevirtual a : (ILjava/lang/String;Ljava/lang/String;Lcom/alibaba/mtl/appmonitor/model/MeasureValueSet;Lcom/alibaba/mtl/appmonitor/model/DimensionValueSet;)V
      //   127: return
      //   128: ldc 'statEvent commit failed,log discard'
      //   130: iconst_4
      //   131: anewarray java/lang/Object
      //   134: dup
      //   135: iconst_0
      //   136: ldc ' ,. module: '
      //   138: aastore
      //   139: dup
      //   140: iconst_1
      //   141: aload_0
      //   142: aastore
      //   143: dup
      //   144: iconst_2
      //   145: ldc ' monitorPoint: '
      //   147: aastore
      //   148: dup
      //   149: iconst_3
      //   150: aload_1
      //   151: aastore
      //   152: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
      //   155: return
      //   156: ldc 'AppMonitorDelegate'
      //   158: ldc 'module & monitorPoint must not null'
      //   160: invokestatic a : (Ljava/lang/String;Ljava/lang/Object;)V
      //   163: return
      //   164: astore_0
      //   165: aload_0
      //   166: invokestatic a : (Ljava/lang/Throwable;)V
      //   169: return
      //   170: aconst_null
      //   171: astore #5
      //   173: goto -> 69
      // Exception table:
      //   from	to	target	type
      //   0	14	164	finally
      //   17	25	164	finally
      //   30	56	164	finally
      //   60	66	164	finally
      //   69	81	164	finally
      //   81	127	164	finally
      //   128	155	164	finally
      //   156	163	164	finally
    }
    
    public static Transaction createTransaction(String param1String1, String param1String2) {
      return createTransaction(param1String1, param1String2, null);
    }
    
    public static Transaction createTransaction(String param1String1, String param1String2, DimensionValueSet param1DimensionValueSet) {
      return new Transaction(Integer.valueOf(f.d.a()), param1String1, param1String2, param1DimensionValueSet);
    }
    
    public static void end(String param1String1, String param1String2, String param1String3) {
      try {
        if (AppMonitorDelegate.i && a.h() && f.d.isOpen() && (AppMonitorDelegate.IS_DEBUG || j.a(f.d, param1String1, param1String2))) {
          i.a("AppMonitorDelegate", new Object[] { "statEvent end. module: ", param1String1, " monitorPoint: ", param1String2, " measureName: ", param1String3 });
          return;
        } 
      } finally {
        param1String1 = null;
      } 
    }
    
    public static void setSampling(int param1Int) {
      j.a().a(f.d, param1Int);
    }
    
    public static void setStatisticsInterval(int param1Int) {
      f.d.setStatisticsInterval(param1Int);
      AppMonitorDelegate.setStatisticsInterval(f.d, param1Int);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\AppMonitorDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */