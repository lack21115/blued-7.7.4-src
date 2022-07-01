package androidx.recyclerview.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public abstract class SnapHelper extends RecyclerView.OnFlingListener {
  RecyclerView a;
  
  private Scroller b;
  
  private final RecyclerView.OnScrollListener c = new RecyclerView.OnScrollListener(this) {
      boolean a = false;
      
      public void onScrollStateChanged(RecyclerView param1RecyclerView, int param1Int) {
        super.onScrollStateChanged(param1RecyclerView, param1Int);
        if (param1Int == 0 && this.a) {
          this.a = false;
          this.b.a();
        } 
      }
      
      public void onScrolled(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {
        if (param1Int1 != 0 || param1Int2 != 0)
          this.a = true; 
      }
    };
  
  private boolean a(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2) {
    if (!(paramLayoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider))
      return false; 
    RecyclerView.SmoothScroller smoothScroller = b(paramLayoutManager);
    if (smoothScroller == null)
      return false; 
    paramInt1 = findTargetSnapPosition(paramLayoutManager, paramInt1, paramInt2);
    if (paramInt1 == -1)
      return false; 
    smoothScroller.setTargetPosition(paramInt1);
    paramLayoutManager.startSmoothScroll(smoothScroller);
    return true;
  }
  
  private void b() throws IllegalStateException {
    if (this.a.getOnFlingListener() == null) {
      this.a.addOnScrollListener(this.c);
      this.a.setOnFlingListener(this);
      return;
    } 
    throw new IllegalStateException("An instance of OnFlingListener already set.");
  }
  
  private void c() {
    this.a.removeOnScrollListener(this.c);
    this.a.setOnFlingListener((RecyclerView.OnFlingListener)null);
  }
  
  @Deprecated
  protected LinearSmoothScroller a(RecyclerView.LayoutManager paramLayoutManager) {
    return !(paramLayoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) ? null : new LinearSmoothScroller(this, this.a.getContext()) {
        protected float a(DisplayMetrics param1DisplayMetrics) {
          return 100.0F / param1DisplayMetrics.densityDpi;
        }
        
        protected void a(View param1View, RecyclerView.State param1State, RecyclerView.SmoothScroller.Action param1Action) {
          if (this.f.a == null)
            return; 
          SnapHelper snapHelper = this.f;
          int[] arrayOfInt = snapHelper.calculateDistanceToFinalSnap(snapHelper.a.getLayoutManager(), param1View);
          int i = arrayOfInt[0];
          int j = arrayOfInt[1];
          int k = a(Math.max(Math.abs(i), Math.abs(j)));
          if (k > 0)
            param1Action.update(i, j, k, (Interpolator)this.b); 
        }
      };
  }
  
  void a() {
    RecyclerView recyclerView = this.a;
    if (recyclerView == null)
      return; 
    RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
    if (layoutManager == null)
      return; 
    View view = findSnapView(layoutManager);
    if (view == null)
      return; 
    int[] arrayOfInt = calculateDistanceToFinalSnap(layoutManager, view);
    if (arrayOfInt[0] != 0 || arrayOfInt[1] != 0)
      this.a.smoothScrollBy(arrayOfInt[0], arrayOfInt[1]); 
  }
  
  public void attachToRecyclerView(RecyclerView paramRecyclerView) throws IllegalStateException {
    RecyclerView recyclerView = this.a;
    if (recyclerView == paramRecyclerView)
      return; 
    if (recyclerView != null)
      c(); 
    this.a = paramRecyclerView;
    if (this.a != null) {
      b();
      this.b = new Scroller(this.a.getContext(), (Interpolator)new DecelerateInterpolator());
      a();
    } 
  }
  
  protected RecyclerView.SmoothScroller b(RecyclerView.LayoutManager paramLayoutManager) {
    return a(paramLayoutManager);
  }
  
  public abstract int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager paramLayoutManager, View paramView);
  
  public int[] calculateScrollDistance(int paramInt1, int paramInt2) {
    this.b.fling(0, 0, paramInt1, paramInt2, -2147483648, 2147483647, -2147483648, 2147483647);
    return new int[] { this.b.getFinalX(), this.b.getFinalY() };
  }
  
  public abstract View findSnapView(RecyclerView.LayoutManager paramLayoutManager);
  
  public abstract int findTargetSnapPosition(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2);
  
  public boolean onFling(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: getfield a : Landroidx/recyclerview/widget/RecyclerView;
    //   4: invokevirtual getLayoutManager : ()Landroidx/recyclerview/widget/RecyclerView$LayoutManager;
    //   7: astore #6
    //   9: iconst_0
    //   10: istore #5
    //   12: aload #6
    //   14: ifnonnull -> 19
    //   17: iconst_0
    //   18: ireturn
    //   19: aload_0
    //   20: getfield a : Landroidx/recyclerview/widget/RecyclerView;
    //   23: invokevirtual getAdapter : ()Landroidx/recyclerview/widget/RecyclerView$Adapter;
    //   26: ifnonnull -> 31
    //   29: iconst_0
    //   30: ireturn
    //   31: aload_0
    //   32: getfield a : Landroidx/recyclerview/widget/RecyclerView;
    //   35: invokevirtual getMinFlingVelocity : ()I
    //   38: istore_3
    //   39: iload_2
    //   40: invokestatic abs : (I)I
    //   43: iload_3
    //   44: if_icmpgt -> 59
    //   47: iload #5
    //   49: istore #4
    //   51: iload_1
    //   52: invokestatic abs : (I)I
    //   55: iload_3
    //   56: if_icmple -> 77
    //   59: iload #5
    //   61: istore #4
    //   63: aload_0
    //   64: aload #6
    //   66: iload_1
    //   67: iload_2
    //   68: invokespecial a : (Landroidx/recyclerview/widget/RecyclerView$LayoutManager;II)Z
    //   71: ifeq -> 77
    //   74: iconst_1
    //   75: istore #4
    //   77: iload #4
    //   79: ireturn
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\recyclerview\widget\SnapHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */