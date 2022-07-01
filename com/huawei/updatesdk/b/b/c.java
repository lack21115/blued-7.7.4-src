package com.huawei.updatesdk.b.b;

import com.huawei.updatesdk.a.b.d.c.c;

public class c extends c {
  private int isUpdateSdk_ = 1;
  
  private String locale_ = null;
  
  private int serviceType_ = 0;
  
  private String ts_ = null;
  
  private void e(String paramString) {
    this.ts_ = paramString;
  }
  
  public void a(int paramInt) {
    this.serviceType_ = paramInt;
  }
  
  public void d(String paramString) {
    this.locale_ = paramString;
  }
  
  public void e() {
    e(String.valueOf(System.currentTimeMillis()));
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getName());
    stringBuilder.append(" {\n\tmethod_: ");
    stringBuilder.append(b());
    stringBuilder.append("\n}");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\b\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */