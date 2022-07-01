package org.chromium.policy;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.UserManager;

public class AppRestrictionsProvider extends AbstractAppRestrictionsProvider {
  private final UserManager mUserManager;
  
  public AppRestrictionsProvider(Context paramContext) {
    super(paramContext);
    if (Build.VERSION.SDK_INT >= 18) {
      this.mUserManager = (UserManager)paramContext.getSystemService("user");
      return;
    } 
    this.mUserManager = null;
  }
  
  @TargetApi(18)
  protected final Bundle getApplicationRestrictions(String paramString) {
    return (this.mUserManager == null) ? new Bundle() : this.mUserManager.getApplicationRestrictions(paramString);
  }
  
  @TargetApi(21)
  protected final String getRestrictionChangeIntentAction() {
    return (Build.VERSION.SDK_INT < 21) ? null : "android.intent.action.APPLICATION_RESTRICTIONS_CHANGED";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\policy\AppRestrictionsProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */