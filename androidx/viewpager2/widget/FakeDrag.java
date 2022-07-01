package androidx.viewpager2.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;

final class FakeDrag {
  private final ViewPager2 a;
  
  private final ScrollEventAdapter b;
  
  private final RecyclerView c;
  
  private VelocityTracker d;
  
  private int e;
  
  private float f;
  
  private int g;
  
  private long h;
  
  FakeDrag(ViewPager2 paramViewPager2, ScrollEventAdapter paramScrollEventAdapter, RecyclerView paramRecyclerView) {
    this.a = paramViewPager2;
    this.b = paramScrollEventAdapter;
    this.c = paramRecyclerView;
  }
  
  private void a(long paramLong, int paramInt, float paramFloat1, float paramFloat2) {
    MotionEvent motionEvent = MotionEvent.obtain(this.h, paramLong, paramInt, paramFloat1, paramFloat2, 0);
    this.d.addMovement(motionEvent);
    motionEvent.recycle();
  }
  
  private void d() {
    VelocityTracker velocityTracker = this.d;
    if (velocityTracker == null) {
      this.d = VelocityTracker.obtain();
      this.e = ViewConfiguration.get(this.a.getContext()).getScaledMaximumFlingVelocity();
      return;
    } 
    velocityTracker.clear();
  }
  
  boolean a() {
    return this.b.g();
  }
  
  boolean a(float paramFloat) {
    float f;
    boolean bool1;
    boolean bool2;
    if (!this.b.g())
      return false; 
    this.f -= paramFloat;
    int i = Math.round(this.f - this.g);
    this.g += i;
    long l = SystemClock.uptimeMillis();
    if (this.a.getOrientation() == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (bool1) {
      bool2 = i;
    } else {
      bool2 = false;
    } 
    if (bool1)
      i = 0; 
    if (bool1) {
      paramFloat = this.f;
    } else {
      paramFloat = 0.0F;
    } 
    if (bool1) {
      f = 0.0F;
    } else {
      f = this.f;
    } 
    this.c.scrollBy(bool2, i);
    a(l, 2, paramFloat, f);
    return true;
  }
  
  boolean b() {
    if (this.b.f())
      return false; 
    this.g = 0;
    this.f = false;
    this.h = SystemClock.uptimeMillis();
    d();
    this.b.b();
    if (!this.b.e())
      this.c.stopScroll(); 
    a(this.h, 0, 0.0F, 0.0F);
    return true;
  }
  
  boolean c() {
    if (!this.b.g())
      return false; 
    this.b.c();
    VelocityTracker velocityTracker = this.d;
    velocityTracker.computeCurrentVelocity(1000, this.e);
    int i = (int)velocityTracker.getXVelocity();
    int j = (int)velocityTracker.getYVelocity();
    if (!this.c.fling(i, j))
      this.a.c(); 
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\viewpager2\widget\FakeDrag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */