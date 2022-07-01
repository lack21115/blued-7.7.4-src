package cn.shuzilm.core;

import android.content.Context;

class m implements Runnable {
  m(DUHelper paramDUHelper, Context paramContext, String paramString1, String paramString2, String paramString3, Listener paramListener) {}
  
  public void run() {
    try {
      String str = DUHelper.a(DUHelper.a(), this.a, this.b, this.c, this.d);
      if (this.e != null) {
        this.e.handler(str);
        return;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\shuzilm\core\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */