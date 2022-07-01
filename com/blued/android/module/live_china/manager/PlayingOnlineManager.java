package com.blued.android.module.live_china.manager;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import com.blued.android.chat.data.EntranceData;
import com.blued.android.chat.data.JoinLiveResult;
import com.blued.android.chat.data.LiveChatInitData;
import com.blued.android.chat.data.ProfileData;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.utils.ChatHelper;
import com.blued.android.chat.utils.MsgPackHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.common.ZegoCommonHelper;
import com.blued.android.module.live_china.fragment.LiveBaseFragment;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveFansLevelUpModel;
import com.blued.android.module.live_china.model.LiveFriendModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveHistoryModel;
import com.blued.android.module.live_china.model.LiveHornModel;
import com.blued.android.module.live_china.model.LiveMakeLoverFansModel;
import com.blued.android.module.live_china.model.LiveMakeLoverModel;
import com.blued.android.module.live_china.model.LivePKDoubleModel;
import com.blued.android.module.live_china.model.LivePKPlayerModel;
import com.blued.android.module.live_china.model.LivePKProgressModel;
import com.blued.android.module.live_china.model.LivePKResultModel;
import com.blued.android.module.live_china.model.LiveRewardModel;
import com.blued.android.module.live_china.model.LiveRoomCloseReason;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.model.LiveRoomUserModel;
import com.blued.android.module.live_china.model.LiveTaskModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.msg.LiveMsgHandler;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.observer.LiveFansObserver;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveRelationshipObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomUtils;
import com.blued.android.module.live_china.utils.log.InstantLog;
import com.blued.android.module.live_china.utils.log.model.InstantLogBody;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.LiveMakeFriendStartView;
import com.blued.das.live.LiveProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.jeremyliao.liveeventbus.core.Observable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class PlayingOnlineManager extends LiveMsgHandler implements LiveFloatManager.OnMediaPlayerConnectListener {
  public int a = 0;
  
  public long b;
  
  public String c;
  
  private Activity f;
  
  private short g = 4;
  
  private long h;
  
  private String i;
  
  private int j;
  
  private PlayingOnliveFragment k;
  
  private FrameLayout l;
  
  private StartPKTask m;
  
  private boolean n = false;
  
  private boolean o = false;
  
  private boolean p;
  
  public PlayingOnlineManager(PlayingOnliveFragment paramPlayingOnliveFragment, boolean paramBoolean, short paramShort, long paramLong, String paramString1, int paramInt, FrameLayout paramFrameLayout, String paramString2) {
    super((LiveBaseFragment)paramPlayingOnliveFragment);
    this.f = (Activity)paramPlayingOnliveFragment.getActivity();
    this.g = paramShort;
    this.h = paramLong;
    this.k = paramPlayingOnliveFragment;
    this.i = paramString1;
    this.j = paramInt;
    this.l = paramFrameLayout;
    LiveFloatManager.a().a(this);
    if (paramBoolean) {
      if (LiveFloatManager.a().t()) {
        this.k.z.setVisibility(0);
        this.k.a(8, false);
      } else {
        if (LiveFloatManager.a().u())
          LiveFloatManager.a().c(); 
        this.k.a(0, true);
        this.k.z.setVisibility(0);
      } 
      if ((LiveFloatManager.a()).g == null) {
        a(2);
        return;
      } 
    } else {
      EventTrackLive.a(LiveProtos.Event.LIVE_ENTER_SUCCESS, LiveRoomManager.a().c(), LiveRoomManager.a().e(), this.k.ca, this.k.bZ, this.k.cb);
      this.k.a(0, true);
      this.k.z.setVisibility(0);
      LiveFloatManager.a().a(this.g, this.h, this.i, this.j, paramString2);
      Logger.a("rb", new Object[] { "mSessionId = ", Long.valueOf(this.h), "--", Long.valueOf(LiveFloatManager.a().v()) });
      LiveFloatManager.a().a(this.g, this.h, this.i);
    } 
  }
  
  public static void a(IRequestHost paramIRequestHost, long paramLong) {
    LiveRoomHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<LiveHistoryModel>>(paramIRequestHost, paramLong) {
          protected void a(BluedEntityA<LiveHistoryModel> param1BluedEntityA) {
            StringBuilder stringBuilder;
            if (LiveRoomManager.a().b() != this.a) {
              stringBuilder = new StringBuilder();
              stringBuilder.append("getHistoryMsg return:");
              stringBuilder.append(LiveRoomManager.a().b());
              Log.i("xpm", stringBuilder.toString());
              LiveRoomManager.a().v();
              return;
            } 
            if (stringBuilder != null && ((BluedEntityA)stringBuilder).data != null && ((BluedEntityA)stringBuilder).data.size() > 0) {
              ArrayList<ChattingModel> arrayList = new ArrayList();
              for (LiveHistoryModel liveHistoryModel : ((BluedEntityA)stringBuilder).data) {
                ChattingModel chattingModel = new ChattingModel();
                chattingModel.fromId = liveHistoryModel.from_id;
                chattingModel.fromNickName = liveHistoryModel.from_nick_name;
                chattingModel.msgContent = liveHistoryModel.msg_content;
                chattingModel.fromRichLevel = liveHistoryModel.from_rich_level;
                chattingModel.msgType = 1;
                chattingModel.fromLiveManager = liveHistoryModel.from_live_manager;
                chattingModel.msgTimestamp = liveHistoryModel.msg_time * 1000L;
                arrayList.add(chattingModel);
              } 
              LiveRoomManager.a().b(arrayList);
              return;
            } 
            LiveRoomManager.a().v();
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            LiveRoomManager.a().v();
            return super.onUIFailure(param1Int, param1String);
          }
        }paramLong);
  }
  
  private void a(LiveFriendModel paramLiveFriendModel, int paramInt) {
    if (this.k.F != null) {
      this.k.F.b(paramLiveFriendModel.stream);
      if (paramInt != 0) {
        if (paramInt != 1) {
          if (paramInt != 2)
            return; 
          if (paramLiveFriendModel.fans.size() > 1)
            this.k.F.a(((LiveFriendModel)paramLiveFriendModel.fans.get(0)).stream, 1); 
          if (paramLiveFriendModel.fans.size() > 2) {
            this.k.F.a(((LiveFriendModel)paramLiveFriendModel.fans.get(1)).stream, 2);
            return;
          } 
        } else {
          if (paramLiveFriendModel.fans.size() > 1)
            this.k.F.a(((LiveFriendModel)paramLiveFriendModel.fans.get(0)).stream, 1); 
          if (paramLiveFriendModel.fans.size() > 2) {
            this.k.F.a(((LiveFriendModel)paramLiveFriendModel.fans.get(2)).stream, 2);
            return;
          } 
        } 
      } else {
        if (paramLiveFriendModel.fans.size() > 1)
          this.k.F.a(((LiveFriendModel)paramLiveFriendModel.fans.get(1)).stream, 1); 
        if (paramLiveFriendModel.fans.size() > 2)
          this.k.F.a(((LiveFriendModel)paramLiveFriendModel.fans.get(2)).stream, 2); 
      } 
    } 
  }
  
  private void a(LiveMakeLoverModel paramLiveMakeLoverModel, int paramInt) {
    if (this.k.F != null) {
      this.k.F.b(paramLiveMakeLoverModel.stream);
      int j = 0;
      int i = 0;
      while (j < paramLiveMakeLoverModel.fans.size()) {
        int k = i + 1;
        if (j == paramInt) {
          i = k - 1;
        } else {
          i = k;
          if (!TextUtils.isEmpty(((LiveMakeLoverFansModel)paramLiveMakeLoverModel.fans.get(j)).uid)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("startZegoPlayForMakeLover:");
            stringBuilder.append(k);
            stringBuilder.append(" : ");
            stringBuilder.append(((LiveMakeLoverFansModel)paramLiveMakeLoverModel.fans.get(j)).stream);
            Log.i("==makelover", stringBuilder.toString());
            this.k.F.a(((LiveMakeLoverFansModel)paramLiveMakeLoverModel.fans.get(j)).stream, k);
            i = k;
          } 
        } 
        j++;
      } 
    } 
  }
  
  private void b(int paramInt) {
    LiveRoomData liveRoomData = LiveRoomManager.a().h();
    if (liveRoomData == null)
      return; 
    this.k.G = LiveRoomManager.a().e();
    boolean bool2 = false;
    if (paramInt != 2) {
      boolean bool;
      if (liveRoomData.is_first == 1) {
        bool = true;
      } else {
        bool = false;
      } 
      this.p = bool;
      float f = CommonStringUtils.b(liveRoomData.gap_exp);
      LiveSetDataObserver.a().a(liveRoomData.level, liveRoomData.next_level, (int)liveRoomData.percent, f);
      if (liveRoomData.level >= 30)
        PlayingMakeFriendManager.b = DensityUtils.a((Context)this.f, 148.0F); 
    } 
    if (liveRoomData.watermark != null) {
      if (LiveRoomManager.a().h() != null)
        (LiveRoomManager.a().h()).watermark = liveRoomData.watermark; 
      this.k.a(liveRoomData.watermark.proportion_x, liveRoomData.watermark.proportion_y, liveRoomData.watermark.image, 1);
    } 
    if (liveRoomData.link_type == 4 && liveRoomData.matchmaking != null && liveRoomData.matchmaking.fans != null)
      this.k.c(liveRoomData.matchmaking.fans); 
    LiveSetDataObserver.a().x();
    this.k.M_();
    this.k.aR();
    Observable observable = LiveEventBus.get("live_luck_turning_btn");
    boolean bool1 = bool2;
    if (liveRoomData.entrance_status == 1)
      bool1 = true; 
    observable.post(Boolean.valueOf(bool1));
  }
  
  public void a() {
    Log.v("==record", "onMediaBufferStart");
    this.k.a(0, true);
  }
  
  public void a(int paramInt) {
    LiveRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<LiveRoomData>>(this, paramInt) {
          protected void a(BluedEntityA<LiveRoomData> param1BluedEntityA) {
            LiveRoomData liveRoomData = (LiveRoomData)param1BluedEntityA.getSingleData();
            if (liveRoomData != null) {
              liveRoomData.lid = PlayingOnlineManager.e(this.b);
              LiveRoomManager.a().a(liveRoomData);
              PlayingOnlineManager.a(this.b, this.a);
            } 
          }
        }this.h, this.i, paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, float paramFloat) {
    LiveSetDataObserver.a().a(paramInt1, paramInt2, paramInt3, paramFloat);
  }
  
  public void a(long paramLong) {
    EventTrackLive.a(LiveProtos.Event.LIVE_LOADING, LiveRoomManager.a().c(), LiveRoomManager.a().e());
    Map<String, String> map = BluedHttpTools.a();
    map.put("loading_time", String.valueOf(paramLong));
    map.put("session_id", String.valueOf(this.h));
    InstantLogBody instantLogBody = new InstantLogBody();
    instantLogBody.service = "live_loading";
    instantLogBody.event = 10001;
    InstantLog.a(instantLogBody, map);
  }
  
  public void a(long paramLong, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    if (TextUtils.equals(stringBuilder.toString(), LiveRoomInfo.a().f())) {
      if (paramInt == 0) {
        this.k.F.c();
        this.k.F.b();
        return;
      } 
      this.k.F.d();
      this.k.F.a();
    } 
  }
  
  public void a(Context paramContext, String paramString, short paramShort, long paramLong, IRequestHost paramIRequestHost) {
    Logger.a("drb", new Object[] { "getUserInfoFollow" });
    if (this.o)
      return; 
    this.o = true;
    LiveRoomHttpUtils.a(paramContext, new BluedUIHttpResponse<BluedEntityA<LiveRoomUserModel>>(this, paramIRequestHost, paramString) {
          protected void a(BluedEntityA<LiveRoomUserModel> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
              LiveRoomUserModel liveRoomUserModel = param1BluedEntityA.data.get(0);
              if (liveRoomUserModel != null && !TextUtils.isEmpty(liveRoomUserModel.relationship))
                LiveRelationshipObserver.a().a(liveRoomUserModel.relationship, this.a); 
            } 
          }
        }paramString, "", Long.valueOf(paramLong), Short.valueOf(paramShort), paramIRequestHost);
  }
  
  public void a(ChattingModel paramChattingModel) {
    super.a(paramChattingModel);
    short s = paramChattingModel.msgType;
    if (s != 106) {
      if (s != 107) {
        if (s != 128) {
          LiveFriendModel liveFriendModel;
          if (s != 129) {
            if (s != 131) {
              LiveMakeLoverModel liveMakeLoverModel;
              int i = 0;
              if (s != 132) {
                if (s != 180) {
                  LiveChatInitData liveChatInitData;
                  if (s != 181) {
                    LiveMakeLoverFansModel liveMakeLoverFansModel;
                    LiveFriendModel liveFriendModel1;
                    LivePKDoubleModel livePKDoubleModel;
                    LiveTaskModel liveTaskModel;
                    StringBuilder stringBuilder1;
                    switch (s) {
                      default:
                        switch (s) {
                          default:
                            switch (s) {
                              default:
                                return;
                              case 192:
                                stringBuilder1 = new StringBuilder();
                                stringBuilder1.append("192(客拒绝):");
                                stringBuilder1.append(paramChattingModel.getMsgExtra());
                                Log.i("==makelover==", stringBuilder1.toString());
                                this.k.a(new Runnable(this, paramChattingModel) {
                                      public void run() {
                                        long l = MsgPackHelper.getLongValue(this.a.msgMapExtra, "uid");
                                        LiveMsgSendManager.a().b("观众拒绝主播相亲邀请");
                                        String str = LiveRoomInfo.a().f();
                                        StringBuilder stringBuilder = new StringBuilder();
                                        stringBuilder.append(l);
                                        stringBuilder.append("");
                                        if (TextUtils.equals(str, stringBuilder.toString())) {
                                          if (PlayingOnlineManager.a(this.b).W())
                                            PlayingOnlineManager.a(this.b).X(); 
                                          LiveMakeLoverManager.a(1);
                                        } 
                                      }
                                    });
                                return;
                              case 191:
                                stringBuilder1 = new StringBuilder();
                                stringBuilder1.append("191(客态闭麦):");
                                stringBuilder1.append(paramChattingModel.getMsgExtra());
                                Log.i("==makelover==", stringBuilder1.toString());
                                return;
                              case 190:
                                stringBuilder1 = new StringBuilder();
                                stringBuilder1.append("190(客态开麦):");
                                stringBuilder1.append(paramChattingModel.getMsgExtra());
                                Log.i("==makelover==", stringBuilder1.toString());
                                return;
                              case 189:
                                stringBuilder1 = new StringBuilder();
                                stringBuilder1.append("189(主态踢客态下麦):");
                                stringBuilder1.append(paramChattingModel.getMsgExtra());
                                Log.i("==makelover==", stringBuilder1.toString());
                                return;
                              case 188:
                                stringBuilder1 = new StringBuilder();
                                stringBuilder1.append("188(客态主动下麦):");
                                stringBuilder1.append(paramChattingModel.getMsgExtra());
                                Log.i("==makelover==", stringBuilder1.toString());
                                return;
                              case 187:
                                stringBuilder1 = new StringBuilder();
                                stringBuilder1.append("187(主拒绝):");
                                stringBuilder1.append(paramChattingModel.getMsgExtra());
                                Log.i("==makelover==", stringBuilder1.toString());
                                this.k.a(new Runnable(this, paramChattingModel) {
                                      public void run() {
                                        long l = MsgPackHelper.getLongValue(this.a.msgMapExtra, "uid");
                                        LiveMsgSendManager liveMsgSendManager = LiveMsgSendManager.a();
                                        StringBuilder stringBuilder = new StringBuilder();
                                        stringBuilder.append("主播忽略观众相亲申请 uid:");
                                        stringBuilder.append(l);
                                        liveMsgSendManager.b(stringBuilder.toString());
                                        String str = LiveRoomInfo.a().f();
                                        stringBuilder = new StringBuilder();
                                        stringBuilder.append(l);
                                        stringBuilder.append("");
                                        if (TextUtils.equals(str, stringBuilder.toString())) {
                                          if (PlayingOnlineManager.a(this.b).W())
                                            PlayingOnlineManager.a(this.b).X(); 
                                          LiveMakeLoverManager.a(1);
                                          AppMethods.d(R.string.live_make_friend_rejected);
                                        } 
                                      }
                                    });
                                return;
                              case 186:
                                stringBuilder1 = new StringBuilder();
                                stringBuilder1.append("186(主同意):");
                                stringBuilder1.append(paramChattingModel.getMsgExtra());
                                Log.i("==makelover==", stringBuilder1.toString());
                                LiveMsgSendManager.a().b("主播邀请观众相亲上麦");
                                this.k.a(new Runnable(this) {
                                      public void run() {
                                        if (PlayingOnlineManager.a(this.a).W())
                                          PlayingOnlineManager.a(this.a).X(); 
                                        LiveMakeLoverManager.a(3);
                                        PlayingOnlineManager.a(this.a).V();
                                      }
                                    });
                                return;
                              case 185:
                                stringBuilder1 = new StringBuilder();
                                stringBuilder1.append("185(爆照):");
                                stringBuilder1.append(paramChattingModel.getMsgExtra());
                                Log.i("==makelover==", stringBuilder1.toString());
                                liveMakeLoverFansModel = (LiveMakeLoverFansModel)AppInfo.f().fromJson(paramChattingModel.getMsgExtra(), LiveMakeLoverFansModel.class);
                                this.k.a(new Runnable(this, liveMakeLoverFansModel) {
                                      public void run() {
                                        (PlayingOnlineManager.a(this.b)).bM.a(this.a.uid, this.a.pic);
                                      }
                                    });
                                return;
                              case 184:
                                break;
                            } 
                            stringBuilder1 = new StringBuilder();
                            stringBuilder1.append("184(重置灯):");
                            stringBuilder1.append(liveMakeLoverFansModel.getMsgExtra());
                            Log.i("==makelover==", stringBuilder1.toString());
                            this.k.a(new Runnable(this) {
                                  public void run() {
                                    (PlayingOnlineManager.a(this.a)).bK.b();
                                  }
                                });
                            return;
                          case 122:
                            LiveMsgSendManager.a().b("收到拒绝连麦邀请");
                            return;
                          case 121:
                            this.k.a(new Runnable(this, (ChattingModel)liveMakeLoverFansModel) {
                                  public void run() {
                                    LiveMsgSendManager.a().b("收到连麦结束消息");
                                    Logger.a("pk", new Object[] { "结束连麦" });
                                    Map map = this.a.msgMapExtra;
                                    MsgPackHelper.getLongValue(map, "closed_by");
                                    if (MsgPackHelper.getIntValue(map, "type") == 1)
                                      if ((PlayingOnlineManager.a(this.b)).aJ) {
                                        PlayingOnlineManager.a(this.b).f(false);
                                      } else {
                                        PlayingOnlineManager.a(this.b).ap();
                                      }  
                                    (PlayingOnlineManager.a(this.b)).ce = false;
                                    PlayingOnlineManager.a(this.b).ae();
                                    PlayingOnlineManager.a(this.b).b_(0);
                                  }
                                });
                            return;
                          case 120:
                            this.k.a(new Runnable(this, (ChattingModel)liveMakeLoverFansModel) {
                                  public void run() {
                                    Logger.a("pk", new Object[] { "开始连麦" });
                                    Map map = this.a.msgMapExtra;
                                    if (map != null) {
                                      PlayingOnlineManager playingOnlineManager;
                                      String str2 = MsgPackHelper.getStringValue(map, "conference_id");
                                      MsgPackHelper.getStringValue(map, "conference_token");
                                      String str3 = MsgPackHelper.getStringValue(map, "target_token");
                                      String str1 = MsgPackHelper.getStringValue(map, "name");
                                      long l = MsgPackHelper.getLongValue(map, "uid");
                                      int i = MsgPackHelper.getIntValue(map, "type");
                                      String str4 = MsgPackHelper.getStringValue(map, "stream");
                                      String str5 = MsgPackHelper.getStringValue(map, "target_stream");
                                      LiveMsgSendManager liveMsgSendManager = LiveMsgSendManager.a();
                                      StringBuilder stringBuilder = new StringBuilder();
                                      stringBuilder.append("收到连麦开始消息,当前连麦uid:");
                                      stringBuilder.append(l);
                                      liveMsgSendManager.b(stringBuilder.toString());
                                      if (i == 0) {
                                        playingOnlineManager = this.b;
                                        playingOnlineManager.b = l;
                                        playingOnlineManager.c = str1;
                                        PlayingOnlineManager.a(playingOnlineManager).e(false);
                                        Logger.a("pk", new Object[] { "111" });
                                        (PlayingOnlineManager.a(this.b)).ce = true;
                                        PlayingOnlineManager.a(this.b).b_(2);
                                        return;
                                      } 
                                      if (TextUtils.equals(String.valueOf(l), LiveRoomInfo.a().f())) {
                                        PlayingOnlineManager.a(this.b).a(JoinLiveResult.SUCCESS, (String)playingOnlineManager, str3, str4, str5, 0);
                                        PlayingOnlineManager.a(this.b).e(true);
                                        AppMethods.d(R.string.live_connection_to_begin);
                                        PlayingOnlineManager.a(this.b).b_(4);
                                      } else {
                                        playingOnlineManager = this.b;
                                        playingOnlineManager.c = str1;
                                        PlayingOnlineManager.a(playingOnlineManager).e(false);
                                        Logger.a("pk", new Object[] { "222" });
                                        PlayingOnlineManager.a(this.b).b_(3);
                                      } 
                                      (PlayingOnlineManager.a(this.b)).ce = false;
                                      this.b.b = l;
                                    } 
                                  }
                                });
                            return;
                          case 119:
                            break;
                        } 
                        liveFriendModel1 = (LiveFriendModel)AppInfo.f().fromJson(liveMakeLoverFansModel.getMsgExtra(), LiveFriendModel.class);
                        this.k.a(new Runnable(this, liveFriendModel1) {
                              public void run() {
                                Logger.a("pk", new Object[] { "好友、观众连线邀请" });
                                LiveMsgSendManager.a().b("收到连麦邀请消息");
                                if (this.a.type == 1)
                                  if (this.a.reset == 0) {
                                    if (!PlayingOnlineManager.a(this.b).B() && !(PlayingOnlineManager.a(this.b)).aJ) {
                                      this.a.model = 2;
                                      (PlayingOnlineManager.a(this.b)).bj.a(this.a);
                                      return;
                                    } 
                                  } else if (this.a.reset == 1) {
                                    (PlayingOnlineManager.a(this.b)).bj.b(this.a);
                                    AppMethods.d(R.string.live_connection_anchor_cancel);
                                  }  
                              }
                            });
                        return;
                      case 215:
                        stringBuilder1 = new StringBuilder();
                        stringBuilder1.append("215暴击时刻:");
                        stringBuilder1.append(liveFriendModel1.getMsgExtra());
                        Log.i("==xpp", stringBuilder1.toString());
                        livePKDoubleModel = (LivePKDoubleModel)AppInfo.f().fromJson(liveFriendModel1.getMsgExtra(), LivePKDoubleModel.class);
                        this.k.a(new Runnable(this, livePKDoubleModel) {
                              public void run() {
                                if (this.a != null && PlayingOnlineManager.a(this.b).B())
                                  PlayingOnlineManager.a(this.b).a(this.a.buff_countdown); 
                              }
                            });
                        return;
                      case 200:
                        stringBuilder1 = new StringBuilder();
                        stringBuilder1.append("200(主态新主播任务):");
                        stringBuilder1.append(livePKDoubleModel.getMsgExtra());
                        Log.i("==livetask==", stringBuilder1.toString());
                        liveTaskModel = (LiveTaskModel)AppInfo.f().fromJson(livePKDoubleModel.getMsgExtra(), LiveTaskModel.class);
                        this.k.a(new Runnable(this, liveTaskModel) {
                              public void run() {
                                LiveRoomManager.a().a(this.a);
                                if (!PlayingOnlineManager.c(this.b)) {
                                  PlayingOnlineManager.a(this.b, true);
                                  return;
                                } 
                                if (!PlayingOnlineManager.a(this.b).aF())
                                  (PlayingOnlineManager.a(this.b)).bQ.a(); 
                              }
                            });
                        return;
                      case 173:
                        Logger.a("rrb", new Object[] { "收到粉丝等级提升消息" });
                        stringBuilder1 = null;
                        try {
                          LiveFansLevelUpModel liveFansLevelUpModel;
                          if (!TextUtils.isEmpty(liveTaskModel.getMsgExtra()))
                            liveFansLevelUpModel = (LiveFansLevelUpModel)AppInfo.f().fromJson(liveTaskModel.getMsgExtra(), LiveFansLevelUpModel.class); 
                          if (liveFansLevelUpModel != null) {
                            this.k.a(new Runnable(this, liveFansLevelUpModel) {
                                  public void run() {
                                    LiveFansObserver.a().a(this.a.level);
                                  }
                                });
                            return;
                          } 
                        } catch (Exception exception) {
                          exception.printStackTrace();
                          return;
                        } 
                        return;
                      case 155:
                        this.k.a(new Runnable(this, (ChattingModel)exception) {
                              public void run() {
                                Map map = this.a.msgMapExtra;
                                int i = MsgPackHelper.getIntValue(map, "level");
                                String str = MsgPackHelper.getStringValue(map, "resource");
                                LiveGiftModel liveGiftModel = new LiveGiftModel();
                                liveGiftModel.images_apng2 = str;
                                LiveSetDataObserver.a().b(liveGiftModel);
                                if (i >= 30)
                                  PlayingMakeFriendManager.b = DensityUtils.a((Context)PlayingOnlineManager.b(this.b), 148.0F); 
                              }
                            });
                      case 157:
                        this.k.a(new Runnable(this, (ChattingModel)exception) {
                              public void run() {
                                Map map = this.a.msgMapExtra;
                                float f1 = MsgPackHelper.getFloatValue(map, "proportion_x");
                                float f2 = MsgPackHelper.getFloatValue(map, "proportion_y");
                                String str = MsgPackHelper.getStringValue(map, "image");
                                int i = MsgPackHelper.getIntValue(map, "add");
                                PlayingOnlineManager.a(this.b).a(f1, f2, str, i);
                              }
                            });
                        return;
                      case 141:
                        this.k.a(new Runnable(this, (ChattingModel)exception) {
                              public void run() {
                                int i = MsgPackHelper.getIntValue(this.a.msgMapExtra, "type");
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("MT_LIVE_ACTIVITY_POP charge, ");
                                stringBuilder.append(i);
                                LogUtils.c(stringBuilder.toString());
                                if (i == 1) {
                                  PlayingOnlineManager.a(this.b).F();
                                  return;
                                } 
                                PlayingOnlineManager.a(this.b).aV();
                              }
                            });
                        return;
                      case 134:
                        liveFriendModel = (LiveFriendModel)AppInfo.f().fromJson(exception.getMsgExtra(), LiveFriendModel.class);
                        if (liveFriendModel != null) {
                          this.k.a(new Runnable(this, liveFriendModel) {
                                public void run() {
                                  // Byte code:
                                  //   0: aload_0
                                  //   1: getfield a : Lcom/blued/android/module/live_china/model/LiveFriendModel;
                                  //   4: getfield fans : Ljava/util/List;
                                  //   7: ifnull -> 147
                                  //   10: iconst_0
                                  //   11: istore_1
                                  //   12: iload_1
                                  //   13: aload_0
                                  //   14: getfield a : Lcom/blued/android/module/live_china/model/LiveFriendModel;
                                  //   17: getfield fans : Ljava/util/List;
                                  //   20: invokeinterface size : ()I
                                  //   25: if_icmpge -> 130
                                  //   28: invokestatic a : ()Lcom/blued/android/module/live_china/msg/LiveMsgSendManager;
                                  //   31: astore_2
                                  //   32: new java/lang/StringBuilder
                                  //   35: dup
                                  //   36: invokespecial <init> : ()V
                                  //   39: astore_3
                                  //   40: aload_3
                                  //   41: ldc '直播间上麦:'
                                  //   43: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
                                  //   46: pop
                                  //   47: aload_3
                                  //   48: iload_1
                                  //   49: invokevirtual append : (I)Ljava/lang/StringBuilder;
                                  //   52: pop
                                  //   53: aload_3
                                  //   54: ldc '号uid：'
                                  //   56: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
                                  //   59: pop
                                  //   60: aload_3
                                  //   61: aload_0
                                  //   62: getfield a : Lcom/blued/android/module/live_china/model/LiveFriendModel;
                                  //   65: getfield fans : Ljava/util/List;
                                  //   68: iload_1
                                  //   69: invokeinterface get : (I)Ljava/lang/Object;
                                  //   74: checkcast com/blued/android/module/live_china/model/LiveFriendModel
                                  //   77: getfield uid : Ljava/lang/String;
                                  //   80: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
                                  //   83: pop
                                  //   84: aload_3
                                  //   85: ldc 'name:'
                                  //   87: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
                                  //   90: pop
                                  //   91: aload_3
                                  //   92: aload_0
                                  //   93: getfield a : Lcom/blued/android/module/live_china/model/LiveFriendModel;
                                  //   96: getfield fans : Ljava/util/List;
                                  //   99: iload_1
                                  //   100: invokeinterface get : (I)Ljava/lang/Object;
                                  //   105: checkcast com/blued/android/module/live_china/model/LiveFriendModel
                                  //   108: getfield name : Ljava/lang/String;
                                  //   111: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
                                  //   114: pop
                                  //   115: aload_2
                                  //   116: aload_3
                                  //   117: invokevirtual toString : ()Ljava/lang/String;
                                  //   120: invokevirtual b : (Ljava/lang/String;)V
                                  //   123: iload_1
                                  //   124: iconst_1
                                  //   125: iadd
                                  //   126: istore_1
                                  //   127: goto -> 12
                                  //   130: aload_0
                                  //   131: getfield b : Lcom/blued/android/module/live_china/manager/PlayingOnlineManager;
                                  //   134: invokestatic a : (Lcom/blued/android/module/live_china/manager/PlayingOnlineManager;)Lcom/blued/android/module/live_china/fragment/PlayingOnliveFragment;
                                  //   137: aload_0
                                  //   138: getfield a : Lcom/blued/android/module/live_china/model/LiveFriendModel;
                                  //   141: getfield fans : Ljava/util/List;
                                  //   144: invokevirtual b_ : (Ljava/util/List;)V
                                  //   147: aload_0
                                  //   148: getfield a : Lcom/blued/android/module/live_china/model/LiveFriendModel;
                                  //   151: getfield uid : Ljava/lang/String;
                                  //   154: invokestatic a : ()Lcom/blued/android/module/live_china/live_info/LiveRoomInfo;
                                  //   157: invokevirtual f : ()Ljava/lang/String;
                                  //   160: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
                                  //   163: ifeq -> 486
                                  //   166: invokestatic a : ()Lcom/blued/android/module/live_china/msg/LiveMsgSendManager;
                                  //   169: astore_2
                                  //   170: new java/lang/StringBuilder
                                  //   173: dup
                                  //   174: invokespecial <init> : ()V
                                  //   177: astore_3
                                  //   178: aload_3
                                  //   179: ldc '直播间上麦我的位置：'
                                  //   181: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
                                  //   184: pop
                                  //   185: aload_3
                                  //   186: aload_0
                                  //   187: getfield a : Lcom/blued/android/module/live_china/model/LiveFriendModel;
                                  //   190: getfield index : I
                                  //   193: invokevirtual append : (I)Ljava/lang/StringBuilder;
                                  //   196: pop
                                  //   197: aload_2
                                  //   198: aload_3
                                  //   199: invokevirtual toString : ()Ljava/lang/String;
                                  //   202: invokevirtual b : (Ljava/lang/String;)V
                                  //   205: aload_0
                                  //   206: getfield a : Lcom/blued/android/module/live_china/model/LiveFriendModel;
                                  //   209: getfield fans : Ljava/util/List;
                                  //   212: invokeinterface size : ()I
                                  //   217: aload_0
                                  //   218: getfield a : Lcom/blued/android/module/live_china/model/LiveFriendModel;
                                  //   221: getfield index : I
                                  //   224: iconst_1
                                  //   225: isub
                                  //   226: if_icmple -> 366
                                  //   229: aload_0
                                  //   230: getfield a : Lcom/blued/android/module/live_china/model/LiveFriendModel;
                                  //   233: getfield fans : Ljava/util/List;
                                  //   236: aload_0
                                  //   237: getfield a : Lcom/blued/android/module/live_china/model/LiveFriendModel;
                                  //   240: getfield index : I
                                  //   243: iconst_1
                                  //   244: isub
                                  //   245: invokeinterface get : (I)Ljava/lang/Object;
                                  //   250: checkcast com/blued/android/module/live_china/model/LiveFriendModel
                                  //   253: astore_2
                                  //   254: new java/lang/StringBuilder
                                  //   257: dup
                                  //   258: invokespecial <init> : ()V
                                  //   261: astore_3
                                  //   262: aload_3
                                  //   263: ldc '用户上麦  我的推流id：'
                                  //   265: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
                                  //   268: pop
                                  //   269: aload_3
                                  //   270: aload_2
                                  //   271: getfield stream : Ljava/lang/String;
                                  //   274: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
                                  //   277: pop
                                  //   278: ldc 'pk'
                                  //   280: aload_3
                                  //   281: invokevirtual toString : ()Ljava/lang/String;
                                  //   284: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
                                  //   287: pop
                                  //   288: aload_2
                                  //   289: aload_0
                                  //   290: getfield a : Lcom/blued/android/module/live_china/model/LiveFriendModel;
                                  //   293: getfield index : I
                                  //   296: putfield index : I
                                  //   299: aload_2
                                  //   300: aload_0
                                  //   301: getfield a : Lcom/blued/android/module/live_china/model/LiveFriendModel;
                                  //   304: getfield conference_id : Ljava/lang/String;
                                  //   307: putfield conference_id : Ljava/lang/String;
                                  //   310: aload_2
                                  //   311: aload_0
                                  //   312: getfield a : Lcom/blued/android/module/live_china/model/LiveFriendModel;
                                  //   315: getfield conference_token : Ljava/lang/String;
                                  //   318: putfield conference_token : Ljava/lang/String;
                                  //   321: new java/lang/StringBuilder
                                  //   324: dup
                                  //   325: invokespecial <init> : ()V
                                  //   328: astore_3
                                  //   329: aload_3
                                  //   330: ldc '用户上麦  index：'
                                  //   332: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
                                  //   335: pop
                                  //   336: aload_3
                                  //   337: aload_2
                                  //   338: getfield index : I
                                  //   341: invokevirtual append : (I)Ljava/lang/StringBuilder;
                                  //   344: pop
                                  //   345: ldc 'pk'
                                  //   347: aload_3
                                  //   348: invokevirtual toString : ()Ljava/lang/String;
                                  //   351: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
                                  //   354: pop
                                  //   355: aload_0
                                  //   356: getfield b : Lcom/blued/android/module/live_china/manager/PlayingOnlineManager;
                                  //   359: invokestatic a : (Lcom/blued/android/module/live_china/manager/PlayingOnlineManager;)Lcom/blued/android/module/live_china/fragment/PlayingOnliveFragment;
                                  //   362: aload_2
                                  //   363: invokevirtual c : (Lcom/blued/android/module/live_china/model/LiveFriendModel;)V
                                  //   366: aload_0
                                  //   367: getfield b : Lcom/blued/android/module/live_china/manager/PlayingOnlineManager;
                                  //   370: invokestatic a : (Lcom/blued/android/module/live_china/manager/PlayingOnlineManager;)Lcom/blued/android/module/live_china/fragment/PlayingOnliveFragment;
                                  //   373: getfield F : Lcom/blued/android/module/live_china/manager/PlayingRTCManager;
                                  //   376: ifnull -> 462
                                  //   379: new java/lang/StringBuilder
                                  //   382: dup
                                  //   383: invokespecial <init> : ()V
                                  //   386: astore_2
                                  //   387: aload_2
                                  //   388: ldc '用户上麦  拉取主播流id：'
                                  //   390: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
                                  //   393: pop
                                  //   394: aload_2
                                  //   395: aload_0
                                  //   396: getfield a : Lcom/blued/android/module/live_china/model/LiveFriendModel;
                                  //   399: getfield stream : Ljava/lang/String;
                                  //   402: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
                                  //   405: pop
                                  //   406: ldc 'pk'
                                  //   408: aload_2
                                  //   409: invokevirtual toString : ()Ljava/lang/String;
                                  //   412: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
                                  //   415: pop
                                  //   416: aload_0
                                  //   417: getfield b : Lcom/blued/android/module/live_china/manager/PlayingOnlineManager;
                                  //   420: invokestatic a : (Lcom/blued/android/module/live_china/manager/PlayingOnlineManager;)Lcom/blued/android/module/live_china/fragment/PlayingOnliveFragment;
                                  //   423: getfield F : Lcom/blued/android/module/live_china/manager/PlayingRTCManager;
                                  //   426: aload_0
                                  //   427: getfield a : Lcom/blued/android/module/live_china/model/LiveFriendModel;
                                  //   430: getfield stream : Ljava/lang/String;
                                  //   433: invokevirtual b : (Ljava/lang/String;)V
                                  //   436: aload_0
                                  //   437: getfield b : Lcom/blued/android/module/live_china/manager/PlayingOnlineManager;
                                  //   440: invokestatic a : (Lcom/blued/android/module/live_china/manager/PlayingOnlineManager;)Lcom/blued/android/module/live_china/fragment/PlayingOnliveFragment;
                                  //   443: getfield F : Lcom/blued/android/module/live_china/manager/PlayingRTCManager;
                                  //   446: invokevirtual c : ()V
                                  //   449: aload_0
                                  //   450: getfield b : Lcom/blued/android/module/live_china/manager/PlayingOnlineManager;
                                  //   453: invokestatic a : (Lcom/blued/android/module/live_china/manager/PlayingOnlineManager;)Lcom/blued/android/module/live_china/fragment/PlayingOnliveFragment;
                                  //   456: getfield F : Lcom/blued/android/module/live_china/manager/PlayingRTCManager;
                                  //   459: invokevirtual b : ()V
                                  //   462: aload_0
                                  //   463: getfield b : Lcom/blued/android/module/live_china/manager/PlayingOnlineManager;
                                  //   466: astore_2
                                  //   467: aload_0
                                  //   468: getfield a : Lcom/blued/android/module/live_china/model/LiveFriendModel;
                                  //   471: astore_3
                                  //   472: aload_2
                                  //   473: aload_3
                                  //   474: aload_3
                                  //   475: getfield index : I
                                  //   478: iconst_1
                                  //   479: isub
                                  //   480: invokestatic a : (Lcom/blued/android/module/live_china/manager/PlayingOnlineManager;Lcom/blued/android/module/live_china/model/LiveFriendModel;I)V
                                  //   483: goto -> 572
                                  //   486: aload_0
                                  //   487: getfield b : Lcom/blued/android/module/live_china/manager/PlayingOnlineManager;
                                  //   490: invokestatic a : (Lcom/blued/android/module/live_china/manager/PlayingOnlineManager;)Lcom/blued/android/module/live_china/fragment/PlayingOnliveFragment;
                                  //   493: invokevirtual aE : ()Z
                                  //   496: ifeq -> 572
                                  //   499: iconst_0
                                  //   500: istore_1
                                  //   501: iload_1
                                  //   502: aload_0
                                  //   503: getfield a : Lcom/blued/android/module/live_china/model/LiveFriendModel;
                                  //   506: getfield fans : Ljava/util/List;
                                  //   509: invokeinterface size : ()I
                                  //   514: if_icmpge -> 558
                                  //   517: aload_0
                                  //   518: getfield a : Lcom/blued/android/module/live_china/model/LiveFriendModel;
                                  //   521: getfield fans : Ljava/util/List;
                                  //   524: iload_1
                                  //   525: invokeinterface get : (I)Ljava/lang/Object;
                                  //   530: checkcast com/blued/android/module/live_china/model/LiveFriendModel
                                  //   533: getfield uid : Ljava/lang/String;
                                  //   536: invokestatic a : ()Lcom/blued/android/module/live_china/live_info/LiveRoomInfo;
                                  //   539: invokevirtual f : ()Ljava/lang/String;
                                  //   542: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
                                  //   545: ifeq -> 551
                                  //   548: goto -> 560
                                  //   551: iload_1
                                  //   552: iconst_1
                                  //   553: iadd
                                  //   554: istore_1
                                  //   555: goto -> 501
                                  //   558: iconst_0
                                  //   559: istore_1
                                  //   560: aload_0
                                  //   561: getfield b : Lcom/blued/android/module/live_china/manager/PlayingOnlineManager;
                                  //   564: aload_0
                                  //   565: getfield a : Lcom/blued/android/module/live_china/model/LiveFriendModel;
                                  //   568: iload_1
                                  //   569: invokestatic a : (Lcom/blued/android/module/live_china/manager/PlayingOnlineManager;Lcom/blued/android/module/live_china/model/LiveFriendModel;I)V
                                  //   572: aload_0
                                  //   573: getfield b : Lcom/blued/android/module/live_china/manager/PlayingOnlineManager;
                                  //   576: invokestatic a : (Lcom/blued/android/module/live_china/manager/PlayingOnlineManager;)Lcom/blued/android/module/live_china/fragment/PlayingOnliveFragment;
                                  //   579: getfield q : Lcom/blued/android/module/live_china/view/LiveMakeFriendManageView;
                                  //   582: aload_0
                                  //   583: getfield a : Lcom/blued/android/module/live_china/model/LiveFriendModel;
                                  //   586: getfield count : I
                                  //   589: invokevirtual b : (I)V
                                  //   592: return
                                }
                              });
                          return;
                        } 
                        return;
                      case 102:
                        this.k.a(new Runnable(this, (ChattingModel)liveFriendModel) {
                              public void run() {
                                Map map = this.a.msgMapExtra;
                                if (map != null) {
                                  String str1 = MsgPackHelper.getStringValue(map, "gift_apng");
                                  String str2 = MsgPackHelper.getStringValue(map, "gift_mp4");
                                  StringBuilder stringBuilder = new StringBuilder();
                                  stringBuilder.append(str1);
                                  stringBuilder.append(" gift_mp4：");
                                  stringBuilder.append(str2);
                                  Logger.a("rrb", new Object[] { "财富等级提升消息 gift_apng:", stringBuilder.toString() });
                                  if (this.a.fromId == Integer.valueOf(LiveRoomInfo.a().f()).intValue()) {
                                    if (!TextUtils.isEmpty(str1) || !TextUtils.isEmpty(str2)) {
                                      LiveGiftModel liveGiftModel = new LiveGiftModel();
                                      if (!TextUtils.isEmpty(str1))
                                        if (str1.endsWith(".gif")) {
                                          liveGiftModel.images_gif = str1;
                                        } else {
                                          liveGiftModel.images_apng2 = str1;
                                        }  
                                      if (!TextUtils.isEmpty(str2))
                                        liveGiftModel.images_mp4 = str2; 
                                      LiveSetDataObserver.a().b(liveGiftModel);
                                    } 
                                    LiveRefreshUIObserver.a().o();
                                  } 
                                } 
                              }
                            });
                        return;
                      case 93:
                        this.k.a(new Runnable(this, (ChattingModel)liveFriendModel) {
                              public void run() {
                                Map map = this.a.msgMapExtra;
                                if (map != null)
                                  this.b.a = MsgPackHelper.getIntValue(map, "live_status"); 
                              }
                            });
                        return;
                      case 44:
                        this.k.a(new Runnable(this) {
                              public void run() {
                                PlayingOnlineManager.a(this.a).aw();
                              }
                            });
                        return;
                      case 39:
                        Logger.a("drb", new Object[] { "收到勋章消息" });
                        liveChatInitData = (LiveChatInitData)AppInfo.f().fromJson(liveFriendModel.getMsgExtra(), LiveChatInitData.class);
                        this.k.a(new Runnable(this, liveChatInitData) {
                              public void run() {
                                if (this.a != null) {
                                  if (LiveRoomManager.a().h() != null)
                                    (LiveRoomManager.a().h()).badges = this.a.badges; 
                                  LiveSetDataObserver.a().c(this.a.badges);
                                  return;
                                } 
                                LiveSetDataObserver.a().c(null);
                              }
                            });
                        return;
                      case 37:
                        break;
                    } 
                    this.k.a(new Runnable(this, (ChattingModel)liveChatInitData) {
                          public void run() {
                            LiveSetDataObserver.a().b(this.a);
                          }
                        });
                    return;
                  } 
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append("181(下麦):");
                  stringBuilder.append(liveChatInitData.getMsgExtra());
                  Log.i("==makelover==", stringBuilder.toString());
                  liveMakeLoverModel = (LiveMakeLoverModel)AppInfo.f().fromJson(liveChatInitData.getMsgExtra(), LiveMakeLoverModel.class);
                  if (liveMakeLoverModel != null) {
                    this.k.a(new Runnable(this, liveMakeLoverModel) {
                          public void run() {
                            LiveMsgSendManager liveMsgSendManager = LiveMsgSendManager.a();
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("直播间相亲下麦:");
                            stringBuilder.append(this.a.index);
                            stringBuilder.append("号uid：");
                            stringBuilder.append(this.a.uid);
                            stringBuilder.append("name:");
                            stringBuilder.append(this.a.name);
                            liveMsgSendManager.b(stringBuilder.toString());
                            (PlayingOnlineManager.a(this.b)).bM.d(this.a.uid);
                            ZegoCommonHelper.b().c().stopPlayingStream(this.a.stream);
                            if (TextUtils.equals(this.a.uid, LiveRoomInfo.a().f()))
                              PlayingOnlineManager.a(this.b).ah(); 
                          }
                        });
                    return;
                  } 
                } else {
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append("180(join):");
                  stringBuilder.append(liveMakeLoverModel.getMsgExtra());
                  Log.i("==makelover==", stringBuilder.toString());
                  liveMakeLoverModel = (LiveMakeLoverModel)AppInfo.f().fromJson(liveMakeLoverModel.getMsgExtra(), LiveMakeLoverModel.class);
                  if (liveMakeLoverModel != null) {
                    this.k.a(new Runnable(this, liveMakeLoverModel) {
                          public void run() {
                            // Byte code:
                            //   0: aload_0
                            //   1: getfield b : Lcom/blued/android/module/live_china/manager/PlayingOnlineManager;
                            //   4: invokestatic a : (Lcom/blued/android/module/live_china/manager/PlayingOnlineManager;)Lcom/blued/android/module/live_china/fragment/PlayingOnliveFragment;
                            //   7: aload_0
                            //   8: getfield a : Lcom/blued/android/module/live_china/model/LiveMakeLoverModel;
                            //   11: getfield fans : Ljava/util/List;
                            //   14: invokevirtual c : (Ljava/util/List;)V
                            //   17: aload_0
                            //   18: getfield a : Lcom/blued/android/module/live_china/model/LiveMakeLoverModel;
                            //   21: getfield uid : Ljava/lang/String;
                            //   24: invokestatic a : ()Lcom/blued/android/module/live_china/live_info/LiveRoomInfo;
                            //   27: invokevirtual f : ()Ljava/lang/String;
                            //   30: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
                            //   33: istore #4
                            //   35: iconst_0
                            //   36: istore_1
                            //   37: iload #4
                            //   39: ifeq -> 235
                            //   42: aconst_null
                            //   43: astore #5
                            //   45: iconst_0
                            //   46: istore_2
                            //   47: iload_1
                            //   48: aload_0
                            //   49: getfield a : Lcom/blued/android/module/live_china/model/LiveMakeLoverModel;
                            //   52: getfield fans : Ljava/util/List;
                            //   55: invokeinterface size : ()I
                            //   60: if_icmpge -> 146
                            //   63: aload_0
                            //   64: getfield a : Lcom/blued/android/module/live_china/model/LiveMakeLoverModel;
                            //   67: getfield fans : Ljava/util/List;
                            //   70: iload_1
                            //   71: invokeinterface get : (I)Ljava/lang/Object;
                            //   76: checkcast com/blued/android/module/live_china/model/LiveMakeLoverFansModel
                            //   79: astore #7
                            //   81: iload_2
                            //   82: istore_3
                            //   83: aload #5
                            //   85: astore #6
                            //   87: aload #7
                            //   89: ifnull -> 122
                            //   92: iload_2
                            //   93: istore_3
                            //   94: aload #5
                            //   96: astore #6
                            //   98: aload #7
                            //   100: getfield uid : Ljava/lang/String;
                            //   103: aload_0
                            //   104: getfield a : Lcom/blued/android/module/live_china/model/LiveMakeLoverModel;
                            //   107: getfield uid : Ljava/lang/String;
                            //   110: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
                            //   113: ifeq -> 122
                            //   116: iload_1
                            //   117: istore_3
                            //   118: aload #7
                            //   120: astore #6
                            //   122: aload #7
                            //   124: ifnull -> 133
                            //   127: aload #7
                            //   129: invokevirtual isEmpty : ()Z
                            //   132: pop
                            //   133: iload_1
                            //   134: iconst_1
                            //   135: iadd
                            //   136: istore_1
                            //   137: iload_3
                            //   138: istore_2
                            //   139: aload #6
                            //   141: astore #5
                            //   143: goto -> 47
                            //   146: invokestatic a : ()Lcom/blued/android/module/live_china/msg/LiveMsgSendManager;
                            //   149: astore #6
                            //   151: new java/lang/StringBuilder
                            //   154: dup
                            //   155: invokespecial <init> : ()V
                            //   158: astore #7
                            //   160: aload #7
                            //   162: ldc '相亲上麦我的位置：'
                            //   164: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
                            //   167: pop
                            //   168: aload #7
                            //   170: iload_2
                            //   171: invokevirtual append : (I)Ljava/lang/StringBuilder;
                            //   174: pop
                            //   175: aload #6
                            //   177: aload #7
                            //   179: invokevirtual toString : ()Ljava/lang/String;
                            //   182: invokevirtual b : (Ljava/lang/String;)V
                            //   185: aload #5
                            //   187: ifnull -> 222
                            //   190: aload #5
                            //   192: iload_2
                            //   193: iconst_1
                            //   194: iadd
                            //   195: putfield index : I
                            //   198: aload #5
                            //   200: aload_0
                            //   201: getfield a : Lcom/blued/android/module/live_china/model/LiveMakeLoverModel;
                            //   204: getfield conference_id : Ljava/lang/String;
                            //   207: putfield conference_id : Ljava/lang/String;
                            //   210: aload_0
                            //   211: getfield b : Lcom/blued/android/module/live_china/manager/PlayingOnlineManager;
                            //   214: invokestatic a : (Lcom/blued/android/module/live_china/manager/PlayingOnlineManager;)Lcom/blued/android/module/live_china/fragment/PlayingOnliveFragment;
                            //   217: aload #5
                            //   219: invokevirtual a : (Lcom/blued/android/module/live_china/model/LiveMakeLoverFansModel;)V
                            //   222: aload_0
                            //   223: getfield b : Lcom/blued/android/module/live_china/manager/PlayingOnlineManager;
                            //   226: aload_0
                            //   227: getfield a : Lcom/blued/android/module/live_china/model/LiveMakeLoverModel;
                            //   230: iload_2
                            //   231: invokestatic a : (Lcom/blued/android/module/live_china/manager/PlayingOnlineManager;Lcom/blued/android/module/live_china/model/LiveMakeLoverModel;I)V
                            //   234: return
                            //   235: aload_0
                            //   236: getfield b : Lcom/blued/android/module/live_china/manager/PlayingOnlineManager;
                            //   239: invokestatic a : (Lcom/blued/android/module/live_china/manager/PlayingOnlineManager;)Lcom/blued/android/module/live_china/fragment/PlayingOnliveFragment;
                            //   242: invokevirtual aG : ()Z
                            //   245: ifeq -> 321
                            //   248: iconst_0
                            //   249: istore_1
                            //   250: iload_1
                            //   251: aload_0
                            //   252: getfield a : Lcom/blued/android/module/live_china/model/LiveMakeLoverModel;
                            //   255: getfield fans : Ljava/util/List;
                            //   258: invokeinterface size : ()I
                            //   263: if_icmpge -> 307
                            //   266: aload_0
                            //   267: getfield a : Lcom/blued/android/module/live_china/model/LiveMakeLoverModel;
                            //   270: getfield fans : Ljava/util/List;
                            //   273: iload_1
                            //   274: invokeinterface get : (I)Ljava/lang/Object;
                            //   279: checkcast com/blued/android/module/live_china/model/LiveMakeLoverFansModel
                            //   282: getfield uid : Ljava/lang/String;
                            //   285: invokestatic a : ()Lcom/blued/android/module/live_china/live_info/LiveRoomInfo;
                            //   288: invokevirtual f : ()Ljava/lang/String;
                            //   291: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
                            //   294: ifeq -> 300
                            //   297: goto -> 309
                            //   300: iload_1
                            //   301: iconst_1
                            //   302: iadd
                            //   303: istore_1
                            //   304: goto -> 250
                            //   307: iconst_0
                            //   308: istore_1
                            //   309: aload_0
                            //   310: getfield b : Lcom/blued/android/module/live_china/manager/PlayingOnlineManager;
                            //   313: aload_0
                            //   314: getfield a : Lcom/blued/android/module/live_china/model/LiveMakeLoverModel;
                            //   317: iload_1
                            //   318: invokestatic a : (Lcom/blued/android/module/live_china/manager/PlayingOnlineManager;Lcom/blued/android/module/live_china/model/LiveMakeLoverModel;I)V
                            //   321: return
                          }
                        });
                    return;
                  } 
                } 
              } else {
                if (this.k.aD())
                  return; 
                liveFriendModel = (LiveFriendModel)AppInfo.f().fromJson(liveMakeLoverModel.getMsgExtra(), LiveFriendModel.class);
                if (liveFriendModel != null) {
                  this.k.b(liveFriendModel);
                  if (liveFriendModel.fans != null) {
                    while (i < liveFriendModel.fans.size()) {
                      LiveMsgSendManager liveMsgSendManager1 = LiveMsgSendManager.a();
                      StringBuilder stringBuilder1 = new StringBuilder();
                      stringBuilder1.append("进入交友模式:");
                      stringBuilder1.append(i);
                      stringBuilder1.append("号uid：");
                      stringBuilder1.append(((LiveFriendModel)liveFriendModel.fans.get(i)).uid);
                      stringBuilder1.append("name:");
                      stringBuilder1.append(((LiveFriendModel)liveFriendModel.fans.get(i)).name);
                      liveMsgSendManager1.b(stringBuilder1.toString());
                      i++;
                    } 
                    this.k.b_(liveFriendModel.fans);
                  } 
                  this.k.q.c(liveFriendModel.count);
                  LiveMsgSendManager liveMsgSendManager = LiveMsgSendManager.a();
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append("进入交友模式 count:");
                  stringBuilder.append(liveFriendModel.count);
                  liveMsgSendManager.b(stringBuilder.toString());
                } 
                c(liveFriendModel);
                return;
              } 
            } else {
              this.k.a(new Runnable(this, (ChattingModel)liveFriendModel) {
                    public void run() {
                      long l = MsgPackHelper.getLongValue(this.a.msgMapExtra, "uid");
                      int i = MsgPackHelper.getIntValue(this.a.msgMapExtra, "voice");
                      LiveMsgSendManager liveMsgSendManager = LiveMsgSendManager.a();
                      StringBuilder stringBuilder = new StringBuilder();
                      stringBuilder.append("麦序管理 uid:");
                      stringBuilder.append(l);
                      stringBuilder.append(" - voice:");
                      stringBuilder.append(i);
                      liveMsgSendManager.b(stringBuilder.toString());
                      this.b.a(l, i);
                    }
                  });
              return;
            } 
          } else {
            this.k.a(new Runnable(this, (ChattingModel)liveFriendModel) {
                  public void run() {
                    Map map = this.a.msgMapExtra;
                    int i = MsgPackHelper.getIntValue(map, "count");
                    long l = MsgPackHelper.getLongValue(map, "uid");
                    LiveMsgSendManager liveMsgSendManager = LiveMsgSendManager.a();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("主播忽略观众申请 uid:");
                    stringBuilder.append(l);
                    stringBuilder.append(" - count:");
                    stringBuilder.append(i);
                    liveMsgSendManager.b(stringBuilder.toString());
                    String str = LiveRoomInfo.a().f();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(l);
                    stringBuilder.append("");
                    if (TextUtils.equals(str, stringBuilder.toString())) {
                      if ((PlayingOnlineManager.a(this.b)).bP.c())
                        (PlayingOnlineManager.a(this.b)).bP.h(); 
                      (PlayingOnlineManager.a(this.b)).bP.setState(0);
                      (PlayingOnlineManager.a(this.b)).q.a(1);
                      AppMethods.d(R.string.live_make_friend_rejected);
                    } 
                    (PlayingOnlineManager.a(this.b)).q.b(i);
                  }
                });
            return;
          } 
        } else {
          LiveMsgSendManager.a().b("主播邀请观众上麦");
          this.k.a(new Runnable(this) {
                public void run() {
                  if ((PlayingOnlineManager.a(this.a)).bP.c())
                    (PlayingOnlineManager.a(this.a)).bP.h(); 
                  if ((PlayingOnlineManager.a(this.a)).bO != null)
                    (PlayingOnlineManager.a(this.a)).bO.f(); 
                  (new LiveMakeFriendStartView(PlayingOnlineManager.a(this.a))).d();
                }
              });
          return;
        } 
      } else {
        this.k.a(new Runnable(this) {
              public void run() {
                Logger.a("rrb", new Object[] { "被解除场控消息" });
                LiveFloatManager.a().a(false);
              }
            });
        return;
      } 
    } else {
      this.k.a(new Runnable(this) {
            public void run() {
              Logger.a("rrb", new Object[] { "被设置为场控消息" });
              LiveFloatManager.a().a(true);
            }
          });
    } 
  }
  
  public void a(LiveFriendModel paramLiveFriendModel) {
    this.m = new StartPKTask(this, paramLiveFriendModel);
    AppInfo.n().postDelayed(this.m, paramLiveFriendModel.delay * 1000L);
  }
  
  public void a(LiveHornModel paramLiveHornModel, LiveGiftModel paramLiveGiftModel) {
    LiveSetDataObserver.a().a(paramLiveHornModel, false);
    if (paramLiveGiftModel != null) {
      LiveSetDataObserver.a().b(paramLiveGiftModel);
      LiveSetDataObserver.a().b(paramLiveGiftModel);
    } 
  }
  
  public void a(LivePKProgressModel paramLivePKProgressModel) {
    if (paramLivePKProgressModel == null)
      return; 
    if (paramLivePKProgressModel.uid == LiveRoomManager.a().d()) {
      this.k.aZ.setOurProgress(paramLivePKProgressModel.total);
    } else {
      this.k.bd.a(paramLivePKProgressModel.score);
      this.k.aZ.setOtherProgress(paramLivePKProgressModel.total);
    } 
    this.k.ba.setData(paramLivePKProgressModel);
  }
  
  public void a(LivePKResultModel paramLivePKResultModel) {
    this.k.a(null);
    this.k.bf.d();
    AppInfo.n().removeCallbacks(this.m);
    if (paramLivePKResultModel.winner == 0L) {
      this.k.a("live_pk_tie_anim.png", R.drawable.live_pk_tie);
      this.k.b("live_pk_tie_anim.png", R.drawable.live_pk_tie);
      this.k.ba.setPkState(0);
    } else if (paramLivePKResultModel.winner == LiveRoomManager.a().d()) {
      this.k.a("live_pk_winner_anim.png", R.drawable.live_pk_winner);
      this.k.b("live_pk_loser_anim.png", R.drawable.live_pk_loser);
      this.k.ba.setPkState(1);
    } else {
      this.k.a("live_pk_loser_anim.png", R.drawable.live_pk_loser);
      this.k.b("live_pk_winner_anim.png", R.drawable.live_pk_winner);
      this.k.ba.setPkState(2);
    } 
    if (paramLivePKResultModel.records != null)
      for (LivePKPlayerModel livePKPlayerModel : paramLivePKResultModel.records) {
        if (livePKPlayerModel.uid != LiveRoomManager.a().d())
          this.b = livePKPlayerModel.uid; 
      }  
    if (paramLivePKResultModel.records != null && this.k.B()) {
      Iterator<LivePKPlayerModel> iterator = paramLivePKResultModel.records.iterator();
      int j = 0;
      int i;
      for (i = 0; iterator.hasNext(); i = livePKPlayerModel.score) {
        LivePKPlayerModel livePKPlayerModel = iterator.next();
        if (livePKPlayerModel == null)
          return; 
        if (livePKPlayerModel.uid == LiveRoomManager.a().d()) {
          this.k.aZ.setOurProgress(livePKPlayerModel.score);
          j = livePKPlayerModel.score;
          continue;
        } 
        this.b = livePKPlayerModel.uid;
        this.k.aZ.setOtherProgress(livePKPlayerModel.score);
      } 
      this.k.bb.a(j, i);
    } 
    this.k.bf.a(paramLivePKResultModel.countdown);
    this.k.g(false);
  }
  
  public void a(LiveRewardModel paramLiveRewardModel) {
    LiveSetDataObserver.a().a(paramLiveRewardModel);
  }
  
  public void a(LiveRoomCloseReason paramLiveRoomCloseReason) {
    this.k.a(new Runnable(this, paramLiveRoomCloseReason) {
          public void run() {
            PlayingOnlineManager.b(this.b).setRequestedOrientation(1);
            PlayingOnlineManager.a(this.b).a(8, false);
            PlayingOnlineManager.a(this.b).a(this.a);
          }
        });
  }
  
  public void a(String paramString) {
    LiveRoomHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<LiveRoomUserModel>>(this) {
          protected void a(BluedEntityA<LiveRoomUserModel> param1BluedEntityA) {
            AppMethods.a(AppInfo.d().getString(R.string.liveVideo_livingView_tips_reportSuccess));
          }
        },  String.valueOf(this.h), paramString);
  }
  
  public void a(boolean paramBoolean) {
    if (!this.k.a(new Runnable(this, paramBoolean) {
          public void run() {
            if (LiveRoomManager.a().l())
              return; 
            if (PlayingOnlineManager.a(this.b) == null || PlayingOnlineManager.a(this.b).w_() == null || !PlayingOnlineManager.a(this.b).w_().isActive()) {
              LiveFloatManager.a().d(true);
              return;
            } 
            PlayingOnlineManager playingOnlineManager = this.b;
            playingOnlineManager.a((Context)PlayingOnlineManager.b(playingOnlineManager), LiveRoomManager.a().e(), PlayingOnlineManager.d(this.b), PlayingOnlineManager.e(this.b), (IRequestHost)PlayingOnlineManager.a(this.b).w_());
            LiveRoomUtils.a((IRequestHost)PlayingOnlineManager.a(this.b).w_(), "1");
            PlayingOnlineManager.a(this.b, 1);
            if (LiveRoomManager.a().h() != null) {
              boolean bool;
              if (TextUtils.isEmpty((LiveRoomManager.a().h()).live_url))
                return; 
              PlayingOnliveFragment playingOnliveFragment = PlayingOnlineManager.a(this.b);
              if ((LiveRoomManager.a().h()).is_manager == 1) {
                bool = true;
              } else {
                bool = false;
              } 
              playingOnliveFragment.aW = bool;
              Logger.a("rrb", new Object[] { "enterLiveSuccess isLiveManager 111111111= ", Boolean.valueOf((PlayingOnlineManager.a(this.b)).aW) });
              LiveRoomData liveRoomData = LiveRoomManager.a().h();
              if (liveRoomData.screen_pattern == 1)
                AppInfo.n().post(new Runnable(this) {
                      public void run() {
                        LiveFloatManager.a().d(true);
                        (PlayingOnlineManager.a(this.a.b)).aU.b();
                      }
                    }); 
              if (this.a || LiveFloatManager.a().E())
                AppInfo.n().postDelayed(new Runnable(this, liveRoomData) {
                      public void run() {
                        if (this.a.effects != null && (!TextUtils.isEmpty(this.a.effects.contents) || !TextUtils.isEmpty(this.a.effects.url) || !TextUtils.isEmpty(this.a.effects.background_color) || !TextUtils.isEmpty(this.a.effects.gift_apng) || !TextUtils.isEmpty(this.a.effects.entrance_gif) || !TextUtils.isEmpty(this.a.effects.entrance_apng) || !TextUtils.isEmpty(this.a.effects.entrance_mp4))) {
                          EntranceData entranceData = new EntranceData();
                          entranceData.entranceContents = this.a.effects.contents;
                          entranceData.entranceImage = this.a.effects.url;
                          entranceData.entranceColor = this.a.effects.background_color;
                          entranceData.entranceGif = this.a.effects.entrance_gif;
                          entranceData.entranceApng = this.a.effects.entrance_apng;
                          entranceData.entranceAnim = this.a.effects.gift_apng;
                          entranceData.entranceMp4 = this.a.effects.entrance_mp4;
                          entranceData.userData = new ProfileData();
                          entranceData.userData.isLiveManager = (PlayingOnlineManager.a(this.b.b)).aW;
                          entranceData.userData.uid = Long.parseLong(LiveRoomInfo.a().f());
                          entranceData.userData.name = LiveRoomInfo.a().c();
                          entranceData.userData.richLevel = LiveRoomInfo.a().q();
                          entranceData.userData.liangType = this.a.liang_type;
                          entranceData.userData.liangId = this.a.liang_id;
                          LiveEventBusUtil.a(entranceData);
                          if (!TextUtils.isEmpty(entranceData.entranceApng) || !TextUtils.isEmpty(entranceData.entranceGif) || !TextUtils.isEmpty(entranceData.entranceMp4)) {
                            LiveGiftModel liveGiftModel = new LiveGiftModel();
                            liveGiftModel.images_gif = entranceData.entranceGif;
                            liveGiftModel.images_apng2 = entranceData.entranceApng;
                            liveGiftModel.images_mp4 = entranceData.entranceMp4;
                            LiveSetDataObserver.a().b(liveGiftModel);
                          } 
                        } else {
                          ChattingModel chattingModel = ChatHelper.getChattingModelForSendmsg(this.a.lid, (short)27, PlayingOnlineManager.b(this.b.b).getString(R.string.live_coming), null, "", (short)4);
                          chattingModel.fromId = LiveRoomInfo.a().g();
                          chattingModel.fromNickName = LiveRoomInfo.a().c();
                          if ((PlayingOnlineManager.a(this.b.b)).aW)
                            chattingModel.fromLiveManager = 1; 
                          Logger.a("rrb", new Object[] { "自己进场普通动效 12= ", Integer.valueOf(chattingModel.fromLiveManager) });
                          LiveSetDataObserver.a().c(chattingModel);
                        } 
                        LiveFloatManager.a().d(false);
                      }
                    }1500L); 
              PlayingOnlineManager.a(this.b).a(new Runnable(this, liveRoomData) {
                    public void run() {
                      LiveSetDataObserver.a().b(this.a.elapse_time);
                      LiveSetDataObserver.a().u();
                    }
                  }2000L);
              PlayingOnlineManager.a(this.b).L();
              PlayingOnlineManager.a(this.b).M();
              LiveFloatManager.a().a((PlayingOnlineManager.a(this.b)).aW);
              if ((PlayingOnlineManager.a(this.b)).bX != null)
                (PlayingOnlineManager.a(this.b)).bX.b(); 
              if (liveRoomData.link_type == 4)
                PlayingOnlineManager.a(this.b).ag(); 
              if (PlayingOnlineManager.c(this.b)) {
                (PlayingOnlineManager.a(this.b)).bQ.a();
                PlayingOnlineManager.a(this.b, true);
              } 
            } 
          }
        }))
      LiveFloatManager.a().d(true); 
  }
  
  public void b() {
    Log.v("==record", "onMediaBufferEnd");
    this.k.a(8, true);
  }
  
  public void b(LiveFriendModel paramLiveFriendModel) {
    if (TextUtils.equals(paramLiveFriendModel.uid, LiveRoomInfo.a().f()))
      this.k.af(); 
  }
  
  public void b(LiveRoomCloseReason paramLiveRoomCloseReason) {
    PlayingOnliveFragment playingOnliveFragment = this.k;
    if (playingOnliveFragment == null || playingOnliveFragment.w_() == null || !this.k.w_().isActive());
  }
  
  public void c() {
    this.k.a(8, true);
  }
  
  public void d() {
    this.k.a(new Runnable(this) {
          public void run() {
            Log.v("==record", "retryConnect");
            PlayingOnlineManager.a(this.a).a(0, true);
          }
        });
  }
  
  public void e() {
    this.k.a(new Runnable(this) {
          public void run() {
            PlayingOnlineManager.a(this.a).a(8, false);
            PlayingOnlineManager.a(this.a).a(null);
          }
        });
  }
  
  public void f() {
    if (LiveFloatManager.a().z())
      LiveRoomUtils.a((IRequestHost)this.k.w_(), "1"); 
  }
  
  public void g() {}
  
  public void h() {
    this.k.bP.setState(0);
    this.k.q.a(1);
  }
  
  public void i() {
    LiveSetDataObserver.a().r();
  }
  
  public void j() {
    EventTrackLive.a(LiveProtos.Event.LIVE_INTERRUPT, LiveRoomManager.a().c(), LiveRoomManager.a().e());
    Map<String, String> map = BluedHttpTools.a();
    map.put("session_id", String.valueOf(this.h));
    InstantLogBody instantLogBody = new InstantLogBody();
    instantLogBody.service = "live_interrupt";
    instantLogBody.event = 20001;
    InstantLog.a(instantLogBody, map);
  }
  
  public boolean k() {
    return this.p;
  }
  
  class StartPKTask implements Runnable {
    private LiveFriendModel b;
    
    public StartPKTask(PlayingOnlineManager this$0, LiveFriendModel param1LiveFriendModel) {
      this.b = param1LiveFriendModel;
    }
    
    public void run() {
      Logger.a("pk", new Object[] { "收到PK开始消息--startPK" });
      PlayingOnlineManager.a(this.a).a(this.b);
      if (this.b.records != null)
        for (LivePKPlayerModel livePKPlayerModel : this.b.records) {
          if (livePKPlayerModel.uid == LiveRoomManager.a().d()) {
            (PlayingOnlineManager.a(this.a)).aZ.setOurProgress(livePKPlayerModel.score);
            continue;
          } 
          this.a.b = livePKPlayerModel.uid;
          (PlayingOnlineManager.a(this.a)).aZ.setOtherProgress(livePKPlayerModel.score);
        }  
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\manager\PlayingOnlineManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */