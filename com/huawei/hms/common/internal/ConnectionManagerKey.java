package com.huawei.hms.common.internal;

import android.content.Context;
import com.huawei.hms.api.Api;
import java.lang.ref.WeakReference;

public class ConnectionManagerKey<TOption extends Api.ApiOptions> {
  private final Api<TOption> mApi;
  
  private final WeakReference<Context> mContextRef;
  
  private final int mHashKey;
  
  private final boolean mHaveOption = false;
  
  private final TOption mOption;
  
  private final String subAppId;
  
  private ConnectionManagerKey(Context paramContext, Api<TOption> paramApi, TOption paramTOption, String paramString) {
    this.mContextRef = new WeakReference<Context>(paramContext);
    this.mApi = paramApi;
    this.mOption = paramTOption;
    this.mHashKey = Objects.hashCode(new Object[] { this.mContextRef.get(), this.mApi, this.mOption });
    this.subAppId = paramString;
  }
  
  private ConnectionManagerKey(Api<TOption> paramApi, String paramString) {
    this.mApi = paramApi;
    this.mOption = null;
    this.mHashKey = System.identityHashCode(this);
    this.subAppId = paramString;
    this.mContextRef = null;
  }
  
  public static <TOption extends Api.ApiOptions> ConnectionManagerKey<TOption> createConnectionManagerKey(Context paramContext, Api<TOption> paramApi, TOption paramTOption, String paramString) {
    return new ConnectionManagerKey<TOption>(paramContext, paramApi, paramTOption, paramString);
  }
  
  public static <TOption extends Api.ApiOptions> ConnectionManagerKey<TOption> createConnectionManagerKey(Api<TOption> paramApi, String paramString) {
    return new ConnectionManagerKey<TOption>(paramApi, paramString);
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof ConnectionManagerKey))
      return false; 
    paramObject = paramObject;
    return (this.mContextRef != null && ((ConnectionManagerKey)paramObject).mContextRef != null) ? ((this.mHaveOption == ((ConnectionManagerKey)paramObject).mHaveOption && Objects.equal(this.mApi, ((ConnectionManagerKey)paramObject).mApi) && Objects.equal(this.mOption, ((ConnectionManagerKey)paramObject).mOption) && Objects.equal(this.subAppId, ((ConnectionManagerKey)paramObject).subAppId) && Objects.equal(this.mContextRef.get(), ((ConnectionManagerKey)paramObject).mContextRef.get()))) : ((this.mContextRef == null && ((ConnectionManagerKey)paramObject).mContextRef == null) ? ((this.mHaveOption == ((ConnectionManagerKey)paramObject).mHaveOption && Objects.equal(this.mApi, ((ConnectionManagerKey)paramObject).mApi) && Objects.equal(this.mOption, ((ConnectionManagerKey)paramObject).mOption) && Objects.equal(this.subAppId, ((ConnectionManagerKey)paramObject).subAppId))) : false);
  }
  
  public final int hashCode() {
    return this.mHashKey;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\internal\ConnectionManagerKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */