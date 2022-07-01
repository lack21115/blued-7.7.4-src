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
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.model.LiveFriendModel;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;

public class LiveMakeFriendCardView implements View.OnClickListener {
  public View a;
  
  public View b;
  
  public View c;
  
  public Context d;
  
  public LayoutInflater e;
  
  private MyPopupWindow f;
  
  private BaseFragment g;
  
  private RecordingOnliveFragment h;
  
  private PlayingOnliveFragment i;
  
  private LinearLayout j;
  
  private ImageView k;
  
  private TextView l;
  
  private TextView m;
  
  private TextView n;
  
  private ImageView o;
  
  private TextView p;
  
  private LiveFriendModel q;
  
  private int r;
  
  public LiveMakeFriendCardView(BaseFragment paramBaseFragment) {
    this.g = paramBaseFragment;
    if (paramBaseFragment instanceof RecordingOnliveFragment) {
      this.h = (RecordingOnliveFragment)paramBaseFragment;
    } else if (paramBaseFragment instanceof PlayingOnliveFragment) {
      this.i = (PlayingOnliveFragment)paramBaseFragment;
    } 
    this.d = paramBaseFragment.getContext();
    c();
  }
  
  private void a(LiveFriendModel paramLiveFriendModel) {
    LiveRoomHttpUtils.b(new BluedUIHttpResponse(this, (IRequestHost)this.g.w_()) {
          public void onUIFinish() {
            super.onUIFinish();
            LiveMakeFriendCardView.c(this.a).setVisibility(8);
          }
          
          public void onUIStart() {
            super.onUIStart();
            LiveMakeFriendCardView.c(this.a).setVisibility(0);
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            this.a.b();
          }
        }"", paramLiveFriendModel.uid);
  }
  
  private void b(LiveFriendModel paramLiveFriendModel, int paramInt) {
    ImageLoader.a(null, paramLiveFriendModel.avatar).a(R.drawable.user_bg_round).c().a(this.k);
    this.l.setText(paramLiveFriendModel.name);
    if (paramLiveFriendModel.voice == 1) {
      this.m.setText(R.string.live_make_friend_close_mic);
    } else {
      this.m.setText(R.string.live_make_friend_open_mic);
    } 
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt != 2)
          return; 
        this.o.setImageResource(R.drawable.live_make_friend_no3);
        return;
      } 
      this.o.setImageResource(R.drawable.live_make_friend_no2);
      return;
    } 
    this.o.setImageResource(R.drawable.live_make_friend_no1);
  }
  
  private void c() {
    this.e = LayoutInflater.from(this.d);
    a();
    this.b = this.a.findViewById(R.id.live_make_friend_card_layer);
    this.c = this.a.findViewById(R.id.content_layout);
    this.k = (ImageView)this.a.findViewById(R.id.live_make_friend_card_header);
    this.l = (TextView)this.a.findViewById(R.id.live_make_friend_card_name);
    this.m = (TextView)this.a.findViewById(R.id.live_make_friend_card_mic);
    this.n = (TextView)this.a.findViewById(R.id.live_make_friend_card_out);
    this.o = (ImageView)this.a.findViewById(R.id.live_make_friend_card_num);
    this.p = (TextView)this.a.findViewById(R.id.live_make_friend_card_btn);
    this.j = (LinearLayout)this.a.findViewById(R.id.ll_loading);
    this.m.setOnClickListener(this);
    this.n.setOnClickListener(this);
    this.p.setOnClickListener(this);
    this.b.setBackgroundColor(this.d.getResources().getColor(R.color.transparent));
    this.b.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.b();
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
  
  private void c(LiveFriendModel paramLiveFriendModel, int paramInt) {
    LiveRoomHttpUtils.b(new BluedUIHttpResponse(this, (IRequestHost)this.g.w_(), paramInt, paramLiveFriendModel) {
          public void onUIFinish() {
            super.onUIFinish();
            LiveMakeFriendCardView.c(this.c).setVisibility(8);
          }
          
          public void onUIStart() {
            super.onUIStart();
            LiveMakeFriendCardView.c(this.c).setVisibility(0);
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            int i = this.a;
            if (i == 0) {
              LiveMakeFriendCardView.d(this.c).setText(R.string.live_make_friend_open_mic);
            } else if (i == 1) {
              LiveMakeFriendCardView.d(this.c).setText(R.string.live_make_friend_close_mic);
            } 
            this.b.voice = this.a;
          }
        }paramLiveFriendModel.uid, paramInt);
  }
  
  private void d() {
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
  
  private void e() {
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.5F, 0.0F);
    alphaAnimation.setDuration(300L);
    alphaAnimation.setFillAfter(true);
    this.b.startAnimation((Animation)alphaAnimation);
    this.c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_bottom_out));
  }
  
  public void a() {
    this.a = this.e.inflate(R.layout.live_make_friend_card, null);
  }
  
  public void a(LiveFriendModel paramLiveFriendModel, int paramInt) {
    this.q = paramLiveFriendModel;
    this.r = paramInt;
    b(paramLiveFriendModel, paramInt);
    BaseFragment baseFragment = this.g;
    if (baseFragment instanceof RecordingOnliveFragment) {
      this.h.Q();
    } else if (baseFragment instanceof PlayingOnliveFragment) {
      this.i.d(4);
      LiveSetDataObserver.a().e(4);
    } 
    this.b.clearAnimation();
    this.c.clearAnimation();
    if (this.f.isShowing())
      this.f.a(); 
    this.f.showAtLocation(this.c, 81, 0, 0);
    this.c.setVisibility(0);
    d();
  }
  
  public void a(ILiveConnectionAnimListener paramILiveConnectionAnimListener) {
    BaseFragment baseFragment = this.g;
    if (baseFragment instanceof RecordingOnliveFragment) {
      this.h.R();
    } else if (baseFragment instanceof PlayingOnliveFragment) {
      this.i.d(0);
      LiveSetDataObserver.a().e(0);
    } 
    AppInfo.n().postDelayed(new Runnable(this, paramILiveConnectionAnimListener) {
          public void run() {
            LiveMakeFriendCardView.a(this.b).a();
            ILiveConnectionAnimListener iLiveConnectionAnimListener = this.a;
            if (iLiveConnectionAnimListener != null)
              iLiveConnectionAnimListener.a(); 
          }
        }320L);
    e();
    this.c.setVisibility(8);
  }
  
  public void b() {
    a((ILiveConnectionAnimListener)null);
  }
  
  public void onClick(View paramView) {
    Context context;
    if (paramView.getId() == R.id.live_make_friend_card_mic) {
      if (this.q.voice == 1) {
        c(this.q, 0);
        return;
      } 
      c(this.q, 1);
      return;
    } 
    if (paramView.getId() == R.id.live_make_friend_card_out) {
      context = this.d;
      CommonAlertDialog.a(context, null, "", context.getString(R.string.live_make_friend_offline_audience), null, null, new DialogInterface.OnClickListener(this) {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
              LiveMakeFriendCardView liveMakeFriendCardView = this.a;
              LiveMakeFriendCardView.a(liveMakeFriendCardView, LiveMakeFriendCardView.b(liveMakeFriendCardView));
            }
          }null, null, false, false);
      return;
    } 
    if (context.getId() == R.id.live_make_friend_card_btn) {
      b();
      if (this.g instanceof RecordingOnliveFragment)
        this.h.cG.a(this.q.uid); 
    } 
  }
  
  class MyPopupWindow extends PopupWindow {
    public MyPopupWindow(LiveMakeFriendCardView this$0, View param1View, int param1Int1, int param1Int2, boolean param1Boolean) {
      super(param1View, param1Int1, param1Int2, param1Boolean);
    }
    
    public void a() {
      super.dismiss();
    }
    
    public void dismiss() {
      try {
        this.a.b();
        return;
      } catch (Exception exception) {
        a();
        return;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\LiveMakeFriendCardView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */