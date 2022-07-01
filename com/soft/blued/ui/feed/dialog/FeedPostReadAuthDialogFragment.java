package com.soft.blued.ui.feed.dialog;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.common.base.mvvm.LifecycleExtKt;
import com.soft.blued.R;
import com.soft.blued.ui.feed.vm.FeedPostViewModel;
import com.soft.blued.view.tip.dialog.BottomSheetBehavior;
import com.soft.blued.view.tip.dialog.BottomSheetDialog;
import com.soft.blued.view.tip.dialog.BottomSheetDialogFragment;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\0002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\b\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\007\n\002\030\002\n\002\b\t\n\002\030\002\n\002\b\003\030\000 \0352\0020\001:\001\035B\005¢\006\002\020\002J\006\020\b\032\0020\tJ\006\020\n\032\0020\tJ\b\020\013\032\0020\tH\002J\b\020\f\032\0020\tH\002J\b\020\r\032\0020\tH\002J\b\020\016\032\0020\tH\002J\022\020\017\032\0020\t2\b\020\020\032\004\030\0010\021H\026J\b\020\022\032\0020\tH\002J\b\020\023\032\0020\tH\002J\b\020\024\032\0020\tH\002J\b\020\025\032\0020\tH\002J\b\020\026\032\0020\tH\002J\b\020\027\032\0020\tH\002J\b\020\030\032\0020\tH\002J\030\020\031\032\0020\t2\006\020\032\032\0020\0332\006\020\034\032\0020\004H\026R\016\020\003\032\0020\004X\016¢\006\002\n\000R\016\020\005\032\0020\006X.¢\006\002\n\000R\016\020\007\032\0020\004X\016¢\006\002\n\000¨\006\036"}, d2 = {"Lcom/soft/blued/ui/feed/dialog/FeedPostReadAuthDialogFragment;", "Lcom/soft/blued/view/tip/dialog/BottomSheetDialogFragment;", "()V", "commentPermission", "", "mViewModel", "Lcom/soft/blued/ui/feed/vm/FeedPostViewModel;", "readAuthPermission", "close", "", "done", "initCommentView", "initData", "initSeeView", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "selectCommentAll", "selectCommentFans", "selectCommentFollow", "selectCommentFollowFans", "selectSeeAll", "selectSeeFans", "selectSeeSelf", "setupDialog", "dialog", "Landroid/app/Dialog;", "style", "Companion", "blued_app_a9999aRelease"}, k = 1, mv = {1, 1, 16})
public final class FeedPostReadAuthDialogFragment extends BottomSheetDialogFragment {
  public static final Companion a = new Companion(null);
  
  private int b;
  
  private int c;
  
  private FeedPostViewModel d;
  
  private HashMap e;
  
  private final void i() {
    FeedPostViewModel feedPostViewModel = this.d;
    if (feedPostViewModel == null)
      Intrinsics.b("mViewModel"); 
    LifecycleExtKt.a((LifecycleOwner)this, (LiveData)feedPostViewModel.c(), new FeedPostReadAuthDialogFragment$initData$1(this));
    feedPostViewModel = this.d;
    if (feedPostViewModel == null)
      Intrinsics.b("mViewModel"); 
    LifecycleExtKt.a((LifecycleOwner)this, (LiveData)feedPostViewModel.d(), new FeedPostReadAuthDialogFragment$initData$2(this));
  }
  
  private final void j() {
    Dialog dialog2 = getDialog();
    if (dialog2 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog2, "dialog!!");
    FrameLayout frameLayout = (FrameLayout)dialog2.findViewById(R.id.rootLayout);
    Intrinsics.a(frameLayout, "dialog!!.rootLayout");
    ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
    FeedPostViewModel feedPostViewModel = this.d;
    if (feedPostViewModel == null)
      Intrinsics.b("mViewModel"); 
    layoutParams.height = feedPostViewModel.F();
    Dialog dialog1 = getDialog();
    if (dialog1 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog1, "dialog!!");
    ((ImageView)dialog1.findViewById(R.id.ivClose)).setOnClickListener(new FeedPostReadAuthDialogFragment$initView$1(this));
    dialog1 = getDialog();
    if (dialog1 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog1, "dialog!!");
    ((TextView)dialog1.findViewById(R.id.tvDone)).setOnClickListener(new FeedPostReadAuthDialogFragment$initView$2(this));
    dialog1 = getDialog();
    if (dialog1 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog1, "dialog!!");
    ((LinearLayout)dialog1.findViewById(R.id.layoutSeeAll)).setOnClickListener(new FeedPostReadAuthDialogFragment$initView$3(this));
    dialog1 = getDialog();
    if (dialog1 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog1, "dialog!!");
    ((LinearLayout)dialog1.findViewById(R.id.layoutSeeFans)).setOnClickListener(new FeedPostReadAuthDialogFragment$initView$4(this));
    dialog1 = getDialog();
    if (dialog1 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog1, "dialog!!");
    ((LinearLayout)dialog1.findViewById(R.id.layoutSeeSelf)).setOnClickListener(new FeedPostReadAuthDialogFragment$initView$5(this));
    dialog1 = getDialog();
    if (dialog1 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog1, "dialog!!");
    ((LinearLayout)dialog1.findViewById(R.id.layoutCommentAll)).setOnClickListener(new FeedPostReadAuthDialogFragment$initView$6(this));
    dialog1 = getDialog();
    if (dialog1 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog1, "dialog!!");
    ((LinearLayout)dialog1.findViewById(R.id.layoutCommentFollowFans)).setOnClickListener(new FeedPostReadAuthDialogFragment$initView$7(this));
    dialog1 = getDialog();
    if (dialog1 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog1, "dialog!!");
    ((LinearLayout)dialog1.findViewById(R.id.layoutCommentFollow)).setOnClickListener(new FeedPostReadAuthDialogFragment$initView$8(this));
    dialog1 = getDialog();
    if (dialog1 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog1, "dialog!!");
    ((LinearLayout)dialog1.findViewById(R.id.layoutCommentFans)).setOnClickListener(new FeedPostReadAuthDialogFragment$initView$9(this));
  }
  
  private final void k() {
    r();
    Dialog dialog2 = getDialog();
    if (dialog2 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog2, "dialog!!");
    TextView textView = (TextView)dialog2.findViewById(R.id.tvSeeAll);
    Context context = getContext();
    if (context == null)
      Intrinsics.a(); 
    Intrinsics.a(context, "context!!");
    textView.setTextColor(context.getResources().getColor(2131100716));
    Dialog dialog1 = getDialog();
    if (dialog1 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog1, "dialog!!");
    ImageView imageView = (ImageView)dialog1.findViewById(R.id.ivSeeAll);
    Intrinsics.a(imageView, "dialog!!.ivSeeAll");
    imageView.setVisibility(0);
    this.b = 0;
  }
  
  private final void l() {
    r();
    Dialog dialog2 = getDialog();
    if (dialog2 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog2, "dialog!!");
    TextView textView = (TextView)dialog2.findViewById(R.id.tvSeeFans);
    Context context = getContext();
    if (context == null)
      Intrinsics.a(); 
    Intrinsics.a(context, "context!!");
    textView.setTextColor(context.getResources().getColor(2131100716));
    Dialog dialog1 = getDialog();
    if (dialog1 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog1, "dialog!!");
    ImageView imageView = (ImageView)dialog1.findViewById(R.id.ivSeeFans);
    Intrinsics.a(imageView, "dialog!!.ivSeeFans");
    imageView.setVisibility(0);
    this.b = 1;
  }
  
  private final void m() {
    r();
    Dialog dialog2 = getDialog();
    if (dialog2 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog2, "dialog!!");
    TextView textView = (TextView)dialog2.findViewById(R.id.tvSeeSelf);
    Context context = getContext();
    if (context == null)
      Intrinsics.a(); 
    Intrinsics.a(context, "context!!");
    textView.setTextColor(context.getResources().getColor(2131100716));
    Dialog dialog1 = getDialog();
    if (dialog1 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog1, "dialog!!");
    ImageView imageView = (ImageView)dialog1.findViewById(R.id.ivSeeSelf);
    Intrinsics.a(imageView, "dialog!!.ivSeeSelf");
    imageView.setVisibility(0);
    this.b = 2;
  }
  
  private final void n() {
    s();
    Dialog dialog2 = getDialog();
    if (dialog2 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog2, "dialog!!");
    TextView textView = (TextView)dialog2.findViewById(R.id.tvCommentAll);
    Context context = getContext();
    if (context == null)
      Intrinsics.a(); 
    Intrinsics.a(context, "context!!");
    textView.setTextColor(context.getResources().getColor(2131100716));
    Dialog dialog1 = getDialog();
    if (dialog1 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog1, "dialog!!");
    ImageView imageView = (ImageView)dialog1.findViewById(R.id.ivCommentAll);
    Intrinsics.a(imageView, "dialog!!.ivCommentAll");
    imageView.setVisibility(0);
    this.c = 0;
  }
  
  private final void o() {
    s();
    Dialog dialog2 = getDialog();
    if (dialog2 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog2, "dialog!!");
    TextView textView = (TextView)dialog2.findViewById(R.id.tvCommentFollowFans);
    Context context = getContext();
    if (context == null)
      Intrinsics.a(); 
    Intrinsics.a(context, "context!!");
    textView.setTextColor(context.getResources().getColor(2131100716));
    Dialog dialog1 = getDialog();
    if (dialog1 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog1, "dialog!!");
    ImageView imageView = (ImageView)dialog1.findViewById(R.id.ivCommentFollowFans);
    Intrinsics.a(imageView, "dialog!!.ivCommentFollowFans");
    imageView.setVisibility(0);
    this.c = 1;
  }
  
  private final void p() {
    s();
    Dialog dialog2 = getDialog();
    if (dialog2 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog2, "dialog!!");
    TextView textView = (TextView)dialog2.findViewById(R.id.tvCommentFollow);
    Context context = getContext();
    if (context == null)
      Intrinsics.a(); 
    Intrinsics.a(context, "context!!");
    textView.setTextColor(context.getResources().getColor(2131100716));
    Dialog dialog1 = getDialog();
    if (dialog1 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog1, "dialog!!");
    ImageView imageView = (ImageView)dialog1.findViewById(R.id.ivCommentFollow);
    Intrinsics.a(imageView, "dialog!!.ivCommentFollow");
    imageView.setVisibility(0);
    this.c = 2;
  }
  
  private final void q() {
    s();
    Dialog dialog2 = getDialog();
    if (dialog2 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog2, "dialog!!");
    TextView textView = (TextView)dialog2.findViewById(R.id.tvCommentFans);
    Context context = getContext();
    if (context == null)
      Intrinsics.a(); 
    Intrinsics.a(context, "context!!");
    textView.setTextColor(context.getResources().getColor(2131100716));
    Dialog dialog1 = getDialog();
    if (dialog1 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog1, "dialog!!");
    ImageView imageView = (ImageView)dialog1.findViewById(R.id.ivCommentFans);
    Intrinsics.a(imageView, "dialog!!.ivCommentFans");
    imageView.setVisibility(0);
    this.c = 3;
  }
  
  private final void r() {
    Dialog dialog3 = getDialog();
    if (dialog3 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog3, "dialog!!");
    ((TextView)dialog3.findViewById(R.id.tvSeeAll)).setTextColor(BluedSkinUtils.a(getContext(), 2131100838));
    dialog3 = getDialog();
    if (dialog3 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog3, "dialog!!");
    ImageView imageView3 = (ImageView)dialog3.findViewById(R.id.ivSeeAll);
    Intrinsics.a(imageView3, "dialog!!.ivSeeAll");
    imageView3.setVisibility(8);
    Dialog dialog2 = getDialog();
    if (dialog2 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog2, "dialog!!");
    ((TextView)dialog2.findViewById(R.id.tvSeeFans)).setTextColor(BluedSkinUtils.a(getContext(), 2131100838));
    dialog2 = getDialog();
    if (dialog2 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog2, "dialog!!");
    ImageView imageView2 = (ImageView)dialog2.findViewById(R.id.ivSeeFans);
    Intrinsics.a(imageView2, "dialog!!.ivSeeFans");
    imageView2.setVisibility(8);
    Dialog dialog1 = getDialog();
    if (dialog1 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog1, "dialog!!");
    ((TextView)dialog1.findViewById(R.id.tvSeeSelf)).setTextColor(BluedSkinUtils.a(getContext(), 2131100838));
    dialog1 = getDialog();
    if (dialog1 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog1, "dialog!!");
    ImageView imageView1 = (ImageView)dialog1.findViewById(R.id.ivSeeSelf);
    Intrinsics.a(imageView1, "dialog!!.ivSeeSelf");
    imageView1.setVisibility(8);
  }
  
  private final void s() {
    Dialog dialog4 = getDialog();
    if (dialog4 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog4, "dialog!!");
    ((TextView)dialog4.findViewById(R.id.tvCommentAll)).setTextColor(BluedSkinUtils.a(getContext(), 2131100838));
    dialog4 = getDialog();
    if (dialog4 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog4, "dialog!!");
    ImageView imageView4 = (ImageView)dialog4.findViewById(R.id.ivCommentAll);
    Intrinsics.a(imageView4, "dialog!!.ivCommentAll");
    imageView4.setVisibility(8);
    Dialog dialog3 = getDialog();
    if (dialog3 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog3, "dialog!!");
    ((TextView)dialog3.findViewById(R.id.tvCommentFollowFans)).setTextColor(BluedSkinUtils.a(getContext(), 2131100838));
    dialog3 = getDialog();
    if (dialog3 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog3, "dialog!!");
    ImageView imageView3 = (ImageView)dialog3.findViewById(R.id.ivCommentFollowFans);
    Intrinsics.a(imageView3, "dialog!!.ivCommentFollowFans");
    imageView3.setVisibility(8);
    Dialog dialog2 = getDialog();
    if (dialog2 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog2, "dialog!!");
    ((TextView)dialog2.findViewById(R.id.tvCommentFollow)).setTextColor(BluedSkinUtils.a(getContext(), 2131100838));
    dialog2 = getDialog();
    if (dialog2 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog2, "dialog!!");
    ImageView imageView2 = (ImageView)dialog2.findViewById(R.id.ivCommentFollow);
    Intrinsics.a(imageView2, "dialog!!.ivCommentFollow");
    imageView2.setVisibility(8);
    Dialog dialog1 = getDialog();
    if (dialog1 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog1, "dialog!!");
    ((TextView)dialog1.findViewById(R.id.tvCommentFans)).setTextColor(BluedSkinUtils.a(getContext(), 2131100838));
    dialog1 = getDialog();
    if (dialog1 == null)
      Intrinsics.a(); 
    Intrinsics.a(dialog1, "dialog!!");
    ImageView imageView1 = (ImageView)dialog1.findViewById(R.id.ivCommentFans);
    Intrinsics.a(imageView1, "dialog!!.ivCommentFans");
    imageView1.setVisibility(8);
  }
  
  public final void f() {
    FeedPostViewModel feedPostViewModel = this.d;
    if (feedPostViewModel == null)
      Intrinsics.b("mViewModel"); 
    feedPostViewModel.c().setValue(Integer.valueOf(this.b));
    feedPostViewModel = this.d;
    if (feedPostViewModel == null)
      Intrinsics.b("mViewModel"); 
    feedPostViewModel.d().setValue(Integer.valueOf(this.c));
    dismiss();
  }
  
  public final void g() {
    dismiss();
  }
  
  public void h() {
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
  
  public void setupDialog(Dialog paramDialog, int paramInt) {
    Intrinsics.b(paramDialog, "dialog");
    super.setupDialog(paramDialog, paramInt);
    paramDialog.setContentView(2131492990);
    BottomSheetBehavior bottomSheetBehavior = ((BottomSheetDialog)paramDialog).a();
    Intrinsics.a(bottomSheetBehavior, "(dialog as BottomSheetDialog).behavior");
    FeedPostViewModel feedPostViewModel = this.d;
    if (feedPostViewModel == null)
      Intrinsics.b("mViewModel"); 
    bottomSheetBehavior.a(feedPostViewModel.F());
    i();
    j();
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\030\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\016\020\003\032\0020\0042\006\020\005\032\0020\006¨\006\007"}, d2 = {"Lcom/soft/blued/ui/feed/dialog/FeedPostReadAuthDialogFragment$Companion;", "", "()V", "show", "Lcom/soft/blued/ui/feed/dialog/FeedPostReadAuthDialogFragment;", "manager", "Landroidx/fragment/app/FragmentManager;", "blued_app_a9999aRelease"}, k = 1, mv = {1, 1, 16})
  public static final class Companion {
    private Companion() {}
    
    public final FeedPostReadAuthDialogFragment a(FragmentManager param1FragmentManager) {
      Intrinsics.b(param1FragmentManager, "manager");
      FeedPostReadAuthDialogFragment feedPostReadAuthDialogFragment = new FeedPostReadAuthDialogFragment();
      feedPostReadAuthDialogFragment.show(param1FragmentManager, FeedPostReadAuthDialogFragment.class.getSimpleName());
      return feedPostReadAuthDialogFragment;
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\020\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\003\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\003H\n¢\006\004\b\005\020\006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 1, 16})
  static final class FeedPostReadAuthDialogFragment$initData$1 extends Lambda implements Function1<Integer, Unit> {
    FeedPostReadAuthDialogFragment$initData$1(FeedPostReadAuthDialogFragment param1FeedPostReadAuthDialogFragment) {
      super(1);
    }
    
    public final void a(Integer param1Integer) {
      if (param1Integer != null && param1Integer.intValue() == 0) {
        FeedPostReadAuthDialogFragment.a(this.a);
        return;
      } 
      if (param1Integer != null && param1Integer.intValue() == 1) {
        FeedPostReadAuthDialogFragment.b(this.a);
        return;
      } 
      if (param1Integer != null && param1Integer.intValue() == 2) {
        FeedPostReadAuthDialogFragment.c(this.a);
        return;
      } 
      FeedPostReadAuthDialogFragment.a(this.a);
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\020\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\003\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\003H\n¢\006\004\b\005\020\006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 1, 16})
  static final class FeedPostReadAuthDialogFragment$initData$2 extends Lambda implements Function1<Integer, Unit> {
    FeedPostReadAuthDialogFragment$initData$2(FeedPostReadAuthDialogFragment param1FeedPostReadAuthDialogFragment) {
      super(1);
    }
    
    public final void a(Integer param1Integer) {
      if (param1Integer != null && param1Integer.intValue() == 0) {
        FeedPostReadAuthDialogFragment.d(this.a);
        return;
      } 
      if (param1Integer != null && param1Integer.intValue() == 1) {
        FeedPostReadAuthDialogFragment.e(this.a);
        return;
      } 
      if (param1Integer != null && param1Integer.intValue() == 2) {
        FeedPostReadAuthDialogFragment.f(this.a);
        return;
      } 
      if (param1Integer != null && param1Integer.intValue() == 3) {
        FeedPostReadAuthDialogFragment.g(this.a);
        return;
      } 
      FeedPostReadAuthDialogFragment.d(this.a);
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\020\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\003H\n¢\006\002\b\005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
  static final class FeedPostReadAuthDialogFragment$initView$1 implements View.OnClickListener {
    FeedPostReadAuthDialogFragment$initView$1(FeedPostReadAuthDialogFragment param1FeedPostReadAuthDialogFragment) {}
    
    public final void onClick(View param1View) {
      this.a.g();
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\020\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\003H\n¢\006\002\b\005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
  static final class FeedPostReadAuthDialogFragment$initView$2 implements View.OnClickListener {
    FeedPostReadAuthDialogFragment$initView$2(FeedPostReadAuthDialogFragment param1FeedPostReadAuthDialogFragment) {}
    
    public final void onClick(View param1View) {
      this.a.f();
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\020\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\003H\n¢\006\002\b\005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
  static final class FeedPostReadAuthDialogFragment$initView$3 implements View.OnClickListener {
    FeedPostReadAuthDialogFragment$initView$3(FeedPostReadAuthDialogFragment param1FeedPostReadAuthDialogFragment) {}
    
    public final void onClick(View param1View) {
      FeedPostReadAuthDialogFragment.a(this.a);
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\020\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\003H\n¢\006\002\b\005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
  static final class FeedPostReadAuthDialogFragment$initView$4 implements View.OnClickListener {
    FeedPostReadAuthDialogFragment$initView$4(FeedPostReadAuthDialogFragment param1FeedPostReadAuthDialogFragment) {}
    
    public final void onClick(View param1View) {
      FeedPostReadAuthDialogFragment.b(this.a);
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\020\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\003H\n¢\006\002\b\005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
  static final class FeedPostReadAuthDialogFragment$initView$5 implements View.OnClickListener {
    FeedPostReadAuthDialogFragment$initView$5(FeedPostReadAuthDialogFragment param1FeedPostReadAuthDialogFragment) {}
    
    public final void onClick(View param1View) {
      FeedPostReadAuthDialogFragment.c(this.a);
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\020\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\003H\n¢\006\002\b\005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
  static final class FeedPostReadAuthDialogFragment$initView$6 implements View.OnClickListener {
    FeedPostReadAuthDialogFragment$initView$6(FeedPostReadAuthDialogFragment param1FeedPostReadAuthDialogFragment) {}
    
    public final void onClick(View param1View) {
      FeedPostReadAuthDialogFragment.d(this.a);
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\020\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\003H\n¢\006\002\b\005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
  static final class FeedPostReadAuthDialogFragment$initView$7 implements View.OnClickListener {
    FeedPostReadAuthDialogFragment$initView$7(FeedPostReadAuthDialogFragment param1FeedPostReadAuthDialogFragment) {}
    
    public final void onClick(View param1View) {
      FeedPostReadAuthDialogFragment.e(this.a);
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\020\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\003H\n¢\006\002\b\005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
  static final class FeedPostReadAuthDialogFragment$initView$8 implements View.OnClickListener {
    FeedPostReadAuthDialogFragment$initView$8(FeedPostReadAuthDialogFragment param1FeedPostReadAuthDialogFragment) {}
    
    public final void onClick(View param1View) {
      FeedPostReadAuthDialogFragment.f(this.a);
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\020\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\003H\n¢\006\002\b\005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
  static final class FeedPostReadAuthDialogFragment$initView$9 implements View.OnClickListener {
    FeedPostReadAuthDialogFragment$initView$9(FeedPostReadAuthDialogFragment param1FeedPostReadAuthDialogFragment) {}
    
    public final void onClick(View param1View) {
      FeedPostReadAuthDialogFragment.g(this.a);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\dialog\FeedPostReadAuthDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */