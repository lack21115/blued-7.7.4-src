package cn.shuzilm.core;

import android.content.Context;

class b implements Runnable {
  b(DUHelper paramDUHelper, Context paramContext, String paramString1, String paramString2, Listener paramListener) {}
  
  public void run() {
    try {
      String str = DUHelper.a(DUHelper.a(), this.a, this.b, this.c);
      if (this.d != null) {
        String str1 = str;
        if (str == null)
          str1 = DUHelper.b(this.e, this.a); 
        this.d.handler(str1);
        return;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\shuzilm\core\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */