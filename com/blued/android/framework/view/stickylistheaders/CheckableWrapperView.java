package com.blued.android.framework.view.stickylistheaders;

import android.content.Context;
import android.widget.Checkable;

class CheckableWrapperView extends WrapperView implements Checkable {
  public CheckableWrapperView(Context paramContext) {
    super(paramContext);
  }
  
  public boolean isChecked() {
    return ((Checkable)this.a).isChecked();
  }
  
  public void setChecked(boolean paramBoolean) {
    ((Checkable)this.a).setChecked(paramBoolean);
  }
  
  public void toggle() {
    setChecked(isChecked() ^ true);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\stickylistheaders\CheckableWrapperView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */