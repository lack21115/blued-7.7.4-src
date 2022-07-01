package com.soft.blued.ui.find.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.soft.blued.ui.find.model.UserFindResult;
import java.util.List;

public final class SearchUserFragment_MVP implements MvpDispatcher {
  private void a(SearchUserFragment paramSearchUserFragment, String paramString) {
    byte b;
    if (paramString.hashCode() == 1756700488 && paramString.equals("PERSON_LIST")) {
      b = 0;
    } else {
      b = -1;
    } 
    if (b != 0)
      return; 
    paramSearchUserFragment.k();
  }
  
  public void a(MvpFragment paramMvpFragment, String paramString, List<Object> paramList) {
    paramMvpFragment = paramMvpFragment;
    if (paramList != null && paramList.size() > 0) {
      byte b = 0;
      Object object = paramList.get(0);
      if (object != null) {
        if (paramString.hashCode() != 1756700488 || !paramString.equals("PERSON_LIST"))
          b = -1; 
        if (b == 0 && UserFindResult.class.isInstance(object)) {
          paramMvpFragment.a((List)paramList);
          return;
        } 
      } 
    } 
    a((SearchUserFragment)paramMvpFragment, paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\fragment\SearchUserFragment_MVP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */