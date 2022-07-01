package com.blued.android.core.imagecache.drawable;

public interface IRecyclingDrawable {
  void a(String paramString);
  
  void a(boolean paramBoolean);
  
  boolean a();
  
  String b();
  
  void b(boolean paramBoolean);
  
  boolean c();
  
  void d();
  
  int e();
  
  public static class CountRef {
    private IRecyclingDrawable a = null;
    
    private int b = 0;
    
    private int c = 0;
    
    private boolean d;
    
    CountRef(IRecyclingDrawable param1IRecyclingDrawable) {
      this.a = param1IRecyclingDrawable;
    }
    
    private void a() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield b : I
      //   6: ifgt -> 44
      //   9: aload_0
      //   10: getfield c : I
      //   13: ifgt -> 44
      //   16: aload_0
      //   17: getfield d : Z
      //   20: ifeq -> 44
      //   23: aload_0
      //   24: getfield a : Lcom/blued/android/core/imagecache/drawable/IRecyclingDrawable;
      //   27: invokeinterface c : ()Z
      //   32: ifeq -> 44
      //   35: aload_0
      //   36: getfield a : Lcom/blued/android/core/imagecache/drawable/IRecyclingDrawable;
      //   39: invokeinterface d : ()V
      //   44: aload_0
      //   45: monitorexit
      //   46: return
      //   47: astore_1
      //   48: aload_0
      //   49: monitorexit
      //   50: aload_1
      //   51: athrow
      // Exception table:
      //   from	to	target	type
      //   2	44	47	finally
    }
    
    public void a(boolean param1Boolean) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: iload_1
      //   3: ifeq -> 24
      //   6: aload_0
      //   7: aload_0
      //   8: getfield c : I
      //   11: iconst_1
      //   12: iadd
      //   13: putfield c : I
      //   16: aload_0
      //   17: iconst_1
      //   18: putfield d : Z
      //   21: goto -> 34
      //   24: aload_0
      //   25: aload_0
      //   26: getfield c : I
      //   29: iconst_1
      //   30: isub
      //   31: putfield c : I
      //   34: aload_0
      //   35: monitorexit
      //   36: aload_0
      //   37: invokespecial a : ()V
      //   40: return
      //   41: astore_2
      //   42: aload_0
      //   43: monitorexit
      //   44: aload_2
      //   45: athrow
      // Exception table:
      //   from	to	target	type
      //   6	21	41	finally
      //   24	34	41	finally
      //   34	36	41	finally
      //   42	44	41	finally
    }
    
    public void b(boolean param1Boolean) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: iload_1
      //   3: ifeq -> 19
      //   6: aload_0
      //   7: aload_0
      //   8: getfield b : I
      //   11: iconst_1
      //   12: iadd
      //   13: putfield b : I
      //   16: goto -> 29
      //   19: aload_0
      //   20: aload_0
      //   21: getfield b : I
      //   24: iconst_1
      //   25: isub
      //   26: putfield b : I
      //   29: aload_0
      //   30: monitorexit
      //   31: aload_0
      //   32: invokespecial a : ()V
      //   35: return
      //   36: astore_2
      //   37: aload_0
      //   38: monitorexit
      //   39: aload_2
      //   40: athrow
      // Exception table:
      //   from	to	target	type
      //   6	16	36	finally
      //   19	29	36	finally
      //   29	31	36	finally
      //   37	39	36	finally
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\imagecache\drawable\IRecyclingDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */