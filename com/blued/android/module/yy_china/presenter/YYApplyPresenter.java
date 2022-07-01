package com.blued.android.module.yy_china.presenter;

import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYLiveState;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;

public class YYApplyPresenter extends MvpPresenter {
  private void m() {
    YYRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<YYLiveState>>(this, g()) {
          protected void a(BluedEntityA<YYLiveState> param1BluedEntityA) {
            if (param1BluedEntityA != null) {
              if (!param1BluedEntityA.hasData())
                return; 
              this.a.a("yy_apply_state", param1BluedEntityA.data.get(0));
            } 
          }
        }YYRoomInfoManager.d().c().c(), g());
  }
  
  public int a(int paramInt) {
    return h().getResources().getColor(paramInt);
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {
    m();
  }
  
  public void a(String paramString1, String paramString2, String paramString3) {
    YYRoomHttpUtils.a(paramString1, paramString2, paramString3, new BluedUIHttpResponse<BluedEntityA<Object>>(this, g()) {
          protected void a(BluedEntityA<Object> param1BluedEntityA) {
            this.a.a("yy_apply_submit", false);
          }
        }g());
  }
  
  public String b(int paramInt) {
    return h().getResources().getString(paramInt);
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\presenter\YYApplyPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */