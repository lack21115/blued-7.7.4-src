package com.huawei.hms.common.api;

import com.huawei.hms.common.Feature;

@Deprecated
public final class UnsupportedApiCallException extends UnsupportedOperationException {
  private final Feature feature;
  
  public UnsupportedApiCallException(Feature paramFeature) {
    this.feature = paramFeature;
  }
  
  public final String getMessage() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.feature);
    stringBuilder.append(" is unsupported");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\api\UnsupportedApiCallException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */