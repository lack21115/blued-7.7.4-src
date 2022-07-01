package com.soft.blued.ui.user.presenter;

import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.ui.user.contract.InterestGalleryContract;
import com.soft.blued.ui.user.model.PictureTabModel;

public class InterestGalleryPresenter implements InterestGalleryContract.IPresenter {
  private InterestGalleryContract.IView a;
  
  private IRequestHost b;
  
  public InterestGalleryPresenter(InterestGalleryContract.IView paramIView, IRequestHost paramIRequestHost) {
    this.a = paramIView;
    this.b = paramIRequestHost;
  }
  
  public void b() {
    MineHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<PictureTabModel>>(this) {
          protected void a(BluedEntityA<PictureTabModel> param1BluedEntityA) {
            if (param1BluedEntityA != null)
              try {
                if (param1BluedEntityA.hasData()) {
                  InterestGalleryPresenter.a(this.a).a(param1BluedEntityA.data);
                  return;
                } 
              } catch (Exception exception) {
                exception.printStackTrace();
              }  
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            InterestGalleryPresenter.a(this.a).a();
          }
        },  this.b);
  }
  
  public void bb_() {
    b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\presenter\InterestGalleryPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */