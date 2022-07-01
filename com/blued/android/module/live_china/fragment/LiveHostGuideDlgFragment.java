package com.blued.android.module.live_china.fragment;

import android.view.View;
import android.widget.ImageView;
import com.blued.android.module.live.base.fragment.LiveBaseDialogFragment;
import com.blued.android.module.live_china.R;

public class LiveHostGuideDlgFragment extends LiveBaseDialogFragment {
  private ImageView i;
  
  private int j;
  
  private boolean k;
  
  private void j() {
    dismissAllowingStateLoss();
  }
  
  public boolean V_() {
    j();
    return true;
  }
  
  public int f() {
    return R.layout.fragment_live_host_guide;
  }
  
  public void g() {
    this.b.setOnClickListener(new -$$Lambda$LiveHostGuideDlgFragment$MpOoSa2UWc3_8kKJ4V1alpxmr9w(this));
    this.i = (ImageView)this.b.findViewById(R.id.iv_fans_indicate);
    if (this.k)
      this.b.setBackgroundColor(getResources().getColor(R.color.transparent)); 
  }
  
  public void h() {
    this.j = this.c.getInt("type");
    this.k = this.c.getBoolean("is_make_lover");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LiveHostGuideDlgFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */