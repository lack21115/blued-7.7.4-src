package com.soft.blued.ui.discover.presenter;

import android.app.Activity;
import android.content.Context;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.soft.blued.http.FeedHttpUtils;
import com.soft.blued.ui.feed.model.BluedTopic;
import com.soft.blued.ui.feed.model.BluedTopicExtra;

public class SuperTopicPresenter extends MvpPresenter {
  private int h = 1;
  
  private int i = 20;
  
  private boolean j = true;
  
  private void c(IFetchDataListener paramIFetchDataListener) {
    Activity activity = h();
    BluedUIHttpResponse bluedUIHttpResponse = d(paramIFetchDataListener);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(this.h);
    stringBuilder1.append("");
    String str = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(this.i);
    stringBuilder2.append("");
    FeedHttpUtils.b((Context)activity, bluedUIHttpResponse, str, stringBuilder2.toString(), g());
  }
  
  private BluedUIHttpResponse d(IFetchDataListener paramIFetchDataListener) {
    return new BluedUIHttpResponse<BluedEntity<BluedTopic, BluedTopicExtra>>(this, "discovery_super_topic_list", g(), paramIFetchDataListener) {
        private void a(BluedEntity<BluedTopic, BluedTopicExtra> param1BluedEntity) {
          if (param1BluedEntity != null && param1BluedEntity.hasData()) {
            IFetchDataListener iFetchDataListener = this.a;
            if (iFetchDataListener != null) {
              iFetchDataListener.a("data_list", param1BluedEntity.data);
            } else {
              this.b.a("data_list", param1BluedEntity.data);
            } 
            SuperTopicPresenter.a(this.b, param1BluedEntity.hasMore());
            return;
          } 
          SuperTopicPresenter.a(this.b, false);
        }
        
        public void onUICache(BluedEntity<BluedTopic, BluedTopicExtra> param1BluedEntity) {
          a(param1BluedEntity);
        }
        
        public void onUIFinish(boolean param1Boolean) {
          super.onUIFinish(param1Boolean);
          if (!param1Boolean)
            SuperTopicPresenter.a(this.b); 
          if (!SuperTopicPresenter.b(this.b)) {
            IFetchDataListener iFetchDataListener1 = this.a;
            if (iFetchDataListener1 != null)
              iFetchDataListener1.b(); 
          } 
          IFetchDataListener iFetchDataListener = this.a;
          if (iFetchDataListener != null)
            iFetchDataListener.a(param1Boolean); 
        }
        
        public void onUIUpdate(BluedEntity<BluedTopic, BluedTopicExtra> param1BluedEntity) {
          a(param1BluedEntity);
        }
      };
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {
    this.h = 1;
    c(paramIFetchDataListener);
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {
    this.h++;
    c(paramIFetchDataListener);
  }
  
  public void k() {
    d((IFetchDataListener)null).refresh();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\discover\presenter\SuperTopicPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */