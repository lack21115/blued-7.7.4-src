package com.huawei.hms.support.api.client;

import android.os.Bundle;

public class BundleResult {
  private int resultCode;
  
  private Bundle rspBody;
  
  public BundleResult(int paramInt, Bundle paramBundle) {
    this.resultCode = paramInt;
    this.rspBody = paramBundle;
  }
  
  public int getResultCode() {
    return this.resultCode;
  }
  
  public Bundle getRspBody() {
    return this.rspBody;
  }
  
  public void setResultCode(int paramInt) {
    this.resultCode = paramInt;
  }
  
  public void setRspBody(Bundle paramBundle) {
    this.rspBody = paramBundle;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\client\BundleResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */