package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.LiveMakeFriendAdapter;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.model.LiveFriendExtraModel;
import com.blued.android.module.live_china.model.LiveFriendModel;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import java.util.ArrayList;

public class LiveMakeLoverListView extends FrameLayout implements View.OnClickListener {
  public RenrenPullToRefreshListView a;
  
  public LiveMakeFriendAdapter b;
  
  public boolean c = true;
  
  public View d;
  
  public View e;
  
  public View f;
  
  private Context g;
  
  private LayoutInflater h;
  
  private View i;
  
  private View j;
  
  private View k;
  
  private TextView l;
  
  private TextView m;
  
  private int n;
  
  private int o = 0;
  
  private long p;
  
  private LiveSettingClickListener q;
  
  private BaseFragment r;
  
  private RecordingOnliveFragment s;
  
  private PlayingOnliveFragment t;
  
  private BluedUIHttpResponse u = new BluedUIHttpResponse<BluedEntity<LiveFriendModel, LiveFriendExtraModel>>(this) {
      boolean a = false;
      
      public boolean onUIFailure(int param1Int, String param1String) {
        this.a = true;
        return super.onUIFailure(param1Int, param1String);
      }
      
      public void onUIFinish() {
        super.onUIFinish();
        if (this.a) {
          this.b.d();
        } else if (this.b.b.getCount() == 0) {
          this.b.b();
        } else {
          this.b.e();
        } 
        this.b.a.q();
        this.b.a.j();
        this.a = false;
      }
      
      public void onUIStart() {
        super.onUIStart();
        this.b.c();
      }
      
      public void onUIUpdate(BluedEntity<LiveFriendModel, LiveFriendExtraModel> param1BluedEntity) {
        if (param1BluedEntity != null && param1BluedEntity.data != null && param1BluedEntity.data.size() > 0) {
          this.b.b.a(param1BluedEntity.data);
          return;
        } 
        this.b.b.a(new ArrayList());
      }
    };
  
  public LiveMakeLoverListView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LiveMakeLoverListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.g = paramContext;
    h();
  }
  
  private void a(ILiveConnectionAnimListener paramILiveConnectionAnimListener) {
    if (this.j.getVisibility() == 8)
      return; 
    this.j.setVisibility(8);
    Animation animation = AnimationUtils.loadAnimation(this.g, R.anim.push_bottom_out);
    this.j.startAnimation(animation);
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
  }
  
  private void h() {
    this.h = LayoutInflater.from(this.g);
    this.i = this.h.inflate(R.layout.live_make_lover_list, (ViewGroup)this);
    this.j = this.i.findViewById(R.id.content_layout);
    this.k = this.i.findViewById(R.id.live_make_lover_list_layer);
    this.l = (TextView)this.i.findViewById(R.id.live_make_lover_list_title);
    this.m = (TextView)this.i.findViewById(R.id.live_make_lover_setting_btn);
    this.k.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.j.setOnClickListener(this);
  }
  
  public void a() {
    if (this.n == 0) {
      this.l.setText(R.string.live_make_friend_manage);
      return;
    } 
    if (this.o == 0) {
      this.l.setText(R.string.live_make_friend_apply);
      this.m.setText(R.string.live_make_friend_apply);
    } else {
      this.l.setText(R.string.live_make_friend_waiting_for);
      this.m.setText(R.string.live_make_friend_setting);
    } 
    this.m.setVisibility(0);
  }
  
  public void a(LiveFriendModel paramLiveFriendModel, TextView paramTextView) {
    LiveRoomHttpUtils.i(new BluedUIHttpResponse(this, (IRequestHost)this.r.w_(), paramLiveFriendModel, paramTextView) {
          public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
            super.onFailure(param1Throwable, param1Int, param1String);
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            this.c.f.setVisibility(8);
            this.b.setEnabled(true);
          }
          
          public void onUIStart() {
            super.onUIStart();
            this.c.f.setVisibility(0);
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            this.c.b.a(this.a);
          }
        }paramLiveFriendModel.uid);
  }
  
  public void a(boolean paramBoolean) {
    BaseFragment baseFragment = this.r;
    if (baseFragment instanceof RecordingOnliveFragment) {
      LiveRoomHttpUtils.a(this.u, this.s.u);
      return;
    } 
    if (baseFragment instanceof PlayingOnliveFragment)
      LiveRoomHttpUtils.a(this.u, this.t.u); 
  }
  
  public void b() {
    this.d.setVisibility(0);
    this.e.setVisibility(8);
    this.a.setVisibility(8);
    this.f.setVisibility(8);
  }
  
  public void b(LiveFriendModel paramLiveFriendModel, TextView paramTextView) {
    LiveRoomHttpUtils.h(new BluedUIHttpResponse(this, (IRequestHost)this.r.w_(), paramLiveFriendModel, paramTextView) {
          public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
            super.onFailure(param1Throwable, param1Int, param1String);
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            this.c.f.setVisibility(8);
            this.b.setEnabled(true);
          }
          
          public void onUIStart() {
            super.onUIStart();
            this.c.f.setVisibility(0);
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            this.c.b.a(this.a);
          }
        }paramLiveFriendModel.uid);
  }
  
  public void c() {
    this.f.setVisibility(0);
    this.e.setVisibility(8);
    this.a.setVisibility(8);
    this.d.setVisibility(8);
  }
  
  public void d() {
    this.e.setVisibility(0);
    this.f.setVisibility(8);
    this.a.setVisibility(8);
    this.d.setVisibility(8);
  }
  
  public void e() {
    this.a.setVisibility(0);
    this.f.setVisibility(8);
    this.e.setVisibility(8);
    this.d.setVisibility(8);
  }
  
  public void f() {
    a((ILiveConnectionAnimListener)null);
  }
  
  public void g() {
    BluedUIHttpResponse bluedUIHttpResponse = new BluedUIHttpResponse(this, (IRequestHost)this.r.w_()) {
        public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
          super.onFailure(param1Throwable, param1Int, param1String);
        }
        
        public void onUIFinish() {
          super.onUIFinish();
          this.a.f.setVisibility(8);
        }
        
        public void onUIStart() {
          super.onUIStart();
          this.a.f.setVisibility(0);
        }
        
        public void onUIUpdate(BluedEntity param1BluedEntity) {
          this.a.setState(1);
          this.a.a(true);
          if (LiveMakeLoverListView.a(this.a) instanceof PlayingOnliveFragment)
            (LiveMakeLoverListView.c(this.a)).q.a(2); 
          AppMethods.d(R.string.live_make_friend_application_successful);
        }
      };
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.p);
    stringBuilder.append("");
    LiveRoomHttpUtils.f(bluedUIHttpResponse, stringBuilder.toString());
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() == R.id.live_make_lover_list_layer) {
      f();
      return;
    } 
    if (paramView.getId() == R.id.tv_live_reload) {
      a(true);
      return;
    } 
    if (paramView.getId() == R.id.live_make_lover_setting_btn) {
      if (this.o == 0) {
        g();
        return;
      } 
      if (this.q != null) {
        f();
        this.q.a();
      } 
    } 
  }
  
  public void setState(int paramInt) {
    this.o = paramInt;
    a();
  }
  
  public static interface LiveSettingClickListener {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\LiveMakeLoverListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */