package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.b.a.a.a;
import com.bytedance.sdk.a.b.a.b;
import com.bytedance.sdk.a.b.a.b.a;
import com.bytedance.sdk.a.b.a.c.a;
import com.bytedance.sdk.a.b.a.c.b;
import com.bytedance.sdk.a.b.a.c.g;
import com.bytedance.sdk.a.b.a.c.j;
import com.bytedance.sdk.a.b.a.g.e;
import java.io.IOException;
import java.util.ArrayList;

final class x implements e {
  final v a;
  
  final j b;
  
  final y c;
  
  final boolean d;
  
  private p e;
  
  private boolean f;
  
  private x(v paramv, y paramy, boolean paramBoolean) {
    this.a = paramv;
    this.c = paramy;
    this.d = paramBoolean;
    this.b = new j(paramv, paramBoolean);
  }
  
  static x a(v paramv, y paramy, boolean paramBoolean) {
    x x1 = new x(paramv, paramy, paramBoolean);
    x1.e = paramv.x().a(x1);
    return x1;
  }
  
  private void g() {
    Object object = e.b().a("response.body().close()");
    this.b.a(object);
  }
  
  public aa a() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield f : Z
    //   6: ifne -> 100
    //   9: aload_0
    //   10: iconst_1
    //   11: putfield f : Z
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_0
    //   17: invokespecial g : ()V
    //   20: aload_0
    //   21: getfield e : Lcom/bytedance/sdk/a/b/p;
    //   24: aload_0
    //   25: invokevirtual a : (Lcom/bytedance/sdk/a/b/e;)V
    //   28: aload_0
    //   29: getfield a : Lcom/bytedance/sdk/a/b/v;
    //   32: invokevirtual s : ()Lcom/bytedance/sdk/a/b/n;
    //   35: aload_0
    //   36: invokevirtual a : (Lcom/bytedance/sdk/a/b/x;)V
    //   39: aload_0
    //   40: invokevirtual f : ()Lcom/bytedance/sdk/a/b/aa;
    //   43: astore_1
    //   44: aload_1
    //   45: ifnull -> 61
    //   48: aload_0
    //   49: getfield a : Lcom/bytedance/sdk/a/b/v;
    //   52: invokevirtual s : ()Lcom/bytedance/sdk/a/b/n;
    //   55: aload_0
    //   56: invokevirtual b : (Lcom/bytedance/sdk/a/b/x;)V
    //   59: aload_1
    //   60: areturn
    //   61: new java/io/IOException
    //   64: dup
    //   65: ldc 'Canceled'
    //   67: invokespecial <init> : (Ljava/lang/String;)V
    //   70: athrow
    //   71: astore_1
    //   72: goto -> 87
    //   75: astore_1
    //   76: aload_0
    //   77: getfield e : Lcom/bytedance/sdk/a/b/p;
    //   80: aload_0
    //   81: aload_1
    //   82: invokevirtual a : (Lcom/bytedance/sdk/a/b/e;Ljava/io/IOException;)V
    //   85: aload_1
    //   86: athrow
    //   87: aload_0
    //   88: getfield a : Lcom/bytedance/sdk/a/b/v;
    //   91: invokevirtual s : ()Lcom/bytedance/sdk/a/b/n;
    //   94: aload_0
    //   95: invokevirtual b : (Lcom/bytedance/sdk/a/b/x;)V
    //   98: aload_1
    //   99: athrow
    //   100: new java/lang/IllegalStateException
    //   103: dup
    //   104: ldc 'Already Executed'
    //   106: invokespecial <init> : (Ljava/lang/String;)V
    //   109: athrow
    //   110: astore_1
    //   111: aload_0
    //   112: monitorexit
    //   113: aload_1
    //   114: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	110	finally
    //   28	44	75	java/io/IOException
    //   28	44	71	finally
    //   61	71	75	java/io/IOException
    //   61	71	71	finally
    //   76	87	71	finally
    //   100	110	110	finally
    //   111	113	110	finally
  }
  
  public boolean b() {
    return this.b.a();
  }
  
  public x c() {
    return a(this.a, this.c, this.d);
  }
  
  String d() {
    String str;
    StringBuilder stringBuilder = new StringBuilder();
    if (b()) {
      str = "canceled ";
    } else {
      str = "";
    } 
    stringBuilder.append(str);
    if (this.d) {
      str = "web socket";
    } else {
      str = "call";
    } 
    stringBuilder.append(str);
    stringBuilder.append(" to ");
    stringBuilder.append(e());
    return stringBuilder.toString();
  }
  
  String e() {
    return this.c.a().m();
  }
  
  aa f() throws IOException {
    ArrayList<t> arrayList = new ArrayList<t>(this.a.v());
    arrayList.add(this.b);
    arrayList.add(new a(this.a.f()));
    arrayList.add(new a(this.a.g()));
    arrayList.add(new a(this.a));
    if (!this.d)
      arrayList.addAll(this.a.w()); 
    arrayList.add(new b(this.d));
    return (new g(arrayList, null, null, null, 0, this.c, this, this.e, this.a.a(), this.a.b(), this.a.c())).a(this.c);
  }
  
  final class a extends b {
    private final f c;
    
    public void a() {
      Exception exception;
      boolean bool = true;
      try {
        aa aa = this.b.f();
        boolean bool1 = this.b.b.a();
        if (bool1) {
          try {
            this.c.a(this.b, new IOException("Canceled"));
            this.b.a.s().a(this);
          } catch (IOException null) {}
        } else {
          this.c.a(this.b, (aa)exception);
          this.b.a.s().a(this);
        } 
      } catch (IOException null) {
        bool = false;
      } finally {}
      if (bool) {
        e e = e.b();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Callback failure for ");
        stringBuilder.append(this.b.d());
        e.a(4, stringBuilder.toString(), exception);
      } else {
        x.a(this.b).a(this.b, (IOException)exception);
        this.c.a(this.b, (IOException)exception);
      } 
      this.b.a.s().a(this);
    }
    
    String b() {
      return this.b.c.a().f();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */