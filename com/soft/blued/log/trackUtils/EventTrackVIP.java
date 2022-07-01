package com.soft.blued.log.trackUtils;

import com.blued.das.vip.VipProtos;
import com.google.protobuf.Message;

public class EventTrackVIP {
  public static VipProtos.PageLevel a(int paramInt) {
    VipProtos.PageLevel pageLevel = VipProtos.PageLevel.UNKNOWN_PAGE_LEVEL;
    return (paramInt != 1) ? ((paramInt != 2) ? pageLevel : VipProtos.PageLevel.SVIP_PAGE) : VipProtos.PageLevel.VIP_PAGE;
  }
  
  private static String a(String paramString) {
    return EventTrackUtils.a(paramString);
  }
  
  public static void a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3) {
    VipProtos.VipProto.Builder builder = VipProtos.VipProto.newBuilder().setEvent(VipProtos.Event.VIP_CENTER_PRIVILEGE_CLICK).setIdentityType(b(paramInt1)).setPageLevel(a(paramInt2)).setIsOpen(paramBoolean);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt3);
    stringBuilder.append("");
    EventTrackUtils.a((Message)builder.setPrivilegeId(stringBuilder.toString()).build());
  }
  
  public static void a(VipProtos.Event paramEvent) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)VipProtos.VipProto.newBuilder().setEvent(paramEvent).build()); 
  }
  
  public static void a(VipProtos.Event paramEvent, int paramInt) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)VipProtos.VipProto.newBuilder().setEvent(paramEvent).setPageLevel(a(paramInt)).build()); 
  }
  
  public static void a(VipProtos.Event paramEvent, int paramInt1, int paramInt2) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)VipProtos.VipProto.newBuilder().setEvent(paramEvent).setIdentityType(b(paramInt1)).setPageLevel(a(paramInt2)).build()); 
  }
  
  public static void a(VipProtos.Event paramEvent, int paramInt1, int paramInt2, VipProtos.BtnType paramBtnType) {
    if (paramEvent != null && paramBtnType != null)
      EventTrackUtils.a((Message)VipProtos.VipProto.newBuilder().setEvent(paramEvent).setIdentityType(b(paramInt1)).setPageLevel(a(paramInt2)).setBtnType(paramBtnType).build()); 
  }
  
  public static void a(VipProtos.Event paramEvent, int paramInt1, int paramInt2, String paramString) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)VipProtos.VipProto.newBuilder().setEvent(paramEvent).setIdentityType(b(paramInt1)).setPageLevel(a(paramInt2)).setBannerUrl(a(paramString)).build()); 
  }
  
  public static void a(VipProtos.Event paramEvent, int paramInt, boolean paramBoolean) {
    if (paramEvent != null) {
      VipProtos.IdentityType identityType;
      if (paramInt == 1) {
        if (paramBoolean) {
          identityType = VipProtos.IdentityType.SVIP_TYPE;
        } else {
          identityType = VipProtos.IdentityType.SVIP_EXPIRED;
        } 
      } else if (paramBoolean) {
        identityType = VipProtos.IdentityType.VIP_TYPE;
      } else {
        identityType = VipProtos.IdentityType.VIP_EXPIRED;
      } 
      EventTrackUtils.a((Message)VipProtos.VipProto.newBuilder().setEvent(paramEvent).setIdentityType(identityType).build());
    } 
  }
  
  public static void a(VipProtos.Event paramEvent, VipProtos.AdPage paramAdPage, String paramString) {
    if (paramEvent != null) {
      VipProtos.VipProto.Builder builder2 = VipProtos.VipProto.newBuilder().setEvent(paramEvent);
      VipProtos.AdPage adPage = paramAdPage;
      if (paramAdPage == null)
        adPage = VipProtos.AdPage.UNKNOWN_AD_PAGE; 
      VipProtos.VipProto.Builder builder1 = builder2.setAdPage(adPage);
      String str = paramString;
      if (paramString == null)
        str = ""; 
      EventTrackUtils.a((Message)builder1.setAdType(str).build());
    } 
  }
  
  public static void a(VipProtos.Event paramEvent, VipProtos.HideType paramHideType) {
    if (paramEvent != null && paramHideType != null)
      EventTrackUtils.a((Message)VipProtos.VipProto.newBuilder().setEvent(paramEvent).setHideType(paramHideType).build()); 
  }
  
  public static void a(VipProtos.Event paramEvent, VipProtos.IdentityType paramIdentityType) {
    if (paramEvent != null && paramIdentityType != null)
      EventTrackUtils.a((Message)VipProtos.VipProto.newBuilder().setEvent(paramEvent).setIdentityType(paramIdentityType).build()); 
  }
  
  public static void a(VipProtos.Event paramEvent, VipProtos.IdentityType paramIdentityType, boolean paramBoolean) {
    if (paramEvent != null && paramIdentityType != null)
      EventTrackUtils.a((Message)VipProtos.VipProto.newBuilder().setEvent(paramEvent).setIdentityType(paramIdentityType).setIsOpen(paramBoolean).build()); 
  }
  
  public static void a(VipProtos.Event paramEvent, VipProtos.Name paramName, VipProtos.FromType paramFromType, VipProtos.PageVersion paramPageVersion) {
    if (paramEvent != null && paramName != null && paramFromType != null && paramPageVersion != null)
      EventTrackUtils.a((Message)VipProtos.VipProto.newBuilder().setEvent(paramEvent).setName(paramName).setFrom(paramFromType).setPageVersion(paramPageVersion).build()); 
  }
  
  public static void a(VipProtos.Event paramEvent, VipProtos.Name paramName, VipProtos.PageVersion paramPageVersion) {
    if (paramEvent != null && paramName != null && paramPageVersion != null)
      EventTrackUtils.a((Message)VipProtos.VipProto.newBuilder().setEvent(paramEvent).setName(paramName).setPageVersion(paramPageVersion).build()); 
  }
  
  public static void a(VipProtos.Event paramEvent, VipProtos.OrderType paramOrderType, String paramString) {
    if (paramEvent != null && paramOrderType != null)
      EventTrackUtils.a((Message)VipProtos.VipProto.newBuilder().setEvent(paramEvent).setOrderType(paramOrderType).setThirdId(paramString).build()); 
  }
  
  public static void a(VipProtos.Event paramEvent, VipProtos.StealthType paramStealthType, boolean paramBoolean) {
    if (paramEvent != null && paramStealthType != null)
      EventTrackUtils.a((Message)VipProtos.VipProto.newBuilder().setEvent(paramEvent).setStealthType(paramStealthType).setIsRange(paramBoolean).build()); 
  }
  
  public static void a(VipProtos.Event paramEvent, VipProtos.VocativeType paramVocativeType) {
    if (paramEvent != null && paramVocativeType != null)
      EventTrackUtils.a((Message)VipProtos.VipProto.newBuilder().setEvent(paramEvent).setVocativeType(paramVocativeType).build()); 
  }
  
  public static void a(VipProtos.Event paramEvent, String paramString) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)VipProtos.VipProto.newBuilder().setEvent(paramEvent).setId(a(paramString)).build()); 
  }
  
  public static void a(VipProtos.Event paramEvent, String paramString1, String paramString2) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)VipProtos.VipProto.newBuilder().setEvent(paramEvent).setLatitude(paramString1).setLongitude(paramString2).build()); 
  }
  
  public static void a(VipProtos.Event paramEvent, boolean paramBoolean) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)VipProtos.VipProto.newBuilder().setEvent(paramEvent).setIsShadow(paramBoolean).build()); 
  }
  
  public static void a(VipProtos.Event paramEvent, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)VipProtos.VipProto.newBuilder().setEvent(paramEvent).setIsHideAll(paramBoolean1).setIsHideAge(paramBoolean4).setIsHideDistance(paramBoolean2).setIsHideRole(paramBoolean3).build()); 
  }
  
  public static VipProtos.IdentityType b(int paramInt) {
    VipProtos.IdentityType identityType = VipProtos.IdentityType.NONE;
    return (paramInt != 1) ? ((paramInt != 2) ? identityType : VipProtos.IdentityType.SVIP_TYPE) : VipProtos.IdentityType.VIP_TYPE;
  }
  
  public static void b(VipProtos.Event paramEvent, String paramString) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)VipProtos.VipProto.newBuilder().setEvent(paramEvent).setImageId(a(paramString)).build()); 
  }
  
  public static void b(VipProtos.Event paramEvent, boolean paramBoolean) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)VipProtos.VipProto.newBuilder().setEvent(paramEvent).setIsOpen(paramBoolean).build()); 
  }
  
  public static VipProtos.OrderType c(int paramInt) {
    return (paramInt != 1) ? ((paramInt != 2) ? ((paramInt != 3) ? ((paramInt != 4) ? VipProtos.OrderType.UNKNOWN_ORDER_TYPE : VipProtos.OrderType.ORDER_CALL) : VipProtos.OrderType.ORDER_EXPOSURE) : VipProtos.OrderType.ORDER_SVIP) : VipProtos.OrderType.ORDER_VIP;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\log\trackUtils\EventTrackVIP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */