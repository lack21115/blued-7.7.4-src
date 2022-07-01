package org.chromium.android_webview;

public interface AwScrollOffsetManager$Delegate {
  int getContainerViewScrollX();
  
  int getContainerViewScrollY();
  
  void invalidate();
  
  void overScrollContainerViewBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean);
  
  void scrollContainerViewTo(int paramInt1, int paramInt2);
  
  void scrollNativeTo(int paramInt1, int paramInt2);
  
  void smoothScroll(int paramInt1, int paramInt2, long paramLong);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwScrollOffsetManager$Delegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */