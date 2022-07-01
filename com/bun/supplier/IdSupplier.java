package com.bun.supplier;

import android.support.annotation.Keep;

@Keep
public interface IdSupplier {
  @Keep
  String getAAID();
  
  @Keep
  String getOAID();
  
  @Keep
  String getVAID();
  
  @Keep
  boolean isSupported();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\bun\supplier\IdSupplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */