package com.bun.supplier;

import android.support.annotation.Keep;

@Keep
public class DefaultSupplier implements IdSupplier {
  @Keep
  public String getAAID() {
    return "";
  }
  
  @Keep
  public String getOAID() {
    return "";
  }
  
  @Keep
  public String getVAID() {
    return "";
  }
  
  @Keep
  public boolean isSupported() {
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\bun\supplier\DefaultSupplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */