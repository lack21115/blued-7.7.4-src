package androidx.viewpager2.widget;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.Locale;

final class PageTransformerAdapter extends ViewPager2.OnPageChangeCallback {
  private final LinearLayoutManager a;
  
  private ViewPager2.PageTransformer b;
  
  PageTransformerAdapter(LinearLayoutManager paramLinearLayoutManager) {
    this.a = paramLinearLayoutManager;
  }
  
  ViewPager2.PageTransformer a() {
    return this.b;
  }
  
  void a(ViewPager2.PageTransformer paramPageTransformer) {
    this.b = paramPageTransformer;
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {
    if (this.b == null)
      return; 
    paramFloat = -paramFloat;
    paramInt2 = 0;
    while (paramInt2 < this.a.getChildCount()) {
      View view = this.a.getChildAt(paramInt2);
      if (view != null) {
        float f = (this.a.getPosition(view) - paramInt1);
        this.b.transformPage(view, f + paramFloat);
        paramInt2++;
        continue;
      } 
      throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(this.a.getChildCount()) }));
    } 
  }
  
  public void onPageSelected(int paramInt) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\viewpager2\widget\PageTransformerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */