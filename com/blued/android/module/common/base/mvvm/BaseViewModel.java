package com.blued.android.module.common.base.mvvm;

import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.blued.android.core.utils.Log;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\0004\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\002\n\002\020\002\n\002\020\013\n\002\b\002\n\002\030\002\n\002\b\005\b&\030\0002\0020\001B\005¢\006\002\020\002J\020\020\013\032\0020\f2\006\020\013\032\0020\rH\004J\022\020\016\032\0020\f2\b\020\017\032\004\030\0010\020H\026J\020\020\021\032\0020\f2\006\020\022\032\0020\rH\004J\b\020\023\032\0020\fH\004J\b\020\024\032\0020\fH\024R\027\020\003\032\b\022\004\022\0020\0050\004¢\006\b\n\000\032\004\b\006\020\007R\027\020\b\032\b\022\004\022\0020\t0\004¢\006\b\n\000\032\004\b\n\020\007¨\006\025"}, d2 = {"Lcom/blued/android/module/common/base/mvvm/BaseViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "hasMoreStateLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/blued/android/module/common/base/mvvm/HasMoreState;", "getHasMoreStateLiveData", "()Landroidx/lifecycle/MutableLiveData;", "loadStateLiveData", "Lcom/blued/android/module/common/base/mvvm/LoadState;", "getLoadStateLiveData", "hasMore", "", "", "init", "arguments", "Landroid/os/Bundle;", "loadFinish", "success", "loadStart", "onCleared", "module_common_release"}, k = 1, mv = {1, 1, 16})
public abstract class BaseViewModel extends ViewModel {
  private final MutableLiveData<LoadState> a = new MutableLiveData();
  
  private final MutableLiveData<HasMoreState> b = new MutableLiveData();
  
  public final MutableLiveData<LoadState> a() {
    return this.a;
  }
  
  public void a(Bundle paramBundle) {}
  
  public final void a(boolean paramBoolean) {
    if (paramBoolean) {
      this.a.setValue(LoadState.b);
      return;
    } 
    this.a.setValue(LoadState.c);
  }
  
  public final MutableLiveData<HasMoreState> b() {
    return this.b;
  }
  
  public final void b(boolean paramBoolean) {
    if (paramBoolean) {
      this.b.setValue(HasMoreState.a);
      return;
    } 
    this.b.setValue(HasMoreState.b);
  }
  
  public void onCleared() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getName());
    stringBuilder.append(this);
    stringBuilder.append(" onCleared()");
    Log.a("BaseViewModel", stringBuilder.toString());
    super.onCleared();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\common\base\mvvm\BaseViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */