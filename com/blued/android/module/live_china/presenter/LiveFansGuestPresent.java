package com.blued.android.module.live_china.presenter;

import android.content.Context;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveFansGoodsModel;
import com.blued.android.module.live_china.model.LiveFansInfoModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.LiveGiftPayTools;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import java.util.List;

public class LiveFansGuestPresent extends MvpPresenter {
  public void a(long paramLong, short paramShort, String paramString, LiveGiftModel paramLiveGiftModel) {
    if (paramLiveGiftModel == null) {
      Logger.a("ddrb", new Object[] { "LiveGiftModel is null " });
      return;
    } 
    LiveGiftPayTools.a().a((Context)h(), paramShort, paramLong, 1, g(), paramLiveGiftModel, paramString, "", 1, new LiveGiftPayTools.BackGiftStatusListener(this) {
          public void a() {
            LiveRefreshUIObserver.a().b(true);
          }
          
          public void a(LiveGiftModel param1LiveGiftModel1, LiveGiftModel param1LiveGiftModel2, List<LiveGiftModel> param1List) {
            AppInfo.n().post(new Runnable(this, param1LiveGiftModel1, param1LiveGiftModel2) {
                  public void run() {
                    Logger.a("ddrb", new Object[] { "onGiftStatus ----- " });
                    KeyboardUtils.a(this.c.a.h());
                    this.a.sendGiftStatus = this.b.sendGiftStatus;
                    if (this.b.sendGiftStatus == 3) {
                      this.c.a.a("LIVE_FANS_ADDED", this.b);
                      Logger.a("ddrb", new Object[] { "onGiftStatus ===== " });
                    } 
                  }
                });
          }
        });
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {}
  
  public void a(String paramString, long paramLong) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    LiveRoomHttpUtils.a(paramString, stringBuilder.toString(), new BluedUIHttpResponse<BluedEntityA<LiveFansInfoModel>>(this, null) {
          protected void a(BluedEntityA<LiveFansInfoModel> param1BluedEntityA) {
            if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
              LiveRoomManager.a().a(param1BluedEntityA.data.get(0));
              this.a.a("LIVE_FANS_INFO", param1BluedEntityA.data.get(0));
            } 
            this.a.b("LIVE_FANS_INFO", true);
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            AppMethods.a(param1String);
            this.a.b("LIVE_FANS_INFO", false);
            return true;
          }
          
          public void onUIStart() {
            super.onUIStart();
            this.a.e_("LIVE_FANS_INFO");
          }
        }null);
  }
  
  public void a(String paramString1, String paramString2, String paramString3) {}
  
  public void b(IFetchDataListener paramIFetchDataListener) {}
  
  public void d(String paramString) {
    LiveRoomHttpUtils.e(paramString, new BluedUIHttpResponse<BluedEntityA<LiveFansGoodsModel>>(this, g()) {
          protected void a(BluedEntityA<LiveFansGoodsModel> param1BluedEntityA) {
            if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0)
              this.a.a("LIVE_FANS_GOODS", param1BluedEntityA.data.get(0)); 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            AppMethods.a(param1String);
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
  
  public void m() {
    LiveRoomHttpUtils.d(new BluedUIHttpResponse<BluedEntityA<LiveGiftModel>>(this, null) {
          protected void a(BluedEntityA<LiveGiftModel> param1BluedEntityA) {
            if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0)
              this.a.a("LIVE_FANS_TICKET", param1BluedEntityA.data.get(0)); 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            AppMethods.a(param1String);
            return true;
          }
          
          public void onUIFinish() {
            super.onUIFinish();
          }
          
          public void onUIStart() {
            super.onUIStart();
          }
        }null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\presenter\LiveFansGuestPresent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */