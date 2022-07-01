package com.soft.blued.ui.feed.dialog;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.view.SearchEditText;
import com.blued.android.module.common.base.mvvm.LifecycleExtKt;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.soft.blued.R;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.customview.SearchView;
import com.soft.blued.customview.smartrefresh.BluedAdapterLoadMoreView;
import com.soft.blued.ui.feed.adapter.SuperTopicAdapter;
import com.soft.blued.ui.feed.model.BluedTopic;
import com.soft.blued.ui.feed.vm.FeedPostViewModel;
import com.soft.blued.utils.ViewUtils;
import com.soft.blued.utils.click.SingleItemClickProxy;
import com.soft.blued.view.tip.dialog.BottomSheetBehavior;
import com.soft.blued.view.tip.dialog.BottomSheetDialog;
import com.soft.blued.view.tip.dialog.BottomSheetDialogFragment;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\000X\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\005\n\002\020\002\n\002\b\002\n\002\020\013\n\002\b\002\n\002\020\016\n\002\b\006\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\b\n\002\b\002\030\000 (2\0020\001:\001(B\005¢\006\002\020\002J\006\020\021\032\0020\022J\016\020\023\032\0020\0222\006\020\024\032\0020\025J\032\020\026\032\0020\0222\b\020\027\032\004\030\0010\0302\b\020\031\032\004\030\0010\030J\b\020\032\032\0020\022H\002J\b\020\033\032\0020\022H\002J\b\020\034\032\0020\022H\002J\022\020\035\032\0020\0222\b\020\036\032\004\030\0010\037H\026J\020\020 \032\0020\0222\006\020!\032\0020\"H\026J\b\020#\032\0020\022H\002J\030\020$\032\0020\0222\006\020!\032\0020%2\006\020&\032\0020'H\026R\016\020\003\032\0020\004X.¢\006\002\n\000R\032\020\005\032\0020\006X.¢\006\016\n\000\032\004\b\007\020\b\"\004\b\t\020\nR\032\020\013\032\0020\fX.¢\006\016\n\000\032\004\b\r\020\016\"\004\b\017\020\020¨\006)"}, d2 = {"Lcom/soft/blued/ui/feed/dialog/FeedPostTopicDialogFragment;", "Lcom/soft/blued/view/tip/dialog/BottomSheetDialogFragment;", "()V", "mViewModel", "Lcom/soft/blued/ui/feed/vm/FeedPostViewModel;", "noDataView", "Lcom/soft/blued/customview/NoDataAndLoadFailView;", "getNoDataView", "()Lcom/soft/blued/customview/NoDataAndLoadFailView;", "setNoDataView", "(Lcom/soft/blued/customview/NoDataAndLoadFailView;)V", "superTopicAdapter", "Lcom/soft/blued/ui/feed/adapter/SuperTopicAdapter;", "getSuperTopicAdapter", "()Lcom/soft/blued/ui/feed/adapter/SuperTopicAdapter;", "setSuperTopicAdapter", "(Lcom/soft/blued/ui/feed/adapter/SuperTopicAdapter;)V", "close", "", "doAnimator", "isShowCancelBtn", "", "done", "superDid", "", "name", "getPositionAndOffset", "initData", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "scrollToPosition", "setupDialog", "Landroid/app/Dialog;", "style", "", "Companion", "blued_app_a9999aRelease"}, k = 1, mv = {1, 1, 16})
public final class FeedPostTopicDialogFragment extends BottomSheetDialogFragment {
  public static final Companion c = new Companion(null);
  
  public SuperTopicAdapter a;
  
  public NoDataAndLoadFailView b;
  
  private FeedPostViewModel d;
  
  private HashMap e;
  
  private final void j() {
    this.a = new SuperTopicAdapter(getContext(), (IRequestHost)a());
    SuperTopicAdapter superTopicAdapter2 = this.a;
    if (superTopicAdapter2 == null)
      Intrinsics.b("superTopicAdapter"); 
    FeedPostViewModel feedPostViewModel2 = this.d;
    if (feedPostViewModel2 == null)
      Intrinsics.b("mViewModel"); 
    superTopicAdapter2.c((List)feedPostViewModel2.k().getValue());
    this.b = new NoDataAndLoadFailView(getContext());
    NoDataAndLoadFailView noDataAndLoadFailView1 = this.b;
    if (noDataAndLoadFailView1 == null)
      Intrinsics.b("noDataView"); 
    noDataAndLoadFailView1.setNoDataImg(2131232637);
    noDataAndLoadFailView1 = this.b;
    if (noDataAndLoadFailView1 == null)
      Intrinsics.b("noDataView"); 
    noDataAndLoadFailView1.setNoDataStr(2131758965);
    noDataAndLoadFailView1 = this.b;
    if (noDataAndLoadFailView1 == null)
      Intrinsics.b("noDataView"); 
    noDataAndLoadFailView1.setTopSpace(DensityUtils.a(getContext(), 40.0F));
    noDataAndLoadFailView1 = this.b;
    if (noDataAndLoadFailView1 == null)
      Intrinsics.b("noDataView"); 
    noDataAndLoadFailView1.setImageScale(0.7F);
    noDataAndLoadFailView1 = this.b;
    if (noDataAndLoadFailView1 == null)
      Intrinsics.b("noDataView"); 
    noDataAndLoadFailView1.c();
    SuperTopicAdapter superTopicAdapter1 = this.a;
    if (superTopicAdapter1 == null)
      Intrinsics.b("superTopicAdapter"); 
    NoDataAndLoadFailView noDataAndLoadFailView2 = this.b;
    if (noDataAndLoadFailView2 == null)
      Intrinsics.b("noDataView"); 
    superTopicAdapter1.e((View)noDataAndLoadFailView2);
    FeedPostViewModel feedPostViewModel1 = this.d;
    if (feedPostViewModel1 == null)
      Intrinsics.b("mViewModel"); 
    LifecycleExtKt.a((LifecycleOwner)this, (LiveData)feedPostViewModel1.k(), new FeedPostTopicDialogFragment$initData$1(this));
    feedPostViewModel1 = this.d;
    if (feedPostViewModel1 == null)
      Intrinsics.b("mViewModel"); 
    LifecycleExtKt.a((LifecycleOwner)this, (LiveData)feedPostViewModel1.l(), new FeedPostTopicDialogFragment$initData$2(this));
    feedPostViewModel1 = this.d;
    if (feedPostViewModel1 == null)
      Intrinsics.b("mViewModel"); 
    LifecycleExtKt.a((LifecycleOwner)this, (LiveData)feedPostViewModel1.m(), new FeedPostTopicDialogFragment$initData$3(this));
    feedPostViewModel1 = this.d;
    if (feedPostViewModel1 == null)
      Intrinsics.b("mViewModel"); 
    LifecycleExtKt.a((LifecycleOwner)this, (LiveData)feedPostViewModel1.n(), new FeedPostTopicDialogFragment$initData$4(this));
  }
  
  private final void k() {
    Dialog dialog12 = getDialog();
    if (dialog12 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog12, "dialog!!");
    FrameLayout frameLayout = (FrameLayout)dialog12.findViewById(R.id.rootLayout);
    Intrinsics.a(frameLayout, "dialog!!.rootLayout");
    ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
    FeedPostViewModel feedPostViewModel2 = this.d;
    if (feedPostViewModel2 == null)
      Intrinsics.b("mViewModel"); 
    layoutParams.height = feedPostViewModel2.F();
    Dialog dialog11 = getDialog();
    if (dialog11 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog11, "dialog!!");
    ((ImageView)dialog11.findViewById(R.id.ivClose)).setOnClickListener(new FeedPostTopicDialogFragment$initView$1(this));
    dialog11 = getDialog();
    if (dialog11 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog11, "dialog!!");
    SearchView searchView6 = (SearchView)dialog11.findViewById(R.id.searchBar);
    Intrinsics.a(searchView6, "dialog!!.searchBar");
    SearchEditText searchEditText5 = searchView6.getEditView();
    Intrinsics.a(searchEditText5, "dialog!!.searchBar.editView");
    Context context = getContext();
    if (context == null)
      Intrinsics.a(); 
    searchEditText5.setHint(context.getString(2131759037));
    Dialog dialog10 = getDialog();
    if (dialog10 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog10, "dialog!!");
    SearchView searchView5 = (SearchView)dialog10.findViewById(R.id.searchBar);
    Intrinsics.a(searchView5, "dialog!!.searchBar");
    SearchEditText searchEditText4 = searchView5.getEditView();
    FeedPostViewModel feedPostViewModel1 = this.d;
    if (feedPostViewModel1 == null)
      Intrinsics.b("mViewModel"); 
    searchEditText4.setText((CharSequence)feedPostViewModel1.l().getValue());
    Dialog dialog9 = getDialog();
    if (dialog9 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog9, "dialog!!");
    SearchView searchView4 = (SearchView)dialog9.findViewById(R.id.searchBar);
    Intrinsics.a(searchView4, "dialog!!.searchBar");
    searchView4.getEditView().a();
    Dialog dialog8 = getDialog();
    if (dialog8 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog8, "dialog!!");
    SearchView searchView3 = (SearchView)dialog8.findViewById(R.id.searchBar);
    Intrinsics.a(searchView3, "dialog!!.searchBar");
    SearchEditText searchEditText3 = searchView3.getEditView();
    Intrinsics.a(searchEditText3, "dialog!!.searchBar.editView");
    searchEditText3.setOnFocusChangeListener(new FeedPostTopicDialogFragment$initView$2(this));
    Dialog dialog7 = getDialog();
    if (dialog7 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog7, "dialog!!");
    ((SearchView)dialog7.findViewById(R.id.searchBar)).setOnSearchInfoListener(new FeedPostTopicDialogFragment$initView$3(this));
    dialog7 = getDialog();
    if (dialog7 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog7, "dialog!!");
    SearchView searchView2 = (SearchView)dialog7.findViewById(R.id.searchBar);
    Intrinsics.a(searchView2, "dialog!!.searchBar");
    SearchEditText searchEditText2 = searchView2.getEditView();
    Intrinsics.a(searchEditText2, "dialog!!.searchBar.editView");
    searchEditText2.setFocusable(true);
    Dialog dialog6 = getDialog();
    if (dialog6 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog6, "dialog!!");
    SearchView searchView1 = (SearchView)dialog6.findViewById(R.id.searchBar);
    Intrinsics.a(searchView1, "dialog!!.searchBar");
    SearchEditText searchEditText1 = searchView1.getEditView();
    Intrinsics.a(searchEditText1, "dialog!!.searchBar.editView");
    searchEditText1.setFocusableInTouchMode(true);
    Dialog dialog5 = getDialog();
    if (dialog5 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog5, "dialog!!");
    RecyclerView recyclerView4 = (RecyclerView)dialog5.findViewById(R.id.recyclerView);
    Intrinsics.a(recyclerView4, "dialog!!.recyclerView");
    recyclerView4.setClipToPadding(false);
    Dialog dialog4 = getDialog();
    if (dialog4 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog4, "dialog!!");
    RecyclerView recyclerView3 = (RecyclerView)dialog4.findViewById(R.id.recyclerView);
    Intrinsics.a(recyclerView3, "dialog!!.recyclerView");
    recyclerView3.setScrollBarStyle(33554432);
    Dialog dialog3 = getDialog();
    if (dialog3 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog3, "dialog!!");
    ((RecyclerView)dialog3.findViewById(R.id.recyclerView)).addOnScrollListener(new FeedPostTopicDialogFragment$initView$4());
    dialog3 = getDialog();
    if (dialog3 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog3, "dialog!!");
    RecyclerView recyclerView2 = (RecyclerView)dialog3.findViewById(R.id.recyclerView);
    Intrinsics.a(recyclerView2, "dialog!!.recyclerView");
    recyclerView2.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(getContext()));
    m();
    Dialog dialog2 = getDialog();
    if (dialog2 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog2, "dialog!!");
    RecyclerView recyclerView1 = (RecyclerView)dialog2.findViewById(R.id.recyclerView);
    Intrinsics.a(recyclerView1, "dialog!!.recyclerView");
    SuperTopicAdapter superTopicAdapter2 = this.a;
    if (superTopicAdapter2 == null)
      Intrinsics.b("superTopicAdapter"); 
    recyclerView1.setAdapter((RecyclerView.Adapter)superTopicAdapter2);
    SuperTopicAdapter superTopicAdapter1 = this.a;
    if (superTopicAdapter1 == null)
      Intrinsics.b("superTopicAdapter"); 
    superTopicAdapter1.a((BaseQuickAdapter.OnItemClickListener)new SingleItemClickProxy(new FeedPostTopicDialogFragment$initView$5(this)));
    superTopicAdapter1 = this.a;
    if (superTopicAdapter1 == null)
      Intrinsics.b("superTopicAdapter"); 
    superTopicAdapter1.a((LoadMoreView)new BluedAdapterLoadMoreView());
    superTopicAdapter1 = this.a;
    if (superTopicAdapter1 == null)
      Intrinsics.b("superTopicAdapter"); 
    superTopicAdapter1.c(true);
    superTopicAdapter1 = this.a;
    if (superTopicAdapter1 == null)
      Intrinsics.b("superTopicAdapter"); 
    FeedPostTopicDialogFragment$initView$6 feedPostTopicDialogFragment$initView$6 = new FeedPostTopicDialogFragment$initView$6(this);
    Dialog dialog13 = getDialog();
    if (dialog13 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog13, "dialog!!");
    superTopicAdapter1.a(feedPostTopicDialogFragment$initView$6, (RecyclerView)dialog13.findViewById(R.id.recyclerView));
    Dialog dialog1 = getDialog();
    if (dialog1 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog1, "dialog!!");
    ((RecyclerView)dialog1.findViewById(R.id.recyclerView)).setOnTouchListener(new FeedPostTopicDialogFragment$initView$7(this));
  }
  
  private final void l() {
    Dialog dialog = getDialog();
    if (dialog != null) {
      RecyclerView recyclerView = (RecyclerView)dialog.findViewById(R.id.recyclerView);
    } else {
      dialog = null;
    } 
    int[] arrayOfInt = ViewUtils.a((RecyclerView)dialog);
    FeedPostViewModel feedPostViewModel = this.d;
    if (feedPostViewModel == null)
      Intrinsics.b("mViewModel"); 
    feedPostViewModel.a(arrayOfInt[0]);
    feedPostViewModel = this.d;
    if (feedPostViewModel == null)
      Intrinsics.b("mViewModel"); 
    feedPostViewModel.b(arrayOfInt[1]);
  }
  
  private final void m() {
    Dialog dialog = getDialog();
    if (dialog != null) {
      RecyclerView recyclerView = (RecyclerView)dialog.findViewById(R.id.recyclerView);
    } else {
      dialog = null;
    } 
    FeedPostViewModel feedPostViewModel = this.d;
    if (feedPostViewModel == null)
      Intrinsics.b("mViewModel"); 
    int i = feedPostViewModel.h();
    feedPostViewModel = this.d;
    if (feedPostViewModel == null)
      Intrinsics.b("mViewModel"); 
    ViewUtils.a((RecyclerView)dialog, i, feedPostViewModel.i());
  }
  
  public final void a(String paramString1, String paramString2) {
    FeedPostViewModel feedPostViewModel = this.d;
    if (feedPostViewModel == null)
      Intrinsics.b("mViewModel"); 
    feedPostViewModel.f().setValue(new BluedTopic(paramString1, paramString2));
    dismiss();
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
  
  public final SuperTopicAdapter f() {
    SuperTopicAdapter superTopicAdapter = this.a;
    if (superTopicAdapter == null)
      Intrinsics.b("superTopicAdapter"); 
    return superTopicAdapter;
  }
  
  public final NoDataAndLoadFailView g() {
    NoDataAndLoadFailView noDataAndLoadFailView = this.b;
    if (noDataAndLoadFailView == null)
      Intrinsics.b("noDataView"); 
    return noDataAndLoadFailView;
  }
  
  public final void h() {
    dismiss();
  }
  
  public void i() {
    HashMap hashMap = this.e;
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
      this.d = (FeedPostViewModel)viewModel;
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
    paramDialog.setContentView(2131492991);
    BottomSheetBehavior bottomSheetBehavior = ((BottomSheetDialog)paramDialog).a();
    Intrinsics.a(bottomSheetBehavior, "(dialog as BottomSheetDialog).behavior");
    FeedPostViewModel feedPostViewModel = this.d;
    if (feedPostViewModel == null)
      Intrinsics.b("mViewModel"); 
    bottomSheetBehavior.a(feedPostViewModel.F());
    j();
    k();
    SuperTopicAdapter superTopicAdapter = this.a;
    if (superTopicAdapter == null)
      Intrinsics.b("superTopicAdapter"); 
    if (superTopicAdapter.n().size() <= 0) {
      FeedPostViewModel feedPostViewModel1 = this.d;
      if (feedPostViewModel1 == null)
        Intrinsics.b("mViewModel"); 
      SuperTopicAdapter superTopicAdapter1 = this.a;
      if (superTopicAdapter1 == null)
        Intrinsics.b("superTopicAdapter"); 
      feedPostViewModel1.a(true, superTopicAdapter1);
    } 
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\030\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\016\020\003\032\0020\0042\006\020\005\032\0020\006¨\006\007"}, d2 = {"Lcom/soft/blued/ui/feed/dialog/FeedPostTopicDialogFragment$Companion;", "", "()V", "show", "Lcom/soft/blued/ui/feed/dialog/FeedPostTopicDialogFragment;", "manager", "Landroidx/fragment/app/FragmentManager;", "blued_app_a9999aRelease"}, k = 1, mv = {1, 1, 16})
  public static final class Companion {
    private Companion() {}
    
    public final FeedPostTopicDialogFragment a(FragmentManager param1FragmentManager) {
      Intrinsics.b(param1FragmentManager, "manager");
      FeedPostTopicDialogFragment feedPostTopicDialogFragment = new FeedPostTopicDialogFragment();
      feedPostTopicDialogFragment.show(param1FragmentManager, FeedPostTopicDialogFragment.class.getSimpleName());
      return feedPostTopicDialogFragment;
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\024\n\000\n\002\020\002\n\000\n\002\020!\n\002\030\002\n\002\b\002\020\000\032\0020\0012\032\020\002\032\026\022\004\022\0020\004 \005*\n\022\004\022\0020\004\030\0010\0030\003H\n¢\006\002\b\006"}, d2 = {"<anonymous>", "", "it", "", "Lcom/soft/blued/ui/feed/model/BluedTopic;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 16})
  static final class FeedPostTopicDialogFragment$initData$1 extends Lambda implements Function1<List<BluedTopic>, Unit> {
    FeedPostTopicDialogFragment$initData$1(FeedPostTopicDialogFragment param1FeedPostTopicDialogFragment) {
      super(1);
    }
    
    public final void a(List<BluedTopic> param1List) {
      this.a.f().c(param1List);
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\020\n\000\n\002\020\002\n\000\n\002\020\016\n\002\b\002\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\003H\n¢\006\002\b\005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 16})
  static final class FeedPostTopicDialogFragment$initData$2 extends Lambda implements Function1<String, Unit> {
    FeedPostTopicDialogFragment$initData$2(FeedPostTopicDialogFragment param1FeedPostTopicDialogFragment) {
      super(1);
    }
    
    public final void a(String param1String) {
      this.a.f().a(param1String);
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\020\n\000\n\002\020\002\n\000\n\002\020\013\n\002\b\003\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\003H\n¢\006\004\b\005\020\006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 1, 16})
  static final class FeedPostTopicDialogFragment$initData$3 extends Lambda implements Function1<Boolean, Unit> {
    FeedPostTopicDialogFragment$initData$3(FeedPostTopicDialogFragment param1FeedPostTopicDialogFragment) {
      super(1);
    }
    
    public final void a(Boolean param1Boolean) {
      Intrinsics.a(param1Boolean, "it");
      if (param1Boolean.booleanValue()) {
        this.a.g().a();
        return;
      } 
      if (!param1Boolean.booleanValue())
        this.a.g().b(); 
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\020\n\000\n\002\020\002\n\000\n\002\020\013\n\002\b\003\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\003H\n¢\006\004\b\005\020\006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 1, 16})
  static final class FeedPostTopicDialogFragment$initData$4 extends Lambda implements Function1<Boolean, Unit> {
    FeedPostTopicDialogFragment$initData$4(FeedPostTopicDialogFragment param1FeedPostTopicDialogFragment) {
      super(1);
    }
    
    public final void a(Boolean param1Boolean) {
      Intrinsics.a(param1Boolean, "it");
      if (param1Boolean.booleanValue()) {
        if (FeedPostTopicDialogFragment.a(this.a).j()) {
          this.a.f().l();
          return;
        } 
        this.a.f().k();
        return;
      } 
      if (!param1Boolean.booleanValue()) {
        if (this.a.f().n().size() > 0) {
          this.a.f().m();
          return;
        } 
        this.a.f().c(false);
      } 
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\020\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\003H\n¢\006\002\b\005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
  static final class FeedPostTopicDialogFragment$initView$1 implements View.OnClickListener {
    FeedPostTopicDialogFragment$initView$1(FeedPostTopicDialogFragment param1FeedPostTopicDialogFragment) {}
    
    public final void onClick(View param1View) {
      this.a.h();
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\026\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\n\002\020\013\n\000\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\0032\006\020\005\032\0020\006H\n¢\006\002\b\007"}, d2 = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "isFocus", "", "onFocusChange"}, k = 3, mv = {1, 1, 16})
  static final class FeedPostTopicDialogFragment$initView$2 implements View.OnFocusChangeListener {
    FeedPostTopicDialogFragment$initView$2(FeedPostTopicDialogFragment param1FeedPostTopicDialogFragment) {}
    
    public final void onFocusChange(View param1View, boolean param1Boolean) {
      this.a.a(param1Boolean);
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\033\n\000\n\002\030\002\n\000\n\002\020\002\n\002\b\002\n\002\020\016\n\002\b\002*\001\000\b\n\030\0002\0020\001J\b\020\002\032\0020\003H\026J\020\020\004\032\0020\0032\006\020\005\032\0020\006H\026J\b\020\007\032\0020\003H\026¨\006\b"}, d2 = {"com/soft/blued/ui/feed/dialog/FeedPostTopicDialogFragment$initView$3", "Lcom/soft/blued/customview/SearchView$OnSearchInfoListener;", "clearContent", "", "doSearch", "msg", "", "onCancel", "blued_app_a9999aRelease"}, k = 1, mv = {1, 1, 16})
  public static final class FeedPostTopicDialogFragment$initView$3 implements SearchView.OnSearchInfoListener {
    FeedPostTopicDialogFragment$initView$3(FeedPostTopicDialogFragment param1FeedPostTopicDialogFragment) {}
    
    public void a() {
      this.a.h();
    }
    
    public void a(String param1String) {
      Intrinsics.b(param1String, "msg");
      this.a.f().c(null);
      this.a.g().c();
      if (TextUtils.isEmpty(param1String)) {
        this.a.f().c(true);
        FeedPostTopicDialogFragment.a(this.a).a(true, this.a.f());
        return;
      } 
      this.a.f().c(true);
      FeedPostTopicDialogFragment.a(this.a).a(true, param1String, this.a.f());
    }
    
    public void b() {}
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\037\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\000\n\002\020\b\n\002\b\002*\001\000\b\n\030\0002\0020\001J \020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\0072\006\020\b\032\0020\007H\026¨\006\t"}, d2 = {"com/soft/blued/ui/feed/dialog/FeedPostTopicDialogFragment$initView$4", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "blued_app_a9999aRelease"}, k = 1, mv = {1, 1, 16})
  public static final class FeedPostTopicDialogFragment$initView$4 extends RecyclerView.OnScrollListener {
    public void onScrolled(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {
      Intrinsics.b(param1RecyclerView, "recyclerView");
      super.onScrolled(param1RecyclerView, param1Int1, param1Int2);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("dx = ");
      stringBuilder.append(param1Int1);
      stringBuilder.append(", dy = ");
      stringBuilder.append(param1Int2);
      Logger.c("onScrolled", new Object[] { stringBuilder.toString() });
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000$\n\000\n\002\020\002\n\000\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\b\n\000\020\000\032\0020\00128\020\002\0324\022\f\022\n \005*\004\030\0010\0040\004\022\f\022\n \005*\004\030\0010\0060\006 \005*\017\022\002\b\003\022\002\b\003\030\0010\003¨\006\0010\003¨\006\0012\016\020\007\032\n \005*\004\030\0010\b0\b2\006\020\t\032\0020\nH\n¢\006\002\b\013"}, d2 = {"<anonymous>", "", "adapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "", "kotlin.jvm.PlatformType", "Lcom/chad/library/adapter/base/BaseViewHolder;", "view", "Landroid/view/View;", "position", "", "onItemClick"}, k = 3, mv = {1, 1, 16})
  static final class FeedPostTopicDialogFragment$initView$5 implements BaseQuickAdapter.OnItemClickListener {
    FeedPostTopicDialogFragment$initView$5(FeedPostTopicDialogFragment param1FeedPostTopicDialogFragment) {}
    
    public final void onItemClick(BaseQuickAdapter<Object, BaseViewHolder> param1BaseQuickAdapter, View param1View, int param1Int) {
      if (param1BaseQuickAdapter.e(param1Int) instanceof BluedTopic) {
        String str;
        BluedTopic bluedTopic = (BluedTopic)param1BaseQuickAdapter.e(param1Int);
        FeedPostTopicDialogFragment feedPostTopicDialogFragment = this.a;
        param1View = null;
        if (bluedTopic != null) {
          String str1 = bluedTopic.super_did;
        } else {
          param1BaseQuickAdapter = null;
        } 
        if (bluedTopic != null)
          str = bluedTopic.name; 
        feedPostTopicDialogFragment.a((String)param1BaseQuickAdapter, str);
        return;
      } 
      this.a.h();
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "onLoadMoreRequested"}, k = 3, mv = {1, 1, 16})
  static final class FeedPostTopicDialogFragment$initView$6 implements BaseQuickAdapter.RequestLoadMoreListener {
    FeedPostTopicDialogFragment$initView$6(FeedPostTopicDialogFragment param1FeedPostTopicDialogFragment) {}
    
    public final void onLoadMoreRequested() {
      boolean bool;
      Dialog dialog = this.a.getDialog();
      if (dialog == null)
        Intrinsics.a(); 
      Intrinsics.a(dialog, "dialog!!");
      SearchView searchView = (SearchView)dialog.findViewById(R.id.searchBar);
      Intrinsics.a(searchView, "dialog!!.searchBar");
      SearchEditText searchEditText = searchView.getEditView();
      Intrinsics.a(searchEditText, "dialog!!.searchBar.editView");
      String str = String.valueOf(searchEditText.getText());
      if (((CharSequence)str).length() == 0) {
        bool = true;
      } else {
        bool = false;
      } 
      if (bool) {
        FeedPostTopicDialogFragment.a(this.a).a(false, this.a.f());
        return;
      } 
      FeedPostTopicDialogFragment.a(this.a).a(false, str, this.a.f());
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\026\n\000\n\002\020\013\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\0032\016\020\005\032\n \004*\004\030\0010\0060\006H\n¢\006\002\b\007"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"}, k = 3, mv = {1, 1, 16})
  static final class FeedPostTopicDialogFragment$initView$7 implements View.OnTouchListener {
    FeedPostTopicDialogFragment$initView$7(FeedPostTopicDialogFragment param1FeedPostTopicDialogFragment) {}
    
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
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\dialog\FeedPostTopicDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */