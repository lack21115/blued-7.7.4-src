package com.blued.android.framework.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;

public class BroadcastFragment extends KeyBoardFragment {
  private BroadcastReceiver e = new BroadcastReceiver(this) {
      public void onReceive(Context param1Context, Intent param1Intent) {
        this.a.getActivity().finish();
      }
    };
  
  public void onAttach(Activity paramActivity) {
    super.onAttach(paramActivity);
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("clear_topic_stack");
    getActivity().registerReceiver(this.e, intentFilter);
  }
  
  public void onDetach() {
    super.onDetach();
    getActivity().unregisterReceiver(this.e);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\activity\BroadcastFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */