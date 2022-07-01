package com.soft.blued.ui.circle.presenter;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.das.client.feed.FeedProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.http.CircleHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.circle.model.CircleBubble;
import com.soft.blued.ui.circle.model.CircleConstants;
import com.soft.blued.ui.circle.model.CircleDetailsModel;
import com.soft.blued.ui.circle.model.CircleJoinState;
import com.soft.blued.ui.circle.model.CircleMethods;
import com.soft.blued.ui.circle.model.MyCircleModel;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.find.observer.FeedRefreshObserver;
import com.soft.blued.utils.BluedPreferences;

public class CircleDetailsPresenter extends MvpPresenter implements FeedRefreshObserver.IFeedRefreshObserver {
  private boolean A = true;
  
  private int B;
  
  private boolean C = false;
  
  public boolean h = true;
  
  public boolean i = true;
  
  public boolean j = true;
  
  public boolean k;
  
  private MyCircleModel l;
  
  private String m;
  
  private String n;
  
  private int o;
  
  private int p = 0;
  
  private int q = 1;
  
  private int r = 30;
  
  private int s = 1;
  
  private int t = 30;
  
  private int u = 1;
  
  private int v = 30;
  
  private CircleConstants.CIRCLE_FROM_PAGE w;
  
  private int x;
  
  private int y;
  
  private int z;
  
  private void a(boolean paramBoolean, IFetchDataListener paramIFetchDataListener) {
    if (paramBoolean) {
      this.q = 1;
    } else {
      this.q++;
    } 
    if (!this.h) {
      int i = this.q;
      if (i != 1) {
        this.q = i - 1;
        paramIFetchDataListener.b();
        return;
      } 
    } 
    CircleHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<CircleDetailsModel>>(this, g(), paramBoolean, paramIFetchDataListener) {
          int a;
          
          protected void a(BluedEntityA<CircleDetailsModel> param1BluedEntityA) {
            boolean bool = false;
            if (param1BluedEntityA != null && param1BluedEntityA.hasData()) {
              CircleDetailsPresenter.a(this.d, ((CircleDetailsModel)param1BluedEntityA.getSingleData()).circle_id);
              if (((CircleDetailsModel)param1BluedEntityA.getSingleData()).allow_join == 1)
                bool = true; 
              BluedPreferences.W(bool);
              if (this.b) {
                CircleDetailsPresenter.a(this.d, (MyCircleModel)param1BluedEntityA.getSingleData());
                this.c.a("circle_details", param1BluedEntityA.data);
                this.c.a("circle_details_top", ((CircleDetailsModel)param1BluedEntityA.getSingleData()).top);
                this.d.a("circle_details_ad", ((CircleDetailsModel)param1BluedEntityA.getSingleData()).ad);
              } 
              this.c.a("circle_new_list", ((CircleDetailsModel)param1BluedEntityA.getSingleData()).feeds);
              if (CircleDetailsPresenter.a(this.d) == 0) {
                this.d.h = param1BluedEntityA.hasMore();
                return;
              } 
            } else if (CircleDetailsPresenter.a(this.d) == 0) {
              this.d.h = false;
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            this.a = param1Int;
            if (CircleDetailsPresenter.b(this.d) != 1)
              CircleDetailsPresenter.c(this.d); 
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish(boolean param1Boolean) {
            if (CircleDetailsPresenter.a(this.d) == 0) {
              if (!this.d.h)
                this.c.b(); 
              this.c.a(param1Boolean);
            } 
            if (this.a == 40370003)
              this.d.i(); 
            CircleDetailsPresenter.d(this.d);
          }
        }this.m, "last", this.q, this.r);
  }
  
  private void b(boolean paramBoolean, IFetchDataListener paramIFetchDataListener) {
    if (paramBoolean) {
      this.s = 1;
    } else {
      this.s++;
    } 
    if (!this.i) {
      int i = this.s;
      if (i != 1) {
        this.s = i - 1;
        paramIFetchDataListener.b();
        return;
      } 
    } 
    CircleHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<CircleDetailsModel>>(this, g(), paramBoolean, paramIFetchDataListener) {
          protected void a(BluedEntityA<CircleDetailsModel> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.hasData()) {
              if (this.a) {
                CircleDetailsPresenter.a(this.c, (MyCircleModel)param1BluedEntityA.getSingleData());
                this.b.a("circle_details", param1BluedEntityA.data);
                this.b.a("circle_details_top", ((CircleDetailsModel)param1BluedEntityA.getSingleData()).top);
                this.c.a("circle_details_ad", ((CircleDetailsModel)param1BluedEntityA.getSingleData()).ad);
              } 
              this.b.a("circle_hot_list", ((CircleDetailsModel)param1BluedEntityA.getSingleData()).feeds);
              if (CircleDetailsPresenter.a(this.c) == 1) {
                this.c.i = param1BluedEntityA.hasMore();
                return;
              } 
            } else if (CircleDetailsPresenter.a(this.c) == 1) {
              this.c.i = false;
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            if (CircleDetailsPresenter.e(this.c) != 1)
              CircleDetailsPresenter.f(this.c); 
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish(boolean param1Boolean) {
            if (CircleDetailsPresenter.a(this.c) == 1) {
              if (!this.c.i)
                this.b.b(); 
              this.b.a(param1Boolean);
            } 
            CircleDetailsPresenter.d(this.c);
          }
        }this.m, "hot", this.s, this.t);
  }
  
  private void c(IFetchDataListener paramIFetchDataListener) {
    CircleHttpUtils.e(new BluedUIHttpResponse<BluedEntityA<CircleBubble>>(this, g(), paramIFetchDataListener) {
          protected void a(BluedEntityA<CircleBubble> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.hasData())
              this.a.a("circle_bubble", param1BluedEntityA.data); 
          }
        }p(), g());
  }
  
  private void c(boolean paramBoolean, IFetchDataListener paramIFetchDataListener) {
    if (paramBoolean) {
      this.u = 1;
    } else {
      this.u++;
    } 
    if (!this.j) {
      int i = this.u;
      if (i != 1) {
        this.u = i - 1;
        paramIFetchDataListener.b();
        return;
      } 
    } 
    CircleHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<CircleDetailsModel>>(this, g(), paramBoolean, paramIFetchDataListener) {
          protected void a(BluedEntityA<CircleDetailsModel> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.hasData()) {
              if (this.a) {
                CircleDetailsPresenter.a(this.c, (MyCircleModel)param1BluedEntityA.getSingleData());
                this.b.a("circle_details", param1BluedEntityA.data);
                this.b.a("circle_details_top", ((CircleDetailsModel)param1BluedEntityA.getSingleData()).top);
                this.c.a("circle_details_ad", ((CircleDetailsModel)param1BluedEntityA.getSingleData()).ad);
              } 
              this.b.a("circle_essence_list", ((CircleDetailsModel)param1BluedEntityA.getSingleData()).feeds);
              if (CircleDetailsPresenter.a(this.c) == 2) {
                this.c.j = param1BluedEntityA.hasMore();
                return;
              } 
            } else if (CircleDetailsPresenter.a(this.c) == 2) {
              this.c.j = false;
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            if (CircleDetailsPresenter.g(this.c) != 1)
              CircleDetailsPresenter.h(this.c); 
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish(boolean param1Boolean) {
            if (CircleDetailsPresenter.a(this.c) == 2) {
              if (!this.c.j)
                this.b.b(); 
              this.b.a(param1Boolean);
            } 
            if (param1Boolean)
              CircleDetailsPresenter.d(this.c); 
          }
        }this.m, "essence", this.u, this.v);
  }
  
  private void y() {
    boolean bool;
    if (this.C)
      return; 
    FeedProtos.Event event = FeedProtos.Event.CIRCLE_DETAIL_SHOW;
    String str1 = (t()).circle_id;
    String str2 = q();
    FeedProtos.CircleSource circleSource = EventTrackFeed.a(u(), v(), w(), x());
    boolean bool1 = t().isJoin();
    if ((t()).allow_join == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    EventTrackFeed.a(event, str1, str2, circleSource, bool1, bool, EventTrackFeed.f((t()).admin_level), this.B);
    this.C = true;
  }
  
  public void a(int paramInt) {
    this.p = paramInt;
  }
  
  public void a(FragmentActivity paramFragmentActivity, Bundle paramBundle1, Bundle paramBundle2) {
    super.a(paramFragmentActivity, paramBundle1, paramBundle2);
    if (paramBundle1 != null) {
      this.m = paramBundle1.getString("circle_id");
      this.n = paramBundle1.getString("feed_id");
      this.o = paramBundle1.getInt("circle_details_tab");
      this.w = (CircleConstants.CIRCLE_FROM_PAGE)paramBundle1.getSerializable("circle_from_page");
      this.x = paramBundle1.getInt("notify_from");
      this.y = paramBundle1.getInt("feed_from");
      this.z = paramBundle1.getInt("h5_from");
      this.B = paramBundle1.getInt("circle_classify_id");
      MyCircleModel myCircleModel = (MyCircleModel)paramBundle1.getSerializable("circle_data");
      if (myCircleModel != null) {
        this.m = myCircleModel.circle_id;
        this.l = myCircleModel;
        a("circle_details", myCircleModel);
      } else {
        b("circle_details");
      } 
      int i = this.o;
      if (i == 1) {
        e();
        this.p = 1;
        b("circle_tab");
        return;
      } 
      if (i == 2) {
        e();
        this.p = 2;
        b("circle_tab");
      } 
    } 
  }
  
  public void a(LifecycleOwner paramLifecycleOwner) {
    super.a(paramLifecycleOwner);
    FeedRefreshObserver.a().a(this);
    paramLifecycleOwner.getLifecycle().addObserver(new LifecycleObserver(this, paramLifecycleOwner) {
          @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
          public void onDestroy() {
            FeedRefreshObserver.a().b(this.b);
            this.a.getLifecycle().removeObserver(this);
          }
        });
    LiveEventBus.get("circle_delete_feed", String.class).observe(paramLifecycleOwner, new Observer<String>(this) {
          public void a(String param1String) {
            this.a.a("circle_delete_feed", param1String, false);
          }
        });
    LiveEventBus.get("circle_join_state", CircleJoinState.class).observe(paramLifecycleOwner, new Observer<CircleJoinState>(this) {
          public void a(CircleJoinState param1CircleJoinState) {
            if (!TextUtils.isEmpty(this.a.p()) && this.a.p().equals(param1CircleJoinState.circle_id)) {
              this.a.t().setJoinState(param1CircleJoinState);
              this.a.b("circle_join_state");
            } 
          }
        });
    LiveEventBus.get("circle_info_modify", MyCircleModel.class).observe(paramLifecycleOwner, new Observer<MyCircleModel>(this) {
          public void a(MyCircleModel param1MyCircleModel) {
            if (param1MyCircleModel != null && this.a.p().equals(param1MyCircleModel.circle_id)) {
              if (!TextUtils.isEmpty(param1MyCircleModel.cover) && !TextUtils.equals((this.a.t()).cover, param1MyCircleModel.cover)) {
                (this.a.t()).cover = param1MyCircleModel.cover;
                (this.a.t()).cover_is_auditing = 1;
              } 
              (this.a.t()).description = param1MyCircleModel.description;
              CircleDetailsPresenter circleDetailsPresenter = this.a;
              circleDetailsPresenter.a("circle_details", circleDetailsPresenter.t());
            } 
          }
        });
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {
    if (this.A) {
      a(true, paramIFetchDataListener);
      b(true, paramIFetchDataListener);
      c(true, paramIFetchDataListener);
      c(paramIFetchDataListener);
      this.A = false;
    } else {
      int i = this.p;
      if (i != 0) {
        if (i != 1) {
          if (i == 2)
            c(true, paramIFetchDataListener); 
        } else {
          b(true, paramIFetchDataListener);
        } 
      } else {
        a(true, paramIFetchDataListener);
      } 
    } 
    this.k = true;
  }
  
  public void a(Object paramObject, int paramInt) {
    if (m() && paramInt == 2 && paramObject instanceof BluedIngSelfFeed) {
      paramObject = paramObject;
      if (CircleMethods.isCircle((BluedIngSelfFeed)paramObject))
        a("circle_post", paramObject); 
    } 
  }
  
  public void a(boolean paramBoolean, CircleMethods.JoinViewChangeListener paramJoinViewChangeListener, FragmentManager paramFragmentManager) {
    if (h() != null && paramFragmentManager != null)
      CircleMethods.joinCircle((Context)h(), paramJoinViewChangeListener, t().getJoinState(), g(), paramFragmentManager, paramBoolean, false); 
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {
    this.k = false;
    int i = this.p;
    if (i != 0) {
      if (i != 1) {
        if (i != 2)
          return; 
        c(false, paramIFetchDataListener);
        return;
      } 
      b(false, paramIFetchDataListener);
      return;
    } 
    a(false, paramIFetchDataListener);
  }
  
  public boolean m() {
    return (this.p == 0);
  }
  
  public int n() {
    return this.p;
  }
  
  public String o() {
    return (t()).title;
  }
  
  public String p() {
    return !TextUtils.isEmpty((t()).circle_id) ? (t()).circle_id : this.m;
  }
  
  public String q() {
    return this.n;
  }
  
  public void r() {
    CircleMethods.exitCircle(t(), g());
  }
  
  public boolean s() {
    return (t().isOwner() || t().isManager());
  }
  
  public MyCircleModel t() {
    if (this.l == null)
      this.l = (MyCircleModel)new CircleDetailsModel(); 
    return this.l;
  }
  
  public CircleConstants.CIRCLE_FROM_PAGE u() {
    return this.w;
  }
  
  public int v() {
    return this.x;
  }
  
  public int w() {
    return this.y;
  }
  
  public int x() {
    return this.z;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\presenter\CircleDetailsPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */