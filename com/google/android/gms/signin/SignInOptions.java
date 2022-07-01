package com.google.android.gms.signin;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;

public final class SignInOptions implements Api.ApiOptions.Optional {
  public static final SignInOptions zaa = new SignInOptions(false, false, null, false, null, null, false, null, null);
  
  private final boolean zab = false;
  
  private final boolean zac = false;
  
  private final String zad = null;
  
  private final boolean zae = false;
  
  private final String zaf = null;
  
  private final String zag = null;
  
  private final boolean zah = false;
  
  private final Long zai = null;
  
  private final Long zaj = null;
  
  private SignInOptions(boolean paramBoolean1, boolean paramBoolean2, String paramString1, boolean paramBoolean3, String paramString2, String paramString3, boolean paramBoolean4, Long paramLong1, Long paramLong2) {}
  
  public final boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof SignInOptions))
      return false; 
    paramObject = paramObject;
    return (this.zab == ((SignInOptions)paramObject).zab && this.zac == ((SignInOptions)paramObject).zac && Objects.equal(this.zad, ((SignInOptions)paramObject).zad) && this.zae == ((SignInOptions)paramObject).zae && this.zah == ((SignInOptions)paramObject).zah && Objects.equal(this.zaf, ((SignInOptions)paramObject).zaf) && Objects.equal(this.zag, ((SignInOptions)paramObject).zag) && Objects.equal(this.zai, ((SignInOptions)paramObject).zai) && Objects.equal(this.zaj, ((SignInOptions)paramObject).zaj));
  }
  
  public final int hashCode() {
    return Objects.hashCode(new Object[] { Boolean.valueOf(this.zab), Boolean.valueOf(this.zac), this.zad, Boolean.valueOf(this.zae), Boolean.valueOf(this.zah), this.zaf, this.zag, this.zai, this.zaj });
  }
  
  public final boolean zaa() {
    return this.zab;
  }
  
  public final boolean zab() {
    return this.zac;
  }
  
  public final String zac() {
    return this.zad;
  }
  
  public final boolean zad() {
    return this.zae;
  }
  
  public final String zae() {
    return this.zaf;
  }
  
  public final String zaf() {
    return this.zag;
  }
  
  public final boolean zag() {
    return this.zah;
  }
  
  public final Long zah() {
    return this.zai;
  }
  
  public final Long zai() {
    return this.zaj;
  }
  
  static {
    new zaa();
  }
  
  public static final class zaa {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\signin\SignInOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */