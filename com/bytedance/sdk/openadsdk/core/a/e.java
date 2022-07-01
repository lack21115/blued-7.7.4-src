package com.bytedance.sdk.openadsdk.core.a;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.d.k;

public abstract class e extends a {
  public e(Context paramContext, k paramk, String paramString, int paramInt) {
    super(paramContext, paramk, paramString, paramInt);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    a_(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
    super.a(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected abstract void a_(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */