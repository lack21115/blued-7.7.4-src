package com.geetest.onelogin.j;

import java.util.HashMap;
import java.util.Map;

public class p {
  private static volatile p a;
  
  private Map<String, a> b = new HashMap<String, a>();
  
  private boolean c = false;
  
  public static p a() {
    // Byte code:
    //   0: getstatic com/geetest/onelogin/j/p.a : Lcom/geetest/onelogin/j/p;
    //   3: ifnonnull -> 37
    //   6: ldc com/geetest/onelogin/j/p
    //   8: monitorenter
    //   9: getstatic com/geetest/onelogin/j/p.a : Lcom/geetest/onelogin/j/p;
    //   12: ifnonnull -> 25
    //   15: new com/geetest/onelogin/j/p
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/geetest/onelogin/j/p.a : Lcom/geetest/onelogin/j/p;
    //   25: ldc com/geetest/onelogin/j/p
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/geetest/onelogin/j/p
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/geetest/onelogin/j/p.a : Lcom/geetest/onelogin/j/p;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public void a(String paramString) {
    if (this.c)
      this.b.put(paramString, new a(this, System.currentTimeMillis())); 
  }
  
  public void a(boolean paramBoolean) {
    this.c = paramBoolean;
  }
  
  public void b(String paramString) {
    if (this.c && this.b.containsKey(paramString)) {
      a a = this.b.get(paramString);
      a.b = System.currentTimeMillis();
      long l = a.a();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Method: ");
      stringBuilder.append(paramString);
      stringBuilder.append(" timeElapsed=");
      stringBuilder.append(l);
      stringBuilder.append("ms");
      h.a(stringBuilder.toString());
      this.b.remove(a);
    } 
  }
  
  class a {
    long a;
    
    long b;
    
    public a(p this$0, long param1Long) {
      this.a = param1Long;
    }
    
    long a() {
      return this.b - this.a;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\j\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */