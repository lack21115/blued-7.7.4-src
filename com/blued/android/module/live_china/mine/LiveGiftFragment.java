package com.blued.android.module.live_china.mine;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.utils.TypeUtils;
import com.blued.android.module.common.model.BaseGiftModel;
import com.blued.android.module.common.model.CommonGiftPackageModel;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.live.base.fragment.LiveGiftBaseFragment;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.blued.android.module.live.base.model.BasePayRemaining;
import com.blued.android.module.live.base.model.CommonLiveGiftModel;
import com.blued.android.module.live.base.model.LiveGiftNumberModel;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveGiftManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveEffectModel;
import com.blued.android.module.live_china.model.LiveGiftBagModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveGiftPackageModel;
import com.blued.android.module.live_china.model.LiveLevelInfoModel;
import com.blued.android.module.live_china.model.LiveLevelModel;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.model.LiveZanExtraModel;
import com.blued.android.module.live_china.model.PayRemaining;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.observer.LiveFansObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.same.tip.CommonShowBottomWindow;
import com.blued.android.module.live_china.utils.LiveGiftPayTools;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.utils.LiveUtils;
import com.blued.android.module.live_china.utils.log.EventTrackLive;
import com.blued.android.module.live_china.utils.log.InstantLog;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.PopActionSheet;
import com.blued.android.module.media.selector.view.ActionSheet;
import com.blued.das.live.LiveProtos;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LiveGiftFragment extends LiveGiftBaseFragment implements View.OnClickListener {
  private TextView L;
  
  private LinearLayout M;
  
  private TextView N;
  
  private TextView O;
  
  private FrameLayout P;
  
  private ImageView Q;
  
  private View R;
  
  private View S;
  
  private TextView T;
  
  private ProgressBar U;
  
  private TextView V;
  
  private TextView W;
  
  private View X;
  
  private View Y;
  
  private DanmakuRunnable Z = new DanmakuRunnable();
  
  private String aa;
  
  private String ab;
  
  private String ac;
  
  private LiveLevelInfoModel ad;
  
  private boolean ae;
  
  private LiveGiftModel af;
  
  private CountDownTimer ag;
  
  private String ah = "#3494f4";
  
  private BaseFragment ai;
  
  private GiftValue aj = new GiftValue(this);
  
  private void P() {
    this.w.setText(String.valueOf(A()));
    if (this.E != null) {
      this.w.setTextColor(getResources().getColor(R.color.syc_dark_b));
      this.y.setAlpha(1.0F);
    } else {
      this.w.setTextColor(Color.parseColor("#8A8A8A"));
      this.y.setAlpha(0.15F);
    } 
    a(this.ad);
  }
  
  private PlayingOnliveFragment Q() {
    return (PlayingOnliveFragment)getParentFragment();
  }
  
  private void R() {
    LiveGiftModel liveGiftModel = this.af;
    if (liveGiftModel != null) {
      if (liveGiftModel.effectModel == null)
        return; 
      String str = String.format(getString(R.string.verify_purchase_mounts), new Object[] { String.valueOf(this.af.effectModel.expire) });
      FragmentActivity fragmentActivity = getActivity();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append(this.af.name);
      CommonAlertDialog.a((Context)fragmentActivity, "", stringBuilder.toString(), getString(R.string.verify_purchase), new DialogInterface.OnClickListener(this) {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
              LiveGiftFragment.a(this.a);
            }
          },  getResources().getString(R.string.cancel), null, null);
    } 
  }
  
  private void S() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("selectedItemIndex: ");
    stringBuilder.append(this.j);
    LogUtils.c(stringBuilder.toString());
    if (TextUtils.isEmpty(this.j))
      return; 
    LiveGiftModel liveGiftModel = (LiveGiftModel)a(this.j);
    if (liveGiftModel != null) {
      if (liveGiftModel.sendGiftStatus == 1)
        return; 
      liveGiftModel.sendGiftStatus = 1;
      liveGiftModel.effectModel = this.af.effectModel;
      LiveEventBus.get("gift_item_update").post(liveGiftModel);
      LiveRoomData liveRoomData = LiveRoomManager.a().h();
      if (liveRoomData != null) {
        boolean bool1;
        boolean bool2;
        boolean bool3;
        LiveProtos.LiveType liveType;
        BaseFragment baseFragment = this.ai;
        if (baseFragment instanceof PlayingOnliveFragment) {
          bool1 = ((PlayingOnliveFragment)baseFragment).B();
          bool3 = ((PlayingOnliveFragment)this.ai).K();
          bool2 = ((PlayingOnliveFragment)this.ai).aF();
        } else {
          bool2 = false;
          bool3 = false;
          bool1 = false;
        } 
        LiveProtos.Event event = LiveProtos.Event.LIVE_GIFT_PAGE_SEND_CLICK;
        String str1 = LiveRoomManager.a().c();
        String str2 = LiveRoomManager.a().e();
        String str3 = liveRoomData.liveFrom;
        String str4 = liveRoomData.recommendType;
        int i = liveRoomData.livePosition;
        String str5 = liveGiftModel.goods_id;
        int j = A();
        int k = (int)(liveGiftModel.beans * A());
        int m = liveGiftModel.packageTabIndex;
        int n = liveGiftModel.pageIndex;
        int i1 = liveGiftModel.positionInPage;
        if (bool2) {
          liveType = LiveProtos.LiveType.BLIND_DATING_LIVE;
        } else {
          liveType = LiveProtos.LiveType.SHOW_LIVE;
        } 
        EventTrackLive.a(event, str1, str2, str3, str4, i, str5, j, k, m + 1, n + 1, i1 + 1, bool3, bool1, liveType);
      } 
      a(liveGiftModel, 1, "", false);
    } 
  }
  
  private void T() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("selectedItemIndex: ");
    stringBuilder.append(this.j);
    LogUtils.c(stringBuilder.toString());
    if (TextUtils.isEmpty(this.j))
      return; 
    LiveGiftModel liveGiftModel = (LiveGiftModel)a(this.j);
    if (liveGiftModel != null) {
      if (liveGiftModel.packageTabIndex == 2)
        return; 
      stringBuilder = new StringBuilder();
      stringBuilder.append("selectedModel: ");
      stringBuilder.append(liveGiftModel.toString());
      LogUtils.c(stringBuilder.toString());
      if (liveGiftModel.double_hit == 1) {
        String str;
        if (this.H != null) {
          str = this.H.goods_id;
        } else {
          str = "";
        } 
        if (this.E != null && this.E.count > 1) {
          liveGiftModel.hit_id = 0L;
        } else if (StringUtils.a(str, liveGiftModel.goods_id) && this.C > 0L && liveGiftModel.comboWaitTime > 0) {
          liveGiftModel.hit_id = this.C;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("判定为有效连击 mLastGiftModel.combo_id = ");
          stringBuilder1.append(liveGiftModel.hit_id);
          LogUtils.c(stringBuilder1.toString());
        } else {
          liveGiftModel.hit_id = System.currentTimeMillis();
          liveGiftModel.hit_count = 0;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("生成一个新的hitId = ");
          stringBuilder1.append(liveGiftModel.hit_id);
          LogUtils.c(stringBuilder1.toString());
        } 
      } 
      liveGiftModel.sendGiftStatus = 1;
      LiveEventBus.get("gift_item_update").post(liveGiftModel);
      LiveRoomData liveRoomData = LiveRoomManager.a().h();
      if (liveRoomData != null) {
        boolean bool1;
        boolean bool2;
        boolean bool3;
        LiveProtos.LiveType liveType;
        BaseFragment baseFragment = this.ai;
        if (baseFragment instanceof PlayingOnliveFragment) {
          bool1 = ((PlayingOnliveFragment)baseFragment).B();
          bool3 = ((PlayingOnliveFragment)this.ai).K();
          bool2 = ((PlayingOnliveFragment)this.ai).aF();
        } else {
          bool2 = false;
          bool3 = false;
          bool1 = false;
        } 
        LiveProtos.Event event = LiveProtos.Event.LIVE_GIFT_PAGE_SEND_CLICK;
        long l = liveRoomData.lid;
        String str1 = LiveRoomManager.a().e();
        String str2 = liveRoomData.liveFrom;
        String str3 = liveRoomData.recommendType;
        int i = liveRoomData.livePosition;
        String str4 = liveGiftModel.goods_id;
        int j = A();
        int k = (int)(liveGiftModel.beans * A());
        int m = liveGiftModel.packageTabIndex;
        int n = liveGiftModel.pageIndex;
        int i1 = liveGiftModel.positionInPage;
        if (bool2) {
          liveType = LiveProtos.LiveType.BLIND_DATING_LIVE;
        } else {
          liveType = LiveProtos.LiveType.SHOW_LIVE;
        } 
        EventTrackLive.a(event, String.valueOf(l), str1, str2, str3, i, str4, j, k, m + 1, n + 1, i1 + 1, bool3, bool1, liveType);
      } 
      a(liveGiftModel, A(), "", false);
    } 
  }
  
  private void U() {
    W();
    O();
  }
  
  private void V() {
    AppInfo.n().removeCallbacks(this.aj);
    AppInfo.n().postDelayed(this.aj, 3000L);
  }
  
  private void W() {
    AppInfo.n().removeCallbacks(this.aj);
  }
  
  private void X() {
    if (this.Q != null) {
      LiveGiftModel liveGiftModel = this.af;
      if (liveGiftModel == null)
        return; 
      if (liveGiftModel.show_info == 1 && this.af.info_type == 2) {
        ImageLoader.a(null, this.af.info_img).a(this.Q);
        this.P.setVisibility(0);
        return;
      } 
      this.P.setVisibility(8);
    } 
  }
  
  private void Y() {
    this.ag = (new CountDownTimer(this, 5000L, 1000L) {
        public void onFinish() {
          LiveGiftFragment.p(this.a).setVisibility(8);
        }
        
        public void onTick(long param1Long) {}
      }).start();
  }
  
  private String a(float paramFloat) {
    return CommonStringUtils.d(Float.toString(paramFloat));
  }
  
  private void a(int paramInt, String[] paramArrayOfString) {
    if (paramArrayOfString == null)
      return; 
    int[] arrayOfInt = new int[paramArrayOfString.length];
    for (int i = 0; i < paramArrayOfString.length; i++)
      arrayOfInt[i] = R.color.sara_a; 
    if (LiveDataManager.a().f()) {
      PopActionSheet.a(getContext(), paramArrayOfString, arrayOfInt, DensityUtils.a(getContext(), 300.0F), new -$$Lambda$LiveGiftFragment$PzMU4JdFtliNiRqPub4uXwKpPyQ(this, paramInt));
      return;
    } 
    CommonShowBottomWindow.a(getActivity(), paramArrayOfString, this.ah, new ActionSheet.ActionSheetListener(this, paramInt) {
          public void a(ActionSheet param1ActionSheet, int param1Int) {
            LiveGiftFragment.a(this.b, this.a, param1Int);
          }
          
          public void a(ActionSheet param1ActionSheet, boolean param1Boolean) {}
        });
  }
  
  private void a(BluedEntity<LiveGiftPackageModel, LiveZanExtraModel> paramBluedEntity) {
    if (paramBluedEntity != null) {
      if (paramBluedEntity.data == null)
        return; 
      int i = this.i.size();
      boolean bool = false;
      if (i == 0)
        g(0); 
      ArrayList<CommonGiftPackageModel> arrayList = new ArrayList();
      for (i = 0; i < paramBluedEntity.data.size(); i++) {
        if ("normal_goods".equalsIgnoreCase(((LiveGiftPackageModel)paramBluedEntity.data.get(i)).type_name)) {
          ((LiveGiftPackageModel)paramBluedEntity.data.get(i)).name = getResources().getString(R.string.live_gift_hot);
        } else if ("ar_goods".equalsIgnoreCase(((LiveGiftPackageModel)paramBluedEntity.data.get(i)).type_name)) {
          ((LiveGiftPackageModel)paramBluedEntity.data.get(i)).name = getResources().getString(R.string.live_gift_magic);
        } else if ("effect_goods".equalsIgnoreCase(((LiveGiftPackageModel)paramBluedEntity.data.get(i)).type_name)) {
          ((LiveGiftPackageModel)paramBluedEntity.data.get(i)).name = getResources().getString(R.string.live_gift_vehicle);
        } 
      } 
      arrayList.addAll(paramBluedEntity.data);
      d(arrayList);
      for (i = bool; i < arrayList.size(); i++) {
        CommonGiftPackageModel commonGiftPackageModel = arrayList.get(i);
        if (commonGiftPackageModel.tabIndex == 0 || commonGiftPackageModel.tabIndex == 1)
          b(commonGiftPackageModel); 
      } 
      b(arrayList);
      X();
    } 
  }
  
  private void a(LiveGiftModel paramLiveGiftModel) {
    LiveGiftPayTools.b();
    if (LiveGiftPayTools.a)
      return; 
    if (Q().w_() != null) {
      if (!Q().w_().isActive())
        return; 
      String str2 = getString(R.string.Live_SendPresent_notEnoughWandou);
      String str1 = str2;
      if (paramLiveGiftModel.effect != null) {
        str1 = str2;
        if (paramLiveGiftModel.effect.size() > 0)
          str1 = getString(R.string.Live_effect_not_enough); 
      } 
      LiveGiftPayTools.a = true;
      CommonAlertDialog.a((Context)getActivity(), null, "", str1, getString(R.string.cancel), getString(R.string.Live_SendPresent_recharge), new DialogInterface.OnClickListener(this) {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
              if (LiveGiftFragment.d(this.a) != null)
                LiveGiftFragment.d(this.a).a(true); 
              LiveRoomInfo.a().a((Context)this.a.getActivity(), 2);
              LiveGiftPayTools.a = false;
            }
          }new DialogInterface.OnClickListener(this) {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
              LiveGiftPayTools.a = false;
            }
          },  new DialogInterface.OnCancelListener(this) {
            public void onCancel(DialogInterface param1DialogInterface) {
              LiveGiftPayTools.a = false;
            }
          },  true);
    } 
  }
  
  private void a(LiveGiftModel paramLiveGiftModel, int paramInt1, int paramInt2, String paramString) {
    Bundle bundle2;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("buyGiftFail: ");
    stringBuilder.append(paramLiveGiftModel.toString());
    stringBuilder.append(", giftCount:");
    stringBuilder.append(paramInt1);
    stringBuilder.append(", errorCode:");
    stringBuilder.append(paramInt2);
    stringBuilder.append(", errorMessage:");
    stringBuilder.append(paramString);
    LogUtils.c(stringBuilder.toString());
    paramLiveGiftModel.sendGiftStatus = 2;
    LiveEventBus.get("gift_item_update").post(paramLiveGiftModel);
    stringBuilder = new StringBuilder();
    stringBuilder.append("buyGiftFail: ");
    stringBuilder.append(paramInt2);
    stringBuilder.append(", msg: ");
    stringBuilder.append(paramString);
    LogUtils.c(stringBuilder.toString());
    switch (paramInt2) {
      default:
        if (!TextUtils.isEmpty(paramString)) {
          AppMethods.a(paramString);
          paramLiveGiftModel.errorMessage = paramString;
          return;
        } 
        return;
      case 4221008:
        a(paramLiveGiftModel);
        return;
      case 4221004:
      case 4221005:
        bundle2 = new Bundle();
        bundle2.putSerializable("selected_model", (Serializable)paramLiveGiftModel);
        bundle2.putInt("gift_count", paramInt1);
        if (paramInt2 == 4221005) {
          bundle2.putString("title", getString(R.string.Live_SendPresent_verifyPassword));
        } else {
          bundle2.putString("title", paramString);
        } 
        bundle2.putString("content", getString(R.string.Live_SendPresent_verifyPasswordText));
        LiveRouteUtil.a((Fragment)this, bundle2, paramInt2);
        return;
      case 4221002:
        break;
    } 
    Bundle bundle1 = new Bundle();
    bundle1.putSerializable("selected_model", (Serializable)paramLiveGiftModel);
    bundle1.putInt("gift_count", paramInt1);
    bundle1.putString("title", getString(R.string.Live_SendPresent_resetPayPassword));
    bundle1.putString("content", getString(R.string.live_set_6_num));
    bundle1.putString("http_host", LiveRoomInfo.a().m());
    LiveRouteUtil.a((Fragment)this, bundle1, paramInt2);
  }
  
  private void a(LiveGiftModel paramLiveGiftModel, int paramInt, String paramString, boolean paramBoolean) {
    if (paramLiveGiftModel == null)
      return; 
    if (!z())
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("buyGift.selectedModel: ");
    stringBuilder.append(paramLiveGiftModel.toString());
    stringBuilder.append(", gifCount:");
    stringBuilder.append(paramInt);
    stringBuilder.append(", payCode:");
    stringBuilder.append(paramString);
    stringBuilder.append(", payToken:");
    String str1 = "";
    stringBuilder.append(LiveRoomPreferences.b(""));
    stringBuilder.append(", remember_me:");
    stringBuilder.append(paramBoolean);
    LogUtils.c(stringBuilder.toString());
    BluedUIHttpResponse<BluedEntity<PayRemaining, LiveZanExtraModel>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntity<PayRemaining, LiveZanExtraModel>>(this, (IRequestHost)w_(), paramLiveGiftModel, paramInt) {
        public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
          super.onFailure(param1Throwable, param1Int, param1String);
          LiveGiftFragment.d(param1String);
        }
        
        public boolean onUIFailure(int param1Int, String param1String) {
          if (!LiveGiftFragment.c(this.c))
            return false; 
          KeyboardUtils.a((Activity)this.c.getActivity());
          LiveGiftFragment.a(this.c, this.a, this.b, param1Int, param1String);
          return true;
        }
        
        public void onUIUpdate(BluedEntity<PayRemaining, LiveZanExtraModel> param1BluedEntity) {
          if (!LiveGiftFragment.b(this.c))
            return; 
          KeyboardUtils.a((Activity)this.c.getActivity());
          if (param1BluedEntity != null && param1BluedEntity.getSingleData() != null) {
            PayRemaining payRemaining = (PayRemaining)param1BluedEntity.getSingleData();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("buyGift.onUIUpdate: ");
            stringBuilder.append(payRemaining.toString());
            LogUtils.c(stringBuilder.toString());
            LiveGiftFragment.a(this.c, payRemaining, this.a, (LiveZanExtraModel)param1BluedEntity.extra, this.b);
            return;
          } 
          LiveGiftFragment.a(this.c, this.a, this.b, 0, (String)null);
        }
      };
    String str2 = LiveRoomManager.a().e();
    String str3 = LiveRoomManager.a().c();
    if (TextUtils.isEmpty(paramString))
      str1 = LiveRoomPreferences.b(""); 
    LiveRoomHttpUtils.a(str2, str3, paramLiveGiftModel, "", paramString, str1, paramBoolean, paramInt, bluedUIHttpResponse, (IRequestHost)w_());
  }
  
  private void a(LiveGiftModel paramLiveGiftModel, PayRemaining paramPayRemaining, LiveZanExtraModel paramLiveZanExtraModel, int paramInt) {
    paramLiveGiftModel.sendGiftStatus = 3;
    paramLiveGiftModel.hit_id = paramPayRemaining.hit_id;
    paramLiveGiftModel.beans_count = paramPayRemaining.beans_count;
    paramLiveGiftModel.beans_current_count = paramPayRemaining.beans_current;
    paramLiveGiftModel.free_number = paramPayRemaining.free_number;
    paramLiveGiftModel.bonus = paramPayRemaining.bonus;
    paramLiveGiftModel.animation = paramPayRemaining.animation;
    if (paramLiveGiftModel.double_hit == 1)
      paramLiveGiftModel.comboWaitTime = this.J; 
    if (paramLiveZanExtraModel != null) {
      paramLiveGiftModel.user_store_count = paramLiveZanExtraModel.user_store_count;
      paramLiveGiftModel.danmu_count = paramLiveZanExtraModel.danmu_count;
      if (paramLiveZanExtraModel.join_club == 1) {
        AppMethods.d(R.string.live_fans_add_success);
        if (LiveRoomManager.a().i() != null)
          (LiveRoomManager.a().i()).fans_status = 1; 
        LiveEventBus.get("live_refresh_gift_list").post(Boolean.valueOf(true));
      } 
    } 
    if (paramLiveGiftModel.is_join_ticket == 1)
      EventTrackLive.a(LiveProtos.Event.LIVE_SEND_FANS_CLUB_TICKET, LiveProtos.Source.GIFT_PAGE, LiveRoomManager.a().c(), LiveRoomManager.a().e()); 
    if (LiveRoomManager.a().i() != null && (LiveRoomManager.a().i()).fans_status == 2 && paramLiveGiftModel.beans_count >= 6.0D) {
      LogUtils.c("zhi hui dian liang");
      LiveFansObserver.a().d();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("after updateGiftValue: ");
    stringBuilder.append(paramLiveGiftModel.toString());
    LogUtils.c(stringBuilder.toString());
  }
  
  private void a(LiveLevelInfoModel paramLiveLevelInfoModel) {
    if (paramLiveLevelInfoModel == null)
      return; 
    TextView textView = this.T;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Lv.");
    stringBuilder.append(LiveUtils.a(paramLiveLevelInfoModel.rich_level));
    textView.setText(stringBuilder.toString());
    if (paramLiveLevelInfoModel.next_rich_level == 0) {
      this.V.setText("Lv.Max");
      this.U.setProgress(100);
      this.W.setText(R.string.live_gift_max_value);
      return;
    } 
    textView = this.V;
    stringBuilder = new StringBuilder();
    stringBuilder.append("Lv.");
    stringBuilder.append(LiveUtils.b(paramLiveLevelInfoModel.next_rich_level));
    textView.setText(stringBuilder.toString());
    if (Build.VERSION.SDK_INT >= 24) {
      this.U.setProgress(LiveUtils.a(paramLiveLevelInfoModel.rich_beans, paramLiveLevelInfoModel.this_level_beans, paramLiveLevelInfoModel.next_level_beans), true);
    } else {
      this.U.setProgress(LiveUtils.a(paramLiveLevelInfoModel.rich_beans, paramLiveLevelInfoModel.this_level_beans, paramLiveLevelInfoModel.next_level_beans));
    } 
    int i = A();
    LiveGiftModel liveGiftModel = this.af;
    if (liveGiftModel != null) {
      this.U.setSecondaryProgress(LiveUtils.a((liveGiftModel.beans * i), paramLiveLevelInfoModel.rich_beans, paramLiveLevelInfoModel.this_level_beans, paramLiveLevelInfoModel.next_level_beans));
      float f = (float)(this.af.beans / 100.0D);
      this.W.setTextColor(getResources().getColor(R.color.nafio_f));
      TextView textView1 = this.W;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("+");
      stringBuilder1.append(b(f * i));
      stringBuilder1.append(getString(R.string.live_gift_value));
      textView1.setText(stringBuilder1.toString());
    } 
    V();
  }
  
  private void a(PayRemaining paramPayRemaining, LiveGiftModel paramLiveGiftModel, LiveZanExtraModel paramLiveZanExtraModel, int paramInt) {
    if (paramPayRemaining == null)
      return; 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("buyGiftSuccess: ");
    stringBuilder2.append(paramPayRemaining.toString());
    LogUtils.c(stringBuilder2.toString());
    if (!TextUtils.isEmpty(paramPayRemaining.token))
      LiveRoomPreferences.c(paramPayRemaining.token); 
    a((BasePayRemaining)paramPayRemaining);
    a(paramLiveGiftModel, paramPayRemaining, paramLiveZanExtraModel, paramInt);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("buyGiftSuccess after updateGiftValue: ");
    stringBuilder1.append(paramLiveGiftModel.toString());
    LogUtils.c(stringBuilder1.toString());
    if (!TextUtils.isEmpty(paramLiveGiftModel.contents) || paramLiveGiftModel.effect != null) {
      LogUtils.a("弹幕消息，不模拟发消息");
    } else {
      a(paramLiveGiftModel, paramInt);
      if (paramLiveZanExtraModel != null && paramLiveZanExtraModel.box != null && paramLiveZanExtraModel.box.size() > 0) {
        LiveGiftModel liveGiftModel = paramLiveZanExtraModel.box.get(0);
        if (liveGiftModel.ops == 4) {
          paramLiveGiftModel.ops = liveGiftModel.ops;
          paramLiveGiftModel.box_image = liveGiftModel.images_static;
        } 
      } 
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("gift success type_name  = ");
      stringBuilder1.append(paramLiveGiftModel.type_name);
      LogUtils.a(stringBuilder1.toString());
      LiveMsgSendManager.a().a(paramLiveGiftModel);
    } 
    L();
    this.H = (CommonLiveGiftModel)paramLiveGiftModel;
    e((CommonLiveGiftModel)paramLiveGiftModel, paramInt);
    LiveEventBus.get("gift_item_update").post(paramLiveGiftModel);
    if (paramLiveGiftModel.packageTabIndex == 2) {
      y();
      return;
    } 
    if (paramLiveZanExtraModel != null)
      a(paramLiveZanExtraModel.box, paramLiveGiftModel.beans_count); 
    a((CommonLiveGiftModel)paramLiveGiftModel);
  }
  
  private void a(List<LiveGiftModel> paramList, double paramDouble) {
    if (paramList != null) {
      String str;
      if (paramList.size() == 0)
        return; 
      LiveGiftModel liveGiftModel = paramList.get(0);
      if (liveGiftModel.ops == 2 || liveGiftModel.ops == 4) {
        liveGiftModel.hit_count = liveGiftModel.count;
        if (liveGiftModel.beans_count < paramDouble)
          liveGiftModel.beans_count = paramDouble; 
        LiveMsgSendManager.a().a(liveGiftModel);
        return;
      } 
      if (liveGiftModel.ops == 3) {
        str = String.format(getString(R.string.get_barrage), new Object[] { String.valueOf(liveGiftModel.count) });
        this.M.setVisibility(0);
        this.L.setText(str);
        AppInfo.n().removeCallbacks(this.Z);
        AppInfo.n().postDelayed(this.Z, 2000L);
        return;
      } 
      if (((LiveGiftModel)str).ops == -1) {
        this.M.setVisibility(0);
        this.L.setText(((LiveGiftModel)str).text);
        AppInfo.n().removeCallbacks(this.Z);
        AppInfo.n().postDelayed(this.Z, 2000L);
        return;
      } 
    } 
  }
  
  private String b(float paramFloat) {
    float f = paramFloat;
    if (paramFloat < 0.0F)
      f = 0.0F; 
    return (new DecimalFormat("0.##")).format(f);
  }
  
  private void b(int paramInt1, int paramInt2) {
    if (paramInt1 == 1) {
      e(paramInt2);
      return;
    } 
    if (paramInt1 == 2) {
      f(paramInt2);
      return;
    } 
    if (paramInt1 == 3 && paramInt2 == 1) {
      b(this.af, 0);
      return;
    } 
    if (paramInt1 == 4 && paramInt2 == 1) {
      b(this.af, 1);
      return;
    } 
    if (paramInt1 == 5) {
      if (this.af.effect != null) {
        LiveGiftModel liveGiftModel = this.af;
        liveGiftModel.effectModel = liveGiftModel.effect.get(paramInt2);
      } 
      R();
    } 
  }
  
  private void b(CommonGiftPackageModel paramCommonGiftPackageModel) {
    if (paramCommonGiftPackageModel.goods != null)
      for (LiveGiftModel liveGiftModel : paramCommonGiftPackageModel.goods) {
        if (liveGiftModel.groups != null && liveGiftModel.groups.size() > 1 && ((LiveGiftNumberModel)liveGiftModel.groups.get(liveGiftModel.groups.size() - 1)).count != 1)
          Collections.reverse(liveGiftModel.groups); 
      }  
  }
  
  private void b(LiveGiftModel paramLiveGiftModel, int paramInt) {
    if (paramLiveGiftModel == null)
      return; 
    paramLiveGiftModel.sendGiftStatus = 1;
    LiveEventBus.get("gift_item_update").post(paramLiveGiftModel);
    LiveRoomHttpUtils.a(paramLiveGiftModel.goods_id, paramInt, new BluedUIHttpResponse<BluedEntityA<LiveGiftModel>>(this, (IRequestHost)w_(), paramLiveGiftModel) {
          public void a(BluedEntityA<LiveGiftModel> param1BluedEntityA) {
            this.a.sendGiftStatus = 0;
            LiveEventBus.get("gift_item_update").post(this.a);
            this.b.y();
          }
        });
  }
  
  private String[] c(boolean paramBoolean) {
    LiveGiftModel liveGiftModel = this.af;
    if (liveGiftModel == null || liveGiftModel.effect == null)
      return null; 
    String[] arrayOfString = new String[this.af.effect.size() + 1];
    if (paramBoolean) {
      arrayOfString[0] = this.aa;
    } else {
      arrayOfString[0] = this.ab;
    } 
    int i = 0;
    while (i < this.af.effect.size()) {
      LiveEffectModel liveEffectModel = this.af.effect.get(i);
      i++;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(String.format(getResources().getString(R.string.renew_1_months), new Object[] { String.valueOf(liveEffectModel.expire) }));
      stringBuilder.append("(");
      stringBuilder.append(a(liveEffectModel.beans));
      stringBuilder.append(getResources().getString(R.string.Live_SendPresent_wandou));
      stringBuilder.append(")");
      arrayOfString[i] = stringBuilder.toString();
    } 
    return arrayOfString;
  }
  
  public static void d(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("checkSavePayToken: ");
    stringBuilder.append(paramString);
    LogUtils.c(stringBuilder.toString());
    if (TextUtils.isEmpty(paramString))
      return; 
    try {
      BluedEntityA bluedEntityA = (BluedEntityA)AppInfo.f().fromJson(paramString, (new TypeToken<BluedEntityA<PayRemaining>>() {
          
          }).getType());
      if (bluedEntityA.hasData()) {
        String str = ((PayRemaining)bluedEntityA.data.get(0)).token;
        if (!TextUtils.isEmpty(str)) {
          LiveRoomPreferences.c(str);
          return;
        } 
      } 
    } catch (JsonSyntaxException jsonSyntaxException) {
      jsonSyntaxException.printStackTrace();
    } 
  }
  
  private void d(List<CommonGiftPackageModel> paramList) {
    if (TypeUtils.a(paramList))
      return; 
    for (int i = 0; i < paramList.size(); i++) {
      CommonGiftPackageModel commonGiftPackageModel = paramList.get(i);
      if (LiveDataManager.a().f()) {
        commonGiftPackageModel.setLine(1);
        commonGiftPackageModel.setRow(6);
        if (commonGiftPackageModel.tabIndex == 2)
          commonGiftPackageModel.setRow(4); 
      } else {
        commonGiftPackageModel.setLine(2);
        commonGiftPackageModel.setRow(4);
        if (commonGiftPackageModel.tabIndex == 2)
          commonGiftPackageModel.setRow(3); 
      } 
      if (commonGiftPackageModel.tabIndex == 0 || commonGiftPackageModel.tabIndex == 1)
        b(commonGiftPackageModel); 
    } 
  }
  
  private void d(boolean paramBoolean) {
    if (paramBoolean)
      y(); 
  }
  
  private void e(int paramInt) {
    LiveGiftModel liveGiftModel = this.af;
    if (liveGiftModel == null)
      return; 
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt != 2)
          return; 
        if (liveGiftModel.effect != null && this.af.effect.size() >= 2) {
          liveGiftModel = this.af;
          liveGiftModel.effectModel = liveGiftModel.effect.get(1);
          R();
          return;
        } 
      } else if (liveGiftModel.effect != null && this.af.effect.size() >= 1) {
        liveGiftModel = this.af;
        liveGiftModel.effectModel = liveGiftModel.effect.get(0);
        R();
        return;
      } 
    } else {
      b(liveGiftModel, 0);
    } 
  }
  
  private void f(int paramInt) {
    LiveGiftModel liveGiftModel = this.af;
    if (liveGiftModel == null)
      return; 
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt != 2)
          return; 
        if (liveGiftModel.effect != null && this.af.effect.size() >= 2) {
          liveGiftModel = this.af;
          liveGiftModel.effectModel = liveGiftModel.effect.get(1);
          R();
          return;
        } 
      } else if (liveGiftModel.effect != null && this.af.effect.size() >= 1) {
        liveGiftModel = this.af;
        liveGiftModel.effectModel = liveGiftModel.effect.get(0);
        R();
        return;
      } 
    } else {
      b(liveGiftModel, 1);
    } 
  }
  
  private void g(int paramInt) {
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt != 2)
          return; 
        EventTrackLive.a(LiveProtos.Event.LIVE_GIFT_PAGE, LiveRoomManager.a().c(), LiveRoomManager.a().e(), 3);
        InstantLog.b("live_gift_page", 3);
        return;
      } 
      EventTrackLive.a(LiveProtos.Event.LIVE_GIFT_PAGE, LiveRoomManager.a().c(), LiveRoomManager.a().e(), 2);
      InstantLog.b("live_gift_page", 2);
      return;
    } 
    EventTrackLive.a(LiveProtos.Event.LIVE_GIFT_PAGE, LiveRoomManager.a().c(), LiveRoomManager.a().e(), 1);
    InstantLog.b("live_gift_page", 1);
  }
  
  public void C() {
    if (Q() != null)
      Q().aJ(); 
  }
  
  public void H() {
    super.H();
    P();
  }
  
  public void K() {
    if (LiveRoomPreferences.k() == 0) {
      View view = this.R;
      if (view != null)
        view.setVisibility(0); 
    } 
  }
  
  public void L() {
    LiveRoomHttpUtils.p(new BluedUIHttpResponse<BluedEntityA<LiveLevelModel>>(this, (IRequestHost)w_()) {
          protected void a(BluedEntityA<LiveLevelModel> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.getSingleData() != null) {
              LiveLevelModel liveLevelModel = (LiveLevelModel)param1BluedEntityA.getSingleData();
              if (liveLevelModel.info != null) {
                LiveGiftFragment.a(this.a, liveLevelModel.info);
                if ((LiveGiftFragment.g(this.a)).next_rich_level == -1) {
                  LiveGiftFragment.h(this.a).setVisibility(8);
                  return;
                } 
                LiveGiftFragment.h(this.a).setVisibility(0);
                LiveGiftFragment.b(this.a, liveLevelModel.info);
              } 
            } 
          }
        }LiveRoomInfo.a().f());
  }
  
  public void M() {
    LiveRoomHttpUtils.n(new BluedUIHttpResponse<BluedEntityA<LiveGiftBagModel>>(this, (IRequestHost)Q().w_()) {
          protected void a(BluedEntityA<LiveGiftBagModel> param1BluedEntityA) {
            LogUtils.a("getGiftBag成功");
            if (param1BluedEntityA != null && param1BluedEntityA.getSingleData() != null) {
              LiveGiftBagModel liveGiftBagModel = (LiveGiftBagModel)param1BluedEntityA.getSingleData();
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append("liveGiftBagModel = ");
              stringBuilder1.append(liveGiftBagModel.toString());
              LogUtils.a(stringBuilder1.toString());
              LiveMsgSendManager liveMsgSendManager = LiveMsgSendManager.a();
              StringBuilder stringBuilder2 = new StringBuilder();
              stringBuilder2.append("首冲礼包 上架状态：");
              stringBuilder2.append(liveGiftBagModel.is_shelves_new);
              stringBuilder2.append(" -- 充值购买状态：");
              stringBuilder2.append(liveGiftBagModel.buy_state);
              liveMsgSendManager.b(stringBuilder2.toString());
              if (liveGiftBagModel.is_shelves_new == 1) {
                if (liveGiftBagModel.buy_state == 0) {
                  EventTrackLive.a(LiveProtos.Event.LIVE_VIEWERS_FIRST_PAY_BTN_SHOW);
                  return;
                } 
                if (liveGiftBagModel.buy_state == 1) {
                  EventTrackLive.a(LiveProtos.Event.LIVE_VIEWERS_FIRST_PAY_BTN_SHOW);
                  return;
                } 
                int i = liveGiftBagModel.buy_state;
              } 
            } 
          }
        });
  }
  
  public void N() {
    this.Y.setVisibility(0);
    Y();
  }
  
  public void O() {
    CountDownTimer countDownTimer = this.ag;
    if (countDownTimer != null)
      countDownTimer.cancel(); 
  }
  
  public boolean V_() {
    LogUtils.c("");
    if (super.V_())
      return true; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("GiftFragment: ");
    stringBuilder.append(isHidden());
    LogUtils.c(stringBuilder.toString());
    if (!isHidden()) {
      Q().aJ();
      return true;
    } 
    return false;
  }
  
  public BaseFragment a(CommonGiftPackageModel paramCommonGiftPackageModel, Bundle paramBundle) {
    return (BaseFragment)new LiveGiftParentFragment();
  }
  
  public void a(int paramInt) {
    g(paramInt);
    if (paramInt == 2) {
      this.u.setVisibility(8);
      this.x.setVisibility(8);
      return;
    } 
    this.u.setVisibility(0);
    this.x.setVisibility(0);
  }
  
  public void a(BaseFragment paramBaseFragment) {
    this.ai = paramBaseFragment;
  }
  
  public void a(BaseGiftModel paramBaseGiftModel, boolean paramBoolean) {
    super.a(paramBaseGiftModel, paramBoolean);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramBaseGiftModel.index);
    stringBuilder.append(", ");
    stringBuilder.append(paramBoolean);
    LogUtils.c(stringBuilder.toString());
    LiveGiftModel liveGiftModel = this.af;
    if (liveGiftModel != null && !StringUtils.a(liveGiftModel.index, paramBaseGiftModel.index)) {
      EventTrackLive.a(LiveProtos.Event.LIVE_GIFT_PAGE_GIFT_CLICK, LiveRoomManager.a().c(), LiveRoomManager.a().e(), ((LiveGiftModel)paramBaseGiftModel).goods_id, paramBaseGiftModel.packageTabIndex + 1, paramBaseGiftModel.pageIndex + 1, paramBaseGiftModel.positionInPage + 1);
      I();
      liveGiftModel = (LiveGiftModel)a(this.af.index);
      if (liveGiftModel != null) {
        liveGiftModel.isSelected = false;
        liveGiftModel.comboWaitTime = 0;
        LiveEventBus.get("gift_item_update").post(liveGiftModel);
      } 
    } 
    this.af = (LiveGiftModel)paramBaseGiftModel;
    if (!TypeUtils.a(this.af.groups)) {
      this.E = this.af.groups.get(this.af.groups.size() - 1);
    } else {
      this.E = null;
    } 
    P();
    if (paramBaseGiftModel.packageTabIndex == 2) {
      if (!paramBoolean)
        return; 
      if (this.af.is_my == 1) {
        if (this.af.effect != null && this.af.effect.size() > 0) {
          if (this.af.is_use == 1) {
            a(1, c(false));
            return;
          } 
          a(2, c(true));
          return;
        } 
        if (this.af.is_use == 1) {
          a(3, new String[] { this.ac, this.ab });
          return;
        } 
        a(4, new String[] { this.ac, this.aa });
        return;
      } 
      if (this.af.effect != null) {
        String[] arrayOfString = new String[this.af.effect.size()];
        for (int i = 0; i < this.af.effect.size(); i++) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(String.format(getResources().getString(R.string.bug_1_months), new Object[] { String.valueOf(((LiveEffectModel)this.af.effect.get(i)).expire) }));
          stringBuilder1.append("(");
          stringBuilder1.append(CommonStringUtils.a(((LiveEffectModel)this.af.effect.get(i)).beans));
          stringBuilder1.append(getResources().getString(R.string.Live_SendPresent_wandou));
          stringBuilder1.append(")");
          arrayOfString[i] = stringBuilder1.toString();
        } 
        a(5, arrayOfString);
        return;
      } 
    } else {
      X();
      a(this.ad);
    } 
  }
  
  protected void a(LiveGiftModel paramLiveGiftModel, int paramInt) {
    d((CommonLiveGiftModel)paramLiveGiftModel, paramInt);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("giftCount = ");
    stringBuilder.append(paramInt);
    stringBuilder.append(", ");
    stringBuilder.append(paramLiveGiftModel.toString());
    LogUtils.c(stringBuilder.toString());
    if (paramInt > 1) {
      paramLiveGiftModel.hit_batch = 1;
      paramLiveGiftModel.hit_count = paramInt;
    } else {
      paramLiveGiftModel.hit_batch = 0;
      if (paramLiveGiftModel.double_hit == 1)
        paramLiveGiftModel.hit_count++; 
    } 
    this.C = paramLiveGiftModel.hit_id;
    stringBuilder = new StringBuilder();
    stringBuilder.append("after judge, giftCount = ");
    stringBuilder.append(paramInt);
    stringBuilder.append(", ");
    stringBuilder.append(paramLiveGiftModel.toString());
    LogUtils.c(stringBuilder.toString());
  }
  
  public void b(BasePayRemaining paramBasePayRemaining) {
    if (paramBasePayRemaining == null)
      return; 
    PayRemaining payRemaining = (PayRemaining)paramBasePayRemaining;
    if (!TextUtils.isEmpty(payRemaining.image_url))
      LiveSetDataObserver.a().a(payRemaining.image_url); 
  }
  
  public void b(boolean paramBoolean) {
    if (paramBoolean)
      LiveRoomPreferences.f(1); 
    View view = this.R;
    if (view != null)
      view.setVisibility(8); 
  }
  
  public void c(BasePayRemaining paramBasePayRemaining) {
    super.c(paramBasePayRemaining);
    if (LiveDataManager.a().f()) {
      if (paramBasePayRemaining.bonus > 0L) {
        this.N.setVisibility(0);
        TextView textView = this.N;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        stringBuilder.append(String.format(getResources().getString(R.string.live_contain), new Object[] { CommonStringUtils.d(String.valueOf(paramBasePayRemaining.bonus)) }));
        stringBuilder.append(")");
        textView.setText(stringBuilder.toString());
        return;
      } 
      this.N.setVisibility(4);
      return;
    } 
    if (paramBasePayRemaining.bonus > 0L) {
      if (this.O != null) {
        this.N.setVisibility(0);
        this.O.setVisibility(8);
        TextView textView = this.N;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        stringBuilder.append(String.format(getResources().getString(R.string.live_contain), new Object[] { CommonStringUtils.d(String.valueOf(paramBasePayRemaining.bonus)) }));
        stringBuilder.append(")");
        textView.setText(stringBuilder.toString());
        return;
      } 
    } else if (this.O != null) {
      this.N.setVisibility(8);
      this.O.setVisibility(8);
    } 
  }
  
  public int k() {
    return LiveDataManager.a().f() ? R.layout.fragment_live_gift_land : R.layout.fragment_live_gift;
  }
  
  public void n() {
    super.n();
    this.F = getString(R.string.Live_SendPresent_recharge);
    this.N = (TextView)this.d.findViewById(R.id.give_price_view);
    this.u = (TextView)this.d.findViewById(R.id.give_gift_view);
    this.v = this.d.findViewById(R.id.live_gift_blank_view);
    this.L = (TextView)this.d.findViewById(R.id.gift_msg_view);
    this.M = (LinearLayout)this.d.findViewById(R.id.gift_top_layout);
    this.P = (FrameLayout)this.d.findViewById(R.id.gift_info_image_layout);
    this.Q = (ImageView)this.d.findViewById(R.id.gift_info_image_view);
    this.R = this.d.findViewById(R.id.live_pk_tips);
    this.S = this.d.findViewById(R.id.live_pk_tips_btn);
    this.T = (TextView)this.d.findViewById(R.id.current_level);
    this.U = (ProgressBar)this.d.findViewById(R.id.gift_progress);
    this.V = (TextView)this.d.findViewById(R.id.next_level);
    this.W = (TextView)this.d.findViewById(R.id.grow_up_text);
    this.X = this.d.findViewById(R.id.gift_progress_layout);
    this.s = (TextView)this.d.findViewById(R.id.price_view);
    this.w = (TextView)this.d.findViewById(R.id.gift_select_num_text);
    this.y = (ImageView)this.d.findViewById(R.id.gift_select_num_image);
    this.x = (LinearLayout)this.d.findViewById(R.id.gift_select_num_view);
    this.t = (TextView)this.d.findViewById(R.id.top_up_view);
    this.z = this.d.findViewById(R.id.live_gift_number_select_layout);
    this.A = (ListView)this.d.findViewById(R.id.live_gift_number_select_list);
    this.O = (TextView)this.d.findViewById(R.id.give_price_view_occupy);
    this.Y = this.d.findViewById(R.id.live_fans_guide);
    this.ac = getResources().getString(R.string.suspend_renewals);
    this.aa = getResources().getString(R.string.equipment);
    this.ab = getResources().getString(R.string.cancel_equipment);
    this.G = true;
    if (LiveDataManager.a().f()) {
      this.O.setVisibility(0);
      return;
    } 
    this.O.setVisibility(8);
  }
  
  public void o() {
    super.o();
    String str = LiveDataManager.a().e();
    if (TypeUtils.a(this.i) && !TextUtils.isEmpty(str))
      try {
        a((BluedEntity<LiveGiftPackageModel, LiveZanExtraModel>)AppInfo.f().fromJson(str, (new TypeToken<BluedEntity<LiveGiftPackageModel, LiveZanExtraModel>>(this) {
              
              }).getType()));
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
        LiveDataManager.a().c(null);
      }  
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
      if ((paramInt1 == 4221005 || paramInt1 == 4221004) && paramIntent != null) {
        LiveGiftModel liveGiftModel = (LiveGiftModel)paramIntent.getSerializableExtra("selected_model");
        String str = paramIntent.getStringExtra("password");
        boolean bool = paramIntent.getBooleanExtra("remember_me", false);
        paramInt1 = paramIntent.getIntExtra("gift_count", 1);
        if (!TextUtils.isEmpty(str) && liveGiftModel != null) {
          a(liveGiftModel, paramInt1, str, bool);
          return;
        } 
      } else if (paramInt1 == 4221002 && paramIntent != null) {
        LiveGiftModel liveGiftModel = (LiveGiftModel)paramIntent.getSerializableExtra("selected_model");
        paramInt1 = paramIntent.getIntExtra("gift_count", 1);
        boolean bool = paramIntent.getBooleanExtra("remember_me", false);
        a(liveGiftModel, paramInt1, paramIntent.getStringExtra("password"), bool);
      }  
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() == R.id.top_up_view) {
      if (Q().aH()) {
        Q().a(true);
        LiveRoomInfo.a().a(getContext(), 3);
        return;
      } 
    } else {
      String str;
      ArrayList<LiveGiftNumberModel> arrayList;
      if (paramView.getId() == R.id.give_gift_view) {
        if (this.af == null)
          return; 
        int i = A();
        str = this.af.goods_id;
        EventTrackLive.a(LiveProtos.Event.USER_LIVE_GIFT_BTN_CLICK, LiveRoomManager.a().c(), LiveRoomManager.a().e(), str, i);
        if (this.af.is_join_ticket == 1 && LiveRoomManager.a().i() != null && (LiveRoomManager.a().i()).fans_status == 0) {
          str = String.format(getResources().getString(R.string.live_fans_name_join_tip), new Object[] { String.valueOf(this.af.beans) });
          CommonAlertDialog.a((Context)getActivity(), "", str, getResources().getString(R.string.sure), new -$$Lambda$LiveGiftFragment$OgSK8IfQAAOdn27F-vIOAkCeHR0(this), getResources().getString(R.string.live_fans_quit_cancel), null, null);
          return;
        } 
        if (this.af.packageTabIndex == 2)
          return; 
        T();
        return;
      } 
      if (str.getId() == R.id.gift_select_num_view) {
        LiveGiftModel liveGiftModel = this.af;
        if (liveGiftModel != null && !TypeUtils.a(liveGiftModel.groups)) {
          int i = A();
          arrayList = new ArrayList();
          for (LiveGiftNumberModel liveGiftNumberModel : this.af.groups) {
            if (liveGiftNumberModel.count == i) {
              liveGiftNumberModel.selected = true;
            } else {
              liveGiftNumberModel.selected = false;
            } 
            arrayList.add(liveGiftNumberModel);
          } 
          c(arrayList);
          return;
        } 
      } else {
        String str1;
        if (arrayList.getId() == R.id.live_pk_tips_btn) {
          b(true);
          return;
        } 
        if (arrayList.getId() == R.id.gift_progress_layout) {
          str1 = LiveRoomInfo.a().z();
          LiveRoomInfo.a().b((Context)getActivity(), str1);
          EventTrackLive.a(LiveProtos.Event.LIVE_GIFT_LEVEL_BAR_CLICK, LiveRoomManager.a().c());
          return;
        } 
        if (str1.getId() == R.id.gift_info_image_view) {
          if (LiveDataManager.a().f()) {
            AppMethods.a(getString(R.string.live_luck_turning_land_tips));
            return;
          } 
          LiveGiftModel liveGiftModel = this.af;
          if (liveGiftModel != null) {
            if (TextUtils.isEmpty(liveGiftModel.info_url))
              return; 
            C();
            Q().d(this.af.info_url, 0);
          } 
        } 
      } 
    } 
  }
  
  public void onDestroy() {
    super.onDestroy();
    this.ai = null;
  }
  
  public void onHiddenChanged(boolean paramBoolean) {
    super.onHiddenChanged(paramBoolean);
    if (!paramBoolean) {
      this.H = null;
      LiveEventBus.get("gift_item_selected").post(t());
      this.h.setToolBtnSelect(0);
      this.n.setCurrentItem(0, false);
      LiveEventBus.get("gift_package_selected").post("0");
      if (LiveDataManager.a().f()) {
        LiveSetDataObserver.a().e(0);
      } else {
        LiveSetDataObserver.a().e(4);
        if (Q().B())
          K(); 
      } 
      LiveSetDataObserver.a().b(true);
      EventTrackLive.a(LiveProtos.Event.LIVE_VIEWERS_GIFT_BTN_CLICK);
      y();
      return;
    } 
    this.C = 0L;
    I();
    c(0);
    if (!LiveDataManager.a().f())
      b(false); 
    LiveSetDataObserver.a().e(0);
    LiveSetDataObserver.a().b(false);
    U();
    Q().d(0);
  }
  
  public void p() {
    super.p();
    this.S.setOnClickListener(this);
    this.X.setOnClickListener(this);
    this.Q.setOnClickListener(this);
    LiveEventBus.get("live_fans_guide_pop", Boolean.class).observe((LifecycleOwner)this, new -$$Lambda$LiveGiftFragment$1uq85oWJoW2KZodjMjwZvL8l9tM(this));
    LiveEventBus.get("live_refresh_gift_list", Boolean.class).observe((LifecycleOwner)this, new -$$Lambda$LiveGiftFragment$FyiNLf3Wu6N_IzSBx5srXQB9Duc(this));
    LiveEventBus.get("screen_orientation_changed", Boolean.class).observe((LifecycleOwner)this, new -$$Lambda$LiveGiftFragment$_JGdH-Btp8FIYp30FXEbrhBRDDY(this));
    LiveEventBus.get(LiveEventBusUtil.d, Boolean.class).observe((LifecycleOwner)this, new -$$Lambda$LiveGiftFragment$4lhKTO1wFufQl_HQ6gHYEMiGCuo(this));
  }
  
  public void q() {
    super.q();
    LiveRoomHttpUtils.b();
    M();
    L();
  }
  
  public String u() {
    if (this.i.size() > 0)
      for (LiveGiftModel liveGiftModel : ((CommonGiftPackageModel)this.i.get(0)).goods) {
        if (liveGiftModel.beans > 0L) {
          LogUtils.c(liveGiftModel.index);
          return liveGiftModel.index;
        } 
      }  
    return null;
  }
  
  public String x() {
    return "live_gift";
  }
  
  public void y() {
    LiveRoomHttpUtils.h(new BluedUIHttpResponse<BluedEntity<LiveGiftPackageModel, LiveZanExtraModel>>(this, (IRequestHost)w_()) {
          public void onUIUpdate(BluedEntity<LiveGiftPackageModel, LiveZanExtraModel> param1BluedEntity) {
            if (!LiveGiftFragment.o(this.a))
              return; 
            if (param1BluedEntity != null && param1BluedEntity.data != null && param1BluedEntity.data.size() > 0) {
              LogUtils.c("更新网络礼物列表");
              LiveGiftFragment.a(this.a, param1BluedEntity);
              LiveGiftManager.a().a(param1BluedEntity.data);
            } else {
              LogUtils.c("从网络获取礼物列表失败 无数据");
            } 
            if (param1BluedEntity != null && param1BluedEntity.extra != null) {
              LiveZanExtraModel liveZanExtraModel = (LiveZanExtraModel)param1BluedEntity.extra;
              LiveGiftManager.a().a(liveZanExtraModel);
              LiveEventBus.get("live_gift_zan_model").post(liveZanExtraModel);
            } 
          }
        });
  }
  
  class DanmakuRunnable implements Runnable {
    private DanmakuRunnable(LiveGiftFragment this$0) {}
    
    public void run() {
      if (!LiveGiftFragment.e(this.a))
        return; 
      LiveGiftFragment.f(this.a).setVisibility(4);
    }
  }
  
  class GiftValue implements Runnable {
    GiftValue(LiveGiftFragment this$0) {}
    
    public void run() {
      if (!LiveGiftFragment.i(this.a))
        return; 
      if (LiveGiftFragment.j(this.a)) {
        if (LiveGiftFragment.k(this.a) != null) {
          float f = (float)((LiveGiftFragment.k(this.a)).beans / 100.0D);
          LiveGiftFragment.l(this.a).setTextColor(this.a.getResources().getColor(R.color.nafio_f));
          TextView textView = LiveGiftFragment.l(this.a);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("+");
          LiveGiftFragment liveGiftFragment = this.a;
          stringBuilder.append(LiveGiftFragment.a(liveGiftFragment, f * LiveGiftFragment.m(liveGiftFragment)));
          stringBuilder.append(this.a.getString(R.string.live_gift_value));
          textView.setText(stringBuilder.toString());
        } 
        LiveGiftFragment.a(this.a, false);
      } else {
        if (LiveGiftFragment.g(this.a) != null) {
          LiveGiftFragment.l(this.a).setTextColor(this.a.getResources().getColor(R.color.nafio_k));
          if ((LiveGiftFragment.g(this.a)).next_rich_level == 0) {
            LiveGiftFragment.l(this.a).setText(R.string.live_gift_max_value);
          } else {
            TextView textView = LiveGiftFragment.l(this.a);
            String str = this.a.getString(R.string.live_gift_need_value);
            LiveGiftFragment liveGiftFragment = this.a;
            textView.setText(String.format(str, new Object[] { LiveGiftFragment.a(liveGiftFragment, (LiveGiftFragment.g(liveGiftFragment)).next_level_beans - (LiveGiftFragment.g(this.a)).rich_beans) }));
          } 
        } 
        LiveGiftFragment.a(this.a, true);
      } 
      AppInfo.n().postDelayed(LiveGiftFragment.n(this.a), 3000L);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\mine\LiveGiftFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */