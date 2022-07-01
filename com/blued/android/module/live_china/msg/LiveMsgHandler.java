package com.blued.android.module.live_china.msg;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.blued.android.chat.data.ProfileData;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.utils.MsgPackHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live_china.common.ZegoCommonHelper;
import com.blued.android.module.live_china.fragment.LiveBaseFragment;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.GrabBoxModel;
import com.blued.android.module.live_china.model.LiveActivityModel;
import com.blued.android.module.live_china.model.LiveFriendModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveHornModel;
import com.blued.android.module.live_china.model.LiveLiangModel;
import com.blued.android.module.live_china.model.LiveMakeLoverFansModel;
import com.blued.android.module.live_china.model.LiveMakeLoverMatchModel;
import com.blued.android.module.live_china.model.LivePKProgressModel;
import com.blued.android.module.live_china.model.LivePKResultModel;
import com.blued.android.module.live_china.model.LiveRewardModel;
import com.blued.android.module.live_china.model.RankingExtra;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.LiveRoomUtils;
import com.blued.android.module.live_china.utils.LiveUtils;
import com.blued.android.module.live_china.view.LivePopUpDialog;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.jeremyliao.liveeventbus.core.Observable;
import java.util.List;
import java.util.Map;

public abstract class LiveMsgHandler {
  protected LiveBaseFragment d;
  
  protected boolean e = false;
  
  public LiveMsgHandler(LiveBaseFragment paramLiveBaseFragment) {
    this.d = paramLiveBaseFragment;
  }
  
  protected abstract void a(int paramInt1, int paramInt2, int paramInt3, float paramFloat);
  
  protected abstract void a(long paramLong, int paramInt);
  
  public void a(ChattingModel paramChattingModel) {
    LiveActivityModel liveActivityModel;
    LiveMakeLoverMatchModel liveMakeLoverMatchModel;
    LiveMakeLoverFansModel liveMakeLoverFansModel;
    RankingExtra rankingExtra;
    Observable observable;
    Map map;
    List<ProfileData> list1;
    LiveFriendModel liveFriendModel;
    LiveMsgSendManager liveMsgSendManager;
    String str2;
    LivePKResultModel livePKResultModel;
    String str1;
    List list;
    LiveGiftModel liveGiftModel;
    float f1;
    float f2;
    StringBuilder stringBuilder2;
    String str3;
    StringBuilder stringBuilder1;
    LiveHornModel liveHornModel;
    if (paramChattingModel == null)
      return; 
    short s = paramChattingModel.msgType;
    int i = 0;
    int j = 0;
    boolean bool = false;
    switch (s) {
      default:
        return;
      case 213:
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("213直播间资源位:");
        stringBuilder2.append(paramChattingModel.getMsgExtra());
        Log.i("==xpp", stringBuilder2.toString());
        liveActivityModel = (LiveActivityModel)AppInfo.f().fromJson(paramChattingModel.getMsgExtra(), LiveActivityModel.class);
        if (liveActivityModel != null && LiveRoomManager.a().h() != null) {
          (LiveRoomManager.a().h()).activity = liveActivityModel.activity;
          this.d.M_();
          return;
        } 
        break;
      case 183:
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("183(相亲成功):");
        stringBuilder2.append(liveActivityModel.getMsgExtra());
        Log.i("==makelover==", stringBuilder2.toString());
        liveMakeLoverMatchModel = (LiveMakeLoverMatchModel)AppInfo.f().fromJson(liveActivityModel.getMsgExtra(), LiveMakeLoverMatchModel.class);
        if (liveMakeLoverMatchModel != null && liveMakeLoverMatchModel.chooser != null && liveMakeLoverMatchModel.chosen != null) {
          this.d.a(liveMakeLoverMatchModel.chosen, liveMakeLoverMatchModel.chooser, liveMakeLoverMatchModel.anime_url);
          return;
        } 
        break;
      case 182:
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("182(嘉宾灭灯):");
        stringBuilder2.append(liveMakeLoverMatchModel.getMsgExtra());
        Log.i("==makelover==", stringBuilder2.toString());
        liveMakeLoverFansModel = (LiveMakeLoverFansModel)AppInfo.f().fromJson(liveMakeLoverMatchModel.getMsgExtra(), LiveMakeLoverFansModel.class);
        this.d.c(liveMakeLoverFansModel.uid);
        return;
      case 167:
        rankingExtra = (RankingExtra)AppInfo.f().fromJson(liveMakeLoverFansModel.getMsgExtra(), RankingExtra.class);
        LiveEventBus.get("live_ranking_msg").post(rankingExtra);
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("收到167消息：hot=");
        stringBuilder2.append(rankingExtra.hot);
        stringBuilder2.append(", jump=");
        stringBuilder2.append(rankingExtra.jump);
        stringBuilder2.append(", need_score=");
        stringBuilder2.append(rankingExtra.need_score);
        Log.v("ranking", stringBuilder2.toString());
        return;
      case 163:
        i = MsgPackHelper.getIntValue(((ChattingModel)rankingExtra).msgMapExtra, "entrance_status");
        observable = LiveEventBus.get("live_luck_turning_btn");
        if (i == 1)
          bool = true; 
        observable.post(Boolean.valueOf(bool));
        return;
      case 154:
        map = ((ChattingModel)observable).msgMapExtra;
        i = MsgPackHelper.getIntValue(map, "level");
        j = MsgPackHelper.getIntValue(map, "next_level");
        f1 = MsgPackHelper.getFloatValue(map, "percent");
        f2 = MsgPackHelper.getFloatValue(map, "gap_exp");
        a(i, j, (int)f1, f2);
        return;
      case 140:
        list1 = ProfileData.parseProfileList(MsgPackHelper.getListValue(((ChattingModel)map).msgMapExtra, "tops"));
        if (list1 != null) {
          if (LiveRoomManager.a().h() == null)
            return; 
          if (list1.size() > 0)
            while (i < list1.size()) {
              ProfileData profileData = list1.get(i);
              profileData.liveViewerRank = ++i;
            }  
          LiveRoomManager.a().a(list1);
          i();
          return;
        } 
        return;
      case 135:
        liveFriendModel = (LiveFriendModel)AppInfo.f().fromJson(list1.getMsgExtra(), LiveFriendModel.class);
        if (liveFriendModel != null) {
          if (liveFriendModel.fans != null) {
            for (i = j; i < liveFriendModel.fans.size(); i++) {
              LiveMsgSendManager liveMsgSendManager1 = LiveMsgSendManager.a();
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("直播间下麦:");
              stringBuilder.append(i);
              stringBuilder.append("号uid：");
              stringBuilder.append(((LiveFriendModel)liveFriendModel.fans.get(i)).uid);
              stringBuilder.append("name:");
              stringBuilder.append(((LiveFriendModel)liveFriendModel.fans.get(i)).name);
              liveMsgSendManager1.b(stringBuilder.toString());
            } 
            this.d.b_(liveFriendModel.fans);
          } 
          ZegoCommonHelper.b().c().stopPlayingStream(liveFriendModel.stream);
          b(liveFriendModel);
          return;
        } 
        break;
      case 133:
        this.d.y();
        this.d.q.d();
        LiveMsgSendManager.a().b("主播退出交友模式");
        h();
        return;
      case 130:
        i = MsgPackHelper.getIntValue(((ChattingModel)liveFriendModel).msgMapExtra, "count");
        this.d.q.b(i);
        return;
      case 127:
        i = MsgPackHelper.getIntValue(((ChattingModel)liveFriendModel).msgMapExtra, "count");
        this.d.q.b(i);
        liveMsgSendManager = LiveMsgSendManager.a();
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("观众申请、撤回申请:");
        stringBuilder2.append(i);
        liveMsgSendManager.b(stringBuilder2.toString());
        return;
      case 118:
        Logger.a("pk", new Object[] { "收到pk活动消息" });
        str3 = MsgPackHelper.getStringValue(((ChattingModel)liveMsgSendManager).msgMapExtra, "icon");
        str2 = MsgPackHelper.getStringValue(((ChattingModel)liveMsgSendManager).msgMapExtra, "link");
        this.d.a(str3, str2);
        return;
      case 117:
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("MT_LIVE_PK_PROGRESS:");
        stringBuilder1.append(str2.getMsgExtra());
        Log.i("==pk==", stringBuilder1.toString());
        if (!this.d.B()) {
          LiveRoomUtils.a((IRequestHost)this.d.w_(), "1");
          return;
        } 
        try {
          a((LivePKProgressModel)AppInfo.f().fromJson(str2.getMsgExtra(), LivePKProgressModel.class));
          return;
        } catch (Exception exception) {
          exception.printStackTrace();
          return;
        } 
      case 116:
        livePKResultModel = (LivePKResultModel)AppInfo.f().fromJson(exception.getMsgExtra(), LivePKResultModel.class);
        LiveMsgSendManager.a().b("收到PK结束消息");
        a(livePKResultModel);
        return;
      case 115:
        Logger.a("pk", new Object[] { "收到PK开始消息" });
        if (this.d.B())
          return; 
        a((LiveFriendModel)AppInfo.f().fromJson(livePKResultModel.getMsgExtra(), LiveFriendModel.class));
        return;
      case 92:
        if (((ChattingModel)livePKResultModel).msgMapExtra != null) {
          String str4 = MsgPackHelper.getStringValue(((ChattingModel)livePKResultModel).msgMapExtra, "hongbao_id");
          long l1 = MsgPackHelper.getLongValue(((ChattingModel)livePKResultModel).msgMapExtra, "start_second");
          long l2 = MsgPackHelper.getLongValue(((ChattingModel)livePKResultModel).msgMapExtra, "end_second");
          i = MsgPackHelper.getIntValue(((ChattingModel)livePKResultModel).msgMapExtra, "status");
          String str5 = MsgPackHelper.getStringValue(((ChattingModel)livePKResultModel).msgMapExtra, "size");
          double d = MsgPackHelper.getDoubleValue(((ChattingModel)livePKResultModel).msgMapExtra, "beans");
          j = MsgPackHelper.getIntValue(((ChattingModel)livePKResultModel).msgMapExtra, "is_anim");
          long l3 = MsgPackHelper.getIntValue(((ChattingModel)livePKResultModel).msgMapExtra, "remaining_millisecond");
          String str6 = MsgPackHelper.getStringValue(((ChattingModel)livePKResultModel).msgMapExtra, "condition");
          str1 = MsgPackHelper.getStringValue(((ChattingModel)livePKResultModel).msgMapExtra, "pwd");
          if (l1 < l2) {
            a(new LiveRewardModel(str4, l1, l2, i, str5, d, j, l3, str6, str1));
            return;
          } 
        } 
        break;
      case 60:
        list = GrabBoxModel.parseGrabBoxMap(MsgPackHelper.getListValue(((ChattingModel)str1).msgMapExtra, "boxes"));
        this.d.b(list);
        return;
      case 40:
        liveHornModel = (LiveHornModel)AppInfo.f().fromJson(list.getMsgExtra(), LiveHornModel.class);
        liveHornModel.content = ((ChattingModel)list).msgContent;
        Logger.a("rrb", new Object[] { "喇叭消息 = ", liveHornModel.gift_apng });
        list = null;
        if (!TextUtils.isEmpty(liveHornModel.gift_apng) || !TextUtils.isEmpty(liveHornModel.gift_mp4)) {
          LiveGiftModel liveGiftModel1 = new LiveGiftModel();
          if (!TextUtils.isEmpty(liveHornModel.gift_apng))
            if (liveHornModel.gift_apng.endsWith(".gif")) {
              liveGiftModel1.images_gif = liveHornModel.gift_apng;
            } else {
              liveGiftModel1.images_apng2 = liveHornModel.gift_apng;
            }  
          liveGiftModel = liveGiftModel1;
          if (!TextUtils.isEmpty(liveHornModel.gift_mp4)) {
            liveGiftModel1.images_mp4 = liveHornModel.gift_mp4;
            liveGiftModel = liveGiftModel1;
          } 
        } 
        a(liveHornModel, liveGiftModel);
        return;
      case 38:
        this.d.d(((ChattingModel)liveGiftModel).msgContent);
        return;
      case 34:
        if (!TextUtils.isEmpty(((ChattingModel)liveGiftModel).msgContent)) {
          LivePopUpDialog.a((Context)this.d.getActivity(), ((ChattingModel)liveGiftModel).msgContent);
          return;
        } 
        break;
      case 31:
        this.d.a_(((ChattingModel)liveGiftModel).fromRichLevel);
        return;
      case 28:
        if (LiveRoomManager.a().b() != ((ChattingModel)liveGiftModel).sessionId)
          return; 
        LiveRoomUtils.a(((ChattingModel)liveGiftModel).fromId, MsgPackHelper.getIntValue(((ChattingModel)liveGiftModel).msgMapExtra, "realtime_count", LiveRoomManager.a().o()));
        return;
      case 27:
        if (LiveRoomManager.a().h() != null) {
          if (LiveRoomManager.a().b() != ((ChattingModel)liveGiftModel).sessionId)
            return; 
          ProfileData profileData = new ProfileData();
          profileData.uid = ((ChattingModel)liveGiftModel).fromId;
          profileData.name = ((ChattingModel)liveGiftModel).fromNickName;
          profileData.avatar = ((ChattingModel)liveGiftModel).fromAvatar;
          profileData.vBadge = ((ChattingModel)liveGiftModel).fromVBadge;
          profileData.richLevel = ((ChattingModel)liveGiftModel).fromRichLevel;
          LiveLiangModel liveLiangModel = LiveUtils.b((ChattingModel)liveGiftModel);
          if (liveLiangModel != null) {
            profileData.liangType = liveLiangModel.liang_type;
            profileData.liangId = liveLiangModel.liang_id;
          } 
          i = LiveRoomManager.a().o();
          LiveRoomUtils.a(profileData, MsgPackHelper.getIntValue(((ChattingModel)liveGiftModel).msgMapExtra, "realtime_count", i));
        } 
        break;
      case 36:
        break;
    } 
  }
  
  protected abstract void a(LiveFriendModel paramLiveFriendModel);
  
  protected abstract void a(LiveHornModel paramLiveHornModel, LiveGiftModel paramLiveGiftModel);
  
  protected abstract void a(LivePKProgressModel paramLivePKProgressModel);
  
  protected abstract void a(LivePKResultModel paramLivePKResultModel);
  
  protected abstract void a(LiveRewardModel paramLiveRewardModel);
  
  protected abstract void b(LiveFriendModel paramLiveFriendModel);
  
  public void c(LiveFriendModel paramLiveFriendModel) {}
  
  protected void h() {}
  
  protected abstract void i();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\msg\LiveMsgHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */