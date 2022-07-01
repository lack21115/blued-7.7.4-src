package com.qq.e.comm.plugin.n;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qq.e.comm.plugin.ac.i;
import com.qq.e.comm.plugin.ac.j;
import com.qq.e.comm.plugin.ad.g;
import com.qq.e.comm.plugin.ad.r;
import com.qq.e.comm.plugin.p.e;
import com.qq.e.comm.plugin.util.am;
import com.qq.e.comm.plugin.util.ar;
import com.qq.e.comm.plugin.util.g;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.plugin.y.d;
import com.qq.e.comm.plugin.y.g;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;

public class b extends RelativeLayout implements View.OnClickListener, g {
  private com.qq.e.comm.plugin.s.a a;
  
  private a b;
  
  private g c;
  
  private boolean d = false;
  
  private boolean e;
  
  private r f;
  
  b(Context paramContext, com.qq.e.comm.plugin.s.a parama) {
    super(paramContext);
    this.a = parama;
    d();
    this.f = new r(paramContext);
  }
  
  private void d() {
    boolean bool;
    String str2;
    String str1;
    String[] arrayOfString;
    if (this.a == null)
      this.d = true; 
    setBackgroundDrawable((Drawable)ar.a(am.a(getContext(), 15), -1, 240));
    j j2 = new j(getContext());
    j2.a(am.a(getContext(), 15));
    j2.setId(2131755010);
    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(am.a(getContext(), 56), am.a(getContext(), 56));
    layoutParams3.addRule(15, -1);
    layoutParams3.addRule(9, -1);
    layoutParams3.leftMargin = am.a(getContext(), 11);
    layoutParams3.rightMargin = am.a(getContext(), 7);
    c c = e();
    d d = new d();
    d.a("url", this.a.p());
    long l = System.currentTimeMillis();
    com.qq.e.comm.plugin.p.a.a().a(this.a.p(), (ImageView)j2, new com.qq.e.comm.plugin.p.b(this, c, d, l) {
          public void a(String param1String, int param1Int, Exception param1Exception) {
            u.a(1130006, param1Int, this.a, this.b);
          }
          
          public void a(String param1String, ImageView param1ImageView, e param1e) {
            u.a(1130007, 0, this.a, this.b);
            g g = (new g(2030011)).b(System.currentTimeMillis() - this.c);
            g.a(this.a);
            u.a(g);
          }
        });
    addView((View)j2, (ViewGroup.LayoutParams)layoutParams3);
    TextView textView2 = new TextView(getContext());
    textView2.setTextColor(-16777216);
    textView2.setTextSize(2, 16.0F);
    textView2.setTypeface(Typeface.defaultFromStyle(1));
    textView2.setId(2131755011);
    textView2.setSingleLine(true);
    textView2.setEllipsize(TextUtils.TruncateAt.END);
    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams4.addRule(1, 2131755010);
    layoutParams4.addRule(0, 2131755012);
    layoutParams4.addRule(6, 2131755010);
    layoutParams4.topMargin = am.a(getContext(), 5);
    if (this.a.v() && this.a.z() != null) {
      str2 = this.a.z().i();
    } else {
      str2 = this.a.n();
    } 
    textView2.setText(str2);
    addView((View)textView2, (ViewGroup.LayoutParams)layoutParams4);
    TextView textView1 = new TextView(getContext());
    textView1.setTextColor(-16777216);
    textView1.setTextSize(2, 14.0F);
    textView1.setSingleLine(true);
    textView1.setEllipsize(TextUtils.TruncateAt.END);
    textView1.setText(this.a.i());
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams2.addRule(1, 2131755010);
    layoutParams2.addRule(0, 2131755012);
    layoutParams2.addRule(3, 2131755011);
    layoutParams2.topMargin = am.a(getContext(), 5);
    addView((View)textView1, (ViewGroup.LayoutParams)layoutParams2);
    j j1 = new j(getContext());
    j1.a(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, am.a(getContext(), 15), am.a(getContext(), 15), 0.0F, 0.0F });
    layoutParams2 = new RelativeLayout.LayoutParams(am.a(getContext(), 39), am.a(getContext(), 18));
    layoutParams2.addRule(11, -1);
    layoutParams2.addRule(12, -1);
    g.a((ImageView)j1, this.a.C());
    addView((View)j1, (ViewGroup.LayoutParams)layoutParams2);
    int i = am.a(getContext(), 82);
    int j = am.a(getContext(), 32);
    if (com.qq.e.comm.plugin.util.b.a(getContext(), this.a) || !this.a.v()) {
      bool = true;
    } else {
      bool = false;
    } 
    String str3 = this.a.ad();
    if (!TextUtils.isEmpty(str3) && bool) {
      str1 = str3;
    } else {
      str1 = "查看";
    } 
    if (!TextUtils.isEmpty(str3) && bool) {
      String[] arrayOfString1 = new String[5];
      arrayOfString1[0] = str1;
      arrayOfString1[1] = str1;
      arrayOfString1[2] = "下载中";
      arrayOfString1[3] = "安装";
      arrayOfString1[4] = str1;
      arrayOfString = arrayOfString1;
    } else {
      arrayOfString = new String[] { "打开", "下载", "下载中", "安装", "打开" };
    } 
    i i1 = (new i.a()).a(this.a).b(i).c(j).d(16).e(-1).f(-1).a(j / 2).a(arrayOfString).a(getContext());
    i1.setId(2131755012);
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(i, j);
    layoutParams1.addRule(11, -1);
    layoutParams1.addRule(15, -1);
    layoutParams1.rightMargin = am.a(getContext(), 10);
    layoutParams1.leftMargin = am.a(getContext(), 7);
    addView((View)i1, (ViewGroup.LayoutParams)layoutParams1);
    setOnClickListener(this);
    setVisibility(8);
  }
  
  private c e() {
    c c = new c();
    c.b(this.a.m());
    c.a(this.a.B());
    c.c(this.a.H());
    return c;
  }
  
  public void a() {
    if (this.d) {
      GDTLogger.d("BottomCard show, data exception!");
      return;
    } 
    setVisibility(0);
    TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    translateAnimation.setDuration(400L);
    startAnimation((Animation)translateAnimation);
    this.e = true;
  }
  
  public void a(ViewGroup paramViewGroup) {
    if (paramViewGroup != null)
      paramViewGroup.removeView((View)this); 
  }
  
  public void a(ViewGroup paramViewGroup, boolean paramBoolean) {
    if (getParent() == null) {
      RelativeLayout.LayoutParams layoutParams;
      if (paramBoolean) {
        layoutParams = new RelativeLayout.LayoutParams(am.a(getContext(), 358), am.a(getContext(), 80));
        layoutParams.addRule(11, -1);
        layoutParams.addRule(12, -1);
      } else {
        layoutParams = new RelativeLayout.LayoutParams(-1, am.a(getContext(), 80));
        layoutParams.addRule(12, -1);
        layoutParams.addRule(14, -1);
        layoutParams.leftMargin = am.a(getContext(), 8);
      } 
      layoutParams.bottomMargin = am.a(getContext(), 8);
      layoutParams.rightMargin = am.a(getContext(), 8);
      paramViewGroup.addView((View)this, (ViewGroup.LayoutParams)layoutParams);
    } 
  }
  
  public void a(g paramg) {
    this.c = paramg;
  }
  
  public void a(a parama) {
    this.b = parama;
  }
  
  public boolean b() {
    return this.e;
  }
  
  public void c() {
    clearAnimation();
  }
  
  public void onClick(View paramView) {
    if (!this.f.a())
      return; 
    a a1 = this.b;
    if (a1 != null)
      a1.a(); 
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    g g1 = this.c;
    if (g1 != null)
      g1.a(paramMotionEvent, true); 
    this.f.a(paramMotionEvent);
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public static interface a {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\n\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */