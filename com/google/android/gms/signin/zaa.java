package com.google.android.gms.signin;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.signin.internal.SignInClientImpl;

public final class zaa {
  public static final Api.AbstractClientBuilder<SignInClientImpl, SignInOptions> zaa;
  
  public static final Api<SignInOptions> zab;
  
  private static final Api.ClientKey<SignInClientImpl> zac = new Api.ClientKey();
  
  private static final Api.ClientKey<SignInClientImpl> zad = new Api.ClientKey();
  
  private static final Api.AbstractClientBuilder<SignInClientImpl, zae> zae;
  
  private static final Scope zaf;
  
  private static final Scope zag;
  
  private static final Api<zae> zah;
  
  static {
    zaa = new zac();
    zae = new zab();
    zaf = new Scope("profile");
    zag = new Scope("email");
    zab = new Api("SignIn.API", zaa, zac);
    zah = new Api("SignIn.INTERNAL_API", zae, zad);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\signin\zaa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */