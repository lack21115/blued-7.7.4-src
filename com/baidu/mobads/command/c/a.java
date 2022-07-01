package com.baidu.mobads.command.c;

import android.content.Context;
import android.content.IntentFilter;
import com.baidu.mobads.openad.c.b;
import com.baidu.mobads.openad.c.c;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;

public class a extends c {
  private static a d;
  
  private Context a;
  
  private b b;
  
  private a(Context paramContext) {
    this.a = paramContext.getApplicationContext();
  }
  
  public static a a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/baidu/mobads/command/c/a.d : Lcom/baidu/mobads/command/c/a;
    //   3: ifnonnull -> 38
    //   6: ldc com/baidu/mobads/command/c/a
    //   8: monitorenter
    //   9: getstatic com/baidu/mobads/command/c/a.d : Lcom/baidu/mobads/command/c/a;
    //   12: ifnonnull -> 26
    //   15: new com/baidu/mobads/command/c/a
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Landroid/content/Context;)V
    //   23: putstatic com/baidu/mobads/command/c/a.d : Lcom/baidu/mobads/command/c/a;
    //   26: ldc com/baidu/mobads/command/c/a
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/baidu/mobads/command/c/a
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/baidu/mobads/command/c/a.d : Lcom/baidu/mobads/command/c/a;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  public void a() {
    dispatchEvent((IOAdEvent)new b("AdLpClosed"));
  }
  
  public void b() {
    try {
      if (this.b == null)
        this.b = new b(this); 
      if (this.a != null) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("lp_close");
        this.a.registerReceiver(this.b, intentFilter);
      } 
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void c() {
    Context context = this.a;
    if (context != null) {
      b b1 = this.b;
      if (b1 != null) {
        context.unregisterReceiver(b1);
        this.b = null;
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\command\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */