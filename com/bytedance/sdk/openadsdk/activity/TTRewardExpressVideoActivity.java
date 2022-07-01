package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.component.reward.view.FullRewardExpressView;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.d;
import com.bytedance.sdk.openadsdk.core.nativeexpress.e;
import com.bytedance.sdk.openadsdk.core.nativeexpress.g;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.downloadnew.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.ai;
import com.bytedance.sdk.openadsdk.utils.t;
import java.util.HashMap;
import java.util.Map;

public class TTRewardExpressVideoActivity extends TTRewardVideoActivity implements TTNativeExpressAd.ExpressAdInteractionListener, g {
  FullRewardExpressView aF;
  
  FrameLayout aG;
  
  long aH;
  
  a aI;
  
  String aJ = "rewarded_video";
  
  Handler aK;
  
  boolean aL = false;
  
  boolean aM = false;
  
  private EmptyView a(ViewGroup paramViewGroup) {
    for (int i = 0; i < paramViewGroup.getChildCount(); i++) {
      View view = paramViewGroup.getChildAt(i);
      if (view instanceof EmptyView)
        return (EmptyView)view; 
    } 
    return null;
  }
  
  private a a(k paramk) {
    return (paramk.B() == 4) ? a.a(this.d, paramk, this.aJ) : null;
  }
  
  private void f(boolean paramBoolean) {
    if (this.b != null) {
      this.b.setShowSkip(paramBoolean);
      this.b.setShowSound(paramBoolean);
      this.b.setShowCountDown(paramBoolean);
      this.b.setShowDislike(paramBoolean);
    } 
    if (paramBoolean) {
      ai.a((View)this.c, 0);
      ai.a((View)this.ar, 0);
      return;
    } 
    ai.a((View)this.c, 4);
    ai.a((View)this.ar, 8);
  }
  
  protected void I() {
    if (this.q == null) {
      finish();
      return;
    } 
    this.az = false;
    this.q.b(2);
    super.I();
  }
  
  public void J() {
    if (this.b != null)
      this.b.a(); 
  }
  
  public long K() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onGetCurrentPlayTime mVideoCurrent:");
    stringBuilder.append(this.aH);
    t.e("TTRewardExpressVideoActivity", stringBuilder.toString());
    return this.aH;
  }
  
  public int L() {
    if (this.aL)
      return 4; 
    if (this.aM)
      return 5; 
    if (t())
      return 1; 
    if (r())
      return 2; 
    if (s());
    return 3;
  }
  
  public void M() {
    H();
  }
  
  public void N() {
    super.N();
    FullRewardExpressView fullRewardExpressView = this.aF;
    if (fullRewardExpressView != null)
      fullRewardExpressView.g(); 
  }
  
  protected void a(NativeExpressView paramNativeExpressView, k paramk) {
    if (paramNativeExpressView != null) {
      if (this.q == null)
        return; 
      this.aI = a(paramk);
      a a1 = this.aI;
      if (a1 != null) {
        a1.b();
        if (paramNativeExpressView.getContext() != null && paramNativeExpressView.getContext() instanceof Activity)
          this.aI.a((Activity)paramNativeExpressView.getContext()); 
      } 
      d.a(paramk);
      EmptyView emptyView2 = a((ViewGroup)paramNativeExpressView);
      EmptyView emptyView1 = emptyView2;
      if (emptyView2 == null) {
        emptyView1 = new EmptyView(this.d, (View)paramNativeExpressView);
        paramNativeExpressView.addView((View)emptyView1);
      } 
      a a2 = this.aI;
      if (a2 != null)
        a2.a((View)emptyView1); 
      emptyView1.setCallback(new EmptyView.a(this) {
            public void a() {
              if (this.a.aI != null)
                this.a.aI.a(); 
            }
            
            public void a(View param1View) {}
            
            public void a(boolean param1Boolean) {
              if (this.a.aI != null)
                if (param1Boolean) {
                  if (this.a.aI != null) {
                    this.a.aI.b();
                    return;
                  } 
                } else if (this.a.aI != null) {
                  this.a.aI.c();
                }  
            }
            
            public void b() {
              if (this.a.aI != null)
                this.a.aI.d(); 
            }
          });
      Context context2 = this.d;
      String str = this.aJ;
      e e = new e(this, context2, paramk, str, ah.a(str)) {
          public void a(View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
            super.a(param1View, param1Int1, param1Int2, param1Int3, param1Int4);
            this.a.a(param1View, param1Int1, param1Int2, param1Int3, param1Int4);
          }
        };
      e.a((View)paramNativeExpressView);
      e.a(this.aI);
      if (!TextUtils.isEmpty(this.ac)) {
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        hashMap.put("rit_scene", this.ac);
        e.a(hashMap);
      } 
      this.aF.setClickListener(e);
      Context context1 = this.d;
      str = this.aJ;
      d d = new d(this, context1, paramk, str, ah.a(str)) {
          public void a(View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
            super.a(param1View, param1Int1, param1Int2, param1Int3, param1Int4);
            this.a.a(param1View, param1Int1, param1Int2, param1Int3, param1Int4);
          }
        };
      d.a((View)paramNativeExpressView);
      if (!TextUtils.isEmpty(this.ac)) {
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        hashMap.put("rit_scene", this.ac);
        d.a(hashMap);
      } 
      d.a(this.aI);
      this.aF.setClickCreativeListener(d);
      emptyView1.setNeedCheckingShow(false);
    } 
  }
  
  public boolean a(long paramLong, boolean paramBoolean) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void b(String paramString) {}
  
  protected void d() {
    super.d();
    int k = ah.d(this.q.P());
    int i = this.q.Q();
    int j = 0;
    if (i == 15) {
      i = 1;
    } else {
      i = 0;
    } 
    float f4 = a(this);
    float f3 = b(this);
    if (f4 > f3)
      j = 1; 
    float f2 = f4;
    float f1 = f3;
    if (i != j) {
      f2 = f4 + f3;
      f1 = f2 - f3;
      f2 -= f1;
    } 
    f3 = f2;
    f4 = f1;
    if (ai.b(this)) {
      j = ai.b((Context)this, ai.i((Context)this));
      if (i != 0) {
        f3 = f2 - j;
        f4 = f1;
      } else {
        f4 = f1 - j;
        f3 = f2;
      } 
    } 
    AdSlot adSlot = (new AdSlot.Builder()).setCodeId(String.valueOf(k)).setExpressViewAcceptedSize(f4, f3).build();
    this.aF = new FullRewardExpressView((Context)this, this.q, adSlot, this.aJ);
    this.aF.setExpressVideoListenerProxy(this);
    this.aF.setExpressInteractionListener(this);
    a((NativeExpressView)this.aF, this.q);
    this.aG = this.aF.getVideoFrameLayout();
    this.m.addView((View)this.aF, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    d(true);
    this.aF.h();
  }
  
  public void d(int paramInt) {
    if (paramInt != 1) {
      if (paramInt != 2) {
        if (paramInt != 3) {
          if (paramInt != 4) {
            if (paramInt != 5)
              return; 
            if (!r()) {
              if (s())
                return; 
              a(0L, false);
              return;
            } 
            return;
          } 
          if (this.A != null) {
            this.A.k();
            this.A = null;
            return;
          } 
        } else {
          try {
            if (s())
              return; 
          } finally {
            Exception exception = null;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onPause throw Exception :");
            stringBuilder.append(exception.getMessage());
            t.e("TTRewardExpressVideoActivity", stringBuilder.toString());
          } 
        } 
      } else {
        try {
          if (r())
            return; 
        } finally {
          Exception exception = null;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("onPause throw Exception :");
          stringBuilder.append(exception.getMessage());
          t.e("TTRewardExpressVideoActivity", stringBuilder.toString());
        } 
      } 
    } else if (!r()) {
      if (s())
        return; 
      a(0L, false);
    } 
  }
  
  public void e(boolean paramBoolean) {
    if (this.M != paramBoolean && this.b != null)
      this.b.b(); 
  }
  
  public void onAdClicked(View paramView, int paramInt) {}
  
  public void onAdShow(View paramView, int paramInt) {}
  
  protected void onDestroy() {
    super.onDestroy();
    Handler handler = this.aK;
    if (handler != null)
      handler.removeCallbacksAndMessages(null); 
    FullRewardExpressView fullRewardExpressView = this.aF;
    if (fullRewardExpressView != null)
      fullRewardExpressView.k(); 
  }
  
  public void onRenderFail(View paramView, String paramString, int paramInt) {
    this.az = true;
    f();
    if (this.aK == null)
      this.aK = new Handler(Looper.getMainLooper()); 
    this.aK.post(new Runnable(this) {
          public void run() {
            this.a.q();
          }
        });
  }
  
  public void onRenderSuccess(View paramView, float paramFloat1, float paramFloat2) {
    if (this.q.c() == 1 && this.q.q())
      return; 
    if (this.aF.m())
      f(true); 
    d(false);
    this.az = true;
    f();
    if (!a(this.u, false)) {
      q();
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      hashMap.put("vbtt_skip_type", Integer.valueOf(1));
      a(this.aJ, (Map)hashMap);
    } 
  }
  
  protected void onResume() {
    super.onResume();
    if (!this.aF.m())
      f(false); 
    ai.a(this);
    FullRewardExpressView fullRewardExpressView = this.aF;
    if (fullRewardExpressView != null)
      fullRewardExpressView.i(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\activity\TTRewardExpressVideoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */