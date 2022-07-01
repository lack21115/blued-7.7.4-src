package com.soft.blued.log.trackUtils;

import android.util.Log;
import com.blued.das.live.LiveProtos;
import com.google.protobuf.Message;

public class EventTrackLive {
  private static String a(String paramString) {
    return EventTrackUtils.a(paramString);
  }
  
  public static void a(LiveProtos.Event paramEvent) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).build()); 
  }
  
  public static void a(LiveProtos.Event paramEvent, LiveProtos.EnterType paramEnterType) {
    if (paramEvent != null && paramEnterType != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setEnterType(paramEnterType).build()); 
  }
  
  public static void a(LiveProtos.Event paramEvent, String paramString) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setTargetUid(a(paramString)).build()); 
  }
  
  public static void a(LiveProtos.Event paramEvent, String paramString1, String paramString2) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setTargetUid(a(paramString2)).setLiveId(a(paramString1)).build()); 
  }
  
  public static void a(LiveProtos.Event paramEvent, String paramString1, String paramString2, LiveProtos.EnterType paramEnterType) {
    if (paramEvent != null && paramEnterType != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setTargetUid(a(paramString2)).setLiveId(a(paramString1)).setEnterType(paramEnterType).build()); 
  }
  
  public static void a(LiveProtos.Event paramEvent, String paramString1, String paramString2, String paramString3) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setLiveId(a(paramString1)).setLiveTypeId(a(paramString2)).setTargetUid(a(paramString3)).build()); 
  }
  
  public static void a(LiveProtos.Event paramEvent, boolean paramBoolean) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setIsJoin(paramBoolean).build()); 
  }
  
  public static void b(LiveProtos.Event paramEvent, String paramString) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setUrl(paramString).build()); 
  }
  
  public static void b(LiveProtos.Event paramEvent, String paramString1, String paramString2, String paramString3) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setTargetUid(a(paramString2)).setLiveId(a(paramString1)).setTaskId(paramString3).build()); 
  }
  
  public static void c(LiveProtos.Event paramEvent, String paramString1, String paramString2, String paramString3) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("tabId:");
    stringBuilder.append(paramString1);
    stringBuilder.append("  lid:");
    stringBuilder.append(paramString2);
    Log.i("==tab", stringBuilder.toString());
    if (paramEvent != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setLiveTab(a(paramString1)).setTargetUid(a(paramString3)).setLiveId(a(paramString2)).build()); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\log\trackUtils\EventTrackLive.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */