package android.support.v7.widget;

final class RtlSpacingHelper {
  int mEnd = Integer.MIN_VALUE;
  
  int mExplicitLeft = 0;
  
  int mExplicitRight = 0;
  
  boolean mIsRelative = false;
  
  boolean mIsRtl = false;
  
  int mLeft = 0;
  
  int mRight = 0;
  
  int mStart = Integer.MIN_VALUE;
  
  public final void setRelative(int paramInt1, int paramInt2) {
    this.mStart = paramInt1;
    this.mEnd = paramInt2;
    this.mIsRelative = true;
    if (this.mIsRtl) {
      if (paramInt2 != Integer.MIN_VALUE)
        this.mLeft = paramInt2; 
      if (paramInt1 != Integer.MIN_VALUE) {
        this.mRight = paramInt1;
        return;
      } 
    } else {
      if (paramInt1 != Integer.MIN_VALUE)
        this.mLeft = paramInt1; 
      if (paramInt2 != Integer.MIN_VALUE)
        this.mRight = paramInt2; 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\RtlSpacingHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */