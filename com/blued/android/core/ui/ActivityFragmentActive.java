package com.blued.android.core.ui;

import androidx.lifecycle.Lifecycle;
import com.blued.android.core.net.IRequestHost;

public class ActivityFragmentActive implements IRequestHost {
  public static ActivityFragmentActive a = new ActivityFragmentActive();
  
  private Lifecycle b;
  
  private ActivityFragmentActive() {}
  
  public ActivityFragmentActive(Lifecycle paramLifecycle) {
    this.b = paramLifecycle;
  }
  
  public void a() {
    if (this.b != null)
      this.b = null; 
  }
  
  public boolean isActive() {
    Lifecycle lifecycle = this.b;
    return (lifecycle != null) ? lifecycle.getCurrentState().isAtLeast(Lifecycle.State.CREATED) : false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\cor\\ui\ActivityFragmentActive.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */