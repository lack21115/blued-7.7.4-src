package com.soft.blued.ui.feed.adapter;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.os.Build;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.RegExpUtils;
import com.blued.das.client.feed.FeedProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.customview.ActionSheet;
import com.soft.blued.http.CircleHttpUtils;
import com.soft.blued.http.FeedHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.circle.model.CircleAddPoints;
import com.soft.blued.ui.circle.model.CircleMethods;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.feed.model.FeedComment;
import com.soft.blued.ui.feed.observer.CommentListDataObserver;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.photo.fragment.BasePhotoFragment;
import com.soft.blued.ui.user.fragment.ReportFragmentNew;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.PopMenuUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import com.soft.blued.view.tip.CommonShowBottomWindow;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CommentListAdapter extends BaseAdapter implements CommentListDataObserver.ICommentDataObserver {
  LoadOptions a;
  
  private Context b;
  
  private LayoutInflater c;
  
  private List<FeedComment> d = new ArrayList<FeedComment>();
  
  private int e;
  
  private IRequestHost f;
  
  private BluedIngSelfFeed g;
  
  private FeedCommentListner h;
  
  private boolean i = true;
  
  private String j;
  
  private String k;
  
  private int l = 1;
  
  private int m = -1;
  
  public CommentListAdapter(Context paramContext, IRequestHost paramIRequestHost, BluedIngSelfFeed paramBluedIngSelfFeed, FeedCommentListner paramFeedCommentListner, String paramString1, String paramString2) {
    this(paramContext, paramIRequestHost, paramBluedIngSelfFeed, paramFeedCommentListner, true, paramString1, paramString2);
  }
  
  public CommentListAdapter(Context paramContext, IRequestHost paramIRequestHost, BluedIngSelfFeed paramBluedIngSelfFeed, FeedCommentListner paramFeedCommentListner, boolean paramBoolean, String paramString1, String paramString2) {
    this.b = paramContext;
    this.h = paramFeedCommentListner;
    this.g = paramBluedIngSelfFeed;
    this.f = paramIRequestHost;
    this.i = paramBoolean;
    this.k = paramString2;
    this.a = new LoadOptions();
    LoadOptions loadOptions = this.a;
    loadOptions.d = 2131234356;
    loadOptions.b = 2131234356;
    this.e = (paramContext.getResources().getDisplayMetrics()).widthPixels;
    loadOptions = this.a;
    int i = this.e;
    loadOptions.a(i >> 1, i >> 1);
    this.c = LayoutInflater.from(paramContext);
    this.j = paramString1;
  }
  
  private void a(View paramView, FeedComment paramFeedComment) {
    if (paramFeedComment != null)
      paramView.setOnLongClickListener(new View.OnLongClickListener(this, paramView, paramFeedComment) {
            public boolean onLongClick(View param1View) {
              ArrayList<String> arrayList = new ArrayList();
              KeyboardUtils.b(CommentListAdapter.a(this.c), this.a);
              arrayList.add(CommentListAdapter.a(this.c).getResources().getString(2131758501));
              if (this.b.user_allow_mute == CommentListAdapter.d(this.c)) {
                int i;
                Resources resources = CommentListAdapter.a(this.c).getResources();
                if (this.b.is_muted == 1) {
                  i = 2131755861;
                } else {
                  i = 2131755862;
                } 
                arrayList.add(resources.getString(i));
              } 
              if (!CircleMethods.isAnonymousMineUid(this.b.comment_uid))
                arrayList.add(CommentListAdapter.a(this.c).getResources().getString(2131758584)); 
              if ("1".equals(this.b.comment_allow_delete))
                arrayList.add(CommentListAdapter.a(this.c).getResources().getString(2131756176)); 
              CommonShowBottomWindow.a((FragmentActivity)CommentListAdapter.a(this.c), arrayList.<String>toArray(new String[arrayList.size()]), new ActionSheet.ActionSheetListener(this) {
                    public void a(ActionSheet param2ActionSheet, int param2Int) {
                      String str = param2ActionSheet.a(param2Int);
                      if (str.equals(CommentListAdapter.a(this.a.c).getResources().getString(2131758501))) {
                        this.a.c.a(this.a.b);
                        return;
                      } 
                      if (str.equals(CommentListAdapter.a(this.a.c).getResources().getString(2131756176))) {
                        this.a.c.b(this.a.b);
                        return;
                      } 
                      if (str.equals(CommentListAdapter.a(this.a.c).getResources().getString(2131758584))) {
                        if (CommentListAdapter.e(this.a.c)) {
                          ReportFragmentNew.a(CommentListAdapter.a(this.a.c), this.a.b.comment_id, this.a.b.feed_id, this.a.b.user_name);
                          return;
                        } 
                        ReportFragmentNew.b(CommentListAdapter.a(this.a.c), this.a.b.comment_id, this.a.b.feed_id, this.a.b.user_name);
                        return;
                      } 
                      Resources resources = CommentListAdapter.a(this.a.c).getResources();
                      if (this.a.b.is_muted == CommentListAdapter.d(this.a.c)) {
                        param2Int = 2131755861;
                      } else {
                        param2Int = 2131755862;
                      } 
                      if (str.equals(resources.getString(param2Int)))
                        this.a.c.a(this.a.b, CommentListAdapter.f(this.a.c)); 
                    }
                    
                    public void a(ActionSheet param2ActionSheet, boolean param2Boolean) {}
                  });
              return true;
            }
          }); 
  }
  
  private void a(FeedComment paramFeedComment, ImageView paramImageView, TextView paramTextView) {
    boolean bool;
    if (a()) {
      FeedProtos.InteractiveType interactiveType;
      FeedProtos.Event event = FeedProtos.Event.FEED_INTERACTIVE;
      String str = paramFeedComment.feed_id;
      if (paramFeedComment.iliked == 1) {
        interactiveType = FeedProtos.InteractiveType.NO_LIKE;
      } else {
        interactiveType = FeedProtos.InteractiveType.LIKE;
      } 
      EventTrackFeed.a(event, str, interactiveType, FeedProtos.Location.COMMENT_DETAIL, paramFeedComment.comment_id, paramFeedComment.feed_uid);
    } else {
      FeedProtos.InteractiveType interactiveType;
      FeedProtos.Event event = FeedProtos.Event.FEED_INTERACTIVE;
      String str = paramFeedComment.feed_id;
      if (paramFeedComment.iliked == 1) {
        interactiveType = FeedProtos.InteractiveType.NO_LIKE;
      } else {
        interactiveType = FeedProtos.InteractiveType.LIKE;
      } 
      EventTrackFeed.a(event, str, interactiveType, FeedProtos.Location.FEED_DETAIL, paramFeedComment.comment_id, paramFeedComment.feed_uid);
    } 
    String str1 = paramFeedComment.comment_id;
    String str2 = paramFeedComment.feed_id;
    if (paramFeedComment.iliked == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    if (!a()) {
      CommentListDataObserver.a().a(str1, bool);
    } else {
      a(str1, bool);
    } 
    FeedHttpUtils.a(str2, str1, bool, new BluedUIHttpResponse<BluedEntityA<CircleAddPoints>>(this, this.f) {
          protected void a(BluedEntityA<CircleAddPoints> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.hasData() && ((CircleAddPoints)param1BluedEntityA.getSingleData()).circle_active_liked_posting > 0) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("点赞成功，基分+");
              stringBuilder.append(((CircleAddPoints)param1BluedEntityA.getSingleData()).circle_active_liked_posting);
              AppMethods.a(stringBuilder.toString());
            } 
          }
        }this.f, true);
  }
  
  private boolean a() {
    return this.j.equals("feed_comment_floor");
  }
  
  private boolean b() {
    return TextUtils.isEmpty(this.k);
  }
  
  public void a(int paramInt) {
    this.m = paramInt;
  }
  
  public void a(FeedComment paramFeedComment) {
    String str = paramFeedComment.comment_content;
    if (Build.VERSION.SDK_INT >= 11 && Build.VERSION.SDK_INT != 18) {
      ((ClipboardManager)this.b.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("simple text", RegExpUtils.a(str)));
    } else {
      ((ClipboardManager)this.b.getSystemService("clipboard")).setText(RegExpUtils.a(str));
    } 
    AppMethods.a(this.b.getResources().getString(2131756130));
  }
  
  public void a(FeedComment paramFeedComment, IRequestHost paramIRequestHost) {
    if (paramFeedComment.is_muted == 1) {
      CircleHttpUtils.a(paramFeedComment.circle_id, new BluedUIHttpResponse(this, paramIRequestHost, paramFeedComment) {
            public void onUIUpdate(BluedEntity param1BluedEntity) {
              this.a.is_muted = 0;
              this.b.notifyDataSetChanged();
              AppMethods.a(AppUtils.a(2131755863));
            }
          }paramFeedComment.comment_uid, paramFeedComment.is_anonym, paramIRequestHost);
      return;
    } 
    CircleHttpUtils.a(paramFeedComment.circle_id, new BluedUIHttpResponse(this, paramIRequestHost, paramFeedComment) {
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            this.a.is_muted = 1;
            this.b.notifyDataSetChanged();
            AppMethods.a(AppUtils.a(2131755863));
          }
        }paramFeedComment.comment_uid, paramFeedComment.is_anonym, paramFeedComment.user_name, paramFeedComment.user_avatar, paramIRequestHost);
  }
  
  public void a(FeedComment paramFeedComment, String paramString) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 288
    //   4: aload_0
    //   5: getfield i : Z
    //   8: ifeq -> 288
    //   11: aload_1
    //   12: aload_1
    //   13: getfield user_vbadge : I
    //   16: putfield vbadge : I
    //   19: aload_0
    //   20: invokespecial a : ()Z
    //   23: ifeq -> 107
    //   26: iconst_0
    //   27: istore_3
    //   28: iload_3
    //   29: aload_0
    //   30: getfield d : Ljava/util/List;
    //   33: invokeinterface size : ()I
    //   38: if_icmpge -> 70
    //   41: aload_0
    //   42: getfield d : Ljava/util/List;
    //   45: iload_3
    //   46: invokeinterface get : (I)Ljava/lang/Object;
    //   51: checkcast com/soft/blued/ui/feed/model/FeedComment
    //   54: getfield isLastHotComment : Z
    //   57: ifeq -> 63
    //   60: goto -> 72
    //   63: iload_3
    //   64: iconst_1
    //   65: iadd
    //   66: istore_3
    //   67: goto -> 28
    //   70: iconst_m1
    //   71: istore_3
    //   72: iload_3
    //   73: iconst_m1
    //   74: if_icmpne -> 91
    //   77: aload_0
    //   78: getfield d : Ljava/util/List;
    //   81: iconst_0
    //   82: aload_1
    //   83: invokeinterface add : (ILjava/lang/Object;)V
    //   88: goto -> 284
    //   91: aload_0
    //   92: getfield d : Ljava/util/List;
    //   95: iload_3
    //   96: iconst_1
    //   97: iadd
    //   98: aload_1
    //   99: invokeinterface add : (ILjava/lang/Object;)V
    //   104: goto -> 284
    //   107: aload_2
    //   108: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   111: ifne -> 206
    //   114: aload_0
    //   115: getfield d : Ljava/util/List;
    //   118: invokeinterface iterator : ()Ljava/util/Iterator;
    //   123: astore #4
    //   125: aload #4
    //   127: invokeinterface hasNext : ()Z
    //   132: ifeq -> 284
    //   135: aload #4
    //   137: invokeinterface next : ()Ljava/lang/Object;
    //   142: checkcast com/soft/blued/ui/feed/model/FeedComment
    //   145: astore #5
    //   147: aload_2
    //   148: aload #5
    //   150: getfield comment_id : Ljava/lang/String;
    //   153: invokevirtual equals : (Ljava/lang/Object;)Z
    //   156: ifeq -> 125
    //   159: aload #5
    //   161: getfield comments : Ljava/util/List;
    //   164: ifnonnull -> 179
    //   167: aload #5
    //   169: new java/util/ArrayList
    //   172: dup
    //   173: invokespecial <init> : ()V
    //   176: putfield comments : Ljava/util/List;
    //   179: aload #5
    //   181: aload #5
    //   183: getfield comments_count : I
    //   186: iconst_1
    //   187: iadd
    //   188: putfield comments_count : I
    //   191: aload #5
    //   193: getfield comments : Ljava/util/List;
    //   196: iconst_0
    //   197: aload_1
    //   198: invokeinterface add : (ILjava/lang/Object;)V
    //   203: goto -> 284
    //   206: iconst_0
    //   207: istore_3
    //   208: iload_3
    //   209: aload_0
    //   210: getfield d : Ljava/util/List;
    //   213: invokeinterface size : ()I
    //   218: if_icmpge -> 250
    //   221: aload_0
    //   222: getfield d : Ljava/util/List;
    //   225: iload_3
    //   226: invokeinterface get : (I)Ljava/lang/Object;
    //   231: checkcast com/soft/blued/ui/feed/model/FeedComment
    //   234: getfield isLastHotComment : Z
    //   237: ifeq -> 243
    //   240: goto -> 252
    //   243: iload_3
    //   244: iconst_1
    //   245: iadd
    //   246: istore_3
    //   247: goto -> 208
    //   250: iconst_m1
    //   251: istore_3
    //   252: iload_3
    //   253: iconst_m1
    //   254: if_icmpne -> 271
    //   257: aload_0
    //   258: getfield d : Ljava/util/List;
    //   261: iconst_0
    //   262: aload_1
    //   263: invokeinterface add : (ILjava/lang/Object;)V
    //   268: goto -> 284
    //   271: aload_0
    //   272: getfield d : Ljava/util/List;
    //   275: iload_3
    //   276: iconst_1
    //   277: iadd
    //   278: aload_1
    //   279: invokeinterface add : (ILjava/lang/Object;)V
    //   284: aload_0
    //   285: invokevirtual notifyDataSetChanged : ()V
    //   288: aload_1
    //   289: ifnull -> 311
    //   292: aload_0
    //   293: getfield i : Z
    //   296: ifeq -> 311
    //   299: aload_1
    //   300: aload_1
    //   301: getfield user_vbadge : I
    //   304: putfield vbadge : I
    //   307: aload_0
    //   308: invokevirtual notifyDataSetChanged : ()V
    //   311: return
  }
  
  public void a(String paramString) {
    if (!StringUtils.e(paramString)) {
      List<FeedComment> list = this.d;
      if (list != null && list.size() > 0) {
        for (int i = 0; i < this.d.size(); i++) {
          if (paramString.equals(((FeedComment)this.d.get(i)).comment_id) && ((FeedComment)this.d.get(i)).isLastHotComment) {
            int j = i - 1;
            if (j >= 0) {
              ((FeedComment)this.d.get(j)).isLastHotComment = ((FeedComment)this.d.get(i)).isLastHotComment;
              ((FeedComment)this.d.get(j)).isHasMoreHotComment = ((FeedComment)this.d.get(i)).isHasMoreHotComment;
              break;
            } 
          } 
        } 
        Iterator<FeedComment> iterator = this.d.iterator();
        while (iterator.hasNext()) {
          if (paramString.equals(((FeedComment)iterator.next()).comment_id))
            iterator.remove(); 
        } 
        notifyDataSetChanged();
      } 
    } 
  }
  
  public void a(String paramString, int paramInt) {
    if (!StringUtils.e(paramString)) {
      List<FeedComment> list = this.d;
      if (list != null && list.size() > 0) {
        for (int i = 0; i < this.d.size(); i++) {
          if (paramString.equals(((FeedComment)this.d.get(i)).comment_id)) {
            ((FeedComment)this.d.get(i)).iliked = paramInt;
            if (paramInt == 1) {
              FeedComment feedComment = this.d.get(i);
              feedComment.liked_count++;
            } else {
              FeedComment feedComment = this.d.get(i);
              feedComment.liked_count--;
            } 
          } 
        } 
        notifyDataSetChanged();
      } 
    } 
  }
  
  public void a(List<FeedComment> paramList) {
    this.d.clear();
    if (paramList != null && paramList.size() > 0)
      this.d.addAll(paramList); 
    notifyDataSetChanged();
  }
  
  public void b(FeedComment paramFeedComment) {
    StringBuilder stringBuilder;
    String str = this.b.getString(2131756931);
    CharSequence charSequence = StringUtils.a(paramFeedComment.comment_content, false, true, false, "feed_detail");
    if (charSequence.length() > 14) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(charSequence.subSequence(0, 14));
      charSequence = "...";
    } else {
      stringBuilder = new StringBuilder();
      stringBuilder.append(charSequence);
      charSequence = "";
    } 
    stringBuilder.append((String)charSequence);
    charSequence = stringBuilder.toString();
    charSequence = String.format(this.b.getResources().getString(2131756179), new Object[] { charSequence });
    Context context = this.b;
    CommonAlertDialog.a(context, str, (String)charSequence, context.getResources().getString(2131756176), new DialogInterface.OnClickListener(this, paramFeedComment) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            String str1 = this.a.feed_id;
            String str2 = this.a.comment_id;
            FeedHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>(this) {
                  protected BluedEntityA<Object> a(String param2String) {
                    return (BluedEntityA<Object>)super.parseData(param2String);
                  }
                  
                  public void a(BluedEntityA<Object> param2BluedEntityA) {
                    if (!CommentListAdapter.g(this.a.b)) {
                      CommentListDataObserver.a().a(this.a.a.comment_id);
                      LiveEventBus.get("feed_delete_comment").post(this.a.a);
                    } else {
                      this.a.b.a(this.a.a.comment_id);
                    } 
                    AppMethods.a(AppInfo.d().getResources().getString(2131756175));
                  }
                  
                  public void onFailure(Throwable param2Throwable, int param2Int, String param2String) {
                    AppMethods.a(AppInfo.d().getResources().getString(2131756082));
                    super.onFailure(param2Throwable, param2Int, param2String);
                  }
                }TextUtils.isEmpty(CommentListAdapter.h(this.b)), str1, str2, (CommentListAdapter.c(this.b)).is_ads, CommentListAdapter.f(this.b));
          }
        }this.b.getResources().getString(2131756057), null, null);
  }
  
  public int getCount() {
    List<FeedComment> list = this.d;
    return (list != null) ? list.size() : 0;
  }
  
  public Object getItem(int paramInt) {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    // Byte code:
    //   0: aload_2
    //   1: ifnull -> 34
    //   4: aload_2
    //   5: invokevirtual getTag : ()Ljava/lang/Object;
    //   8: instanceof com/soft/blued/ui/feed/adapter/CommentListAdapter$ViewHolder
    //   11: ifeq -> 26
    //   14: aload_2
    //   15: invokevirtual getTag : ()Ljava/lang/Object;
    //   18: checkcast com/soft/blued/ui/feed/adapter/CommentListAdapter$ViewHolder
    //   21: astore #14
    //   23: goto -> 37
    //   26: aconst_null
    //   27: astore_2
    //   28: aload_2
    //   29: astore #14
    //   31: goto -> 37
    //   34: aconst_null
    //   35: astore #14
    //   37: aload_2
    //   38: ifnonnull -> 263
    //   41: new com/soft/blued/ui/feed/adapter/CommentListAdapter$ViewHolder
    //   44: dup
    //   45: aload_0
    //   46: aconst_null
    //   47: invokespecial <init> : (Lcom/soft/blued/ui/feed/adapter/CommentListAdapter;Lcom/soft/blued/ui/feed/adapter/CommentListAdapter$1;)V
    //   50: astore_2
    //   51: aload_0
    //   52: getfield c : Landroid/view/LayoutInflater;
    //   55: ldc_w 2131493490
    //   58: aload_3
    //   59: iconst_0
    //   60: invokevirtual inflate : (ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   63: astore #14
    //   65: aload_2
    //   66: aload #14
    //   68: ldc_w 2131299696
    //   71: invokevirtual findViewById : (I)Landroid/view/View;
    //   74: putfield a : Landroid/view/View;
    //   77: aload_2
    //   78: aload #14
    //   80: ldc_w 2131297362
    //   83: invokevirtual findViewById : (I)Landroid/view/View;
    //   86: checkcast android/widget/ImageView
    //   89: putfield b : Landroid/widget/ImageView;
    //   92: aload_2
    //   93: aload #14
    //   95: ldc_w 2131296838
    //   98: invokevirtual findViewById : (I)Landroid/view/View;
    //   101: checkcast android/widget/TextView
    //   104: putfield e : Landroid/widget/TextView;
    //   107: aload_2
    //   108: aload #14
    //   110: ldc_w 2131299358
    //   113: invokevirtual findViewById : (I)Landroid/view/View;
    //   116: checkcast android/widget/TextView
    //   119: putfield d : Landroid/widget/TextView;
    //   122: aload_2
    //   123: aload #14
    //   125: ldc_w 2131300267
    //   128: invokevirtual findViewById : (I)Landroid/view/View;
    //   131: checkcast android/widget/TextView
    //   134: putfield c : Landroid/widget/TextView;
    //   137: aload_2
    //   138: aload #14
    //   140: ldc_w 2131297575
    //   143: invokevirtual findViewById : (I)Landroid/view/View;
    //   146: checkcast android/widget/ImageView
    //   149: putfield f : Landroid/widget/ImageView;
    //   152: aload_2
    //   153: aload #14
    //   155: ldc_w 2131297461
    //   158: invokevirtual findViewById : (I)Landroid/view/View;
    //   161: checkcast android/widget/ImageView
    //   164: putfield g : Landroid/widget/ImageView;
    //   167: aload_2
    //   168: aload #14
    //   170: ldc_w 2131300653
    //   173: invokevirtual findViewById : (I)Landroid/view/View;
    //   176: checkcast android/widget/TextView
    //   179: putfield h : Landroid/widget/TextView;
    //   182: aload_2
    //   183: aload #14
    //   185: ldc_w 2131297581
    //   188: invokevirtual findViewById : (I)Landroid/view/View;
    //   191: checkcast android/widget/ImageView
    //   194: putfield i : Landroid/widget/ImageView;
    //   197: aload_2
    //   198: aload #14
    //   200: ldc_w 2131297820
    //   203: invokevirtual findViewById : (I)Landroid/view/View;
    //   206: checkcast android/widget/ImageView
    //   209: putfield j : Landroid/widget/ImageView;
    //   212: aload_2
    //   213: aload #14
    //   215: ldc_w 2131297682
    //   218: invokevirtual findViewById : (I)Landroid/view/View;
    //   221: checkcast android/widget/ImageView
    //   224: putfield k : Landroid/widget/ImageView;
    //   227: aload_2
    //   228: aload #14
    //   230: ldc_w 2131298890
    //   233: invokevirtual findViewById : (I)Landroid/view/View;
    //   236: checkcast android/widget/LinearLayout
    //   239: putfield l : Landroid/widget/LinearLayout;
    //   242: aload_2
    //   243: aload #14
    //   245: ldc_w 2131296797
    //   248: invokevirtual findViewById : (I)Landroid/view/View;
    //   251: putfield m : Landroid/view/View;
    //   254: aload #14
    //   256: aload_2
    //   257: invokevirtual setTag : (Ljava/lang/Object;)V
    //   260: goto -> 271
    //   263: aload #14
    //   265: astore_3
    //   266: aload_2
    //   267: astore #14
    //   269: aload_3
    //   270: astore_2
    //   271: aload_0
    //   272: getfield d : Ljava/util/List;
    //   275: iload_1
    //   276: invokeinterface get : (I)Ljava/lang/Object;
    //   281: checkcast com/soft/blued/ui/feed/model/FeedComment
    //   284: astore #16
    //   286: aload #16
    //   288: getfield iliked : I
    //   291: iconst_1
    //   292: if_icmpne -> 328
    //   295: aload_2
    //   296: getfield g : Landroid/widget/ImageView;
    //   299: ldc_w 2131232450
    //   302: invokevirtual setImageResource : (I)V
    //   305: aload_2
    //   306: getfield h : Landroid/widget/TextView;
    //   309: aload_0
    //   310: getfield b : Landroid/content/Context;
    //   313: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   316: ldc_w 2131100319
    //   319: invokevirtual getColor : (I)I
    //   322: invokevirtual setTextColor : (I)V
    //   325: goto -> 355
    //   328: aload_2
    //   329: getfield g : Landroid/widget/ImageView;
    //   332: ldc_w 2131232449
    //   335: invokevirtual setImageResource : (I)V
    //   338: aload_2
    //   339: getfield h : Landroid/widget/TextView;
    //   342: aload_0
    //   343: getfield b : Landroid/content/Context;
    //   346: ldc_w 2131100842
    //   349: invokestatic a : (Landroid/content/Context;I)I
    //   352: invokevirtual setTextColor : (I)V
    //   355: aload #16
    //   357: getfield liked_count : I
    //   360: ifle -> 428
    //   363: aload_2
    //   364: getfield h : Landroid/widget/TextView;
    //   367: astore_3
    //   368: aload_0
    //   369: getfield b : Landroid/content/Context;
    //   372: astore #15
    //   374: new java/lang/StringBuilder
    //   377: dup
    //   378: invokespecial <init> : ()V
    //   381: astore #17
    //   383: aload #17
    //   385: aload #16
    //   387: getfield liked_count : I
    //   390: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   393: pop
    //   394: aload #17
    //   396: ldc_w ''
    //   399: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: pop
    //   403: aload_3
    //   404: aload #15
    //   406: aload #17
    //   408: invokevirtual toString : ()Ljava/lang/String;
    //   411: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   414: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   417: aload_2
    //   418: getfield h : Landroid/widget/TextView;
    //   421: iconst_0
    //   422: invokevirtual setVisibility : (I)V
    //   425: goto -> 437
    //   428: aload_2
    //   429: getfield h : Landroid/widget/TextView;
    //   432: bipush #8
    //   434: invokevirtual setVisibility : (I)V
    //   437: aload_2
    //   438: getfield g : Landroid/widget/ImageView;
    //   441: astore_3
    //   442: aload_2
    //   443: getfield h : Landroid/widget/TextView;
    //   446: astore #15
    //   448: aload_2
    //   449: getfield g : Landroid/widget/ImageView;
    //   452: new com/soft/blued/ui/feed/adapter/CommentListAdapter$1
    //   455: dup
    //   456: aload_0
    //   457: aload #16
    //   459: aload_3
    //   460: aload #15
    //   462: invokespecial <init> : (Lcom/soft/blued/ui/feed/adapter/CommentListAdapter;Lcom/soft/blued/ui/feed/model/FeedComment;Landroid/widget/ImageView;Landroid/widget/TextView;)V
    //   465: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   468: aload_2
    //   469: getfield h : Landroid/widget/TextView;
    //   472: new com/soft/blued/ui/feed/adapter/CommentListAdapter$2
    //   475: dup
    //   476: aload_0
    //   477: aload #16
    //   479: aload_3
    //   480: aload #15
    //   482: invokespecial <init> : (Lcom/soft/blued/ui/feed/adapter/CommentListAdapter;Lcom/soft/blued/ui/feed/model/FeedComment;Landroid/widget/ImageView;Landroid/widget/TextView;)V
    //   485: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   488: aload_2
    //   489: getfield f : Landroid/widget/ImageView;
    //   492: aload #16
    //   494: getfield vbadge : I
    //   497: iconst_3
    //   498: invokestatic a : (Landroid/widget/ImageView;II)V
    //   501: aload_0
    //   502: getfield f : Lcom/blued/android/core/net/IRequestHost;
    //   505: aload #16
    //   507: getfield user_avatar : Ljava/lang/String;
    //   510: invokestatic a : (Lcom/blued/android/core/net/IRequestHost;Ljava/lang/String;)Lcom/blued/android/core/image/ImageWrapper;
    //   513: ldc 2131234356
    //   515: invokevirtual a : (I)Lcom/blued/android/core/image/ImageWrapper;
    //   518: invokevirtual c : ()Lcom/blued/android/core/image/ImageWrapper;
    //   521: aload_2
    //   522: getfield b : Landroid/widget/ImageView;
    //   525: invokevirtual a : (Landroid/widget/ImageView;)V
    //   528: aload #16
    //   530: getfield comment_timestamp : Ljava/lang/String;
    //   533: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   536: ifne -> 564
    //   539: aload_2
    //   540: getfield c : Landroid/widget/TextView;
    //   543: aload_0
    //   544: getfield b : Landroid/content/Context;
    //   547: aload #16
    //   549: getfield comment_timestamp : Ljava/lang/String;
    //   552: invokestatic b : (Ljava/lang/String;)J
    //   555: invokestatic i : (Landroid/content/Context;J)Ljava/lang/String;
    //   558: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   561: goto -> 574
    //   564: aload_2
    //   565: getfield c : Landroid/widget/TextView;
    //   568: ldc_w ''
    //   571: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   574: aload #16
    //   576: getfield user_name : Ljava/lang/String;
    //   579: invokestatic e : (Ljava/lang/String;)Z
    //   582: ifne -> 652
    //   585: aload #16
    //   587: getfield note : Ljava/lang/String;
    //   590: invokestatic e : (Ljava/lang/String;)Z
    //   593: ifne -> 628
    //   596: aload_2
    //   597: getfield d : Landroid/widget/TextView;
    //   600: aload #16
    //   602: getfield note : Ljava/lang/String;
    //   605: aload #16
    //   607: getfield user_name : Ljava/lang/String;
    //   610: ldc_w ':'
    //   613: ldc_w ''
    //   616: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   619: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   622: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   625: goto -> 662
    //   628: aload_2
    //   629: getfield d : Landroid/widget/TextView;
    //   632: aload #16
    //   634: getfield user_name : Ljava/lang/String;
    //   637: ldc_w ':'
    //   640: ldc_w ''
    //   643: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   646: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   649: goto -> 662
    //   652: aload_2
    //   653: getfield d : Landroid/widget/TextView;
    //   656: ldc_w ''
    //   659: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   662: new com/soft/blued/ui/find/model/UserBasicModel
    //   665: dup
    //   666: invokespecial <init> : ()V
    //   669: astore_3
    //   670: aload_3
    //   671: aload #16
    //   673: getfield vip_grade : I
    //   676: putfield vip_grade : I
    //   679: aload_3
    //   680: aload #16
    //   682: getfield is_vip_annual : I
    //   685: putfield is_vip_annual : I
    //   688: aload_3
    //   689: aload #16
    //   691: getfield is_hide_vip_look : I
    //   694: putfield is_hide_vip_look : I
    //   697: aload_3
    //   698: aload #16
    //   700: getfield vip_exp_lvl : I
    //   703: putfield vip_exp_lvl : I
    //   706: aload_0
    //   707: getfield b : Landroid/content/Context;
    //   710: aload_2
    //   711: getfield d : Landroid/widget/TextView;
    //   714: aload_3
    //   715: invokestatic a : (Landroid/content/Context;Landroid/widget/TextView;Lcom/soft/blued/ui/find/model/UserBasicModel;)V
    //   718: aload_2
    //   719: getfield i : Landroid/widget/ImageView;
    //   722: aload_3
    //   723: invokestatic a : (Landroid/widget/ImageView;Lcom/soft/blued/ui/find/model/UserBasicModel;)V
    //   726: aload_0
    //   727: invokespecial b : ()Z
    //   730: ifeq -> 748
    //   733: aload_2
    //   734: getfield j : Landroid/widget/ImageView;
    //   737: aload #16
    //   739: getfield is_author : I
    //   742: invokestatic a : (Landroid/widget/ImageView;I)V
    //   745: goto -> 765
    //   748: aload_2
    //   749: getfield j : Landroid/widget/ImageView;
    //   752: aload #16
    //   754: getfield admin_level : I
    //   757: aload #16
    //   759: getfield is_author : I
    //   762: invokestatic setLevelMark : (Landroid/widget/ImageView;II)V
    //   765: aload_2
    //   766: getfield k : Landroid/widget/ImageView;
    //   769: astore_3
    //   770: aload #16
    //   772: getfield is_anonym : I
    //   775: iconst_1
    //   776: if_icmpne -> 785
    //   779: iconst_0
    //   780: istore #6
    //   782: goto -> 789
    //   785: bipush #8
    //   787: istore #6
    //   789: aload_3
    //   790: iload #6
    //   792: invokevirtual setVisibility : (I)V
    //   795: aload #16
    //   797: getfield is_reply : Ljava/lang/String;
    //   800: invokestatic e : (Ljava/lang/String;)Z
    //   803: ifne -> 886
    //   806: ldc_w '1'
    //   809: aload #16
    //   811: getfield is_reply : Ljava/lang/String;
    //   814: invokevirtual equals : (Ljava/lang/Object;)Z
    //   817: ifeq -> 843
    //   820: aload_0
    //   821: getfield b : Landroid/content/Context;
    //   824: aload_2
    //   825: getfield e : Landroid/widget/TextView;
    //   828: aload #16
    //   830: aload_0
    //   831: getfield j : Ljava/lang/String;
    //   834: ldc_w 2131100716
    //   837: invokestatic a : (Landroid/content/Context;Landroid/widget/TextView;Lcom/soft/blued/ui/feed/model/FeedComment;Ljava/lang/String;I)V
    //   840: goto -> 896
    //   843: ldc_w '0'
    //   846: aload #16
    //   848: getfield is_reply : Ljava/lang/String;
    //   851: invokevirtual equals : (Ljava/lang/Object;)Z
    //   854: ifeq -> 873
    //   857: aload_2
    //   858: getfield e : Landroid/widget/TextView;
    //   861: aload #16
    //   863: aload_0
    //   864: getfield j : Ljava/lang/String;
    //   867: invokestatic a : (Landroid/widget/TextView;Lcom/soft/blued/ui/feed/model/FeedComment;Ljava/lang/String;)V
    //   870: goto -> 896
    //   873: aload_2
    //   874: getfield e : Landroid/widget/TextView;
    //   877: ldc_w ''
    //   880: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   883: goto -> 896
    //   886: aload_2
    //   887: getfield e : Landroid/widget/TextView;
    //   890: ldc_w ''
    //   893: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   896: new com/soft/blued/ui/feed/adapter/CommentListAdapter$3
    //   899: dup
    //   900: aload_0
    //   901: aload #16
    //   903: aload_2
    //   904: getfield b : Landroid/widget/ImageView;
    //   907: invokespecial <init> : (Lcom/soft/blued/ui/feed/adapter/CommentListAdapter;Lcom/soft/blued/ui/feed/model/FeedComment;Landroid/widget/ImageView;)V
    //   910: astore_3
    //   911: aload_2
    //   912: getfield d : Landroid/widget/TextView;
    //   915: aload_3
    //   916: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   919: aload_2
    //   920: getfield b : Landroid/widget/ImageView;
    //   923: aload_3
    //   924: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   927: aload #16
    //   929: getfield comment_pics : [Ljava/lang/String;
    //   932: ifnull -> 1388
    //   935: aload #16
    //   937: getfield comment_pics : [Ljava/lang/String;
    //   940: arraylength
    //   941: ifle -> 1388
    //   944: aload_2
    //   945: getfield l : Landroid/widget/LinearLayout;
    //   948: iconst_0
    //   949: invokevirtual setVisibility : (I)V
    //   952: aload_0
    //   953: getfield b : Landroid/content/Context;
    //   956: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   959: invokevirtual getDisplayMetrics : ()Landroid/util/DisplayMetrics;
    //   962: getfield widthPixels : I
    //   965: istore #6
    //   967: new com/blued/android/core/imagecache/LoadOptions
    //   970: dup
    //   971: invokespecial <init> : ()V
    //   974: astore #15
    //   976: aload #15
    //   978: ldc_w 2131231369
    //   981: putfield d : I
    //   984: aload #15
    //   986: ldc_w 2131231369
    //   989: putfield b : I
    //   992: iload #6
    //   994: iconst_1
    //   995: ishr
    //   996: istore #6
    //   998: aload #15
    //   1000: iload #6
    //   1002: iload #6
    //   1004: invokevirtual a : (II)Lcom/blued/android/core/imagecache/LoadOptions;
    //   1007: pop
    //   1008: getstatic com/blued/android/core/AppInfo.l : I
    //   1011: invokestatic d : ()Landroid/content/Context;
    //   1014: ldc_w 74.0
    //   1017: invokestatic a : (Landroid/content/Context;F)I
    //   1020: isub
    //   1021: istore #6
    //   1023: iload #6
    //   1025: i2d
    //   1026: dstore #4
    //   1028: dload #4
    //   1030: ldc2_w 1.5
    //   1033: dmul
    //   1034: d2i
    //   1035: istore #7
    //   1037: dload #4
    //   1039: ldc2_w 0.73
    //   1042: dmul
    //   1043: d2i
    //   1044: istore #8
    //   1046: aload_2
    //   1047: astore_3
    //   1048: aload_2
    //   1049: getfield l : Landroid/widget/LinearLayout;
    //   1052: invokevirtual removeAllViews : ()V
    //   1055: iconst_0
    //   1056: istore #9
    //   1058: aload_2
    //   1059: astore_3
    //   1060: iload #9
    //   1062: aload #16
    //   1064: getfield comment_pics : [Ljava/lang/String;
    //   1067: arraylength
    //   1068: if_icmpge -> 1370
    //   1071: aload_2
    //   1072: astore_3
    //   1073: aload #16
    //   1075: getfield comment_pics_width : [Ljava/lang/String;
    //   1078: iload #9
    //   1080: aaload
    //   1081: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Integer;
    //   1084: invokevirtual intValue : ()I
    //   1087: aload #16
    //   1089: getfield comment_pics_height : [Ljava/lang/String;
    //   1092: iload #9
    //   1094: aaload
    //   1095: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Integer;
    //   1098: invokevirtual intValue : ()I
    //   1101: iload #6
    //   1103: iload #7
    //   1105: iload #6
    //   1107: iload #8
    //   1109: invokestatic a : (IIIIII)[I
    //   1112: astore #19
    //   1114: aload_2
    //   1115: astore_3
    //   1116: aload_0
    //   1117: getfield b : Landroid/content/Context;
    //   1120: invokestatic from : (Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   1123: ldc_w 2131493491
    //   1126: aconst_null
    //   1127: invokevirtual inflate : (ILandroid/view/ViewGroup;)Landroid/view/View;
    //   1130: astore #17
    //   1132: aload_2
    //   1133: astore_3
    //   1134: aload #17
    //   1136: ldc_w 2131296747
    //   1139: invokevirtual findViewById : (I)Landroid/view/View;
    //   1142: checkcast android/widget/ImageView
    //   1145: astore #18
    //   1147: aload_2
    //   1148: astore_3
    //   1149: aload #17
    //   1151: ldc_w 2131296745
    //   1154: invokevirtual findViewById : (I)Landroid/view/View;
    //   1157: checkcast com/blued/android/framework/view/shape/ShapeTextView
    //   1160: astore #20
    //   1162: aload_2
    //   1163: astore_3
    //   1164: aload #16
    //   1166: getfield comment_pics_height : [Ljava/lang/String;
    //   1169: ifnull -> 1238
    //   1172: aload_2
    //   1173: astore_3
    //   1174: aload #16
    //   1176: getfield comment_pics_height : [Ljava/lang/String;
    //   1179: arraylength
    //   1180: iload #9
    //   1182: if_icmple -> 1238
    //   1185: aload_2
    //   1186: astore_3
    //   1187: aload #16
    //   1189: getfield comment_pics_height : [Ljava/lang/String;
    //   1192: iload #9
    //   1194: aaload
    //   1195: invokestatic c : (Ljava/lang/String;)I
    //   1198: istore #10
    //   1200: iload #10
    //   1202: i2d
    //   1203: dstore #4
    //   1205: dload #4
    //   1207: getstatic com/blued/android/core/AppInfo.m : I
    //   1210: i2d
    //   1211: ldc2_w 1.5
    //   1214: dmul
    //   1215: dcmpl
    //   1216: ifle -> 1228
    //   1219: aload #20
    //   1221: iconst_0
    //   1222: invokevirtual setVisibility : (I)V
    //   1225: goto -> 1245
    //   1228: aload #20
    //   1230: bipush #8
    //   1232: invokevirtual setVisibility : (I)V
    //   1235: goto -> 1245
    //   1238: aload #20
    //   1240: bipush #8
    //   1242: invokevirtual setVisibility : (I)V
    //   1245: new android/widget/FrameLayout$LayoutParams
    //   1248: dup
    //   1249: aload #19
    //   1251: iconst_0
    //   1252: iaload
    //   1253: aload #19
    //   1255: iconst_1
    //   1256: iaload
    //   1257: invokespecial <init> : (II)V
    //   1260: astore_3
    //   1261: iload #9
    //   1263: aload #16
    //   1265: getfield comment_pics : [Ljava/lang/String;
    //   1268: arraylength
    //   1269: iconst_1
    //   1270: isub
    //   1271: if_icmpeq -> 1288
    //   1274: aload_3
    //   1275: aload_0
    //   1276: getfield b : Landroid/content/Context;
    //   1279: ldc_w 10.0
    //   1282: invokestatic a : (Landroid/content/Context;F)I
    //   1285: putfield bottomMargin : I
    //   1288: aload #18
    //   1290: aload_3
    //   1291: invokevirtual setLayoutParams : (Landroid/view/ViewGroup$LayoutParams;)V
    //   1294: aload_0
    //   1295: getfield f : Lcom/blued/android/core/net/IRequestHost;
    //   1298: aload #16
    //   1300: getfield comment_pics : [Ljava/lang/String;
    //   1303: iload #9
    //   1305: aaload
    //   1306: aload #19
    //   1308: iload #9
    //   1310: iaload
    //   1311: invokestatic a : (Ljava/lang/String;I)Ljava/lang/String;
    //   1314: invokestatic a : (Lcom/blued/android/core/net/IRequestHost;Ljava/lang/String;)Lcom/blued/android/core/image/ImageWrapper;
    //   1317: ldc_w 6.0
    //   1320: invokevirtual a : (F)Lcom/blued/android/core/image/ImageWrapper;
    //   1323: aload #18
    //   1325: invokevirtual a : (Landroid/widget/ImageView;)V
    //   1328: aload_2
    //   1329: getfield l : Landroid/widget/LinearLayout;
    //   1332: aload #17
    //   1334: invokevirtual addView : (Landroid/view/View;)V
    //   1337: aload #18
    //   1339: new com/soft/blued/ui/feed/adapter/CommentListAdapter$4
    //   1342: dup
    //   1343: aload_0
    //   1344: aload #16
    //   1346: iload #9
    //   1348: aload #15
    //   1350: aload_2
    //   1351: iload_1
    //   1352: invokespecial <init> : (Lcom/soft/blued/ui/feed/adapter/CommentListAdapter;Lcom/soft/blued/ui/feed/model/FeedComment;ILcom/blued/android/core/imagecache/LoadOptions;Lcom/soft/blued/ui/feed/adapter/CommentListAdapter$ViewHolder;I)V
    //   1355: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   1358: iload #9
    //   1360: iconst_1
    //   1361: iadd
    //   1362: istore #9
    //   1364: goto -> 1058
    //   1367: goto -> 1375
    //   1370: goto -> 1385
    //   1373: aload_3
    //   1374: astore_2
    //   1375: ldc_w '图片越界'
    //   1378: iconst_0
    //   1379: anewarray java/lang/Object
    //   1382: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   1385: goto -> 1397
    //   1388: aload_2
    //   1389: getfield l : Landroid/widget/LinearLayout;
    //   1392: bipush #8
    //   1394: invokevirtual setVisibility : (I)V
    //   1397: aload_0
    //   1398: aload_2
    //   1399: getfield a : Landroid/view/View;
    //   1402: aload #16
    //   1404: invokespecial a : (Landroid/view/View;Lcom/soft/blued/ui/feed/model/FeedComment;)V
    //   1407: aload_2
    //   1408: getfield a : Landroid/view/View;
    //   1411: new com/soft/blued/ui/feed/adapter/-$$Lambda$CommentListAdapter$ZC2dA-qIeXPVQBkuffon2b1HW74
    //   1414: dup
    //   1415: aload_0
    //   1416: aload #16
    //   1418: invokespecial <init> : (Lcom/soft/blued/ui/feed/adapter/CommentListAdapter;Lcom/soft/blued/ui/feed/model/FeedComment;)V
    //   1421: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   1424: aload_2
    //   1425: getfield m : Landroid/view/View;
    //   1428: bipush #8
    //   1430: invokevirtual setVisibility : (I)V
    //   1433: aload_2
    //   1434: getfield m : Landroid/view/View;
    //   1437: invokevirtual clearAnimation : ()V
    //   1440: new java/lang/StringBuilder
    //   1443: dup
    //   1444: invokespecial <init> : ()V
    //   1447: astore_2
    //   1448: aload_2
    //   1449: ldc_w 'from====='
    //   1452: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1455: pop
    //   1456: aload_2
    //   1457: aload_0
    //   1458: getfield m : I
    //   1461: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1464: pop
    //   1465: ldc_w 'CommentListAdapter'
    //   1468: iconst_1
    //   1469: anewarray java/lang/Object
    //   1472: dup
    //   1473: iconst_0
    //   1474: aload_2
    //   1475: invokevirtual toString : ()Ljava/lang/String;
    //   1478: aastore
    //   1479: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   1482: aload_0
    //   1483: getfield m : I
    //   1486: bipush #13
    //   1488: if_icmpne -> 1605
    //   1491: getstatic com/blued/das/client/feed/FeedProtos$Event.CIRCLE_NOTE_COMMENT_DRAW : Lcom/blued/das/client/feed/FeedProtos$Event;
    //   1494: astore_2
    //   1495: aload #16
    //   1497: getfield comment_id : Ljava/lang/String;
    //   1500: astore_3
    //   1501: getstatic com/blued/das/client/feed/FeedProtos$NoteSource.NOTE_COMMENT_DETAIL : Lcom/blued/das/client/feed/FeedProtos$NoteSource;
    //   1504: astore #15
    //   1506: aload #16
    //   1508: getfield feed_id : Ljava/lang/String;
    //   1511: astore #17
    //   1513: aload #16
    //   1515: getfield circle_id : Ljava/lang/String;
    //   1518: astore #18
    //   1520: aload #16
    //   1522: getfield comment_content : Ljava/lang/String;
    //   1525: invokestatic a : (Ljava/lang/CharSequence;)Z
    //   1528: istore #13
    //   1530: aload #16
    //   1532: invokestatic a : (Lcom/soft/blued/ui/feed/model/FeedComment;)Lcom/blued/das/client/feed/FeedProtos$FeedClass;
    //   1535: astore #19
    //   1537: aload_0
    //   1538: getfield g : Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;
    //   1541: invokestatic b : (Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;)Lcom/blued/das/client/feed/FeedProtos$NoteType;
    //   1544: astore #20
    //   1546: aload_0
    //   1547: getfield g : Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;
    //   1550: getfield is_anonym : I
    //   1553: iconst_1
    //   1554: if_icmpne -> 1563
    //   1557: iconst_1
    //   1558: istore #11
    //   1560: goto -> 1566
    //   1563: iconst_0
    //   1564: istore #11
    //   1566: aload #16
    //   1568: getfield is_anonym : I
    //   1571: iconst_1
    //   1572: if_icmpne -> 1581
    //   1575: iconst_1
    //   1576: istore #12
    //   1578: goto -> 1584
    //   1581: iconst_0
    //   1582: istore #12
    //   1584: aload_2
    //   1585: aload_3
    //   1586: aload #15
    //   1588: aload #17
    //   1590: aload #18
    //   1592: iload #13
    //   1594: aload #19
    //   1596: aload #20
    //   1598: iload #11
    //   1600: iload #12
    //   1602: invokestatic a : (Lcom/blued/das/client/feed/FeedProtos$Event;Ljava/lang/String;Lcom/blued/das/client/feed/FeedProtos$NoteSource;Ljava/lang/String;Ljava/lang/String;ZLcom/blued/das/client/feed/FeedProtos$FeedClass;Lcom/blued/das/client/feed/FeedProtos$NoteType;ZZ)V
    //   1605: aload #14
    //   1607: areturn
    //   1608: astore_2
    //   1609: goto -> 1373
    //   1612: astore_3
    //   1613: goto -> 1367
    //   1616: astore_3
    //   1617: goto -> 1375
    // Exception table:
    //   from	to	target	type
    //   1048	1055	1608	finally
    //   1060	1071	1608	finally
    //   1073	1114	1608	finally
    //   1116	1132	1608	finally
    //   1134	1147	1608	finally
    //   1149	1162	1608	finally
    //   1164	1172	1608	finally
    //   1174	1185	1608	finally
    //   1187	1200	1608	finally
    //   1205	1225	1612	finally
    //   1228	1235	1612	finally
    //   1238	1245	1612	finally
    //   1245	1288	1612	finally
    //   1288	1328	1612	finally
    //   1328	1358	1616	finally
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver) {
    super.registerDataSetObserver(paramDataSetObserver);
    CommentListDataObserver.a().a(this);
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver) {
    super.unregisterDataSetObserver(paramDataSetObserver);
    CommentListDataObserver.a().b(this);
  }
  
  public static interface FeedCommentListner {
    void contentClick(FeedComment param1FeedComment);
  }
  
  static interface LIKED {}
  
  class ViewHolder {
    public View a;
    
    public ImageView b;
    
    public TextView c;
    
    public TextView d;
    
    public TextView e;
    
    public ImageView f;
    
    public ImageView g;
    
    public TextView h;
    
    public ImageView i;
    
    public ImageView j;
    
    public ImageView k;
    
    public LinearLayout l;
    
    public View m;
    
    private ViewHolder(CommentListAdapter this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\adapter\CommentListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */