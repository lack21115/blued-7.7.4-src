package com.huawei.hms.support.api;

import com.huawei.hms.support.api.client.Result;

public class ResolveResult<T> extends Result {
  private T entity = null;
  
  public ResolveResult() {}
  
  public ResolveResult(T paramT) {}
  
  public T getValue() {
    return this.entity;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\ResolveResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */