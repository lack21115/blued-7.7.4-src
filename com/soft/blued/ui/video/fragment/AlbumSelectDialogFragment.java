package com.soft.blued.ui.video.fragment;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.DelayRepeatTaskUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.das.client.feed.FeedProtos;
import com.soft.blued.R;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.feed.vm.FeedPostViewModel;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.PermissionUtils;
import com.soft.blued.utils.PopMenuUtils;
import com.soft.blued.utils.ViewUtils;
import com.soft.blued.view.tip.dialog.BottomSheetBehavior;
import com.soft.blued.view.tip.dialog.BottomSheetDialog;
import com.soft.blued.view.tip.dialog.BottomSheetDialogFragment;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\000\001\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\004\n\002\030\002\n\000\n\002\030\002\n\002\b\005\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\013\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\002\n\002\020\007\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\020\016\n\002\b\003\030\000 62\0020\001:\00256B\005¢\006\002\020\002J\b\020\031\032\0020\004H\002J\006\020\032\032\0020\033J\022\020\034\032\0020\0332\b\020\035\032\004\030\0010\036H\026J\022\020\037\032\0020\0332\b\020\035\032\004\030\0010\036H\026J&\020 \032\004\030\0010\0242\006\020!\032\0020\"2\b\020#\032\004\030\0010$2\b\020\035\032\004\030\0010\036H\026J\b\020%\032\0020\033H\026J\020\020&\032\0020\0332\006\020'\032\0020(H\026J\020\020)\032\0020\0332\006\020*\032\0020+H\002J\020\020,\032\0020\0332\006\020*\032\0020+H\002J\030\020-\032\0020\0332\006\020'\032\0020.2\006\020/\032\0020\004H\026J\032\0200\032\0020\0332\006\0201\032\002022\b\0203\032\004\030\00104H\026R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\004X\004¢\006\002\n\000R\016\020\006\032\0020\004XD¢\006\002\n\000R\016\020\007\032\0020\004X\004¢\006\002\n\000R\016\020\b\032\0020\tX.¢\006\002\n\000R\034\020\n\032\004\030\0010\013X\016¢\006\016\n\000\032\004\b\f\020\r\"\004\b\016\020\017R\024\020\020\032\b\022\004\022\0020\0220\021X.¢\006\002\n\000R\020\020\023\032\004\030\0010\024X\016¢\006\002\n\000R\016\020\025\032\0020\026X\016¢\006\002\n\000R\016\020\027\032\0020\030X.¢\006\002\n\000¨\0067"}, d2 = {"Lcom/soft/blued/ui/video/fragment/AlbumSelectDialogFragment;", "Lcom/soft/blued/view/tip/dialog/BottomSheetDialogFragment;", "()V", "IMAGE_SELECT_HEIGHT", "", "IMAGE_TITLE", "MARGIN_TOP", "PEEK_HEIGHT", "albumSelectFragment", "Lcom/soft/blued/ui/video/fragment/AlbumSelectHalfFragment;", "albumSelectOnDismissListener", "Lcom/soft/blued/ui/video/fragment/AlbumSelectDialogFragment$AlbumSelectOnDismissListener;", "getAlbumSelectOnDismissListener", "()Lcom/soft/blued/ui/video/fragment/AlbumSelectDialogFragment$AlbumSelectOnDismissListener;", "setAlbumSelectOnDismissListener", "(Lcom/soft/blued/ui/video/fragment/AlbumSelectDialogFragment$AlbumSelectOnDismissListener;)V", "behavior", "Lcom/soft/blued/view/tip/dialog/BottomSheetBehavior;", "Landroid/widget/FrameLayout;", "contentView", "Landroid/view/View;", "isShowPeek", "", "mViewModel", "Lcom/soft/blued/ui/feed/vm/FeedPostViewModel;", "getDialogHeight", "init", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "setTitleAlpha", "alpha", "", "setWindowDimAmount", "setupDialog", "Landroid/app/Dialog;", "style", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "", "AlbumSelectOnDismissListener", "Companion", "blued_app_a9999aRelease"}, k = 1, mv = {1, 1, 16})
public final class AlbumSelectDialogFragment extends BottomSheetDialogFragment {
  public static final Companion a = new Companion(null);
  
  private final int b;
  
  private final int c;
  
  private final int d;
  
  private final int e;
  
  private View f;
  
  private FeedPostViewModel g;
  
  private AlbumSelectHalfFragment h;
  
  private BottomSheetBehavior<FrameLayout> i;
  
  private boolean j;
  
  private AlbumSelectOnDismissListener k;
  
  private HashMap l;
  
  public AlbumSelectDialogFragment() {
    int i = KeyboardUtils.a();
    if (i <= 0)
      i = DensityUtils.a(AppInfo.d(), 320.0F); 
    this.c = i;
    this.d = DensityUtils.a(AppInfo.d(), 54.0F);
    this.e = this.c + this.d;
  }
  
  private final void a(float paramFloat) {
    Dialog dialog = getDialog();
    if (dialog != null) {
      Window window = dialog.getWindow();
      if (window != null)
        window.setDimAmount(paramFloat); 
    } 
  }
  
  private final void b(float paramFloat) {
    View view = this.f;
    if (view != null) {
      ShapeFrameLayout shapeFrameLayout = (ShapeFrameLayout)view.findViewById(R.id.titleTouch);
      if (shapeFrameLayout != null)
        shapeFrameLayout.setAlpha(paramFloat); 
    } 
    view = this.f;
    if (view != null) {
      view = view.findViewById(R.id.viewTitleBg);
      if (view != null)
        view.setAlpha(paramFloat); 
    } 
    if (paramFloat == 0.0F) {
      view = this.f;
      if (view != null) {
        ShapeFrameLayout shapeFrameLayout = (ShapeFrameLayout)view.findViewById(R.id.titleTouch);
        if (shapeFrameLayout != null)
          shapeFrameLayout.setVisibility(4); 
      } 
      view = this.f;
      if (view != null) {
        view = view.findViewById(R.id.viewTitleBg);
        if (view != null)
          view.setVisibility(4); 
      } 
    } else {
      view = this.f;
      if (view != null) {
        ShapeFrameLayout shapeFrameLayout = (ShapeFrameLayout)view.findViewById(R.id.titleTouch);
        if (shapeFrameLayout != null)
          shapeFrameLayout.setVisibility(0); 
      } 
      view = this.f;
      if (view != null) {
        view = view.findViewById(R.id.viewTitleBg);
        if (view != null)
          view.setVisibility(0); 
      } 
    } 
    AlbumSelectHalfFragment albumSelectHalfFragment = this.h;
    if (albumSelectHalfFragment == null)
      Intrinsics.b("albumSelectFragment"); 
    if (albumSelectHalfFragment != null)
      albumSelectHalfFragment.a(paramFloat); 
  }
  
  private final int i() {
    FeedPostViewModel feedPostViewModel = this.g;
    if (feedPostViewModel == null)
      Intrinsics.b("mViewModel"); 
    return feedPostViewModel.F() - this.b;
  }
  
  public final void a(AlbumSelectOnDismissListener paramAlbumSelectOnDismissListener) {
    this.k = paramAlbumSelectOnDismissListener;
  }
  
  public final AlbumSelectOnDismissListener f() {
    return this.k;
  }
  
  public final void g() {
    this.h = new AlbumSelectHalfFragment();
    FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
    AlbumSelectHalfFragment albumSelectHalfFragment2 = this.h;
    if (albumSelectHalfFragment2 == null)
      Intrinsics.b("albumSelectFragment"); 
    fragmentTransaction.replace(2131297219, (Fragment)albumSelectHalfFragment2).commit();
    AlbumSelectHalfFragment albumSelectHalfFragment1 = this.h;
    if (albumSelectHalfFragment1 == null)
      Intrinsics.b("albumSelectFragment"); 
    albumSelectHalfFragment1.a(new AlbumSelectDialogFragment$init$1(this));
    if (this.j) {
      BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.i;
      if (bottomSheetBehavior == null)
        Intrinsics.b("behavior"); 
      bottomSheetBehavior.a(this.e);
      a(0.0F);
      b(0.0F);
      FeedPostViewModel feedPostViewModel = this.g;
      if (feedPostViewModel == null)
        Intrinsics.b("mViewModel"); 
      feedPostViewModel.y().setValue(Integer.valueOf(this.c));
    } else {
      BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.i;
      if (bottomSheetBehavior == null)
        Intrinsics.b("behavior"); 
      bottomSheetBehavior.a(i());
    } 
    AlbumSelectDialogFragment$init$onTouchListener$1 albumSelectDialogFragment$init$onTouchListener$1 = new AlbumSelectDialogFragment$init$onTouchListener$1(this);
    Dialog dialog = getDialog();
    if (dialog == null)
      Intrinsics.a(); 
    View view2 = dialog.findViewById(2131300309);
    if (view2 != null)
      view2.setOnTouchListener(albumSelectDialogFragment$init$onTouchListener$1); 
    view2 = this.f;
    if (view2 == null)
      Intrinsics.a(); 
    ShapeFrameLayout shapeFrameLayout = (ShapeFrameLayout)view2.findViewById(R.id.titleTouch);
    albumSelectDialogFragment$init$onTouchListener$1 = albumSelectDialogFragment$init$onTouchListener$1;
    shapeFrameLayout.setOnTouchListener(albumSelectDialogFragment$init$onTouchListener$1);
    View view1 = this.f;
    if (view1 == null)
      Intrinsics.a(); 
    view1.findViewById(R.id.titleBarTouch).setOnTouchListener(albumSelectDialogFragment$init$onTouchListener$1);
    a(new AlbumSelectDialogFragment$init$2(this));
  }
  
  public void h() {
    HashMap hashMap = this.l;
    if (hashMap != null)
      hashMap.clear(); 
  }
  
  public void onActivityCreated(Bundle paramBundle) {
    super.onActivityCreated(paramBundle);
    g();
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
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    Intrinsics.b(paramLayoutInflater, "inflater");
    this.f = paramLayoutInflater.inflate(2131492974, paramViewGroup, false);
    return this.f;
  }
  
  public void onDestroyView() {
    super.onDestroyView();
    FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
    AlbumSelectHalfFragment albumSelectHalfFragment = this.h;
    if (albumSelectHalfFragment == null)
      Intrinsics.b("albumSelectFragment"); 
    fragmentTransaction.remove((Fragment)albumSelectHalfFragment).commitAllowingStateLoss();
    h();
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {
    Intrinsics.b(paramDialogInterface, "dialog");
    FeedPostViewModel feedPostViewModel = this.g;
    if (feedPostViewModel == null)
      Intrinsics.b("mViewModel"); 
    feedPostViewModel.y().setValue(Integer.valueOf(0));
    AlbumSelectOnDismissListener albumSelectOnDismissListener = this.k;
    if (albumSelectOnDismissListener != null)
      albumSelectOnDismissListener.a((DialogFragment)this, null); 
    super.onDismiss(paramDialogInterface);
  }
  
  public void setupDialog(Dialog paramDialog, int paramInt) {
    Intrinsics.b(paramDialog, "dialog");
    super.setupDialog(paramDialog, paramInt);
    Bundle bundle = getArguments();
    if (bundle == null)
      Intrinsics.a(); 
    this.j = bundle.getBoolean("show_peek");
    FeedPostViewModel feedPostViewModel = this.g;
    if (feedPostViewModel == null)
      Intrinsics.b("mViewModel"); 
    feedPostViewModel.d(this.j);
    BottomSheetBehavior<FrameLayout> bottomSheetBehavior = ((BottomSheetDialog)paramDialog).a();
    Intrinsics.a(bottomSheetBehavior, "(dialog as BottomSheetDialog).behavior");
    this.i = bottomSheetBehavior;
    bottomSheetBehavior = this.i;
    if (bottomSheetBehavior == null)
      Intrinsics.b("behavior"); 
    bottomSheetBehavior.a(new AlbumSelectDialogFragment$setupDialog$1(this));
  }
  
  public void show(FragmentManager paramFragmentManager, String paramString) {
    Intrinsics.b(paramFragmentManager, "manager");
    DelayRepeatTaskUtils.a("AlbumSelectDialogFragmentShow", new AlbumSelectDialogFragment$show$1(this, paramFragmentManager, paramString));
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000$\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\bf\030\0002\0020\001J\024\020\002\032\004\030\0010\0032\b\020\004\032\004\030\0010\005H&J\032\020\006\032\0020\0072\006\020\b\032\0020\t2\b\020\n\032\004\030\0010\003H&¨\006\013"}, d2 = {"Lcom/soft/blued/ui/video/fragment/AlbumSelectDialogFragment$AlbumSelectOnDismissListener;", "", "getClickView", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "onDismiss", "", "dialog", "Landroidx/fragment/app/DialogFragment;", "clickView", "blued_app_a9999aRelease"}, k = 1, mv = {1, 1, 16})
  public static interface AlbumSelectOnDismissListener {
    View a(MotionEvent param1MotionEvent);
    
    void a(DialogFragment param1DialogFragment, View param1View);
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000.\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\b\n\002\b\002\n\002\020\016\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\005\n\002\020\013\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J6\020\b\032\0020\t2\006\020\n\032\0020\0132\006\020\f\032\0020\0042\006\020\r\032\0020\0042\006\020\016\032\0020\0042\006\020\017\032\0020\0042\006\020\020\032\0020\021R\016\020\003\032\0020\004XT¢\006\002\n\000R\016\020\005\032\0020\004XT¢\006\002\n\000R\016\020\006\032\0020\007XT¢\006\002\n\000¨\006\022"}, d2 = {"Lcom/soft/blued/ui/video/fragment/AlbumSelectDialogFragment$Companion;", "", "()V", "NOT_DISMISS", "", "SHOW_FULL", "SHOW_PEEK", "", "show", "Lcom/soft/blued/ui/video/fragment/AlbumSelectDialogFragment;", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "from", "albumDataType", "selectPhotoMaxNum", "pageType", "isFirstShow", "", "blued_app_a9999aRelease"}, k = 1, mv = {1, 1, 16})
  public static final class Companion {
    private Companion() {}
    
    public final AlbumSelectDialogFragment a(FragmentActivity param1FragmentActivity, int param1Int1, int param1Int2, int param1Int3, int param1Int4, boolean param1Boolean) {
      Intrinsics.b(param1FragmentActivity, "fragmentActivity");
      AlbumSelectDialogFragment albumSelectDialogFragment = new AlbumSelectDialogFragment();
      Bundle bundle = AlbumSelectFragment.a(param1Int1, param1Int2, param1Int3, param1Int4);
      bundle.putBoolean("show_peek", param1Boolean);
      albumSelectDialogFragment.setArguments(bundle);
      if (!PopMenuUtils.a((Context)param1FragmentActivity, null))
        PermissionUtils.b(new AlbumSelectDialogFragment$Companion$show$1(albumSelectDialogFragment, param1FragmentActivity)); 
      return albumSelectDialogFragment;
    }
    
    @Metadata(bv = {1, 0, 3}, d1 = {"\000\035\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\021\n\002\020\016\n\002\b\003*\001\000\b\n\030\0002\0020\001J\033\020\002\032\0020\0032\f\020\004\032\b\022\004\022\0020\0060\005H\026¢\006\002\020\007J\b\020\b\032\0020\003H\026¨\006\t"}, d2 = {"com/soft/blued/ui/video/fragment/AlbumSelectDialogFragment$Companion$show$1", "Lcom/blued/android/framework/permission/PermissionCallbacks;", "onPermissionsDenied", "", "perms", "", "", "([Ljava/lang/String;)V", "onPermissionsGranted", "blued_app_a9999aRelease"}, k = 1, mv = {1, 1, 16})
    public static final class AlbumSelectDialogFragment$Companion$show$1 implements PermissionCallbacks {
      AlbumSelectDialogFragment$Companion$show$1(AlbumSelectDialogFragment param2AlbumSelectDialogFragment, FragmentActivity param2FragmentActivity) {}
      
      public void a(String[] param2ArrayOfString) {
        Intrinsics.b(param2ArrayOfString, "perms");
      }
      
      public void aa_() {
        AlbumSelectDialogFragment albumSelectDialogFragment = this.a;
        FragmentManager fragmentManager = this.b.getSupportFragmentManager();
        Intrinsics.a(fragmentManager, "fragmentActivity.supportFragmentManager");
        albumSelectDialogFragment.show(fragmentManager, AlbumSelectDialogFragment.class.getSimpleName());
      }
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\035\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\021\n\002\020\016\n\002\b\003*\001\000\b\n\030\0002\0020\001J\033\020\002\032\0020\0032\f\020\004\032\b\022\004\022\0020\0060\005H\026¢\006\002\020\007J\b\020\b\032\0020\003H\026¨\006\t"}, d2 = {"com/soft/blued/ui/video/fragment/AlbumSelectDialogFragment$Companion$show$1", "Lcom/blued/android/framework/permission/PermissionCallbacks;", "onPermissionsDenied", "", "perms", "", "", "([Ljava/lang/String;)V", "onPermissionsGranted", "blued_app_a9999aRelease"}, k = 1, mv = {1, 1, 16})
  public static final class AlbumSelectDialogFragment$Companion$show$1 implements PermissionCallbacks {
    AlbumSelectDialogFragment$Companion$show$1(AlbumSelectDialogFragment param1AlbumSelectDialogFragment, FragmentActivity param1FragmentActivity) {}
    
    public void a(String[] param1ArrayOfString) {
      Intrinsics.b(param1ArrayOfString, "perms");
    }
    
    public void aa_() {
      AlbumSelectDialogFragment albumSelectDialogFragment = this.a;
      FragmentManager fragmentManager = this.b.getSupportFragmentManager();
      Intrinsics.a(fragmentManager, "fragmentActivity.supportFragmentManager");
      albumSelectDialogFragment.show(fragmentManager, AlbumSelectDialogFragment.class.getSimpleName());
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "onClosePage"}, k = 3, mv = {1, 1, 16})
  static final class AlbumSelectDialogFragment$init$1 implements AlbumSelectHalfFragment.OnClosePageListener {
    AlbumSelectDialogFragment$init$1(AlbumSelectDialogFragment param1AlbumSelectDialogFragment) {}
    
    public final void a() {
      this.a.dismiss();
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 16})
  static final class AlbumSelectDialogFragment$init$2 implements Runnable {
    AlbumSelectDialogFragment$init$2(AlbumSelectDialogFragment param1AlbumSelectDialogFragment) {}
    
    public final void run() {
      View view2 = AlbumSelectDialogFragment.e(this.a);
      if (view2 == null)
        Intrinsics.a(); 
      view2 = view2.findViewById(R.id.viewTitleBg);
      Intrinsics.a(view2, "contentView!!.viewTitleBg");
      ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
      View view3 = AlbumSelectDialogFragment.h(this.a).s();
      Intrinsics.a(view3, "albumSelectFragment.titleLayout");
      layoutParams2.height = view3.getMeasuredHeight();
      Intrinsics.a(layoutParams2, "contentView!!.viewTitleB…suredHeight\n            }");
      view3 = AlbumSelectDialogFragment.e(this.a);
      if (view3 == null)
        Intrinsics.a(); 
      view3 = view3.findViewById(R.id.viewTitleBg);
      if (view3 != null)
        view3.setLayoutParams(layoutParams2); 
      View view1 = AlbumSelectDialogFragment.e(this.a);
      if (view1 == null)
        Intrinsics.a(); 
      view1 = view1.findViewById(R.id.titleBarTouch);
      Intrinsics.a(view1, "contentView!!.titleBarTouch");
      ViewGroup.LayoutParams layoutParams1 = view1.getLayoutParams();
      view3 = AlbumSelectDialogFragment.h(this.a).s();
      Intrinsics.a(view3, "albumSelectFragment.titleLayout");
      layoutParams1.height = view3.getMeasuredHeight();
      Intrinsics.a(layoutParams1, "contentView!!.titleBarTo…suredHeight\n            }");
      view3 = AlbumSelectDialogFragment.e(this.a);
      if (view3 == null)
        Intrinsics.a(); 
      view3 = view3.findViewById(R.id.titleBarTouch);
      if (view3 != null)
        view3.setLayoutParams(layoutParams1); 
      AlbumSelectDialogFragment.h(this.a).setArguments(this.a.getArguments());
      AlbumSelectDialogFragment.h(this.a).c(this.a.getArguments());
      if (AlbumSelectDialogFragment.d(this.a))
        AlbumSelectDialogFragment.h(this.a).a(0.0F); 
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000!\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\005\n\002\020\013\n\002\b\002\n\002\030\002\n\000*\001\000\b\n\030\0002\0020\001J\030\020\b\032\0020\t2\006\020\n\032\0020\0032\006\020\013\032\0020\fH\026R\034\020\002\032\004\030\0010\003X\016¢\006\016\n\000\032\004\b\004\020\005\"\004\b\006\020\007¨\006\r"}, d2 = {"com/soft/blued/ui/video/fragment/AlbumSelectDialogFragment$init$onTouchListener$1", "Landroid/view/View$OnTouchListener;", "touchView", "Landroid/view/View;", "getTouchView", "()Landroid/view/View;", "setTouchView", "(Landroid/view/View;)V", "onTouch", "", "v", "event", "Landroid/view/MotionEvent;", "blued_app_a9999aRelease"}, k = 1, mv = {1, 1, 16})
  public static final class AlbumSelectDialogFragment$init$onTouchListener$1 implements View.OnTouchListener {
    private View b;
    
    AlbumSelectDialogFragment$init$onTouchListener$1(AlbumSelectDialogFragment param1AlbumSelectDialogFragment) {}
    
    public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
      Intrinsics.b(param1View, "v");
      Intrinsics.b(param1MotionEvent, "event");
      if (!AlbumSelectDialogFragment.c(this.a).C())
        return false; 
      int i = param1MotionEvent.getAction();
      param1View = null;
      if (i != 0) {
        if (i != 1)
          return true; 
        if (ViewUtils.a(this.b, param1MotionEvent)) {
          param1View = this.b;
          if (param1View != null) {
            Object object = param1View.getTag();
          } else {
            param1View = null;
          } 
          if (param1View != null) {
            param1View = this.b;
            if (param1View != null) {
              Object object = param1View.getTag();
            } else {
              param1View = null;
            } 
            if (param1View != null) {
              if (((Integer)param1View).intValue() == 101) {
                AlbumSelectDialogFragment.a(this.a).d(3);
                return true;
              } 
            } else {
              throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            } 
          } 
          AlbumSelectDialogFragment.AlbumSelectOnDismissListener albumSelectOnDismissListener = this.a.f();
          if (albumSelectOnDismissListener != null)
            albumSelectOnDismissListener.a((DialogFragment)this.a, this.b); 
          View view = this.b;
          if (view != null) {
            Object object = view.getTag();
          } else {
            view = null;
          } 
          if (view != null) {
            view = this.b;
            if (view != null) {
              Object object = view.getTag();
            } else {
              view = null;
            } 
            if (view != null) {
              if (((Integer)view).intValue() != 102) {
                this.a.a((AlbumSelectDialogFragment.AlbumSelectOnDismissListener)null);
                this.a.dismiss();
                return true;
              } 
            } else {
              throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            } 
          } else {
            this.a.a((AlbumSelectDialogFragment.AlbumSelectOnDismissListener)null);
            this.a.dismiss();
            return true;
          } 
        } else {
          this.a.dismiss();
          return true;
        } 
      } else {
        AlbumSelectDialogFragment.AlbumSelectOnDismissListener albumSelectOnDismissListener = this.a.f();
        if (albumSelectOnDismissListener != null)
          param1View = albumSelectOnDismissListener.a(param1MotionEvent); 
        this.b = param1View;
      } 
      return true;
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000%\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\000\n\002\020\007\n\002\b\002\n\002\020\b\n\000*\001\000\b\n\030\0002\0020\001J\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\007H\026J\030\020\b\032\0020\0032\006\020\004\032\0020\0052\006\020\t\032\0020\nH\026¨\006\013"}, d2 = {"com/soft/blued/ui/video/fragment/AlbumSelectDialogFragment$setupDialog$1", "Lcom/soft/blued/view/tip/dialog/BottomSheetBehavior$BottomSheetCallback;", "onSlide", "", "bottomSheet", "Landroid/view/View;", "slideOffset", "", "onStateChanged", "newState", "", "blued_app_a9999aRelease"}, k = 1, mv = {1, 1, 16})
  public static final class AlbumSelectDialogFragment$setupDialog$1 extends BottomSheetBehavior.BottomSheetCallback {
    AlbumSelectDialogFragment$setupDialog$1(AlbumSelectDialogFragment param1AlbumSelectDialogFragment) {}
    
    public void a(View param1View, float param1Float) {
      Intrinsics.b(param1View, "bottomSheet");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("slideOffset = ");
      stringBuilder.append(param1Float);
      Logger.c("BottomSheetCallback", new Object[] { stringBuilder.toString() });
      if (AlbumSelectDialogFragment.d(this.a)) {
        float f = false;
        if (param1Float >= f) {
          float f1;
          AlbumSelectDialogFragment albumSelectDialogFragment = this.a;
          float f2 = 30 * param1Float;
          if (f2 > true) {
            f1 = 1.0F;
          } else {
            f1 = f2;
            if (f2 < f)
              f1 = 0.0F; 
          } 
          AlbumSelectDialogFragment.a(albumSelectDialogFragment, f1);
          AlbumSelectDialogFragment.b(this.a, param1Float * 0.6F);
          return;
        } 
        int i = AlbumSelectDialogFragment.f(this.a) + (int)(AlbumSelectDialogFragment.g(this.a) * param1Float);
        stringBuilder = new StringBuilder();
        stringBuilder.append("height = ");
        stringBuilder.append(i);
        Logger.c("BottomSheetCallback", new Object[] { stringBuilder.toString() });
        AlbumSelectDialogFragment.c(this.a).y().setValue(Integer.valueOf(i));
        return;
      } 
      if (param1Float <= false)
        AlbumSelectDialogFragment.b(this.a, (true + param1Float) * 0.6F); 
    }
    
    public void a(View param1View, int param1Int) {
      Intrinsics.b(param1View, "bottomSheet");
      if (param1Int == 3) {
        AlbumSelectDialogFragment.a(this.a).a(AlbumSelectDialogFragment.b(this.a));
        if (AlbumSelectDialogFragment.c(this.a).C())
          EventTrackFeed.a(FeedProtos.Event.FEED_ADD_PHOTO, FeedProtos.AddType.FULL_SCREEN, AlbumSelectDialogFragment.c(this.a).E()); 
        AlbumSelectDialogFragment.a(this.a, false);
        AlbumSelectDialogFragment.c(this.a).d(AlbumSelectDialogFragment.d(this.a));
        AlbumSelectDialogFragment.c(this.a).y().setValue(Integer.valueOf(0));
        param1View = AlbumSelectDialogFragment.e(this.a);
        if (param1View != null) {
          param1View = param1View.findViewById(R.id.titleBarTouch);
          if (param1View != null)
            param1View.setVisibility(8); 
        } 
      } 
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 16})
  static final class AlbumSelectDialogFragment$show$1 implements Runnable {
    AlbumSelectDialogFragment$show$1(AlbumSelectDialogFragment param1AlbumSelectDialogFragment, FragmentManager param1FragmentManager, String param1String) {}
    
    public final void run() {
      AlbumSelectDialogFragment.a(this.a, this.b, this.c);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\video\fragment\AlbumSelectDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */