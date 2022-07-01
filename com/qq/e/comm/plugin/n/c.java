package com.qq.e.comm.plugin.n;

import android.animation.ArgbEvaluator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.a.d.a;
import com.qq.e.comm.plugin.ac.i;
import com.qq.e.comm.plugin.ac.j;
import com.qq.e.comm.plugin.ad.g;
import com.qq.e.comm.plugin.ad.k;
import com.qq.e.comm.plugin.ad.r;
import com.qq.e.comm.plugin.p.a;
import com.qq.e.comm.plugin.p.b;
import com.qq.e.comm.plugin.p.e;
import com.qq.e.comm.plugin.s.a;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.am;
import com.qq.e.comm.plugin.util.aq;
import com.qq.e.comm.plugin.util.ar;
import com.qq.e.comm.plugin.util.b;
import com.qq.e.comm.plugin.util.g;
import com.qq.e.comm.plugin.util.q;
import com.qq.e.comm.plugin.util.y;
import com.qq.e.comm.plugin.y.u;

public class c extends RelativeLayout implements View.OnClickListener, g {
  private static int a = Color.parseColor("#333333");
  
  private static int b = Color.parseColor("#7F7F7F");
  
  private static int c = Color.parseColor("#EFF3F9");
  
  private static int d = Color.parseColor("#3171F4");
  
  private static int e = Color.parseColor("#EFF3F9");
  
  private static final int n = GDTADManager.getInstance().getSM().getInteger("mdpa_card_btn_animation_time", 3);
  
  private a f;
  
  private b.a g;
  
  private g h;
  
  private TextView i;
  
  private boolean j;
  
  private volatile boolean k;
  
  private com.qq.e.comm.plugin.y.c l;
  
  private r m;
  
  c(Context paramContext, a parama, com.qq.e.comm.plugin.y.c paramc) {
    super(paramContext);
    this.f = parama;
    this.l = paramc;
    e();
    this.m = new r(paramContext);
  }
  
  private RelativeLayout a(k paramk) {
    String str1;
    String str2;
    RelativeLayout relativeLayout = new RelativeLayout(getContext());
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
    layoutParams2.addRule(15);
    layoutParams2.addRule(1, 2131755009);
    layoutParams2.addRule(3, 2131755014);
    layoutParams2.leftMargin = am.a(getContext(), 4);
    layoutParams2.topMargin = am.a(getContext(), 12);
    layoutParams2.rightMargin = am.a(getContext(), 4);
    layoutParams2.bottomMargin = am.a(getContext(), 4);
    relativeLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    j j1 = new j(getContext());
    j1.setId(2131755014);
    j1.a(am.a(getContext(), 8));
    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(am.a(getContext(), 16), am.a(getContext(), 16));
    layoutParams4.addRule(9);
    layoutParams4.addRule(10);
    layoutParams4.leftMargin = am.a(getContext(), 8);
    if (!TextUtils.isEmpty(this.f.p())) {
      a.a().a(this.f.p(), (ImageView)j1);
    } else {
      j1.setVisibility(4);
    } 
    relativeLayout.addView((View)j1, (ViewGroup.LayoutParams)layoutParams4);
    TextView textView3 = new TextView(getContext());
    textView3.setId(2131755015);
    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams5.addRule(1, 2131755014);
    layoutParams5.leftMargin = am.a(getContext(), 4);
    textView3.setTextSize(2, 12.0F);
    textView3.setTextColor(b);
    if (this.f.v() && this.f.z() != null) {
      str2 = this.f.z().i();
    } else {
      str2 = this.f.n();
    } 
    textView3.setText(str2);
    relativeLayout.addView((View)textView3, (ViewGroup.LayoutParams)layoutParams5);
    TextView textView2 = new TextView(getContext());
    textView2.setId(2131755010);
    textView2.setTypeface(Typeface.defaultFromStyle(1));
    textView2.setLines(1);
    textView2.setEllipsize(TextUtils.TruncateAt.END);
    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams3.addRule(3, 2131755014);
    layoutParams3.addRule(0, 2131755016);
    layoutParams3.leftMargin = am.a(getContext(), 8);
    layoutParams3.topMargin = am.a(getContext(), 5);
    layoutParams3.rightMargin = am.a(getContext(), 12);
    textView2.setTextSize(2, 14.0F);
    textView2.setTextColor(a);
    if (TextUtils.isEmpty(paramk.b)) {
      textView2.setVisibility(4);
    } else {
      textView2.setText(paramk.b);
    } 
    relativeLayout.addView((View)textView2, (ViewGroup.LayoutParams)layoutParams3);
    textView2 = new TextView(getContext());
    textView2.setId(2131755013);
    textView2.setTypeface(Typeface.defaultFromStyle(1));
    textView2.setLines(1);
    textView2.setEllipsize(TextUtils.TruncateAt.END);
    layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams3.addRule(3, 2131755010);
    layoutParams3.addRule(9);
    layoutParams3.addRule(1, 2131755009);
    layoutParams3.addRule(0, 2131755016);
    layoutParams3.leftMargin = am.a(getContext(), 8);
    layoutParams3.rightMargin = am.a(getContext(), 12);
    layoutParams3.topMargin = am.a(getContext(), 1);
    textView2.setTextSize(2, 14.0F);
    textView2.setTextColor(a);
    if (TextUtils.isEmpty(paramk.e)) {
      textView2.setVisibility(4);
    } else {
      textView2.setText(paramk.e);
    } 
    relativeLayout.addView((View)textView2, (ViewGroup.LayoutParams)layoutParams3);
    String[] arrayOfString = paramk.c;
    if (arrayOfString != null) {
      TextView textView = f();
      textView.setId(2131755011);
      layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
      layoutParams5.leftMargin = am.a(getContext(), 8);
      layoutParams5.topMargin = am.a(getContext(), 6);
      layoutParams5.addRule(3, 2131755013);
      layoutParams5.addRule(9);
      if (arrayOfString.length > 0) {
        textView.setText(paramk.c[0]);
      } else {
        textView.setVisibility(8);
      } 
      relativeLayout.addView((View)textView, (ViewGroup.LayoutParams)layoutParams5);
      textView = f();
      textView.setId(2131755012);
      layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
      layoutParams5.leftMargin = am.a(getContext(), 4);
      layoutParams5.topMargin = am.a(getContext(), 6);
      layoutParams5.addRule(3, 2131755013);
      layoutParams5.addRule(1, 2131755011);
      if (arrayOfString.length > 1) {
        textView.setText(paramk.c[1]);
      } else {
        textView.setVisibility(8);
      } 
      relativeLayout.addView((View)textView, (ViewGroup.LayoutParams)layoutParams5);
    } 
    TextView textView1 = f();
    layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams3.addRule(1, 2131755012);
    layoutParams3.addRule(3, 2131755013);
    layoutParams3.leftMargin = am.a(getContext(), 4);
    layoutParams3.topMargin = am.a(getContext(), 6);
    if (TextUtils.isEmpty(paramk.d)) {
      textView1.setVisibility(8);
    } else {
      textView1.setText(paramk.d);
    } 
    relativeLayout.addView((View)textView1, (ViewGroup.LayoutParams)layoutParams3);
    int m = am.a(getContext(), 60);
    int n = am.a(getContext(), 28);
    if (b.a(getContext(), this.f) || !this.f.v()) {
      j = 1;
    } else {
      j = 0;
    } 
    if (!TextUtils.isEmpty(paramk.f) && j) {
      str1 = paramk.f;
    } else {
      str1 = "查看";
    } 
    i i = (new i.a()).a(this.f).a(am.a(getContext(), 3)).b(m).c(n).d(12).e(d).f(-1).g(d).a(new String[] { str1, str1, "下载中", "安装", str1 }).a(new a(this) {
          public void a(String param1String, int param1Int1, int param1Int2, long param1Long) {
            if (param1Int1 == 4) {
              c c1;
              boolean bool;
              if (c.a(this.a) != null) {
                c.a(this.a).setBackgroundDrawable(null);
                c1 = this.a;
                bool = true;
              } else {
                c1 = this.a;
                bool = false;
              } 
              c.a(c1, bool);
            } 
          }
        }).a(getContext());
    i.setId(2131755016);
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(m, n);
    layoutParams1.addRule(11);
    layoutParams1.addRule(15);
    layoutParams1.rightMargin = am.a(getContext(), 12);
    this.i = i.b;
    int j = d;
    GradientDrawable gradientDrawable = new GradientDrawable();
    gradientDrawable.setColor(-1);
    gradientDrawable.setCornerRadius(8);
    gradientDrawable.setStroke(3, j);
    this.i.setBackgroundDrawable((Drawable)gradientDrawable);
    relativeLayout.addView((View)i, (ViewGroup.LayoutParams)layoutParams1);
    return relativeLayout;
  }
  
  private void e() {
    String str;
    ImageView imageView;
    a a1 = this.f;
    if (a1 == null) {
      str = "init, adData null";
    } else {
      String str1;
      k k = str.ab();
      if (k == null) {
        str1 = "init, dpaData null";
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("dpaData : ");
        stringBuilder.append(str1.toString());
        ak.a("DpaCardView", stringBuilder.toString());
        d = q.b(this.f);
        j j = new j(getContext());
        j.setId(2131755009);
        j.setScaleType(ImageView.ScaleType.CENTER_CROP);
        j.setImageDrawable((Drawable)new ColorDrawable(e));
        j.a(am.a(getContext(), 5));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(am.a(getContext(), 88), am.a(getContext(), 88));
        layoutParams2.addRule(9);
        layoutParams2.addRule(3, 2131755014);
        layoutParams2.leftMargin = am.a(getContext(), 4);
        layoutParams2.topMargin = am.a(getContext(), 4);
        layoutParams2.bottomMargin = am.a(getContext(), 8);
        if (!TextUtils.isEmpty(((k)str1).a)) {
          a.a().a(((k)str1).a, (ImageView)j, new b(this) {
                public void a(String param1String, int param1Int, Exception param1Exception) {
                  ImageView imageView = new ImageView(this.a.getContext());
                  RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                  layoutParams.leftMargin = am.a(this.a.getContext(), 27);
                  layoutParams.addRule(15);
                  imageView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
                  imageView.setImageBitmap(aq.a("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"));
                  this.a.addView((View)imageView, (ViewGroup.LayoutParams)layoutParams);
                }
                
                public void a(String param1String, ImageView param1ImageView, e param1e) {}
              });
        } else {
          j.setVisibility(4);
        } 
        addView((View)j, (ViewGroup.LayoutParams)layoutParams2);
        addView((View)a((k)str1));
        imageView = new ImageView(getContext());
        imageView.setAlpha(0.6F);
        RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(am.a(getContext(), 39), am.a(getContext(), 18));
        layoutParams1.addRule(11);
        layoutParams1.addRule(12);
        g.a(imageView, this.f.C());
        addView((View)imageView, (ViewGroup.LayoutParams)layoutParams1);
        setPadding(am.a(getContext(), 4), am.a(getContext(), 4), am.a(getContext(), 0), am.a(getContext(), 0));
        setBackgroundDrawable((Drawable)ar.a(am.a(getContext(), 8), -1, 255));
        setVisibility(8);
        setOnClickListener(this);
        return;
      } 
    } 
    ak.a("DpaCardView", (String)imageView);
  }
  
  private TextView f() {
    TextView textView = new TextView(getContext());
    int i = am.a(getContext(), 2);
    int j = c;
    GradientDrawable gradientDrawable = new GradientDrawable();
    gradientDrawable.setColor(j);
    gradientDrawable.setCornerRadius(i);
    textView.setLines(1);
    textView.setMaxWidth(am.a(getContext(), 64));
    textView.setEllipsize(TextUtils.TruncateAt.END);
    textView.setBackgroundDrawable((Drawable)gradientDrawable);
    textView.setPadding(am.a(getContext(), 4), 0, am.a(getContext(), 4), 0);
    textView.setTextSize(2, 11.0F);
    textView.setTextColor(b);
    return textView;
  }
  
  private void g() {
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    Integer integer = Integer.valueOf(-1);
    ValueAnimator valueAnimator2 = ValueAnimator.ofObject((TypeEvaluator)argbEvaluator, new Object[] { integer, Integer.valueOf(d) });
    valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            if (c.b(this.a))
              return; 
            Object object = param1ValueAnimator.getAnimatedValue();
            if (object instanceof Integer) {
              int i = ((Integer)object).intValue();
              int j = c.d();
              object = new GradientDrawable();
              object.setColor(i);
              object.setCornerRadius(8);
              object.setStroke(3, j);
              if (c.a(this.a) != null)
                c.a(this.a).setBackgroundDrawable((Drawable)object); 
            } 
          }
        });
    long l = 500L;
    valueAnimator2.setDuration(l);
    valueAnimator2.setInterpolator((TimeInterpolator)new DecelerateInterpolator());
    ValueAnimator valueAnimator1 = ValueAnimator.ofObject((TypeEvaluator)new ArgbEvaluator(), new Object[] { Integer.valueOf(d), integer });
    valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            if (c.b(this.a))
              return; 
            Object object = param1ValueAnimator.getAnimatedValue();
            if (object instanceof Integer) {
              int i = ((Integer)object).intValue();
              if (c.a(this.a) != null)
                c.a(this.a).setTextColor(i); 
            } 
          }
        });
    valueAnimator1.setDuration(l);
    valueAnimator1.setInterpolator((TimeInterpolator)new DecelerateInterpolator());
    y.a(new Runnable(this, valueAnimator2, valueAnimator1) {
          public void run() {
            if (c.b(this.c))
              return; 
            this.a.start();
            this.b.start();
          }
        }(n * 1000));
  }
  
  public void a() {
    u.a(1140001, 1, this.l);
    setVisibility(0);
    TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    translateAnimation.setDuration(400L);
    startAnimation((Animation)translateAnimation);
    if (this.i != null)
      g(); 
    this.j = true;
  }
  
  public void a(ViewGroup paramViewGroup) {
    if (paramViewGroup != null)
      paramViewGroup.removeView((View)this); 
  }
  
  public void a(ViewGroup paramViewGroup, boolean paramBoolean) {
    if (getParent() == null) {
      RelativeLayout.LayoutParams layoutParams;
      if (paramBoolean) {
        layoutParams = new RelativeLayout.LayoutParams(am.a(getContext(), 359), am.a(getContext(), 104));
        layoutParams.addRule(11, -1);
        layoutParams.addRule(12, -1);
      } else {
        layoutParams = new RelativeLayout.LayoutParams(-1, am.a(getContext(), 104));
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
    this.h = paramg;
  }
  
  public void a(b.a parama) {
    this.g = parama;
  }
  
  public boolean b() {
    return this.j;
  }
  
  public void c() {
    TextView textView = this.i;
    if (textView != null) {
      textView.clearAnimation();
      this.i = null;
    } 
  }
  
  public void onClick(View paramView) {
    if (!this.m.a())
      return; 
    u.a(1140002, 1, this.l);
    b.a a1 = this.g;
    if (a1 != null)
      a1.a(); 
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    g g1 = this.h;
    if (g1 != null)
      g1.a(paramMotionEvent, true); 
    this.m.a(paramMotionEvent);
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\n\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */