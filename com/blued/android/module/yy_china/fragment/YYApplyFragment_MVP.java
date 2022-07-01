package com.blued.android.module.yy_china.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.yy_china.model.YYLiveState;
import java.util.List;

public final class YYApplyFragment_MVP implements MvpDispatcher {
  private void a(YYApplyFragment paramYYApplyFragment, String paramString) {
    byte b;
    if (paramString.hashCode() == -1102999352 && paramString.equals("yy_apply_submit")) {
      b = 0;
    } else {
      b = -1;
    } 
    if (b != 0)
      return; 
    paramYYApplyFragment.k();
  }
  
  public void a(MvpFragment paramMvpFragment, String paramString, List<List> paramList) {
    paramMvpFragment = paramMvpFragment;
    if (paramList != null && paramList.size() > 0) {
      byte b = 0;
      paramList = paramList.get(0);
      if (paramList != null) {
        if (paramString.hashCode() != -35611167 || !paramString.equals("yy_apply_state"))
          b = -1; 
        if (b == 0 && YYLiveState.class.isInstance(paramList)) {
          paramMvpFragment.a((YYLiveState)paramList);
          return;
        } 
      } 
    } 
    a((YYApplyFragment)paramMvpFragment, paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\fragment\YYApplyFragment_MVP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */