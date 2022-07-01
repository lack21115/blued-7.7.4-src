package org.chromium.android_webview;

final class AwContents$AwScrollOffsetManagerDelegate implements AwScrollOffsetManager$Delegate {
  private AwContents$AwScrollOffsetManagerDelegate() {}
  
  public final int getContainerViewScrollX() {
    return AwContents.access$700(AwContents.this).getScrollX();
  }
  
  public final int getContainerViewScrollY() {
    return AwContents.access$700(AwContents.this).getScrollY();
  }
  
  public final void invalidate() {
    AwContents.access$1300(AwContents.this);
  }
  
  public final void overScrollContainerViewBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean) {
    AwContents.access$800(AwContents.this).overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, 0, 0, paramBoolean);
  }
  
  public final void scrollContainerViewTo(int paramInt1, int paramInt2) {
    AwContents.access$800(AwContents.this).super_scrollTo(paramInt1, paramInt2);
  }
  
  public final void scrollNativeTo(int paramInt1, int paramInt2) {
    if (!AwContents.access$900(AwContents.this, 0))
      AwContents.access$1100(AwContents.this, AwContents.access$1000(AwContents.this), paramInt1, paramInt2); 
  }
  
  public final void smoothScroll(int paramInt1, int paramInt2, long paramLong) {
    if (!AwContents.access$900(AwContents.this, 0))
      AwContents.access$1200(AwContents.this, AwContents.access$1000(AwContents.this), paramInt1, paramInt2, paramLong); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwContents$AwScrollOffsetManagerDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */