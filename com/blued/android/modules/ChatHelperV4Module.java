package com.blued.android.modules;

import com.blued.android.module.base.base.IBaseInterface;
import com.blued.android.module.base.chat.ChatHelperV4Proxy;
import com.blued.android.module.base.chat.IChatHelperV4;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;

public class ChatHelperV4Module {
  static IChatHelperV4 a = new IChatHelperV4() {
      public void b() {
        ChatHelperV4.a().e();
      }
      
      public void c() {
        ChatHelperV4.a().d();
      }
    };
  
  public static void a() {
    ChatHelperV4Proxy.a().a((IBaseInterface)a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\modules\ChatHelperV4Module.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */