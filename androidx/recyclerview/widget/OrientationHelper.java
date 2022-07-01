package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;

public abstract class OrientationHelper {
  public static final int HORIZONTAL = 0;
  
  public static final int VERTICAL = 1;
  
  protected final RecyclerView.LayoutManager a;
  
  final Rect b = new Rect();
  
  private int c = Integer.MIN_VALUE;
  
  private OrientationHelper(RecyclerView.LayoutManager paramLayoutManager) {
    this.a = paramLayoutManager;
  }
  
  public static OrientationHelper createHorizontalHelper(RecyclerView.LayoutManager paramLayoutManager) {
    return new OrientationHelper(paramLayoutManager) {
        public int getDecoratedEnd(View param1View) {
          RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)param1View.getLayoutParams();
          return this.a.getDecoratedRight(param1View) + layoutParams.rightMargin;
        }
        
        public int getDecoratedMeasurement(View param1View) {
          RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)param1View.getLayoutParams();
          return this.a.getDecoratedMeasuredWidth(param1View) + layoutParams.leftMargin + layoutParams.rightMargin;
        }
        
        public int getDecoratedMeasurementInOther(View param1View) {
          RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)param1View.getLayoutParams();
          return this.a.getDecoratedMeasuredHeight(param1View) + layoutParams.topMargin + layoutParams.bottomMargin;
        }
        
        public int getDecoratedStart(View param1View) {
          RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)param1View.getLayoutParams();
          return this.a.getDecoratedLeft(param1View) - layoutParams.leftMargin;
        }
        
        public int getEnd() {
          return this.a.getWidth();
        }
        
        public int getEndAfterPadding() {
          return this.a.getWidth() - this.a.getPaddingRight();
        }
        
        public int getEndPadding() {
          return this.a.getPaddingRight();
        }
        
        public int getMode() {
          return this.a.getWidthMode();
        }
        
        public int getModeInOther() {
          return this.a.getHeightMode();
        }
        
        public int getStartAfterPadding() {
          return this.a.getPaddingLeft();
        }
        
        public int getTotalSpace() {
          return this.a.getWidth() - this.a.getPaddingLeft() - this.a.getPaddingRight();
        }
        
        public int getTransformedEndWithDecoration(View param1View) {
          this.a.getTransformedBoundingBox(param1View, true, this.b);
          return this.b.right;
        }
        
        public int getTransformedStartWithDecoration(View param1View) {
          this.a.getTransformedBoundingBox(param1View, true, this.b);
          return this.b.left;
        }
        
        public void offsetChild(View param1View, int param1Int) {
          param1View.offsetLeftAndRight(param1Int);
        }
        
        public void offsetChildren(int param1Int) {
          this.a.offsetChildrenHorizontal(param1Int);
        }
      };
  }
  
  public static OrientationHelper createOrientationHelper(RecyclerView.LayoutManager paramLayoutManager, int paramInt) {
    if (paramInt != 0) {
      if (paramInt == 1)
        return createVerticalHelper(paramLayoutManager); 
      throw new IllegalArgumentException("invalid orientation");
    } 
    return createHorizontalHelper(paramLayoutManager);
  }
  
  public static OrientationHelper createVerticalHelper(RecyclerView.LayoutManager paramLayoutManager) {
    return new OrientationHelper(paramLayoutManager) {
        public int getDecoratedEnd(View param1View) {
          RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)param1View.getLayoutParams();
          return this.a.getDecoratedBottom(param1View) + layoutParams.bottomMargin;
        }
        
        public int getDecoratedMeasurement(View param1View) {
          RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)param1View.getLayoutParams();
          return this.a.getDecoratedMeasuredHeight(param1View) + layoutParams.topMargin + layoutParams.bottomMargin;
        }
        
        public int getDecoratedMeasurementInOther(View param1View) {
          RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)param1View.getLayoutParams();
          return this.a.getDecoratedMeasuredWidth(param1View) + layoutParams.leftMargin + layoutParams.rightMargin;
        }
        
        public int getDecoratedStart(View param1View) {
          RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)param1View.getLayoutParams();
          return this.a.getDecoratedTop(param1View) - layoutParams.topMargin;
        }
        
        public int getEnd() {
          return this.a.getHeight();
        }
        
        public int getEndAfterPadding() {
          return this.a.getHeight() - this.a.getPaddingBottom();
        }
        
        public int getEndPadding() {
          return this.a.getPaddingBottom();
        }
        
        public int getMode() {
          return this.a.getHeightMode();
        }
        
        public int getModeInOther() {
          return this.a.getWidthMode();
        }
        
        public int getStartAfterPadding() {
          return this.a.getPaddingTop();
        }
        
        public int getTotalSpace() {
          return this.a.getHeight() - this.a.getPaddingTop() - this.a.getPaddingBottom();
        }
        
        public int getTransformedEndWithDecoration(View param1View) {
          this.a.getTransformedBoundingBox(param1View, true, this.b);
          return this.b.bottom;
        }
        
        public int getTransformedStartWithDecoration(View param1View) {
          this.a.getTransformedBoundingBox(param1View, true, this.b);
          return this.b.top;
        }
        
        public void offsetChild(View param1View, int param1Int) {
          param1View.offsetTopAndBottom(param1Int);
        }
        
        public void offsetChildren(int param1Int) {
          this.a.offsetChildrenVertical(param1Int);
        }
      };
  }
  
  public abstract int getDecoratedEnd(View paramView);
  
  public abstract int getDecoratedMeasurement(View paramView);
  
  public abstract int getDecoratedMeasurementInOther(View paramView);
  
  public abstract int getDecoratedStart(View paramView);
  
  public abstract int getEnd();
  
  public abstract int getEndAfterPadding();
  
  public abstract int getEndPadding();
  
  public RecyclerView.LayoutManager getLayoutManager() {
    return this.a;
  }
  
  public abstract int getMode();
  
  public abstract int getModeInOther();
  
  public abstract int getStartAfterPadding();
  
  public abstract int getTotalSpace();
  
  public int getTotalSpaceChange() {
    return (Integer.MIN_VALUE == this.c) ? 0 : (getTotalSpace() - this.c);
  }
  
  public abstract int getTransformedEndWithDecoration(View paramView);
  
  public abstract int getTransformedStartWithDecoration(View paramView);
  
  public abstract void offsetChild(View paramView, int paramInt);
  
  public abstract void offsetChildren(int paramInt);
  
  public void onLayoutComplete() {
    this.c = getTotalSpace();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\recyclerview\widget\OrientationHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */