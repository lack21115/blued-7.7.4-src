package com.soft.blued.log.trackUtils;

import com.blued.das.superexpose.SuperExposeProtos;
import com.google.protobuf.Message;

public class EventTrackSuperExpose {
  private static String a(String paramString) {
    return EventTrackUtils.a(paramString);
  }
  
  public static void a(SuperExposeProtos.Event paramEvent) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)SuperExposeProtos.SuperExposeProto.newBuilder().setEvent(paramEvent).build()); 
  }
  
  public static void a(SuperExposeProtos.Event paramEvent, String paramString, long paramLong) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)SuperExposeProtos.SuperExposeProto.newBuilder().setEvent(paramEvent).setId(a(paramString)).setBubbleId(paramLong).build()); 
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2) {
    EventTrackUtils.a((Message)SuperExposeProtos.SuperExposeProto.newBuilder().setEvent(SuperExposeProtos.Event.EXPOSE_BUY_PAGE_PAY_CLICK).setSkuId(a(paramString1)).setDiscountId(a(paramString2)).setStrategy(paramInt1).setRegion(paramInt2).build());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\log\trackUtils\EventTrackSuperExpose.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */