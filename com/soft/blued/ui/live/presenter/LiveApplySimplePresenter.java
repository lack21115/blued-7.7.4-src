package com.soft.blued.ui.live.presenter;

import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.live_china.model.BluedLiveState;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.soft.blued.ui.live.model.BluedLiveListData;
import com.soft.blued.user.UserInfo;

public class LiveApplySimplePresenter extends MvpPresenter {
  public void a(IFetchDataListener paramIFetchDataListener) {}
  
  public void a(String paramString1, String paramString2) {
    LiveRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<BluedLiveListData>>(this, g()) {
          protected void a(BluedEntityA<BluedLiveListData> param1BluedEntityA) {
            this.a.b("LIVE_SIMPLE__APPLY");
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            AppMethods.a(param1String);
            return false;
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            this.a.b("LIVE_SIMPLE__APPLY", true);
          }
          
          public void onUIStart() {
            super.onUIStart();
            this.a.e_("LIVE_SIMPLE__APPLY");
          }
        }UserInfo.a().i().getUid(), g(), 1, paramString1, paramString2, 1);
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {}
  
  public void m() {
    LiveRoomHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<BluedLiveState>>(this, g()) {
          public void a(BluedEntityA<BluedLiveState> param1BluedEntityA) {
            if (param1BluedEntityA != null)
              this.a.a("LIVE_APPLY", param1BluedEntityA.data); 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            AppMethods.a(param1String);
            return true;
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            this.a.b("LIVE_APPLY", true);
          }
          
          public void onUIStart() {
            super.onUIStart();
            this.a.e_("LIVE_APPLY");
          }
        }UserInfo.a().i().getUid(), g());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\presenter\LiveApplySimplePresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */