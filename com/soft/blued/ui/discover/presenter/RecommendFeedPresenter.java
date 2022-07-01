package com.soft.blued.ui.discover.presenter;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.http.FeedHttpUtils;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.http.LiveHttpUtils;
import com.soft.blued.ui.circle.adapter.CircleListAdapter;
import com.soft.blued.ui.circle.model.CircleConstants;
import com.soft.blued.ui.circle.model.CircleMethods;
import com.soft.blued.ui.circle.model.MyCircleModel;
import com.soft.blued.ui.circle.observer.ICircleDataObserver;
import com.soft.blued.ui.discover.model.DiscoverPicture;
import com.soft.blued.ui.discover.model.DiscoverSquareExtra;
import com.soft.blued.ui.feed.adapter.FeedHorizontalRecommendAdapter;
import com.soft.blued.ui.feed.adapter.FeedListAdapterForRecyclerView;
import com.soft.blued.ui.feed.adapter.RecommendTopicAdapter;
import com.soft.blued.ui.feed.manager.FeedMethods;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.feed.model.BluedTopic;
import com.soft.blued.ui.feed.model.FeedComment;
import com.soft.blued.ui.feed.model.FeedParse;
import com.soft.blued.ui.feed.model.FeedRecommendUser;
import com.soft.blued.ui.feed.model.FeedRepost;
import com.soft.blued.ui.feed.model.HotTopicExtra;
import com.soft.blued.ui.feed.model.RecommendCircleExtra;
import com.soft.blued.ui.feed.observer.IFeedDataObserver;
import com.soft.blued.ui.live.model.LiveRecommendExtra;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecommendFeedPresenter extends MvpPresenter implements IFeedDataObserver {
  private int h = 1;
  
  private boolean i = true;
  
  private FeedListAdapterForRecyclerView j;
  
  private List<BluedIngSelfFeed> k;
  
  private boolean l = true;
  
  private void a(int paramInt, BluedIngSelfFeed paramBluedIngSelfFeed) {
    int i = paramInt;
    if (paramInt <= 0)
      i = 3; 
    if (m().size() > i)
      m().add(i, paramBluedIngSelfFeed); 
  }
  
  private BluedUIHttpResponse d(IFetchDataListener paramIFetchDataListener) {
    return new BluedUIHttpResponse<BluedEntity<BluedIngSelfFeed, DiscoverSquareExtra>>(this, "discoverylistdata", g(), paramIFetchDataListener) {
        private void a(BluedEntity<BluedIngSelfFeed, DiscoverSquareExtra> param1BluedEntity) {
          List list;
          if (param1BluedEntity.extra != null && ((DiscoverSquareExtra)param1BluedEntity.extra).explore_list != null && ((DiscoverSquareExtra)param1BluedEntity.extra).explore_list.size() > 0) {
            list = ((DiscoverSquareExtra)param1BluedEntity.extra).explore_list;
          } else {
            list = DiscoverSquareExtra.getDefaultExplores();
          } 
          this.b.a("discover_entry", list);
        }
        
        public void onUICache(BluedEntity<BluedIngSelfFeed, DiscoverSquareExtra> param1BluedEntity) {
          super.onUICache(param1BluedEntity);
          if (param1BluedEntity != null) {
            this.b.a("featured_list", param1BluedEntity.data);
            a(param1BluedEntity);
          } 
        }
        
        public void onUIFinish(boolean param1Boolean) {
          if (!param1Boolean)
            RecommendFeedPresenter.c(this.b); 
          if (!RecommendFeedPresenter.d(this.b)) {
            IFetchDataListener iFetchDataListener1 = this.a;
            if (iFetchDataListener1 != null)
              iFetchDataListener1.b(); 
          } 
          IFetchDataListener iFetchDataListener = this.a;
          if (iFetchDataListener != null)
            iFetchDataListener.a(param1Boolean); 
        }
        
        public void onUIStart() {
          super.onUIStart();
          IFetchDataListener iFetchDataListener = this.a;
          if (iFetchDataListener != null)
            iFetchDataListener.a(); 
        }
        
        public void onUIUpdate(BluedEntity<BluedIngSelfFeed, DiscoverSquareExtra> param1BluedEntity) {
          if (param1BluedEntity != null) {
            if (this.a != null) {
              RecommendFeedPresenter.a(this.b, param1BluedEntity.data);
              this.a.a("featured_list", param1BluedEntity.data);
            } 
            if (RecommendFeedPresenter.a(this.b) == 1) {
              a(param1BluedEntity);
              if (param1BluedEntity.hasData()) {
                if (RecommendFeedPresenter.b(this.b)) {
                  RecommendFeedPresenter.a(this.b, this.a);
                } else {
                  RecommendFeedPresenter.b(this.b, this.a);
                } 
                RecommendFeedPresenter recommendFeedPresenter = this.b;
                RecommendFeedPresenter.a(recommendFeedPresenter, true ^ RecommendFeedPresenter.b(recommendFeedPresenter));
                RecommendFeedPresenter.c(this.b, this.a);
              } 
            } 
            RecommendFeedPresenter.b(this.b, param1BluedEntity.hasMore());
            return;
          } 
          RecommendFeedPresenter.b(this.b, false);
        }
        
        public BluedEntity<BluedIngSelfFeed, DiscoverSquareExtra> parseData(String param1String) {
          BluedEntity<BluedIngSelfFeed, DiscoverSquareExtra> bluedEntity = super.parseData(param1String);
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
  
  private void e(IFetchDataListener paramIFetchDataListener) {
    String str1;
    FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.j;
    String str2 = "";
    if (feedListAdapterForRecyclerView != null) {
      str2 = feedListAdapterForRecyclerView.q;
      str1 = this.j.r;
    } else {
      str1 = "";
    } 
    LiveHttpUtils.a(str2, str1, null, g(), new BluedUIHttpResponse<BluedEntity<FeedRecommendUser, LiveRecommendExtra>>(this, g(), paramIFetchDataListener) {
          public void onUIUpdate(BluedEntity<FeedRecommendUser, LiveRecommendExtra> param1BluedEntity) {
            if (param1BluedEntity != null && param1BluedEntity.data != null && param1BluedEntity.extra != null) {
              (RecommendFeedPresenter.e(this.b)).t = ((LiveRecommendExtra)param1BluedEntity.extra).hasmore;
              (RecommendFeedPresenter.e(this.b)).q = ((LiveRecommendExtra)param1BluedEntity.extra).last_lid;
              (RecommendFeedPresenter.e(this.b)).r = ((LiveRecommendExtra)param1BluedEntity.extra).ai_last_uid;
              (RecommendFeedPresenter.e(this.b)).s = ((LiveRecommendExtra)param1BluedEntity.extra).recommend_char;
              int i = ((LiveRecommendExtra)param1BluedEntity.extra).line - 1;
              if (param1BluedEntity.data.size() >= 3 && i >= 0 && i < RecommendFeedPresenter.e(this.b).n().size()) {
                BluedIngSelfFeed bluedIngSelfFeed = RecommendFeedPresenter.e(this.b).n().get(i);
                if (bluedIngSelfFeed.dataType != 3) {
                  bluedIngSelfFeed = (BluedIngSelfFeed)bluedIngSelfFeed.clone();
                  bluedIngSelfFeed.feed_id = "0";
                  bluedIngSelfFeed.feed_uid = "0";
                  bluedIngSelfFeed.feed_type = -1;
                  bluedIngSelfFeed.dataType = 3;
                  if ((RecommendFeedPresenter.e(this.b)).u == null)
                    (RecommendFeedPresenter.e(this.b)).u = new FeedHorizontalRecommendAdapter((Context)this.b.h(), this.b.g()); 
                  (RecommendFeedPresenter.e(this.b)).u.c(true);
                  (RecommendFeedPresenter.e(this.b)).u.b(false);
                  (RecommendFeedPresenter.e(this.b)).u.c(param1BluedEntity.data);
                  RecommendFeedPresenter.a(this.b, i, bluedIngSelfFeed);
                  IFetchDataListener iFetchDataListener = this.a;
                  if (iFetchDataListener != null)
                    iFetchDataListener.a("featured_list", this.b.m()); 
                } 
              } 
            } 
          }
        });
  }
  
  private void f(IFetchDataListener paramIFetchDataListener) {
    FeedHttpUtils.a((Context)h(), new BluedUIHttpResponse<BluedEntity<MyCircleModel, RecommendCircleExtra>>(this, g(), paramIFetchDataListener) {
          public void onUIUpdate(BluedEntity<MyCircleModel, RecommendCircleExtra> param1BluedEntity) {
            if (param1BluedEntity != null && param1BluedEntity.extra != null) {
              if (3 < RecommendFeedPresenter.e(this.b).n().size() && ((BluedIngSelfFeed)RecommendFeedPresenter.e(this.b).n().get(3)).is_ads == 1)
                return; 
              int i = ((RecommendCircleExtra)param1BluedEntity.extra).line - 1;
              if (param1BluedEntity.data.size() >= 1 && i >= 0 && i < RecommendFeedPresenter.e(this.b).n().size()) {
                BluedIngSelfFeed bluedIngSelfFeed = (BluedIngSelfFeed)((BluedIngSelfFeed)RecommendFeedPresenter.e(this.b).n().get(i)).clone();
                bluedIngSelfFeed.feed_id = "0";
                bluedIngSelfFeed.feed_uid = "0";
                bluedIngSelfFeed.feed_type = -1;
                bluedIngSelfFeed.dataType = 5;
                if ((RecommendFeedPresenter.e(this.b)).w == null)
                  (RecommendFeedPresenter.e(this.b)).w = new CircleListAdapter((Context)this.b.h(), CircleConstants.CIRCLE_FROM_PAGE.RECOMMEND_CIRCLE, this.b.g(), null); 
                (RecommendFeedPresenter.e(this.b)).w.c(false);
                (RecommendFeedPresenter.e(this.b)).w.c(param1BluedEntity.data);
                RecommendFeedPresenter.a(this.b, i, bluedIngSelfFeed);
                IFetchDataListener iFetchDataListener = this.a;
                if (iFetchDataListener != null)
                  iFetchDataListener.a("featured_list", this.b.m()); 
              } 
            } 
          }
        }g());
  }
  
  private void g(IFetchDataListener paramIFetchDataListener) {
    FeedHttpUtils.b((Context)h(), new BluedUIHttpResponse<BluedEntity<BluedTopic, HotTopicExtra>>(this, g(), paramIFetchDataListener) {
          public Map<Integer, List<BluedTopic>> a(List<BluedTopic> param1List, int param1Int) {
            HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
            hashMap.put(Integer.valueOf(1), new ArrayList());
            for (BluedTopic bluedTopic : param1List) {
              List<BluedTopic> list = (List)hashMap.get(Integer.valueOf(hashMap.size()));
              param1List = list;
              if (list.size() == param1Int) {
                param1List = new ArrayList<BluedTopic>();
                hashMap.put(Integer.valueOf(hashMap.size() + 1), param1List);
              } 
              param1List.add(bluedTopic);
            } 
            return (Map)hashMap;
          }
          
          public void onUIUpdate(BluedEntity<BluedTopic, HotTopicExtra> param1BluedEntity) {
            if (param1BluedEntity != null && param1BluedEntity.hasData() && param1BluedEntity.extra != null) {
              if (3 < RecommendFeedPresenter.e(this.b).n().size() && ((BluedIngSelfFeed)RecommendFeedPresenter.e(this.b).n().get(3)).is_ads == 1)
                return; 
              int i = ((HotTopicExtra)param1BluedEntity.extra).line - 1;
              if (param1BluedEntity.data.size() >= 1 && i >= 0 && i < RecommendFeedPresenter.e(this.b).n().size()) {
                BluedIngSelfFeed bluedIngSelfFeed = (BluedIngSelfFeed)((BluedIngSelfFeed)RecommendFeedPresenter.e(this.b).n().get(i)).clone();
                bluedIngSelfFeed.feed_id = "0";
                bluedIngSelfFeed.feed_uid = "0";
                bluedIngSelfFeed.feed_type = -1;
                bluedIngSelfFeed.dataType = 4;
                if ((RecommendFeedPresenter.e(this.b)).v == null)
                  (RecommendFeedPresenter.e(this.b)).v = new RecommendTopicAdapter((Context)this.b.h(), this.b.g()); 
                (RecommendFeedPresenter.e(this.b)).v.c(false);
                ArrayList<BluedTopic> arrayList = new ArrayList();
                for (List<BluedTopic> list : a(param1BluedEntity.data, 3).values()) {
                  BluedTopic bluedTopic = new BluedTopic();
                  bluedTopic.bluedTopicList = new ArrayList();
                  bluedTopic.bluedTopicList.addAll(list);
                  arrayList.add(bluedTopic);
                } 
                (RecommendFeedPresenter.e(this.b)).v.c(arrayList);
                RecommendFeedPresenter.a(this.b, i, bluedIngSelfFeed);
                IFetchDataListener iFetchDataListener = this.a;
                if (iFetchDataListener != null)
                  iFetchDataListener.a("featured_list", this.b.m()); 
              } 
            } 
          }
        }g());
  }
  
  public void a(int paramInt) {
    FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.j;
    if (feedListAdapterForRecyclerView != null)
      feedListAdapterForRecyclerView.a(paramInt); 
  }
  
  public void a(LifecycleOwner paramLifecycleOwner) {
    super.a(paramLifecycleOwner);
    FeedMethods.a(paramLifecycleOwner, (IFeedDataObserver)this.j);
    CircleMethods.registerFeedListObserver(paramLifecycleOwner, (ICircleDataObserver)this.j);
    LiveEventBus.get("circle_delete_feed", String.class).observe(paramLifecycleOwner, new Observer<String>(this) {
          public void a(String param1String) {
            this.a.a("delete_circle_feed", param1String, false);
          }
        });
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {
    c(paramIFetchDataListener);
    this.h = 1;
    FindHttpUtils.a(d(paramIFetchDataListener), this.h, "", g());
  }
  
  public void a(FeedListAdapterForRecyclerView paramFeedListAdapterForRecyclerView) {
    this.j = paramFeedListAdapterForRecyclerView;
  }
  
  public void a(BluedIngSelfFeed paramBluedIngSelfFeed) {
    FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.j;
    if (feedListAdapterForRecyclerView != null)
      feedListAdapterForRecyclerView.a(paramBluedIngSelfFeed); 
  }
  
  public void a(FeedComment paramFeedComment) {
    FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.j;
    if (feedListAdapterForRecyclerView != null)
      feedListAdapterForRecyclerView.a(paramFeedComment); 
  }
  
  public void a(FeedRepost paramFeedRepost) {
    FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.j;
    if (feedListAdapterForRecyclerView != null)
      feedListAdapterForRecyclerView.a(paramFeedRepost); 
  }
  
  public void a(String paramString, int paramInt) {
    FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.j;
    if (feedListAdapterForRecyclerView != null)
      feedListAdapterForRecyclerView.a(paramString, paramInt); 
  }
  
  public void a(String paramString1, String paramString2) {
    FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.j;
    if (feedListAdapterForRecyclerView != null)
      feedListAdapterForRecyclerView.a(paramString1, paramString2); 
  }
  
  public void b(int paramInt) {
    FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.j;
    if (feedListAdapterForRecyclerView != null)
      feedListAdapterForRecyclerView.b(paramInt); 
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {
    if (this.i) {
      this.h++;
      FindHttpUtils.a(d(paramIFetchDataListener), this.h, this.j.a(), g());
    } 
  }
  
  public void b(String paramString, int paramInt) {
    FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.j;
    if (feedListAdapterForRecyclerView != null)
      feedListAdapterForRecyclerView.b(paramString, paramInt); 
  }
  
  public void b(String paramString1, String paramString2) {
    FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.j;
    if (feedListAdapterForRecyclerView != null)
      feedListAdapterForRecyclerView.b(paramString1, paramString2); 
  }
  
  public void c(IFetchDataListener paramIFetchDataListener) {
    FindHttpUtils.a((Context)h(), new BluedUIHttpResponse<BluedEntityA<DiscoverPicture>>(this, paramIFetchDataListener) {
          public void a(BluedEntityA<DiscoverPicture> param1BluedEntityA) {
            this.a.a("discover_picture_list", param1BluedEntityA.data);
          }
          
          public void onUIFinish(boolean param1Boolean) {
            if (!param1Boolean)
              this.b.a("discover_picture_list", (Object)null); 
          }
        }"", g());
  }
  
  public void c(String paramString, int paramInt) {
    FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.j;
    if (feedListAdapterForRecyclerView != null)
      feedListAdapterForRecyclerView.c(paramString, paramInt); 
  }
  
  public void d(String paramString) {
    FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.j;
    if (feedListAdapterForRecyclerView != null)
      feedListAdapterForRecyclerView.d(paramString); 
  }
  
  public void e(String paramString) {
    FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.j;
    if (feedListAdapterForRecyclerView != null)
      feedListAdapterForRecyclerView.e(paramString); 
  }
  
  public void k() {
    d((IFetchDataListener)null).refresh();
  }
  
  public String[] l() {
    return new String[] { "featured_list" };
  }
  
  public List<BluedIngSelfFeed> m() {
    if (this.k == null)
      this.k = new ArrayList<BluedIngSelfFeed>(); 
    return this.k;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\discover\presenter\RecommendFeedPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */