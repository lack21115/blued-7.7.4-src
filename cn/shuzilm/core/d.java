package cn.shuzilm.core;

import android.content.Context;

final class d implements Runnable {
  d(Context paramContext1, String paramString, Context paramContext2) {}
  
  public void run() {
    try {
      DUHelper.a(this.a);
      DUHelper.setConfig("f_pkg", this.b);
      DUHelper.a(this.c, DUHelper.e().toString(), (String)null, (String)null);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
      unsatisfiedLinkError.printStackTrace();
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\shuzilm\core\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */