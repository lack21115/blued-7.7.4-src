package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
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
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.c;
import com.bytedance.sdk.openadsdk.core.nativeexpress.d;
import com.bytedance.sdk.openadsdk.core.nativeexpress.e;
import com.bytedance.sdk.openadsdk.core.nativeexpress.l;
import com.bytedance.sdk.openadsdk.downloadnew.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.t;
import java.util.List;
import java.util.Map;

public class b extends l implements ak.a {
  TTDislikeDialogAbstract a;
  
  private a b;
  
  private final Context c;
  
  private k d;
  
  private AdSlot f;
  
  private TTNativeExpressAd.ExpressAdInteractionListener g;
  
  private TTAppDownloadListener h;
  
  private com.bytedance.sdk.openadsdk.dislike.b i;
  
  private ak j;
  
  private int k;
  
  private TTAdDislike.DislikeInteractionCallback l;
  
  private Context m;
  
  private String n = "banner_ad";
  
  public b(Context paramContext, k paramk, AdSlot paramAdSlot) {
    this.c = paramContext;
    this.d = paramk;
    this.f = paramAdSlot;
    this.b = new a(paramContext, paramk, paramAdSlot);
    b(this.b.c(), this.d);
  }
  
  private EmptyView a(ViewGroup paramViewGroup) {
    for (int i = 0; i < paramViewGroup.getChildCount(); i++) {
      View view = paramViewGroup.getChildAt(i);
      if (view instanceof EmptyView)
        return (EmptyView)view; 
    } 
    return null;
  }
  
  private a a(k paramk) {
    if (paramk.B() == 4) {
      a a1 = a.a(this.c, paramk, this.n);
      TTAppDownloadListener tTAppDownloadListener = this.h;
      if (tTAppDownloadListener != null)
        a1.a(tTAppDownloadListener); 
      return a1;
    } 
    return null;
  }
  
  private void a() {
    ak ak1 = this.j;
    if (ak1 != null) {
      ak1.removeCallbacksAndMessages(null);
      this.j.sendEmptyMessageDelayed(112201, this.k);
    } 
  }
  
  private void a(Activity paramActivity, TTAdDislike.DislikeInteractionCallback paramDislikeInteractionCallback) {
    if (this.i == null)
      this.i = new com.bytedance.sdk.openadsdk.dislike.b((Context)paramActivity, this.d); 
    this.m = (Context)paramActivity;
    this.i.setDislikeInteractionCallback(paramDislikeInteractionCallback);
    a a1 = this.b;
    if (a1 != null && a1.c() != null)
      this.b.c().setDislike((TTAdDislike)this.i); 
  }
  
  private void a(NativeExpressView paramNativeExpressView, k paramk) {
    if (paramNativeExpressView != null) {
      if (paramk == null)
        return; 
      if (this.l != null) {
        this.i.a(paramk);
        if (paramNativeExpressView != null)
          paramNativeExpressView.setDislike((TTAdDislike)this.i); 
      } 
      TTDislikeDialogAbstract tTDislikeDialogAbstract = this.a;
      if (tTDislikeDialogAbstract != null) {
        tTDislikeDialogAbstract.setMaterialMeta(paramk);
        if (paramNativeExpressView != null)
          paramNativeExpressView.setOuterDislike(this.a); 
      } 
    } 
  }
  
  private void b() {
    ak ak1 = this.j;
    if (ak1 != null)
      ak1.removeCallbacksAndMessages(null); 
  }
  
  private void b(k paramk) {
    if (this.b.d() != null && this.b.f()) {
      a(this.b.d(), paramk);
      b(this.b.d(), paramk);
    } 
  }
  
  private void b(NativeExpressView paramNativeExpressView, k paramk) {
    if (paramNativeExpressView != null) {
      if (paramk == null)
        return; 
      this.d = paramk;
      a a1 = a(paramk);
      paramNativeExpressView.setBackupListener(new c(this, a1) {
            public boolean a(NativeExpressView param1NativeExpressView, int param1Int) {
              param1NativeExpressView.l();
              BannerExpressBackupView bannerExpressBackupView = new BannerExpressBackupView(param1NativeExpressView.getContext());
              bannerExpressBackupView.a(b.a(this.b), param1NativeExpressView, this.a);
              bannerExpressBackupView.setDislikeInner((TTAdDislike)b.b(this.b));
              bannerExpressBackupView.setDislikeOuter(this.b.a);
              return true;
            }
          });
      if (a1 != null) {
        a1.b();
        if (paramNativeExpressView.getContext() != null && paramNativeExpressView.getContext() instanceof Activity)
          a1.a((Activity)paramNativeExpressView.getContext()); 
      } 
      d.a(paramk);
      EmptyView emptyView2 = a((ViewGroup)paramNativeExpressView);
      EmptyView emptyView1 = emptyView2;
      if (emptyView2 == null) {
        emptyView1 = new EmptyView(this.c, (View)paramNativeExpressView);
        paramNativeExpressView.addView((View)emptyView1);
      } 
      if (a1 != null)
        a1.a((View)emptyView1); 
      emptyView1.setCallback(new EmptyView.a(this, a1, paramNativeExpressView, paramk) {
            public void a() {
              a a1 = this.a;
              if (a1 != null)
                a1.a(); 
            }
            
            public void a(View param1View) {
              throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
            }
            
            public void a(boolean param1Boolean) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("TAG=");
              stringBuilder.append(b.c(this.d));
              stringBuilder.append(",onWindowFocusChanged....hasWindowFocus=");
              stringBuilder.append(param1Boolean);
              t.b("checkWebViewIsTransparent", stringBuilder.toString());
              a a1 = this.a;
              if (a1 != null)
                if (param1Boolean) {
                  if (a1 != null)
                    a1.b(); 
                } else if (a1 != null) {
                  a1.c();
                }  
              if (param1Boolean) {
                b.d(this.d);
                t.b("TTBannerExpressAd", "获得焦点，开始计时");
                return;
              } 
              t.b("TTBannerExpressAd", "失去焦点，停止计时");
              b.e(this.d);
            }
            
            public void b() {
              a a1 = this.a;
              if (a1 != null)
                a1.d(); 
            }
          });
      e e = new e(this.c, paramk, this.n, 2);
      e.a((View)paramNativeExpressView);
      e.a(a1);
      paramNativeExpressView.setClickListener(e);
      d d = new d(this.c, paramk, this.n, 2);
      d.a((View)paramNativeExpressView);
      d.a(a1);
      paramNativeExpressView.setClickCreativeListener(d);
      if (a1 != null)
        a1.a(this.h); 
      emptyView1.setNeedCheckingShow(true);
    } 
  }
  
  private void c() {
    com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(this.c).a(this.f, 1, null, new com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(this) {
          public void a() {
            b.d(this.a);
          }
          
          public void a(List<k> param1List) {
            k k;
            if (param1List == null) {
              param1List = null;
            } else {
              k = param1List.get(0);
            } 
            b.h(this.a).a(k, b.i(this.a));
            b.a(this.a, k);
            b.h(this.a).e();
            b.d(this.a);
          }
        }5000);
  }
  
  public void a(Message paramMessage) {
    if (paramMessage.what == 112201)
      c(); 
  }
  
  public void destroy() {
    a a1 = this.b;
    if (a1 != null)
      a1.b(); 
  }
  
  public View getExpressAdView() {
    return (View)this.b;
  }
  
  public List<FilterWord> getFilterWords() {
    k k1 = this.d;
    return (k1 == null) ? null : k1.R();
  }
  
  public int getImageMode() {
    k k1 = this.d;
    return (k1 == null) ? -1 : k1.Q();
  }
  
  public int getInteractionType() {
    k k1 = this.d;
    return (k1 == null) ? -1 : k1.B();
  }
  
  public Map<String, Object> getMediaExtraInfo() {
    k k1 = this.d;
    return (k1 != null) ? k1.X() : null;
  }
  
  public void render() {
    this.b.a();
  }
  
  public void setDislikeCallback(Activity paramActivity, TTAdDislike.DislikeInteractionCallback paramDislikeInteractionCallback) {
    if (paramDislikeInteractionCallback != null) {
      if (paramActivity == null)
        return; 
      this.l = paramDislikeInteractionCallback;
      a(paramActivity, paramDislikeInteractionCallback);
    } 
  }
  
  public void setDislikeDialog(TTDislikeDialogAbstract paramTTDislikeDialogAbstract) {
    if (paramTTDislikeDialogAbstract == null) {
      t.b("dialog is null, please check");
      return;
    } 
    this.a = paramTTDislikeDialogAbstract;
    paramTTDislikeDialogAbstract.setMaterialMeta(this.d);
    a a1 = this.b;
    if (a1 != null && a1.c() != null)
      this.b.c().setOuterDislike(paramTTDislikeDialogAbstract); 
  }
  
  public void setDownloadListener(TTAppDownloadListener paramTTAppDownloadListener) {
    this.h = paramTTAppDownloadListener;
  }
  
  public void setExpressInteractionListener(TTNativeExpressAd.AdInteractionListener paramAdInteractionListener) {
    this.g = (TTNativeExpressAd.ExpressAdInteractionListener)paramAdInteractionListener;
    this.b.a((TTNativeExpressAd.ExpressAdInteractionListener)paramAdInteractionListener);
  }
  
  public void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener paramExpressAdInteractionListener) {
    this.g = paramExpressAdInteractionListener;
    this.b.a(paramExpressAdInteractionListener);
  }
  
  public void setSlideIntervalTime(int paramInt) {
    int i;
    if (paramInt <= 0)
      return; 
    this.n = "slide_banner_ad";
    b(this.b.c(), this.d);
    this.b.a(1000);
    if (paramInt < 30000) {
      i = 30000;
    } else {
      i = paramInt;
      if (paramInt > 120000)
        i = 120000; 
    } 
    this.k = i;
    this.j = new ak(Looper.getMainLooper(), this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\bannerexpress\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */