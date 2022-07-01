package com.soft.blued.ui.msg_group.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.soft.blued.ui.msg_group.model.GroupInfoModel;
import java.util.List;

public final class MyGroupFragment_MVP implements MvpDispatcher {
  public void a(MvpFragment paramMvpFragment, String paramString, List<Object> paramList) {
    paramMvpFragment = paramMvpFragment;
    if (paramList != null && paramList.size() > 0) {
      byte b = 0;
      Object object = paramList.get(0);
      if (object != null) {
        if (paramString.hashCode() != 1608540586 || !paramString.equals("data_group"))
          b = -1; 
        if (b != 0)
          return; 
        if (GroupInfoModel.class.isInstance(object))
          paramMvpFragment.a((List)paramList); 
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg_group\fragment\MyGroupFragment_MVP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */