package com.soft.blued.ui.circle.adapter;

import android.animation.ObjectAnimator;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Build;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.framework.utils.RegExpUtils;
import com.blued.das.client.feed.FeedProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.customview.ActionSheet;
import com.soft.blued.http.CircleHttpUtils;
import com.soft.blued.http.FeedHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.circle.model.CircleAddPoints;
import com.soft.blued.ui.circle.model.CircleMethods;
import com.soft.blued.ui.feed.fragment.HotCommentsFragment;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.feed.model.FeedComment;
import com.soft.blued.ui.feed.observer.CommentListDataObserver;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.photo.fragment.BasePhotoFragment;
import com.soft.blued.ui.user.fragment.ReportFragmentNew;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.AreaUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import com.soft.blued.view.tip.CommonShowBottomWindow;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class CircleMainDetailCommentAdapter extends BaseQuickAdapter<FeedComment, BaseViewHolder> implements CommentListDataObserver.ICommentDataObserver {
  public static final String a = CircleMainDetailCommentAdapter.class.getSimpleName();
  
  public String b = "";
  
  public IRequestHost c;
  
  public BluedIngSelfFeed d;
  
  public String e = "";
  
  public String f = "";
  
  private int g = 1;
  
  private HashSet<String> h = new HashSet<String>();
  
  private View i;
  
  public CircleMainDetailCommentAdapter() {
    super(2131493504, null);
  }
  
  private boolean B() {
    return this.b.equals("feed_comment_floor");
  }
  
  private List<FeedComment> a(List<FeedComment> paramList) {
    ArrayList<FeedComment> arrayList = new ArrayList();
    for (FeedComment feedComment : paramList) {
      if (!this.h.contains(feedComment.comment_id)) {
        arrayList.add(feedComment);
        this.h.add(feedComment.comment_id);
      } 
    } 
    return arrayList;
  }
  
  private void a(View paramView, FeedComment paramFeedComment) {
    if (paramFeedComment != null)
      paramView.setOnLongClickListener(new View.OnLongClickListener(this, paramFeedComment) {
            public boolean onLongClick(View param1View) {
              ArrayList<String> arrayList = new ArrayList();
              arrayList.add(CircleMainDetailCommentAdapter.h(this.b).getResources().getString(2131758501));
              if (this.a.user_allow_mute == CircleMainDetailCommentAdapter.i(this.b)) {
                int i;
                Resources resources = CircleMainDetailCommentAdapter.j(this.b).getResources();
                if (this.a.is_muted == 1) {
                  i = 2131755861;
                } else {
                  i = 2131755862;
                } 
                arrayList.add(resources.getString(i));
              } 
              if (!CircleMethods.isAnonymousMineUid(this.a.comment_uid))
                arrayList.add(CircleMainDetailCommentAdapter.k(this.b).getResources().getString(2131758584)); 
              if ("1".equals(this.a.comment_allow_delete))
                arrayList.add(CircleMainDetailCommentAdapter.l(this.b).getResources().getString(2131756176)); 
              CommonShowBottomWindow.a((FragmentActivity)CircleMainDetailCommentAdapter.m(this.b), arrayList.<String>toArray(new String[arrayList.size()]), new ActionSheet.ActionSheetListener(this) {
                    public void a(ActionSheet param2ActionSheet, int param2Int) {
                      String str = param2ActionSheet.a(param2Int);
                      if (str.equals(CircleMainDetailCommentAdapter.n(this.a.b).getResources().getString(2131758501))) {
                        this.a.b.a(this.a.a);
                        return;
                      } 
                      if (str.equals(CircleMainDetailCommentAdapter.o(this.a.b).getResources().getString(2131756176))) {
                        this.a.b.b(this.a.a);
                        return;
                      } 
                      if (str.equals(CircleMainDetailCommentAdapter.p(this.a.b).getResources().getString(2131758584))) {
                        ReportFragmentNew.b(CircleMainDetailCommentAdapter.q(this.a.b), this.a.a.comment_id, this.a.a.feed_id, this.a.a.user_name);
                        return;
                      } 
                      Resources resources = CircleMainDetailCommentAdapter.r(this.a.b).getResources();
                      if (this.a.a.is_muted == 1) {
                        param2Int = 2131755861;
                      } else {
                        param2Int = 2131755862;
                      } 
                      if (str.equals(resources.getString(param2Int)))
                        this.a.b.a(this.a.a, this.a.b.c); 
                    }
                    
                    public void a(ActionSheet param2ActionSheet, boolean param2Boolean) {}
                  });
              return true;
            }
          }); 
  }
  
  private void a(FeedComment paramFeedComment, ImageView paramImageView, TextView paramTextView) {
    boolean bool1;
    boolean bool2;
    boolean bool3;
    boolean bool4;
    String str2 = paramFeedComment.comment_id;
    String str3 = paramFeedComment.feed_id;
    if (paramFeedComment.iliked == 1) {
      bool1 = false;
    } else {
      bool1 = true;
    } 
    paramFeedComment.iliked = bool1;
    if (paramFeedComment.iliked == 1) {
      paramFeedComment.liked_count++;
      paramImageView.setImageResource(2131232450);
      paramTextView.setTextColor(this.k.getResources().getColor(2131100319));
    } else {
      paramFeedComment.liked_count--;
      paramImageView.setImageResource(2131232449);
      paramTextView.setTextColor(BluedSkinUtils.a(this.k, 2131100842));
    } 
    if (paramFeedComment.liked_count == 0) {
      paramTextView.setVisibility(8);
    } else {
      paramTextView.setVisibility(0);
    } 
    Context context = this.k;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramFeedComment.liked_count);
    stringBuilder.append("");
    paramTextView.setText(AreaUtils.a(context, stringBuilder.toString()));
    FeedProtos.Event event = FeedProtos.Event.CIRCLE_NOTE_LIKE;
    String str1 = this.e;
    if (bool1 == true) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    boolean bool = StringUtils.a(paramFeedComment.comment_content);
    FeedProtos.FeedClass feedClass = EventTrackFeed.a(paramFeedComment);
    FeedProtos.NoteType noteType = EventTrackFeed.b(this.d);
    if (this.d.is_anonym == 1) {
      bool3 = true;
    } else {
      bool3 = false;
    } 
    if (paramFeedComment.is_anonym == 1) {
      bool4 = true;
    } else {
      bool4 = false;
    } 
    EventTrackFeed.a(event, str1, str3, str2, bool2, bool, feedClass, noteType, bool3, bool4, FeedProtos.NoteSource.NOTE_DETAIL);
    FeedHttpUtils.a(str3, str2, bool1, new BluedUIHttpResponse<BluedEntityA<CircleAddPoints>>(this, this.c) {
          protected void a(BluedEntityA<CircleAddPoints> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.hasData() && ((CircleAddPoints)param1BluedEntityA.getSingleData()).circle_active_liked_posting > 0) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("点赞成功，基分+");
              stringBuilder.append(((CircleAddPoints)param1BluedEntityA.getSingleData()).circle_active_liked_posting);
              AppMethods.a(stringBuilder.toString());
            } 
          }
        }this.c, false);
  }
  
  public void A() {
    CommentListDataObserver.a().b(this);
  }
  
  public String a() {
    return this.f;
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, FeedComment paramFeedComment) {
    // Byte code:
    //   0: aload_1
    //   1: ldc_w 2131299051
    //   4: invokevirtual d : (I)Landroid/view/View;
    //   7: checkcast com/blued/android/framework/view/shape/ShapeLinearLayout
    //   10: ldc_w 2131100881
    //   13: invokestatic b : (Lcom/blued/android/framework/view/shape/ShapeHelper$ShapeView;I)V
    //   16: aload_2
    //   17: getfield iliked : I
    //   20: iconst_1
    //   21: if_icmpne -> 55
    //   24: aload_1
    //   25: ldc_w 2131297461
    //   28: ldc 2131232450
    //   30: invokevirtual c : (II)Lcom/chad/library/adapter/base/BaseViewHolder;
    //   33: ldc_w 2131300653
    //   36: aload_0
    //   37: getfield k : Landroid/content/Context;
    //   40: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   43: ldc 2131100319
    //   45: invokevirtual getColor : (I)I
    //   48: invokevirtual f : (II)Lcom/chad/library/adapter/base/BaseViewHolder;
    //   51: pop
    //   52: goto -> 80
    //   55: aload_1
    //   56: ldc_w 2131297461
    //   59: ldc 2131232449
    //   61: invokevirtual c : (II)Lcom/chad/library/adapter/base/BaseViewHolder;
    //   64: ldc_w 2131300653
    //   67: aload_0
    //   68: getfield k : Landroid/content/Context;
    //   71: ldc 2131100842
    //   73: invokestatic a : (Landroid/content/Context;I)I
    //   76: invokevirtual f : (II)Lcom/chad/library/adapter/base/BaseViewHolder;
    //   79: pop
    //   80: aload_2
    //   81: getfield liked_count : I
    //   84: ifle -> 148
    //   87: aload_0
    //   88: getfield k : Landroid/content/Context;
    //   91: astore #12
    //   93: new java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial <init> : ()V
    //   100: astore #13
    //   102: aload #13
    //   104: aload_2
    //   105: getfield liked_count : I
    //   108: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload #13
    //   114: ldc ''
    //   116: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload_1
    //   121: ldc_w 2131300653
    //   124: aload #12
    //   126: aload #13
    //   128: invokevirtual toString : ()Ljava/lang/String;
    //   131: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   134: invokevirtual a : (ILjava/lang/CharSequence;)Lcom/chad/library/adapter/base/BaseViewHolder;
    //   137: ldc_w 2131300653
    //   140: iconst_1
    //   141: invokevirtual b : (IZ)Lcom/chad/library/adapter/base/BaseViewHolder;
    //   144: pop
    //   145: goto -> 157
    //   148: aload_1
    //   149: ldc_w 2131300653
    //   152: iconst_0
    //   153: invokevirtual b : (IZ)Lcom/chad/library/adapter/base/BaseViewHolder;
    //   156: pop
    //   157: aload_1
    //   158: ldc_w 2131297461
    //   161: invokevirtual d : (I)Landroid/view/View;
    //   164: new com/soft/blued/ui/circle/adapter/CircleMainDetailCommentAdapter$1
    //   167: dup
    //   168: aload_0
    //   169: aload_2
    //   170: aload_1
    //   171: invokespecial <init> : (Lcom/soft/blued/ui/circle/adapter/CircleMainDetailCommentAdapter;Lcom/soft/blued/ui/feed/model/FeedComment;Lcom/chad/library/adapter/base/BaseViewHolder;)V
    //   174: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   177: aload_1
    //   178: ldc_w 2131300653
    //   181: invokevirtual d : (I)Landroid/view/View;
    //   184: new com/soft/blued/ui/circle/adapter/CircleMainDetailCommentAdapter$2
    //   187: dup
    //   188: aload_0
    //   189: aload_2
    //   190: aload_1
    //   191: invokespecial <init> : (Lcom/soft/blued/ui/circle/adapter/CircleMainDetailCommentAdapter;Lcom/soft/blued/ui/feed/model/FeedComment;Lcom/chad/library/adapter/base/BaseViewHolder;)V
    //   194: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   197: aload_2
    //   198: getfield isLastHotComment : Z
    //   201: ifeq -> 311
    //   204: aload_1
    //   205: ldc_w 2131298958
    //   208: iconst_1
    //   209: invokevirtual b : (IZ)Lcom/chad/library/adapter/base/BaseViewHolder;
    //   212: pop
    //   213: aload_2
    //   214: getfield isHasMoreHotComment : Z
    //   217: ifeq -> 269
    //   220: aload_1
    //   221: ldc_w 2131297429
    //   224: iconst_1
    //   225: invokevirtual b : (IZ)Lcom/chad/library/adapter/base/BaseViewHolder;
    //   228: ldc_w 2131301052
    //   231: aload_0
    //   232: getfield k : Landroid/content/Context;
    //   235: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   238: ldc_w 2131757933
    //   241: invokevirtual getString : (I)Ljava/lang/String;
    //   244: invokevirtual a : (ILjava/lang/CharSequence;)Lcom/chad/library/adapter/base/BaseViewHolder;
    //   247: pop
    //   248: aload_1
    //   249: ldc_w 2131298958
    //   252: invokevirtual d : (I)Landroid/view/View;
    //   255: new com/soft/blued/ui/circle/adapter/CircleMainDetailCommentAdapter$3
    //   258: dup
    //   259: aload_0
    //   260: invokespecial <init> : (Lcom/soft/blued/ui/circle/adapter/CircleMainDetailCommentAdapter;)V
    //   263: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   266: goto -> 320
    //   269: aload_1
    //   270: ldc_w 2131297429
    //   273: iconst_0
    //   274: invokevirtual b : (IZ)Lcom/chad/library/adapter/base/BaseViewHolder;
    //   277: ldc_w 2131301052
    //   280: aload_0
    //   281: getfield k : Landroid/content/Context;
    //   284: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   287: ldc_w 2131755214
    //   290: invokevirtual getString : (I)Ljava/lang/String;
    //   293: invokevirtual a : (ILjava/lang/CharSequence;)Lcom/chad/library/adapter/base/BaseViewHolder;
    //   296: pop
    //   297: aload_1
    //   298: ldc_w 2131298958
    //   301: invokevirtual d : (I)Landroid/view/View;
    //   304: aconst_null
    //   305: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   308: goto -> 320
    //   311: aload_1
    //   312: ldc_w 2131298958
    //   315: iconst_0
    //   316: invokevirtual b : (IZ)Lcom/chad/library/adapter/base/BaseViewHolder;
    //   319: pop
    //   320: aload_1
    //   321: ldc_w 2131297575
    //   324: invokevirtual d : (I)Landroid/view/View;
    //   327: checkcast android/widget/ImageView
    //   330: aload_2
    //   331: getfield vbadge : I
    //   334: iconst_3
    //   335: invokestatic a : (Landroid/widget/ImageView;II)V
    //   338: aload_0
    //   339: getfield c : Lcom/blued/android/core/net/IRequestHost;
    //   342: aload_2
    //   343: getfield user_avatar : Ljava/lang/String;
    //   346: invokestatic a : (Lcom/blued/android/core/net/IRequestHost;Ljava/lang/String;)Lcom/blued/android/core/image/ImageWrapper;
    //   349: ldc_w 2131234356
    //   352: invokevirtual a : (I)Lcom/blued/android/core/image/ImageWrapper;
    //   355: invokevirtual c : ()Lcom/blued/android/core/image/ImageWrapper;
    //   358: aload_1
    //   359: ldc_w 2131297362
    //   362: invokevirtual d : (I)Landroid/view/View;
    //   365: checkcast android/widget/ImageView
    //   368: invokevirtual a : (Landroid/widget/ImageView;)V
    //   371: aload_2
    //   372: getfield comment_timestamp : Ljava/lang/String;
    //   375: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   378: ifne -> 406
    //   381: aload_1
    //   382: ldc_w 2131300267
    //   385: aload_0
    //   386: getfield k : Landroid/content/Context;
    //   389: aload_2
    //   390: getfield comment_timestamp : Ljava/lang/String;
    //   393: invokestatic b : (Ljava/lang/String;)J
    //   396: invokestatic i : (Landroid/content/Context;J)Ljava/lang/String;
    //   399: invokevirtual a : (ILjava/lang/CharSequence;)Lcom/chad/library/adapter/base/BaseViewHolder;
    //   402: pop
    //   403: goto -> 416
    //   406: aload_1
    //   407: ldc_w 2131300267
    //   410: ldc ''
    //   412: invokevirtual a : (ILjava/lang/CharSequence;)Lcom/chad/library/adapter/base/BaseViewHolder;
    //   415: pop
    //   416: aload_2
    //   417: getfield user_name : Ljava/lang/String;
    //   420: invokestatic e : (Ljava/lang/String;)Z
    //   423: ifne -> 489
    //   426: aload_2
    //   427: getfield note : Ljava/lang/String;
    //   430: invokestatic e : (Ljava/lang/String;)Z
    //   433: ifne -> 466
    //   436: aload_1
    //   437: ldc_w 2131299358
    //   440: aload_2
    //   441: getfield note : Ljava/lang/String;
    //   444: aload_2
    //   445: getfield user_name : Ljava/lang/String;
    //   448: ldc_w ':'
    //   451: ldc ''
    //   453: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   456: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   459: invokevirtual a : (ILjava/lang/CharSequence;)Lcom/chad/library/adapter/base/BaseViewHolder;
    //   462: pop
    //   463: goto -> 499
    //   466: aload_1
    //   467: ldc_w 2131299358
    //   470: aload_2
    //   471: getfield user_name : Ljava/lang/String;
    //   474: ldc_w ':'
    //   477: ldc ''
    //   479: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   482: invokevirtual a : (ILjava/lang/CharSequence;)Lcom/chad/library/adapter/base/BaseViewHolder;
    //   485: pop
    //   486: goto -> 499
    //   489: aload_1
    //   490: ldc_w 2131299358
    //   493: ldc ''
    //   495: invokevirtual a : (ILjava/lang/CharSequence;)Lcom/chad/library/adapter/base/BaseViewHolder;
    //   498: pop
    //   499: new com/soft/blued/ui/find/model/UserBasicModel
    //   502: dup
    //   503: invokespecial <init> : ()V
    //   506: astore #12
    //   508: aload #12
    //   510: aload_2
    //   511: getfield vip_grade : I
    //   514: putfield vip_grade : I
    //   517: aload #12
    //   519: aload_2
    //   520: getfield is_vip_annual : I
    //   523: putfield is_vip_annual : I
    //   526: aload #12
    //   528: aload_2
    //   529: getfield is_hide_vip_look : I
    //   532: putfield is_hide_vip_look : I
    //   535: aload #12
    //   537: aload_2
    //   538: getfield vip_exp_lvl : I
    //   541: putfield vip_exp_lvl : I
    //   544: aload_0
    //   545: getfield k : Landroid/content/Context;
    //   548: aload_1
    //   549: ldc_w 2131299358
    //   552: invokevirtual d : (I)Landroid/view/View;
    //   555: checkcast android/widget/TextView
    //   558: aload #12
    //   560: invokestatic a : (Landroid/content/Context;Landroid/widget/TextView;Lcom/soft/blued/ui/find/model/UserBasicModel;)V
    //   563: aload_1
    //   564: ldc_w 2131297581
    //   567: invokevirtual d : (I)Landroid/view/View;
    //   570: checkcast android/widget/ImageView
    //   573: aload #12
    //   575: invokestatic a : (Landroid/widget/ImageView;Lcom/soft/blued/ui/find/model/UserBasicModel;)V
    //   578: aload_1
    //   579: ldc_w 2131297820
    //   582: invokevirtual d : (I)Landroid/view/View;
    //   585: checkcast android/widget/ImageView
    //   588: aload_2
    //   589: getfield admin_level : I
    //   592: aload_2
    //   593: getfield is_author : I
    //   596: invokestatic setLevelMark : (Landroid/widget/ImageView;II)V
    //   599: aload_2
    //   600: getfield is_anonym : I
    //   603: iconst_1
    //   604: if_icmpne -> 613
    //   607: iconst_1
    //   608: istore #9
    //   610: goto -> 616
    //   613: iconst_0
    //   614: istore #9
    //   616: aload_1
    //   617: ldc_w 2131297682
    //   620: iload #9
    //   622: invokevirtual b : (IZ)Lcom/chad/library/adapter/base/BaseViewHolder;
    //   625: pop
    //   626: aload_2
    //   627: getfield is_reply : Ljava/lang/String;
    //   630: invokestatic e : (Ljava/lang/String;)Z
    //   633: ifne -> 724
    //   636: ldc_w '1'
    //   639: aload_2
    //   640: getfield is_reply : Ljava/lang/String;
    //   643: invokevirtual equals : (Ljava/lang/Object;)Z
    //   646: ifeq -> 677
    //   649: aload_0
    //   650: getfield k : Landroid/content/Context;
    //   653: aload_1
    //   654: ldc_w 2131296838
    //   657: invokevirtual d : (I)Landroid/view/View;
    //   660: checkcast android/widget/TextView
    //   663: aload_2
    //   664: aload_0
    //   665: getfield b : Ljava/lang/String;
    //   668: ldc_w 2131100716
    //   671: invokestatic a : (Landroid/content/Context;Landroid/widget/TextView;Lcom/soft/blued/ui/feed/model/FeedComment;Ljava/lang/String;I)V
    //   674: goto -> 734
    //   677: ldc_w '0'
    //   680: aload_2
    //   681: getfield is_reply : Ljava/lang/String;
    //   684: invokevirtual equals : (Ljava/lang/Object;)Z
    //   687: ifeq -> 711
    //   690: aload_1
    //   691: ldc_w 2131296838
    //   694: invokevirtual d : (I)Landroid/view/View;
    //   697: checkcast android/widget/TextView
    //   700: aload_2
    //   701: aload_0
    //   702: getfield b : Ljava/lang/String;
    //   705: invokestatic a : (Landroid/widget/TextView;Lcom/soft/blued/ui/feed/model/FeedComment;Ljava/lang/String;)V
    //   708: goto -> 734
    //   711: aload_1
    //   712: ldc_w 2131296838
    //   715: ldc ''
    //   717: invokevirtual a : (ILjava/lang/CharSequence;)Lcom/chad/library/adapter/base/BaseViewHolder;
    //   720: pop
    //   721: goto -> 734
    //   724: aload_1
    //   725: ldc_w 2131296838
    //   728: ldc ''
    //   730: invokevirtual a : (ILjava/lang/CharSequence;)Lcom/chad/library/adapter/base/BaseViewHolder;
    //   733: pop
    //   734: aload_2
    //   735: getfield comments_count : I
    //   738: ifle -> 1477
    //   741: aload_2
    //   742: getfield comments : Ljava/util/List;
    //   745: ifnull -> 1477
    //   748: aload_2
    //   749: getfield comments : Ljava/util/List;
    //   752: invokeinterface size : ()I
    //   757: ifle -> 1477
    //   760: aload_2
    //   761: getfield comments : Ljava/util/List;
    //   764: iconst_0
    //   765: invokeinterface get : (I)Ljava/lang/Object;
    //   770: checkcast com/soft/blued/ui/feed/model/FeedComment
    //   773: astore #14
    //   775: aload #14
    //   777: getfield is_reply : Ljava/lang/String;
    //   780: invokestatic e : (Ljava/lang/String;)Z
    //   783: ifne -> 838
    //   786: ldc_w '1'
    //   789: aload #14
    //   791: getfield is_reply : Ljava/lang/String;
    //   794: invokevirtual equals : (Ljava/lang/Object;)Z
    //   797: ifeq -> 838
    //   800: aload_0
    //   801: getfield k : Landroid/content/Context;
    //   804: aload_1
    //   805: ldc_w 2131301258
    //   808: invokevirtual d : (I)Landroid/view/View;
    //   811: checkcast android/widget/TextView
    //   814: invokevirtual getTextSize : ()F
    //   817: f2i
    //   818: aload #14
    //   820: aload #14
    //   822: getfield is_anonym : I
    //   825: bipush #13
    //   827: ldc_w 2131100716
    //   830: invokestatic a : (Landroid/content/Context;ILcom/soft/blued/ui/feed/model/FeedComment;III)Ljava/lang/CharSequence;
    //   833: astore #12
    //   835: goto -> 868
    //   838: aload_0
    //   839: getfield k : Landroid/content/Context;
    //   842: aload_1
    //   843: ldc_w 2131301258
    //   846: invokevirtual d : (I)Landroid/view/View;
    //   849: checkcast android/widget/TextView
    //   852: invokevirtual getTextSize : ()F
    //   855: f2i
    //   856: aload #14
    //   858: bipush #13
    //   860: ldc_w 2131100716
    //   863: invokestatic b : (Landroid/content/Context;ILcom/soft/blued/ui/feed/model/FeedComment;II)Ljava/lang/CharSequence;
    //   866: astore #12
    //   868: aload #12
    //   870: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   873: ifne -> 1017
    //   876: aload #14
    //   878: getfield note : Ljava/lang/String;
    //   881: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   884: ifne -> 897
    //   887: aload #14
    //   889: getfield note : Ljava/lang/String;
    //   892: astore #13
    //   894: goto -> 904
    //   897: aload #14
    //   899: getfield user_name : Ljava/lang/String;
    //   902: astore #13
    //   904: aload_1
    //   905: ldc_w 2131301259
    //   908: aload #13
    //   910: invokevirtual a : (ILjava/lang/CharSequence;)Lcom/chad/library/adapter/base/BaseViewHolder;
    //   913: pop
    //   914: aload_1
    //   915: ldc_w 2131297910
    //   918: invokevirtual d : (I)Landroid/view/View;
    //   921: checkcast android/widget/ImageView
    //   924: aload #14
    //   926: getfield admin_level : I
    //   929: aload #14
    //   931: getfield is_author : I
    //   934: invokestatic setLevelMark : (Landroid/widget/ImageView;II)V
    //   937: aload #14
    //   939: getfield is_anonym : I
    //   942: iconst_1
    //   943: if_icmpne -> 952
    //   946: iconst_1
    //   947: istore #9
    //   949: goto -> 955
    //   952: iconst_0
    //   953: istore #9
    //   955: aload_1
    //   956: ldc_w 2131297683
    //   959: iload #9
    //   961: invokevirtual b : (IZ)Lcom/chad/library/adapter/base/BaseViewHolder;
    //   964: pop
    //   965: aload_1
    //   966: ldc_w 2131301259
    //   969: invokevirtual d : (I)Landroid/view/View;
    //   972: new com/soft/blued/ui/circle/adapter/CircleMainDetailCommentAdapter$4
    //   975: dup
    //   976: aload_0
    //   977: aload #14
    //   979: invokespecial <init> : (Lcom/soft/blued/ui/circle/adapter/CircleMainDetailCommentAdapter;Lcom/soft/blued/ui/feed/model/FeedComment;)V
    //   982: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   985: aload_1
    //   986: ldc_w 2131301258
    //   989: invokevirtual d : (I)Landroid/view/View;
    //   992: checkcast android/widget/TextView
    //   995: aload #12
    //   997: iconst_0
    //   998: aload_0
    //   999: getfield b : Ljava/lang/String;
    //   1002: invokestatic a : (Landroid/widget/TextView;Ljava/lang/CharSequence;ILjava/lang/String;)V
    //   1005: aload_1
    //   1006: ldc_w 2131299052
    //   1009: iconst_1
    //   1010: invokevirtual b : (IZ)Lcom/chad/library/adapter/base/BaseViewHolder;
    //   1013: pop
    //   1014: goto -> 1026
    //   1017: aload_1
    //   1018: ldc_w 2131299052
    //   1021: iconst_0
    //   1022: invokevirtual b : (IZ)Lcom/chad/library/adapter/base/BaseViewHolder;
    //   1025: pop
    //   1026: aload_2
    //   1027: getfield comments : Ljava/util/List;
    //   1030: invokeinterface size : ()I
    //   1035: iconst_1
    //   1036: if_icmple -> 1308
    //   1039: aload_2
    //   1040: getfield comments : Ljava/util/List;
    //   1043: iconst_1
    //   1044: invokeinterface get : (I)Ljava/lang/Object;
    //   1049: checkcast com/soft/blued/ui/feed/model/FeedComment
    //   1052: astore #14
    //   1054: aload #14
    //   1056: getfield is_reply : Ljava/lang/String;
    //   1059: invokestatic e : (Ljava/lang/String;)Z
    //   1062: ifne -> 1117
    //   1065: ldc_w '1'
    //   1068: aload #14
    //   1070: getfield is_reply : Ljava/lang/String;
    //   1073: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1076: ifeq -> 1117
    //   1079: aload_0
    //   1080: getfield k : Landroid/content/Context;
    //   1083: aload_1
    //   1084: ldc_w 2131301261
    //   1087: invokevirtual d : (I)Landroid/view/View;
    //   1090: checkcast android/widget/TextView
    //   1093: invokevirtual getTextSize : ()F
    //   1096: f2i
    //   1097: aload #14
    //   1099: aload #14
    //   1101: getfield is_anonym : I
    //   1104: bipush #13
    //   1106: ldc_w 2131100716
    //   1109: invokestatic a : (Landroid/content/Context;ILcom/soft/blued/ui/feed/model/FeedComment;III)Ljava/lang/CharSequence;
    //   1112: astore #12
    //   1114: goto -> 1147
    //   1117: aload_0
    //   1118: getfield k : Landroid/content/Context;
    //   1121: aload_1
    //   1122: ldc_w 2131301261
    //   1125: invokevirtual d : (I)Landroid/view/View;
    //   1128: checkcast android/widget/TextView
    //   1131: invokevirtual getTextSize : ()F
    //   1134: f2i
    //   1135: aload #14
    //   1137: bipush #13
    //   1139: ldc_w 2131100716
    //   1142: invokestatic b : (Landroid/content/Context;ILcom/soft/blued/ui/feed/model/FeedComment;II)Ljava/lang/CharSequence;
    //   1145: astore #12
    //   1147: aload #12
    //   1149: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1152: ifne -> 1296
    //   1155: aload #14
    //   1157: getfield note : Ljava/lang/String;
    //   1160: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1163: ifne -> 1176
    //   1166: aload #14
    //   1168: getfield note : Ljava/lang/String;
    //   1171: astore #13
    //   1173: goto -> 1183
    //   1176: aload #14
    //   1178: getfield user_name : Ljava/lang/String;
    //   1181: astore #13
    //   1183: aload_1
    //   1184: ldc_w 2131301262
    //   1187: aload #13
    //   1189: invokevirtual a : (ILjava/lang/CharSequence;)Lcom/chad/library/adapter/base/BaseViewHolder;
    //   1192: pop
    //   1193: aload_1
    //   1194: ldc_w 2131297911
    //   1197: invokevirtual d : (I)Landroid/view/View;
    //   1200: checkcast android/widget/ImageView
    //   1203: aload #14
    //   1205: getfield admin_level : I
    //   1208: aload #14
    //   1210: getfield is_author : I
    //   1213: invokestatic setLevelMark : (Landroid/widget/ImageView;II)V
    //   1216: aload #14
    //   1218: getfield is_anonym : I
    //   1221: iconst_1
    //   1222: if_icmpne -> 1231
    //   1225: iconst_1
    //   1226: istore #9
    //   1228: goto -> 1234
    //   1231: iconst_0
    //   1232: istore #9
    //   1234: aload_1
    //   1235: ldc_w 2131297684
    //   1238: iload #9
    //   1240: invokevirtual b : (IZ)Lcom/chad/library/adapter/base/BaseViewHolder;
    //   1243: pop
    //   1244: aload_1
    //   1245: ldc_w 2131301262
    //   1248: invokevirtual d : (I)Landroid/view/View;
    //   1251: new com/soft/blued/ui/circle/adapter/CircleMainDetailCommentAdapter$5
    //   1254: dup
    //   1255: aload_0
    //   1256: aload #14
    //   1258: invokespecial <init> : (Lcom/soft/blued/ui/circle/adapter/CircleMainDetailCommentAdapter;Lcom/soft/blued/ui/feed/model/FeedComment;)V
    //   1261: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   1264: aload_1
    //   1265: ldc_w 2131301261
    //   1268: invokevirtual d : (I)Landroid/view/View;
    //   1271: checkcast android/widget/TextView
    //   1274: aload #12
    //   1276: iconst_0
    //   1277: aload_0
    //   1278: getfield b : Ljava/lang/String;
    //   1281: invokestatic a : (Landroid/widget/TextView;Ljava/lang/CharSequence;ILjava/lang/String;)V
    //   1284: aload_1
    //   1285: ldc_w 2131299053
    //   1288: iconst_1
    //   1289: invokevirtual b : (IZ)Lcom/chad/library/adapter/base/BaseViewHolder;
    //   1292: pop
    //   1293: goto -> 1317
    //   1296: aload_1
    //   1297: ldc_w 2131299053
    //   1300: iconst_0
    //   1301: invokevirtual b : (IZ)Lcom/chad/library/adapter/base/BaseViewHolder;
    //   1304: pop
    //   1305: goto -> 1317
    //   1308: aload_1
    //   1309: ldc_w 2131299053
    //   1312: iconst_0
    //   1313: invokevirtual b : (IZ)Lcom/chad/library/adapter/base/BaseViewHolder;
    //   1316: pop
    //   1317: aload_2
    //   1318: getfield comments_count : I
    //   1321: iconst_2
    //   1322: if_icmple -> 1404
    //   1325: aload_0
    //   1326: getfield k : Landroid/content/Context;
    //   1329: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   1332: ldc_w 2131758582
    //   1335: invokevirtual getString : (I)Ljava/lang/String;
    //   1338: astore #12
    //   1340: new java/lang/StringBuilder
    //   1343: dup
    //   1344: invokespecial <init> : ()V
    //   1347: astore #13
    //   1349: aload #13
    //   1351: aload_2
    //   1352: getfield comments_count : I
    //   1355: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1358: pop
    //   1359: aload #13
    //   1361: ldc ''
    //   1363: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1366: pop
    //   1367: aload_1
    //   1368: ldc_w 2131301260
    //   1371: aload #12
    //   1373: iconst_1
    //   1374: anewarray java/lang/Object
    //   1377: dup
    //   1378: iconst_0
    //   1379: aload #13
    //   1381: invokevirtual toString : ()Ljava/lang/String;
    //   1384: aastore
    //   1385: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1388: invokevirtual a : (ILjava/lang/CharSequence;)Lcom/chad/library/adapter/base/BaseViewHolder;
    //   1391: pop
    //   1392: aload_1
    //   1393: ldc_w 2131298959
    //   1396: iconst_1
    //   1397: invokevirtual b : (IZ)Lcom/chad/library/adapter/base/BaseViewHolder;
    //   1400: pop
    //   1401: goto -> 1413
    //   1404: aload_1
    //   1405: ldc_w 2131298959
    //   1408: iconst_0
    //   1409: invokevirtual b : (IZ)Lcom/chad/library/adapter/base/BaseViewHolder;
    //   1412: pop
    //   1413: aload_1
    //   1414: ldc_w 2131301258
    //   1417: invokevirtual d : (I)Landroid/view/View;
    //   1420: checkcast android/widget/TextView
    //   1423: invokestatic a : ()Lcom/soft/blued/customview/CustomLinkMovementMethod;
    //   1426: invokevirtual setMovementMethod : (Landroid/text/method/MovementMethod;)V
    //   1429: aload_1
    //   1430: ldc_w 2131301261
    //   1433: invokevirtual d : (I)Landroid/view/View;
    //   1436: checkcast android/widget/TextView
    //   1439: invokestatic a : ()Lcom/soft/blued/customview/CustomLinkMovementMethod;
    //   1442: invokevirtual setMovementMethod : (Landroid/text/method/MovementMethod;)V
    //   1445: aload_1
    //   1446: ldc_w 2131296766
    //   1449: iconst_1
    //   1450: invokevirtual b : (IZ)Lcom/chad/library/adapter/base/BaseViewHolder;
    //   1453: pop
    //   1454: aload_1
    //   1455: ldc_w 2131299051
    //   1458: invokevirtual c : (I)Lcom/chad/library/adapter/base/BaseViewHolder;
    //   1461: ldc_w 2131301258
    //   1464: invokevirtual c : (I)Lcom/chad/library/adapter/base/BaseViewHolder;
    //   1467: ldc_w 2131301261
    //   1470: invokevirtual c : (I)Lcom/chad/library/adapter/base/BaseViewHolder;
    //   1473: pop
    //   1474: goto -> 1486
    //   1477: aload_1
    //   1478: ldc_w 2131296766
    //   1481: iconst_0
    //   1482: invokevirtual b : (IZ)Lcom/chad/library/adapter/base/BaseViewHolder;
    //   1485: pop
    //   1486: aload_1
    //   1487: ldc_w 2131297362
    //   1490: invokevirtual d : (I)Landroid/view/View;
    //   1493: checkcast android/widget/ImageView
    //   1496: astore #12
    //   1498: new com/soft/blued/ui/circle/adapter/CircleMainDetailCommentAdapter$6
    //   1501: dup
    //   1502: aload_0
    //   1503: aload_2
    //   1504: aload #12
    //   1506: invokespecial <init> : (Lcom/soft/blued/ui/circle/adapter/CircleMainDetailCommentAdapter;Lcom/soft/blued/ui/feed/model/FeedComment;Landroid/widget/ImageView;)V
    //   1509: astore #13
    //   1511: aload_1
    //   1512: ldc_w 2131299358
    //   1515: invokevirtual d : (I)Landroid/view/View;
    //   1518: aload #13
    //   1520: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   1523: aload #12
    //   1525: aload #13
    //   1527: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   1530: aload_1
    //   1531: ldc_w 2131298890
    //   1534: invokevirtual d : (I)Landroid/view/View;
    //   1537: checkcast android/widget/LinearLayout
    //   1540: astore #14
    //   1542: aload_2
    //   1543: getfield comment_pics : [Ljava/lang/String;
    //   1546: ifnull -> 1951
    //   1549: aload_2
    //   1550: getfield comment_pics : [Ljava/lang/String;
    //   1553: arraylength
    //   1554: ifle -> 1951
    //   1557: aload #14
    //   1559: iconst_0
    //   1560: invokevirtual setVisibility : (I)V
    //   1563: aload_0
    //   1564: getfield k : Landroid/content/Context;
    //   1567: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   1570: invokevirtual getDisplayMetrics : ()Landroid/util/DisplayMetrics;
    //   1573: getfield widthPixels : I
    //   1576: istore #5
    //   1578: new com/blued/android/core/imagecache/LoadOptions
    //   1581: dup
    //   1582: invokespecial <init> : ()V
    //   1585: astore #12
    //   1587: aload #12
    //   1589: ldc_w 2131231369
    //   1592: putfield d : I
    //   1595: aload #12
    //   1597: ldc_w 2131231369
    //   1600: putfield b : I
    //   1603: iload #5
    //   1605: iconst_1
    //   1606: ishr
    //   1607: istore #5
    //   1609: aload #12
    //   1611: iload #5
    //   1613: iload #5
    //   1615: invokevirtual a : (II)Lcom/blued/android/core/imagecache/LoadOptions;
    //   1618: pop
    //   1619: getstatic com/blued/android/core/AppInfo.l : I
    //   1622: invokestatic d : ()Landroid/content/Context;
    //   1625: ldc_w 74.0
    //   1628: invokestatic a : (Landroid/content/Context;F)I
    //   1631: isub
    //   1632: istore #5
    //   1634: iload #5
    //   1636: i2d
    //   1637: dstore_3
    //   1638: ldc2_w 1.5
    //   1641: dload_3
    //   1642: dmul
    //   1643: d2i
    //   1644: istore #6
    //   1646: dload_3
    //   1647: ldc2_w 0.73
    //   1650: dmul
    //   1651: d2i
    //   1652: istore #7
    //   1654: aload #14
    //   1656: invokevirtual removeAllViews : ()V
    //   1659: iconst_0
    //   1660: istore #8
    //   1662: iload #8
    //   1664: aload_2
    //   1665: getfield comment_pics : [Ljava/lang/String;
    //   1668: arraylength
    //   1669: if_icmpge -> 1958
    //   1672: aload_2
    //   1673: getfield comment_pics_width : [Ljava/lang/String;
    //   1676: iload #8
    //   1678: aaload
    //   1679: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Integer;
    //   1682: invokevirtual intValue : ()I
    //   1685: aload_2
    //   1686: getfield comment_pics_height : [Ljava/lang/String;
    //   1689: iload #8
    //   1691: aaload
    //   1692: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Integer;
    //   1695: invokevirtual intValue : ()I
    //   1698: iload #5
    //   1700: iload #6
    //   1702: iload #5
    //   1704: iload #7
    //   1706: invokestatic a : (IIIIII)[I
    //   1709: astore #15
    //   1711: aload_0
    //   1712: getfield k : Landroid/content/Context;
    //   1715: invokestatic from : (Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   1718: ldc_w 2131493491
    //   1721: aconst_null
    //   1722: invokevirtual inflate : (ILandroid/view/ViewGroup;)Landroid/view/View;
    //   1725: astore #16
    //   1727: aload #16
    //   1729: ldc_w 2131296747
    //   1732: invokevirtual findViewById : (I)Landroid/view/View;
    //   1735: checkcast android/widget/ImageView
    //   1738: astore #13
    //   1740: aload #16
    //   1742: ldc_w 2131296745
    //   1745: invokevirtual findViewById : (I)Landroid/view/View;
    //   1748: checkcast com/blued/android/framework/view/shape/ShapeTextView
    //   1751: astore #17
    //   1753: aload_2
    //   1754: getfield comment_pics_height : [Ljava/lang/String;
    //   1757: ifnull -> 1812
    //   1760: aload_2
    //   1761: getfield comment_pics_height : [Ljava/lang/String;
    //   1764: arraylength
    //   1765: iload #8
    //   1767: if_icmple -> 1812
    //   1770: aload_2
    //   1771: getfield comment_pics_height : [Ljava/lang/String;
    //   1774: iload #8
    //   1776: aaload
    //   1777: invokestatic c : (Ljava/lang/String;)I
    //   1780: i2d
    //   1781: getstatic com/blued/android/core/AppInfo.m : I
    //   1784: i2d
    //   1785: ldc2_w 1.5
    //   1788: dmul
    //   1789: dcmpl
    //   1790: ifle -> 1802
    //   1793: aload #17
    //   1795: iconst_0
    //   1796: invokevirtual setVisibility : (I)V
    //   1799: goto -> 1819
    //   1802: aload #17
    //   1804: bipush #8
    //   1806: invokevirtual setVisibility : (I)V
    //   1809: goto -> 1819
    //   1812: aload #17
    //   1814: bipush #8
    //   1816: invokevirtual setVisibility : (I)V
    //   1819: new android/widget/FrameLayout$LayoutParams
    //   1822: dup
    //   1823: aload #15
    //   1825: iconst_0
    //   1826: iaload
    //   1827: aload #15
    //   1829: iconst_1
    //   1830: iaload
    //   1831: invokespecial <init> : (II)V
    //   1834: astore #17
    //   1836: iload #8
    //   1838: aload_2
    //   1839: getfield comment_pics : [Ljava/lang/String;
    //   1842: arraylength
    //   1843: iconst_1
    //   1844: isub
    //   1845: if_icmpeq -> 1863
    //   1848: aload #17
    //   1850: aload_0
    //   1851: getfield k : Landroid/content/Context;
    //   1854: ldc_w 10.0
    //   1857: invokestatic a : (Landroid/content/Context;F)I
    //   1860: putfield bottomMargin : I
    //   1863: aload #13
    //   1865: aload #17
    //   1867: invokevirtual setLayoutParams : (Landroid/view/ViewGroup$LayoutParams;)V
    //   1870: aload_0
    //   1871: getfield c : Lcom/blued/android/core/net/IRequestHost;
    //   1874: aload_2
    //   1875: getfield comment_pics : [Ljava/lang/String;
    //   1878: iload #8
    //   1880: aaload
    //   1881: aload #15
    //   1883: iload #8
    //   1885: iaload
    //   1886: invokestatic a : (Ljava/lang/String;I)Ljava/lang/String;
    //   1889: invokestatic a : (Lcom/blued/android/core/net/IRequestHost;Ljava/lang/String;)Lcom/blued/android/core/image/ImageWrapper;
    //   1892: ldc_w 6.0
    //   1895: invokevirtual a : (F)Lcom/blued/android/core/image/ImageWrapper;
    //   1898: aload #13
    //   1900: invokevirtual a : (Landroid/widget/ImageView;)V
    //   1903: aload #14
    //   1905: aload #16
    //   1907: invokevirtual addView : (Landroid/view/View;)V
    //   1910: aload #13
    //   1912: new com/soft/blued/ui/circle/adapter/CircleMainDetailCommentAdapter$7
    //   1915: dup
    //   1916: aload_0
    //   1917: aload_2
    //   1918: iload #8
    //   1920: aload #12
    //   1922: aload_1
    //   1923: invokespecial <init> : (Lcom/soft/blued/ui/circle/adapter/CircleMainDetailCommentAdapter;Lcom/soft/blued/ui/feed/model/FeedComment;ILcom/blued/android/core/imagecache/LoadOptions;Lcom/chad/library/adapter/base/BaseViewHolder;)V
    //   1926: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   1929: iload #8
    //   1931: iconst_1
    //   1932: iadd
    //   1933: istore #8
    //   1935: goto -> 1662
    //   1938: ldc_w '图片越界'
    //   1941: iconst_0
    //   1942: anewarray java/lang/Object
    //   1945: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   1948: goto -> 1958
    //   1951: aload #14
    //   1953: bipush #8
    //   1955: invokevirtual setVisibility : (I)V
    //   1958: aload_0
    //   1959: aload_1
    //   1960: ldc_w 2131299696
    //   1963: invokevirtual d : (I)Landroid/view/View;
    //   1966: aload_2
    //   1967: invokespecial a : (Landroid/view/View;Lcom/soft/blued/ui/feed/model/FeedComment;)V
    //   1970: aload_1
    //   1971: ldc_w 2131299696
    //   1974: invokevirtual c : (I)Lcom/chad/library/adapter/base/BaseViewHolder;
    //   1977: pop
    //   1978: aload_1
    //   1979: ldc_w 2131296797
    //   1982: invokevirtual d : (I)Landroid/view/View;
    //   1985: astore #12
    //   1987: aload_2
    //   1988: getfield anchor_point : I
    //   1991: iconst_1
    //   1992: if_icmpne -> 2010
    //   1995: aload #12
    //   1997: iconst_0
    //   1998: invokevirtual setVisibility : (I)V
    //   2001: aload_0
    //   2002: aload #12
    //   2004: putfield i : Landroid/view/View;
    //   2007: goto -> 2017
    //   2010: aload #12
    //   2012: bipush #8
    //   2014: invokevirtual setVisibility : (I)V
    //   2017: aload_1
    //   2018: ldc_w 2131299645
    //   2021: invokevirtual d : (I)Landroid/view/View;
    //   2024: astore #12
    //   2026: aload_1
    //   2027: ldc_w 2131296766
    //   2030: invokevirtual d : (I)Landroid/view/View;
    //   2033: invokevirtual getVisibility : ()I
    //   2036: ifne -> 2126
    //   2039: aload_2
    //   2040: getfield comments : Ljava/util/List;
    //   2043: invokeinterface iterator : ()Ljava/util/Iterator;
    //   2048: astore_1
    //   2049: aload_1
    //   2050: invokeinterface hasNext : ()Z
    //   2055: ifeq -> 2093
    //   2058: aload_1
    //   2059: invokeinterface next : ()Ljava/lang/Object;
    //   2064: checkcast com/soft/blued/ui/feed/model/FeedComment
    //   2067: astore #13
    //   2069: aload #13
    //   2071: getfield anchor_point : I
    //   2074: iconst_1
    //   2075: if_icmpne -> 2049
    //   2078: aload_0
    //   2079: aload #13
    //   2081: getfield comment_id : Ljava/lang/String;
    //   2084: putfield f : Ljava/lang/String;
    //   2087: iconst_1
    //   2088: istore #5
    //   2090: goto -> 2096
    //   2093: iconst_0
    //   2094: istore #5
    //   2096: iload #5
    //   2098: ifeq -> 2116
    //   2101: aload #12
    //   2103: iconst_0
    //   2104: invokevirtual setVisibility : (I)V
    //   2107: aload_0
    //   2108: aload #12
    //   2110: putfield i : Landroid/view/View;
    //   2113: goto -> 2126
    //   2116: aload #12
    //   2118: bipush #8
    //   2120: invokevirtual setVisibility : (I)V
    //   2123: goto -> 2126
    //   2126: aload_2
    //   2127: getfield isShowUrlVisited : Z
    //   2130: ifne -> 2257
    //   2133: getstatic com/blued/das/client/feed/FeedProtos$Event.CIRCLE_NOTE_COMMENT_DRAW : Lcom/blued/das/client/feed/FeedProtos$Event;
    //   2136: astore_1
    //   2137: aload_2
    //   2138: getfield comment_id : Ljava/lang/String;
    //   2141: astore #12
    //   2143: getstatic com/blued/das/client/feed/FeedProtos$NoteSource.NOTE_DETAIL : Lcom/blued/das/client/feed/FeedProtos$NoteSource;
    //   2146: astore #13
    //   2148: aload_2
    //   2149: getfield feed_id : Ljava/lang/String;
    //   2152: astore #14
    //   2154: aload_2
    //   2155: getfield circle_id : Ljava/lang/String;
    //   2158: astore #15
    //   2160: aload_2
    //   2161: getfield comment_content : Ljava/lang/String;
    //   2164: invokestatic a : (Ljava/lang/CharSequence;)Z
    //   2167: istore #11
    //   2169: aload_2
    //   2170: invokestatic a : (Lcom/soft/blued/ui/feed/model/FeedComment;)Lcom/blued/das/client/feed/FeedProtos$FeedClass;
    //   2173: astore #16
    //   2175: aload_0
    //   2176: getfield d : Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;
    //   2179: invokestatic b : (Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;)Lcom/blued/das/client/feed/FeedProtos$NoteType;
    //   2182: astore #17
    //   2184: aload_0
    //   2185: getfield d : Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;
    //   2188: astore #18
    //   2190: aload #18
    //   2192: ifnull -> 2210
    //   2195: aload #18
    //   2197: getfield is_anonym : I
    //   2200: iconst_1
    //   2201: if_icmpne -> 2210
    //   2204: iconst_1
    //   2205: istore #9
    //   2207: goto -> 2213
    //   2210: iconst_0
    //   2211: istore #9
    //   2213: aload_2
    //   2214: getfield is_anonym : I
    //   2217: iconst_1
    //   2218: if_icmpne -> 2227
    //   2221: iconst_1
    //   2222: istore #10
    //   2224: goto -> 2230
    //   2227: iconst_0
    //   2228: istore #10
    //   2230: aload_1
    //   2231: aload #12
    //   2233: aload #13
    //   2235: aload #14
    //   2237: aload #15
    //   2239: iload #11
    //   2241: aload #16
    //   2243: aload #17
    //   2245: iload #9
    //   2247: iload #10
    //   2249: invokestatic a : (Lcom/blued/das/client/feed/FeedProtos$Event;Ljava/lang/String;Lcom/blued/das/client/feed/FeedProtos$NoteSource;Ljava/lang/String;Ljava/lang/String;ZLcom/blued/das/client/feed/FeedProtos$FeedClass;Lcom/blued/das/client/feed/FeedProtos$NoteType;ZZ)V
    //   2252: aload_2
    //   2253: iconst_1
    //   2254: putfield isShowUrlVisited : Z
    //   2257: return
    //   2258: astore #12
    //   2260: goto -> 1938
    // Exception table:
    //   from	to	target	type
    //   1654	1659	2258	finally
    //   1662	1799	2258	finally
    //   1802	1809	2258	finally
    //   1812	1819	2258	finally
    //   1819	1863	2258	finally
    //   1863	1929	2258	finally
  }
  
  public void a(FeedComment paramFeedComment) {
    String str = paramFeedComment.comment_content;
    if (Build.VERSION.SDK_INT >= 11 && Build.VERSION.SDK_INT != 18) {
      ((ClipboardManager)this.k.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("simple text", RegExpUtils.a(str)));
    } else {
      ((ClipboardManager)this.k.getSystemService("clipboard")).setText(RegExpUtils.a(str));
    } 
    AppMethods.a(this.k.getResources().getString(2131756130));
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
    if (paramFeedComment != null) {
      paramFeedComment.vbadge = paramFeedComment.user_vbadge;
      if (!TextUtils.isEmpty(paramString))
        for (int i = 0; i < n().size(); i++) {
          FeedComment feedComment = n().get(i);
          if (paramString.equals(feedComment.comment_id)) {
            if (feedComment.comments == null)
              feedComment.comments = new ArrayList(); 
            feedComment.comments_count++;
            feedComment.comments.add(0, paramFeedComment);
            // Byte code: goto -> 117
          } 
        }  
      byte b = -1;
      if (b != -1)
        notifyItemChanged(b + o()); 
    } 
  }
  
  public void a(String paramString) {
    Log.v("drb", "circle comment notifyCommentDeleted");
    if (!StringUtils.e(paramString) && n() != null && n().size() > 0) {
      for (int i = 0; i < n().size(); i++) {
        if (paramString.equals(((FeedComment)n().get(i)).comment_id) && ((FeedComment)n().get(i)).isLastHotComment) {
          int j = i - 1;
          if (j >= 0) {
            ((FeedComment)n().get(j)).isLastHotComment = ((FeedComment)n().get(i)).isLastHotComment;
            ((FeedComment)n().get(j)).isHasMoreHotComment = ((FeedComment)n().get(i)).isHasMoreHotComment;
            break;
          } 
        } 
      } 
      Iterator iterator = n().iterator();
      while (iterator.hasNext()) {
        if (paramString.equals(((FeedComment)iterator.next()).comment_id)) {
          Log.v("drb", "circle comment iter.remove()");
          iterator.remove();
        } 
      } 
      notifyDataSetChanged();
    } 
  }
  
  public void a(String paramString, int paramInt) {}
  
  public void b() {
    View view = this.i;
    if (view != null) {
      view.setVisibility(0);
      this.i.setAlpha(0.1F);
      ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(this.i, "alpha", new float[] { 0.1F, 0.0F });
      objectAnimator.setDuration(3000L);
      objectAnimator.setStartDelay(3000L);
      objectAnimator.start();
    } 
  }
  
  public void b(FeedComment paramFeedComment) {
    StringBuilder stringBuilder;
    String str = this.k.getString(2131756931);
    CharSequence charSequence = StringUtils.a(paramFeedComment.comment_content, false, true, false, "CIRCLE_NOTE_DETAIL");
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
    charSequence = String.format(this.k.getResources().getString(2131756179), new Object[] { charSequence });
    CommonAlertDialog.a(this.k, str, (String)charSequence, this.k.getResources().getString(2131756176), new DialogInterface.OnClickListener(this, paramFeedComment) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            String str1 = this.a.feed_id;
            String str2 = this.a.comment_id;
            FeedHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>(this) {
                  protected BluedEntityA<Object> a(String param2String) {
                    return (BluedEntityA<Object>)super.parseData(param2String);
                  }
                  
                  public void a(BluedEntityA<Object> param2BluedEntityA) {
                    if (!CircleMainDetailCommentAdapter.s(this.a.b)) {
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
                }false, str1, str2, this.b.d.is_ads, this.b.c);
          }
        }this.k.getResources().getString(2131756057), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {}
        },  null);
  }
  
  public void c() {
    View view = this.i;
    if (view != null) {
      view.setVisibility(8);
      this.i.clearAnimation();
    } 
  }
  
  public void c(List<FeedComment> paramList) {
    this.h.clear();
    if (this.n != null && this.n.size() > 0) {
      this.n.clear();
    } else {
      this.n = new ArrayList();
    } 
    if (paramList != null)
      this.n.addAll(a(paramList)); 
    notifyDataSetChanged();
  }
  
  public void d() {
    CommentListDataObserver.a().a(this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\adapter\CircleMainDetailCommentAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */