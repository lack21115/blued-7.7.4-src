package com.qq.e.comm.plugin.q;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class b extends FrameLayout {
  private TextView a;
  
  private ProgressBar b;
  
  private a c;
  
  public b(Context paramContext) {
    super(paramContext);
    a(paramContext);
  }
  
  private void a(Context paramContext) {
    this.c = new a(paramContext);
    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int)TypedValue.applyDimension(1, 29.0F, getResources().getDisplayMetrics()), (int)TypedValue.applyDimension(1, 35.0F, getResources().getDisplayMetrics()));
    this.c.a(Color.parseColor("#2a2d33"));
    this.c.a(TypedValue.applyDimension(1, 2.0F, getResources().getDisplayMetrics()));
    layoutParams3.gravity = 19;
    layoutParams3.leftMargin = (int)TypedValue.applyDimension(1, 7.0F, getResources().getDisplayMetrics());
    this.c.setLayoutParams((ViewGroup.LayoutParams)layoutParams3);
    int i = (int)TypedValue.applyDimension(1, 10.0F, getResources().getDisplayMetrics());
    this.c.setPadding(i, i, i, i);
    addView(this.c);
    View view = new View(paramContext);
    view.setBackgroundColor(Color.parseColor("#ffe4e5e7"));
    FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, (int)TypedValue.applyDimension(1, 0.67F, getResources().getDisplayMetrics()));
    layoutParams4.gravity = 80;
    view.setLayoutParams((ViewGroup.LayoutParams)layoutParams4);
    addView(view);
    this.b = new ProgressBar(paramContext, null, 16842872);
    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int)TypedValue.applyDimension(1, 1.34F, getResources().getDisplayMetrics()));
    layoutParams2.gravity = 80;
    this.b.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    this.b.setMax(100);
    ClipDrawable clipDrawable1 = new ClipDrawable((Drawable)new ColorDrawable(0), 3, 1);
    ClipDrawable clipDrawable2 = new ClipDrawable((Drawable)new ColorDrawable(Color.parseColor("#ff008de8")), 3, 1);
    clipDrawable1.setLevel(10000);
    LayerDrawable layerDrawable = new LayerDrawable(new Drawable[] { (Drawable)clipDrawable1, (Drawable)clipDrawable2, (Drawable)clipDrawable2 });
    layerDrawable.setId(0, 16908288);
    layerDrawable.setId(1, 16908303);
    layerDrawable.setId(2, 16908301);
    this.b.setProgressDrawable((Drawable)layerDrawable);
    addView((View)this.b);
    this.a = new TextView(paramContext);
    i = (int)TypedValue.applyDimension(1, 55.0F, getResources().getDisplayMetrics());
    FrameLayout.LayoutParams layoutParams1 = new FrameLayout.LayoutParams(-2, -2);
    layoutParams1.gravity = 17;
    layoutParams1.leftMargin = i;
    layoutParams1.rightMargin = i;
    this.a.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    this.a.setTextSize(2, 15.33F);
    this.a.setTextColor(Color.parseColor("#ff2a2d33"));
    this.a.setSingleLine();
    this.a.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
    addView((View)this.a);
  }
  
  private void b(int paramInt) {
    int i;
    ProgressBar progressBar = this.b;
    if (paramInt < 0) {
      i = 0;
    } else {
      i = paramInt;
      if (paramInt > 100)
        i = 100; 
    } 
    progressBar.setProgress(i);
  }
  
  public void a() {
    if (this.b.getVisibility() == 0) {
      this.b.setVisibility(8);
      this.b.setProgress(0);
    } 
  }
  
  public void a(int paramInt) {
    if (this.b.getVisibility() != 0)
      this.b.setVisibility(0); 
    b(paramInt);
  }
  
  public void a(View.OnClickListener paramOnClickListener) {
    this.c.setClickable(true);
    this.c.setOnClickListener(paramOnClickListener);
  }
  
  public void a(String paramString) {
    this.a.setText(paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\q\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */