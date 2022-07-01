package com.blued.android.module.live_china.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveHornModel;
import java.util.ArrayList;
import java.util.List;

public class HornView extends LinearLayout {
  private Context a;
  
  private LayoutInflater b;
  
  private View c;
  
  private ScrollTextView d;
  
  private View e;
  
  private ScrollTextView f;
  
  private List<LiveHornModel> g = new ArrayList<LiveHornModel>();
  
  private boolean h;
  
  public HornView(Context paramContext) {
    super(paramContext);
    this.a = paramContext;
    b();
  }
  
  public HornView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    b();
  }
  
  private void a(LiveHornModel paramLiveHornModel) {
    Animation animation = AnimationUtils.loadAnimation(AppInfo.d(), R.anim.hornview_in_from_right);
    animation.setDuration(500L);
    AlphaAnimation alphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    alphaAnimation.setDuration(500L);
    animation.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {
            AppInfo.n().postDelayed(new Runnable(this) {
                  public void run() {
                    HornView.a(this.a.a).a();
                  }
                },  4000L);
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    this.d.setOnScrollListener(new ScrollTextView.OnScrollListener(this, paramLiveHornModel, alphaAnimation) {
          public void a() {
            HornView.b(this.c).remove(this.a);
            if (HornView.b(this.c).size() > 0) {
              LiveHornModel liveHornModel = HornView.b(this.c).get(0);
              HornView.c(this.c, liveHornModel);
              if (liveHornModel.type == 1) {
                HornView.a(this.c, liveHornModel);
                return;
              } 
              if (liveHornModel.type == 2) {
                HornView.a(this.c).setVisibility(4);
                HornView.c(this.c).startAnimation((Animation)this.b);
                return;
              } 
            } else {
              HornView.a(this.c).setVisibility(4);
              HornView.c(this.c).startAnimation((Animation)this.b);
            } 
          }
        });
    alphaAnimation.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {
            HornView.c(this.a).setVisibility(4);
            HornView.a(this.a, false);
            this.a.a();
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    this.d.startAnimation(animation);
    this.d.setVisibility(0);
  }
  
  private void b() {
    this.b = LayoutInflater.from(this.a);
    View view = this.b.inflate(R.layout.live_horn_layout, (ViewGroup)this, true);
    this.c = view.findViewById(R.id.big_horn_layout);
    this.d = (ScrollTextView)view.findViewById(R.id.big_horn_text);
    this.e = view.findViewById(R.id.small_horn_layout);
    this.f = (ScrollTextView)view.findViewById(R.id.small_horn_text);
    this.c.setVisibility(4);
    this.d.setVisibility(4);
    this.e.setVisibility(4);
    this.f.setVisibility(4);
  }
  
  private void b(LiveHornModel paramLiveHornModel) {
    Animation animation = AnimationUtils.loadAnimation(AppInfo.d(), R.anim.hornview_in_from_right);
    animation.setDuration(500L);
    AlphaAnimation alphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    alphaAnimation.setDuration(500L);
    animation.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {
            AppInfo.n().postDelayed(new Runnable(this) {
                  public void run() {
                    HornView.d(this.a.a).a();
                  }
                },  4000L);
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    this.f.setOnScrollListener(new ScrollTextView.OnScrollListener(this, paramLiveHornModel, alphaAnimation) {
          public void a() {
            HornView.b(this.c).remove(this.a);
            if (HornView.b(this.c).size() > 0) {
              LiveHornModel liveHornModel = HornView.b(this.c).get(0);
              HornView.c(this.c, liveHornModel);
              if (liveHornModel.type == 1) {
                HornView.d(this.c).setVisibility(4);
                HornView.e(this.c).startAnimation((Animation)this.b);
                return;
              } 
              if (liveHornModel.type == 2) {
                HornView.b(this.c, liveHornModel);
                return;
              } 
            } else {
              HornView.d(this.c).setVisibility(4);
              HornView.e(this.c).startAnimation((Animation)this.b);
            } 
          }
        });
    alphaAnimation.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {
            HornView.e(this.a).setVisibility(4);
            HornView.a(this.a, false);
            this.a.a();
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    this.f.startAnimation(animation);
    this.f.setVisibility(0);
  }
  
  private void setScrollText(LiveHornModel paramLiveHornModel) {
    if (paramLiveHornModel.type == 1) {
      this.d.a(paramLiveHornModel);
      return;
    } 
    if (paramLiveHornModel.type == 2)
      this.f.a(paramLiveHornModel); 
  }
  
  public void a() {
    if (this.g.size() > 0 && !this.h) {
      this.h = true;
      LiveHornModel liveHornModel = this.g.get(0);
      setScrollText(liveHornModel);
      AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      alphaAnimation.setDuration(500L);
      alphaAnimation.setAnimationListener(new Animation.AnimationListener(this, liveHornModel) {
            public void onAnimationEnd(Animation param1Animation) {
              if (this.a.type == 1) {
                HornView.a(this.b, this.a);
                return;
              } 
              if (this.a.type == 2)
                HornView.b(this.b, this.a); 
            }
            
            public void onAnimationRepeat(Animation param1Animation) {}
            
            public void onAnimationStart(Animation param1Animation) {}
          });
      if (liveHornModel.type == 1) {
        this.c.setVisibility(0);
        this.c.startAnimation((Animation)alphaAnimation);
        return;
      } 
      if (liveHornModel.type == 2) {
        this.e.setVisibility(0);
        this.e.startAnimation((Animation)alphaAnimation);
      } 
    } 
  }
  
  public void a(LiveHornModel paramLiveHornModel, boolean paramBoolean) {
    if (paramBoolean) {
      this.g.add(0, paramLiveHornModel);
    } else {
      this.g.add(paramLiveHornModel);
    } 
    a();
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\HornView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */