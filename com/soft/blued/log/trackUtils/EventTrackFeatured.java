package com.soft.blued.log.trackUtils;

import com.blued.das.client.featured.FeaturedProtos;
import com.google.protobuf.Message;

public class EventTrackFeatured {
  private static String a(String paramString) {
    return EventTrackUtils.a(paramString);
  }
  
  public static void a(FeaturedProtos.Event paramEvent, String paramString1, int paramInt, String paramString2) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)FeaturedProtos.FeaturedProto.newBuilder().setEvent(paramEvent).setTargetUid(a(paramString1)).setReason(paramInt).setLabel(a(paramString2)).build()); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\log\trackUtils\EventTrackFeatured.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */