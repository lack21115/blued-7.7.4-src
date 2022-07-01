package com.soft.blued.log.trackUtils;

import com.blued.das.login.LoginAndRegisterProtos;
import com.google.protobuf.Message;
import com.soft.blued.utils.Logger;

public class EventTrackLoginAndRegister {
  public static void a(LoginAndRegisterProtos.Event paramEvent) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LoginAndRegisterProtos.LoginAndRegisterProto.newBuilder().setEvent(paramEvent).build()); 
  }
  
  public static void a(LoginAndRegisterProtos.Event paramEvent, int paramInt1, int paramInt2, boolean paramBoolean) {
    if (paramEvent != null) {
      LoginAndRegisterProtos.LoginAndRegisterProto loginAndRegisterProto = LoginAndRegisterProtos.LoginAndRegisterProto.newBuilder().setEvent(paramEvent).setDuration(paramInt1).setThirdDuration(paramInt2).setIsCallback(paramBoolean).build();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramInt1);
      stringBuilder.append(";");
      stringBuilder.append(paramInt2);
      stringBuilder.append(";");
      stringBuilder.append(paramBoolean);
      Logger.a("splash_ad_data", stringBuilder.toString());
      EventTrackUtils.a((Message)loginAndRegisterProto);
    } 
  }
  
  public static void a(LoginAndRegisterProtos.Event paramEvent, LoginAndRegisterProtos.LabelType paramLabelType, LoginAndRegisterProtos.LabelStatus paramLabelStatus) {
    if (paramEvent != null && paramLabelType != null && paramLabelStatus != null)
      EventTrackUtils.a((Message)LoginAndRegisterProtos.LoginAndRegisterProto.newBuilder().setEvent(paramEvent).setLabelType(paramLabelType).setLabelStatus(paramLabelStatus).build()); 
  }
  
  public static void a(LoginAndRegisterProtos.Event paramEvent, LoginAndRegisterProtos.RoleType paramRoleType) {
    if (paramEvent != null && paramRoleType != null)
      EventTrackUtils.a((Message)LoginAndRegisterProtos.LoginAndRegisterProto.newBuilder().setEvent(paramEvent).setRoleType(paramRoleType).build()); 
  }
  
  public static void a(LoginAndRegisterProtos.Event paramEvent, LoginAndRegisterProtos.Source paramSource) {
    if (paramEvent != null) {
      LoginAndRegisterProtos.LoginAndRegisterProto.Builder builder = LoginAndRegisterProtos.LoginAndRegisterProto.newBuilder().setEvent(paramEvent);
      LoginAndRegisterProtos.Source source = paramSource;
      if (paramSource == null)
        source = LoginAndRegisterProtos.Source.UNKNOWN_SOURCE; 
      EventTrackUtils.a((Message)builder.setSource(source).build());
    } 
  }
  
  public static void a(LoginAndRegisterProtos.Event paramEvent, LoginAndRegisterProtos.UnitType paramUnitType) {
    if (paramEvent != null && paramUnitType != null)
      EventTrackUtils.a((Message)LoginAndRegisterProtos.LoginAndRegisterProto.newBuilder().setEvent(paramEvent).setUnitType(paramUnitType).build()); 
  }
  
  public static void a(LoginAndRegisterProtos.Event paramEvent, String paramString) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)LoginAndRegisterProtos.LoginAndRegisterProto.newBuilder().setEvent(paramEvent).setTargetUid(b(paramString)).build()); 
  }
  
  public static void a(String paramString) {
    EventTrackUtils.a((Message)LoginAndRegisterProtos.LoginAndRegisterProto.newBuilder().setEvent(LoginAndRegisterProtos.Event.HW_CHANNEL_DATA).setJson(b(paramString)).build());
  }
  
  private static String b(String paramString) {
    return EventTrackUtils.a(paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\log\trackUtils\EventTrackLoginAndRegister.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */