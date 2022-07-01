package com.qq.e.comm.plugin.ab;

import android.net.Uri;
import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.plugin.aa.a.b;
import com.qq.e.comm.plugin.j.c;
import com.qq.e.comm.plugin.util.aj;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.bb;
import com.qq.e.comm.plugin.y.d;
import com.qq.e.comm.plugin.y.e;
import com.qq.e.comm.plugin.y.g;
import com.qq.e.comm.plugin.y.u;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class j {
  private static final String a = j.class.getSimpleName();
  
  private static volatile j f;
  
  private File b = g();
  
  private File c = aj.j();
  
  private Set<String> d;
  
  private Set<String> e;
  
  private File a(String paramString, File paramFile) {
    File file = new File(paramFile, aj.a(paramString));
    if (file.exists()) {
      if (file.length() > 0L)
        return file; 
      file.delete();
    } 
    return null;
  }
  
  private FileInputStream a(String paramString, bb.a parama) {
    String str;
    File file;
    if (parama == bb.a.d) {
      file = b(paramString);
    } else {
      file = a(paramString);
    } 
    StringBuilder stringBuilder2 = null;
    if (file != null) {
      e e;
      if (parama == bb.a.d) {
        e = new e(1110108);
      } else {
        e = new e(1110104);
      } 
      u.a(e);
      try {
        str = a;
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("get response from cache: ");
        stringBuilder2.append(paramString);
        ak.a(str, stringBuilder2.toString());
        return new FileInputStream(file);
      } catch (IOException iOException) {
        iOException.printStackTrace();
        return null;
      } 
    } 
    if (str == bb.a.d && GDTADManager.getInstance().getSM().getInteger("web_proxy_img_cache", 0) == 1)
      return b((String)iOException, (bb.a)str); 
    StringBuilder stringBuilder1 = stringBuilder2;
    return (FileInputStream)((GDTADManager.getInstance().getSM().getInteger("web_proxy_res_cache", 0) == 1) ? b((String)iOException, (bb.a)str) : stringBuilder1);
  }
  
  private void a(String paramString, File paramFile, bb.a parama, a parama1) {
    b b = (new b.a()).a(paramFile).a(aj.a(paramString)).a(false).b(paramString).a();
    com.qq.e.comm.plugin.aa.a.a.a().a(b, paramString, new com.qq.e.comm.plugin.j.a(this, paramString, parama, parama1) {
          public void a() {}
          
          public void a(long param1Long1, long param1Long2, int param1Int) {}
          
          public void a(long param1Long, boolean param1Boolean) {}
          
          public void a(c param1c) {
            String str = j.f();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("download fail, url = ");
            stringBuilder.append(this.a);
            stringBuilder.append(" ,errorCode:");
            stringBuilder.append(param1c.a());
            stringBuilder.append(", errorMsg:");
            stringBuilder.append(param1c.b());
            ak.b(str, stringBuilder.toString());
            e e = new e(1110106);
            d d = new d();
            d.a("url", this.a);
            e.a(d);
            u.a(e);
            j.a a1 = this.c;
            if (a1 != null)
              a1.a((Exception)param1c); 
          }
          
          public void a(File param1File, long param1Long) {
            int i;
            String str = j.f();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("download success, url=");
            stringBuilder.append(this.a);
            stringBuilder.append(", time = ");
            stringBuilder.append(param1Long);
            ak.a(str, stringBuilder.toString());
            if (this.b == bb.a.d) {
              i = 2060001;
            } else {
              i = 2060003;
            } 
            g g = new g(i);
            g.b(param1Long);
            if (param1File.exists()) {
              g.b((int)(param1File.length() >> 10L));
              j.a a1 = this.c;
              if (a1 != null)
                a1.a(param1File); 
            } else {
              g.b(-1);
              j.a a1 = this.c;
              if (a1 != null)
                a1.a(new Exception("文件不存在")); 
            } 
            u.a(g);
          }
          
          public void b() {}
          
          public void c() {
            j.a a1 = this.c;
            if (a1 != null)
              a1.a(new Exception("下载被取消")); 
          }
        });
  }
  
  private File b(String paramString) {
    return a(paramString, this.b);
  }
  
  private FileInputStream b(String paramString, bb.a parama) {
    Exchanger<FileInputStream> exchanger = new Exchanger();
    a a1 = new a(this, exchanger) {
        public void a(File param1File) {
          try {
            this.a.exchange(new FileInputStream(param1File));
            return;
          } catch (FileNotFoundException fileNotFoundException) {
          
          } catch (InterruptedException interruptedException) {}
          interruptedException.printStackTrace();
        }
        
        public void a(Exception param1Exception) {
          ak.a(j.f(), param1Exception.getMessage());
          try {
            this.a.exchange(null);
            return;
          } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
            return;
          } 
        }
      };
    if (parama == bb.a.d) {
      a(paramString, a1);
    } else {
      a(paramString, parama, a1);
    } 
    try {
      return exchanger.exchange(null, 3L, TimeUnit.SECONDS);
    } catch (InterruptedException interruptedException) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("download InterruptedException, url = ");
      stringBuilder.append(paramString);
      ak.a(str, stringBuilder.toString(), interruptedException);
      return null;
    } catch (TimeoutException timeoutException) {
      timeoutException.printStackTrace();
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("download TimeoutException, url = ");
      stringBuilder.append(paramString);
      ak.a(str, stringBuilder.toString(), timeoutException);
      u.a(new e(1110107));
      return null;
    } 
  }
  
  public static j e() {
    // Byte code:
    //   0: getstatic com/qq/e/comm/plugin/ab/j.f : Lcom/qq/e/comm/plugin/ab/j;
    //   3: ifnonnull -> 37
    //   6: ldc com/qq/e/comm/plugin/ab/j
    //   8: monitorenter
    //   9: getstatic com/qq/e/comm/plugin/ab/j.f : Lcom/qq/e/comm/plugin/ab/j;
    //   12: ifnonnull -> 25
    //   15: new com/qq/e/comm/plugin/ab/j
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/qq/e/comm/plugin/ab/j.f : Lcom/qq/e/comm/plugin/ab/j;
    //   25: ldc com/qq/e/comm/plugin/ab/j
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/qq/e/comm/plugin/ab/j
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/qq/e/comm/plugin/ab/j.f : Lcom/qq/e/comm/plugin/ab/j;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private File g() {
    if (this.b == null)
      this.b = aj.l(); 
    if (!this.b.exists())
      this.b.mkdirs(); 
    return this.b;
  }
  
  public File a(String paramString) {
    return a(paramString, this.c);
  }
  
  public FileInputStream a(Uri paramUri) {
    String str = paramUri.toString();
    if (TextUtils.isEmpty(str)) {
      ak.a(a, "url == null or empty");
    } else {
      e e;
      String str2 = bb.a(paramUri);
      bb.a a = bb.c(str2);
      if (b().contains(str2)) {
        str2 = a;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("proxy image: ");
        stringBuilder1.append(str);
        ak.a(str2, stringBuilder1.toString());
        e = new e(1110101);
        u.a(e);
        return a(str, a);
      } 
      if (c().contains(e)) {
        String str3 = a;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("proxy resource: ");
        stringBuilder1.append(str);
        ak.a(str3, stringBuilder1.toString());
        e e1 = new e(1110109);
        u.a(e1);
        return a(str, a);
      } 
      String str1 = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("proxy fail: ");
      stringBuilder.append(str);
      ak.a(str1, stringBuilder.toString());
      if (GDTADManager.getInstance().getSM().getInteger("web_proxy_not_hit_event", 0) == 1) {
        e e1 = new e(1110105);
        e1.a((new d()).a("url", str));
        u.a(e1);
      } 
    } 
    return null;
  }
  
  public void a(String paramString, a parama) {
    String str1;
    if (TextUtils.isEmpty(paramString)) {
      ak.a(a, "downloadImage url is empty or null");
      return;
    } 
    String str2 = aj.a(paramString);
    if ((new File(g(), str2)).exists()) {
      str1 = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append(": 对应的文件本地已存在");
      ak.a(str1, stringBuilder.toString());
      return;
    } 
    a(paramString, g(), bb.a.d, (a)str1);
  }
  
  public void a(String paramString, bb.a parama, a parama1) {
    a(paramString, this.c, parama, parama1);
  }
  
  public boolean a() {
    SM sM = GDTADManager.getInstance().getSM();
    boolean bool = false;
    if (sM.getInteger("web_proxy", 0) == 1)
      bool = true; 
    return bool;
  }
  
  public Set<String> b() {
    if (this.e == null) {
      String str2 = GDTADManager.getInstance().getSM().getString("web_proxy_img_suffix");
      String str1 = str2;
      if (TextUtils.isEmpty(str2))
        str1 = "jpg,jpeg,png"; 
      this.e = new HashSet<String>(Arrays.asList(TextUtils.split(str1, ",")));
    } 
    return this.e;
  }
  
  public Set<String> c() {
    if (this.d == null) {
      String str2 = GDTADManager.getInstance().getSM().getString("web_proxy_res_suffix");
      String str1 = str2;
      if (TextUtils.isEmpty(str2))
        str1 = "html,js,css"; 
      this.d = new HashSet<String>(Arrays.asList(TextUtils.split(str1, ",")));
    } 
    return this.d;
  }
  
  public void d() {
    this.d = null;
    this.e = null;
  }
  
  public static interface a {
    void a(File param1File);
    
    void a(Exception param1Exception);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */