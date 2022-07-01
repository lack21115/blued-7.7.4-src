package com.baidu.mobads.production.b;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobads.e.a;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.production.b;
import com.baidu.mobads.production.u;
import com.baidu.mobads.vo.c;
import com.baidu.mobads.vo.d;
import java.util.HashMap;

public class b extends b implements IXNonLinearAdSlot {
  private d y;
  
  public b(Context paramContext, RelativeLayout paramRelativeLayout, String paramString, int paramInt) {
    super(paramContext);
    setActivity(paramContext);
    setAdSlotBase(paramRelativeLayout);
    this.o = IXAdConstants4PDK.SlotType.SLOT_TYPE_CPU;
    this.y = new d(getApplicationContext(), getActivity(), this.o, paramString, paramInt);
  }
  
  public b(Context paramContext, RelativeLayout paramRelativeLayout, String paramString1, String paramString2) {
    super(paramContext);
    setActivity(paramContext);
    setAdSlotBase(paramRelativeLayout);
    this.o = IXAdConstants4PDK.SlotType.SLOT_TYPE_CPU;
    this.y = new d(getApplicationContext(), getActivity(), this.o, paramString1, paramString2);
  }
  
  public d a() {
    return this.y;
  }
  
  public void a(IXAdContainer paramIXAdContainer, HashMap<String, Object> paramHashMap) {
    start();
  }
  
  public void a(com.baidu.mobads.openad.d.b paramb, u paramu, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("{'ad':[{'id':99999999,'html':'");
    stringBuilder.append(this.y.c());
    stringBuilder.append("', type='");
    stringBuilder.append(IXAdInstanceInfo.CreativeType.HTML.getValue());
    stringBuilder.append("'}],'n':1}");
    String str = stringBuilder.toString();
    try {
      setAdResponseInfo((IXAdResponseInfo)new c(str));
    } catch (Exception exception) {}
    b("XAdMouldeLoader ad-server requesting success");
  }
  
  public void b(IXAdContainer paramIXAdContainer, HashMap<String, Object> paramHashMap) {}
  
  public void b(IXAdResponseInfo paramIXAdResponseInfo) {}
  
  public void b(d paramd) {
    this.k = paramd;
    m();
    a((com.baidu.mobads.openad.d.b)null, (u)null, 5000);
  }
  
  public void c() {
    load();
  }
  
  public void d() {
    this.m = 10000;
  }
  
  public void e(IXAdContainer paramIXAdContainer, HashMap<String, Object> paramHashMap) {
    r();
    dispatchEvent((IOAdEvent)new a("AdUserClose"));
  }
  
  public void request() {
    a(this.y);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\production\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */