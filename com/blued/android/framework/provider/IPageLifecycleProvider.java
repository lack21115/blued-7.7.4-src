package com.blued.android.framework.provider;

import android.content.Context;
import android.os.Bundle;

public interface IPageLifecycleProvider {
  public static final EmptyImpl a = new EmptyImpl();
  
  Context a(Context paramContext);
  
  void a(Context paramContext, Bundle paramBundle);
  
  void a(Bundle paramBundle);
  
  void a(String paramString);
  
  void b(String paramString);
  
  public static class EmptyImpl implements IPageLifecycleProvider {
    public Context a(Context param1Context) {
      return param1Context;
    }
    
    public void a(Context param1Context, Bundle param1Bundle) {}
    
    public void a(Bundle param1Bundle) {}
    
    public void a(String param1String) {}
    
    public void b(String param1String) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\provider\IPageLifecycleProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */