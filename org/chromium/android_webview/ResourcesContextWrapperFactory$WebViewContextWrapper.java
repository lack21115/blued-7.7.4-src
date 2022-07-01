package org.chromium.android_webview;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.view.LayoutInflater;

final class ResourcesContextWrapperFactory$WebViewContextWrapper extends ContextWrapper {
  private Context mApplicationContext;
  
  public ResourcesContextWrapperFactory$WebViewContextWrapper(Context paramContext) {
    super(paramContext);
  }
  
  public final Context getApplicationContext() {
    if (this.mApplicationContext == null) {
      Context context = getBaseContext().getApplicationContext();
      if (context == getBaseContext()) {
        this.mApplicationContext = (Context)this;
      } else {
        this.mApplicationContext = ResourcesContextWrapperFactory.get(context);
      } 
    } 
    return this.mApplicationContext;
  }
  
  public final ClassLoader getClassLoader() {
    ClassLoader classLoader = getBaseContext().getClassLoader();
    return new ResourcesContextWrapperFactory$WebViewContextWrapper$1(getClass().getClassLoader(), classLoader);
  }
  
  public final Object getSystemService(String paramString) {
    return "layout_inflater".equals(paramString) ? ((LayoutInflater)getBaseContext().getSystemService(paramString)).cloneInContext((Context)this) : getBaseContext().getSystemService(paramString);
  }
  
  public final void registerComponentCallbacks(ComponentCallbacks paramComponentCallbacks) {
    getBaseContext().registerComponentCallbacks(paramComponentCallbacks);
  }
  
  public final void startActivity(Intent paramIntent) {
    if (AwContents.activityFromContext((Context)this) == null)
      paramIntent.setFlags(268435456); 
    super.startActivity(paramIntent);
  }
  
  public final void unregisterComponentCallbacks(ComponentCallbacks paramComponentCallbacks) {
    getBaseContext().unregisterComponentCallbacks(paramComponentCallbacks);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\ResourcesContextWrapperFactory$WebViewContextWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */