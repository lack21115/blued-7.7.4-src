package com.qq.e.comm.plugin.intersitial2.fullscreen;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.comm.util.GDTLogger;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Map;

public class InterstitialFSEventCenter {
  private static volatile InterstitialFSEventCenter a;
  
  private Map<String, a> b = new HashMap<String, a>();
  
  private Handler c = new Handler(Looper.getMainLooper());
  
  public static InterstitialFSEventCenter a() {
    // Byte code:
    //   0: getstatic com/qq/e/comm/plugin/intersitial2/fullscreen/InterstitialFSEventCenter.a : Lcom/qq/e/comm/plugin/intersitial2/fullscreen/InterstitialFSEventCenter;
    //   3: ifnonnull -> 37
    //   6: ldc com/qq/e/comm/plugin/intersitial2/fullscreen/InterstitialFSEventCenter
    //   8: monitorenter
    //   9: getstatic com/qq/e/comm/plugin/intersitial2/fullscreen/InterstitialFSEventCenter.a : Lcom/qq/e/comm/plugin/intersitial2/fullscreen/InterstitialFSEventCenter;
    //   12: ifnonnull -> 25
    //   15: new com/qq/e/comm/plugin/intersitial2/fullscreen/InterstitialFSEventCenter
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/qq/e/comm/plugin/intersitial2/fullscreen/InterstitialFSEventCenter.a : Lcom/qq/e/comm/plugin/intersitial2/fullscreen/InterstitialFSEventCenter;
    //   25: ldc com/qq/e/comm/plugin/intersitial2/fullscreen/InterstitialFSEventCenter
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/qq/e/comm/plugin/intersitial2/fullscreen/InterstitialFSEventCenter
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/qq/e/comm/plugin/intersitial2/fullscreen/InterstitialFSEventCenter.a : Lcom/qq/e/comm/plugin/intersitial2/fullscreen/InterstitialFSEventCenter;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  void a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    this.b.remove(paramString);
  }
  
  public void a(String paramString, int paramInt, Object paramObject) {
    if (TextUtils.isEmpty(paramString))
      return; 
    this.c.post(new Runnable(this, paramString, paramInt, paramObject) {
          public void run() {
            InterstitialFSEventCenter.a a = (InterstitialFSEventCenter.a)InterstitialFSEventCenter.a(this.d).get(this.a);
            if (a != null)
              a.a(this.a, this.b, this.c); 
          }
        });
  }
  
  public void a(String paramString, a parama) {
    if (TextUtils.isEmpty(paramString) || parama == null) {
      GDTLogger.d("registerListener id null or listener null");
      return;
    } 
    this.b.put(paramString, parama);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface InterstitialFSEvent {
    public static final int ON_AD_CLICKED = 10003;
    
    public static final int ON_AD_CLOSED = 10004;
    
    public static final int ON_AD_EXPOSURE = 10002;
    
    public static final int ON_AD_OPEN = 10001;
    
    public static final int ON_VIDEO_CACHED = 10005;
    
    public static final int ON_VIDEO_COMPLETE = 10011;
    
    public static final int ON_VIDEO_ERROR = 10012;
    
    public static final int ON_VIDEO_INIT = 10006;
    
    public static final int ON_VIDEO_LOADING = 10007;
    
    public static final int ON_VIDEO_PAUSE = 10010;
    
    public static final int ON_VIDEO_READY = 10008;
    
    public static final int ON_VIDEO_START = 10009;
  }
  
  public static interface a {
    void a(String param1String, int param1Int, Object param1Object);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\intersitial2\fullscreen\InterstitialFSEventCenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */