package com.soft.blued.ui.feed.presenter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.soft.blued.http.FeedHttpUtils;
import com.soft.blued.ui.circle.model.CircleMethods;
import com.soft.blued.ui.circle.observer.ICircleDataObserver;
import com.soft.blued.ui.feed.adapter.FeedListAdapterForRecyclerView;
import com.soft.blued.ui.feed.manager.FeedMethods;
import com.soft.blued.ui.feed.model.AttentionLiveRecommendData;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.feed.model.FeedParse;
import com.soft.blued.ui.feed.observer.IFeedDataObserver;
import com.soft.blued.ui.find.observer.FeedRefreshObserver;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import java.util.Iterator;
import java.util.List;

public class AttentionFeedPresenter extends MvpPresenter implements FeedRefreshObserver.IFeedRefreshObserver {
  private int h = 1;
  
  private int i = 12;
  
  private boolean j = true;
  
  private FeedListAdapterForRecyclerView k;
  
  private int l = 1;
  
  private boolean m = true;
  
  private List<AttentionLiveRecommendData> n;
  
  private String o = "follows";
  
  private String p = "500";
  
  private BluedUIHttpResponse q = new BluedUIHttpResponse<BluedEntityA<AttentionLiveRecommendData>>(this, g()) {
      protected void a(BluedEntityA<AttentionLiveRecommendData> param1BluedEntityA) {
        if (param1BluedEntityA.hasData()) {
          if (AttentionFeedPresenter.c(this.a) == 1) {
            AttentionFeedPresenter.a(this.a, param1BluedEntityA.data);
          } else {
            List list = param1BluedEntityA.data;
            for (AttentionLiveRecommendData attentionLiveRecommendData : AttentionFeedPresenter.d(this.a)) {
              Iterator<AttentionLiveRecommendData> iterator = list.iterator();
              while (iterator.hasNext()) {
                AttentionLiveRecommendData attentionLiveRecommendData1 = iterator.next();
                if (attentionLiveRecommendData.uid != null && attentionLiveRecommendData.uid.equals(attentionLiveRecommendData1.uid))
                  iterator.remove(); 
              } 
            } 
            AttentionFeedPresenter.d(this.a).addAll(list);
          } 
          AttentionFeedPresenter.b(this.a, param1BluedEntityA.hasMore());
          return;
        } 
        AttentionFeedPresenter.b(this.a, false);
      }
      
      public void onUIFinish(boolean param1Boolean) {
        super.onUIFinish(param1Boolean);
        if (!param1Boolean)
          AttentionFeedPresenter.e(this.a); 
        AttentionFeedPresenter attentionFeedPresenter = this.a;
        attentionFeedPresenter.a("live_list", AttentionFeedPresenter.d(attentionFeedPresenter));
      }
    };
  
  private void c(IFetchDataListener paramIFetchDataListener) {
    BluedUIHttpResponse bluedUIHttpResponse;
    if (this.h == 1) {
      Activity activity = h();
      bluedUIHttpResponse = d(paramIFetchDataListener);
      String str1 = UserInfo.a().i().getUid();
      String str2 = this.o;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.h);
      stringBuilder1.append("");
      String str3 = stringBuilder1.toString();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(this.i);
      stringBuilder2.append("");
      FeedHttpUtils.a((Context)activity, bluedUIHttpResponse, str1, str2, str3, stringBuilder2.toString(), BluedPreferences.s(), BluedPreferences.t(), this.p, "", g());
      return;
    } 
    if (this.k != null) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.k.a());
      if (StringUtils.e("")) {
        str1 = "";
      } else {
        str1 = ",";
      } 
      stringBuilder1.append(str1);
      stringBuilder1.append("");
      String str1 = stringBuilder1.toString();
      Activity activity = h();
      bluedUIHttpResponse = d((IFetchDataListener)bluedUIHttpResponse);
      String str2 = UserInfo.a().i().getUid();
      String str3 = this.o;
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(this.h);
      stringBuilder2.append("");
      String str4 = stringBuilder2.toString();
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append(this.i);
      stringBuilder3.append("");
      FeedHttpUtils.a((Context)activity, bluedUIHttpResponse, str2, str3, str4, stringBuilder3.toString(), BluedPreferences.s(), BluedPreferences.t(), this.p, str1, g());
    } 
  }
  
  private BluedUIHttpResponse d(IFetchDataListener paramIFetchDataListener) {
    return new BluedUIHttpResponse<BluedEntityA<BluedIngSelfFeed>>(this, "attentionfeedlist", g(), paramIFetchDataListener) {
        boolean a = false;
        
        private void a(BluedEntityA<BluedIngSelfFeed> param1BluedEntityA, boolean param1Boolean) {
          if (param1BluedEntityA != null && param1BluedEntityA.hasData()) {
            IFetchDataListener iFetchDataListener = this.b;
            if (iFetchDataListener != null) {
              iFetchDataListener.a("feed_list", param1BluedEntityA.data);
            } else {
              this.c.a("feed_list", param1BluedEntityA.data);
            } 
            AttentionFeedPresenter.a(this.c, param1BluedEntityA.hasMore());
            return;
          } 
          AttentionFeedPresenter.a(this.c, false);
        }
        
        protected BluedEntityA<BluedIngSelfFeed> a(String param1String) {
          BluedEntityA<BluedIngSelfFeed> bluedEntityA = (BluedEntityA)super.parseData(param1String);
          if (bluedEntityA != null) {
            if (!bluedEntityA.hasData())
              return bluedEntityA; 
            for (BluedIngSelfFeed bluedIngSelfFeed : bluedEntityA.data)
              bluedIngSelfFeed.feedParse = new FeedParse((Context)this.c.h(), bluedIngSelfFeed, 0); 
          } 
          return bluedEntityA;
        }
        
        protected void a(BluedEntityA<BluedIngSelfFeed> param1BluedEntityA) {
          a(param1BluedEntityA, true);
        }
        
        public void b(BluedEntityA<BluedIngSelfFeed> param1BluedEntityA) {
          a(param1BluedEntityA, false);
        }
        
        public void onUIFinish(boolean param1Boolean) {
          if (!param1Boolean)
            AttentionFeedPresenter.a(this.c); 
          if (!AttentionFeedPresenter.b(this.c)) {
            IFetchDataListener iFetchDataListener1 = this.b;
            if (iFetchDataListener1 != null)
              iFetchDataListener1.b(); 
          } 
          IFetchDataListener iFetchDataListener = this.b;
          if (iFetchDataListener != null)
            iFetchDataListener.a(param1Boolean); 
        }
        
        public void onUIStart() {
          super.onUIStart();
        }
      };
  }
  
  public void a(FragmentActivity paramFragmentActivity, Bundle paramBundle1, Bundle paramBundle2) {
    super.a(paramFragmentActivity, paramBundle1, paramBundle2);
  }
  
  public void a(LifecycleOwner paramLifecycleOwner) {
    super.a(paramLifecycleOwner);
    FeedMethods.a(paramLifecycleOwner, (IFeedDataObserver)this.k);
    CircleMethods.registerFeedListObserver(paramLifecycleOwner, (ICircleDataObserver)this.k);
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
    this.h = 1;
    c(paramIFetchDataListener);
    a(true);
  }
  
  public void a(FeedListAdapterForRecyclerView paramFeedListAdapterForRecyclerView) {
    this.k = paramFeedListAdapterForRecyclerView;
  }
  
  public void a(Object paramObject, int paramInt) {
    b("send_list_visibility");
    if (paramInt == 2 && paramObject instanceof BluedIngSelfFeed) {
      paramObject = paramObject;
      if (this.k != null && !CircleMethods.isCircle((BluedIngSelfFeed)paramObject)) {
        this.k.a(0, paramObject);
        this.k.notifyDataSetChanged();
      } 
    } 
  }
  
  public void a(boolean paramBoolean) {
    if (paramBoolean) {
      this.l = 1;
    } else {
      this.l++;
    } 
    FeedHttpUtils.a(this.q, this.l, g());
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {
    this.h++;
    c(paramIFetchDataListener);
  }
  
  public void k() {
    d((IFetchDataListener)null).refresh();
  }
  
  public String[] l() {
    return new String[] { "feed_list" };
  }
  
  public boolean m() {
    return this.j;
  }
  
  public int n() {
    return this.l;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\presenter\AttentionFeedPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */