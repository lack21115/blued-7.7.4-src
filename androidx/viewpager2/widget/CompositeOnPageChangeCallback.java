package androidx.viewpager2.widget;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

final class CompositeOnPageChangeCallback extends ViewPager2.OnPageChangeCallback {
  private final List<ViewPager2.OnPageChangeCallback> a;
  
  CompositeOnPageChangeCallback(int paramInt) {
    this.a = new ArrayList<ViewPager2.OnPageChangeCallback>(paramInt);
  }
  
  private void a(ConcurrentModificationException paramConcurrentModificationException) {
    throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", paramConcurrentModificationException);
  }
  
  void a(ViewPager2.OnPageChangeCallback paramOnPageChangeCallback) {
    this.a.add(paramOnPageChangeCallback);
  }
  
  void b(ViewPager2.OnPageChangeCallback paramOnPageChangeCallback) {
    this.a.remove(paramOnPageChangeCallback);
  }
  
  public void onPageScrollStateChanged(int paramInt) {
    try {
      Iterator<ViewPager2.OnPageChangeCallback> iterator = this.a.iterator();
      while (iterator.hasNext())
        ((ViewPager2.OnPageChangeCallback)iterator.next()).onPageScrollStateChanged(paramInt); 
    } catch (ConcurrentModificationException concurrentModificationException) {
      a(concurrentModificationException);
    } 
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {
    try {
      Iterator<ViewPager2.OnPageChangeCallback> iterator = this.a.iterator();
      while (iterator.hasNext())
        ((ViewPager2.OnPageChangeCallback)iterator.next()).onPageScrolled(paramInt1, paramFloat, paramInt2); 
    } catch (ConcurrentModificationException concurrentModificationException) {
      a(concurrentModificationException);
    } 
  }
  
  public void onPageSelected(int paramInt) {
    try {
      Iterator<ViewPager2.OnPageChangeCallback> iterator = this.a.iterator();
      while (iterator.hasNext())
        ((ViewPager2.OnPageChangeCallback)iterator.next()).onPageSelected(paramInt); 
    } catch (ConcurrentModificationException concurrentModificationException) {
      a(concurrentModificationException);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\viewpager2\widget\CompositeOnPageChangeCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */