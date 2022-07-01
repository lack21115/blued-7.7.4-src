package com.soft.blued.ui.live.presenter;

import android.util.Log;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.module.live_china.model.BluedLiveState;
import com.soft.blued.http.LiveHttpUtils;
import com.soft.blued.ui.live.model.LiveIDCardUploadResult;
import com.soft.blued.user.UserInfo;

public class LiveApplyImprovePresenter extends LiveBaseImprovePresenter {
  public void a(int paramInt, String paramString) {
    LiveHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<LiveIDCardUploadResult>>(this, g(), paramInt) {
          protected void a(BluedEntityA<LiveIDCardUploadResult> param1BluedEntityA) {
            if (param1BluedEntityA != null) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("上传图片成功：");
              stringBuilder.append(this.a);
              Log.v("pk", stringBuilder.toString());
              int i = this.a;
              if (i != 0) {
                if (i != 1)
                  return; 
                this.b.a("LIVE_CARD_BACK_UPLOAD", param1BluedEntityA.data);
                return;
              } 
              this.b.a("LIVE_CARD_FRONT_UPLOAD", param1BluedEntityA.data);
            } 
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            int i = this.a;
            if (i != 0) {
              if (i != 1)
                return; 
              this.b.b("LIVE_CARD_BACK_UPLOAD", true);
              return;
            } 
            this.b.b("LIVE_CARD_FRONT_UPLOAD", true);
          }
        }UserInfo.a().i().getUid(), paramInt, paramString, g());
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {}
  
  public void a(boolean paramBoolean) {
    LiveHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<BluedLiveState>>(this, g(), paramBoolean) {
          public void a(BluedEntityA<BluedLiveState> param1BluedEntityA) {
            if (param1BluedEntityA != null) {
              this.b.a("LIVE_IMPROVE_STATE", param1BluedEntityA.data);
              if (this.a && param1BluedEntityA.data.size() > 0 && param1BluedEntityA.data.get(0) != null) {
                BluedLiveState bluedLiveState = param1BluedEntityA.data.get(0);
                if (bluedLiveState.idcard_verify_status != 1) {
                  AppMethods.a(bluedLiveState.idcard_verify_fail_reason);
                  return;
                } 
                this.b.b("LIVE_SHOW_AGREEMENT");
                this.b.h().finish();
              } 
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            AppMethods.a(param1String);
            return true;
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            this.b.b("LIVE_IMPROVE_STATE", true);
          }
          
          public void onUIStart() {
            super.onUIStart();
            this.b.e_("LIVE_IMPROVE_STATE");
          }
        }UserInfo.a().i().getUid(), g());
  }
  
  public void b(int paramInt, String paramString) {
    LiveHttpUtils.d(new BluedUIHttpResponse(this, g(), paramInt) {
          public boolean onUIFailure(int param1Int, String param1String) {
            AppMethods.a(param1String);
            return true;
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            int i = this.a;
            if (i != 0) {
              if (i != 1)
                return; 
              this.b.b("LIVE_CARD_BACK_DELETE", true);
              return;
            } 
            this.b.b("LIVE_CARD_FRONT_DELETE", true);
          }
          
          public void onUIStart() {
            super.onUIStart();
            int i = this.a;
            if (i != 0) {
              if (i != 1)
                return; 
              this.b.e_("LIVE_CARD_BACK_DELETE");
              return;
            } 
            this.b.e_("LIVE_CARD_FRONT_DELETE");
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            int i = this.a;
            if (i != 0) {
              if (i != 1)
                return; 
              this.b.b("LIVE_CARD_BACK_DELETE");
              return;
            } 
            this.b.b("LIVE_CARD_FRONT_DELETE");
          }
        }UserInfo.a().i().getUid(), paramInt, paramString, g());
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\presenter\LiveApplyImprovePresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */