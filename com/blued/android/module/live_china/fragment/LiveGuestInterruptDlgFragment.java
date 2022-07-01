package com.blued.android.module.live_china.fragment;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.blued.android.module.live.base.fragment.LiveBaseDialogFragment;
import com.blued.android.module.live_china.R;

public class LiveGuestInterruptDlgFragment extends LiveBaseDialogFragment {
  public TextView i;
  
  public TextView j;
  
  private String k;
  
  private String l;
  
  private void j() {
    dismissAllowingStateLoss();
    if (getTargetFragment() != null && getTargetFragment() instanceof PlayingOnliveFragment)
      ((PlayingOnliveFragment)getTargetFragment()).az(); 
  }
  
  public boolean V_() {
    j();
    return true;
  }
  
  public int f() {
    return R.layout.live_error_layout_tips;
  }
  
  public void g() {
    this.b.setOnClickListener(-$$Lambda$LiveGuestInterruptDlgFragment$T--KIbCruakjCdt3Kf03ZOcyyUM.INSTANCE);
    this.j = (TextView)this.b.findViewById(R.id.error_tips_title);
    this.j.setText(this.k);
    this.i = (TextView)this.b.findViewById(R.id.error_tips_message);
    if (!TextUtils.isEmpty(this.l)) {
      this.i.setText(this.l);
    } else {
      this.i.setVisibility(8);
    } 
    this.b.findViewById(R.id.error_tips_btn).setOnClickListener(new -$$Lambda$LiveGuestInterruptDlgFragment$XbPrxCnbyqXcIOX5Q28kUKWboP8(this));
  }
  
  public void h() {
    this.k = this.c.getString("msg_title");
    this.l = this.c.getString("msg_text");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LiveGuestInterruptDlgFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */