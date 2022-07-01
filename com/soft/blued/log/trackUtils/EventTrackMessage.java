package com.soft.blued.log.trackUtils;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.das.message.MessageProtos;
import com.google.protobuf.Message;
import com.soft.blued.log.model.LogData;
import com.soft.blued.ui.find.manager.MapFindManager;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.Logger;

public class EventTrackMessage {
  private static MessageProtos.ShowType a(LogData paramLogData) {
    MessageProtos.ShowType showType2 = MessageProtos.ShowType.UNKNOWN_SHOW_TYPE;
    MessageProtos.ShowType showType1 = showType2;
    if (paramLogData != null) {
      showType1 = showType2;
      if (paramLogData.k != null) {
        if ("0".equalsIgnoreCase(paramLogData.k))
          return MessageProtos.ShowType.PALACE_SHOW; 
        showType1 = MessageProtos.ShowType.LIST_SHOW;
      } 
    } 
    return showType1;
  }
  
  private static String a(String paramString) {
    return EventTrackUtils.a(paramString);
  }
  
  public static void a(MessageProtos.Event paramEvent) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)MessageProtos.MessageProto.newBuilder().setEvent(paramEvent).build()); 
  }
  
  public static void a(MessageProtos.Event paramEvent, int paramInt) {
    if (paramEvent != null) {
      MessageProtos.MessageProto.Builder builder = MessageProtos.MessageProto.newBuilder().setEvent(paramEvent);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramInt);
      stringBuilder.append("");
      EventTrackUtils.a((Message)builder.setImageId(stringBuilder.toString()).build());
    } 
  }
  
  public static void a(MessageProtos.Event paramEvent, int paramInt, String paramString) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)MessageProtos.MessageProto.newBuilder().setEvent(paramEvent).setPosition(paramInt).setTargetUid(paramString).build()); 
  }
  
  public static void a(MessageProtos.Event paramEvent, MessageProtos.MsgScreenClickType paramMsgScreenClickType) {
    if (paramEvent != null && paramMsgScreenClickType != null)
      EventTrackUtils.a((Message)MessageProtos.MessageProto.newBuilder().setEvent(paramEvent).setMsgScreenClickType(paramMsgScreenClickType).build()); 
  }
  
  public static void a(MessageProtos.Event paramEvent, MessageProtos.SourceType paramSourceType, int paramInt, MessageProtos.PhotoType paramPhotoType) {
    if (paramEvent != null && paramSourceType != null && paramPhotoType != null)
      EventTrackUtils.a((Message)MessageProtos.MessageProto.newBuilder().setEvent(paramEvent).setPhotoSource(paramSourceType).setPhotoNum(paramInt).setPhotoType(paramPhotoType).build()); 
  }
  
  public static void a(MessageProtos.Event paramEvent, MessageProtos.StrangerSource paramStrangerSource, String paramString) {
    MessageProtos.MessageProto.Builder builder = MessageProtos.MessageProto.newBuilder();
    if (paramEvent != null)
      builder.setEvent(paramEvent); 
    if (paramStrangerSource != null)
      builder.setStrangerSource(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE); 
    if (!TextUtils.isEmpty(paramString))
      builder.setTargetUid(paramString); 
    EventTrackUtils.a((Message)builder.build());
  }
  
  public static void a(MessageProtos.Event paramEvent, MessageProtos.StrangerSource paramStrangerSource, String paramString, boolean paramBoolean) {
    MessageProtos.MessageProto.Builder builder = MessageProtos.MessageProto.newBuilder();
    if (paramEvent != null)
      builder.setEvent(paramEvent); 
    if (paramStrangerSource != null)
      builder.setStrangerSource(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE); 
    if (!TextUtils.isEmpty(paramString))
      builder.setTargetUid(paramString); 
    builder.setIsValid(paramBoolean);
    EventTrackUtils.a((Message)builder.build());
  }
  
  public static void a(MessageProtos.Event paramEvent, MessageProtos.WarnType paramWarnType, MessageProtos.WarnTime paramWarnTime) {
    if (paramEvent != null && paramWarnType != null)
      EventTrackUtils.a((Message)MessageProtos.MessageProto.newBuilder().setEvent(paramEvent).setWarnTime(paramWarnTime).setWarnType(paramWarnType).build()); 
  }
  
  public static void a(MessageProtos.Event paramEvent, LogData paramLogData) {
    if (paramEvent != null) {
      LogData logData = paramLogData;
      if (paramLogData == null)
        logData = new LogData(); 
      boolean bool = "1".equalsIgnoreCase(logData.u);
      MessageProtos.MessageProto messageProto = MessageProtos.MessageProto.newBuilder().setEvent(paramEvent).setStrangerSource(b(logData.F)).setShowType(a(logData)).setTargetUid(a(logData.b)).setIsAppreciateCall(bool).setIsSuperExposure(logData.B).setIsMapFind(MapFindManager.a().b()).setIsShadow(logData.C).setIsQuietCall(logData.E).setIsAi(logData.D).build();
      if (AppInfo.m()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramEvent.name());
        stringBuilder.append("=");
        stringBuilder.append(BluedConfig.b().a().toJson(logData));
        Logger.c("ljx_log:", new Object[] { stringBuilder.toString() });
      } 
      EventTrackUtils.a((Message)messageProto);
    } 
  }
  
  public static void a(MessageProtos.Event paramEvent, String paramString) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)MessageProtos.MessageProto.newBuilder().setEvent(paramEvent).setUrl(paramString).build()); 
  }
  
  public static void a(MessageProtos.Event paramEvent, String paramString1, MessageProtos.SortType paramSortType, String paramString2) {
    if (paramEvent != null && paramSortType != null)
      EventTrackUtils.a((Message)MessageProtos.MessageProto.newBuilder().setEvent(paramEvent).setTargetUid(a(paramString1)).setSortType(paramSortType).setCallFilter(a(paramString2)).build()); 
  }
  
  public static void a(MessageProtos.Event paramEvent, String paramString1, String paramString2) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)MessageProtos.MessageProto.newBuilder().setEvent(paramEvent).setId(paramString1).setTargetUid(paramString2).build()); 
  }
  
  public static void a(MessageProtos.Event paramEvent, String paramString1, String paramString2, String paramString3) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)MessageProtos.MessageProto.newBuilder().setEvent(paramEvent).setTargetUid(paramString1).setType(paramString2).setUrl(paramString3).build()); 
  }
  
  public static void a(MessageProtos.Event paramEvent, String paramString, boolean... paramVarArgs) {
    if (paramEvent != null) {
      MessageProtos.MessageProto.Builder builder = MessageProtos.MessageProto.newBuilder().setEvent(paramEvent);
      int i = paramVarArgs.length;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (i > 0) {
        bool1 = bool2;
        if (paramVarArgs[0])
          bool1 = true; 
      } 
      EventTrackUtils.a((Message)builder.setIsBuy(bool1).setId(paramString).build());
    } 
  }
  
  public static void a(MessageProtos.Event paramEvent, boolean paramBoolean) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)MessageProtos.MessageProto.newBuilder().setEvent(paramEvent).setIsOpen(paramBoolean).build()); 
  }
  
  private static MessageProtos.StrangerSource b(String paramString) {
    MessageProtos.StrangerSource strangerSource = MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE;
    return "my_visitor".equalsIgnoreCase(paramString) ? MessageProtos.StrangerSource.FRIEND_NEARBY_VISIT : ("my_visited".equalsIgnoreCase(paramString) ? MessageProtos.StrangerSource.FRIEND_NEARBY_VIEW : ("feed_notice".equalsIgnoreCase(paramString) ? MessageProtos.StrangerSource.FOLLOW_ATTENTION : ("shine_video_list".equalsIgnoreCase(paramString) ? MessageProtos.StrangerSource.FIND_PLAZA_FLASH : ("feed_square".equalsIgnoreCase(paramString) ? MessageProtos.StrangerSource.FIND_PLAZA_RECOMMEND : ("msg_hello".equalsIgnoreCase(paramString) ? MessageProtos.StrangerSource.APPRECIATE_CALL_SHORT : ("msg_hello_detail".equalsIgnoreCase(paramString) ? MessageProtos.StrangerSource.APPRECIATE_CALL_TOTAL : (("my_followed".equalsIgnoreCase(paramString) || "my_secret_follow".equalsIgnoreCase(paramString)) ? MessageProtos.StrangerSource.MINE_FOLLOW : ("my_fans".equalsIgnoreCase(paramString) ? MessageProtos.StrangerSource.MINE_FAN : ("my_friends".equalsIgnoreCase(paramString) ? MessageProtos.StrangerSource.MINE_FRIEND : ("integrate".equalsIgnoreCase(paramString) ? MessageProtos.StrangerSource.COMPLEX_SORT : ("online".equalsIgnoreCase(paramString) ? MessageProtos.StrangerSource.ONLINE_TIME_SORT : ("nearby".equalsIgnoreCase(paramString) ? MessageProtos.StrangerSource.DISTANCE_SORT : ("selected".equalsIgnoreCase(paramString) ? MessageProtos.StrangerSource.NEARBY_FEATURED : ("newbie".equalsIgnoreCase(paramString) ? MessageProtos.StrangerSource.NEW_FACE : ("nearby_mix_recommend".equalsIgnoreCase(paramString) ? MessageProtos.StrangerSource.APPRECIATE_CALL_SHORT : ("feed_comment_floor".equalsIgnoreCase(paramString) ? MessageProtos.StrangerSource.FEED_COMMENT : ("topic_detail".equalsIgnoreCase(paramString) ? MessageProtos.StrangerSource.SUPER_TOPIC_DETAIL : ("feed_followed".equalsIgnoreCase(paramString) ? MessageProtos.StrangerSource.FIND_PLAZA_FOLLOW : ("feed_nearby".equalsIgnoreCase(paramString) ? MessageProtos.StrangerSource.FIND_PLAZA_NEARBY : ("feed_image".equalsIgnoreCase(paramString) ? MessageProtos.StrangerSource.FIND_PLAZA_IMAGE : ("shine_video_detail".equalsIgnoreCase(paramString) ? MessageProtos.StrangerSource.FIND_PLAZA_FLASH_DETAIL : ("feed_detail".equalsIgnoreCase(paramString) ? MessageProtos.StrangerSource.FEED_DETAIL : ("feed_horizontal_recommend".equalsIgnoreCase(paramString) ? MessageProtos.StrangerSource.FIND_PLAZA_RECOMMEND_USER : ("PAGE_FEED_MINE".equalsIgnoreCase(paramString) ? MessageProtos.StrangerSource.PAGE_FEED_MINE : ("PAGE_FEED_LIKE".equalsIgnoreCase(paramString) ? MessageProtos.StrangerSource.PAGE_FEED_LIKE : ("PAGE_FEED_DETAIL_MORE".equalsIgnoreCase(paramString) ? MessageProtos.StrangerSource.PAGE_FEED_DETAIL_MORE : ("CIRCLE_MEMBERS".equalsIgnoreCase(paramString) ? MessageProtos.StrangerSource.CIRCLE_USERS : ("CIRCLE_NOTE_DETAIL".equalsIgnoreCase(paramString) ? MessageProtos.StrangerSource.CIRCLE_NOTE_DETAIL : strangerSource))))))))))))))))))))))))))));
  }
  
  public static void b(MessageProtos.Event paramEvent, String paramString) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)MessageProtos.MessageProto.newBuilder().setEvent(paramEvent).setDestination(paramString).build()); 
  }
  
  public static void b(MessageProtos.Event paramEvent, String paramString1, String paramString2) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)MessageProtos.MessageProto.newBuilder().setEvent(paramEvent).setLiveId(paramString1).setTargetUid(paramString2).build()); 
  }
  
  public static void c(MessageProtos.Event paramEvent, String paramString) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)MessageProtos.MessageProto.newBuilder().setEvent(paramEvent).setKeyword(paramString).build()); 
  }
  
  public static void c(MessageProtos.Event paramEvent, String paramString1, String paramString2) {
    if (paramEvent == null)
      return; 
    EventTrackUtils.a((Message)MessageProtos.MessageProto.newBuilder().setEvent(paramEvent).setRoomId(a(paramString1)).setRoomUid(a(paramString2)).build());
  }
  
  public static void d(MessageProtos.Event paramEvent, String paramString) {
    if (paramEvent == null)
      return; 
    EventTrackUtils.a((Message)MessageProtos.MessageProto.newBuilder().setEvent(paramEvent).setTargetUid(a(paramString)).build());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\log\trackUtils\EventTrackMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */