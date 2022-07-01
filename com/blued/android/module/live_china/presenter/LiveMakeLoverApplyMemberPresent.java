package com.blued.android.module.live_china.presenter;

import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.live_china.model.LiveMakeLoverApplyMemberModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;

public class LiveMakeLoverApplyMemberPresent extends MvpPresenter {
  public int h = 0;
  
  private int i = 1;
  
  private String j;
  
  private String k;
  
  public void a(IFetchDataListener paramIFetchDataListener) {
    this.i = 1;
    c(paramIFetchDataListener);
  }
  
  public void a(LiveMakeLoverApplyMemberModel paramLiveMakeLoverApplyMemberModel) {
    if (paramLiveMakeLoverApplyMemberModel == null)
      return; 
    LiveRoomHttpUtils.c(this.j, paramLiveMakeLoverApplyMemberModel.uid, new BluedUIHttpResponse(this, g(), paramLiveMakeLoverApplyMemberModel) {
          public boolean onUIFailure(int param1Int, String param1String) {
            this.b.h = param1Int;
            AppMethods.a(param1String);
            this.b.b("LIVE_MAKE_LOVER_AGREE", false);
            return true;
          }
          
          public void onUIStart() {
            super.onUIStart();
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            LiveMakeLoverApplyMemberPresent liveMakeLoverApplyMemberPresent = this.b;
            liveMakeLoverApplyMemberPresent.h = 0;
            liveMakeLoverApplyMemberPresent.a("LIVE_MAKE_LOVER_AGREE", this.a);
            this.b.b("LIVE_MAKE_LOVER_AGREE", true);
          }
        }g());
  }
  
  public void a(String paramString1, String paramString2) {
    this.j = paramString1;
    this.k = paramString2;
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {
    this.i++;
    c(paramIFetchDataListener);
  }
  
  public void b(LiveMakeLoverApplyMemberModel paramLiveMakeLoverApplyMemberModel) {
    if (paramLiveMakeLoverApplyMemberModel == null)
      return; 
    LiveRoomHttpUtils.d(this.j, paramLiveMakeLoverApplyMemberModel.uid, new BluedUIHttpResponse(this, g(), paramLiveMakeLoverApplyMemberModel) {
          public boolean onUIFailure(int param1Int, String param1String) {
            this.b.h = param1Int;
            AppMethods.a(param1String);
            this.b.b("LIVE_MAKE_LOVER_IGNORE", false);
            return true;
          }
          
          public void onUIStart() {
            super.onUIStart();
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            LiveMakeLoverApplyMemberPresent liveMakeLoverApplyMemberPresent = this.b;
            liveMakeLoverApplyMemberPresent.h = 0;
            liveMakeLoverApplyMemberPresent.a("LIVE_MAKE_LOVER_IGNORE", this.a);
            this.b.b("LIVE_MAKE_LOVER_IGNORE", true);
          }
        }g());
  }
  
  public void c(IFetchDataListener paramIFetchDataListener) {
    LiveRoomHttpUtils.a(this.i, this.j, this.k, new BluedUIHttpResponse<BluedEntityA<LiveMakeLoverApplyMemberModel>>(this, g(), paramIFetchDataListener) {
          protected void a(BluedEntityA<LiveMakeLoverApplyMemberModel> param1BluedEntityA) {
            LiveMakeLoverApplyMemberPresent liveMakeLoverApplyMemberPresent = this.b;
            liveMakeLoverApplyMemberPresent.h = 0;
            if (param1BluedEntityA == null) {
              liveMakeLoverApplyMemberPresent.b("LIVE_MAKE_LOVER_APPLY_LIST", true);
              return;
            } 
            if (param1BluedEntityA.data != null) {
              IFetchDataListener iFetchDataListener = this.a;
              if (iFetchDataListener != null)
                iFetchDataListener.a("LIVE_MAKE_LOVER_APPLY_LIST", param1BluedEntityA.data); 
            } 
            if (!param1BluedEntityA.hasMore()) {
              IFetchDataListener iFetchDataListener = this.a;
              if (iFetchDataListener != null)
                iFetchDataListener.b(); 
            } 
            this.b.b("LIVE_MAKE_LOVER_APPLY_LIST", true);
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            this.b.h = param1Int;
            AppMethods.a(param1String);
            if (LiveMakeLoverApplyMemberPresent.a(this.b) > 1)
              LiveMakeLoverApplyMemberPresent.b(this.b); 
            this.b.b("LIVE_MAKE_LOVER_APPLY_LIST", false);
            return true;
          }
          
          public void onUIStart() {
            super.onUIStart();
            IFetchDataListener iFetchDataListener = this.a;
            if (iFetchDataListener != null)
              iFetchDataListener.a(); 
          }
        }g());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\presenter\LiveMakeLoverApplyMemberPresent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */