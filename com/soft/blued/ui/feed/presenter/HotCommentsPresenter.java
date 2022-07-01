package com.soft.blued.ui.feed.presenter;

import android.app.Dialog;
import android.content.Context;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.utils.DialogUtils;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.http.CircleHttpUtils;
import com.soft.blued.http.FeedHttpUtils;
import com.soft.blued.ui.circle.model.CircleMethods;
import com.soft.blued.ui.feed.adapter.CommentListAdapter;
import com.soft.blued.ui.feed.contract.IHotCommentsContract;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.feed.model.FeedComment;
import com.soft.blued.ui.feed.observer.CommentListDataObserver;
import java.util.ArrayList;

public class HotCommentsPresenter implements IHotCommentsContract.IPresenter {
  private IHotCommentsContract.IView a;
  
  private Context b;
  
  private IRequestHost c;
  
  private BluedIngSelfFeed d;
  
  private int e = 1;
  
  private boolean f;
  
  private boolean g = true;
  
  private boolean h = true;
  
  private String i;
  
  private String j;
  
  private CommentListAdapter.FeedCommentListner k;
  
  private Dialog l;
  
  private BluedUIHttpResponse m = new BluedUIHttpResponse<BluedEntityA<BluedIngSelfFeed>>(this) {
      public void a(BluedEntityA<BluedIngSelfFeed> param1BluedEntityA) {
        HotCommentsPresenter.a(this.a).aH_();
        if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0 && param1BluedEntityA.data.get(0) != null && ((BluedIngSelfFeed)param1BluedEntityA.data.get(0)).comments != null) {
          if (((BluedIngSelfFeed)param1BluedEntityA.data.get(0)).comments.size() > 0) {
            if (param1BluedEntityA.extra != null && param1BluedEntityA.extra.hasmore == 1) {
              HotCommentsPresenter.b(this.a, true);
              HotCommentsPresenter.a(this.a).a();
            } else {
              HotCommentsPresenter.b(this.a, false);
              HotCommentsPresenter.a(this.a).b();
            } 
            if (HotCommentsPresenter.b(this.a) == 1) {
              HotCommentsPresenter.a(this.a).b(((BluedIngSelfFeed)param1BluedEntityA.data.get(0)).comments);
              return;
            } 
            HotCommentsPresenter.a(this.a).a(((BluedIngSelfFeed)param1BluedEntityA.data.get(0)).comments);
            return;
          } 
          HotCommentsPresenter.a(this.a).b();
          if (HotCommentsPresenter.b(this.a) == 1) {
            HotCommentsPresenter.a(this.a).aI_();
            return;
          } 
          AppMethods.a(HotCommentsPresenter.c(this.a).getResources().getString(2131756083));
          return;
        } 
        if (HotCommentsPresenter.b(this.a) != 1) {
          HotCommentsPresenter.d(this.a);
          HotCommentsPresenter.b(this.a, false);
        } else {
          HotCommentsPresenter.a(this.a).aI_();
        } 
        HotCommentsPresenter.a(this.a).b();
      }
      
      public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
        super.onFailure(param1Throwable, param1Int, param1String);
        AppInfo.n().post(new Runnable(this) {
              public void run() {
                HotCommentsPresenter.a(this.a.a).h();
              }
            });
      }
      
      public void onUIFinish() {
        super.onUIFinish();
        HotCommentsPresenter.a(this.a).d();
      }
    };
  
  public HotCommentsPresenter(Context paramContext, BluedIngSelfFeed paramBluedIngSelfFeed, IHotCommentsContract.IView paramIView, IRequestHost paramIRequestHost) {
    this.b = paramContext;
    this.d = paramBluedIngSelfFeed;
    this.c = paramIRequestHost;
    this.a = paramIView;
    this.l = DialogUtils.a(paramContext);
    this.k = new CommentListAdapter.FeedCommentListner(this, paramContext, paramIView) {
        public void contentClick(FeedComment param1FeedComment) {
          HotCommentsPresenter.a(this.c, false);
          HotCommentsPresenter.a(this.c, param1FeedComment.comment_id);
          String str = this.a.getResources().getString(2131758580);
          HotCommentsPresenter.b(this.c, param1FeedComment.user_name);
          IHotCommentsContract.IView iView = this.b;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(str);
          stringBuilder.append(param1FeedComment.user_name);
          stringBuilder.append(":");
          iView.a(stringBuilder.toString());
        }
      };
  }
  
  private void b(boolean paramBoolean) {
    if (paramBoolean) {
      this.e = 1;
      this.a.b(new ArrayList());
    } 
    if (this.e == 1)
      this.f = true; 
    if (!this.f) {
      int i = this.e;
      if (i != 1) {
        this.e = i - 1;
        AppMethods.a(this.b.getResources().getString(2131756083));
        this.a.d();
        return;
      } 
    } 
    FeedHttpUtils.a(this.b, this.m, this.d.feed_id, this.e, 20, this.c);
  }
  
  public void a(String paramString) {
    this.j = paramString;
  }
  
  public void a(String paramString, boolean paramBoolean) {
    FeedComment feedComment = new FeedComment();
    if (!this.g) {
      feedComment.comment_id = this.j;
      feedComment.is_ads = this.d.is_ads;
      feedComment.aid = this.d.aid;
    } 
    BluedUIHttpResponse<BluedEntityA<FeedComment>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<FeedComment>>(this, this.c) {
        public void a(BluedEntityA<FeedComment> param1BluedEntityA) {
          if (param1BluedEntityA != null)
            try {
              if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
                FeedComment feedComment = param1BluedEntityA.data.get(0);
                CommentListDataObserver.a().a(feedComment, "");
                LiveEventBus.get("feed_add_comment").post(feedComment);
                HotCommentsPresenter.a(this.a, true);
                HotCommentsPresenter.a(this.a).e();
                AppMethods.d(2131758692);
                return;
              } 
            } catch (Exception exception) {
              AppMethods.d(2131756082);
            }  
        }
        
        public void onUIFinish() {
          DialogUtils.b(HotCommentsPresenter.e(this.a));
        }
        
        public void onUIStart() {
          DialogUtils.a(HotCommentsPresenter.e(this.a));
        }
      };
    if (e()) {
      FeedHttpUtils.a(bluedUIHttpResponse, this.d, feedComment, paramString, this.c);
      return;
    } 
    CircleHttpUtils.a(bluedUIHttpResponse, this.d, feedComment, paramString, paramBoolean, -1, this.c);
  }
  
  public void a(boolean paramBoolean) {
    this.h = paramBoolean;
  }
  
  public void b() {
    b(true);
  }
  
  public void b(String paramString) {
    this.i = paramString;
  }
  
  public void bb_() {}
  
  public void c() {
    this.e++;
    b(false);
  }
  
  public CommentListAdapter.FeedCommentListner d() {
    return this.k;
  }
  
  public boolean e() {
    return f() ^ true;
  }
  
  public boolean f() {
    BluedIngSelfFeed bluedIngSelfFeed = this.d;
    return (bluedIngSelfFeed != null && CircleMethods.isCircle(bluedIngSelfFeed));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\presenter\HotCommentsPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */