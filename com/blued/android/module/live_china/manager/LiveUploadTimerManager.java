package com.blued.android.module.live_china.manager;

import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.HttpResponseHandler;
import com.blued.android.core.net.StringHttpResponseHandler;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveUploadTimerModel;
import com.blued.android.module.live_china.utils.LivePreferencesUtils;
import java.util.Map;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

public class LiveUploadTimerManager {
  private static LiveUploadTimerManager c;
  
  private Timer a;
  
  private String b;
  
  public static LiveUploadTimerManager a() {
    if (c == null)
      c = new LiveUploadTimerManager(); 
    return c;
  }
  
  private static void a(StringHttpResponseHandler paramStringHttpResponseHandler, String paramString1, String paramString2) {
    Map<String, String> map = BluedHttpTools.b();
    map.put("lid", paramString1);
    map.put("type", paramString2);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LiveRoomInfo.a().k());
    stringBuilder.append("/live/time/report");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramStringHttpResponseHandler).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(String paramString) {
    if (c != null)
      return; 
    a();
    c.b = paramString;
    c("2");
    f();
  }
  
  public static void b() {
    if (c == null)
      return; 
    c("3");
    g();
    c = null;
  }
  
  public static void c() {
    c("4");
    g();
  }
  
  private static void c(String paramString) {
    // Byte code:
    //   0: ldc com/blued/android/module/live_china/manager/LiveUploadTimerManager
    //   2: monitorenter
    //   3: getstatic com/blued/android/module/live_china/manager/LiveUploadTimerManager.c : Lcom/blued/android/module/live_china/manager/LiveUploadTimerManager;
    //   6: ifnull -> 75
    //   9: getstatic com/blued/android/module/live_china/manager/LiveUploadTimerManager.c : Lcom/blued/android/module/live_china/manager/LiveUploadTimerManager;
    //   12: getfield b : Ljava/lang/String;
    //   15: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   18: ifeq -> 24
    //   21: goto -> 75
    //   24: invokestatic currentTimeMillis : ()J
    //   27: lstore_1
    //   28: invokestatic b : ()J
    //   31: lstore_3
    //   32: lload_1
    //   33: lload_3
    //   34: lsub
    //   35: ldc2_w 86400000
    //   38: lcmp
    //   39: ifge -> 46
    //   42: ldc com/blued/android/module/live_china/manager/LiveUploadTimerManager
    //   44: monitorexit
    //   45: return
    //   46: new com/blued/android/module/live_china/manager/LiveUploadTimerManager$2
    //   49: dup
    //   50: invokespecial <init> : ()V
    //   53: getstatic com/blued/android/module/live_china/manager/LiveUploadTimerManager.c : Lcom/blued/android/module/live_china/manager/LiveUploadTimerManager;
    //   56: getfield b : Ljava/lang/String;
    //   59: aload_0
    //   60: invokestatic a : (Lcom/blued/android/core/net/StringHttpResponseHandler;Ljava/lang/String;Ljava/lang/String;)V
    //   63: goto -> 71
    //   66: astore_0
    //   67: aload_0
    //   68: invokevirtual printStackTrace : ()V
    //   71: ldc com/blued/android/module/live_china/manager/LiveUploadTimerManager
    //   73: monitorexit
    //   74: return
    //   75: ldc com/blued/android/module/live_china/manager/LiveUploadTimerManager
    //   77: monitorexit
    //   78: return
    //   79: astore_0
    //   80: ldc com/blued/android/module/live_china/manager/LiveUploadTimerManager
    //   82: monitorexit
    //   83: aload_0
    //   84: athrow
    // Exception table:
    //   from	to	target	type
    //   3	21	79	finally
    //   24	32	79	finally
    //   46	63	66	java/lang/Exception
    //   46	63	79	finally
    //   67	71	79	finally
  }
  
  public static void d() {
    c("5");
    f();
  }
  
  private static void f() {
    if (c == null)
      return; 
    g();
    c.a = new Timer();
    c.a.schedule(new TimerTask() {
          public void run() {
            LiveUploadTimerManager.b("1");
          }
        },  60000L, 60000L);
  }
  
  private static void g() {
    LiveUploadTimerManager liveUploadTimerManager = c;
    if (liveUploadTimerManager != null) {
      Timer timer = liveUploadTimerManager.a;
      if (timer == null)
        return; 
      timer.cancel();
      c.a = null;
    } 
  }
  
  public static interface UPLOAD_TYPE {
    public static final String APP_TO_HOME = "4";
    
    public static final String HOME_TO_APP = "5";
    
    public static final String JOIN_LIVE = "2";
    
    public static final String LEAVE_LIVE = "3";
    
    public static final String PER_MINUTE = "1";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\manager\LiveUploadTimerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */