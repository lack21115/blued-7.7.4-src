package com.soft.blued.ui.find.manager;

public class MapFindManager {
  private static MapFindManager a;
  
  private MapFindBean b;
  
  public static MapFindManager a() {
    // Byte code:
    //   0: getstatic com/soft/blued/ui/find/manager/MapFindManager.a : Lcom/soft/blued/ui/find/manager/MapFindManager;
    //   3: ifnonnull -> 37
    //   6: ldc com/soft/blued/ui/find/manager/MapFindManager
    //   8: monitorenter
    //   9: getstatic com/soft/blued/ui/find/manager/MapFindManager.a : Lcom/soft/blued/ui/find/manager/MapFindManager;
    //   12: ifnonnull -> 25
    //   15: new com/soft/blued/ui/find/manager/MapFindManager
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/soft/blued/ui/find/manager/MapFindManager.a : Lcom/soft/blued/ui/find/manager/MapFindManager;
    //   25: ldc com/soft/blued/ui/find/manager/MapFindManager
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/soft/blued/ui/find/manager/MapFindManager
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/soft/blued/ui/find/manager/MapFindManager.a : Lcom/soft/blued/ui/find/manager/MapFindManager;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public void a(MapFindBean paramMapFindBean) {
    this.b = paramMapFindBean;
  }
  
  public boolean b() {
    return (this.b != null);
  }
  
  public MapFindBean c() {
    return this.b;
  }
  
  public static class MapFindBean {
    public String a;
    
    public String b;
    
    public double c;
    
    public String d;
    
    public String e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\manager\MapFindManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */