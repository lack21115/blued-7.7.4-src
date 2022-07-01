package com.soft.blued.ui.circle.presenter;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.http.CircleHttpUtils;
import com.soft.blued.ui.circle.model.CircleHotPostExtra;
import com.soft.blued.ui.circle.model.MyCircleExtra;
import com.soft.blued.ui.circle.model.MyCircleModel;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.feed.model.BluedTopicExtra;

public class CirclePresenter extends MvpPresenter {
  public int h = 1;
  
  public boolean i;
  
  private void c(IFetchDataListener paramIFetchDataListener) {
    CircleHttpUtils.a(new BluedUIHttpResponse<BluedEntity<BluedIngSelfFeed, BluedTopicExtra>>(this, g(), paramIFetchDataListener) {
          public boolean onUIFailure(int param1Int, String param1String) {
            this.b.a("data_base_talk_list_error", false);
            if (this.b.h > 0) {
              CirclePresenter circlePresenter = this.b;
              circlePresenter.h--;
            } 
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            IFetchDataListener iFetchDataListener = this.a;
            if (iFetchDataListener != null)
              iFetchDataListener.a(param1Boolean); 
          }
          
          public void onUIUpdate(BluedEntity<BluedIngSelfFeed, BluedTopicExtra> param1BluedEntity) {
            if (param1BluedEntity != null) {
              this.b.i = param1BluedEntity.hasMore();
              this.a.a("data_base_talk_list", param1BluedEntity.data);
              if (!param1BluedEntity.hasMore()) {
                IFetchDataListener iFetchDataListener = this.a;
                if (iFetchDataListener != null)
                  iFetchDataListener.b(); 
              } 
            } 
          }
        }this.h, 20);
  }
  
  private void d(IFetchDataListener paramIFetchDataListener) {
    CircleHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<MyCircleModel>>(this, g(), paramIFetchDataListener) {
          public void a(BluedEntityA<MyCircleModel> param1BluedEntityA) {
            if (param1BluedEntityA != null)
              this.a.a("data_my_new_base_list", param1BluedEntityA.data); 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            this.b.a("data_my_new_base_list_error", false);
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            this.b.a("data_my_new_base_list_finish", false);
          }
        }1);
  }
  
  private void e(IFetchDataListener paramIFetchDataListener) {
    CircleHttpUtils.a(new BluedUIHttpResponse<BluedEntity<MyCircleModel, MyCircleExtra>>(this, g(), paramIFetchDataListener) {
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            if (!param1Boolean)
              this.b.b("data_recommend_list_error"); 
          }
          
          public void onUIUpdate(BluedEntity<MyCircleModel, MyCircleExtra> param1BluedEntity) {
            if (param1BluedEntity != null)
              this.a.a("data_recommend_list", param1BluedEntity.data); 
          }
        }g());
  }
  
  private void f(IFetchDataListener paramIFetchDataListener) {
    CircleHttpUtils.b(new BluedUIHttpResponse<BluedEntity<BluedIngSelfFeed, CircleHotPostExtra>>(this, g(), paramIFetchDataListener) {
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            if (!param1Boolean)
              this.a.a("data_hot_rank_list", null); 
          }
          
          public void onUIUpdate(BluedEntity<BluedIngSelfFeed, CircleHotPostExtra> param1BluedEntity) {
            if (param1BluedEntity != null) {
              this.a.a("data_hot_rank_list", param1BluedEntity.data);
              this.b.a("data_hot_rank_time", Long.valueOf(((CircleHotPostExtra)param1BluedEntity.extra).update_time));
            } 
          }
        }g());
  }
  
  public void a(LifecycleOwner paramLifecycleOwner) {
    super.a(paramLifecycleOwner);
    LiveEventBus.get("circle_delete_feed", String.class).observe(paramLifecycleOwner, new Observer<String>(this) {
          public void a(String param1String) {
            this.a.a("data_delete_feed", param1String, false);
          }
        });
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {
    this.h = 1;
    c(paramIFetchDataListener);
    d(paramIFetchDataListener);
    e(paramIFetchDataListener);
    f(paramIFetchDataListener);
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {
    if (this.i) {
      this.h++;
      c(paramIFetchDataListener);
      return;
    } 
    paramIFetchDataListener.b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\presenter\CirclePresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */