package com.soft.blued.ui.pay.googlepay.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class IabBroadcastReceiver extends BroadcastReceiver {
  private final IabBroadcastListener a;
  
  public void onReceive(Context paramContext, Intent paramIntent) {
    IabBroadcastListener iabBroadcastListener = this.a;
    if (iabBroadcastListener != null)
      iabBroadcastListener.a(); 
  }
  
  public static interface IabBroadcastListener {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\pay\googlepa\\util\IabBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */