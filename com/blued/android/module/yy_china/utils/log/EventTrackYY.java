package com.blued.android.module.yy_china.utils.log;

import android.text.TextUtils;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.google.protobuf.Message;

public class EventTrackYY {
  private static ChatRoomProtos.WarnType a(int paramInt) {
    return (ChatRoomProtos.WarnType.forNumber(paramInt) == null) ? ChatRoomProtos.WarnType.UNKNOWN_WARN_TYPE : ChatRoomProtos.WarnType.forNumber(paramInt);
  }
  
  private static String a(String paramString) {
    return EventTrackUtils.a(paramString);
  }
  
  public static void a(ChatRoomProtos.Event paramEvent) {
    if (paramEvent == null)
      return; 
    EventTrackUtils.a((Message)ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(paramEvent).build());
  }
  
  public static void a(ChatRoomProtos.Event paramEvent, String paramString) {
    if (paramEvent == null)
      return; 
    EventTrackUtils.a((Message)ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(paramEvent).setBannerId(paramString).build());
  }
  
  public static void a(ChatRoomProtos.Event paramEvent, String paramString, ChatRoomProtos.UserType paramUserType) {
    if (paramEvent == null)
      return; 
    if (paramUserType == null)
      return; 
    ChatRoomProtos.ChatRoomProto.Builder builder = ChatRoomProtos.ChatRoomProto.newBuilder();
    builder.setEvent(paramEvent);
    builder.setSource(a(paramString));
    builder.setUserType(paramUserType);
    EventTrackUtils.a((Message)builder.build());
  }
  
  public static void a(ChatRoomProtos.Event paramEvent, String paramString1, String paramString2) {
    if (paramEvent == null)
      return; 
    EventTrackUtils.a((Message)ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(paramEvent).setRoomId(a(paramString1)).setRoomUid(a(paramString2)).build());
  }
  
  public static void a(ChatRoomProtos.Event paramEvent, String paramString1, String paramString2, int paramInt) {
    if (paramEvent == null)
      return; 
    EventTrackUtils.a((Message)ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(paramEvent).setRoomId(a(paramString1)).setRoomUid(a(paramString2)).setPosition(paramInt).build());
  }
  
  public static void a(ChatRoomProtos.Event paramEvent, String paramString1, String paramString2, String paramString3) {
    if (paramEvent == null)
      return; 
    EventTrackUtils.a((Message)ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(paramEvent).setRoomId(a(paramString1)).setRoomUid(a(paramString2)).setTargetUid(a(paramString3)).build());
  }
  
  public static void a(ChatRoomProtos.Event paramEvent, String paramString1, String paramString2, String paramString3, int paramInt) {
    if (paramEvent == null)
      return; 
    EventTrackUtils.a((Message)ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(paramEvent).setRoomId(a(paramString1)).setId(a(paramString2)).setMusicId(a(paramString3)).setDuration(paramInt).build());
  }
  
  public static void a(ChatRoomProtos.Event paramEvent, String paramString1, String paramString2, String paramString3, String paramString4) {
    if (paramEvent == null)
      return; 
    ChatRoomProtos.ChatRoomProto.Builder builder = ChatRoomProtos.ChatRoomProto.newBuilder();
    builder.setEvent(paramEvent);
    if (!TextUtils.isEmpty(paramString1))
      builder.setRoomId(a(paramString1)); 
    if (!TextUtils.isEmpty(paramString2))
      builder.setRoomUid(a(paramString2)); 
    if (!TextUtils.isEmpty(paramString3))
      builder.setTabId(a(paramString3)); 
    if (!TextUtils.isEmpty(paramString4))
      builder.setSource(a(paramString4)); 
    EventTrackUtils.a((Message)builder.build());
  }
  
  public static void a(ChatRoomProtos.Event paramEvent, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt) {
    if (paramEvent == null)
      return; 
    EventTrackUtils.a((Message)ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(paramEvent).setRoomId(a(paramString1)).setRoomUid(a(paramString2)).setTargetUid(a(paramString3)).setWarnType(a(paramInt)).setContent(a(paramString4)).build());
  }
  
  public static void a(ChatRoomProtos.Event paramEvent, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String paramString5, int paramInt3, int paramInt4, int paramInt5) {
    if (paramEvent == null)
      return; 
    EventTrackUtils.a((Message)ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(paramEvent).setRoomId(a(paramString1)).setRoomUid(a(paramString2)).setTargetUid(a(paramString3)).setGoodsId(a(paramString4)).setNum(paramInt1).setCount(paramInt2).setSource(paramString5).setPosition(paramInt3).setTabNum(paramInt4).setPageNum(paramInt5).build());
  }
  
  public static void a(ChatRoomProtos.Event paramEvent, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    if (paramEvent == null)
      return; 
    ChatRoomProtos.ChatRoomProto.Builder builder = ChatRoomProtos.ChatRoomProto.newBuilder();
    builder.setEvent(paramEvent);
    if (!TextUtils.isEmpty(paramString1))
      builder.setRoomId(a(paramString1)); 
    if (!TextUtils.isEmpty(paramString2))
      builder.setRoomUid(a(paramString2)); 
    if (!TextUtils.isEmpty(paramString3))
      builder.setTabId(a(paramString3)); 
    if (!TextUtils.isEmpty(paramString4))
      builder.setRoomType(a(paramString4)); 
    if (!TextUtils.isEmpty(paramString5))
      builder.setSource(a(paramString5)); 
    EventTrackUtils.a((Message)builder.build());
  }
  
  public static void a(ChatRoomProtos.Event paramEvent, String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
    if (paramEvent == null)
      return; 
    EventTrackUtils.a((Message)ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(paramEvent).setRoomId(a(paramString1)).setRoomUid(a(paramString2)).setTargetUid(a(paramString3)).setIsFollow(paramBoolean).build());
  }
  
  public static void b(ChatRoomProtos.Event paramEvent, String paramString) {
    if (paramEvent == null)
      return; 
    EventTrackUtils.a((Message)ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(paramEvent).setRoomType(paramString).build());
  }
  
  public static void b(ChatRoomProtos.Event paramEvent, String paramString1, String paramString2) {
    if (paramEvent == null)
      return; 
    EventTrackUtils.a((Message)ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(paramEvent).setRoomId(a(paramString1)).setId(a(paramString2)).build());
  }
  
  public static void b(ChatRoomProtos.Event paramEvent, String paramString1, String paramString2, String paramString3) {
    if (paramEvent == null)
      return; 
    EventTrackUtils.a((Message)ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(paramEvent).setRoomId(a(paramString1)).setRoomUid(a(paramString2)).setRoomType(a(paramString3)).build());
  }
  
  public static void c(ChatRoomProtos.Event paramEvent, String paramString) {
    if (paramEvent == null)
      return; 
    EventTrackUtils.a((Message)ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(paramEvent).setRoomId(a(paramString)).build());
  }
  
  public static void c(ChatRoomProtos.Event paramEvent, String paramString1, String paramString2) {
    if (paramEvent == null)
      return; 
    EventTrackUtils.a((Message)ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(paramEvent).setRoomId(a(paramString1)).setRange(a(paramString2)).build());
  }
  
  public static void c(ChatRoomProtos.Event paramEvent, String paramString1, String paramString2, String paramString3) {
    if (paramEvent == null)
      return; 
    EventTrackUtils.a((Message)ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(paramEvent).setRoomId(a(paramString1)).setRoomUid(a(paramString2)).setSource(paramString3).build());
  }
  
  public static void d(ChatRoomProtos.Event paramEvent, String paramString1, String paramString2, String paramString3) {
    if (paramEvent == null)
      return; 
    ChatRoomProtos.ChatRoomProto.Builder builder = ChatRoomProtos.ChatRoomProto.newBuilder();
    builder.setEvent(paramEvent);
    builder.setSource(a(paramString3));
    builder.setRoomType(a(paramString2));
    builder.setRoomName(a(paramString1));
    EventTrackUtils.a((Message)builder.build());
  }
  
  public static void e(ChatRoomProtos.Event paramEvent, String paramString1, String paramString2, String paramString3) {
    if (paramEvent == null)
      return; 
    ChatRoomProtos.ChatRoomProto.Builder builder = ChatRoomProtos.ChatRoomProto.newBuilder();
    builder.setEvent(paramEvent);
    if (!TextUtils.isEmpty(paramString1))
      builder.setRoomId(a(paramString1)); 
    if (!TextUtils.isEmpty(paramString2))
      builder.setRoomUid(a(paramString2)); 
    if (!TextUtils.isEmpty(paramString3))
      builder.setId(a(paramString3)); 
    EventTrackUtils.a((Message)builder.build());
  }
  
  public static void f(ChatRoomProtos.Event paramEvent, String paramString1, String paramString2, String paramString3) {
    if (paramEvent == null)
      return; 
    ChatRoomProtos.ChatRoomProto.Builder builder = ChatRoomProtos.ChatRoomProto.newBuilder();
    builder.setEvent(paramEvent);
    builder.setRoomId(a(paramString1));
    builder.setRoomUid(a(paramString2));
    builder.setId(a(paramString3));
    EventTrackUtils.a((Message)builder.build());
  }
  
  public static void g(ChatRoomProtos.Event paramEvent, String paramString1, String paramString2, String paramString3) {
    if (paramEvent == null)
      return; 
    ChatRoomProtos.ChatRoomProto.Builder builder = ChatRoomProtos.ChatRoomProto.newBuilder();
    builder.setEvent(paramEvent);
    builder.setRoomId(a(paramString1));
    builder.setRoomUid(a(paramString2));
    builder.setTargetUid(a(paramString3));
    EventTrackUtils.a((Message)builder.build());
  }
  
  public static void h(ChatRoomProtos.Event paramEvent, String paramString1, String paramString2, String paramString3) {
    if (paramEvent == null)
      return; 
    EventTrackUtils.a((Message)ChatRoomProtos.ChatRoomProto.newBuilder().setEvent(paramEvent).setRoomId(a(paramString1)).setId(a(paramString2)).setMusicId(a(paramString3)).build());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_chin\\utils\log\EventTrackYY.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */