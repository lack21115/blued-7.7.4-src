package org.chromium.android_webview;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class ResourcesContextWrapperFactory {
  private static final WeakHashMap sCtxToWrapper = new WeakHashMap<Object, Object>();
  
  private static final Object sLock = new Object();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static Context get(Context paramContext) {
    if (paramContext instanceof ResourcesContextWrapperFactory$WebViewContextWrapper)
      return paramContext; 
    synchronized (sLock) {
      ResourcesContextWrapperFactory$WebViewContextWrapper resourcesContextWrapperFactory$WebViewContextWrapper1;
      WeakReference<ResourcesContextWrapperFactory$WebViewContextWrapper> weakReference = (WeakReference)sCtxToWrapper.get(paramContext);
      if (weakReference == null) {
        weakReference = null;
      } else {
        resourcesContextWrapperFactory$WebViewContextWrapper1 = weakReference.get();
      } 
      ResourcesContextWrapperFactory$WebViewContextWrapper resourcesContextWrapperFactory$WebViewContextWrapper2 = resourcesContextWrapperFactory$WebViewContextWrapper1;
      if (resourcesContextWrapperFactory$WebViewContextWrapper1 == null) {
        resourcesContextWrapperFactory$WebViewContextWrapper2 = new ResourcesContextWrapperFactory$WebViewContextWrapper(paramContext);
        sCtxToWrapper.put(paramContext, new WeakReference<ResourcesContextWrapperFactory$WebViewContextWrapper>(resourcesContextWrapperFactory$WebViewContextWrapper2));
      } 
      return (Context)resourcesContextWrapperFactory$WebViewContextWrapper2;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\ResourcesContextWrapperFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */