package com.qq.e.comm.plugin.rewardvideo.b;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.aa.b.f;
import com.qq.e.comm.plugin.ab.d.a;
import com.qq.e.comm.plugin.ab.d.e;
import com.qq.e.comm.plugin.ac.b;
import com.qq.e.comm.plugin.ac.k;
import com.qq.e.comm.plugin.ad.g;
import com.qq.e.comm.plugin.rewardvideo.d;
import com.qq.e.comm.plugin.rewardvideo.n;
import com.qq.e.comm.plugin.util.am;
import com.qq.e.comm.plugin.util.aq;

public class c extends FrameLayout {
  private final f a;
  
  private final ImageView b;
  
  private final b c;
  
  private k d;
  
  private final ImageView e;
  
  private final ImageView f;
  
  private TextView g;
  
  private a h;
  
  private RelativeLayout i;
  
  private boolean j;
  
  private g k;
  
  public c(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, d paramd, g paramg) {
    super(paramContext);
    String str;
    int i;
    this.k = paramg;
    this.i = new RelativeLayout(paramContext);
    addView((View)this.i, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    this.a = new f(paramContext);
    this.a.setId(2131755010);
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
    layoutParams2.addRule(13, -1);
    this.i.addView((View)this.a, (ViewGroup.LayoutParams)layoutParams2);
    this.b = new ImageView(paramContext);
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
    layoutParams.gravity = 17;
    addView((View)this.b, (ViewGroup.LayoutParams)layoutParams);
    if (paramBoolean2) {
      this.h = (new e(paramContext, null)).a();
      this.h.b().setBackgroundColor(0);
      this.i.addView(this.h.b(), (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    } 
    if (paramd != null && !paramBoolean1 && paramd.P() < paramd.Q() && GDTADManager.getInstance().getSM().getInteger("rewardVideoPortraitAlignTop", 1) == 1) {
      i = 1;
    } else {
      i = 0;
    } 
    this.c = new b(paramContext);
    this.c.setId(2131755009);
    this.c.a(am.a(paramContext, 2));
    this.c.a(Color.argb(77, 255, 255, 255));
    this.c.b(-1);
    this.c.c(Color.argb(128, 0, 0, 0));
    this.c.b(am.a(paramContext, 14));
    this.e = new ImageView(paramContext);
    this.e.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.e.setVisibility(8);
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(am.a(paramContext, 30), am.a(paramContext, 30));
    layoutParams1.addRule(11, -1);
    layoutParams1.rightMargin = am.a(paramContext, 20);
    if (i) {
      layoutParams1.addRule(6, 2131755010);
    } else {
      layoutParams1.addRule(10, -1);
      layoutParams1.topMargin = am.a(paramContext, 15);
    } 
    this.i.addView((View)this.c, (ViewGroup.LayoutParams)layoutParams1);
    layoutParams1 = new RelativeLayout.LayoutParams(am.a(paramContext, 30), am.a(paramContext, 30));
    layoutParams1.addRule(0, 2131755009);
    layoutParams1.rightMargin = am.a(paramContext, 20);
    if (i) {
      layoutParams1.addRule(6, 2131755010);
    } else {
      layoutParams1.addRule(10, -1);
      layoutParams1.topMargin = am.a(paramContext, 15);
    } 
    this.i.addView((View)this.e, (ViewGroup.LayoutParams)layoutParams1);
    this.f = new ImageView(paramContext);
    this.f.setId(2131755011);
    this.f.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.f.setImageBitmap(aq.a("iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAMAAACdt4HsAAAAbFBMVEUAAAAAAAD////p6eknJyf/\n//8MDAz///////8REREbGxs9PT11dXWlpaX39/f///////////////9qamoZGRksLCxQUFBkZGSL\ni4u/v7/Z2dny8vL///////////////////////////////8d9apUAAAAI3RSTlOAAE3qikd6JQV3\nc2hbVE5AKx4RoYZtY15YUVBORD48MhoKNpZmpn4AAAHhSURBVFjDpZfbloIwDEXPVFsoFwW830H/\n/x+HRMYRIQIr54EHl2eTNiVN8CMoLIPb5WyNsefLLShD6X/9gCJbmg8ts2IsIAwad4cRhIMAslsj\nyhLiOyB/2Q/JduMd4PxmmxxeiPwroLoa1iKNHVpycbowrGslAwr7tCcOPXLJE2ELCZAb1t5DkN8b\nVt4PyAwpjfBFUWpIWR/gbkg7DGhnSPcugN9/ijGo+NSKAe/rP0YYoejI+9AGFOz3GCXPhOIdUFmK\nP8JIRbQKW70B+PzEGK2YT9Q/IBf2fyAX+R8gtJR/TFJKiwgbQEC4CJMUkScgQBPAHhO1b0LAM4CF\nx0T5BYXAAKo/CVpardHReoWWEqpRBCgoANf2P2ZzfGg+e7QJjkIoakDWTcF6RoRP/2zdTURWA5Y9\nZ2hOBPGHRjGvASHlw0EiyH44coYoqX4CEkH2A1RpSwScA5kg+zkPAW71cwuZIPuxra03XOrnBjJB\n9mNTWy84108PmSD74WvrGZaTIBNkP6fBgnIByATZD/aqAeolqDdRnUb1QVIfZfXHpP6ctQVFXdLU\nRVVb1tUXi/pq016u6utd22BoWxx1k6Vt87SNprbVVTfb+nZfP3DoRx790KUf+/SDp3701Q/f6vH/\nFzOPJ4ULw0zxAAAAAElFTkSuQmCC\n"));
    layoutParams1 = new RelativeLayout.LayoutParams(am.a(paramContext, 30), am.a(paramContext, 30));
    layoutParams1.addRule(9, -1);
    layoutParams1.leftMargin = am.a(paramContext, 20);
    if (i) {
      layoutParams1.addRule(6, 2131755010);
    } else {
      layoutParams1.addRule(10, -1);
      layoutParams1.topMargin = am.a(paramContext, 15);
    } 
    this.i.addView((View)this.f, (ViewGroup.LayoutParams)layoutParams1);
    if (paramd == null) {
      str = "";
    } else {
      str = paramd.B();
    } 
    this.j = n.c(str);
    if (this.j) {
      this.g = new TextView(getContext());
      this.g.setTextSize(12.0F);
      this.g.setTextColor(-1);
      RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
      layoutParams3.addRule(1, 2131755011);
      layoutParams3.leftMargin = 20;
      if (i) {
        layoutParams3.addRule(6, 2131755010);
      } else {
        layoutParams3.addRule(10, -1);
        layoutParams3.topMargin = am.a(paramContext, 15);
      } 
      this.g.setLayoutParams((ViewGroup.LayoutParams)layoutParams3);
      this.g.setPadding(am.a(paramContext, 7), am.a(paramContext, 7), am.a(paramContext, 7), am.a(paramContext, 7));
      i = Color.parseColor("#48FFFFFF");
      int j = Color.parseColor("#80000000");
      GradientDrawable gradientDrawable = new GradientDrawable();
      gradientDrawable.setColor(j);
      gradientDrawable.setCornerRadius(54);
      gradientDrawable.setStroke(5, i);
      this.g.setBackgroundDrawable((Drawable)gradientDrawable);
      this.i.addView((View)this.g);
    } 
    a(paramd);
  }
  
  private void a(d paramd) {
    if (paramd != null) {
      if (TextUtils.isEmpty(paramd.ac()))
        return; 
      this.d = new k(getContext(), paramd.ac(), this.k);
    } 
  }
  
  public int a(Context paramContext) {
    return 45;
  }
  
  public ImageView a() {
    return this.e;
  }
  
  public void a(ViewGroup paramViewGroup) {
    if (getParent() == null)
      paramViewGroup.addView((View)this, new ViewGroup.LayoutParams(-1, -1)); 
  }
  
  public ImageView b() {
    return this.f;
  }
  
  public f c() {
    return this.a;
  }
  
  public ImageView d() {
    return this.b;
  }
  
  public b e() {
    return this.c;
  }
  
  public a f() {
    return this.h;
  }
  
  public TextView g() {
    return this.j ? this.g : null;
  }
  
  public k h() {
    return this.d;
  }
  
  public void i() {
    this.i.setVisibility(4);
  }
  
  public void j() {
    this.i.setVisibility(0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\rewardvideo\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */