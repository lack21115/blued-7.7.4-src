package com.baidu.mobads.f;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdContainerFactory;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;

public class a {
  private static IXAdContainerFactory e;
  
  public double a = 0.1D;
  
  private Context b;
  
  private Class<?> c = null;
  
  private double d;
  
  private Boolean f;
  
  private IXAdLogger g = XAdSDKFoundationFacade.getInstance().getAdLogger();
  
  public a(Class<?> paramClass, Context paramContext, double paramDouble, Boolean paramBoolean) {
    this.c = paramClass;
    this.b = paramContext;
    this.d = paramDouble;
    this.f = paramBoolean;
  }
  
  public IXAdContainerFactory a() {
    if (e == null)
      try {
        e = this.c.getDeclaredConstructor(new Class[] { Context.class }).newInstance(new Object[] { this.b });
        this.a = e.getRemoteVersion();
        e.setDebugMode(this.f);
        e.handleShakeVersion(this.d, "8.8283");
      } finally {
        Exception exception = null;
        this.g.w(new Object[] { "XAdContainerFactoryBuilder", exception.getMessage() });
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("newXAdContainerFactory() failed, possibly API incompatible: ");
        stringBuilder.append(exception.getMessage());
      }  
    return e;
  }
  
  public void b() {
    e = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */