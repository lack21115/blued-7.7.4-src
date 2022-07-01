package com.soft.blued.ui.discover.presenter;

import android.app.Activity;
import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
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
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.feed.model.FeedParse;
import com.soft.blued.ui.feed.observer.IFeedDataObserver;

public class ImageFeedPresenter extends MvpPresenter {
  private FeedListAdapterForRecyclerView h;
  
  private int i;
  
  private int j = 12;
  
  private boolean k = true;
  
  private void c(IFetchDataListener paramIFetchDataListener) {
    Activity activity = h();
    BluedUIHttpResponse bluedUIHttpResponse = d(paramIFetchDataListener);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(this.i);
    stringBuilder1.append("");
    String str = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(this.j);
    stringBuilder2.append("");
    FeedHttpUtils.c((Context)activity, bluedUIHttpResponse, str, stringBuilder2.toString(), g());
  }
  
  private BluedUIHttpResponse d(IFetchDataListener paramIFetchDataListener) {
    return new BluedUIHttpResponse<BluedEntityA<BluedIngSelfFeed>>(this, "image_feed", g(), paramIFetchDataListener) {
        protected BluedEntityA<BluedIngSelfFeed> a(String param1String) {
          BluedEntityA<BluedIngSelfFeed> bluedEntityA = (BluedEntityA)super.parseData(param1String);
          if (bluedEntityA != null) {
            if (!bluedEntityA.hasData())
              return bluedEntityA; 
            for (BluedIngSelfFeed bluedIngSelfFeed : bluedEntityA.data)
              bluedIngSelfFeed.feedParse = new FeedParse((Context)this.b.h(), bluedIngSelfFeed, 10); 
          } 
          return bluedEntityA;
        }
        
        protected void a(BluedEntityA<BluedIngSelfFeed> param1BluedEntityA) {
          super.onUICache((BluedEntity)param1BluedEntityA);
          if (param1BluedEntityA != null)
            this.b.a("feed_list", param1BluedEntityA.data); 
        }
        
        public void b(BluedEntityA<BluedIngSelfFeed> param1BluedEntityA) {
          if (param1BluedEntityA != null && param1BluedEntityA.hasData()) {
            IFetchDataListener iFetchDataListener = this.a;
            if (iFetchDataListener != null) {
              iFetchDataListener.a("feed_list", param1BluedEntityA.data);
            } else {
              this.b.a("feed_list", param1BluedEntityA.data);
            } 
            ImageFeedPresenter.a(this.b, param1BluedEntityA.hasMore());
            return;
          } 
          ImageFeedPresenter.a(this.b, false);
        }
        
        public void onUIFinish(boolean param1Boolean) {
          if (!param1Boolean)
            ImageFeedPresenter.a(this.b); 
          if (!ImageFeedPresenter.b(this.b)) {
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
      };
  }
  
  public void a(LifecycleOwner paramLifecycleOwner) {
    super.a(paramLifecycleOwner);
    FeedMethods.a(paramLifecycleOwner, (IFeedDataObserver)this.h);
    CircleMethods.registerFeedListObserver(paramLifecycleOwner, (ICircleDataObserver)this.h);
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {
    this.i = 1;
    c(paramIFetchDataListener);
  }
  
  public void a(FeedListAdapterForRecyclerView paramFeedListAdapterForRecyclerView) {
    this.h = paramFeedListAdapterForRecyclerView;
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {
    this.i++;
    c(paramIFetchDataListener);
  }
  
  public void k() {
    d((IFetchDataListener)null).refresh();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\discover\presenter\ImageFeedPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */