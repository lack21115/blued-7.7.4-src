package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.Method;

public abstract class a implements v {
  protected Method a;
  
  protected byte[] b;
  
  protected String c;
  
  protected int d;
  
  protected String e;
  
  protected boolean f;
  
  public a(Method paramMethod, int paramInt, String paramString1, byte[] paramArrayOfbyte, String paramString2, boolean paramBoolean) {
    this.a = paramMethod;
    this.d = paramInt;
    this.c = paramString1;
    this.b = paramArrayOfbyte;
    this.e = paramString2;
    this.f = paramBoolean;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\android\phone\mrpc\core\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */