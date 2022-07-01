package com.blued.android.module.yy_china.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AudioManagerUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live.base.utils.LiveAlterDialog;
import com.blued.android.module.live.base.utils.LiveLogUtils;
import com.blued.android.module.live.base.utils.LiveSettingConfig;
import com.blued.android.module.live.base.view.animation.LiveAnimationView;
import com.blued.android.module.yy_china.NotificationService;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.BaseConnectingAdapter;
import com.blued.android.module.yy_china.adapter.YYConnectingAdapter;
import com.blued.android.module.yy_china.adapter.YYConnectingCPAdapter;
import com.blued.android.module.yy_china.manager.YYGiftAnimManager;
import com.blued.android.module.yy_china.manager.YYImMsgManager;
import com.blued.android.module.yy_china.manager.YYObserverManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.BlindPublishModel;
import com.blued.android.module.yy_china.model.YYAudienceModel;
import com.blued.android.module.yy_china.model.YYHeartModel;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYMsgEmojiExtra;
import com.blued.android.module.yy_china.model.YYMsgWarningExtra;
import com.blued.android.module.yy_china.model.YYReportModel;
import com.blued.android.module.yy_china.model.YYRetryRoomModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.presenter.YYCPPresenter;
import com.blued.android.module.yy_china.trtc_audio.IAudioContract;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.android.module.yy_china.trtc_audio.model.GenerateTestUserSig;
import com.blued.android.module.yy_china.trtc_audio.permission.PermissionHelper;
import com.blued.android.module.yy_china.utils.PopupwindowFactory;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.AudienceUserCardView;
import com.blued.android.module.yy_china.view.GiftBaseHitView;
import com.blued.android.module.yy_china.view.RoomMemberListView;
import com.blued.android.module.yy_china.view.SeatUserCardView;
import com.blued.android.module.yy_china.view.WaittingListView;
import com.blued.android.module.yy_china.view.YYAudienceListView;
import com.blued.android.module.yy_china.view.YYBottomView;
import com.blued.android.module.yy_china.view.YYBroadcastView;
import com.blued.android.module.yy_china.view.YYCardOptionView;
import com.blued.android.module.yy_china.view.YYEmojiView;
import com.blued.android.module.yy_china.view.YYFloatVoteView;
import com.blued.android.module.yy_china.view.YYHostEndView;
import com.blued.android.module.yy_china.view.YYImListView;
import com.blued.android.module.yy_china.view.YYIncomeView;
import com.blued.android.module.yy_china.view.YYMoreMenuView;
import com.blued.android.module.yy_china.view.YYMusicFloatView;
import com.blued.android.module.yy_china.view.YYOtherEndView;
import com.blued.android.module.yy_china.view.YYRenameView;
import com.blued.android.module.yy_china.view.YYReportView;
import com.blued.android.module.yy_china.view.YYSendVoteView;
import com.blued.android.module.yy_china.view.YYStudioTitleView;
import com.blued.android.module.yy_china.view.YYToolBoxView;
import com.blued.android.module.yy_china.view.YYTypingView;
import com.blued.android.module.yy_china.view.YYUserVoteView;
import com.blued.android.module.yy_china.view.YYVoteResultView;
import com.blued.android.module.yy_china.view.YYWaittingView;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.tencent.trtc.TRTCCloudDef;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public abstract class BaseYYStudioFragment extends KeyBoardFragment {
  public boolean A = false;
  
  private View B;
  
  private RecyclerView C;
  
  private YYImListView D;
  
  private KeyboardListenLinearLayout E;
  
  private YYAudienceListView F;
  
  private LinearLayout G;
  
  private GiftBaseHitView H;
  
  private GiftBaseHitView I;
  
  private LiveAnimationView J;
  
  private View K;
  
  private YYTypingView L;
  
  private YYBroadcastView M;
  
  private ShapeTextView N;
  
  private YYFloatVoteView O;
  
  private int P;
  
  private int Q;
  
  private YYGiftAnimManager R;
  
  private boolean S = false;
  
  private boolean T = false;
  
  private YYMusicFragment U;
  
  private long V = 0L;
  
  private ShapeTextView W;
  
  private YYCPPresenter X;
  
  private YYGiftListFragment Y;
  
  public Context e;
  
  protected YYStudioTitleView f;
  
  protected YYBottomView o;
  
  protected YYMusicFloatView p;
  
  protected FrameLayout q;
  
  protected YYHostEndView r;
  
  protected YYOtherEndView s;
  
  protected YYIncomeView t;
  
  protected YYWaittingView u;
  
  protected ShapeTextView v;
  
  protected ImageView w;
  
  public BaseConnectingAdapter x;
  
  public PopupWindow y;
  
  public boolean z = false;
  
  private void V() {
    this.R = new YYGiftAnimManager(this, this.H, this.I, this.J);
  }
  
  private void W() {
    FrameLayout frameLayout = (FrameLayout)this.B.findViewById(R.id.yy_container);
    ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
    this.B.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this, layoutParams, frameLayout) {
          public void onGlobalLayout() {
            int i = BaseYYStudioFragment.f(this.c).getHeight();
            if (i != 0) {
              BaseYYStudioFragment.f(this.c).getViewTreeObserver().removeOnGlobalLayoutListener(this);
              this.a.height = i;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("params.height:");
              stringBuilder.append(this.a.height);
              Log.i("==xpf", stringBuilder.toString());
              this.b.setLayoutParams(this.a);
            } 
          }
        });
    this.f = (YYStudioTitleView)this.B.findViewById(R.id.ll_title_view);
    this.f.a(this);
    this.p = (YYMusicFloatView)this.B.findViewById(R.id.music_float);
    this.W = (ShapeTextView)this.B.findViewById(R.id.tv_cp_guide);
    this.o = (YYBottomView)this.B.findViewById(R.id.ll_bottom);
    this.o.a(this, this.z);
    this.u = (YYWaittingView)this.B.findViewById(R.id.ll_waitting_layout);
    this.u.a(this);
    this.t = (YYIncomeView)this.B.findViewById(R.id.income_view);
    this.t.a(this);
    this.F = (YYAudienceListView)this.B.findViewById(R.id.ll_audience_layout);
    this.F.a(this);
    this.D = (YYImListView)this.B.findViewById(R.id.rv_im_list_view);
    this.D.a(this);
    this.O = (YYFloatVoteView)this.B.findViewById(R.id.vote_time);
    this.O.a(this);
    this.q = (FrameLayout)this.B.findViewById(R.id.ll_gift_layout);
    this.r = (YYHostEndView)this.B.findViewById(R.id.ll_end_view);
    this.s = (YYOtherEndView)this.B.findViewById(R.id.ll_other_end_view);
    this.C = (RecyclerView)this.B.findViewById(R.id.rv_chatting_list_view);
    this.E = (KeyboardListenLinearLayout)this.B.findViewById(R.id.keyboard_linear_layout);
    this.J = (LiveAnimationView)this.B.findViewById(R.id.live_animation_layout);
    this.v = (ShapeTextView)this.B.findViewById(R.id.tv_report);
    this.w = (ImageView)this.B.findViewById(R.id.room_img);
    this.G = (LinearLayout)this.B.findViewById(R.id.ll_hit_view);
    this.H = (GiftBaseHitView)this.B.findViewById(R.id.hitView1);
    this.I = (GiftBaseHitView)this.B.findViewById(R.id.hitView2);
    this.L = (YYTypingView)this.B.findViewById(R.id.typing_view);
    this.M = (YYBroadcastView)this.B.findViewById(R.id.ll_broadcast_layout);
    this.M.a(R.drawable.shape_raduis_tl_tr_12_151515);
    this.M.b(false);
    this.M.a(true);
    this.M.setEditable(true);
    this.M.setContentMinHeight(DensityUtils.a(getContext(), 120.0F));
    this.K = this.B.findViewById(R.id.keyboard_view);
    this.K.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            KeyboardUtils.a((Activity)this.a.getActivity());
          }
        });
    this.N = (ShapeTextView)this.B.findViewById(R.id.tv_broadcast);
    this.N.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
            if (yYRoomModel != null)
              EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_NOTICE_CLICK, yYRoomModel.room_id, yYRoomModel.uid); 
            this.a.Q();
          }
        });
    this.W.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.t();
          }
        });
    X();
    M();
    if (YYRoomInfoManager.d().b() != null) {
      ImageLoader.a((IRequestHost)w_(), (YYRoomInfoManager.d().b()).type_img).a(this.w);
      if (YYRoomInfoManager.d().b().isCPChannel()) {
        this.W.setVisibility(0);
        return;
      } 
      this.W.setVisibility(8);
    } 
  }
  
  private void X() {
    GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 4);
    this.C.setLayoutManager((RecyclerView.LayoutManager)gridLayoutManager);
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel != null && yYRoomModel.isCPChannel()) {
      this.x = (BaseConnectingAdapter)new YYConnectingCPAdapter(getContext(), this);
      this.C.setAdapter((RecyclerView.Adapter)this.x);
      this.x.a(this.C);
      gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(this, gridLayoutManager) {
            public int getSpanSize(int param1Int) {
              return (param1Int == 0) ? this.c.getSpanCount() : 1;
            }
          });
    } else {
      this.x = (BaseConnectingAdapter)new YYConnectingAdapter(getContext(), this);
      this.C.setAdapter((RecyclerView.Adapter)this.x);
      this.x.a(this.C);
    } 
    a(this.x);
  }
  
  private void Y() {
    YYVoteResultView yYVoteResultView = new YYVoteResultView(getContext());
    yYVoteResultView.a(this);
    a((View)yYVoteResultView, -2);
  }
  
  private void Z() {
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null)
      return; 
    YYRoomHttpUtils.f(yYRoomModel.room_id, new BluedUIHttpResponse<BluedEntityA<YYRetryRoomModel>>(this, (IRequestHost)w_(), yYRoomModel) {
          protected void a(BluedEntityA<YYRetryRoomModel> param1BluedEntityA) {
            if (param1BluedEntityA != null) {
              if (!param1BluedEntityA.hasData())
                return; 
              if (LiveSettingConfig.a().b()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("retryConnect() ---> ");
                stringBuilder.append(param1BluedEntityA.toString());
                LiveLogUtils.a(stringBuilder.toString(), LiveLogUtils.a());
              } 
              if (BaseYYStudioFragment.d(this.b) != null) {
                Logger.e("sdk", new Object[] { "onConnectionRecovery ---> audienceLayout.init()" });
                BaseYYStudioFragment.d(this.b).a(this.b);
              } 
              YYRetryRoomModel yYRetryRoomModel = (YYRetryRoomModel)param1BluedEntityA.getSingleData();
              if (!TextUtils.equals(this.a.room_name, yYRetryRoomModel.room_name) && this.b.f != null) {
                this.a.room_name = yYRetryRoomModel.room_name;
                this.b.f.a();
              } 
              if (!TextUtils.isEmpty(this.a.relationship) && !TextUtils.equals(this.a.relationship, yYRetryRoomModel.relationship) && this.b.f != null)
                this.b.f.a(YYRoomInfoManager.d().e(), yYRetryRoomModel.relationship); 
              List list = yYRetryRoomModel.mics;
              if (yYRetryRoomModel.isCPChannel()) {
                ((YYSeatMemberModel)list.get(0)).itemType = 1;
                if (yYRetryRoomModel.getCPPresentStep() != this.a.getCPPresentStep())
                  this.b.x.a(yYRetryRoomModel.getCPPresentStep(), yYRetryRoomModel.getCPNextStep(), true); 
              } 
              this.a.setSeatList(list);
              if (yYRetryRoomModel.isCPChannel() && yYRetryRoomModel.blind_publish != null && !yYRetryRoomModel.blind_publish.isEmpty()) {
                for (BlindPublishModel blindPublishModel : yYRetryRoomModel.blind_publish) {
                  YYSeatMemberModel yYSeatMemberModel = this.a.getSeatMember(blindPublishModel.uid);
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append(blindPublishModel.choose_seat_num);
                  stringBuilder.append("");
                  yYSeatMemberModel.likeNum = stringBuilder.toString();
                } 
                this.b.x.a(null);
              } 
              YYUserInfo yYUserInfo = (YYRoomInfoManager.d()).a;
              if (yYUserInfo == null)
                return; 
              yYUserInfo.push_url = yYRetryRoomModel.publish_url;
              if (!TextUtils.equals(yYUserInfo.chat_anchor, yYRetryRoomModel.chat_anchor))
                yYUserInfo.chat_anchor = yYRetryRoomModel.chat_anchor; 
              if (yYUserInfo.is_open_mic != yYRetryRoomModel.is_open_mic)
                YYObserverManager.a().c(yYRetryRoomModel.is_open_mic); 
              if (!TextUtils.equals(yYUserInfo.is_mic, yYRetryRoomModel.is_mic)) {
                if (TextUtils.equals(yYRetryRoomModel.is_mic, "1")) {
                  YYObserverManager.a().a("1");
                } else {
                  YYObserverManager.a().a(yYUserInfo.chat_anchor);
                } 
                yYUserInfo.is_mic = yYRetryRoomModel.is_mic;
              } 
              if (yYRetryRoomModel.vote_countdown > 0L)
                YYRoomInfoManager.d().a(yYRetryRoomModel.vote_countdown); 
              yYUserInfo.mute = yYRetryRoomModel.mute;
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            if (LiveSettingConfig.a().b()) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("retryConnect() ---> onUIFailure() errorCode:");
              stringBuilder.append(param1Int);
              LiveLogUtils.a(stringBuilder.toString(), LiveLogUtils.a());
            } 
            if (param1Int == 40380002) {
              ToastUtils.a("房间已关闭", 0);
              if (YYRoomInfoManager.d().b() != null && TextUtils.equals((YYRoomInfoManager.d().b()).uid, YYRoomInfoManager.d().e())) {
                this.b.b(this.a.room_id);
              } else {
                this.b.P();
              } 
            } else if (param1Int == 40380030) {
              ToastUtils.a("你已被房主移出了房间", 0);
              YYRoomInfoManager.d().l();
              this.b.getActivity().finish();
            } else if (param1Int == 40380022) {
              YYRoomInfoManager.d().l();
              this.b.getActivity().finish();
            } 
            return super.onUIFailure(param1Int, param1String);
          }
        }(IRequestHost)w_());
  }
  
  public static void a(Context paramContext) {
    if ((YYRoomInfoManager.d()).a != null) {
      if (TextUtils.isEmpty((YYRoomInfoManager.d()).a.chat_anchor))
        return; 
      if ((YYRoomInfoManager.d()).a.chat_anchor.equals("1")) {
        a(paramContext, true);
        return;
      } 
      b(paramContext, true);
    } 
  }
  
  private static void a(Context paramContext, Class paramClass, Bundle paramBundle) {
    AudioManagerUtils.a().b();
    TerminalActivity.a(paramBundle);
    TerminalActivity.b(paramBundle);
    TerminalActivity.d(paramContext, paramClass, paramBundle);
  }
  
  public static void a(Context paramContext, boolean paramBoolean) {
    Bundle bundle = new Bundle();
    bundle.putBoolean("from_float", paramBoolean);
    a(paramContext, RecordingStudioFragment.class, bundle);
  }
  
  private void a(BaseConnectingAdapter paramBaseConnectingAdapter) {
    paramBaseConnectingAdapter.a(new BaseQuickAdapter.OnItemClickListener(this) {
          public void onItemClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
            YYSeatMemberModel yYSeatMemberModel = param1BaseQuickAdapter.n().get(param1Int);
            this.a.a(param1View, yYSeatMemberModel, yYSeatMemberModel.mic_position);
          }
        });
    if (YYRoomInfoManager.d().b() != null) {
      paramBaseConnectingAdapter.c((YYRoomInfoManager.d().b()).mics);
      this.C.scrollToPosition(paramBaseConnectingAdapter.getItemCount() - 1);
    } 
  }
  
  private void aa() {
    if (getActivity() instanceof BaseFragmentActivity)
      ((BaseFragmentActivity)getActivity()).a((BaseFragmentActivity.IOnBackPressedListener)this); 
  }
  
  public static void b(Context paramContext, boolean paramBoolean) {
    Bundle bundle = new Bundle();
    bundle.putBoolean("from_float", paramBoolean);
    a(paramContext, PlayingStudioFragment.class, bundle);
  }
  
  private void b(String paramString1, String paramString2) {
    FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
    this.Y = (YYGiftListFragment)getChildFragmentManager().findFragmentByTag("LiveGift");
    Bundle bundle = new Bundle();
    bundle.putString("from", paramString1);
    bundle.putString("target_uid", paramString2);
    YYGiftListFragment yYGiftListFragment = this.Y;
    if (yYGiftListFragment == null) {
      this.Y = new YYGiftListFragment();
      this.Y.setArguments(bundle);
      fragmentTransaction.add(R.id.ll_gift_layout, (Fragment)this.Y, "LiveGift");
    } else {
      yYGiftListFragment.setArguments(bundle);
      fragmentTransaction.show((Fragment)this.Y);
    } 
    fragmentTransaction.commitNowAllowingStateLoss();
  }
  
  private void d(String paramString) {
    View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_alert_message_layout, null);
    ((TextView)view.findViewById(R.id.tv_alert_msg)).setText(paramString);
    LiveAlterDialog.a(getContext(), view, null, null, false, true);
  }
  
  public void A() {
    WaittingListView waittingListView = new WaittingListView(getContext());
    waittingListView.a(this);
    a((View)waittingListView, (int)(AppInfo.m * 0.6D));
  }
  
  public void B() {
    YYEmojiView yYEmojiView = new YYEmojiView(getContext());
    yYEmojiView.a(this);
    a((View)yYEmojiView, -2);
  }
  
  public void C() {
    YYEmojiView yYEmojiView = new YYEmojiView(getContext());
    yYEmojiView.b(this);
    a((View)yYEmojiView, -2);
  }
  
  public void D() {
    YYToolBoxView yYToolBoxView = new YYToolBoxView(getContext());
    yYToolBoxView.a(this);
    a((View)yYToolBoxView, -2);
  }
  
  public void E() {
    YYSendVoteView yYSendVoteView = new YYSendVoteView(getContext());
    yYSendVoteView.a(this);
    a((View)yYSendVoteView, -2);
  }
  
  public void F() {
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null)
      return; 
    YYRoomHttpUtils.l(yYRoomModel.room_id, new BluedUIHttpResponse(this, (IRequestHost)w_()) {
          public void onUIUpdate(BluedEntity param1BluedEntity) {}
        }(IRequestHost)w_());
  }
  
  public boolean G() {
    PopupWindow popupWindow = this.y;
    return (popupWindow != null) ? popupWindow.isShowing() : false;
  }
  
  public void H() {
    PopupWindow popupWindow = this.y;
    if (popupWindow != null && popupWindow.isShowing())
      this.y.dismiss(); 
  }
  
  public void I() {
    LiveEventBus.get("live_pwd_fragment_close").post("");
    H();
    w();
    YYStudioTitleView yYStudioTitleView = this.f;
    if (yYStudioTitleView != null)
      yYStudioTitleView.b(); 
    KeyboardUtils.a((Activity)getActivity());
  }
  
  public abstract void J();
  
  public abstract void K();
  
  public abstract void L();
  
  public abstract void M();
  
  protected abstract void N();
  
  public abstract int O();
  
  public abstract void P();
  
  public abstract void Q();
  
  public abstract void R();
  
  public void S() {
    AudioManagerUtils.a().a(false);
    AudioChannelManager.e().c();
    Intent intent = new Intent(this.e, NotificationService.class);
    this.e.stopService(intent);
  }
  
  protected IAudioContract.IAudioCallback T() {
    return new IAudioContract.IAudioCallback(this) {
        public void a() {}
        
        public void a(int param1Int) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("用户身份 ==> errorCode : ");
          stringBuilder.append(param1Int);
          Logger.e("sdk", new Object[] { stringBuilder.toString() });
        }
        
        public void a(int param1Int, String param1String) {
          Logger.e("sdk", new Object[] { "onStartPublishCDNStream ... " });
          YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
          if (yYRoomModel == null)
            return; 
          YYRoomHttpUtils.a(yYRoomModel.room_id);
        }
        
        public void a(long param1Long) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("onSelfJoined ... l: ");
          stringBuilder.append(param1Long);
          Logger.e("sdk", new Object[] { stringBuilder.toString() });
        }
        
        public void a(String param1String) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("onUserJoined ==> uid: ");
          stringBuilder.append(param1String);
          Logger.e("sdk", new Object[] { stringBuilder.toString() });
        }
        
        public void a(String param1String, boolean param1Boolean) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("麦克风状态 ==> uid : ");
          stringBuilder.append(param1String);
          stringBuilder.append(" --- mic : ");
          stringBuilder.append(param1Boolean);
          Logger.e("sdk", new Object[] { stringBuilder.toString() });
        }
        
        public void a(Set<String> param1Set) {
          if (param1Set == null)
            return; 
          YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
          if (yYRoomModel == null)
            return; 
          int i = 1;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("sdk talking user: ");
          stringBuilder1.append(Arrays.toString(param1Set.toArray((Object[])new String[0])));
          Logger.e("sdk", new Object[] { stringBuilder1.toString() });
          Set set = yYRoomModel.getTalkingUserIds();
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("seat talking user: ");
          stringBuilder2.append(Arrays.toString(set.toArray((Object[])new String[0])));
          Logger.e("sdk", new Object[] { stringBuilder2.toString() });
          if (param1Set.size() == set.size()) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("是否相等： ");
            stringBuilder2.append(set.equals(param1Set));
            Logger.e("sdk", new Object[] { stringBuilder2.toString() });
            i = true ^ set.equals(param1Set);
          } 
          if (i != 0)
            this.a.x.a(param1Set); 
          YYUserInfo yYUserInfo = (YYRoomInfoManager.d()).a;
          if (yYUserInfo != null) {
            if (!TextUtils.equals(yYUserInfo.is_mic, "1"))
              return; 
            this.a.a(yYRoomModel.room_id, yYUserInfo);
          } 
        }
        
        public void b() {
          Logger.e("sdk", new Object[] { "onConnectionRecovery ... " });
          if (LiveSettingConfig.a().b())
            LiveLogUtils.a("onConnectionRecovery() ---> retryConnect()", LiveLogUtils.a()); 
          BaseYYStudioFragment.a(this.a);
        }
        
        public void b(int param1Int, String param1String) {}
        
        public void b(String param1String) {
          Logger.e("sdk", new Object[] { "onUserOffline ... " });
        }
        
        public void c(String param1String) {}
      };
  }
  
  public YYImListView U() {
    return this.D;
  }
  
  public boolean V_() {
    (AudioChannelManager.e()).a = true;
    return super.V_();
  }
  
  public void a(View paramView, int paramInt) {
    a(paramView, paramInt, 80);
  }
  
  protected void a(View paramView, int paramInt1, int paramInt2) {
    a(paramView, AppInfo.l, paramInt1, paramInt2);
  }
  
  protected void a(View paramView, int paramInt1, int paramInt2, int paramInt3) {
    if (this.S)
      return; 
    PopupWindow popupWindow = this.y;
    if (popupWindow != null && popupWindow.isShowing())
      this.y.dismiss(); 
    if (paramView == null)
      return; 
    this.y = (new PopupwindowFactory.Builder(getContext())).a(paramView).a(paramInt3).c(paramInt2).b(paramInt1).d(R.color.syc_66000000).h();
  }
  
  public abstract void a(View paramView, YYSeatMemberModel paramYYSeatMemberModel, int paramInt);
  
  public void a(YYReportModel paramYYReportModel, int paramInt) {
    YYReportView yYReportView = new YYReportView(getContext());
    yYReportView.a(this, paramYYReportModel, paramInt);
    a((View)yYReportView, -2);
  }
  
  public void a(YYUserInfo paramYYUserInfo) {
    YYCardOptionView yYCardOptionView = new YYCardOptionView(getContext());
    yYCardOptionView.a(this, paramYYUserInfo);
    a((View)yYCardOptionView, -2);
  }
  
  public void a(String paramString) {
    YYUserVoteView yYUserVoteView = new YYUserVoteView(getContext());
    yYUserVoteView.a(this, paramString);
    a((View)yYUserVoteView, -2);
  }
  
  public void a(String paramString, YYUserInfo paramYYUserInfo) {
    if (this.V <= 0L)
      this.V = System.currentTimeMillis(); 
    long l1 = System.currentTimeMillis();
    long l2 = this.V;
    if (l2 > 0L && l1 - l2 >= 120000L)
      YYRoomHttpUtils.h(paramString, new BluedUIHttpResponse<BluedEntityA<YYHeartModel>>(this, null, paramYYUserInfo) {
            protected void a(BluedEntityA<YYHeartModel> param1BluedEntityA) {
              if (param1BluedEntityA != null) {
                if (!param1BluedEntityA.hasData())
                  return; 
                YYHeartModel yYHeartModel = (YYHeartModel)param1BluedEntityA.getSingleData();
                if (yYHeartModel == null)
                  return; 
                if (LiveSettingConfig.a().b()) {
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append("checkSelfMicStatus() ---> ");
                  stringBuilder.append(yYHeartModel.toString());
                  LiveLogUtils.a(stringBuilder.toString(), LiveLogUtils.a());
                } 
                if (yYHeartModel.in_room != 1)
                  this.b.b(yYHeartModel.room_id); 
                if (yYHeartModel.is_mics != 1) {
                  YYUserInfo yYUserInfo = this.a;
                  yYUserInfo.is_mic = "0";
                  yYUserInfo.is_open_mic = 0;
                  YYObserverManager.a().a("0");
                } 
              } 
            }
            
            public void onUIStart() {
              super.onUIStart();
              BaseYYStudioFragment.a(this.b, System.currentTimeMillis());
            }
          }null); 
  }
  
  public void a(String paramString1, String paramString2) {
    YYTypingView yYTypingView = this.L;
    if (yYTypingView != null) {
      this.S = true;
      yYTypingView.a(this, paramString1, paramString2);
    } 
  }
  
  public void a(String paramString1, String paramString2, YYImModel paramYYImModel) {
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel != null) {
      List<YYSeatMemberModel> list = yYRoomModel.mics;
      int i;
      for (i = 0; i < list.size(); i++) {
        YYSeatMemberModel yYSeatMemberModel = list.get(i);
        if (TextUtils.equals(yYSeatMemberModel.getUid(), paramString1)) {
          yYSeatMemberModel.apngUrl = paramString2;
          yYSeatMemberModel.emojiModel = paramYYImModel;
          this.x.a(i, paramString1, paramString2, paramYYImModel);
          return;
        } 
      } 
    } 
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean) {
    AudienceUserCardView audienceUserCardView;
    if (paramBoolean) {
      SeatUserCardView seatUserCardView = new SeatUserCardView(getContext());
    } else {
      audienceUserCardView = new AudienceUserCardView(getContext());
    } 
    audienceUserCardView.a(this, paramString1, paramString2, paramString3, paramString4);
    a((View)audienceUserCardView, -2);
  }
  
  public void a(String paramString, boolean paramBoolean) {
    YYMoreMenuView yYMoreMenuView = new YYMoreMenuView(getContext());
    yYMoreMenuView.a(this, paramString);
    yYMoreMenuView.setShutdownLisenter(new View.OnClickListener(this, paramBoolean) {
          public void onClick(View param1View) {
            if (!this.a && YYRoomInfoManager.d().b() != null)
              EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_EXIT_BTN_CLICK, (YYRoomInfoManager.d().b()).room_id, (YYRoomInfoManager.d().b()).uid); 
            this.b.H();
            this.b.P();
          }
        });
    a((View)yYMoreMenuView, -2, 48);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2) {
    if (this.S)
      return; 
    if (paramBoolean) {
      if (G())
        H(); 
      b(paramString1, paramString2);
      return;
    } 
    w();
  }
  
  public void b(KeyboardListenLinearLayout paramKeyboardListenLinearLayout) {
    a(paramKeyboardListenLinearLayout);
  }
  
  public abstract void b(String paramString);
  
  public void c(String paramString) {
    if (!this.z) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("pushCdnStream url: ");
      stringBuilder.append(paramString);
      Logger.e("onMessage", new Object[] { stringBuilder.toString() });
      if (TextUtils.isEmpty(paramString))
        return; 
      TRTCCloudDef.TRTCPublishCDNParam tRTCPublishCDNParam = new TRTCCloudDef.TRTCPublishCDNParam();
      tRTCPublishCDNParam.appId = GenerateTestUserSig.b();
      tRTCPublishCDNParam.bizId = GenerateTestUserSig.d();
      tRTCPublishCDNParam.url = paramString;
      AudioChannelManager.e().a(tRTCPublishCDNParam);
    } 
  }
  
  public void e_(int paramInt) {
    super.e_(paramInt);
    if (paramInt != -3) {
      if (paramInt != -2)
        return; 
      this.S = false;
      this.T = false;
      this.K.setVisibility(8);
      YYTypingView yYTypingView = this.L;
      if (yYTypingView != null) {
        yYTypingView.setVisibility(8);
        this.L.getEtInput().setText("");
      } 
      YYBroadcastView yYBroadcastView = this.M;
      if (yYBroadcastView != null) {
        yYBroadcastView.setVisibility(8);
        return;
      } 
    } else {
      this.K.setVisibility(0);
      if (this.S) {
        YYTypingView yYTypingView = this.L;
        if (yYTypingView != null)
          yYTypingView.setVisibility(0); 
      } 
      if (this.T) {
        YYBroadcastView yYBroadcastView = this.M;
        if (yYBroadcastView != null)
          yYBroadcastView.setVisibility(0); 
      } 
    } 
  }
  
  public boolean j() {
    return false;
  }
  
  public void onActivityCreated(Bundle paramBundle) {
    super.onActivityCreated(paramBundle);
    LiveEventBus.get("notify_alert_message", YYImModel.class).observe((LifecycleOwner)this, new Observer<YYImModel>(this) {
          public void a(YYImModel param1YYImModel) {
            if (param1YYImModel != null) {
              if (TextUtils.isEmpty(param1YYImModel.contents))
                return; 
              YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
              if (yYRoomModel != null && param1YYImModel.target_profile != null) {
                int i;
                YYMsgWarningExtra yYMsgWarningExtra = (YYMsgWarningExtra)AppInfo.f().fromJson(param1YYImModel.getMsgExtra(), YYMsgWarningExtra.class);
                ChatRoomProtos.Event event = ChatRoomProtos.Event.CHAT_ROOM_WARN_POP_SHOW;
                String str1 = yYRoomModel.room_id;
                String str2 = yYRoomModel.uid;
                String str3 = param1YYImModel.target_profile.getUid();
                String str4 = param1YYImModel.contents;
                if (yYMsgWarningExtra == null) {
                  i = 0;
                } else {
                  i = yYMsgWarningExtra.warning_type;
                } 
                EventTrackYY.a(event, str1, str2, str3, str4, i);
              } 
              BaseYYStudioFragment.a(this.a, param1YYImModel.contents);
            } 
          }
        });
    LiveEventBus.get("notify_follow_user", String.class).observe((LifecycleOwner)this, new Observer<String>(this) {
          public void a(String param1String) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("发送关注通知 UID= ");
            stringBuilder.append(param1String);
            Logger.e("BaseYYStudioFragment", new Object[] { stringBuilder.toString() });
            YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
            if (yYRoomModel == null)
              return; 
            if (TextUtils.equals(param1String, yYRoomModel.uid))
              ToastUtils.a("你已关注房主", 0); 
            YYRoomHttpUtils.c(yYRoomModel.room_id, param1String, new BluedUIHttpResponse<BluedEntityA<Object>>(this, (IRequestHost)this.a.w_()) {
                  protected void a(BluedEntityA<Object> param2BluedEntityA) {}
                }(IRequestHost)this.a.w_());
          }
        });
    LiveEventBus.get("show_gift_view", String.class).observe((LifecycleOwner)this, new Observer<String>(this) {
          public void a(String param1String) {
            this.a.a(true, "", "");
          }
        });
    LiveEventBus.get("set_manager_msg", YYAudienceModel.class).observe((LifecycleOwner)this, new Observer<YYAudienceModel>(this) {
          public void a(YYAudienceModel param1YYAudienceModel) {
            this.a.x.a(param1YYAudienceModel.getUid(), param1YYAudienceModel.chat_anchor);
            YYUserInfo yYUserInfo = (YYRoomInfoManager.d()).a;
            if (yYUserInfo == null)
              return; 
            if (TextUtils.equals(param1YYAudienceModel.getUid(), yYUserInfo.getUid()))
              yYUserInfo.chat_anchor = param1YYAudienceModel.chat_anchor; 
            YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
            if (yYRoomModel == null)
              return; 
            if (TextUtils.equals(yYRoomModel.uid, yYUserInfo.getUid()) && TextUtils.equals("2", param1YYAudienceModel.chat_anchor))
              ToastUtils.a("设置成功", 0); 
          }
        });
    LiveEventBus.get("inner_fragment_close", String.class).observe((LifecycleOwner)this, new Observer<String>(this) {
          public void a(String param1String) {
            Logger.e("BaseYYStudioFragment", new Object[] { "内部fragment关闭 ...  " });
            BaseYYStudioFragment.b(this.a);
          }
        });
    LiveEventBus.get("display_emoji_image", YYImModel.class).observe((LifecycleOwner)this, new Observer<YYImModel>(this) {
          public void a(YYImModel param1YYImModel) {
            YYAudienceModel yYAudienceModel = param1YYImModel.source_profile;
            if (yYAudienceModel == null)
              return; 
            YYMsgEmojiExtra yYMsgEmojiExtra = (YYMsgEmojiExtra)AppInfo.f().fromJson(param1YYImModel.getMsgExtra(), YYMsgEmojiExtra.class);
            if (yYMsgEmojiExtra == null)
              return; 
            this.a.a(yYAudienceModel.getUid(), yYMsgEmojiExtra.apng, param1YYImModel);
          }
        });
    LiveEventBus.get("show_vote_result", String.class).observe((LifecycleOwner)this, new Observer<String>(this) {
          public void a(String param1String) {
            if (TextUtils.isEmpty(param1String)) {
              this.a.H();
              BaseYYStudioFragment.c(this.a);
            } 
          }
        });
    YYCPPresenter yYCPPresenter = this.X;
    if (yYCPPresenter != null)
      yYCPPresenter.a((LifecycleOwner)this); 
    this.F.post(new Runnable(this) {
          public void run() {
            if (BaseYYStudioFragment.d(this.a) != null) {
              int i;
              if (BaseYYStudioFragment.e(this.a) == null)
                return; 
              int[] arrayOfInt = new int[2];
              BaseYYStudioFragment.d(this.a).getLocationOnScreen(arrayOfInt);
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("loc:[");
              stringBuilder.append(arrayOfInt[0]);
              stringBuilder.append(",");
              stringBuilder.append(arrayOfInt[1]);
              stringBuilder.append("]; height: ");
              stringBuilder.append(BaseYYStudioFragment.d(this.a).getHeight());
              LogUtils.d("gift", stringBuilder.toString());
              if (YYRoomInfoManager.d().b() != null && YYRoomInfoManager.d().b().isCPChannel()) {
                i = arrayOfInt[1];
              } else {
                i = arrayOfInt[1] + BaseYYStudioFragment.d(this.a).getHeight();
              } 
              FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)BaseYYStudioFragment.e(this.a).getLayoutParams();
              layoutParams.topMargin = i;
              BaseYYStudioFragment.e(this.a).setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            } 
          }
        });
    if (this.A)
      P(); 
    if (!this.z)
      F(); 
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    Logger.e("BaseYYStudioFragment", new Object[] { "onCreate ... " });
    if (paramBundle != null && !PermissionHelper.a(new String[] { "android.permission.RECORD_AUDIO" })) {
      String str = paramBundle.getString("yy_unexpectedly_exit");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onCreate ... roomId: ");
      stringBuilder.append(str);
      Logger.e("BaseYYStudioFragment", new Object[] { stringBuilder.toString() });
      b(str);
      return;
    } 
    this.z = getArguments().getBoolean("from_float", false);
    this.A = getArguments().getBoolean("from_float_close", false);
    J();
    this.X = new YYCPPresenter(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    Logger.e("BaseYYStudioFragment", new Object[] { "onCreateView ... " });
    getActivity().getWindow().setSoftInputMode(16);
    View view = this.B;
    if (view == null) {
      this.e = getContext();
      this.B = paramLayoutInflater.inflate(R.layout.fragment_base_yy_studio_layout, paramViewGroup, false);
      this.P = DensityUtils.a(getContext(), 10.0F);
      this.Q = (AppInfo.l - DensityUtils.a(getContext(), 60.0F) * 4 - this.P * 2) / 3;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("rightDistance = ");
      stringBuilder.append(this.Q);
      Logger.e("BaseYYStudioFragment", new Object[] { stringBuilder.toString() });
      W();
      V();
      b(this.E);
      N();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.B.getParent()).removeView(this.B);
    } 
    R();
    AudioChannelManager.e().a(new IAudioContract.AppHandoverListener(this) {
          public void a() {
            YYUserInfo yYUserInfo = (YYRoomInfoManager.d()).a;
            if (yYUserInfo != null && TextUtils.equals(yYUserInfo.is_mic, "1")) {
              Intent intent = new Intent(this.a.e, NotificationService.class);
              this.a.e.startService(intent);
            } 
          }
          
          public void b() {
            if (LiveSettingConfig.a().b())
              LiveLogUtils.a("onAppFore() ---> retryConnect()", LiveLogUtils.a()); 
            BaseYYStudioFragment.a(this.a);
            Intent intent = new Intent(this.a.e, NotificationService.class);
            this.a.e.stopService(intent);
          }
        });
    return this.B;
  }
  
  public void onDestroy() {
    super.onDestroy();
    LiveSettingConfig.a().a(YYRoomHttpUtils.b(), YYRoomHttpUtils.c(), LiveLogUtils.c());
    YYObserverManager.a().b();
    YYImMsgManager.a().e();
    AudioChannelManager.e().a(null);
    AudioChannelManager.e().a(getContext());
    YYGiftAnimManager yYGiftAnimManager = this.R;
    if (yYGiftAnimManager != null)
      yYGiftAnimManager.a(); 
    this.z = false;
    YYCPPresenter yYCPPresenter = this.X;
    if (yYCPPresenter != null)
      yYCPPresenter.b(); 
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {
    super.onSaveInstanceState(paramBundle);
    Logger.e("BaseYYStudioFragment", new Object[] { "onSaveInstanceState ...  " });
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onSaveInstanceState ... roomId: ");
      stringBuilder.append(yYRoomModel.room_id);
      Logger.e("BaseYYStudioFragment", new Object[] { stringBuilder.toString() });
      paramBundle.putSerializable("yy_unexpectedly_exit", yYRoomModel.room_id);
    } 
  }
  
  public void t() {
    YYCPPresenter yYCPPresenter = this.X;
    if (yYCPPresenter != null)
      yYCPPresenter.a(); 
  }
  
  public void u() {
    YYRenameView yYRenameView = new YYRenameView(getContext());
    yYRenameView.a(this);
    a((View)yYRenameView, -2);
  }
  
  public void v() {
    YYBroadcastView yYBroadcastView = this.M;
    if (yYBroadcastView != null) {
      this.T = true;
      yYBroadcastView.a(this);
    } 
  }
  
  public void w() {
    try {
      FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
      if (this.Y != null)
        fragmentTransaction.hide((Fragment)this.Y).commitNowAllowingStateLoss(); 
      aa();
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void x() {
    FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
    YYMusicFragment yYMusicFragment = this.U;
    if (yYMusicFragment == null) {
      this.U = new YYMusicFragment();
      fragmentTransaction.add(R.id.live_music_layout, (Fragment)this.U, "LiveMusic");
      fragmentTransaction.commitNowAllowingStateLoss();
      return;
    } 
    if (yYMusicFragment.isHidden()) {
      this.U.I();
      fragmentTransaction.show((Fragment)this.U);
      fragmentTransaction.commitNowAllowingStateLoss();
    } 
  }
  
  public void y() {
    if (this.U != null && !isHidden()) {
      this.U.I();
      getChildFragmentManager().beginTransaction().hide((Fragment)this.U).commitNowAllowingStateLoss();
    } 
    aa();
  }
  
  public void z() {
    RoomMemberListView roomMemberListView = new RoomMemberListView(getContext());
    roomMemberListView.a(this, O());
    a((View)roomMemberListView, (int)(AppInfo.m * 0.6D));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\fragment\BaseYYStudioFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */