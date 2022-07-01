package a.b.a.a;

import java.util.concurrent.Executor;

public class a extends c {
  public static volatile a c;
  
  public c a;
  
  public c b;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public a() {
    new b();
    throw new VerifyError("bad dex opcode");
  }
  
  public static a b() {
    // Byte code:
    //   0: getstatic a/b/a/a/a.c : La/b/a/a/a;
    //   3: ifnull -> 10
    //   6: getstatic a/b/a/a/a.c : La/b/a/a/a;
    //   9: areturn
    //   10: ldc a/b/a/a/a
    //   12: monitorenter
    //   13: getstatic a/b/a/a/a.c : La/b/a/a/a;
    //   16: ifnonnull -> 29
    //   19: new a/b/a/a/a
    //   22: dup
    //   23: invokespecial <init> : ()V
    //   26: putstatic a/b/a/a/a.c : La/b/a/a/a;
    //   29: ldc a/b/a/a/a
    //   31: monitorexit
    //   32: getstatic a/b/a/a/a.c : La/b/a/a/a;
    //   35: areturn
    //   36: astore_0
    //   37: ldc a/b/a/a/a
    //   39: monitorexit
    //   40: aload_0
    //   41: athrow
    // Exception table:
    //   from	to	target	type
    //   13	29	36	finally
    //   29	32	36	finally
    //   37	40	36	finally
  }
  
  public void a(Runnable paramRunnable) {
    throw new VerifyError("bad dex opcode");
  }
  
  public boolean a() {
    throw new VerifyError("bad dex opcode");
  }
  
  public void b(Runnable paramRunnable) {
    throw new VerifyError("bad dex opcode");
  }
  
  public static final class a implements Executor {
    public void execute(Runnable param1Runnable) {
      a.b();
      throw new VerifyError("bad dex opcode");
    }
  }
  
  public static final class b implements Executor {
    public void execute(Runnable param1Runnable) {
      a.b();
      throw new VerifyError("bad dex opcode");
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\a\b\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */