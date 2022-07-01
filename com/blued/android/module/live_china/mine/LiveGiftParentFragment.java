package com.blued.android.module.live_china.mine;

import android.os.Bundle;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.common.fragment.BaseGiftParentFragment;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.blued.android.module.live_china.model.LiveGiftModel;
import javax.annotation.Nonnull;

public class LiveGiftParentFragment extends BaseGiftParentFragment<LiveGiftModel> {
  public BaseFragment a(int paramInt, @Nonnull Bundle paramBundle) {
    return (BaseFragment)new LiveGiftPageFragment();
  }
  
  public void n() {
    super.n();
    if (LiveDataManager.a().f()) {
      this.k = false;
      return;
    } 
    this.k = true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\mine\LiveGiftParentFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */