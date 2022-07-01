package com.blued.android.module.live_china.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TransparentActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.mine.LiveRouteUtil;
import com.blued.android.module.live_china.model.LiveLiangModel;
import com.blued.android.module.live_china.model.LiveLiangOrderModel;
import com.blued.android.module.live_china.model.PayRemaining;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.pop.LiveLiangPayedPop;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.utils.LiveGiftPayTools;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.google.gson.reflect.TypeToken;

public class LiveLiangPayFragment extends BaseFragment {
  public Context d;
  
  public View e;
  
  public LayoutInflater f;
  
  private Dialog g;
  
  private String h;
  
  private int i;
  
  private long j;
  
  private boolean k = false;
  
  private void a(int paramInt, String paramString) {
    Bundle bundle2;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("buyLiangFail: , errorCode:");
    stringBuilder.append(paramInt);
    stringBuilder.append(", errorMessage:");
    stringBuilder.append(paramString);
    LogUtils.c(stringBuilder.toString());
    switch (paramInt) {
      default:
        getActivity().finish();
        if (!TextUtils.isEmpty(paramString)) {
          AppMethods.a(paramString);
          return;
        } 
        return;
      case 4221008:
        l();
        return;
      case 4221004:
      case 4221005:
        bundle2 = new Bundle();
        if (paramInt == 4221005) {
          bundle2.putString("title", getString(R.string.Live_SendPresent_verifyPassword));
        } else {
          bundle2.putString("title", paramString);
        } 
        bundle2.putString("content", getString(R.string.Live_SendPresent_verifyPasswordText));
        LiveRouteUtil.a((Fragment)this, bundle2, paramInt);
        return;
      case 4221002:
        break;
    } 
    Bundle bundle1 = new Bundle();
    bundle1.putString("title", getString(R.string.Live_SendPresent_resetPayPassword));
    bundle1.putString("content", getString(R.string.live_set_6_num));
    bundle1.putString("http_host", LiveRoomInfo.a().m());
    LiveRouteUtil.a((Fragment)this, bundle1, paramInt);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, long paramLong) {
    Bundle bundle = new Bundle();
    bundle.putString("liang_id", paramString);
    bundle.putInt("reNew", paramInt);
    bundle.putLong("expire_time", paramLong);
    TransparentActivity.a(bundle);
    TransparentActivity.b(paramContext, LiveLiangPayFragment.class, bundle);
  }
  
  private void a(LiveLiangOrderModel paramLiveLiangOrderModel) {
    if (paramLiveLiangOrderModel == null) {
      getActivity().finish();
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("buyLiangSuccess: ");
    stringBuilder.append(paramLiveLiangOrderModel.liang_id);
    LogUtils.c(stringBuilder.toString());
    LiveLiangModel liveLiangModel = new LiveLiangModel();
    liveLiangModel.liang_id = paramLiveLiangOrderModel.liang_id;
    liveLiangModel.liang_type = paramLiveLiangOrderModel.liang_type;
    LiveRoomManager.a().a(liveLiangModel);
    LiveSetDataObserver.a().x();
    LiveRoomPreferences.d(false);
    LiveLiangPayedPop.a(this, paramLiveLiangOrderModel.liang_id, paramLiveLiangOrderModel.expire_seconds, this.i);
  }
  
  public static void a(String paramString) {
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
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  private void a(String paramString, boolean paramBoolean) {
    if (!k()) {
      getActivity().finish();
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("buyLiang: , payCode:");
    stringBuilder.append(paramString);
    stringBuilder.append(", payToken:");
    stringBuilder.append(LiveRoomPreferences.b(""));
    LogUtils.c(stringBuilder.toString());
    BluedUIHttpResponse<BluedEntityA<LiveLiangOrderModel>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<LiveLiangOrderModel>>(this, (IRequestHost)w_()) {
        protected void a(BluedEntityA<LiveLiangOrderModel> param1BluedEntityA) {
          if (!this.a.k()) {
            this.a.getActivity().finish();
            return;
          } 
          KeyboardUtils.a((Activity)this.a.getActivity());
          if (param1BluedEntityA != null && param1BluedEntityA.getSingleData() != null) {
            LiveLiangOrderModel liveLiangOrderModel = (LiveLiangOrderModel)param1BluedEntityA.getSingleData();
            LiveLiangPayFragment.a(this.a, liveLiangOrderModel);
            if (!TextUtils.isEmpty(liveLiangOrderModel.token)) {
              LiveRoomPreferences.c(liveLiangOrderModel.token);
              return;
            } 
          } else {
            LiveLiangPayFragment.a(this.a, 0, "");
          } 
        }
        
        public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
          super.onFailure(param1Throwable, param1Int, param1String);
          LiveLiangPayFragment.a(param1String);
        }
        
        public boolean onUIFailure(int param1Int, String param1String) {
          if (!this.a.k()) {
            this.a.getActivity().finish();
            return false;
          } 
          KeyboardUtils.a((Activity)this.a.getActivity());
          LiveLiangPayFragment.a(this.a, param1Int, param1String);
          return true;
        }
        
        public void onUIFinish() {
          LiveLiangPayFragment.a(this.a).dismiss();
          super.onUIFinish();
        }
        
        public void onUIStart() {
          super.onUIStart();
          LiveLiangPayFragment.a(this.a).show();
        }
      };
    if (this.i == 0) {
      LiveRoomHttpUtils.a(this.h, paramString, LiveRoomPreferences.b(""), paramBoolean, bluedUIHttpResponse, (IRequestHost)w_());
      return;
    } 
    LiveRoomHttpUtils.a(this.h, this.j, paramString, LiveRoomPreferences.b(""), paramBoolean, bluedUIHttpResponse, (IRequestHost)w_());
  }
  
  private void l() {
    LiveGiftPayTools.b();
    if (this.k)
      return; 
    if (w_() == null || !w_().isActive()) {
      if (getActivity() != null)
        getActivity().finish(); 
      return;
    } 
    String str = getString(R.string.live_id_charge_tip);
    this.k = true;
    CommonAlertDialog.a((Context)getActivity(), null, "", str, getString(R.string.cancel), getString(R.string.Live_SendPresent_recharge), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            EventTrackLive.a(LiveProtos.Event.BETTER_ID_RENEW_INSUFFICIENT_CONFIRM_CLICK);
            LiveLiangPayFragment.a(this.a, false);
            this.a.getActivity().finish();
            LiveRoomInfo.a().a((Context)this.a.getActivity(), 2);
          }
        }new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            EventTrackLive.a(LiveProtos.Event.BETTER_ID_RENEW_INSUFFICIENT_CANCEL_CLICK);
            LiveLiangPayFragment.a(this.a, false);
            this.a.getActivity().finish();
          }
        }new DialogInterface.OnCancelListener(this) {
          public void onCancel(DialogInterface param1DialogInterface) {
            LiveLiangPayFragment.a(this.a, false);
            this.a.getActivity().finish();
          }
        }true);
  }
  
  public void a() {
    this.g = DialogUtils.a(this.d);
    a("", false);
  }
  
  protected boolean k() {
    return !(w_() == null);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      if ((paramInt1 == 4221005 || paramInt1 == 4221004) && paramIntent != null) {
        LiveProtos.Event event;
        if (this.i == 1) {
          event = LiveProtos.Event.BETTER_ID_RENEW_SUCCESS_CONFIRM_CLICK;
        } else {
          event = LiveProtos.Event.BETTER_ID_RENEW_KEYWORD_CONFIRM_CLICK;
        } 
        EventTrackLive.a(event);
        String str = paramIntent.getStringExtra("password");
        boolean bool = paramIntent.getBooleanExtra("remember_me", false);
        if (!TextUtils.isEmpty(str)) {
          a(str, bool);
          return;
        } 
      } else if (paramInt1 == 4221002 && paramIntent != null) {
        EventTrackLive.a(LiveProtos.Event.BETTER_ID_RENEW_SET_KEYWORD_CONFIRM_CLICK);
        a(paramIntent.getStringExtra("password"), paramIntent.getBooleanExtra("remember_me", false));
        return;
      } 
    } else {
      getActivity().finish();
    } 
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    if (getArguments() != null) {
      this.h = getArguments().getString("liang_id");
      this.i = getArguments().getInt("reNew");
      this.j = getArguments().getLong("expire_time");
    } 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    this.f = LayoutInflater.from(this.d);
    if (this.e == null) {
      this.e = (View)new FrameLayout(this.d);
      StatusBarHelper.a((Activity)getActivity(), false);
      a();
    } 
    return this.e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LiveLiangPayFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */