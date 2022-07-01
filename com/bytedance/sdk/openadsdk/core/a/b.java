package com.bytedance.sdk.openadsdk.core.a;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.d.e;
import com.bytedance.sdk.openadsdk.core.d.i;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.z;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.ai;
import java.lang.ref.WeakReference;
import java.util.Map;

public class b extends c {
  protected Context c;
  
  protected final k d;
  
  protected final String e;
  
  protected final int f;
  
  protected WeakReference<View> g;
  
  protected WeakReference<View> h;
  
  protected e i;
  
  protected a j;
  
  protected TTNativeAd k;
  
  protected c l;
  
  protected boolean m = false;
  
  protected com.bytedance.sdk.openadsdk.downloadnew.core.a n;
  
  protected Map<String, Object> o;
  
  protected TTNativeExpressAd p;
  
  protected com.bytedance.sdk.openadsdk.core.nativeexpress.a q;
  
  public b(Context paramContext, k paramk, String paramString, int paramInt) {
    this.c = paramContext;
    this.d = paramk;
    this.e = paramString;
    this.f = paramInt;
  }
  
  protected e a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2, View paramView1, View paramView2) {
    e.a a1 = (new e.a()).e(paramInt1).d(paramInt2).c(paramInt3).b(paramInt4).b(paramLong1).a(paramLong2).b(ai.a(paramView1)).a(ai.a(paramView2)).c(ai.b(paramView1)).d(ai.b(paramView2)).f(this.x).g(this.y).h(this.z).a(this.B);
    if (h.c().b()) {
      paramInt1 = 1;
    } else {
      paramInt1 = 2;
    } 
    return a1.a(paramInt1).a();
  }
  
  public void a(View paramView) {
    this.g = new WeakReference<View>(paramView);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    String str;
    View view1;
    View view2;
    if (a(1))
      return; 
    if (this.c == null)
      this.c = o.a(); 
    if (this.c == null)
      return; 
    long l1 = this.v;
    long l2 = this.w;
    WeakReference<View> weakReference1 = this.g;
    if (weakReference1 == null) {
      weakReference1 = null;
    } else {
      view1 = weakReference1.get();
    } 
    WeakReference<View> weakReference2 = this.h;
    if (weakReference2 == null) {
      weakReference2 = null;
    } else {
      view2 = weakReference2.get();
    } 
    this.i = a(paramInt1, paramInt2, paramInt3, paramInt4, l1, l2, view1, view2);
    a a1 = this.j;
    if (a1 != null)
      a1.a(paramView, -1); 
    boolean bool = this.d.q();
    if (bool) {
      str = this.e;
    } else {
      str = ah.a(this.f);
    } 
    bool = z.a(this.c, this.d, this.f, this.k, this.p, str, this.n, bool);
    if (!bool) {
      k k1 = this.d;
      if (k1 != null && k1.O() != null && this.d.O().c() == 2)
        return; 
    } 
    d.a(this.c, "click", this.d, this.i, this.e, bool, this.o);
  }
  
  public void a(TTNativeAd paramTTNativeAd) {
    this.k = paramTTNativeAd;
  }
  
  public void a(TTNativeExpressAd paramTTNativeExpressAd) {
    this.p = paramTTNativeExpressAd;
  }
  
  public void a(a parama) {
    this.j = parama;
  }
  
  public void a(com.bytedance.sdk.openadsdk.core.nativeexpress.a parama) {
    this.q = parama;
  }
  
  public void a(c paramc) {
    this.l = paramc;
  }
  
  public void a(com.bytedance.sdk.openadsdk.downloadnew.core.a parama) {
    this.n = parama;
  }
  
  public void a(Map<String, Object> paramMap) {
    this.o = paramMap;
  }
  
  protected boolean a(int paramInt) {
    if (this.q != null) {
      int[] arrayOfInt2 = new int[2];
      int[] arrayOfInt1 = new int[2];
      WeakReference<View> weakReference = this.h;
      if (weakReference != null) {
        arrayOfInt2 = ai.a(weakReference.get());
        arrayOfInt1 = ai.b(this.h.get());
      } 
      i i = (new i.a()).d(this.r).c(this.s).b(this.t).a(this.u).b(this.v).a(this.w).e(arrayOfInt2[0]).f(arrayOfInt2[1]).g(arrayOfInt1[0]).h(arrayOfInt1[1]).a();
      this.q.a(paramInt, i);
      return true;
    } 
    return false;
  }
  
  public void b(View paramView) {
    this.h = new WeakReference<View>(paramView);
  }
  
  public void c(boolean paramBoolean) {
    this.m = paramBoolean;
  }
  
  public static interface a {
    void a(View param1View, int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */