package com.blued.android.module.yy_china.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.yy_china.model.YYRankModel;
import java.util.List;

public final class YYRankItemFragment_MVP implements MvpDispatcher {
  private void a(YYRankItemFragment paramYYRankItemFragment, String paramString) {
    byte b;
    if (paramString.hashCode() == -315448516 && paramString.equals("show_nodata_layout")) {
      b = 0;
    } else {
      b = -1;
    } 
    if (b != 0)
      return; 
    paramYYRankItemFragment.k();
  }
  
  public void a(MvpFragment paramMvpFragment, String paramString, List<Object> paramList) {
    paramMvpFragment = paramMvpFragment;
    if (paramList != null && paramList.size() > 0) {
      byte b = 0;
      YYRankModel yYRankModel = (YYRankModel)paramList.get(0);
      if (yYRankModel != null) {
        switch (paramString.hashCode()) {
          default:
            b = -1;
            break;
          case 1231889178:
            if (paramString.equals("show_no2_layout")) {
              b = 1;
              break;
            } 
          case -510921157:
            if (paramString.equals("show_no1_layout"))
              break; 
          case -1320267783:
            if (paramString.equals("show_no3_layout")) {
              b = 2;
              break;
            } 
          case -1923833943:
            if (paramString.equals("show_list_layout")) {
              b = 3;
              break;
            } 
        } 
        if (b != 0) {
          if (b != 1) {
            if (b != 2) {
              if (b == 3 && YYRankModel.class.isInstance(yYRankModel)) {
                paramMvpFragment.a((List)paramList);
                return;
              } 
            } else if (YYRankModel.class.isInstance(yYRankModel)) {
              paramMvpFragment.c(yYRankModel);
              return;
            } 
          } else if (YYRankModel.class.isInstance(yYRankModel)) {
            paramMvpFragment.b(yYRankModel);
            return;
          } 
        } else if (YYRankModel.class.isInstance(yYRankModel)) {
          paramMvpFragment.a(yYRankModel);
          return;
        } 
      } 
    } 
    a((YYRankItemFragment)paramMvpFragment, paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\fragment\YYRankItemFragment_MVP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */