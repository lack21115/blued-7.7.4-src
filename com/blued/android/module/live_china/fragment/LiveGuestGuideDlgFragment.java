package com.blued.android.module.live_china.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.blued.android.module.live.base.fragment.LiveBaseDialogFragment;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.utils.LivePreferencesUtils;

public class LiveGuestGuideDlgFragment extends LiveBaseDialogFragment {
  public ViewGroup i;
  
  private RelativeLayout j;
  
  private int k;
  
  private void j() {
    if (this.k == 2)
      LivePreferencesUtils.d(true); 
    dismissAllowingStateLoss();
  }
  
  public boolean V_() {
    j();
    return true;
  }
  
  public int f() {
    return R.layout.fragment_live_guest_guide;
  }
  
  public void g() {
    this.b.setOnClickListener(new -$$Lambda$LiveGuestGuideDlgFragment$U1P3kAnGv7APEqN4l-Oqr9eJ7Ps(this));
    this.i = (ViewGroup)this.b.findViewById(R.id.new_gift_guide);
    this.i.setOnClickListener(new -$$Lambda$LiveGuestGuideDlgFragment$joShZT5V0Aw4wc1CxB7QD295Ti4(this));
    this.j = (RelativeLayout)this.b.findViewById(R.id.live_scroll_guide_layout);
    this.j.setOnClickListener(new -$$Lambda$LiveGuestGuideDlgFragment$ZWV3S_w5sg8tgy_utL6-TuhpjGQ(this));
    int i = this.k;
    if (i == 1) {
      this.i.setVisibility(0);
      return;
    } 
    if (i == 2)
      this.j.setVisibility(0); 
  }
  
  public void h() {
    this.k = this.c.getInt("type");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LiveGuestGuideDlgFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */