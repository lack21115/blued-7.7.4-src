package com.bytedance.sdk.openadsdk.component.banner;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.core.d.k;

class c extends FrameLayout {
  private ImageView a;
  
  private final Context b;
  
  private k c;
  
  public c(Context paramContext) {
    super(paramContext);
    this.b = paramContext;
    c();
  }
  
  private void c() {
    this.a = new ImageView(this.b);
    this.a.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    this.a.setScaleType(ImageView.ScaleType.FIT_XY);
    addView((View)this.a);
  }
  
  k a() {
    return this.c;
  }
  
  void a(Bitmap paramBitmap) {
    this.a.setImageBitmap(paramBitmap);
  }
  
  void a(k paramk) {
    this.c = paramk;
  }
  
  void b() {
    this.a.setImageBitmap(null);
    setOnClickListener(null);
    this.c = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\component\banner\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */