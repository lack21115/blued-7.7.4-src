package com.soft.blued.log.trackUtils;

import com.blued.das.authority.SystemAuthorityProtos;
import com.google.protobuf.Message;

public class EventTrackSystemAuthority {
  private static String a(String paramString) {
    return EventTrackUtils.a(paramString);
  }
  
  public static void a(SystemAuthorityProtos.Event paramEvent) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)SystemAuthorityProtos.SystemAuthorityProto.newBuilder().setEvent(paramEvent).build()); 
  }
  
  public static void a(SystemAuthorityProtos.Event paramEvent, SystemAuthorityProtos.Type paramType, boolean paramBoolean) {
    if (paramEvent != null && paramType != null)
      EventTrackUtils.a((Message)SystemAuthorityProtos.SystemAuthorityProto.newBuilder().setEvent(paramEvent).setType(paramType).setIsOpen(paramBoolean).build()); 
  }
  
  public static void a(SystemAuthorityProtos.Event paramEvent, String paramString) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)SystemAuthorityProtos.SystemAuthorityProto.newBuilder().setEvent(paramEvent).setUrl(a(paramString)).build()); 
  }
  
  public static void b(SystemAuthorityProtos.Event paramEvent, String paramString) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)SystemAuthorityProtos.SystemAuthorityProto.newBuilder().setEvent(paramEvent).setContent(paramString).build()); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\log\trackUtils\EventTrackSystemAuthority.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */