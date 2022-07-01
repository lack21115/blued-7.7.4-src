package com.soft.blued.ui.notify.presenter;

import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.soft.blued.http.CircleHttpUtils;
import com.soft.blued.ui.notify.model.CircleNotify;

public class CircleNotifyListPresenter extends MvpPresenter {
  private int h = 1;
  
  private int i = 20;
  
  private boolean j;
  
  private void c(IFetchDataListener paramIFetchDataListener) {
    if (this.h == 1)
      this.j = true; 
    if (!this.j)
      return; 
    CircleHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<CircleNotify>>(this, g(), paramIFetchDataListener) {
          protected void a(BluedEntityA<CircleNotify> param1BluedEntityA) {
            if (param1BluedEntityA != null) {
              if (param1BluedEntityA.hasData())
                this.a.a("notify_list", param1BluedEntityA.data); 
              CircleNotifyListPresenter.a(this.b, param1BluedEntityA.hasMore());
              return;
            } 
            CircleNotifyListPresenter.a(this.b, false);
          }
          
          public void onUIFinish(boolean param1Boolean) {
            if (!param1Boolean && CircleNotifyListPresenter.a(this.b) != 1)
              CircleNotifyListPresenter.b(this.b); 
            if (!CircleNotifyListPresenter.c(this.b))
              this.a.b(); 
            this.a.a(param1Boolean);
          }
        }this.h, this.i, g());
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {
    this.h = 1;
    c(paramIFetchDataListener);
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {
    this.h++;
    c(paramIFetchDataListener);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\notify\presenter\CircleNotifyListPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */