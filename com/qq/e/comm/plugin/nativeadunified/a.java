package com.qq.e.comm.plugin.nativeadunified;

import android.content.Context;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.adevent.ADEventListener;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.mediation.interfaces.BaseNativeUnifiedAd;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class a {
  public static NativeUnifiedADData a(NativeUnifiedADData paramNativeUnifiedADData, k.a parama) {
    InvocationHandler invocationHandler;
    if (!(paramNativeUnifiedADData instanceof ADEventListener))
      return paramNativeUnifiedADData; 
    try {
      Method method = ADEventListener.class.getDeclaredMethod("setAdListener", new Class[] { ADListener.class });
      invocationHandler = new InvocationHandler(method, parama, paramNativeUnifiedADData) {
          public Object invoke(Object param1Object, Method param1Method, Object[] param1ArrayOfObject) throws Throwable {
            if (this.a.equals(param1Method)) {
              this.b.a((ADListener)param1ArrayOfObject[0]);
              return param1Method.invoke(this.c, new Object[] { this.b });
            } 
            return param1Method.invoke(this.c, param1ArrayOfObject);
          }
        };
      return (NativeUnifiedADData)Proxy.newProxyInstance(NativeUnifiedADData.class.getClassLoader(), new Class[] { NativeUnifiedADData.class, ADEventListener.class }, invocationHandler);
    } catch (NoSuchMethodException noSuchMethodException) {
      noSuchMethodException.printStackTrace();
      return (NativeUnifiedADData)invocationHandler;
    } 
  }
  
  public static BaseNativeUnifiedAd a(String paramString1, Context paramContext, String paramString2, String paramString3) throws Exception {
    return Class.forName(paramString1).<BaseNativeUnifiedAd>asSubclass(BaseNativeUnifiedAd.class).getDeclaredConstructor(new Class[] { Context.class, String.class, String.class }).newInstance(new Object[] { paramContext, paramString2, paramString3 });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\nativeadunified\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */