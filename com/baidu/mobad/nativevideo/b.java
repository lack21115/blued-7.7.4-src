package com.baidu.mobad.nativevideo;

import com.baidu.mobad.feeds.NativeErrorCode;
import java.util.List;

class b implements a.a {
  b(PatchVideoNative paramPatchVideoNative) {}
  
  public void a(NativeErrorCode paramNativeErrorCode) {
    PatchVideoNative.a(this.a, paramNativeErrorCode);
  }
  
  public void a(List<e> paramList) {
    if (paramList != null && paramList.size() > 0) {
      PatchVideoNative.a(this.a, paramList.get(0));
      PatchVideoNative.a(this.a);
      return;
    } 
    PatchVideoNative.a(this.a, NativeErrorCode.LOAD_AD_FAILED);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobad\nativevideo\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */