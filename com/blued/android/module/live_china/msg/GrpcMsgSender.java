package com.blued.android.module.live_china.msg;

import android.text.TextUtils;
import cn.irisgw.live.LiveChatOuterClass;
import cn.irisgw.live.LiveConstants;
import com.blued.android.chat.data.EntranceData;
import com.blued.android.chat.data.LiveChatStatistics;
import com.blued.android.chat.data.LiveCloseReason;
import com.blued.android.chat.data.ProfileData;
import com.blued.android.chat.listener.LiveChatInfoListener;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.utils.MsgPackHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.http.HappyDnsUtils;
import com.blued.android.framework.utils.LocaleUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.im.grpc.OnConnectStateListener;
import com.blued.android.module.live.im.LiveIM;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveActivityItemModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.google.protobuf.Any;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class GrpcMsgSender extends ILiveMsgSender {
  private final String a = "GrpcMsgSender";
  
  private boolean b = false;
  
  private String c;
  
  private String d;
  
  private String e;
  
  private final Map<String, Set<LiveChatInfoListener>> f = new HashMap<String, Set<LiveChatInfoListener>>();
  
  private OnConnectStateListener g = new OnConnectStateListener(this) {
      public void onConnected() {
        LogUtils.c("GrpcMsgSender", "connect onConnected");
        if (LiveRoomManager.a().b() > 0L) {
          LiveRoomHttpUtils.a(null, LiveRoomManager.a().b(), (LiveRoomManager.a().h()).comeCode, 1);
          LiveRoomHttpUtils.a(null, null, LiveRoomManager.a().c(), "1");
        } 
        GrpcMsgSender.a(this.a);
      }
      
      public void onConnecting() {}
      
      public void onDisconnected() {
        GrpcMsgSender.a(this.a, false);
        LogUtils.d("GrpcMsgSender", "connect onClose");
      }
      
      public void onReceive(Any param1Any) {
        try {
          GrpcMsgSender.a(this.a, param1Any);
          return;
        } catch (Exception exception) {
          GrpcMsgSender grpcMsgSender = this.a;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("解析错误？ ");
          stringBuilder.append(exception.toString());
          GrpcMsgSender.a(grpcMsgSender, stringBuilder.toString());
          exception.printStackTrace();
          return;
        } 
      }
    };
  
  public GrpcMsgSender() {
    LiveIM.a(true);
  }
  
  private LiveGiftModel a(LiveConstants.GiftExtra paramGiftExtra) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private Map<String, Object> a(LiveConstants.LoveFan paramLoveFan) {
    long l1;
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    MsgPackHelper.putMapValue(hashMap, "uid", paramLoveFan.getUid());
    MsgPackHelper.putMapValue(hashMap, "name", paramLoveFan.getName());
    MsgPackHelper.putMapValue(hashMap, "avatar", paramLoveFan.getAvatar());
    boolean bool = paramLoveFan.getVoice();
    long l2 = 1L;
    if (bool) {
      l1 = 1L;
    } else {
      l1 = 0L;
    } 
    MsgPackHelper.putMapValue(hashMap, "voice", l1);
    MsgPackHelper.putMapValue(hashMap, "pic", paramLoveFan.getPic());
    if (paramLoveFan.getLamp()) {
      l1 = 1L;
    } else {
      l1 = 0L;
    } 
    MsgPackHelper.putMapValue(hashMap, "lamp", l1);
    if (paramLoveFan.getIsFollowed()) {
      l1 = l2;
    } else {
      l1 = 0L;
    } 
    MsgPackHelper.putMapValue(hashMap, "is_followed", l1);
    MsgPackHelper.putMapValue(hashMap, "stream", paramLoveFan.getStream());
    return (Map)hashMap;
  }
  
  private void a(EntranceData paramEntranceData, long paramLong) {
    if (paramEntranceData != null)
      synchronized (this.f) {
        Set set = this.f.get(LiveRoomManager.a().c());
        if (set != null) {
          Iterator<LiveChatInfoListener> iterator = set.iterator();
          while (iterator.hasNext())
            ((LiveChatInfoListener)iterator.next()).onViewerEntrance(paramEntranceData, paramLong); 
        } 
        return;
      }  
  }
  
  private void a(LiveCloseReason paramLiveCloseReason, LiveChatStatistics paramLiveChatStatistics) {
    synchronized (this.f) {
      Set set = this.f.get(LiveRoomManager.a().c());
      if (set != null) {
        Iterator<LiveChatInfoListener> iterator = set.iterator();
        while (iterator.hasNext()) {
          LiveChatInfoListener liveChatInfoListener = iterator.next();
          iterator.remove();
          liveChatInfoListener.onClose(paramLiveCloseReason, paramLiveChatStatistics);
        } 
      } 
      return;
    } 
  }
  
  private void a(Any paramAny) throws InvalidProtocolBufferException {
    LiveConstants.CloseLiveExtra closeLiveExtra;
    StringBuilder stringBuilder1;
    if (paramAny == null)
      return; 
    if (!paramAny.is(LiveConstants.LiveMessage.class))
      return; 
    LiveConstants.LiveMessage liveMessage = (LiveConstants.LiveMessage)paramAny.unpack(LiveConstants.LiveMessage.class);
    ChattingModel chattingModel = new ChattingModel();
    chattingModel.sessionId = CommonStringUtils.c(liveMessage.getLiveId());
    if (LiveRoomManager.a().b() != chattingModel.sessionId) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("getRoomId: ");
      stringBuilder1.append(LiveRoomManager.a().b());
      stringBuilder1.append(", sessionId:");
      stringBuilder1.append(chattingModel.sessionId);
      LogUtils.c("GrpcMsgSender", stringBuilder1.toString());
      return;
    } 
    chattingModel.msgId = stringBuilder1.getMsgId();
    chattingModel.msgTimestamp = stringBuilder1.getTimestamp();
    chattingModel.fromId = stringBuilder1.getFrom();
    chattingModel.msgType = (short)stringBuilder1.getTypeValue();
    chattingModel.msgContent = stringBuilder1.getContents();
    if (stringBuilder1.getProfile() != null) {
      chattingModel.fromVBadge = stringBuilder1.getProfile().getVbadgeValue();
      chattingModel.fromAvatar = stringBuilder1.getProfile().getAvatar();
      chattingModel.fromNickName = stringBuilder1.getProfile().getName();
      chattingModel.fromRichLevel = stringBuilder1.getProfile().getRichLevel();
      chattingModel.fromLiveManager = stringBuilder1.getProfile().getIsManager();
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("fromNickName: ");
    stringBuilder2.append(chattingModel.fromNickName);
    stringBuilder2.append(", msgType: ");
    stringBuilder2.append(chattingModel.msgType);
    stringBuilder2.append(", msgContent:");
    stringBuilder2.append(chattingModel.msgContent);
    LogUtils.c(stringBuilder2.toString());
    if (stringBuilder1.getExtra() != null) {
      EntranceData entranceData;
      chattingModel.msgMapExtra = new HashMap<Object, Object>();
      if (stringBuilder1.getExtra().is(LiveConstants.JoinLiveExtra.class)) {
        long l;
        LiveConstants.JoinLiveExtra joinLiveExtra = (LiveConstants.JoinLiveExtra)stringBuilder1.getExtra().unpack(LiveConstants.JoinLiveExtra.class);
        MsgPackHelper.putMapValue(chattingModel.msgMapExtra, "count", joinLiveExtra.getCount());
        MsgPackHelper.putMapValue(chattingModel.msgMapExtra, "realtime_count", joinLiveExtra.getRealtimeCount());
        MsgPackHelper.putMapValue(chattingModel.msgMapExtra, "fan_club_name", joinLiveExtra.getFanClubName());
        MsgPackHelper.putMapValue(chattingModel.msgMapExtra, "fans_status", joinLiveExtra.getFansStatusValue());
        Map map = chattingModel.msgMapExtra;
        if (joinLiveExtra.getInFanClub()) {
          l = 1L;
        } else {
          l = 0L;
        } 
        MsgPackHelper.putMapValue(map, "in_fan_club", l);
        MsgPackHelper.putMapValue(chattingModel.msgMapExtra, "fan_club_level", joinLiveExtra.getFanClubLevel());
        MsgPackHelper.putMapValue(chattingModel.msgMapExtra, "liang_id", joinLiveExtra.getLiangId());
        MsgPackHelper.putMapValue(chattingModel.msgMapExtra, "liang_type", joinLiveExtra.getLiangTypeValue());
        if (joinLiveExtra.getEffects() != null && (!TextUtils.isEmpty(joinLiveExtra.getEffects().getEntranceApng()) || !TextUtils.isEmpty(joinLiveExtra.getEffects().getEntranceGif()) || !TextUtils.isEmpty(joinLiveExtra.getEffects().getEntranceMp4()) || !TextUtils.isEmpty(joinLiveExtra.getEffects().getUrl()))) {
          boolean bool;
          entranceData = new EntranceData();
          ProfileData profileData = new ProfileData();
          profileData.uid = stringBuilder1.getFrom();
          profileData.name = stringBuilder1.getProfile().getName();
          profileData.avatar = stringBuilder1.getProfile().getAvatar();
          profileData.vBadge = stringBuilder1.getProfile().getVbadgeValue();
          if (stringBuilder1.getProfile().getIsManager() == 1) {
            bool = true;
          } else {
            bool = false;
          } 
          profileData.isLiveManager = bool;
          profileData.liangId = joinLiveExtra.getLiangId();
          profileData.liangType = joinLiveExtra.getLiangTypeValue();
          entranceData.userData = profileData;
          entranceData.entranceContents = joinLiveExtra.getEffects().getContents();
          entranceData.entranceImage = joinLiveExtra.getEffects().getUrl();
          entranceData.entranceColor = joinLiveExtra.getEffects().getBackgroundColor();
          entranceData.entranceAnim = joinLiveExtra.getEffects().getGiftApng();
          entranceData.entranceGif = joinLiveExtra.getEffects().getEntranceGif();
          entranceData.entranceApng = joinLiveExtra.getEffects().getEntranceApng();
          entranceData.entranceMp4 = joinLiveExtra.getEffects().getEntranceMp4();
          a(entranceData, joinLiveExtra.getRealtimeCount());
          return;
        } 
      } else {
        LiveConstants.LeaveLiveExtra leaveLiveExtra;
        if (stringBuilder1.getExtra().is(LiveConstants.LeaveLiveExtra.class)) {
          leaveLiveExtra = (LiveConstants.LeaveLiveExtra)stringBuilder1.getExtra().unpack(LiveConstants.LeaveLiveExtra.class);
          MsgPackHelper.putMapValue(((ChattingModel)entranceData).msgMapExtra, "count", leaveLiveExtra.getCount());
          MsgPackHelper.putMapValue(((ChattingModel)entranceData).msgMapExtra, "realtime_count", leaveLiveExtra.getRealtimeCount());
        } else {
          LiveChatStatistics liveChatStatistics;
          LiveGiftModel liveGiftModel;
          if (leaveLiveExtra.getExtra().is(LiveConstants.CloseLiveExtra.class)) {
            closeLiveExtra = (LiveConstants.CloseLiveExtra)leaveLiveExtra.getExtra().unpack(LiveConstants.CloseLiveExtra.class);
            liveChatStatistics = new LiveChatStatistics();
            liveChatStatistics.title = closeLiveExtra.getKickInfo().getTitle();
            liveChatStatistics.message = closeLiveExtra.getKickInfo().getMessage();
            liveChatStatistics.audience_message = closeLiveExtra.getKickInfo().getAudienceMessage();
            if (closeLiveExtra.getKickInfo().getReasonValue() < 1) {
              a(LiveCloseReason.CLOSED_BY_LIVER, liveChatStatistics);
              return;
            } 
            a(LiveCloseReason.CLOSED_BY_MANAGER, liveChatStatistics);
            return;
          } 
          if (liveChatStatistics.getExtra().is(LiveConstants.GiftExtra.class)) {
            liveGiftModel = a((LiveConstants.GiftExtra)liveChatStatistics.getExtra().unpack(LiveConstants.GiftExtra.class));
            ((ChattingModel)closeLiveExtra).msgMapExtra.put("gift_model", liveGiftModel);
          } else {
            LiveConstants.LiveRankExtra liveRankExtra;
            if (liveGiftModel.getExtra().is(LiveConstants.LiveRankExtra.class)) {
              liveRankExtra = (LiveConstants.LiveRankExtra)liveGiftModel.getExtra().unpack(LiveConstants.LiveRankExtra.class);
              MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "rank", liveRankExtra.getRank());
              MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "icon", liveRankExtra.getIcon());
            } else {
              LiveConstants.MedalExtra medalExtra;
              if (liveRankExtra.getExtra().is(LiveConstants.MedalExtra.class)) {
                medalExtra = (LiveConstants.MedalExtra)liveRankExtra.getExtra().unpack(LiveConstants.MedalExtra.class);
                ArrayList<HashMap<Object, Object>> arrayList = new ArrayList();
                for (int i = 0; i < medalExtra.getBadgesList().size(); i++) {
                  HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
                  MsgPackHelper.putMapValue(hashMap, "id", ((LiveConstants.MedalExtra.Badge)medalExtra.getBadgesList().get(i)).getId());
                  MsgPackHelper.putMapValue(hashMap, "url", ((LiveConstants.MedalExtra.Badge)medalExtra.getBadgesList().get(i)).getUrl());
                  arrayList.add(hashMap);
                } 
                ((ChattingModel)closeLiveExtra).msgMapExtra.put("badges", arrayList);
              } else {
                LiveConstants.HornExtra hornExtra;
                if (medalExtra.getExtra().is(LiveConstants.HornExtra.class)) {
                  hornExtra = (LiveConstants.HornExtra)medalExtra.getExtra().unpack(LiveConstants.HornExtra.class);
                  MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "type", hornExtra.getType());
                  MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "color", hornExtra.getColor());
                  MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "notify_icon", hornExtra.getNotifyIcon());
                  MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "highlight", hornExtra.getHighlight());
                  MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "gift_apng", hornExtra.getGiftApng());
                  MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "highlight_new", hornExtra.getHighlightNew());
                  ((ChattingModel)closeLiveExtra).msgMapExtra.put("is_hongbao", Boolean.valueOf(hornExtra.getIsHongbao()));
                } else {
                  LiveConstants.BoxExtra boxExtra;
                  if (hornExtra.getExtra().is(LiveConstants.BoxExtra.class)) {
                    boxExtra = (LiveConstants.BoxExtra)hornExtra.getExtra().unpack(LiveConstants.BoxExtra.class);
                    ArrayList<HashMap<Object, Object>> arrayList = new ArrayList();
                    for (int i = 0; i < boxExtra.getBoxesList().size(); i++) {
                      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
                      MsgPackHelper.putMapValue(hashMap, "type", ((LiveConstants.BoxExtra.Box)boxExtra.getBoxesList().get(i)).getType());
                      MsgPackHelper.putMapValue(hashMap, "box_id", ((LiveConstants.BoxExtra.Box)boxExtra.getBoxesList().get(i)).getBoxId());
                      MsgPackHelper.putMapValue(hashMap, "box_image", ((LiveConstants.BoxExtra.Box)boxExtra.getBoxesList().get(i)).getBoxImage());
                      MsgPackHelper.putMapValue(hashMap, "progress", ((LiveConstants.BoxExtra.Box)boxExtra.getBoxesList().get(i)).getProgress());
                      MsgPackHelper.putMapValue(hashMap, "progress_full_gif", ((LiveConstants.BoxExtra.Box)boxExtra.getBoxesList().get(i)).getProgressFullGif());
                      MsgPackHelper.putMapValue(hashMap, "duration", ((LiveConstants.BoxExtra.Box)boxExtra.getBoxesList().get(i)).getDuration());
                      MsgPackHelper.putMapValue(hashMap, "index", ((LiveConstants.BoxExtra.Box)boxExtra.getBoxesList().get(i)).getIndex());
                      MsgPackHelper.putMapValue(hashMap, "box_gif", ((LiveConstants.BoxExtra.Box)boxExtra.getBoxesList().get(i)).getBoxGif());
                      arrayList.add(hashMap);
                    } 
                    ((ChattingModel)closeLiveExtra).msgMapExtra.put("boxes", arrayList);
                  } else {
                    LiveConstants.BoxGiftExtra boxGiftExtra;
                    if (boxExtra.getExtra().is(LiveConstants.BoxGiftExtra.class)) {
                      boxGiftExtra = (LiveConstants.BoxGiftExtra)boxExtra.getExtra().unpack(LiveConstants.BoxGiftExtra.class);
                      ArrayList<HashMap<Object, Object>> arrayList = new ArrayList();
                      for (int i = 0; i < boxGiftExtra.getBonusList().size(); i++) {
                        HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>();
                        MsgPackHelper.putMapValue(hashMap1, "id", boxGiftExtra.getBonus(i).getId());
                        MsgPackHelper.putMapValue(hashMap1, "image", boxGiftExtra.getBonus(i).getImage());
                        MsgPackHelper.putMapValue(hashMap1, "count", boxGiftExtra.getBonus(i).getCount());
                        HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>();
                        MsgPackHelper.putMapValue(hashMap2, "uid", boxGiftExtra.getBonus(i).getProfile().getUid());
                        MsgPackHelper.putMapValue(hashMap2, "name", boxGiftExtra.getBonus(i).getProfile().getName());
                        hashMap1.put("profile", hashMap2);
                        arrayList.add(hashMap1);
                      } 
                      ((ChattingModel)closeLiveExtra).msgMapExtra.put("bonus", arrayList);
                    } else {
                      LiveConstants.HongbaoExtra hongbaoExtra;
                      if (boxGiftExtra.getExtra().is(LiveConstants.HongbaoExtra.class)) {
                        long l;
                        hongbaoExtra = (LiveConstants.HongbaoExtra)boxGiftExtra.getExtra().unpack(LiveConstants.HongbaoExtra.class);
                        MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "hongbao_id", hongbaoExtra.getHongbaoId());
                        MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "start_second", hongbaoExtra.getStartSecond());
                        MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "end_second", hongbaoExtra.getEndSecond());
                        MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "status", hongbaoExtra.getStatus());
                        MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "size", hongbaoExtra.getSize());
                        MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "beans", hongbaoExtra.getBeans());
                        Map map = ((ChattingModel)closeLiveExtra).msgMapExtra;
                        if (hongbaoExtra.getIsAnim()) {
                          l = 1L;
                        } else {
                          l = 0L;
                        } 
                        MsgPackHelper.putMapValue(map, "is_anim", l);
                        MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "remaining_millisecond", hongbaoExtra.getRemainingMillisecond());
                        MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "condition", hongbaoExtra.getCondition());
                        MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "pwd", hongbaoExtra.getPwd());
                      } else {
                        LiveConstants.HongbaoRefundExtra hongbaoRefundExtra;
                        if (hongbaoExtra.getExtra().is(LiveConstants.HongbaoRefundExtra.class)) {
                          hongbaoRefundExtra = (LiveConstants.HongbaoRefundExtra)hongbaoExtra.getExtra().unpack(LiveConstants.HongbaoRefundExtra.class);
                          MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "refund_beans", hongbaoRefundExtra.getRefundBeans());
                        } else {
                          LiveConstants.RichLevelUpdateExtra richLevelUpdateExtra;
                          if (hongbaoRefundExtra.getExtra().is(LiveConstants.RichLevelUpdateExtra.class)) {
                            richLevelUpdateExtra = (LiveConstants.RichLevelUpdateExtra)hongbaoRefundExtra.getExtra().unpack(LiveConstants.RichLevelUpdateExtra.class);
                            MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "gift_apng", richLevelUpdateExtra.getGiftApng());
                          } else if (!richLevelUpdateExtra.getExtra().is(LiveConstants.ManagerAppointmentExtra.class) && !richLevelUpdateExtra.getExtra().is(LiveConstants.ManagerCancelExtra.class)) {
                            LiveConstants.muteExtra muteExtra;
                            if (richLevelUpdateExtra.getExtra().is(LiveConstants.muteExtra.class)) {
                              muteExtra = (LiveConstants.muteExtra)richLevelUpdateExtra.getExtra().unpack(LiveConstants.muteExtra.class);
                              HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
                              MsgPackHelper.putMapValue(hashMap, "uid", muteExtra.getMuteProfile().getUid());
                              MsgPackHelper.putMapValue(hashMap, "name", muteExtra.getMuteProfile().getName());
                              ((ChattingModel)closeLiveExtra).msgMapExtra.put("mute_profile", hashMap);
                            } else {
                              LiveConstants.FriendPKInviteExtra friendPKInviteExtra;
                              if (muteExtra.getExtra().is(LiveConstants.FriendPKInviteExtra.class)) {
                                friendPKInviteExtra = (LiveConstants.FriendPKInviteExtra)muteExtra.getExtra().unpack(LiveConstants.FriendPKInviteExtra.class);
                                MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "reset", friendPKInviteExtra.getReset());
                                MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "uid", friendPKInviteExtra.getUid());
                                MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "avatar", friendPKInviteExtra.getAvatar());
                                MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "name", friendPKInviteExtra.getName());
                                MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "lid", friendPKInviteExtra.getLid());
                              } else {
                                LiveConstants.StartPKExtra startPKExtra;
                                if (friendPKInviteExtra.getExtra().is(LiveConstants.StartPKExtra.class)) {
                                  startPKExtra = (LiveConstants.StartPKExtra)friendPKInviteExtra.getExtra().unpack(LiveConstants.StartPKExtra.class);
                                  MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "stream", startPKExtra.getStream());
                                  MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "target_stream", startPKExtra.getTargetStream());
                                  MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "conference_id", startPKExtra.getConferenceId());
                                  MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "conference_token", startPKExtra.getConferenceToken());
                                  MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "uid", startPKExtra.getUid());
                                  MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "lid", startPKExtra.getLid());
                                  MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "name", startPKExtra.getName());
                                  MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "avatar", startPKExtra.getAvatar());
                                  MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "countdown", startPKExtra.getCountdown());
                                  MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "avatar", startPKExtra.getAvatar());
                                  MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "countdown", startPKExtra.getCountdown());
                                  MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "delay", startPKExtra.getDelay());
                                  ArrayList<HashMap<Object, Object>> arrayList = new ArrayList();
                                  for (int i = 0; i < startPKExtra.getRecordsList().size(); i++) {
                                    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
                                    MsgPackHelper.putMapValue(hashMap, "uid", startPKExtra.getRecords(i).getUid());
                                    MsgPackHelper.putMapValue(hashMap, "score", startPKExtra.getRecords(i).getScore());
                                    arrayList.add(hashMap);
                                  } 
                                  ((ChattingModel)closeLiveExtra).msgMapExtra.put("records", arrayList);
                                } else {
                                  LiveConstants.EndPKExtra endPKExtra;
                                  if (startPKExtra.getExtra().is(LiveConstants.EndPKExtra.class)) {
                                    endPKExtra = (LiveConstants.EndPKExtra)startPKExtra.getExtra().unpack(LiveConstants.EndPKExtra.class);
                                    MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "type", endPKExtra.getType());
                                    MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "winner", endPKExtra.getWinner());
                                    MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "countdown", endPKExtra.getCountdown());
                                    ArrayList<HashMap<Object, Object>> arrayList = new ArrayList();
                                    for (int i = 0; i < endPKExtra.getRecordsList().size(); i++) {
                                      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
                                      MsgPackHelper.putMapValue(hashMap, "uid", endPKExtra.getRecords(i).getUid());
                                      MsgPackHelper.putMapValue(hashMap, "score", endPKExtra.getRecords(i).getScore());
                                      MsgPackHelper.putMapValue(hashMap, "ar_url", endPKExtra.getRecords(i).getArUrl());
                                      MsgPackHelper.putMapValue(hashMap, "anim_code", endPKExtra.getRecords(i).getAnimCode());
                                      arrayList.add(hashMap);
                                    } 
                                    ((ChattingModel)closeLiveExtra).msgMapExtra.put("records", arrayList);
                                  } else {
                                    LiveConstants.PKProgressUpdateExtra pKProgressUpdateExtra;
                                    if (endPKExtra.getExtra().is(LiveConstants.PKProgressUpdateExtra.class)) {
                                      pKProgressUpdateExtra = (LiveConstants.PKProgressUpdateExtra)endPKExtra.getExtra().unpack(LiveConstants.PKProgressUpdateExtra.class);
                                      MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "uid", pKProgressUpdateExtra.getUid());
                                      MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "score", pKProgressUpdateExtra.getScore());
                                      MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "total", pKProgressUpdateExtra.getTotal());
                                      ArrayList<HashMap<Object, Object>> arrayList = new ArrayList();
                                      int i;
                                      for (i = 0; i < pKProgressUpdateExtra.getTopList().size(); i++) {
                                        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
                                        MsgPackHelper.putMapValue(hashMap, "uid", pKProgressUpdateExtra.getTop(i).getUid());
                                        MsgPackHelper.putMapValue(hashMap, "avatar", pKProgressUpdateExtra.getTop(i).getAvatar());
                                        arrayList.add(hashMap);
                                      } 
                                      ((ChattingModel)closeLiveExtra).msgMapExtra.put("top", arrayList);
                                      arrayList = new ArrayList<HashMap<Object, Object>>();
                                      for (i = 0; i < pKProgressUpdateExtra.getTargetTopList().size(); i++) {
                                        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
                                        MsgPackHelper.putMapValue(hashMap, "uid", pKProgressUpdateExtra.getTargetTop(i).getUid());
                                        MsgPackHelper.putMapValue(hashMap, "avatar", pKProgressUpdateExtra.getTargetTop(i).getAvatar());
                                        arrayList.add(hashMap);
                                      } 
                                      ((ChattingModel)closeLiveExtra).msgMapExtra.put("target_top", arrayList);
                                    } else {
                                      LiveConstants.H5EventExtra h5EventExtra;
                                      if (pKProgressUpdateExtra.getExtra().is(LiveConstants.H5EventExtra.class)) {
                                        h5EventExtra = (LiveConstants.H5EventExtra)pKProgressUpdateExtra.getExtra().unpack(LiveConstants.H5EventExtra.class);
                                        MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "icon", h5EventExtra.getIcon());
                                        MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "link", h5EventExtra.getLink());
                                      } else {
                                        LiveConstants.LineInviteExtra lineInviteExtra;
                                        if (h5EventExtra.getExtra().is(LiveConstants.LineInviteExtra.class)) {
                                          lineInviteExtra = (LiveConstants.LineInviteExtra)h5EventExtra.getExtra().unpack(LiveConstants.LineInviteExtra.class);
                                          MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "uid", lineInviteExtra.getUid());
                                          MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "name", lineInviteExtra.getName());
                                          MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "avatar", lineInviteExtra.getAvatar());
                                          MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "reset", lineInviteExtra.getReset());
                                          MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "type", lineInviteExtra.getType());
                                        } else {
                                          LiveConstants.LineStartExtra lineStartExtra;
                                          if (lineInviteExtra.getExtra().is(LiveConstants.LineStartExtra.class)) {
                                            lineStartExtra = (LiveConstants.LineStartExtra)lineInviteExtra.getExtra().unpack(LiveConstants.LineStartExtra.class);
                                            MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "stream", lineStartExtra.getStream());
                                            MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "target_stream", lineStartExtra.getTargetStream());
                                            MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "conference_id", lineStartExtra.getConferenceId());
                                            MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "conference_token", lineStartExtra.getConferenceToken());
                                            MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "target_token", lineStartExtra.getTargetToken());
                                            MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "uid", lineStartExtra.getUid());
                                            MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "name", lineStartExtra.getName());
                                            MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "type", lineStartExtra.getType());
                                          } else {
                                            LiveConstants.LineEndExtra lineEndExtra;
                                            if (lineStartExtra.getExtra().is(LiveConstants.LineEndExtra.class)) {
                                              lineEndExtra = (LiveConstants.LineEndExtra)lineStartExtra.getExtra().unpack(LiveConstants.LineEndExtra.class);
                                              MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "closed_by", lineEndExtra.getClosedBy());
                                              MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "type", lineEndExtra.getType());
                                            } else {
                                              LiveConstants.EventExtra eventExtra;
                                              if (lineEndExtra.getExtra().is(LiveConstants.EventExtra.class)) {
                                                eventExtra = (LiveConstants.EventExtra)lineEndExtra.getExtra().unpack(LiveConstants.EventExtra.class);
                                                MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "icon", eventExtra.getIcon());
                                              } else {
                                                LiveConstants.AudienceJoinFriendModeExtra audienceJoinFriendModeExtra;
                                                if (eventExtra.getExtra().is(LiveConstants.AudienceJoinFriendModeExtra.class)) {
                                                  audienceJoinFriendModeExtra = (LiveConstants.AudienceJoinFriendModeExtra)eventExtra.getExtra().unpack(LiveConstants.AudienceJoinFriendModeExtra.class);
                                                  MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "count", audienceJoinFriendModeExtra.getCount());
                                                } else {
                                                  LiveConstants.IgnoreAudienceVoiceUpExtra ignoreAudienceVoiceUpExtra;
                                                  if (audienceJoinFriendModeExtra.getExtra().is(LiveConstants.IgnoreAudienceVoiceUpExtra.class)) {
                                                    ignoreAudienceVoiceUpExtra = (LiveConstants.IgnoreAudienceVoiceUpExtra)audienceJoinFriendModeExtra.getExtra().unpack(LiveConstants.IgnoreAudienceVoiceUpExtra.class);
                                                    MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "count", ignoreAudienceVoiceUpExtra.getCount());
                                                    MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "uid", ignoreAudienceVoiceUpExtra.getUid());
                                                  } else {
                                                    LiveConstants.IgnoreAnchorVoiceUpInviteExtra ignoreAnchorVoiceUpInviteExtra;
                                                    if (ignoreAudienceVoiceUpExtra.getExtra().is(LiveConstants.IgnoreAnchorVoiceUpInviteExtra.class)) {
                                                      ignoreAnchorVoiceUpInviteExtra = (LiveConstants.IgnoreAnchorVoiceUpInviteExtra)ignoreAudienceVoiceUpExtra.getExtra().unpack(LiveConstants.IgnoreAnchorVoiceUpInviteExtra.class);
                                                      MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "count", ignoreAnchorVoiceUpInviteExtra.getCount());
                                                      MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "name", ignoreAnchorVoiceUpInviteExtra.getName());
                                                    } else {
                                                      LiveConstants.VoiceStatusExtra voiceStatusExtra;
                                                      if (ignoreAnchorVoiceUpInviteExtra.getExtra().is(LiveConstants.VoiceStatusExtra.class)) {
                                                        voiceStatusExtra = (LiveConstants.VoiceStatusExtra)ignoreAnchorVoiceUpInviteExtra.getExtra().unpack(LiveConstants.VoiceStatusExtra.class);
                                                        MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "uid", voiceStatusExtra.getUid());
                                                        MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "voice", voiceStatusExtra.getVoice());
                                                      } else {
                                                        LiveConstants.AnchorJoinFriendModeExtra anchorJoinFriendModeExtra;
                                                        if (voiceStatusExtra.getExtra().is(LiveConstants.AnchorJoinFriendModeExtra.class)) {
                                                          anchorJoinFriendModeExtra = (LiveConstants.AnchorJoinFriendModeExtra)voiceStatusExtra.getExtra().unpack(LiveConstants.AnchorJoinFriendModeExtra.class);
                                                          MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "count", anchorJoinFriendModeExtra.getCount());
                                                          MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "stream", anchorJoinFriendModeExtra.getStream());
                                                          ArrayList<HashMap<Object, Object>> arrayList = new ArrayList();
                                                          for (int i = 0; i < anchorJoinFriendModeExtra.getFansList().size(); i++) {
                                                            HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
                                                            if (anchorJoinFriendModeExtra.getFans(i).getUid() > 0)
                                                              MsgPackHelper.putMapValue(hashMap, "uid", anchorJoinFriendModeExtra.getFans(i).getUid()); 
                                                            MsgPackHelper.putMapValue(hashMap, "name", anchorJoinFriendModeExtra.getFans(i).getName());
                                                            MsgPackHelper.putMapValue(hashMap, "avatar", anchorJoinFriendModeExtra.getFans(i).getAvatar());
                                                            MsgPackHelper.putMapValue(hashMap, "voice", anchorJoinFriendModeExtra.getFans(i).getVoice());
                                                            MsgPackHelper.putMapValue(hashMap, "stream", anchorJoinFriendModeExtra.getFans(i).getStream());
                                                            arrayList.add(hashMap);
                                                          } 
                                                          ((ChattingModel)closeLiveExtra).msgMapExtra.put("fans", arrayList);
                                                        } else {
                                                          LiveConstants.FriendModeVoiceExtra friendModeVoiceExtra;
                                                          if (anchorJoinFriendModeExtra.getExtra().is(LiveConstants.FriendModeVoiceExtra.class)) {
                                                            friendModeVoiceExtra = (LiveConstants.FriendModeVoiceExtra)anchorJoinFriendModeExtra.getExtra().unpack(LiveConstants.FriendModeVoiceExtra.class);
                                                            MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "count", friendModeVoiceExtra.getCount());
                                                            MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "uid", friendModeVoiceExtra.getUid());
                                                            MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "name", friendModeVoiceExtra.getName());
                                                            MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "stream", friendModeVoiceExtra.getStream());
                                                            MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "conference_id", friendModeVoiceExtra.getConferenceId());
                                                            MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "conference_token", friendModeVoiceExtra.getConferenceToken());
                                                            MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "index", friendModeVoiceExtra.getIndex());
                                                            ArrayList<HashMap<Object, Object>> arrayList = new ArrayList();
                                                            for (int i = 0; i < friendModeVoiceExtra.getFansList().size(); i++) {
                                                              HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
                                                              if (friendModeVoiceExtra.getFans(i).getUid() > 0)
                                                                MsgPackHelper.putMapValue(hashMap, "uid", friendModeVoiceExtra.getFans(i).getUid()); 
                                                              MsgPackHelper.putMapValue(hashMap, "name", friendModeVoiceExtra.getFans(i).getName());
                                                              MsgPackHelper.putMapValue(hashMap, "avatar", friendModeVoiceExtra.getFans(i).getAvatar());
                                                              MsgPackHelper.putMapValue(hashMap, "voice", friendModeVoiceExtra.getFans(i).getVoice());
                                                              MsgPackHelper.putMapValue(hashMap, "stream", friendModeVoiceExtra.getFans(i).getStream());
                                                              arrayList.add(hashMap);
                                                            } 
                                                            ((ChattingModel)closeLiveExtra).msgMapExtra.put("fans", arrayList);
                                                          } else {
                                                            LiveConstants.SyncTopAudienceExtra syncTopAudienceExtra;
                                                            if (friendModeVoiceExtra.getExtra().is(LiveConstants.SyncTopAudienceExtra.class)) {
                                                              syncTopAudienceExtra = (LiveConstants.SyncTopAudienceExtra)friendModeVoiceExtra.getExtra().unpack(LiveConstants.SyncTopAudienceExtra.class);
                                                              ArrayList<HashMap<Object, Object>> arrayList = new ArrayList();
                                                              for (int i = 0; i < syncTopAudienceExtra.getTopsList().size(); i++) {
                                                                HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
                                                                MsgPackHelper.putMapValue(hashMap, "uid", ((LiveConstants.SyncTopAudienceExtra.TopAudience)syncTopAudienceExtra.getTopsList().get(i)).getUid());
                                                                MsgPackHelper.putMapValue(hashMap, "avatar", ((LiveConstants.SyncTopAudienceExtra.TopAudience)syncTopAudienceExtra.getTopsList().get(i)).getAvatar());
                                                                MsgPackHelper.putMapValue(hashMap, "vbadge", ((LiveConstants.SyncTopAudienceExtra.TopAudience)syncTopAudienceExtra.getTopsList().get(i)).getVbadgeValue());
                                                                arrayList.add(hashMap);
                                                              } 
                                                              ((ChattingModel)closeLiveExtra).msgMapExtra.put("tops", arrayList);
                                                            } else {
                                                              LiveConstants.H5BubbleExtra h5BubbleExtra;
                                                              if (syncTopAudienceExtra.getExtra().is(LiveConstants.H5BubbleExtra.class)) {
                                                                h5BubbleExtra = (LiveConstants.H5BubbleExtra)syncTopAudienceExtra.getExtra().unpack(LiveConstants.H5BubbleExtra.class);
                                                                MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "type", h5BubbleExtra.getType());
                                                                MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "icon", h5BubbleExtra.getIcon());
                                                                MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "url", h5BubbleExtra.getUrl());
                                                              } else {
                                                                LiveConstants.SyncExpExtra syncExpExtra;
                                                                if (h5BubbleExtra.getExtra().is(LiveConstants.SyncExpExtra.class)) {
                                                                  syncExpExtra = (LiveConstants.SyncExpExtra)h5BubbleExtra.getExtra().unpack(LiveConstants.SyncExpExtra.class);
                                                                  MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "level", syncExpExtra.getLevel());
                                                                  MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "exp", syncExpExtra.getExp());
                                                                  MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "gap_exp", syncExpExtra.getGapExp());
                                                                  MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "percent", syncExpExtra.getPercent());
                                                                  MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "next_level", syncExpExtra.getNextLevel());
                                                                } else {
                                                                  LiveConstants.AnchorUpgradeExtra anchorUpgradeExtra;
                                                                  if (syncExpExtra.getExtra().is(LiveConstants.AnchorUpgradeExtra.class)) {
                                                                    anchorUpgradeExtra = (LiveConstants.AnchorUpgradeExtra)syncExpExtra.getExtra().unpack(LiveConstants.AnchorUpgradeExtra.class);
                                                                    MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "level", anchorUpgradeExtra.getLevel());
                                                                    MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "resource", anchorUpgradeExtra.getResource());
                                                                  } else {
                                                                    LiveConstants.TagLocationExtra tagLocationExtra;
                                                                    if (anchorUpgradeExtra.getExtra().is(LiveConstants.TagLocationExtra.class)) {
                                                                      tagLocationExtra = (LiveConstants.TagLocationExtra)anchorUpgradeExtra.getExtra().unpack(LiveConstants.TagLocationExtra.class);
                                                                      MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "proportion_x", tagLocationExtra.getProportionX());
                                                                      MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "proportion_y", tagLocationExtra.getProportionY());
                                                                      MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "image", tagLocationExtra.getImage());
                                                                      MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "add", tagLocationExtra.getAdd());
                                                                    } else {
                                                                      LiveConstants.LotteryEventExtra lotteryEventExtra;
                                                                      if (tagLocationExtra.getExtra().is(LiveConstants.LotteryEventExtra.class)) {
                                                                        lotteryEventExtra = (LiveConstants.LotteryEventExtra)tagLocationExtra.getExtra().unpack(LiveConstants.LotteryEventExtra.class);
                                                                        MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "entrance_status", lotteryEventExtra.getEntranceStatus());
                                                                      } else {
                                                                        LiveConstants.MallEntranceExtra mallEntranceExtra;
                                                                        if (lotteryEventExtra.getExtra().is(LiveConstants.MallEntranceExtra.class)) {
                                                                          mallEntranceExtra = (LiveConstants.MallEntranceExtra)lotteryEventExtra.getExtra().unpack(LiveConstants.MallEntranceExtra.class);
                                                                          MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "status", mallEntranceExtra.getStatus());
                                                                        } else {
                                                                          LiveConstants.TopTrendRankExtra topTrendRankExtra;
                                                                          if (mallEntranceExtra.getExtra().is(LiveConstants.TopTrendRankExtra.class)) {
                                                                            topTrendRankExtra = (LiveConstants.TopTrendRankExtra)mallEntranceExtra.getExtra().unpack(LiveConstants.TopTrendRankExtra.class);
                                                                            MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "hot", topTrendRankExtra.getHot());
                                                                            MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "jump", topTrendRankExtra.getJump());
                                                                            MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "need_score", topTrendRankExtra.getNeedScore());
                                                                            MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "battle_rank", topTrendRankExtra.getBattleRank());
                                                                            MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "battle_catch", topTrendRankExtra.getBattleCatch());
                                                                          } else {
                                                                            LiveConstants.TaskProcess taskProcess;
                                                                            if (topTrendRankExtra.getExtra().is(LiveConstants.TaskProcess.class)) {
                                                                              taskProcess = (LiveConstants.TaskProcess)topTrendRankExtra.getExtra().unpack(LiveConstants.TaskProcess.class);
                                                                              ArrayList<String> arrayList = new ArrayList();
                                                                              for (int i = 0; i < taskProcess.getTaskListList().size(); i++)
                                                                                arrayList.add(taskProcess.getTaskList(i)); 
                                                                              ((ChattingModel)closeLiveExtra).msgMapExtra.put("task_list", arrayList);
                                                                            } else {
                                                                              LiveConstants.FanClub fanClub;
                                                                              if (taskProcess.getExtra().is(LiveConstants.FanClub.class)) {
                                                                                fanClub = (LiveConstants.FanClub)taskProcess.getExtra().unpack(LiveConstants.FanClub.class);
                                                                                MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "level", fanClub.getLevel());
                                                                              } else {
                                                                                LiveConstants.LoveJoinInfo loveJoinInfo;
                                                                                if (fanClub.getExtra().is(LiveConstants.LoveJoinInfo.class)) {
                                                                                  loveJoinInfo = (LiveConstants.LoveJoinInfo)fanClub.getExtra().unpack(LiveConstants.LoveJoinInfo.class);
                                                                                  MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "chooser_count", loveJoinInfo.getChooserCount());
                                                                                  MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "chosen_count", loveJoinInfo.getChosenCount());
                                                                                } else if (loveJoinInfo.getExtra().is(LiveConstants.LoveFan.class)) {
                                                                                  ((ChattingModel)closeLiveExtra).msgMapExtra = a((LiveConstants.LoveFan)loveJoinInfo.getExtra().unpack(LiveConstants.LoveFan.class));
                                                                                } else {
                                                                                  LiveConstants.LoveJoinAction loveJoinAction;
                                                                                  if (loveJoinInfo.getExtra().is(LiveConstants.LoveJoinAction.class)) {
                                                                                    long l;
                                                                                    loveJoinAction = (LiveConstants.LoveJoinAction)loveJoinInfo.getExtra().unpack(LiveConstants.LoveJoinAction.class);
                                                                                    MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "stream", loveJoinAction.getStream());
                                                                                    Map map = ((ChattingModel)closeLiveExtra).msgMapExtra;
                                                                                    if (loveJoinAction.getIsHideDistance()) {
                                                                                      l = 1L;
                                                                                    } else {
                                                                                      l = 0L;
                                                                                    } 
                                                                                    MsgPackHelper.putMapValue(map, "is_hide_distance", l);
                                                                                    MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "index", loveJoinAction.getIndex());
                                                                                    MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "type", loveJoinAction.getType());
                                                                                    MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "uid", loveJoinAction.getUid());
                                                                                    MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "name", loveJoinAction.getName());
                                                                                    MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "conference_id", loveJoinAction.getConferenceId());
                                                                                    ArrayList<Map<String, Object>> arrayList = new ArrayList();
                                                                                    for (int i = 0; i < loveJoinAction.getFansList().size(); i++)
                                                                                      arrayList.add(a(loveJoinAction.getFansList().get(i))); 
                                                                                    ((ChattingModel)closeLiveExtra).msgMapExtra.put("fans", arrayList);
                                                                                  } else {
                                                                                    LiveConstants.LoveStatus loveStatus;
                                                                                    if (loveJoinAction.getExtra().is(LiveConstants.LoveStatus.class)) {
                                                                                      loveStatus = (LiveConstants.LoveStatus)loveJoinAction.getExtra().unpack(LiveConstants.LoveStatus.class);
                                                                                      MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "uid", loveStatus.getUid());
                                                                                    } else {
                                                                                      LiveConstants.LoveSuccess loveSuccess;
                                                                                      if (loveStatus.getExtra().is(LiveConstants.LoveSuccess.class)) {
                                                                                        loveSuccess = (LiveConstants.LoveSuccess)loveStatus.getExtra().unpack(LiveConstants.LoveSuccess.class);
                                                                                        MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "anime_url", loveSuccess.getAnimeUrl());
                                                                                        ((ChattingModel)closeLiveExtra).msgMapExtra.put("chosen", a(loveSuccess.getChosen()));
                                                                                        ((ChattingModel)closeLiveExtra).msgMapExtra.put("chooser", a(loveSuccess.getChooser()));
                                                                                      } else {
                                                                                        LiveConstants.LoveJoinStatus loveJoinStatus;
                                                                                        if (loveSuccess.getExtra().is(LiveConstants.LoveJoinStatus.class)) {
                                                                                          loveJoinStatus = (LiveConstants.LoveJoinStatus)loveSuccess.getExtra().unpack(LiveConstants.LoveJoinStatus.class);
                                                                                          MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "uid", loveJoinStatus.getUid());
                                                                                          MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "type", loveJoinStatus.getType());
                                                                                        } else {
                                                                                          LiveConstants.LoveOpenStatus loveOpenStatus;
                                                                                          if (loveJoinStatus.getExtra().is(LiveConstants.LoveOpenStatus.class)) {
                                                                                            loveOpenStatus = (LiveConstants.LoveOpenStatus)loveJoinStatus.getExtra().unpack(LiveConstants.LoveOpenStatus.class);
                                                                                            MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "uid", loveOpenStatus.getUid());
                                                                                            MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "fan", loveOpenStatus.getFan());
                                                                                          } else {
                                                                                            LiveConstants.Text text;
                                                                                            if (loveOpenStatus.getExtra().is(LiveConstants.Text.class)) {
                                                                                              long l;
                                                                                              text = (LiveConstants.Text)loveOpenStatus.getExtra().unpack(LiveConstants.Text.class);
                                                                                              MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "fan_club_name", text.getFanClubName());
                                                                                              MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "fans_status", text.getFansStatusValue());
                                                                                              Map map = ((ChattingModel)closeLiveExtra).msgMapExtra;
                                                                                              if (text.getInFanClub()) {
                                                                                                l = 1L;
                                                                                              } else {
                                                                                                l = 0L;
                                                                                              } 
                                                                                              MsgPackHelper.putMapValue(map, "in_fan_club", l);
                                                                                              MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "fan_club_level", text.getFanClubLevel());
                                                                                              MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "liang_id", text.getLiangId());
                                                                                              MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "liang_type", text.getLiangTypeValue());
                                                                                            } else {
                                                                                              LiveConstants.Barrage barrage;
                                                                                              if (text.getExtra().is(LiveConstants.Barrage.class)) {
                                                                                                long l;
                                                                                                barrage = (LiveConstants.Barrage)text.getExtra().unpack(LiveConstants.Barrage.class);
                                                                                                MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "fan_club_name", barrage.getFanClubName());
                                                                                                MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "fans_status", barrage.getFansStatusValue());
                                                                                                Map map = ((ChattingModel)closeLiveExtra).msgMapExtra;
                                                                                                if (barrage.getInFanClub()) {
                                                                                                  l = 1L;
                                                                                                } else {
                                                                                                  l = 0L;
                                                                                                } 
                                                                                                MsgPackHelper.putMapValue(map, "in_fan_club", l);
                                                                                                MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "fan_club_level", barrage.getFanClubLevel());
                                                                                                MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "liang_id", barrage.getLiangId());
                                                                                                MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "liang_type", barrage.getLiangTypeValue());
                                                                                              } else {
                                                                                                LiveConstants.OfficialRecommend officialRecommend;
                                                                                                if (barrage.getExtra().is(LiveConstants.OfficialRecommend.class)) {
                                                                                                  officialRecommend = (LiveConstants.OfficialRecommend)barrage.getExtra().unpack(LiveConstants.OfficialRecommend.class);
                                                                                                  MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "end_time", officialRecommend.getEndTime());
                                                                                                  MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "icon", officialRecommend.getIcon());
                                                                                                  ((ChattingModel)closeLiveExtra).msgMapExtra.put("timeout", Boolean.valueOf(officialRecommend.getTimeout()));
                                                                                                  ((ChattingModel)closeLiveExtra).msgMapExtra.put("icon_show", Boolean.valueOf(officialRecommend.getIconShow()));
                                                                                                } else {
                                                                                                  LiveConstants.Like like;
                                                                                                  if (officialRecommend.getExtra().is(LiveConstants.Like.class)) {
                                                                                                    like = (LiveConstants.Like)officialRecommend.getExtra().unpack(LiveConstants.Like.class);
                                                                                                    MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "liang_id", like.getLiangId());
                                                                                                    MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "liang_type", like.getLiangTypeValue());
                                                                                                  } else {
                                                                                                    LiveConstants.Follow follow;
                                                                                                    if (like.getExtra().is(LiveConstants.Follow.class)) {
                                                                                                      follow = (LiveConstants.Follow)like.getExtra().unpack(LiveConstants.Follow.class);
                                                                                                      MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "liang_id", follow.getLiangId());
                                                                                                      MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "liang_type", follow.getLiangTypeValue());
                                                                                                    } else {
                                                                                                      ArrayList<LiveActivityItemModel> arrayList;
                                                                                                      if (follow.getExtra().is(LiveConstants.LiveActivity.class)) {
                                                                                                        LiveConstants.LiveActivity liveActivity = (LiveConstants.LiveActivity)follow.getExtra().unpack(LiveConstants.LiveActivity.class);
                                                                                                        if (liveActivity != null && liveActivity.getActivityList() != null) {
                                                                                                          arrayList = new ArrayList();
                                                                                                          for (LiveConstants.LiveActivity.Activity activity : liveActivity.getActivityList()) {
                                                                                                            LiveActivityItemModel liveActivityItemModel = new LiveActivityItemModel();
                                                                                                            liveActivityItemModel.id = String.valueOf(activity.getId());
                                                                                                            liveActivityItemModel.icon = activity.getIcon();
                                                                                                            liveActivityItemModel.url = activity.getUrl();
                                                                                                            liveActivityItemModel.rank = activity.getRank();
                                                                                                            liveActivityItemModel.page = activity.getPageValue();
                                                                                                            arrayList.add(liveActivityItemModel);
                                                                                                          } 
                                                                                                          ((ChattingModel)closeLiveExtra).msgMapExtra.put("activity", arrayList);
                                                                                                        } 
                                                                                                      } else if (arrayList.getExtra().is(LiveConstants.PkBuff.class)) {
                                                                                                        LiveConstants.PkBuff pkBuff = (LiveConstants.PkBuff)arrayList.getExtra().unpack(LiveConstants.PkBuff.class);
                                                                                                        MsgPackHelper.putMapValue(((ChattingModel)closeLiveExtra).msgMapExtra, "buff_countdown", pkBuff.getBuffCountdown());
                                                                                                      } 
                                                                                                    } 
                                                                                                  } 
                                                                                                } 
                                                                                              } 
                                                                                            } 
                                                                                          } 
                                                                                        } 
                                                                                      } 
                                                                                    } 
                                                                                  } 
                                                                                } 
                                                                              } 
                                                                            } 
                                                                          } 
                                                                        } 
                                                                      } 
                                                                    } 
                                                                  } 
                                                                } 
                                                              } 
                                                            } 
                                                          } 
                                                        } 
                                                      } 
                                                    } 
                                                  } 
                                                } 
                                              } 
                                            } 
                                          } 
                                        } 
                                      } 
                                    } 
                                  } 
                                } 
                              } 
                            } 
                          } 
                        } 
                      } 
                    } 
                  } 
                } 
              } 
            } 
          } 
        } 
      } 
    } 
    a((ChattingModel)closeLiveExtra);
  }
  
  private void c(String paramString) {}
  
  private void n() {
    a(g());
    LiveIM.a(LiveChatOuterClass.LiveLikeRequest.newBuilder().setLiveId(LiveRoomManager.a().c()).setCount(1).setHasFirstLike(true).build(), new -$$Lambda$GrpcMsgSender$Nzo1OhV41j9kYtrVvrwUEMh0LFc(this));
  }
  
  private void o() {
    if (TextUtils.isEmpty(this.e))
      this.e = LocaleUtils.b(); 
    LiveIM.a(AppInfo.g, "android_china", this.e, AppInfo.c);
  }
  
  public void a() {
    this.c = LiveRoomInfo.a().l();
    this.d = LiveRoomInfo.a().p();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("init: mLiveImHost=");
    stringBuilder.append(this.c);
    stringBuilder.append("\nmAccessToken=");
    stringBuilder.append(this.d);
    LogUtils.c("GrpcMsgSender", stringBuilder.toString());
    LiveIM.a(AppInfo.d(), this.c, HappyDnsUtils.d());
    LiveIM.b(this.g);
    LiveIM.a(this.g);
    LiveIM.a(this.d);
  }
  
  public void a(long paramLong) {
    if (!this.b)
      b(); 
  }
  
  public void a(long paramLong, LiveChatInfoListener paramLiveChatInfoListener) {
    synchronized (this.f) {
      Set<LiveChatInfoListener> set2 = this.f.get(String.valueOf(paramLong));
      Set<LiveChatInfoListener> set1 = set2;
      if (set2 == null) {
        set1 = new HashSet();
        this.f.put(String.valueOf(paramLong), set1);
      } 
      set1.add(paramLiveChatInfoListener);
      return;
    } 
  }
  
  public void a(String paramString) {
    a(a((short)1, paramString));
    LiveIM.a(LiveChatOuterClass.LiveMsgRequest.newBuilder().setLiveId(LiveRoomManager.a().c()).setContents(paramString).build(), new -$$Lambda$GrpcMsgSender$NFLWgdWHd2J3eHueji89RWBKzz0(this));
  }
  
  public void a(short paramShort, long paramLong, LiveChatInfoListener paramLiveChatInfoListener) {
    a(paramLong, paramLiveChatInfoListener);
  }
  
  public void a(boolean paramBoolean) {
    LiveIM.a(LiveChatOuterClass.LiveLikeRequest.newBuilder().setLiveId(LiveRoomManager.a().c()).setCount(1).setHasFirstLike(paramBoolean).build(), new -$$Lambda$GrpcMsgSender$_aqvHetsiuhYMaWMZohyMhXKlok(this));
    if (paramBoolean)
      n(); 
  }
  
  public void b() {
    if (this.b) {
      if (!TextUtils.equals(this.c, LiveRoomInfo.a().l()) || !TextUtils.equals(this.d, LiveRoomInfo.a().p()))
        c(); 
      AppInfo.n().postDelayed(new Runnable(this) {
            public void run() {
              this.a.d();
            }
          },  100L);
    } else {
      d();
    } 
    if (this.b && !TextUtils.equals(this.e, LocaleUtils.b()))
      o(); 
  }
  
  public void b(long paramLong, LiveChatInfoListener paramLiveChatInfoListener) {
    synchronized (this.f) {
      Set set = this.f.get(String.valueOf(paramLong));
      if (set != null)
        set.remove(paramLiveChatInfoListener); 
      return;
    } 
  }
  
  public void b(short paramShort, long paramLong, LiveChatInfoListener paramLiveChatInfoListener) {
    b(paramLong, paramLiveChatInfoListener);
  }
  
  public void c() {
    if (this.b)
      LiveIM.c(); 
  }
  
  public void d() {
    if (this.b)
      return; 
    this.b = true;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("connect live im @");
    stringBuilder.append(Thread.currentThread().getName());
    LogUtils.c("GrpcMsgSender", stringBuilder.toString());
    this.c = LiveRoomInfo.a().l();
    this.d = LiveRoomInfo.a().p();
    if (!LiveIM.a()) {
      LiveIM.a(AppInfo.d(), this.c, HappyDnsUtils.d());
      LiveIM.a(false);
      LiveIM.a(this.g);
    } 
    LiveIM.a(this.d);
    LiveIM.b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\msg\GrpcMsgSender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */