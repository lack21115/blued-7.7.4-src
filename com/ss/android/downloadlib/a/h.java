package com.ss.android.downloadlib.a;

import android.content.Context;
import android.os.Environment;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.ss.android.a.a.a.n;
import com.ss.android.a.a.b.d;
import com.ss.android.a.a.c.e;
import com.ss.android.downloadlib.a.b.c;
import com.ss.android.downloadlib.a.b.d;
import com.ss.android.downloadlib.a.c.a;
import com.ss.android.downloadlib.e.c;
import com.ss.android.downloadlib.e.d;
import com.ss.android.downloadlib.e.e;
import com.ss.android.downloadlib.e.g;
import com.ss.android.downloadlib.e.h;
import com.ss.android.downloadlib.g;
import com.ss.android.socialbase.appdownloader.c;
import com.ss.android.socialbase.appdownloader.g;
import com.ss.android.socialbase.downloader.d.p;
import com.ss.android.socialbase.downloader.d.w;
import com.ss.android.socialbase.downloader.downloader.f;
import com.ss.android.socialbase.downloader.g.c;
import com.ss.android.socialbase.downloader.g.e;
import com.ss.android.socialbase.downloader.m.f;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class h implements h.a {
  private long a;
  
  private c.a b;
  
  private boolean c = false;
  
  private final h d = new h(Looper.getMainLooper(), this);
  
  private b e;
  
  public static String a(String paramString1, String paramString2, com.ss.android.socialbase.downloader.k.a parama) {
    // Byte code:
    //   0: invokestatic h : ()Lcom/ss/android/socialbase/appdownloader/d;
    //   3: invokestatic a : ()Landroid/content/Context;
    //   6: aload_0
    //   7: invokevirtual a : (Landroid/content/Context;Ljava/lang/String;)Lcom/ss/android/socialbase/downloader/g/c;
    //   10: astore_0
    //   11: aload_0
    //   12: ifnull -> 20
    //   15: aload_0
    //   16: invokevirtual k : ()Ljava/lang/String;
    //   19: areturn
    //   20: aload_1
    //   21: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   24: ifne -> 29
    //   27: aload_1
    //   28: areturn
    //   29: aconst_null
    //   30: astore_0
    //   31: invokestatic a : ()Landroid/content/Context;
    //   34: invokestatic a : (Landroid/content/Context;)Ljava/lang/String;
    //   37: astore_1
    //   38: aload_1
    //   39: astore_0
    //   40: goto -> 43
    //   43: aload_2
    //   44: ldc 'back_fix_sigbus'
    //   46: iconst_0
    //   47: invokevirtual a : (Ljava/lang/String;I)I
    //   50: iconst_1
    //   51: if_icmpne -> 56
    //   54: aload_0
    //   55: areturn
    //   56: invokestatic a : ()Landroid/content/Context;
    //   59: invokevirtual getFilesDir : ()Ljava/io/File;
    //   62: astore #4
    //   64: aload #4
    //   66: invokevirtual exists : ()Z
    //   69: ifne -> 78
    //   72: aload #4
    //   74: invokevirtual mkdirs : ()Z
    //   77: pop
    //   78: aload_0
    //   79: astore_1
    //   80: aload #4
    //   82: invokevirtual exists : ()Z
    //   85: ifeq -> 151
    //   88: aload #4
    //   90: invokevirtual isDirectory : ()Z
    //   93: ifne -> 98
    //   96: aload_0
    //   97: areturn
    //   98: aload_2
    //   99: ldc 'bugfix_sigbus_all_brand'
    //   101: iconst_0
    //   102: invokevirtual a : (Ljava/lang/String;I)I
    //   105: iconst_1
    //   106: if_icmpeq -> 117
    //   109: aload_0
    //   110: astore_1
    //   111: invokestatic b : ()Z
    //   114: ifeq -> 151
    //   117: getstatic android/os/Build$VERSION.SDK_INT : I
    //   120: istore_3
    //   121: aload_0
    //   122: astore_1
    //   123: iload_3
    //   124: bipush #21
    //   126: if_icmplt -> 151
    //   129: aload_0
    //   130: astore_1
    //   131: iload_3
    //   132: bipush #25
    //   134: if_icmpgt -> 151
    //   137: aload_0
    //   138: astore_1
    //   139: invokestatic a : ()Z
    //   142: ifeq -> 151
    //   145: aload #4
    //   147: invokevirtual getPath : ()Ljava/lang/String;
    //   150: astore_1
    //   151: aload_1
    //   152: areturn
    //   153: astore_1
    //   154: goto -> 43
    // Exception table:
    //   from	to	target	type
    //   31	38	153	java/lang/Exception
  }
  
  public static List<d> a(Map<Integer, Object> paramMap) {
    ArrayList<d> arrayList = new ArrayList();
    if (paramMap != null) {
      if (paramMap.isEmpty())
        return arrayList; 
      for (d d : paramMap.values()) {
        if (d instanceof d) {
          arrayList.add(d);
          continue;
        } 
        if (d instanceof SoftReference) {
          SoftReference<d> softReference = (SoftReference)d;
          if (softReference.get() instanceof d)
            arrayList.add(softReference.get()); 
        } 
      } 
    } 
    return arrayList;
  }
  
  private boolean a(int paramInt) {
    return (this.b.d.b() == 2 && paramInt == 2) ? true : ((this.b.d.b() == 3));
  }
  
  private void b(n paramn) {
    if (e.b("android.permission.WRITE_EXTERNAL_STORAGE")) {
      if (paramn != null)
        paramn.a(); 
      return;
    } 
    e.a a1 = new e.a(this, paramn) {
        public void a() {
          n n1 = this.a;
          if (n1 != null)
            n1.a(); 
        }
        
        public void a(String param1String) {
          n n1 = this.a;
          if (n1 != null)
            n1.a(param1String); 
        }
      };
    e.a(new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" }, a1);
  }
  
  private boolean d() {
    return (e() && f());
  }
  
  private boolean e() {
    return (this.b.b != null && !TextUtils.isEmpty(this.b.b.t()) && !TextUtils.isEmpty(this.b.b.a()));
  }
  
  private boolean e(c paramc) {
    return (f(paramc) && !g.a(this.b.b));
  }
  
  private boolean f() {
    return this.b.d.d();
  }
  
  private boolean f(c paramc) {
    return (paramc != null && paramc.q() == -3);
  }
  
  private void g() {
    Message message = Message.obtain();
    message.what = 1;
    this.d.sendMessageDelayed(message, 1200L);
  }
  
  private boolean h() {
    return (g.a(this.b.b) && i.a(this.b.d.a()));
  }
  
  int a(Context paramContext, w paramw) {
    a a1;
    boolean bool;
    if (paramContext == null)
      return 0; 
    Map map = this.b.b.h();
    ArrayList<e> arrayList = new ArrayList();
    if (map != null)
      for (Map.Entry entry : map.entrySet()) {
        if (entry != null)
          arrayList.add(new e((String)entry.getKey(), (String)entry.getValue())); 
      }  
    String str1 = c.a(String.valueOf(this.b.b.d()), this.b.b.c(), this.b.b.i(), String.valueOf(this.b.b.x()));
    com.ss.android.socialbase.downloader.k.a a2 = com.ss.android.socialbase.downloader.k.a.a(this.b.b.n());
    String str2 = a(this.b.b.a(), this.b.b.l(), a2);
    int i = com.ss.android.socialbase.downloader.downloader.b.a(this.b.b.a(), str2);
    c c = f.a(j.a()).h(i);
    if (c != null && 3 == this.b.b.x()) {
      c.f(true);
      f.a(c);
    } 
    g g1 = (new g(paramContext, this.b.b.a())).b(this.b.b.b()).a(this.b.b.f()).d(str1).a(arrayList).a(this.b.b.j()).c(this.b.b.k()).b(this.b.b.m()).c(str2).a(paramw).l(this.b.b.o()).a(this.b.b.A()).b(this.b.b.z()).f(this.b.b.t()).c(1000).d(100).a(this.b.b.n()).i(true).j(true).a(a2.a("retry_count", 5)).b(a2.a("backup_url_retry_count", 0)).j(true).m(true);
    if (a2.a("need_https_to_http_retry", 0) == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    g1 = g1.d(bool);
    if (a2.a("need_chunk_downgrade_retry", 1) == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    g1 = g1.h(bool);
    if (a2.a("need_retry_delay", 0) == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    g1 = g1.g(bool).h(a2.c("retry_delay_time_array"));
    if (a2.a("need_reuse_runnable", 0) == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    g1 = g1.k(bool);
    if (a2.a("need_independent_process", 0) == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    g g2 = g1.l(bool).a(e.a(this.b.b.a(), this.b.b.n())).a(e.a(this.b.b.n()));
    if (!TextUtils.isEmpty(this.b.b.g())) {
      g2.e(this.b.b.g());
    } else {
      g2.e("application/vnd.android.package-archive");
    } 
    g1 = null;
    if (a2.a("clear_space_use_disk_handler", 0) == 1) {
      a1 = new a();
      g2.a((p)a1);
    } 
    i = i.a(this.b.b, d(), g2);
    if (a1 != null)
      a1.a(i); 
    return i;
  }
  
  public int a(boolean paramBoolean) {
    return (a() && paramBoolean) ? 1 : 0;
  }
  
  public void a(long paramLong) {
    this.a = paramLong;
    this.b = c.a().e(paramLong);
    if (this.b.a())
      g.b(); 
  }
  
  public void a(Message paramMessage) {
    if (paramMessage.what != 1)
      return; 
    com.ss.android.a.a.a.a a1 = j.k();
    if (a1 != null && a1.a())
      com.ss.android.downloadlib.d.a.a().a("install_window_show", this.b); 
  }
  
  void a(Message paramMessage, e parame, List<d> paramList) {
    if (paramMessage != null) {
      if (paramMessage.what != 3)
        return; 
      c c = (c)paramMessage.obj;
      int j = paramMessage.arg1;
      int i = 0;
      if (j != 1 && paramMessage.arg1 != 6 && paramMessage.arg1 == 2 && c.ay()) {
        g.a().a(this.b.b, this.b.d, this.b.c);
        c.f(false);
      } 
      parame.a(c);
      int k = c.a(c.q());
      long l = c.ab();
      if (l > 0L) {
        j = (int)(c.Z() * 100L / l);
        b b1 = this.e;
        i = j;
        if (b1 != null) {
          b1.a(c);
          this.e = null;
          i = j;
        } 
      } 
      for (d d : paramList) {
        if (k != 1) {
          if (k != 2) {
            if (k != 3)
              continue; 
            if (c.q() == -4) {
              d.a();
              continue;
            } 
            if (c.q() == -1) {
              d.a(parame);
              continue;
            } 
            if (c.q() == -3) {
              if (g.a(this.b.b)) {
                d.b(parame);
                continue;
              } 
              d.c(parame);
            } 
            continue;
          } 
          d.b(parame, i);
          continue;
        } 
        d.a(parame, i);
      } 
    } 
  }
  
  void a(n paramn) {
    if (!TextUtils.isEmpty(this.b.b.l()) && this.b.b.l().startsWith(Environment.getDataDirectory().getAbsolutePath())) {
      paramn.a();
      return;
    } 
    b(new n(this, paramn) {
          public void a() {
            this.a.a();
          }
          
          public void a(String param1String) {
            j.d().a(1, j.a(), (h.a(this.b)).b, "您已禁止使用存储权限，请授权后再下载", null, 1);
            com.ss.android.downloadlib.d.a.a().b(h.b(this.b), 1);
            this.a.a(param1String);
          }
        });
  }
  
  public void a(c paramc) {
    this.c = false;
    b b1 = this.e;
    if (b1 != null) {
      b1.a(paramc);
      this.e = null;
    } 
  }
  
  void a(c paramc, e parame, List<d> paramList) {
    // Byte code:
    //   0: aload_3
    //   1: invokeinterface isEmpty : ()Z
    //   6: ifeq -> 10
    //   9: return
    //   10: aload_1
    //   11: ifnull -> 296
    //   14: aload_2
    //   15: ifnonnull -> 21
    //   18: goto -> 296
    //   21: iconst_0
    //   22: istore #5
    //   24: aload_1
    //   25: invokevirtual ab : ()J
    //   28: lconst_0
    //   29: lcmp
    //   30: ifle -> 63
    //   33: aload_1
    //   34: invokevirtual Z : ()J
    //   37: ldc2_w 100
    //   40: lmul
    //   41: aload_1
    //   42: invokevirtual ab : ()J
    //   45: ldiv
    //   46: lstore #6
    //   48: lload #6
    //   50: l2i
    //   51: istore #4
    //   53: goto -> 66
    //   56: astore #8
    //   58: aload #8
    //   60: invokevirtual printStackTrace : ()V
    //   63: iconst_0
    //   64: istore #4
    //   66: iload #4
    //   68: ifge -> 78
    //   71: iload #5
    //   73: istore #4
    //   75: goto -> 78
    //   78: aload_2
    //   79: aload_1
    //   80: invokevirtual a : (Lcom/ss/android/socialbase/downloader/g/c;)V
    //   83: aload_3
    //   84: invokeinterface iterator : ()Ljava/util/Iterator;
    //   89: astore_3
    //   90: aload_3
    //   91: invokeinterface hasNext : ()Z
    //   96: ifeq -> 295
    //   99: aload_3
    //   100: invokeinterface next : ()Ljava/lang/Object;
    //   105: checkcast com/ss/android/a/a/b/d
    //   108: astore #8
    //   110: aload_1
    //   111: invokevirtual q : ()I
    //   114: tableswitch default -> 180, -4 -> 255, -3 -> 220, -2 -> 207, -1 -> 196, 0 -> 180, 1 -> 183, 2 -> 183, 3 -> 183, 4 -> 183, 5 -> 183, 6 -> 180, 7 -> 183, 8 -> 183
    //   180: goto -> 90
    //   183: aload #8
    //   185: aload_2
    //   186: iload #4
    //   188: invokeinterface a : (Lcom/ss/android/a/a/c/e;I)V
    //   193: goto -> 90
    //   196: aload #8
    //   198: aload_2
    //   199: invokeinterface a : (Lcom/ss/android/a/a/c/e;)V
    //   204: goto -> 90
    //   207: aload #8
    //   209: aload_2
    //   210: iload #4
    //   212: invokeinterface b : (Lcom/ss/android/a/a/c/e;I)V
    //   217: goto -> 90
    //   220: aload_0
    //   221: getfield b : Lcom/ss/android/downloadlib/a/b/c$a;
    //   224: getfield b : Lcom/ss/android/a/a/b/c;
    //   227: invokestatic a : (Lcom/ss/android/a/a/b/c;)Z
    //   230: ifeq -> 244
    //   233: aload #8
    //   235: aload_2
    //   236: invokeinterface b : (Lcom/ss/android/a/a/c/e;)V
    //   241: goto -> 90
    //   244: aload #8
    //   246: aload_2
    //   247: invokeinterface c : (Lcom/ss/android/a/a/c/e;)V
    //   252: goto -> 90
    //   255: aload_0
    //   256: getfield b : Lcom/ss/android/downloadlib/a/b/c$a;
    //   259: getfield b : Lcom/ss/android/a/a/b/c;
    //   262: invokestatic a : (Lcom/ss/android/a/a/b/c;)Z
    //   265: ifeq -> 285
    //   268: aload_2
    //   269: bipush #-3
    //   271: putfield b : I
    //   274: aload #8
    //   276: aload_2
    //   277: invokeinterface b : (Lcom/ss/android/a/a/c/e;)V
    //   282: goto -> 90
    //   285: aload #8
    //   287: invokeinterface a : ()V
    //   292: goto -> 90
    //   295: return
    //   296: aload_3
    //   297: invokeinterface iterator : ()Ljava/util/Iterator;
    //   302: astore_1
    //   303: aload_1
    //   304: invokeinterface hasNext : ()Z
    //   309: ifeq -> 329
    //   312: aload_1
    //   313: invokeinterface next : ()Ljava/lang/Object;
    //   318: checkcast com/ss/android/a/a/b/d
    //   321: invokeinterface a : ()V
    //   326: goto -> 303
    //   329: return
    // Exception table:
    //   from	to	target	type
    //   24	48	56	java/lang/Exception
  }
  
  boolean a() {
    return (g.a(this.b.b) && !i.a(this.b.d.a()));
  }
  
  boolean a(Context paramContext, int paramInt, boolean paramBoolean) {
    com.ss.android.downloadad.a.b.a a1;
    d d1;
    d d2 = new d(0);
    if (g.a(this.b.b)) {
      String str;
      com.ss.android.a.a.c.b b1 = this.b.b.u();
      if (b1 == null) {
        str = null;
      } else {
        str = b1.a();
      } 
      if (i.a(this.b.d.a())) {
        d1 = d.a(str, this.b.b.t());
      } else {
        d1 = d2;
        if (!paramBoolean) {
          d1 = d2;
          if (i.c(this.b.d.a()))
            d1 = d.a(str); 
        } 
      } 
    } else {
      d1 = d2;
      if (a(paramInt)) {
        d1 = d2;
        if (!TextUtils.isEmpty(this.b.b.t())) {
          d1 = d2;
          if (j.i().optInt("disable_market") != 1) {
            com.ss.android.downloadlib.d.a.a().a("market_click_open", this.b);
            d1 = d.a(paramContext, this.b.b.t());
          } 
        } 
      } 
    } 
    switch (d1.a()) {
      default:
        return false;
      case 6:
        com.ss.android.downloadlib.d.a.a().a("market_open_failed", this.b);
        return false;
      case 5:
        com.ss.android.downloadlib.d.a.a().a(this.a, paramInt);
        com.ss.android.downloadlib.d.a.a().a("market_open_success", this.b);
        j.c().a(paramContext, this.b.b, this.b.d, this.b.c, this.b.b.t());
        a.a().a(this.b.b);
        a1 = new com.ss.android.downloadad.a.b.a(this.b.b, this.b.c, this.b.d);
        a1.a(2);
        a1.c(System.currentTimeMillis());
        a1.d(4);
        c.a().a(a1);
      case 4:
        return true;
      case 3:
        com.ss.android.downloadlib.d.a.a().a("deeplink_app_open", this.b);
        j.c().a((Context)a1, this.b.b, this.b.d, this.b.c, this.b.b.t());
      case 2:
        return true;
      case 1:
        break;
    } 
    com.ss.android.downloadlib.d.a.a().a("deeplink_url_open", this.b);
    j.c().a((Context)a1, this.b.b, this.b.d, this.b.c, this.b.b.t());
    return true;
  }
  
  void b() {
    if (i.b(this.b.d.a()) && this.b.b.u() != null)
      a.a().a(this.b.b.u()); 
  }
  
  void b(c paramc) {
    if (i.a(this.b.b) && !this.c) {
      byte b1;
      if (paramc != null && g.b(paramc.n())) {
        b1 = 1;
      } else {
        b1 = 2;
      } 
      com.ss.android.downloadlib.d.a.a().a("file_status", b1, this.b);
      this.c = true;
    } 
  }
  
  boolean b(boolean paramBoolean) {
    return (!paramBoolean && this.b.d.b() == 1);
  }
  
  void c() {
    if (this.e == null)
      this.e = new b(this) {
          public void a(c param1c) {
            com.ss.android.downloadlib.d.a.a().a(h.b(this.a), 2, param1c);
          }
        }; 
  }
  
  boolean c(c paramc) {
    return (e(paramc) || h());
  }
  
  void d(c paramc) {
    if (this.b.b != null && paramc != null) {
      if (paramc.g() == 0)
        return; 
      int i = paramc.q();
      if (i == -1 || i == -4) {
        com.ss.android.downloadlib.d.a.a().a(this.a, 2);
      } else if (i.a(this.b.b)) {
        com.ss.android.downloadlib.d.a.a().a(this.a, 2);
      } 
      switch (i) {
        default:
          return;
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 7:
        case 8:
          com.ss.android.downloadlib.d.a.a().b(this.a, 3);
          return;
        case -2:
          com.ss.android.downloadlib.d.a.a().b(this.a, 4);
          return;
        case -3:
          if (g.a(this.b.b)) {
            g.b();
            return;
          } 
          com.ss.android.downloadlib.d.a.a().b(this.a, 5);
          g();
          return;
        case -4:
        case -1:
          break;
      } 
      c();
      c.a().a(new com.ss.android.downloadad.a.b.a(this.b.b, this.b.c, this.b.d, paramc.g()));
    } 
  }
  
  static class a extends com.ss.android.socialbase.downloader.d.b {
    private h a;
    
    a(h param1h) {
      this.a = param1h;
    }
    
    private void a(c param1c, int param1Int) {
      Message message = Message.obtain();
      message.what = 3;
      message.obj = param1c;
      message.arg1 = param1Int;
      this.a.sendMessage(message);
    }
    
    public void a(c param1c) {
      a(param1c, 1);
    }
    
    public void a(c param1c, com.ss.android.socialbase.downloader.e.a param1a) {
      a(param1c, -1);
    }
    
    public void b(c param1c) {
      a(param1c, 2);
    }
    
    public void c(c param1c) {
      a(param1c, 4);
    }
    
    public void d(c param1c) {
      a(param1c, -2);
    }
    
    public void e(c param1c) {
      a(param1c, -3);
    }
    
    public void f(c param1c) {
      a(param1c, -4);
    }
  }
  
  public static interface b {
    void a(c param1c);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\downloadlib\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */