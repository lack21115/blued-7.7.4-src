package com.blued.android.module.live_china.utils.log;

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
  
  public static void a(LiveProtos.Event paramEvent, LiveProtos.Source paramSource, String paramString1, String paramString2) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setTargetUid(a(paramString2)).setLiveId(a(paramString1)).setSource(paramSource).build()); 
  }
  
  public static void a(LiveProtos.Event paramEvent, String paramString) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setTargetUid(a(paramString)).build()); 
  }
  
  public static void a(LiveProtos.Event paramEvent, String paramString1, String paramString2) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setTargetUid(a(paramString2)).setLiveId(a(paramString1)).build()); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_chin\\utils\log\EventTrackLive.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */