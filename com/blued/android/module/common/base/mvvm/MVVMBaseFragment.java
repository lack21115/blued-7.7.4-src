package com.blued.android.module.common.base.mvvm;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseFragment;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\000N\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\003\n\002\030\002\n\002\b\b\n\002\030\002\n\000\n\002\020\002\n\002\b\005\n\002\020\013\n\002\b\005\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\006\b&\030\000*\b\b\000\020\001*\0020\0022\0020\003B\005¢\006\002\020\004J\017\020\021\032\004\030\0018\000H\024¢\006\002\020\rJ\b\020\022\032\0020\023H\024J\b\020\024\032\0020\025H\024J\b\020\026\032\0020\025H$J\b\020\027\032\0020\025H$J\b\020\030\032\0020\025H\002J\020\020\031\032\0020\0252\006\020\032\032\0020\033H\024J\b\020\034\032\0020\025H\024J\b\020\035\032\0020\025H\002J\b\020\036\032\0020\025H\024J\022\020\037\032\0020\0252\b\020 \032\004\030\0010!H\026J&\020\"\032\004\030\0010\n2\006\020#\032\0020$2\b\020%\032\004\030\0010&2\b\020 \032\004\030\0010!H\026J\b\020'\032\0020\025H\026J\b\020(\032\0020\025H\024J\b\020)\032\0020\025H\024J\032\020*\032\0020\0252\006\020+\032\0020\n2\b\020 \032\004\030\0010!H\026R\022\020\005\032\0020\006X¦\004¢\006\006\032\004\b\007\020\bR\020\020\t\032\004\030\0010\nX\016¢\006\002\n\000R\034\020\013\032\0028\000X.¢\006\020\n\002\020\020\032\004\b\f\020\r\"\004\b\016\020\017¨\006,"}, d2 = {"Lcom/blued/android/module/common/base/mvvm/MVVMBaseFragment;", "M", "Lcom/blued/android/module/common/base/mvvm/BaseViewModel;", "Lcom/blued/android/core/ui/BaseFragment;", "()V", "layoutId", "", "getLayoutId", "()I", "mRootView", "Landroid/view/View;", "mViewModel", "getMViewModel", "()Lcom/blued/android/module/common/base/mvvm/BaseViewModel;", "setMViewModel", "(Lcom/blued/android/module/common/base/mvvm/BaseViewModel;)V", "Lcom/blued/android/module/common/base/mvvm/BaseViewModel;", "getViewModel", "getViewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "hasMore", "", "init", "liveDataObserver", "load", "loadFinish", "success", "", "loadStart", "loadState", "noMore", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onPrepare", "onRegisterLiveListener", "onViewCreated", "view", "module_common_release"}, k = 1, mv = {1, 1, 16})
public abstract class MVVMBaseFragment<M extends BaseViewModel> extends BaseFragment {
  protected M d;
  
  private View e;
  
  private HashMap f;
  
  private final void v() {
    M m2 = n();
    if (m2 == null)
      Intrinsics.a(); 
    this.d = m2;
    M m1 = this.d;
    if (m1 == null)
      Intrinsics.b("mViewModel"); 
    m1.a(getArguments());
    w();
    o();
    p();
    q();
  }
  
  private final void w() {
    M m = this.d;
    if (m == null)
      Intrinsics.b("mViewModel"); 
    m.a().observe(getViewLifecycleOwner(), new MVVMBaseFragment$loadState$1(this));
    m = this.d;
    if (m == null)
      Intrinsics.b("mViewModel"); 
    m.b().observe(getViewLifecycleOwner(), new MVVMBaseFragment$loadState$2(this));
  }
  
  public abstract int a();
  
  public View a(int paramInt) {
    if (this.f == null)
      this.f = new HashMap<Object, Object>(); 
    View view2 = (View)this.f.get(Integer.valueOf(paramInt));
    View view1 = view2;
    if (view2 == null) {
      view1 = getView();
      if (view1 == null)
        return null; 
      view1 = view1.findViewById(paramInt);
      this.f.put(Integer.valueOf(paramInt), view1);
    } 
    return view1;
  }
  
  protected void a(boolean paramBoolean) {}
  
  public final M k() {
    M m = this.d;
    if (m == null)
      Intrinsics.b("mViewModel"); 
    return m;
  }
  
  protected void l() {}
  
  protected ViewModelStoreOwner m() {
    return (ViewModelStoreOwner)this;
  }
  
  protected M n() {
    Type type = getClass().getGenericSuperclass();
    if (type != null && type instanceof ParameterizedType) {
      Type[] arrayOfType = ((ParameterizedType)type).getActualTypeArguments();
      Intrinsics.a(arrayOfType, "type.actualTypeArguments");
      Type type1 = arrayOfType[0];
      ViewModelStoreOwner viewModelStoreOwner = m();
      Context context = AppInfo.d();
      if (context != null) {
        ViewModelProvider viewModelProvider = new ViewModelProvider(viewModelStoreOwner, (ViewModelProvider.Factory)ViewModelProvider.AndroidViewModelFactory.getInstance((Application)context));
        if (type1 != null)
          return (M)viewModelProvider.get((Class)type1); 
        throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<M>");
      } 
      throw new TypeCastException("null cannot be cast to non-null type android.app.Application");
    } 
    return null;
  }
  
  protected void o() {}
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    l();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    Intrinsics.b(paramLayoutInflater, "inflater");
    this.e = paramLayoutInflater.inflate(a(), paramViewGroup, false);
    View view = this.e;
    if (view == null)
      Intrinsics.a(); 
    return view;
  }
  
  public void onDestroyView() {
    super.onDestroyView();
    this.e = (View)null;
    u();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    Intrinsics.b(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    v();
  }
  
  protected abstract void p();
  
  protected abstract void q();
  
  protected void r() {}
  
  protected void s() {}
  
  protected void t() {}
  
  public void u() {
    HashMap hashMap = this.f;
    if (hashMap != null)
      hashMap.clear(); 
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\026\n\000\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\020\000\032\0020\001\"\b\b\000\020\002*\0020\0032\016\020\004\032\n \006*\004\030\0010\0050\005H\n¢\006\002\b\007"}, d2 = {"<anonymous>", "", "M", "Lcom/blued/android/module/common/base/mvvm/BaseViewModel;", "it", "Lcom/blued/android/module/common/base/mvvm/LoadState;", "kotlin.jvm.PlatformType", "onChanged"}, k = 3, mv = {1, 1, 16})
  static final class MVVMBaseFragment$loadState$1<T> implements Observer<LoadState> {
    MVVMBaseFragment$loadState$1(MVVMBaseFragment param1MVVMBaseFragment) {}
    
    public final void a(LoadState param1LoadState) {
      if (param1LoadState == null)
        return; 
      int i = MVVMBaseFragment$WhenMappings.a[param1LoadState.ordinal()];
      if (i != 1) {
        if (i != 2) {
          if (i != 3)
            return; 
          this.a.a(false);
          return;
        } 
        this.a.a(true);
        return;
      } 
      this.a.r();
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\026\n\000\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\020\000\032\0020\001\"\b\b\000\020\002*\0020\0032\016\020\004\032\n \006*\004\030\0010\0050\005H\n¢\006\002\b\007"}, d2 = {"<anonymous>", "", "M", "Lcom/blued/android/module/common/base/mvvm/BaseViewModel;", "it", "Lcom/blued/android/module/common/base/mvvm/HasMoreState;", "kotlin.jvm.PlatformType", "onChanged"}, k = 3, mv = {1, 1, 16})
  static final class MVVMBaseFragment$loadState$2<T> implements Observer<HasMoreState> {
    MVVMBaseFragment$loadState$2(MVVMBaseFragment param1MVVMBaseFragment) {}
    
    public final void a(HasMoreState param1HasMoreState) {
      if (param1HasMoreState == null)
        return; 
      int i = MVVMBaseFragment$WhenMappings.b[param1HasMoreState.ordinal()];
      if (i != 1) {
        if (i != 2)
          return; 
        this.a.t();
        return;
      } 
      this.a.s();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\common\base\mvvm\MVVMBaseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */