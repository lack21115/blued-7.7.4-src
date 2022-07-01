package com.blued.android.module.live_china.view;

import android.content.Context;
import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveFriendModel;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;

public class LivePKInviteView extends FrameLayout implements View.OnClickListener {
  public int a;
  
  private Context b;
  
  private LayoutInflater c;
  
  private View d;
  
  private View e;
  
  private LinearLayout f;
  
  private ImageView g;
  
  private LiveConnectionView h;
  
  private ILiveConnectionStateListener i;
  
  private ImageView j;
  
  private TextView k;
  
  private LinearLayout l;
  
  private LiveFriendModel m;
  
  private CountDownTimer n;
  
  public LivePKInviteView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public LivePKInviteView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LivePKInviteView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.b = paramContext;
    h();
  }
  
  private void b(ILiveConnectionAnimListener paramILiveConnectionAnimListener) {
    if (this.d.getVisibility() == 8)
      return; 
    this.d.setVisibility(8);
    Animation animation = AnimationUtils.loadAnimation(this.b, R.anim.push_bottom_out);
    this.d.startAnimation(animation);
    animation.setAnimationListener(new Animation.AnimationListener(this, paramILiveConnectionAnimListener) {
          public void onAnimationEnd(Animation param1Animation) {
            ILiveConnectionAnimListener iLiveConnectionAnimListener = this.a;
            if (iLiveConnectionAnimListener != null)
              iLiveConnectionAnimListener.a(); 
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    ILiveConnectionStateListener iLiveConnectionStateListener = this.i;
    if (iLiveConnectionStateListener != null)
      iLiveConnectionStateListener.b(); 
  }
  
  private void c(ILiveConnectionAnimListener paramILiveConnectionAnimListener) {
    if (this.f.getVisibility() == 8)
      return; 
    this.f.setVisibility(8);
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.5F, 0.0F);
    alphaAnimation.setDuration(300L);
    alphaAnimation.setFillAfter(true);
    Animation animation = AnimationUtils.loadAnimation(this.b, R.anim.push_center_out);
    this.f.startAnimation(animation);
    animation.setAnimationListener(new Animation.AnimationListener(this, paramILiveConnectionAnimListener) {
          public void onAnimationEnd(Animation param1Animation) {
            ILiveConnectionAnimListener iLiveConnectionAnimListener = this.a;
            if (iLiveConnectionAnimListener != null)
              iLiveConnectionAnimListener.a(); 
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
  }
  
  private void h() {
    this.c = LayoutInflater.from(this.b);
    View view = this.c.inflate(R.layout.live_pk_invite_loading, (ViewGroup)this);
    this.d = view.findViewById(R.id.content_layout);
    this.e = view.findViewById(R.id.live_pk_invite_layer);
    this.j = (ImageView)view.findViewById(R.id.live_pk_invite_header);
    this.k = (TextView)view.findViewById(R.id.live_pk_invite_name);
    this.g = (ImageView)view.findViewById(R.id.live_pk_invite_cancel);
    this.l = (LinearLayout)findViewById(R.id.ll_loading);
    this.f = (LinearLayout)view.findViewById(R.id.live_pk_simple_loading_layout);
    this.e.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.f.setOnClickListener(this);
  }
  
  private void i() {
    this.f.clearAnimation();
    this.f.setVisibility(0);
    this.f.startAnimation(AnimationUtils.loadAnimation(this.b, R.anim.push_center_in));
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 0.5F);
    alphaAnimation.setDuration(300L);
    alphaAnimation.setFillAfter(true);
    ILiveConnectionStateListener iLiveConnectionStateListener = this.i;
    if (iLiveConnectionStateListener != null)
      iLiveConnectionStateListener.b(); 
  }
  
  private void j() {
    CountDownTimer countDownTimer = this.n;
    if (countDownTimer != null)
      countDownTimer.cancel(); 
  }
  
  private void setInviteUserData(LiveFriendModel paramLiveFriendModel) {
    if (paramLiveFriendModel != null) {
      if (!TextUtils.isEmpty(paramLiveFriendModel.name)) {
        this.k.setText(paramLiveFriendModel.name);
      } else {
        this.k.setText("");
      } 
      ImageLoader.a(null, paramLiveFriendModel.avatar).a(R.drawable.user_bg_round).c().a(this.j);
    } 
  }
  
  public void a() {
    d();
  }
  
  public void a(LiveFriendModel paramLiveFriendModel, boolean paramBoolean, int paramInt) {
    this.a = paramInt;
    this.m = paramLiveFriendModel;
    setVisibility(0);
    this.d.setVisibility(0);
    this.d.clearAnimation();
    Animation animation = AnimationUtils.loadAnimation(this.b, R.anim.push_bottom_in);
    this.d.startAnimation(animation);
    animation.setAnimationListener(new Animation.AnimationListener(this, paramBoolean) {
          public void onAnimationEnd(Animation param1Animation) {
            if (this.a)
              this.b.f(); 
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    ILiveConnectionStateListener iLiveConnectionStateListener = this.i;
    if (iLiveConnectionStateListener != null)
      iLiveConnectionStateListener.a(); 
    setInviteUserData(paramLiveFriendModel);
    this.e.setVisibility(0);
  }
  
  public void a(ILiveConnectionAnimListener paramILiveConnectionAnimListener) {
    if (this.d.getVisibility() == 8)
      return; 
    this.d.setVisibility(8);
    Animation animation = AnimationUtils.loadAnimation(this.b, R.anim.push_bottom_out);
    this.d.startAnimation(animation);
    animation.setAnimationListener(new Animation.AnimationListener(this, paramILiveConnectionAnimListener) {
          public void onAnimationEnd(Animation param1Animation) {
            this.b.setVisibility(8);
            ILiveConnectionAnimListener iLiveConnectionAnimListener = this.a;
            if (iLiveConnectionAnimListener != null)
              iLiveConnectionAnimListener.a(); 
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    ILiveConnectionStateListener iLiveConnectionStateListener = this.i;
    if (iLiveConnectionStateListener != null)
      iLiveConnectionStateListener.b(); 
  }
  
  public void a(LiveConnectionView paramLiveConnectionView) {
    this.h = paramLiveConnectionView;
    this.i = paramLiveConnectionView;
  }
  
  public void a(boolean paramBoolean) {
    LiveRoomHttpUtils.c(new BluedUIHttpResponse(this, (IRequestHost)this.h.a.w_(), paramBoolean) {
          public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
            super.onFailure(param1Throwable, param1Int, param1String);
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            LivePKInviteView.d(this.b).setVisibility(8);
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            this.b.a(new ILiveConnectionAnimListener(this) {
                  public void a() {
                    if (this.a.a)
                      LivePKInviteView.e(this.a.b).a(false, this.a.b.a); 
                  }
                });
          }
        });
  }
  
  public void b(boolean paramBoolean) {
    LiveRoomHttpUtils.l(new BluedUIHttpResponse(this, (IRequestHost)this.h.a.w_(), paramBoolean) {
          public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
            super.onFailure(param1Throwable, param1Int, param1String);
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            LivePKInviteView.d(this.b).setVisibility(8);
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            this.b.a(new ILiveConnectionAnimListener(this) {
                  public void a() {
                    if (this.a.a)
                      LivePKInviteView.e(this.a.b).a(false, this.a.b.a); 
                  }
                });
          }
        });
  }
  
  public boolean b() {
    return (this.f.getVisibility() == 0 || this.d.getVisibility() == 0);
  }
  
  public void c() {
    if (b()) {
      if (this.f.getVisibility() == 0)
        c(new ILiveConnectionAnimListener(this) {
              public void a() {
                this.a.setVisibility(8);
              }
            }); 
      if (this.d.getVisibility() == 0)
        b(new ILiveConnectionAnimListener(this) {
              public void a() {
                this.a.setVisibility(8);
              }
            }); 
      j();
    } 
  }
  
  public void d() {
    if (this.f.getVisibility() == 8) {
      b(new ILiveConnectionAnimListener(this) {
            public void a() {
              LivePKInviteView.a(this.a).setVisibility(4);
              LivePKInviteView.b(this.a);
            }
          });
      return;
    } 
    c(new ILiveConnectionAnimListener(this) {
          public void a() {
            LivePKInviteView.a(this.a).setVisibility(0);
            LivePKInviteView livePKInviteView = this.a;
            livePKInviteView.a(LivePKInviteView.c(livePKInviteView), false, this.a.a);
          }
        });
  }
  
  public void e() {
    if (this.a == 0) {
      a(false);
      return;
    } 
    b(false);
  }
  
  public void f() {
    j();
    this.n = (new CountDownTimer(this, 20000L, 1000L) {
        public void onFinish() {
          if (LivePKInviteView.f(this.a).getVisibility() == 0) {
            LivePKInviteView.a(this.a, new ILiveConnectionAnimListener(this) {
                  public void a() {
                    if (this.a.a.a == 0) {
                      this.a.a.a(false);
                      return;
                    } 
                    this.a.a.b(false);
                  }
                });
          } else if (this.a.a == 0) {
            this.a.a(true);
          } else {
            this.a.b(true);
          } 
          AppMethods.d(R.string.live_pk_invite_him_next_time);
        }
        
        public void onTick(long param1Long) {}
      }).start();
  }
  
  public void g() {
    j();
  }
  
  public void onClick(View paramView) {
    String str;
    if (paramView.getId() == R.id.live_pk_invite_layer) {
      d();
      return;
    } 
    if (paramView.getId() == R.id.live_pk_invite_cancel) {
      if (this.a == 0) {
        str = this.b.getString(R.string.live_pk_cancel_this_invitation);
      } else {
        str = this.b.getString(R.string.live_connection_cancel_this_invitation);
      } 
      Context context = this.b;
      CommonAlertDialog.a(context, "", str, context.getString(R.string.biao_v4_ok), new DialogInterface.OnClickListener(this) {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
              LivePKInviteView.d(this.a).setVisibility(0);
              if (this.a.a == 0) {
                this.a.a(true);
                return;
              } 
              this.a.b(true);
            }
          },  this.b.getString(R.string.live_window_permisson_cancel), null, null);
      return;
    } 
    if (str.getId() == R.id.live_pk_simple_loading_layout)
      d(); 
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\LivePKInviteView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */