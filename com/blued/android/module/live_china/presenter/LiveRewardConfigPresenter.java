package com.blued.android.module.live_china.presenter;

import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.live_china.live_interface.IRewardConfigView;
import com.blued.android.module.live_china.model.LiveRewardConfigModel;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;

public class LiveRewardConfigPresenter {
  private IRewardConfigView a;
  
  private IRequestHost b;
  
  public LiveRewardConfigPresenter(IRewardConfigView paramIRewardConfigView, IRequestHost paramIRequestHost) {
    this.a = paramIRewardConfigView;
    this.b = paramIRequestHost;
  }
  
  public void a() {
    Logger.a("drb", new Object[] { "getRewardConfig" });
    LiveRoomHttpUtils.i(new BluedUIHttpResponse<BluedEntityA<LiveRewardConfigModel>>(this, this.b) {
          protected void a(BluedEntityA<LiveRewardConfigModel> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0)
              LiveRewardConfigPresenter.a(this.a).a(param1BluedEntityA.data.get(0)); 
          }
          
          public void onUIFinish() {
            super.onUIFinish();
          }
          
          public void onUIStart() {
            super.onUIStart();
            LiveRewardConfigPresenter.a(this.a).a();
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\presenter\LiveRewardConfigPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */