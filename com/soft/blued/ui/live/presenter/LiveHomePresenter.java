package com.soft.blued.ui.live.presenter;

import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveLiangModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.soft.blued.http.LiveHttpUtils;
import com.soft.blued.ui.live.model.BannerModel;
import com.soft.blued.ui.live.model.LiveFollowCurrent;
import com.soft.blued.ui.live.model.LiveTabInfo;
import com.soft.blued.ui.live.model.LiveTabModel;
import com.soft.blued.ui.live.model.LiveTwoFloorModel;

public class LiveHomePresenter extends MvpPresenter {
  private static final String h = LiveHomePresenter.class.getSimpleName();
  
  private int i = 0;
  
  public void a(IFetchDataListener paramIFetchDataListener) {
    if (this.i == 0)
      m(); 
    c(paramIFetchDataListener);
    n();
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {}
  
  public void c(IFetchDataListener paramIFetchDataListener) {
    LiveHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<BannerModel>>(this, paramIFetchDataListener) {
          public void a(BluedEntityA<BannerModel> param1BluedEntityA) {
            if (param1BluedEntityA != null)
              try {
                this.a.a("BANNER_INFO", param1BluedEntityA.data);
                return;
              } catch (Exception exception) {
                exception.printStackTrace();
                AppMethods.a(this.b.h().getResources().getString(2131756082));
              }  
          }
          
          public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
            super.onFailure(param1Throwable, param1Int, param1String);
            AppInfo.n().post(new Runnable(this) {
                  public void run() {
                    this.a.a.a("BANNER_INFO", null);
                  }
                });
          }
        }"hot", null);
  }
  
  public boolean c() {
    return false;
  }
  
  public void m() {
    LiveHttpUtils.d(new BluedUIHttpResponse<BluedEntity<LiveTabModel, LiveTabModel>>(this, g()) {
          public void onUICache(BluedEntity<LiveTabModel, LiveTabModel> param1BluedEntity) {
            if (param1BluedEntity.extra != null)
              ((LiveTabModel)param1BluedEntity.extra).default_cate_id = "0"; 
            if (param1BluedEntity != null && param1BluedEntity.data != null) {
              LiveTabInfo liveTabInfo = new LiveTabInfo();
              liveTabInfo.liveTabs.addAll(param1BluedEntity.data);
              liveTabInfo.liveTabModelExtra = (LiveTabModel)param1BluedEntity.extra;
              LiveHomePresenter.a(this.a, param1BluedEntity.data.size());
              this.a.a("LIST_TAB", liveTabInfo);
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            return true;
          }
          
          public void onUIFinish() {
            super.onUIFinish();
          }
          
          public void onUIStart() {
            super.onUIStart();
          }
          
          public void onUIUpdate(BluedEntity<LiveTabModel, LiveTabModel> param1BluedEntity) {
            if (param1BluedEntity != null && param1BluedEntity.data != null) {
              LiveTabInfo liveTabInfo = new LiveTabInfo();
              liveTabInfo.liveTabs.addAll(param1BluedEntity.data);
              liveTabInfo.liveTabModelExtra = (LiveTabModel)param1BluedEntity.extra;
              LiveHomePresenter.a(this.a, param1BluedEntity.data.size());
              this.a.a("LIST_TAB", liveTabInfo);
            } 
          }
        }g());
  }
  
  public void n() {
    LiveHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<LiveTwoFloorModel>>(this, g()) {
          public void a(BluedEntityA<LiveTwoFloorModel> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.data != null) {
              this.a.a("TWO_LEVEL", param1BluedEntityA.data);
              return;
            } 
            this.a.b("TWO_LEVEL");
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            return true;
          }
          
          public void onUIFinish() {
            super.onUIFinish();
          }
          
          public void onUIStart() {
            super.onUIStart();
          }
        }g());
  }
  
  public void o() {
    LiveRoomHttpUtils.r(new BluedUIHttpResponse<BluedEntityA<LiveLiangModel>>(this, g()) {
          protected void a(BluedEntityA<LiveLiangModel> param1BluedEntityA) {
            if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
              LiveRoomManager.a().a(param1BluedEntityA.data.get(0));
              this.a.a("LIVE_LIANG_ID", param1BluedEntityA.data);
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            this.a.a("LIVE_LIANG_ID", (Object)null);
            return true;
          }
          
          public void onUIFinish() {
            super.onUIFinish();
          }
          
          public void onUIStart() {
            super.onUIStart();
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\presenter\LiveHomePresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */