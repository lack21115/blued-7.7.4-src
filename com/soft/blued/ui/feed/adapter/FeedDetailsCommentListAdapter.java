package com.soft.blued.ui.feed.adapter;

import android.animation.ObjectAnimator;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.ClipboardManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.RegExpUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.das.client.feed.FeedProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.customview.ActionSheet;
import com.soft.blued.http.FeedHttpUtils;
import com.soft.blued.log.model.LogData;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.feed.fragment.CommentFragment;
import com.soft.blued.ui.feed.fragment.HotCommentsFragment;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.feed.model.FeedComment;
import com.soft.blued.ui.feed.observer.CommentListDataObserver;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.user.fragment.ReportFragmentNew;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.PopMenuUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import com.soft.blued.view.tip.CommonShowBottomWindow;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class FeedDetailsCommentListAdapter extends BaseQuickAdapter<FeedComment, BaseViewHolder> implements CommentListDataObserver.ICommentDataObserver {
  public String a = "";
  
  private Context b;
  
  private IRequestHost c;
  
  private BluedIngSelfFeed d;
  
  private boolean e = true;
  
  private String f;
  
  private int g = -1;
  
  private HashSet<String> h = new HashSet<String>();
  
  private View i;
  
  private FeedCommentListener o;
  
  public FeedDetailsCommentListAdapter(Context paramContext, IRequestHost paramIRequestHost, String paramString) {
    super(2131493504);
    this.b = paramContext;
    this.c = paramIRequestHost;
    this.f = paramString;
  }
  
  private boolean A() {
    return this.f.equals("feed_comment_floor");
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
              arrayList.add(FeedDetailsCommentListAdapter.a(this.b).getResources().getString(2131758501));
              if (!this.a.comment_uid.equals(UserInfo.a().i().getUid()))
                arrayList.add(FeedDetailsCommentListAdapter.a(this.b).getResources().getString(2131758584)); 
              if ("1".equals(this.a.comment_allow_delete))
                arrayList.add(FeedDetailsCommentListAdapter.a(this.b).getResources().getString(2131756176)); 
              CommonShowBottomWindow.a((FragmentActivity)FeedDetailsCommentListAdapter.a(this.b), arrayList.<String>toArray(new String[arrayList.size()]), new ActionSheet.ActionSheetListener(this) {
                    public void a(ActionSheet param2ActionSheet, int param2Int) {
                      String str = param2ActionSheet.a(param2Int);
                      if (str.equals(FeedDetailsCommentListAdapter.a(this.a.b).getResources().getString(2131758501))) {
                        this.a.b.a(this.a.a);
                        return;
                      } 
                      if (str.equals(FeedDetailsCommentListAdapter.a(this.a.b).getResources().getString(2131756176))) {
                        this.a.b.b(this.a.a);
                        return;
                      } 
                      if (str.equals(FeedDetailsCommentListAdapter.a(this.a.b).getResources().getString(2131758584)))
                        ReportFragmentNew.a(FeedDetailsCommentListAdapter.a(this.a.b), this.a.a.comment_id, this.a.a.feed_id, this.a.a.user_name); 
                    }
                    
                    public void a(ActionSheet param2ActionSheet, boolean param2Boolean) {}
                  });
              return true;
            }
          }); 
  }
  
  private void a(FeedComment paramFeedComment, ImageView paramImageView, TextView paramTextView) {
    boolean bool;
    if (A()) {
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
    if (!A()) {
      CommentListDataObserver.a().a(str1, bool);
    } else {
      a(str1, bool);
    } 
    FeedHttpUtils.a(str2, str1, bool, null, this.c, true);
  }
  
  public void a() {
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
  
  public void a(int paramInt) {
    this.g = paramInt;
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, FeedComment paramFeedComment) {
    if (paramBaseViewHolder != null) {
      int i = paramBaseViewHolder.getAdapterPosition();
      int j = o();
      (new CommentViewHolder(this, paramBaseViewHolder.z())).a(paramFeedComment, i - j);
    } 
  }
  
  public void a(FeedCommentListener paramFeedCommentListener) {
    this.o = paramFeedCommentListener;
  }
  
  public void a(BluedIngSelfFeed paramBluedIngSelfFeed) {
    this.d = paramBluedIngSelfFeed;
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
  
  public void a(FeedComment paramFeedComment, String paramString) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 312
    //   4: aload_0
    //   5: getfield e : Z
    //   8: ifeq -> 312
    //   11: aload_0
    //   12: getfield d : Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;
    //   15: ifnull -> 312
    //   18: aload_1
    //   19: getfield feed_id : Ljava/lang/String;
    //   22: aload_0
    //   23: getfield d : Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;
    //   26: getfield feed_id : Ljava/lang/String;
    //   29: invokevirtual equals : (Ljava/lang/Object;)Z
    //   32: ifeq -> 312
    //   35: aload_1
    //   36: aload_1
    //   37: getfield user_vbadge : I
    //   40: putfield vbadge : I
    //   43: aload_0
    //   44: invokespecial A : ()Z
    //   47: ifeq -> 131
    //   50: iconst_0
    //   51: istore_3
    //   52: iload_3
    //   53: aload_0
    //   54: getfield n : Ljava/util/List;
    //   57: invokeinterface size : ()I
    //   62: if_icmpge -> 94
    //   65: aload_0
    //   66: getfield n : Ljava/util/List;
    //   69: iload_3
    //   70: invokeinterface get : (I)Ljava/lang/Object;
    //   75: checkcast com/soft/blued/ui/feed/model/FeedComment
    //   78: getfield isLastHotComment : Z
    //   81: ifeq -> 87
    //   84: goto -> 96
    //   87: iload_3
    //   88: iconst_1
    //   89: iadd
    //   90: istore_3
    //   91: goto -> 52
    //   94: iconst_m1
    //   95: istore_3
    //   96: iload_3
    //   97: iconst_m1
    //   98: if_icmpne -> 115
    //   101: aload_0
    //   102: getfield n : Ljava/util/List;
    //   105: iconst_0
    //   106: aload_1
    //   107: invokeinterface add : (ILjava/lang/Object;)V
    //   112: goto -> 308
    //   115: aload_0
    //   116: getfield n : Ljava/util/List;
    //   119: iload_3
    //   120: iconst_1
    //   121: iadd
    //   122: aload_1
    //   123: invokeinterface add : (ILjava/lang/Object;)V
    //   128: goto -> 308
    //   131: aload_2
    //   132: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   135: ifne -> 230
    //   138: aload_0
    //   139: getfield n : Ljava/util/List;
    //   142: invokeinterface iterator : ()Ljava/util/Iterator;
    //   147: astore #4
    //   149: aload #4
    //   151: invokeinterface hasNext : ()Z
    //   156: ifeq -> 308
    //   159: aload #4
    //   161: invokeinterface next : ()Ljava/lang/Object;
    //   166: checkcast com/soft/blued/ui/feed/model/FeedComment
    //   169: astore #5
    //   171: aload_2
    //   172: aload #5
    //   174: getfield comment_id : Ljava/lang/String;
    //   177: invokevirtual equals : (Ljava/lang/Object;)Z
    //   180: ifeq -> 149
    //   183: aload #5
    //   185: getfield comments : Ljava/util/List;
    //   188: ifnonnull -> 203
    //   191: aload #5
    //   193: new java/util/ArrayList
    //   196: dup
    //   197: invokespecial <init> : ()V
    //   200: putfield comments : Ljava/util/List;
    //   203: aload #5
    //   205: aload #5
    //   207: getfield comments_count : I
    //   210: iconst_1
    //   211: iadd
    //   212: putfield comments_count : I
    //   215: aload #5
    //   217: getfield comments : Ljava/util/List;
    //   220: iconst_0
    //   221: aload_1
    //   222: invokeinterface add : (ILjava/lang/Object;)V
    //   227: goto -> 308
    //   230: iconst_0
    //   231: istore_3
    //   232: iload_3
    //   233: aload_0
    //   234: getfield n : Ljava/util/List;
    //   237: invokeinterface size : ()I
    //   242: if_icmpge -> 274
    //   245: aload_0
    //   246: getfield n : Ljava/util/List;
    //   249: iload_3
    //   250: invokeinterface get : (I)Ljava/lang/Object;
    //   255: checkcast com/soft/blued/ui/feed/model/FeedComment
    //   258: getfield isLastHotComment : Z
    //   261: ifeq -> 267
    //   264: goto -> 276
    //   267: iload_3
    //   268: iconst_1
    //   269: iadd
    //   270: istore_3
    //   271: goto -> 232
    //   274: iconst_m1
    //   275: istore_3
    //   276: iload_3
    //   277: iconst_m1
    //   278: if_icmpne -> 295
    //   281: aload_0
    //   282: getfield n : Ljava/util/List;
    //   285: iconst_0
    //   286: aload_1
    //   287: invokeinterface add : (ILjava/lang/Object;)V
    //   292: goto -> 308
    //   295: aload_0
    //   296: getfield n : Ljava/util/List;
    //   299: iload_3
    //   300: iconst_1
    //   301: iadd
    //   302: aload_1
    //   303: invokeinterface add : (ILjava/lang/Object;)V
    //   308: aload_0
    //   309: invokevirtual notifyDataSetChanged : ()V
    //   312: aload_1
    //   313: ifnull -> 335
    //   316: aload_0
    //   317: getfield e : Z
    //   320: ifeq -> 335
    //   323: aload_1
    //   324: aload_1
    //   325: getfield user_vbadge : I
    //   328: putfield vbadge : I
    //   331: aload_0
    //   332: invokevirtual notifyDataSetChanged : ()V
    //   335: return
  }
  
  public void a(String paramString) {
    if (!StringUtils.e(paramString) && this.n != null && this.n.size() > 0) {
      for (int i = 0; i < this.n.size(); i++) {
        if (paramString.equals(((FeedComment)this.n.get(i)).comment_id) && ((FeedComment)this.n.get(i)).isLastHotComment) {
          int j = i - 1;
          if (j >= 0) {
            ((FeedComment)this.n.get(j)).isLastHotComment = ((FeedComment)this.n.get(i)).isLastHotComment;
            ((FeedComment)this.n.get(j)).isHasMoreHotComment = ((FeedComment)this.n.get(i)).isHasMoreHotComment;
            break;
          } 
        } 
      } 
      Iterator iterator = this.n.iterator();
      while (iterator.hasNext()) {
        if (paramString.equals(((FeedComment)iterator.next()).comment_id))
          iterator.remove(); 
      } 
      notifyDataSetChanged();
    } 
  }
  
  public void a(String paramString, int paramInt) {
    if (!StringUtils.e(paramString) && this.n != null && this.n.size() > 0) {
      for (int i = 0; i < this.n.size(); i++) {
        if (paramString.equals(((FeedComment)this.n.get(i)).comment_id)) {
          ((FeedComment)this.n.get(i)).iliked = paramInt;
          if (paramInt == 1) {
            FeedComment feedComment = this.n.get(i);
            feedComment.liked_count++;
          } else {
            FeedComment feedComment = this.n.get(i);
            feedComment.liked_count--;
          } 
        } 
      } 
      notifyDataSetChanged();
    } 
  }
  
  public void b() {
    View view = this.i;
    if (view != null) {
      view.setVisibility(8);
      this.i.clearAnimation();
    } 
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
                    if (!FeedDetailsCommentListAdapter.h(this.a.b)) {
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
                }true, str1, str2, (FeedDetailsCommentListAdapter.c(this.b)).is_ads, FeedDetailsCommentListAdapter.e(this.b));
          }
        }this.b.getResources().getString(2131755726), null, null);
  }
  
  public void c() {
    CommentListDataObserver.a().a(this);
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
    CommentListDataObserver.a().b(this);
  }
  
  public class CommentViewHolder {
    private LinearLayout A;
    
    private TextView B;
    
    private View C;
    
    private View D;
    
    private int b;
    
    private View c;
    
    private ImageView d;
    
    private TextView e;
    
    private TextView f;
    
    private TextView g;
    
    private ImageView h;
    
    private ImageView i;
    
    private TextView j;
    
    private View k;
    
    private LinearLayout l;
    
    private TextView m;
    
    private ImageView n;
    
    private ImageView o;
    
    private ImageView p;
    
    private ConstraintLayout q;
    
    private ShapeLinearLayout r;
    
    private LinearLayout s;
    
    private TextView t;
    
    private ImageView u;
    
    private TextView v;
    
    private LinearLayout w;
    
    private TextView x;
    
    private ImageView y;
    
    private TextView z;
    
    public CommentViewHolder(FeedDetailsCommentListAdapter this$0, View param1View) {
      this.c = param1View.findViewById(2131299696);
      this.d = (ImageView)param1View.findViewById(2131297362);
      this.g = (TextView)param1View.findViewById(2131296838);
      this.f = (TextView)param1View.findViewById(2131299358);
      this.e = (TextView)param1View.findViewById(2131300267);
      this.h = (ImageView)param1View.findViewById(2131297575);
      this.i = (ImageView)param1View.findViewById(2131297461);
      this.j = (TextView)param1View.findViewById(2131300653);
      this.k = param1View.findViewById(2131296798);
      this.l = (LinearLayout)param1View.findViewById(2131298958);
      this.m = (TextView)param1View.findViewById(2131301052);
      this.n = (ImageView)param1View.findViewById(2131297429);
      this.o = (ImageView)param1View.findViewById(2131297581);
      this.p = (ImageView)param1View.findViewById(2131297820);
      this.q = (ConstraintLayout)param1View.findViewById(2131296766);
      this.r = (ShapeLinearLayout)param1View.findViewById(2131299051);
      ShapeHelper.b((ShapeHelper.ShapeView)this.r, 2131100881);
      this.s = (LinearLayout)param1View.findViewById(2131299052);
      this.t = (TextView)param1View.findViewById(2131301259);
      this.u = (ImageView)param1View.findViewById(2131297910);
      this.v = (TextView)param1View.findViewById(2131301258);
      this.w = (LinearLayout)param1View.findViewById(2131299053);
      this.x = (TextView)param1View.findViewById(2131301262);
      this.y = (ImageView)param1View.findViewById(2131297911);
      this.z = (TextView)param1View.findViewById(2131301261);
      this.A = (LinearLayout)param1View.findViewById(2131298959);
      this.B = (TextView)param1View.findViewById(2131301260);
      this.C = param1View.findViewById(2131296797);
      this.D = param1View.findViewById(2131299645);
    }
    
    public void a(FeedComment param1FeedComment, int param1Int) {
      // Byte code:
      //   0: aload_0
      //   1: iload_2
      //   2: putfield b : I
      //   5: aload_1
      //   6: getfield iliked : I
      //   9: iconst_1
      //   10: if_icmpne -> 49
      //   13: aload_0
      //   14: getfield i : Landroid/widget/ImageView;
      //   17: ldc_w 2131232450
      //   20: invokevirtual setImageResource : (I)V
      //   23: aload_0
      //   24: getfield j : Landroid/widget/TextView;
      //   27: aload_0
      //   28: getfield a : Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;
      //   31: invokestatic a : (Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;)Landroid/content/Context;
      //   34: invokevirtual getResources : ()Landroid/content/res/Resources;
      //   37: ldc_w 2131100319
      //   40: invokevirtual getColor : (I)I
      //   43: invokevirtual setTextColor : (I)V
      //   46: goto -> 79
      //   49: aload_0
      //   50: getfield i : Landroid/widget/ImageView;
      //   53: ldc_w 2131232449
      //   56: invokevirtual setImageResource : (I)V
      //   59: aload_0
      //   60: getfield j : Landroid/widget/TextView;
      //   63: aload_0
      //   64: getfield a : Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;
      //   67: invokestatic a : (Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;)Landroid/content/Context;
      //   70: ldc_w 2131100842
      //   73: invokestatic a : (Landroid/content/Context;I)I
      //   76: invokevirtual setTextColor : (I)V
      //   79: aload_1
      //   80: getfield liked_count : I
      //   83: ifle -> 153
      //   86: aload_0
      //   87: getfield j : Landroid/widget/TextView;
      //   90: astore_3
      //   91: aload_0
      //   92: getfield a : Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;
      //   95: invokestatic a : (Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;)Landroid/content/Context;
      //   98: astore #4
      //   100: new java/lang/StringBuilder
      //   103: dup
      //   104: invokespecial <init> : ()V
      //   107: astore #5
      //   109: aload #5
      //   111: aload_1
      //   112: getfield liked_count : I
      //   115: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   118: pop
      //   119: aload #5
      //   121: ldc_w ''
      //   124: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   127: pop
      //   128: aload_3
      //   129: aload #4
      //   131: aload #5
      //   133: invokevirtual toString : ()Ljava/lang/String;
      //   136: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
      //   139: invokevirtual setText : (Ljava/lang/CharSequence;)V
      //   142: aload_0
      //   143: getfield j : Landroid/widget/TextView;
      //   146: iconst_0
      //   147: invokevirtual setVisibility : (I)V
      //   150: goto -> 162
      //   153: aload_0
      //   154: getfield j : Landroid/widget/TextView;
      //   157: bipush #8
      //   159: invokevirtual setVisibility : (I)V
      //   162: aload_0
      //   163: getfield i : Landroid/widget/ImageView;
      //   166: new com/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter$CommentViewHolder$1
      //   169: dup
      //   170: aload_0
      //   171: aload_1
      //   172: invokespecial <init> : (Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter$CommentViewHolder;Lcom/soft/blued/ui/feed/model/FeedComment;)V
      //   175: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
      //   178: aload_0
      //   179: getfield j : Landroid/widget/TextView;
      //   182: new com/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter$CommentViewHolder$2
      //   185: dup
      //   186: aload_0
      //   187: aload_1
      //   188: invokespecial <init> : (Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter$CommentViewHolder;Lcom/soft/blued/ui/feed/model/FeedComment;)V
      //   191: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
      //   194: aload_1
      //   195: getfield isLastHotComment : Z
      //   198: ifeq -> 350
      //   201: aload_0
      //   202: getfield k : Landroid/view/View;
      //   205: bipush #8
      //   207: invokevirtual setVisibility : (I)V
      //   210: aload_0
      //   211: getfield l : Landroid/widget/LinearLayout;
      //   214: astore_3
      //   215: aload_0
      //   216: getfield a : Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;
      //   219: invokestatic b : (Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;)Ljava/lang/String;
      //   222: ldc_w 'feed_detail'
      //   225: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
      //   228: ifeq -> 236
      //   231: iconst_0
      //   232: istore_2
      //   233: goto -> 239
      //   236: bipush #8
      //   238: istore_2
      //   239: aload_3
      //   240: iload_2
      //   241: invokevirtual setVisibility : (I)V
      //   244: aload_1
      //   245: getfield isHasMoreHotComment : Z
      //   248: ifeq -> 300
      //   251: aload_0
      //   252: getfield n : Landroid/widget/ImageView;
      //   255: iconst_0
      //   256: invokevirtual setVisibility : (I)V
      //   259: aload_0
      //   260: getfield m : Landroid/widget/TextView;
      //   263: aload_0
      //   264: getfield a : Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;
      //   267: invokestatic a : (Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;)Landroid/content/Context;
      //   270: invokevirtual getResources : ()Landroid/content/res/Resources;
      //   273: ldc_w 2131757933
      //   276: invokevirtual getString : (I)Ljava/lang/String;
      //   279: invokevirtual setText : (Ljava/lang/CharSequence;)V
      //   282: aload_0
      //   283: getfield l : Landroid/widget/LinearLayout;
      //   286: new com/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter$CommentViewHolder$3
      //   289: dup
      //   290: aload_0
      //   291: invokespecial <init> : (Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter$CommentViewHolder;)V
      //   294: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
      //   297: goto -> 397
      //   300: aload_0
      //   301: getfield m : Landroid/widget/TextView;
      //   304: aload_0
      //   305: getfield a : Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;
      //   308: invokestatic a : (Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;)Landroid/content/Context;
      //   311: invokevirtual getResources : ()Landroid/content/res/Resources;
      //   314: ldc_w 2131755214
      //   317: invokevirtual getString : (I)Ljava/lang/String;
      //   320: invokevirtual setText : (Ljava/lang/CharSequence;)V
      //   323: aload_0
      //   324: getfield n : Landroid/widget/ImageView;
      //   327: bipush #8
      //   329: invokevirtual setVisibility : (I)V
      //   332: aload_0
      //   333: getfield l : Landroid/widget/LinearLayout;
      //   336: new com/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter$CommentViewHolder$4
      //   339: dup
      //   340: aload_0
      //   341: invokespecial <init> : (Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter$CommentViewHolder;)V
      //   344: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
      //   347: goto -> 397
      //   350: iload_2
      //   351: aload_0
      //   352: getfield a : Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;
      //   355: invokestatic d : (Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;)Ljava/util/List;
      //   358: invokeinterface size : ()I
      //   363: iconst_1
      //   364: isub
      //   365: if_icmpne -> 380
      //   368: aload_0
      //   369: getfield k : Landroid/view/View;
      //   372: bipush #8
      //   374: invokevirtual setVisibility : (I)V
      //   377: goto -> 388
      //   380: aload_0
      //   381: getfield k : Landroid/view/View;
      //   384: iconst_0
      //   385: invokevirtual setVisibility : (I)V
      //   388: aload_0
      //   389: getfield l : Landroid/widget/LinearLayout;
      //   392: bipush #8
      //   394: invokevirtual setVisibility : (I)V
      //   397: aload_0
      //   398: getfield h : Landroid/widget/ImageView;
      //   401: aload_1
      //   402: getfield vbadge : I
      //   405: iconst_3
      //   406: invokestatic a : (Landroid/widget/ImageView;II)V
      //   409: aload_0
      //   410: getfield a : Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;
      //   413: invokestatic e : (Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;)Lcom/blued/android/core/net/IRequestHost;
      //   416: iconst_1
      //   417: aload_1
      //   418: getfield user_avatar : Ljava/lang/String;
      //   421: invokestatic a : (ILjava/lang/String;)Ljava/lang/String;
      //   424: invokestatic a : (Lcom/blued/android/core/net/IRequestHost;Ljava/lang/String;)Lcom/blued/android/core/image/ImageWrapper;
      //   427: ldc_w 2131234356
      //   430: invokevirtual a : (I)Lcom/blued/android/core/image/ImageWrapper;
      //   433: invokevirtual c : ()Lcom/blued/android/core/image/ImageWrapper;
      //   436: aload_0
      //   437: getfield d : Landroid/widget/ImageView;
      //   440: invokevirtual a : (Landroid/widget/ImageView;)V
      //   443: aload_1
      //   444: getfield comment_timestamp : Ljava/lang/String;
      //   447: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
      //   450: ifne -> 480
      //   453: aload_0
      //   454: getfield e : Landroid/widget/TextView;
      //   457: aload_0
      //   458: getfield a : Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;
      //   461: invokestatic a : (Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;)Landroid/content/Context;
      //   464: aload_1
      //   465: getfield comment_timestamp : Ljava/lang/String;
      //   468: invokestatic b : (Ljava/lang/String;)J
      //   471: invokestatic i : (Landroid/content/Context;J)Ljava/lang/String;
      //   474: invokevirtual setText : (Ljava/lang/CharSequence;)V
      //   477: goto -> 490
      //   480: aload_0
      //   481: getfield e : Landroid/widget/TextView;
      //   484: ldc_w ''
      //   487: invokevirtual setText : (Ljava/lang/CharSequence;)V
      //   490: aload_1
      //   491: getfield user_name : Ljava/lang/String;
      //   494: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
      //   497: ifne -> 563
      //   500: aload_1
      //   501: getfield note : Ljava/lang/String;
      //   504: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
      //   507: ifne -> 540
      //   510: aload_0
      //   511: getfield f : Landroid/widget/TextView;
      //   514: aload_1
      //   515: getfield note : Ljava/lang/String;
      //   518: aload_1
      //   519: getfield user_name : Ljava/lang/String;
      //   522: ldc_w ':'
      //   525: ldc_w ''
      //   528: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
      //   531: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   534: invokevirtual setText : (Ljava/lang/CharSequence;)V
      //   537: goto -> 573
      //   540: aload_0
      //   541: getfield f : Landroid/widget/TextView;
      //   544: aload_1
      //   545: getfield user_name : Ljava/lang/String;
      //   548: ldc_w ':'
      //   551: ldc_w ''
      //   554: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
      //   557: invokevirtual setText : (Ljava/lang/CharSequence;)V
      //   560: goto -> 573
      //   563: aload_0
      //   564: getfield f : Landroid/widget/TextView;
      //   567: ldc_w ''
      //   570: invokevirtual setText : (Ljava/lang/CharSequence;)V
      //   573: new com/soft/blued/ui/find/model/UserBasicModel
      //   576: dup
      //   577: invokespecial <init> : ()V
      //   580: astore_3
      //   581: aload_3
      //   582: aload_1
      //   583: getfield vip_grade : I
      //   586: putfield vip_grade : I
      //   589: aload_3
      //   590: aload_1
      //   591: getfield is_vip_annual : I
      //   594: putfield is_vip_annual : I
      //   597: aload_3
      //   598: aload_1
      //   599: getfield is_hide_vip_look : I
      //   602: putfield is_hide_vip_look : I
      //   605: aload_3
      //   606: aload_1
      //   607: getfield vip_exp_lvl : I
      //   610: putfield vip_exp_lvl : I
      //   613: aload_0
      //   614: getfield a : Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;
      //   617: invokestatic a : (Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;)Landroid/content/Context;
      //   620: aload_0
      //   621: getfield f : Landroid/widget/TextView;
      //   624: aload_3
      //   625: invokestatic a : (Landroid/content/Context;Landroid/widget/TextView;Lcom/soft/blued/ui/find/model/UserBasicModel;)V
      //   628: aload_0
      //   629: getfield o : Landroid/widget/ImageView;
      //   632: aload_3
      //   633: invokestatic a : (Landroid/widget/ImageView;Lcom/soft/blued/ui/find/model/UserBasicModel;)V
      //   636: aload_0
      //   637: getfield p : Landroid/widget/ImageView;
      //   640: aload_1
      //   641: getfield is_author : I
      //   644: invokestatic a : (Landroid/widget/ImageView;I)V
      //   647: aload_1
      //   648: getfield is_reply : Ljava/lang/String;
      //   651: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
      //   654: ifne -> 742
      //   657: ldc_w '1'
      //   660: aload_1
      //   661: getfield is_reply : Ljava/lang/String;
      //   664: invokevirtual equals : (Ljava/lang/Object;)Z
      //   667: ifeq -> 698
      //   670: aload_0
      //   671: getfield a : Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;
      //   674: invokestatic a : (Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;)Landroid/content/Context;
      //   677: aload_0
      //   678: getfield g : Landroid/widget/TextView;
      //   681: aload_1
      //   682: aload_0
      //   683: getfield a : Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;
      //   686: invokestatic b : (Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;)Ljava/lang/String;
      //   689: ldc_w 2131100716
      //   692: invokestatic a : (Landroid/content/Context;Landroid/widget/TextView;Lcom/soft/blued/ui/feed/model/FeedComment;Ljava/lang/String;I)V
      //   695: goto -> 752
      //   698: ldc_w '0'
      //   701: aload_1
      //   702: getfield is_reply : Ljava/lang/String;
      //   705: invokevirtual equals : (Ljava/lang/Object;)Z
      //   708: ifeq -> 729
      //   711: aload_0
      //   712: getfield g : Landroid/widget/TextView;
      //   715: aload_1
      //   716: aload_0
      //   717: getfield a : Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;
      //   720: invokestatic b : (Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;)Ljava/lang/String;
      //   723: invokestatic a : (Landroid/widget/TextView;Lcom/soft/blued/ui/feed/model/FeedComment;Ljava/lang/String;)V
      //   726: goto -> 752
      //   729: aload_0
      //   730: getfield g : Landroid/widget/TextView;
      //   733: ldc_w ''
      //   736: invokevirtual setText : (Ljava/lang/CharSequence;)V
      //   739: goto -> 752
      //   742: aload_0
      //   743: getfield g : Landroid/widget/TextView;
      //   746: ldc_w ''
      //   749: invokevirtual setText : (Ljava/lang/CharSequence;)V
      //   752: aload_1
      //   753: getfield comments_count : I
      //   756: ifle -> 1387
      //   759: aload_1
      //   760: getfield comments : Ljava/util/List;
      //   763: ifnull -> 1387
      //   766: aload_1
      //   767: getfield comments : Ljava/util/List;
      //   770: invokeinterface size : ()I
      //   775: ifle -> 1387
      //   778: aload_1
      //   779: getfield comments : Ljava/util/List;
      //   782: iconst_0
      //   783: invokeinterface get : (I)Ljava/lang/Object;
      //   788: checkcast com/soft/blued/ui/feed/model/FeedComment
      //   791: astore #5
      //   793: aload #5
      //   795: getfield is_reply : Ljava/lang/String;
      //   798: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
      //   801: ifne -> 846
      //   804: ldc_w '1'
      //   807: aload #5
      //   809: getfield is_reply : Ljava/lang/String;
      //   812: invokevirtual equals : (Ljava/lang/Object;)Z
      //   815: ifeq -> 846
      //   818: aload_0
      //   819: getfield a : Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;
      //   822: invokestatic a : (Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;)Landroid/content/Context;
      //   825: aload_0
      //   826: getfield v : Landroid/widget/TextView;
      //   829: invokevirtual getTextSize : ()F
      //   832: f2i
      //   833: aload #5
      //   835: iconst_2
      //   836: ldc_w 2131100716
      //   839: invokestatic a : (Landroid/content/Context;ILcom/soft/blued/ui/feed/model/FeedComment;II)Ljava/lang/CharSequence;
      //   842: astore_3
      //   843: goto -> 871
      //   846: aload_0
      //   847: getfield a : Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;
      //   850: invokestatic a : (Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;)Landroid/content/Context;
      //   853: aload_0
      //   854: getfield v : Landroid/widget/TextView;
      //   857: invokevirtual getTextSize : ()F
      //   860: f2i
      //   861: aload #5
      //   863: iconst_2
      //   864: ldc_w 2131100716
      //   867: invokestatic b : (Landroid/content/Context;ILcom/soft/blued/ui/feed/model/FeedComment;II)Ljava/lang/CharSequence;
      //   870: astore_3
      //   871: aload_3
      //   872: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
      //   875: ifne -> 975
      //   878: aload_0
      //   879: getfield t : Landroid/widget/TextView;
      //   882: astore #6
      //   884: aload #5
      //   886: getfield note : Ljava/lang/String;
      //   889: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
      //   892: ifne -> 905
      //   895: aload #5
      //   897: getfield note : Ljava/lang/String;
      //   900: astore #4
      //   902: goto -> 912
      //   905: aload #5
      //   907: getfield user_name : Ljava/lang/String;
      //   910: astore #4
      //   912: aload #6
      //   914: aload #4
      //   916: invokevirtual setText : (Ljava/lang/CharSequence;)V
      //   919: aload_0
      //   920: getfield u : Landroid/widget/ImageView;
      //   923: aload #5
      //   925: getfield is_author : I
      //   928: invokestatic a : (Landroid/widget/ImageView;I)V
      //   931: aload_0
      //   932: getfield t : Landroid/widget/TextView;
      //   935: new com/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter$CommentViewHolder$5
      //   938: dup
      //   939: aload_0
      //   940: aload #5
      //   942: invokespecial <init> : (Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter$CommentViewHolder;Lcom/soft/blued/ui/feed/model/FeedComment;)V
      //   945: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
      //   948: aload_0
      //   949: getfield v : Landroid/widget/TextView;
      //   952: aload_3
      //   953: iconst_0
      //   954: aload_0
      //   955: getfield a : Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;
      //   958: invokestatic b : (Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;)Ljava/lang/String;
      //   961: invokestatic a : (Landroid/widget/TextView;Ljava/lang/CharSequence;ILjava/lang/String;)V
      //   964: aload_0
      //   965: getfield s : Landroid/widget/LinearLayout;
      //   968: iconst_0
      //   969: invokevirtual setVisibility : (I)V
      //   972: goto -> 984
      //   975: aload_0
      //   976: getfield s : Landroid/widget/LinearLayout;
      //   979: bipush #8
      //   981: invokevirtual setVisibility : (I)V
      //   984: aload_1
      //   985: getfield comments : Ljava/util/List;
      //   988: invokeinterface size : ()I
      //   993: iconst_1
      //   994: if_icmple -> 1208
      //   997: aload_1
      //   998: getfield comments : Ljava/util/List;
      //   1001: iconst_1
      //   1002: invokeinterface get : (I)Ljava/lang/Object;
      //   1007: checkcast com/soft/blued/ui/feed/model/FeedComment
      //   1010: astore #6
      //   1012: aload #6
      //   1014: getfield is_reply : Ljava/lang/String;
      //   1017: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
      //   1020: ifne -> 1065
      //   1023: ldc_w '1'
      //   1026: aload #6
      //   1028: getfield is_reply : Ljava/lang/String;
      //   1031: invokevirtual equals : (Ljava/lang/Object;)Z
      //   1034: ifeq -> 1065
      //   1037: aload_0
      //   1038: getfield a : Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;
      //   1041: invokestatic a : (Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;)Landroid/content/Context;
      //   1044: aload_0
      //   1045: getfield z : Landroid/widget/TextView;
      //   1048: invokevirtual getTextSize : ()F
      //   1051: f2i
      //   1052: aload #6
      //   1054: iconst_2
      //   1055: ldc_w 2131100716
      //   1058: invokestatic a : (Landroid/content/Context;ILcom/soft/blued/ui/feed/model/FeedComment;II)Ljava/lang/CharSequence;
      //   1061: astore_3
      //   1062: goto -> 1090
      //   1065: aload_0
      //   1066: getfield a : Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;
      //   1069: invokestatic a : (Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;)Landroid/content/Context;
      //   1072: aload_0
      //   1073: getfield z : Landroid/widget/TextView;
      //   1076: invokevirtual getTextSize : ()F
      //   1079: f2i
      //   1080: aload #6
      //   1082: iconst_2
      //   1083: ldc_w 2131100716
      //   1086: invokestatic b : (Landroid/content/Context;ILcom/soft/blued/ui/feed/model/FeedComment;II)Ljava/lang/CharSequence;
      //   1089: astore_3
      //   1090: aload_3
      //   1091: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
      //   1094: ifne -> 1196
      //   1097: aload_0
      //   1098: getfield x : Landroid/widget/TextView;
      //   1101: astore #7
      //   1103: aload #6
      //   1105: getfield note : Ljava/lang/String;
      //   1108: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
      //   1111: ifne -> 1124
      //   1114: aload #6
      //   1116: getfield note : Ljava/lang/String;
      //   1119: astore #4
      //   1121: goto -> 1131
      //   1124: aload #6
      //   1126: getfield user_name : Ljava/lang/String;
      //   1129: astore #4
      //   1131: aload #7
      //   1133: aload #4
      //   1135: invokevirtual setText : (Ljava/lang/CharSequence;)V
      //   1138: aload_0
      //   1139: getfield y : Landroid/widget/ImageView;
      //   1142: aload #6
      //   1144: getfield is_author : I
      //   1147: invokestatic a : (Landroid/widget/ImageView;I)V
      //   1150: aload_0
      //   1151: getfield x : Landroid/widget/TextView;
      //   1154: new com/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter$CommentViewHolder$6
      //   1157: dup
      //   1158: aload_0
      //   1159: aload #5
      //   1161: aload #6
      //   1163: invokespecial <init> : (Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter$CommentViewHolder;Lcom/soft/blued/ui/feed/model/FeedComment;Lcom/soft/blued/ui/feed/model/FeedComment;)V
      //   1166: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
      //   1169: aload_0
      //   1170: getfield z : Landroid/widget/TextView;
      //   1173: aload_3
      //   1174: iconst_0
      //   1175: aload_0
      //   1176: getfield a : Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;
      //   1179: invokestatic b : (Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;)Ljava/lang/String;
      //   1182: invokestatic a : (Landroid/widget/TextView;Ljava/lang/CharSequence;ILjava/lang/String;)V
      //   1185: aload_0
      //   1186: getfield w : Landroid/widget/LinearLayout;
      //   1189: iconst_0
      //   1190: invokevirtual setVisibility : (I)V
      //   1193: goto -> 1217
      //   1196: aload_0
      //   1197: getfield w : Landroid/widget/LinearLayout;
      //   1200: bipush #8
      //   1202: invokevirtual setVisibility : (I)V
      //   1205: goto -> 1217
      //   1208: aload_0
      //   1209: getfield w : Landroid/widget/LinearLayout;
      //   1212: bipush #8
      //   1214: invokevirtual setVisibility : (I)V
      //   1217: aload_1
      //   1218: getfield comments_count : I
      //   1221: iconst_2
      //   1222: if_icmple -> 1306
      //   1225: aload_0
      //   1226: getfield a : Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;
      //   1229: invokestatic a : (Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;)Landroid/content/Context;
      //   1232: invokevirtual getResources : ()Landroid/content/res/Resources;
      //   1235: ldc_w 2131758582
      //   1238: invokevirtual getString : (I)Ljava/lang/String;
      //   1241: astore_3
      //   1242: new java/lang/StringBuilder
      //   1245: dup
      //   1246: invokespecial <init> : ()V
      //   1249: astore #4
      //   1251: aload #4
      //   1253: aload_1
      //   1254: getfield comments_count : I
      //   1257: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   1260: pop
      //   1261: aload #4
      //   1263: ldc_w ''
      //   1266: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1269: pop
      //   1270: aload_3
      //   1271: iconst_1
      //   1272: anewarray java/lang/Object
      //   1275: dup
      //   1276: iconst_0
      //   1277: aload #4
      //   1279: invokevirtual toString : ()Ljava/lang/String;
      //   1282: aastore
      //   1283: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   1286: astore_3
      //   1287: aload_0
      //   1288: getfield B : Landroid/widget/TextView;
      //   1291: aload_3
      //   1292: invokevirtual setText : (Ljava/lang/CharSequence;)V
      //   1295: aload_0
      //   1296: getfield A : Landroid/widget/LinearLayout;
      //   1299: iconst_0
      //   1300: invokevirtual setVisibility : (I)V
      //   1303: goto -> 1315
      //   1306: aload_0
      //   1307: getfield A : Landroid/widget/LinearLayout;
      //   1310: bipush #8
      //   1312: invokevirtual setVisibility : (I)V
      //   1315: aload_0
      //   1316: getfield v : Landroid/widget/TextView;
      //   1319: invokestatic a : ()Lcom/soft/blued/customview/CustomLinkMovementMethod;
      //   1322: invokevirtual setMovementMethod : (Landroid/text/method/MovementMethod;)V
      //   1325: aload_0
      //   1326: getfield z : Landroid/widget/TextView;
      //   1329: invokestatic a : ()Lcom/soft/blued/customview/CustomLinkMovementMethod;
      //   1332: invokevirtual setMovementMethod : (Landroid/text/method/MovementMethod;)V
      //   1335: aload_0
      //   1336: getfield q : Landroidx/constraintlayout/widget/ConstraintLayout;
      //   1339: iconst_0
      //   1340: invokevirtual setVisibility : (I)V
      //   1343: new com/soft/blued/utils/click/SingleClickProxy
      //   1346: dup
      //   1347: new com/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter$CommentViewHolder$7
      //   1350: dup
      //   1351: aload_0
      //   1352: aload_1
      //   1353: invokespecial <init> : (Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter$CommentViewHolder;Lcom/soft/blued/ui/feed/model/FeedComment;)V
      //   1356: invokespecial <init> : (Landroid/view/View$OnClickListener;)V
      //   1359: astore_3
      //   1360: aload_0
      //   1361: getfield r : Lcom/blued/android/framework/view/shape/ShapeLinearLayout;
      //   1364: aload_3
      //   1365: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
      //   1368: aload_0
      //   1369: getfield v : Landroid/widget/TextView;
      //   1372: aload_3
      //   1373: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
      //   1376: aload_0
      //   1377: getfield z : Landroid/widget/TextView;
      //   1380: aload_3
      //   1381: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
      //   1384: goto -> 1396
      //   1387: aload_0
      //   1388: getfield q : Landroidx/constraintlayout/widget/ConstraintLayout;
      //   1391: bipush #8
      //   1393: invokevirtual setVisibility : (I)V
      //   1396: aload_0
      //   1397: getfield d : Landroid/widget/ImageView;
      //   1400: astore_3
      //   1401: aload_0
      //   1402: getfield f : Landroid/widget/TextView;
      //   1405: new com/soft/blued/ui/feed/adapter/-$$Lambda$FeedDetailsCommentListAdapter$CommentViewHolder$UwA7rLTdp2wMl6bt7jF6mTIuPsQ
      //   1408: dup
      //   1409: aload_0
      //   1410: aload_1
      //   1411: aload_3
      //   1412: invokespecial <init> : (Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter$CommentViewHolder;Lcom/soft/blued/ui/feed/model/FeedComment;Landroid/widget/ImageView;)V
      //   1415: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
      //   1418: aload_0
      //   1419: getfield d : Landroid/widget/ImageView;
      //   1422: new com/soft/blued/ui/feed/adapter/-$$Lambda$FeedDetailsCommentListAdapter$CommentViewHolder$p83gZnLtvpGW5Hmo-Y_FW-ZPOxw
      //   1425: dup
      //   1426: aload_0
      //   1427: aload_1
      //   1428: aload_3
      //   1429: invokespecial <init> : (Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter$CommentViewHolder;Lcom/soft/blued/ui/feed/model/FeedComment;Landroid/widget/ImageView;)V
      //   1432: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
      //   1435: aload_0
      //   1436: getfield a : Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;
      //   1439: aload_0
      //   1440: getfield c : Landroid/view/View;
      //   1443: aload_1
      //   1444: invokestatic a : (Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;Landroid/view/View;Lcom/soft/blued/ui/feed/model/FeedComment;)V
      //   1447: aload_0
      //   1448: getfield c : Landroid/view/View;
      //   1451: new com/soft/blued/ui/feed/adapter/-$$Lambda$FeedDetailsCommentListAdapter$CommentViewHolder$ijMumWJhP782h8s0yDshTI9E8Zs
      //   1454: dup
      //   1455: aload_0
      //   1456: aload_1
      //   1457: invokespecial <init> : (Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter$CommentViewHolder;Lcom/soft/blued/ui/feed/model/FeedComment;)V
      //   1460: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
      //   1463: aload_1
      //   1464: getfield anchor_point : I
      //   1467: iconst_1
      //   1468: if_icmpne -> 1494
      //   1471: aload_0
      //   1472: getfield C : Landroid/view/View;
      //   1475: iconst_0
      //   1476: invokevirtual setVisibility : (I)V
      //   1479: aload_0
      //   1480: getfield a : Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;
      //   1483: aload_0
      //   1484: getfield C : Landroid/view/View;
      //   1487: invokestatic a : (Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;Landroid/view/View;)Landroid/view/View;
      //   1490: pop
      //   1491: goto -> 1503
      //   1494: aload_0
      //   1495: getfield C : Landroid/view/View;
      //   1498: bipush #8
      //   1500: invokevirtual setVisibility : (I)V
      //   1503: aload_0
      //   1504: getfield q : Landroidx/constraintlayout/widget/ConstraintLayout;
      //   1507: invokevirtual getVisibility : ()I
      //   1510: ifne -> 1607
      //   1513: aload_1
      //   1514: getfield comments : Ljava/util/List;
      //   1517: invokeinterface iterator : ()Ljava/util/Iterator;
      //   1522: astore_3
      //   1523: aload_3
      //   1524: invokeinterface hasNext : ()Z
      //   1529: ifeq -> 1569
      //   1532: aload_3
      //   1533: invokeinterface next : ()Ljava/lang/Object;
      //   1538: checkcast com/soft/blued/ui/feed/model/FeedComment
      //   1541: astore #4
      //   1543: aload #4
      //   1545: getfield anchor_point : I
      //   1548: iconst_1
      //   1549: if_icmpne -> 1523
      //   1552: aload_0
      //   1553: getfield a : Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;
      //   1556: aload #4
      //   1558: getfield comment_id : Ljava/lang/String;
      //   1561: putfield a : Ljava/lang/String;
      //   1564: iconst_1
      //   1565: istore_2
      //   1566: goto -> 1571
      //   1569: iconst_0
      //   1570: istore_2
      //   1571: iload_2
      //   1572: ifeq -> 1598
      //   1575: aload_0
      //   1576: getfield D : Landroid/view/View;
      //   1579: iconst_0
      //   1580: invokevirtual setVisibility : (I)V
      //   1583: aload_0
      //   1584: getfield a : Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;
      //   1587: aload_0
      //   1588: getfield D : Landroid/view/View;
      //   1591: invokestatic a : (Lcom/soft/blued/ui/feed/adapter/FeedDetailsCommentListAdapter;Landroid/view/View;)Landroid/view/View;
      //   1594: pop
      //   1595: goto -> 1607
      //   1598: aload_0
      //   1599: getfield D : Landroid/view/View;
      //   1602: bipush #8
      //   1604: invokevirtual setVisibility : (I)V
      //   1607: aload_1
      //   1608: getfield isShowUrlVisited : Z
      //   1611: ifne -> 1637
      //   1614: getstatic com/blued/das/client/feed/FeedProtos$Event.FEED_DETAIL_COMMENT_DRAW : Lcom/blued/das/client/feed/FeedProtos$Event;
      //   1617: aload_1
      //   1618: getfield feed_id : Ljava/lang/String;
      //   1621: aload_1
      //   1622: getfield feed_uid : Ljava/lang/String;
      //   1625: aload_1
      //   1626: getfield comment_id : Ljava/lang/String;
      //   1629: invokestatic a : (Lcom/blued/das/client/feed/FeedProtos$Event;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
      //   1632: aload_1
      //   1633: iconst_1
      //   1634: putfield isShowUrlVisited : Z
      //   1637: return
    }
  }
  
  class null implements View.OnClickListener {
    null(FeedDetailsCommentListAdapter this$0, FeedComment param1FeedComment) {}
    
    public void onClick(View param1View) {
      FeedDetailsCommentListAdapter.a(this.b.a, this.a, FeedDetailsCommentListAdapter.CommentViewHolder.a(this.b), FeedDetailsCommentListAdapter.CommentViewHolder.b(this.b));
    }
  }
  
  class null implements View.OnClickListener {
    null(FeedDetailsCommentListAdapter this$0, FeedComment param1FeedComment) {}
    
    public void onClick(View param1View) {
      FeedDetailsCommentListAdapter.a(this.b.a, this.a, FeedDetailsCommentListAdapter.CommentViewHolder.a(this.b), FeedDetailsCommentListAdapter.CommentViewHolder.b(this.b));
    }
  }
  
  class null implements View.OnClickListener {
    null(FeedDetailsCommentListAdapter this$0) {}
    
    public void onClick(View param1View) {
      HotCommentsFragment.a(FeedDetailsCommentListAdapter.a(this.a.a), FeedDetailsCommentListAdapter.c(this.a.a));
    }
  }
  
  class null implements View.OnClickListener {
    null(FeedDetailsCommentListAdapter this$0) {}
    
    public void onClick(View param1View) {}
  }
  
  class null implements View.OnClickListener {
    null(FeedDetailsCommentListAdapter this$0, FeedComment param1FeedComment) {}
    
    public void onClick(View param1View) {
      LogData logData = new LogData();
      logData.I = this.a.feed_id;
      if (!StringUtils.e(this.a.uid)) {
        UserInfoFragmentNew.a(FeedDetailsCommentListAdapter.a(this.b.a), this.a.comment_uid, logData, "feed_detail");
        return;
      } 
      UserInfoFragmentNew.b(FeedDetailsCommentListAdapter.a(this.b.a), this.a.user_name, logData, "feed_detail");
    }
  }
  
  class null implements View.OnClickListener {
    null(FeedDetailsCommentListAdapter this$0, FeedComment param1FeedComment1, FeedComment param1FeedComment2) {}
    
    public void onClick(View param1View) {
      LogData logData = new LogData();
      logData.I = this.a.feed_id;
      if (!StringUtils.e(this.b.uid)) {
        UserInfoFragmentNew.a(FeedDetailsCommentListAdapter.a(this.c.a), this.b.comment_uid, logData, "feed_detail");
        return;
      } 
      UserInfoFragmentNew.b(FeedDetailsCommentListAdapter.a(this.c.a), this.b.user_name, logData, "feed_detail");
    }
  }
  
  class null implements View.OnClickListener {
    null(FeedDetailsCommentListAdapter this$0, FeedComment param1FeedComment) {}
    
    public void onClick(View param1View) {
      EventTrackFeed.c(FeedProtos.Event.FEED_DETAIL_PAGE_SHOW, this.a.feed_id);
      String str = FeedDetailsCommentListAdapter.a(this.b.a).getResources().getString(2131758583);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.a.comments_count);
      stringBuilder.append("");
      str = String.format(str, new Object[] { stringBuilder.toString() });
      CommentFragment.a(FeedDetailsCommentListAdapter.a(this.b.a), str, this.a, FeedDetailsCommentListAdapter.c(this.b.a), this.b.a.a, FeedDetailsCommentListAdapter.f(this.b.a));
    }
  }
  
  public static interface FeedCommentListener {
    void a(FeedComment param1FeedComment);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\adapter\FeedDetailsCommentListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */