package com.soft.blued.ui.feed.presenter;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.soft.blued.http.CircleHttpUtils;
import com.soft.blued.http.FeedHttpUtils;
import com.soft.blued.ui.circle.model.CircleAddPoints;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.feed.model.FeedComment;
import com.soft.blued.ui.feed.observer.CommentListDataObserver;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.user.UserInfo;

public class CommentPresenter extends MvpPresenter {
  private String h;
  
  private String i;
  
  private String j;
  
  private String k;
  
  private BluedIngSelfFeed l;
  
  private int m = -1;
  
  private String n;
  
  private boolean o;
  
  private int p;
  
  private int q = 1;
  
  private int r = 20;
  
  private boolean s;
  
  private FeedComment t;
  
  private String u;
  
  private String v;
  
  private void c(IFetchDataListener paramIFetchDataListener) {
    BluedUIHttpResponse<BluedEntityA<FeedComment>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<FeedComment>>(this, g(), paramIFetchDataListener) {
        protected void a(BluedEntityA<FeedComment> param1BluedEntityA) {
          if (param1BluedEntityA != null) {
            CommentPresenter.a(this.b, (FeedComment)param1BluedEntityA.getSingleData());
            this.a.a("comment", param1BluedEntityA.data);
            this.a.a("comments", (CommentPresenter.a(this.b)).comments);
            if (param1BluedEntityA.extra != null && param1BluedEntityA.extra.hasmore == 1) {
              CommentPresenter.a(this.b, true);
              return;
            } 
            CommentPresenter.a(this.b, false);
            this.a.b();
          } 
        }
        
        public boolean onUIFailure(int param1Int, String param1String) {
          if (CommentPresenter.b(this.b) != 1)
            CommentPresenter.c(this.b); 
          return super.onUIFailure(param1Int, param1String);
        }
        
        public void onUIFinish(boolean param1Boolean) {
          this.a.a(param1Boolean);
        }
        
        public void onUIStart() {
          this.a.a();
        }
      };
    boolean bool = A();
    String str1 = this.i;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(this.q);
    stringBuilder1.append("");
    String str2 = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(this.r);
    stringBuilder2.append("");
    FeedHttpUtils.a(bluedUIHttpResponse, bool, str1, str2, stringBuilder2.toString(), this.n, g());
  }
  
  public boolean A() {
    return B() ^ true;
  }
  
  public boolean B() {
    return TextUtils.isEmpty(this.k) ^ true;
  }
  
  public boolean C() {
    return this.o;
  }
  
  public void a(int paramInt) {
    (m()).must_anonym_reply = paramInt;
  }
  
  public void a(FragmentActivity paramFragmentActivity, Bundle paramBundle1, Bundle paramBundle2) {
    super.a(paramFragmentActivity, paramBundle1, paramBundle2);
    if (paramBundle1 != null) {
      this.h = paramBundle1.getString("title");
      this.j = paramBundle1.getString("feed_id");
      this.i = paramBundle1.getString("comment_id");
      this.k = paramBundle1.getString("circle_id");
      this.p = paramBundle1.getInt("from");
      this.l = (BluedIngSelfFeed)paramBundle1.getSerializable("feed_data");
      this.m = paramBundle1.getInt("anonymous_header_number");
      this.n = paramBundle1.getString("mark_comment_id");
      this.o = paramBundle1.getBoolean("can_at", true);
    } 
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {
    this.q = 1;
    c(paramIFetchDataListener);
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {
    this.q++;
    c(paramIFetchDataListener);
  }
  
  public void c(String paramString, boolean paramBoolean) {
    if (this.t == null)
      return; 
    if (TextUtils.isEmpty(this.u))
      w(); 
    FeedComment feedComment = new FeedComment();
    feedComment.comment_id = this.u;
    feedComment.is_ads = (m()).is_ads;
    feedComment.aid = (m()).aid;
    BluedUIHttpResponse<BluedEntityA<FeedComment>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<FeedComment>>(this, g(), paramBoolean) {
        public void a(BluedEntityA<FeedComment> param1BluedEntityA) {
          if (param1BluedEntityA != null && param1BluedEntityA.hasData()) {
            FeedComment feedComment = param1BluedEntityA.data.get(0);
            CommentListDataObserver.a().a(feedComment, (CommentPresenter.a(this.b)).comment_id);
            this.b.b("comment_success");
            if (this.a) {
              this.b.a(1);
            } else {
              this.b.a(2);
            } 
            this.b.b("comment_state");
            if (feedComment.circle_active_comment > 0) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("回帖成功，基分+");
              stringBuilder.append(feedComment.circle_active_comment);
              AppMethods.a(stringBuilder.toString());
              return;
            } 
            AppMethods.a(AppInfo.d().getString(2131758692));
          } 
        }
        
        public void onUIFinish(boolean param1Boolean) {
          this.b.b(null, param1Boolean);
        }
        
        public void onUIStart() {
          this.b.e_(null);
        }
      };
    if (A()) {
      FeedHttpUtils.a(bluedUIHttpResponse, m(), feedComment, paramString, g());
      return;
    } 
    CircleHttpUtils.a(bluedUIHttpResponse, m(), feedComment, paramString, paramBoolean, this.m, g());
  }
  
  public void d(String paramString) {
    this.u = paramString;
  }
  
  public void e(String paramString) {
    this.v = paramString;
  }
  
  public BluedIngSelfFeed m() {
    if (this.l == null)
      this.l = new BluedIngSelfFeed(); 
    return this.l;
  }
  
  public String n() {
    return this.k;
  }
  
  public String o() {
    return TextUtils.isEmpty(this.h) ? AppInfo.d().getString(2131758286) : this.h;
  }
  
  public String p() {
    return "feed_comment_floor";
  }
  
  public FeedComment q() {
    if (this.t == null)
      this.t = new FeedComment(); 
    return this.t;
  }
  
  public String r() {
    FeedComment feedComment = this.t;
    return (feedComment != null) ? feedComment.feed_id : null;
  }
  
  public boolean s() {
    FeedComment feedComment = this.t;
    return (feedComment == null) ? true : feedComment.comment_uid.equals(UserInfo.a().i().getUid());
  }
  
  public UserBasicModel t() {
    if (this.t != null && !s()) {
      UserBasicModel userBasicModel = new UserBasicModel();
      userBasicModel.name = this.t.user_name;
      userBasicModel.uid = this.t.comment_uid;
      userBasicModel.avatar = this.t.user_avatar;
      return userBasicModel;
    } 
    return null;
  }
  
  public void u() {
    FeedComment feedComment = this.t;
    if (feedComment != null) {
      boolean bool;
      String str1 = feedComment.comment_id;
      String str2 = this.t.feed_id;
      if (this.t.iliked == 0) {
        bool = true;
      } else {
        bool = false;
      } 
      FeedComment feedComment1 = this.t;
      feedComment1.iliked = bool;
      if (bool == true) {
        feedComment1.liked_count++;
      } else {
        feedComment1.liked_count--;
      } 
      a("like", this.t);
      FeedHttpUtils.a(str2, str1, bool, new BluedUIHttpResponse<BluedEntityA<CircleAddPoints>>(this, g()) {
            protected void a(BluedEntityA<CircleAddPoints> param1BluedEntityA) {
              if (param1BluedEntityA != null && param1BluedEntityA.hasData() && ((CircleAddPoints)param1BluedEntityA.getSingleData()).circle_active_liked_posting > 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("点赞成功，基分+");
                stringBuilder.append(((CircleAddPoints)param1BluedEntityA.getSingleData()).circle_active_liked_posting);
                AppMethods.a(stringBuilder.toString());
              } 
            }
          }g(), true);
    } 
  }
  
  public String v() {
    return this.v;
  }
  
  public void w() {
    FeedComment feedComment = this.t;
    if (feedComment == null)
      return; 
    this.u = feedComment.comment_id;
    this.v = this.t.user_name;
  }
  
  public int x() {
    return (m()).must_anonym_reply;
  }
  
  public int y() {
    return this.m;
  }
  
  public int z() {
    return this.p;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\presenter\CommentPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */