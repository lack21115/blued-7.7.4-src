package org.chromium.android_webview;

public class AwScrollOffsetManager {
  private boolean mApplyDeferredNativeScroll;
  
  public int mContainerViewHeight;
  
  public int mContainerViewWidth;
  
  private int mDeferredNativeScrollX;
  
  private int mDeferredNativeScrollY;
  
  public final AwScrollOffsetManager$Delegate mDelegate;
  
  int mMaxHorizontalScrollOffset;
  
  int mMaxVerticalScrollOffset;
  
  int mNativeScrollX;
  
  int mNativeScrollY;
  
  boolean mProcessingTouchEvent;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public AwScrollOffsetManager(AwScrollOffsetManager$Delegate paramAwScrollOffsetManager$Delegate) {
    this.mDelegate = paramAwScrollOffsetManager$Delegate;
  }
  
  public final boolean animateScrollTo(int paramInt1, int paramInt2) {
    int i = this.mDelegate.getContainerViewScrollX();
    int j = this.mDelegate.getContainerViewScrollY();
    paramInt1 = clampHorizontalScroll(paramInt1);
    paramInt2 = clampVerticalScroll(paramInt2);
    paramInt1 -= i;
    paramInt2 -= j;
    if (paramInt1 == 0 && paramInt2 == 0)
      return false; 
    this.mDelegate.smoothScroll(i + paramInt1, j + paramInt2, Math.min(Math.max(Math.abs(paramInt1), Math.abs(paramInt2)) * 1000 / 480, 750));
    this.mDelegate.invalidate();
    return true;
  }
  
  final int clampHorizontalScroll(int paramInt) {
    paramInt = Math.max(0, paramInt);
    return Math.min(this.mMaxHorizontalScrollOffset, paramInt);
  }
  
  final int clampVerticalScroll(int paramInt) {
    paramInt = Math.max(0, paramInt);
    return Math.min(this.mMaxVerticalScrollOffset, paramInt);
  }
  
  public final int computeHorizontalScrollRange() {
    return this.mContainerViewWidth + this.mMaxHorizontalScrollOffset;
  }
  
  public final int computeVerticalScrollRange() {
    return this.mContainerViewHeight + this.mMaxVerticalScrollOffset;
  }
  
  public final void scrollBy(int paramInt1, int paramInt2) {
    if (paramInt1 == 0 && paramInt2 == 0)
      return; 
    int i = this.mDelegate.getContainerViewScrollX();
    int j = this.mDelegate.getContainerViewScrollY();
    int k = this.mMaxHorizontalScrollOffset;
    int m = this.mMaxVerticalScrollOffset;
    this.mDelegate.overScrollContainerViewBy(paramInt1, paramInt2, i, j, k, m, this.mProcessingTouchEvent);
  }
  
  final void scrollNativeTo(int paramInt1, int paramInt2) {
    paramInt1 = clampHorizontalScroll(paramInt1);
    paramInt2 = clampVerticalScroll(paramInt2);
    if (this.mProcessingTouchEvent) {
      this.mDeferredNativeScrollX = paramInt1;
      this.mDeferredNativeScrollY = paramInt2;
      this.mApplyDeferredNativeScroll = true;
      return;
    } 
    if (paramInt1 == this.mNativeScrollX && paramInt2 == this.mNativeScrollY)
      return; 
    this.mNativeScrollX = paramInt1;
    this.mNativeScrollY = paramInt2;
    this.mDelegate.scrollNativeTo(paramInt1, paramInt2);
  }
  
  public final void setProcessingTouchEvent(boolean paramBoolean) {
    assert false;
    throw new AssertionError();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwScrollOffsetManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */