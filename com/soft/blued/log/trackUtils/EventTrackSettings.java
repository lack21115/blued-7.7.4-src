package com.soft.blued.log.trackUtils;

import com.blued.das.settings.SettingsProtos;
import com.google.protobuf.Message;

public class EventTrackSettings {
  private static String a(String paramString) {
    return EventTrackUtils.a(paramString);
  }
  
  public static void a(SettingsProtos.Event paramEvent) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)SettingsProtos.SettingsProto.newBuilder().setEvent(paramEvent).build()); 
  }
  
  public static void a(SettingsProtos.Event paramEvent, int paramInt) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)SettingsProtos.SettingsProto.newBuilder().setEvent(paramEvent).setNum(paramInt).build()); 
  }
  
  public static void a(SettingsProtos.Event paramEvent, SettingsProtos.ModuleType paramModuleType, String paramString1, String paramString2, boolean paramBoolean) {
    if (paramEvent != null && paramModuleType != null)
      EventTrackUtils.a((Message)SettingsProtos.SettingsProto.newBuilder().setEvent(paramEvent).setModuleType(paramModuleType).setLinkUrl(a(paramString1)).setBannerId(a(paramString2)).setIsShadow(paramBoolean).build()); 
  }
  
  public static void a(SettingsProtos.Event paramEvent, String paramString) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)SettingsProtos.SettingsProto.newBuilder().setEvent(paramEvent).setName(a(paramString)).build()); 
  }
  
  public static void a(SettingsProtos.Event paramEvent, String paramString1, String paramString2, boolean paramBoolean) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)SettingsProtos.SettingsProto.newBuilder().setEvent(paramEvent).setLinkUrl(a(paramString1)).setBannerId(a(paramString2)).setIsShadow(paramBoolean).build()); 
  }
  
  public static void a(SettingsProtos.Event paramEvent, boolean paramBoolean) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)SettingsProtos.SettingsProto.newBuilder().setIsOpen(paramBoolean).setEvent(paramEvent).build()); 
  }
  
  public static void b(SettingsProtos.Event paramEvent, int paramInt) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)SettingsProtos.SettingsProto.newBuilder().setEvent(paramEvent).setPosition(paramInt).build()); 
  }
  
  public static void b(SettingsProtos.Event paramEvent, String paramString) {
    if (paramEvent != null && paramString != null)
      EventTrackUtils.a((Message)SettingsProtos.SettingsProto.newBuilder().setEvent(paramEvent).setLinkUrl(a(paramString)).build()); 
  }
  
  public static void b(SettingsProtos.Event paramEvent, boolean paramBoolean) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)SettingsProtos.SettingsProto.newBuilder().setEvent(paramEvent).setIsOpen(paramBoolean).build()); 
  }
  
  public static void c(SettingsProtos.Event paramEvent, int paramInt) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)SettingsProtos.SettingsProto.newBuilder().setEvent(paramEvent).setFrom(paramInt).build()); 
  }
  
  public static void c(SettingsProtos.Event paramEvent, boolean paramBoolean) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)SettingsProtos.SettingsProto.newBuilder().setEvent(paramEvent).setIsAuto(paramBoolean).build()); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\log\trackUtils\EventTrackSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */