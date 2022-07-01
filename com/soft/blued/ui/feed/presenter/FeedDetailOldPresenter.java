package com.soft.blued.ui.feed.presenter;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.util.Pair;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.utils.DialogUtils;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.http.FeedHttpUtils;
import com.soft.blued.ui.feed.contract.IFeedDetailContract;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.feed.model.BluedRepostEntityExtra;
import com.soft.blued.ui.feed.model.FeedComment;
import com.soft.blued.ui.feed.model.FeedParse;
import com.soft.blued.ui.feed.model.FeedRepost;
import com.soft.blued.ui.feed.observer.CommentListDataObserver;
import com.soft.blued.ui.feed.observer.IFeedDataObserver;
import com.soft.blued.ui.find.model.BluedRecommendUsers;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class FeedDetailOldPresenter implements IFeedDetailContract.IPresenter, IFeedDataObserver {
  private BluedIngSelfFeed a;
  
  private IFeedDetailContract.IView b;
  
  private Context c;
  
  private IRequestHost d;
  
  private Dialog e;
  
  private int f = 1;
  
  private int g = 1;
  
  private int h = 1;
  
  private DataStatus i;
  
  private int j = -1;
  
  private boolean k = true;
  
  private boolean l = false;
  
  private boolean m;
  
  private int n = 1;
  
  public FeedDetailOldPresenter(Context paramContext, IFeedDetailContract.IView paramIView, BluedIngSelfFeed paramBluedIngSelfFeed, int paramInt, IRequestHost paramIRequestHost) {
    this.c = paramContext;
    this.b = paramIView;
    this.a = paramBluedIngSelfFeed;
    this.d = paramIRequestHost;
    this.j = paramInt;
    this.i = new DataStatus(this);
    this.e = DialogUtils.a(this.c);
  }
  
  private void h() {
    int i = this.n;
    Context context = this.c;
    BluedUIHttpResponse<BluedEntityA<BluedIngSelfFeed>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<BluedIngSelfFeed>>(this, this.d, i) {
        protected BluedEntityA<BluedIngSelfFeed> a(String param1String) {
          BluedEntityA<BluedIngSelfFeed> bluedEntityA = (BluedEntityA)super.parseData(param1String);
          if (bluedEntityA != null) {
            if (!bluedEntityA.hasData())
              return bluedEntityA; 
            for (BluedIngSelfFeed bluedIngSelfFeed : bluedEntityA.data)
              bluedIngSelfFeed.feedParse = new FeedParse(FeedDetailOldPresenter.b(this.b), bluedIngSelfFeed, 2); 
          } 
          return bluedEntityA;
        }
        
        protected void a(BluedEntityA<BluedIngSelfFeed> param1BluedEntityA) {
          boolean bool = false;
          if (param1BluedEntityA != null) {
            if (param1BluedEntityA.extra != null) {
              FeedDetailOldPresenter.DataStatus dataStatus = FeedDetailOldPresenter.e(this.b);
              if (param1BluedEntityA.extra.hasmore == 1)
                bool = true; 
              dataStatus.g = bool;
            } else {
              (FeedDetailOldPresenter.e(this.b)).g = false;
            } 
            FeedDetailOldPresenter.a(this.b).a(param1BluedEntityA.data, this.a, (FeedDetailOldPresenter.e(this.b)).g);
            return;
          } 
          FeedDetailOldPresenter.a(this.b).a(null, this.a, false);
        }
        
        public void onUIFinish(boolean param1Boolean) {
          if (!param1Boolean)
            FeedDetailOldPresenter.a(this.b).a(null, this.a, false); 
        }
      };
    String str = this.a.feed_id;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.n);
    stringBuilder.append("");
    FeedHttpUtils.a(context, bluedUIHttpResponse, str, stringBuilder.toString(), "20", this.d);
  }
  
  private void i() {
    String str1;
    BluedUIHttpResponse<BluedEntityA<BluedIngSelfFeed>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<BluedIngSelfFeed>>(this) {
        private int b;
        
        private String c;
        
        private boolean d;
        
        public void a(BluedEntityA<BluedIngSelfFeed> param1BluedEntityA) {
          boolean bool = false;
          if (param1BluedEntityA != null && param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
            BluedIngSelfFeed bluedIngSelfFeed = param1BluedEntityA.data.get(0);
            if (bluedIngSelfFeed != null && !StringUtils.e(bluedIngSelfFeed.feed_id)) {
              FeedDetailOldPresenter.a(this.a, bluedIngSelfFeed);
              FeedDetailOldPresenter.a(this.a).c(FeedDetailOldPresenter.d(this.a));
            } 
            if (FeedDetailOldPresenter.f(this.a) == 1) {
              if ((bluedIngSelfFeed.hot_comments == null || bluedIngSelfFeed.hot_comments.size() == 0) && (bluedIngSelfFeed.comments == null || bluedIngSelfFeed.comments.size() == 0)) {
                (FeedDetailOldPresenter.e(this.a)).e = 0;
              } else if (bluedIngSelfFeed.hot_comments != null && bluedIngSelfFeed.hot_comments.size() > 0) {
                ((FeedComment)bluedIngSelfFeed.hot_comments.get(bluedIngSelfFeed.hot_comments.size() - 1)).isLastHotComment = true;
                if (bluedIngSelfFeed.hot_comments_more == 1)
                  ((FeedComment)bluedIngSelfFeed.hot_comments.get(bluedIngSelfFeed.hot_comments.size() - 1)).isHasMoreHotComment = true; 
                FeedDetailOldPresenter.a(this.a).e(bluedIngSelfFeed.hot_comments);
                FeedDetailOldPresenter.a(this.a).f(bluedIngSelfFeed.comments);
              } else {
                FeedDetailOldPresenter.a(this.a).e(bluedIngSelfFeed.comments);
              } 
              this.a.b();
            } else if (bluedIngSelfFeed.comments != null && bluedIngSelfFeed.comments.size() > 0) {
              FeedDetailOldPresenter.a(this.a).f(bluedIngSelfFeed.comments);
            } else {
              (FeedDetailOldPresenter.e(this.a)).e = 0;
            } 
            if (param1BluedEntityA.extra != null) {
              FeedDetailOldPresenter.DataStatus dataStatus = FeedDetailOldPresenter.e(this.a);
              if (param1BluedEntityA.extra.hasmore == 1)
                bool = true; 
              dataStatus.b = bool;
            } else {
              (FeedDetailOldPresenter.e(this.a)).b = false;
            } 
          } else {
            (FeedDetailOldPresenter.e(this.a)).e = 0;
          } 
          FeedDetailOldPresenter.a(this.a).b(1);
        }
        
        public boolean onUIFailure(int param1Int, String param1String) {
          this.b = param1Int;
          this.c = param1String;
          (FeedDetailOldPresenter.e(this.a)).e = 2;
          this.d = true;
          return (FeedDetailOldPresenter.c(this.a) && param1Int == 404100) ? true : super.onUIFailure(param1Int, param1String);
        }
        
        public void onUIFinish() {
          // Byte code:
          //   0: aload_0
          //   1: getfield a : Lcom/soft/blued/ui/feed/presenter/FeedDetailOldPresenter;
          //   4: invokestatic a : (Lcom/soft/blued/ui/feed/presenter/FeedDetailOldPresenter;)Lcom/soft/blued/ui/feed/contract/IFeedDetailContract$IView;
          //   7: invokeinterface g : ()V
          //   12: aload_0
          //   13: getfield a : Lcom/soft/blued/ui/feed/presenter/FeedDetailOldPresenter;
          //   16: invokestatic a : (Lcom/soft/blued/ui/feed/presenter/FeedDetailOldPresenter;)Lcom/soft/blued/ui/feed/contract/IFeedDetailContract$IView;
          //   19: invokeinterface a : ()V
          //   24: aload_0
          //   25: getfield a : Lcom/soft/blued/ui/feed/presenter/FeedDetailOldPresenter;
          //   28: invokestatic g : (Lcom/soft/blued/ui/feed/presenter/FeedDetailOldPresenter;)Z
          //   31: ifeq -> 65
          //   34: aload_0
          //   35: getfield a : Lcom/soft/blued/ui/feed/presenter/FeedDetailOldPresenter;
          //   38: iconst_0
          //   39: invokestatic a : (Lcom/soft/blued/ui/feed/presenter/FeedDetailOldPresenter;Z)Z
          //   42: pop
          //   43: aload_0
          //   44: getfield a : Lcom/soft/blued/ui/feed/presenter/FeedDetailOldPresenter;
          //   47: invokestatic h : (Lcom/soft/blued/ui/feed/presenter/FeedDetailOldPresenter;)Z
          //   50: ifeq -> 65
          //   53: aload_0
          //   54: getfield a : Lcom/soft/blued/ui/feed/presenter/FeedDetailOldPresenter;
          //   57: invokestatic a : (Lcom/soft/blued/ui/feed/presenter/FeedDetailOldPresenter;)Lcom/soft/blued/ui/feed/contract/IFeedDetailContract$IView;
          //   60: invokeinterface i : ()V
          //   65: aload_0
          //   66: getfield a : Lcom/soft/blued/ui/feed/presenter/FeedDetailOldPresenter;
          //   69: invokestatic c : (Lcom/soft/blued/ui/feed/presenter/FeedDetailOldPresenter;)Z
          //   72: ifeq -> 102
          //   75: aload_0
          //   76: getfield b : I
          //   79: ldc 404100
          //   81: if_icmpne -> 102
          //   84: ldc 2131758773
          //   86: invokestatic d : (I)V
          //   89: aload_0
          //   90: getfield a : Lcom/soft/blued/ui/feed/presenter/FeedDetailOldPresenter;
          //   93: invokestatic a : (Lcom/soft/blued/ui/feed/presenter/FeedDetailOldPresenter;)Lcom/soft/blued/ui/feed/contract/IFeedDetailContract$IView;
          //   96: invokeinterface h : ()V
          //   101: return
          //   102: aload_0
          //   103: getfield a : Lcom/soft/blued/ui/feed/presenter/FeedDetailOldPresenter;
          //   106: invokestatic f : (Lcom/soft/blued/ui/feed/presenter/FeedDetailOldPresenter;)I
          //   109: iconst_1
          //   110: if_icmpne -> 145
          //   113: aload_0
          //   114: getfield b : I
          //   117: istore_1
          //   118: iload_1
          //   119: ldc 404100
          //   121: if_icmpeq -> 130
          //   124: iload_1
          //   125: ldc 4031216
          //   127: if_icmpne -> 145
          //   130: aload_0
          //   131: getfield a : Lcom/soft/blued/ui/feed/presenter/FeedDetailOldPresenter;
          //   134: invokestatic a : (Lcom/soft/blued/ui/feed/presenter/FeedDetailOldPresenter;)Lcom/soft/blued/ui/feed/contract/IFeedDetailContract$IView;
          //   137: invokeinterface h : ()V
          //   142: goto -> 199
          //   145: aload_0
          //   146: getfield d : Z
          //   149: ifeq -> 199
          //   152: aload_0
          //   153: getfield a : Lcom/soft/blued/ui/feed/presenter/FeedDetailOldPresenter;
          //   156: invokestatic a : (Lcom/soft/blued/ui/feed/presenter/FeedDetailOldPresenter;)Lcom/soft/blued/ui/feed/contract/IFeedDetailContract$IView;
          //   159: invokeinterface bg_ : ()V
          //   164: aload_0
          //   165: getfield a : Lcom/soft/blued/ui/feed/presenter/FeedDetailOldPresenter;
          //   168: invokestatic e : (Lcom/soft/blued/ui/feed/presenter/FeedDetailOldPresenter;)Lcom/soft/blued/ui/feed/presenter/FeedDetailOldPresenter$DataStatus;
          //   171: iconst_0
          //   172: putfield b : Z
          //   175: aload_0
          //   176: getfield a : Lcom/soft/blued/ui/feed/presenter/FeedDetailOldPresenter;
          //   179: invokestatic f : (Lcom/soft/blued/ui/feed/presenter/FeedDetailOldPresenter;)I
          //   182: iconst_1
          //   183: if_icmpne -> 199
          //   186: aload_0
          //   187: getfield a : Lcom/soft/blued/ui/feed/presenter/FeedDetailOldPresenter;
          //   190: invokestatic a : (Lcom/soft/blued/ui/feed/presenter/FeedDetailOldPresenter;)Lcom/soft/blued/ui/feed/contract/IFeedDetailContract$IView;
          //   193: iconst_1
          //   194: invokeinterface b : (I)V
          //   199: aload_0
          //   200: iconst_0
          //   201: putfield d : Z
          //   204: return
        }
      };
    String str2 = this.a.feed_id;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.g);
    stringBuilder.append("");
    String str3 = stringBuilder.toString();
    if (this.m) {
      str1 = "100";
    } else {
      str1 = "40";
    } 
    FeedHttpUtils.a(bluedUIHttpResponse, str2, str3, str1, "", this.a.is_ads, this.d);
  }
  
  private void j() {
    int i = this.h;
    Context context = this.c;
    BluedUIHttpResponse<BluedEntity<FeedRepost, BluedRepostEntityExtra>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntity<FeedRepost, BluedRepostEntityExtra>>(this, i) {
        public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
          super.onFailure(param1Throwable, param1Int, param1String);
          (FeedDetailOldPresenter.e(this.b)).f = 2;
          (FeedDetailOldPresenter.e(this.b)).c = false;
          AppInfo.n().post(new Runnable(this) {
                public void run() {
                  if (this.a.a == 1) {
                    FeedDetailOldPresenter.a(this.a.b).g(new ArrayList());
                    FeedDetailOldPresenter.a(this.a.b).b(2);
                    return;
                  } 
                  FeedDetailOldPresenter.a(this.a.b).bg_();
                }
              });
        }
        
        public void onUIFinish() {
          FeedDetailOldPresenter.a(this.b).g();
          FeedDetailOldPresenter.a(this.b).a();
        }
        
        public void onUIUpdate(BluedEntity<FeedRepost, BluedRepostEntityExtra> param1BluedEntity) {
          if (param1BluedEntity != null) {
            List list = param1BluedEntity.data;
            boolean bool = false;
            if (list != null && param1BluedEntity.data.size() > 0) {
              if (this.a == 1) {
                FeedDetailOldPresenter.a(this.b).g(param1BluedEntity.data);
              } else {
                FeedDetailOldPresenter.a(this.b).h(param1BluedEntity.data);
              } 
            } else if (this.a == 1) {
              (FeedDetailOldPresenter.e(this.b)).f = 0;
              FeedDetailOldPresenter.a(this.b).g(new ArrayList());
            } 
            if (param1BluedEntity.extra != null) {
              FeedDetailOldPresenter.DataStatus dataStatus = FeedDetailOldPresenter.e(this.b);
              if (((BluedRepostEntityExtra)param1BluedEntity.extra).hasmore == 1)
                bool = true; 
              dataStatus.c = bool;
            } 
          } 
          FeedDetailOldPresenter.a(this.b).b(2);
        }
      };
    String str = this.a.feed_id;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.h);
    stringBuilder.append("");
    FeedHttpUtils.a(context, bluedUIHttpResponse, str, stringBuilder.toString(), "20", this.a.is_ads, this.d);
  }
  
  public void a(int paramInt) {
    if (TextUtils.equals(this.a.feed_uid, (UserInfo.a().i()).uid))
      this.a.theme_id = paramInt; 
    this.b.c(this.a);
  }
  
  public void a(BluedIngSelfFeed paramBluedIngSelfFeed) {}
  
  public void a(FeedComment paramFeedComment) {
    if (!this.a.feed_id.equals(paramFeedComment.feed_id))
      return; 
    BluedIngSelfFeed bluedIngSelfFeed = this.a;
    bluedIngSelfFeed.feed_comment++;
    this.i.e = 1;
    this.b.b(1);
    this.b.c(this.a);
  }
  
  public void a(FeedRepost paramFeedRepost) {
    if (!this.a.feed_id.equals(paramFeedRepost.feed_id))
      return; 
    BluedIngSelfFeed bluedIngSelfFeed = this.a;
    bluedIngSelfFeed.repost_count++;
    if (this.i.f != 1) {
      DataStatus dataStatus = this.i;
      dataStatus.c = false;
      dataStatus.f = 1;
    } 
    this.b.b(2);
    this.b.c(this.a);
  }
  
  public void a(String paramString, int paramInt) {
    BluedIngSelfFeed bluedIngSelfFeed = this.a;
    bluedIngSelfFeed.allow_comments = paramInt;
    this.b.c(bluedIngSelfFeed);
  }
  
  public void a(String paramString1, String paramString2) {
    if (!this.a.feed_id.equals(paramString1))
      return; 
    BluedIngSelfFeed bluedIngSelfFeed = this.a;
    bluedIngSelfFeed.feed_comment--;
    if (this.a.feed_comment < 0)
      this.a.feed_comment = 0; 
    if (this.a.feed_comment == 0) {
      this.i.e = 0;
    } else {
      this.i.e = 1;
    } 
    this.b.b(1);
    this.b.c(this.a);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
    FeedComment feedComment = new FeedComment();
    if (!paramBoolean) {
      feedComment.comment_id = paramString3;
      feedComment.is_ads = this.a.is_ads;
      feedComment.aid = this.a.aid;
    } 
    FeedHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<FeedComment>>(this, this.d, paramString3) {
          public void a(BluedEntityA<FeedComment> param1BluedEntityA) {
            if (param1BluedEntityA != null)
              try {
                if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
                  FeedComment feedComment = param1BluedEntityA.data.get(0);
                  CommentListDataObserver.a().a(feedComment, this.a);
                  LiveEventBus.get("feed_add_comment").post(feedComment);
                  (this.b.f()).e = 1;
                  FeedDetailOldPresenter.a(this.b).c(1);
                  FeedDetailOldPresenter.a(this.b).e();
                  AppMethods.a(FeedDetailOldPresenter.b(this.b).getString(2131758692));
                  return;
                } 
              } catch (Exception exception) {
                AppMethods.a(FeedDetailOldPresenter.b(this.b).getResources().getString(2131756082));
              }  
          }
          
          public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
            if (FeedDetailOldPresenter.c(this.b)) {
              Pair pair = BluedHttpUtils.a(param1Throwable, param1Int, param1String);
              if (pair != null && ((Integer)pair.first).intValue() == 404100) {
                AppMethods.d(2131758773);
                return;
              } 
              super.onFailure(param1Throwable, param1Int, param1String);
              return;
            } 
            super.onFailure(param1Throwable, param1Int, param1String);
          }
          
          public void onUIFinish() {
            FeedDetailOldPresenter.a(this.b).d();
          }
          
          public void onUIStart() {
            FeedDetailOldPresenter.a(this.b).b();
          }
        }g(), feedComment, paramString1, this.d);
  }
  
  public void a(boolean paramBoolean) {
    this.l = paramBoolean;
  }
  
  public void b() {
    this.n = 1;
    this.i.g = true;
    h();
  }
  
  public void b(int paramInt) {
    if (TextUtils.equals(this.a.feed_uid, (UserInfo.a().i()).uid))
      this.a.theme_pendant = paramInt; 
    this.b.c(this.a);
  }
  
  public void b(BluedIngSelfFeed paramBluedIngSelfFeed) {
    this.m = true;
    this.a = paramBluedIngSelfFeed;
  }
  
  public void b(String paramString, int paramInt) {
    BluedIngSelfFeed bluedIngSelfFeed = this.a;
    bluedIngSelfFeed.reading_scope = paramInt;
    this.b.c(bluedIngSelfFeed);
  }
  
  public void b(String paramString1, String paramString2) {}
  
  public void bb_() {}
  
  public void c() {
    this.g = 1;
    i();
  }
  
  public void c(String paramString, int paramInt) {
    if (!this.a.feed_id.equals(paramString))
      return; 
    if (paramInt == 1) {
      BluedIngSelfFeed bluedIngSelfFeed1 = this.a;
      bluedIngSelfFeed1.feed_dig++;
    } else {
      BluedIngSelfFeed bluedIngSelfFeed1 = this.a;
      bluedIngSelfFeed1.feed_dig--;
      if (this.a.feed_dig < 0)
        this.a.feed_dig = 0; 
    } 
    BluedIngSelfFeed bluedIngSelfFeed = this.a;
    bluedIngSelfFeed.iliked = paramInt;
    if (bluedIngSelfFeed.feed_dig == 0) {
      this.i.d = 0;
    } else {
      this.i.d = 1;
    } 
    this.b.b(0);
    this.b.c(this.a);
    this.a.isPlayLikeAnim = false;
  }
  
  public void d() {
    if (this.i.b) {
      this.g++;
      i();
    } 
  }
  
  public void d(String paramString) {
    if (!this.a.feed_id.equals(paramString))
      return; 
    if (paramString.equals(this.a.feed_id))
      this.b.h(); 
  }
  
  public void e() {
    this.h = 1;
    j();
  }
  
  public void e(String paramString) {
    if (!this.a.feed_id.equals(paramString))
      return; 
    if (!StringUtils.e(paramString) && paramString.equals(this.a.feed_id)) {
      int i;
      BluedIngSelfFeed bluedIngSelfFeed = this.a;
      bluedIngSelfFeed.repost_count--;
      bluedIngSelfFeed = this.a;
      if (bluedIngSelfFeed.repost_count < 0) {
        i = 0;
      } else {
        i = this.a.repost_count;
      } 
      bluedIngSelfFeed.repost_count = i;
      this.b.c(this.a);
      e();
    } 
  }
  
  public DataStatus f() {
    return this.i;
  }
  
  public BluedIngSelfFeed g() {
    return this.a;
  }
  
  public static interface DATA_STATUS {}
  
  public class DataStatus {
    public boolean a = true;
    
    public boolean b = true;
    
    public boolean c = true;
    
    public int d = 1;
    
    public int e = 1;
    
    public int f = 1;
    
    public boolean g = true;
    
    public DataStatus(FeedDetailOldPresenter this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\presenter\FeedDetailOldPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */