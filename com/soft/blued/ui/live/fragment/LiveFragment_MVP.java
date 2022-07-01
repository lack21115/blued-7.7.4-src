package com.soft.blued.ui.live.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.live_china.model.BluedLiveState;
import java.util.List;

public final class LiveFragment_MVP implements MvpDispatcher {
  public void a(MvpFragment paramMvpFragment, String paramString, List<List> paramList) {
    paramMvpFragment = paramMvpFragment;
    if (paramList != null && paramList.size() > 0) {
      byte b = 0;
      paramList = paramList.get(0);
      if (paramList != null) {
        if (paramString.hashCode() != -1680246946 || !paramString.equals("LIVE_STATE"))
          b = -1; 
        if (b != 0)
          return; 
        if (BluedLiveState.class.isInstance(paramList))
          paramMvpFragment.a((BluedLiveState)paramList); 
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\fragment\LiveFragment_MVP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */