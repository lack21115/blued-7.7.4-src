package com.blued.android.module.base.chat;

import com.blued.android.module.base.base.BaseProxy;

public class ChatHelperV4Proxy extends BaseProxy<IChatHelperV4> implements IChatHelperV4 {
  private static ChatHelperV4Proxy b;
  
  public static ChatHelperV4Proxy a() {
    // Byte code:
    //   0: getstatic com/blued/android/module/base/chat/ChatHelperV4Proxy.b : Lcom/blued/android/module/base/chat/ChatHelperV4Proxy;
    //   3: ifnonnull -> 37
    //   6: ldc com/blued/android/module/base/chat/ChatHelperV4Proxy
    //   8: monitorenter
    //   9: getstatic com/blued/android/module/base/chat/ChatHelperV4Proxy.b : Lcom/blued/android/module/base/chat/ChatHelperV4Proxy;
    //   12: ifnonnull -> 25
    //   15: new com/blued/android/module/base/chat/ChatHelperV4Proxy
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/blued/android/module/base/chat/ChatHelperV4Proxy.b : Lcom/blued/android/module/base/chat/ChatHelperV4Proxy;
    //   25: ldc com/blued/android/module/base/chat/ChatHelperV4Proxy
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/blued/android/module/base/chat/ChatHelperV4Proxy
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/blued/android/module/base/chat/ChatHelperV4Proxy.b : Lcom/blued/android/module/base/chat/ChatHelperV4Proxy;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public void b() {
    if (this.a != null)
      ((IChatHelperV4)this.a).b(); 
  }
  
  public void c() {
    if (this.a != null)
      ((IChatHelperV4)this.a).c(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\base\chat\ChatHelperV4Proxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */