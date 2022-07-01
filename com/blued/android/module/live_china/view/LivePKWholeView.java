package com.blued.android.module.live_china.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.GrabBoxDetailModel;
import com.blued.android.module.live_china.model.LiveFriendModel;
import com.blued.android.module.live_china.model.LiveInteractionModel;
import com.blued.android.module.live_china.same.loadingIndicator.AVLoadingIndicatorView;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.InstantLog;

public class LivePKWholeView extends FrameLayout implements View.OnClickListener {
  public int a;
  
  private Context b;
  
  private LayoutInflater c;
  
  private View d;
  
  private LiveConnectionView e;
  
  private ILiveConnectionStateListener f;
  
  private View g;
  
  private TextView h;
  
  private LinearLayout i;
  
  private TextView j;
  
  private TextView k;
  
  private LinearLayout l;
  
  private ImageView m;
  
  private AVLoadingIndicatorView n;
  
  private ImageView o;
  
  private LinearLayout p;
  
  private TextView q;
  
  private TextView r;
  
  private TextView s;
  
  private TextView t;
  
  private WholeCountDownTimer u = new WholeCountDownTimer(this);
  
  private InviteCountDownTimer v = new InviteCountDownTimer(this);
  
  private CountDownTimer w;
  
  private LiveInteractionModel x;
  
  public LivePKWholeView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public LivePKWholeView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LivePKWholeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.b = paramContext;
    k();
  }
  
  private void k() {
    this.c = LayoutInflater.from(this.b);
    this.d = this.c.inflate(R.layout.live_pk_whole_loading, (ViewGroup)this).findViewById(R.id.content_layout);
    this.g = findViewById(R.id.live_pk_whole_layer);
    this.h = (TextView)findViewById(R.id.live_pk_whole_title);
    this.i = (LinearLayout)findViewById(R.id.live_pk_whole_text_layout);
    this.j = (TextView)findViewById(R.id.live_pk_whole_text_top);
    this.k = (TextView)findViewById(R.id.live_pk_whole_text_bottom);
    this.l = (LinearLayout)findViewById(R.id.live_pk_whole_header_layout);
    this.m = (ImageView)findViewById(R.id.live_pk_whole_my_header);
    this.n = (AVLoadingIndicatorView)findViewById(R.id.remote_loading_view);
    this.o = (ImageView)findViewById(R.id.live_pk_whole_your_header);
    this.p = (LinearLayout)findViewById(R.id.live_pk_whole_bottom_double_btn_layout);
    this.q = (TextView)findViewById(R.id.live_pk_whole_bottom_double_cancel_btn);
    this.r = (TextView)findViewById(R.id.live_pk_whole_bottom_double_again_btn);
    this.s = (TextView)findViewById(R.id.live_pk_whole_bottom_single_cancel_btn);
    this.t = (TextView)findViewById(R.id.live_pk_whole_bottom_count_down);
    this.d.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.o.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.q.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.r.setOnClickListener(this);
  }
  
  private void l() {
    LiveRoomHttpUtils.j(new BluedUIHttpResponse<BluedEntity<GrabBoxDetailModel, LiveInteractionModel>>(this, (IRequestHost)this.e.a.w_()) {
          public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
            super.onFailure(param1Throwable, param1Int, param1String);
            AppInfo.n().post(new Runnable(this) {
                  public void run() {
                    this.a.a.a(new ILiveConnectionAnimListener(this) {
                          public void a() {
                            LivePKWholeView.b(this.a.a.a).a(true);
                          }
                        });
                  }
                });
          }
          
          public void onUIFinish() {}
          
          public void onUIStart() {
            super.onUIStart();
          }
          
          public void onUIUpdate(BluedEntity<GrabBoxDetailModel, LiveInteractionModel> param1BluedEntity) {
            if (param1BluedEntity != null && param1BluedEntity.extra != null)
              LivePKWholeView.a(this.a, (LiveInteractionModel)param1BluedEntity.extra); 
            this.a.i();
            AppInfo.n().postDelayed(LivePKWholeView.a(this.a), 30000L);
          }
        });
  }
  
  private void m() {
    if (getVisibility() == 0)
      return; 
    setVisibility(0);
    this.d.setVisibility(0);
    this.d.clearAnimation();
    Animation animation = AnimationUtils.loadAnimation(this.b, R.anim.push_bottom_in);
    this.d.startAnimation(animation);
    animation.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {}
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    ILiveConnectionStateListener iLiveConnectionStateListener = this.f;
    if (iLiveConnectionStateListener != null)
      iLiveConnectionStateListener.a(); 
  }
  
  public void a() {
    this.h.setText(this.b.getString(R.string.live_pk_whole_matching));
    this.l.setVisibility(0);
    this.i.setVisibility(8);
    this.n.setVisibility(0);
    this.p.setVisibility(8);
    this.s.setVisibility(0);
    this.t.setVisibility(8);
    ImageLoader.a(null, LiveRoomInfo.a().d()).a(R.drawable.user_bg_round).c().a(this.m);
    this.o.setImageResource(R.drawable.user_bg_round);
    m();
    this.g.setVisibility(4);
    l();
    setCurrentModel(1);
  }
  
  public void a(LiveFriendModel paramLiveFriendModel) {
    this.h.setText(this.b.getString(R.string.live_pk_whole_start));
    this.l.setVisibility(0);
    this.i.setVisibility(8);
    this.n.setVisibility(0);
    this.p.setVisibility(8);
    this.s.setVisibility(8);
    this.t.setVisibility(0);
    ImageLoader.a(null, LiveRoomInfo.a().d()).a(R.drawable.user_bg_round).c().a(this.m);
    ImageLoader.a(null, paramLiveFriendModel.avatar).a(R.drawable.user_bg_round).c().a(this.o);
    h();
    this.w = (new CountDownTimer(this, paramLiveFriendModel.delay * 1000L, 500L, paramLiveFriendModel) {
        public void onFinish() {
          this.b.a(new ILiveConnectionAnimListener(this) {
                public void a() {
                  (LivePKWholeView.b(this.a.b)).a.b(this.a.a);
                }
              });
        }
        
        public void onTick(long param1Long) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(param1Long / 1000L + 1L);
          stringBuilder.append("");
          String str = stringBuilder.toString();
          LivePKWholeView.c(this.b).setText(str);
        }
      }).start();
    m();
    this.g.setVisibility(0);
    setCurrentModel(4);
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
    setCurrentModel(0);
    ILiveConnectionStateListener iLiveConnectionStateListener = this.f;
    if (iLiveConnectionStateListener != null)
      iLiveConnectionStateListener.b(); 
  }
  
  public void a(LiveConnectionView paramLiveConnectionView) {
    this.e = paramLiveConnectionView;
    this.f = paramLiveConnectionView;
  }
  
  public void b() {
    Log.v("pk", "取消全民pk接口");
    LiveRoomHttpUtils.k(new BluedUIHttpResponse(this) {
          public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
            super.onFailure(param1Throwable, param1Int, param1String);
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {}
        });
  }
  
  public void c() {
    this.h.setText(this.b.getString(R.string.live_pk_whole));
    this.l.setVisibility(8);
    this.i.setVisibility(0);
    this.n.setVisibility(8);
    this.p.setVisibility(0);
    this.s.setVisibility(8);
    m();
    this.g.setVisibility(4);
    setCurrentModel(3);
  }
  
  public void d() {
    h();
    int i = this.a;
    if (i == 4 || i == 1)
      g(); 
  }
  
  public void e() {
    if (this.p.getVisibility() == 0 || this.s.getVisibility() == 0)
      this.s.performClick(); 
  }
  
  public boolean f() {
    return (getVisibility() == 0);
  }
  
  public void g() {
    setCurrentModel(0);
    a((ILiveConnectionAnimListener)null);
  }
  
  public void h() {
    CountDownTimer countDownTimer = this.w;
    if (countDownTimer != null)
      countDownTimer.cancel(); 
  }
  
  public void i() {
    AppInfo.n().removeCallbacks(this.u);
  }
  
  public void j() {
    AppInfo.n().removeCallbacks(this.v);
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() == R.id.live_pk_whole_bottom_single_cancel_btn || paramView.getId() == R.id.live_pk_whole_bottom_double_cancel_btn) {
      a(new ILiveConnectionAnimListener(this) {
            public void a() {
              this.a.b();
              LivePKWholeView.b(this.a).a(false);
            }
          });
      i();
      return;
    } 
    if (paramView.getId() == R.id.live_pk_whole_bottom_double_again_btn) {
      a();
      return;
    } 
  }
  
  public void setCurrentModel(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setCurrentModel:");
    stringBuilder.append(paramInt);
    Log.v("pk", stringBuilder.toString());
    this.a = paramInt;
  }
  
  public class InviteCountDownTimer implements Runnable {
    public InviteCountDownTimer(LivePKWholeView this$0) {}
    
    public void run() {
      this.a.g();
    }
  }
  
  public class WholeCountDownTimer implements Runnable {
    public WholeCountDownTimer(LivePKWholeView this$0) {}
    
    public void run() {
      InstantLog.a("live_pk_match_overtime");
      this.a.c();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\LivePKWholeView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */