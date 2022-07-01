package com.baidu.mobads.command.b;

import com.baidu.mobads.command.b;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdResource;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;

public class a extends b {
  private String f = null;
  
  public a(IXNonLinearAdSlot paramIXNonLinearAdSlot, IXAdInstanceInfo paramIXAdInstanceInfo, IXAdResource paramIXAdResource, String paramString) {
    super(paramIXNonLinearAdSlot, paramIXAdInstanceInfo, paramIXAdResource);
    this.f = paramString;
  }
  
  public void a() {
    XAdSDKFoundationFacade.getInstance().getCommonUtils().browserOutside(this.a, this.f);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\command\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */