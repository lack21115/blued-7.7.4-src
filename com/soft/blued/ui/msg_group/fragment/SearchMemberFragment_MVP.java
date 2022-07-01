package com.soft.blued.ui.msg_group.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.soft.blued.ui.msg_group.model.GroupMemberModel;
import java.util.List;

public final class SearchMemberFragment_MVP implements MvpDispatcher {
  public void a(MvpFragment paramMvpFragment, String paramString, List<Object> paramList) {
    paramMvpFragment = paramMvpFragment;
    if (paramList != null && paramList.size() > 0) {
      byte b = 0;
      Integer integer = (Integer)paramList.get(0);
      if (integer != null) {
        switch (paramString.hashCode()) {
          default:
            b = -1;
            break;
          case -314568773:
            if (paramString.equals("data_set_manager")) {
              b = 2;
              break;
            } 
          case -1091221294:
            if (paramString.equals("update_no_data_view")) {
              b = 1;
              break;
            } 
          case -1343725603:
            if (paramString.equals("data_search"))
              break; 
          case -1515158321:
            if (paramString.equals("data_member")) {
              b = 3;
              break;
            } 
        } 
        if (b != 0) {
          if (b != 1) {
            if (b != 2) {
              if (b != 3)
                return; 
              if (GroupMemberModel.class.isInstance(integer)) {
                paramMvpFragment.b((List)paramList);
                return;
              } 
            } else if (Integer.class.isInstance(integer)) {
              paramMvpFragment.a(integer);
              return;
            } 
          } else if (Boolean.class.isInstance(integer)) {
            paramMvpFragment.a((Boolean)integer);
            return;
          } 
        } else if (GroupMemberModel.class.isInstance(integer)) {
          paramMvpFragment.a((List)paramList);
        } 
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg_group\fragment\SearchMemberFragment_MVP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */