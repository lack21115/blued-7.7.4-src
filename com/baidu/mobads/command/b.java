package com.baidu.mobads.command;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdResource;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;

public abstract class b {
  protected Context a;
  
  protected IXNonLinearAdSlot b;
  
  protected IXAdInstanceInfo c;
  
  protected IXAdResource d;
  
  protected IXAdLogger e = XAdSDKFoundationFacade.getInstance().getAdLogger();
  
  public b(IXNonLinearAdSlot paramIXNonLinearAdSlot, IXAdInstanceInfo paramIXAdInstanceInfo, IXAdResource paramIXAdResource) {
    this.b = paramIXNonLinearAdSlot;
    if (paramIXNonLinearAdSlot != null) {
      this.a = paramIXNonLinearAdSlot.getApplicationContext();
    } else {
      this.a = XAdSDKFoundationFacade.getInstance().getApplicationContext();
    } 
    this.c = paramIXAdInstanceInfo;
    this.d = paramIXAdResource;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\command\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */