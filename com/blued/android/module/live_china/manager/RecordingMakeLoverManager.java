package com.blued.android.module.live_china.manager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.model.LiveMakeLoverFansModel;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.LivePreferencesUtils;
import com.blued.android.module.live_china.view.HoleRelativeLayout;
import com.blued.android.module.live_china.view.NewFuncPopwindow;
import java.util.List;

public class RecordingMakeLoverManager extends MakeLoverBaseManager {
  public static int b = 0;
  
  public static int c = 0;
  
  public static double d = 1.0D;
  
  private Context e;
  
  private RecordingOnliveFragment f;
  
  private int g;
  
  public RecordingMakeLoverManager(RecordingOnliveFragment paramRecordingOnliveFragment) {
    this.f = paramRecordingOnliveFragment;
    this.e = paramRecordingOnliveFragment.getContext();
    this.g = AppInfo.l / 3;
    b = (int)(this.g * d);
    c = DensityUtils.a(this.e, '');
  }
  
  private NewFuncPopwindow a(View paramView, int paramInt) {
    NewFuncPopwindow newFuncPopwindow = new NewFuncPopwindow(this.e, (int)(AppInfo.l * 0.453D), -1);
    newFuncPopwindow.a(paramInt);
    newFuncPopwindow.b(DensityUtils.a(this.e, 10.0F));
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("x:");
    stringBuilder.append(arrayOfInt[0]);
    stringBuilder.append(" ; y:");
    stringBuilder.append(arrayOfInt[1]);
    Logger.d("RecordingMakeLoverManager", new Object[] { stringBuilder.toString() });
    HoleRelativeLayout.RoundRect roundRect = new HoleRelativeLayout.RoundRect();
    roundRect.a = arrayOfInt[0];
    roundRect.b = arrayOfInt[1];
    roundRect.c = paramView.getWidth();
    roundRect.d = paramView.getHeight();
    roundRect.i = false;
    newFuncPopwindow.a(roundRect);
    newFuncPopwindow.a(5000L);
    newFuncPopwindow.a(this.f.e, arrayOfInt[0], arrayOfInt[1]);
    return newFuncPopwindow;
  }
  
  private void i() {
    a(this.f.aZ.Q, R.drawable.live_lover_restart).a(null);
  }
  
  private void j() {
    a((View)this.f.aZ.R, R.drawable.live_lover_ok).a(new NewFuncPopwindow.FuncDismissListener(this) {
          public void a() {
            RecordingMakeLoverManager.b(this.a);
          }
        });
  }
  
  public void b(List<LiveMakeLoverFansModel> paramList) {
    if (paramList != null)
      a(paramList); 
    h();
  }
  
  public void d(String paramString) {
    int i = b(paramString);
    h();
    this.f.aZ.a(i);
  }
  
  public void f() {
    this.f.b_(8);
    this.f.S.d();
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
    layoutParams.setMargins(0, c, 0, 0);
    this.f.bs.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    layoutParams = (FrameLayout.LayoutParams)this.f.bt.getLayoutParams();
    layoutParams.width = -1;
    layoutParams.height = b * 2;
    this.f.bt.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    layoutParams = new FrameLayout.LayoutParams(this.g, b);
    this.f.C.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    layoutParams = new FrameLayout.LayoutParams(this.g, b);
    layoutParams.leftMargin = this.g;
    this.f.bE.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.f.aZ.b.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    layoutParams = new FrameLayout.LayoutParams(this.g, b);
    layoutParams.leftMargin = this.g * 2;
    this.f.bF.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.f.aZ.c.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    layoutParams = new FrameLayout.LayoutParams(this.g, b);
    layoutParams.topMargin = b;
    this.f.bG.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.f.aZ.d.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    layoutParams = new FrameLayout.LayoutParams(this.g, b);
    layoutParams.topMargin = b;
    layoutParams.leftMargin = this.g;
    this.f.bH.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.f.aZ.e.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    layoutParams = new FrameLayout.LayoutParams(this.g, b);
    layoutParams.topMargin = b;
    layoutParams.leftMargin = this.g * 2;
    this.f.bI.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.f.aZ.f.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    layoutParams = (FrameLayout.LayoutParams)this.f.aZ.P.getLayoutParams();
    layoutParams.gravity = 5;
    layoutParams.rightMargin = DensityUtils.a(this.e, 10.0F);
    layoutParams.topMargin = b * 2 + DensityUtils.a(this.e, 10.0F);
    this.f.aZ.P.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.f.aZ.S.removeAllViews();
    if (this.f.cu.getParent() instanceof ViewGroup)
      ((ViewGroup)this.f.cu.getParent()).removeView((View)this.f.cu); 
    ViewGroup.MarginLayoutParams marginLayoutParams1 = new ViewGroup.MarginLayoutParams(-2, -2);
    marginLayoutParams1.topMargin = DensityUtils.a(this.e, 10.0F);
    this.f.aZ.S.addView((View)this.f.cu, (ViewGroup.LayoutParams)marginLayoutParams1);
    this.f.aZ.T.removeAllViews();
    if (this.f.cr.getParent() instanceof ViewGroup)
      ((ViewGroup)this.f.cr.getParent()).removeView((View)this.f.cr); 
    ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(DensityUtils.a(this.e, 50.0F), DensityUtils.a(this.e, 50.0F));
    this.f.aZ.T.addView((View)this.f.cr, (ViewGroup.LayoutParams)marginLayoutParams2);
    this.f.aZ.U.removeAllViews();
    if (this.f.Q.getParent() instanceof ViewGroup)
      ((ViewGroup)this.f.Q.getParent()).removeView((View)this.f.Q); 
    marginLayoutParams2 = new ViewGroup.MarginLayoutParams(-2, -2);
    marginLayoutParams1.topMargin = DensityUtils.a(this.e, 10.0F);
    this.f.aZ.U.addView((View)this.f.Q, (ViewGroup.LayoutParams)marginLayoutParams2);
    this.f.bd.a(8);
    this.f.bZ.setVisibility(8);
    this.f.bE.setVisibility(0);
    this.f.bF.setVisibility(0);
    this.f.bG.setVisibility(0);
    this.f.bH.setVisibility(0);
    this.f.bI.setVisibility(0);
    this.f.aZ.a.setVisibility(0);
    this.f.aZ.g.setVisibility(0);
    this.f.aZ.h.setVisibility(0);
    this.f.aZ.i.setVisibility(0);
    this.f.aZ.j.setVisibility(0);
    this.f.aZ.k.setVisibility(0);
    this.f.aZ.l.setVisibility(8);
    this.f.aZ.m.setVisibility(8);
    this.f.aZ.n.setVisibility(8);
    this.f.aZ.o.setVisibility(8);
    this.f.aZ.p.setVisibility(8);
    this.f.aZ.v.setVisibility(8);
    this.f.aZ.w.setVisibility(8);
    this.f.aZ.x.setVisibility(8);
    this.f.aZ.y.setVisibility(8);
    this.f.aZ.z.setVisibility(8);
    this.f.aZ.F.setVisibility(8);
    this.f.aZ.G.setVisibility(8);
    this.f.aZ.H.setVisibility(8);
    this.f.aZ.I.setVisibility(8);
    this.f.aZ.J.setVisibility(8);
    if (LivePreferencesUtils.d())
      return; 
    this.f.a(new Runnable(this) {
          public void run() {
            Logger.d("NewFuncPopwindow", new Object[] { "NewFuncPopwindow create ... " });
            LivePreferencesUtils.b(true);
            RecordingMakeLoverManager.a(this.a);
          }
        }500L);
  }
  
  public void g() {}
  
  public void h() {
    if (this.a != null)
      for (int i = 0; i < this.a.size(); i++) {
        LiveMakeLoverFansModel liveMakeLoverFansModel = this.a.get(i);
        if (i == 0)
          if (!liveMakeLoverFansModel.isEmpty()) {
            this.f.aZ.g.setVisibility(8);
            this.f.aZ.F.setVisibility(0);
          } else {
            this.f.aZ.F.setVisibility(8);
            if (this.f.aZ.g.getVisibility() == 8)
              this.f.aZ.g.setVisibility(0); 
          }  
        if (i == 1)
          if (!liveMakeLoverFansModel.isEmpty()) {
            this.f.aZ.h.setVisibility(8);
            this.f.aZ.G.setVisibility(0);
          } else {
            this.f.aZ.G.setVisibility(8);
            if (this.f.aZ.h.getVisibility() == 8)
              this.f.aZ.h.setVisibility(0); 
          }  
        if (i == 2)
          if (!liveMakeLoverFansModel.isEmpty()) {
            this.f.aZ.i.setVisibility(8);
            this.f.aZ.H.setVisibility(0);
          } else {
            this.f.aZ.H.setVisibility(8);
            if (this.f.aZ.i.getVisibility() == 8)
              this.f.aZ.i.setVisibility(0); 
          }  
        if (i == 3)
          if (!liveMakeLoverFansModel.isEmpty()) {
            this.f.aZ.j.setVisibility(8);
            this.f.aZ.I.setVisibility(0);
          } else {
            this.f.aZ.I.setVisibility(8);
            if (this.f.aZ.j.getVisibility() == 8)
              this.f.aZ.j.setVisibility(0); 
          }  
        if (i == 4)
          if (!liveMakeLoverFansModel.isEmpty()) {
            this.f.aZ.k.setVisibility(8);
            this.f.aZ.J.setVisibility(0);
          } else {
            this.f.aZ.J.setVisibility(8);
            if (this.f.aZ.k.getVisibility() == 8)
              this.f.aZ.k.setVisibility(0); 
          }  
      }  
    this.f.aZ.a();
    this.f.aZ.b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\manager\RecordingMakeLoverManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */