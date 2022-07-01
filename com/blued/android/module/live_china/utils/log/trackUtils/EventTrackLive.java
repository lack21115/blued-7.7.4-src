package com.blued.android.module.live_china.utils.log.trackUtils;

import com.blued.android.module.live_china.utils.log.EventTrackUtils;
import com.blued.das.live.LiveProtos;
import com.google.protobuf.Message;

public class EventTrackLive {
  public static LiveProtos.FollowStatus a(String paramString) {
    LiveProtos.FollowStatus followStatus = LiveProtos.FollowStatus.TO_FOLLOW;
    if ("1".equals(paramString))
      return LiveProtos.FollowStatus.FOLLOWED_HIM; 
    if ("2".equals(paramString))
      return LiveProtos.FollowStatus.FOLLOW_ME; 
    if ("3".equals(paramString))
      return LiveProtos.FollowStatus.FOLLOWED_EACH; 
    if ("8".equals(paramString) || "4".equals(paramString) || "12".equals(paramString))
      followStatus = LiveProtos.FollowStatus.FOLLOW_BLACK; 
    return followStatus;
  }
  
  public static LiveProtos.TaskType a(int paramInt) {
    LiveProtos.TaskType taskType = LiveProtos.TaskType.UNKNOWN_TASK_TYPE;
    return (paramInt != 1) ? ((paramInt != 2) ? ((paramInt != 3) ? ((paramInt != 4) ? ((paramInt != 5) ? taskType : LiveProtos.TaskType.SEND_ANY_GIFT) : LiveProtos.TaskType.RECHARGE_ANY) : LiveProtos.TaskType.SEND_3_MSG) : LiveProtos.TaskType.WATCH_15M) : LiveProtos.TaskType.LOGIN_DAILY;
  }
  
  public static void a(LiveProtos.Event paramEvent) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).build()); 
  }
  
  public static void a(LiveProtos.Event paramEvent, long paramLong, String paramString, LiveProtos.BoxType paramBoxType) {
    if (paramEvent != null && paramBoxType != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setTargetUid(c(paramString)).setLiveId(String.valueOf(paramLong)).setBoxType(paramBoxType).build()); 
  }
  
  public static void a(LiveProtos.Event paramEvent, long paramLong, String paramString, LiveProtos.FollowStatus paramFollowStatus) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setTargetUid(c(paramString)).setLiveId(String.valueOf(paramLong)).setFollowStatus(paramFollowStatus).build()); 
  }
  
  public static void a(LiveProtos.Event paramEvent, long paramLong, String paramString, boolean paramBoolean) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setTargetUid(c(paramString)).setLiveId(String.valueOf(paramLong)).setIsQueue(paramBoolean).build()); 
  }
  
  public static void a(LiveProtos.Event paramEvent, LiveProtos.BtnType paramBtnType, String paramString1, String paramString2) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setTargetUid(c(paramString2)).setLiveId(c(paramString1)).setBtnType(paramBtnType).build()); 
  }
  
  public static void a(LiveProtos.Event paramEvent, LiveProtos.CardFrom paramCardFrom) {
    if (paramEvent == null)
      return; 
    if (paramCardFrom == null)
      return; 
    EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setCardFrom(paramCardFrom).build());
  }
  
  public static void a(LiveProtos.Event paramEvent, LiveProtos.LiveType paramLiveType) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setLiveType(paramLiveType).build()); 
  }
  
  public static void a(LiveProtos.Event paramEvent, LiveProtos.Status paramStatus) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setStatus(paramStatus).build()); 
  }
  
  public static void a(LiveProtos.Event paramEvent, String paramString) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setLiveId(c(paramString)).build()); 
  }
  
  public static void a(LiveProtos.Event paramEvent, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setLiveId(c(paramString)).setBeansCount(paramInt1).setBeansNum(paramInt2).setViewCount(paramInt3).setLikeCount(paramInt4).setOnlineCount(paramInt5).setLiveDuration(paramInt6).build()); 
  }
  
  public static void a(LiveProtos.Event paramEvent, String paramString, LiveProtos.Status paramStatus) {
    if (paramEvent != null && paramStatus != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setFilterId(c(paramString)).setStatus(paramStatus).build()); 
  }
  
  public static void a(LiveProtos.Event paramEvent, String paramString1, String paramString2) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setTargetUid(c(paramString2)).setLiveId(c(paramString1)).build()); 
  }
  
  public static void a(LiveProtos.Event paramEvent, String paramString1, String paramString2, int paramInt) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setTargetUid(c(paramString2)).setLiveId(c(paramString1)).setPosition(paramInt).build()); 
  }
  
  public static void a(LiveProtos.Event paramEvent, String paramString1, String paramString2, LiveProtos.TaskType paramTaskType) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setTargetUid(paramString2).setLiveId(paramString1).setTaskType(paramTaskType).build()); 
  }
  
  public static void a(LiveProtos.Event paramEvent, String paramString1, String paramString2, String paramString3) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setTargetUid(c(paramString3)).setLiveId(c(paramString1)).setTaskId(c(paramString2)).build()); 
  }
  
  public static void a(LiveProtos.Event paramEvent, String paramString1, String paramString2, String paramString3, int paramInt) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setLiveId(c(paramString1)).setTargetUid(c(paramString2)).setGoodsId(c(paramString3)).setNum(paramInt).build()); 
  }
  
  public static void a(LiveProtos.Event paramEvent, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setTargetUid(c(paramString2)).setLiveId(c(paramString1)).setGoodsId(c(paramString3)).setPosition(paramInt1).setTabNum(paramInt2).setPageNum(paramInt3).build()); 
  }
  
  public static void a(LiveProtos.Event paramEvent, String paramString1, String paramString2, String paramString3, String paramString4) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setLiveId(c(paramString1)).setTargetUid(c(paramString2)).setRecommendLiveId(c(paramString3)).setRecommendUid(c(paramString4)).build()); 
  }
  
  public static void a(LiveProtos.Event paramEvent, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setTargetUid(c(paramString2)).setLiveId(c(paramString1)).setLiveFrom(c(paramString3)).setRecommendType(c(paramString4)).setLiveFromNum(paramInt).build()); 
  }
  
  public static void a(LiveProtos.Event paramEvent, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean1, boolean paramBoolean2, LiveProtos.LiveType paramLiveType) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setTargetUid(c(paramString2)).setLiveId(c(paramString1)).setLiveFrom(c(paramString3)).setLiveFromNum(paramInt1).setRecommendType(c(paramString4)).setGoodsId(c(paramString5)).setNum(paramInt2).setCount(paramInt3).setPosition(paramInt4).setTabNum(paramInt5).setPageNum(paramInt6).setIsHitTime(paramBoolean1).setIsPk(paramBoolean2).setLiveType(paramLiveType).build()); 
  }
  
  public static void a(LiveProtos.Event paramEvent, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setTargetUid(c(paramString2)).setLiveId(c(paramString1)).setFollowedUid(c(paramString3)).setLiveFrom(c(paramString4)).setRecommendType(c(paramString5)).setLiveFromNum(paramInt).build()); 
  }
  
  public static void a(LiveProtos.Event paramEvent, String paramString1, String paramString2, boolean paramBoolean) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setTargetUid(c(paramString2)).setLiveId(c(paramString1)).setIsSuccess(paramBoolean).build()); 
  }
  
  public static void a(LiveProtos.Event paramEvent, String paramString, boolean paramBoolean) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setLiveId(c(paramString)).setIsAuto(paramBoolean).build()); 
  }
  
  public static void a(LiveProtos.Event paramEvent, boolean paramBoolean) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setIsAuto(paramBoolean).build()); 
  }
  
  public static LiveProtos.FollowStatus b(String paramString) {
    LiveProtos.FollowStatus followStatus = LiveProtos.FollowStatus.TO_FOLLOW_STATUS;
    if ("1".equals(paramString))
      return LiveProtos.FollowStatus.FOLLOWED_STATUS; 
    if ("2".equals(paramString))
      return LiveProtos.FollowStatus.BE_FOLLOWED_STATUS; 
    if ("3".equals(paramString))
      followStatus = LiveProtos.FollowStatus.EACH_FOLLOW_STATUS; 
    return followStatus;
  }
  
  public static void b(LiveProtos.Event paramEvent, String paramString) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setTargetUid(c(paramString)).build()); 
  }
  
  public static void b(LiveProtos.Event paramEvent, String paramString1, String paramString2) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setLiveId(c(paramString1)).setTaskId(paramString2).build()); 
  }
  
  public static void b(LiveProtos.Event paramEvent, String paramString1, String paramString2, int paramInt) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setLiveId(c(paramString1)).setTargetUid(c(paramString2)).setCount(paramInt).build()); 
  }
  
  public static void b(LiveProtos.Event paramEvent, String paramString1, String paramString2, String paramString3) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setLiveId(c(paramString1)).setTargetUid(c(paramString2)).setGuestUid(c(paramString3)).build()); 
  }
  
  public static void b(LiveProtos.Event paramEvent, String paramString1, String paramString2, String paramString3, int paramInt) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setLiveId(c(paramString1)).setMusicId(c(paramString2)).setTabId(c(paramString3)).setCount(paramInt).build()); 
  }
  
  public static void b(LiveProtos.Event paramEvent, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setTargetUid(c(paramString2)).setLiveId(c(paramString1)).setFrom(c(paramString3)).setRecommendType(c(paramString4)).setLiveFromNum(paramInt).build()); 
  }
  
  public static void b(LiveProtos.Event paramEvent, String paramString1, String paramString2, boolean paramBoolean) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setTargetUid(c(paramString2)).setLiveId(c(paramString1)).setIsOpen(paramBoolean).build()); 
  }
  
  private static String c(String paramString) {
    return EventTrackUtils.a(paramString);
  }
  
  public static void c(LiveProtos.Event paramEvent, String paramString) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setId(c(paramString)).build()); 
  }
  
  public static void c(LiveProtos.Event paramEvent, String paramString1, String paramString2) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setLiveId(c(paramString1)).setTabId(c(paramString2)).build()); 
  }
  
  public static void c(LiveProtos.Event paramEvent, String paramString1, String paramString2, String paramString3) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setTargetUid(c(paramString2)).setLiveId(c(paramString1)).setLiveFrom(paramString3).build()); 
  }
  
  public static void d(LiveProtos.Event paramEvent, String paramString1, String paramString2, String paramString3) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setLiveId(c(paramString1)).setMusicId(c(paramString2)).setTabId(c(paramString3)).build()); 
  }
  
  public static void e(LiveProtos.Event paramEvent, String paramString1, String paramString2, String paramString3) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setLiveId(c(paramString1)).setTargetUid(c(paramString2)).setPassword(c(paramString3)).build()); 
  }
  
  public static void f(LiveProtos.Event paramEvent, String paramString1, String paramString2, String paramString3) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LiveProtos.LiveProto.newBuilder().setEvent(paramEvent).setTargetUid(c(paramString2)).setLiveId(c(paramString1)).setUrl(c(paramString3)).build()); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_chin\\utils\log\trackUtils\EventTrackLive.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */