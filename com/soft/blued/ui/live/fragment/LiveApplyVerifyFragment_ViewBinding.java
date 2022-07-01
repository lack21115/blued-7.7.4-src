package com.soft.blued.ui.live.fragment;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.soft.blued.customview.CommonTopTitleNoTrans;

public class LiveApplyVerifyFragment_ViewBinding implements Unbinder {
  private LiveApplyVerifyFragment b;
  
  public LiveApplyVerifyFragment_ViewBinding(LiveApplyVerifyFragment paramLiveApplyVerifyFragment, View paramView) {
    this.b = paramLiveApplyVerifyFragment;
    paramLiveApplyVerifyFragment.top_title = (CommonTopTitleNoTrans)Utils.a(paramView, 2131300300, "field 'top_title'", CommonTopTitleNoTrans.class);
    paramLiveApplyVerifyFragment.tv_tip_1 = (TextView)Utils.a(paramView, 2131301394, "field 'tv_tip_1'", TextView.class);
  }
  
  public void unbind() {
    LiveApplyVerifyFragment liveApplyVerifyFragment = this.b;
    if (liveApplyVerifyFragment != null) {
      this.b = null;
      liveApplyVerifyFragment.top_title = null;
      liveApplyVerifyFragment.tv_tip_1 = null;
      return;
    } 
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\fragment\LiveApplyVerifyFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */