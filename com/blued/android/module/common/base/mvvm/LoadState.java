package com.blued.android.module.common.base.mvvm;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\000\f\n\002\030\002\n\002\020\020\n\002\b\005\b\001\030\0002\b\022\004\022\0020\0000\001B\007\b\002¢\006\002\020\002j\002\b\003j\002\b\004j\002\b\005¨\006\006"}, d2 = {"Lcom/blued/android/module/common/base/mvvm/LoadState;", "", "(Ljava/lang/String;I)V", "LoadStart", "LoadSuccess", "LoadFail", "module_common_release"}, k = 1, mv = {1, 1, 16})
public enum LoadState {
  a, b, c;
  
  static {
    LoadState loadState1 = new LoadState("LoadStart", 0);
    a = loadState1;
    LoadState loadState2 = new LoadState("LoadSuccess", 1);
    b = loadState2;
    LoadState loadState3 = new LoadState("LoadFail", 2);
    c = loadState3;
    d = new LoadState[] { loadState1, loadState2, loadState3 };
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\common\base\mvvm\LoadState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */