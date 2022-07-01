package com.blued.android.module.live_china.view;

import android.content.Context;
import android.text.TextUtils;
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
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveFriendModel;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import java.util.ArrayList;
import java.util.List;

public class PopLiveCallView implements View.OnClickListener {
  public View a;
  
  public View b;
  
  public View c;
  
  public Context d;
  
  public LayoutInflater e;
  
  private MyPopupWindow f;
  
  private BaseFragment g;
  
  private RecordingOnliveFragment h;
  
  private PlayingOnliveFragment i;
  
  private ImageView j;
  
  private TextView k;
  
  private TextView l;
  
  private TextView m;
  
  private ImageView n;
  
  private ImageView o;
  
  private ImageView p;
  
  private LinearLayout q;
  
  private LiveFriendModel r;
  
  private List<LiveFriendModel> s = new ArrayList<LiveFriendModel>();
  
  private LinearLayout t;
  
  public PopLiveCallView(BaseFragment paramBaseFragment) {
    this.g = paramBaseFragment;
    if (paramBaseFragment instanceof RecordingOnliveFragment) {
      this.h = (RecordingOnliveFragment)paramBaseFragment;
    } else if (paramBaseFragment instanceof PlayingOnliveFragment) {
      this.i = (PlayingOnliveFragment)paramBaseFragment;
    } 
    this.d = paramBaseFragment.getContext();
    e();
  }
  
  private void a(ILiveConnectionAnimListener paramILiveConnectionAnimListener) {
    BaseFragment baseFragment = this.g;
    if (baseFragment instanceof RecordingOnliveFragment) {
      this.h.R();
    } else if (baseFragment instanceof PlayingOnliveFragment) {
      this.i.d(0);
      LiveSetDataObserver.a().e(0);
    } 
    AppInfo.n().postDelayed(new Runnable(this, paramILiveConnectionAnimListener) {
          public void run() {
            PopLiveCallView.a(this.b).a();
            PopLiveCallView.b(this.b);
            ILiveConnectionAnimListener iLiveConnectionAnimListener = this.a;
            if (iLiveConnectionAnimListener != null)
              iLiveConnectionAnimListener.a(); 
          }
        }320L);
    j();
    this.c.setVisibility(8);
  }
  
  private void b(int paramInt) {
    LiveRoomHttpUtils.c(new BluedUIHttpResponse(this, (IRequestHost)this.g.w_(), paramInt) {
          public void onUIFinish() {
            super.onUIFinish();
            PopLiveCallView.c(this.b).setVisibility(8);
          }
          
          public void onUIStart() {
            super.onUIStart();
            PopLiveCallView.c(this.b).setVisibility(0);
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            if (this.a == 1)
              this.b.a(0); 
          }
        }paramInt);
  }
  
  private void c(int paramInt) {
    LiveRoomHttpUtils.e(new BluedUIHttpResponse(this, (IRequestHost)this.g.w_(), paramInt) {
          public void onUIFinish() {
            super.onUIFinish();
            PopLiveCallView.c(this.b).setVisibility(8);
          }
          
          public void onUIStart() {
            super.onUIStart();
            PopLiveCallView.c(this.b).setVisibility(0);
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            if (this.a == 1)
              this.b.a(1); 
          }
        }paramInt);
  }
  
  private void c(LiveFriendModel paramLiveFriendModel) {
    if (paramLiveFriendModel != null) {
      ImageLoader.a(null, paramLiveFriendModel.avatar).a(R.drawable.user_bg_round).c().a(this.j);
      if (!TextUtils.isEmpty(paramLiveFriendModel.name)) {
        this.k.setText(paramLiveFriendModel.name);
      } else {
        this.k.setText("");
      } 
      int i = paramLiveFriendModel.model;
      if (i != 0) {
        if (i != 1) {
          if (i != 2)
            return; 
          this.l.setText(R.string.live_connection_anchor_invitation);
          this.q.setVisibility(8);
          return;
        } 
        this.l.setText(R.string.live_connection_sent_you_invitation);
        this.q.setVisibility(0);
        return;
      } 
      this.l.setText(R.string.live_pk_sent_you_invitation);
      this.q.setVisibility(0);
    } 
  }
  
  private void d() {
    if (!c() && this.s.size() > 0) {
      this.r = this.s.get(0);
      c(this.r);
      f();
    } 
  }
  
  private void d(LiveFriendModel paramLiveFriendModel) {
    LiveRoomHttpUtils.d(new BluedUIHttpResponse(this, (IRequestHost)this.g.w_(), paramLiveFriendModel) {
          public void onUIFinish() {
            super.onUIFinish();
            PopLiveCallView.c(this.b).setVisibility(8);
          }
          
          public void onUIStart() {
            super.onUIStart();
            PopLiveCallView.c(this.b).setVisibility(0);
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            PopLiveCallView.d(this.b).remove(this.a);
            PopLiveCallView.e(this.b);
          }
        }paramLiveFriendModel.uid);
  }
  
  private void e() {
    this.e = LayoutInflater.from(this.d);
    b();
    this.b = this.a.findViewById(R.id.live_pk_call_layer);
    this.c = this.a.findViewById(R.id.content_layout);
    this.j = (ImageView)this.a.findViewById(R.id.live_pk_call_header);
    this.k = (TextView)this.a.findViewById(R.id.live_pk_call_name);
    this.l = (TextView)this.a.findViewById(R.id.live_pk_call_text);
    this.m = (TextView)this.a.findViewById(R.id.live_pk_call_invite_text);
    this.q = (LinearLayout)this.a.findViewById(R.id.live_pk_call_invite_layout);
    this.n = (ImageView)this.a.findViewById(R.id.live_pk_call_cancel);
    this.o = (ImageView)this.a.findViewById(R.id.live_pk_call_answer);
    this.p = (ImageView)this.a.findViewById(R.id.live_pk_call_invite);
    this.t = (LinearLayout)this.a.findViewById(R.id.ll_loading);
    this.n.setOnClickListener(this);
    this.o.setOnClickListener(this);
    this.p.setOnClickListener(this);
    this.b.setBackgroundColor(this.d.getResources().getColor(R.color.transparent));
    this.b.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {}
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
  
  private void e(LiveFriendModel paramLiveFriendModel) {
    LiveRoomHttpUtils.e(new BluedUIHttpResponse(this, (IRequestHost)this.g.w_()) {
          public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
            super.onFailure(param1Throwable, param1Int, param1String);
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            PopLiveCallView.c(this.a).setVisibility(8);
          }
          
          public void onUIStart() {
            super.onUIStart();
            PopLiveCallView.c(this.a).setVisibility(0);
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            PopLiveCallView.d(this.a).clear();
            PopLiveCallView.e(this.a);
          }
        }paramLiveFriendModel.uid);
  }
  
  private void f() {
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
    g();
  }
  
  private void f(LiveFriendModel paramLiveFriendModel) {
    LiveRoomHttpUtils.m(new BluedUIHttpResponse(this, (IRequestHost)this.g.w_(), paramLiveFriendModel) {
          public void onUIFinish() {
            super.onUIFinish();
            PopLiveCallView.c(this.b).setVisibility(8);
          }
          
          public void onUIStart() {
            super.onUIStart();
            PopLiveCallView.c(this.b).setVisibility(0);
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            PopLiveCallView.d(this.b).remove(this.a);
            PopLiveCallView.e(this.b);
          }
        }paramLiveFriendModel.uid);
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
    h();
  }
  
  private void g(LiveFriendModel paramLiveFriendModel) {
    LiveRoomInfo.a().a(new PermissionCallbacks(this, paramLiveFriendModel) {
          public void a(String[] param1ArrayOfString) {
            LiveMsgSendManager.a().b("关闭权限");
            PopLiveCallView popLiveCallView = this.b;
            PopLiveCallView.a(popLiveCallView, PopLiveCallView.g(popLiveCallView));
            PopLiveCallView.e(this.b);
          }
          
          public void aa_() {
            LiveMsgSendManager.a().b("开启权限");
            LiveRoomHttpUtils.n(new BluedUIHttpResponse(this, (IRequestHost)PopLiveCallView.f(this.b).w_()) {
                  public void onFailure(Throwable param2Throwable, int param2Int, String param2String) {
                    super.onFailure(param2Throwable, param2Int, param2String);
                  }
                  
                  public void onUIFinish() {
                    super.onUIFinish();
                    PopLiveCallView.c(this.a.b).setVisibility(8);
                  }
                  
                  public void onUIStart() {
                    super.onUIStart();
                    PopLiveCallView.c(this.a.b).setVisibility(0);
                  }
                  
                  public void onUIUpdate(BluedEntity param2BluedEntity) {
                    PopLiveCallView.d(this.a.b).clear();
                    PopLiveCallView.e(this.a.b);
                  }
                }this.a.uid);
          }
        });
  }
  
  private void h() {
    if (this.g instanceof RecordingOnliveFragment) {
      LiveFriendModel liveFriendModel = this.r;
      if (liveFriendModel != null) {
        if (liveFriendModel.model == 0) {
          if (this.h.bV) {
            this.p.setImageResource(R.drawable.live_invite_select);
          } else {
            this.p.setImageResource(R.drawable.live_invite_default);
          } 
          this.m.setText(R.string.live_pk_no_invitation);
          return;
        } 
        if (this.h.bW) {
          this.p.setImageResource(R.drawable.live_invite_select);
        } else {
          this.p.setImageResource(R.drawable.live_invite_default);
        } 
        this.m.setText(R.string.live_connection_no_invitation);
      } 
    } 
  }
  
  private void i() {
    a((ILiveConnectionAnimListener)null);
  }
  
  private void j() {
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.5F, 0.0F);
    alphaAnimation.setDuration(300L);
    alphaAnimation.setFillAfter(true);
    this.b.startAnimation((Animation)alphaAnimation);
    this.c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_bottom_out));
  }
  
  private boolean k() {
    return (this.t.getVisibility() == 0);
  }
  
  public void a() {
    this.n.performClick();
  }
  
  public void a(int paramInt) {
    for (int i = 0; i < this.s.size(); i = j + 1) {
      LiveFriendModel liveFriendModel = this.s.get(i);
      int j = i;
      if (liveFriendModel.model == paramInt) {
        this.s.remove(liveFriendModel);
        j = i - 1;
      } 
    } 
  }
  
  public void a(LiveFriendModel paramLiveFriendModel) {
    this.s.add(paramLiveFriendModel);
    d();
  }
  
  public void b() {
    this.a = this.e.inflate(R.layout.live_pk_call, null);
  }
  
  public void b(LiveFriendModel paramLiveFriendModel) {
    if (paramLiveFriendModel != null) {
      LiveFriendModel liveFriendModel = this.r;
      if (liveFriendModel != null && TextUtils.equals(liveFriendModel.uid, paramLiveFriendModel.uid)) {
        if (this.s.size() > 0)
          this.s.remove(0); 
        this.r = null;
        i();
      } 
    } 
  }
  
  public boolean c() {
    return (this.c.getVisibility() == 0);
  }
  
  public void onClick(View paramView) {
    LiveFriendModel liveFriendModel;
    if (paramView.getId() == R.id.live_pk_call_cancel) {
      liveFriendModel = this.r;
      if (liveFriendModel != null) {
        if (liveFriendModel.model == 0) {
          d(this.r);
          return;
        } 
        f(this.r);
        return;
      } 
    } else if (liveFriendModel.getId() == R.id.live_pk_call_answer) {
      liveFriendModel = this.r;
      if (liveFriendModel != null) {
        if (liveFriendModel.model == 0) {
          e(this.r);
          return;
        } 
        g(this.r);
        return;
      } 
    } else if (liveFriendModel.getId() == R.id.live_pk_call_invite) {
      if (k())
        return; 
      if (this.g instanceof RecordingOnliveFragment) {
        liveFriendModel = this.r;
        if (liveFriendModel != null)
          if (liveFriendModel.model == 0) {
            if (this.h.bV) {
              this.h.bV = false;
              this.p.setImageResource(R.drawable.live_invite_default);
              b(0);
            } else {
              this.h.bV = true;
              this.p.setImageResource(R.drawable.live_invite_select);
              b(1);
            } 
          } else if (this.h.bW) {
            this.h.bW = false;
            this.p.setImageResource(R.drawable.live_invite_default);
            c(0);
          } else {
            this.h.bW = true;
            this.p.setImageResource(R.drawable.live_invite_select);
            c(1);
          }  
        this.h.br.l();
      } 
    } 
  }
  
  class MyPopupWindow extends PopupWindow {
    public MyPopupWindow(PopLiveCallView this$0, View param1View, int param1Int1, int param1Int2, boolean param1Boolean) {
      super(param1View, param1Int1, param1Int2, param1Boolean);
    }
    
    public void a() {
      super.dismiss();
    }
    
    public void dismiss() {
      try {
        PopLiveCallView.e(this.a);
        return;
      } catch (Exception exception) {
        a();
        return;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\PopLiveCallView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */