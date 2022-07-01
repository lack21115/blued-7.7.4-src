package com.amap.api.col.s;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.INearbySearch;
import com.amap.api.services.nearby.NearbySearch;
import com.amap.api.services.nearby.NearbySearchResult;
import com.amap.api.services.nearby.UploadInfo;
import com.amap.api.services.nearby.UploadInfoCallback;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

public final class bb implements INearbySearch {
  private static long e;
  
  private List<NearbySearch.NearbyListener> a = new ArrayList<NearbySearch.NearbyListener>();
  
  private String b;
  
  private Context c;
  
  private s d;
  
  private ExecutorService f;
  
  private LatLonPoint g = null;
  
  private String h = null;
  
  private boolean i = false;
  
  private Timer j = new Timer();
  
  private UploadInfoCallback k;
  
  private TimerTask l;
  
  public bb(Context paramContext) {
    this.c = paramContext.getApplicationContext();
    this.d = s.a();
  }
  
  private int a() throws AMapException {
    try {
      if (!this.i) {
        if (a(this.b))
          return (new t(this.c, this.b)).n_().intValue(); 
        throw new AMapException("USERID非法");
      } 
      throw new AMapException("已开启自动上传");
    } catch (AMapException aMapException) {
      throw aMapException;
    } finally {
      Exception exception = null;
    } 
  }
  
  private int a(UploadInfo paramUploadInfo) {
    try {
      q.a(this.c);
      if (paramUploadInfo == null)
        return 2202; 
      long l = (new Date()).getTime();
      if (l - e < 6500L)
        return 2203; 
      e = l;
      String str = paramUploadInfo.getUserID();
      if (!a(str))
        return 2201; 
      if (TextUtils.isEmpty(this.h))
        this.h = str; 
      if (!str.equals(this.h))
        return 2201; 
      LatLonPoint latLonPoint = paramUploadInfo.getPoint();
      if (latLonPoint == null || latLonPoint.equals(this.g))
        return 2204; 
      (new v(this.c, paramUploadInfo)).n_();
      return 1000;
    } catch (AMapException aMapException) {
      return aMapException.getErrorCode();
    } finally {
      paramUploadInfo = null;
    } 
  }
  
  private static boolean a(String paramString) {
    return TextUtils.isEmpty(paramString) ? false : Pattern.compile("^[a-z0-9A-Z_-]{1,32}$").matcher(paramString).find();
  }
  
  public final void addNearbyListener(NearbySearch.NearbyListener paramNearbyListener) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Ljava/util/List;
    //   6: aload_1
    //   7: invokeinterface add : (Ljava/lang/Object;)Z
    //   12: pop
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: astore_1
    //   17: aload_1
    //   18: ldc 'NearbySearch'
    //   20: ldc 'addNearbyListener'
    //   22: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Exception table:
    //   from	to	target	type
    //   2	13	16	finally
    //   17	25	28	finally
  }
  
  public final void clearUserInfoAsyn() {
    try {
      return;
    } finally {
      Exception exception = null;
      i.a(exception, "NearbySearch", "clearUserInfoAsynThrowable");
    } 
  }
  
  public final void destroy() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield j : Ljava/util/Timer;
    //   6: invokevirtual cancel : ()V
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: astore_1
    //   13: aload_1
    //   14: ldc 'NearbySearch'
    //   16: ldc 'destryoy'
    //   18: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: astore_1
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_1
    //   28: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	12	finally
    //   13	21	24	finally
  }
  
  public final void removeNearbyListener(NearbySearch.NearbyListener paramNearbyListener) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: aload_0
    //   10: getfield a : Ljava/util/List;
    //   13: aload_1
    //   14: invokeinterface remove : (Ljava/lang/Object;)Z
    //   19: pop
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: astore_1
    //   24: aload_1
    //   25: ldc 'NearbySearch'
    //   27: ldc 'removeNearbyListener'
    //   29: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   9	20	23	finally
    //   24	32	35	finally
  }
  
  public final NearbySearchResult searchNearbyInfo(NearbySearch.NearbyQuery paramNearbyQuery) throws AMapException {
    try {
      q.a(this.c);
      boolean bool = false;
      if (paramNearbyQuery != null && paramNearbyQuery.getCenterPoint() != null)
        bool = true; 
      if (bool)
        return (new u(this.c, paramNearbyQuery)).n_(); 
      throw new AMapException("无效的参数 - IllegalArgumentException");
    } catch (AMapException aMapException) {
      throw aMapException;
    } finally {
      paramNearbyQuery = null;
      i.a((Throwable)paramNearbyQuery, "NearbySearch", "searchNearbyInfo");
    } 
  }
  
  public final void searchNearbyInfoAsyn(NearbySearch.NearbyQuery paramNearbyQuery) {
    try {
      return;
    } finally {
      paramNearbyQuery = null;
      i.a((Throwable)paramNearbyQuery, "NearbySearch", "searchNearbyInfoAsynThrowable");
    } 
  }
  
  public final void setUserID(String paramString) {
    this.b = paramString;
  }
  
  public final void startUploadNearbyInfoAuto(UploadInfoCallback paramUploadInfoCallback, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_2
    //   3: istore_3
    //   4: iload_2
    //   5: sipush #7000
    //   8: if_icmpge -> 15
    //   11: sipush #7000
    //   14: istore_3
    //   15: aload_0
    //   16: aload_1
    //   17: putfield k : Lcom/amap/api/services/nearby/UploadInfoCallback;
    //   20: aload_0
    //   21: getfield i : Z
    //   24: ifeq -> 42
    //   27: aload_0
    //   28: getfield l : Ljava/util/TimerTask;
    //   31: ifnull -> 42
    //   34: aload_0
    //   35: getfield l : Ljava/util/TimerTask;
    //   38: invokevirtual cancel : ()Z
    //   41: pop
    //   42: aload_0
    //   43: iconst_1
    //   44: putfield i : Z
    //   47: aload_0
    //   48: new com/amap/api/col/s/bb$a
    //   51: dup
    //   52: aload_0
    //   53: iconst_0
    //   54: invokespecial <init> : (Lcom/amap/api/col/s/bb;B)V
    //   57: putfield l : Ljava/util/TimerTask;
    //   60: aload_0
    //   61: getfield j : Ljava/util/Timer;
    //   64: aload_0
    //   65: getfield l : Ljava/util/TimerTask;
    //   68: lconst_0
    //   69: iload_3
    //   70: i2l
    //   71: invokevirtual schedule : (Ljava/util/TimerTask;JJ)V
    //   74: aload_0
    //   75: monitorexit
    //   76: return
    //   77: astore_1
    //   78: aload_1
    //   79: ldc 'NearbySearch'
    //   81: ldc_w 'startUploadNearbyInfoAuto'
    //   84: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   87: aload_0
    //   88: monitorexit
    //   89: return
    //   90: astore_1
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_1
    //   94: athrow
    // Exception table:
    //   from	to	target	type
    //   15	42	77	finally
    //   42	74	77	finally
    //   78	87	90	finally
  }
  
  public final void stopUploadNearbyInfoAuto() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield l : Ljava/util/TimerTask;
    //   6: ifnull -> 30
    //   9: aload_0
    //   10: getfield l : Ljava/util/TimerTask;
    //   13: invokevirtual cancel : ()Z
    //   16: pop
    //   17: goto -> 30
    //   20: astore_1
    //   21: aload_1
    //   22: ldc 'NearbySearch'
    //   24: ldc_w 'stopUploadNearbyInfoAuto'
    //   27: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   30: aload_0
    //   31: iconst_0
    //   32: putfield i : Z
    //   35: aload_0
    //   36: aconst_null
    //   37: putfield l : Ljava/util/TimerTask;
    //   40: aload_0
    //   41: monitorexit
    //   42: return
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Exception table:
    //   from	to	target	type
    //   2	17	20	finally
    //   21	30	43	finally
    //   30	40	43	finally
  }
  
  public final void uploadNearbyInfoAsyn(UploadInfo paramUploadInfo) {
    if (this.f == null)
      this.f = Executors.newSingleThreadExecutor(); 
    this.f.submit(new Runnable(this, paramUploadInfo) {
          public final void run() {
            try {
              Message message = bb.a(this.b).obtainMessage();
              message.arg1 = 10;
              message.obj = bb.b(this.b);
              return;
            } finally {
              Exception exception = null;
              i.a(exception, "NearbySearch", "uploadNearbyInfoAsyn");
            } 
          }
        });
  }
  
  final class a extends TimerTask {
    private a(bb this$0) {}
    
    public final void run() {
      try {
        return;
      } finally {
        Exception exception = null;
        i.a(exception, "NearbySearch", "UpdateDataTask");
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */