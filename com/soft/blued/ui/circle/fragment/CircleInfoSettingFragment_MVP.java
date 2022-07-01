package com.soft.blued.ui.circle.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.soft.blued.ui.circle.model.MyCircleModel;
import java.util.List;

public final class CircleInfoSettingFragment_MVP implements MvpDispatcher {
  public void a(MvpFragment paramMvpFragment, String paramString, List<List> paramList) {
    CircleInfoSettingFragment circleInfoSettingFragment = (CircleInfoSettingFragment)paramMvpFragment;
    if (paramList != null && paramList.size() > 0) {
      byte b = 0;
      paramList = paramList.get(0);
      if (paramList != null) {
        if (paramString.hashCode() != -1519155757 || !paramString.equals("circle_details"))
          b = -1; 
        if (b != 0)
          return; 
        if (MyCircleModel.class.isInstance(paramList))
          circleInfoSettingFragment.a((MyCircleModel)paramList); 
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\fragment\CircleInfoSettingFragment_MVP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */