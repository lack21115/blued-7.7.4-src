package com.blued.android.modules;

import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.base.user.IUser;
import com.blued.android.module.base.user.UserProxy;
import com.blued.android.module.live_china.model.PayRemaining;
import com.soft.blued.user.UserInfo;

class UserModule {
  private static IUser a = new IUser() {
      public String a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(UserInfo.a().i().getVBadge());
        stringBuilder.append("");
        return stringBuilder.toString();
      }
    };
  
  public static void a() {
    UserProxy.b().a(a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\modules\UserModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */