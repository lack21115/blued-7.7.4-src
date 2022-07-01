package com.soft.blued.ui.pay.googlepay.util;

public class IabResult {
  int a;
  
  String b;
  
  public IabResult(int paramInt, String paramString) {
    this.a = paramInt;
    if (paramString == null || paramString.trim().length() == 0) {
      this.b = IabHelper.a(paramInt);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(" (response: ");
    stringBuilder.append(IabHelper.a(paramInt));
    stringBuilder.append(")");
    this.b = stringBuilder.toString();
  }
  
  public String a() {
    return this.b;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("IabResult: ");
    stringBuilder.append(a());
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\pay\googlepa\\util\IabResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */