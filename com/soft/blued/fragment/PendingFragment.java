package com.soft.blued.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blued.android.core.ui.BaseFragment;
import com.soft.blued.ui.msg.DialogSkipFragment;
import com.soft.blued.ui.msg.model.ChannelModel;
import com.soft.blued.utils.Logger;

public class PendingFragment extends BaseFragment {
  private int d = 0;
  
  private Context e;
  
  private void a(Bundle paramBundle) {
    Logger.b("PendingFragment", new Object[] { "action:", Integer.valueOf(this.d) });
    if (paramBundle == null) {
      getActivity().finish();
      return;
    } 
    if (this.d == 1) {
      ChannelModel channelModel = (ChannelModel)paramBundle.getSerializable("CHANNEL");
      DialogSkipFragment.a(this.e, channelModel);
    } 
    getActivity().finish();
  }
  
  public void onCreate(Bundle paramBundle) {
    Logger.b("PendingFragment", new Object[] { "onCreate" });
    this.e = (Context)getActivity();
    Bundle bundle = getArguments();
    if (bundle != null)
      this.d = bundle.getInt("action", 0); 
    a(bundle);
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\fragment\PendingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */