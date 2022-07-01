package com.bytedance.sdk.a.b.a.d;

import com.bytedance.sdk.a.a.i;
import com.bytedance.sdk.a.a.l;
import com.bytedance.sdk.a.a.r;
import com.bytedance.sdk.a.a.s;
import com.bytedance.sdk.a.a.t;
import com.bytedance.sdk.a.b.a.b.g;
import com.bytedance.sdk.a.b.a.c.c;
import com.bytedance.sdk.a.b.a.c.h;
import com.bytedance.sdk.a.b.a.c.i;
import com.bytedance.sdk.a.b.a.c.k;
import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.ab;
import com.bytedance.sdk.a.b.r;
import com.bytedance.sdk.a.b.s;
import com.bytedance.sdk.a.b.v;
import com.bytedance.sdk.a.b.y;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

public final class a implements c {
  final v a;
  
  final g b;
  
  final com.bytedance.sdk.a.a.e c;
  
  final com.bytedance.sdk.a.a.d d;
  
  int e = 0;
  
  private long f = 262144L;
  
  public a(v paramv, g paramg, com.bytedance.sdk.a.a.e parame, com.bytedance.sdk.a.a.d paramd) {
    this.a = paramv;
    this.b = paramg;
    this.c = parame;
    this.d = paramd;
  }
  
  private String f() throws IOException {
    String str = this.c.e(this.f);
    this.f -= str.length();
    return str;
  }
  
  public r a(long paramLong) {
    if (this.e == 1) {
      this.e = 2;
      return new d(this, paramLong);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("state: ");
    stringBuilder.append(this.e);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public r a(y paramy, long paramLong) {
    if ("chunked".equalsIgnoreCase(paramy.a("Transfer-Encoding")))
      return d(); 
    if (paramLong != -1L)
      return a(paramLong); 
    throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
  }
  
  public s a(s params) throws IOException {
    if (this.e == 4) {
      this.e = 5;
      return new c(this, params);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("state: ");
    stringBuilder.append(this.e);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public aa.a a(boolean paramBoolean) throws IOException {
    int i = this.e;
    if (i == 1 || i == 3)
      try {
        k k = k.a(f());
        aa.a a1 = (new aa.a()).a(k.a).a(k.b).a(k.c).a(c());
        if (paramBoolean && k.b == 100)
          return null; 
        this.e = 4;
        return a1;
      } catch (EOFException eOFException) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("unexpected end of stream on ");
        stringBuilder1.append(this.b);
        IOException iOException = new IOException(stringBuilder1.toString());
        iOException.initCause(eOFException);
        throw iOException;
      }  
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("state: ");
    stringBuilder.append(this.e);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public ab a(aa paramaa) throws IOException {
    this.b.c.f(this.b.b);
    String str = paramaa.a("Content-Type");
    if (!com.bytedance.sdk.a.b.a.c.e.b(paramaa))
      return (ab)new h(str, 0L, l.a(b(0L))); 
    if ("chunked".equalsIgnoreCase(paramaa.a("Transfer-Encoding")))
      return (ab)new h(str, -1L, l.a(a(paramaa.a().a()))); 
    long l = com.bytedance.sdk.a.b.a.c.e.a(paramaa);
    return (ab)((l != -1L) ? new h(str, l, l.a(b(l))) : new h(str, -1L, l.a(e())));
  }
  
  public void a() throws IOException {
    this.d.flush();
  }
  
  void a(i parami) {
    t t = parami.a();
    parami.a(t.c);
    t.f();
    t.e();
  }
  
  public void a(r paramr, String paramString) throws IOException {
    if (this.e == 0) {
      this.d.b(paramString).b("\r\n");
      int i = 0;
      int j = paramr.a();
      while (i < j) {
        this.d.b(paramr.a(i)).b(": ").b(paramr.b(i)).b("\r\n");
        i++;
      } 
      this.d.b("\r\n");
      this.e = 1;
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("state: ");
    stringBuilder.append(this.e);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public void a(y paramy) throws IOException {
    String str = i.a(paramy, this.b.b().a().b().type());
    a(paramy.c(), str);
  }
  
  public s b(long paramLong) throws IOException {
    if (this.e == 4) {
      this.e = 5;
      return new e(this, paramLong);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("state: ");
    stringBuilder.append(this.e);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public void b() throws IOException {
    this.d.flush();
  }
  
  public r c() throws IOException {
    r.a a1 = new r.a();
    while (true) {
      String str = f();
      if (str.length() != 0) {
        com.bytedance.sdk.a.b.a.a.a.a(a1, str);
        continue;
      } 
      return a1.a();
    } 
  }
  
  public r d() {
    if (this.e == 1) {
      this.e = 2;
      return new b(this);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("state: ");
    stringBuilder.append(this.e);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public s e() throws IOException {
    if (this.e == 4) {
      g g1 = this.b;
      if (g1 != null) {
        this.e = 5;
        g1.d();
        return new f(this);
      } 
      throw new IllegalStateException("streamAllocation == null");
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("state: ");
    stringBuilder.append(this.e);
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  abstract class a implements s {
    protected final i a = new i(this.d.c.a());
    
    protected boolean b;
    
    protected long c = 0L;
    
    private a(a this$0) {}
    
    public long a(com.bytedance.sdk.a.a.c param1c, long param1Long) throws IOException {
      try {
        param1Long = this.d.c.a(param1c, param1Long);
        if (param1Long > 0L)
          this.c += param1Long; 
        return param1Long;
      } catch (IOException iOException) {
        a(false, iOException);
        throw iOException;
      } 
    }
    
    public t a() {
      return (t)this.a;
    }
    
    protected final void a(boolean param1Boolean, IOException param1IOException) throws IOException {
      if (this.d.e == 6)
        return; 
      if (this.d.e == 5) {
        this.d.a(this.a);
        a a1 = this.d;
        a1.e = 6;
        if (a1.b != null)
          this.d.b.a(param1Boolean ^ true, this.d, this.c, param1IOException); 
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("state: ");
      stringBuilder.append(this.d.e);
      throw new IllegalStateException(stringBuilder.toString());
    }
  }
  
  final class b implements r {
    private final i b = new i(this.a.d.a());
    
    private boolean c;
    
    b(a this$0) {}
    
    public t a() {
      return (t)this.b;
    }
    
    public void a_(com.bytedance.sdk.a.a.c param1c, long param1Long) throws IOException {
      if (!this.c) {
        if (param1Long == 0L)
          return; 
        this.a.d.k(param1Long);
        this.a.d.b("\r\n");
        this.a.d.a_(param1c, param1Long);
        this.a.d.b("\r\n");
        return;
      } 
      throw new IllegalStateException("closed");
    }
    
    public void close() throws IOException {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield c : Z
      //   6: istore_1
      //   7: iload_1
      //   8: ifeq -> 14
      //   11: aload_0
      //   12: monitorexit
      //   13: return
      //   14: aload_0
      //   15: iconst_1
      //   16: putfield c : Z
      //   19: aload_0
      //   20: getfield a : Lcom/bytedance/sdk/a/b/a/d/a;
      //   23: getfield d : Lcom/bytedance/sdk/a/a/d;
      //   26: ldc '0\\r\\n\\r\\n'
      //   28: invokeinterface b : (Ljava/lang/String;)Lcom/bytedance/sdk/a/a/d;
      //   33: pop
      //   34: aload_0
      //   35: getfield a : Lcom/bytedance/sdk/a/b/a/d/a;
      //   38: aload_0
      //   39: getfield b : Lcom/bytedance/sdk/a/a/i;
      //   42: invokevirtual a : (Lcom/bytedance/sdk/a/a/i;)V
      //   45: aload_0
      //   46: getfield a : Lcom/bytedance/sdk/a/b/a/d/a;
      //   49: iconst_3
      //   50: putfield e : I
      //   53: aload_0
      //   54: monitorexit
      //   55: return
      //   56: astore_2
      //   57: aload_0
      //   58: monitorexit
      //   59: aload_2
      //   60: athrow
      // Exception table:
      //   from	to	target	type
      //   2	7	56	finally
      //   14	53	56	finally
    }
    
    public void flush() throws IOException {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield c : Z
      //   6: istore_1
      //   7: iload_1
      //   8: ifeq -> 14
      //   11: aload_0
      //   12: monitorexit
      //   13: return
      //   14: aload_0
      //   15: getfield a : Lcom/bytedance/sdk/a/b/a/d/a;
      //   18: getfield d : Lcom/bytedance/sdk/a/a/d;
      //   21: invokeinterface flush : ()V
      //   26: aload_0
      //   27: monitorexit
      //   28: return
      //   29: astore_2
      //   30: aload_0
      //   31: monitorexit
      //   32: aload_2
      //   33: athrow
      // Exception table:
      //   from	to	target	type
      //   2	7	29	finally
      //   14	26	29	finally
    }
  }
  
  class c extends a {
    private final s f;
    
    private long g = -1L;
    
    private boolean h = true;
    
    c(a this$0, s param1s) {
      super(this$0);
      this.f = param1s;
    }
    
    private void b() throws IOException {
      if (this.g != -1L)
        this.e.c.p(); 
      try {
        this.g = this.e.c.m();
        String str = this.e.c.p().trim();
        if (this.g >= 0L) {
          if (!str.isEmpty()) {
            boolean bool = str.startsWith(";");
            if (bool) {
              if (this.g == 0L) {
                this.h = false;
                com.bytedance.sdk.a.b.a.c.e.a(this.e.a.f(), this.f, this.e.c());
                a(true, (IOException)null);
              } 
              return;
            } 
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("expected chunk size and optional extensions but was \"");
            stringBuilder.append(this.g);
            stringBuilder.append(str);
            stringBuilder.append("\"");
            throw new ProtocolException(stringBuilder.toString());
          } 
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("expected chunk size and optional extensions but was \"");
          stringBuilder.append(this.g);
          stringBuilder.append(str);
          stringBuilder.append("\"");
          throw new ProtocolException(stringBuilder.toString());
        } 
        if (this.g == 0L) {
          this.h = false;
          com.bytedance.sdk.a.b.a.c.e.a(this.e.a.f(), this.f, this.e.c());
          a(true, (IOException)null);
        } 
        return;
      } catch (NumberFormatException numberFormatException) {
        throw new ProtocolException(numberFormatException.getMessage());
      } 
    }
    
    public long a(com.bytedance.sdk.a.a.c param1c, long param1Long) throws IOException {
      if (param1Long >= 0L) {
        if (!this.b) {
          if (!this.h)
            return -1L; 
          long l = this.g;
          if (l == 0L || l == -1L) {
            b();
            if (!this.h)
              return -1L; 
          } 
          param1Long = super.a(param1c, Math.min(param1Long, this.g));
          if (param1Long != -1L) {
            this.g -= param1Long;
            return param1Long;
          } 
          ProtocolException protocolException = new ProtocolException("unexpected end of stream");
          a(false, protocolException);
          throw protocolException;
        } 
        throw new IllegalStateException("closed");
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("byteCount < 0: ");
      stringBuilder.append(param1Long);
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    public void close() throws IOException {
      if (this.b)
        return; 
      if (this.h && !com.bytedance.sdk.a.b.a.c.a(this, 100, TimeUnit.MILLISECONDS))
        a(false, (IOException)null); 
      this.b = true;
    }
  }
  
  final class d implements r {
    private final i b = new i(this.a.d.a());
    
    private boolean c;
    
    private long d;
    
    d(a this$0, long param1Long) {
      this.d = param1Long;
    }
    
    public t a() {
      return (t)this.b;
    }
    
    public void a_(com.bytedance.sdk.a.a.c param1c, long param1Long) throws IOException {
      if (!this.c) {
        com.bytedance.sdk.a.b.a.c.a(param1c.b(), 0L, param1Long);
        if (param1Long <= this.d) {
          this.a.d.a_(param1c, param1Long);
          this.d -= param1Long;
          return;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("expected ");
        stringBuilder.append(this.d);
        stringBuilder.append(" bytes but received ");
        stringBuilder.append(param1Long);
        throw new ProtocolException(stringBuilder.toString());
      } 
      throw new IllegalStateException("closed");
    }
    
    public void close() throws IOException {
      if (this.c)
        return; 
      this.c = true;
      if (this.d <= 0L) {
        this.a.a(this.b);
        this.a.e = 3;
        return;
      } 
      throw new ProtocolException("unexpected end of stream");
    }
    
    public void flush() throws IOException {
      if (this.c)
        return; 
      this.a.d.flush();
    }
  }
  
  class e extends a {
    private long f;
    
    e(a this$0, long param1Long) throws IOException {
      super(this$0);
      this.f = param1Long;
      if (this.f == 0L)
        a(true, (IOException)null); 
    }
    
    public long a(com.bytedance.sdk.a.a.c param1c, long param1Long) throws IOException {
      if (param1Long >= 0L) {
        if (!this.b) {
          long l = this.f;
          if (l == 0L)
            return -1L; 
          param1Long = super.a(param1c, Math.min(l, param1Long));
          if (param1Long != -1L) {
            this.f -= param1Long;
            if (this.f == 0L)
              a(true, (IOException)null); 
            return param1Long;
          } 
          ProtocolException protocolException = new ProtocolException("unexpected end of stream");
          a(false, protocolException);
          throw protocolException;
        } 
        throw new IllegalStateException("closed");
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("byteCount < 0: ");
      stringBuilder.append(param1Long);
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    public void close() throws IOException {
      if (this.b)
        return; 
      if (this.f != 0L && !com.bytedance.sdk.a.b.a.c.a(this, 100, TimeUnit.MILLISECONDS))
        a(false, (IOException)null); 
      this.b = true;
    }
  }
  
  class f extends a {
    private boolean f;
    
    f(a this$0) {
      super(this$0);
    }
    
    public long a(com.bytedance.sdk.a.a.c param1c, long param1Long) throws IOException {
      if (param1Long >= 0L) {
        if (!this.b) {
          if (this.f)
            return -1L; 
          param1Long = super.a(param1c, param1Long);
          if (param1Long == -1L) {
            this.f = true;
            a(true, (IOException)null);
            return -1L;
          } 
          return param1Long;
        } 
        throw new IllegalStateException("closed");
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("byteCount < 0: ");
      stringBuilder.append(param1Long);
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    public void close() throws IOException {
      if (this.b)
        return; 
      if (!this.f)
        a(false, (IOException)null); 
      this.b = true;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\a\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */