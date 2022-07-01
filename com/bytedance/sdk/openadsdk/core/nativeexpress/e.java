package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.a.b;
import com.bytedance.sdk.openadsdk.core.d.i;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.utils.ai;

public class e extends b {
  private i a;
  
  public e(Context paramContext, k paramk, String paramString, int paramInt) {
    super(paramContext, paramk, paramString, paramInt);
  }
  
  public com.bytedance.sdk.openadsdk.core.d.e a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2, View paramView1, View paramView2) {
    int k;
    this.x = 1;
    this.y = 0;
    this.z = 0;
    int[] arrayOfInt1 = ai.a(paramView1);
    if (arrayOfInt1 != null && arrayOfInt1.length == 2) {
      j = arrayOfInt1[0];
      k = arrayOfInt1[1];
      paramInt1 = (int)ai.a(this.c, paramInt1) + j;
      paramInt2 = (int)ai.a(this.c, paramInt2) + k;
      paramInt3 = (int)ai.a(this.c, paramInt3) + j;
      paramInt4 = (int)ai.a(this.c, paramInt4) + k;
    } else {
      j = 0;
      k = 0;
    } 
    int[] arrayOfInt2 = new int[2];
    int[] arrayOfInt3 = new int[2];
    i i1 = this.a;
    if (i1 != null) {
      paramLong1 = i1.e;
      paramLong2 = this.a.f;
      arrayOfInt2[0] = (int)ai.a(this.c, this.a.g) + j;
      arrayOfInt2[1] = (int)ai.a(this.c, this.a.h) + k;
      j = (int)ai.a(this.c, this.a.i);
      k = (int)ai.a(this.c, this.a.j);
      arrayOfInt3[0] = j;
      arrayOfInt3[1] = k;
    } 
    int j = 1;
    com.bytedance.sdk.openadsdk.core.d.e.a a = (new com.bytedance.sdk.openadsdk.core.d.e.a()).e(paramInt1).d(paramInt2).c(paramInt3).b(paramInt4).b(paramLong1).a(paramLong2).b(arrayOfInt1).a(arrayOfInt2).c(ai.b(paramView1)).d(arrayOfInt3).f(this.x).g(this.y).h(this.z);
    if (h.c().b()) {
      paramInt1 = j;
    } else {
      paramInt1 = 2;
    } 
    return a.a(paramInt1).a(this.B).a();
  }
  
  public void a(i parami) {
    this.a = parami;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\nativeexpress\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */