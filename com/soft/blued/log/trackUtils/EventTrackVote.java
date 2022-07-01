package com.soft.blued.log.trackUtils;

import com.blued.das.client.vote.VoteProtos;
import com.google.protobuf.Message;

public class EventTrackVote {
  private static String a(String paramString) {
    return EventTrackUtils.a(paramString);
  }
  
  public static void a(VoteProtos.Event paramEvent) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)VoteProtos.VoteProto.newBuilder().setEvent(paramEvent).build()); 
  }
  
  public static void a(VoteProtos.Event paramEvent, VoteProtos.FeedType paramFeedType) {
    if (paramEvent != null && paramFeedType != null)
      EventTrackUtils.a((Message)VoteProtos.VoteProto.newBuilder().setEvent(paramEvent).setFeedType(paramFeedType).build()); 
  }
  
  public static void a(VoteProtos.Event paramEvent, VoteProtos.PhotoOption paramPhotoOption, String paramString1, String paramString2) {
    if (paramEvent != null && paramPhotoOption != null)
      EventTrackUtils.a((Message)VoteProtos.VoteProto.newBuilder().setEvent(paramEvent).setPhotoOption(paramPhotoOption).setTargetUid(a(paramString1)).setFeedId(a(paramString2)).build()); 
  }
  
  public static void a(VoteProtos.Event paramEvent, String paramString1, String paramString2) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)VoteProtos.VoteProto.newBuilder().setEvent(paramEvent).setTargetUid(a(paramString1)).setFeedId(a(paramString2)).build()); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\log\trackUtils\EventTrackVote.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */