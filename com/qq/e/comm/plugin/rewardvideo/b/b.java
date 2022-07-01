package com.qq.e.comm.plugin.rewardvideo.b;

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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qq.e.comm.plugin.util.am;
import com.qq.e.comm.plugin.util.aq;
import com.qq.e.comm.plugin.util.g;

public class b extends RelativeLayout {
  private TextView a;
  
  private ProgressBar b;
  
  private ImageView c;
  
  public b(Context paramContext) {
    super(paramContext);
    a(paramContext);
  }
  
  private void a(Context paramContext) {
    LinearLayout linearLayout = new LinearLayout(paramContext);
    linearLayout.setOrientation(0);
    addView((View)linearLayout, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    int i = am.a(paramContext, 14);
    linearLayout.setPadding(i, 0, i, 0);
    this.c = new ImageView(paramContext);
    this.c.setImageBitmap(aq.a("iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAMAAACdt4HsAAAAbFBMVEUAAAAAAAD////p6eknJyf/\n//8MDAz///////8REREbGxs9PT11dXWlpaX39/f///////////////9qamoZGRksLCxQUFBkZGSL\ni4u/v7/Z2dny8vL///////////////////////////////8d9apUAAAAI3RSTlOAAE3qikd6JQV3\nc2hbVE5AKx4RoYZtY15YUVBORD48MhoKNpZmpn4AAAHhSURBVFjDpZfbloIwDEXPVFsoFwW830H/\n/x+HRMYRIQIr54EHl2eTNiVN8CMoLIPb5WyNsefLLShD6X/9gCJbmg8ts2IsIAwad4cRhIMAslsj\nyhLiOyB/2Q/JduMd4PxmmxxeiPwroLoa1iKNHVpycbowrGslAwr7tCcOPXLJE2ELCZAb1t5DkN8b\nVt4PyAwpjfBFUWpIWR/gbkg7DGhnSPcugN9/ijGo+NSKAe/rP0YYoejI+9AGFOz3GCXPhOIdUFmK\nP8JIRbQKW70B+PzEGK2YT9Q/IBf2fyAX+R8gtJR/TFJKiwgbQEC4CJMUkScgQBPAHhO1b0LAM4CF\nx0T5BYXAAKo/CVpardHReoWWEqpRBCgoANf2P2ZzfGg+e7QJjkIoakDWTcF6RoRP/2zdTURWA5Y9\nZ2hOBPGHRjGvASHlw0EiyH44coYoqX4CEkH2A1RpSwScA5kg+zkPAW71cwuZIPuxra03XOrnBjJB\n9mNTWy84108PmSD74WvrGZaTIBNkP6fBgnIByATZD/aqAeolqDdRnUb1QVIfZfXHpP6ctQVFXdLU\nRVVb1tUXi/pq016u6utd22BoWxx1k6Vt87SNprbVVTfb+nZfP3DoRx790KUf+/SDp3701Q/f6vH/\nFzOPJ4ULw0zxAAAAAElFTkSuQmCC\n"));
    this.c.setScaleType(ImageView.ScaleType.FIT_CENTER);
    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(am.a(paramContext, 30), am.a(paramContext, 30));
    layoutParams4.rightMargin = am.a(paramContext, 7);
    layoutParams4.gravity = 16;
    this.c.setVisibility(8);
    linearLayout.addView((View)this.c, (ViewGroup.LayoutParams)layoutParams4);
    View view = new View(paramContext);
    view.setId(-1894776829);
    view.setBackgroundColor(Color.parseColor("#ffe4e5e7"));
    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, (int)TypedValue.applyDimension(1, 0.67F, getResources().getDisplayMetrics()));
    layoutParams5.addRule(12, -1);
    layoutParams5.addRule(6, -1894776828);
    view.setLayoutParams((ViewGroup.LayoutParams)layoutParams5);
    addView(view);
    this.b = new ProgressBar(paramContext, null, 16842872);
    this.b.setId(-1894776828);
    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int)TypedValue.applyDimension(1, 1.34F, getResources().getDisplayMetrics()));
    layoutParams3.addRule(12, -1);
    this.b.setLayoutParams((ViewGroup.LayoutParams)layoutParams3);
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
    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
    layoutParams2.gravity = 16;
    layoutParams2.weight = 1.0E-6F;
    this.a.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    this.a.setTextSize(2, 15.33F);
    this.a.setTextColor(-1);
    this.a.setSingleLine();
    this.a.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
    linearLayout.addView((View)this.a, (ViewGroup.LayoutParams)layoutParams2);
    ImageView imageView = new ImageView(paramContext);
    LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(am.a(paramContext, 40), am.a(paramContext, 14));
    layoutParams1.gravity = 21;
    linearLayout.addView((View)imageView, (ViewGroup.LayoutParams)layoutParams1);
    g.a(imageView);
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
  
  public ImageView a() {
    return this.c;
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
  
  public void b() {
    if (this.b.getVisibility() == 0) {
      this.b.setVisibility(8);
      this.b.setProgress(0);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\rewardvideo\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */