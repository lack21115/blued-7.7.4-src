package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.dislike.b;
import com.bytedance.sdk.openadsdk.downloadnew.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.t;
import java.util.List;
import java.util.Map;

public class k extends l {
  protected NativeExpressView a;
  
  protected final Context b;
  
  protected com.bytedance.sdk.openadsdk.core.d.k c;
  
  protected String d = "embeded_ad";
  
  private TTNativeExpressAd.ExpressAdInteractionListener f;
  
  private TTAppDownloadListener g;
  
  private TTAdDislike.DislikeInteractionCallback h;
  
  private b i;
  
  private TTDislikeDialogAbstract j;
  
  private a k;
  
  public k(Context paramContext, com.bytedance.sdk.openadsdk.core.d.k paramk, AdSlot paramAdSlot) {
    this.b = paramContext;
    this.c = paramk;
    a(paramContext, paramk, paramAdSlot);
  }
  
  private EmptyView a(ViewGroup paramViewGroup) {
    for (int i = 0; i < paramViewGroup.getChildCount(); i++) {
      View view = paramViewGroup.getChildAt(i);
      if (view instanceof EmptyView)
        return (EmptyView)view; 
    } 
    return null;
  }
  
  private a a(com.bytedance.sdk.openadsdk.core.d.k paramk) {
    return (paramk.B() == 4) ? a.a(this.b, paramk, this.d) : null;
  }
  
  private void a(Activity paramActivity, TTAdDislike.DislikeInteractionCallback paramDislikeInteractionCallback) {
    if (this.i == null)
      this.i = new b((Context)paramActivity, this.c); 
    this.i.setDislikeInteractionCallback(paramDislikeInteractionCallback);
    NativeExpressView nativeExpressView = this.a;
    if (nativeExpressView != null)
      nativeExpressView.setDislike((TTAdDislike)this.i); 
  }
  
  public void a(Context paramContext, com.bytedance.sdk.openadsdk.core.d.k paramk, AdSlot paramAdSlot) {
    this.a = new NativeExpressView(paramContext, paramk, paramAdSlot, this.d);
    a(this.a, this.c);
  }
  
  protected void a(NativeExpressView paramNativeExpressView, com.bytedance.sdk.openadsdk.core.d.k paramk) {
    this.c = paramk;
    paramNativeExpressView.setBackupListener(new c(this) {
          public boolean a(NativeExpressView param1NativeExpressView, int param1Int) {
            param1NativeExpressView.l();
            h h = new h(param1NativeExpressView.getContext());
            h.a(this.a.c, param1NativeExpressView, k.a(this.a));
            h.setDislikeInner((TTAdDislike)k.b(this.a));
            h.setDislikeOuter(k.c(this.a));
            return true;
          }
        });
    this.k = a(paramk);
    a a2 = this.k;
    if (a2 != null) {
      a2.b();
      if (paramNativeExpressView.getContext() != null && paramNativeExpressView.getContext() instanceof Activity)
        this.k.a((Activity)paramNativeExpressView.getContext()); 
    } 
    d.a(paramk);
    EmptyView emptyView2 = a((ViewGroup)paramNativeExpressView);
    EmptyView emptyView1 = emptyView2;
    if (emptyView2 == null) {
      emptyView1 = new EmptyView(this.b, (View)paramNativeExpressView);
      paramNativeExpressView.addView((View)emptyView1);
    } 
    a a3 = this.k;
    if (a3 != null)
      a3.a((View)emptyView1); 
    emptyView1.setCallback(new EmptyView.a(this, paramk) {
          public void a() {
            if (k.a(this.b) != null)
              k.a(this.b).a(); 
          }
          
          public void a(View param1View) {
            throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
          }
          
          public void a(boolean param1Boolean) {
            if (k.a(this.b) != null)
              if (param1Boolean) {
                if (k.a(this.b) != null) {
                  k.a(this.b).b();
                  return;
                } 
              } else if (k.a(this.b) != null) {
                k.a(this.b).c();
              }  
          }
          
          public void b() {
            if (k.a(this.b) != null)
              k.a(this.b).d(); 
          }
        });
    Context context2 = this.b;
    String str = this.d;
    e e = new e(context2, paramk, str, ah.a(str));
    e.a((View)paramNativeExpressView);
    e.a(this.k);
    e.a(this);
    this.a.setClickListener(e);
    Context context1 = this.b;
    str = this.d;
    d d = new d(context1, paramk, str, ah.a(str));
    d.a((View)paramNativeExpressView);
    d.a(this.k);
    d.a(this);
    this.a.setClickCreativeListener(d);
    a a1 = this.k;
    if (a1 != null)
      a1.a(this.g); 
    emptyView1.setNeedCheckingShow(true);
  }
  
  public void destroy() {
    NativeExpressView nativeExpressView = this.a;
    if (nativeExpressView != null)
      nativeExpressView.k(); 
  }
  
  public View getExpressAdView() {
    return (View)this.a;
  }
  
  public List<FilterWord> getFilterWords() {
    com.bytedance.sdk.openadsdk.core.d.k k1 = this.c;
    return (k1 == null) ? null : k1.R();
  }
  
  public int getImageMode() {
    com.bytedance.sdk.openadsdk.core.d.k k1 = this.c;
    return (k1 == null) ? -1 : k1.Q();
  }
  
  public int getInteractionType() {
    com.bytedance.sdk.openadsdk.core.d.k k1 = this.c;
    return (k1 == null) ? -1 : k1.B();
  }
  
  public Map<String, Object> getMediaExtraInfo() {
    com.bytedance.sdk.openadsdk.core.d.k k1 = this.c;
    return (k1 != null) ? k1.X() : null;
  }
  
  public void render() {
    this.a.h();
  }
  
  public void setDislikeCallback(Activity paramActivity, TTAdDislike.DislikeInteractionCallback paramDislikeInteractionCallback) {
    if (paramDislikeInteractionCallback != null) {
      if (paramActivity == null)
        return; 
      this.h = paramDislikeInteractionCallback;
      a(paramActivity, paramDislikeInteractionCallback);
    } 
  }
  
  public void setDislikeDialog(TTDislikeDialogAbstract paramTTDislikeDialogAbstract) {
    if (paramTTDislikeDialogAbstract == null) {
      t.b("dialog is null, please check");
      return;
    } 
    this.j = paramTTDislikeDialogAbstract;
    paramTTDislikeDialogAbstract.setMaterialMeta(this.c);
    NativeExpressView nativeExpressView = this.a;
    if (nativeExpressView != null)
      nativeExpressView.setOuterDislike(paramTTDislikeDialogAbstract); 
  }
  
  public void setDownloadListener(TTAppDownloadListener paramTTAppDownloadListener) {
    this.g = paramTTAppDownloadListener;
    a a1 = this.k;
    if (a1 != null)
      a1.a(this.g); 
  }
  
  public void setExpressInteractionListener(TTNativeExpressAd.AdInteractionListener paramAdInteractionListener) {
    this.f = (TTNativeExpressAd.ExpressAdInteractionListener)paramAdInteractionListener;
    this.a.setExpressInteractionListener((TTNativeExpressAd.ExpressAdInteractionListener)paramAdInteractionListener);
  }
  
  public void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener paramExpressAdInteractionListener) {
    this.f = paramExpressAdInteractionListener;
    this.a.setExpressInteractionListener(paramExpressAdInteractionListener);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\nativeexpress\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */