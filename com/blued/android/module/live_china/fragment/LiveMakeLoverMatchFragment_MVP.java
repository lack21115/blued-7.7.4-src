package com.blued.android.module.live_china.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.live_china.model.LiveMakeLoverReleationModel;
import java.util.List;

public final class LiveMakeLoverMatchFragment_MVP implements MvpDispatcher {
  public void a(MvpFragment paramMvpFragment, String paramString, List<List> paramList) {
    paramMvpFragment = paramMvpFragment;
    if (paramList != null && paramList.size() > 0) {
      byte b = 0;
      paramList = paramList.get(0);
      if (paramList != null) {
        if (paramString.hashCode() != 1038681772 || !paramString.equals("MAKE_LOVER_RELATION"))
          b = -1; 
        if (b != 0)
          return; 
        if (LiveMakeLoverReleationModel.class.isInstance(paramList))
          paramMvpFragment.a((LiveMakeLoverReleationModel)paramList); 
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LiveMakeLoverMatchFragment_MVP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */