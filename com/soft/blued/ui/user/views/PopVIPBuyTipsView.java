package com.soft.blued.ui.user.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.das.vip.VipProtos;
import com.soft.blued.log.trackUtils.EventTrackVIP;
import com.soft.blued.ui.user.adapter.VIPBuyTipsAdapter;
import com.soft.blued.ui.user.model.VIPPrivilegeModel;
import java.util.List;

public class PopVIPBuyTipsView {
  public View a;
  
  public View b;
  
  public View c;
  
  public Context d;
  
  public LayoutInflater e;
  
  private MyPopupWindow f;
  
  private RecyclerView g;
  
  private VIPBuyTipsAdapter h;
  
  private TextView i;
  
  private TextView j;
  
  private List<VIPPrivilegeModel> k;
  
  private BaseFragment l;
  
  private int m;
  
  public PopVIPBuyTipsView(BaseFragment paramBaseFragment, List<VIPPrivilegeModel> paramList, int paramInt) {
    this.d = paramBaseFragment.getContext();
    this.l = paramBaseFragment;
    this.k = paramList;
    this.m = paramInt;
    e();
  }
  
  private void e() {
    ActivityFragmentActive activityFragmentActive;
    this.e = LayoutInflater.from(this.d);
    a();
    this.b = this.a.findViewById(2131300559);
    this.g = (RecyclerView)this.a.findViewById(2131299605);
    this.i = (TextView)this.a.findViewById(2131301702);
    this.j = (TextView)this.a.findViewById(2131301701);
    BaseFragment baseFragment = this.l;
    if (baseFragment == null) {
      baseFragment = null;
    } else {
      activityFragmentActive = baseFragment.w_();
    } 
    this.h = new VIPBuyTipsAdapter((IRequestHost)activityFragmentActive);
    this.g.setAdapter((RecyclerView.Adapter)this.h);
    this.g.setLayoutManager((RecyclerView.LayoutManager)new GridLayoutManager(this.d, 3));
    this.h.c(this.k);
    this.b.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {}
        });
    this.c = this.a.findViewById(2131298758);
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
    this.i.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            EventTrackVIP.a(VipProtos.Event.VIP_BUY_PAGE_CANCEL_POP_BUY_CLICK, PopVIPBuyTipsView.a(this.a));
            this.a.d();
          }
        });
    this.j.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            EventTrackVIP.a(VipProtos.Event.VIP_BUY_PAGE_CANCEL_POP_CANCEL_CLICK, PopVIPBuyTipsView.a(this.a));
            this.a.d();
            if (PopVIPBuyTipsView.b(this.a).getActivity() != null)
              PopVIPBuyTipsView.b(this.a).getActivity().finish(); 
          }
        });
  }
  
  private void f() {
    this.c.startAnimation(AnimationUtils.loadAnimation(this.d, 2130772055));
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
  
  private void g() {
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.5F, 0.0F);
    alphaAnimation.setDuration(300L);
    alphaAnimation.setFillAfter(true);
    this.b.startAnimation((Animation)alphaAnimation);
    this.c.startAnimation(AnimationUtils.loadAnimation(this.d, 2130772056));
  }
  
  public void a() {
    this.a = this.e.inflate(2131494289, null);
  }
  
  public boolean b() {
    return this.f.isShowing();
  }
  
  public void c() {
    this.b.clearAnimation();
    this.c.clearAnimation();
    if (this.f.isShowing())
      this.f.a(); 
    this.f.showAtLocation(this.c, 81, 0, 0);
    this.c.setVisibility(0);
    f();
  }
  
  public void d() {
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            PopVIPBuyTipsView.c(this.a).a();
          }
        },  320L);
    g();
    this.c.setVisibility(8);
  }
  
  class MyPopupWindow extends PopupWindow {
    public MyPopupWindow(PopVIPBuyTipsView this$0, View param1View, int param1Int1, int param1Int2, boolean param1Boolean) {
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
        if (PopVIPBuyTipsView.b(this.a) != null && PopVIPBuyTipsView.b(this.a).isAdded())
          a(); 
        return;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\views\PopVIPBuyTipsView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */