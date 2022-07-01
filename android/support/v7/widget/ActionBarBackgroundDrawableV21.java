package android.support.v7.widget;

import android.graphics.Outline;

final class ActionBarBackgroundDrawableV21 extends ActionBarBackgroundDrawable {
  public ActionBarBackgroundDrawableV21(ActionBarContainer paramActionBarContainer) {
    super(paramActionBarContainer);
  }
  
  public final void getOutline(Outline paramOutline) {
    if (this.mContainer.mIsSplit) {
      if (this.mContainer.mSplitBackground != null) {
        this.mContainer.mSplitBackground.getOutline(paramOutline);
        return;
      } 
    } else if (this.mContainer.mBackground != null) {
      this.mContainer.mBackground.getOutline(paramOutline);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\ActionBarBackgroundDrawableV21.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */