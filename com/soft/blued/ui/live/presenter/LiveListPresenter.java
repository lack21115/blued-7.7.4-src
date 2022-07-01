package com.soft.blued.ui.live.presenter;

import android.content.Context;
import android.util.Log;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.live_china.model.BluedLiveState;
import com.blued.android.module.live_china.observer.LiveSwipeRefreshObserver;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.soft.blued.http.LiveHttpUtils;
import com.soft.blued.ui.live.contract.LiveListContract;
import com.soft.blued.ui.live.model.BannerModel;
import com.soft.blued.ui.live.model.BluedLiveListData;
import com.soft.blued.ui.live.model.LiveListCommonModel;
import com.soft.blued.ui.live.model.LiveListRankFlagExtra;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.NetworkUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LiveListPresenter implements LiveListContract.IPresenter {
  private static final String a = LiveListPresenter.class.getSimpleName();
  
  private BluedLiveState b;
  
  private Context c;
  
  private LiveListCommonModel d;
  
  private LiveListContract.IView e;
  
  private int f;
  
  private String g;
  
  private int h;
  
  private List<BluedLiveListData> i;
  
  private List<BluedLiveListData> j;
  
  public LiveListPresenter(Context paramContext, String paramString, int paramInt) {
    if (paramContext != null) {
      this.d = new LiveListCommonModel();
      this.c = paramContext;
      this.g = paramString;
      this.h = paramInt;
      this.i = new ArrayList<BluedLiveListData>();
      this.j = new ArrayList<BluedLiveListData>();
    } 
  }
  
  private void a(String paramString, int paramInt) {
    LiveListContract.IView iView;
    if (!NetworkUtils.b()) {
      iView = this.e;
      if (iView != null) {
        iView.d();
        this.e.c();
        this.e.b();
        return;
      } 
    } else {
      LiveHttpUtils.a(new BluedUIHttpResponse<BluedEntity<BluedLiveListData, LiveListRankFlagExtra>>(this, paramInt, (String)iView) {
            public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
              super.onFailure(param1Throwable, param1Int, param1String);
              AppInfo.n().post(new Runnable(this) {
                    public void run() {
                      if (LiveListPresenter.b(this.a.c) != null)
                        LiveListPresenter.b(this.a.c).a(null, false); 
                    }
                  });
            }
            
            public void onUIFinish() {
              Logger.a(LiveListPresenter.i(), new Object[] { "onUIFinish" });
              LiveSwipeRefreshObserver.a().b();
              if (LiveListPresenter.b(this.c) != null) {
                LiveListPresenter.b(this.c).c();
                LiveListPresenter.b(this.c).b();
              } 
            }
            
            public void onUIUpdate(BluedEntity<BluedLiveListData, LiveListRankFlagExtra> param1BluedEntity) {
              try {
                List list;
                if (param1BluedEntity.extra != null) {
                  boolean bool;
                  LiveListCommonModel liveListCommonModel = LiveListPresenter.a(this.c);
                  if (((LiveListRankFlagExtra)param1BluedEntity.extra).recommend == 1) {
                    bool = true;
                  } else {
                    bool = false;
                  } 
                  liveListCommonModel.setCanReCommend(bool);
                } 
                if (param1BluedEntity.data != null && param1BluedEntity.data.size() > 0) {
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append("parseData.data: ");
                  stringBuilder.append(param1BluedEntity.data);
                  Log.i("xpm", stringBuilder.toString());
                  if (param1BluedEntity.hasMore()) {
                    LiveListPresenter.a(this.c).setHasData(true);
                    if (LiveListPresenter.b(this.c) != null)
                      LiveListPresenter.b(this.c).e(); 
                  } else {
                    LiveListPresenter.a(this.c).setHasData(false);
                    if (!LiveListPresenter.a(this.c).isCanReCommend() && LiveListPresenter.b(this.c) != null)
                      LiveListPresenter.b(this.c).a(); 
                  } 
                  if (this.a == 1) {
                    Iterator iterator = param1BluedEntity.data.iterator();
                    while (iterator.hasNext())
                      ((BluedLiveListData)iterator.next()).liveType = 6; 
                  } 
                  LiveListPresenter.c(this.c).addAll(param1BluedEntity.data);
                  if (LiveListPresenter.b(this.c) != null) {
                    boolean bool;
                    LiveListContract.IView iView = LiveListPresenter.b(this.c);
                    list = param1BluedEntity.data;
                    if (LiveListPresenter.a(this.c).getPage() != 1) {
                      bool = true;
                    } else {
                      bool = false;
                    } 
                    iView.a(list, bool);
                  } 
                  if (!LiveListPresenter.a(this.c).getHasData()) {
                    LiveListPresenter.a(this.c).setRecommendPage(LiveListPresenter.a(this.c).getRecommendPage() + 1);
                    this.c.a(this.b, false);
                  } 
                } else {
                  if (LiveListPresenter.a(this.c).getPage() == 1) {
                    if (LiveListPresenter.b(this.c) != null)
                      LiveListPresenter.b(this.c).a(((BluedEntity)list).data, false); 
                  } else {
                    LiveListPresenter.a(this.c).setPage(LiveListPresenter.a(this.c).getPage() - 1);
                  } 
                  if (LiveListPresenter.a(this.c).isCanReCommend()) {
                    LiveListPresenter.a(this.c).setRecommendPage(LiveListPresenter.a(this.c).getRecommendPage() + 1);
                    this.c.a(this.b, true);
                  } else if (LiveListPresenter.b(this.c) != null) {
                    LiveListPresenter.b(this.c).a();
                  } 
                } 
                if (LiveListPresenter.b(this.c) != null) {
                  LiveListPresenter.b(this.c).a(LiveListPresenter.d(this.c));
                  return;
                } 
              } catch (Exception exception) {
                exception.printStackTrace();
                if (LiveListPresenter.a(this.c).getPage() != 1)
                  LiveListPresenter.a(this.c).setPage(LiveListPresenter.a(this.c).getPage() - 1); 
                AppMethods.a(LiveListPresenter.e(this.c).getResources().getString(2131756082));
              } 
            }
          }(String)iView, String.valueOf(this.d.getPage()), null);
    } 
  }
  
  public BluedLiveState a() {
    return this.b;
  }
  
  public void a(LiveListContract.IView paramIView) {
    this.e = paramIView;
  }
  
  public void a(String paramString, boolean paramBoolean) {
    if (!this.d.isCanReCommend())
      return; 
    LiveHttpUtils.b(new BluedUIHttpResponse<BluedEntity<BluedLiveListData, LiveListRankFlagExtra>>(this) {
          public void onUIFinish() {
            Logger.a(LiveListPresenter.i(), new Object[] { "onUIFinish" });
            LiveSwipeRefreshObserver.a().b();
            if (LiveListPresenter.b(this.a) != null) {
              LiveListPresenter.b(this.a).c();
              LiveListPresenter.b(this.a).b();
            } 
          }
          
          public void onUIUpdate(BluedEntity<BluedLiveListData, LiveListRankFlagExtra> param1BluedEntity) {
            try {
              if (param1BluedEntity.data != null && param1BluedEntity.data.size() > 0) {
                Iterator iterator = param1BluedEntity.data.iterator();
                while (iterator.hasNext())
                  ((BluedLiveListData)iterator.next()).liveType = 10; 
                LiveListPresenter.g(this.a).addAll(param1BluedEntity.data);
                if (LiveListPresenter.b(this.a) != null)
                  LiveListPresenter.b(this.a).a(param1BluedEntity.data, true); 
              } 
              if (!param1BluedEntity.hasMore() && LiveListPresenter.b(this.a) != null) {
                LiveListPresenter.b(this.a).a();
                return;
              } 
            } catch (Exception exception) {
              exception.printStackTrace();
              if (LiveListPresenter.a(this.a).getRecommendPage() != 0)
                LiveListPresenter.a(this.a).setRecommendPage(LiveListPresenter.a(this.a).getRecommendPage() - 1); 
              AppMethods.a(LiveListPresenter.e(this.a).getResources().getString(2131756082));
            } 
          }
        }paramString, String.valueOf(this.d.getRecommendPage()), null);
  }
  
  public void a(boolean paramBoolean) {
    if (paramBoolean) {
      this.d.setPage(1);
      this.d.setRecommendPage(0);
      this.d.setCanReCommend(false);
      this.d.setHasData(true);
      g();
      a(this.g, this.h);
      return;
    } 
    if (!this.d.getHasData()) {
      LiveListCommonModel liveListCommonModel1 = this.d;
      liveListCommonModel1.setRecommendPage(liveListCommonModel1.getRecommendPage() + 1);
      a(this.g, false);
      return;
    } 
    LiveListCommonModel liveListCommonModel = this.d;
    liveListCommonModel.setPage(liveListCommonModel.getPage() + 1);
    if (!this.d.getHasData() && this.d.getPage() != 1 && !this.d.isCanReCommend()) {
      liveListCommonModel = this.d;
      liveListCommonModel.setPage(liveListCommonModel.getPage() - 1);
      AppMethods.a(this.c.getResources().getString(2131756083));
      LiveListContract.IView iView = this.e;
      if (iView != null)
        iView.c(); 
      return;
    } 
    a(this.g, this.h);
  }
  
  public void b() {
    List<BluedLiveListData> list = this.i;
    if (list != null) {
      LiveListContract.IView iView = this.e;
      if (iView != null)
        iView.a(list, false); 
    } 
    list = this.j;
    if (list != null && list.size() > 0) {
      LiveListContract.IView iView = this.e;
      if (iView != null)
        iView.a(this.j, true); 
    } 
  }
  
  public void c() {
    List<BluedLiveListData> list = this.i;
    if (list != null)
      list.clear(); 
    list = this.j;
    if (list != null)
      list.clear(); 
  }
  
  public int d() {
    List<BluedLiveListData> list = this.i;
    int i = 0;
    if (list != null)
      i = 0 + list.size(); 
    list = this.j;
    int j = i;
    if (list != null)
      j = i + list.size(); 
    return j;
  }
  
  public void e() {
    this.e = null;
  }
  
  public void f() {
    h();
  }
  
  public void g() {
    LiveRoomHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<BluedLiveState>>(this) {
          public void a(BluedEntityA<BluedLiveState> param1BluedEntityA) {
            try {
              if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
                LiveListPresenter.a(this.a, param1BluedEntityA.data.get(0));
                if (1 == (LiveListPresenter.f(this.a)).is_permission || 2 == (LiveListPresenter.f(this.a)).is_permission) {
                  LiveListPresenter.a(this.a, 1);
                } else {
                  LiveListPresenter.a(this.a, 0);
                } 
                if ((LiveListPresenter.f(this.a)).allow_applied == 0) {
                  LiveListPresenter.a(this.a, 0);
                  return;
                } 
              } 
            } catch (Exception exception) {
              exception.printStackTrace();
            } 
          }
        }UserInfo.a().i().getUid(), null);
  }
  
  public void h() {
    LiveHttpUtils.e(new BluedUIHttpResponse<BluedEntityA<BannerModel>>(this) {
          public void a(BluedEntityA<BannerModel> param1BluedEntityA) {
            if (LiveListPresenter.b(this.a) != null && param1BluedEntityA != null)
              LiveListPresenter.b(this.a).a(param1BluedEntityA.data); 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            if (LiveListPresenter.b(this.a) != null)
              LiveListPresenter.b(this.a).a(null); 
            return super.onUIFailure(param1Int, param1String);
          }
        }null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\presenter\LiveListPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */