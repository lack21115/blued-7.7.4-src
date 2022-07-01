package com.blued.android.module.live_china.presenter;

import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveFansMemberModel;
import com.blued.android.module.live_china.model.LiveFriendModel;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;

public class LiveMakeLoverApplyGuestPresent extends MvpPresenter {
  public int h = 0;
  
  public void a(IFetchDataListener paramIFetchDataListener) {}
  
  public void a(String paramString1, String paramString2) {
    LiveRoomHttpUtils.e(paramString1, paramString2, new BluedUIHttpResponse<BluedEntityA<LiveFansMemberModel>>(this, g()) {
          protected void a(BluedEntityA<LiveFansMemberModel> param1BluedEntityA) {
            this.a.b("LIVE_MAKE_LOVER_APPLY");
            this.a.b("LIVE_MAKE_LOVER_APPLY", true);
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            LiveMakeLoverApplyGuestPresent liveMakeLoverApplyGuestPresent = this.a;
            liveMakeLoverApplyGuestPresent.h = param1Int;
            liveMakeLoverApplyGuestPresent.b("LIVE_MAKE_LOVER_APPLY", false);
            AppMethods.a(param1String);
            return true;
          }
          
          public void onUIStart() {
            super.onUIStart();
            this.a.e_("LIVE_MAKE_LOVER_APPLY");
          }
        }g());
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {}
  
  public void d(String paramString) {
    LiveRoomInfo.a().a(new PermissionCallbacks(this, paramString) {
          public void a(String[] param1ArrayOfString) {
            LiveMsgSendManager.a().b("关闭权限");
            this.b.f(this.a);
          }
          
          public void aa_() {
            LiveMsgSendManager.a().b("开启权限");
            LiveRoomHttpUtils.t(new BluedUIHttpResponse<BluedEntity<LiveFriendModel, LiveFriendModel>>(this, this.b.g()) {
                  public boolean onUIFailure(int param2Int, String param2String) {
                    this.a.b.h = param2Int;
                    this.a.b.b("LIVE_MAKE_LOVER_START", false);
                    AppMethods.a(param2String);
                    return true;
                  }
                  
                  public void onUIStart() {
                    super.onUIStart();
                    this.a.b.e_("LIVE_MAKE_LOVER_START");
                  }
                  
                  public void onUIUpdate(BluedEntity<LiveFriendModel, LiveFriendModel> param2BluedEntity) {
                    this.a.b.b("LIVE_MAKE_LOVER_START");
                    this.a.b.b("LIVE_MAKE_LOVER_START", true);
                  }
                }this.a);
          }
        });
  }
  
  public void e(String paramString) {
    LiveRoomHttpUtils.u(new BluedUIHttpResponse(this, g()) {
          public boolean onUIFailure(int param1Int, String param1String) {
            LiveMakeLoverApplyGuestPresent liveMakeLoverApplyGuestPresent = this.a;
            liveMakeLoverApplyGuestPresent.h = param1Int;
            liveMakeLoverApplyGuestPresent.b("LIVE_MAKE_LOVER_CANCEL", false);
            AppMethods.a(param1String);
            return true;
          }
          
          public void onUIFinish() {
            super.onUIFinish();
          }
          
          public void onUIStart() {
            super.onUIStart();
            this.a.e_("LIVE_MAKE_LOVER_CANCEL");
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            this.a.b("LIVE_MAKE_LOVER_CANCEL");
            this.a.b("LIVE_MAKE_LOVER_CANCEL", true);
          }
        }paramString);
  }
  
  public void f(String paramString) {
    LiveRoomHttpUtils.v(new BluedUIHttpResponse(this, g()) {
          public boolean onUIFailure(int param1Int, String param1String) {
            LiveMakeLoverApplyGuestPresent liveMakeLoverApplyGuestPresent = this.a;
            liveMakeLoverApplyGuestPresent.h = param1Int;
            liveMakeLoverApplyGuestPresent.b("LIVE_MAKE_LOVER_REFUSE", false);
            AppMethods.a(param1String);
            return true;
          }
          
          public void onUIFinish() {
            super.onUIFinish();
          }
          
          public void onUIStart() {
            super.onUIStart();
            this.a.e_("LIVE_MAKE_LOVER_REFUSE");
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            this.a.b("LIVE_MAKE_LOVER_REFUSE");
            this.a.b("LIVE_MAKE_LOVER_REFUSE", true);
          }
        }paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\presenter\LiveMakeLoverApplyGuestPresent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */