package com.google.android.gms.common.api;

public class Response<T extends Result> {
  private T zza;
  
  public Response() {}
  
  public Response(T paramT) {
    this.zza = paramT;
  }
  
  protected T getResult() {
    return this.zza;
  }
  
  public void setResult(T paramT) {
    this.zza = paramT;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\Response.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */