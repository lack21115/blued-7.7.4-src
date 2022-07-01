package com.google.android.gms.auth.api.signin;

import android.os.Bundle;
import com.google.android.gms.common.api.Scope;
import java.util.List;

public interface GoogleSignInOptionsExtension {
  public static final int FITNESS = 3;
  
  public static final int GAMES = 1;
  
  int getExtensionType();
  
  List<Scope> getImpliedScopes();
  
  Bundle toBundle();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\auth\api\signin\GoogleSignInOptionsExtension.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */