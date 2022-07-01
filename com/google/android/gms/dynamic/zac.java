package com.google.android.gms.dynamic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

final class zac implements DeferredLifecycleHelper.zaa {
  zac(DeferredLifecycleHelper paramDeferredLifecycleHelper, FrameLayout paramFrameLayout, LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {}
  
  public final int zaa() {
    return 2;
  }
  
  public final void zaa(LifecycleDelegate paramLifecycleDelegate) {
    this.zaa.removeAllViews();
    this.zaa.addView(DeferredLifecycleHelper.zab(this.zae).onCreateView(this.zab, this.zac, this.zad));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\dynamic\zac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */