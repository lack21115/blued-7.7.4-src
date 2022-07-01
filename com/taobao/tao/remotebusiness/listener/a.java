package com.taobao.tao.remotebusiness.listener;

import com.taobao.tao.remotebusiness.MtopBusiness;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import mtopsdk.mtop.common.MtopListener;

final class a implements InvocationHandler {
  private MtopFinishListenerImpl a;
  
  private MtopProgressListenerImpl b;
  
  private MtopBusiness c;
  
  private MtopListener d;
  
  public a(MtopBusiness paramMtopBusiness, MtopListener paramMtopListener) {
    this.a = new MtopFinishListenerImpl(paramMtopBusiness, paramMtopListener);
    this.c = paramMtopBusiness;
    this.d = paramMtopListener;
  }
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject) {
    if (paramMethod.getName().equals("onFinished")) {
      paramObject = this.a;
      return paramMethod.invoke(paramObject, paramArrayOfObject);
    } 
    if (paramMethod.getName().equals("onDataReceived") || paramMethod.getName().equals("onHeader")) {
      if (this.b == null)
        this.b = new MtopProgressListenerImpl(this.c, this.d); 
      paramObject = this.b;
      return paramMethod.invoke(paramObject, paramArrayOfObject);
    } 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\taobao\tao\remotebusiness\listener\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */