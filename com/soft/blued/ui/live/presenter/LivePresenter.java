package com.soft.blued.ui.live.presenter;

import android.content.Context;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.live_china.model.BluedLiveState;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.soft.blued.http.FeedHttpUtils;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.Logger;

public class LivePresenter extends MvpPresenter {
  public void a(IFetchDataListener paramIFetchDataListener) {
    m();
  }
  
  public void a(String paramString1, String paramString2) {
    FeedHttpUtils.a((Context)h(), new BluedUIHttpResponse(this, g()) {
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            AppMethods.d(2131758599);
          }
        }paramString1, paramString2, g());
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {}
  
  public void m() {
    LiveRoomHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<BluedLiveState>>(this) {
          protected BluedEntityA<BluedLiveState> a(String param1String) {
            Logger.a("livestate", new Object[] { param1String });
            return (BluedEntityA<BluedLiveState>)super.parseData(param1String);
          }
          
          public void a(BluedEntityA<BluedLiveState> param1BluedEntityA) {
            if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0)
              this.a.a("LIVE_STATE", param1BluedEntityA.data.get(0)); 
            this.a.b("LIVE_STATE", true);
          }
          
          public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
            super.onFailure(param1Throwable, param1Int, param1String);
            this.a.b("LIVE_STATE", false);
          }
        }UserInfo.a().i().getUid(), g());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\presenter\LivePresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */