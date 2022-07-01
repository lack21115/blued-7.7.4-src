package com.soft.blued.log.trackUtils;

import com.blued.das.client.socialnet.SocialNetWorkProtos;
import com.google.protobuf.Message;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\000$\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\000\n\002\020\016\n\000\n\002\030\002\n\000\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J \020\003\032\0020\0042\006\020\005\032\0020\0062\006\020\007\032\0020\b2\006\020\t\032\0020\nH\007¨\006\013"}, d2 = {"Lcom/soft/blued/log/trackUtils/EventTrackGroup;", "", "()V", "sendEvent", "", "event", "Lcom/blued/das/client/socialnet/SocialNetWorkProtos$Event;", "group_id", "", "sourceType", "Lcom/blued/das/client/socialnet/SocialNetWorkProtos$SourceType;", "blued_app_a9999aRelease"}, k = 1, mv = {1, 1, 16})
public final class EventTrackGroup {
  public static final EventTrackGroup a = new EventTrackGroup();
  
  @JvmStatic
  public static final void a(SocialNetWorkProtos.Event paramEvent, String paramString, SocialNetWorkProtos.SourceType paramSourceType) {
    Intrinsics.b(paramEvent, "event");
    Intrinsics.b(paramString, "group_id");
    Intrinsics.b(paramSourceType, "sourceType");
    EventTrackUtils.a((Message)SocialNetWorkProtos.SocialNetWorkProto.newBuilder().setGroupId(paramString).setSource(paramSourceType).setEvent(paramEvent).build());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\log\trackUtils\EventTrackGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */