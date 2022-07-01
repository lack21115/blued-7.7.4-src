package com.soft.blued.ui.msg_group.presenter;

import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.soft.blued.http.MsgGroupHttpUtils;
import com.soft.blued.ui.msg_group.model.GroupNoticeModel;

public class GroupNoticePresenter extends MvpPresenter {
  public int h = 1;
  
  int i = 20;
  
  boolean j;
  
  private void c(IFetchDataListener paramIFetchDataListener) {
    MsgGroupHttpUtils.b(g(), this.h, this.i, new BluedUIHttpResponse<BluedEntityA<GroupNoticeModel>>(this, g(), paramIFetchDataListener) {
          protected void a(BluedEntityA<GroupNoticeModel> param1BluedEntityA) {
            if (param1BluedEntityA.hasData()) {
              this.a.a("data_notice", param1BluedEntityA.data);
              this.b.j = param1BluedEntityA.hasMore();
            } 
          }
          
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            if (!param1Boolean) {
              GroupNoticePresenter groupNoticePresenter = this.b;
              groupNoticePresenter.h--;
            } 
            this.a.a(param1Boolean);
            if (!this.b.j && param1Boolean)
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
    this.j = true;
    c(paramIFetchDataListener);
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {
    this.h++;
    c(paramIFetchDataListener);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg_group\presenter\GroupNoticePresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */