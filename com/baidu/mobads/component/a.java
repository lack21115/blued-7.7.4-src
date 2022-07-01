package com.baidu.mobads.component;

class a implements IFeedPortraitListener {
  a(XNativeView paramXNativeView) {}
  
  public void playCompletion() {}
  
  public void playError() {}
  
  public void playRenderingStart() {
    XNativeView.access$000(this.a);
    XNativeViewManager.getInstance().resetAllPlayer(this.a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\component\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */