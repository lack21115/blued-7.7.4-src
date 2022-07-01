package com.bytedance.sdk.openadsdk.g.a;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.core.n;
import com.bytedance.sdk.adnet.err.VAdError;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class b {
  private final m a;
  
  private final Handler b = new Handler(Looper.getMainLooper());
  
  private final Map<String, d> c = Collections.synchronizedMap(new HashMap<String, d>());
  
  public b(m paramm) {
    this.a = paramm;
  }
  
  public static a a() {
    return new a();
  }
  
  private c a(String paramString1, int paramInt1, int paramInt2, ImageView.ScaleType paramScaleType, String paramString2) {
    return new c(paramString1, new c.a(this, paramString2, paramString1) {
          public void a(n<byte[]> param1n) {
            b.d d = (b.d)b.a(this.c).remove(this.a);
            if (d != null) {
              d.b = param1n;
              d.e = (byte[])param1n.a;
              b.a(this.c, this.a, this.b, d);
            } 
          }
          
          public void a(String param1String, byte[] param1ArrayOfbyte) {
            b.d d = (b.d)b.a(this.c).get(this.a);
            if (d != null)
              for (b.b b1 : d.c) {
                if (b1 != null)
                  b1.a(param1String, param1ArrayOfbyte); 
              }  
          }
          
          public void b(n<byte[]> param1n) {
            b.d d = (b.d)b.a(this.c).remove(this.a);
            if (d != null) {
              d.b = param1n;
              d.d = param1n.c;
              b.a(this.c, this.a, this.b, d);
            } 
          }
        }paramInt1, paramInt2, paramScaleType, Bitmap.Config.RGB_565);
  }
  
  private void a(String paramString1, String paramString2, d paramd) {
    if (paramd == null)
      return; 
    boolean bool = paramd.a();
    if (paramd.c != null) {
      for (b b1 : paramd.c) {
        if (b1 != null) {
          if (bool) {
            b1.a(new c(paramd.e, b1, paramString1, paramString2));
            continue;
          } 
          b1.b(new c(paramd.d, b1, paramString1, paramString2));
        } 
      } 
      paramd.c.clear();
    } 
  }
  
  private void b(String paramString, b paramb, int paramInt1, int paramInt2, ImageView.ScaleType paramScaleType) {
    c c1;
    String str = a.a().a(paramString, paramInt1, paramInt2, paramScaleType);
    a.a a = a.a().b(str);
    if (a != null && a.a != null) {
      c1 = new c(a.a, paramb, str, paramString);
      this.b.post(new Runnable(this, paramb, paramString, a, c1) {
            public void run() {
              b.b b1 = this.a;
              if (b1 != null)
                b1.a(this.b, this.c.a); 
              b1 = this.a;
              if (b1 != null)
                b1.a(this.d); 
            }
          });
      return;
    } 
    d d2 = this.c.get(str);
    if (d2 != null) {
      d2.a(paramb);
      return;
    } 
    c c = a(paramString, paramInt1, paramInt2, (ImageView.ScaleType)c1, str);
    d d1 = new d(c, paramb);
    this.a.a(c);
    this.c.put(str, d1);
  }
  
  public void a(String paramString, b paramb, int paramInt1, int paramInt2) {
    a(paramString, paramb, paramInt1, paramInt2, ImageView.ScaleType.CENTER_INSIDE);
  }
  
  public void a(String paramString, b paramb, int paramInt1, int paramInt2, ImageView.ScaleType paramScaleType) {
    if (paramb != null)
      this.b.post(new Runnable(this, paramb) {
            public void run() {
              b.b b1 = this.a;
              if (b1 != null)
                b1.a(); 
            }
          }); 
    com.bytedance.sdk.openadsdk.i.a.a().c(new Runnable(this, paramString, paramb, paramInt1, paramInt2, paramScaleType) {
          public void run() {
            b.a(this.f, this.a, this.b, this.c, this.d, this.e);
          }
        }5);
  }
  
  public static class a implements b {
    public void a() {}
    
    public void a(b.c param1c) {}
    
    public void a(String param1String, byte[] param1ArrayOfbyte) {}
    
    public void b(b.c param1c) {}
  }
  
  public static interface b {
    void a();
    
    void a(b.c param1c);
    
    void a(String param1String, byte[] param1ArrayOfbyte);
    
    void b(b.c param1c);
  }
  
  public static class c {
    private final byte[] a;
    
    private final b.b b;
    
    private final String c;
    
    private final String d;
    
    private final VAdError e;
    
    public c(VAdError param1VAdError, b.b param1b, String param1String1, String param1String2) {
      this.e = param1VAdError;
      this.b = param1b;
      this.c = param1String1;
      this.d = param1String2;
      this.a = null;
    }
    
    public c(byte[] param1ArrayOfbyte, b.b param1b, String param1String1, String param1String2) {
      this.a = param1ArrayOfbyte;
      this.b = param1b;
      this.c = param1String1;
      this.d = param1String2;
      this.e = null;
    }
  }
  
  static class d {
    c a;
    
    n b;
    
    List<b.b> c = Collections.synchronizedList(new ArrayList<b.b>());
    
    VAdError d;
    
    byte[] e;
    
    public d(c param1c, b.b param1b) {
      this.a = param1c;
      a(param1b);
    }
    
    void a(b.b param1b) {
      if (param1b != null)
        this.c.add(param1b); 
    }
    
    boolean a() {
      return (this.d == null && this.e != null);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\g\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */