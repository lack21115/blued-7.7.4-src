package com.datavisor.vangogh.a;

import android.content.Context;
import android.os.Debug;

public class a {
  private static a a;
  
  private Context b = null;
  
  private long c = 0L;
  
  private a(Context paramContext) {
    if (paramContext != null) {
      this.b = paramContext;
      this.c = 0L;
      return;
    } 
    throw new IllegalArgumentException("DbgDetect initialization error: mContext is null.");
  }
  
  public static a a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/datavisor/vangogh/a/a.a : Lcom/datavisor/vangogh/a/a;
    //   3: ifnonnull -> 38
    //   6: ldc com/datavisor/vangogh/a/b
    //   8: monitorenter
    //   9: getstatic com/datavisor/vangogh/a/a.a : Lcom/datavisor/vangogh/a/a;
    //   12: ifnonnull -> 26
    //   15: new com/datavisor/vangogh/a/a
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Landroid/content/Context;)V
    //   23: putstatic com/datavisor/vangogh/a/a.a : Lcom/datavisor/vangogh/a/a;
    //   26: ldc com/datavisor/vangogh/a/b
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/datavisor/vangogh/a/b
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/datavisor/vangogh/a/a.a : Lcom/datavisor/vangogh/a/a;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  private void b() {
    if (((this.b.getApplicationInfo()).flags & 0x2) != 0)
      this.c |= 0x1L; 
  }
  
  private void c() {
    if (Debug.isDebuggerConnected())
      this.c |= 0x2L; 
  }
  
  public String a() {
    this.c = 0L;
    b();
    c();
    return String.valueOf(this.c);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\datavisor\vangogh\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */