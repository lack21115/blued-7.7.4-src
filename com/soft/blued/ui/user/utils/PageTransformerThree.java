package com.soft.blued.ui.user.utils;

import android.os.Build;
import android.view.View;
import androidx.viewpager.widget.ViewPager;

public class PageTransformerThree implements ViewPager.PageTransformer {
  private float a = 0.1F;
  
  public void transformPage(View paramView, float paramFloat) {
    paramView.setTranslationX((int)(paramView.getWidth() * this.a));
    if (Build.VERSION.SDK_INT < 19)
      paramView.getParent().requestLayout(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\use\\utils\PageTransformerThree.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */