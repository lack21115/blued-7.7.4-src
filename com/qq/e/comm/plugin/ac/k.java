package com.qq.e.comm.plugin.ac;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qq.e.comm.plugin.ad.g;
import com.qq.e.comm.plugin.ad.r;
import com.qq.e.comm.plugin.p.a;
import com.qq.e.comm.plugin.util.am;

public class k extends ImageView implements View.OnClickListener {
  private String a;
  
  private g b;
  
  private r c;
  
  private View.OnClickListener d;
  
  public k(Context paramContext, String paramString, g paramg) {
    super(paramContext);
    this.a = paramString;
    this.b = paramg;
    this.c = new r(getContext());
    setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    setOnClickListener(this);
    setVisibility(8);
  }
  
  public void a() {
    setVisibility(8);
  }
  
  public void a(int paramInt1, int paramInt2, ViewGroup paramViewGroup) {
    if (paramViewGroup == null)
      return; 
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(am.a(getContext(), 112), am.a(getContext(), 90));
    layoutParams.topMargin = am.a(getContext(), paramInt2 - 90);
    layoutParams.leftMargin = am.a(getContext(), paramInt1);
    paramViewGroup.addView((View)this, (ViewGroup.LayoutParams)layoutParams);
    a.a().a(this.a, this);
    setVisibility(0);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean) {
    Context context = getContext();
    if (context instanceof Activity) {
      ViewGroup viewGroup = (ViewGroup)((Activity)context).getWindow().getDecorView();
      FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(am.a(getContext(), 112), am.a(getContext(), 90));
      layoutParams.topMargin = am.a(getContext(), paramInt2 - 90);
      layoutParams.leftMargin = am.a(getContext(), paramInt1);
      viewGroup.addView((View)this, (ViewGroup.LayoutParams)layoutParams);
      a.a().a(this.a, this);
    } 
    setVisibility(0);
  }
  
  public void a(View.OnClickListener paramOnClickListener) {
    this.d = paramOnClickListener;
    a(paramOnClickListener, (r)null);
  }
  
  public void a(View.OnClickListener paramOnClickListener, r paramr) {
    this.d = paramOnClickListener;
    if (paramr != null)
      this.c = paramr; 
  }
  
  public void onClick(View paramView) {
    if (this.d != null && this.c.a())
      this.d.onClick(paramView); 
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    g g1 = this.b;
    if (g1 != null)
      g1.a(paramMotionEvent, true); 
    this.c.a(paramMotionEvent);
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ac\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */