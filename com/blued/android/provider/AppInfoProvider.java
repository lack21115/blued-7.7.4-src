package com.blued.android.provider;

import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.provider.IAppInfoProvider;

public class AppInfoProvider implements IAppInfoProvider {
  public String a() {
    return "1";
  }
  
  public String b() {
    return BluedSkinUtils.c() ? "light" : "dark";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\provider\AppInfoProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */