package com.soft.blued.ui.msg_group.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.soft.blued.ui.msg_group.model.GroupMemberModel;
import java.util.List;

public final class GroupMemberFragment_MVP implements MvpDispatcher {
  private void a(GroupMemberFragment paramGroupMemberFragment, String paramString) {
    byte b;
    if (paramString.hashCode() == -1772847136 && paramString.equals("data_delete")) {
      b = 0;
    } else {
      b = -1;
    } 
    if (b != 0)
      return; 
    paramGroupMemberFragment.k();
  }
  
  public void a(MvpFragment paramMvpFragment, String paramString, List<Object> paramList) {
    paramMvpFragment = paramMvpFragment;
    if (paramList != null && paramList.size() > 0) {
      byte b = 0;
      Object object = paramList.get(0);
      if (object != null) {
        if (paramString.hashCode() != -1515158321 || !paramString.equals("data_member"))
          b = -1; 
        if (b == 0 && GroupMemberModel.class.isInstance(object)) {
          paramMvpFragment.a((List)paramList);
          return;
        } 
      } 
    } 
    a((GroupMemberFragment)paramMvpFragment, paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg_group\fragment\GroupMemberFragment_MVP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */