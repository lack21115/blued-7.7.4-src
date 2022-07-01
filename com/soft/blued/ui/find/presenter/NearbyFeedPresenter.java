package com.soft.blued.ui.find.presenter;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModelProviders;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.framework.utils.AppUtils;
import com.soft.blued.control.LocationHelperNew;
import com.soft.blued.http.FeedHttpUtils;
import com.soft.blued.ui.circle.model.CircleMethods;
import com.soft.blued.ui.circle.observer.ICircleDataObserver;
import com.soft.blued.ui.feed.adapter.FeedListAdapterForRecyclerView;
import com.soft.blued.ui.feed.manager.FeedMethods;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.feed.model.FeedParse;
import com.soft.blued.ui.feed.observer.IFeedDataObserver;
import com.soft.blued.ui.find.model.NearbyFeedCity;
import com.soft.blued.ui.find.model.NearbyOperate;
import com.soft.blued.ui.find.observer.FeedRefreshObserver;
import com.soft.blued.ui.find.observer.NearbyViewModel;
import com.soft.blued.ui.home.HomeActivity;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.DeviceUtils;
import com.soft.blued.utils.StringUtils;
import java.util.List;

public class NearbyFeedPresenter extends MvpPresenter implements FeedRefreshObserver.IFeedRefreshObserver {
  private FeedListAdapterForRecyclerView h;
  
  private int i;
  
  private int j = 12;
  
  private boolean k = true;
  
  private String l = "city";
  
  private String m = "500";
  
  private String n;
  
  private String o;
  
  private String p;
  
  private void c(IFetchDataListener paramIFetchDataListener) {
    DeviceUtils.b(new LocationHelperNew.LocationFinishListener(this, paramIFetchDataListener) {
          public void a() {
            NearbyFeedPresenter.a(this.b, NearbyFeedCity.getInstance().getLongitude());
            NearbyFeedPresenter.b(this.b, NearbyFeedCity.getInstance().getLatitude());
            NearbyFeedPresenter.a(this.b);
            NearbyFeedPresenter.a(this.b, this.a);
          }
          
          public void a(int param1Int) {
            NearbyFeedPresenter.a(this.b, NearbyFeedCity.getInstance().getLongitude());
            NearbyFeedPresenter.b(this.b, NearbyFeedCity.getInstance().getLatitude());
            NearbyFeedPresenter.a(this.b, this.a);
          }
        });
  }
  
  private void d(IFetchDataListener paramIFetchDataListener) {
    if (this.i == 1)
      this.k = true; 
    if (!this.k) {
      int i = this.i;
      if (i != 1) {
        this.i = i - 1;
        AppMethods.a(AppUtils.a(2131756083));
        paramIFetchDataListener.a(true);
        return;
      } 
    } 
    if (this.i == 1) {
      Activity activity1 = h();
      bluedUIHttpResponse = e(paramIFetchDataListener);
      String str4 = UserInfo.a().i().getUid();
      String str5 = this.l;
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append(this.i);
      stringBuilder3.append("");
      String str6 = stringBuilder3.toString();
      StringBuilder stringBuilder4 = new StringBuilder();
      stringBuilder4.append(this.j);
      stringBuilder4.append("");
      FeedHttpUtils.a((Context)activity1, bluedUIHttpResponse, str4, str5, str6, stringBuilder4.toString(), this.n, this.o, this.m, "", "", g());
      FeedHttpUtils.b(o(), g());
      return;
    } 
    FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.h;
    if (feedListAdapterForRecyclerView != null && feedListAdapterForRecyclerView.a() != null) {
      String str;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.p);
      if (StringUtils.e("")) {
        str = "";
      } else {
        str = ",";
      } 
      stringBuilder.append(str);
      stringBuilder.append("");
      this.p = stringBuilder.toString();
    } 
    Activity activity = h();
    BluedUIHttpResponse bluedUIHttpResponse = e((IFetchDataListener)bluedUIHttpResponse);
    String str1 = UserInfo.a().i().getUid();
    String str2 = this.l;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(this.i);
    stringBuilder1.append("");
    String str3 = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(this.j);
    stringBuilder2.append("");
    FeedHttpUtils.a((Context)activity, bluedUIHttpResponse, str1, str2, str3, stringBuilder2.toString(), this.n, this.o, this.m, this.p, "", g());
  }
  
  private BluedUIHttpResponse e(IFetchDataListener paramIFetchDataListener) {
    return new BluedUIHttpResponse<BluedEntity<BluedIngSelfFeed, BluedEntityBaseExtra>>(this, "nearbyfeedlist", g(), paramIFetchDataListener) {
        private void a(BluedEntity<BluedIngSelfFeed, BluedEntityBaseExtra> param1BluedEntity, boolean param1Boolean) {
          int i = 0;
          if (param1BluedEntity != null && param1BluedEntity.hasData()) {
            List list = param1BluedEntity.data;
            while (i < list.size()) {
              int j = i;
              if (((BluedIngSelfFeed)list.get(i)).is_join_circle == 1) {
                list.remove(i);
                j = i - 1;
              } 
              i = j + 1;
            } 
            IFetchDataListener iFetchDataListener = this.a;
            if (iFetchDataListener != null) {
              iFetchDataListener.a("feed_list", list);
            } else {
              this.b.a("feed_list", list);
            } 
            NearbyFeedPresenter.a(this.b, param1BluedEntity.hasMore());
            return;
          } 
          NearbyFeedPresenter.a(this.b, false);
        }
        
        public void onUICache(BluedEntity<BluedIngSelfFeed, BluedEntityBaseExtra> param1BluedEntity) {
          a(param1BluedEntity, true);
        }
        
        public void onUIFinish(boolean param1Boolean) {
          if (!param1Boolean)
            NearbyFeedPresenter.b(this.b); 
          if (this.a != null) {
            if (!NearbyFeedPresenter.c(this.b))
              this.a.b(); 
            this.a.a(param1Boolean);
          } 
        }
        
        public void onUIUpdate(BluedEntity<BluedIngSelfFeed, BluedEntityBaseExtra> param1BluedEntity) {
          a(param1BluedEntity, false);
        }
        
        public BluedEntity<BluedIngSelfFeed, BluedEntityBaseExtra> parseData(String param1String) {
          BluedEntity<BluedIngSelfFeed, BluedEntityBaseExtra> bluedEntity = super.parseData(param1String);
          if (bluedEntity != null) {
            if (!bluedEntity.hasData())
              return bluedEntity; 
            for (BluedIngSelfFeed bluedIngSelfFeed : bluedEntity.data)
              bluedIngSelfFeed.feedParse = new FeedParse((Context)this.b.h(), bluedIngSelfFeed, 6); 
          } 
          return bluedEntity;
        }
      };
  }
  
  private void n() {
    if (HomeActivity.c != null)
      ((NearbyViewModel)ViewModelProviders.of((FragmentActivity)HomeActivity.c).get(NearbyViewModel.class)).d.postValue(null); 
  }
  
  private BluedUIHttpResponse o() {
    return new BluedUIHttpResponse<BluedEntityA<NearbyOperate.DataBean>>(this, g()) {
        protected void a(BluedEntityA<NearbyOperate.DataBean> param1BluedEntityA) {
          this.a.a("feed_operate", param1BluedEntityA.data);
        }
      };
  }
  
  public void a(LifecycleOwner paramLifecycleOwner) {
    super.a(paramLifecycleOwner);
    FeedMethods.a(paramLifecycleOwner, (IFeedDataObserver)this.h);
    CircleMethods.registerFeedListObserver(paramLifecycleOwner, (ICircleDataObserver)this.h);
    FeedRefreshObserver.a().a(this);
    paramLifecycleOwner.getLifecycle().addObserver(new LifecycleObserver(this, paramLifecycleOwner) {
          @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
          public void onDestroy() {
            FeedRefreshObserver.a().b(this.b);
            this.a.getLifecycle().removeObserver(this);
          }
        });
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {
    this.i = 1;
    c(paramIFetchDataListener);
  }
  
  public void a(FeedListAdapterForRecyclerView paramFeedListAdapterForRecyclerView) {
    this.h = paramFeedListAdapterForRecyclerView;
  }
  
  public void a(Object paramObject, int paramInt) {
    if (paramInt == 2 && paramObject instanceof BluedIngSelfFeed) {
      paramObject = paramObject;
      if (this.h != null && !CircleMethods.isCircle((BluedIngSelfFeed)paramObject)) {
        this.h.a(0, paramObject);
        this.h.notifyDataSetChanged();
      } 
    } 
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {
    this.i++;
    d(paramIFetchDataListener);
  }
  
  public void k() {
    e((IFetchDataListener)null).refresh();
    o().refresh();
  }
  
  public String[] l() {
    return new String[] { "feed_list" };
  }
  
  public boolean m() {
    return this.k;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\presenter\NearbyFeedPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */