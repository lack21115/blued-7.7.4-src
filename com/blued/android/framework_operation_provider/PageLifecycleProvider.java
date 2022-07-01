package com.blued.android.framework_operation_provider;

import android.content.Context;
import android.os.Bundle;
import com.blued.android.core.imagecache.RecyclingImageLoader;
import com.blued.android.framework.provider.IPageLifecycleProvider;
import com.soft.blued.ui.live.view.VideoChatHintToast;
import com.umeng.analytics.MobclickAgent;

public class PageLifecycleProvider implements IPageLifecycleProvider {
  public Context a(Context paramContext) {
    return paramContext;
  }
  
  public void a(Context paramContext, Bundle paramBundle) {
    VideoChatHintToast.b(paramContext, paramBundle);
  }
  
  public void a(Bundle paramBundle) {
    VideoChatHintToast.b(paramBundle);
  }
  
  public void a(String paramString) {
    RecyclingImageLoader.c();
    MobclickAgent.onPageStart(paramString);
  }
  
  public void b(String paramString) {
    MobclickAgent.onPageEnd(paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework_operation_provider\PageLifecycleProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */