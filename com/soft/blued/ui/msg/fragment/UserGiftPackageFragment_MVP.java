package com.soft.blued.ui.msg.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.soft.blued.ui.msg.model.UserGiftPackageModel;
import java.util.List;

public final class UserGiftPackageFragment_MVP implements MvpDispatcher {
  private void a(UserGiftPackageFragment paramUserGiftPackageFragment, String paramString) {
    byte b;
    if (paramString.hashCode() == -1784691660 && paramString.equals("DATA_BUY_SUCCEED")) {
      b = 0;
    } else {
      b = -1;
    } 
    if (b != 0)
      return; 
    paramUserGiftPackageFragment.E();
  }
  
  public void a(MvpFragment paramMvpFragment, String paramString, List<Object> paramList) {
    paramMvpFragment = paramMvpFragment;
    if (paramList != null && paramList.size() > 0) {
      byte b = 0;
      Object object = paramList.get(0);
      if (object != null) {
        if (paramString.hashCode() != 771425425 || !paramString.equals("DATA_PACKAGE"))
          b = -1; 
        if (b == 0 && UserGiftPackageModel.class.isInstance(object)) {
          paramMvpFragment.c((List)paramList);
          return;
        } 
      } 
    } 
    a((UserGiftPackageFragment)paramMvpFragment, paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\fragment\UserGiftPackageFragment_MVP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */