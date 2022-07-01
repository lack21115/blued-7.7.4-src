package com.blued.android.provider;

import com.blued.android.framework.provider.IUserInfoProvider;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.UserRelationshipUtils;

public class UserInfoProvider implements IUserInfoProvider {
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
    UserRelationshipUtils.b();
  }
  
  public void d() {
    BluedConfig.b().e();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\provider\UserInfoProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */