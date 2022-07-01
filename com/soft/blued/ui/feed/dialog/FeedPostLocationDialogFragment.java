package com.soft.blued.ui.feed.dialog;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.SearchEditText;
import com.blued.android.module.common.base.mvvm.LifecycleExtKt;
import com.blued.android.module.common.utils.DialogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.soft.blued.R;
import com.soft.blued.customview.SearchView;
import com.soft.blued.customview.smartrefresh.BluedAdapterLoadMoreView;
import com.soft.blued.ui.feed.adapter.FeedPostLocationAdapter;
import com.soft.blued.ui.feed.vm.FeedPostViewModel;
import com.soft.blued.ui.msg.model.PositionPOIModel;
import com.soft.blued.utils.PermissionUtils;
import com.soft.blued.utils.ViewUtils;
import com.soft.blued.view.tip.dialog.BottomSheetBehavior;
import com.soft.blued.view.tip.dialog.BottomSheetDialog;
import com.soft.blued.view.tip.dialog.BottomSheetDialogFragment;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\000X\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\003\n\002\020\013\n\002\b\002\n\002\020\016\n\002\b\005\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020\b\n\002\b\002\030\000 #2\0020\001:\001#B\005¢\006\002\020\002J\006\020\r\032\0020\016J\b\020\017\032\0020\016H\002J\016\020\020\032\0020\0162\006\020\021\032\0020\022J\006\020\023\032\0020\016J\b\020\024\032\0020\025H\002J\b\020\026\032\0020\016H\002J\b\020\027\032\0020\016H\002J\b\020\030\032\0020\016H\002J\022\020\031\032\0020\0162\b\020\032\032\004\030\0010\033H\026J\020\020\034\032\0020\0162\006\020\035\032\0020\036H\026J\b\020\037\032\0020\016H\002J\030\020 \032\0020\0162\006\020\035\032\0020\0072\006\020!\032\0020\"H\026R\016\020\003\032\0020\004X.¢\006\002\n\000R\016\020\005\032\0020\004X.¢\006\002\n\000R\020\020\006\032\004\030\0010\007X\016¢\006\002\n\000R\016\020\b\032\0020\tX.¢\006\002\n\000R\016\020\n\032\0020\013X.¢\006\002\n\000R\016\020\f\032\0020\004X.¢\006\002\n\000¨\006$"}, d2 = {"Lcom/soft/blued/ui/feed/dialog/FeedPostLocationDialogFragment;", "Lcom/soft/blued/view/tip/dialog/BottomSheetDialogFragment;", "()V", "footerView", "Landroid/view/View;", "headerView", "loadingDialog", "Landroid/app/Dialog;", "locationAdapter", "Lcom/soft/blued/ui/feed/adapter/FeedPostLocationAdapter;", "mViewModel", "Lcom/soft/blued/ui/feed/vm/FeedPostViewModel;", "selectHeaderView", "close", "", "deleteLocation", "doAnimator", "isShowCancelBtn", "", "done", "getKeyWords", "", "getPositionAndOffset", "initData", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "scrollToPosition", "setupDialog", "style", "", "Companion", "blued_app_a9999aRelease"}, k = 1, mv = {1, 1, 16})
public final class FeedPostLocationDialogFragment extends BottomSheetDialogFragment {
  public static final Companion a = new Companion(null);
  
  private Dialog b;
  
  private FeedPostLocationAdapter c;
  
  private View d;
  
  private View e;
  
  private View f;
  
  private FeedPostViewModel g;
  
  private HashMap h;
  
  private final String i() {
    Dialog dialog = getDialog();
    if (dialog == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog, "dialog!!");
    SearchView searchView = (SearchView)dialog.findViewById(R.id.searchBar);
    Intrinsics.a(searchView, "dialog!!.searchBar");
    SearchEditText searchEditText = searchView.getEditView();
    Intrinsics.a(searchEditText, "dialog!!.searchBar.editView");
    return String.valueOf(searchEditText.getText());
  }
  
  private final void j() {
    this.c = new FeedPostLocationAdapter(getContext());
    FeedPostLocationAdapter feedPostLocationAdapter = this.c;
    if (feedPostLocationAdapter == null)
      Intrinsics.b("locationAdapter"); 
    feedPostLocationAdapter.a((LoadMoreView)new BluedAdapterLoadMoreView());
    feedPostLocationAdapter = this.c;
    if (feedPostLocationAdapter == null)
      Intrinsics.b("locationAdapter"); 
    FeedPostViewModel feedPostViewModel2 = this.g;
    if (feedPostViewModel2 == null)
      Intrinsics.b("mViewModel"); 
    feedPostLocationAdapter.c((List)feedPostViewModel2.w().getValue());
    FeedPostViewModel feedPostViewModel1 = this.g;
    if (feedPostViewModel1 == null)
      Intrinsics.b("mViewModel"); 
    LifecycleExtKt.a((LifecycleOwner)this, (LiveData)feedPostViewModel1.v(), new FeedPostLocationDialogFragment$initData$1(this));
    feedPostViewModel1 = this.g;
    if (feedPostViewModel1 == null)
      Intrinsics.b("mViewModel"); 
    LifecycleExtKt.a((LifecycleOwner)this, (LiveData)feedPostViewModel1.w(), new FeedPostLocationDialogFragment$initData$2(this));
    feedPostViewModel1 = this.g;
    if (feedPostViewModel1 == null)
      Intrinsics.b("mViewModel"); 
    LifecycleExtKt.a((LifecycleOwner)this, (LiveData)feedPostViewModel1.x(), new FeedPostLocationDialogFragment$initData$3(this));
  }
  
  private final void k() {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getDialog : ()Landroid/app/Dialog;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnonnull -> 12
    //   9: invokestatic a : ()V
    //   12: aload_1
    //   13: ldc 'dialog!!'
    //   15: invokestatic a : (Ljava/lang/Object;Ljava/lang/String;)V
    //   18: aload_1
    //   19: getstatic com/soft/blued/R$id.rootLayout : I
    //   22: invokevirtual findViewById : (I)Landroid/view/View;
    //   25: checkcast android/widget/FrameLayout
    //   28: astore_1
    //   29: aload_1
    //   30: ldc 'dialog!!.rootLayout'
    //   32: invokestatic a : (Ljava/lang/Object;Ljava/lang/String;)V
    //   35: aload_1
    //   36: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   39: astore_1
    //   40: aload_0
    //   41: getfield g : Lcom/soft/blued/ui/feed/vm/FeedPostViewModel;
    //   44: astore_2
    //   45: aload_2
    //   46: ifnonnull -> 54
    //   49: ldc 'mViewModel'
    //   51: invokestatic b : (Ljava/lang/String;)V
    //   54: aload_1
    //   55: aload_2
    //   56: invokevirtual F : ()I
    //   59: putfield height : I
    //   62: aload_0
    //   63: aload_0
    //   64: invokevirtual getContext : ()Landroid/content/Context;
    //   67: invokestatic a : (Landroid/content/Context;)Landroid/app/Dialog;
    //   70: putfield b : Landroid/app/Dialog;
    //   73: aload_0
    //   74: invokevirtual getDialog : ()Landroid/app/Dialog;
    //   77: astore_1
    //   78: aload_1
    //   79: ifnonnull -> 85
    //   82: invokestatic a : ()V
    //   85: aload_1
    //   86: ldc 'dialog!!'
    //   88: invokestatic a : (Ljava/lang/Object;Ljava/lang/String;)V
    //   91: aload_1
    //   92: getstatic com/soft/blued/R$id.ivClose : I
    //   95: invokevirtual findViewById : (I)Landroid/view/View;
    //   98: checkcast android/widget/ImageView
    //   101: new com/soft/blued/ui/feed/dialog/FeedPostLocationDialogFragment$initView$1
    //   104: dup
    //   105: aload_0
    //   106: invokespecial <init> : (Lcom/soft/blued/ui/feed/dialog/FeedPostLocationDialogFragment;)V
    //   109: checkcast android/view/View$OnClickListener
    //   112: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   115: aload_0
    //   116: invokevirtual getDialog : ()Landroid/app/Dialog;
    //   119: astore_1
    //   120: aload_1
    //   121: ifnonnull -> 127
    //   124: invokestatic a : ()V
    //   127: aload_1
    //   128: ldc 'dialog!!'
    //   130: invokestatic a : (Ljava/lang/Object;Ljava/lang/String;)V
    //   133: aload_1
    //   134: getstatic com/soft/blued/R$id.searchBar : I
    //   137: invokevirtual findViewById : (I)Landroid/view/View;
    //   140: checkcast com/soft/blued/customview/SearchView
    //   143: astore_1
    //   144: aload_1
    //   145: ldc 'dialog!!.searchBar'
    //   147: invokestatic a : (Ljava/lang/Object;Ljava/lang/String;)V
    //   150: aload_1
    //   151: invokevirtual getEditView : ()Lcom/blued/android/framework/view/SearchEditText;
    //   154: ldc_w 2131758410
    //   157: invokevirtual setHint : (I)V
    //   160: aload_0
    //   161: invokevirtual getDialog : ()Landroid/app/Dialog;
    //   164: astore_1
    //   165: aload_1
    //   166: ifnonnull -> 172
    //   169: invokestatic a : ()V
    //   172: aload_1
    //   173: ldc 'dialog!!'
    //   175: invokestatic a : (Ljava/lang/Object;Ljava/lang/String;)V
    //   178: aload_1
    //   179: getstatic com/soft/blued/R$id.searchBar : I
    //   182: invokevirtual findViewById : (I)Landroid/view/View;
    //   185: checkcast com/soft/blued/customview/SearchView
    //   188: astore_1
    //   189: aload_1
    //   190: ldc 'dialog!!.searchBar'
    //   192: invokestatic a : (Ljava/lang/Object;Ljava/lang/String;)V
    //   195: aload_1
    //   196: invokevirtual getEditView : ()Lcom/blued/android/framework/view/SearchEditText;
    //   199: astore_1
    //   200: aload_0
    //   201: getfield g : Lcom/soft/blued/ui/feed/vm/FeedPostViewModel;
    //   204: astore_2
    //   205: aload_2
    //   206: ifnonnull -> 214
    //   209: ldc 'mViewModel'
    //   211: invokestatic b : (Ljava/lang/String;)V
    //   214: aload_1
    //   215: aload_2
    //   216: invokevirtual t : ()Ljava/lang/String;
    //   219: checkcast java/lang/CharSequence
    //   222: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   225: aload_0
    //   226: invokevirtual getDialog : ()Landroid/app/Dialog;
    //   229: astore_1
    //   230: aload_1
    //   231: ifnonnull -> 237
    //   234: invokestatic a : ()V
    //   237: aload_1
    //   238: ldc 'dialog!!'
    //   240: invokestatic a : (Ljava/lang/Object;Ljava/lang/String;)V
    //   243: aload_1
    //   244: getstatic com/soft/blued/R$id.searchBar : I
    //   247: invokevirtual findViewById : (I)Landroid/view/View;
    //   250: checkcast com/soft/blued/customview/SearchView
    //   253: astore_1
    //   254: aload_1
    //   255: ldc 'dialog!!.searchBar'
    //   257: invokestatic a : (Ljava/lang/Object;Ljava/lang/String;)V
    //   260: aload_1
    //   261: invokevirtual getEditView : ()Lcom/blued/android/framework/view/SearchEditText;
    //   264: invokevirtual a : ()V
    //   267: aload_0
    //   268: invokevirtual getDialog : ()Landroid/app/Dialog;
    //   271: astore_1
    //   272: aload_1
    //   273: ifnonnull -> 279
    //   276: invokestatic a : ()V
    //   279: aload_1
    //   280: ldc 'dialog!!'
    //   282: invokestatic a : (Ljava/lang/Object;Ljava/lang/String;)V
    //   285: aload_1
    //   286: getstatic com/soft/blued/R$id.searchBar : I
    //   289: invokevirtual findViewById : (I)Landroid/view/View;
    //   292: checkcast com/soft/blued/customview/SearchView
    //   295: astore_1
    //   296: aload_1
    //   297: ldc 'dialog!!.searchBar'
    //   299: invokestatic a : (Ljava/lang/Object;Ljava/lang/String;)V
    //   302: aload_1
    //   303: invokevirtual getEditView : ()Lcom/blued/android/framework/view/SearchEditText;
    //   306: astore_1
    //   307: aload_1
    //   308: ldc 'dialog!!.searchBar.editView'
    //   310: invokestatic a : (Ljava/lang/Object;Ljava/lang/String;)V
    //   313: aload_1
    //   314: new com/soft/blued/ui/feed/dialog/FeedPostLocationDialogFragment$initView$2
    //   317: dup
    //   318: aload_0
    //   319: invokespecial <init> : (Lcom/soft/blued/ui/feed/dialog/FeedPostLocationDialogFragment;)V
    //   322: checkcast android/view/View$OnFocusChangeListener
    //   325: invokevirtual setOnFocusChangeListener : (Landroid/view/View$OnFocusChangeListener;)V
    //   328: aload_0
    //   329: invokevirtual getDialog : ()Landroid/app/Dialog;
    //   332: astore_1
    //   333: aload_1
    //   334: ifnonnull -> 340
    //   337: invokestatic a : ()V
    //   340: aload_1
    //   341: ldc 'dialog!!'
    //   343: invokestatic a : (Ljava/lang/Object;Ljava/lang/String;)V
    //   346: aload_1
    //   347: getstatic com/soft/blued/R$id.searchBar : I
    //   350: invokevirtual findViewById : (I)Landroid/view/View;
    //   353: checkcast com/soft/blued/customview/SearchView
    //   356: new com/soft/blued/ui/feed/dialog/FeedPostLocationDialogFragment$initView$3
    //   359: dup
    //   360: aload_0
    //   361: invokespecial <init> : (Lcom/soft/blued/ui/feed/dialog/FeedPostLocationDialogFragment;)V
    //   364: checkcast com/soft/blued/customview/SearchView$OnSearchInfoListener
    //   367: invokevirtual setOnSearchInfoListener : (Lcom/soft/blued/customview/SearchView$OnSearchInfoListener;)V
    //   370: aload_0
    //   371: getfield c : Lcom/soft/blued/ui/feed/adapter/FeedPostLocationAdapter;
    //   374: astore_1
    //   375: aload_1
    //   376: ifnonnull -> 384
    //   379: ldc 'locationAdapter'
    //   381: invokestatic b : (Ljava/lang/String;)V
    //   384: new com/soft/blued/ui/feed/dialog/FeedPostLocationDialogFragment$initView$4
    //   387: dup
    //   388: aload_0
    //   389: invokespecial <init> : (Lcom/soft/blued/ui/feed/dialog/FeedPostLocationDialogFragment;)V
    //   392: checkcast com/chad/library/adapter/base/BaseQuickAdapter$RequestLoadMoreListener
    //   395: astore_2
    //   396: aload_0
    //   397: invokevirtual getDialog : ()Landroid/app/Dialog;
    //   400: astore_3
    //   401: aload_3
    //   402: ifnonnull -> 408
    //   405: invokestatic a : ()V
    //   408: aload_3
    //   409: ldc 'dialog!!'
    //   411: invokestatic a : (Ljava/lang/Object;Ljava/lang/String;)V
    //   414: aload_1
    //   415: aload_2
    //   416: aload_3
    //   417: getstatic com/soft/blued/R$id.recycleView : I
    //   420: invokevirtual findViewById : (I)Landroid/view/View;
    //   423: checkcast androidx/recyclerview/widget/RecyclerView
    //   426: invokevirtual a : (Lcom/chad/library/adapter/base/BaseQuickAdapter$RequestLoadMoreListener;Landroidx/recyclerview/widget/RecyclerView;)V
    //   429: aload_0
    //   430: invokevirtual getDialog : ()Landroid/app/Dialog;
    //   433: astore_1
    //   434: aload_1
    //   435: ifnonnull -> 441
    //   438: invokestatic a : ()V
    //   441: aload_1
    //   442: ldc 'dialog!!'
    //   444: invokestatic a : (Ljava/lang/Object;Ljava/lang/String;)V
    //   447: aload_1
    //   448: getstatic com/soft/blued/R$id.recycleView : I
    //   451: invokevirtual findViewById : (I)Landroid/view/View;
    //   454: checkcast androidx/recyclerview/widget/RecyclerView
    //   457: new com/soft/blued/ui/feed/dialog/FeedPostLocationDialogFragment$initView$5
    //   460: dup
    //   461: aload_0
    //   462: invokespecial <init> : (Lcom/soft/blued/ui/feed/dialog/FeedPostLocationDialogFragment;)V
    //   465: checkcast android/view/View$OnTouchListener
    //   468: invokevirtual setOnTouchListener : (Landroid/view/View$OnTouchListener;)V
    //   471: aload_0
    //   472: invokevirtual getContext : ()Landroid/content/Context;
    //   475: invokestatic from : (Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   478: ldc_w 2131493514
    //   481: aconst_null
    //   482: invokevirtual inflate : (ILandroid/view/ViewGroup;)Landroid/view/View;
    //   485: astore_1
    //   486: aload_1
    //   487: ldc_w 'LayoutInflater.from(cont…feed_post_location, null)'
    //   490: invokestatic a : (Ljava/lang/Object;Ljava/lang/String;)V
    //   493: aload_0
    //   494: aload_1
    //   495: putfield d : Landroid/view/View;
    //   498: aload_0
    //   499: getfield d : Landroid/view/View;
    //   502: astore_1
    //   503: aload_1
    //   504: ifnonnull -> 512
    //   507: ldc 'headerView'
    //   509: invokestatic b : (Ljava/lang/String;)V
    //   512: aload_1
    //   513: getstatic com/soft/blued/R$id.tvName : I
    //   516: invokevirtual findViewById : (I)Landroid/view/View;
    //   519: checkcast android/widget/TextView
    //   522: astore_1
    //   523: aload_1
    //   524: ldc_w 'headerView.tvName'
    //   527: invokestatic a : (Ljava/lang/Object;Ljava/lang/String;)V
    //   530: aload_0
    //   531: invokevirtual getContext : ()Landroid/content/Context;
    //   534: astore_2
    //   535: aload_2
    //   536: ifnonnull -> 542
    //   539: invokestatic a : ()V
    //   542: aload_1
    //   543: aload_2
    //   544: ldc_w 2131758407
    //   547: invokevirtual getString : (I)Ljava/lang/String;
    //   550: checkcast java/lang/CharSequence
    //   553: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   556: aload_0
    //   557: getfield d : Landroid/view/View;
    //   560: astore_1
    //   561: aload_1
    //   562: ifnonnull -> 570
    //   565: ldc 'headerView'
    //   567: invokestatic b : (Ljava/lang/String;)V
    //   570: aload_1
    //   571: getstatic com/soft/blued/R$id.tvLocation : I
    //   574: invokevirtual findViewById : (I)Landroid/view/View;
    //   577: checkcast android/widget/TextView
    //   580: astore_1
    //   581: aload_1
    //   582: ldc_w 'headerView.tvLocation'
    //   585: invokestatic a : (Ljava/lang/Object;Ljava/lang/String;)V
    //   588: aload_1
    //   589: bipush #8
    //   591: invokevirtual setVisibility : (I)V
    //   594: aload_0
    //   595: getfield d : Landroid/view/View;
    //   598: astore_1
    //   599: aload_1
    //   600: ifnonnull -> 608
    //   603: ldc 'headerView'
    //   605: invokestatic b : (Ljava/lang/String;)V
    //   608: aload_1
    //   609: new com/soft/blued/ui/feed/dialog/FeedPostLocationDialogFragment$initView$6
    //   612: dup
    //   613: aload_0
    //   614: invokespecial <init> : (Lcom/soft/blued/ui/feed/dialog/FeedPostLocationDialogFragment;)V
    //   617: checkcast android/view/View$OnClickListener
    //   620: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   623: aload_0
    //   624: getfield c : Lcom/soft/blued/ui/feed/adapter/FeedPostLocationAdapter;
    //   627: astore_1
    //   628: aload_1
    //   629: ifnonnull -> 637
    //   632: ldc 'locationAdapter'
    //   634: invokestatic b : (Ljava/lang/String;)V
    //   637: aload_0
    //   638: getfield d : Landroid/view/View;
    //   641: astore_2
    //   642: aload_2
    //   643: ifnonnull -> 651
    //   646: ldc 'headerView'
    //   648: invokestatic b : (Ljava/lang/String;)V
    //   651: aload_1
    //   652: aload_2
    //   653: invokevirtual b : (Landroid/view/View;)I
    //   656: pop
    //   657: aload_0
    //   658: getfield c : Lcom/soft/blued/ui/feed/adapter/FeedPostLocationAdapter;
    //   661: astore_1
    //   662: aload_1
    //   663: ifnonnull -> 671
    //   666: ldc 'locationAdapter'
    //   668: invokestatic b : (Ljava/lang/String;)V
    //   671: aload_1
    //   672: invokevirtual a : ()Z
    //   675: ifne -> 1077
    //   678: aload_0
    //   679: getfield g : Lcom/soft/blued/ui/feed/vm/FeedPostViewModel;
    //   682: astore_1
    //   683: aload_1
    //   684: ifnonnull -> 692
    //   687: ldc 'mViewModel'
    //   689: invokestatic b : (Ljava/lang/String;)V
    //   692: aload_1
    //   693: invokevirtual o : ()Landroidx/lifecycle/MutableLiveData;
    //   696: invokevirtual getValue : ()Ljava/lang/Object;
    //   699: checkcast java/lang/CharSequence
    //   702: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   705: ifne -> 1003
    //   708: aload_0
    //   709: getfield g : Lcom/soft/blued/ui/feed/vm/FeedPostViewModel;
    //   712: astore_1
    //   713: aload_1
    //   714: ifnonnull -> 722
    //   717: ldc 'mViewModel'
    //   719: invokestatic b : (Ljava/lang/String;)V
    //   722: aload_1
    //   723: invokevirtual p : ()Ljava/lang/String;
    //   726: checkcast java/lang/CharSequence
    //   729: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   732: ifne -> 1003
    //   735: aload_0
    //   736: getfield g : Lcom/soft/blued/ui/feed/vm/FeedPostViewModel;
    //   739: astore_1
    //   740: aload_1
    //   741: ifnonnull -> 749
    //   744: ldc 'mViewModel'
    //   746: invokestatic b : (Ljava/lang/String;)V
    //   749: aload_1
    //   750: invokevirtual q : ()Ljava/lang/String;
    //   753: checkcast java/lang/CharSequence
    //   756: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   759: ifne -> 1003
    //   762: aload_0
    //   763: invokevirtual getContext : ()Landroid/content/Context;
    //   766: invokestatic from : (Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   769: ldc_w 2131493514
    //   772: aconst_null
    //   773: invokevirtual inflate : (ILandroid/view/ViewGroup;)Landroid/view/View;
    //   776: astore_1
    //   777: aload_1
    //   778: ldc_w 'LayoutInflater.from(cont…feed_post_location, null)'
    //   781: invokestatic a : (Ljava/lang/Object;Ljava/lang/String;)V
    //   784: aload_0
    //   785: aload_1
    //   786: putfield e : Landroid/view/View;
    //   789: aload_0
    //   790: getfield e : Landroid/view/View;
    //   793: astore_1
    //   794: aload_1
    //   795: ifnonnull -> 804
    //   798: ldc_w 'selectHeaderView'
    //   801: invokestatic b : (Ljava/lang/String;)V
    //   804: aload_1
    //   805: getstatic com/soft/blued/R$id.tvName : I
    //   808: invokevirtual findViewById : (I)Landroid/view/View;
    //   811: checkcast android/widget/TextView
    //   814: astore_1
    //   815: aload_1
    //   816: ldc_w 'selectHeaderView.tvName'
    //   819: invokestatic a : (Ljava/lang/Object;Ljava/lang/String;)V
    //   822: aload_0
    //   823: getfield g : Lcom/soft/blued/ui/feed/vm/FeedPostViewModel;
    //   826: astore_2
    //   827: aload_2
    //   828: ifnonnull -> 836
    //   831: ldc 'mViewModel'
    //   833: invokestatic b : (Ljava/lang/String;)V
    //   836: aload_1
    //   837: aload_2
    //   838: invokevirtual o : ()Landroidx/lifecycle/MutableLiveData;
    //   841: invokevirtual getValue : ()Ljava/lang/Object;
    //   844: checkcast java/lang/CharSequence
    //   847: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   850: aload_0
    //   851: getfield e : Landroid/view/View;
    //   854: astore_1
    //   855: aload_1
    //   856: ifnonnull -> 865
    //   859: ldc_w 'selectHeaderView'
    //   862: invokestatic b : (Ljava/lang/String;)V
    //   865: aload_1
    //   866: getstatic com/soft/blued/R$id.tvLocation : I
    //   869: invokevirtual findViewById : (I)Landroid/view/View;
    //   872: checkcast android/widget/TextView
    //   875: astore_1
    //   876: aload_1
    //   877: ldc_w 'selectHeaderView.tvLocation'
    //   880: invokestatic a : (Ljava/lang/Object;Ljava/lang/String;)V
    //   883: aload_1
    //   884: bipush #8
    //   886: invokevirtual setVisibility : (I)V
    //   889: aload_0
    //   890: getfield e : Landroid/view/View;
    //   893: astore_1
    //   894: aload_1
    //   895: ifnonnull -> 904
    //   898: ldc_w 'selectHeaderView'
    //   901: invokestatic b : (Ljava/lang/String;)V
    //   904: aload_1
    //   905: getstatic com/soft/blued/R$id.tvName : I
    //   908: invokevirtual findViewById : (I)Landroid/view/View;
    //   911: checkcast android/widget/TextView
    //   914: aload_0
    //   915: invokevirtual getContext : ()Landroid/content/Context;
    //   918: ldc_w 2131100716
    //   921: invokestatic a : (Landroid/content/Context;I)I
    //   924: invokevirtual setTextColor : (I)V
    //   927: aload_0
    //   928: getfield e : Landroid/view/View;
    //   931: astore_1
    //   932: aload_1
    //   933: ifnonnull -> 942
    //   936: ldc_w 'selectHeaderView'
    //   939: invokestatic b : (Ljava/lang/String;)V
    //   942: aload_1
    //   943: getstatic com/soft/blued/R$id.ivSelect : I
    //   946: invokevirtual findViewById : (I)Landroid/view/View;
    //   949: checkcast android/widget/ImageView
    //   952: astore_1
    //   953: aload_1
    //   954: ldc_w 'selectHeaderView.ivSelect'
    //   957: invokestatic a : (Ljava/lang/Object;Ljava/lang/String;)V
    //   960: aload_1
    //   961: iconst_0
    //   962: invokevirtual setVisibility : (I)V
    //   965: aload_0
    //   966: getfield c : Lcom/soft/blued/ui/feed/adapter/FeedPostLocationAdapter;
    //   969: astore_1
    //   970: aload_1
    //   971: ifnonnull -> 979
    //   974: ldc 'locationAdapter'
    //   976: invokestatic b : (Ljava/lang/String;)V
    //   979: aload_0
    //   980: getfield e : Landroid/view/View;
    //   983: astore_2
    //   984: aload_2
    //   985: ifnonnull -> 994
    //   988: ldc_w 'selectHeaderView'
    //   991: invokestatic b : (Ljava/lang/String;)V
    //   994: aload_1
    //   995: aload_2
    //   996: invokevirtual b : (Landroid/view/View;)I
    //   999: pop
    //   1000: goto -> 1077
    //   1003: aload_0
    //   1004: getfield d : Landroid/view/View;
    //   1007: astore_1
    //   1008: aload_1
    //   1009: ifnonnull -> 1017
    //   1012: ldc 'headerView'
    //   1014: invokestatic b : (Ljava/lang/String;)V
    //   1017: aload_1
    //   1018: getstatic com/soft/blued/R$id.tvName : I
    //   1021: invokevirtual findViewById : (I)Landroid/view/View;
    //   1024: checkcast android/widget/TextView
    //   1027: aload_0
    //   1028: invokevirtual getContext : ()Landroid/content/Context;
    //   1031: ldc_w 2131100716
    //   1034: invokestatic a : (Landroid/content/Context;I)I
    //   1037: invokevirtual setTextColor : (I)V
    //   1040: aload_0
    //   1041: getfield d : Landroid/view/View;
    //   1044: astore_1
    //   1045: aload_1
    //   1046: ifnonnull -> 1054
    //   1049: ldc 'headerView'
    //   1051: invokestatic b : (Ljava/lang/String;)V
    //   1054: aload_1
    //   1055: getstatic com/soft/blued/R$id.ivSelect : I
    //   1058: invokevirtual findViewById : (I)Landroid/view/View;
    //   1061: checkcast android/widget/ImageView
    //   1064: astore_1
    //   1065: aload_1
    //   1066: ldc_w 'headerView.ivSelect'
    //   1069: invokestatic a : (Ljava/lang/Object;Ljava/lang/String;)V
    //   1072: aload_1
    //   1073: iconst_0
    //   1074: invokevirtual setVisibility : (I)V
    //   1077: aload_0
    //   1078: invokevirtual getContext : ()Landroid/content/Context;
    //   1081: invokestatic from : (Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   1084: ldc_w 2131493515
    //   1087: aconst_null
    //   1088: invokevirtual inflate : (ILandroid/view/ViewGroup;)Landroid/view/View;
    //   1091: astore_1
    //   1092: aload_1
    //   1093: ldc_w 'LayoutInflater.from(cont…cation_larger_area, null)'
    //   1096: invokestatic a : (Ljava/lang/Object;Ljava/lang/String;)V
    //   1099: aload_0
    //   1100: aload_1
    //   1101: putfield f : Landroid/view/View;
    //   1104: aload_0
    //   1105: getfield f : Landroid/view/View;
    //   1108: astore_1
    //   1109: aload_1
    //   1110: ifnonnull -> 1118
    //   1113: ldc 'footerView'
    //   1115: invokestatic b : (Ljava/lang/String;)V
    //   1118: aload_1
    //   1119: new com/soft/blued/ui/feed/dialog/FeedPostLocationDialogFragment$initView$7
    //   1122: dup
    //   1123: aload_0
    //   1124: invokespecial <init> : (Lcom/soft/blued/ui/feed/dialog/FeedPostLocationDialogFragment;)V
    //   1127: checkcast android/view/View$OnClickListener
    //   1130: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   1133: aload_0
    //   1134: getfield c : Lcom/soft/blued/ui/feed/adapter/FeedPostLocationAdapter;
    //   1137: astore_1
    //   1138: aload_1
    //   1139: ifnonnull -> 1147
    //   1142: ldc 'locationAdapter'
    //   1144: invokestatic b : (Ljava/lang/String;)V
    //   1147: aload_0
    //   1148: getfield f : Landroid/view/View;
    //   1151: astore_2
    //   1152: aload_2
    //   1153: ifnonnull -> 1161
    //   1156: ldc 'footerView'
    //   1158: invokestatic b : (Ljava/lang/String;)V
    //   1161: aload_1
    //   1162: aload_2
    //   1163: invokevirtual c : (Landroid/view/View;)I
    //   1166: pop
    //   1167: aload_0
    //   1168: invokevirtual getDialog : ()Landroid/app/Dialog;
    //   1171: astore_1
    //   1172: aload_1
    //   1173: ifnonnull -> 1179
    //   1176: invokestatic a : ()V
    //   1179: aload_1
    //   1180: ldc 'dialog!!'
    //   1182: invokestatic a : (Ljava/lang/Object;Ljava/lang/String;)V
    //   1185: aload_1
    //   1186: getstatic com/soft/blued/R$id.recycleView : I
    //   1189: invokevirtual findViewById : (I)Landroid/view/View;
    //   1192: checkcast androidx/recyclerview/widget/RecyclerView
    //   1195: astore_1
    //   1196: aload_1
    //   1197: ldc_w 'dialog!!.recycleView'
    //   1200: invokestatic a : (Ljava/lang/Object;Ljava/lang/String;)V
    //   1203: aload_1
    //   1204: new androidx/recyclerview/widget/LinearLayoutManager
    //   1207: dup
    //   1208: aload_0
    //   1209: invokevirtual getContext : ()Landroid/content/Context;
    //   1212: invokespecial <init> : (Landroid/content/Context;)V
    //   1215: checkcast androidx/recyclerview/widget/RecyclerView$LayoutManager
    //   1218: invokevirtual setLayoutManager : (Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V
    //   1221: aload_0
    //   1222: invokevirtual getDialog : ()Landroid/app/Dialog;
    //   1225: astore_1
    //   1226: aload_1
    //   1227: ifnonnull -> 1233
    //   1230: invokestatic a : ()V
    //   1233: aload_1
    //   1234: ldc 'dialog!!'
    //   1236: invokestatic a : (Ljava/lang/Object;Ljava/lang/String;)V
    //   1239: aload_1
    //   1240: getstatic com/soft/blued/R$id.recycleView : I
    //   1243: invokevirtual findViewById : (I)Landroid/view/View;
    //   1246: checkcast androidx/recyclerview/widget/RecyclerView
    //   1249: astore_1
    //   1250: aload_1
    //   1251: ldc_w 'dialog!!.recycleView'
    //   1254: invokestatic a : (Ljava/lang/Object;Ljava/lang/String;)V
    //   1257: aload_0
    //   1258: getfield c : Lcom/soft/blued/ui/feed/adapter/FeedPostLocationAdapter;
    //   1261: astore_2
    //   1262: aload_2
    //   1263: ifnonnull -> 1271
    //   1266: ldc 'locationAdapter'
    //   1268: invokestatic b : (Ljava/lang/String;)V
    //   1271: aload_1
    //   1272: aload_2
    //   1273: checkcast androidx/recyclerview/widget/RecyclerView$Adapter
    //   1276: invokevirtual setAdapter : (Landroidx/recyclerview/widget/RecyclerView$Adapter;)V
    //   1279: aload_0
    //   1280: invokespecial m : ()V
    //   1283: aload_0
    //   1284: getfield c : Lcom/soft/blued/ui/feed/adapter/FeedPostLocationAdapter;
    //   1287: astore_1
    //   1288: aload_1
    //   1289: ifnonnull -> 1297
    //   1292: ldc 'locationAdapter'
    //   1294: invokestatic b : (Ljava/lang/String;)V
    //   1297: aload_1
    //   1298: new com/soft/blued/ui/feed/dialog/FeedPostLocationDialogFragment$initView$8
    //   1301: dup
    //   1302: aload_0
    //   1303: invokespecial <init> : (Lcom/soft/blued/ui/feed/dialog/FeedPostLocationDialogFragment;)V
    //   1306: checkcast com/chad/library/adapter/base/BaseQuickAdapter$OnItemClickListener
    //   1309: invokevirtual a : (Lcom/chad/library/adapter/base/BaseQuickAdapter$OnItemClickListener;)V
    //   1312: return
  }
  
  private final void l() {
    Dialog dialog = getDialog();
    if (dialog != null) {
      RecyclerView recyclerView = (RecyclerView)dialog.findViewById(R.id.recycleView);
    } else {
      dialog = null;
    } 
    int[] arrayOfInt = ViewUtils.a((RecyclerView)dialog);
    FeedPostViewModel feedPostViewModel = this.g;
    if (feedPostViewModel == null)
      Intrinsics.b("mViewModel"); 
    feedPostViewModel.d(arrayOfInt[0]);
    feedPostViewModel = this.g;
    if (feedPostViewModel == null)
      Intrinsics.b("mViewModel"); 
    feedPostViewModel.c(arrayOfInt[1]);
  }
  
  private final void m() {
    Dialog dialog = getDialog();
    if (dialog != null) {
      RecyclerView recyclerView = (RecyclerView)dialog.findViewById(R.id.recycleView);
    } else {
      dialog = null;
    } 
    FeedPostViewModel feedPostViewModel = this.g;
    if (feedPostViewModel == null)
      Intrinsics.b("mViewModel"); 
    int i = feedPostViewModel.s();
    feedPostViewModel = this.g;
    if (feedPostViewModel == null)
      Intrinsics.b("mViewModel"); 
    ViewUtils.a((RecyclerView)dialog, i, feedPostViewModel.r());
  }
  
  private final void n() {
    FeedPostLocationAdapter feedPostLocationAdapter2 = this.c;
    if (feedPostLocationAdapter2 == null)
      Intrinsics.b("locationAdapter"); 
    Iterator iterator = feedPostLocationAdapter2.n().iterator();
    while (iterator.hasNext())
      ((PositionPOIModel)iterator.next()).mark_visible = false; 
    FeedPostLocationAdapter feedPostLocationAdapter1 = this.c;
    if (feedPostLocationAdapter1 == null)
      Intrinsics.b("locationAdapter"); 
    feedPostLocationAdapter1.notifyDataSetChanged();
    View view2 = this.d;
    if (view2 == null)
      Intrinsics.b("headerView"); 
    TextView textView = (TextView)view2.findViewById(R.id.tvName);
    Context context = getContext();
    if (context == null)
      Intrinsics.a(); 
    Intrinsics.a(context, "context!!");
    textView.setTextColor(context.getResources().getColor(2131100716));
    View view1 = this.d;
    if (view1 == null)
      Intrinsics.b("headerView"); 
    ImageView imageView = (ImageView)view1.findViewById(R.id.ivSelect);
    Intrinsics.a(imageView, "headerView.ivSelect");
    imageView.setVisibility(0);
    FeedPostViewModel feedPostViewModel1 = this.g;
    if (feedPostViewModel1 == null)
      Intrinsics.b("mViewModel"); 
    feedPostViewModel1.o().setValue("");
    FeedPostViewModel feedPostViewModel2 = this.g;
    if (feedPostViewModel2 == null)
      Intrinsics.b("mViewModel"); 
    String str = (String)null;
    feedPostViewModel2.b(str);
    feedPostViewModel2 = this.g;
    if (feedPostViewModel2 == null)
      Intrinsics.b("mViewModel"); 
    feedPostViewModel2.c(str);
  }
  
  public final void a(boolean paramBoolean) {
    Dialog dialog = getDialog();
    if (dialog == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog, "dialog!!");
    if ((SearchView)dialog.findViewById(R.id.searchBar) != null) {
      dialog = getDialog();
      if (dialog == null)
        Intrinsics.a(); 
      Intrinsics.a(dialog, "dialog!!");
      ((SearchView)dialog.findViewById(R.id.searchBar)).a(paramBoolean);
      dialog = getDialog();
      if (dialog == null)
        Intrinsics.a(); 
      Intrinsics.a(dialog, "dialog!!");
      SearchView searchView3 = (SearchView)dialog.findViewById(R.id.searchBar);
      Intrinsics.a(searchView3, "dialog!!.searchBar");
      SearchEditText searchEditText3 = searchView3.getEditView();
      Intrinsics.a(searchEditText3, "dialog!!.searchBar.editView");
      searchEditText3.setFocusable(true);
      Dialog dialog2 = getDialog();
      if (dialog2 == null)
        Intrinsics.a(); 
      Intrinsics.a(dialog2, "dialog!!");
      SearchView searchView2 = (SearchView)dialog2.findViewById(R.id.searchBar);
      Intrinsics.a(searchView2, "dialog!!.searchBar");
      SearchEditText searchEditText2 = searchView2.getEditView();
      Intrinsics.a(searchEditText2, "dialog!!.searchBar.editView");
      searchEditText2.setFocusableInTouchMode(true);
      Dialog dialog1 = getDialog();
      if (dialog1 == null)
        Intrinsics.a(); 
      Intrinsics.a(dialog1, "dialog!!");
      SearchView searchView1 = (SearchView)dialog1.findViewById(R.id.searchBar);
      Intrinsics.a(searchView1, "dialog!!.searchBar");
      SearchEditText searchEditText1 = searchView1.getEditView();
      Intrinsics.a(searchEditText1, "dialog!!.searchBar.editView");
      searchEditText1.setCursorVisible(paramBoolean);
    } 
  }
  
  public final void f() {
    dismiss();
  }
  
  public final void g() {
    dismiss();
  }
  
  public void h() {
    HashMap hashMap = this.h;
    if (hashMap != null)
      hashMap.clear(); 
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setStyle(0, 2131820776);
    FragmentActivity fragmentActivity = getActivity();
    if (fragmentActivity == null)
      Intrinsics.a(); 
    Intrinsics.a(fragmentActivity, "activity!!");
    ViewModelStore viewModelStore = fragmentActivity.getViewModelStore();
    Context context = AppInfo.d();
    if (context != null) {
      ViewModel viewModel = (new ViewModelProvider(viewModelStore, (ViewModelProvider.Factory)ViewModelProvider.AndroidViewModelFactory.getInstance((Application)context))).get(FeedPostViewModel.class);
      Intrinsics.a(viewModel, "ViewModelProvider(activi…ostViewModel::class.java)");
      this.g = (FeedPostViewModel)viewModel;
      return;
    } 
    throw new TypeCastException("null cannot be cast to non-null type android.app.Application");
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {
    Intrinsics.b(paramDialogInterface, "dialog");
    l();
    super.onDismiss(paramDialogInterface);
  }
  
  public void setupDialog(Dialog paramDialog, int paramInt) {
    Intrinsics.b(paramDialog, "dialog");
    super.setupDialog(paramDialog, paramInt);
    paramDialog.setContentView(2131492989);
    BottomSheetBehavior bottomSheetBehavior = ((BottomSheetDialog)paramDialog).a();
    Intrinsics.a(bottomSheetBehavior, "(dialog as BottomSheetDialog).behavior");
    FeedPostViewModel feedPostViewModel = this.g;
    if (feedPostViewModel == null)
      Intrinsics.b("mViewModel"); 
    bottomSheetBehavior.a(feedPostViewModel.F());
    j();
    k();
    FeedPostLocationAdapter feedPostLocationAdapter = this.c;
    if (feedPostLocationAdapter == null)
      Intrinsics.b("locationAdapter"); 
    if (feedPostLocationAdapter.n().size() <= 0) {
      FeedPostViewModel feedPostViewModel1 = this.g;
      if (feedPostViewModel1 == null)
        Intrinsics.b("mViewModel"); 
      feedPostViewModel1.I();
      feedPostViewModel1 = this.g;
      if (feedPostViewModel1 == null)
        Intrinsics.b("mViewModel"); 
      feedPostViewModel1.a((LifecycleOwner)this, true, i());
    } 
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\030\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\016\020\003\032\0020\0042\006\020\005\032\0020\006¨\006\007"}, d2 = {"Lcom/soft/blued/ui/feed/dialog/FeedPostLocationDialogFragment$Companion;", "", "()V", "show", "Lcom/soft/blued/ui/feed/dialog/FeedPostLocationDialogFragment;", "manager", "Landroidx/fragment/app/FragmentManager;", "blued_app_a9999aRelease"}, k = 1, mv = {1, 1, 16})
  public static final class Companion {
    private Companion() {}
    
    public final FeedPostLocationDialogFragment a(FragmentManager param1FragmentManager) {
      Intrinsics.b(param1FragmentManager, "manager");
      FeedPostLocationDialogFragment feedPostLocationDialogFragment = new FeedPostLocationDialogFragment();
      PermissionUtils.a(new FeedPostLocationDialogFragment$Companion$show$1(feedPostLocationDialogFragment, param1FragmentManager));
      return feedPostLocationDialogFragment;
    }
    
    @Metadata(bv = {1, 0, 3}, d1 = {"\000\035\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\021\n\002\020\016\n\002\b\003*\001\000\b\n\030\0002\0020\001J\033\020\002\032\0020\0032\f\020\004\032\b\022\004\022\0020\0060\005H\026¢\006\002\020\007J\b\020\b\032\0020\003H\026¨\006\t"}, d2 = {"com/soft/blued/ui/feed/dialog/FeedPostLocationDialogFragment$Companion$show$1", "Lcom/blued/android/framework/permission/PermissionCallbacks;", "onPermissionsDenied", "", "perms", "", "", "([Ljava/lang/String;)V", "onPermissionsGranted", "blued_app_a9999aRelease"}, k = 1, mv = {1, 1, 16})
    public static final class FeedPostLocationDialogFragment$Companion$show$1 implements PermissionCallbacks {
      FeedPostLocationDialogFragment$Companion$show$1(FeedPostLocationDialogFragment param2FeedPostLocationDialogFragment, FragmentManager param2FragmentManager) {}
      
      public void a(String[] param2ArrayOfString) {
        Intrinsics.b(param2ArrayOfString, "perms");
      }
      
      public void aa_() {
        this.a.show(this.b, FeedPostLocationDialogFragment.class.getSimpleName());
      }
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\035\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\021\n\002\020\016\n\002\b\003*\001\000\b\n\030\0002\0020\001J\033\020\002\032\0020\0032\f\020\004\032\b\022\004\022\0020\0060\005H\026¢\006\002\020\007J\b\020\b\032\0020\003H\026¨\006\t"}, d2 = {"com/soft/blued/ui/feed/dialog/FeedPostLocationDialogFragment$Companion$show$1", "Lcom/blued/android/framework/permission/PermissionCallbacks;", "onPermissionsDenied", "", "perms", "", "", "([Ljava/lang/String;)V", "onPermissionsGranted", "blued_app_a9999aRelease"}, k = 1, mv = {1, 1, 16})
  public static final class FeedPostLocationDialogFragment$Companion$show$1 implements PermissionCallbacks {
    FeedPostLocationDialogFragment$Companion$show$1(FeedPostLocationDialogFragment param1FeedPostLocationDialogFragment, FragmentManager param1FragmentManager) {}
    
    public void a(String[] param1ArrayOfString) {
      Intrinsics.b(param1ArrayOfString, "perms");
    }
    
    public void aa_() {
      this.a.show(this.b, FeedPostLocationDialogFragment.class.getSimpleName());
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\020\n\000\n\002\020\002\n\000\n\002\020\013\n\002\b\003\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\003H\n¢\006\004\b\005\020\006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 1, 16})
  static final class FeedPostLocationDialogFragment$initData$1 extends Lambda implements Function1<Boolean, Unit> {
    FeedPostLocationDialogFragment$initData$1(FeedPostLocationDialogFragment param1FeedPostLocationDialogFragment) {
      super(1);
    }
    
    public final void a(Boolean param1Boolean) {
      byte b;
      TextView textView = (TextView)FeedPostLocationDialogFragment.a(this.a).findViewById(R.id.tvFooterName);
      Intrinsics.a(textView, "footerView.tvFooterName");
      Intrinsics.a(param1Boolean, "it");
      if (param1Boolean.booleanValue()) {
        b = 0;
      } else {
        b = 8;
      } 
      textView.setVisibility(b);
      ((TextView)FeedPostLocationDialogFragment.a(this.a).findViewById(R.id.tvFooterName)).setText(FeedPostLocationDialogFragment.b(this.a).K());
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\024\n\000\n\002\020\002\n\000\n\002\020!\n\002\030\002\n\002\b\002\020\000\032\0020\0012\032\020\002\032\026\022\004\022\0020\004 \005*\n\022\004\022\0020\004\030\0010\0030\003H\n¢\006\002\b\006"}, d2 = {"<anonymous>", "", "it", "", "Lcom/soft/blued/ui/msg/model/PositionPOIModel;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 16})
  static final class FeedPostLocationDialogFragment$initData$2 extends Lambda implements Function1<List<PositionPOIModel>, Unit> {
    FeedPostLocationDialogFragment$initData$2(FeedPostLocationDialogFragment param1FeedPostLocationDialogFragment) {
      super(1);
    }
    
    public final void a(List<PositionPOIModel> param1List) {
      DialogUtils.b(FeedPostLocationDialogFragment.c(this.a));
      FeedPostLocationDialogFragment.d(this.a).c(param1List);
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\020\n\000\n\002\020\002\n\000\n\002\020\013\n\002\b\003\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\003H\n¢\006\004\b\005\020\006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 1, 16})
  static final class FeedPostLocationDialogFragment$initData$3 extends Lambda implements Function1<Boolean, Unit> {
    FeedPostLocationDialogFragment$initData$3(FeedPostLocationDialogFragment param1FeedPostLocationDialogFragment) {
      super(1);
    }
    
    public final void a(Boolean param1Boolean) {
      Intrinsics.a(param1Boolean, "it");
      if (param1Boolean.booleanValue()) {
        FeedPostLocationDialogFragment.d(this.a).l();
        return;
      } 
      if (!param1Boolean.booleanValue())
        FeedPostLocationDialogFragment.d(this.a).k(); 
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\020\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\003H\n¢\006\002\b\005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
  static final class FeedPostLocationDialogFragment$initView$1 implements View.OnClickListener {
    FeedPostLocationDialogFragment$initView$1(FeedPostLocationDialogFragment param1FeedPostLocationDialogFragment) {}
    
    public final void onClick(View param1View) {
      this.a.g();
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\026\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\n\002\020\013\n\000\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\0032\006\020\005\032\0020\006H\n¢\006\002\b\007"}, d2 = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "isFocus", "", "onFocusChange"}, k = 3, mv = {1, 1, 16})
  static final class FeedPostLocationDialogFragment$initView$2 implements View.OnFocusChangeListener {
    FeedPostLocationDialogFragment$initView$2(FeedPostLocationDialogFragment param1FeedPostLocationDialogFragment) {}
    
    public final void onFocusChange(View param1View, boolean param1Boolean) {
      this.a.a(param1Boolean);
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\033\n\000\n\002\030\002\n\000\n\002\020\002\n\002\b\002\n\002\020\016\n\002\b\002*\001\000\b\n\030\0002\0020\001J\b\020\002\032\0020\003H\026J\020\020\004\032\0020\0032\006\020\005\032\0020\006H\026J\b\020\007\032\0020\003H\026¨\006\b"}, d2 = {"com/soft/blued/ui/feed/dialog/FeedPostLocationDialogFragment$initView$3", "Lcom/soft/blued/customview/SearchView$OnSearchInfoListener;", "clearContent", "", "doSearch", "msg", "", "onCancel", "blued_app_a9999aRelease"}, k = 1, mv = {1, 1, 16})
  public static final class FeedPostLocationDialogFragment$initView$3 implements SearchView.OnSearchInfoListener {
    FeedPostLocationDialogFragment$initView$3(FeedPostLocationDialogFragment param1FeedPostLocationDialogFragment) {}
    
    public void a() {
      this.a.g();
    }
    
    public void a(String param1String) {
      Intrinsics.b(param1String, "msg");
      FeedPostLocationDialogFragment.b(this.a).I();
      FeedPostLocationDialogFragment.b(this.a).a((LifecycleOwner)this.a, true, param1String);
    }
    
    public void b() {}
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "onLoadMoreRequested"}, k = 3, mv = {1, 1, 16})
  static final class FeedPostLocationDialogFragment$initView$4 implements BaseQuickAdapter.RequestLoadMoreListener {
    FeedPostLocationDialogFragment$initView$4(FeedPostLocationDialogFragment param1FeedPostLocationDialogFragment) {}
    
    public final void onLoadMoreRequested() {
      FeedPostViewModel feedPostViewModel = FeedPostLocationDialogFragment.b(this.a);
      FeedPostLocationDialogFragment feedPostLocationDialogFragment = this.a;
      feedPostViewModel.a((LifecycleOwner)feedPostLocationDialogFragment, false, FeedPostLocationDialogFragment.e(feedPostLocationDialogFragment));
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\026\n\000\n\002\020\013\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\0032\016\020\005\032\n \004*\004\030\0010\0060\006H\n¢\006\002\b\007"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"}, k = 3, mv = {1, 1, 16})
  static final class FeedPostLocationDialogFragment$initView$5 implements View.OnTouchListener {
    FeedPostLocationDialogFragment$initView$5(FeedPostLocationDialogFragment param1FeedPostLocationDialogFragment) {}
    
    public final boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
      Context context = this.a.getContext();
      Dialog dialog = this.a.getDialog();
      if (dialog == null)
        Intrinsics.a(); 
      Intrinsics.a(dialog, "dialog!!");
      SearchView searchView = (SearchView)dialog.findViewById(R.id.searchBar);
      Intrinsics.a(searchView, "dialog!!.searchBar");
      KeyboardUtils.b(context, (View)searchView.getEditView());
      return false;
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\020\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\003H\n¢\006\002\b\005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
  static final class FeedPostLocationDialogFragment$initView$6 implements View.OnClickListener {
    FeedPostLocationDialogFragment$initView$6(FeedPostLocationDialogFragment param1FeedPostLocationDialogFragment) {}
    
    public final void onClick(View param1View) {
      FeedPostLocationDialogFragment.f(this.a);
      this.a.f();
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\020\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\003H\n¢\006\002\b\005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
  static final class FeedPostLocationDialogFragment$initView$7 implements View.OnClickListener {
    FeedPostLocationDialogFragment$initView$7(FeedPostLocationDialogFragment param1FeedPostLocationDialogFragment) {}
    
    public final void onClick(View param1View) {
      if (FeedPostLocationDialogFragment.b(this.a).J())
        FeedPostLocationDialogFragment.a(this.a).setVisibility(8); 
      FeedPostViewModel feedPostViewModel = FeedPostLocationDialogFragment.b(this.a);
      FeedPostLocationDialogFragment feedPostLocationDialogFragment = this.a;
      feedPostViewModel.a((LifecycleOwner)feedPostLocationDialogFragment, true, FeedPostLocationDialogFragment.e(feedPostLocationDialogFragment));
      DialogUtils.a(FeedPostLocationDialogFragment.c(this.a));
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000$\n\000\n\002\020\002\n\000\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\b\n\000\020\000\032\0020\00128\020\002\0324\022\f\022\n \005*\004\030\0010\0040\004\022\f\022\n \005*\004\030\0010\0060\006 \005*\017\022\002\b\003\022\002\b\003\030\0010\003¨\006\0010\003¨\006\0012\016\020\007\032\n \005*\004\030\0010\b0\b2\006\020\t\032\0020\nH\n¢\006\002\b\013"}, d2 = {"<anonymous>", "", "adapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "", "kotlin.jvm.PlatformType", "Lcom/chad/library/adapter/base/BaseViewHolder;", "view", "Landroid/view/View;", "position", "", "onItemClick"}, k = 3, mv = {1, 1, 16})
  static final class FeedPostLocationDialogFragment$initView$8 implements BaseQuickAdapter.OnItemClickListener {
    FeedPostLocationDialogFragment$initView$8(FeedPostLocationDialogFragment param1FeedPostLocationDialogFragment) {}
    
    public final void onItemClick(BaseQuickAdapter<Object, BaseViewHolder> param1BaseQuickAdapter, View param1View, int param1Int) {
      TextView textView = (TextView)FeedPostLocationDialogFragment.g(this.a).findViewById(R.id.tvName);
      Context context = this.a.getContext();
      if (context == null)
        Intrinsics.a(); 
      Intrinsics.a(context, "context!!");
      textView.setTextColor(context.getResources().getColor(2131100539));
      ImageView imageView = (ImageView)FeedPostLocationDialogFragment.g(this.a).findViewById(R.id.ivSelect);
      Intrinsics.a(imageView, "headerView.ivSelect");
      imageView.setVisibility(8);
      Iterator iterator = FeedPostLocationDialogFragment.d(this.a).n().iterator();
      while (iterator.hasNext())
        ((PositionPOIModel)iterator.next()).mark_visible = false; 
      ((PositionPOIModel)FeedPostLocationDialogFragment.d(this.a).n().get(param1Int)).mark_visible = true;
      FeedPostLocationDialogFragment.d(this.a).notifyDataSetChanged();
      FeedPostLocationDialogFragment.b(this.a).o().setValue(((PositionPOIModel)FeedPostLocationDialogFragment.d(this.a).n().get(param1Int)).name);
      FeedPostLocationDialogFragment.b(this.a).b(((PositionPOIModel)FeedPostLocationDialogFragment.d(this.a).n().get(param1Int)).latitude.toString());
      FeedPostLocationDialogFragment.b(this.a).c(((PositionPOIModel)FeedPostLocationDialogFragment.d(this.a).n().get(param1Int)).longitude.toString());
      this.a.f();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\dialog\FeedPostLocationDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */