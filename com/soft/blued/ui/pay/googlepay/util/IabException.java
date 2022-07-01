package com.soft.blued.ui.pay.googlepay.util;

public class IabException extends Exception {
  IabResult a;
  
  public IabException(int paramInt, String paramString) {
    this(new IabResult(paramInt, paramString));
  }
  
  public IabException(int paramInt, String paramString, Exception paramException) {
    this(new IabResult(paramInt, paramString), paramException);
  }
  
  public IabException(IabResult paramIabResult) {
    this(paramIabResult, (Exception)null);
  }
  
  public IabException(IabResult paramIabResult, Exception paramException) {
    super(paramIabResult.a(), paramException);
    this.a = paramIabResult;
  }
  
  public IabResult a() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\pay\googlepa\\util\IabException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */