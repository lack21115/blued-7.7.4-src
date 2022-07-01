package com.blued.android.module.common.base.mvvm;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseFragmentActivity;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\0008\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\n\n\002\030\002\n\000\n\002\020\002\n\002\b\004\n\002\020\013\n\002\b\005\n\002\030\002\n\002\b\003\b&\030\000*\b\b\000\020\001*\0020\0022\0020\003B\005¢\006\002\020\004J\017\020\017\032\004\030\0018\000H\024¢\006\002\020\013J\b\020\020\032\0020\021H\024J\b\020\022\032\0020\023H\024J\b\020\024\032\0020\023H$J\b\020\025\032\0020\023H$J\020\020\026\032\0020\0232\006\020\027\032\0020\030H\024J\b\020\031\032\0020\023H\024J\b\020\032\032\0020\023H\002J\b\020\033\032\0020\023H\024J\022\020\034\032\0020\0232\b\020\035\032\004\030\0010\036H\026J\b\020\037\032\0020\023H\024J\b\020 \032\0020\023H\024R\022\020\005\032\0020\006X¤\004¢\006\006\032\004\b\007\020\bR\034\020\t\032\0028\000X.¢\006\020\n\002\020\016\032\004\b\n\020\013\"\004\b\f\020\r¨\006!"}, d2 = {"Lcom/blued/android/module/common/base/mvvm/MVVMBaseActivity;", "M", "Lcom/blued/android/module/common/base/mvvm/BaseViewModel;", "Lcom/blued/android/core/ui/BaseFragmentActivity;", "()V", "layoutId", "", "getLayoutId", "()I", "mViewModel", "getMViewModel", "()Lcom/blued/android/module/common/base/mvvm/BaseViewModel;", "setMViewModel", "(Lcom/blued/android/module/common/base/mvvm/BaseViewModel;)V", "Lcom/blued/android/module/common/base/mvvm/BaseViewModel;", "getViewModel", "getViewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "hasMore", "", "init", "liveDataObserver", "loadFinish", "success", "", "loadStart", "loadState", "noMore", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPrepare", "onRegisterLiveListener", "module_common_release"}, k = 1, mv = {1, 1, 16})
public abstract class MVVMBaseActivity<M extends BaseViewModel> extends BaseFragmentActivity {
  protected M c;
  
  private final void r() {
    M m1 = this.c;
    if (m1 == null)
      Intrinsics.b("mViewModel"); 
    MutableLiveData<LoadState> mutableLiveData = m1.a();
    LifecycleOwner lifecycleOwner = (LifecycleOwner)this;
    mutableLiveData.observe(lifecycleOwner, new MVVMBaseActivity$loadState$1(this));
    M m2 = this.c;
    if (m2 == null)
      Intrinsics.b("mViewModel"); 
    m2.b().observe(lifecycleOwner, new MVVMBaseActivity$loadState$2(this));
  }
  
  protected void b(boolean paramBoolean) {}
  
  protected abstract int h();
  
  protected void i() {}
  
  protected ViewModelStoreOwner j() {
    return (ViewModelStoreOwner)this;
  }
  
  protected M k() {
    Type type = getClass().getGenericSuperclass();
    if (type != null && type instanceof ParameterizedType) {
      Type[] arrayOfType = ((ParameterizedType)type).getActualTypeArguments();
      Intrinsics.a(arrayOfType, "type.actualTypeArguments");
      Type type1 = arrayOfType[0];
      ViewModelStoreOwner viewModelStoreOwner = j();
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
  
  protected void l() {}
  
  protected abstract void m();
  
  protected abstract void n();
  
  protected void o() {}
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    i();
    setContentView(h());
    paramBundle = (Bundle)k();
    if (paramBundle == null)
      Intrinsics.a(); 
    this.c = (M)paramBundle;
    M m = this.c;
    if (m == null)
      Intrinsics.b("mViewModel"); 
    if (getIntent() != null) {
      Intent intent = getIntent();
      Intrinsics.a(intent, "intent");
      Bundle bundle = intent.getExtras();
    } else {
      paramBundle = null;
    } 
    m.a(paramBundle);
    r();
    l();
    m();
    n();
  }
  
  protected void p() {}
  
  protected void q() {}
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\026\n\000\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\020\000\032\0020\001\"\b\b\000\020\002*\0020\0032\016\020\004\032\n \006*\004\030\0010\0050\005H\n¢\006\002\b\007"}, d2 = {"<anonymous>", "", "M", "Lcom/blued/android/module/common/base/mvvm/BaseViewModel;", "it", "Lcom/blued/android/module/common/base/mvvm/LoadState;", "kotlin.jvm.PlatformType", "onChanged"}, k = 3, mv = {1, 1, 16})
  static final class MVVMBaseActivity$loadState$1<T> implements Observer<LoadState> {
    MVVMBaseActivity$loadState$1(MVVMBaseActivity param1MVVMBaseActivity) {}
    
    public final void a(LoadState param1LoadState) {
      if (param1LoadState == null)
        return; 
      int i = MVVMBaseActivity$WhenMappings.a[param1LoadState.ordinal()];
      if (i != 1) {
        if (i != 2) {
          if (i != 3)
            return; 
          this.a.b(false);
          return;
        } 
        this.a.b(true);
        return;
      } 
      this.a.o();
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\026\n\000\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\020\000\032\0020\001\"\b\b\000\020\002*\0020\0032\016\020\004\032\n \006*\004\030\0010\0050\005H\n¢\006\002\b\007"}, d2 = {"<anonymous>", "", "M", "Lcom/blued/android/module/common/base/mvvm/BaseViewModel;", "it", "Lcom/blued/android/module/common/base/mvvm/HasMoreState;", "kotlin.jvm.PlatformType", "onChanged"}, k = 3, mv = {1, 1, 16})
  static final class MVVMBaseActivity$loadState$2<T> implements Observer<HasMoreState> {
    MVVMBaseActivity$loadState$2(MVVMBaseActivity param1MVVMBaseActivity) {}
    
    public final void a(HasMoreState param1HasMoreState) {
      if (param1HasMoreState == null)
        return; 
      int i = MVVMBaseActivity$WhenMappings.b[param1HasMoreState.ordinal()];
      if (i != 1) {
        if (i != 2)
          return; 
        this.a.q();
        return;
      } 
      this.a.p();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\common\base\mvvm\MVVMBaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */