package com.cmic.sso.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import java.util.UUID;

public class z {
  public static String a() {
    return UUID.randomUUID().toString().replaceAll("-", "");
  }
  
  public static void a(Context paramContext, Bundle paramBundle, String paramString1, String paramString2) {
    b(paramContext, paramBundle, paramString1, paramString2);
  }
  
  public static String b() {
    return c().replace("-", "");
  }
  
  private static void b(Context paramContext, Bundle paramBundle, String paramString1, String paramString2) {
    try {
      Intent intent = new Intent();
      intent.setClassName(paramContext, "com.cmic.sso.sdk.activity.LoginAuthActivity");
      intent.putExtras(paramBundle);
      intent.setFlags(268435456);
      if (paramString1 != null && paramString2 != null) {
        ActivityCompat.startActivity(paramContext, intent, ActivityOptionsCompat.makeCustomAnimation(paramContext, n.b(paramContext, paramString1), n.b(paramContext, paramString2)).toBundle());
        return;
      } 
      paramContext.startActivity(intent);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      if (paramString1 != null && paramString2 != null) {
        Intent intent = new Intent();
        intent.setClassName(paramContext, "com.cmic.sso.sdk.activity.LoginAuthActivity");
        intent.putExtras(paramBundle);
        intent.setFlags(268435456);
        paramContext.startActivity(intent);
      } 
      return;
    } 
  }
  
  private static String c() {
    return UUID.randomUUID().toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sd\\utils\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */