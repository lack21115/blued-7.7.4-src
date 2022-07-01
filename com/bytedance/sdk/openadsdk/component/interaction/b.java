package com.bytedance.sdk.openadsdk.component.interaction;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.adnet.b.d;
import com.bytedance.sdk.adnet.core.n;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTInteractionAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.a.a;
import com.bytedance.sdk.openadsdk.core.d.j;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.downloadnew.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.g.e;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.t;
import java.util.Map;

class b implements TTInteractionAd {
  private static boolean i;
  
  private final Context a;
  
  private final k b;
  
  private Dialog c;
  
  private TTInteractionAd.AdInteractionListener d;
  
  private a e;
  
  private k f;
  
  private ImageView g;
  
  private ImageView h;
  
  b(Context paramContext, k paramk) {
    this.a = paramContext;
    this.b = paramk;
  }
  
  private void a() {
    if (this.c == null) {
      this.c = (Dialog)new m(this.a);
      this.c.setOnShowListener(new DialogInterface.OnShowListener(this) {
            public void onShow(DialogInterface param1DialogInterface) {
              if (b.a(this.a).isShowing()) {
                d.a(b.b(this.a), b.c(this.a), "interaction", null);
                if (b.d(this.a) != null)
                  b.d(this.a).onAdShow(); 
                if (b.c(this.a).U())
                  ah.a(b.c(this.a), (View)b.e(this.a)); 
              } 
            }
          });
      this.c.setOnDismissListener(new DialogInterface.OnDismissListener(this) {
            public void onDismiss(DialogInterface param1DialogInterface) {
              if (b.f(this.a) != null)
                b.f(this.a).d(); 
            }
          });
      ((m)this.c).a(false, new m.a(this) {
            public void a(View param1View) {
              b.i(this.a);
              d.a(b.b(this.a), b.c(this.a), "interaction");
              if (b.d(this.a) != null)
                b.d(this.a).onAdDismiss(); 
              t.b("TTInteractionAdImpl", "dislike事件发出");
            }
            
            public void a(ImageView param1ImageView1, ImageView param1ImageView2, FrameLayout param1FrameLayout) {
              b.a(this.a, param1ImageView1);
              b.b(this.a, param1ImageView2);
              b.g(this.a);
              b.h(this.a);
            }
          });
    } 
  }
  
  private void b() {
    a a1 = new a(this.a, this.b, "interaction", 3);
    a1.a((View)this.h);
    a1.b((View)this.g);
    a1.a(this.e);
    a1.a(new com.bytedance.sdk.openadsdk.core.a.b.a(this) {
          public void a(View param1View, int param1Int) {
            if (b.d(this.a) != null)
              b.d(this.a).onAdClicked(); 
            if (param1Int == 2 || param1Int == 3 || param1Int == 5) {
              b.i(this.a);
              if (b.d(this.a) != null)
                b.d(this.a).onAdDismiss(); 
            } 
          }
        });
    this.h.setOnClickListener((View.OnClickListener)a1);
    this.h.setOnTouchListener((View.OnTouchListener)a1);
  }
  
  private void c() {
    int i = ((j)this.b.F().get(0)).b();
    String str = ((j)this.b.F().get(0)).a();
    e.a(this.a).g().a(str, new d.d(this) {
          public void a() {}
          
          public void a(d.c param1c, boolean param1Boolean) {
            if (param1c != null && param1c.a() != null) {
              b.e(this.a).setImageBitmap(param1c.a());
              if (b.j(this.a) != null)
                b.j(this.a).a(); 
              return;
            } 
            if (b.j(this.a) != null)
              b.j(this.a).b(); 
          }
          
          public void a(n<Bitmap> param1n) {}
          
          public void b() {}
          
          public void b(n<Bitmap> param1n) {
            if (b.j(this.a) != null)
              b.j(this.a).b(); 
          }
        },  i, i);
  }
  
  private void d() {
    i = false;
    this.c.dismiss();
  }
  
  void a(k paramk) {
    this.f = paramk;
    d.a(this.b);
    if (getInteractionType() == 4)
      this.e = a.a(this.a, this.b, "interaction"); 
    a();
  }
  
  public int getInteractionType() {
    k k1 = this.b;
    return (k1 == null) ? -1 : k1.B();
  }
  
  public Map<String, Object> getMediaExtraInfo() {
    k k1 = this.b;
    return (k1 != null) ? k1.X() : null;
  }
  
  public void setAdInteractionListener(TTInteractionAd.AdInteractionListener paramAdInteractionListener) {
    this.d = paramAdInteractionListener;
  }
  
  public void setDownloadListener(TTAppDownloadListener paramTTAppDownloadListener) {
    a a1 = this.e;
    if (a1 != null)
      a1.a(paramTTAppDownloadListener); 
  }
  
  public void showInteractionAd(Activity paramActivity) {
    if (paramActivity.isFinishing())
      return; 
    if (Looper.getMainLooper() == Looper.myLooper()) {
      if (!i) {
        i = true;
        this.c.show();
      } 
      return;
    } 
    throw new IllegalStateException("不能在子线程调用 TTInteractionAd.showInteractionAd");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\component\interaction\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */