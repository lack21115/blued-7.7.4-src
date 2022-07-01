package com.soft.blued.ui.msg.presenter;

import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.ui.msg.model.UserGiftPackageModel;
import java.util.ArrayList;

public class UserGiftPresenter extends MvpPresenter {
  public void a(IFetchDataListener paramIFetchDataListener) {
    UserHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<UserGiftPackageModel>>(this, g(), paramIFetchDataListener) {
          protected void a(BluedEntityA<UserGiftPackageModel> param1BluedEntityA) {
            if (param1BluedEntityA.hasData()) {
              this.a.a("DATA_PACKAGE", param1BluedEntityA.data);
              return;
            } 
            this.a.a("DATA_PACKAGE", new ArrayList());
          }
          
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            this.a.a(param1Boolean);
          }
        }g());
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4) {
    UserHttpUtils.a(paramString1, paramString2, paramString3, paramString4, new BluedUIHttpResponse(this, g()) {
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            if (param1Boolean)
              this.a.b("DATA_BUY_SUCCEED"); 
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {}
        }g());
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\presenter\UserGiftPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */