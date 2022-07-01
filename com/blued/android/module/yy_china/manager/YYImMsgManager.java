package com.blued.android.module.yy_china.manager;

import android.text.TextUtils;
import com.blued.android.chat.utils.MsgPackHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.im.biz.AudioChatroom;
import com.blued.android.module.yy_china.model.BlindMatchUserModel;
import com.blued.android.module.yy_china.model.BlindPublishModel;
import com.blued.android.module.yy_china.model.YYAudienceModel;
import com.blued.android.module.yy_china.model.YYCPStepModel;
import com.blued.android.module.yy_china.model.YYGiftModel;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYMsgAudienceCountExtra;
import com.blued.android.module.yy_china.model.YYMsgBlindPublishExtra;
import com.blued.android.module.yy_china.model.YYMsgBlindResultExtra;
import com.blued.android.module.yy_china.model.YYMsgEmojiExtra;
import com.blued.android.module.yy_china.model.YYMsgGiftExtra;
import com.blued.android.module.yy_china.model.YYMsgKickInfoExtra;
import com.blued.android.module.yy_china.model.YYMsgMicStatusExtra;
import com.blued.android.module.yy_china.model.YYMsgMuteStatusExtra;
import com.blued.android.module.yy_china.model.YYMsgOfficeExtra;
import com.blued.android.module.yy_china.model.YYMsgRoomNameExtra;
import com.blued.android.module.yy_china.model.YYMsgSeatExtra;
import com.blued.android.module.yy_china.model.YYMsgUpSeatExtra;
import com.blued.android.module.yy_china.model.YYMsgVoteStartExtra;
import com.blued.android.module.yy_china.model.YYMsgWaittingExtra;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.im.audio_chatroom.AudioMsgType;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class YYImMsgManager {
  private YYImMsgManager() {}
  
  private void E(YYImModel paramYYImModel) {
    YYCPStepModel yYCPStepModel = (YYCPStepModel)AppInfo.f().fromJson(paramYYImModel.getMsgExtra(), YYCPStepModel.class);
    if (yYCPStepModel == null)
      return; 
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel != null) {
      yYRoomModel.setCPNextStep(yYCPStepModel.next_step);
      yYRoomModel.setCPPresentStep(yYCPStepModel.present_step);
    } 
    if (yYCPStepModel.present_step == 0 && yYRoomModel != null && yYRoomModel.mics != null) {
      Iterator iterator = yYRoomModel.mics.iterator();
      while (iterator.hasNext())
        ((YYSeatMemberModel)iterator.next()).likeNum = ""; 
    } 
    yYCPStepModel.resend = paramYYImModel.resend;
    LiveEventBus.get("update_cp_step").post(yYCPStepModel);
  }
  
  public static YYImMsgManager a() {
    return IMMsgManager.a();
  }
  
  private void a(int paramInt) {
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel != null)
      yYRoomModel.setAudienceCount(paramInt); 
    YYObserverManager.a().a(paramInt);
  }
  
  private YYAudienceModel f() {
    YYAudienceModel yYAudienceModel = new YYAudienceModel();
    yYAudienceModel.setUid((YYRoomInfoManager.d().b()).uid);
    yYAudienceModel.setName((YYRoomInfoManager.d().b()).name);
    yYAudienceModel.setAvatar((YYRoomInfoManager.d().b()).avatar);
    return yYAudienceModel;
  }
  
  public void A(YYImModel paramYYImModel) {
    E(paramYYImModel);
  }
  
  public void B(YYImModel paramYYImModel) {
    YYMsgBlindPublishExtra yYMsgBlindPublishExtra = (YYMsgBlindPublishExtra)AppInfo.f().fromJson(paramYYImModel.getMsgExtra(), YYMsgBlindPublishExtra.class);
    if (yYMsgBlindPublishExtra == null)
      return; 
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel != null) {
      yYRoomModel.setCPNextStep(yYMsgBlindPublishExtra.next_step);
      yYRoomModel.setCPPresentStep(yYMsgBlindPublishExtra.present_step);
    } 
    if (yYRoomModel != null && yYRoomModel.mics != null)
      for (BlindPublishModel blindPublishModel : yYMsgBlindPublishExtra.seats) {
        if (blindPublishModel == null)
          continue; 
        YYSeatMemberModel yYSeatMemberModel = yYRoomModel.getSeatMember(blindPublishModel.uid);
        if (yYSeatMemberModel != null) {
          int i = blindPublishModel.choose_seat_num;
          String str = "";
          if (i > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(blindPublishModel.choose_seat_num);
            stringBuilder.append("");
            str = stringBuilder.toString();
          } 
          yYSeatMemberModel.likeNum = str;
        } 
      }  
    yYMsgBlindPublishExtra.resend = paramYYImModel.resend;
    LiveEventBus.get("show_blind_publish").post(yYMsgBlindPublishExtra);
  }
  
  public void C(YYImModel paramYYImModel) {
    YYMsgBlindResultExtra yYMsgBlindResultExtra = (YYMsgBlindResultExtra)AppInfo.f().fromJson(paramYYImModel.getMsgExtra(), YYMsgBlindResultExtra.class);
    if (yYMsgBlindResultExtra == null)
      return; 
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel != null) {
      yYRoomModel.setCPNextStep(yYMsgBlindResultExtra.next_step);
      yYRoomModel.setCPPresentStep(yYMsgBlindResultExtra.present_step);
      if (yYMsgBlindResultExtra.seats != null && !yYMsgBlindResultExtra.seats.isEmpty())
        for (BlindPublishModel blindPublishModel : yYMsgBlindResultExtra.seats) {
          if (blindPublishModel == null)
            continue; 
          YYSeatMemberModel yYSeatMemberModel = yYRoomModel.getSeatMember(blindPublishModel.uid);
          if (yYSeatMemberModel != null) {
            int i = blindPublishModel.choose_seat_num;
            String str = "";
            if (i > 0) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(blindPublishModel.choose_seat_num);
              stringBuilder.append("");
              str = stringBuilder.toString();
            } 
            yYSeatMemberModel.likeNum = str;
          } 
        }  
    } 
    yYMsgBlindResultExtra.resend = paramYYImModel.resend;
    LiveEventBus.get("show_blind_result").post(yYMsgBlindResultExtra);
    if (yYMsgBlindResultExtra.match_users != null && !yYMsgBlindResultExtra.match_users.isEmpty())
      a(paramYYImModel); 
  }
  
  public void D(YYImModel paramYYImModel) {
    BlindMatchUserModel blindMatchUserModel = (BlindMatchUserModel)AppInfo.f().fromJson(paramYYImModel.getMsgExtra(), BlindMatchUserModel.class);
    if (blindMatchUserModel == null)
      return; 
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel != null) {
      YYSeatMemberModel yYSeatMemberModel = yYRoomModel.getSeatMember(blindMatchUserModel.uid);
      if (yYSeatMemberModel != null) {
        int i = blindMatchUserModel.seat_num;
        String str = "";
        if (i > 0) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(blindMatchUserModel.seat_num);
          stringBuilder.append("");
          str = stringBuilder.toString();
        } 
        yYSeatMemberModel.likeNum = str;
      } 
    } 
    LiveEventBus.get("show_blind_heart").post(blindMatchUserModel);
  }
  
  public YYAudienceModel a(String paramString1, String paramString2, String paramString3) {
    YYAudienceModel yYAudienceModel = new YYAudienceModel();
    yYAudienceModel.setUid(paramString1);
    yYAudienceModel.setName(paramString2);
    yYAudienceModel.setAvatar(paramString3);
    return yYAudienceModel;
  }
  
  public void a(YYGiftModel paramYYGiftModel, YYSeatMemberModel paramYYSeatMemberModel) {
    YYImModel yYImModel = new YYImModel();
    yYImModel.type = AudioMsgType.MsgType.SEND_GIFT.getNumber();
    yYImModel.source_profile = c();
    YYAudienceModel yYAudienceModel = new YYAudienceModel();
    yYAudienceModel.setUid(paramYYSeatMemberModel.getUid());
    yYAudienceModel.setName(paramYYSeatMemberModel.getName());
    yYAudienceModel.setAvatar(paramYYSeatMemberModel.getAvatar());
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramYYSeatMemberModel.chat_anchor);
    stringBuilder.append("");
    yYAudienceModel.role = stringBuilder.toString();
    yYImModel.target_profile = yYAudienceModel;
    yYImModel.msgMapExtra = new HashMap<Object, Object>();
    MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "gift_icon", paramYYGiftModel.images_static);
    MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "gift_apng", paramYYGiftModel.images_apng);
    MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "gift_mp4", paramYYGiftModel.images_mp4);
    MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "gift_id", paramYYGiftModel.goods_id);
    MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "hit_count", paramYYGiftModel.hit_count);
    MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "hit_id", paramYYGiftModel.hit_id);
    MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "hit_batch", paramYYGiftModel.hit_batch);
    MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "beans_current", "");
    a(yYImModel);
    YYObserverManager.a().a(yYImModel, false);
  }
  
  public void a(YYImModel paramYYImModel) {
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel != null)
      yYRoomModel.addImDatas(paramYYImModel); 
  }
  
  public void a(YYImModel paramYYImModel, String paramString) {
    if (paramYYImModel == null)
      return; 
    YYAudienceModel yYAudienceModel = paramYYImModel.target_profile;
    if (yYAudienceModel == null)
      return; 
    YYUserInfo yYUserInfo = (YYRoomInfoManager.d()).a;
    if (yYUserInfo == null)
      return; 
    if (!TextUtils.equals(yYAudienceModel.getUid(), yYUserInfo.getUid()) && !TextUtils.equals("2", yYUserInfo.chat_anchor) && !TextUtils.equals("1", yYUserInfo.chat_anchor))
      return; 
    if (yYUserInfo != null && TextUtils.equals(yYAudienceModel.getUid(), yYUserInfo.getUid())) {
      yYUserInfo.mute = paramString;
      LiveEventBus.get("set_mute_status").post(paramString);
    } 
    a(paramYYImModel);
  }
  
  public void a(YYImModel paramYYImModel, boolean paramBoolean) {
    AppInfo.n().postDelayed(new Runnable(this, paramBoolean) {
          public void run() {
            YYRoomInfoManager.d().k();
            if (this.a)
              LiveEventBus.get("show_vote_result").post(""); 
          }
        }300L);
  }
  
  public void a(String paramString) {
    YYImModel yYImModel = new YYImModel();
    yYImModel.contents = paramString;
    yYImModel.type = -6;
    a(yYImModel);
  }
  
  public void a(String paramString1, String paramString2) {
    YYImModel yYImModel = new YYImModel();
    yYImModel.type = 21;
    YYMsgOfficeExtra yYMsgOfficeExtra = new YYMsgOfficeExtra();
    yYMsgOfficeExtra.title = paramString1;
    yYMsgOfficeExtra.content = paramString2;
    yYImModel.setMsgExtra(AppInfo.f().toJson(yYMsgOfficeExtra));
    a(yYImModel);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4) {
    YYImModel yYImModel = new YYImModel();
    yYImModel.type = AudioMsgType.MsgType.TEXT.getNumber();
    paramString3 = paramString3.replaceAll("\n", "");
    if (paramString3.endsWith(" ")) {
      paramString3 = paramString3.trim();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString3);
      stringBuilder.append(" ");
      paramString3 = stringBuilder.toString();
    } else {
      paramString3 = paramString3.trim();
    } 
    String str = paramString3;
    if (!TextUtils.isEmpty(paramString1)) {
      str = paramString3;
      if (!TextUtils.isEmpty(paramString2)) {
        str = paramString3;
        if (!TextUtils.isEmpty(paramString4))
          if (!paramString3.contains(paramString4)) {
            str = paramString3;
          } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("@(name:");
            stringBuilder2.append(paramString2);
            stringBuilder2.append(",id:");
            stringBuilder2.append(paramString1);
            stringBuilder2.append(") ");
            str = paramString3.replaceFirst(paramString4, stringBuilder2.toString());
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("组装@ msg = ");
            stringBuilder1.append(str);
            Logger.e("IM msg", new Object[] { stringBuilder1.toString() });
          }  
      } 
    } 
    yYImModel.contents = str;
    yYImModel.source_profile = c();
    YYIMManager.a().a(str, new AudioChatroom.OnAudioChatroomResponseListener(this, yYImModel) {
          public void a(int param1Int, Exception param1Exception) {}
          
          public void a(long param1Long) {
            YYImModel yYImModel = this.a;
            yYImModel.msg_time = param1Long;
            this.b.a(yYImModel);
          }
        });
  }
  
  public void b() {
    YYImModel yYImModel = new YYImModel();
    yYImModel.type = -5;
    a(yYImModel);
  }
  
  public void b(YYImModel paramYYImModel) {
    if (paramYYImModel.target_profile != null && TextUtils.equals(paramYYImModel.source_profile.getUid(), YYRoomInfoManager.d().e()))
      return; 
    a(paramYYImModel);
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel != null)
      yYRoomModel.addAudienceToList(paramYYImModel.source_profile); 
    YYMsgAudienceCountExtra yYMsgAudienceCountExtra = (YYMsgAudienceCountExtra)AppInfo.f().fromJson(paramYYImModel.getMsgExtra(), YYMsgAudienceCountExtra.class);
    if (yYMsgAudienceCountExtra == null)
      return; 
    a(yYMsgAudienceCountExtra.auditorCount);
  }
  
  public void b(String paramString1, String paramString2, String paramString3) {
    YYImModel yYImModel = new YYImModel();
    yYImModel.type = -3;
    yYImModel.source_profile = f();
    yYImModel.target_profile = a(paramString1, paramString2, paramString3);
    a(yYImModel);
  }
  
  public YYAudienceModel c() {
    YYAudienceModel yYAudienceModel = new YYAudienceModel();
    yYAudienceModel.setUid(YYRoomInfoManager.d().e());
    yYAudienceModel.setName(YYRoomInfoManager.d().f());
    yYAudienceModel.setAvatar(YYRoomInfoManager.d().g());
    YYUserInfo yYUserInfo = (YYRoomInfoManager.d()).a;
    if (yYUserInfo != null)
      yYAudienceModel.chat_anchor = yYUserInfo.chat_anchor; 
    return yYAudienceModel;
  }
  
  public void c(YYImModel paramYYImModel) {
    YYUserInfo yYUserInfo = (YYRoomInfoManager.d()).a;
    if (yYUserInfo == null)
      return; 
    YYAudienceModel yYAudienceModel = paramYYImModel.target_profile;
    if (yYAudienceModel == null)
      return; 
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null)
      return; 
    yYRoomModel.removeAudienceForList(yYAudienceModel.getUid());
    YYMsgUpSeatExtra yYMsgUpSeatExtra = (YYMsgUpSeatExtra)AppInfo.f().fromJson(paramYYImModel.getMsgExtra(), YYMsgUpSeatExtra.class);
    if (yYMsgUpSeatExtra == null)
      return; 
    ArrayList<YYSeatMemberModel> arrayList = new ArrayList();
    Iterator<YYMsgSeatExtra> iterator = yYMsgUpSeatExtra.seats.iterator();
    String str = "";
    while (iterator.hasNext()) {
      boolean bool;
      YYMsgSeatExtra yYMsgSeatExtra = iterator.next();
      YYSeatMemberModel yYSeatMemberModel = new YYSeatMemberModel();
      yYSeatMemberModel.setUid(yYMsgSeatExtra.uid);
      yYSeatMemberModel.setName(yYMsgSeatExtra.name);
      yYSeatMemberModel.setAvatar(yYMsgSeatExtra.avatar);
      yYSeatMemberModel.chat_anchor = yYMsgSeatExtra.role;
      if (yYMsgSeatExtra.mute == 0) {
        bool = true;
      } else {
        bool = false;
      } 
      yYSeatMemberModel.is_open_mic = bool;
      yYSeatMemberModel.position_status = yYMsgSeatExtra.seat_type;
      yYSeatMemberModel.mic_position = yYMsgSeatExtra.mic_position;
      yYSeatMemberModel.publish_url = yYMsgSeatExtra.push_url;
      if (TextUtils.equals(yYMsgSeatExtra.uid, yYUserInfo.getUid())) {
        yYSeatMemberModel.setName(YYRoomInfoManager.d().f());
        yYSeatMemberModel.setAvatar(YYRoomInfoManager.d().g());
      } 
      if (TextUtils.equals(yYAudienceModel.getUid(), yYMsgSeatExtra.uid))
        str = yYMsgSeatExtra.push_url; 
      if (yYRoomModel.isCPChannel() && TextUtils.equals(yYSeatMemberModel.getUid(), yYRoomModel.uid)) {
        yYSeatMemberModel.itemType = 1;
      } else {
        yYSeatMemberModel.itemType = 0;
      } 
      arrayList.add(yYSeatMemberModel);
    } 
    yYRoomModel.setSeatList(arrayList);
    if (TextUtils.equals(yYAudienceModel.getUid(), yYUserInfo.getUid())) {
      yYUserInfo.push_url = str;
      yYUserInfo.is_mic = "1";
      yYUserInfo.is_open_mic = 1;
      YYObserverManager.a().a("1");
      YYObserverManager.a().c(yYUserInfo.is_open_mic);
    } 
    a(paramYYImModel);
    a(yYMsgUpSeatExtra.auditor_count);
  }
  
  public void c(String paramString1, String paramString2, String paramString3) {
    YYImModel yYImModel = new YYImModel();
    yYImModel.type = -4;
    yYImModel.source_profile = f();
    yYImModel.target_profile = a(paramString1, paramString2, paramString3);
    a(yYImModel);
  }
  
  public void d() {
    YYImModel yYImModel = new YYImModel();
    yYImModel.type = 2;
    yYImModel.source_profile = c();
    a(yYImModel);
  }
  
  public void d(YYImModel paramYYImModel) {
    YYUserInfo yYUserInfo = (YYRoomInfoManager.d()).a;
    if (yYUserInfo == null)
      return; 
    YYAudienceModel yYAudienceModel = paramYYImModel.target_profile;
    if (yYAudienceModel == null)
      return; 
    if (TextUtils.equals(yYAudienceModel.getUid(), yYUserInfo.getUid())) {
      yYUserInfo.is_mic = "0";
      yYUserInfo.is_open_mic = 0;
      yYAudienceModel.setAvatar(YYRoomInfoManager.d().g());
      yYAudienceModel.setName(YYRoomInfoManager.d().f());
      YYObserverManager.a().a("0");
    } 
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null)
      return; 
    yYRoomModel.addAudienceToList(yYAudienceModel);
    YYMsgUpSeatExtra yYMsgUpSeatExtra = (YYMsgUpSeatExtra)AppInfo.f().fromJson(paramYYImModel.getMsgExtra(), YYMsgUpSeatExtra.class);
    if (yYMsgUpSeatExtra == null)
      return; 
    ArrayList<YYSeatMemberModel> arrayList = new ArrayList();
    for (YYMsgSeatExtra yYMsgSeatExtra : yYMsgUpSeatExtra.seats) {
      boolean bool;
      YYSeatMemberModel yYSeatMemberModel = new YYSeatMemberModel();
      yYSeatMemberModel.setUid(yYMsgSeatExtra.uid);
      yYSeatMemberModel.setName(yYMsgSeatExtra.name);
      yYSeatMemberModel.setAvatar(yYMsgSeatExtra.avatar);
      yYSeatMemberModel.chat_anchor = yYMsgSeatExtra.role;
      if (yYMsgSeatExtra.mute == 0) {
        bool = true;
      } else {
        bool = false;
      } 
      yYSeatMemberModel.is_open_mic = bool;
      yYSeatMemberModel.position_status = yYMsgSeatExtra.seat_type;
      yYSeatMemberModel.mic_position = yYMsgSeatExtra.mic_position;
      if (yYRoomModel.isCPChannel() && TextUtils.equals(yYSeatMemberModel.getUid(), yYRoomModel.uid)) {
        yYSeatMemberModel.itemType = 1;
      } else {
        yYSeatMemberModel.itemType = 0;
      } 
      arrayList.add(yYSeatMemberModel);
    } 
    yYRoomModel.setSeatList(arrayList);
    a(yYMsgUpSeatExtra.auditor_count);
    if (yYMsgUpSeatExtra.leave_type != 0) {
      LiveEventBus.get("down_seat_msg").post(yYAudienceModel);
      a(paramYYImModel);
      return;
    } 
    if (yYMsgUpSeatExtra.leave_type == 2)
      LiveEventBus.get("down_seat_msg").post(yYAudienceModel); 
  }
  
  public void e() {}
  
  public void e(YYImModel paramYYImModel) {
    YYUserInfo yYUserInfo = (YYRoomInfoManager.d()).a;
    if (yYUserInfo == null)
      return; 
    YYAudienceModel yYAudienceModel = paramYYImModel.target_profile;
    if (yYAudienceModel == null)
      return; 
    if (TextUtils.equals(yYAudienceModel.getUid(), yYUserInfo.getUid()))
      LiveEventBus.get("invite_seat_msg").post(yYAudienceModel); 
  }
  
  public void f(YYImModel paramYYImModel) {
    a(paramYYImModel);
  }
  
  public void g(YYImModel paramYYImModel) {
    if (paramYYImModel == null)
      return; 
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null)
      return; 
    YYMsgMuteStatusExtra yYMsgMuteStatusExtra = (YYMsgMuteStatusExtra)AppInfo.f().fromJson(paramYYImModel.getMsgExtra(), YYMsgMuteStatusExtra.class);
    if (yYMsgMuteStatusExtra == null)
      return; 
    String str = yYMsgMuteStatusExtra.uid;
    int i = yYMsgMuteStatusExtra.mute;
    boolean bool = true;
    if (i == 0) {
      i = 1;
    } else {
      i = 0;
    } 
    yYRoomModel.updateMicStatus(str, i);
    YYAudienceModel yYAudienceModel1 = paramYYImModel.source_profile;
    YYAudienceModel yYAudienceModel2 = paramYYImModel.target_profile;
    if (!TextUtils.equals(yYAudienceModel1.getUid(), yYAudienceModel2.getUid()) && !TextUtils.equals(yYRoomModel.uid, yYAudienceModel2.getUid()))
      a(paramYYImModel); 
    YYUserInfo yYUserInfo = (YYRoomInfoManager.d()).a;
    if (yYUserInfo == null)
      return; 
    if (TextUtils.equals(yYUserInfo.getUid(), yYMsgMuteStatusExtra.uid)) {
      YYObserverManager yYObserverManager = YYObserverManager.a();
      if (yYMsgMuteStatusExtra.mute == 0) {
        i = bool;
      } else {
        i = 0;
      } 
      yYObserverManager.c(i);
    } 
  }
  
  public void h(YYImModel paramYYImModel) {
    if (paramYYImModel == null)
      return; 
    YYMsgMicStatusExtra yYMsgMicStatusExtra = (YYMsgMicStatusExtra)AppInfo.f().fromJson(paramYYImModel.getMsgExtra(), YYMsgMicStatusExtra.class);
    YYObserverManager.a().a(yYMsgMicStatusExtra.seat_num, yYMsgMicStatusExtra.seat_close);
    a(paramYYImModel);
  }
  
  public void i(YYImModel paramYYImModel) {
    if (paramYYImModel == null)
      return; 
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null)
      return; 
    YYAudienceModel yYAudienceModel = paramYYImModel.source_profile;
    if (yYAudienceModel == null)
      return; 
    yYRoomModel.removeSeatMember(yYAudienceModel.getUid());
    yYRoomModel.removeAudienceForList(yYAudienceModel.getUid());
    YYMsgAudienceCountExtra yYMsgAudienceCountExtra = (YYMsgAudienceCountExtra)AppInfo.f().fromJson(paramYYImModel.getMsgExtra(), YYMsgAudienceCountExtra.class);
    if (yYMsgAudienceCountExtra == null)
      return; 
    a(yYMsgAudienceCountExtra.auditorCount);
  }
  
  public void j(YYImModel paramYYImModel) {
    if (paramYYImModel == null)
      return; 
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null)
      return; 
    YYUserInfo yYUserInfo = (YYRoomInfoManager.d()).a;
    if (yYUserInfo == null)
      return; 
    YYAudienceModel yYAudienceModel = paramYYImModel.target_profile;
    if (yYAudienceModel == null)
      return; 
    if (TextUtils.equals(yYAudienceModel.getUid(), yYUserInfo.getUid())) {
      LiveEventBus.get("close_living_room").post(null);
      AudioChannelManager.e().c();
      return;
    } 
    a(paramYYImModel);
    yYRoomModel.removeSeatMember(yYAudienceModel.getUid());
    yYRoomModel.removeAudienceForList(yYAudienceModel.getUid());
    YYMsgAudienceCountExtra yYMsgAudienceCountExtra = (YYMsgAudienceCountExtra)AppInfo.f().fromJson(paramYYImModel.getMsgExtra(), YYMsgAudienceCountExtra.class);
    if (yYMsgAudienceCountExtra == null)
      return; 
    a(yYMsgAudienceCountExtra.auditorCount);
  }
  
  public void k(YYImModel paramYYImModel) {
    if (paramYYImModel == null)
      return; 
    YYMsgKickInfoExtra yYMsgKickInfoExtra = (YYMsgKickInfoExtra)AppInfo.f().fromJson(paramYYImModel.getMsgExtra(), YYMsgKickInfoExtra.class);
    LiveEventBus.get("close_living_room").post(yYMsgKickInfoExtra);
    AudioChannelManager.e().c();
  }
  
  public void l(YYImModel paramYYImModel) {
    if (paramYYImModel == null)
      return; 
    YYMsgWaittingExtra yYMsgWaittingExtra = (YYMsgWaittingExtra)AppInfo.f().fromJson(paramYYImModel.getMsgExtra(), YYMsgWaittingExtra.class);
    if (yYMsgWaittingExtra == null)
      return; 
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel != null)
      yYRoomModel.setWaittingCount(yYMsgWaittingExtra.apply_count); 
    YYObserverManager.a().b(yYMsgWaittingExtra.apply_count);
    if (yYMsgWaittingExtra.apply_status == 0)
      a(paramYYImModel); 
  }
  
  public void m(YYImModel paramYYImModel) {
    if (paramYYImModel == null)
      return; 
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null)
      return; 
    YYMsgRoomNameExtra yYMsgRoomNameExtra = (YYMsgRoomNameExtra)AppInfo.f().fromJson(paramYYImModel.getMsgExtra(), YYMsgRoomNameExtra.class);
    yYRoomModel.room_name = yYMsgRoomNameExtra.room_name;
    LiveEventBus.get("notify_room_rename").post(yYMsgRoomNameExtra.room_name);
  }
  
  public void n(YYImModel paramYYImModel) {
    if (paramYYImModel == null)
      return; 
    LiveEventBus.get("notify_alert_message").post(paramYYImModel);
  }
  
  public void o(YYImModel paramYYImModel) {
    if (paramYYImModel == null)
      return; 
    YYAudienceModel yYAudienceModel = paramYYImModel.target_profile;
    if (yYAudienceModel == null)
      return; 
    LiveEventBus.get("set_manager_msg").post(yYAudienceModel);
    a(paramYYImModel);
  }
  
  public void p(YYImModel paramYYImModel) {
    if (paramYYImModel == null)
      return; 
    YYAudienceModel yYAudienceModel = paramYYImModel.target_profile;
    if (yYAudienceModel == null)
      return; 
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel != null) {
      if (!TextUtils.equals(yYRoomModel.uid, yYAudienceModel.getUid()))
        return; 
      a(paramYYImModel);
    } 
  }
  
  public void q(YYImModel paramYYImModel) {
    if (paramYYImModel == null)
      return; 
    YYAudienceModel yYAudienceModel = paramYYImModel.target_profile;
    if (yYAudienceModel == null)
      return; 
    if (TextUtils.equals(yYAudienceModel.getUid(), YYRoomInfoManager.d().e()))
      LiveEventBus.get("late_accept_msg").post(""); 
  }
  
  public void r(YYImModel paramYYImModel) {
    if (paramYYImModel == null)
      return; 
    YYAudienceModel yYAudienceModel = paramYYImModel.target_profile;
    if (yYAudienceModel == null)
      return; 
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null)
      return; 
    if (TextUtils.equals(yYAudienceModel.getUid(), yYRoomModel.uid)) {
      YYAudienceModel yYAudienceModel1 = paramYYImModel.source_profile;
      if (yYAudienceModel1 == null)
        return; 
      LiveEventBus.get("late_reject_msg").post(yYAudienceModel1.getName());
    } 
  }
  
  public void s(YYImModel paramYYImModel) {
    if (paramYYImModel == null)
      return; 
    YYMsgGiftExtra yYMsgGiftExtra = (YYMsgGiftExtra)AppInfo.f().fromJson(paramYYImModel.getMsgExtra(), YYMsgGiftExtra.class);
    if (yYMsgGiftExtra == null)
      return; 
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel != null)
      yYRoomModel.setGiftBeans(yYMsgGiftExtra.beans_current); 
    YYObserverManager.a().b(yYMsgGiftExtra.beans_current);
    YYObserverManager.a().a(paramYYImModel, true);
    a(paramYYImModel);
  }
  
  public void t(YYImModel paramYYImModel) {
    if (paramYYImModel == null)
      return; 
    LiveEventBus.get("send_apply_reject").post("");
    a(paramYYImModel);
  }
  
  public void u(YYImModel paramYYImModel) {
    a(paramYYImModel);
  }
  
  public void v(YYImModel paramYYImModel) {
    LiveEventBus.get("display_emoji_image").post(paramYYImModel);
  }
  
  public void w(YYImModel paramYYImModel) {
    YYMsgEmojiExtra yYMsgEmojiExtra = (YYMsgEmojiExtra)AppInfo.f().fromJson(paramYYImModel.getMsgExtra(), YYMsgEmojiExtra.class);
    if (yYMsgEmojiExtra != null) {
      if (TextUtils.isEmpty(yYMsgEmojiExtra.result))
        return; 
      a(paramYYImModel);
    } 
  }
  
  public void x(YYImModel paramYYImModel) {
    YYMsgVoteStartExtra yYMsgVoteStartExtra = (YYMsgVoteStartExtra)AppInfo.f().fromJson(paramYYImModel.getMsgExtra(), YYMsgVoteStartExtra.class);
    if (yYMsgVoteStartExtra == null)
      return; 
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel != null)
      yYRoomModel.vote_id = yYMsgVoteStartExtra.vote_id; 
    YYRoomInfoManager.d().a(StringUtils.a(yYMsgVoteStartExtra.vote_time, 0L));
  }
  
  public void y(YYImModel paramYYImModel) {
    E(paramYYImModel);
  }
  
  public void z(YYImModel paramYYImModel) {
    E(paramYYImModel);
  }
  
  static class IMMsgManager {
    private static YYImMsgManager a = new YYImMsgManager();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\manager\YYImMsgManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */