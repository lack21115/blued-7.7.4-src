package com.bun.supplier;

import android.support.annotation.Keep;

public interface IRemoteIdSupplier extends InnerIdSupplier {
  @Keep
  String getAAID(String paramString);
  
  @Keep
  String getVAID(String paramString);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\bun\supplier\IRemoteIdSupplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */