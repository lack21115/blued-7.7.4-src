package com.google.android.gms.dynamic;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

final class zaf implements View.OnClickListener {
  zaf(Context paramContext, Intent paramIntent) {}
  
  public final void onClick(View paramView) {
    try {
      this.zaa.startActivity(this.zab);
      return;
    } catch (ActivityNotFoundException activityNotFoundException) {
      Log.e("DeferredLifecycleHelper", "Failed to start resolution intent", (Throwable)activityNotFoundException);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\dynamic\zaf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */