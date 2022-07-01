package com.blued.android.module.live_china.presenter;

import android.content.Context;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.contrast.LiveRewardDetailsContract;
import com.blued.android.module.live_china.model.LiveRewardExtraModel;
import com.blued.android.module.live_china.model.LiveRewardListModel;
import com.blued.android.module.live_china.model.RewardDetailsCommonModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;

public class LiveRewardDetailsPresenter implements LiveRewardDetailsContract.IPresenter {
  private Context a;
  
  private IRequestHost b;
  
  private RewardDetailsCommonModel c;
  
  private long d;
  
  private String e;
  
  private LiveRewardDetailsContract.IView f;
  
  public LiveRewardDetailsPresenter(Context paramContext, LiveRewardDetailsContract.IView paramIView, IRequestHost paramIRequestHost, RewardDetailsCommonModel paramRewardDetailsCommonModel, String paramString, long paramLong) {
    this.b = paramIRequestHost;
    this.c = paramRewardDetailsCommonModel;
    this.a = paramContext;
    this.e = paramString;
    this.d = paramLong;
    this.f = paramIView;
  }
  
  public void b() {
    LiveRoomHttpUtils.b(new BluedUIHttpResponse<BluedEntity<LiveRewardListModel, LiveRewardExtraModel>>(this, this.b) {
          public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
            super.onFailure(param1Throwable, param1Int, param1String);
            AppInfo.n().post(new Runnable(this) {
                  public void run() {
                    LiveRewardDetailsPresenter.a(this.a.a).a(null, false);
                  }
                });
          }
          
          public void onUIFinish() {
            LiveRewardDetailsPresenter.a(this.a).d();
          }
          
          public void onUIUpdate(BluedEntity<LiveRewardListModel, LiveRewardExtraModel> param1BluedEntity) {
            try {
              if (param1BluedEntity.extra != null) {
                LiveRewardExtraModel liveRewardExtraModel = (LiveRewardExtraModel)param1BluedEntity.extra;
                LiveRewardDetailsPresenter.a(this.a).a(liveRewardExtraModel);
              } 
              if (param1BluedEntity.data != null && param1BluedEntity.data.size() > 0) {
                if (param1BluedEntity.hasMore()) {
                  (LiveRewardDetailsPresenter.b(this.a)).hasData = true;
                  LiveRewardDetailsPresenter.a(this.a).e();
                } else {
                  (LiveRewardDetailsPresenter.b(this.a)).hasData = false;
                  LiveRewardDetailsPresenter.a(this.a).c();
                } 
                if ((LiveRewardDetailsPresenter.b(this.a)).page == 1) {
                  LiveRewardDetailsPresenter.a(this.a).a(param1BluedEntity.data, false);
                  return;
                } 
                LiveRewardDetailsPresenter.a(this.a).a(param1BluedEntity.data, true);
                return;
              } 
              if ((LiveRewardDetailsPresenter.b(this.a)).page == 1) {
                LiveRewardDetailsPresenter.a(this.a).a(param1BluedEntity.data, false);
              } else {
                (LiveRewardDetailsPresenter.b(this.a)).page--;
              } 
              LiveRewardDetailsPresenter.a(this.a).c();
              return;
            } catch (Exception exception) {
              exception.printStackTrace();
              if ((LiveRewardDetailsPresenter.b(this.a)).page != 1)
                (LiveRewardDetailsPresenter.b(this.a)).page--; 
              AppMethods.a(LiveRewardDetailsPresenter.c(this.a).getResources().getString(R.string.common_net_error));
              return;
            } 
          }
          
          public BluedEntity<LiveRewardListModel, LiveRewardExtraModel> parseData(String param1String) {
            return super.parseData(param1String);
          }
        }this.e, String.valueOf(this.d), String.valueOf(this.c.page), String.valueOf(this.c.last_record_id));
  }
  
  public void bb_() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\presenter\LiveRewardDetailsPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */