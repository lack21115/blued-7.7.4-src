package com.ss.android.socialbase.downloader.m;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.b.h;
import com.ss.android.socialbase.downloader.d.ab;
import com.ss.android.socialbase.downloader.d.ac;
import com.ss.android.socialbase.downloader.d.ad;
import com.ss.android.socialbase.downloader.d.af;
import com.ss.android.socialbase.downloader.d.ag;
import com.ss.android.socialbase.downloader.d.c;
import com.ss.android.socialbase.downloader.d.e;
import com.ss.android.socialbase.downloader.d.f;
import com.ss.android.socialbase.downloader.d.h;
import com.ss.android.socialbase.downloader.d.i;
import com.ss.android.socialbase.downloader.d.j;
import com.ss.android.socialbase.downloader.d.l;
import com.ss.android.socialbase.downloader.d.m;
import com.ss.android.socialbase.downloader.d.n;
import com.ss.android.socialbase.downloader.d.o;
import com.ss.android.socialbase.downloader.d.p;
import com.ss.android.socialbase.downloader.d.q;
import com.ss.android.socialbase.downloader.d.r;
import com.ss.android.socialbase.downloader.d.s;
import com.ss.android.socialbase.downloader.d.t;
import com.ss.android.socialbase.downloader.d.u;
import com.ss.android.socialbase.downloader.d.v;
import com.ss.android.socialbase.downloader.d.w;
import com.ss.android.socialbase.downloader.d.x;
import com.ss.android.socialbase.downloader.d.y;
import com.ss.android.socialbase.downloader.d.z;
import com.ss.android.socialbase.downloader.downloader.i;
import com.ss.android.socialbase.downloader.downloader.r;
import com.ss.android.socialbase.downloader.e.a;
import com.ss.android.socialbase.downloader.g.a;
import com.ss.android.socialbase.downloader.g.c;
import com.ss.android.socialbase.downloader.g.d;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class g {
  private static Handler a = new Handler(Looper.getMainLooper());
  
  public static ab a(ac paramac) {
    return (ab)((paramac == null) ? null : new ab.a(paramac) {
        public boolean a(c param1c) throws RemoteException {
          return this.a.a(param1c);
        }
        
        public boolean b(c param1c) throws RemoteException {
          return this.a.b(param1c);
        }
      });
  }
  
  public static ac a(ab paramab) {
    return (paramab == null) ? null : new ac(paramab) {
        public boolean a(c param1c) {
          try {
            return this.a.a(param1c);
          } catch (RemoteException remoteException) {
            remoteException.printStackTrace();
            return false;
          } 
        }
        
        public boolean b(c param1c) {
          try {
            return this.a.b(param1c);
          } catch (RemoteException remoteException) {
            remoteException.printStackTrace();
            return false;
          } 
        }
      };
  }
  
  public static ad a(r paramr) {
    return (ad)((paramr == null) ? null : new ad.a(paramr) {
        public long a(int param1Int1, int param1Int2) throws RemoteException {
          return this.a.a(param1Int1, param1Int2);
        }
      });
  }
  
  public static af a(ag paramag) {
    return (af)((paramag == null) ? null : new af.a(paramag) {
        public void a(int param1Int1, int param1Int2) {
          this.a.a(param1Int1, param1Int2);
        }
      });
  }
  
  public static ag a(af paramaf) {
    return (paramaf == null) ? null : new ag(paramaf) {
        public void a(int param1Int1, int param1Int2) {
          try {
            this.a.a(param1Int1, param1Int2);
            return;
          } catch (RemoteException remoteException) {
            remoteException.printStackTrace();
            return;
          } 
        }
      };
  }
  
  public static e a(i parami) {
    return (e)((parami == null) ? null : new e.a(parami) {
        public int a(long param1Long) throws RemoteException {
          return this.a.a(param1Long);
        }
      });
  }
  
  public static f a(l paraml) {
    return (f)((paraml == null) ? null : new f.a(paraml) {
        public void a(c param1c, a param1a, int param1Int) throws RemoteException {
          this.a.a(param1c, param1a, param1Int);
        }
      });
  }
  
  public static com.ss.android.socialbase.downloader.d.g a(q paramq) {
    return (com.ss.android.socialbase.downloader.d.g)((paramq == null) ? null : new com.ss.android.socialbase.downloader.d.g.a(paramq) {
        public Uri a(String param1String1, String param1String2) throws RemoteException {
          return this.a.a(param1String1, param1String2);
        }
      });
  }
  
  public static h a(v paramv) {
    return (h)((paramv == null) ? null : new h.a(paramv) {
        public boolean a() throws RemoteException {
          return this.a.a();
        }
      });
  }
  
  public static i a(w paramw, boolean paramBoolean) {
    return (i)((paramw == null) ? null : new i.a(paramw, paramBoolean) {
        public int a() throws RemoteException {
          return this.a.hashCode();
        }
        
        public void a(c param1c) throws RemoteException {
          if (this.b) {
            g.a().post(new Runnable(this, param1c) {
                  public void run() {
                    this.b.a.a(this.a);
                  }
                });
            return;
          } 
          this.a.a(param1c);
        }
        
        public void a(c param1c, a param1a) throws RemoteException {
          if (this.b) {
            g.a().post(new Runnable(this, param1c, param1a) {
                  public void run() {
                    this.c.a.a(this.a, this.b);
                  }
                });
            return;
          } 
          this.a.a(param1c, param1a);
        }
        
        public void b(c param1c) throws RemoteException {
          if (this.b) {
            g.a().post(new Runnable(this, param1c) {
                  public void run() {
                    this.b.a.b(this.a);
                  }
                });
            return;
          } 
          this.a.b(param1c);
        }
        
        public void b(c param1c, a param1a) throws RemoteException {
          if (this.b) {
            g.a().post(new Runnable(this, param1c, param1a) {
                  public void run() {
                    this.c.a.b(this.a, this.b);
                  }
                });
            return;
          } 
          this.a.b(param1c, param1a);
        }
        
        public void c(c param1c) throws RemoteException {
          if (this.b) {
            g.a().post(new Runnable(this, param1c) {
                  public void run() {
                    this.b.a.c(this.a);
                  }
                });
            return;
          } 
          this.a.c(param1c);
        }
        
        public void c(c param1c, a param1a) throws RemoteException {
          if (this.b) {
            g.a().post(new Runnable(this, param1c, param1a) {
                  public void run() {
                    this.c.a.c(this.a, this.b);
                  }
                });
            return;
          } 
          this.a.c(param1c, param1a);
        }
        
        public void d(c param1c) throws RemoteException {
          if (this.b) {
            g.a().post(new Runnable(this, param1c) {
                  public void run() {
                    this.b.a.d(this.a);
                  }
                });
            return;
          } 
          this.a.d(param1c);
        }
        
        public void e(c param1c) throws RemoteException {
          if (this.b) {
            g.a().post(new Runnable(this, param1c) {
                  public void run() {
                    this.b.a.e(this.a);
                  }
                });
            return;
          } 
          this.a.e(param1c);
        }
        
        public void f(c param1c) throws RemoteException {
          if (this.b) {
            g.a().post(new Runnable(this, param1c) {
                  public void run() {
                    this.b.a.f(this.a);
                  }
                });
            return;
          } 
          this.a.f(param1c);
        }
        
        public void g(c param1c) throws RemoteException {
          if (this.b) {
            g.a().post(new Runnable(this, param1c) {
                  public void run() {
                    this.b.a.g(this.a);
                  }
                });
            return;
          } 
          this.a.g(param1c);
        }
        
        public void h(c param1c) throws RemoteException {
          if (this.b) {
            g.a().post(new Runnable(this, param1c) {
                  public void run() {
                    this.b.a.h(this.a);
                  }
                });
            return;
          } 
          this.a.h(param1c);
        }
      });
  }
  
  public static j a(x paramx) {
    return (j)((paramx == null) ? null : new j.a(paramx) {
        public String a() throws RemoteException {
          return this.a.b();
        }
        
        public void a(String param1String) throws RemoteException {
          if (TextUtils.isEmpty(param1String))
            return; 
          try {
            JSONObject jSONObject = new JSONObject(param1String);
            this.a.a(jSONObject);
            return;
          } catch (JSONException jSONException) {
            jSONException.printStackTrace();
            return;
          } 
        }
        
        public int[] b() throws RemoteException {
          x x1 = this.a;
          return (x1 instanceof c) ? ((c)x1).a() : null;
        }
      });
  }
  
  public static l a(f paramf) {
    return (paramf == null) ? null : new l(paramf) {
        public void a(c param1c, a param1a, int param1Int) {
          if (param1c == null)
            return; 
          try {
            this.a.a(param1c, param1a, param1Int);
            return;
          } catch (RemoteException remoteException) {
            remoteException.printStackTrace();
            return;
          } 
        }
      };
  }
  
  public static m a(o paramo) {
    return (m)((paramo == null) ? null : new m.a(paramo) {
        public void a() throws RemoteException {
          this.a.a();
        }
      });
  }
  
  public static n a(p paramp) {
    return (n)((paramp == null) ? null : new n.a(paramp) {
        public boolean a(long param1Long1, long param1Long2, m param1m) throws RemoteException {
          return this.a.a(param1Long1, param1Long2, g.a(param1m));
        }
      });
  }
  
  public static o a(m paramm) {
    return (paramm == null) ? null : new o(paramm) {
        public void a() {
          try {
            this.a.a();
            return;
          } catch (RemoteException remoteException) {
            remoteException.printStackTrace();
            return;
          } 
        }
      };
  }
  
  public static p a(n paramn) {
    return (paramn == null) ? null : new p(paramn) {
        public boolean a(long param1Long1, long param1Long2, o param1o) {
          try {
            return this.a.a(param1Long1, param1Long2, g.a(param1o));
          } catch (RemoteException remoteException) {
            remoteException.printStackTrace();
            return false;
          } 
        }
      };
  }
  
  public static q a(com.ss.android.socialbase.downloader.d.g paramg) {
    return (paramg == null) ? null : new q(paramg) {
        public Uri a(String param1String1, String param1String2) {
          try {
            return this.a.a(param1String1, param1String2);
          } catch (RemoteException remoteException) {
            remoteException.printStackTrace();
            return null;
          } 
        }
      };
  }
  
  public static r a(t paramt) {
    return (r)((paramt == null) ? null : new r.a(paramt) {
        public void a(List<String> param1List) {
          this.a.a(param1List);
        }
        
        public boolean a() {
          return this.a.a();
        }
      });
  }
  
  public static s a(u paramu) {
    return (s)((paramu == null) ? null : new s.a(paramu) {
        public boolean a(r param1r) throws RemoteException {
          return this.a.a(g.a(param1r));
        }
      });
  }
  
  public static t a(r paramr) {
    return (paramr == null) ? null : new t(paramr) {
        public void a(List<String> param1List) {
          try {
            this.a.a(param1List);
            return;
          } catch (RemoteException remoteException) {
            remoteException.printStackTrace();
            return;
          } 
        }
        
        public boolean a() {
          try {
            return this.a.a();
          } catch (RemoteException remoteException) {
            remoteException.printStackTrace();
            return false;
          } 
        }
      };
  }
  
  public static u a(s params) {
    return (params == null) ? null : new u(params) {
        public boolean a(t param1t) {
          try {
            return this.a.a(g.a(param1t));
          } catch (RemoteException remoteException) {
            remoteException.printStackTrace();
            return false;
          } 
        }
      };
  }
  
  public static v a(h paramh) {
    return (paramh == null) ? null : new v(paramh) {
        public boolean a() {
          try {
            return this.a.a();
          } catch (RemoteException remoteException) {
            remoteException.printStackTrace();
            return false;
          } 
        }
      };
  }
  
  public static w a(i parami) {
    return (parami == null) ? null : new w(parami) {
        public void a(c param1c) {
          try {
            this.a.a(param1c);
            return;
          } catch (RemoteException remoteException) {
            remoteException.printStackTrace();
            return;
          } 
        }
        
        public void a(c param1c, a param1a) {
          try {
            this.a.a(param1c, param1a);
            return;
          } catch (RemoteException remoteException) {
            remoteException.printStackTrace();
            return;
          } 
        }
        
        public void b(c param1c) {
          try {
            this.a.b(param1c);
            return;
          } catch (RemoteException remoteException) {
            remoteException.printStackTrace();
            return;
          } 
        }
        
        public void b(c param1c, a param1a) {
          try {
            this.a.b(param1c, param1a);
            return;
          } catch (RemoteException remoteException) {
            remoteException.printStackTrace();
            return;
          } 
        }
        
        public void c(c param1c) {
          try {
            this.a.c(param1c);
            return;
          } catch (RemoteException remoteException) {
            remoteException.printStackTrace();
            return;
          } 
        }
        
        public void c(c param1c, a param1a) {
          try {
            this.a.c(param1c, param1a);
            return;
          } catch (RemoteException remoteException) {
            remoteException.printStackTrace();
            return;
          } 
        }
        
        public void d(c param1c) {
          try {
            this.a.d(param1c);
            return;
          } catch (RemoteException remoteException) {
            remoteException.printStackTrace();
            return;
          } 
        }
        
        public void e(c param1c) {
          try {
            this.a.e(param1c);
            return;
          } catch (RemoteException remoteException) {
            remoteException.printStackTrace();
            return;
          } 
        }
        
        public void f(c param1c) {
          try {
            this.a.f(param1c);
            return;
          } catch (RemoteException remoteException) {
            remoteException.printStackTrace();
            return;
          } 
        }
        
        public void g(c param1c) {
          try {
            this.a.g(param1c);
            return;
          } catch (RemoteException remoteException) {
            remoteException.printStackTrace();
            return;
          } 
        }
        
        public void h(c param1c) {
          try {
            this.a.h(param1c);
            return;
          } catch (RemoteException remoteException) {
            remoteException.printStackTrace();
            return;
          } 
        }
      };
  }
  
  public static x a(j paramj) {
    return (x)((paramj == null) ? null : new c(paramj) {
        public void a(JSONObject param1JSONObject) {
          if (param1JSONObject == null)
            return; 
          try {
            this.a.a(param1JSONObject.toString());
            return;
          } catch (RemoteException remoteException) {
            remoteException.printStackTrace();
            return;
          } 
        }
        
        public int[] a() {
          try {
            return this.a.b();
          } catch (RemoteException remoteException) {
            remoteException.printStackTrace();
            return null;
          } 
        }
        
        public String b() {
          try {
            return this.a.a();
          } catch (RemoteException remoteException) {
            remoteException.printStackTrace();
            return "";
          } 
        }
      });
  }
  
  public static y a(z paramz) {
    return (y)((paramz == null) ? null : new y.a(paramz) {
        public String a() throws RemoteException {
          return this.a.a();
        }
        
        public void a(int param1Int, c param1c, String param1String1, String param1String2) throws RemoteException {
          this.a.a(param1Int, param1c, param1String1, param1String2);
        }
        
        public boolean a(boolean param1Boolean) throws RemoteException {
          return this.a.a(param1Boolean);
        }
      });
  }
  
  public static z a(y paramy) {
    return (paramy == null) ? null : new z(paramy) {
        public String a() {
          try {
            return this.a.a();
          } catch (RemoteException remoteException) {
            remoteException.printStackTrace();
            return null;
          } 
        }
        
        public void a(int param1Int, c param1c, String param1String1, String param1String2) {
          try {
            this.a.a(param1Int, param1c, param1String1, param1String2);
            return;
          } catch (RemoteException remoteException) {
            remoteException.printStackTrace();
            return;
          } 
        }
        
        public boolean a(boolean param1Boolean) {
          try {
            return this.a.a(param1Boolean);
          } catch (RemoteException remoteException) {
            remoteException.printStackTrace();
            return false;
          } 
        }
      };
  }
  
  public static i a(e parame) {
    return (parame == null) ? null : new i(parame) {
        public int a(long param1Long) {
          try {
            return this.a.a(param1Long);
          } catch (RemoteException remoteException) {
            remoteException.printStackTrace();
            return 0;
          } 
        }
      };
  }
  
  public static r a(ad paramad) {
    return (paramad == null) ? null : new r(paramad) {
        public long a(int param1Int1, int param1Int2) {
          try {
            return this.a.a(param1Int1, param1Int2);
          } catch (RemoteException remoteException) {
            remoteException.printStackTrace();
            return 0L;
          } 
        }
      };
  }
  
  public static a a(d paramd) {
    return (a)((paramd == null) ? null : new a.a(paramd) {
        public int a(int param1Int) throws RemoteException {
          return this.a.b(f.c(param1Int));
        }
        
        public i a(int param1Int1, int param1Int2) throws RemoteException {
          boolean bool;
          w w = this.a.a(f.c(param1Int1), param1Int2);
          if (param1Int1 == h.b.ordinal()) {
            bool = false;
          } else {
            bool = true;
          } 
          return g.a(w, bool);
        }
        
        public c a() throws RemoteException {
          return this.a.a();
        }
        
        public e b() throws RemoteException {
          return g.a(this.a.f());
        }
        
        public i b(int param1Int) throws RemoteException {
          boolean bool;
          w w = this.a.c(f.c(param1Int));
          if (param1Int == h.b.ordinal()) {
            bool = false;
          } else {
            bool = true;
          } 
          return g.a(w, bool);
        }
        
        public y c() throws RemoteException {
          return g.a(this.a.j());
        }
        
        public ab d() throws RemoteException {
          return g.a(this.a.k());
        }
        
        public h e() throws RemoteException {
          return g.a(this.a.c());
        }
        
        public f f() throws RemoteException {
          return g.a(this.a.d());
        }
        
        public s g() throws RemoteException {
          return g.a(this.a.h());
        }
        
        public ad h() throws RemoteException {
          return g.a(this.a.g());
        }
        
        public n i() throws RemoteException {
          return g.a(this.a.i());
        }
        
        public j j() throws RemoteException {
          return g.a(this.a.e());
        }
        
        public com.ss.android.socialbase.downloader.d.g k() throws RemoteException {
          return g.a(this.a.l());
        }
      });
  }
  
  public static d a(a parama) {
    if (parama == null)
      return null; 
    try {
      d d = new d(parama.a());
      d.a(a(parama.b())).a(a(parama.c())).a(a(parama.e())).a(a(parama.f())).a(a(parama.j())).a(a(parama.g())).a(a(parama.i())).a(a(parama.k())).a(a(parama.d())).a(a(parama.h()));
      i i = parama.b(h.a.ordinal());
      if (i != null)
        d.a(i.hashCode(), a(i)); 
      i = parama.b(h.b.ordinal());
      if (i != null)
        d.b(i.hashCode(), a(i)); 
      i = parama.b(h.c.ordinal());
      if (i != null)
        d.c(i.hashCode(), a(i)); 
      a(d, parama, h.a);
      a(d, parama, h.b);
      a(d, parama, h.c);
      return d;
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
      return null;
    } 
  }
  
  private static void a(d paramd, a parama, h paramh) throws RemoteException {
    SparseArray sparseArray = new SparseArray();
    for (int i = 0; i < parama.a(paramh.ordinal()); i++) {
      i i1 = parama.a(paramh.ordinal(), i);
      if (i1 != null)
        sparseArray.put(i1.a(), a(i1)); 
    } 
    paramd.a(sparseArray, paramh);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\m\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */