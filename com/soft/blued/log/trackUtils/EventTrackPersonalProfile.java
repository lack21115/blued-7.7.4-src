package com.soft.blued.log.trackUtils;

import com.blued.android.core.AppInfo;
import com.blued.das.profile.PersonalProfileProtos;
import com.google.protobuf.Message;
import com.soft.blued.log.model.LogData;
import com.soft.blued.ui.find.manager.MapFindManager;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.Logger;

public class EventTrackPersonalProfile {
  private static PersonalProfileProtos.ShowType a(LogData paramLogData) {
    PersonalProfileProtos.ShowType showType2 = PersonalProfileProtos.ShowType.UNKNOWN_SHOW_TYPE;
    PersonalProfileProtos.ShowType showType1 = showType2;
    if (paramLogData != null) {
      showType1 = showType2;
      if (paramLogData.k != null) {
        if ("0".equalsIgnoreCase(paramLogData.k))
          return PersonalProfileProtos.ShowType.PALACE_SHOW; 
        showType1 = PersonalProfileProtos.ShowType.LIST_SHOW;
      } 
    } 
    return showType1;
  }
  
  public static PersonalProfileProtos.TargetIdentityType a(int paramInt) {
    return (paramInt != 1) ? ((paramInt != 2) ? PersonalProfileProtos.TargetIdentityType.NONE : PersonalProfileProtos.TargetIdentityType.SVIP) : PersonalProfileProtos.TargetIdentityType.VIP;
  }
  
  private static String a(String paramString) {
    return EventTrackUtils.a(paramString);
  }
  
  public static void a(PersonalProfileProtos.Event paramEvent) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)PersonalProfileProtos.PersonalProfileProto.newBuilder().setEvent(paramEvent).build()); 
  }
  
  public static void a(PersonalProfileProtos.Event paramEvent, int paramInt) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)PersonalProfileProtos.PersonalProfileProto.newBuilder().setEvent(paramEvent).setType(paramInt).build()); 
  }
  
  public static void a(PersonalProfileProtos.Event paramEvent, PersonalProfileProtos.TabType paramTabType, String paramString) {
    if (paramEvent != null && paramTabType != null)
      EventTrackUtils.a((Message)PersonalProfileProtos.PersonalProfileProto.newBuilder().setTabType(paramTabType).setEvent(paramEvent).setTargetUid(a(paramString)).build()); 
  }
  
  public static void a(PersonalProfileProtos.Event paramEvent, LogData paramLogData) {
    if (paramEvent != null) {
      String str;
      LogData logData = paramLogData;
      if (paramLogData == null)
        logData = new LogData(); 
      if (AppInfo.m()) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramEvent.name());
        stringBuilder1.append("=");
        stringBuilder1.append(BluedConfig.b().a().toJson(logData));
        Logger.c("ljx_log:", new Object[] { stringBuilder1.toString() });
      } 
      boolean bool = "1".equalsIgnoreCase(logData.u);
      PersonalProfileProtos.PersonalProfileProto.Builder builder2 = PersonalProfileProtos.PersonalProfileProto.newBuilder().setEvent(paramEvent).setSource(b(logData.F)).setShowType(a(logData));
      if (logData.x == null) {
        str = "";
      } else {
        str = logData.x;
      } 
      builder2 = builder2.setDistance(str);
      if (logData.y == null) {
        str = "";
      } else {
        str = logData.y;
      } 
      builder2 = builder2.setOnlineTime(str).setReason(logData.z);
      if (logData.A == null) {
        str = "";
      } else {
        str = logData.A;
      } 
      PersonalProfileProtos.PersonalProfileProto.Builder builder1 = builder2.setLabel(str).setTargetUid(a(logData.b)).setIsAppreciateCall(bool).setIsSuperExposure(logData.B).setIsMapFind(MapFindManager.a().b()).setIsShadow(logData.C).setIsQuietCall(logData.E).setIsFollow(logData.G);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(logData.H);
      stringBuilder.append("");
      EventTrackUtils.a((Message)builder1.setLiveId(a(stringBuilder.toString())).setIsAi(logData.D).setFeedId(a(logData.I)).build());
    } 
  }
  
  public static void a(PersonalProfileProtos.Event paramEvent, String paramString) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)PersonalProfileProtos.PersonalProfileProto.newBuilder().setEvent(paramEvent).setFeedId(a(paramString)).build()); 
  }
  
  public static void a(PersonalProfileProtos.Event paramEvent, String paramString, int paramInt) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)PersonalProfileProtos.PersonalProfileProto.newBuilder().setEvent(paramEvent).setTargetUid(a(paramString)).setTargetIdentityType(a(paramInt)).build()); 
  }
  
  public static void a(PersonalProfileProtos.Event paramEvent, String paramString, PersonalProfileProtos.GiftFrom paramGiftFrom) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)PersonalProfileProtos.PersonalProfileProto.newBuilder().setTargetUid(a(paramString)).setEvent(paramEvent).setGiftFrom(paramGiftFrom).build()); 
  }
  
  public static void a(PersonalProfileProtos.Event paramEvent, String paramString1, PersonalProfileProtos.GiftFrom paramGiftFrom, String paramString2, boolean paramBoolean) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)PersonalProfileProtos.PersonalProfileProto.newBuilder().setTargetUid(a(paramString1)).setEvent(paramEvent).setGiftId(a(paramString2)).setGiftFrom(paramGiftFrom).setIsBag(paramBoolean).build()); 
  }
  
  public static void a(PersonalProfileProtos.Event paramEvent, String paramString1, String paramString2) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)PersonalProfileProtos.PersonalProfileProto.newBuilder().setEvent(paramEvent).setTargetUid(a(paramString1)).setId(paramString2).build()); 
  }
  
  public static void a(PersonalProfileProtos.Event paramEvent, String paramString1, String paramString2, int paramInt, String paramString3) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)PersonalProfileProtos.PersonalProfileProto.newBuilder().setTargetUid(a(paramString1)).setEvent(paramEvent).setFeedId(a(paramString2)).setType(paramInt).setUrl(paramString3).build()); 
  }
  
  public static void a(PersonalProfileProtos.Event paramEvent, String paramString1, String paramString2, boolean paramBoolean) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)PersonalProfileProtos.PersonalProfileProto.newBuilder().setEvent(paramEvent).setTargetUid(a(paramString1)).setFeedId(a(paramString2)).setIsVideo(paramBoolean).build()); 
  }
  
  public static void a(String paramString, PersonalProfileProtos.VoteOption paramVoteOption) {
    EventTrackUtils.a((Message)PersonalProfileProtos.PersonalProfileProto.newBuilder().setEvent(PersonalProfileProtos.Event.BLUED_OFFICER_VOTE_BTN_CLICK).setTargetUid(paramString).setVoteOption(paramVoteOption).build());
  }
  
  public static void a(boolean paramBoolean) {
    EventTrackUtils.a((Message)PersonalProfileProtos.PersonalProfileProto.newBuilder().setEvent(PersonalProfileProtos.Event.EDIT_SIGNATURE_VIP_PAGE_BTN_CLICK).setIdentityNum((UserInfo.a().i()).vbadge).setIsOpen(paramBoolean).build());
  }
  
  private static PersonalProfileProtos.Source b(String paramString) {
    PersonalProfileProtos.Source source = PersonalProfileProtos.Source.UNKNOWN_FOLLOW_SOURCE;
    return "my_visitor".equalsIgnoreCase(paramString) ? PersonalProfileProtos.Source.FRIEND_NEARBY_VISIT : ("my_visited".equalsIgnoreCase(paramString) ? PersonalProfileProtos.Source.FRIEND_NEARBY_VIEW : ("feed_notice".equalsIgnoreCase(paramString) ? PersonalProfileProtos.Source.FOLLOW_ATTENTION : ("shine_video_list".equalsIgnoreCase(paramString) ? PersonalProfileProtos.Source.FIND_PLAZA_FLASH : ("feed_square".equalsIgnoreCase(paramString) ? PersonalProfileProtos.Source.FIND_PLAZA_RECOMMEND : ("msg_hello".equalsIgnoreCase(paramString) ? PersonalProfileProtos.Source.APPRECIATE_CALL_SHORT : ("msg_hello_detail".equalsIgnoreCase(paramString) ? PersonalProfileProtos.Source.APPRECIATE_CALL_TOTAL : (("my_followed".equalsIgnoreCase(paramString) || "my_secret_follow".equalsIgnoreCase(paramString)) ? PersonalProfileProtos.Source.MINE_FOLLOW : ("my_fans".equalsIgnoreCase(paramString) ? PersonalProfileProtos.Source.MINE_FAN : ("my_friends".equalsIgnoreCase(paramString) ? PersonalProfileProtos.Source.MINE_FRIEND : ("integrate".equalsIgnoreCase(paramString) ? PersonalProfileProtos.Source.COMPLEX_SORT : ("online".equalsIgnoreCase(paramString) ? PersonalProfileProtos.Source.ONLINE_TIME_SORT : ("nearby".equalsIgnoreCase(paramString) ? PersonalProfileProtos.Source.DISTANCE_SORT : ("selected".equalsIgnoreCase(paramString) ? PersonalProfileProtos.Source.NEARBY_FEATURED : ("newbie".equalsIgnoreCase(paramString) ? PersonalProfileProtos.Source.NEW_FACE : ("nearby_mix_recommend".equalsIgnoreCase(paramString) ? PersonalProfileProtos.Source.APPRECIATE_CALL_SHORT : ("feed_comment_floor".equalsIgnoreCase(paramString) ? PersonalProfileProtos.Source.FEED_COMMENT : ("topic_detail".equalsIgnoreCase(paramString) ? PersonalProfileProtos.Source.SUPER_TOPIC_DETAIL : ("feed_followed".equalsIgnoreCase(paramString) ? PersonalProfileProtos.Source.FIND_PLAZA_FOLLOW : ("feed_nearby".equalsIgnoreCase(paramString) ? PersonalProfileProtos.Source.FIND_PLAZA_NEARBY : ("feed_image".equalsIgnoreCase(paramString) ? PersonalProfileProtos.Source.FIND_PLAZA_IMAGE : ("shine_video_detail".equalsIgnoreCase(paramString) ? PersonalProfileProtos.Source.FIND_PLAZA_FLASH_DETAIL : ("feed_detail".equalsIgnoreCase(paramString) ? PersonalProfileProtos.Source.FEED_DETAIL : ("feed_horizontal_recommend".equalsIgnoreCase(paramString) ? PersonalProfileProtos.Source.FIND_PLAZA_RECOMMEND_USER : ("PAGE_FEED_MINE".equalsIgnoreCase(paramString) ? PersonalProfileProtos.Source.PAGE_FEED_MINE : ("PAGE_FEED_LIKE".equalsIgnoreCase(paramString) ? PersonalProfileProtos.Source.PAGE_FEED_LIKE : ("PAGE_FEED_DETAIL_MORE".equalsIgnoreCase(paramString) ? PersonalProfileProtos.Source.PAGE_FEED_DETAIL_MORE : ("CIRCLE_MEMBERS".equalsIgnoreCase(paramString) ? PersonalProfileProtos.Source.CIRCLE_USERS : ("CIRCLE_NOTE_DETAIL".equalsIgnoreCase(paramString) ? PersonalProfileProtos.Source.CIRCLE_NOTE_DETAIL : ("CIRCLE_ACTIVE_MEMBER_LIST".equalsIgnoreCase(paramString) ? PersonalProfileProtos.Source.CIRCLE_ACTIVE_MEMBER_LIST : ("CIRCLE_ACTIVE_MEMBER_MISSION".equalsIgnoreCase(paramString) ? PersonalProfileProtos.Source.CIRCLE_ACTIVE_MEMBER_MISSION : source))))))))))))))))))))))))))))));
  }
  
  public static void b(PersonalProfileProtos.Event paramEvent, String paramString) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)PersonalProfileProtos.PersonalProfileProto.newBuilder().setTargetUid(a(paramString)).setEvent(paramEvent).build()); 
  }
  
  public static void b(PersonalProfileProtos.Event paramEvent, String paramString, int paramInt) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)PersonalProfileProtos.PersonalProfileProto.newBuilder().setTargetUid(a(paramString)).setEvent(paramEvent).setPosition(paramInt).build()); 
  }
  
  public static void b(PersonalProfileProtos.Event paramEvent, String paramString, PersonalProfileProtos.GiftFrom paramGiftFrom) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)PersonalProfileProtos.PersonalProfileProto.newBuilder().setTargetUid(a(paramString)).setEvent(paramEvent).setGiftFrom(paramGiftFrom).build()); 
  }
  
  public static void b(PersonalProfileProtos.Event paramEvent, String paramString1, String paramString2) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)PersonalProfileProtos.PersonalProfileProto.newBuilder().setEvent(paramEvent).setTargetUid(a(paramString1)).setLiveId(a(paramString2)).build()); 
  }
  
  public static void c(PersonalProfileProtos.Event paramEvent, String paramString1, String paramString2) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)PersonalProfileProtos.PersonalProfileProto.newBuilder().setEvent(paramEvent).setTargetUid(a(paramString1)).setFeedId(a(paramString2)).build()); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\log\trackUtils\EventTrackPersonalProfile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */