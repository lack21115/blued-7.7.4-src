package com.blued.android.module.live_china.presenter;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.live_china.live_interface.IGrabRewardView;
import com.blued.android.module.live_china.model.LiveRewardExtraModel;
import com.blued.android.module.live_china.model.LiveRewardListModel;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;

public class LiveGrabRewardPresenter {
  private IGrabRewardView a;
  
  private IRequestHost b;
  
  public LiveGrabRewardPresenter(IGrabRewardView paramIGrabRewardView, IRequestHost paramIRequestHost) {
    this.a = paramIGrabRewardView;
    this.b = paramIRequestHost;
  }
  
  public void a(String paramString1, long paramLong, String paramString2, String paramString3) {
    LiveRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntity<LiveRewardListModel, LiveRewardExtraModel>>(this, this.b, paramString3) {
          public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
            AppInfo.n().post(new Runnable(this, param1Throwable, param1Int, param1String) {
                  public void run() {
                    LiveGrabRewardPresenter.a(this.d.b).a(this.a, this.b, this.c);
                  }
                });
          }
          
          public void onUIFinish() {}
          
          public void onUIStart() {
            super.onUIStart();
            LiveGrabRewardPresenter.a(this.b).f();
          }
          
          public void onUIUpdate(BluedEntity<LiveRewardListModel, LiveRewardExtraModel> param1BluedEntity) {
            try {
              if (param1BluedEntity.data != null && param1BluedEntity.data.size() > 0) {
                LiveGrabRewardPresenter.a(this.b).a(param1BluedEntity.data.get(0));
                if (!TextUtils.isEmpty(this.a))
                  LiveSetDataObserver.a().c(this.a); 
              } 
              return;
            } catch (Exception exception) {
              return;
            } 
          }
          
          public BluedEntity<LiveRewardListModel, LiveRewardExtraModel> parseData(String param1String) {
            return super.parseData(param1String);
          }
        }paramString1, String.valueOf(paramLong), paramString2, paramString3);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\presenter\LiveGrabRewardPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */