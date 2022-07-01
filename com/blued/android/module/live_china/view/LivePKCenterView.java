package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.GrabBoxDetailModel;
import com.blued.android.module.live_china.model.LiveFriendExtraModel;
import com.blued.android.module.live_china.model.LiveInteractionModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.utils.log.InstantLog;

public class LivePKCenterView extends FrameLayout implements View.OnClickListener {
  private Context a;
  
  private LayoutInflater b;
  
  private View c;
  
  private View d;
  
  private LiveConnectionView e;
  
  private ILiveConnectionStateListener f;
  
  private ImageView g;
  
  private LinearLayout h;
  
  private ImageView i;
  
  private ImageView j;
  
  private ImageView k;
  
  private ImageView l;
  
  private LinearLayout m;
  
  private LiveInteractionModel n;
  
  private ImageView o;
  
  private ImageView p;
  
  public LivePKCenterView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public LivePKCenterView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LivePKCenterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    e();
  }
  
  private void e() {
    this.b = LayoutInflater.from(this.a);
    View view = this.b.inflate(R.layout.live_pk_center, (ViewGroup)this);
    this.c = view.findViewById(R.id.content_layout);
    this.d = view.findViewById(R.id.live_pk_center_layer);
    this.g = (ImageView)view.findViewById(R.id.live_pk_center_help);
    this.h = (LinearLayout)findViewById(R.id.live_pk_center_btn_layout);
    this.i = (ImageView)findViewById(R.id.live_pk_whole_btn);
    this.j = (ImageView)findViewById(R.id.live_pk_friend_btn);
    this.l = (ImageView)findViewById(R.id.live_make_friend_btn);
    this.k = (ImageView)findViewById(R.id.live_rtc_friend_btn);
    this.g = (ImageView)findViewById(R.id.live_pk_center_help);
    this.o = (ImageView)findViewById(R.id.live_pk_center_new);
    this.p = (ImageView)findViewById(R.id.live_pk_center_make_friend_new);
    this.m = (LinearLayout)findViewById(R.id.ll_loading);
    this.d.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.l.setOnClickListener(this);
  }
  
  private void f() {
    LiveRoomPreferences.h(1);
    this.o.setVisibility(8);
  }
  
  private void g() {
    LiveRoomPreferences.i(1);
    this.p.setVisibility(8);
  }
  
  private void h() {
    LiveInteractionModel liveInteractionModel = this.n;
    if (liveInteractionModel != null) {
      if (liveInteractionModel.whole_pk != null)
        ImageLoader.a(null, this.n.whole_pk.pic).a(this.i); 
      if (this.n.friend_pk != null)
        ImageLoader.a(null, this.n.friend_pk.pic).a(this.j); 
      if (this.n.friend_ligature != null)
        ImageLoader.a(null, this.n.friend_ligature.pic).a(this.k); 
      if (this.n.multi_ligature != null)
        ImageLoader.a(null, this.n.multi_ligature.pic).a(this.l); 
    } 
  }
  
  public void a(ILiveConnectionAnimListener paramILiveConnectionAnimListener) {
    if (this.c.getVisibility() == 8)
      return; 
    this.c.setVisibility(8);
    Animation animation = AnimationUtils.loadAnimation(this.a, R.anim.push_bottom_out);
    this.c.startAnimation(animation);
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
    ILiveConnectionStateListener iLiveConnectionStateListener = this.f;
    if (iLiveConnectionStateListener != null)
      iLiveConnectionStateListener.b(); 
  }
  
  public void a(LiveConnectionView paramLiveConnectionView) {
    this.e = paramLiveConnectionView;
    this.f = paramLiveConnectionView;
  }
  
  public void a(boolean paramBoolean) {
    setVisibility(0);
    this.c.setVisibility(0);
    this.c.clearAnimation();
    Animation animation = AnimationUtils.loadAnimation(this.a, R.anim.push_bottom_in);
    this.c.startAnimation(animation);
    animation.setAnimationListener(new Animation.AnimationListener(this, paramBoolean) {
          public void onAnimationEnd(Animation param1Animation) {
            if (this.a)
              this.b.getInteraction(); 
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    ILiveConnectionStateListener iLiveConnectionStateListener = this.f;
    if (iLiveConnectionStateListener != null)
      iLiveConnectionStateListener.a(); 
    InstantLog.a("live_group_chat_btn_show");
  }
  
  public boolean a() {
    return (getVisibility() == 0);
  }
  
  public void b() {
    c();
  }
  
  public void c() {
    a((ILiveConnectionAnimListener)null);
  }
  
  public void d() {
    LiveRoomHttpUtils.f(new BluedUIHttpResponse<BluedEntity<LiveFriendExtraModel, LiveFriendExtraModel>>(this, (IRequestHost)this.e.a.w_()) {
          public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
            super.onFailure(param1Throwable, param1Int, param1String);
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            LivePKCenterView.b(this.a).setVisibility(8);
          }
          
          public void onUIStart() {
            super.onUIStart();
            LivePKCenterView.b(this.a).setVisibility(0);
          }
          
          public void onUIUpdate(BluedEntity<LiveFriendExtraModel, LiveFriendExtraModel> param1BluedEntity) {
            LivePKCenterView.c(this.a);
            this.a.a(new ILiveConnectionAnimListener(this, param1BluedEntity) {
                  public void a() {
                    if (this.a.extra != null) {
                      RecordingOnliveFragment recordingOnliveFragment = (LivePKCenterView.a(this.b.a)).a;
                      int i = ((LiveFriendExtraModel)this.a.extra).is_access_control;
                      boolean bool = true;
                      if (i != 1)
                        bool = false; 
                      recordingOnliveFragment.i(bool);
                    } 
                  }
                });
          }
        });
  }
  
  public void getInteraction() {
    LiveRoomHttpUtils.b(new BluedUIHttpResponse<BluedEntity<LiveInteractionModel, GrabBoxDetailModel>>(this, (IRequestHost)this.e.a.w_()) {
          public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
            super.onFailure(param1Throwable, param1Int, param1String);
          }
          
          public void onUIFinish() {
            LivePKCenterView.b(this.a).setVisibility(8);
          }
          
          public void onUIStart() {
            super.onUIStart();
            LivePKCenterView.b(this.a).setVisibility(0);
          }
          
          public void onUIUpdate(BluedEntity<LiveInteractionModel, GrabBoxDetailModel> param1BluedEntity) {
            if (param1BluedEntity != null && param1BluedEntity.hasData()) {
              LivePKCenterView.a(this.a, param1BluedEntity.data.get(0));
              LivePKCenterView.d(this.a);
            } 
          }
        });
  }
  
  public void onClick(View paramView) {
    LiveInteractionModel liveInteractionModel;
    if (paramView.getId() == R.id.live_pk_center_layer) {
      c();
      return;
    } 
    if (paramView.getId() == R.id.live_pk_whole_btn) {
      liveInteractionModel = this.n;
      if (liveInteractionModel != null && liveInteractionModel.whole_pk != null) {
        if (this.n.whole_pk.enable == 1) {
          this.e.setPKCurrentModel(1);
          a(new ILiveConnectionAnimListener(this) {
                public void a() {
                  LivePKCenterView.a(this.a).c();
                }
              });
          return;
        } 
        AppMethods.a(this.n.whole_pk.alert_message);
        return;
      } 
    } else if (liveInteractionModel.getId() == R.id.live_pk_friend_btn) {
      liveInteractionModel = this.n;
      if (liveInteractionModel != null && liveInteractionModel.friend_pk != null) {
        if (this.n.friend_pk.enable == 1) {
          a(new ILiveConnectionAnimListener(this) {
                public void a() {
                  LivePKCenterView.a(this.a).a(true, 0);
                }
              });
          return;
        } 
        AppMethods.a(this.n.friend_pk.alert_message);
        return;
      } 
    } else if (liveInteractionModel.getId() == R.id.live_rtc_friend_btn) {
      liveInteractionModel = this.n;
      if (liveInteractionModel != null && liveInteractionModel.friend_ligature != null) {
        if (this.n.friend_ligature.enable == 1) {
          f();
          a(new ILiveConnectionAnimListener(this) {
                public void a() {
                  LivePKCenterView.a(this.a).a(true, 1);
                }
              });
          return;
        } 
        AppMethods.a(this.n.friend_ligature.alert_message);
        return;
      } 
    } else if (liveInteractionModel.getId() == R.id.live_make_friend_btn) {
      liveInteractionModel = this.n;
      if (liveInteractionModel != null && liveInteractionModel.multi_ligature != null) {
        if (this.n.multi_ligature.enable == 1) {
          d();
          return;
        } 
        AppMethods.a(this.n.multi_ligature.alert_message);
        return;
      } 
    } else if (liveInteractionModel.getId() == R.id.live_pk_center_help) {
      this.e.a(LiveRoomInfo.a().A());
    } 
  }
  
  public void setConnectionStateListener(ILiveConnectionStateListener paramILiveConnectionStateListener) {
    this.f = paramILiveConnectionStateListener;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\LivePKCenterView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */