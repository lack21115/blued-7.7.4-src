package com.blued.android.framework.ui;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import com.blued.android.core.ui.UIPageCallback;
import com.blued.android.framework.provider.ProviderHolder;
import com.blued.android.framework.ui.wrapper.BluedContextWrapper;

public class CorePageCallback extends UIPageCallback {
  public Context a(Context paramContext) {
    ContextWrapper contextWrapper = BluedContextWrapper.a(paramContext);
    return ProviderHolder.a().d().a((Context)contextWrapper);
  }
  
  public void a(Context paramContext, Bundle paramBundle) {
    ProviderHolder.a().d().a(paramContext, paramBundle);
  }
  
  public void a(Bundle paramBundle) {
    ProviderHolder.a().d().a(paramBundle);
  }
  
  public void a(String paramString) {
    ProviderHolder.a().d().a(paramString);
  }
  
  public void b(String paramString) {
    ProviderHolder.a().d().b(paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framewor\\ui\CorePageCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */