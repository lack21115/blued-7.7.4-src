package com.qq.e.comm.plugin.c;

import android.content.Context;
import android.view.View;
import com.qq.e.ads.cfg.BrowserType;
import com.qq.e.comm.plugin.ad.e;
import com.qq.e.comm.plugin.s.b;
import com.qq.e.comm.plugin.s.c;
import com.qq.e.comm.plugin.util.b;
import com.qq.e.comm.plugin.util.bb;
import com.qq.e.comm.plugin.util.d;
import com.qq.e.comm.plugin.y.c;
import java.util.concurrent.Future;

public class f {
  String A;
  
  BrowserType B;
  
  boolean C;
  
  final com.qq.e.comm.plugin.s.a D;
  
  private Future<b> E;
  
  final e a;
  
  final int b;
  
  final String c;
  
  final boolean d;
  
  final boolean e;
  
  final String f;
  
  final boolean g;
  
  final Boolean h;
  
  final c i;
  
  final boolean j;
  
  final boolean k;
  
  final boolean l;
  
  final String m;
  
  final int n;
  
  final int o;
  
  final com.qq.e.comm.plugin.ad.f p;
  
  final boolean q;
  
  final boolean r;
  
  final boolean s;
  
  final boolean t;
  
  final boolean u;
  
  final boolean v;
  
  final int w;
  
  final Context x;
  
  final int y;
  
  final c z;
  
  private f(a parama) {
    Boolean bool2;
    this.D = a.a(parama);
    this.a = this.D.C();
    this.b = this.D.a_();
    this.c = this.D.s();
    this.d = this.D.ah();
    String str = this.D.af();
    this.e = bb.b(str);
    if (!this.e)
      str = null; 
    this.f = str;
    this.g = d.a(this.b);
    boolean bool = b.b(this.D);
    boolean bool1 = true;
    if (bool) {
      bool2 = Boolean.valueOf(true);
    } else if (b.c(this.D)) {
      bool2 = Boolean.valueOf(false);
    } else {
      this.h = null;
      this.i = this.D.l();
    } 
    this.h = bool2;
    this.i = this.D.l();
  }
  
  protected b a() {
    Future<b> future = this.E;
    if (future == null)
      return null; 
    try {
      return future.get();
    } catch (Exception exception) {
      return null;
    } 
  }
  
  void a(Future<b> paramFuture) {
    if (paramFuture == null)
      return; 
    this.E = paramFuture;
  }
  
  public static class a {
    private com.qq.e.comm.plugin.s.a a;
    
    private String b;
    
    private int c;
    
    private int d = 0;
    
    private com.qq.e.comm.plugin.ad.f e;
    
    private boolean f = false;
    
    private boolean g = true;
    
    private boolean h = false;
    
    private boolean i = false;
    
    private boolean j;
    
    private boolean k = true;
    
    public a(com.qq.e.comm.plugin.s.a param1a, View param1View) {
      this.a = param1a;
      this.c = com.qq.e.comm.plugin.ad.a.a().b(param1View);
      this.j = param1a.ah() ^ true;
    }
    
    public a a(int param1Int) {
      this.d = param1Int;
      return this;
    }
    
    public a a(com.qq.e.comm.plugin.ad.f param1f) {
      this.e = param1f;
      return this;
    }
    
    public a a(String param1String) {
      this.b = param1String;
      return this;
    }
    
    public a a(boolean param1Boolean) {
      this.f = param1Boolean;
      return this;
    }
    
    public f a() {
      return new f(this);
    }
    
    public a b(boolean param1Boolean) {
      this.g = param1Boolean;
      return this;
    }
    
    public a c(boolean param1Boolean) {
      this.h = param1Boolean;
      return this;
    }
    
    public a d(boolean param1Boolean) {
      this.i = param1Boolean;
      return this;
    }
    
    public a e(boolean param1Boolean) {
      this.j = param1Boolean;
      return this;
    }
    
    public a f(boolean param1Boolean) {
      this.k = param1Boolean;
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\c\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */