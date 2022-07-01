package com.soft.blued.log.trackUtils;

import android.text.TextUtils;
import com.blued.das.guy.GuyProtos;
import com.google.protobuf.Message;
import com.soft.blued.utils.Logger;

public class EventTrackGuy {
  public static void a(GuyProtos.Event paramEvent) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)GuyProtos.GuyProto.newBuilder().setEvent(paramEvent).build()); 
  }
  
  public static void a(GuyProtos.Event paramEvent, int paramInt) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)GuyProtos.GuyProto.newBuilder().setEvent(paramEvent).setRow(paramInt).build()); 
  }
  
  public static void a(GuyProtos.Event paramEvent, int paramInt1, int paramInt2) {
    byte b = 21;
    if (6 == paramInt1 && paramInt2 == 1) {
      paramInt1 = 12;
    } else if (6 == paramInt1 && paramInt2 == 6) {
      paramInt1 = 13;
    } else if (6 == paramInt1 && paramInt2 == 14) {
      paramInt1 = 14;
    } else if (6 == paramInt1 && paramInt2 == 21) {
      paramInt1 = 15;
    } else if (paramInt1 == 0 && paramInt2 == 1) {
      paramInt1 = 16;
    } else if (paramInt1 == 0 && paramInt2 == 6) {
      paramInt1 = 17;
    } else if (paramInt1 == 0 && paramInt2 == 14) {
      paramInt1 = 18;
    } else if (paramInt1 == 0 && paramInt2 == 21) {
      paramInt1 = 19;
    } else if (4 == paramInt1 && paramInt2 == 1) {
      paramInt1 = 20;
    } else if (4 == paramInt1 && paramInt2 == 6) {
      paramInt1 = b;
    } else if (4 == paramInt1 && paramInt2 == 14) {
      paramInt1 = 22;
    } else if (4 == paramInt1 && paramInt2 == 21) {
      paramInt1 = 23;
    } else {
      paramInt1 = 0;
    } 
    a(paramEvent, paramInt1);
  }
  
  public static void a(GuyProtos.Event paramEvent, GuyProtos.BtnType paramBtnType) {
    if (paramEvent != null && paramBtnType != null)
      EventTrackUtils.a((Message)GuyProtos.GuyProto.newBuilder().setEvent(paramEvent).setBtnType(paramBtnType).build()); 
  }
  
  public static void a(GuyProtos.Event paramEvent, GuyProtos.ShowType paramShowType) {
    if (paramEvent != null && paramShowType != null)
      EventTrackUtils.a((Message)GuyProtos.GuyProto.newBuilder().setEvent(paramEvent).setShowType(paramShowType).build()); 
  }
  
  public static void a(GuyProtos.Event paramEvent, GuyProtos.SortType paramSortType, boolean paramBoolean) {
    if (paramEvent != null && paramSortType != null)
      EventTrackUtils.a((Message)GuyProtos.GuyProto.newBuilder().setEvent(paramEvent).setSortType(paramSortType).setIsMapFind(paramBoolean).build()); 
  }
  
  public static void a(GuyProtos.Event paramEvent, GuyProtos.VocativeSourcePage paramVocativeSourcePage) {
    if (paramEvent != null && paramVocativeSourcePage != null)
      EventTrackUtils.a((Message)GuyProtos.GuyProto.newBuilder().setEvent(paramEvent).setVocativeSourcePage(paramVocativeSourcePage).build()); 
  }
  
  public static void a(GuyProtos.Event paramEvent, GuyProtos.VocativeSourcePage paramVocativeSourcePage, String paramString) {
    if (paramEvent != null && paramVocativeSourcePage != null)
      EventTrackUtils.a((Message)GuyProtos.GuyProto.newBuilder().setEvent(paramEvent).setVocativeSourcePage(paramVocativeSourcePage).setSkuId(d(paramString)).build()); 
  }
  
  public static void a(GuyProtos.Event paramEvent, GuyProtos.VocativeStatus paramVocativeStatus) {
    if (paramEvent != null && paramVocativeStatus != null)
      EventTrackUtils.a((Message)GuyProtos.GuyProto.newBuilder().setEvent(paramEvent).setVocativeStatus(paramVocativeStatus).build()); 
  }
  
  public static void a(GuyProtos.Event paramEvent, GuyProtos.VocativeType paramVocativeType) {
    if (paramEvent != null && paramVocativeType != null)
      EventTrackUtils.a((Message)GuyProtos.GuyProto.newBuilder().setEvent(paramEvent).setVocativeType(paramVocativeType).build()); 
  }
  
  public static void a(GuyProtos.Event paramEvent, String paramString) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)GuyProtos.GuyProto.newBuilder().setEvent(paramEvent).setTargetUid(d(paramString)).build()); 
  }
  
  public static void a(GuyProtos.Event paramEvent, String paramString, int paramInt) {
    boolean bool = "nearby".equals(paramString);
    byte b = 6;
    if (bool && paramInt == 0) {
      paramInt = 1;
    } else if ("online".equals(paramString) && paramInt == 0) {
      paramInt = 2;
    } else if ("nearby".equals(paramString) && paramInt == 6) {
      paramInt = 3;
    } else if ("online".equals(paramString) && paramInt == 6) {
      paramInt = 4;
    } else if ("nearby".equals(paramString) && paramInt == 14) {
      paramInt = 5;
    } else if ("online".equals(paramString) && paramInt == 14) {
      paramInt = b;
    } else if ("nearby".equals(paramString) && paramInt == 21) {
      paramInt = 7;
    } else if ("online".equals(paramString) && paramInt == 21) {
      paramInt = 8;
    } else if ("nearby".equals(paramString) && paramInt == 29) {
      paramInt = 9;
    } else if ("online".equals(paramString) && paramInt == 29) {
      paramInt = 10;
    } else {
      paramInt = 0;
    } 
    a(paramEvent, paramInt);
  }
  
  public static void a(GuyProtos.Event paramEvent, String paramString, GuyProtos.SortType paramSortType, GuyProtos.ShowType paramShowType, boolean paramBoolean) {
    if (paramEvent != null && paramSortType != null && paramShowType != null) {
      Logger.a("user_find", paramString);
      EventTrackUtils.a((Message)GuyProtos.GuyProto.newBuilder().setEvent(paramEvent).setTargetUid(d(paramString)).setSortType(paramSortType).setShowType(paramShowType).setIsMapFind(paramBoolean).build());
    } 
  }
  
  public static void a(GuyProtos.Event paramEvent, String paramString1, GuyProtos.SortType paramSortType, GuyProtos.ShowType paramShowType, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString2, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, int paramInt, String paramString3) {
    if (paramEvent != null && paramSortType != null && paramShowType != null) {
      Logger.a("user_find", paramString1);
      EventTrackUtils.a((Message)GuyProtos.GuyProto.newBuilder().setEvent(paramEvent).setTargetUid(d(paramString1)).setSortType(paramSortType).setShowType(paramShowType).setIsMapFind(paramBoolean1).setIsShadow(paramBoolean2).setIsAppreciateCall(paramBoolean3).setIsLive(paramBoolean4).setLiveType(d(paramString2)).setIsQuietCall(paramBoolean5).setIsAuto(paramBoolean6).setNum(paramInt).setRecommendType(d(paramString3)).setIsAi(paramBoolean7).build());
    } 
  }
  
  public static void a(GuyProtos.Event paramEvent, String paramString1, String paramString2, String paramString3) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)GuyProtos.GuyProto.newBuilder().setEvent(paramEvent).setTargetUid(d(paramString1)).setRoomId(d(paramString2)).setRoomUid(d(paramString3)).build()); 
  }
  
  public static void a(GuyProtos.Event paramEvent, String paramString1, String paramString2, String paramString3, int paramInt) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)GuyProtos.GuyProto.newBuilder().setEvent(paramEvent).setLiveId(d(paramString1)).setTargetUid(d(paramString2)).setRecommendType(d(paramString3)).setNum(paramInt).build()); 
  }
  
  public static void a(GuyProtos.Event paramEvent, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)GuyProtos.GuyProto.newBuilder().setEvent(paramEvent).setLiveId(d(paramString1)).setTargetUid(d(paramString2)).setLiveClassStr(d(paramString3)).setRecommendType(d(paramString4)).setNum(paramInt).build()); 
  }
  
  public static void a(GuyProtos.Event paramEvent, boolean paramBoolean) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)GuyProtos.GuyProto.newBuilder().setEvent(paramEvent).setIsVip(paramBoolean).build()); 
  }
  
  public static void a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    EventTrackUtils.a((Message)GuyProtos.GuyProto.newBuilder().setEvent(GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_PRICE_WINDOW_SHOW).setVocativeSourcePage(b(paramString)).build());
  }
  
  public static GuyProtos.VocativeSourcePage b(String paramString) {
    GuyProtos.VocativeSourcePage vocativeSourcePage = GuyProtos.VocativeSourcePage.UNKNOWN_VOCATIVE_SOURCE_PAGE;
    if (TextUtils.isEmpty(paramString))
      return vocativeSourcePage; 
    byte b = -1;
    int i = paramString.hashCode();
    if (i != -235377960) {
      if (i != 119794870) {
        if (i == 1536204444 && paramString.equals("vocative_end_report"))
          b = 1; 
      } else if (paramString.equals("mine_vocative_order")) {
        b = 0;
      } 
    } else if (paramString.equals("mine_vocative_order_is_remain")) {
      b = 2;
    } 
    return (b != 0) ? ((b != 1) ? ((b != 2) ? vocativeSourcePage : GuyProtos.VocativeSourcePage.ORDER_BUY_MORE) : GuyProtos.VocativeSourcePage.REPORT_KEEP_ON) : GuyProtos.VocativeSourcePage.ORDER_BUY;
  }
  
  public static void b(GuyProtos.Event paramEvent) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)GuyProtos.GuyProto.newBuilder().setEvent(paramEvent).build()); 
  }
  
  public static void b(GuyProtos.Event paramEvent, String paramString) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)GuyProtos.GuyProto.newBuilder().setEvent(paramEvent).setConfigJson(d(paramString)).build()); 
  }
  
  public static void b(GuyProtos.Event paramEvent, boolean paramBoolean) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)GuyProtos.GuyProto.newBuilder().setEvent(paramEvent).setIsAuto(paramBoolean).build()); 
  }
  
  public static GuyProtos.SortType c(String paramString) {
    byte b;
    switch (paramString.hashCode()) {
      default:
        b = -1;
        break;
      case 492822833:
        if (paramString.equals("integrate")) {
          b = 0;
          break;
        } 
      case -1012222381:
        if (paramString.equals("online")) {
          b = 1;
          break;
        } 
      case -1048842402:
        if (paramString.equals("newbie")) {
          b = 3;
          break;
        } 
      case -1049482625:
        if (paramString.equals("nearby")) {
          b = 2;
          break;
        } 
      case -1572566948:
        if (paramString.equals("msg_hello_detail")) {
          b = 4;
          break;
        } 
    } 
    return (b != 0) ? ((b != 1) ? ((b != 2) ? ((b != 3) ? ((b != 4) ? null : GuyProtos.SortType.CALL_SECOND_PAGE) : GuyProtos.SortType.NEW_FACE) : GuyProtos.SortType.DISTANCE_SORT) : GuyProtos.SortType.ONLINE_TIME_SORT) : GuyProtos.SortType.COMPLEX_SORT;
  }
  
  public static void c(GuyProtos.Event paramEvent, String paramString) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)GuyProtos.GuyProto.newBuilder().setEvent(paramEvent).setRole(d(paramString)).build()); 
  }
  
  public static void c(GuyProtos.Event paramEvent, boolean paramBoolean) {
    if (paramEvent != null)
      EventTrackUtils.a((Message)GuyProtos.GuyProto.newBuilder().setEvent(paramEvent).setIsShadow(paramBoolean).build()); 
  }
  
  private static String d(String paramString) {
    return EventTrackUtils.a(paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\log\trackUtils\EventTrackGuy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */