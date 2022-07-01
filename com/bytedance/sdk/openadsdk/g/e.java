package com.bytedance.sdk.openadsdk.g;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.sdk.adnet.b.b;
import com.bytedance.sdk.adnet.b.d;
import com.bytedance.sdk.adnet.core.k;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.core.n;
import com.bytedance.sdk.adnet.core.o;
import com.bytedance.sdk.adnet.d.h;
import com.bytedance.sdk.adnet.face.IHttpStack;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.g.a.b;
import javax.net.ssl.SSLSocketFactory;

public class e {
  private static volatile e a;
  
  private static IHttpStack c;
  
  private Context b;
  
  private m d;
  
  private b e;
  
  private m f;
  
  private m g;
  
  private d h;
  
  private b i;
  
  private e(Context paramContext) {
    if (paramContext == null) {
      paramContext = o.a();
    } else {
      paramContext = paramContext.getApplicationContext();
    } 
    this.b = paramContext;
  }
  
  public static IHttpStack a() {
    return c;
  }
  
  public static a a(String paramString, ImageView paramImageView, int paramInt1, int paramInt2) {
    return new a(paramImageView, paramString, paramInt1, paramInt2);
  }
  
  public static e a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/g/e.a : Lcom/bytedance/sdk/openadsdk/g/e;
    //   3: ifnonnull -> 38
    //   6: ldc com/bytedance/sdk/openadsdk/g/e
    //   8: monitorenter
    //   9: getstatic com/bytedance/sdk/openadsdk/g/e.a : Lcom/bytedance/sdk/openadsdk/g/e;
    //   12: ifnonnull -> 26
    //   15: new com/bytedance/sdk/openadsdk/g/e
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Landroid/content/Context;)V
    //   23: putstatic com/bytedance/sdk/openadsdk/g/e.a : Lcom/bytedance/sdk/openadsdk/g/e;
    //   26: ldc com/bytedance/sdk/openadsdk/g/e
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/bytedance/sdk/openadsdk/g/e
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/bytedance/sdk/openadsdk/g/e.a : Lcom/bytedance/sdk/openadsdk/g/e;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  public static void a(IHttpStack paramIHttpStack) {
    c = paramIHttpStack;
  }
  
  public static com.bytedance.sdk.adnet.core.e b() {
    return new com.bytedance.sdk.adnet.core.e();
  }
  
  private void h() {
    if (this.i == null) {
      k();
      this.i = new b(this.g);
    } 
  }
  
  private void i() {
    if (this.h == null) {
      k();
      this.h = new d(this.g, (d.b)a.a());
    } 
  }
  
  private void j() {
    if (this.d == null)
      this.d = com.bytedance.sdk.adnet.a.a(this.b, l()); 
  }
  
  private void k() {
    if (this.g == null)
      this.g = com.bytedance.sdk.adnet.a.a(this.b, l()); 
  }
  
  private IHttpStack l() {
    return (IHttpStack)((a() != null) ? a() : new k((SSLSocketFactory)new h(), h.a, d.a));
  }
  
  public void a(o paramo) {
    com.bytedance.sdk.adnet.a.a(paramo);
  }
  
  public void a(String paramString, ImageView paramImageView) {
    a(paramString, paramImageView, a(paramString, paramImageView, 0, 0));
  }
  
  public void a(String paramString, ImageView paramImageView, d.d paramd) {
    i();
    this.h.a(paramString, paramd);
  }
  
  public void a(String paramString, b.a parama) {
    j();
    if (this.e == null)
      this.e = new b(this.b, this.d); 
    this.e.a(paramString, parama);
  }
  
  public m c() {
    j();
    return this.d;
  }
  
  public m d() {
    k();
    return this.g;
  }
  
  public m e() {
    if (this.f == null)
      this.f = com.bytedance.sdk.adnet.a.a(this.b, l()); 
    return this.f;
  }
  
  public b f() {
    h();
    return this.i;
  }
  
  public d g() {
    i();
    return this.h;
  }
  
  static class a implements d.d {
    private ImageView a;
    
    private final String b;
    
    private final int c;
    
    private final int d;
    
    a(ImageView param1ImageView, String param1String, int param1Int1, int param1Int2) {
      this.a = param1ImageView;
      this.b = param1String;
      this.c = param1Int1;
      this.d = param1Int2;
      param1ImageView = this.a;
      if (param1ImageView != null)
        param1ImageView.setTag(1094453505, param1String); 
    }
    
    private boolean c() {
      ImageView imageView = this.a;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (imageView != null) {
        Object object = imageView.getTag(1094453505);
        bool1 = bool2;
        if (object != null) {
          bool1 = bool2;
          if (object.equals(this.b))
            bool1 = true; 
        } 
      } 
      return bool1;
    }
    
    public void a() {
      ImageView imageView = this.a;
      if (imageView != null && imageView.getContext() instanceof Activity && ((Activity)this.a.getContext()).isFinishing())
        return; 
      if (this.a != null && c()) {
        int i = this.c;
        if (i != 0)
          this.a.setImageResource(i); 
      } 
    }
    
    public void a(d.c param1c, boolean param1Boolean) {
      ImageView imageView = this.a;
      if (imageView != null && imageView.getContext() instanceof Activity && ((Activity)this.a.getContext()).isFinishing())
        return; 
      if (this.a != null && c() && param1c.a() != null)
        this.a.setImageBitmap(param1c.a()); 
    }
    
    public void a(n<Bitmap> param1n) {}
    
    public void b() {
      this.a = null;
    }
    
    public void b(n<Bitmap> param1n) {
      ImageView imageView = this.a;
      if (imageView != null && imageView.getContext() instanceof Activity && ((Activity)this.a.getContext()).isFinishing())
        return; 
      if (this.a != null && this.d != 0 && c())
        this.a.setImageResource(this.d); 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\g\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */