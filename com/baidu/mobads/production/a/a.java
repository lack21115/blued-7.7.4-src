package com.baidu.mobads.production.a;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobads.AdSize;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.openad.d.b;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.production.b;
import com.baidu.mobads.production.u;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.e;
import com.baidu.mobads.vo.b;
import com.baidu.mobads.vo.c;
import com.baidu.mobads.vo.d;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends b implements IXNonLinearAdSlot {
  private c y;
  
  public a(Context paramContext, RelativeLayout paramRelativeLayout, String paramString, boolean paramBoolean) {
    super(paramContext);
    setId(paramString);
    setActivity(paramContext);
    setAdSlotBase(paramRelativeLayout);
    this.o = IXAdConstants4PDK.SlotType.SLOT_TYPE_BANNER;
    XAdSDKFoundationFacade.getInstance().getAdConstants();
    this.y = new c(getApplicationContext(), getActivity(), this.o);
    this.y.f(AdSize.Banner.getValue());
    this.y.d(paramString);
    b b1 = (b)this.y.d();
    b1.a(paramBoolean);
    JSONObject jSONObject2 = b1.getAttribute();
    JSONObject jSONObject1 = jSONObject2;
    if (jSONObject2 == null)
      jSONObject1 = new JSONObject(); 
    try {
      jSONObject1.put("ABILITY", "BANNER_CLOSE,PAUSE,UNLIMITED_BANNER_SIZE,");
    } catch (JSONException jSONException) {}
    b1.a(jSONObject1);
    f(paramString);
  }
  
  public d a() {
    return this.y;
  }
  
  public void a(IXAdContainer paramIXAdContainer, HashMap<String, Object> paramHashMap) {
    start();
  }
  
  public void a(b paramb, u paramu, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("{'ad':[{'id':99999999,'url':'");
    stringBuilder.append(this.y.b());
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
    a((b)null, (u)null, 5000);
  }
  
  public void c() {
    load();
  }
  
  public void d() {
    this.m = 10000;
  }
  
  public void e(IXAdContainer paramIXAdContainer, HashMap<String, Object> paramHashMap) {
    r();
    dispatchEvent((IOAdEvent)new com.baidu.mobads.e.a("AdUserClose"));
  }
  
  public void g() {
    (new Thread(new b(this))).start();
  }
  
  public void request() {
    a(this.y);
    try {
      e.a(getActivity(), getActivity().getBaseContext());
      return;
    } catch (Exception exception) {
      (new HashMap<String, String>()).put("error_message", "init webview,exception");
      dispatchEvent((IOAdEvent)new com.baidu.mobads.e.a("AdError"));
      return;
    } catch (Error error) {
      (new HashMap<String, String>()).put("error_message", "init webview,error");
      dispatchEvent((IOAdEvent)new com.baidu.mobads.e.a("AdError"));
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\production\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */