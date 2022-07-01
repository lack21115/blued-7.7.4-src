package com.blued.android.framework.activity;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.UIPageCallback;
import com.blued.android.framework.activity.wrapper.BluedContextWrapper;
import com.blued.android.framework.provider.ProviderHolder;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class CorePageCallback extends UIPageCallback {
  public Context a(Context paramContext) {
    ContextWrapper contextWrapper = BluedContextWrapper.a(paramContext);
    return (Context)(AppInfo.o() ? ViewPumpContextWrapper.a((Context)contextWrapper) : super.a((Context)contextWrapper));
  }
  
  public void a(Context paramContext, int paramInt, String[] paramArrayOfString, int[] paramArrayOfint) {}
  
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\activity\CorePageCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */