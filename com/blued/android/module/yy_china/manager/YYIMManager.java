package com.blued.android.module.yy_china.manager;

import android.text.TextUtils;
import com.blued.android.chat.utils.MsgPackHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.im.IM;
import com.blued.android.module.im.biz.AudioChatroom;
import com.blued.android.module.im.grpc.OnConnectStateListener;
import com.blued.android.module.yy_china.model.YYAudienceModel;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.im.audio_chatroom.AudioChatroomOuterClass;
import com.blued.im.audio_chatroom.AudioMsgExtra;
import com.blued.im.audio_chatroom.AudioMsgType;
import com.google.protobuf.Any;
import java.util.ArrayList;
import java.util.HashMap;

public class YYIMManager implements OnConnectStateListener {
  public static YYIMManager a;
  
  public static YYIMManager a() {
    if (a == null)
      a = new YYIMManager(); 
    return a;
  }
  
  private void a(AudioChatroomOuterClass.Receive paramReceive, YYImModel paramYYImModel) {
    AudioMsgExtra.JoinRoom joinRoom;
    AudioMsgExtra.QuitRoom quitRoom;
    AudioMsgExtra.CloseRoom closeRoom;
    AudioMsgExtra.SendGift sendGift;
    AudioMsgExtra.AlertRoom alertRoom;
    AudioMsgExtra.UpSeatSuccess upSeatSuccess;
    AudioMsgExtra.LeaveSeat leaveSeat;
    AudioMsgExtra.ApplyUpSeatCount applyUpSeatCount;
    AudioMsgExtra.MuteSeatStatus muteSeatStatus;
    AudioMsgExtra.CloseSeatStatus closeSeatStatus;
    AudioMsgExtra.OfficeMsg officeMsg;
    AudioMsgExtra.AuditNamePass auditNamePass;
    AudioMsgExtra.EmojiMsg emojiMsg;
    AudioMsgExtra.VoteStart voteStart;
    AudioMsgExtra.BlindDate blindDate;
    ArrayList<HashMap<Object, Object>> arrayList;
    if (paramReceive.getMsgType() == AudioMsgType.MsgType.TEXT) {
      YYImMsgManager.a().a(paramYYImModel);
      return;
    } 
    AudioMsgType.MsgType msgType1 = paramReceive.getMsgType();
    AudioMsgType.MsgType msgType2 = AudioMsgType.MsgType.JOIN_ROOM;
    boolean bool = false;
    int i = 0;
    if (msgType1 == msgType2) {
      joinRoom = paramReceive.getExtra().getJoinRoomExtra();
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "auditorCount", joinRoom.getAuditorCount());
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("收到进场消息 auditorCount = ");
      stringBuilder.append(joinRoom.getAuditorCount());
      Logger.e("onMessage", new Object[] { stringBuilder.toString() });
      YYImMsgManager.a().b(paramYYImModel);
      return;
    } 
    if (joinRoom.getMsgType() == AudioMsgType.MsgType.QUIT_ROOM) {
      quitRoom = joinRoom.getExtra().getQuitRoomExtra();
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "auditorCount", quitRoom.getAuditorCount());
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("收到退场消息 auditorCount = ");
      stringBuilder.append(quitRoom.getAuditorCount());
      Logger.e("onMessage", new Object[] { stringBuilder.toString() });
      YYImMsgManager.a().i(paramYYImModel);
      return;
    } 
    if (quitRoom.getMsgType() == AudioMsgType.MsgType.CLOSE_ROOM) {
      closeRoom = quitRoom.getExtra().getCloseRoomExtra();
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "title", closeRoom.getKickInfo().getTitle());
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "message", closeRoom.getKickInfo().getMessage());
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "audience_message", closeRoom.getKickInfo().getAudienceMessage());
      YYImMsgManager.a().k(paramYYImModel);
      return;
    } 
    if (closeRoom.getMsgType() == AudioMsgType.MsgType.SEND_GIFT) {
      sendGift = closeRoom.getExtra().getSendGiftExtra();
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "gift_icon", sendGift.getGiftIcon());
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "gift_apng", sendGift.getGiftApng());
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "gift_mp4", sendGift.getGiftMp4());
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "gift_type", sendGift.getGiftType());
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "gift_id", sendGift.getGiftId());
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "hit_count", sendGift.getHitCount());
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "hit_id", sendGift.getHitId());
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "hit_batch", sendGift.getHitBatch());
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "beans_current", sendGift.getBeansCurrent());
      YYImMsgManager.a().s(paramYYImModel);
      return;
    } 
    if (sendGift.getMsgType() == AudioMsgType.MsgType.ALERT_ROOM) {
      alertRoom = sendGift.getExtra().getAlertRoomExtra();
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "warning_type", alertRoom.getAlertType());
      YYImMsgManager.a().n(paramYYImModel);
      return;
    } 
    if (alertRoom.getMsgType() == AudioMsgType.MsgType.FOLLOW_NOTICE) {
      YYImMsgManager.a().p(paramYYImModel);
      return;
    } 
    if (alertRoom.getMsgType() == AudioMsgType.MsgType.SET_MANAGER) {
      YYImMsgManager.a().o(paramYYImModel);
      return;
    } 
    if (alertRoom.getMsgType() == AudioMsgType.MsgType.CANCLE_MANAGER) {
      YYImMsgManager.a().o(paramYYImModel);
      return;
    } 
    if (alertRoom.getMsgType() == AudioMsgType.MsgType.MUTE) {
      YYImMsgManager.a().a(paramYYImModel, "1");
      return;
    } 
    if (alertRoom.getMsgType() == AudioMsgType.MsgType.UNMUTE) {
      YYImMsgManager.a().a(paramYYImModel, "0");
      return;
    } 
    if (alertRoom.getMsgType() == AudioMsgType.MsgType.INVITE_UP_SEAT) {
      YYImMsgManager.a().e(paramYYImModel);
      return;
    } 
    if (alertRoom.getMsgType() == AudioMsgType.MsgType.REFUSE_INVITE) {
      YYImMsgManager.a().r(paramYYImModel);
      return;
    } 
    if (alertRoom.getMsgType() == AudioMsgType.MsgType.UP_SEAT_SUCCESS) {
      upSeatSuccess = alertRoom.getExtra().getUpSeatSuccessExtra();
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "room_id", upSeatSuccess.getRoomId());
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "seat_num", upSeatSuccess.getSeatNum());
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "auditor_count", upSeatSuccess.getAuditorCount());
      ArrayList<HashMap<Object, Object>> arrayList1 = new ArrayList();
      while (i < upSeatSuccess.getSeatsList().size()) {
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        MsgPackHelper.putMapValue(hashMap, "uid", upSeatSuccess.getSeats(i).getUid());
        MsgPackHelper.putMapValue(hashMap, "name", upSeatSuccess.getSeats(i).getName());
        MsgPackHelper.putMapValue(hashMap, "avatar", upSeatSuccess.getSeats(i).getAvatar());
        MsgPackHelper.putMapValue(hashMap, "role", upSeatSuccess.getSeats(i).getRoleValue());
        MsgPackHelper.putMapValue(hashMap, "user_sig", upSeatSuccess.getSeats(i).getUserSig());
        MsgPackHelper.putMapValue(hashMap, "mute", upSeatSuccess.getSeats(i).getMute());
        MsgPackHelper.putMapValue(hashMap, "seat_type", upSeatSuccess.getSeats(i).getSeatType());
        MsgPackHelper.putMapValue(hashMap, "mic_position", upSeatSuccess.getSeats(i).getMicPosition());
        if (i != 0 && upSeatSuccess.getSeats(i).getMicPosition() == 0)
          MsgPackHelper.putMapValue(hashMap, "mic_position", i); 
        MsgPackHelper.putMapValue(hashMap, "push_url", upSeatSuccess.getSeats(i).getPublishUrl());
        arrayList1.add(hashMap);
        i++;
      } 
      paramYYImModel.msgMapExtra.put("seats", arrayList1);
      YYImMsgManager.a().c(paramYYImModel);
      return;
    } 
    if (upSeatSuccess.getMsgType() == AudioMsgType.MsgType.LEAVE_SEAT) {
      leaveSeat = upSeatSuccess.getExtra().getLeaveSeatExtra();
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "room_id", leaveSeat.getRoomId());
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "seat_num", leaveSeat.getSeatNum());
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "leave_type", leaveSeat.getLeaveType());
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "auditor_count", leaveSeat.getAuditorCount());
      ArrayList<HashMap<Object, Object>> arrayList1 = new ArrayList();
      for (i = bool; i < leaveSeat.getSeatsList().size(); i++) {
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        MsgPackHelper.putMapValue(hashMap, "uid", leaveSeat.getSeats(i).getUid());
        MsgPackHelper.putMapValue(hashMap, "name", leaveSeat.getSeats(i).getName());
        MsgPackHelper.putMapValue(hashMap, "avatar", leaveSeat.getSeats(i).getAvatar());
        MsgPackHelper.putMapValue(hashMap, "role", leaveSeat.getSeats(i).getRoleValue());
        MsgPackHelper.putMapValue(hashMap, "user_sig", leaveSeat.getSeats(i).getUserSig());
        MsgPackHelper.putMapValue(hashMap, "mute", leaveSeat.getSeats(i).getMute());
        MsgPackHelper.putMapValue(hashMap, "seat_type", leaveSeat.getSeats(i).getSeatType());
        MsgPackHelper.putMapValue(hashMap, "mic_position", leaveSeat.getSeats(i).getMicPosition());
        if (i != 0 && leaveSeat.getSeats(i).getMicPosition() == 0)
          MsgPackHelper.putMapValue(hashMap, "mic_position", i); 
        arrayList1.add(hashMap);
      } 
      paramYYImModel.msgMapExtra.put("seats", arrayList1);
      YYImMsgManager.a().d(paramYYImModel);
      return;
    } 
    if (leaveSeat.getMsgType() == AudioMsgType.MsgType.APPLY_UP_SEAT_COUNT) {
      applyUpSeatCount = leaveSeat.getExtra().getApplyUpSeatCountExtra();
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "apply_count", applyUpSeatCount.getApplyCount());
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "apply_status", applyUpSeatCount.getApplyStatus());
      YYImMsgManager.a().l(paramYYImModel);
      return;
    } 
    if (applyUpSeatCount.getMsgType() == AudioMsgType.MsgType.MUTE_SEAT_STATUS) {
      muteSeatStatus = applyUpSeatCount.getExtra().getMuteSeatStatus();
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "uid", muteSeatStatus.getUid());
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "mute", muteSeatStatus.getMute());
      YYImMsgManager.a().g(paramYYImModel);
      return;
    } 
    if (muteSeatStatus.getMsgType() == AudioMsgType.MsgType.CLOSE_SEAT_STATUS) {
      closeSeatStatus = muteSeatStatus.getExtra().getCloseSeatExtra();
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "seat_num", closeSeatStatus.getSeatNum());
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "seat_close", closeSeatStatus.getSeatClose());
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("收到消息 开麦封麦 seat_num = ");
      stringBuilder.append(closeSeatStatus.getSeatNum());
      stringBuilder.append(" ； seat_close = ");
      stringBuilder.append(closeSeatStatus.getSeatClose());
      Logger.e("onMessage", new Object[] { stringBuilder.toString() });
      YYImMsgManager.a().h(paramYYImModel);
      return;
    } 
    if (closeSeatStatus.getMsgType() == AudioMsgType.MsgType.KICK_ROOM) {
      YYImMsgManager.a().j(paramYYImModel);
      return;
    } 
    if (closeSeatStatus.getMsgType() == AudioMsgType.MsgType.ROOM_NAME_INVALID) {
      YYImMsgManager.a().a(paramYYImModel);
      return;
    } 
    if (closeSeatStatus.getMsgType() == AudioMsgType.MsgType.OFFICE_MSG) {
      officeMsg = closeSeatStatus.getExtra().getOfficeMsgExtra();
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "title", officeMsg.getTitle());
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "content", officeMsg.getContent());
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "text_color", officeMsg.getTextColor());
      YYImMsgManager.a().a(paramYYImModel);
      return;
    } 
    if (officeMsg.getMsgType() == AudioMsgType.MsgType.AUDIT_NAME_PASS) {
      auditNamePass = officeMsg.getExtra().getAuditNamePassExtra();
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "room_name", auditNamePass.getRoomName());
      YYImMsgManager.a().m(paramYYImModel);
      return;
    } 
    if (auditNamePass.getMsgType() == AudioMsgType.MsgType.UP_APPLY_REJECT) {
      YYImMsgManager.a().t(paramYYImModel);
      return;
    } 
    if (auditNamePass.getMsgType() == AudioMsgType.MsgType.LATE_UP_SEAT_ACCEPT) {
      YYImMsgManager.a().q(paramYYImModel);
      return;
    } 
    if (auditNamePass.getMsgType() == AudioMsgType.MsgType.LATE_UP_SEAT_REJECT) {
      YYImMsgManager.a().r(paramYYImModel);
      return;
    } 
    if (auditNamePass.getMsgType() == AudioMsgType.MsgType.ANNOUNCEMENT) {
      YYImMsgManager.a().u(paramYYImModel);
      return;
    } 
    if (auditNamePass.getMsgType() == AudioMsgType.MsgType.EMOJIMSG) {
      emojiMsg = auditNamePass.getExtra().getEmojiMsgExtra();
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "id", emojiMsg.getId());
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "name", emojiMsg.getName());
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "pic", emojiMsg.getPic());
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "apng", emojiMsg.getApng());
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "result", emojiMsg.getResult());
      YYImMsgManager.a().v(paramYYImModel);
      return;
    } 
    if (emojiMsg.getMsgType() == AudioMsgType.MsgType.SOUND_EFFECT) {
      YYImMsgManager.a().a(paramYYImModel);
      return;
    } 
    if (emojiMsg.getMsgType() == AudioMsgType.MsgType.VOTE_START) {
      voteStart = emojiMsg.getExtra().getVoteStartExtra();
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "vote_time", voteStart.getEndTime());
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "vote_id", voteStart.getVoteId());
      YYImMsgManager.a().x(paramYYImModel);
      return;
    } 
    if (voteStart.getMsgType() == AudioMsgType.MsgType.VOTE_END) {
      YYImMsgManager.a().a(paramYYImModel, true);
      return;
    } 
    if (voteStart.getMsgType() == AudioMsgType.MsgType.TEXT_NO_NAME) {
      YYImMsgManager.a().a(paramYYImModel, false);
      YYImMsgManager.a().a(paramYYImModel);
      return;
    } 
    if (voteStart.getMsgType() == AudioMsgType.MsgType.BLIND_DATA_START) {
      blindDate = voteStart.getExtra().getBlindData();
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "present_step", blindDate.getPresentStep());
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "next_step", blindDate.getNextStep());
      YYImMsgManager.a().y(paramYYImModel);
      return;
    } 
    if (blindDate.getMsgType() == AudioMsgType.MsgType.BLIND_DATA_INTRODUCE) {
      blindDate = blindDate.getExtra().getBlindData();
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "present_step", blindDate.getPresentStep());
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "next_step", blindDate.getNextStep());
      YYImMsgManager.a().z(paramYYImModel);
      return;
    } 
    if (blindDate.getMsgType() == AudioMsgType.MsgType.BLIND_DATA_CHOOSE) {
      blindDate = blindDate.getExtra().getBlindData();
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "present_step", blindDate.getPresentStep());
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "next_step", blindDate.getNextStep());
      YYImMsgManager.a().A(paramYYImModel);
      return;
    } 
    if (blindDate.getMsgType() == AudioMsgType.MsgType.BLIND_DATA_PULISH) {
      AudioMsgExtra.BlindDatePublish blindDatePublish = blindDate.getExtra().getBlindDataPublish();
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "present_step", blindDatePublish.getPresentStep());
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "next_step", blindDatePublish.getNextStep());
      arrayList = new ArrayList();
      for (AudioMsgExtra.BlindDateSeat blindDateSeat : blindDatePublish.getSeatsList()) {
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        MsgPackHelper.putMapValue(hashMap, "uid", blindDateSeat.getUid());
        MsgPackHelper.putMapValue(hashMap, "choose_seat_num", blindDateSeat.getChooseSeatNum());
        arrayList.add(hashMap);
      } 
      paramYYImModel.msgMapExtra.put("seats", arrayList);
      YYImMsgManager.a().B(paramYYImModel);
      return;
    } 
    if (arrayList.getMsgType() == AudioMsgType.MsgType.BLIND_DATA_OVER) {
      AudioMsgExtra.BlindDateOver blindDateOver = arrayList.getExtra().getBlindDataOver();
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "present_step", blindDateOver.getPresentStep());
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "next_step", blindDateOver.getNextStep());
      arrayList = new ArrayList<HashMap<Object, Object>>();
      for (AudioMsgExtra.MatchUserPair matchUserPair : blindDateOver.getMatchUsersList()) {
        HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>();
        AudioMsgExtra.MatchUser matchUser1 = matchUserPair.getSource();
        MsgPackHelper.putMapValue(hashMap1, "uid", matchUser1.getUid());
        MsgPackHelper.putMapValue(hashMap1, "name", matchUser1.getName());
        MsgPackHelper.putMapValue(hashMap1, "avatar", matchUser1.getAvatar());
        MsgPackHelper.putMapValue(hashMap1, "seat_num", matchUser1.getSeatNum());
        HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>();
        AudioMsgExtra.MatchUser matchUser2 = matchUserPair.getTarget();
        MsgPackHelper.putMapValue(hashMap2, "uid", matchUser2.getUid());
        MsgPackHelper.putMapValue(hashMap2, "name", matchUser2.getName());
        MsgPackHelper.putMapValue(hashMap2, "avatar", matchUser2.getAvatar());
        MsgPackHelper.putMapValue(hashMap2, "seat_num", matchUser2.getSeatNum());
        HashMap<Object, Object> hashMap3 = new HashMap<Object, Object>();
        hashMap3.put("source", hashMap1);
        hashMap3.put("target", hashMap2);
        arrayList.add(hashMap3);
      } 
      ArrayList<HashMap<Object, Object>> arrayList1 = new ArrayList();
      for (AudioMsgExtra.BlindDateSeat blindDateSeat : blindDateOver.getSeatsList()) {
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        MsgPackHelper.putMapValue(hashMap, "uid", blindDateSeat.getUid());
        MsgPackHelper.putMapValue(hashMap, "choose_seat_num", blindDateSeat.getChooseSeatNum());
        arrayList1.add(hashMap);
      } 
      paramYYImModel.msgMapExtra.put("match_users", arrayList);
      paramYYImModel.msgMapExtra.put("seats", arrayList1);
      YYImMsgManager.a().C(paramYYImModel);
      return;
    } 
    if (arrayList.getMsgType() == AudioMsgType.MsgType.BLIND_DATA_HEART) {
      AudioMsgExtra.BlindDateHeartUser blindDateHeartUser = arrayList.getExtra().getBlindDataHeartUser();
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "uid", blindDateHeartUser.getUid());
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "name", blindDateHeartUser.getName());
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "avatar", blindDateHeartUser.getAvatar());
      MsgPackHelper.putMapValue(paramYYImModel.msgMapExtra, "seat_num", blindDateHeartUser.getSeatNum());
      YYImMsgManager.a().D(paramYYImModel);
    } 
  }
  
  public void a(String paramString, AudioChatroom.OnAudioChatroomResponseListener paramOnAudioChatroomResponseListener) {
    YYUserInfo yYUserInfo = (YYRoomInfoManager.d()).a;
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel != null && !TextUtils.isEmpty(yYRoomModel.room_id)) {
      if (yYUserInfo == null)
        return; 
      IM.a(AudioChatroomOuterClass.Request.newBuilder().setContents(paramString).setSourceProfile(AudioMsgExtra.Profile.newBuilder().setName(yYUserInfo.getName()).setAvatar(yYUserInfo.getAvatar()).setUid(StringUtils.a(yYUserInfo.getUid(), 0)).setRoleValue(StringUtils.a(yYUserInfo.chat_anchor, 0)).build()).setMsgType(AudioMsgType.MsgType.TEXT).setRoomId(StringUtils.a(yYRoomModel.room_id, 0)), paramOnAudioChatroomResponseListener);
    } 
  }
  
  public void onConnected() {
    Logger.e("onMessage", new Object[] { "onConnected ... " });
  }
  
  public void onConnecting() {
    Logger.e("onMessage", new Object[] { "onConnecting ... " });
  }
  
  public void onDisconnected() {
    Logger.e("onMessage", new Object[] { "onDisconnected ... " });
  }
  
  public void onReceive(Any paramAny) {
    Logger.e("onMessage", new Object[] { "收到消息" });
    try {
      YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
      if (yYRoomModel == null)
        return; 
      AudioChatroomOuterClass.Receive receive = (AudioChatroomOuterClass.Receive)paramAny.unpack(AudioChatroomOuterClass.Receive.class);
      if (receive.getRoomId() != StringUtils.a(yYRoomModel.room_id, 0))
        return; 
      YYImModel yYImModel = new YYImModel();
      yYImModel.type = receive.getMsgTypeValue();
      yYImModel.contents = receive.getContents();
      yYImModel.resend = receive.getResend();
      yYImModel.source_profile = new YYAudienceModel();
      yYImModel.source_profile.setUid(String.valueOf(receive.getSourceProfile().getUid()));
      yYImModel.source_profile.setName(receive.getSourceProfile().getName());
      yYImModel.source_profile.setAvatar(receive.getSourceProfile().getAvatar());
      yYImModel.source_profile.chat_anchor = String.valueOf(receive.getSourceProfile().getRoleValue());
      yYImModel.target_profile = new YYAudienceModel();
      yYImModel.target_profile.setUid(String.valueOf(receive.getTargetProfile().getUid()));
      yYImModel.target_profile.setName(receive.getTargetProfile().getName());
      yYImModel.target_profile.setAvatar(receive.getTargetProfile().getAvatar());
      yYImModel.target_profile.chat_anchor = String.valueOf(receive.getTargetProfile().getRoleValue());
      yYImModel.msg_time = receive.getMsgTime();
      yYImModel.msgMapExtra = new HashMap<Object, Object>();
      AppInfo.n().post(new Runnable(this, receive, yYImModel) {
            public void run() {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("收到消息 type = ");
              stringBuilder.append(this.a.getMsgTypeValue());
              Logger.e("onMessage", new Object[] { stringBuilder.toString() });
              YYIMManager.a(this.c, this.a, this.b);
              stringBuilder = new StringBuilder();
              stringBuilder.append("收到消息 = ");
              stringBuilder.append(this.b.toString());
              Logger.e("onMessage", new Object[] { stringBuilder.toString() });
            }
          });
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\manager\YYIMManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */