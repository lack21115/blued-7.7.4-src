package com.soft.blued.log;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.HttpManager;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.pool.ThreadPriority;
import com.blued.das.message.MessageProtos;
import com.soft.blued.http.BluedHttpUrl;
import com.soft.blued.log.model.InstantLogBody;
import com.soft.blued.log.model.LogData;
import com.soft.blued.log.trackUtils.EventTrackMessage;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.DeviceUtils;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.NetworkUtils;
import com.soft.blued.utils.StringUtils;
import java.util.Map;

public class InstantLog {
  public static long a;
  
  public static int a(long paramLong1, long paramLong2) {
    return (int)((paramLong2 - paramLong1) / 1000L);
  }
  
  public static void a() {
    a = System.currentTimeMillis();
  }
  
  public static void a(int paramInt) {
    long l = a;
    if (l != 0L) {
      int i = a(l, System.currentTimeMillis());
      Map<String, String> map = BluedHttpTools.a();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(i);
      stringBuilder.append("");
      map.put("time", stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramInt);
      stringBuilder.append("");
      map.put("from", stringBuilder.toString());
      a("shine_video_stay_time", map);
      a = 0L;
    } 
  }
  
  public static void a(int paramInt, double paramDouble) {
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    map.put("type", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramDouble);
    stringBuilder.append("");
    map.put("num", stringBuilder.toString());
    a("vip_buy_page_item_click", map);
  }
  
  public static void a(int paramInt1, int paramInt2) {
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt1);
    stringBuilder.append("");
    map.put("type", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt2);
    stringBuilder.append("");
    map.put("from", stringBuilder.toString());
    a("shine_video_list_request", map);
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString1, String paramString2) {
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt1);
    stringBuilder.append("");
    map.put("type", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt2);
    stringBuilder.append("");
    map.put("to", stringBuilder.toString());
    if (!StringUtils.e(paramString1))
      map.put("url", paramString1); 
    if (!StringUtils.e(paramString2))
      map.put("id", paramString2); 
    a("share_click", map);
  }
  
  public static void a(int paramInt1, BluedIngSelfFeed paramBluedIngSelfFeed, String paramString, int paramInt2) {
    if (paramBluedIngSelfFeed != null) {
      Map<String, String> map = BluedHttpTools.a();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramInt1);
      stringBuilder.append("");
      map.put("from", stringBuilder.toString());
      map.put("id", paramBluedIngSelfFeed.feed_id);
      map.put("type", paramBluedIngSelfFeed.recommend_text);
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramBluedIngSelfFeed.is_super_topics);
      stringBuilder.append("");
      map.put("is_super_topic", stringBuilder.toString());
      if (!TextUtils.isEmpty(paramString))
        map.put("topic_id", paramString); 
      if (paramInt2 != -1) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramInt2);
        stringBuilder1.append("");
        map.put("topic_category", stringBuilder1.toString());
      } 
      a("like_btn_click", map);
    } 
  }
  
  public static void a(int paramInt, String paramString) {
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    map.put("position", stringBuilder.toString());
    map.put("url", paramString);
    a("game_status", map);
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2) {
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt1);
    stringBuilder2.append("");
    map.put("from", stringBuilder2.toString());
    map.put("url", paramString);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramInt2);
    stringBuilder1.append("");
    map.put("is_self", stringBuilder1.toString());
    a("vip_icon_click", map);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2) {
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    map.put("type", stringBuilder.toString());
    map.put("url", paramString1);
    a("msg_click", map);
    MessageProtos.Event event = MessageProtos.Event.MSG_CLICK;
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    EventTrackMessage.a(event, paramString2, stringBuilder.toString(), paramString1);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3) {
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    map.put("from", stringBuilder.toString());
    map.put("id", paramString1);
    map.put("type", paramString2);
    map.put("target_uid", paramString3);
    a("feed_show", map);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    map.put("from", stringBuilder.toString());
    map.put("uid", paramString1);
    map.put("item_id", paramString2);
    if (!TextUtils.isEmpty(paramString3))
      map.put("type", paramString3); 
    map.put("status", paramString4);
    map.put("num", paramString5);
    a("live_item_show", map);
  }
  
  public static void a(LogData paramLogData) {
    ThreadManager.a().a((Runnable)new ThreadExecutor("postLogData", ThreadPriority.a, paramLogData) {
          public void execute() {
            LogData logData = this.a;
            if (logData != null && !StringUtils.e(logData.J)) {
              Map<String, String> map = BluedHttpTools.a();
              if (!StringUtils.e(this.a.a))
                map.put("num", this.a.a); 
              if (!StringUtils.e(this.a.b))
                map.put("target_uid", this.a.b); 
              if (!StringUtils.e(this.a.c))
                map.put("uid", this.a.c); 
              if (!StringUtils.e(this.a.d))
                map.put("url", this.a.d); 
              if (!StringUtils.e(this.a.e))
                map.put("platform", this.a.e); 
              if (!StringUtils.e(this.a.f))
                map.put("destination", this.a.f); 
              if (!StringUtils.e(this.a.g))
                map.put("from", this.a.g); 
              if (!StringUtils.e(this.a.h))
                map.put("topic_category", this.a.h); 
              if (!StringUtils.e(this.a.i))
                map.put("db_id", this.a.i); 
              if (!StringUtils.e(this.a.j))
                map.put("document_id", this.a.j); 
              if (!StringUtils.e(this.a.k))
                map.put("type", this.a.k); 
              if (!StringUtils.e(this.a.l))
                map.put("position", this.a.l); 
              if (!StringUtils.e(this.a.m))
                map.put("time", this.a.m); 
              if (!StringUtils.e(this.a.n))
                map.put("id", this.a.n); 
              if (!StringUtils.e(this.a.o))
                map.put("content", this.a.o); 
              if (!StringUtils.e(this.a.p))
                map.put("to", this.a.p); 
              if (!StringUtils.e(this.a.q))
                map.put("is_self", this.a.q); 
              if (!StringUtils.e(this.a.s))
                map.put("pid", this.a.s); 
              if (!StringUtils.e(this.a.r))
                map.put("item_id", this.a.r); 
              if (!StringUtils.e(this.a.t))
                map.put("topic_id", this.a.t); 
              if (!StringUtils.e(this.a.u))
                map.put("is_hello", this.a.u); 
              if (!StringUtils.e(this.a.v))
                map.put("status", this.a.v); 
              InstantLogBody instantLogBody = new InstantLogBody();
              instantLogBody.service = this.a.J;
              InstantLog.a(instantLogBody, map);
            } 
          }
        });
  }
  
  public static void a(String paramString) {
    InstantLogBody instantLogBody = new InstantLogBody();
    instantLogBody.service = paramString;
    b(instantLogBody, (Map<String, String>)null);
  }
  
  public static void a(String paramString, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    g(paramString, stringBuilder.toString());
  }
  
  public static void a(String paramString, Object paramObject) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("from", String.valueOf(paramObject));
    a(paramString, map);
  }
  
  public static void a(String paramString1, String paramString2) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("url", paramString2);
    a(paramString1, map);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, String paramString3) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("from", "4");
    map.put("id", paramString1);
    map.put("topic_id", paramString2);
    map.put("target_uid", paramString3);
    if (paramInt == 1) {
      map.put("topic_category", "0");
    } else {
      map.put("topic_category", "1");
    } 
    a("feed_show", map);
  }
  
  public static void a(String paramString, Map<String, String> paramMap) {
    InstantLogBody instantLogBody = new InstantLogBody();
    instantLogBody.service = paramString;
    b(instantLogBody, paramMap);
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3, int paramInt) {
    if (!StringUtils.e(paramString2)) {
      byte b;
      String str = paramString2;
      if (paramString2.startsWith("-"))
        str = paramString2.substring(1); 
      paramString2 = paramString3;
      if (paramString3.startsWith("-"))
        paramString2 = paramString3.substring(1); 
      if (paramInt == 1) {
        b = 5;
      } else {
        b = 20;
      } 
      if (str.contains("-") && (str.split("-")).length >= b) {
        Map<String, String> map = BluedHttpTools.a();
        map.put("from", paramString1);
        map.put("id", str);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramInt);
        stringBuilder.append("");
        map.put("type", stringBuilder.toString());
        map.put("is_hello", paramString2);
        a("people_show", map);
        return true;
      } 
    } 
    return false;
  }
  
  public static void b(int paramInt1, int paramInt2, String paramString1, String paramString2) {
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt1);
    stringBuilder.append("");
    map.put("type", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt2);
    stringBuilder.append("");
    map.put("to", stringBuilder.toString());
    if (!StringUtils.e(paramString1))
      map.put("url", paramString1); 
    if (!StringUtils.e(paramString2))
      map.put("id", paramString2); 
    a("share_success", map);
  }
  
  public static void b(int paramInt1, BluedIngSelfFeed paramBluedIngSelfFeed, String paramString, int paramInt2) {
    if (paramBluedIngSelfFeed != null) {
      Map<String, String> map = BluedHttpTools.a();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramInt1);
      stringBuilder.append("");
      map.put("from", stringBuilder.toString());
      map.put("id", paramBluedIngSelfFeed.feed_id);
      map.put("type", paramBluedIngSelfFeed.recommend_text);
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramBluedIngSelfFeed.is_super_topics);
      stringBuilder.append("");
      map.put("is_super_topic", stringBuilder.toString());
      if (!TextUtils.isEmpty(paramString))
        map.put("topic_id", paramString); 
      if (paramInt2 != -1) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramInt2);
        stringBuilder1.append("");
        map.put("topic_category", stringBuilder1.toString());
      } 
      a("comment_btn_click", map);
    } 
  }
  
  public static void b(int paramInt, String paramString) {
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    map.put("from", stringBuilder.toString());
    map.put("target_uid", paramString);
    a("shine_video_attention_click", map);
  }
  
  private static void b(InstantLogBody paramInstantLogBody, Map<String, String> paramMap) {
    ThreadManager.a().a((Runnable)new ThreadExecutor("PostLog", ThreadPriority.a, paramInstantLogBody, paramMap) {
          public void execute() {
            InstantLog.a(this.a, this.b);
          }
        });
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
    map.put("target_uid", paramString2);
    a(paramString1, map);
  }
  
  public static boolean b(String paramString) {
    if (!StringUtils.e(paramString)) {
      String str = paramString;
      if (paramString.startsWith("-"))
        str = paramString.substring(1); 
      if (str.contains("-") && (str.split("-")).length >= 20) {
        Map<String, String> map = BluedHttpTools.a();
        map.put("uid", str);
        map.put("position", "1");
        a("msg_rec_chat_show", map);
        return true;
      } 
    } 
    return false;
  }
  
  public static void c(int paramInt1, BluedIngSelfFeed paramBluedIngSelfFeed, String paramString, int paramInt2) {
    if (paramBluedIngSelfFeed != null) {
      Map<String, String> map = BluedHttpTools.a();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramInt1);
      stringBuilder.append("");
      map.put("from", stringBuilder.toString());
      map.put("id", paramBluedIngSelfFeed.feed_id);
      map.put("type", paramBluedIngSelfFeed.recommend_text);
      if (!TextUtils.isEmpty(paramString))
        map.put("topic_id", paramString); 
      if (paramInt2 != -1) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramInt2);
        stringBuilder1.append("");
        map.put("topic_category", stringBuilder1.toString());
      } 
      a("feed_share_btn_click", map);
    } 
  }
  
  private static void c(InstantLogBody paramInstantLogBody, Map<String, String> paramMap) {
    if (paramInstantLogBody != null)
      try {
        Map<String, String> map = BluedHttpTools.a();
        map.put("service", paramInstantLogBody.service);
        if (!TextUtils.isEmpty(paramInstantLogBody.from))
          map.put("from", paramInstantLogBody.from); 
        if (!TextUtils.isEmpty(paramInstantLogBody.pn))
          map.put("pn", paramInstantLogBody.pn); 
        String str1 = BluedConfig.b().a().toJson(paramMap);
        if (!TextUtils.isEmpty(str1))
          map.put("event_info", str1); 
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(paramInstantLogBody.event);
        stringBuilder2.append("");
        map.put("event", stringBuilder2.toString());
        String str3 = NetworkUtils.d();
        if (!TextUtils.isEmpty(str3))
          map.put("network", str3); 
        boolean bool = TextUtils.isEmpty(paramInstantLogBody.operator);
        if (bool) {
          map.put("operator", DeviceUtils.d());
        } else {
          map.put("operator", paramInstantLogBody.operator);
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(BluedHttpUrl.n());
        stringBuilder1.append("/live/log");
        String str2 = stringBuilder1.toString();
        if (AppInfo.m() && paramInstantLogBody != null)
          Logger.c("InstantLog", new Object[] { "postlog Service:", paramInstantLogBody.service, ";>Event info:", str1 }); 
        HttpManager.b(str2, null).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).g().i();
        return;
      } catch (Exception exception) {
        return;
      }  
  }
  
  public static void c(String paramString1, String paramString2) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("uid", paramString2);
    a(paramString1, map);
  }
  
  public static void d(int paramInt1, BluedIngSelfFeed paramBluedIngSelfFeed, String paramString, int paramInt2) {
    if (paramBluedIngSelfFeed != null) {
      Map<String, String> map = BluedHttpTools.a();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramInt1);
      stringBuilder.append("");
      map.put("from", stringBuilder.toString());
      map.put("id", paramBluedIngSelfFeed.feed_id);
      map.put("type", paramBluedIngSelfFeed.recommend_text);
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramBluedIngSelfFeed.is_super_topics);
      stringBuilder.append("");
      map.put("is_super_topic", stringBuilder.toString());
      if (!TextUtils.isEmpty(paramString))
        map.put("topic_id", paramString); 
      if (paramInt2 != -1) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramInt2);
        stringBuilder1.append("");
        map.put("topic_category", stringBuilder1.toString());
      } 
      a("repost_btn_click", map);
    } 
  }
  
  public static void d(String paramString1, String paramString2) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("destination", paramString2);
    a(paramString1, map);
  }
  
  public static void e(String paramString1, String paramString2) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("platform", paramString1);
    map.put("from", paramString2);
    a("share_feed_success", map);
  }
  
  public static void f(String paramString1, String paramString2) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("document_id", paramString2);
    a(paramString1, map);
  }
  
  public static void g(String paramString1, String paramString2) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("type", paramString2);
    a(paramString1, map);
  }
  
  public static void h(String paramString1, String paramString2) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("id", paramString2);
    a(paramString1, map);
  }
  
  public static void i(String paramString1, String paramString2) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("content", paramString2);
    a(paramString1, map);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\log\InstantLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */