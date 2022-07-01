package com.android.webview.chromium;

final class WebViewChromiumFactoryProvider$FilteredClassLoader extends ClassLoader {
  WebViewChromiumFactoryProvider$FilteredClassLoader(ClassLoader paramClassLoader) {
    super(paramClassLoader);
  }
  
  protected final Class findClass(String paramString) {
    if (paramString != null) {
      if (paramString.startsWith("org.chromium.support_lib_"))
        return super.findClass(paramString); 
      throw new ClassNotFoundException("This ClassLoader should only be used for the androidx.webkit support library");
    } 
    throw new ClassNotFoundException("This ClassLoader should only be used for the androidx.webkit support library");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\WebViewChromiumFactoryProvider$FilteredClassLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */