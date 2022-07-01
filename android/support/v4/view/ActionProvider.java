package android.support.v4.view;

import android.view.View;

public abstract class ActionProvider {
  public ActionProvider$SubUiVisibilityListener mSubUiVisibilityListener;
  
  public abstract View onCreateActionView();
  
  public final void subUiVisibilityChanged(boolean paramBoolean) {
    if (this.mSubUiVisibilityListener != null)
      this.mSubUiVisibilityListener.onSubUiVisibilityChanged(paramBoolean); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\view\ActionProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */