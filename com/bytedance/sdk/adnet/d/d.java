package com.bytedance.sdk.adnet.d;

public class d {
  private a a = a.d;
  
  private b b = new a();
  
  private d() {}
  
  public static void a(a parama) {
    // Byte code:
    //   0: ldc com/bytedance/sdk/adnet/d/d
    //   2: monitorenter
    //   3: invokestatic a : ()Lcom/bytedance/sdk/adnet/d/d;
    //   6: aload_0
    //   7: putfield a : Lcom/bytedance/sdk/adnet/d/d$a;
    //   10: ldc com/bytedance/sdk/adnet/d/d
    //   12: monitorexit
    //   13: return
    //   14: astore_0
    //   15: ldc com/bytedance/sdk/adnet/d/d
    //   17: monitorexit
    //   18: aload_0
    //   19: athrow
    // Exception table:
    //   from	to	target	type
    //   3	13	14	finally
    //   15	18	14	finally
  }
  
  public static void a(String paramString1, String paramString2) {
    if ((c.a()).a.compareTo(a.c) <= 0)
      (c.a()).b.a(paramString1, paramString2); 
  }
  
  public static void b(String paramString1, String paramString2) {
    if ((c.a()).a.compareTo(a.a) <= 0)
      (c.a()).b.b(paramString1, paramString2); 
  }
  
  public enum a {
    a, b, c, d;
  }
  
  public static interface b {
    void a(String param1String1, String param1String2);
    
    void b(String param1String1, String param1String2);
  }
  
  static class c {
    private static final d a = new d();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\adnet\d\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */