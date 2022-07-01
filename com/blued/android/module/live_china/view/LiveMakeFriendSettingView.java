package com.blued.android.module.live_china.view;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;

public class LiveMakeFriendSettingView implements View.OnClickListener {
  public View a;
  
  public View b;
  
  public View c;
  
  public Context d;
  
  public LayoutInflater e;
  
  private MyPopupWindow f;
  
  private LinearLayout g;
  
  private ImageView h;
  
  private TextView i;
  
  private TextView j;
  
  private int k;
  
  private BaseFragment l;
  
  private long m;
  
  private boolean n = true;
  
  public LiveMakeFriendSettingView(BaseFragment paramBaseFragment, long paramLong) {
    this.d = paramBaseFragment.getContext();
    this.l = paramBaseFragment;
    this.m = paramLong;
    h();
  }
  
  private void h() {
    this.e = LayoutInflater.from(this.d);
    d();
    this.b = this.a.findViewById(R.id.live_make_friend_setting_layer);
    this.c = this.a.findViewById(R.id.content_layout);
    this.g = (LinearLayout)this.a.findViewById(R.id.ll_loading);
    this.h = (ImageView)this.a.findViewById(R.id.live_make_friend_setting_header);
    this.i = (TextView)this.a.findViewById(R.id.live_make_friend_setting_btn);
    this.j = (TextView)this.a.findViewById(R.id.live_make_friend_camera_btn);
    if (this.n) {
      this.j.setText(R.string.live_make_friend_close_camera);
    } else {
      this.j.setText(R.string.live_make_friend_open_camera);
    } 
    ImageLoader.a(null, LiveRoomInfo.a().d()).a(R.drawable.user_bg_round).c().a(this.h);
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.b.setBackgroundColor(this.d.getResources().getColor(R.color.transparent));
    this.b.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.f();
          }
        });
    this.c.setVisibility(8);
    this.c.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {}
        });
    this.f = new MyPopupWindow(this, this.a, -1, -1, true);
    this.f.setBackgroundDrawable(this.d.getResources().getDrawable(17170445));
    this.f.setTouchable(true);
    this.f.setOutsideTouchable(true);
    this.f.setFocusable(true);
    this.f.update();
  }
  
  private void i() {
    this.c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_bottom_in));
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 0.5F);
    alphaAnimation.setDuration(300L);
    alphaAnimation.setFillAfter(true);
    alphaAnimation.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {}
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    this.b.startAnimation((Animation)alphaAnimation);
  }
  
  private void j() {
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.5F, 0.0F);
    alphaAnimation.setDuration(300L);
    alphaAnimation.setFillAfter(true);
    this.b.startAnimation((Animation)alphaAnimation);
    this.c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_bottom_out));
  }
  
  private void k() {
    BluedUIHttpResponse bluedUIHttpResponse = new BluedUIHttpResponse(this, (IRequestHost)this.l.w_()) {
        public void onUIFinish() {
          super.onUIFinish();
          LiveMakeFriendSettingView.c(this.a).setVisibility(8);
        }
        
        public void onUIStart() {
          super.onUIStart();
          LiveMakeFriendSettingView.c(this.a).setVisibility(0);
        }
        
        public void onUIUpdate(BluedEntity param1BluedEntity) {
          this.a.f();
          if (LiveMakeFriendSettingView.d(this.a) instanceof PlayingOnliveFragment) {
            ((PlayingOnliveFragment)LiveMakeFriendSettingView.d(this.a)).q.a(1);
            ((PlayingOnliveFragment)LiveMakeFriendSettingView.d(this.a)).bP.setState(0);
          } 
          AppMethods.d(R.string.live_make_friend_successful_cancellation);
        }
      };
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.m);
    stringBuilder.append("");
    LiveRoomHttpUtils.g(bluedUIHttpResponse, stringBuilder.toString());
  }
  
  public void a(int paramInt) {
    this.k = paramInt;
    paramInt = this.k;
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt != 2)
          return; 
        this.i.setVisibility(8);
        return;
      } 
      this.i.setText(R.string.live_make_friend_out);
      return;
    } 
    this.i.setText(R.string.live_make_friend_cancel_apply);
  }
  
  public void a(ILiveConnectionAnimListener paramILiveConnectionAnimListener) {
    if (this.c.getVisibility() == 8)
      return; 
    AppInfo.n().postDelayed(new Runnable(this, paramILiveConnectionAnimListener) {
          public void run() {
            LiveMakeFriendSettingView.a(this.b).a();
            ILiveConnectionAnimListener iLiveConnectionAnimListener = this.a;
            if (iLiveConnectionAnimListener != null)
              iLiveConnectionAnimListener.a(); 
          }
        }320L);
    j();
    this.c.setVisibility(8);
  }
  
  public boolean a() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("isCameraOpen = ");
    stringBuilder.append(this.n);
    Logger.a("pk", new Object[] { stringBuilder.toString() });
    return this.n;
  }
  
  public void b() {
    this.n = true;
    this.j.setText(R.string.live_make_friend_close_camera);
    Logger.a("pk", new Object[] { "openCamera当前为开启摄像头" });
  }
  
  public void c() {
    this.n = false;
    this.j.setText(R.string.live_make_friend_open_camera);
    Logger.a("pk", new Object[] { "closeCamera当前为关闭摄像头" });
  }
  
  public void d() {
    this.a = this.e.inflate(R.layout.live_make_friend_setting, null);
  }
  
  public void e() {
    this.b.clearAnimation();
    this.c.clearAnimation();
    if (this.f.isShowing())
      this.f.a(); 
    this.f.showAtLocation(this.c, 81, 0, 0);
    this.c.setVisibility(0);
    i();
  }
  
  public void f() {
    a((ILiveConnectionAnimListener)null);
  }
  
  public void g() {
    BluedUIHttpResponse bluedUIHttpResponse = new BluedUIHttpResponse(this, (IRequestHost)this.l.w_()) {
        public void onUIFinish() {
          super.onUIFinish();
          LiveMakeFriendSettingView.c(this.a).setVisibility(8);
        }
        
        public void onUIStart() {
          super.onUIStart();
          LiveMakeFriendSettingView.c(this.a).setVisibility(0);
        }
        
        public void onUIUpdate(BluedEntity param1BluedEntity) {
          this.a.f();
          if (LiveMakeFriendSettingView.d(this.a) instanceof PlayingOnliveFragment)
            ((PlayingOnliveFragment)LiveMakeFriendSettingView.d(this.a)).af(); 
          AppMethods.d(R.string.live_make_friend_exit_successfully);
        }
      };
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.m);
    stringBuilder.append("");
    LiveRoomHttpUtils.b(bluedUIHttpResponse, stringBuilder.toString(), "");
  }
  
  public void onClick(View paramView) {
    Context context;
    if (paramView.getId() == R.id.live_make_friend_setting_btn) {
      if (this.k == 0) {
        Context context1 = this.d;
        CommonAlertDialog.a(context1, "", context1.getString(R.string.live_make_friend_cancellation_application), this.d.getResources().getString(R.string.biao_v4_ok), new DialogInterface.OnClickListener(this) {
              public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                LiveMakeFriendSettingView.b(this.a);
              }
            },  null, null, null);
        return;
      } 
      context = this.d;
      CommonAlertDialog.a(context, "", context.getString(R.string.live_make_friend_out_tips), this.d.getResources().getString(R.string.filter_off), new DialogInterface.OnClickListener(this) {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
              this.a.g();
            }
          },  null, null, null);
      return;
    } 
    if (context.getId() == R.id.live_make_friend_camera_btn) {
      f();
      BaseFragment baseFragment = this.l;
      if (baseFragment instanceof PlayingOnliveFragment)
        if (this.n) {
          if (((PlayingOnliveFragment)baseFragment).aE()) {
            ((PlayingOnliveFragment)this.l).aS();
          } else {
            c();
          } 
        } else if (((PlayingOnliveFragment)baseFragment).aE()) {
          ((PlayingOnliveFragment)this.l).aT();
        } else {
          b();
        }  
      baseFragment = this.l;
      if (baseFragment instanceof RecordingOnliveFragment) {
        if (this.n) {
          ((RecordingOnliveFragment)baseFragment).au();
          return;
        } 
        ((RecordingOnliveFragment)baseFragment).av();
      } 
    } 
  }
  
  class MyPopupWindow extends PopupWindow {
    public MyPopupWindow(LiveMakeFriendSettingView this$0, View param1View, int param1Int1, int param1Int2, boolean param1Boolean) {
      super(param1View, param1Int1, param1Int2, param1Boolean);
    }
    
    public void a() {
      super.dismiss();
    }
    
    public void dismiss() {
      try {
        this.a.f();
        return;
      } catch (Exception exception) {
        a();
        return;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\LiveMakeFriendSettingView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */