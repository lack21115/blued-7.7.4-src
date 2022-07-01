package com.soft.blued.ui.feed.presenter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.framework.utils.AppUtils;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.http.FeedHttpUtils;
import com.soft.blued.ui.feed.manager.FeedMethods;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.feed.model.BluedRepostEntityExtra;
import com.soft.blued.ui.feed.model.FeedComment;
import com.soft.blued.ui.feed.model.FeedDetailsExtra;
import com.soft.blued.ui.feed.model.FeedParse;
import com.soft.blued.ui.feed.model.FeedRepost;
import com.soft.blued.ui.feed.observer.CommentListDataObserver;
import com.soft.blued.ui.feed.observer.IFeedDataObserver;
import com.soft.blued.ui.feed.observer.LikeListDataObserver;
import com.soft.blued.ui.find.model.BluedRecommendUsers;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.ArrayList;
import java.util.List;

public class FeedDetailsPresenter extends MvpPresenter implements IFeedDataObserver {
  private DataStatus A = new DataStatus(this);
  
  private BluedIngSelfFeed h;
  
  private String i;
  
  private int j = -1;
  
  private int k = -1;
  
  private int l;
  
  private String m;
  
  private boolean n = true;
  
  private boolean o = false;
  
  private List<FeedComment> p = new ArrayList<FeedComment>();
  
  private boolean q;
  
  private String r;
  
  private String s;
  
  private boolean t = true;
  
  private int u = 1;
  
  private int v = 1;
  
  private int w = 1;
  
  private int x = 1;
  
  private boolean y = true;
  
  private int z = 1;
  
  private void k(IFetchDataListener paramIFetchDataListener) {
    paramIFetchDataListener.a("comment_list", this.p);
    this.p.clear();
    paramIFetchDataListener.a(true);
  }
  
  private void l(IFetchDataListener paramIFetchDataListener) {
    Activity activity = h();
    BluedUIHttpResponse<BluedEntityA<BluedIngSelfFeed>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<BluedIngSelfFeed>>(this, g(), paramIFetchDataListener) {
        protected BluedEntityA<BluedIngSelfFeed> a(String param1String) {
          BluedEntityA<BluedIngSelfFeed> bluedEntityA = (BluedEntityA)super.parseData(param1String);
          if (bluedEntityA != null) {
            if (!bluedEntityA.hasData())
              return bluedEntityA; 
            for (BluedIngSelfFeed bluedIngSelfFeed : bluedEntityA.data)
              bluedIngSelfFeed.feedParse = new FeedParse((Context)this.b.h(), bluedIngSelfFeed, 14); 
          } 
          return bluedEntityA;
        }
        
        protected void a(BluedEntityA<BluedIngSelfFeed> param1BluedEntityA) {
          if (param1BluedEntityA != null) {
            this.a.a("feed_list", param1BluedEntityA.data);
            if (param1BluedEntityA.extra != null && param1BluedEntityA.extra.hasmore == 1) {
              (FeedDetailsPresenter.c(this.b)).d = true;
              return;
            } 
            (FeedDetailsPresenter.c(this.b)).d = false;
            return;
          } 
          (FeedDetailsPresenter.c(this.b)).d = false;
        }
        
        public void onUIFinish(boolean param1Boolean) {
          if (!param1Boolean)
            (FeedDetailsPresenter.c(this.b)).d = false; 
          (FeedDetailsPresenter.c(this.b)).h = param1Boolean ^ true;
          if (FeedDetailsPresenter.d(this.b) == 1 && !(FeedDetailsPresenter.c(this.b)).d)
            this.a.b(); 
          this.a.a(param1Boolean);
        }
      };
    String str = q();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.x);
    stringBuilder.append("");
    FeedHttpUtils.a((Context)activity, bluedUIHttpResponse, str, stringBuilder.toString(), "20", g());
  }
  
  private void m(IFetchDataListener paramIFetchDataListener) {
    BluedUIHttpResponse<BluedEntity<BluedIngSelfFeed, FeedDetailsExtra>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntity<BluedIngSelfFeed, FeedDetailsExtra>>(this, g(), paramIFetchDataListener) {
        public boolean onUIFailure(int param1Int, String param1String) {
          if (param1Int >= 0)
            this.b.i(); 
          return super.onUIFailure(param1Int, param1String);
        }
        
        public void onUIFinish(boolean param1Boolean) {
          if (!param1Boolean)
            (FeedDetailsPresenter.c(this.b)).b = false; 
          (FeedDetailsPresenter.c(this.b)).f = param1Boolean ^ true;
          if (FeedDetailsPresenter.d(this.b) == 1 && !FeedDetailsPresenter.g(this.b) && !(FeedDetailsPresenter.c(this.b)).b)
            this.a.b(); 
          this.a.a(param1Boolean);
          if (FeedDetailsPresenter.h(this.b)) {
            this.b.b("show_keyboard");
            FeedDetailsPresenter.a(this.b, false);
          } 
          if (FeedDetailsPresenter.i(this.b)) {
            if (!TextUtils.isEmpty(FeedDetailsPresenter.j(this.b)))
              this.b.b("scroll_to_comment"); 
            FeedDetailsPresenter.b(this.b, false);
          } 
        }
        
        public void onUIUpdate(BluedEntity<BluedIngSelfFeed, FeedDetailsExtra> param1BluedEntity) {
          boolean bool = false;
          if (param1BluedEntity != null && param1BluedEntity.data != null && param1BluedEntity.data.size() > 0) {
            if (param1BluedEntity.getSingleData() != null) {
              if (!TextUtils.isEmpty(((BluedIngSelfFeed)param1BluedEntity.getSingleData()).feed_id)) {
                FeedDetailsPresenter.a(this.b, (BluedIngSelfFeed)param1BluedEntity.getSingleData());
                this.a.a("feed_data", param1BluedEntity.data);
              } 
              if (FeedDetailsPresenter.e(this.b) == 1) {
                if (((FeedDetailsPresenter.b(this.b)).hot_comments == null || (FeedDetailsPresenter.b(this.b)).hot_comments.size() == 0) && ((FeedDetailsPresenter.b(this.b)).comments == null || (FeedDetailsPresenter.b(this.b)).comments.size() == 0)) {
                  (FeedDetailsPresenter.c(this.b)).b = false;
                } else {
                  ArrayList arrayList = new ArrayList();
                  if ((FeedDetailsPresenter.b(this.b)).hot_comments != null && (FeedDetailsPresenter.b(this.b)).hot_comments.size() > 0) {
                    ((FeedComment)(FeedDetailsPresenter.b(this.b)).hot_comments.get((FeedDetailsPresenter.b(this.b)).hot_comments.size() - 1)).isLastHotComment = true;
                    if ((FeedDetailsPresenter.b(this.b)).hot_comments_more == 1)
                      ((FeedComment)(FeedDetailsPresenter.b(this.b)).hot_comments.get((FeedDetailsPresenter.b(this.b)).hot_comments.size() - 1)).isHasMoreHotComment = true; 
                    arrayList.addAll((FeedDetailsPresenter.b(this.b)).hot_comments);
                    arrayList.addAll((FeedDetailsPresenter.b(this.b)).comments);
                  } else {
                    arrayList.addAll((FeedDetailsPresenter.b(this.b)).comments);
                  } 
                  if (arrayList.size() > 7) {
                    ArrayList arrayList1 = new ArrayList();
                    for (int i = 0; i < arrayList.size(); i++) {
                      if (i < 7) {
                        arrayList1.add(arrayList.get(i));
                      } else {
                        FeedDetailsPresenter.f(this.b).add(arrayList.get(i));
                      } 
                    } 
                    this.a.a("comment_list", arrayList1);
                  } else {
                    this.a.a("comment_list", arrayList);
                  } 
                } 
              } else {
                this.a.a("comment_list", ((BluedIngSelfFeed)param1BluedEntity.getSingleData()).comments);
              } 
            } 
            if (param1BluedEntity.extra != null) {
              this.b.a("show_ad", ((FeedDetailsExtra)param1BluedEntity.extra).adms);
              FeedDetailsPresenter.DataStatus dataStatus = FeedDetailsPresenter.c(this.b);
              if (((FeedDetailsExtra)param1BluedEntity.extra).hasmore == 1)
                bool = true; 
              dataStatus.b = bool;
              return;
            } 
            (FeedDetailsPresenter.c(this.b)).b = false;
            return;
          } 
          (FeedDetailsPresenter.c(this.b)).b = false;
        }
      };
    String str = q();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.v);
    stringBuilder.append("");
    FeedHttpUtils.a(bluedUIHttpResponse, str, stringBuilder.toString(), "40", this.i, this.h.is_ads, g());
  }
  
  private void n(IFetchDataListener paramIFetchDataListener) {
    Activity activity = h();
    BluedUIHttpResponse<BluedEntityA<BluedRecommendUsers>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<BluedRecommendUsers>>(this, paramIFetchDataListener) {
        public void a(BluedEntityA<BluedRecommendUsers> param1BluedEntityA) {
          if (param1BluedEntityA != null) {
            this.a.a("like_list", param1BluedEntityA.data);
            if (param1BluedEntityA.extra != null && param1BluedEntityA.extra.hasmore == 1) {
              (FeedDetailsPresenter.c(this.b)).a = true;
              return;
            } 
            (FeedDetailsPresenter.c(this.b)).a = false;
            return;
          } 
          (FeedDetailsPresenter.c(this.b)).a = false;
        }
        
        public void onUIFinish(boolean param1Boolean) {
          if (!param1Boolean)
            (FeedDetailsPresenter.c(this.b)).a = false; 
          (FeedDetailsPresenter.c(this.b)).e = param1Boolean ^ true;
          if (FeedDetailsPresenter.d(this.b) == 0 && !(FeedDetailsPresenter.c(this.b)).a)
            this.a.b(); 
          this.a.a(param1Boolean);
        }
      };
    String str = q();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.u);
    stringBuilder.append("");
    FeedHttpUtils.b((Context)activity, bluedUIHttpResponse, str, stringBuilder.toString(), "20", this.h.is_ads, g());
  }
  
  private void o(IFetchDataListener paramIFetchDataListener) {
    Activity activity = h();
    BluedUIHttpResponse<BluedEntity<FeedRepost, BluedRepostEntityExtra>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntity<FeedRepost, BluedRepostEntityExtra>>(this, paramIFetchDataListener) {
        public void onUIFinish(boolean param1Boolean) {
          if (!param1Boolean)
            (FeedDetailsPresenter.c(this.b)).c = false; 
          (FeedDetailsPresenter.c(this.b)).g = param1Boolean ^ true;
          if (FeedDetailsPresenter.d(this.b) == 0 && this.a != null && !(FeedDetailsPresenter.c(this.b)).c)
            this.a.b(); 
          IFetchDataListener iFetchDataListener = this.a;
          if (iFetchDataListener != null)
            iFetchDataListener.a(param1Boolean); 
        }
        
        public void onUIUpdate(BluedEntity<FeedRepost, BluedRepostEntityExtra> param1BluedEntity) {
          if (param1BluedEntity != null) {
            IFetchDataListener iFetchDataListener = this.a;
            if (iFetchDataListener != null) {
              iFetchDataListener.a("repost_list", param1BluedEntity.data);
            } else {
              this.b.a("repost_list", param1BluedEntity.data);
            } 
            if (param1BluedEntity.extra != null && ((BluedRepostEntityExtra)param1BluedEntity.extra).hasmore == 1) {
              (FeedDetailsPresenter.c(this.b)).c = true;
              return;
            } 
            (FeedDetailsPresenter.c(this.b)).c = false;
            return;
          } 
          (FeedDetailsPresenter.c(this.b)).c = false;
        }
      };
    String str = q();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.w);
    stringBuilder.append("");
    FeedHttpUtils.a((Context)activity, bluedUIHttpResponse, str, stringBuilder.toString(), "20", this.h.is_ads, g());
  }
  
  public DataStatus A() {
    return this.A;
  }
  
  public boolean B() {
    List<FeedComment> list = this.p;
    return (list != null && list.size() > 0);
  }
  
  public String C() {
    return this.s;
  }
  
  public void a(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("notifyDynamicSkin resId:");
    stringBuilder.append(paramInt);
    Log.v("drb", stringBuilder.toString());
    if (paramInt != -1 && TextUtils.equals(this.h.feed_uid, (UserInfo.a().i()).uid))
      this.h.theme_id = paramInt; 
    b("feed_data");
  }
  
  public void a(FragmentActivity paramFragmentActivity, Bundle paramBundle1, Bundle paramBundle2) {
    super.a(paramFragmentActivity, paramBundle1, paramBundle2);
    if (paramBundle1 != null) {
      this.j = paramBundle1.getInt("from", -1);
      int i = this.j;
      if (i != 0) {
        if (i != 1) {
          if (i != 4) {
            if (i != 6) {
              if (i == 8)
                this.k = 10; 
            } else {
              this.k = 7;
            } 
          } else {
            this.k = 6;
          } 
        } else {
          this.k = 9;
        } 
      } else {
        this.k = 8;
      } 
      this.l = paramBundle1.getInt("show_photo");
      i = paramBundle1.getInt("feed_is_ads");
      String str = paramBundle1.getString("feed_aid");
      this.q = paramBundle1.getBoolean("if_from_comment");
      try {
        this.h = (BluedIngSelfFeed)paramBundle1.getSerializable("feed_data");
        this.i = paramBundle1.getString("feed_comment_id");
        this.m = (r().getContentData()).user_name;
        (r()).is_ads = i;
        (r()).aid = str;
        (r()).is_recommend_ticktocks = 0;
        (r()).recommend_text = null;
        (r()).distance = null;
        (r()).feed_timestamp = null;
        b("feed_data");
        return;
      } catch (Exception exception) {
        i();
        exception.printStackTrace();
      } 
    } 
  }
  
  public void a(LifecycleOwner paramLifecycleOwner) {
    super.a(paramLifecycleOwner);
    FeedMethods.a(paramLifecycleOwner, this);
    LiveEventBus.get("feed_post_meanwhile_comment", FeedComment.class).observe(paramLifecycleOwner, new Observer<FeedComment>(this) {
          public void a(FeedComment param1FeedComment) {
            CommentListDataObserver.a().a(param1FeedComment, FeedDetailsPresenter.a(this.a));
            LiveEventBus.get("feed_add_comment").post(param1FeedComment);
            this.a.b("init_edit");
          }
        });
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {
    (A()).b = true;
    e(paramIFetchDataListener);
    c(paramIFetchDataListener);
    (A()).a = true;
    g(paramIFetchDataListener);
    (A()).c = true;
    i(paramIFetchDataListener);
  }
  
  public void a(BluedIngSelfFeed paramBluedIngSelfFeed) {}
  
  public void a(FeedComment paramFeedComment) {
    if (paramFeedComment != null && q().equals(paramFeedComment.feed_id)) {
      BluedIngSelfFeed bluedIngSelfFeed = r();
      bluedIngSelfFeed.feed_comment++;
      b("feed_data");
      a("feed_no_data_tab", Integer.valueOf(1));
    } 
  }
  
  public void a(FeedRepost paramFeedRepost) {
    if (paramFeedRepost != null && q().equals(paramFeedRepost.feed_id)) {
      BluedIngSelfFeed bluedIngSelfFeed = r();
      bluedIngSelfFeed.repost_count++;
      b("feed_data");
      a("feed_no_data_tab", Integer.valueOf(2));
    } 
  }
  
  public void a(String paramString, int paramInt) {
    if (q().equals(paramString)) {
      (r()).allow_comments = paramInt;
      b("feed_data");
    } 
  }
  
  public void a(String paramString1, String paramString2) {
    if (q().equals(paramString1)) {
      BluedIngSelfFeed bluedIngSelfFeed = r();
      bluedIngSelfFeed.feed_comment--;
      if ((r()).feed_comment < 0)
        (r()).feed_comment = 0; 
      b("feed_data");
      a("feed_no_data_tab", Integer.valueOf(1));
    } 
  }
  
  public void a(boolean paramBoolean) {
    this.o = paramBoolean;
  }
  
  public void b(int paramInt) {
    if (paramInt != -1 && TextUtils.equals(this.h.feed_uid, (UserInfo.a().i()).uid))
      this.h.theme_pendant = paramInt; 
    b("feed_data");
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {
    int i = this.z;
    if (i != 0) {
      if (i != 1) {
        if (i != 2)
          return; 
        j(paramIFetchDataListener);
        return;
      } 
      if (this.o) {
        if (this.p.size() > 0) {
          k(paramIFetchDataListener);
          return;
        } 
        f(paramIFetchDataListener);
        return;
      } 
      d(paramIFetchDataListener);
      return;
    } 
    h(paramIFetchDataListener);
  }
  
  public void b(String paramString, int paramInt) {
    if (q().equals(paramString)) {
      (r()).reading_scope = paramInt;
      b("feed_data");
    } 
  }
  
  public void b(String paramString1, String paramString2) {}
  
  public void b(boolean paramBoolean) {
    LiveEventBus.get("feed_vote_change").post(this.h);
    FeedHttpUtils.a(new BluedUIHttpResponse<BluedEntityA>(this, g()) {
          public void a(BluedEntityA param1BluedEntityA) {}
        }q(), (UserInfo.a().i()).uid, paramBoolean, g());
  }
  
  public void c(int paramInt) {
    this.z = paramInt;
  }
  
  public void c(IFetchDataListener paramIFetchDataListener) {
    this.x = 1;
    this.A.d = true;
    l(paramIFetchDataListener);
  }
  
  public void c(String paramString, int paramInt) {
    if (q().equals(paramString)) {
      if (paramInt == 1) {
        BluedIngSelfFeed bluedIngSelfFeed = r();
        bluedIngSelfFeed.feed_dig++;
      } else {
        BluedIngSelfFeed bluedIngSelfFeed = r();
        bluedIngSelfFeed.feed_dig--;
        if ((r()).feed_dig < 0)
          (r()).feed_dig = 0; 
      } 
      (r()).iliked = paramInt;
      b("feed_data");
      a("feed_no_data_tab", Integer.valueOf(0));
      (r()).isPlayLikeAnim = false;
    } 
  }
  
  public void c(String paramString1, String paramString2) {
    FeedHttpUtils.a((Context)h(), new BluedUIHttpResponse<BluedEntity>(this) {
          public void onSuccess(String param1String) {
            AppMethods.d(2131758599);
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {}
        },  paramString1, paramString2, g());
  }
  
  public void c(boolean paramBoolean) {
    this.t = paramBoolean;
  }
  
  public void d(IFetchDataListener paramIFetchDataListener) {
    if (this.A.d) {
      this.x++;
      l(paramIFetchDataListener);
    } 
  }
  
  public void d(String paramString) {
    if (q().equals(paramString))
      i(); 
  }
  
  public void e(IFetchDataListener paramIFetchDataListener) {
    this.v = 1;
    m(paramIFetchDataListener);
  }
  
  public void e(String paramString) {
    if (q().equals(paramString)) {
      int i;
      BluedIngSelfFeed bluedIngSelfFeed = r();
      bluedIngSelfFeed.repost_count--;
      bluedIngSelfFeed = r();
      if ((r()).repost_count < 0) {
        i = 0;
      } else {
        i = (r()).repost_count;
      } 
      bluedIngSelfFeed.repost_count = i;
      b("feed_data");
      a("feed_no_data_tab", Integer.valueOf(2));
      i((IFetchDataListener)null);
    } 
  }
  
  public void f(IFetchDataListener paramIFetchDataListener) {
    if (this.A.b) {
      this.v++;
      m(paramIFetchDataListener);
    } 
  }
  
  public void f(String paramString) {
    FeedComment feedComment = new FeedComment();
    if (!this.t) {
      feedComment.comment_id = this.s;
      feedComment.is_ads = this.h.is_ads;
      feedComment.aid = this.h.aid;
    } 
    FeedHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<FeedComment>>(this, g()) {
          public void a(BluedEntityA<FeedComment> param1BluedEntityA) {
            if (param1BluedEntityA != null)
              try {
                if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
                  FeedComment feedComment = param1BluedEntityA.data.get(0);
                  CommentListDataObserver.a().a(feedComment, FeedDetailsPresenter.a(this.a));
                  LiveEventBus.get("feed_add_comment").post(feedComment);
                  this.a.b("init_edit");
                  AppMethods.a(AppUtils.a(2131758692));
                  return;
                } 
              } catch (Exception exception) {
                AppMethods.a(AppUtils.a(2131756082));
              }  
          }
          
          public void onUIFinish(boolean param1Boolean) {
            this.a.b("_load_type_default_", param1Boolean);
          }
          
          public void onUIStart() {
            this.a.e_("_load_type_default_");
          }
        }r(), feedComment, paramString, g());
  }
  
  public void g(IFetchDataListener paramIFetchDataListener) {
    this.u = 1;
    n(paramIFetchDataListener);
  }
  
  public void g(String paramString) {
    this.r = paramString;
  }
  
  public void h(IFetchDataListener paramIFetchDataListener) {
    if (this.A.a) {
      this.u++;
      n(paramIFetchDataListener);
    } 
  }
  
  public void h(String paramString) {
    this.s = paramString;
  }
  
  public void i(IFetchDataListener paramIFetchDataListener) {
    this.w = 1;
    o(paramIFetchDataListener);
  }
  
  public void j(IFetchDataListener paramIFetchDataListener) {
    if (this.A.c) {
      this.w++;
      o(paramIFetchDataListener);
    } 
  }
  
  public void m() {
    FeedHttpUtils.a((Context)h(), new BluedUIHttpResponse<BluedEntity>(this) {
          public void onUIFinish(boolean param1Boolean) {
            this.a.b("_load_type_default_", param1Boolean);
          }
          
          public void onUIStart() {
            this.a.e_("_load_type_default_");
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            AppMethods.d(2131756175);
            LiveEventBus.get("feed_delete").post(this.a.q());
            if ((FeedDetailsPresenter.b(this.a)).repost != null)
              LiveEventBus.get("feed_delete_repost").post((FeedDetailsPresenter.b(this.a)).repost.feed_id); 
            this.a.i();
          }
        }q(), g(), true);
  }
  
  public void n() {
    if (!UserRelationshipUtils.a(this.h.relationship)) {
      BluedIngSelfFeed bluedIngSelfFeed = this.h;
      bluedIngSelfFeed.iliked = 1;
      bluedIngSelfFeed.isPlayLikeAnim = true;
      LikeListDataObserver.a().a(UserInfo.a().i().getUid(), this.h.iliked);
      LiveEventBus.get("feed_like_change").post(this.h);
      FeedHttpUtils.a((Context)h(), null, UserInfo.a().i().getUid(), q(), this.h.is_ads, this.h.liked_url, g());
    } 
  }
  
  public void o() {
    if (!UserRelationshipUtils.a(this.h.relationship)) {
      this.h.iliked = 0;
      LikeListDataObserver.a().a(UserInfo.a().i().getUid(), this.h.iliked);
      LiveEventBus.get("feed_like_change").post(this.h);
      FeedHttpUtils.a((Context)h(), null, UserInfo.a().i().getUid(), q(), this.h.is_ads, g());
    } 
  }
  
  public int p() {
    return this.z;
  }
  
  public String q() {
    String str = (r()).feed_id;
    if (TextUtils.isEmpty(str))
      i(); 
    return str;
  }
  
  public BluedIngSelfFeed r() {
    if (this.h == null)
      this.h = new BluedIngSelfFeed(); 
    return this.h;
  }
  
  public FeedParse s() {
    if ((r()).feedParse == null)
      (r()).feedParse = new FeedParse((Context)h(), this.h, 2, (r()).super_topics_name); 
    return (r()).feedParse;
  }
  
  public boolean t() {
    return ((r()).is_repost == 1 && (r()).repost != null);
  }
  
  public BluedIngSelfFeed u() {
    return t() ? (r()).repost : r();
  }
  
  public boolean v() {
    return this.n;
  }
  
  public int w() {
    return this.j;
  }
  
  public int x() {
    return this.k;
  }
  
  public int y() {
    return this.l;
  }
  
  public String z() {
    return this.m;
  }
  
  public class DataStatus {
    public boolean a = true;
    
    public boolean b = true;
    
    public boolean c = true;
    
    public boolean d = true;
    
    public boolean e = false;
    
    public boolean f = false;
    
    public boolean g = false;
    
    public boolean h = false;
    
    public DataStatus(FeedDetailsPresenter this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\presenter\FeedDetailsPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */