package com.qq.e.comm.plugin.gdtnativead.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qq.e.comm.plugin.aa.b.b;
import com.qq.e.comm.plugin.aa.b.c;
import com.qq.e.comm.plugin.aa.b.d;
import com.qq.e.comm.plugin.aa.b.e;
import com.qq.e.comm.plugin.aa.b.f;
import com.qq.e.comm.plugin.aa.b.g;
import com.qq.e.comm.plugin.ac.h;
import com.qq.e.comm.plugin.util.am;
import java.lang.ref.WeakReference;

public class c extends FrameLayout implements b, c.a {
  private View A;
  
  private View.OnClickListener B = new View.OnClickListener(this) {
      public void onClick(View param1View) {
        if (c.a(this.a) != null)
          c.a(this.a).j_(); 
      }
    };
  
  private View.OnClickListener C = new View.OnClickListener(this) {
      public void onClick(View param1View) {
        if (c.a(this.a) != null)
          c.a(this.a).i_(); 
      }
    };
  
  private View.OnClickListener D = new View.OnClickListener(this) {
      public void onClick(View param1View) {
        c.b(this.a);
      }
    };
  
  private View.OnClickListener E = new View.OnClickListener(this) {
      public void onClick(View param1View) {
        if (c.a(this.a) != null && c.c(this.a) != null)
          c.a(this.a).b(c.c(this.a).c()); 
        if (!c.d(this.a)) {
          c.e(this.a);
          this.a.a(3000, false);
        } 
      }
    };
  
  private f.a F = new f.a(this) {
      public void a() {
        if (c.a(this.a) != null)
          c.a(this.a).b_(); 
        c.f(this.a).setVisibility(0);
      }
      
      public void a(int param1Int, Exception param1Exception) {
        c.g(this.a).sendEmptyMessage(10003);
        if (c.a(this.a) != null)
          c.a(this.a).a(param1Int, param1Exception); 
      }
      
      public void b() {
        c.g(this.a).sendEmptyMessage(10002);
        if (c.h(this.a) != null)
          c.h(this.a).setVisibility(4); 
        if (c.a(this.a) != null)
          c.a(this.a).c_(); 
        c.i(this.a);
        this.a.e();
      }
      
      public void c() {
        c.g(this.a).removeMessages(10002);
        if (c.j(this.a) != null)
          c.j(this.a).a(100); 
        if (c.a(this.a) != null)
          c.a(this.a).f_(); 
        if (c.h(this.a) != null && c.k(this.a))
          c.h(this.a).setVisibility(0); 
        this.a.d(true);
        c.f(this.a).setVisibility(4);
      }
      
      public void d() {
        c.g(this.a).removeMessages(10002);
        if (c.j(this.a) != null)
          c.j(this.a).a(100); 
        if (c.h(this.a) != null && c.k(this.a))
          c.h(this.a).setVisibility(0); 
        if (c.a(this.a) != null)
          c.a(this.a).g_(); 
      }
      
      public void e() {
        c.g(this.a).removeMessages(10002);
        if (c.a(this.a) != null)
          c.a(this.a).h_(); 
      }
      
      public void f() {
        c.g(this.a).sendEmptyMessage(10002);
        c.i(this.a);
        if (c.a(this.a) != null)
          c.a(this.a).g(); 
      }
    };
  
  private final Handler G = new b(this);
  
  private e a;
  
  private c b;
  
  private boolean c;
  
  private boolean d;
  
  private int e;
  
  private a f;
  
  private FrameLayout g;
  
  private FrameLayout h;
  
  private ImageView i;
  
  private ImageView j;
  
  private ImageView k;
  
  private ImageView l;
  
  private h m;
  
  private Context n;
  
  private ImageView o;
  
  private String p;
  
  private int q;
  
  private int r;
  
  private int s;
  
  private int t;
  
  private int u;
  
  private int v;
  
  private boolean w;
  
  private boolean x;
  
  private boolean y;
  
  private boolean z = true;
  
  public c(Context paramContext, int paramInt, String paramString) {
    this(paramContext, paramInt, paramString, true, true);
  }
  
  public c(Context paramContext, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2) {
    super(paramContext);
    this.p = paramString;
    this.e = paramInt;
    this.w = paramBoolean1;
    this.x = paramBoolean2;
    this.n = paramContext.getApplicationContext();
    m();
    n();
  }
  
  private void m() {
    this.q = am.a(this.n, 12);
    this.r = am.a(this.n, 12);
    this.s = am.a(this.n, 24) + this.q * 2;
    this.t = am.a(this.n, 30) + this.r * 2;
    this.u = am.a(this.n, 46);
    this.v = am.a(this.n, 56);
  }
  
  private void n() {
    this.b = new c(getContext());
    this.b.setBackgroundColor(0);
    addView((View)this.b, 0);
    this.b.a(this);
    this.g = new FrameLayout(getContext());
    this.b.addView((View)this.g, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    o();
    p();
  }
  
  private void o() {
    byte b1;
    if (this.m == null) {
      this.m = new h(getContext());
      this.m.b(100);
    } 
    h h1 = this.m;
    if (this.w) {
      b1 = 0;
    } else {
      b1 = 4;
    } 
    h1.setVisibility(b1);
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, am.a(this.n, 3));
    layoutParams.gravity = 80;
    this.g.addView((View)this.m, (ViewGroup.LayoutParams)layoutParams);
  }
  
  private void p() {
    FrameLayout frameLayout = this.h;
    int i = 0;
    if (frameLayout == null) {
      this.h = new FrameLayout(getContext());
      GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { Integer.MIN_VALUE, 1073741824, 0 });
      gradientDrawable.setShape(0);
      this.h.setBackgroundDrawable((Drawable)gradientDrawable);
      this.h.setPadding(0, 0, 0, this.q);
    } 
    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
    this.g.addView((View)this.h, (ViewGroup.LayoutParams)layoutParams2);
    this.h.setVisibility(4);
    if (this.k == null) {
      this.k = new ImageView(getContext());
      this.k.setImageBitmap(g.i(this.n));
      this.k.setOnClickListener(this.C);
    } 
    int j = this.s;
    layoutParams2 = new FrameLayout.LayoutParams(j, j);
    layoutParams2.gravity = 53;
    ImageView imageView2 = this.k;
    j = this.q;
    imageView2.setPadding(j / 2, j, j, j);
    this.k.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    this.h.addView((View)this.k);
    if (this.j == null) {
      this.j = new ImageView(getContext());
      this.j.setImageBitmap(g.g(this.n));
      this.j.setOnClickListener(this.D);
    } 
    j = this.s;
    layoutParams2 = new FrameLayout.LayoutParams(j, j);
    layoutParams2.gravity = 53;
    layoutParams2.rightMargin = this.s;
    imageView2 = this.j;
    j = this.q;
    imageView2.setPadding(j, j, j / 2, j);
    this.j.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    this.h.addView((View)this.j);
    if (this.o == null && this.p != null) {
      this.o = new ImageView(getContext());
      layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
      layoutParams2.gravity = 17;
      this.g.addView((View)this.o, (ViewGroup.LayoutParams)layoutParams2);
      com.qq.e.comm.plugin.p.a.a().a(this.p, this.o);
    } 
    ImageView imageView1 = this.o;
    if (imageView1 != null) {
      if (!this.x)
        i = 4; 
      imageView1.setVisibility(i);
    } 
    if (this.i == null) {
      this.i = new ImageView(getContext());
      this.i.setImageBitmap(g.e(this.n));
      this.i.setOnClickListener(this.B);
    } 
    i = this.s;
    FrameLayout.LayoutParams layoutParams1 = new FrameLayout.LayoutParams(i, i);
    layoutParams1.gravity = 51;
    imageView2 = this.i;
    i = this.q;
    imageView2.setPadding(i, i, i, i);
    this.i.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    this.g.addView((View)this.i);
    if (this.l == null) {
      this.l = new ImageView(getContext());
      this.l.setImageBitmap(g.j(this.n));
      this.l.setOnClickListener(this.E);
    } 
    i = this.u;
    layoutParams1 = new FrameLayout.LayoutParams(i, i);
    layoutParams1.gravity = 17;
    this.l.setVisibility(4);
    this.g.addView((View)this.l, (ViewGroup.LayoutParams)layoutParams1);
  }
  
  private void q() {
    e e1 = this.a;
    if (e1 != null)
      if (e1.d()) {
        this.a.i();
      } else {
        this.a.h();
      }  
    e();
  }
  
  private void r() {
    e e1 = this.a;
    if (e1 != null)
      if (e1.c()) {
        this.a.a();
      } else {
        this.a.b();
      }  
    this.G.sendEmptyMessageDelayed(10004, 100L);
  }
  
  private void s() {
    if (this.l != null) {
      ImageView imageView;
      Bitmap bitmap;
      e e1 = this.a;
      if (e1 == null)
        return; 
      if (e1.c()) {
        imageView = this.l;
        bitmap = g.k(this.n);
      } else {
        imageView = this.l;
        bitmap = g.j(this.n);
      } 
      imageView.setImageBitmap(bitmap);
    } 
  }
  
  private int t() {
    e e1 = this.a;
    if (e1 == null)
      return 0; 
    int i = e1.f();
    int j = this.a.e();
    h h1 = this.m;
    if (h1 != null && j > 0)
      h1.a(i * 100 / j); 
    return i;
  }
  
  private void u() {
    ImageView imageView = this.i;
    if (imageView != null && this.j != null && this.l != null) {
      if (this.k == null)
        return; 
      FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)imageView.getLayoutParams();
      int i = this.s;
      layoutParams.width = i;
      layoutParams.height = i;
      ImageView imageView1 = this.i;
      i = this.q;
      imageView1.setPadding(i, i, i, i);
      this.i.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      layoutParams = (FrameLayout.LayoutParams)this.j.getLayoutParams();
      layoutParams.rightMargin = this.s;
      imageView1 = this.j;
      i = this.q;
      imageView1.setPadding(i, i, i / 2, i);
      i = this.s;
      layoutParams.width = i;
      layoutParams.height = i;
      this.j.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      layoutParams = (FrameLayout.LayoutParams)this.k.getLayoutParams();
      i = this.s;
      layoutParams.width = i;
      layoutParams.height = i;
      imageView1 = this.k;
      i = this.q;
      imageView1.setPadding(i / 2, i, i, i);
      this.k.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      layoutParams = (FrameLayout.LayoutParams)this.l.getLayoutParams();
      i = this.u;
      layoutParams.width = i;
      layoutParams.height = i;
      this.l.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    } 
  }
  
  private void v() {
    ImageView imageView = this.i;
    if (imageView != null && this.j != null) {
      if (this.l == null)
        return; 
      FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)imageView.getLayoutParams();
      int i = this.t;
      layoutParams.width = i;
      layoutParams.height = i;
      ImageView imageView1 = this.i;
      i = this.r;
      imageView1.setPadding(i, i, i, i);
      this.i.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      layoutParams = (FrameLayout.LayoutParams)this.j.getLayoutParams();
      i = this.t;
      layoutParams.width = i;
      layoutParams.height = i;
      layoutParams.rightMargin = 0;
      imageView1 = this.j;
      i = this.r;
      imageView1.setPadding(i, i, i, i);
      this.j.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      layoutParams = (FrameLayout.LayoutParams)this.l.getLayoutParams();
      i = this.v;
      layoutParams.width = i;
      layoutParams.height = i;
      this.l.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    } 
  }
  
  public void a() {
    this.d = false;
    this.y = true;
  }
  
  public void a(int paramInt) {
    this.e = paramInt;
    paramInt = this.e;
    if (paramInt == 4) {
      v();
      return;
    } 
    if (paramInt == 3)
      u(); 
  }
  
  public void a(int paramInt1, int paramInt2) {
    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.o.getLayoutParams();
    layoutParams.width = paramInt1;
    layoutParams.height = paramInt2;
    layoutParams.gravity = 17;
    this.o.post(new Runnable(this, layoutParams) {
          public void run() {
            c.h(this.b).setLayoutParams((ViewGroup.LayoutParams)this.a);
          }
        });
  }
  
  public void a(int paramInt, boolean paramBoolean) {
    a(paramInt, paramBoolean, 100L);
  }
  
  public void a(int paramInt, boolean paramBoolean, long paramLong) {
    if (!this.c) {
      ImageView imageView = this.l;
      if (imageView != null && this.h != null) {
        this.c = true;
        if (this.z)
          imageView.setVisibility(0); 
        if (!paramBoolean && !this.d)
          this.h.setVisibility(0); 
      } 
    } 
    this.G.sendEmptyMessageDelayed(10004, paramLong);
    e();
    Message message = this.G.obtainMessage(10001);
    if (paramInt != 0) {
      this.G.removeMessages(10001);
      this.G.sendMessageDelayed(message, paramInt);
    } 
  }
  
  public void a(long paramLong) {
    a(3000, this.y, paramLong);
  }
  
  public void a(d.a parama) {
    if (parama instanceof a)
      this.f = (a)parama; 
  }
  
  public void a(e parame) {
    this.a = parame;
    this.a.a(this.F);
    s();
  }
  
  public void a(boolean paramBoolean) {
    this.w = paramBoolean;
    h h1 = this.m;
    if (h1 != null) {
      byte b1;
      if (paramBoolean) {
        b1 = 0;
      } else {
        b1 = 4;
      } 
      h1.setVisibility(b1);
    } 
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: putfield x : Z
    //   5: aload_0
    //   6: getfield o : Landroid/widget/ImageView;
    //   9: ifnull -> 81
    //   12: iload_2
    //   13: ifeq -> 81
    //   16: iload_1
    //   17: ifeq -> 67
    //   20: aload_0
    //   21: getfield a : Lcom/qq/e/comm/plugin/aa/b/e;
    //   24: astore #4
    //   26: aload #4
    //   28: ifnull -> 67
    //   31: aload #4
    //   33: invokeinterface g : ()Lcom/qq/e/comm/plugin/aa/b/f$d;
    //   38: astore #4
    //   40: aload #4
    //   42: getstatic com/qq/e/comm/plugin/aa/b/f$d.g : Lcom/qq/e/comm/plugin/aa/b/f$d;
    //   45: if_acmpeq -> 56
    //   48: aload #4
    //   50: getstatic com/qq/e/comm/plugin/aa/b/f$d.e : Lcom/qq/e/comm/plugin/aa/b/f$d;
    //   53: if_acmpne -> 81
    //   56: aload_0
    //   57: getfield o : Landroid/widget/ImageView;
    //   60: astore #4
    //   62: iconst_0
    //   63: istore_3
    //   64: goto -> 75
    //   67: aload_0
    //   68: getfield o : Landroid/widget/ImageView;
    //   71: astore #4
    //   73: iconst_4
    //   74: istore_3
    //   75: aload #4
    //   77: iload_3
    //   78: invokevirtual setVisibility : (I)V
    //   81: return
  }
  
  public void b() {
    ImageView imageView = this.i;
    if (imageView != null && this.h != null) {
      imageView.setVisibility(4);
      this.h.setVisibility(4);
    } 
  }
  
  public void b(boolean paramBoolean) {
    this.z = paramBoolean;
    if (this.l != null) {
      if (paramBoolean && isShown()) {
        c();
        return;
      } 
      this.l.setVisibility(4);
    } 
  }
  
  public void c() {
    e e1 = this.a;
    if (e1 != null && e1.g() != f.d.a) {
      if (this.a.g() == f.d.b)
        return; 
      a(3000, this.y);
    } 
  }
  
  public void c(boolean paramBoolean) {
    this.d = paramBoolean;
    ImageView imageView = this.i;
    if (imageView != null && this.h != null) {
      boolean bool;
      if (paramBoolean) {
        bool = true;
      } else {
        bool = false;
      } 
      imageView.setVisibility(bool);
      this.h.setVisibility(bool);
    } 
  }
  
  public void d() {
    if (this.c) {
      ImageView imageView = this.l;
      if (imageView != null && this.h != null) {
        imageView.setVisibility(4);
        this.h.setVisibility(4);
        this.c = false;
      } 
    } 
  }
  
  public void d(boolean paramBoolean) {
    e e1 = this.a;
    if (e1 != null && e1.g() != f.d.a) {
      if (this.a.g() == f.d.b)
        return; 
      a(3000, paramBoolean);
    } 
  }
  
  public void e() {
    if (this.j != null) {
      ImageView imageView;
      Bitmap bitmap;
      e e1 = this.a;
      if (e1 == null)
        return; 
      if (e1.d()) {
        imageView = this.j;
        bitmap = g.h(this.n);
      } else {
        imageView = this.j;
        bitmap = g.g(this.n);
      } 
      imageView.setImageBitmap(bitmap);
    } 
  }
  
  public void e(boolean paramBoolean) {
    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.m.getLayoutParams();
    if (paramBoolean) {
      FrameLayout.LayoutParams layoutParams1;
      View view = this.A;
      if (view == null) {
        this.A = new View(this.n);
        this.A.setAlpha(0.6F);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { 16777215, 889192448, -1627389952, -16777216 });
        this.A.setBackgroundDrawable((Drawable)gradientDrawable);
        layoutParams1 = new FrameLayout.LayoutParams(-1, am.a(this.n, 250));
        layoutParams1.gravity = 80;
        this.g.addView(this.A, (ViewGroup.LayoutParams)layoutParams1);
      } else {
        layoutParams1.setVisibility(0);
      } 
      layoutParams.setMargins(0, 0, 0, am.a(this.n, 30));
    } 
    layoutParams.height = am.a(this.n, 2);
    this.m.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.m.bringToFront();
  }
  
  public void f() {
    boolean bool;
    ImageView imageView = this.k;
    if (imageView == null)
      return; 
    if (this.e == 4) {
      bool = true;
    } else {
      bool = false;
    } 
    imageView.setVisibility(bool);
  }
  
  public void g() {
    Bitmap bitmap;
    ImageView imageView = this.i;
    if (imageView == null)
      return; 
    if (this.e == 4) {
      bitmap = g.f(this.n);
    } else {
      bitmap = g.e(this.n);
    } 
    imageView.setImageBitmap(bitmap);
  }
  
  public void h() {
    if (this.c)
      c(); 
  }
  
  public void i() {
    Handler handler = this.G;
    if (handler != null) {
      handler.removeMessages(10002);
      this.G.removeMessages(10001);
    } 
  }
  
  public boolean isShown() {
    return this.c;
  }
  
  public boolean j() {
    e e1 = this.a;
    return (e1 != null) ? e1.d() : true;
  }
  
  public void k() {
    e e1 = this.a;
    if (e1 != null) {
      if (e1.d()) {
        this.a.i();
        return;
      } 
      this.a.h();
    } 
  }
  
  public void l() {
    View view = this.A;
    if (view != null)
      view.setVisibility(8); 
    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.m.getLayoutParams();
    layoutParams.setMargins(0, 0, 0, 0);
    layoutParams.height = am.a(this.n, 3);
    this.m.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
  
  public static interface a extends d.a {
    void b(boolean param1Boolean);
    
    void j_();
  }
  
  static class b extends Handler {
    private WeakReference<c> a;
    
    public b(c param1c) {
      this.a = new WeakReference<c>(param1c);
    }
    
    public void handleMessage(Message param1Message) {
      c c = this.a.get();
      if (c != null) {
        switch (param1Message.what) {
          default:
            return;
          case 10004:
            c.i(c);
            return;
          case 10003:
            c.setEnabled(false);
            return;
          case 10002:
            c.l(c);
            if (c.c(c) != null && c.c(c).c()) {
              sendMessageDelayed(obtainMessage(10002), 500L);
              return;
            } 
            return;
          case 10001:
            break;
        } 
        if (c.c(c) != null && c.c(c).c()) {
          c.d();
          return;
        } 
        param1Message = obtainMessage(10001);
        removeMessages(10001);
        sendMessageDelayed(param1Message, 3000L);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\gdtnativead\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */