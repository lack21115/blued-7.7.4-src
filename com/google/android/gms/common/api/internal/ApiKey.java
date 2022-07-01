package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;

public final class ApiKey<O extends Api.ApiOptions> {
  private final boolean zaa = false;
  
  private final int zab;
  
  private final Api<O> zac;
  
  private final O zad;
  
  private ApiKey(Api<O> paramApi, O paramO) {
    this.zac = paramApi;
    this.zad = paramO;
    this.zab = Objects.hashCode(new Object[] { this.zac, this.zad });
  }
  
  public static <O extends Api.ApiOptions> ApiKey<O> getSharedApiKey(Api<O> paramApi, O paramO) {
    return new ApiKey<O>(paramApi, paramO);
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject == null)
      return false; 
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof ApiKey))
      return false; 
    paramObject = paramObject;
    return (Objects.equal(this.zac, ((ApiKey)paramObject).zac) && Objects.equal(this.zad, ((ApiKey)paramObject).zad));
  }
  
  public final String getApiName() {
    return this.zac.zad();
  }
  
  public final Api.AnyClientKey<?> getClientKey() {
    return this.zac.zac();
  }
  
  public final int hashCode() {
    return this.zab;
  }
  
  public final boolean isUnique() {
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\ApiKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */