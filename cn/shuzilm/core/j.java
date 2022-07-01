package cn.shuzilm.core;

import android.content.Context;

final class j implements Runnable {
  j(Context paramContext, String paramString1, String paramString2) {}
  
  public void run() {
    try {
      DUHelper.setConfig("type", "0");
      DUHelper.setConfig("apiKey", DUHelper.d());
      DUHelper.a(DUHelper.a(), this.a, DUHelper.e(), this.b);
      DUHelper.a(DUHelper.a(), DUHelper.f(), this.c);
      DUHelper.b(this.a, DUHelper.e().toString(), DUHelper.f().toString());
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\shuzilm\core\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */