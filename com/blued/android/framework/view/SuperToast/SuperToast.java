package com.blued.android.framework.view.SuperToast;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.blued.android.framework.R;
import com.blued.android.framework.view.SuperToast.utils.AccessibilityUtils;
import com.blued.android.framework.view.SuperToast.utils.BackgroundUtils;

public class SuperToast {
  private final Context a;
  
  private final View b;
  
  private final TextView c;
  
  private Style d;
  
  private OnDismissListener e;
  
  protected SuperToast(Context paramContext, int paramInt) {
    this.a = paramContext;
    this.d = new Style();
    this.d.w = paramInt;
    this.b = a(paramContext, (LayoutInflater)paramContext.getSystemService("layout_inflater"), paramInt);
    this.c = (TextView)this.b.findViewById(R.id.message);
  }
  
  public SuperToast(Context paramContext, Style paramStyle) {
    this.a = paramContext;
    this.d = paramStyle;
    this.b = a(paramContext, (LayoutInflater)paramContext.getSystemService("layout_inflater"), this.d.w);
    this.c = (TextView)this.b.findViewById(R.id.message);
  }
  
  protected SuperToast(Context paramContext, Style paramStyle, int paramInt) {
    this.a = paramContext;
    this.d = paramStyle;
    this.d.w = paramInt;
    this.b = a(paramContext, (LayoutInflater)paramContext.getSystemService("layout_inflater"), paramInt);
    this.c = (TextView)this.b.findViewById(R.id.message);
  }
  
  protected View a(Context paramContext, LayoutInflater paramLayoutInflater, int paramInt) {
    return paramLayoutInflater.inflate(R.layout.supertoast_button, null);
  }
  
  public SuperToast a(int paramInt) {
    if (paramInt > 5000) {
      Log.e(getClass().getName(), "SuperToast duration cannot exceed 4500ms.");
      this.d.b = 5000;
      return this;
    } 
    this.d.b = paramInt;
    return this;
  }
  
  public SuperToast b(int paramInt1, int paramInt2, int paramInt3) {
    Style style = this.d;
    style.g = paramInt1;
    style.h = paramInt2;
    style.i = paramInt3;
    return this;
  }
  
  protected void f() {
    int i = Build.VERSION.SDK_INT;
    TextView textView = this.c;
    if (textView != null) {
      textView.setText(this.d.a);
      textView = this.c;
      textView.setTypeface(textView.getTypeface(), this.d.q);
      this.c.setTextColor(this.d.r);
      this.c.setTextSize(this.d.s);
      if (this.d.u > 0)
        if (this.d.t == 1) {
          this.c.setCompoundDrawablesWithIntrinsicBounds(this.d.u, 0, 0, 0);
        } else if (this.d.t == 4) {
          this.c.setCompoundDrawablesWithIntrinsicBounds(0, this.d.u, 0, 0);
        } else if (this.d.t == 2) {
          this.c.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.d.u, 0);
        } else if (this.d.t == 3) {
          this.c.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, this.d.u);
        }  
    } 
    if (i >= 16) {
      View view = this.b;
      Style style = this.d;
      view.setBackground(BackgroundUtils.a(style, style.c));
      if (i >= 21)
        this.b.setElevation(3.0F); 
    } else {
      View view = this.b;
      Style style = this.d;
      view.setBackgroundDrawable(BackgroundUtils.a(style, style.c));
    } 
    if (this.d.e == 3) {
      textView = this.c;
      if (textView != null)
        textView.setGravity(8388611); 
      if (((this.a.getResources().getConfiguration()).screenLayout & 0xF) >= 3) {
        this.d.h = BackgroundUtils.b(12);
        this.d.i = BackgroundUtils.b(12);
        this.d.j = BackgroundUtils.b(288);
        this.d.g = 8388691;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(BackgroundUtils.b(2));
        gradientDrawable.setColor(this.d.c);
        if (i >= 16) {
          this.b.setBackground((Drawable)gradientDrawable);
        } else {
          this.b.setBackgroundDrawable((Drawable)gradientDrawable);
        } 
      } else {
        Style style = this.d;
        style.i = 0;
        style.j = -1;
      } 
      if (this.d.d != 0) {
        this.b.findViewById(R.id.border).setVisibility(0);
        this.b.findViewById(R.id.border).setBackgroundColor(this.d.d);
      } 
    } 
    (j()).o = System.currentTimeMillis();
  }
  
  public int h() {
    return this.d.b;
  }
  
  public OnDismissListener i() {
    return this.e;
  }
  
  public Style j() {
    return this.d;
  }
  
  public Context k() {
    return this.a;
  }
  
  public View l() {
    return this.b;
  }
  
  public boolean m() {
    View view = this.b;
    return (view != null && view.isShown());
  }
  
  protected WindowManager.LayoutParams n() {
    WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
    layoutParams.height = this.d.k;
    layoutParams.width = this.d.j;
    layoutParams.flags = 152;
    layoutParams.format = -3;
    layoutParams.windowAnimations = 16973826;
    layoutParams.type = 2005;
    layoutParams.gravity = this.d.g;
    layoutParams.x = 0;
    layoutParams.y = 0;
    return layoutParams;
  }
  
  public void o() {
    f();
    Toaster.a().a(this);
    AccessibilityUtils.a(this.b);
  }
  
  public void p() {
    Toaster.a().b(this);
  }
  
  public static interface OnDismissListener {
    void a(View param1View, Parcelable param1Parcelable);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\SuperToast\SuperToast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */