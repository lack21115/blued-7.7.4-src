package com.blued.android.provider;

import com.blued.android.framework.provider.IUserInfoProvider;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.UserRelationshipUtils;

public class UserInfoProviderForSimilarity implements IUserInfoProvider {
  public String a() {
    return UserInfo.a().i().getUid();
  }
  
  public void a(String paramString) {
    UserRelationshipUtils.a(paramString, new int[0]);
  }
  
  public String b() {
    return UserInfo.a().d();
  }
  
  public void c() {
    Logger.c("loginInBackground", new Object[0]);
    UserRelationshipUtils.b();
  }
  
  public void d() {
    BluedConfig.b().e();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\provider\UserInfoProviderForSimilarity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */