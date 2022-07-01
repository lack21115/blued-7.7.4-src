package com.huawei.hms.support.api.client;

public abstract class ConvertedResult<R extends Result> {
  public abstract <S extends Result> ConvertedResult<S> convertResult(ResultConvert<? super R, ? extends S> paramResultConvert);
  
  public abstract void finalExec(ResultCallbacks<? super R> paramResultCallbacks);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\client\ConvertedResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */