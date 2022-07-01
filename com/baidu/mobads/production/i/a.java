package com.baidu.mobads.production.i;

import android.content.Context;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobads.AdSize;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdProd;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.production.c.c;
import com.baidu.mobads.vo.d;

public class a extends c {
  private com.baidu.mobads.production.h.a y;
  
  public a(Context paramContext, String paramString) {
    super(paramContext);
    setId(paramString);
    setActivity(paramContext);
    setAdSlotBase(null);
    this.o = IXAdConstants4PDK.SlotType.SLOT_TYPE_PREROLL;
    this.y = new com.baidu.mobads.production.h.a(getApplicationContext(), getActivity(), IXAdConstants4PDK.SlotType.SLOT_TYPE_PREROLL, (IXAdProd)this);
    this.y.f(AdSize.PrerollVideoNative.getValue());
    this.y.d(paramString);
  }
  
  public void a(RequestParameters paramRequestParameters) {
    int i = paramRequestParameters.getWidth();
    int j = paramRequestParameters.getHeight();
    if (i > 0 && j > 0) {
      this.y.d(i);
      this.y.e(j);
    } 
  }
  
  public d b() {
    return (d)this.y;
  }
  
  public void request() {
    a((d)this.y);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\production\i\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */