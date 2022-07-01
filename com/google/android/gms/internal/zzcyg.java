package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;

public final class zzcyg {
  public static final Api API;
  
  private static Api.zzf zzegu = new Api.zzf();
  
  public static final Api.zza zzegv;
  
  private static Api.zzf zzkln = new Api.zzf();
  
  private static Api.zza zzklo;
  
  static {
    zzegv = new zzcyh();
    zzklo = new zzcyi();
    new Scope("profile");
    new Scope("email");
    API = new Api("SignIn.API", zzegv, zzegu);
    new Api("SignIn.INTERNAL_API", zzklo, zzkln);
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\internal\zzcyg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */