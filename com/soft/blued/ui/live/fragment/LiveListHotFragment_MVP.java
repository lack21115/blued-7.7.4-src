package com.soft.blued.ui.live.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.soft.blued.ui.live.model.BluedLiveListData;
import java.util.List;

public final class LiveListHotFragment_MVP implements MvpDispatcher {
  private void a(LiveListHotFragment paramLiveListHotFragment, String paramString) {
    byte b;
    if (paramString.hashCode() == 521559408 && paramString.equals("HOT_LIST")) {
      b = 0;
    } else {
      b = -1;
    } 
    if (b != 0)
      return; 
    paramLiveListHotFragment.k();
  }
  
  public void a(MvpFragment paramMvpFragment, String paramString, List<Object> paramList) {
    paramMvpFragment = paramMvpFragment;
    if (paramList != null && paramList.size() > 0) {
      byte b = 0;
      Object object = paramList.get(0);
      if (object != null) {
        if (paramString.hashCode() != 521559408 || !paramString.equals("HOT_LIST"))
          b = -1; 
        if (b == 0 && BluedLiveListData.class.isInstance(object)) {
          paramMvpFragment.a((List)paramList);
          return;
        } 
      } 
    } 
    a((LiveListHotFragment)paramMvpFragment, paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\fragment\LiveListHotFragment_MVP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */