package com.blued.android.module.live_china.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
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

public class LiveMakeFriendListView extends FrameLayout implements View.OnClickListener {
  public RenrenPullToRefreshListView a;
  
  public ListView b;
  
  public LiveMakeFriendAdapter c;
  
  public boolean d = true;
  
  public View e;
  
  public View f;
  
  public View g;
  
  private Context h;
  
  private LayoutInflater i;
  
  private View j;
  
  private View k;
  
  private View l;
  
  private TextView m;
  
  private TextView n;
  
  private TextView o;
  
  private int p;
  
  private int q = 0;
  
  private long r;
  
  private LiveSettingClickListener s;
  
  private BaseFragment t;
  
  private RecordingOnliveFragment u;
  
  private PlayingOnliveFragment v;
  
  private BluedUIHttpResponse w = new BluedUIHttpResponse<BluedEntity<LiveFriendModel, LiveFriendExtraModel>>(this) {
      boolean a = false;
      
      public boolean onUIFailure(int param1Int, String param1String) {
        this.a = true;
        return super.onUIFailure(param1Int, param1String);
      }
      
      public void onUIFinish() {
        super.onUIFinish();
        if (this.a) {
          this.b.f();
        } else if (this.b.c.getCount() == 0) {
          this.b.d();
        } else {
          this.b.g();
        } 
        this.b.a.q();
        this.b.a.j();
        this.a = false;
      }
      
      public void onUIStart() {
        super.onUIStart();
        this.b.e();
      }
      
      public void onUIUpdate(BluedEntity<LiveFriendModel, LiveFriendExtraModel> param1BluedEntity) {
        if (param1BluedEntity != null && param1BluedEntity.data != null && param1BluedEntity.data.size() > 0) {
          this.b.c.a(param1BluedEntity.data);
          return;
        } 
        this.b.c.a(new ArrayList());
      }
    };
  
  public LiveMakeFriendListView(Context paramContext) {
    this(paramContext, null);
  }
  
  public LiveMakeFriendListView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LiveMakeFriendListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.h = paramContext;
    j();
  }
  
  private void a(ILiveConnectionAnimListener paramILiveConnectionAnimListener) {
    if (this.k.getVisibility() == 8)
      return; 
    this.k.setVisibility(8);
    Animation animation = AnimationUtils.loadAnimation(this.h, R.anim.push_bottom_out);
    this.k.startAnimation(animation);
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
  
  private void j() {
    this.i = LayoutInflater.from(this.h);
    this.j = this.i.inflate(R.layout.live_make_friend_list, (ViewGroup)this);
    this.k = this.j.findViewById(R.id.content_layout);
    this.l = this.j.findViewById(R.id.live_make_friend_list_layer);
    this.m = (TextView)this.j.findViewById(R.id.live_make_friend_list_title);
    this.o = (TextView)this.j.findViewById(R.id.live_make_friend_setting_btn);
    this.l.setOnClickListener(this);
    this.o.setOnClickListener(this);
    this.k.setOnClickListener(this);
  }
  
  private void k() {
    this.e = this.j.findViewById(R.id.ll_nodata);
    this.f = this.j.findViewById(R.id.ll_error);
    this.g = this.j.findViewById(R.id.live_make_friend_loading_view);
    this.n = (TextView)this.k.findViewById(R.id.tv_live_reload);
    this.a = (RenrenPullToRefreshListView)this.j.findViewById(R.id.rptrlv_live_list);
    this.a.setRefreshEnabled(false);
    this.a.p();
    this.b = (ListView)this.a.getRefreshableView();
    this.a.setOnPullDownListener(new RenrenPullToRefreshListView.OnPullDownListener(this) {
          public void a() {
            this.a.a(true);
          }
          
          public void b() {
            this.a.a(false);
          }
        });
    this.b.setDivider(null);
    this.b.setSelector((Drawable)new ColorDrawable(0));
    this.c = new LiveMakeFriendAdapter(this.h, new LiveMakeFriendAdapter.LiveJoinListener(this) {
          public void a(LiveFriendModel param1LiveFriendModel, int param1Int) {
            if (LiveMakeFriendListView.a(this.a) instanceof RecordingOnliveFragment) {
              (LiveMakeFriendListView.b(this.a)).cG.a(param1LiveFriendModel.uid);
              return;
            } 
            if (LiveMakeFriendListView.a(this.a) instanceof PlayingOnliveFragment)
              LiveSetDataObserver.a().e(param1LiveFriendModel.uid); 
          }
          
          public void a(LiveFriendModel param1LiveFriendModel, int param1Int, TextView param1TextView) {
            this.a.a(param1LiveFriendModel, param1TextView);
          }
          
          public void b(LiveFriendModel param1LiveFriendModel, int param1Int, TextView param1TextView) {
            this.a.b(param1LiveFriendModel, param1TextView);
          }
        }this.p, this.b);
    this.b.setAdapter((ListAdapter)this.c);
    this.n.setOnClickListener(this);
  }
  
  public void a() {
    if (this.p == 0) {
      this.m.setText(R.string.live_make_friend_manage);
      return;
    } 
    if (this.q == 0) {
      this.m.setText(R.string.live_make_friend_apply);
      this.o.setText(R.string.live_make_friend_apply);
    } else {
      this.m.setText(R.string.live_make_friend_waiting_for);
      this.o.setText(R.string.live_make_friend_setting);
    } 
    this.o.setVisibility(0);
  }
  
  public void a(int paramInt, LiveSettingClickListener paramLiveSettingClickListener, long paramLong, BaseFragment paramBaseFragment) {
    this.p = paramInt;
    this.s = paramLiveSettingClickListener;
    this.r = paramLong;
    this.t = paramBaseFragment;
    BaseFragment baseFragment = this.t;
    if (baseFragment instanceof RecordingOnliveFragment) {
      this.u = (RecordingOnliveFragment)baseFragment;
    } else if (baseFragment instanceof PlayingOnliveFragment) {
      this.v = (PlayingOnliveFragment)baseFragment;
    } 
    k();
    a();
  }
  
  public void a(LiveFriendModel paramLiveFriendModel, TextView paramTextView) {
    LiveRoomHttpUtils.i(new BluedUIHttpResponse(this, (IRequestHost)this.t.w_(), paramLiveFriendModel, paramTextView) {
          public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
            super.onFailure(param1Throwable, param1Int, param1String);
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            this.c.g.setVisibility(8);
            this.b.setEnabled(true);
          }
          
          public void onUIStart() {
            super.onUIStart();
            this.c.g.setVisibility(0);
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            this.c.c.a(this.a);
          }
        }paramLiveFriendModel.uid);
  }
  
  public void a(boolean paramBoolean) {
    BaseFragment baseFragment = this.t;
    if (baseFragment instanceof RecordingOnliveFragment) {
      LiveRoomHttpUtils.a(this.w, this.u.u);
      return;
    } 
    if (baseFragment instanceof PlayingOnliveFragment)
      LiveRoomHttpUtils.a(this.w, this.v.u); 
  }
  
  public void b() {
    h();
  }
  
  public void b(LiveFriendModel paramLiveFriendModel, TextView paramTextView) {
    LiveRoomHttpUtils.h(new BluedUIHttpResponse(this, (IRequestHost)this.t.w_(), paramLiveFriendModel, paramTextView) {
          public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
            super.onFailure(param1Throwable, param1Int, param1String);
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            this.c.g.setVisibility(8);
            this.b.setEnabled(true);
          }
          
          public void onUIStart() {
            super.onUIStart();
            this.c.g.setVisibility(0);
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            this.c.c.a(this.a);
          }
        }paramLiveFriendModel.uid);
  }
  
  public void b(boolean paramBoolean) {
    setVisibility(0);
    this.k.setVisibility(0);
    this.k.clearAnimation();
    Animation animation = AnimationUtils.loadAnimation(this.h, R.anim.push_bottom_in);
    this.k.startAnimation(animation);
    animation.setAnimationListener(new Animation.AnimationListener(this, paramBoolean) {
          public void onAnimationEnd(Animation param1Animation) {
            if (this.a) {
              this.b.a.k();
              return;
            } 
            if (this.b.f.getVisibility() != 0 && this.b.e.getVisibility() != 0 && this.b.c.getCount() == 0)
              this.b.a.k(); 
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
  }
  
  public boolean c() {
    return (this.k.getVisibility() == 0);
  }
  
  public void d() {
    this.e.setVisibility(0);
    this.f.setVisibility(8);
    this.a.setVisibility(8);
    this.g.setVisibility(8);
  }
  
  public void e() {
    this.g.setVisibility(0);
    this.f.setVisibility(8);
    this.a.setVisibility(8);
    this.e.setVisibility(8);
  }
  
  public void f() {
    this.f.setVisibility(0);
    this.g.setVisibility(8);
    this.a.setVisibility(8);
    this.e.setVisibility(8);
  }
  
  public void g() {
    this.a.setVisibility(0);
    this.g.setVisibility(8);
    this.f.setVisibility(8);
    this.e.setVisibility(8);
  }
  
  public void h() {
    a((ILiveConnectionAnimListener)null);
  }
  
  public void i() {
    BluedUIHttpResponse bluedUIHttpResponse = new BluedUIHttpResponse(this, (IRequestHost)this.t.w_()) {
        public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
          super.onFailure(param1Throwable, param1Int, param1String);
        }
        
        public void onUIFinish() {
          super.onUIFinish();
          this.a.g.setVisibility(8);
        }
        
        public void onUIStart() {
          super.onUIStart();
          this.a.g.setVisibility(0);
        }
        
        public void onUIUpdate(BluedEntity param1BluedEntity) {
          this.a.setState(1);
          this.a.a(true);
          if (LiveMakeFriendListView.a(this.a) instanceof PlayingOnliveFragment)
            (LiveMakeFriendListView.c(this.a)).q.a(2); 
          AppMethods.d(R.string.live_make_friend_application_successful);
        }
      };
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.r);
    stringBuilder.append("");
    LiveRoomHttpUtils.f(bluedUIHttpResponse, stringBuilder.toString());
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() == R.id.live_make_friend_list_layer) {
      h();
      return;
    } 
    if (paramView.getId() == R.id.tv_live_reload) {
      a(true);
      return;
    } 
    if (paramView.getId() == R.id.live_make_friend_setting_btn) {
      if (this.q == 0) {
        i();
        return;
      } 
      if (this.s != null) {
        h();
        this.s.a();
      } 
    } 
  }
  
  public void setState(int paramInt) {
    this.q = paramInt;
    a();
  }
  
  public static interface LiveSettingClickListener {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\LiveMakeFriendListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */