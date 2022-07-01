package com.blued.android.module.live_china.presenter;

import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;

public class LiveMakeLoverOkPresent extends MvpPresenter {
  public void a(IFetchDataListener paramIFetchDataListener) {}
  
  public void a(String paramString1, String paramString2) {
    LiveRoomHttpUtils.d(new BluedUIHttpResponse(this, g()) {
          public boolean onUIFailure(int param1Int, String param1String) {
            AppMethods.a(param1String);
            this.a.b("MAKE_LOVER_OK", false);
            return true;
          }
          
          public void onUIFinish() {
            super.onUIFinish();
          }
          
          public void onUIStart() {
            super.onUIStart();
            this.a.e_("MAKE_LOVER_OK");
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            this.a.b("MAKE_LOVER_OK", true);
          }
        }paramString1, paramString2);
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {}
  
  public boolean c() {
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\presenter\LiveMakeLoverOkPresent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */