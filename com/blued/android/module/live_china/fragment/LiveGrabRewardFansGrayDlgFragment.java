package com.blued.android.module.live_china.fragment;

import android.view.View;
import com.blued.android.module.live.base.fragment.LiveBaseDialogFragment;
import com.blued.android.module.live_china.R;

public class LiveGrabRewardFansGrayDlgFragment extends LiveBaseDialogFragment {
  private void j() {
    dismissAllowingStateLoss();
    if (getParentFragment() != null)
      ((PlayingOnliveFragment)getParentFragment()).U(); 
  }
  
  public int f() {
    return R.layout.fragment_live_grab_reward_fans_gray;
  }
  
  public void g() {
    this.b.setOnClickListener(-$$Lambda$LiveGrabRewardFansGrayDlgFragment$8tRsThKW4g8ZLsrqUUdBYg1yoww.INSTANCE);
    this.b.findViewById(R.id.live_grab_reward_fans_gray_close_btn).setOnClickListener(new -$$Lambda$LiveGrabRewardFansGrayDlgFragment$BPznVdez2FEHyWwksr_1lJqvLKg(this));
    this.b.findViewById(R.id.live_grab_reward_fans_gray_confirm_btn).setOnClickListener(new -$$Lambda$LiveGrabRewardFansGrayDlgFragment$3fFxEgMmFffo-39VPkhQK1MQmiY(this));
  }
  
  public void h() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LiveGrabRewardFansGrayDlgFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */