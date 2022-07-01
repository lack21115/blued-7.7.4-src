package com.blued.android.module.base.webpage;

public class WebPageProxy implements IWebPage {
  private static WebPageProxy a = new WebPageProxy();
  
  private IWebPage b = null;
  
  public static WebPageProxy a() {
    return a;
  }
  
  public void a(IWebPage paramIWebPage) {
    this.b = paramIWebPage;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\base\webpage\WebPageProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */