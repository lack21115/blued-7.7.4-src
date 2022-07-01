package com.blued.android.module.live_china.fragment;

import android.view.View;
import android.widget.TextView;
import com.blued.android.module.live.base.fragment.LiveBaseDialogFragment;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveFloatManager;

public class LiveGuestErrorDlgFragment extends LiveBaseDialogFragment {
  public TextView i;
  
  private String j;
  
  private void j() {
    LiveFloatManager.a().b(false);
    LiveFloatManager.a().n();
    if (getTargetFragment() != null && getTargetFragment() instanceof PlayingOnliveFragment)
      ((PlayingOnliveFragment)getTargetFragment()).aa(); 
  }
  
  public boolean V_() {
    j();
    return true;
  }
  
  public int f() {
    return R.layout.fragment_live_guest_error;
  }
  
  public void g() {
    this.b.setOnClickListener(-$$Lambda$LiveGuestErrorDlgFragment$QNJv7_d-u5cJGMnhcmfWDJdbyYo.INSTANCE);
    this.i = (TextView)this.b.findViewById(R.id.live_guest_error_tv);
    this.i.setText(this.j);
    this.b.findViewById(R.id.live_guest_error_btn).setOnClickListener(new -$$Lambda$LiveGuestErrorDlgFragment$itYW2zILfrlabKI8_lmwkSSDET4(this));
  }
  
  public void h() {
    this.j = this.c.getString("msg_text");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LiveGuestErrorDlgFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */