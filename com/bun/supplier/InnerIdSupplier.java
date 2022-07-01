package com.bun.supplier;

import android.support.annotation.Keep;

public interface InnerIdSupplier extends IdSupplier {
  void a(SupplierListener paramSupplierListener);
  
  boolean a();
  
  @Keep
  String getUDID();
  
  @Keep
  void shutDown();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\bun\supplier\InnerIdSupplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */