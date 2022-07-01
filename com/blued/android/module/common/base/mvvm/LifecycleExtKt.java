package com.blued.android.module.common.base.mvvm;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\000 \n\000\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\b\003\032A\020\000\032\0020\001\"\004\b\000\020\002*\0020\0032\f\020\004\032\b\022\004\022\002H\0020\0052!\020\006\032\035\022\023\022\021H\002¢\006\f\b\b\022\b\b\t\022\004\b\b(\n\022\004\022\0020\0010\007¨\006\013"}, d2 = {"observe", "", "T", "Landroidx/lifecycle/LifecycleOwner;", "liveData", "Landroidx/lifecycle/LiveData;", "observer", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "t", "module_common_release"}, k = 2, mv = {1, 1, 16})
public final class LifecycleExtKt {
  public static final <T> void a(LifecycleOwner paramLifecycleOwner, LiveData<T> paramLiveData, Function1<? super T, Unit> paramFunction1) {
    Intrinsics.b(paramLifecycleOwner, "$this$observe");
    Intrinsics.b(paramLiveData, "liveData");
    Intrinsics.b(paramFunction1, "observer");
    paramLiveData.observe(paramLifecycleOwner, new LifecycleExtKt$observe$1(paramFunction1));
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\n\n\000\n\002\020\002\n\002\b\005\020\000\032\0020\001\"\004\b\000\020\0022\016\020\003\032\n \004*\004\030\001H\002H\002H\n¢\006\004\b\005\020\006"}, d2 = {"<anonymous>", "", "T", "it", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 1, 16})
  static final class LifecycleExtKt$observe$1<T> implements Observer<T> {
    LifecycleExtKt$observe$1(Function1 param1Function1) {}
    
    public final void onChanged(T param1T) {
      if (param1T != null)
        this.a.a(param1T); 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\common\base\mvvm\LifecycleExtKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */