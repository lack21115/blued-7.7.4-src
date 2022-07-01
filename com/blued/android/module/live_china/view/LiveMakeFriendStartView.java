package com.blued.android.module.live_china.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveFriendModel;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;

public class LiveMakeFriendStartView implements View.OnClickListener {
  public View a;
  
  public View b;
  
  public View c;
  
  public Context d;
  
  public LayoutInflater e;
  
  private MyPopupWindow f;
  
  private LinearLayout g;
  
  private TextView h;
  
  private TextView i;
  
  private TextView j;
  
  private CountDownTimer k;
  
  private PlayingOnliveFragment l;
  
  public LiveMakeFriendStartView(PlayingOnliveFragment paramPlayingOnliveFragment) {
    this.d = paramPlayingOnliveFragment.getContext();
    this.l = paramPlayingOnliveFragment;
    f();
  }
  
  private void f() {
    this.e = LayoutInflater.from(this.d);
    a();
    this.b = this.a.findViewById(R.id.live_make_friend_start_layer);
    this.c = this.a.findViewById(R.id.content_layout);
    this.g = (LinearLayout)this.a.findViewById(R.id.ll_loading);
    this.h = (TextView)this.a.findViewById(R.id.live_make_friend_start_text);
    this.i = (TextView)this.a.findViewById(R.id.live_make_friend_start_cancel);
    this.j = (TextView)this.a.findViewById(R.id.live_make_friend_start_now);
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.b.setBackgroundColor(this.d.getResources().getColor(R.color.transparent));
    this.b.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {}
        });
    this.c.setVisibility(8);
    this.c.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {}
        });
    this.f = new MyPopupWindow(this.a, -1, -1);
    this.f.setBackgroundDrawable(this.d.getResources().getDrawable(17170445));
    this.f.setTouchable(true);
    this.f.setOutsideTouchable(true);
    this.f.setFocusable(true);
    this.f.update();
  }
  
  private void g() {
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
  
  private void h() {
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.5F, 0.0F);
    alphaAnimation.setDuration(300L);
    alphaAnimation.setFillAfter(true);
    this.b.startAnimation((Animation)alphaAnimation);
    this.c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_bottom_out));
  }
  
  private void i() {
    BluedUIHttpResponse bluedUIHttpResponse = new BluedUIHttpResponse(this, (IRequestHost)this.l.w_()) {
        public void onUIFinish() {
          super.onUIFinish();
          LiveMakeFriendStartView.d(this.a).setVisibility(8);
        }
        
        public void onUIStart() {
          super.onUIStart();
          LiveMakeFriendStartView.d(this.a).setVisibility(0);
        }
        
        public void onUIUpdate(BluedEntity param1BluedEntity) {
          this.a.e();
          this.a.b();
          (LiveMakeFriendStartView.e(this.a)).q.a(1);
          (LiveMakeFriendStartView.e(this.a)).bP.setState(0);
        }
      };
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.l.u);
    stringBuilder.append("");
    LiveRoomHttpUtils.k(bluedUIHttpResponse, stringBuilder.toString());
  }
  
  private void j() {
    LiveRoomInfo.a().a(new PermissionCallbacks(this) {
          public void a(String[] param1ArrayOfString) {
            LiveMsgSendManager.a().b("关闭权限");
            this.a.e();
            LiveMakeFriendStartView.g(this.a);
          }
          
          public void aa_() {
            LiveMsgSendManager.a().b("开启权限");
            this.a.b();
            BluedUIHttpResponse<BluedEntity<LiveFriendModel, LiveFriendModel>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntity<LiveFriendModel, LiveFriendModel>>(this, (IRequestHost)LiveMakeFriendStartView.e(this.a).w_()) {
                public void onFailure(Throwable param2Throwable, int param2Int, String param2String) {
                  super.onFailure(param2Throwable, param2Int, param2String);
                  AppInfo.n().post(new Runnable(this) {
                        public void run() {
                          LiveMakeFriendStartView.f(this.a.a.a).setEnabled(true);
                          (LiveMakeFriendStartView.e(this.a.a.a)).bP.setState(0);
                          (LiveMakeFriendStartView.e(this.a.a.a)).q.a(1);
                        }
                      });
                }
                
                public void onUIFinish() {
                  super.onUIFinish();
                  LiveMakeFriendStartView.d(this.a.a).setVisibility(8);
                  this.a.a.e();
                }
                
                public void onUIStart() {
                  super.onUIStart();
                  LiveMakeFriendStartView.d(this.a.a).setVisibility(0);
                }
                
                public void onUIUpdate(BluedEntity<LiveFriendModel, LiveFriendModel> param2BluedEntity) {}
              };
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((LiveMakeFriendStartView.e(this.a)).u);
            stringBuilder.append("");
            LiveRoomHttpUtils.j(bluedUIHttpResponse, stringBuilder.toString());
          }
        });
  }
  
  public void a() {
    this.a = this.e.inflate(R.layout.live_make_friend_start, null);
  }
  
  public void a(ILiveConnectionAnimListener paramILiveConnectionAnimListener) {
    AppInfo.n().postDelayed(new Runnable(this, paramILiveConnectionAnimListener) {
          public void run() {
            LiveMakeFriendStartView.c(this.b).a();
            ILiveConnectionAnimListener iLiveConnectionAnimListener = this.a;
            if (iLiveConnectionAnimListener != null)
              iLiveConnectionAnimListener.a(); 
          }
        }320L);
    h();
    this.c.setVisibility(8);
  }
  
  public void b() {
    CountDownTimer countDownTimer = this.k;
    if (countDownTimer != null)
      countDownTimer.cancel(); 
  }
  
  public void c() {
    b();
    this.k = (new CountDownTimer(this, 6000L, 500L) {
        public void onFinish() {
          LiveMakeFriendStartView.b(this.a);
        }
        
        public void onTick(long param1Long) {
          param1Long /= 1000L;
          TextView textView = LiveMakeFriendStartView.a(this.a);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(param1Long + 1L);
          stringBuilder.append("S");
          textView.setText(stringBuilder.toString());
        }
      }).start();
  }
  
  public void d() {
    c();
    this.b.clearAnimation();
    this.c.clearAnimation();
    if (this.f.isShowing())
      this.f.a(); 
    this.f.showAtLocation(this.c, 81, 0, 0);
    this.c.setVisibility(0);
    g();
  }
  
  public void e() {
    a((ILiveConnectionAnimListener)null);
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() == R.id.live_make_friend_start_cancel) {
      i();
      return;
    } 
    if (paramView.getId() == R.id.live_make_friend_start_now) {
      this.j.setEnabled(false);
      j();
    } 
  }
  
  class MyPopupWindow extends PopupWindow {
    public MyPopupWindow(View param1View, int param1Int1, int param1Int2) {
      this(param1View, param1Int1, param1Int2, false);
    }
    
    public MyPopupWindow(View param1View, int param1Int1, int param1Int2, boolean param1Boolean) {
      super(param1View, param1Int1, param1Int2, param1Boolean);
    }
    
    public void a() {
      super.dismiss();
    }
    
    public void dismiss() {
      try {
        this.a.e();
        return;
      } catch (Exception exception) {
        a();
        return;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\LiveMakeFriendStartView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */