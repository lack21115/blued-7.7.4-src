package com.bytedance.sdk.openadsdk.core.c;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.c;
import com.bytedance.sdk.openadsdk.core.nativeexpress.d;
import com.bytedance.sdk.openadsdk.core.nativeexpress.e;
import com.bytedance.sdk.openadsdk.core.nativeexpress.l;
import com.bytedance.sdk.openadsdk.downloadnew.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.utils.t;
import java.util.List;
import java.util.Map;

public class b extends l {
  a a;
  
  private NativeExpressView b;
  
  private final Context c;
  
  private k d;
  
  private TTNativeExpressAd.ExpressAdInteractionListener f;
  
  private TTNativeExpressAd.AdInteractionListener g;
  
  private TTAppDownloadListener h;
  
  private com.bytedance.sdk.openadsdk.dislike.b i;
  
  private a j;
  
  private Dialog k;
  
  private FrameLayout l;
  
  private String m = "interaction";
  
  public b(Context paramContext, k paramk, AdSlot paramAdSlot) {
    this.c = paramContext;
    this.d = paramk;
    this.b = new NativeExpressView(paramContext, paramk, paramAdSlot, this.m);
    a(this.b, this.d);
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
    return (paramk.B() == 4) ? a.a(this.c, paramk, this.m) : null;
  }
  
  private void a() {
    Dialog dialog = this.k;
    if (dialog != null)
      dialog.dismiss(); 
  }
  
  private void a(Activity paramActivity) {
    if (this.k == null) {
      this.k = (Dialog)new m((Context)paramActivity);
      this.k.setOnDismissListener(new DialogInterface.OnDismissListener(this) {
            public void onDismiss(DialogInterface param1DialogInterface) {
              if (b.c(this.a) != null)
                b.c(this.a).d(); 
              d.a(b.d(this.a), b.b(this.a), "interaction");
              if (b.h(this.a) != null)
                b.h(this.a).onAdDismiss(); 
              t.b("TTInteractionExpressAd", "dislike事件发出");
            }
          });
      ((m)this.k).a(true, new m.a(this) {
            public void a(View param1View) {
              b.g(this.a);
            }
            
            public void a(ImageView param1ImageView1, ImageView param1ImageView2, FrameLayout param1FrameLayout) {
              b.a(this.a, param1FrameLayout);
              b.i(this.a).addView((View)b.a(this.a), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
            }
          });
    } 
    a a1 = this.a;
    if (a1 != null)
      a1.a(this.k); 
    if (!this.k.isShowing())
      this.k.show(); 
  }
  
  private void a(Activity paramActivity, TTAdDislike.DislikeInteractionCallback paramDislikeInteractionCallback) {
    if (this.i == null)
      this.i = new com.bytedance.sdk.openadsdk.dislike.b((Context)paramActivity, this.d); 
    this.i.setDislikeInteractionCallback(paramDislikeInteractionCallback);
    NativeExpressView nativeExpressView = this.b;
    if (nativeExpressView != null)
      nativeExpressView.setDislike((TTAdDislike)this.i); 
  }
  
  private void a(NativeExpressView paramNativeExpressView, k paramk) {
    this.d = paramk;
    this.b.setBackupListener(new c(this) {
          public boolean a(NativeExpressView param1NativeExpressView, int param1Int) {
            b.a(this.a).l();
            this.a.a = new a(param1NativeExpressView.getContext());
            this.a.a.a(b.b(this.a), b.a(this.a), b.c(this.a));
            return true;
          }
        });
    this.j = a(paramk);
    a a2 = this.j;
    if (a2 != null) {
      a2.b();
      if (paramNativeExpressView.getContext() != null && paramNativeExpressView.getContext() instanceof Activity)
        this.j.a((Activity)paramNativeExpressView.getContext()); 
    } 
    d.a(paramk);
    EmptyView emptyView2 = a((ViewGroup)paramNativeExpressView);
    EmptyView emptyView1 = emptyView2;
    if (emptyView2 == null) {
      emptyView1 = new EmptyView(this.c, (View)paramNativeExpressView);
      paramNativeExpressView.addView((View)emptyView1);
    } 
    a a3 = this.j;
    if (a3 != null)
      a3.a((View)emptyView1); 
    emptyView1.setCallback(new EmptyView.a(this, paramk) {
          public void a() {
            if (b.c(this.b) != null)
              b.c(this.b).a(); 
          }
          
          public void a(View param1View) {
            throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
          }
          
          public void a(boolean param1Boolean) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ExpressView onWindowFocusChanged=");
            stringBuilder.append(param1Boolean);
            t.b("TTInteractionExpressAd", stringBuilder.toString());
            if (b.c(this.b) != null)
              if (param1Boolean) {
                if (b.c(this.b) != null) {
                  b.c(this.b).b();
                  return;
                } 
              } else if (b.c(this.b) != null) {
                b.c(this.b).c();
              }  
          }
          
          public void b() {
            if (b.c(this.b) != null)
              b.c(this.b).d(); 
          }
        });
    e e = new e(this.c, paramk, this.m, 3);
    e.a((View)paramNativeExpressView);
    e.a(this.j);
    this.b.setClickListener(e);
    d d = new d(this.c, paramk, this.m, 3);
    d.a((View)paramNativeExpressView);
    d.a(this.j);
    d.a(new com.bytedance.sdk.openadsdk.core.a.b.a(this) {
          public void a(View param1View, int param1Int) {
            if (param1Int == 2 || param1Int == 3 || param1Int == 5)
              b.g(this.a); 
          }
        });
    this.b.setClickCreativeListener(d);
    a a1 = this.j;
    if (a1 != null)
      a1.a(this.h); 
    emptyView1.setNeedCheckingShow(true);
  }
  
  public void destroy() {
    NativeExpressView nativeExpressView = this.b;
    if (nativeExpressView != null)
      nativeExpressView.k(); 
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
    this.b.h();
  }
  
  public void setDislikeCallback(Activity paramActivity, TTAdDislike.DislikeInteractionCallback paramDislikeInteractionCallback) {
    if (paramDislikeInteractionCallback != null) {
      if (paramActivity == null)
        return; 
      a(paramActivity, paramDislikeInteractionCallback);
    } 
  }
  
  public void setDislikeDialog(TTDislikeDialogAbstract paramTTDislikeDialogAbstract) {
    if (paramTTDislikeDialogAbstract == null) {
      t.b("dialog is null, please check");
      return;
    } 
    paramTTDislikeDialogAbstract.setMaterialMeta(this.d);
    NativeExpressView nativeExpressView = this.b;
    if (nativeExpressView != null)
      nativeExpressView.setOuterDislike(paramTTDislikeDialogAbstract); 
  }
  
  public void setDownloadListener(TTAppDownloadListener paramTTAppDownloadListener) {
    this.h = paramTTAppDownloadListener;
    a a1 = this.j;
    if (a1 != null)
      a1.a(this.h); 
  }
  
  public void setExpressInteractionListener(TTNativeExpressAd.AdInteractionListener paramAdInteractionListener) {
    this.g = paramAdInteractionListener;
    this.f = (TTNativeExpressAd.ExpressAdInteractionListener)paramAdInteractionListener;
    this.b.setExpressInteractionListener((TTNativeExpressAd.ExpressAdInteractionListener)paramAdInteractionListener);
  }
  
  public void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener paramExpressAdInteractionListener) {
    this.f = paramExpressAdInteractionListener;
    this.b.setExpressInteractionListener(paramExpressAdInteractionListener);
  }
  
  public void showInteractionExpressAd(Activity paramActivity) {
    if (paramActivity != null) {
      if (paramActivity.isFinishing())
        return; 
      if (Looper.getMainLooper() != Looper.myLooper()) {
        t.b("不能在子线程调用 TTInteractionExpressAd.showInteractionAd");
        return;
      } 
      a(paramActivity);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */