package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.common.fragment.BaseGiftParentFragment;
import com.blued.android.module.live.base.model.CommonLiveGiftModel;
import com.blued.android.module.yy_china.R;
import javax.annotation.Nonnull;

public class YYGiftParentFragment extends BaseGiftParentFragment<CommonLiveGiftModel> {
  public BaseFragment a(int paramInt, @Nonnull Bundle paramBundle) {
    return (BaseFragment)new YYGiftPageFragment();
  }
  
  public void n() {
    super.n();
    this.h.setSelectedImgRes(R.drawable.icon_gift_page_selected);
  }
  
  public void onHiddenChanged(boolean paramBoolean) {
    super.onHiddenChanged(paramBoolean);
    Logger.e("yy_gift", new Object[] { "YYGiftParentFragment onHiddenChanged ... " });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\fragment\YYGiftParentFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */