package com.blued.android.module.live_china.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.net.http.QueueFileDownloader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.ReflectionUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.click.SingleClickProxy;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.mine.LiveRouteUtil;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveOneKissModel;
import com.blued.android.module.live_china.model.LiveZanExtraModel;
import com.blued.android.module.live_china.model.PayRemaining;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.utils.LiveGiftPayTools;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.google.gson.reflect.TypeToken;

public class LiveKissDialogFragment extends BaseDialogFragment {
  public static int l;
  
  public Context a;
  
  public View b;
  
  public View c;
  
  public ImageView d;
  
  public ImageView e;
  
  public ImageView f;
  
  public int g;
  
  public int h;
  
  public int i;
  
  public String j;
  
  public String k;
  
  BluedUIHttpResponse m = new BluedUIHttpResponse<BluedEntity<PayRemaining, LiveZanExtraModel>>(this, (IRequestHost)a()) {
      public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
        super.onFailure(param1Throwable, param1Int, param1String);
        LiveKissDialogFragment.a(param1String);
      }
      
      public boolean onUIFailure(int param1Int, String param1String) {
        KeyboardUtils.a((Activity)this.a.getActivity());
        LiveKissDialogFragment.a(this.a, param1Int, param1String);
        return true;
      }
      
      public void onUIFinish() {
        LiveKissDialogFragment.b(this.a).dismiss();
        super.onUIFinish();
      }
      
      public void onUIStart() {
        super.onUIStart();
        LiveKissDialogFragment.b(this.a).show();
      }
      
      public void onUIUpdate(BluedEntity<PayRemaining, LiveZanExtraModel> param1BluedEntity) {
        KeyboardUtils.a((Activity)this.a.getActivity());
        if (param1BluedEntity != null && param1BluedEntity.getSingleData() != null) {
          if (LiveRoomManager.a().h() != null)
            EventTrackLive.a(LiveProtos.Event.LIVE_KISS_PURCHASE_COMPLETE_SHOW, String.valueOf((LiveRoomManager.a().h()).lid), LiveKissDialogFragment.c(this.a)); 
          PayRemaining payRemaining = (PayRemaining)param1BluedEntity.getSingleData();
          LiveKissDialogFragment.d(this.a);
          LiveGiftModel liveGiftModel = new LiveGiftModel();
          if (LiveKissDialogFragment.e(this.a) != null) {
            liveGiftModel.goods_id = (LiveKissDialogFragment.e(this.a)).goods_id;
            liveGiftModel.name = (LiveKissDialogFragment.e(this.a)).goods_name;
            liveGiftModel.images_static = (LiveKissDialogFragment.e(this.a)).goods_icon;
            liveGiftModel.animation = payRemaining.animation;
            liveGiftModel.beans_current_count = payRemaining.beans_current;
            liveGiftModel.beans_count = payRemaining.beans_count;
            liveGiftModel.hit_id = payRemaining.hit_id;
            liveGiftModel.bonus = payRemaining.bonus;
            liveGiftModel.beans = payRemaining.beans;
          } 
          LiveMsgSendManager.a().a(liveGiftModel);
          if (!TextUtils.isEmpty(payRemaining.token))
            LiveRoomPreferences.c(payRemaining.token); 
          this.a.h();
          return;
        } 
        LiveKissDialogFragment.a(this.a, 0, "");
      }
    };
  
  ScaleAnimation n = null;
  
  Runnable o = new Runnable(this) {
      public void run() {
        if (LiveRoomManager.a().h() != null)
          EventTrackLive.a(LiveProtos.Event.LIVE_KISS_AUTO_RETURN_CLICK, String.valueOf((LiveRoomManager.a().h()).lid)); 
        this.a.h();
      }
    };
  
  public EventCallBack p;
  
  private boolean q;
  
  private LiveOneKissModel r = new LiveOneKissModel();
  
  private Dialog s;
  
  private boolean t;
  
  private boolean u = false;
  
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
        if (!TextUtils.isEmpty(paramString)) {
          AppMethods.a(paramString);
          return;
        } 
        return;
      case 4221008:
        j();
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
    String str1;
    LiveGiftModel liveGiftModel = new LiveGiftModel();
    liveGiftModel.goods_id = this.k;
    String str2 = LiveRoomManager.a().e();
    String str3 = LiveDataManager.a().c();
    if (TextUtils.isEmpty(paramString)) {
      str1 = LiveRoomPreferences.b("");
    } else {
      str1 = "";
    } 
    LiveRoomHttpUtils.a(str2, str3, liveGiftModel, "", paramString, str1, paramBoolean, 1, this.m, (IRequestHost)a());
  }
  
  private void i() {}
  
  private void j() {
    LiveGiftPayTools.b();
    if (this.u)
      return; 
    if (a() == null || !a().isActive()) {
      h();
      return;
    } 
    if (LiveRoomManager.a().h() != null)
      EventTrackLive.a(LiveProtos.Event.LIVE_KISS_INSUFFICIENT_SHOW, String.valueOf((LiveRoomManager.a().h()).lid)); 
    String str = getString(R.string.live_id_charge_tip);
    this.u = true;
    CommonAlertDialog.a((Context)getActivity(), null, "", str, getString(R.string.cancel), getString(R.string.Live_SendPresent_recharge), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            LiveKissDialogFragment.a(this.a, false);
            this.a.h();
            LiveRoomInfo.a().a((Context)this.a.getActivity(), 2);
            if (this.a.p != null)
              this.a.p.a(); 
          }
        }new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            LiveKissDialogFragment.a(this.a, false);
          }
        }new DialogInterface.OnCancelListener(this) {
          public void onCancel(DialogInterface param1DialogInterface) {
            LiveKissDialogFragment.a(this.a, false);
          }
        }true);
  }
  
  private void k() {
    this.n = new ScaleAnimation(1.0F, 1.1F, 1.0F, 1.1F, 1, 0.5F, 1, 0.5F);
    this.n.setDuration(600L);
    this.n.setFillAfter(false);
    this.n.setRepeatMode(2);
    this.n.setRepeatCount(-1);
    this.e.clearAnimation();
    this.e.startAnimation((Animation)this.n);
  }
  
  public void a(EventCallBack paramEventCallBack) {
    this.p = paramEventCallBack;
  }
  
  public void f() {
    if (this.t)
      this.e.setVisibility(8); 
  }
  
  public void g() {
    if (this.t)
      this.e.setVisibility(0); 
  }
  
  public void h() {
    Dialog dialog = getDialog();
    if (dialog != null && dialog.isShowing())
      dialog.dismiss(); 
  }
  
  public void onActivityCreated(Bundle paramBundle) {
    getDialog().getWindow().requestFeature(1);
    super.onActivityCreated(paramBundle);
    if (Build.VERSION.SDK_INT >= 23)
      getDialog().getWindow().getDecorView().setSystemUiVisibility(9216); 
    getDialog().getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
    getDialog().getWindow().setLayout(-1, -1);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      if ((paramInt1 == 4221005 || paramInt1 == 4221004) && paramIntent != null) {
        a(paramIntent.getStringExtra("password"), paramIntent.getBooleanExtra("remember_me", false));
        return;
      } 
      if (paramInt1 == 4221002 && paramIntent != null)
        a(paramIntent.getStringExtra("password"), paramIntent.getBooleanExtra("remember_me", false)); 
    } 
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.a = (Context)getActivity();
    if (getArguments() != null)
      this.r = (LiveOneKissModel)getArguments().getSerializable("kissModel"); 
    LiveOneKissModel liveOneKissModel = this.r;
    if (liveOneKissModel != null) {
      this.g = liveOneKissModel.pop;
      this.h = this.r.delay;
      this.i = this.r.duration;
      this.j = this.r.animation;
      this.k = this.r.goods_id;
      this.q = this.r.isChargeTo;
    } 
    setStyle(0, R.style.Dialog_FullScreen);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    LiveRoomHttpUtils.a(LiveDataManager.a().c(), 1);
    this.s = DialogUtils.a(this.a);
    this.b = paramLayoutInflater.inflate(R.layout.dialog_live_kiss, paramViewGroup);
    this.c = this.b.findViewById(R.id.empty_view);
    this.d = (ImageView)this.b.findViewById(R.id.iv_anim);
    this.e = (ImageView)this.b.findViewById(R.id.iv_click);
    this.f = (ImageView)this.b.findViewById(R.id.iv_close);
    this.e.setVisibility(8);
    this.f.setVisibility(8);
    l++;
    String str1 = this.j;
    String str2 = RecyclingUtils.d(str1);
    QueueFileDownloader.QueueFileListener queueFileListener = new QueueFileDownloader.QueueFileListener(this) {
        public void a(int param1Int1, int param1Int2, String param1String1, String param1String2) {
          AppInfo.n().post(new Runnable(this, param1Int1, param1String2) {
                public void run() {
                  if (this.a >= 0) {
                    ImageLoader.d((IRequestHost)this.c.a.a(), this.b).d(LiveKissDialogFragment.l).e(-1).a(new ImageLoader.OnAnimationStateListener(this) {
                          public void a() {
                            this.a.c.a.e.setVisibility(0);
                            this.a.c.a.f.setVisibility(0);
                            LiveKissDialogFragment.a(this.a.c.a);
                          }
                          
                          public void b() {}
                        }).a(this.c.a.d);
                    return;
                  } 
                  this.c.a.h();
                }
              });
        }
      };
    ActivityFragmentActive activityFragmentActive = a();
    QueueFileDownloader.a(new String[] { str1 }, new String[] { str2 }, queueFileListener, (IRequestHost)activityFragmentActive, true);
    this.d.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {}
        });
    this.e.setOnClickListener((View.OnClickListener)new SingleClickProxy(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              if (LiveRoomManager.a().h() != null)
                EventTrackLive.a(LiveProtos.Event.LIVE_KISS_BTN_CLICK, String.valueOf((LiveRoomManager.a().h()).lid)); 
              AppInfo.n().removeCallbacks(this.a.o);
              LiveGiftModel liveGiftModel = new LiveGiftModel();
              liveGiftModel.goods_id = this.a.k;
              LiveRoomHttpUtils.a(LiveRoomManager.a().e(), LiveDataManager.a().c(), liveGiftModel, "", "", LiveRoomPreferences.b(""), false, 1, this.a.m, (IRequestHost)this.a.a());
            }
          }2000L, null));
    this.f.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (LiveRoomManager.a().h() != null)
              EventTrackLive.a(LiveProtos.Event.LIVE_KISS_RETURN_CLICK, String.valueOf((LiveRoomManager.a().h()).lid)); 
            LiveRoomHttpUtils.a(LiveDataManager.a().c(), 2);
            this.a.h();
          }
        });
    this.c.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (LiveRoomManager.a().h() != null)
              EventTrackLive.a(LiveProtos.Event.LIVE_KISS_SURROUNDING_AREA_CLICK, String.valueOf((LiveRoomManager.a().h()).lid)); 
            LiveRoomHttpUtils.a(LiveDataManager.a().c(), 2);
            this.a.h();
          }
        });
    if (this.i > 0) {
      AppInfo.n().removeCallbacks(this.o);
      AppInfo.n().postDelayed(this.o, (this.i * 1000));
    } 
    if (LiveRoomManager.a().h() != null)
      EventTrackLive.a(LiveProtos.Event.LIVE_KISS_POP_SHOW, String.valueOf((LiveRoomManager.a().h()).lid)); 
    this.t = true;
    return this.b;
  }
  
  public void onDestroy() {
    super.onDestroy();
    if (this.t) {
      ImageView imageView = this.e;
      if (imageView != null)
        imageView.clearAnimation(); 
      this.s.dismiss();
      AppInfo.n().removeCallbacks(this.o);
    } 
  }
  
  public void show(FragmentManager paramFragmentManager, String paramString) {
    try {
      ReflectionUtils.a(this, "mDismissed", Boolean.valueOf(false));
      ReflectionUtils.a(this, "mShownByMe", Boolean.valueOf(true));
      FragmentTransaction fragmentTransaction = paramFragmentManager.beginTransaction();
      fragmentTransaction.add((Fragment)this, paramString);
      fragmentTransaction.commitAllowingStateLoss();
      return;
    } catch (Exception exception) {
      super.show(paramFragmentManager, paramString);
      return;
    } 
  }
  
  public static interface EventCallBack {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LiveKissDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */