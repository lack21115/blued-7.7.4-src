package com.blued.android.framework.ui.xpop.animator;

import android.animation.FloatEvaluator;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.util.XPopupUtils;

public class BlurAnimator extends PopupAnimator {
  public Bitmap a;
  
  public boolean b = false;
  
  private FloatEvaluator e = new FloatEvaluator();
  
  public BlurAnimator() {}
  
  public BlurAnimator(View paramView) {
    super(paramView);
  }
  
  public void a() {
    Bitmap bitmap = XPopupUtils.a(this.c.getContext(), this.a, 25.0F, true);
    BitmapDrawable bitmapDrawable = new BitmapDrawable(this.c.getResources(), bitmap);
    if (this.b)
      bitmapDrawable.setColorFilter(XPopup.a(), PorterDuff.Mode.SRC_OVER); 
    this.c.setBackground((Drawable)bitmapDrawable);
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\ui\xpop\animator\BlurAnimator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */