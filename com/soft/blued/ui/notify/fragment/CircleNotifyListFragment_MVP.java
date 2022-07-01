package com.soft.blued.ui.notify.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.soft.blued.ui.notify.model.CircleNotify;
import java.util.List;

public final class CircleNotifyListFragment_MVP implements MvpDispatcher {
  public void a(MvpFragment paramMvpFragment, String paramString, List<Object> paramList) {
    paramMvpFragment = paramMvpFragment;
    if (paramList != null && paramList.size() > 0) {
      byte b = 0;
      Object object = paramList.get(0);
      if (object != null) {
        if (paramString.hashCode() != -1742866476 || !paramString.equals("notify_list"))
          b = -1; 
        if (b != 0)
          return; 
        if (CircleNotify.class.isInstance(object))
          paramMvpFragment.a((List)paramList); 
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\notify\fragment\CircleNotifyListFragment_MVP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */