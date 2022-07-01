package com.baidu.mobad.video;

import com.baidu.mobads.interfaces.IXAdEvent4PDK;
import com.baidu.mobads.interfaces.IXAdProd;
import com.baidu.mobads.openad.c.b;
import java.util.HashMap;

public class XAdEvent4PDK extends b implements IXAdEvent4PDK {
  private IXAdProd a;
  
  public XAdEvent4PDK(String paramString, int paramInt, IXAdProd paramIXAdProd) {
    super(paramString, paramInt);
    this.a = paramIXAdProd;
  }
  
  public XAdEvent4PDK(String paramString1, int paramInt, String paramString2, IXAdProd paramIXAdProd) {
    super(paramString1, paramInt, paramString2);
    this.a = paramIXAdProd;
  }
  
  public XAdEvent4PDK(String paramString, int paramInt, HashMap<String, Object> paramHashMap, IXAdProd paramIXAdProd) {
    super(paramString, paramInt, paramHashMap);
    this.a = paramIXAdProd;
  }
  
  public XAdEvent4PDK(String paramString, IXAdProd paramIXAdProd) {
    super(paramString);
    this.a = paramIXAdProd;
  }
  
  public XAdEvent4PDK(String paramString1, String paramString2, IXAdProd paramIXAdProd) {
    super(paramString1, paramString2);
    this.a = paramIXAdProd;
  }
  
  public XAdEvent4PDK(String paramString, HashMap<String, Object> paramHashMap, IXAdProd paramIXAdProd) {
    super(paramString, paramHashMap);
    this.a = paramIXAdProd;
  }
  
  public IXAdProd getAdSlot() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobad\video\XAdEvent4PDK.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */