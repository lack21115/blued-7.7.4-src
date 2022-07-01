package com.soft.blued.ui.user.presenter;

import android.app.Activity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.common.utils.ToastUtils;
import com.soft.blued.ui.user.manager.VipBubbleManager;

public class VipBubblePresenter extends MvpPresenter {
  public void a(IFetchDataListener paramIFetchDataListener) {
    VipBubbleManager.a().a(new VipBubbleManager.RefreshListener(this, paramIFetchDataListener) {
          public void a() {
            this.a.a("data_bubble", VipBubbleManager.a().d());
          }
        }g());
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\presenter\VipBubblePresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */