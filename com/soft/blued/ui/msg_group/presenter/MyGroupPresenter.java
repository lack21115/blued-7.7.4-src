package com.soft.blued.ui.msg_group.presenter;

import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.soft.blued.http.MsgGroupHttpUtils;
import com.soft.blued.ui.msg_group.model.MyGroupModel;

public class MyGroupPresenter extends MvpPresenter {
  public int h = 1;
  
  int i = 20;
  
  public int j;
  
  boolean k;
  
  private void c(IFetchDataListener paramIFetchDataListener) {
    MsgGroupHttpUtils.a(g(), this.h, this.i, new BluedUIHttpResponse<BluedEntityA<MyGroupModel>>(this, g(), paramIFetchDataListener) {
          protected void a(BluedEntityA<MyGroupModel> param1BluedEntityA) {
            if (param1BluedEntityA.hasData()) {
              this.b.j = ((MyGroupModel)param1BluedEntityA.data.get(0)).max_join;
              this.a.a("data_group", ((MyGroupModel)param1BluedEntityA.data.get(0)).groups);
              this.b.k = param1BluedEntityA.hasMore();
            } 
          }
          
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            if (!param1Boolean) {
              MyGroupPresenter myGroupPresenter = this.b;
              myGroupPresenter.h--;
            } 
            this.a.a(param1Boolean);
            if (!this.b.k && param1Boolean)
              this.a.b(); 
          }
          
          public void onUIStart() {
            super.onUIStart();
            this.a.a();
          }
        });
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {
    this.h = 1;
    this.k = true;
    c(paramIFetchDataListener);
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {
    this.h++;
    c(paramIFetchDataListener);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg_group\presenter\MyGroupPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */