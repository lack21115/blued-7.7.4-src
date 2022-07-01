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
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.LivePKInviteAdapter;
import com.blued.android.module.live_china.model.LiveFriendExtraModel;
import com.blued.android.module.live_china.model.LiveFriendModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import java.util.ArrayList;

public class LivePKFriendListView extends FrameLayout implements View.OnClickListener {
  public RenrenPullToRefreshListView a;
  
  public ListView b;
  
  public LivePKInviteAdapter c;
  
  public boolean d = true;
  
  public View e;
  
  public View f;
  
  public View g;
  
  private Context h;
  
  private LayoutInflater i;
  
  private View j;
  
  private View k;
  
  private View l;
  
  private ImageView m;
  
  private LiveConnectionView n;
  
  private ILiveConnectionStateListener o;
  
  private int p = 0;
  
  private TextView q;
  
  private TextView r;
  
  private ImageView s;
  
  private TextView t;
  
  private View u;
  
  private BluedUIHttpResponse v = new BluedUIHttpResponse<BluedEntity<LiveFriendModel, LiveFriendExtraModel>>(this) {
      boolean a = false;
      
      public boolean onUIFailure(int param1Int, String param1String) {
        this.a = true;
        return super.onUIFailure(param1Int, param1String);
      }
      
      public void onUIFinish() {
        super.onUIFinish();
        if (this.a) {
          this.b.c();
        } else if (this.b.c.getCount() == 0) {
          this.b.a();
        } else {
          this.b.d();
        } 
        if (this.b.d) {
          this.b.a.o();
        } else {
          this.b.a.p();
        } 
        this.b.a.q();
        this.b.a.j();
        this.a = false;
      }
      
      public void onUIStart() {
        super.onUIStart();
        if (LivePKFriendListView.b(this.b) == 0)
          this.b.b(); 
      }
      
      public void onUIUpdate(BluedEntity<LiveFriendModel, LiveFriendExtraModel> param1BluedEntity) {
        if (param1BluedEntity != null && param1BluedEntity.data != null && param1BluedEntity.data.size() > 0)
          if (LivePKFriendListView.b(this.b) == 0) {
            this.b.c.a(param1BluedEntity.data);
          } else {
            this.b.c.b(param1BluedEntity.data);
          }  
        this.b.d = param1BluedEntity.hasMore();
        if (param1BluedEntity.extra != null)
          LivePKFriendListView.a(this.b, ((LiveFriendExtraModel)param1BluedEntity.extra).cursor); 
      }
    };
  
  private int w;
  
  public LivePKFriendListView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public LivePKFriendListView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LivePKFriendListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.h = paramContext;
    l();
    m();
  }
  
  private void a(LiveFriendModel paramLiveFriendModel) {
    LiveRoomHttpUtils.c(new BluedUIHttpResponse(this, (IRequestHost)this.n.a.w_(), paramLiveFriendModel) {
          public void onUIFinish() {
            super.onUIFinish();
            this.b.i();
          }
          
          public void onUIStart() {
            super.onUIStart();
            this.b.h();
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            this.b.a(new ILiveConnectionAnimListener(this) {
                  public void a() {
                    LivePKFriendListView.c(this.a.b).a(this.a.a, true, 0);
                  }
                });
          }
        }paramLiveFriendModel.uid);
  }
  
  private void b(LiveFriendModel paramLiveFriendModel) {
    LiveRoomHttpUtils.d(new BluedUIHttpResponse(this, (IRequestHost)this.n.a.w_(), paramLiveFriendModel) {
          public void onUIFinish() {
            super.onUIFinish();
            this.b.i();
          }
          
          public void onUIStart() {
            super.onUIStart();
            this.b.h();
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            this.b.a(new ILiveConnectionAnimListener(this) {
                  public void a() {
                    LivePKFriendListView.c(this.a.b).a(this.a.a, true, 1);
                  }
                });
          }
        }paramLiveFriendModel.uid, 0);
  }
  
  private void l() {
    this.i = LayoutInflater.from(this.h);
    this.j = this.i.inflate(R.layout.live_pk_friend_list, (ViewGroup)this);
    this.k = this.j.findViewById(R.id.content_layout);
    this.l = this.j.findViewById(R.id.live_pk_friend_list_layer);
    this.m = (ImageView)this.j.findViewById(R.id.live_pk_friend_list_back);
    this.q = (TextView)this.j.findViewById(R.id.live_pk_friend_list_title);
    this.s = (ImageView)this.j.findViewById(R.id.live_pk_friend_list_invite);
    this.t = (TextView)this.j.findViewById(R.id.live_pk_friend_list_invite_text);
    this.u = this.j.findViewById(R.id.full_screen_loading_view);
    this.l.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.u.setOnClickListener(this);
    this.q.setOnClickListener(this);
  }
  
  private void m() {
    this.e = this.j.findViewById(R.id.ll_nodata);
    this.f = this.j.findViewById(R.id.ll_error);
    this.g = this.j.findViewById(R.id.pk_loading_view);
    this.r = (TextView)this.k.findViewById(R.id.tv_live_reload);
    this.a = (RenrenPullToRefreshListView)this.j.findViewById(R.id.rptrlv_live_list);
    this.a.setRefreshEnabled(false);
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
    this.c = new LivePKInviteAdapter(this.h, new LivePKInviteAdapter.LiveInviteListener(this) {
          public void a(LiveFriendModel param1LiveFriendModel, int param1Int) {
            if (LivePKFriendListView.a(this.a) == 0) {
              LivePKFriendListView.a(this.a, param1LiveFriendModel);
              return;
            } 
            LivePKFriendListView.b(this.a, param1LiveFriendModel);
          }
        });
    this.b.setAdapter((ListAdapter)this.c);
    this.r.setOnClickListener(this);
  }
  
  private void setLiveConnectionStatus(int paramInt) {
    LiveRoomHttpUtils.e(new BluedUIHttpResponse(this, (IRequestHost)this.n.a.w_()) {
          public void onUIFinish() {
            super.onUIFinish();
            this.a.i();
          }
          
          public void onUIStart() {
            super.onUIStart();
            this.a.h();
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {}
        }paramInt);
  }
  
  private void setLivePkStatus(int paramInt) {
    LiveRoomHttpUtils.c(new BluedUIHttpResponse(this, (IRequestHost)this.n.a.w_()) {
          public void onUIFinish() {
            super.onUIFinish();
            this.a.i();
          }
          
          public void onUIStart() {
            super.onUIStart();
            this.a.h();
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {}
        }paramInt);
  }
  
  public void a() {
    this.e.setVisibility(0);
    this.f.setVisibility(8);
    this.a.setVisibility(8);
    this.g.setVisibility(8);
  }
  
  public void a(ILiveConnectionAnimListener paramILiveConnectionAnimListener) {
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
    ILiveConnectionStateListener iLiveConnectionStateListener = this.o;
    if (iLiveConnectionStateListener != null)
      iLiveConnectionStateListener.b(); 
  }
  
  public void a(LiveConnectionView paramLiveConnectionView) {
    this.n = paramLiveConnectionView;
    this.o = paramLiveConnectionView;
  }
  
  public void a(boolean paramBoolean) {
    if (paramBoolean)
      this.p = 0; 
    if (this.w == 0) {
      LiveRoomHttpUtils.b(this.v, this.p);
      return;
    } 
    LiveRoomHttpUtils.d(this.v, this.p);
  }
  
  public void a(boolean paramBoolean, int paramInt) {
    if (this.w != paramInt)
      this.p = 0; 
    this.w = paramInt;
    if (this.w == 0) {
      this.q.setText(R.string.live_pk_friend);
    } else {
      this.q.setText(R.string.live_anchor_connection);
    } 
    this.c.a(paramInt);
    if (paramBoolean) {
      b();
      LivePKInviteAdapter livePKInviteAdapter = this.c;
      if (livePKInviteAdapter != null)
        livePKInviteAdapter.a(new ArrayList()); 
    } 
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
    ILiveConnectionStateListener iLiveConnectionStateListener = this.o;
    if (iLiveConnectionStateListener != null)
      iLiveConnectionStateListener.a(); 
    j();
  }
  
  public void b() {
    this.g.setVisibility(0);
    this.f.setVisibility(8);
    this.a.setVisibility(8);
    this.e.setVisibility(8);
  }
  
  public void c() {
    this.f.setVisibility(0);
    this.g.setVisibility(8);
    this.a.setVisibility(8);
    this.e.setVisibility(8);
  }
  
  public void d() {
    this.a.setVisibility(0);
    this.g.setVisibility(8);
    this.f.setVisibility(8);
    this.e.setVisibility(8);
  }
  
  public boolean e() {
    return (getVisibility() == 0);
  }
  
  public void f() {
    if (!g())
      k(); 
  }
  
  public boolean g() {
    return (this.u.getVisibility() == 0);
  }
  
  public void h() {
    this.u.setVisibility(0);
  }
  
  public void i() {
    this.u.setVisibility(8);
  }
  
  public void j() {
    if (this.w == 0) {
      if (this.n.a.bV) {
        this.s.setImageResource(R.drawable.live_invite_select);
      } else {
        this.s.setImageResource(R.drawable.live_invite_default);
      } 
      this.t.setText(R.string.live_pk_no_invitation);
      return;
    } 
    if (this.n.a.bW) {
      this.s.setImageResource(R.drawable.live_invite_select);
    } else {
      this.s.setImageResource(R.drawable.live_invite_default);
    } 
    this.t.setText(R.string.live_connection_no_invitation);
  }
  
  public void k() {
    a((ILiveConnectionAnimListener)null);
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() == R.id.live_pk_friend_list_layer) {
      k();
      return;
    } 
    if (paramView.getId() == R.id.live_pk_friend_list_back) {
      a(new ILiveConnectionAnimListener(this) {
            public void a() {
              LivePKFriendListView.c(this.a).a(false);
            }
          });
      return;
    } 
    if (paramView.getId() == R.id.tv_live_reload) {
      a(true);
      return;
    } 
    if (paramView.getId() == R.id.live_pk_friend_list_invite) {
      if (this.w == 0) {
        if (this.n.a.bV) {
          this.n.a.bV = false;
          this.s.setImageResource(R.drawable.live_invite_default);
          setLivePkStatus(0);
          return;
        } 
        this.n.a.bV = true;
        this.s.setImageResource(R.drawable.live_invite_select);
        setLivePkStatus(1);
        return;
      } 
      if (this.n.a.bW) {
        this.n.a.bW = false;
        this.s.setImageResource(R.drawable.live_invite_default);
        setLiveConnectionStatus(0);
        return;
      } 
      this.n.a.bW = true;
      this.s.setImageResource(R.drawable.live_invite_select);
      setLiveConnectionStatus(1);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\LivePKFriendListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */