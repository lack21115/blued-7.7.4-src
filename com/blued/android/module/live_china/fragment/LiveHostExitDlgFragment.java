package com.blued.android.module.live_china.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.blued.android.module.live.base.fragment.LiveBaseDialogFragment;
import com.blued.android.module.live_china.R;

public class LiveHostExitDlgFragment extends LiveBaseDialogFragment {
  public Button i;
  
  public Button j;
  
  public ImageView k;
  
  private void j() {
    if (getTargetFragment() != null)
      getTargetFragment().onActivityResult(getTargetRequestCode(), -1, null); 
    dismissAllowingStateLoss();
  }
  
  private void k() {
    dismissAllowingStateLoss();
  }
  
  public boolean V_() {
    k();
    return true;
  }
  
  public int f() {
    return R.layout.fragment_live_host_exit;
  }
  
  public void g() {
    this.b.setOnClickListener(new -$$Lambda$LiveHostExitDlgFragment$30cjUjZoyVtiiahls0I4hF2teBE(this));
    this.j = (Button)this.b.findViewById(R.id.live_exit_cancel_btn);
    this.i = (Button)this.b.findViewById(R.id.live_exit_sure_btn);
    this.k = (ImageView)this.b.findViewById(R.id.live_exit_close_btn);
    this.j.setOnClickListener(new -$$Lambda$LiveHostExitDlgFragment$ccPZTCwBUk0dPz0F93h1lI5wkoA(this));
    this.i.setOnClickListener(new -$$Lambda$LiveHostExitDlgFragment$TXugkpLOyBhWG5aY6ov8IZofO-8(this));
    this.k.setOnClickListener(new -$$Lambda$LiveHostExitDlgFragment$xbvqYCLgkisZNQzLCgikAY2pYyY(this));
  }
  
  public void h() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LiveHostExitDlgFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */