package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewParent;
import androidx.core.util.Preconditions;

public final class MarginPageTransformer implements ViewPager2.PageTransformer {
  private final int a;
  
  public MarginPageTransformer(int paramInt) {
    Preconditions.checkArgumentNonnegative(paramInt, "Margin must be non-negative");
    this.a = paramInt;
  }
  
  private ViewPager2 a(View paramView) {
    ViewParent viewParent1 = paramView.getParent();
    ViewParent viewParent2 = viewParent1.getParent();
    if (viewParent1 instanceof androidx.recyclerview.widget.RecyclerView && viewParent2 instanceof ViewPager2)
      return (ViewPager2)viewParent2; 
    throw new IllegalStateException("Expected the page view to be managed by a ViewPager2 instance.");
  }
  
  public void transformPage(View paramView, float paramFloat) {
    ViewPager2 viewPager2 = a(paramView);
    float f = this.a * paramFloat;
    if (viewPager2.getOrientation() == 0) {
      paramFloat = f;
      if (viewPager2.b())
        paramFloat = -f; 
      paramView.setTranslationX(paramFloat);
      return;
    } 
    paramView.setTranslationY(f);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\viewpager2\widget\MarginPageTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */