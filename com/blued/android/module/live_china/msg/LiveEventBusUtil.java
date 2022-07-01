package com.blued.android.module.live_china.msg;

import com.blued.android.chat.data.EntranceData;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.utils.MsgPackHelper;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.live_china.model.FirstChargeGift;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.jeremyliao.liveeventbus.LiveEventBus;

public class LiveEventBusUtil {
  public static String a = "live_beans_update";
  
  public static String b = "live_new_msg";
  
  public static String c = "live_entrance_data";
  
  public static String d = "pay_result";
  
  public static String e = "first_charge";
  
  public static String f = "first_charge_detail";
  
  public static String g = "start_first_charge_success_anim";
  
  public static void a() {
    LiveEventBus.get(a).post(null);
  }
  
  public static void a(int paramInt) {
    LiveEventBus.get(e).post(Integer.valueOf(paramInt));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("notifyFirstCharge: ");
    stringBuilder.append(paramInt);
    LogUtils.c(stringBuilder.toString());
  }
  
  public static void a(EntranceData paramEntranceData) {
    if (paramEntranceData != null)
      LiveEventBus.get(c).post(paramEntranceData); 
  }
  
  public static void a(ChattingModel paramChattingModel) {
    a(paramChattingModel, true);
  }
  
  public static void a(ChattingModel paramChattingModel, boolean paramBoolean) {
    if (paramChattingModel != null) {
      b(paramChattingModel, paramBoolean);
      LiveEventBus.get(b).post(paramChattingModel);
    } 
  }
  
  public static void a(FirstChargeGift paramFirstChargeGift) {
    if (paramFirstChargeGift != null)
      LiveEventBus.get(f).post(paramFirstChargeGift); 
  }
  
  public static void a(boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("notifyPayResult: ");
    stringBuilder.append(paramBoolean);
    LogUtils.c(stringBuilder.toString());
    if (paramBoolean)
      LiveRoomPreferences.k(1); 
    LiveEventBus.get(d).post(Boolean.valueOf(paramBoolean));
  }
  
  private static void b(ChattingModel paramChattingModel, boolean paramBoolean) {
    if (paramChattingModel == null && paramChattingModel.msgMapExtra == null)
      return; 
    if (paramChattingModel.msgType == 33 && !paramBoolean) {
      LiveGiftModel liveGiftModel = new LiveGiftModel();
      liveGiftModel.images_static = MsgPackHelper.getStringValue(paramChattingModel.msgMapExtra, "gift_pic_url");
      liveGiftModel.images_gif = MsgPackHelper.getStringValue(paramChattingModel.msgMapExtra, "gift_pic_gif");
      liveGiftModel.images_apng2 = MsgPackHelper.getStringValue(paramChattingModel.msgMapExtra, "gift_pic_apng2");
      liveGiftModel.images_mp4 = MsgPackHelper.getStringValue(paramChattingModel.msgMapExtra, "gift_pic_mp4");
      liveGiftModel.type_name = MsgPackHelper.getStringValue(paramChattingModel.msgMapExtra, "type_name");
      liveGiftModel.resource_url = MsgPackHelper.getStringValue(paramChattingModel.msgMapExtra, "resource_url");
      liveGiftModel.name = MsgPackHelper.getStringValue(paramChattingModel.msgMapExtra, "gift_name");
      liveGiftModel.animation = MsgPackHelper.getIntValue(paramChattingModel.msgMapExtra, "animation");
      liveGiftModel.giftType = MsgPackHelper.getIntValue(paramChattingModel.msgMapExtra, "gift_type");
      liveGiftModel.giftId = MsgPackHelper.getIntValue(paramChattingModel.msgMapExtra, "gift_id");
      liveGiftModel.hit_count = MsgPackHelper.getIntValue(paramChattingModel.msgMapExtra, "hit_count");
      liveGiftModel.hit_id = MsgPackHelper.getLongValue(paramChattingModel.msgMapExtra, "hit_id");
      liveGiftModel.hit_batch = MsgPackHelper.getIntValue(paramChattingModel.msgMapExtra, "hit_batch");
      liveGiftModel.beans_count = MsgPackHelper.getDoubleValue(paramChattingModel.msgMapExtra, "beans_count");
      liveGiftModel.beans_current_count = MsgPackHelper.getIntValue(paramChattingModel.msgMapExtra, "beans_current_count");
      liveGiftModel.anim_code = MsgPackHelper.getStringValue(paramChattingModel.msgMapExtra, "anim_code");
      liveGiftModel.fanClubName = MsgPackHelper.getStringValue(paramChattingModel.msgMapExtra, "fan_club_name");
      liveGiftModel.fanStatus = MsgPackHelper.getIntValue(paramChattingModel.msgMapExtra, "fans_status");
      liveGiftModel.inFanClub = MsgPackHelper.getIntValue(paramChattingModel.msgMapExtra, "in_fan_club");
      liveGiftModel.fanClubLevel = MsgPackHelper.getIntValue(paramChattingModel.msgMapExtra, "fan_club_level");
      liveGiftModel.liang_id = MsgPackHelper.getStringValue(paramChattingModel.msgMapExtra, "liang_id");
      liveGiftModel.liang_type = MsgPackHelper.getIntValue(paramChattingModel.msgMapExtra, "liang_type");
      paramChattingModel.msgMapExtra.clear();
      paramChattingModel.msgMapExtra.put("gift_model", liveGiftModel);
    } 
  }
  
  public static void b(boolean paramBoolean) {
    LiveEventBus.get(g).post(Boolean.valueOf(paramBoolean));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\msg\LiveEventBusUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */