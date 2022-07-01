package com.pgl.a.a;

public class a {
  public static int a = 255;
  
  public static String a() {
    int i = a;
    return (i != 0) ? ((i != 2) ? ((i != 3) ? "" : "https://bds-va.byteoversea.com") : "https://bds-sg.byteoversea.com") : "https://bds.snssdk.com";
  }
  
  public static void a(int paramInt) {
    // Byte code:
    //   0: ldc com/pgl/a/a/a
    //   2: monitorenter
    //   3: iload_0
    //   4: putstatic com/pgl/a/a/a.a : I
    //   7: ldc com/pgl/a/a/a
    //   9: monitorexit
    //   10: return
    //   11: astore_1
    //   12: ldc com/pgl/a/a/a
    //   14: monitorexit
    //   15: aload_1
    //   16: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	11	finally
  }
  
  public static String b() {
    int i = a;
    return (i != 0) ? ((i != 2) ? ((i != 3) ? "" : "https://sdfp-va.byteoversea.com") : "https://sdfp-sg.byteoversea.com") : "https://sdfp.snssdk.com";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\pgl\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */