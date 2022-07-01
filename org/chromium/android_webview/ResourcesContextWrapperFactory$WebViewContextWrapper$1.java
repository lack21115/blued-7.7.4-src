package org.chromium.android_webview;

final class ResourcesContextWrapperFactory$WebViewContextWrapper$1 extends ClassLoader {
  protected final Class findClass(String paramString) {
    try {
      return webViewCl.loadClass(paramString);
    } catch (ClassNotFoundException classNotFoundException) {
      return appCl.loadClass(paramString);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\ResourcesContextWrapperFactory$WebViewContextWrapper$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */