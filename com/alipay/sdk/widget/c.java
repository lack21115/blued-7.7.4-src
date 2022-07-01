package com.alipay.sdk.widget;

class c implements Runnable {
  c(a parama) {}
  
  public void run() {
    if (a.c(this.a) != null && a.c(this.a).isShowing())
      try {
        a.e(this.a).removeMessages(1);
        a.c(this.a).dismiss();
        return;
      } catch (Exception exception) {
        com.alipay.sdk.util.c.a(exception);
      }  
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\widget\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */