package com.soft.blued.ui.yy_room.presenter;

import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.yy_china.model.YYFollowedModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.soft.blued.user.UserInfo;
import java.util.List;

public class YYFollowedPresenter extends MvpPresenter {
  private int h = 1;
  
  private int i = 20;
  
  private boolean j = false;
  
  private void a(boolean paramBoolean, IFetchDataListener paramIFetchDataListener) {
    if (paramBoolean) {
      this.h = 1;
    } else {
      this.h++;
    } 
    if (!this.j) {
      int i = this.h;
      if (i != 1) {
        this.h = i - 1;
        paramIFetchDataListener.b();
        return;
      } 
    } 
    YYRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<YYFollowedModel.DataBean>>(this, g(), paramIFetchDataListener) {
          protected void a(BluedEntityA<YYFollowedModel.DataBean> param1BluedEntityA) {
            boolean bool = false;
            if (param1BluedEntityA == null || !param1BluedEntityA.hasData()) {
              YYFollowedPresenter.a(this.b, false);
              return;
            } 
            List list = param1BluedEntityA.data;
            this.a.a("show_followed_list", list);
            YYFollowedPresenter yYFollowedPresenter = this.b;
            if (param1BluedEntityA.extra.hasmore == 1)
              bool = true; 
            YYFollowedPresenter.a(yYFollowedPresenter, bool);
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            if (YYFollowedPresenter.b(this.b) != 1)
              YYFollowedPresenter.c(this.b); 
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            if (!YYFollowedPresenter.a(this.b))
              this.a.b(); 
            this.a.a(param1Boolean);
          }
        }(UserInfo.a().i()).uid, this.h, this.i, g());
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {
    a(true, paramIFetchDataListener);
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {
    a(false, paramIFetchDataListener);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\yy_room\presenter\YYFollowedPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */