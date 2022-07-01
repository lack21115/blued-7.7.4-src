package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.a.a;
import com.bytedance.sdk.openadsdk.core.a.b;
import com.bytedance.sdk.openadsdk.core.a.c;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.downloadnew.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.utils.ah;
import java.util.List;

public class n {
  private final k a;
  
  private a b;
  
  private final Context c;
  
  private final TTNativeAd d;
  
  private String e = "embeded_ad";
  
  public n(Context paramContext, TTNativeAd paramTTNativeAd, k paramk, String paramString) {
    this.d = paramTTNativeAd;
    this.a = paramk;
    this.c = paramContext;
    this.e = paramString;
    if (this.a.B() == 4)
      this.b = a.a(this.c, this.a, this.e); 
  }
  
  private EmptyView a(ViewGroup paramViewGroup) {
    for (int i = 0; i < paramViewGroup.getChildCount(); i++) {
      View view = paramViewGroup.getChildAt(i);
      if (view instanceof EmptyView)
        return (EmptyView)view; 
    } 
    return null;
  }
  
  public a a() {
    return this.b;
  }
  
  public void a(Activity paramActivity) {
    a a1 = this.b;
    if (a1 != null)
      a1.a(paramActivity); 
  }
  
  public void a(ViewGroup paramViewGroup, List<View> paramList1, List<View> paramList2, View paramView, TTNativeAd.AdInteractionListener paramAdInteractionListener) {
    a a1 = this.b;
    if (a1 != null)
      a1.b(); 
    d.a(this.a);
    EmptyView emptyView2 = a(paramViewGroup);
    EmptyView emptyView1 = emptyView2;
    if (emptyView2 == null) {
      emptyView1 = new EmptyView(this.c, (View)paramViewGroup);
      paramViewGroup.addView(emptyView1);
    } 
    emptyView1.a();
    emptyView1.setRefClickViews(paramList1);
    emptyView1.setRefCreativeViews(paramList2);
    a a2 = this.b;
    if (a2 != null)
      a2.a(emptyView1); 
    Context context1 = this.c;
    k k1 = this.a;
    String str1 = this.e;
    b b = new b(context1, k1, str1, ah.a(str1));
    b.a((View)paramViewGroup);
    b.b(paramView);
    b.a(this.b);
    b.a(this.d);
    b.a(new b.a(this, paramAdInteractionListener) {
          public void a(View param1View, int param1Int) {
            TTNativeAd.AdInteractionListener adInteractionListener = this.a;
            if (adInteractionListener != null)
              adInteractionListener.onAdClicked(param1View, n.a(this.b)); 
          }
        });
    Context context2 = this.c;
    k k2 = this.a;
    String str2 = this.e;
    a a3 = new a(context2, k2, str2, ah.a(str2));
    a3.a((View)paramViewGroup);
    a3.b(paramView);
    a3.a(this.b);
    a3.a(this.d);
    a3.a(new b.a(this, paramAdInteractionListener) {
          public void a(View param1View, int param1Int) {
            TTNativeAd.AdInteractionListener adInteractionListener = this.a;
            if (adInteractionListener != null)
              adInteractionListener.onAdCreativeClick(param1View, n.a(this.b)); 
          }
        });
    emptyView1.a(paramList1, (c)b);
    emptyView1.a(paramList2, (c)a3);
    emptyView1.setCallback(new EmptyView.a(this, paramAdInteractionListener) {
          public void a() {
            if (n.b(this.b) != null)
              n.b(this.b).a(); 
          }
          
          public void a(View param1View) {
            d.a(n.c(this.b), n.d(this.b), n.e(this.b), null);
            TTNativeAd.AdInteractionListener adInteractionListener = this.a;
            if (adInteractionListener != null)
              adInteractionListener.onAdShow(n.a(this.b)); 
            if (n.d(this.b).U())
              ah.a(n.d(this.b), param1View); 
          }
          
          public void a(boolean param1Boolean) {
            if (n.b(this.b) != null) {
              if (param1Boolean) {
                n.b(this.b).b();
                return;
              } 
              n.b(this.b).c();
            } 
          }
          
          public void b() {
            if (n.b(this.b) != null)
              n.b(this.b).d(); 
          }
        });
    emptyView1.setNeedCheckingShow(true);
  }
  
  public void a(TTAppDownloadListener paramTTAppDownloadListener) {
    a a1 = this.b;
    if (a1 != null)
      a1.a(paramTTAppDownloadListener); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */