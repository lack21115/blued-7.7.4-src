package com.blued.android.module.base.payment;

public class PaymentProxy implements IPayment {
  private static PaymentProxy a = new PaymentProxy();
  
  private IPayment b = null;
  
  public static PaymentProxy a() {
    return a;
  }
  
  public void a(IPayment paramIPayment) {
    this.b = paramIPayment;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\base\payment\PaymentProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */