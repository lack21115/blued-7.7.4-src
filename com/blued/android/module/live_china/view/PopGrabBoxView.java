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
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.GrabBoxDetailModel;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.InstantLog;

public class PopGrabBoxView {
  public View a;
  
  public View b;
  
  public View c;
  
  public Context d;
  
  public BaseFragment e;
  
  public LayoutInflater f;
  
  public LinearLayout g;
  
  public LinearLayout h;
  
  public LinearLayout i;
  
  private MyPopupWindow j;
  
  private String k;
  
  private String l;
  
  private IRequestHost m;
  
  private DismissLisnter n;
  
  private ImageView o;
  
  private TextView p;
  
  private TextView q;
  
  private TextView r;
  
  private TextView s;
  
  private TextView t;
  
  private View u;
  
  private LoadOptions v;
  
  private LinearLayout w;
  
  public PopGrabBoxView(BaseFragment paramBaseFragment, IRequestHost paramIRequestHost, DismissLisnter paramDismissLisnter) {
    this.e = paramBaseFragment;
    this.d = paramBaseFragment.getContext();
    this.m = paramIRequestHost;
    this.n = paramDismissLisnter;
    f();
  }
  
  public static void b(BaseFragment paramBaseFragment, String paramString1, String paramString2, DismissLisnter paramDismissLisnter, IRequestHost paramIRequestHost) {
    (new PopGrabBoxView(paramBaseFragment, paramIRequestHost, paramDismissLisnter)).a(paramString1, paramString2);
  }
  
  private void f() {
    this.f = LayoutInflater.from(this.d);
    a();
    this.b = this.a.findViewById(R.id.tv_bg);
    this.g = (LinearLayout)this.a.findViewById(R.id.ll_loading);
    this.o = (ImageView)this.a.findViewById(R.id.pop_grab_box_image);
    this.p = (TextView)this.a.findViewById(R.id.pop_grab_box_progress_left);
    this.q = (TextView)this.a.findViewById(R.id.pop_grab_box_progress_right);
    this.r = (TextView)this.a.findViewById(R.id.pop_grab_box_wandou);
    this.s = (TextView)this.a.findViewById(R.id.pop_grab_box_title);
    this.t = (TextView)this.a.findViewById(R.id.pop_grab_box_detail);
    this.u = this.a.findViewById(R.id.pop_grab_box_detail_btn);
    this.w = (LinearLayout)this.a.findViewById(R.id.box_detail_layout);
    this.h = (LinearLayout)this.a.findViewById(R.id.ll_left_part);
    this.i = (LinearLayout)this.a.findViewById(R.id.ll_right_part);
    this.b.setBackgroundColor(this.d.getResources().getColor(R.color.transparent));
    this.b.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.d();
          }
        });
    this.c = this.a.findViewById(R.id.ll_content);
    this.c.setVisibility(8);
    this.c.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {}
        });
    this.j = new MyPopupWindow(this, this.a, -1, -1, true);
    this.j.setBackgroundDrawable(this.d.getResources().getDrawable(17170445));
    this.j.setTouchable(true);
    this.j.setOutsideTouchable(true);
    this.j.setFocusable(true);
    this.j.update();
    this.v = new LoadOptions();
    this.v.l = false;
    this.g.setVisibility(8);
  }
  
  public void a() {
    this.a = this.f.inflate(R.layout.pop_grab_box, null);
  }
  
  public void a(String paramString1, String paramString2) {
    this.k = paramString1;
    this.l = paramString2;
    this.w.setVisibility(4);
    this.g.setVisibility(0);
    this.b.clearAnimation();
    this.c.clearAnimation();
    if (this.j.isShowing())
      this.j.a(); 
    DismissLisnter dismissLisnter = this.n;
    if (dismissLisnter != null)
      dismissLisnter.b(); 
    this.j.showAtLocation(this.c, 81, 0, 0);
    this.c.setVisibility(0);
    b();
  }
  
  public void b() {
    this.c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_bottom_in));
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 0.5F);
    alphaAnimation.setDuration(300L);
    alphaAnimation.setFillAfter(true);
    alphaAnimation.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {
            this.a.e();
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    this.b.startAnimation((Animation)alphaAnimation);
  }
  
  public void c() {
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.5F, 0.0F);
    alphaAnimation.setDuration(300L);
    alphaAnimation.setFillAfter(true);
    this.b.startAnimation((Animation)alphaAnimation);
    this.c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_bottom_out));
  }
  
  public void d() {
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            PopGrabBoxView.a(this.a).a();
            if (PopGrabBoxView.b(this.a) != null)
              PopGrabBoxView.b(this.a).a(); 
          }
        },  320L);
    c();
    this.c.setVisibility(8);
  }
  
  public void e() {
    LiveRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntity<GrabBoxDetailModel, GrabBoxDetailModel>>(this, this.m) {
          boolean a = false;
          
          public boolean onUIFailure(int param1Int, String param1String) {
            this.a = true;
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish() {
            this.b.g.setVisibility(8);
            PopGrabBoxView.l(this.b).setVisibility(0);
            if (this.a) {
              this.a = false;
              this.b.d();
            } 
          }
          
          public void onUIUpdate(BluedEntity<GrabBoxDetailModel, GrabBoxDetailModel> param1BluedEntity) {
            if (param1BluedEntity != null && param1BluedEntity.extra != null) {
              GrabBoxDetailModel grabBoxDetailModel = (GrabBoxDetailModel)param1BluedEntity.extra;
              ImageLoader.a(PopGrabBoxView.d(this.b), grabBoxDetailModel.start_image).a(PopGrabBoxView.c(this.b));
              PopGrabBoxView.e(this.b).setText(grabBoxDetailModel.name);
              PopGrabBoxView.f(this.b).setText(grabBoxDetailModel.comment);
              PopGrabBoxView.g(this.b).setText(grabBoxDetailModel.wish);
              PopGrabBoxView.h(this.b).setText(grabBoxDetailModel.top_wish);
              PopGrabBoxView.i(this.b).setText(CommonStringUtils.a(grabBoxDetailModel.total_wish));
              if (TextUtils.equals(LiveRoomInfo.a().f(), PopGrabBoxView.j(this.b))) {
                PopGrabBoxView.k(this.b).setVisibility(8);
                this.b.h.setPadding(this.b.h.getPaddingLeft(), DensityUtils.a(this.b.d, 14.0F), this.b.h.getPaddingRight(), DensityUtils.a(this.b.d, 14.0F));
                this.b.i.setPadding(this.b.i.getPaddingLeft(), DensityUtils.a(this.b.d, 14.0F), this.b.i.getPaddingRight(), this.b.i.getPaddingBottom());
              } else {
                PopGrabBoxView.k(this.b).setVisibility(0);
                this.b.h.setPadding(this.b.h.getPaddingLeft(), DensityUtils.a(this.b.d, 30.0F), this.b.h.getPaddingRight(), DensityUtils.a(this.b.d, 30.0F));
                this.b.i.setPadding(this.b.i.getPaddingLeft(), DensityUtils.a(this.b.d, 30.0F), this.b.i.getPaddingRight(), this.b.i.getPaddingBottom());
              } 
              PopGrabBoxView.k(this.b).setOnClickListener(new View.OnClickListener(this, grabBoxDetailModel) {
                    public void onClick(View param2View) {
                      if (!LiveRefreshUIObserver.a().e())
                        return; 
                      if (!TextUtils.equals(LiveRoomInfo.a().f(), PopGrabBoxView.j(this.b.b))) {
                        InstantLog.a("live_activity_link_click");
                        LiveRoomInfo.a().b(this.b.b.d, this.a.url);
                      } 
                      if (this.b.b.e instanceof com.blued.android.module.live_china.fragment.PlayingOnliveFragment)
                        LiveRefreshUIObserver.a().b(true); 
                    }
                  });
            } 
          }
        }this.k, this.l, this.m);
  }
  
  public static interface DismissLisnter {
    void a();
    
    void b();
  }
  
  class MyPopupWindow extends PopupWindow {
    public MyPopupWindow(PopGrabBoxView this$0, View param1View, int param1Int1, int param1Int2, boolean param1Boolean) {
      super(param1View, param1Int1, param1Int2, param1Boolean);
    }
    
    public void a() {
      super.dismiss();
    }
    
    public void dismiss() {
      try {
        this.a.d();
        return;
      } catch (Exception exception) {
        a();
        return;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\PopGrabBoxView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */