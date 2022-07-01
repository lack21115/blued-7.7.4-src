package com.huawei.hms.support.api;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.Status;

public class ResolvePendingResult<T extends IMessageEntity> extends PendingResultImpl<ResolveResult<T>, T> {
  protected ResolvePendingResult(ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity, Class<T> paramClass) {
    super(paramApiClient, paramString, paramIMessageEntity, paramClass);
  }
  
  public static <R extends IMessageEntity> ResolvePendingResult<R> build(ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity, Class<R> paramClass) {
    return new ResolvePendingResult<R>(paramApiClient, paramString, paramIMessageEntity, paramClass);
  }
  
  public T get() {
    return await().getValue();
  }
  
  public ResolveResult<T> onComplete(T paramT) {
    ResolveResult<T> resolveResult = new ResolveResult<T>(paramT);
    resolveResult.setStatus(new Status(0));
    return resolveResult;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\ResolvePendingResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */