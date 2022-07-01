package com.qq.e.comm.plugin.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.a.b.a;
import com.qq.e.comm.plugin.a.b.b;
import com.qq.e.comm.plugin.a.b.d;
import com.qq.e.comm.plugin.a.d.b;
import com.qq.e.comm.plugin.d.c;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public final class p implements f {
  private final Context a;
  
  private final c b;
  
  private f.a c;
  
  private f.a d = new f.a(this) {
      public void a(int param1Int, String param1String, boolean param1Boolean) {
        if (param1Int == 0) {
          p p1 = this.a;
          p.a(p1, p.a(p1));
        } 
        if (p.b(this.a) != null)
          p.b(this.a).a(param1Int, param1String, param1Boolean); 
      }
      
      public boolean a() {
        return false;
      }
    };
  
  public p(Context paramContext) {
    this(paramContext, null);
  }
  
  public p(Context paramContext, c paramc) {
    this.a = paramContext.getApplicationContext();
    this.b = paramc;
  }
  
  private Intent a(Context paramContext, File paramFile) {
    Intent intent = new Intent("android.intent.action.VIEW");
    Uri uri = c.a(paramContext, paramFile);
    intent.addFlags(1);
    intent.setDataAndType(uri, "application/vnd.android.package-archive");
    intent.addFlags(268435456);
    intent.addFlags(32768);
    return intent;
  }
  
  private void a(c paramc) {
    if (paramc == null)
      return; 
    Context context = GDTADManager.getInstance().getAppContext();
    Intent intent = n.a(context, paramc);
    if (intent != null) {
      a a1 = new a(context, paramc);
      a1.a((d)new b(intent, paramc, context));
      a1.c();
      b.a().b(paramc.h());
    } 
  }
  
  public void a(f.a parama) {
    this.c = parama;
  }
  
  public void a(File paramFile) {
    if (b(paramFile)) {
      a.a.a(this.d, this.b);
      return;
    } 
    f.a a1 = this.c;
    if (a1 != null)
      a1.a(1, "", false); 
  }
  
  public boolean b(File paramFile) {
    Intent intent = a(this.a, paramFile);
    PackageManager packageManager = this.a.getPackageManager();
    boolean bool = false;
    if (packageManager.resolveActivity(intent, 0) != null) {
      this.a.startActivity(intent);
      bool = true;
    } 
    return bool;
  }
  
  public static final class a implements e.b, g.a {
    public static final a a = new a();
    
    private ConcurrentHashMap<String, f.a> b = new ConcurrentHashMap<String, f.a>();
    
    private e c;
    
    private a() {
      (new g(this)).a(GDTADManager.getInstance().getAppContext());
      this.c = new e(this);
    }
    
    public void a(f.a param1a, c param1c) {
      if (param1a != null) {
        if (param1c == null)
          return; 
        a(param1a, param1c.h());
      } 
    }
    
    public void a(f.a param1a, String param1String) {
      if (param1a != null) {
        if (TextUtils.isEmpty(param1String))
          return; 
        this.b.put(param1String, param1a);
        this.c.a(param1String);
      } 
    }
    
    public void a(String param1String) {
      c(param1String);
    }
    
    public boolean b(String param1String) {
      return this.b.containsKey(param1String);
    }
    
    public void c(String param1String) {
      if (param1String != null && this.b.containsKey(param1String)) {
        f.a a1 = this.b.remove(param1String);
        if (a1 != null)
          a1.a(0, "", a1.a()); 
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\a\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */