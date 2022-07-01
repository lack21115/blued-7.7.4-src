package com.blued.android.module.live_china.liveForMsg;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.collection.ArrayMap;
import com.blued.android.chat.data.EntranceData;
import com.blued.android.chat.data.ProfileData;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.utils.MsgPackHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.NetworkUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module.common.listener.SysNetworkListener;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.liveForMsg.data.LiveMsgContentAdapter;
import com.blued.android.module.live_china.liveForMsg.model.LiveMsgBonusExtra;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.GiftAnimManager;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveHornModel;
import com.blued.android.module.live_china.model.LiveMsgReportModel;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.model.LiveRoomUserModel;
import com.blued.android.module.live_china.model.LiveZanExtraModel;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.msg.SendMsgListener;
import com.blued.android.module.live_china.observer.LiveFansObserver;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.utils.LiveUtils;
import com.blued.android.module.live_china.utils.log.EventTrackLive;
import com.blued.android.module.live_china.utils.log.InstantLog;
import com.blued.android.module.live_china.view.BarrageView;
import com.blued.android.module.live_china.view.BarrageViewMultiOneRow;
import com.blued.android.module.live_china.view.EntranceEffectLayout;
import com.blued.android.module.live_china.view.EntranceNormalLayout;
import com.blued.android.module.live_china.view.PopUserCard;
import com.blued.android.module.live_china.view.PopUserCardCenter;
import com.blued.android.module.live_china.view.QuickReplyView;
import com.blued.das.live.LiveProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LiveMsgManager implements SysNetworkListener, Serializable {
  private static String x = LiveMsgManager.class.getSimpleName();
  
  private TextView A;
  
  private ShapeLinearLayout B;
  
  private TextView C;
  
  private View D;
  
  private View E;
  
  private View F;
  
  private View G;
  
  private GiftAnimManager H;
  
  private QuickReplyView I;
  
  private View J;
  
  private View K;
  
  private Runnable L;
  
  public View a;
  
  public ActivityFragmentActive b;
  
  public BaseFragment c;
  
  public short d = -1;
  
  public long e = -1L;
  
  public boolean f;
  
  public Context g;
  
  public ListView h;
  
  public List<ChattingModel> i = new ArrayList<ChattingModel>();
  
  public LiveMsgContentAdapter j;
  
  public View k;
  
  public RelativeLayout l;
  
  public LinearLayout m;
  
  public LinearLayout n;
  
  public boolean o = true;
  
  public BarrageView p;
  
  public EntranceEffectLayout q;
  
  public EntranceNormalLayout r;
  
  public BarrageViewMultiOneRow s;
  
  public View t;
  
  public int u;
  
  Runnable v = new Runnable(this) {
      public void run() {
        if (LiveMsgManager.d(this.a) != null)
          LiveMsgManager.d(this.a).setVisibility(8); 
      }
    };
  
  PopUserCard.UserCardOnclickListner w = new PopUserCard.UserCardOnclickListner(this) {
      public void a() {
        if (this.a.c instanceof RecordingOnliveFragment) {
          if (((RecordingOnliveFragment)this.a.c).be) {
            ((RecordingOnliveFragment)this.a.c).h(0);
          } else {
            ((RecordingOnliveFragment)this.a.c).g(0);
          } 
        } else {
          LiveRefreshUIObserver.a().d(0);
        } 
        this.a.a(0);
      }
      
      public void a(LiveRoomUserModel param1LiveRoomUserModel) {
        if (LiveFloatManager.a().B()) {
          AppMethods.d(R.string.no_landscape_mode);
          return;
        } 
        if (this.a.c instanceof RecordingOnliveFragment && this.a.c != null) {
          if (!((RecordingOnliveFragment)this.a.c).f(false))
            return; 
          LiveMsgManager.a(this.a, param1LiveRoomUserModel);
        } 
      }
      
      public void a(String param1String) {
        LiveRoomHttpUtils.a(String.valueOf(this.a.e), param1String, "2");
      }
      
      public void a(String param1String, LiveMsgReportModel param1LiveMsgReportModel) {
        if (CommonStringUtils.c(param1String) == LiveRoomManager.a().d()) {
          LiveRefreshUIObserver.a().l();
          return;
        } 
        this.a.a(param1LiveMsgReportModel, param1String);
      }
      
      public void a(String param1String1, String param1String2) {
        LiveRoomHttpUtils.a(String.valueOf(this.a.e), param1String1, "1");
        if (LiveFloatManager.a().w()) {
          ProfileData profileData = new ProfileData();
          profileData.uid = Long.valueOf(param1String1).longValue();
          profileData.name = param1String2;
          Logger.a("rrb", new Object[] { "uid = ", param1String1 });
          Logger.a("rrb", new Object[] { "name = ", param1String2 });
          LiveMsgSendManager.a().b(profileData);
        } 
      }
      
      public void b() {
        AppInfo.n().post(new Runnable(this) {
              public void run() {
                if (this.a.a.c instanceof RecordingOnliveFragment) {
                  if (((RecordingOnliveFragment)this.a.a.c).be) {
                    ((RecordingOnliveFragment)this.a.a.c).h(4);
                  } else {
                    ((RecordingOnliveFragment)this.a.a.c).g(4);
                  } 
                } else {
                  LiveRefreshUIObserver.a().d(4);
                } 
                this.a.a.a(4);
                Logger.a("drb", new Object[] { "onShow setChatViewVisibility" });
              }
            });
      }
      
      public void b(String param1String1, String param1String2) {
        LiveSetDataObserver.a().b(param1String2);
      }
      
      public void c() {
        if (this.a.c instanceof PlayingOnliveBaseModeFragment && this.a.c != null)
          LiveRefreshUIObserver.a().b(true); 
      }
      
      public void c(String param1String1, String param1String2) {
        LiveRoomHttpUtils.a(String.valueOf(this.a.e), param1String1, "0");
        if (LiveFloatManager.a().w()) {
          ProfileData profileData = new ProfileData();
          profileData.uid = CommonStringUtils.c(param1String1);
          profileData.name = param1String2;
          LiveMsgSendManager.a().a(profileData);
        } 
      }
      
      public void d() {
        if (this.a.c instanceof RecordingOnliveFragment && this.a.c != null)
          ((RecordingOnliveFragment)this.a.c).U(); 
      }
    };
  
  private PopUserCard y;
  
  private String z;
  
  public LiveMsgManager(BaseFragment paramBaseFragment) {
    a(paramBaseFragment);
    a();
    u();
    v();
  }
  
  private void a(BaseFragment paramBaseFragment) {
    this.g = (Context)paramBaseFragment.getActivity();
    this.c = paramBaseFragment;
    this.b = paramBaseFragment.w_();
    if (paramBaseFragment instanceof RecordingOnliveFragment) {
      this.f = true;
      this.a = ((RecordingOnliveFragment)paramBaseFragment).e;
      return;
    } 
    if (paramBaseFragment instanceof PlayingOnliveBaseModeFragment) {
      this.f = false;
      PlayingOnliveBaseModeFragment playingOnliveBaseModeFragment = (PlayingOnliveBaseModeFragment)paramBaseFragment;
      this.a = playingOnliveBaseModeFragment.e;
      this.d = playingOnliveBaseModeFragment.x;
      this.e = playingOnliveBaseModeFragment.y;
      if (paramBaseFragment instanceof com.blued.android.module.live_china.fragment.PlayingOnliveSimpleModeFragment) {
        this.u = 1;
      } else if (paramBaseFragment instanceof com.blued.android.module.live_china.fragment.PlayingOnliveFullModeFragment) {
        this.u = 0;
      } 
      n();
    } 
  }
  
  private void b(LiveRoomUserModel paramLiveRoomUserModel) {
    LiveRoomHttpUtils.d(new BluedUIHttpResponse(this, (IRequestHost)this.c.w_(), paramLiveRoomUserModel) {
          public void onUIFinish() {
            super.onUIFinish();
          }
          
          public void onUIStart() {
            super.onUIStart();
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            if (this.b.c instanceof RecordingOnliveFragment && this.b.c != null)
              ((RecordingOnliveFragment)this.b.c).h(this.a.avatar); 
          }
        }paramLiveRoomUserModel.uid, 1);
  }
  
  private void q() {
    if (LiveRoomManager.a().h() != null && LiveRoomManager.a().s() != null) {
      ShapeLinearLayout shapeLinearLayout = this.B;
      if (shapeLinearLayout != null && this.A != null) {
        if (this.u == 1)
          return; 
        if (shapeLinearLayout.getVisibility() == 8)
          this.B.setVisibility(0); 
        if (this.A.getVisibility() == 8) {
          ShapeHelper.b((ShapeHelper.ShapeView)this.B, R.color.syc_e6ffffff);
          this.C.setVisibility(0);
          return;
        } 
        if (this.A.getVisibility() == 0) {
          ShapeHelper.b((ShapeHelper.ShapeView)this.B, R.color.syc_00ffffff);
          this.C.setVisibility(8);
        } 
      } 
    } 
  }
  
  private void r() {
    this.o = true;
    TextView textView = this.A;
    if (textView != null) {
      textView.setVisibility(8);
      q();
    } 
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            this.a.h.setSelection(this.a.j.getCount());
          }
        },  10L);
  }
  
  private boolean s() {
    BaseFragment baseFragment = this.c;
    boolean bool = baseFragment instanceof PlayingOnliveBaseModeFragment;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool) {
      bool1 = bool2;
      if (baseFragment != null) {
        bool1 = bool2;
        if (((PlayingOnliveBaseModeFragment)baseFragment).ak == 4)
          bool1 = true; 
      } 
    } 
    return bool1;
  }
  
  private void t() {
    BaseFragment baseFragment = this.c;
    if (baseFragment instanceof RecordingOnliveFragment) {
      this.z = LiveRoomInfo.a().f();
    } else if (baseFragment instanceof PlayingOnliveBaseModeFragment && !LiveRoomManager.a().l()) {
      this.z = LiveRoomManager.a().e();
    } 
    if (TextUtils.isEmpty(this.z) || this.z.equals("0"))
      this.z = "0"; 
    if (LiveFloatManager.a().B()) {
      this.y = (PopUserCard)new PopUserCardCenter(this.g, (IRequestHost)this.b, this.z, Long.valueOf(this.e), Short.valueOf(this.d), this.w);
      return;
    } 
    this.y = new PopUserCard(this.g, (IRequestHost)this.b, this.z, Long.valueOf(this.e), Short.valueOf(this.d), this.w);
  }
  
  private void u() {
    this.j = new LiveMsgContentAdapter(this, this.i);
    this.h.setAdapter((ListAdapter)this.j);
    this.H = new GiftAnimManager();
    this.H.a(this, this.n);
  }
  
  private void v() {
    this.h.setOnScrollListener(new MyOnScrollListener());
  }
  
  public void a() {
    this.k = this.a.findViewById(R.id.live_msg_main_root);
    this.h = (ListView)this.k.findViewById(R.id.live_msg_content_pullrefresh);
    this.h.setStackFromBottom(true);
    this.h.setDividerHeight(AppMethods.a(3));
    this.A = (TextView)this.k.findViewById(R.id.tv_msg_scroll_to_bottom);
    TextView textView = this.A;
    if (textView != null)
      textView.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              LiveMsgManager.a(this.a);
              EventTrackLive.a(LiveProtos.Event.LIVE_NEW_MSG_CLICK, String.valueOf(this.a.e), LiveMsgManager.b(this.a));
            }
          }); 
    this.B = (ShapeLinearLayout)this.k.findViewById(R.id.fl_back_to_last_live_room);
    this.C = (TextView)this.k.findViewById(R.id.tv_back_to_last_live_room_tips);
    if (this.B != null && LiveRoomManager.a().s() != null && this.L == null && this.u == 0) {
      this.L = new Runnable(this) {
          public void run() {
            try {
              LiveRoomManager.a().b(null);
              LiveMsgManager.a(this.a, (Runnable)null);
              LiveMsgManager.c(this.a).setVisibility(8);
              return;
            } catch (Exception exception) {
              exception.printStackTrace();
              return;
            } 
          }
        };
      this.B.postDelayed(this.L, 180000L);
      this.B.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              LiveRoomData liveRoomData = LiveRoomManager.a().s();
              if (liveRoomData != null) {
                liveRoomData = new LiveRoomData(liveRoomData.lid, 0, "live_room_ranking", liveRoomData.profile.uid, liveRoomData.profile.name, liveRoomData.profile.avatar, liveRoomData.profile.vbadge);
                PlayingOnliveFragment.a(this.a.g, liveRoomData);
              } 
              LiveRoomManager.a().b(null);
            }
          });
      q();
    } 
    this.m = (LinearLayout)this.a.findViewById(R.id.live_msg_net_wifi);
    this.l = (RelativeLayout)this.a.findViewById(R.id.live_msg_net_wifi_layout);
    this.n = (LinearLayout)this.a.findViewById(R.id.ll_gift_ani_root);
    this.p = (BarrageView)this.a.findViewById(R.id.barrage);
    this.q = (EntranceEffectLayout)this.a.findViewById(R.id.approach_effect_barrage);
    this.r = (EntranceNormalLayout)this.a.findViewById(R.id.approach_normal_barrage);
    this.I = (QuickReplyView)this.a.findViewById(R.id.quick_reply_view);
    if (LiveFloatManager.a().B()) {
      this.s = (BarrageViewMultiOneRow)this.a.findViewById(R.id.multi_barrage);
      this.D = this.a.findViewById(R.id.barrage_occupy_view);
    } else {
      this.p.a = 3;
    } 
    this.E = this.a.findViewById(R.id.occupy_view);
    this.t = this.a.findViewById(R.id.barrage_space_view);
    this.F = this.a.findViewById(R.id.simple_model_high);
    this.G = this.a.findViewById(R.id.simple_model_low);
    this.J = this.a.findViewById(R.id.rl_msg_fans_reopen);
    this.K = this.a.findViewById(R.id.ll_msg_fans_reopen);
    this.K.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            EventTrackLive.a(LiveProtos.Event.LIVE_FANS_RENEW_TOAST_CLICK, String.valueOf(this.a.e), LiveMsgManager.b(this.a));
            LiveMsgManager.d(this.a).removeCallbacks(this.a.v);
            LiveMsgManager.d(this.a).setVisibility(8);
            LiveFansObserver.a().c();
          }
        });
    t();
    this.p.setUserCard(this.y);
    BarrageViewMultiOneRow barrageViewMultiOneRow = this.s;
    if (barrageViewMultiOneRow != null)
      barrageViewMultiOneRow.setUserCard(this.y); 
    GiftAnimManager giftAnimManager = this.H;
    if (giftAnimManager != null)
      giftAnimManager.a(this, this.n); 
    this.I.setOnItemClickListener(new -$$Lambda$LiveMsgManager$8GJT9PDAuWoCWh9ab1moArXIID4(this));
  }
  
  public void a(int paramInt) {
    int i;
    ListView listView = this.h;
    if (LiveFloatManager.a().B()) {
      i = 8;
    } else {
      i = paramInt;
    } 
    listView.setVisibility(i);
    BarrageViewMultiOneRow barrageViewMultiOneRow = this.s;
    if (barrageViewMultiOneRow != null)
      barrageViewMultiOneRow.setVisibility(paramInt); 
  }
  
  public void a(EntranceData paramEntranceData) {
    if (s())
      return; 
    this.q.a(paramEntranceData);
  }
  
  public void a(ChattingModel paramChattingModel) {
    GiftAnimManager giftAnimManager = this.H;
    if (giftAnimManager == null)
      return; 
    giftAnimManager.a(paramChattingModel);
  }
  
  public void a(LiveGiftModel paramLiveGiftModel) {
    GiftAnimManager giftAnimManager = this.H;
    if (giftAnimManager == null)
      return; 
    giftAnimManager.e(paramLiveGiftModel);
  }
  
  public void a(LiveMsgReportModel paramLiveMsgReportModel, String paramString) {
    Context context = this.g;
    AlertDialog alertDialog = CommonAlertDialog.a(context, null, 20, context.getString(R.string.liveVideo_livingView_tips_reportReason), null, this.g.getString(R.string.liveVideo_livingView_label_reportButton), "", null, new CommonAlertDialog.TextOnClickListener(this, paramLiveMsgReportModel, paramString) {
          public void a(String param1String) {
            LiveMsgReportModel liveMsgReportModel = this.a;
            if (liveMsgReportModel != null) {
              liveMsgReportModel.reportContent = param1String;
              LiveRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<LiveRoomUserModel>>(this) {
                    protected void a(BluedEntityA<LiveRoomUserModel> param2BluedEntityA) {
                      AppMethods.a(AppInfo.d().getString(R.string.liveVideo_livingView_tips_reportSuccess));
                    }
                  },  this.a);
            } else {
              String str = LiveUtils.a(this.c.j.a);
              if (!TextUtils.isEmpty(param1String) && !TextUtils.isEmpty(str)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(param1String);
                stringBuilder.append("\n");
                stringBuilder.append(str);
                param1String = stringBuilder.toString();
              } else if (TextUtils.isEmpty(param1String)) {
                if (!TextUtils.isEmpty(str)) {
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append("\n");
                  stringBuilder.append(str);
                  String str1 = stringBuilder.toString();
                } else {
                  param1String = "";
                } 
              } 
              Logger.b(LiveMsgManager.p(), new Object[] { "举报手输内容加聊天记录拼接字符串==", param1String });
              if (!TextUtils.isEmpty(param1String))
                LiveRoomInfo.a().a(this.c.g, param1String, this.b, this.c.e, (IRequestHost)this.c.b); 
            } 
            KeyboardUtils.a((Activity)this.c.c.getActivity());
          }
        }null);
    LiveRefreshUIObserver.a().a(alertDialog);
  }
  
  public void a(LiveRoomUserModel paramLiveRoomUserModel) {
    if (this.y == null)
      t(); 
    this.y.a(paramLiveRoomUserModel);
  }
  
  public void a(String paramString) {
    if (this.y == null)
      t(); 
    this.y.e(paramString);
  }
  
  public void a(String paramString, int paramInt) {
    if (this.y == null)
      t(); 
    this.y.a(paramString, paramInt);
  }
  
  public void a(String paramString, LiveMsgReportModel paramLiveMsgReportModel) {
    if (this.y == null)
      t(); 
    this.y.a(paramString, paramLiveMsgReportModel);
  }
  
  public void a(List<String> paramList) {
    if (this.y == null)
      t(); 
    this.y.a(paramList);
    q();
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b() {
    View view = this.J;
    if (view != null)
      view.removeCallbacks(this.v); 
    f();
  }
  
  public void b(int paramInt) {
    LiveMsgContentAdapter liveMsgContentAdapter = this.j;
    if (liveMsgContentAdapter != null) {
      if (liveMsgContentAdapter.a == null)
        return; 
      for (int i = this.j.a.size() - 1; i >= 0; i--) {
        if (paramInt == 2 && ((ChattingModel)this.j.a.get(i)).msgType == -10001) {
          this.j.a.remove(i);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("live_msg_daily_task_complete: ");
          stringBuilder.append(paramInt);
          stringBuilder.append(", index: ");
          stringBuilder.append(i);
          LogUtils.c(stringBuilder.toString());
          break;
        } 
        if (paramInt == 1 && ((ChattingModel)this.j.a.get(i)).msgType == -10000) {
          this.j.a.remove(i);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("live_msg_daily_task_complete: ");
          stringBuilder.append(paramInt);
          stringBuilder.append(", index: ");
          stringBuilder.append(i);
          LogUtils.c(stringBuilder.toString());
          break;
        } 
      } 
      this.j.notifyDataSetChanged();
    } 
  }
  
  public void b(ChattingModel paramChattingModel) {
    GiftAnimManager giftAnimManager = this.H;
    if (giftAnimManager == null)
      return; 
    giftAnimManager.b(paramChattingModel);
  }
  
  public void b(LiveGiftModel paramLiveGiftModel) {
    GiftAnimManager giftAnimManager = this.H;
    if (giftAnimManager == null)
      return; 
    giftAnimManager.a(paramLiveGiftModel);
  }
  
  public void b(String paramString) {
    if (this.y == null)
      t(); 
    this.y.f(paramString);
  }
  
  public void b(String paramString, LiveMsgReportModel paramLiveMsgReportModel) {
    if (this.y == null)
      t(); 
    this.y.b(paramString, paramLiveMsgReportModel);
  }
  
  public void b(List<LiveZanExtraModel.HotWords> paramList) {
    this.I.setData(paramList);
  }
  
  public void b(boolean paramBoolean) {
    Logger.a("drb", new Object[] { "onWifiStatus = ", Boolean.valueOf(paramBoolean) });
    e(paramBoolean);
  }
  
  public void c() {
    if (this.J != null && !LiveRoomPreferences.G()) {
      EventTrackLive.a(LiveProtos.Event.LIVE_FANS_RENEW_TOAST_SHOW, String.valueOf(this.e), this.z);
      this.J.setVisibility(0);
      this.J.postDelayed(this.v, 10000L);
      LiveRoomPreferences.H();
    } 
  }
  
  public void c(int paramInt) {
    GiftAnimManager giftAnimManager = this.H;
    if (giftAnimManager == null)
      return; 
    giftAnimManager.a(paramInt);
  }
  
  public void c(ChattingModel paramChattingModel) {
    if (this.s != null && LiveFloatManager.a().B()) {
      if (s())
        return; 
      this.s.b(paramChattingModel);
      return;
    } 
    this.p.a(paramChattingModel);
  }
  
  public void c(LiveGiftModel paramLiveGiftModel) {
    GiftAnimManager giftAnimManager = this.H;
    if (giftAnimManager == null)
      return; 
    giftAnimManager.b(paramLiveGiftModel);
  }
  
  public void c(String paramString) {
    this.z = paramString;
    PopUserCard popUserCard = this.y;
    if (popUserCard != null) {
      this.z = paramString;
      popUserCard.c(paramString);
    } 
    q();
  }
  
  public void c(String paramString, LiveMsgReportModel paramLiveMsgReportModel) {
    if (!TextUtils.isEmpty(paramString) && paramLiveMsgReportModel != null)
      b(paramString, paramLiveMsgReportModel); 
  }
  
  public void c(boolean paramBoolean) {
    if (paramBoolean) {
      this.F.setVisibility(0);
      this.G.setVisibility(8);
      Logger.a("ddrb", new Object[] { "mSimpleModelHighView VISIBLE" });
      return;
    } 
    if (!LiveFloatManager.a().B()) {
      this.F.setVisibility(8);
      Logger.a("ddrb", new Object[] { "mSimpleModelHighView GONE" });
      this.G.setVisibility(0);
    } 
  }
  
  public void d() {
    LiveMsgContentAdapter liveMsgContentAdapter = this.j;
    if (liveMsgContentAdapter != null)
      liveMsgContentAdapter.notifyDataSetChanged(); 
  }
  
  public void d(int paramInt) {
    this.I.setQuickReplyViewVisibility(paramInt);
  }
  
  public void d(ChattingModel paramChattingModel) {
    BarrageViewMultiOneRow barrageViewMultiOneRow = this.s;
    if (barrageViewMultiOneRow == null) {
      e(paramChattingModel);
      return;
    } 
    barrageViewMultiOneRow.b(paramChattingModel);
  }
  
  public void d(LiveGiftModel paramLiveGiftModel) {
    GiftAnimManager giftAnimManager = this.H;
    if (giftAnimManager == null)
      return; 
    giftAnimManager.c(paramLiveGiftModel);
  }
  
  public void d(String paramString) {
    if (!TextUtils.isEmpty(paramString))
      b(paramString); 
  }
  
  public void d(String paramString, LiveMsgReportModel paramLiveMsgReportModel) {
    if (!TextUtils.isEmpty(paramString) && paramLiveMsgReportModel != null)
      a(paramString, paramLiveMsgReportModel); 
  }
  
  public void d(boolean paramBoolean) {
    LiveMsgContentAdapter liveMsgContentAdapter = this.j;
    if (liveMsgContentAdapter != null)
      liveMsgContentAdapter.a(paramBoolean); 
  }
  
  public void e() {
    PopUserCard popUserCard = this.y;
    if (popUserCard != null && popUserCard.s())
      this.y.q(); 
  }
  
  public void e(ChattingModel paramChattingModel) {
    Logger.a("rrb", new Object[] { "普通进场提示消息 model = ", Integer.valueOf(paramChattingModel.fromLiveManager) });
    ChattingModel chattingModel = this.j.b();
    if (chattingModel != null && (chattingModel.msgType == 27 || chattingModel.msgType == 51)) {
      this.j.a(paramChattingModel);
    } else {
      this.j.a(paramChattingModel);
    } 
    if (this.o)
      r(); 
  }
  
  public void e(boolean paramBoolean) {
    Logger.a("drb", new Object[] { "onWifiNo = ", Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      Logger.a("drb", new Object[] { "onWifiNo 横屏主态喇叭 " });
      LiveHornModel liveHornModel = new LiveHornModel();
      liveHornModel.content = AppInfo.d().getString(R.string.Live_SendPresent_notWifi);
      liveHornModel.type = 2;
      liveHornModel.is_wifi = true;
      BaseFragment baseFragment = this.c;
      if (baseFragment instanceof RecordingOnliveFragment) {
        ((RecordingOnliveFragment)baseFragment).a(liveHornModel, true);
        return;
      } 
      if (baseFragment instanceof PlayingOnliveBaseModeFragment) {
        Logger.a("drb", new Object[] { "onWifiNo 横屏客态喇叭 " });
        LiveSetDataObserver.a().a(liveHornModel, true);
      } 
    } 
  }
  
  public void f() {
    if (this.H == null)
      return; 
    ShapeLinearLayout shapeLinearLayout = this.B;
    if (shapeLinearLayout != null) {
      Runnable runnable = this.L;
      if (runnable != null) {
        shapeLinearLayout.removeCallbacks(runnable);
        this.L = null;
      } 
    } 
    this.H.e();
    this.H = null;
    this.c = null;
  }
  
  public void f(ChattingModel paramChattingModel) {
    ChattingModel chattingModel = this.j.b();
    if (chattingModel != null && (chattingModel.msgType == 27 || chattingModel.msgType == 51)) {
      this.j.a(paramChattingModel);
      if (paramChattingModel.msgType != 27 || paramChattingModel.msgType != 103 || paramChattingModel.msgType != 104)
        LiveRoomManager.a().a(paramChattingModel); 
    } else {
      this.j.a.add(paramChattingModel);
      LiveRoomManager.a().a(paramChattingModel);
    } 
    if (LiveFloatManager.a().B()) {
      c(paramChattingModel);
      Logger.a("rrb", new Object[] { "addDanmaku" });
    } 
  }
  
  public void g() {
    GiftAnimManager giftAnimManager = this.H;
    if (giftAnimManager == null)
      return; 
    giftAnimManager.f();
  }
  
  public void g(ChattingModel paramChattingModel) {
    if (paramChattingModel == null)
      return; 
    short s = paramChattingModel.msgType;
    boolean bool = false;
    if (51 == s)
      Logger.a("674", new Object[] { "收到第一次点赞消息：", paramChattingModel.fromNickName }); 
    if (s != 1) {
      if (s != 27)
        if (s != 33) {
          if (s != 61)
            if (s != 155) {
              if (s != 194) {
                if (s != 202) {
                  LiveMsgSendManager liveMsgSendManager;
                  StringBuilder stringBuilder;
                  switch (s) {
                    default:
                      switch (s) {
                        default:
                          switch (s) {
                            default:
                              return;
                            case 106:
                            case 107:
                            case 108:
                            case 109:
                              break;
                          } 
                          break;
                        case 103:
                        case 104:
                          if (this.c instanceof PlayingOnliveBaseModeFragment && paramChattingModel.fromId == Integer.valueOf(LiveRoomInfo.a().f()).intValue()) {
                            h(paramChattingModel);
                            return;
                          } 
                          return;
                        case 102:
                          break;
                      } 
                      Log.i("xpp", "MT_LIVECHAT_RICH_LEVEL");
                      if (paramChattingModel.fromId == Integer.valueOf(LiveRoomInfo.a().f()).intValue()) {
                        StringBuilder stringBuilder1 = new StringBuilder();
                        stringBuilder1.append("MT_LIVECHAT_RICH_LEVEL :");
                        stringBuilder1.append(paramChattingModel.fromRichLevel);
                        Log.i("xpp", stringBuilder1.toString());
                        LiveRoomInfo.a().a(paramChattingModel.fromRichLevel);
                      } 
                      h(paramChattingModel);
                      liveMsgSendManager = LiveMsgSendManager.a();
                      stringBuilder = new StringBuilder();
                      stringBuilder.append("收到财富等级升级消息：");
                      stringBuilder.append(paramChattingModel.fromRichLevel);
                      liveMsgSendManager.b(stringBuilder.toString());
                      return;
                    case 50:
                      paramChattingModel.msgContent = AppInfo.d().getResources().getString(R.string.live_shared);
                      h(paramChattingModel);
                      return;
                    case 49:
                      paramChattingModel.msgContent = AppInfo.d().getResources().getString(R.string.live_following);
                      h(paramChattingModel);
                      return;
                    case 51:
                      break;
                  } 
                } else {
                  if (this.c instanceof RecordingOnliveFragment) {
                    h(paramChattingModel);
                    return;
                  } 
                  return;
                } 
              } else {
                if (this.c instanceof RecordingOnliveFragment) {
                  paramChattingModel.msgType = -10002;
                  paramChattingModel.msgContent = AppInfo.d().getResources().getString(R.string.live_use_card_ok);
                  h(paramChattingModel);
                  LiveEventBus.get("live_used_top_card").post("");
                  return;
                } 
                return;
              } 
            } else {
              if (!LiveRoomManager.a().l())
                paramChattingModel.fromNickName = (LiveRoomManager.a().h()).profile.name; 
              h(paramChattingModel);
              LiveMsgSendManager.a().b("收到主播升级消息");
              return;
            }  
        } else {
          if (paramChattingModel.fromId != LiveRoomInfo.a().g())
            a(paramChattingModel); 
          h(paramChattingModel);
          return;
        }  
      h(paramChattingModel);
      return;
    } 
    if (LiveRoomManager.a().w() && paramChattingModel.fromId != LiveRoomInfo.a().g()) {
      int i;
      if (this.c instanceof com.blued.android.module.live_china.fragment.PlayingOnliveSimpleModeFragment)
        return; 
      s = bool;
      if (paramChattingModel.msgMapExtra != null) {
        s = bool;
        if (paramChattingModel.msgMapExtra.containsKey("is_history_data"))
          i = ((Integer)paramChattingModel.msgMapExtra.get("is_history_data")).intValue(); 
      } 
      if (i == 1) {
        h(paramChattingModel);
        return;
      } 
      LiveRoomManager.a().b(paramChattingModel);
      return;
    } 
    h(paramChattingModel);
  }
  
  public void h() {
    GiftAnimManager giftAnimManager = this.H;
    if (giftAnimManager == null)
      return; 
    giftAnimManager.a();
  }
  
  public void h(ChattingModel paramChattingModel) {
    if (paramChattingModel == null)
      return; 
    if (this.j.a == null)
      this.j.a = new ArrayList(); 
    if (paramChattingModel.msgType == 61) {
      List<LiveMsgBonusExtra> list = LiveMsgBonusExtra.parseBonusMap(MsgPackHelper.getListValue(paramChattingModel.msgMapExtra, "bonus"));
      if (list != null)
        for (int i = 0; i < list.size(); i++) {
          LiveMsgBonusExtra liveMsgBonusExtra = list.get(i);
          ArrayMap arrayMap = new ArrayMap();
          MsgPackHelper.putMapValue((Map)arrayMap, "id", liveMsgBonusExtra.id);
          MsgPackHelper.putMapValue((Map)arrayMap, "count", liveMsgBonusExtra.count);
          MsgPackHelper.putMapValue((Map)arrayMap, "image", liveMsgBonusExtra.image);
          if (liveMsgBonusExtra.profile != null) {
            MsgPackHelper.putMapValue((Map)arrayMap, "uid", liveMsgBonusExtra.profile.uid);
            MsgPackHelper.putMapValue((Map)arrayMap, "name", liveMsgBonusExtra.profile.name);
          } 
          paramChattingModel.msgMapExtra = (Map)arrayMap;
          this.j.a.add(paramChattingModel);
          if (LiveFloatManager.a().B())
            c(paramChattingModel); 
        }  
    } else if (paramChattingModel.msgType == 27 || paramChattingModel.msgType == 51) {
      e(paramChattingModel);
      if (LiveFloatManager.a().B())
        c(paramChattingModel); 
    } else {
      f(paramChattingModel);
    } 
    if (!this.o) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramChattingModel.fromId);
      stringBuilder.append("");
      if (!TextUtils.equals(stringBuilder.toString(), LiveRoomInfo.a().f())) {
        if (this.A.getVisibility() == 8) {
          this.A.setVisibility(0);
          q();
        } 
        EventTrackLive.a(LiveProtos.Event.LIVE_NEW_MSG_SHOW, String.valueOf(this.e), this.z);
        if (this.j.a.size() > 1000)
          for (int i = this.j.a.size() - 1000; i > 0; i--)
            this.j.a.remove(0);  
        this.j.notifyDataSetChanged();
        return;
      } 
    } 
    if (this.j.a.size() > 100)
      for (int i = this.j.a.size() - 100; i > 0; i--)
        this.j.a.remove(0);  
    this.j.notifyDataSetChanged();
    r();
  }
  
  public List<LiveGiftModel> i() {
    GiftAnimManager giftAnimManager = this.H;
    return (giftAnimManager == null) ? new ArrayList<LiveGiftModel>() : giftAnimManager.b();
  }
  
  public List<LiveGiftModel> j() {
    GiftAnimManager giftAnimManager = this.H;
    return (giftAnimManager == null) ? new ArrayList<LiveGiftModel>() : giftAnimManager.c();
  }
  
  public void k() {
    RelativeLayout relativeLayout = this.l;
    if (relativeLayout != null)
      relativeLayout.setVisibility(8); 
    this.E.setVisibility(8);
  }
  
  public void l() {
    this.E.setVisibility(0);
  }
  
  public void m() {
    EventTrackLive.a(LiveProtos.Event.LIVE_REPORT_BTN_CLICK, String.valueOf(this.e), this.z);
    this.w.a(this.z, null);
  }
  
  public void n() {
    BaseFragment baseFragment = this.c;
    if (baseFragment instanceof RecordingOnliveFragment) {
      this.d = ((RecordingOnliveFragment)baseFragment).t;
      this.e = ((RecordingOnliveFragment)this.c).u;
      a();
    } 
    if (NetworkUtils.a())
      e(false); 
  }
  
  public void o() {
    if (this.c instanceof com.blued.android.module.live_china.fragment.PlayingOnliveSimpleModeFragment)
      return; 
    this.j.a().addAll(LiveRoomManager.a().t());
    this.j.notifyDataSetChanged();
  }
  
  class MyOnScrollListener implements AbsListView.OnScrollListener {
    private MyOnScrollListener(LiveMsgManager this$0) {}
    
    public void onScroll(AbsListView param1AbsListView, int param1Int1, int param1Int2, int param1Int3) {}
    
    public void onScrollStateChanged(AbsListView param1AbsListView, int param1Int) {
      boolean bool = true;
      if (param1Int != 0) {
        if (param1Int != 1)
          return; 
      } else {
        LiveMsgManager liveMsgManager = this.a;
        if (param1AbsListView.getLastVisiblePosition() != param1AbsListView.getCount() - 1)
          bool = false; 
        liveMsgManager.o = bool;
        if (this.a.o)
          AppInfo.n().post(new Runnable(this) {
                public void run() {
                  if (LiveMsgManager.e(this.a.a) != null && LiveMsgManager.e(this.a.a).getVisibility() == 0) {
                    LiveMsgManager.e(this.a.a).setVisibility(8);
                    LiveMsgManager.f(this.a.a);
                  } 
                }
              }); 
      } 
    }
  }
  
  class null implements Runnable {
    null(LiveMsgManager this$0) {}
    
    public void run() {
      if (LiveMsgManager.e(this.a.a) != null && LiveMsgManager.e(this.a.a).getVisibility() == 0) {
        LiveMsgManager.e(this.a.a).setVisibility(8);
        LiveMsgManager.f(this.a.a);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\liveForMsg\LiveMsgManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */