package com.blued.android.module.live_china.manager;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.blued.android.chat.data.LiveChatInitData;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.utils.MsgPackHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.common.ZegoCommonHelper;
import com.blued.android.module.live_china.common.ZegoMixStreamHelper;
import com.blued.android.module.live_china.fragment.LiveBaseFragment;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveFriendModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveHornModel;
import com.blued.android.module.live_china.model.LiveMakeLoverFansModel;
import com.blued.android.module.live_china.model.LiveMakeLoverModel;
import com.blued.android.module.live_china.model.LivePKDoubleModel;
import com.blued.android.module.live_china.model.LivePKPlayerModel;
import com.blued.android.module.live_china.model.LivePKProgressModel;
import com.blued.android.module.live_china.model.LivePKResultModel;
import com.blued.android.module.live_china.model.LiveRecordRecommendModel;
import com.blued.android.module.live_china.model.LiveRewardModel;
import com.blued.android.module.live_china.model.LiveTaskModel;
import com.blued.android.module.live_china.msg.LiveMsgHandler;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.same.Logger;
import java.util.Iterator;
import java.util.Map;

public class RecordingMsgManager extends LiveMsgHandler {
  private RecordingOnliveFragment a;
  
  private RecordingOnliveManager b;
  
  private boolean c;
  
  public RecordingMsgManager(RecordingOnliveFragment paramRecordingOnliveFragment, RecordingOnliveManager paramRecordingOnliveManager) {
    super((LiveBaseFragment)paramRecordingOnliveFragment);
    this.a = paramRecordingOnliveFragment;
    this.b = paramRecordingOnliveManager;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, float paramFloat) {
    this.a.a(paramInt1, paramInt2, paramInt3, paramFloat);
  }
  
  public void a(long paramLong, int paramInt) {}
  
  public void a(ChattingModel paramChattingModel) {
    LiveChatInitData liveChatInitData;
    super.a(paramChattingModel);
    short s = paramChattingModel.msgType;
    if (s != 37) {
      LiveFriendModel liveFriendModel;
      if (s != 39) {
        if (s != 94) {
          if (s != 114) {
            LiveTaskModel liveTaskModel;
            if (s != 134) {
              if (s != 155) {
                if (s != 165) {
                  LiveRecordRecommendModel liveRecordRecommendModel;
                  if (s != 200) {
                    LivePKDoubleModel livePKDoubleModel;
                    if (s != 211) {
                      LiveFriendModel liveFriendModel1;
                      if (s != 215) {
                        if (s != 46) {
                          if (s != 47) {
                            if (s != 128) {
                              if (s != 129) {
                                if (s != 131) {
                                  if (s != 132) {
                                    LiveMakeLoverFansModel liveMakeLoverFansModel;
                                    LiveMakeLoverModel liveMakeLoverModel;
                                    StringBuilder stringBuilder2;
                                    switch (s) {
                                      default:
                                        switch (s) {
                                          default:
                                            switch (s) {
                                              default:
                                                return;
                                              case 192:
                                                stringBuilder2 = new StringBuilder();
                                                stringBuilder2.append("192(客拒绝):");
                                                stringBuilder2.append(paramChattingModel.getMsgExtra());
                                                Log.i("==makelover==", stringBuilder2.toString());
                                                this.a.a(new Runnable(this) {
                                                      public void run() {
                                                        LiveMsgSendManager.a().b("观众拒绝主播相亲邀请");
                                                        AppMethods.d(R.string.live_make_friend_busy);
                                                      }
                                                    });
                                                return;
                                              case 191:
                                                stringBuilder2 = new StringBuilder();
                                                stringBuilder2.append("191(客态闭麦):");
                                                stringBuilder2.append(paramChattingModel.getMsgExtra());
                                                Log.i("==makelover==", stringBuilder2.toString());
                                                return;
                                              case 190:
                                                stringBuilder2 = new StringBuilder();
                                                stringBuilder2.append("190(客态开麦):");
                                                stringBuilder2.append(paramChattingModel.getMsgExtra());
                                                Log.i("==makelover==", stringBuilder2.toString());
                                                return;
                                              case 189:
                                                stringBuilder2 = new StringBuilder();
                                                stringBuilder2.append("189(主态踢客态下麦):");
                                                stringBuilder2.append(paramChattingModel.getMsgExtra());
                                                Log.i("==makelover==", stringBuilder2.toString());
                                                return;
                                              case 188:
                                                stringBuilder2 = new StringBuilder();
                                                stringBuilder2.append("188(客态主动下麦):");
                                                stringBuilder2.append(paramChattingModel.getMsgExtra());
                                                Log.i("==makelover==", stringBuilder2.toString());
                                                return;
                                              case 187:
                                                stringBuilder2 = new StringBuilder();
                                                stringBuilder2.append("187(主拒绝):");
                                                stringBuilder2.append(paramChattingModel.getMsgExtra());
                                                Log.i("==makelover==", stringBuilder2.toString());
                                                LiveMsgSendManager.a().b("主播忽略观众相亲上麦");
                                                return;
                                              case 186:
                                                stringBuilder2 = new StringBuilder();
                                                stringBuilder2.append("186(主同意):");
                                                stringBuilder2.append(paramChattingModel.getMsgExtra());
                                                Log.i("==makelover==", stringBuilder2.toString());
                                                LiveMsgSendManager.a().b("主播邀请观众相亲上麦");
                                                return;
                                              case 185:
                                                stringBuilder2 = new StringBuilder();
                                                stringBuilder2.append("185(嘉宾爆照):");
                                                stringBuilder2.append(paramChattingModel.getMsgExtra());
                                                Log.i("==makelover==", stringBuilder2.toString());
                                                liveMakeLoverFansModel = (LiveMakeLoverFansModel)AppInfo.f().fromJson(paramChattingModel.getMsgExtra(), LiveMakeLoverFansModel.class);
                                                this.a.a(new Runnable(this, liveMakeLoverFansModel) {
                                                      public void run() {
                                                        (RecordingMsgManager.a(this.b)).aZ.a(this.a.uid, this.a.pic);
                                                      }
                                                    });
                                                return;
                                              case 184:
                                                break;
                                            } 
                                            stringBuilder2 = new StringBuilder();
                                            stringBuilder2.append("184(重置灯):");
                                            stringBuilder2.append(liveMakeLoverFansModel.getMsgExtra());
                                            Log.i("==makelover==", stringBuilder2.toString());
                                            return;
                                          case 181:
                                            stringBuilder2 = new StringBuilder();
                                            stringBuilder2.append("181(下麦):");
                                            stringBuilder2.append(liveMakeLoverFansModel.getMsgExtra());
                                            Log.i("==makelover==", stringBuilder2.toString());
                                            liveMakeLoverModel = (LiveMakeLoverModel)AppInfo.f().fromJson(liveMakeLoverFansModel.getMsgExtra(), LiveMakeLoverModel.class);
                                            if (liveMakeLoverModel != null) {
                                              this.a.a(new Runnable(this, liveMakeLoverModel) {
                                                    public void run() {
                                                      (RecordingMsgManager.a(this.b)).bb.d(this.a.uid);
                                                      LiveMsgSendManager liveMsgSendManager = LiveMsgSendManager.a();
                                                      StringBuilder stringBuilder = new StringBuilder();
                                                      stringBuilder.append("直播间下麦:");
                                                      stringBuilder.append(this.a.index);
                                                      stringBuilder.append("号uid：");
                                                      stringBuilder.append(this.a.uid);
                                                      stringBuilder.append("name:");
                                                      stringBuilder.append(this.a.name);
                                                      liveMsgSendManager.b(stringBuilder.toString());
                                                      ZegoCommonHelper.b().c().stopPlayingStream(this.a.stream);
                                                      ZegoMixStreamHelper.a().a(this.a.stream, (RecordingMsgManager.b(this.b)).c);
                                                      AppMethods.a(String.format(RecordingMsgManager.a(this.b).getContext().getString(R.string.live_make_friend_has_left), new Object[] { this.a.name }));
                                                    }
                                                  });
                                              return;
                                            } 
                                            return;
                                          case 180:
                                            stringBuilder2 = new StringBuilder();
                                            stringBuilder2.append("180（join）:");
                                            stringBuilder2.append(liveMakeLoverModel.getMsgExtra());
                                            Log.i("==makelover==", stringBuilder2.toString());
                                            liveMakeLoverModel = (LiveMakeLoverModel)AppInfo.f().fromJson(liveMakeLoverModel.getMsgExtra(), LiveMakeLoverModel.class);
                                            if (liveMakeLoverModel != null) {
                                              this.a.a(new Runnable(this, liveMakeLoverModel) {
                                                    public void run() {
                                                      if (this.a.fans != null) {
                                                        RecordingMsgManager.a(this.b).d(this.a.fans);
                                                        LiveMakeLoverFansModel liveMakeLoverFansModel = null;
                                                        int i = 0;
                                                        int j;
                                                        for (j = 0; i < this.a.fans.size(); j = k) {
                                                          LiveMakeLoverFansModel liveMakeLoverFansModel2 = this.a.fans.get(i);
                                                          LiveMakeLoverFansModel liveMakeLoverFansModel1 = liveMakeLoverFansModel;
                                                          int k = j;
                                                          if (liveMakeLoverFansModel2 != null) {
                                                            liveMakeLoverFansModel1 = liveMakeLoverFansModel;
                                                            k = j;
                                                            if (TextUtils.equals(liveMakeLoverFansModel2.uid, this.a.uid)) {
                                                              k = i;
                                                              liveMakeLoverFansModel1 = liveMakeLoverFansModel2;
                                                            } 
                                                          } 
                                                          i++;
                                                          liveMakeLoverFansModel = liveMakeLoverFansModel1;
                                                        } 
                                                        if (liveMakeLoverFansModel != null) {
                                                          AppMethods.a(String.format(RecordingMsgManager.a(this.b).getContext().getString(R.string.live_make_friend_succeeded_entering), new Object[] { liveMakeLoverFansModel.name }));
                                                          StringBuilder stringBuilder1 = new StringBuilder();
                                                          stringBuilder1.append("用户相亲上麦  推流id：");
                                                          stringBuilder1.append(this.a.stream);
                                                          stringBuilder1.append(" -- 拉流id:");
                                                          stringBuilder1.append(liveMakeLoverFansModel.stream);
                                                          Log.v("pk", stringBuilder1.toString());
                                                          (RecordingMsgManager.a(this.b)).S.b(this.a.stream, liveMakeLoverFansModel.stream, j + 1);
                                                          LiveMsgSendManager liveMsgSendManager = LiveMsgSendManager.a();
                                                          StringBuilder stringBuilder2 = new StringBuilder();
                                                          stringBuilder2.append("直播间相亲上麦:");
                                                          stringBuilder2.append(j);
                                                          stringBuilder2.append("号uid：");
                                                          stringBuilder2.append(liveMakeLoverFansModel.uid);
                                                          stringBuilder2.append("name:");
                                                          stringBuilder2.append(liveMakeLoverFansModel.name);
                                                          liveMsgSendManager.b(stringBuilder2.toString());
                                                        } 
                                                      } 
                                                    }
                                                  });
                                              return;
                                            } 
                                            return;
                                          case 179:
                                            break;
                                        } 
                                        stringBuilder2 = new StringBuilder();
                                        stringBuilder2.append("179(申请 取消 同步):");
                                        stringBuilder2.append(liveMakeLoverModel.getMsgExtra());
                                        Log.i("==makelover==", stringBuilder2.toString());
                                        liveMakeLoverModel = (LiveMakeLoverModel)AppInfo.f().fromJson(liveMakeLoverModel.getMsgExtra(), LiveMakeLoverModel.class);
                                        if (liveMakeLoverModel != null) {
                                          this.a.a(new Runnable(this, liveMakeLoverModel) {
                                                public void run() {
                                                  RecordingMsgManager.a(this.b).n(this.a.chooser_count + this.a.chosen_count);
                                                }
                                              });
                                          return;
                                        } 
                                        return;
                                      case 122:
                                        this.a.a(new Runnable(this) {
                                              public void run() {
                                                if (RecordingMsgManager.b(this.a) != null) {
                                                  LiveMsgSendManager.a().b("收到连麦拒绝消息");
                                                  Logger.a("pk", new Object[] { "拒绝连麦邀请" });
                                                  (RecordingMsgManager.a(this.a)).br.d();
                                                  (RecordingMsgManager.a(this.a)).br.f();
                                                  RecordingMsgManager.a(this.a).at();
                                                  AppMethods.d(R.string.live_pk_invite_him_next_time);
                                                } 
                                              }
                                            });
                                        break;
                                      case 121:
                                        Log.v("==record", "MT_LIVE_CONNECTION_END");
                                        this.a.a(new Runnable(this, (ChattingModel)liveMakeLoverModel) {
                                              public void run() {
                                                if (RecordingMsgManager.b(this.b) != null) {
                                                  LiveMsgSendManager.a().b("收到连麦结束消息");
                                                  Logger.a("pk", new Object[] { "结束连麦" });
                                                  Map map = this.a.msgMapExtra;
                                                  long l = MsgPackHelper.getLongValue(map, "closed_by");
                                                  MsgPackHelper.getIntValue(map, "type");
                                                  if (RecordingMsgManager.a(this.b).aO() || RecordingMsgManager.a(this.b).aN()) {
                                                    String str = LiveRoomInfo.a().f();
                                                    StringBuilder stringBuilder = new StringBuilder();
                                                    stringBuilder.append(l);
                                                    stringBuilder.append("");
                                                    if (!TextUtils.equals(str, stringBuilder.toString()))
                                                      AppMethods.d(R.string.live_connection_other_finish); 
                                                  } 
                                                  RecordingMsgManager.a(this.b).O();
                                                  RecordingMsgManager.a(this.b).b_(0);
                                                } 
                                              }
                                            });
                                        return;
                                      case 120:
                                        this.a.a(new Runnable(this, (ChattingModel)liveMakeLoverModel) {
                                              public void run() {
                                                if (RecordingMsgManager.b(this.b) != null) {
                                                  LiveMsgSendManager.a().b("收到连麦开始消息");
                                                  Logger.a("pk", new Object[] { "开始连麦" });
                                                  Map map = this.a.msgMapExtra;
                                                  if (map != null) {
                                                    MsgPackHelper.getStringValue(map, "conference_id");
                                                    MsgPackHelper.getStringValue(map, "conference_token");
                                                    String str1 = MsgPackHelper.getStringValue(map, "stream");
                                                    String str2 = MsgPackHelper.getStringValue(map, "target_stream");
                                                    StringBuilder stringBuilder = new StringBuilder();
                                                    stringBuilder.append("我的拉流id:");
                                                    stringBuilder.append(str2);
                                                    Log.v("pk", stringBuilder.toString());
                                                    stringBuilder = new StringBuilder();
                                                    stringBuilder.append("我的推流id:");
                                                    stringBuilder.append(str1);
                                                    Log.v("pk", stringBuilder.toString());
                                                    MsgPackHelper.getStringValue(map, "name");
                                                    MsgPackHelper.getLongValue(map, "uid");
                                                    if (MsgPackHelper.getIntValue(map, "type") == 0) {
                                                      if ((RecordingMsgManager.a(this.b)).br.i()) {
                                                        AppMethods.d(R.string.live_other_anchor_agreed);
                                                      } else {
                                                        AppMethods.d(R.string.live_connection_to_begin);
                                                      } 
                                                      (RecordingMsgManager.a(this.b)).br.d();
                                                      (RecordingMsgManager.a(this.b)).br.f();
                                                      RecordingMsgManager.a(this.b).b_(2);
                                                    } else {
                                                      if ((RecordingMsgManager.a(this.b)).br.i()) {
                                                        AppMethods.d(R.string.live_other_anchor_agreed);
                                                      } else {
                                                        AppMethods.d(R.string.live_connection_to_begin);
                                                      } 
                                                      RecordingMsgManager.a(this.b).at();
                                                      RecordingMsgManager.a(this.b).b_(3);
                                                    } 
                                                    RecordingMsgManager.a(this.b).N();
                                                    RecordingMsgManager.b(this.b).a(2, str2);
                                                  } 
                                                } 
                                              }
                                            });
                                        return;
                                      case 119:
                                        liveFriendModel1 = (LiveFriendModel)AppInfo.f().fromJson(liveMakeLoverModel.getMsgExtra(), LiveFriendModel.class);
                                        this.a.a(new Runnable(this, liveFriendModel1) {
                                              public void run() {
                                                Logger.a("pk", new Object[] { "好友、观众连线邀请" });
                                                LiveMsgSendManager.a().b("收到连麦邀请消息");
                                                if (this.a.type == 0)
                                                  if (this.a.reset == 0) {
                                                    if (!(RecordingMsgManager.a(this.b)).br.i() && !RecordingMsgManager.a(this.b).aS()) {
                                                      if ((RecordingMsgManager.a(this.b)).cy)
                                                        KeyboardUtils.a((Activity)RecordingMsgManager.a(this.b).getActivity()); 
                                                      this.a.model = 1;
                                                      if ((RecordingMsgManager.a(this.b)).bP != null) {
                                                        (RecordingMsgManager.a(this.b)).bP.a(this.a);
                                                        return;
                                                      } 
                                                    } 
                                                  } else if (this.a.reset == 1 && (RecordingMsgManager.a(this.b)).bP != null) {
                                                    (RecordingMsgManager.a(this.b)).bP.b(this.a);
                                                  }  
                                              }
                                            });
                                        return;
                                    } 
                                  } 
                                  if (this.a.aP())
                                    return; 
                                  liveFriendModel1 = (LiveFriendModel)AppInfo.f().fromJson(liveFriendModel1.getMsgExtra(), LiveFriendModel.class);
                                  if (liveFriendModel1 != null) {
                                    if (liveFriendModel1.fans != null) {
                                      s = 0;
                                      while (s < liveFriendModel1.fans.size()) {
                                        LiveMsgSendManager liveMsgSendManager1 = LiveMsgSendManager.a();
                                        StringBuilder stringBuilder3 = new StringBuilder();
                                        stringBuilder3.append("进入交友模式:");
                                        stringBuilder3.append(s);
                                        stringBuilder3.append("号uid：");
                                        stringBuilder3.append(((LiveFriendModel)liveFriendModel1.fans.get(s)).uid);
                                        stringBuilder3.append("name:");
                                        stringBuilder3.append(((LiveFriendModel)liveFriendModel1.fans.get(s)).name);
                                        liveMsgSendManager1.b(stringBuilder3.toString());
                                        int i = s + 1;
                                      } 
                                      this.a.b_(liveFriendModel1.fans);
                                    } 
                                    this.a.c(liveFriendModel1);
                                    this.a.q.c(liveFriendModel1.count);
                                    LiveMsgSendManager liveMsgSendManager = LiveMsgSendManager.a();
                                    StringBuilder stringBuilder2 = new StringBuilder();
                                    stringBuilder2.append("进入交友模式 count:");
                                    stringBuilder2.append(liveFriendModel1.count);
                                    liveMsgSendManager.b(stringBuilder2.toString());
                                  } 
                                  c(liveFriendModel1);
                                  return;
                                } 
                                this.a.a(new Runnable(this, (ChattingModel)liveFriendModel1) {
                                      public void run() {
                                        long l = MsgPackHelper.getLongValue(this.a.msgMapExtra, "uid");
                                        int i = MsgPackHelper.getIntValue(this.a.msgMapExtra, "enable");
                                        LiveMsgSendManager liveMsgSendManager = LiveMsgSendManager.a();
                                        StringBuilder stringBuilder = new StringBuilder();
                                        stringBuilder.append("麦序管理 uid:");
                                        stringBuilder.append(l);
                                        stringBuilder.append(" - enable:");
                                        stringBuilder.append(i);
                                        liveMsgSendManager.b(stringBuilder.toString());
                                        this.b.a(l, i);
                                      }
                                    });
                                return;
                              } 
                              this.a.a(new Runnable(this, (ChattingModel)liveFriendModel1) {
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
                                      if (TextUtils.equals(str, stringBuilder.toString()) && (RecordingMsgManager.a(this.b)).bY.c()) {
                                        (RecordingMsgManager.a(this.b)).bY.h();
                                        (RecordingMsgManager.a(this.b)).bY.setState(0);
                                      } 
                                      (RecordingMsgManager.a(this.b)).q.b(i);
                                    }
                                  });
                              return;
                            } 
                            LiveMsgSendManager.a().b("主播邀请观众上麦");
                            return;
                          } 
                          this.a.a(new Runnable(this, (ChattingModel)liveFriendModel1) {
                                public void run() {
                                  Map map = this.a.msgMapExtra;
                                  if (map != null) {
                                    String str = MsgPackHelper.getStringValue(map, "error_contents");
                                    if (!TextUtils.isEmpty(str)) {
                                      AppMethods.a(str);
                                    } else {
                                      AppMethods.d(R.string.connection_not_accepted);
                                    } 
                                  } else {
                                    AppMethods.d(R.string.connection_not_accepted);
                                  } 
                                  RecordingMsgManager.a(this.b).aB();
                                }
                              });
                          return;
                        } 
                        this.a.a(new Runnable(this) {
                              public void run() {
                                if (RecordingMsgManager.b(this.a) != null)
                                  RecordingMsgManager.a(this.a).N(); 
                              }
                            });
                        return;
                      } 
                      StringBuilder stringBuilder1 = new StringBuilder();
                      stringBuilder1.append("215暴击时刻:");
                      stringBuilder1.append(liveFriendModel1.getMsgExtra());
                      Log.i("==xpp", stringBuilder1.toString());
                      livePKDoubleModel = (LivePKDoubleModel)AppInfo.f().fromJson(liveFriendModel1.getMsgExtra(), LivePKDoubleModel.class);
                      this.a.a(new Runnable(this, livePKDoubleModel) {
                            public void run() {
                              if (this.a != null)
                                RecordingMsgManager.a(this.b).c(this.a.buff_countdown); 
                            }
                          });
                      return;
                    } 
                    liveRecordRecommendModel = (LiveRecordRecommendModel)AppInfo.f().fromJson(livePKDoubleModel.getMsgExtra(), LiveRecordRecommendModel.class);
                    if (LiveRoomManager.a().h() != null)
                      (LiveRoomManager.a().h()).recommend = liveRecordRecommendModel; 
                    this.a.a(new Runnable(this) {
                          public void run() {
                            RecordingMsgManager.a(this.a).bh();
                          }
                        });
                    return;
                  } 
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append("200(主态新主播任务):");
                  stringBuilder.append(liveRecordRecommendModel.getMsgExtra());
                  Log.i("==livetask==", stringBuilder.toString());
                  liveTaskModel = (LiveTaskModel)AppInfo.f().fromJson(liveRecordRecommendModel.getMsgExtra(), LiveTaskModel.class);
                  this.a.a(new Runnable(this, liveTaskModel) {
                        public void run() {
                          LiveRoomManager.a().a(this.a);
                          if (!RecordingMsgManager.a(this.b).aQ())
                            (RecordingMsgManager.a(this.b)).bd.a(); 
                        }
                      });
                  return;
                } 
                this.a.a(new Runnable(this, (ChattingModel)liveTaskModel) {
                      public void run() {
                        if (MsgPackHelper.getIntValue(this.a.msgMapExtra, "status") == 1)
                          RecordingMsgManager.a(this.b).aa(); 
                      }
                    });
                return;
              } 
              this.a.a(new Runnable(this, (ChattingModel)liveTaskModel) {
                    public void run() {
                      Map map = this.a.msgMapExtra;
                      MsgPackHelper.getIntValue(map, "level");
                      String str = MsgPackHelper.getStringValue(map, "resource");
                      LiveGiftModel liveGiftModel = new LiveGiftModel();
                      liveGiftModel.images_apng2 = str;
                      (RecordingMsgManager.a(this.b)).cG.d(liveGiftModel);
                    }
                  });
              return;
            } 
            liveFriendModel = (LiveFriendModel)AppInfo.f().fromJson(liveTaskModel.getMsgExtra(), LiveFriendModel.class);
            if (liveFriendModel != null) {
              this.a.a(new Runnable(this, liveFriendModel) {
                    public void run() {
                      if (this.a.fans != null) {
                        for (int i = 0; i < this.a.fans.size(); i++) {
                          LiveMsgSendManager liveMsgSendManager1 = LiveMsgSendManager.a();
                          StringBuilder stringBuilder1 = new StringBuilder();
                          stringBuilder1.append("直播间上麦:");
                          stringBuilder1.append(i);
                          stringBuilder1.append("号uid：");
                          stringBuilder1.append(((LiveFriendModel)this.a.fans.get(i)).uid);
                          stringBuilder1.append("name:");
                          stringBuilder1.append(((LiveFriendModel)this.a.fans.get(i)).name);
                          liveMsgSendManager1.b(stringBuilder1.toString());
                        } 
                        RecordingMsgManager.a(this.b).b_(this.a.fans);
                        if (this.a.fans.size() > this.a.index - 1) {
                          LiveFriendModel liveFriendModel = this.a.fans.get(this.a.index - 1);
                          AppMethods.a(String.format(RecordingMsgManager.a(this.b).getContext().getString(R.string.live_make_friend_succeeded_entering), new Object[] { liveFriendModel.name }));
                          StringBuilder stringBuilder1 = new StringBuilder();
                          stringBuilder1.append("用户上麦  推流id：");
                          stringBuilder1.append(this.a.stream);
                          stringBuilder1.append(" -- 拉流id:");
                          stringBuilder1.append(liveFriendModel.stream);
                          Log.v("pk", stringBuilder1.toString());
                          (RecordingMsgManager.a(this.b)).S.a(this.a.stream, liveFriendModel.stream, this.a.index);
                        } 
                      } 
                      (RecordingMsgManager.a(this.b)).q.b(this.a.count);
                      LiveMsgSendManager liveMsgSendManager = LiveMsgSendManager.a();
                      StringBuilder stringBuilder = new StringBuilder();
                      stringBuilder.append("直播间上麦 count:");
                      stringBuilder.append(this.a.count);
                      liveMsgSendManager.b(stringBuilder.toString());
                    }
                  });
              return;
            } 
          } else {
            liveFriendModel = (LiveFriendModel)AppInfo.f().fromJson(liveFriendModel.getMsgExtra(), LiveFriendModel.class);
            this.a.a(new Runnable(this, liveFriendModel) {
                  public void run() {
                    Logger.a("pk", new Object[] { "收到pk邀请消息" });
                    if (this.a.type == 0)
                      if (this.a.reset == 0) {
                        if (!(RecordingMsgManager.a(this.b)).br.i()) {
                          if ((RecordingMsgManager.a(this.b)).cy)
                            KeyboardUtils.a((Activity)RecordingMsgManager.a(this.b).getActivity()); 
                          this.a.model = 0;
                          if ((RecordingMsgManager.a(this.b)).bP != null) {
                            (RecordingMsgManager.a(this.b)).bP.a(this.a);
                            return;
                          } 
                        } 
                      } else if (this.a.reset == 1 && (RecordingMsgManager.a(this.b)).bP != null) {
                        (RecordingMsgManager.a(this.b)).bP.b(this.a);
                      }  
                  }
                });
            return;
          } 
        } else {
          this.a.a(new Runnable(this, (ChattingModel)liveFriendModel) {
                public void run() {
                  Logger.a("rrrb", new Object[] { "红包返还消息" });
                  Map map = this.a.msgMapExtra;
                  if (map != null) {
                    int i = MsgPackHelper.getIntValue(map, "refund_beans");
                    String str = RecordingMsgManager.a(this.b).getContext().getString(R.string.live_reward_beans_back);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(i);
                    stringBuilder.append("");
                    AppMethods.a(String.format(str, new Object[] { stringBuilder.toString() }));
                  } 
                }
              });
          return;
        } 
      } else {
        liveChatInitData = (LiveChatInitData)AppInfo.f().fromJson(liveFriendModel.getMsgExtra(), LiveChatInitData.class);
        this.a.a(new Runnable(this, liveChatInitData) {
              public void run() {
                if (this.a != null)
                  RecordingMsgManager.a(this.b).a(this.a.badges); 
              }
            });
        return;
      } 
    } else {
      this.a.a(new Runnable(this, (ChattingModel)liveChatInitData) {
            public void run() {
              RecordingMsgManager.a(this.b).a(this.a);
            }
          });
    } 
  }
  
  public void a(LiveFriendModel paramLiveFriendModel) {
    this.a.br.d();
    this.a.a(paramLiveFriendModel);
    this.a.br.e();
    this.a.br.f();
  }
  
  public void a(LiveHornModel paramLiveHornModel, LiveGiftModel paramLiveGiftModel) {
    LiveMsgSendManager.a().b("收到喇叭消息");
    this.a.a(paramLiveHornModel, false);
    if (paramLiveGiftModel != null) {
      this.a.a(paramLiveGiftModel);
      this.a.a(paramLiveGiftModel);
    } 
  }
  
  public void a(LivePKProgressModel paramLivePKProgressModel) {
    if (paramLivePKProgressModel == null)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLivePKProgressModel.uid);
    stringBuilder.append("");
    if (TextUtils.equals(stringBuilder.toString(), LiveRoomInfo.a().f())) {
      this.a.bu.setOurProgress(paramLivePKProgressModel.total);
    } else {
      this.a.bC.a(paramLivePKProgressModel.score);
      this.a.bu.setOtherProgress(paramLivePKProgressModel.total);
    } 
    this.a.bv.setData(paramLivePKProgressModel);
  }
  
  public void a(LivePKResultModel paramLivePKResultModel) {
    this.a.br.j();
    this.a.bD.d();
    if (paramLivePKResultModel.winner == 0L) {
      if (paramLivePKResultModel.records != null) {
        Iterator<LivePKPlayerModel> iterator = paramLivePKResultModel.records.iterator();
        while (iterator.hasNext()) {
          LivePKPlayerModel livePKPlayerModel = iterator.next();
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(livePKPlayerModel.uid);
          stringBuilder.append("");
          if (TextUtils.equals(stringBuilder.toString(), LiveRoomInfo.a().f())) {
            LiveGiftModel liveGiftModel = new LiveGiftModel();
            liveGiftModel.anim_code = livePKPlayerModel.anim_code;
            liveGiftModel.resource_url = livePKPlayerModel.ar_url;
            this.a.cG.a(liveGiftModel);
            break;
          } 
        } 
      } 
      this.a.c("live_pk_tie_anim.png", R.drawable.live_pk_tie);
      this.a.d("live_pk_tie_anim.png", R.drawable.live_pk_tie);
      this.a.bv.setPkState(0);
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramLivePKResultModel.winner);
      stringBuilder.append("");
      if (TextUtils.equals(stringBuilder.toString(), LiveRoomInfo.a().f())) {
        if (paramLivePKResultModel.records != null) {
          Iterator<LivePKPlayerModel> iterator = paramLivePKResultModel.records.iterator();
          while (iterator.hasNext()) {
            LivePKPlayerModel livePKPlayerModel = iterator.next();
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(livePKPlayerModel.uid);
            stringBuilder1.append("");
            if (TextUtils.equals(stringBuilder1.toString(), LiveRoomInfo.a().f())) {
              LiveGiftModel liveGiftModel = new LiveGiftModel();
              liveGiftModel.anim_code = livePKPlayerModel.anim_code;
              liveGiftModel.resource_url = livePKPlayerModel.ar_url;
              this.a.cG.a(liveGiftModel);
              break;
            } 
          } 
          this.a.c("live_pk_winner_anim.png", R.drawable.live_pk_winner);
          this.a.d("live_pk_loser_anim.png", R.drawable.live_pk_loser);
          this.a.bv.setPkState(1);
        } 
      } else if (paramLivePKResultModel.records != null) {
        Iterator<LivePKPlayerModel> iterator = paramLivePKResultModel.records.iterator();
        while (iterator.hasNext()) {
          LivePKPlayerModel livePKPlayerModel = iterator.next();
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(livePKPlayerModel.uid);
          stringBuilder1.append("");
          if (TextUtils.equals(stringBuilder1.toString(), LiveRoomInfo.a().f())) {
            LiveGiftModel liveGiftModel = new LiveGiftModel();
            liveGiftModel.anim_code = livePKPlayerModel.anim_code;
            liveGiftModel.resource_url = livePKPlayerModel.ar_url;
            this.a.cG.a(liveGiftModel);
            break;
          } 
        } 
        this.a.c("live_pk_loser_anim.png", R.drawable.live_pk_loser);
        this.a.d("live_pk_winner_anim.png", R.drawable.live_pk_winner);
        this.a.bv.setPkState(2);
      } 
    } 
    if (paramLivePKResultModel.type == 1) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramLivePKResultModel.winner);
      stringBuilder.append("");
      if (TextUtils.equals(stringBuilder.toString(), LiveRoomInfo.a().f()))
        if (this.a.bD.a()) {
          AppMethods.a(this.a.getString(R.string.live_pk_exit_from_each_other_time));
        } else {
          AppMethods.a(this.a.getString(R.string.live_pk_exit_from_each_other));
        }  
    } 
    if (paramLivePKResultModel.records != null && this.a.B()) {
      Iterator<LivePKPlayerModel> iterator = paramLivePKResultModel.records.iterator();
      int j = 0;
      int i;
      for (i = 0; iterator.hasNext(); i = livePKPlayerModel.score) {
        LivePKPlayerModel livePKPlayerModel = iterator.next();
        if (livePKPlayerModel == null)
          return; 
        if (livePKPlayerModel.uid == LiveRoomManager.a().d()) {
          j = livePKPlayerModel.score;
          continue;
        } 
      } 
      this.a.bT.a(j, i);
    } 
    this.a.bD.a(paramLivePKResultModel.countdown);
    this.a.e(false);
  }
  
  public void a(LiveRewardModel paramLiveRewardModel) {
    this.a.bk.setData(paramLiveRewardModel);
  }
  
  public void a(boolean paramBoolean) {
    this.c = paramBoolean;
  }
  
  public boolean a() {
    return this.c;
  }
  
  public void b(LiveFriendModel paramLiveFriendModel) {
    ZegoMixStreamHelper.a().a(paramLiveFriendModel.stream, this.b.c);
    AppMethods.a(String.format(this.a.getContext().getString(R.string.live_make_friend_has_left), new Object[] { paramLiveFriendModel.name }));
  }
  
  public void c(LiveFriendModel paramLiveFriendModel) {
    super.c(paramLiveFriendModel);
    int i = paramLiveFriendModel.is_access_control;
    boolean bool = true;
    if (i != 1)
      bool = false; 
    this.c = bool;
  }
  
  public void i() {
    this.a.ae.a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\manager\RecordingMsgManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */