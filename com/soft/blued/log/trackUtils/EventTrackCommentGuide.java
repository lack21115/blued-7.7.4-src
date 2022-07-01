package com.soft.blued.log.trackUtils;

import com.blued.das.client.commentguide.CommentGuideProtos;
import com.google.protobuf.Message;

public class EventTrackCommentGuide {
  private static String a(String paramString) {
    return EventTrackUtils.a(paramString);
  }
  
  public static void a(CommentGuideProtos.Event paramEvent) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)CommentGuideProtos.CommentGuideProto.newBuilder().setEvent(paramEvent).build()); 
  }
  
  public static void a(CommentGuideProtos.Event paramEvent, String paramString) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)CommentGuideProtos.CommentGuideProto.newBuilder().setEvent(paramEvent).setShowOccasion(a(paramString)).build()); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\log\trackUtils\EventTrackCommentGuide.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */