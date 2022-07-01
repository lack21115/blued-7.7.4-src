package com.blued.android.module.live_china.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;

public class PopPlayExitView {
  public View a;
  
  public View b;
  
  public View c;
  
  public Context d;
  
  public LayoutInflater e;
  
  private MyPopupWindow f;
  
  private PlayingOnliveFragment g;
  
  private TextView h;
  
  private TextView i;
  
  private ImageView j;
  
  public PopPlayExitView(PlayingOnliveFragment paramPlayingOnliveFragment) {
    this.g = paramPlayingOnliveFragment;
    this.d = paramPlayingOnliveFragment.getContext();
    d();
  }
  
  private void d() {
    this.e = LayoutInflater.from(this.d);
    a();
    this.b = this.a.findViewById(R.id.tv_bg);
    this.h = (TextView)this.a.findViewById(R.id.live_play_exit_follow_btn);
    this.i = (TextView)this.a.findViewById(R.id.live_play_exit_leave_btn);
    this.j = (ImageView)this.a.findViewById(R.id.live_play_exit_header);
    this.b.setBackgroundColor(this.d.getResources().getColor(R.color.transparent));
    this.b.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.c();
          }
        });
    this.c = this.a.findViewById(R.id.ll_content);
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
    if (!LiveRoomManager.a().l())
      ImageLoader.a(null, (LiveRoomManager.a().h()).profile.avatar).a(R.drawable.user_bg_round).c().a(this.j); 
    this.h.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.c();
            LiveSetDataObserver.a().k();
            LiveRefreshUIObserver.a().p();
            EventTrackLive.a(LiveProtos.Event.LIVE_EXIT_GUIDE_FOLLOWED_EXIT_BTN_CLICK);
          }
        });
    this.i.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.c();
            LiveRefreshUIObserver.a().p();
            EventTrackLive.a(LiveProtos.Event.LIVE_EXIT_GUIDE_EXIT_BTN_CLICK);
          }
        });
  }
  
  private void e() {
    this.c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_center_in));
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
  
  private void f() {
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.5F, 0.0F);
    alphaAnimation.setDuration(300L);
    alphaAnimation.setFillAfter(true);
    this.b.startAnimation((Animation)alphaAnimation);
    this.c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_center_out));
  }
  
  public void a() {
    this.a = this.e.inflate(R.layout.live_play_exit_tip, null);
  }
  
  public void b() {
    EventTrackLive.a(LiveProtos.Event.LIVE_EXIT_GUIDE_FOLLOWED_LAYER_SHOW);
    this.b.clearAnimation();
    this.c.clearAnimation();
    if (this.f.isShowing())
      this.f.a(); 
    this.f.showAtLocation(this.c, 81, 0, 0);
    this.c.setVisibility(0);
    e();
  }
  
  public void c() {
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            PopPlayExitView.a(this.a).a();
          }
        },  320L);
    f();
    this.c.setVisibility(8);
  }
  
  class MyPopupWindow extends PopupWindow {
    public MyPopupWindow(PopPlayExitView this$0, View param1View, int param1Int1, int param1Int2, boolean param1Boolean) {
      super(param1View, param1Int1, param1Int2, param1Boolean);
    }
    
    public void a() {
      super.dismiss();
    }
    
    public void dismiss() {
      try {
        this.a.c();
        return;
      } catch (Exception exception) {
        a();
        return;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\PopPlayExitView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */