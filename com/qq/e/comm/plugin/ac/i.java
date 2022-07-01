package com.qq.e.comm.plugin.ac;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qq.e.comm.plugin.a.d.a;
import com.qq.e.comm.plugin.a.l;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.y;

public class i extends RelativeLayout implements a {
  public h a;
  
  public TextView b;
  
  private Context c;
  
  private com.qq.e.comm.plugin.s.a d;
  
  private int e;
  
  private String f = "打开";
  
  private String g = "下载";
  
  private String h = "下载中";
  
  private String i = "安装";
  
  private String j = "打开";
  
  private a k;
  
  private i(Context paramContext) {
    super(paramContext);
    this.c = paramContext;
  }
  
  private String a() {
    com.qq.e.comm.plugin.s.a a1 = this.d;
    return (a1 != null && a1.v() && this.d.z() != null) ? this.d.z().d() : "";
  }
  
  private void a(int paramInt1, int paramInt2) {
    String str;
    if (paramInt1 != 0)
      if (paramInt1 != 1) {
        if (paramInt1 != 4) {
          if (paramInt1 != 8) {
            if (paramInt1 != 16 && paramInt1 != 32 && paramInt1 != 64)
              return; 
          } else {
            h h2 = this.a;
            if (h2 != null)
              h2.a(100); 
            TextView textView1 = this.b;
            if (textView1 != null) {
              str = this.i;
            } else {
              return;
            } 
            textView1.setText(str);
          } 
        } else {
          h h2 = this.a;
          if (h2 != null)
            h2.a(paramInt2); 
          TextView textView1 = this.b;
          if (textView1 != null) {
            textView1.setText(this.h);
            this.b.setTextColor(this.e);
            return;
          } 
          return;
        } 
      } else {
        h h2 = this.a;
        if (h2 != null)
          h2.a(100); 
        TextView textView1 = this.b;
        if (textView1 != null) {
          str = this.j;
        } else {
          return;
        } 
        textView1.setText(str);
      }  
    h h1 = this.a;
    if (h1 != null)
      h1.a(100); 
    TextView textView = this.b;
    if (textView != null) {
      str = this.g;
    } else {
      return;
    } 
    textView.setText(str);
  }
  
  private void a(a parama) {
    if (parama == null)
      return; 
    this.a = new h(this.c);
    this.b = new TextView(this.c);
    this.d = parama.a;
    String str = a();
    if (!TextUtils.isEmpty(str))
      l.a().a(str, this); 
    this.e = parama.g;
    this.k = parama.j;
    if (parama.i != null && parama.i.length == 5) {
      this.f = parama.i[0];
      this.g = parama.i[1];
      this.h = parama.i[2];
      this.i = parama.i[3];
      this.j = parama.i[4];
    } 
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(parama.c, parama.d);
    this.a.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    if (parama.h != -1)
      this.a.c(parama.h); 
    this.a.a(parama.b);
    this.a.b(100);
    this.a.a(true);
    this.b.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.b.setBackgroundDrawable(null);
    this.b.setGravity(17);
    this.b.setTextColor(parama.f);
    this.b.setTextSize(2, parama.e);
    com.qq.e.comm.plugin.s.a a1 = this.d;
    if (a1 != null && a1.v()) {
      a(l.a().a(str), -1);
    } else {
      this.b.setText(this.f);
    } 
    addView(this.a);
    addView((View)this.b);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, long paramLong) {
    String str = a();
    if (TextUtils.isEmpty(str) || TextUtils.isEmpty(paramString)) {
      paramString = "onAPKStatusUpdate adInfoPkgName or pkgName null";
    } else if (!str.equals(paramString)) {
      paramString = "onAPKStatusUpdate adInfoPkgName mismatch pkgName";
    } else {
      y.a(new Runnable(this, paramInt1, paramInt2, paramString, paramLong) {
            public void run() {
              i.a(this.e, this.a, this.b);
              if (i.a(this.e) != null)
                i.a(this.e).a(this.c, this.a, this.b, this.d); 
            }
          });
      return;
    } 
    ak.a("ProgressButton", paramString);
  }
  
  public static class a {
    com.qq.e.comm.plugin.s.a a;
    
    int b;
    
    int c;
    
    int d;
    
    int e = 12;
    
    int f;
    
    int g;
    
    int h = -1;
    
    String[] i;
    
    a j;
    
    public a a(int param1Int) {
      this.b = param1Int;
      return this;
    }
    
    public a a(a param1a) {
      this.j = param1a;
      return this;
    }
    
    public a a(com.qq.e.comm.plugin.s.a param1a) {
      this.a = param1a;
      return this;
    }
    
    public a a(String[] param1ArrayOfString) {
      if (param1ArrayOfString == null || param1ArrayOfString.length != 5) {
        ak.a("ProgressButton", "setStatusText null or length is not 5");
        return this;
      } 
      this.i = param1ArrayOfString;
      return this;
    }
    
    public i a(Context param1Context) {
      i i = new i(param1Context);
      i.a(i, this);
      return i;
    }
    
    public a b(int param1Int) {
      this.c = param1Int;
      return this;
    }
    
    public a c(int param1Int) {
      this.d = param1Int;
      return this;
    }
    
    public a d(int param1Int) {
      this.e = param1Int;
      return this;
    }
    
    public a e(int param1Int) {
      this.f = param1Int;
      return this;
    }
    
    public a f(int param1Int) {
      this.g = param1Int;
      return this;
    }
    
    public a g(int param1Int) {
      this.h = param1Int;
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ac\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */