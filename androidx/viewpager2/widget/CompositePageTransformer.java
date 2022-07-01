package androidx.viewpager2.widget;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class CompositePageTransformer implements ViewPager2.PageTransformer {
  private final List<ViewPager2.PageTransformer> a = new ArrayList<ViewPager2.PageTransformer>();
  
  public void addTransformer(ViewPager2.PageTransformer paramPageTransformer) {
    this.a.add(paramPageTransformer);
  }
  
  public void removeTransformer(ViewPager2.PageTransformer paramPageTransformer) {
    this.a.remove(paramPageTransformer);
  }
  
  public void transformPage(View paramView, float paramFloat) {
    Iterator<ViewPager2.PageTransformer> iterator = this.a.iterator();
    while (iterator.hasNext())
      ((ViewPager2.PageTransformer)iterator.next()).transformPage(paramView, paramFloat); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\viewpager2\widget\CompositePageTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */