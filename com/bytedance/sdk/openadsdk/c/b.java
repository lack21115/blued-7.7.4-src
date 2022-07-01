package com.bytedance.sdk.openadsdk.c;

import android.os.Handler;
import android.os.Message;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.f.b.c;
import java.util.concurrent.atomic.AtomicBoolean;

public class b<T extends i> {
  private g<T> a;
  
  private Handler b;
  
  private AtomicBoolean c;
  
  b() {}
  
  public b(e<T> parame, p<T> paramp, g.b paramb, g.a parama) {
    this.a = new g<T>(parame, paramp, paramb, parama);
    this.c = new AtomicBoolean(false);
  }
  
  public b(e<T> parame, p<T> paramp, g.b paramb, g.a parama, g<T> paramg) {
    this.a = paramg;
    this.c = new AtomicBoolean(false);
  }
  
  public static a c() {
    return a.e();
  }
  
  public static b d() {
    return b.e();
  }
  
  public void a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield c : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   6: ifnull -> 19
    //   9: aload_0
    //   10: getfield c : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   13: invokevirtual get : ()Z
    //   16: ifne -> 31
    //   19: aload_0
    //   20: getfield a : Lcom/bytedance/sdk/openadsdk/c/g;
    //   23: invokevirtual getLooper : ()Landroid/os/Looper;
    //   26: astore_1
    //   27: aload_1
    //   28: ifnull -> 34
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: aload_0
    //   35: getfield c : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   38: ifnull -> 110
    //   41: aload_0
    //   42: getfield c : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   45: invokevirtual get : ()Z
    //   48: ifne -> 110
    //   51: aload_0
    //   52: getfield a : Lcom/bytedance/sdk/openadsdk/c/g;
    //   55: invokevirtual start : ()V
    //   58: aload_0
    //   59: new android/os/Handler
    //   62: dup
    //   63: aload_0
    //   64: getfield a : Lcom/bytedance/sdk/openadsdk/c/g;
    //   67: invokevirtual getLooper : ()Landroid/os/Looper;
    //   70: aload_0
    //   71: getfield a : Lcom/bytedance/sdk/openadsdk/c/g;
    //   74: invokespecial <init> : (Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   77: putfield b : Landroid/os/Handler;
    //   80: aload_0
    //   81: getfield b : Landroid/os/Handler;
    //   84: invokevirtual obtainMessage : ()Landroid/os/Message;
    //   87: astore_1
    //   88: aload_1
    //   89: iconst_5
    //   90: putfield what : I
    //   93: aload_0
    //   94: getfield b : Landroid/os/Handler;
    //   97: aload_1
    //   98: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   101: pop
    //   102: aload_0
    //   103: getfield c : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   106: iconst_1
    //   107: invokevirtual set : (Z)V
    //   110: aload_0
    //   111: monitorexit
    //   112: return
    //   113: astore_1
    //   114: aload_0
    //   115: monitorexit
    //   116: aload_1
    //   117: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	113	finally
    //   19	27	113	finally
    //   34	110	113	finally
  }
  
  public void a(T paramT) {
    if (!this.c.get())
      return; 
    Message message = this.b.obtainMessage();
    message.what = 1;
    message.obj = paramT;
    this.b.sendMessage(message);
  }
  
  public void b() {
    this.c.set(false);
    this.a.quit();
    this.b.removeCallbacksAndMessages(null);
  }
  
  public static class a extends b<a> {
    private static volatile a a;
    
    public static a e() {
      // Byte code:
      //   0: getstatic com/bytedance/sdk/openadsdk/c/b$a.a : Lcom/bytedance/sdk/openadsdk/c/b$a;
      //   3: ifnonnull -> 37
      //   6: ldc com/bytedance/sdk/openadsdk/c/b$a
      //   8: monitorenter
      //   9: getstatic com/bytedance/sdk/openadsdk/c/b$a.a : Lcom/bytedance/sdk/openadsdk/c/b$a;
      //   12: ifnonnull -> 25
      //   15: new com/bytedance/sdk/openadsdk/c/b$a
      //   18: dup
      //   19: invokespecial <init> : ()V
      //   22: putstatic com/bytedance/sdk/openadsdk/c/b$a.a : Lcom/bytedance/sdk/openadsdk/c/b$a;
      //   25: ldc com/bytedance/sdk/openadsdk/c/b$a
      //   27: monitorexit
      //   28: goto -> 37
      //   31: astore_0
      //   32: ldc com/bytedance/sdk/openadsdk/c/b$a
      //   34: monitorexit
      //   35: aload_0
      //   36: athrow
      //   37: getstatic com/bytedance/sdk/openadsdk/c/b$a.a : Lcom/bytedance/sdk/openadsdk/c/b$a;
      //   40: areturn
      // Exception table:
      //   from	to	target	type
      //   9	25	31	finally
      //   25	28	31	finally
      //   32	35	31	finally
    }
    
    public void a() {
      /* monitor enter ThisExpression{InnerObjectType{ObjectType{com/bytedance/sdk/openadsdk/c/b}.Lcom/bytedance/sdk/openadsdk/c/b$a;}} */
      /* monitor exit ThisExpression{InnerObjectType{ObjectType{com/bytedance/sdk/openadsdk/c/b}.Lcom/bytedance/sdk/openadsdk/c/b$a;}} */
    }
    
    public void a(a param1a) {}
    
    public void b() {}
  }
  
  public static class b extends b<c.a> {
    private static volatile b a;
    
    public static b e() {
      // Byte code:
      //   0: getstatic com/bytedance/sdk/openadsdk/c/b$b.a : Lcom/bytedance/sdk/openadsdk/c/b$b;
      //   3: ifnonnull -> 37
      //   6: ldc com/bytedance/sdk/openadsdk/c/b$b
      //   8: monitorenter
      //   9: getstatic com/bytedance/sdk/openadsdk/c/b$b.a : Lcom/bytedance/sdk/openadsdk/c/b$b;
      //   12: ifnonnull -> 25
      //   15: new com/bytedance/sdk/openadsdk/c/b$b
      //   18: dup
      //   19: invokespecial <init> : ()V
      //   22: putstatic com/bytedance/sdk/openadsdk/c/b$b.a : Lcom/bytedance/sdk/openadsdk/c/b$b;
      //   25: ldc com/bytedance/sdk/openadsdk/c/b$b
      //   27: monitorexit
      //   28: goto -> 37
      //   31: astore_0
      //   32: ldc com/bytedance/sdk/openadsdk/c/b$b
      //   34: monitorexit
      //   35: aload_0
      //   36: athrow
      //   37: getstatic com/bytedance/sdk/openadsdk/c/b$b.a : Lcom/bytedance/sdk/openadsdk/c/b$b;
      //   40: areturn
      // Exception table:
      //   from	to	target	type
      //   9	25	31	finally
      //   25	28	31	finally
      //   32	35	31	finally
    }
    
    public void a() {
      /* monitor enter ThisExpression{InnerObjectType{ObjectType{com/bytedance/sdk/openadsdk/c/b}.Lcom/bytedance/sdk/openadsdk/c/b$b;}} */
      /* monitor exit ThisExpression{InnerObjectType{ObjectType{com/bytedance/sdk/openadsdk/c/b}.Lcom/bytedance/sdk/openadsdk/c/b$b;}} */
    }
    
    public void a(c.a param1a) {}
    
    public void b() {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */