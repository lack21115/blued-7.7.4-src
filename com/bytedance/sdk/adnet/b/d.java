package com.bytedance.sdk.adnet.b;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.core.n;
import com.bytedance.sdk.adnet.err.VAdError;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class d {
  private final ExecutorService a = Executors.newCachedThreadPool();
  
  private final m b;
  
  private int c = 50;
  
  private final b d;
  
  private final Map<String, a> e = Collections.synchronizedMap(new HashMap<String, a>());
  
  private final Map<String, a> f = Collections.synchronizedMap(new HashMap<String, a>());
  
  private final Handler g = new Handler(Looper.getMainLooper());
  
  public d(m paramm, b paramb) {
    this.b = paramm;
    b b1 = paramb;
    if (paramb == null)
      b1 = new a(); 
    this.d = b1;
  }
  
  private String a(String paramString, int paramInt1, int paramInt2, ImageView.ScaleType paramScaleType) {
    String str = this.d.a(paramString, paramInt1, paramInt2, paramScaleType);
    if (!TextUtils.isEmpty(str))
      return str; 
    StringBuilder stringBuilder = new StringBuilder(paramString.length() + 12);
    stringBuilder.append("#W");
    stringBuilder.append(paramInt1);
    stringBuilder.append("#H");
    stringBuilder.append(paramInt2);
    stringBuilder.append("#S");
    stringBuilder.append(paramScaleType.ordinal());
    stringBuilder.append(paramString);
    return stringBuilder.toString();
  }
  
  private void a(String paramString, a parama) {
    this.f.put(paramString, parama);
    Runnable runnable = new Runnable(this, paramString) {
        public void run() {
          d.a a = (d.a)d.b(this.b).get(this.a);
          if (a != null)
            for (d.c c : d.a.a(a)) {
              if (d.c.a(c) == null)
                continue; 
              if (a.a() == null) {
                d.c.a(c, d.a.b(a));
                d.c.a(c).a(c, false);
              } else {
                d.c.a(c).b(a.b());
              } 
              d.c.a(c).b();
            }  
          d.b(this.b).remove(this.a);
        }
      };
    this.g.postDelayed(runnable, this.c);
  }
  
  private void b(String paramString, d paramd, int paramInt1, int paramInt2, ImageView.ScaleType paramScaleType) {
    c c1;
    this.g.post(new Runnable(this, paramd) {
          public void run() {
            this.a.a();
          }
        });
    String str = a(paramString, paramInt1, paramInt2, paramScaleType);
    Bitmap bitmap = this.d.a(str);
    if (bitmap != null) {
      c1 = new c(this, bitmap, paramString, null, null);
      this.g.post(new Runnable(this, paramd, c1) {
            public void run() {
              this.a.a(this.b, true);
              this.a.b();
            }
          });
      return;
    } 
    c c2 = new c(this, null, (String)c1, str, paramd);
    a a2 = this.e.get(str);
    a a1 = a2;
    if (a2 == null)
      a1 = this.f.get(str); 
    if (a1 != null) {
      a1.a(c2);
      return;
    } 
    Request<Bitmap> request = a((String)c1, paramInt1, paramInt2, paramScaleType, str);
    this.b.a(request);
    this.e.put(str, new a(request, c2));
  }
  
  protected Request<Bitmap> a(String paramString1, int paramInt1, int paramInt2, ImageView.ScaleType paramScaleType, String paramString2) {
    return new e(paramString1, new n.a<Bitmap>(this, paramString2) {
          public void a(n<Bitmap> param1n) {
            d.a(this.b).execute(new Runnable(this, param1n) {
                  public void run() {
                    this.b.b.a(this.b.a, this.a);
                  }
                });
          }
          
          public void b(n<Bitmap> param1n) {
            d.a(this.b).execute(new Runnable(this, param1n) {
                  public void run() {
                    this.b.b.b(this.b.a, this.a);
                  }
                });
          }
        }paramInt1, paramInt2, paramScaleType, Bitmap.Config.RGB_565);
  }
  
  public void a(String paramString, d paramd) {
    a(paramString, paramd, 0, 0);
  }
  
  public void a(String paramString, d paramd, int paramInt1, int paramInt2) {
    a(paramString, paramd, paramInt1, paramInt2, ImageView.ScaleType.CENTER_INSIDE);
  }
  
  public void a(String paramString, d paramd, int paramInt1, int paramInt2, ImageView.ScaleType paramScaleType) {
    this.a.execute(new Runnable(this, paramString, paramd, paramInt1, paramInt2, paramScaleType) {
          public void run() {
            d.a(this.f, this.a, this.b, this.c, this.d, this.e);
          }
        });
  }
  
  protected void a(String paramString, n<Bitmap> paramn) {
    this.d.a(paramString, (Bitmap)paramn.a);
    a a = this.e.remove(paramString);
    if (a != null) {
      a.a(a, (Bitmap)paramn.a);
      a.a(paramn);
      a(paramString, a);
    } 
  }
  
  protected void b(String paramString, n<Bitmap> paramn) {
    a a = this.e.remove(paramString);
    if (a != null) {
      a.a(paramn.c);
      a.a(paramn);
      a(paramString, a);
    } 
  }
  
  static class a {
    private final Request<?> a;
    
    private n<Bitmap> b;
    
    private Bitmap c;
    
    private VAdError d;
    
    private final List<d.c> e = Collections.synchronizedList(new ArrayList<d.c>());
    
    public a(Request<?> param1Request, d.c param1c) {
      this.a = param1Request;
      this.e.add(param1c);
    }
    
    public VAdError a() {
      return this.d;
    }
    
    public void a(d.c param1c) {
      this.e.add(param1c);
    }
    
    public void a(n<Bitmap> param1n) {
      this.b = param1n;
    }
    
    public void a(VAdError param1VAdError) {
      this.d = param1VAdError;
    }
    
    public n<Bitmap> b() {
      return this.b;
    }
  }
  
  public static interface b {
    Bitmap a(String param1String);
    
    String a(String param1String, int param1Int1, int param1Int2, ImageView.ScaleType param1ScaleType);
    
    void a(String param1String, Bitmap param1Bitmap);
  }
  
  public class c {
    private Bitmap b;
    
    private final d.d c;
    
    private final String d;
    
    private final String e;
    
    public c(d this$0, Bitmap param1Bitmap, String param1String1, String param1String2, d.d param1d) {
      this.b = param1Bitmap;
      this.e = param1String1;
      this.d = param1String2;
      this.c = param1d;
    }
    
    public Bitmap a() {
      return this.b;
    }
  }
  
  public static interface d extends n.a<Bitmap> {
    void a();
    
    void a(d.c param1c, boolean param1Boolean);
    
    void b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\adnet\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */