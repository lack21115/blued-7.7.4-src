package com.huawei.hms.api;

import android.content.Intent;

public class UserRecoverableException extends Exception {
  private final Intent a;
  
  public UserRecoverableException(String paramString, Intent paramIntent) {
    super(paramString);
    this.a = paramIntent;
  }
  
  public Intent getIntent() {
    return new Intent(this.a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\api\UserRecoverableException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */