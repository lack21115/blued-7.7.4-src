package com.sina.weibo.sdk.component;

enum BrowserLauncher {
  AUTH, COMMON, GAME, SHARE, WIDGET;
  
  static {
    COMMON = new BrowserLauncher("COMMON", 3);
    GAME = new BrowserLauncher("GAME", 4);
    ENUM$VALUES = new BrowserLauncher[] { AUTH, SHARE, WIDGET, COMMON, GAME };
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\component\BrowserLauncher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */