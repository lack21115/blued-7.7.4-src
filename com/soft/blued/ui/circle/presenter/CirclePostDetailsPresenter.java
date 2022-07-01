package com.soft.blued.ui.circle.presenter;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.core.AppMethods;
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
import com.soft.blued.ui.circle.adapter.CircleMainDetailCommentAdapter;
import com.soft.blued.ui.circle.model.CircleAddPoints;
import com.soft.blued.ui.circle.model.CircleJoinState;
import com.soft.blued.ui.circle.model.CircleMethods;
import com.soft.blued.ui.circle.model.MyCircleModel;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.feed.model.FeedComment;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.MarkDownLinkHelper;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;

public class CirclePostDetailsPresenter extends MvpPresenter {
  public boolean h = true;
  
  boolean i = false;
  
  private BluedIngSelfFeed j;
  
  private String k = "";
  
  private String l;
  
  private FeedProtos.NoteSource m;
  
  private CircleMainDetailCommentAdapter n;
  
  private int o = 1;
  
  private int p = 20;
  
  private boolean q = false;
  
  private int r = -1;
  
  private boolean s = true;
  
  private void c(IFetchDataListener paramIFetchDataListener) {
    String str;
    BluedUIHttpResponse<BluedEntityA<BluedIngSelfFeed>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<BluedIngSelfFeed>>(this, g(), paramIFetchDataListener) {
        boolean a;
        
        protected void a(BluedEntityA<BluedIngSelfFeed> param1BluedEntityA) {
          boolean bool = false;
          if (param1BluedEntityA != null && param1BluedEntityA.hasData()) {
            if (CirclePostDetailsPresenter.b(this.c) == 1) {
              CirclePostDetailsPresenter.a(this.c, (BluedIngSelfFeed)param1BluedEntityA.getSingleData());
              this.c.a("data_circle_detail", param1BluedEntityA.getSingleData());
              if (((CirclePostDetailsPresenter.c(this.c)).hot_comments == null || (CirclePostDetailsPresenter.c(this.c)).hot_comments.size() == 0) && ((CirclePostDetailsPresenter.c(this.c)).comments == null || (CirclePostDetailsPresenter.c(this.c)).comments.size() == 0)) {
                this.b.a("data_comment_list", new ArrayList());
              } else {
                ArrayList arrayList = new ArrayList();
                if ((CirclePostDetailsPresenter.c(this.c)).hot_comments != null && (CirclePostDetailsPresenter.c(this.c)).hot_comments.size() > 0) {
                  ((FeedComment)(CirclePostDetailsPresenter.c(this.c)).hot_comments.get((CirclePostDetailsPresenter.c(this.c)).hot_comments.size() - 1)).isLastHotComment = true;
                  if ((CirclePostDetailsPresenter.c(this.c)).hot_comments_more == 1)
                    ((FeedComment)(CirclePostDetailsPresenter.c(this.c)).hot_comments.get((CirclePostDetailsPresenter.c(this.c)).hot_comments.size() - 1)).isHasMoreHotComment = true; 
                  arrayList.addAll((CirclePostDetailsPresenter.c(this.c)).hot_comments);
                  arrayList.addAll((CirclePostDetailsPresenter.c(this.c)).comments);
                } else {
                  arrayList.addAll((CirclePostDetailsPresenter.c(this.c)).comments);
                } 
                this.b.a("data_comment_list", arrayList);
                boolean bool1 = bool;
                if (arrayList.size() > 1) {
                  bool1 = bool;
                  if (((FeedComment)arrayList.get(0)).comment_pics != null) {
                    bool1 = bool;
                    if (((FeedComment)arrayList.get(0)).comment_pics.length > 0)
                      bool1 = true; 
                  } 
                } 
                this.a = bool1;
              } 
            } else {
              this.b.a("data_comment_list", ((BluedIngSelfFeed)param1BluedEntityA.getSingleData()).comments);
            } 
            this.c.h = param1BluedEntityA.hasMore();
            return;
          } 
          this.c.h = false;
        }
        
        public boolean onUIFailure(int param1Int, String param1String) {
          if (CirclePostDetailsPresenter.b(this.c) <= 1)
            this.c.i(); 
          return super.onUIFailure(param1Int, param1String);
        }
        
        public void onUIFinish(boolean param1Boolean) {
          super.onUIFinish(param1Boolean);
          if (!param1Boolean)
            CirclePostDetailsPresenter.d(this.c); 
          if (!this.c.h) {
            IFetchDataListener iFetchDataListener1 = this.b;
            if (iFetchDataListener1 != null)
              iFetchDataListener1.b(); 
          } 
          IFetchDataListener iFetchDataListener = this.b;
          if (iFetchDataListener != null)
            iFetchDataListener.a(param1Boolean); 
          if (CirclePostDetailsPresenter.e(this.c)) {
            if (!TextUtils.isEmpty(CirclePostDetailsPresenter.f(this.c)))
              this.c.a("data_scroll_to_comment", Boolean.valueOf(this.a), false); 
            CirclePostDetailsPresenter.a(this.c, false);
          } 
          if (param1Boolean)
            CirclePostDetailsPresenter.g(this.c); 
        }
      };
    if (!p()) {
      str = this.k;
    } else {
      str = this.j.feed_id;
    } 
    CircleHttpUtils.a(bluedUIHttpResponse, str, this.o, this.p, this.l, g());
  }
  
  private void u() {
    if (!this.i) {
      boolean bool1;
      boolean bool2;
      boolean bool3;
      boolean bool4;
      FeedProtos.Event event = FeedProtos.Event.CIRCLE_NOTE_DETAIL_SHOW;
      String str1 = this.j.circle_id;
      String str2 = this.j.feed_id;
      FeedProtos.NoteSource noteSource = r();
      if (r() == FeedProtos.NoteSource.CIRCLE_TOP) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      FeedProtos.NoteType noteType = EventTrackFeed.b(this.j);
      boolean bool = this.j.isJoin();
      if (this.j.allow_join == 0) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      if (this.j.is_anonym == 1) {
        bool3 = true;
      } else {
        bool3 = false;
      } 
      if (this.j.is_essence == 1) {
        bool4 = true;
      } else {
        bool4 = false;
      } 
      EventTrackFeed.a(event, str1, str2, noteSource, bool1, noteType, bool, bool2, bool3, bool4, MarkDownLinkHelper.a(this.j.feed_content));
      this.i = true;
    } 
  }
  
  public void a(int paramInt) {
    CircleHttpUtils.a(new BluedUIHttpResponse(this, g()) {
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            AppMethods.d(2131759327);
          }
        }this.j.feed_id, paramInt, g());
  }
  
  public void a(FragmentActivity paramFragmentActivity, Bundle paramBundle1, Bundle paramBundle2) {
    super.a(paramFragmentActivity, paramBundle1, paramBundle2);
    if (paramBundle1 != null) {
      this.j = (BluedIngSelfFeed)paramBundle1.getSerializable("feed_data");
      this.k = paramBundle1.getString("feed_id");
      this.l = paramBundle1.getString("comment_id");
      this.m = (FeedProtos.NoteSource)paramBundle1.getSerializable("circle_from_page");
      if (this.m == null)
        this.m = FeedProtos.NoteSource.UNKNOWN_NOTE_SOURCE; 
      this.q = paramBundle1.getBoolean("to_web_view");
      a("data_circle_detail", this.j);
    } 
    this.r = CircleMethods.getAnonymousHeaderNumber((Context)h());
  }
  
  public void a(FragmentManager paramFragmentManager) {
    if (h() != null && paramFragmentManager != null)
      CircleMethods.joinCircle((Context)h(), null, n().getJoinState(), g(), paramFragmentManager, false, true); 
  }
  
  public void a(LifecycleOwner paramLifecycleOwner) {
    super.a(paramLifecycleOwner);
    this.n.d();
    paramLifecycleOwner.getLifecycle().addObserver((LifecycleObserver)new LifecycleEventObserver(this, paramLifecycleOwner) {
          public void onStateChanged(LifecycleOwner param1LifecycleOwner, Lifecycle.Event param1Event) {
            if (param1Event == Lifecycle.Event.ON_DESTROY) {
              CirclePostDetailsPresenter.a(this.b).A();
              this.a.getLifecycle().removeObserver((LifecycleObserver)this);
            } 
          }
        });
    LiveEventBus.get("circle_delete_feed", String.class).observe(paramLifecycleOwner, new Observer<String>(this) {
          public void a(String param1String) {
            if (!TextUtils.isEmpty(param1String) && param1String.equals((this.a.n()).feed_id))
              this.a.i(); 
          }
        });
    LiveEventBus.get("circle_join_state", CircleJoinState.class).observe(paramLifecycleOwner, new Observer<CircleJoinState>(this) {
          public void a(CircleJoinState param1CircleJoinState) {
            if (!TextUtils.isEmpty(this.a.o()) && this.a.o().equals(param1CircleJoinState.circle_id)) {
              this.a.n().setJoinState(param1CircleJoinState);
              CirclePostDetailsPresenter circlePostDetailsPresenter = this.a;
              circlePostDetailsPresenter.a("data_circle_join", circlePostDetailsPresenter.n());
            } 
          }
        });
    LiveEventBus.get("feed_post_meanwhile_comment", FeedComment.class).observe(paramLifecycleOwner, new Observer<FeedComment>(this) {
          public void a(FeedComment param1FeedComment) {
            this.a.a("data_add_comment", param1FeedComment);
          }
        });
    LiveEventBus.get("circle_info_modify", MyCircleModel.class).observe(paramLifecycleOwner, new Observer<MyCircleModel>(this) {
          public void a(MyCircleModel param1MyCircleModel) {
            if (param1MyCircleModel != null && this.a.o().equals(param1MyCircleModel.circle_id)) {
              (this.a.n()).cover = param1MyCircleModel.cover;
              CirclePostDetailsPresenter circlePostDetailsPresenter = this.a;
              circlePostDetailsPresenter.a("data_circle_detail", circlePostDetailsPresenter.n());
            } 
          }
        });
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {
    this.o = 1;
    this.h = true;
    c(paramIFetchDataListener);
  }
  
  public void a(CircleMainDetailCommentAdapter paramCircleMainDetailCommentAdapter) {
    this.n = paramCircleMainDetailCommentAdapter;
  }
  
  public void a(FeedComment paramFeedComment, String paramString, boolean paramBoolean) {
    if (p()) {
      boolean bool;
      FeedProtos.NoteSource noteSource;
      String str1;
      if (TextUtils.isEmpty(this.j.circle_id))
        return; 
      if (this.m == FeedProtos.NoteSource.CIRCLE_RECOMMEND_LIST || this.m == FeedProtos.NoteSource.CITY_NOTE) {
        noteSource = this.m;
      } else {
        noteSource = FeedProtos.NoteSource.NOTE_DETAIL;
      } 
      FeedProtos.Event event = FeedProtos.Event.CIRCLE_NOTE_COMMENT;
      String str2 = this.j.circle_id;
      String str3 = this.j.feed_id;
      if (paramFeedComment == null) {
        str1 = "";
      } else {
        str1 = paramFeedComment.comment_id;
      } 
      boolean bool1 = StringUtils.a(paramString);
      FeedProtos.FeedClass feedClass = EventTrackFeed.a(paramFeedComment);
      FeedProtos.NoteType noteType = EventTrackFeed.b(this.j);
      if (this.j.is_anonym == 1) {
        bool = true;
      } else {
        bool = false;
      } 
      EventTrackFeed.a(event, str2, str3, str1, bool1, feedClass, noteType, bool, paramBoolean, noteSource);
      CircleHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<FeedComment>>(this, g(), paramFeedComment, paramBoolean) {
            protected void a(BluedEntityA<FeedComment> param1BluedEntityA) {
              if (param1BluedEntityA != null && param1BluedEntityA.hasData()) {
                FeedComment feedComment = param1BluedEntityA.data.get(0);
                if (this.a == null) {
                  this.c.a("data_add_comment", feedComment);
                } else {
                  this.c.a("data_add_reply", feedComment);
                } 
                if (this.b) {
                  (this.c.n()).must_anonym_reply = 1;
                } else {
                  (this.c.n()).must_anonym_reply = 2;
                } 
                CirclePostDetailsPresenter circlePostDetailsPresenter = this.c;
                circlePostDetailsPresenter.a("data_comment_state", circlePostDetailsPresenter.n());
                if (feedComment.circle_active_comment > 0) {
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append("回帖成功，基分+");
                  stringBuilder.append(feedComment.circle_active_comment);
                  AppMethods.a(stringBuilder.toString());
                  return;
                } 
                AppMethods.a(this.c.h().getString(2131758692));
              } 
            }
            
            public void onUIFinish(boolean param1Boolean) {
              super.onUIFinish(param1Boolean);
              this.c.b("", param1Boolean);
              this.c.b("data_enable_send_click");
            }
            
            public void onUIStart() {
              super.onUIStart();
              this.c.e_("");
            }
          }n(), paramFeedComment, paramString, paramBoolean, this.r, g());
    } 
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {
    this.o++;
    c(paramIFetchDataListener);
  }
  
  public void m() {
    boolean bool1;
    boolean bool2;
    if (!p())
      return; 
    FeedProtos.Event event = FeedProtos.Event.CIRCLE_NOTE_LIKE;
    String str1 = this.j.circle_id;
    String str2 = this.j.feed_id;
    if (this.j.iliked == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    boolean bool = StringUtils.a(this.j.feed_content);
    FeedProtos.FeedClass feedClass = EventTrackFeed.a(this.j);
    FeedProtos.NoteType noteType = EventTrackFeed.b(this.j);
    if (this.j.is_anonym == 1) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    EventTrackFeed.a(event, str1, str2, "", bool1, bool, feedClass, noteType, bool2, false, FeedProtos.NoteSource.NOTE_DETAIL);
    if (this.j.iliked == 0) {
      BluedIngSelfFeed bluedIngSelfFeed1 = this.j;
      bluedIngSelfFeed1.iliked = 1;
      bluedIngSelfFeed1.feed_dig++;
      this.j.isPlayLikeAnim = true;
      a("data_circle_detail", n());
      LiveEventBus.get("feed_like_change").post(this.j);
      CircleHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<CircleAddPoints>>(this, g()) {
            protected void a(BluedEntityA<CircleAddPoints> param1BluedEntityA) {
              if (param1BluedEntityA != null && param1BluedEntityA.hasData() && ((CircleAddPoints)param1BluedEntityA.getSingleData()).circle_active_liked_posting > 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("点赞成功，基分+");
                stringBuilder.append(((CircleAddPoints)param1BluedEntityA.getSingleData()).circle_active_liked_posting);
                AppMethods.a(stringBuilder.toString());
              } 
            }
          }UserInfo.a().i().getUid(), this.j.feed_id, this.j.liked_url, g());
      return;
    } 
    BluedIngSelfFeed bluedIngSelfFeed = this.j;
    bluedIngSelfFeed.iliked = 0;
    if (bluedIngSelfFeed.feed_dig > 0) {
      bluedIngSelfFeed = this.j;
      bluedIngSelfFeed.feed_dig--;
    } 
    a("data_circle_detail", n());
    LiveEventBus.get("feed_like_change").post(this.j);
    CircleHttpUtils.a(null, UserInfo.a().i().getUid(), this.j.feed_id, g());
  }
  
  public BluedIngSelfFeed n() {
    if (!p())
      this.j = new BluedIngSelfFeed(); 
    return this.j;
  }
  
  public String o() {
    return (n()).circle_id;
  }
  
  public boolean p() {
    BluedIngSelfFeed bluedIngSelfFeed = this.j;
    return (bluedIngSelfFeed != null && !TextUtils.isEmpty(bluedIngSelfFeed.feed_id));
  }
  
  public String q() {
    if (TextUtils.isEmpty(this.k))
      this.k = (n()).feed_id; 
    return this.k;
  }
  
  public FeedProtos.NoteSource r() {
    return this.m;
  }
  
  public int s() {
    return this.r;
  }
  
  public boolean t() {
    return this.q;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\presenter\CirclePostDetailsPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */