package com.blued.android.module.live_china.utils.log;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.HttpManager;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.pool.ThreadPriority;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.utils.log.model.InstantLogBody;
import com.blued.android.module.live_china.utils.log.model.LogData;
import java.util.Map;

public class InstantLog {
  public static void a(int paramInt1, int paramInt2, int paramInt3) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("whitening", String.valueOf(paramInt1));
    map.put("pinky", String.valueOf(paramInt2));
    map.put("buffing", String.valueOf(paramInt3));
    a("filters_type_score", map);
  }
  
  public static void a(InstantLogBody paramInstantLogBody) {
    c(paramInstantLogBody, null);
  }
  
  public static void a(InstantLogBody paramInstantLogBody, Map<String, String> paramMap) {
    c(paramInstantLogBody, paramMap);
  }
  
  public static void a(LogData paramLogData) {
    ThreadManager.a().a((Runnable)new ThreadExecutor("postLogData", ThreadPriority.a, paramLogData) {
          public void execute() {
            LogData logData = this.a;
            if (logData != null && !TextUtils.isEmpty(logData.D)) {
              Map<String, String> map = BluedHttpTools.a();
              if (!TextUtils.isEmpty(this.a.a))
                map.put("num", this.a.a); 
              if (!TextUtils.isEmpty(this.a.b))
                map.put("target_uid", this.a.b); 
              if (!TextUtils.isEmpty(this.a.c))
                map.put("uid", this.a.c); 
              if (!TextUtils.isEmpty(this.a.d))
                map.put("url", this.a.d); 
              if (!TextUtils.isEmpty(this.a.e))
                map.put("platform", this.a.e); 
              if (!TextUtils.isEmpty(this.a.f))
                map.put("destination", this.a.f); 
              if (!TextUtils.isEmpty(this.a.g))
                map.put("from", this.a.g); 
              if (!TextUtils.isEmpty(this.a.h))
                map.put("topic_category", this.a.h); 
              if (!TextUtils.isEmpty(this.a.i))
                map.put("db_id", this.a.i); 
              if (!TextUtils.isEmpty(this.a.j))
                map.put("document_id", this.a.j); 
              if (!TextUtils.isEmpty(this.a.k))
                map.put("type", this.a.k); 
              if (!TextUtils.isEmpty(this.a.l))
                map.put("position", this.a.l); 
              if (!TextUtils.isEmpty(this.a.m))
                map.put("time", this.a.m); 
              if (!TextUtils.isEmpty(this.a.n))
                map.put("id", this.a.n); 
              if (!TextUtils.isEmpty(this.a.o))
                map.put("content", this.a.o); 
              if (!TextUtils.isEmpty(this.a.p))
                map.put("to", this.a.p); 
              if (!TextUtils.isEmpty(this.a.q))
                map.put("is_self", this.a.q); 
              if (!TextUtils.isEmpty(this.a.s))
                map.put("pid", this.a.s); 
              if (!TextUtils.isEmpty(this.a.r))
                map.put("item_id", this.a.r); 
              if (!TextUtils.isEmpty(this.a.t))
                map.put("topic_id", this.a.t); 
              if (!TextUtils.isEmpty(this.a.u))
                map.put("is_hello", this.a.u); 
              if (!TextUtils.isEmpty(this.a.v))
                map.put("status", this.a.v); 
              InstantLogBody instantLogBody = new InstantLogBody();
              instantLogBody.service = this.a.D;
              InstantLog.b(instantLogBody, map);
            } 
          }
        });
  }
  
  public static void a(String paramString) {
    InstantLogBody instantLogBody = new InstantLogBody();
    instantLogBody.service = paramString;
    c(instantLogBody, null);
  }
  
  public static void a(String paramString, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    a(paramString, stringBuilder.toString());
  }
  
  public static void a(String paramString1, String paramString2) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("type", paramString2);
    a(paramString1, map);
  }
  
  public static void a(String paramString, Map<String, String> paramMap) {
    InstantLogBody instantLogBody = new InstantLogBody();
    instantLogBody.service = paramString;
    c(instantLogBody, paramMap);
  }
  
  public static void b(String paramString, int paramInt) {
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    map.put("position", stringBuilder.toString());
    a(paramString, map);
  }
  
  public static void b(String paramString1, String paramString2) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("id", paramString2);
    a(paramString1, map);
  }
  
  private static void c(InstantLogBody paramInstantLogBody, Map<String, String> paramMap) {
    ThreadManager.a().a((Runnable)new ThreadExecutor("PostLog", ThreadPriority.a, paramInstantLogBody, paramMap) {
          public void execute() {
            InstantLog.b(this.a, this.b);
          }
        });
  }
  
  private static void d(InstantLogBody paramInstantLogBody, Map<String, String> paramMap) {
    if (paramInstantLogBody != null)
      try {
        Map<String, String> map = BluedHttpTools.a();
        map.put("service", paramInstantLogBody.service);
        if (!TextUtils.isEmpty(paramInstantLogBody.from))
          map.put("from", paramInstantLogBody.from); 
        if (!TextUtils.isEmpty(paramInstantLogBody.pn))
          map.put("pn", paramInstantLogBody.pn); 
        String str2 = AppInfo.f().toJson(paramMap);
        if (!TextUtils.isEmpty(str2))
          map.put("event_info", str2); 
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(paramInstantLogBody.event);
        stringBuilder2.append("");
        map.put("event", stringBuilder2.toString());
        String str1 = LiveRoomInfo.a().n();
        if (!TextUtils.isEmpty(str1))
          map.put("network", str1); 
        boolean bool = TextUtils.isEmpty(paramInstantLogBody.operator);
        if (bool) {
          map.put("operator", LiveRoomInfo.a().o());
        } else {
          map.put("operator", paramInstantLogBody.operator);
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(LiveRoomInfo.a().k());
        stringBuilder1.append("/live/log");
        HttpManager.b(stringBuilder1.toString(), null).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).g().i();
        return;
      } catch (Exception exception) {
        return;
      }  
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_chin\\utils\log\InstantLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */