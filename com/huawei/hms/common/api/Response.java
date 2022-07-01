package com.huawei.hms.common.api;

import com.huawei.hms.support.api.client.Result;

public class Response<T extends Result> {
  protected T result;
  
  public Response() {}
  
  protected Response(T paramT) {
    this.result = paramT;
  }
  
  protected T getResult() {
    return this.result;
  }
  
  public void setResult(T paramT) {
    this.result = paramT;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\api\Response.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */