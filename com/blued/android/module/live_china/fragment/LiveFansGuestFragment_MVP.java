package com.blued.android.module.live_china.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.live_china.model.LiveFansGoodsModel;
import com.blued.android.module.live_china.model.LiveFansInfoModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import java.util.List;

public final class LiveFansGuestFragment_MVP implements MvpDispatcher {
  public void a(MvpFragment paramMvpFragment, String paramString, List<List> paramList) {
    paramMvpFragment = paramMvpFragment;
    if (paramList != null && paramList.size() > 0) {
      byte b = 0;
      paramList = paramList.get(0);
      if (paramList != null) {
        switch (paramString.hashCode()) {
          default:
            b = -1;
            break;
          case 1845895978:
            if (paramString.equals("LIVE_FANS_GOODS")) {
              b = 3;
              break;
            } 
          case 1840016596:
            if (paramString.equals("LIVE_FANS_ADDED")) {
              b = 1;
              break;
            } 
          case 1754487192:
            if (paramString.equals("LIVE_FANS_TICKET")) {
              b = 2;
              break;
            } 
          case 198150714:
            if (paramString.equals("LIVE_FANS_INFO"))
              break; 
        } 
        if (b != 0) {
          if (b != 1) {
            if (b != 2) {
              if (b != 3)
                return; 
              if (LiveFansGoodsModel.class.isInstance(paramList)) {
                paramMvpFragment.a((LiveFansGoodsModel)paramList);
                return;
              } 
            } else if (LiveGiftModel.class.isInstance(paramList)) {
              paramMvpFragment.a((LiveGiftModel)paramList);
              return;
            } 
          } else if (LiveGiftModel.class.isInstance(paramList)) {
            paramMvpFragment.b((LiveGiftModel)paramList);
            return;
          } 
        } else if (LiveFansInfoModel.class.isInstance(paramList)) {
          paramMvpFragment.a((LiveFansInfoModel)paramList);
        } 
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LiveFansGuestFragment_MVP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */