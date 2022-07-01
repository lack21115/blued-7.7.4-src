package com.soft.blued.ui.live.presenter;

import android.util.Log;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.live_china.model.LiveFansQuitModel;
import com.blued.android.module.live_china.model.LiveFansRecommendModel;
import com.soft.blued.http.LiveHttpUtils;
import com.soft.blued.ui.live.model.LiveJoinFansModel;
import java.util.ArrayList;

public class LiveJoinFansPresenter extends MvpPresenter {
  public boolean h = false;
  
  public boolean i = false;
  
  public boolean j = false;
  
  public int k = 1;
  
  public int l = 1;
  
  public void a(IFetchDataListener paramIFetchDataListener) {
    this.k = 1;
    c(paramIFetchDataListener);
  }
  
  public void a(boolean paramBoolean) {
    if (paramBoolean) {
      this.l = 1;
    } else {
      this.l++;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("getJoinRecommend pageRecommend:");
    stringBuilder.append(this.l);
    Log.i("LiveJoinFansPresenter", stringBuilder.toString());
    LiveHttpUtils.c(this.l, new BluedUIHttpResponse<BluedEntityA<LiveFansRecommendModel>>(this, g()) {
          public void a(BluedEntityA<LiveFansRecommendModel> param1BluedEntityA) {
            this.a.j = param1BluedEntityA.hasMore();
            this.a.a("LIVE_JOIN_RECOMMEND", param1BluedEntityA.data);
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            if (this.a.l > 1) {
              LiveJoinFansPresenter liveJoinFansPresenter = this.a;
              liveJoinFansPresenter.l--;
            } 
            this.a.a("LIVE_JOIN_RECOMMEND", null);
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
  
  public void b(IFetchDataListener paramIFetchDataListener) {
    this.k++;
    c(paramIFetchDataListener);
  }
  
  public void c(IFetchDataListener paramIFetchDataListener) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("getJoinFans pageFans:");
    stringBuilder.append(this.k);
    Log.i("LiveJoinFansPresenter", stringBuilder.toString());
    LiveHttpUtils.b(this.k, new BluedUIHttpResponse<BluedEntityA<LiveJoinFansModel>>(this, g(), paramIFetchDataListener) {
          public void a(BluedEntityA<LiveJoinFansModel> param1BluedEntityA) {
            if (param1BluedEntityA.data != null)
              this.a.a("LIVE_JOIN_FANS", param1BluedEntityA.data); 
            this.b.i = param1BluedEntityA.hasMore();
            if (!param1BluedEntityA.hasMore())
              this.a.b(); 
            this.b.b("LIVE_JOIN_FANS", true);
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            if (this.b.k > 1) {
              LiveJoinFansPresenter liveJoinFansPresenter = this.b;
              liveJoinFansPresenter.k--;
            } 
            this.a.a("LIVE_JOIN_FANS", new ArrayList());
            this.b.b("LIVE_JOIN_FANS", false);
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
  
  public boolean c() {
    return false;
  }
  
  public void d(String paramString) {
    LiveHttpUtils.a(paramString, new BluedUIHttpResponse<BluedEntityA<LiveFansQuitModel>>(this, g(), paramString) {
          public void a(BluedEntityA<LiveFansQuitModel> param1BluedEntityA) {
            LiveFansQuitModel liveFansQuitModel = new LiveFansQuitModel();
            liveFansQuitModel.localUid = this.a;
            this.b.a("LIVE_JOIN_FANS_QUIT", liveFansQuitModel);
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            AppMethods.a(param1String);
            return true;
          }
          
          public void onUIFinish() {
            this.b.b("LIVE_JOIN_FANS_QUIT", true);
            super.onUIFinish();
          }
          
          public void onUIStart() {
            super.onUIStart();
          }
        }g());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\presenter\LiveJoinFansPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */