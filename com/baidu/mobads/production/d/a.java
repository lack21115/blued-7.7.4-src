package com.baidu.mobads.production.d;

import android.content.Context;
import android.webkit.WebView;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.interfaces.IXHybridAdRenderer;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.openad.d.b;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.production.b;
import com.baidu.mobads.production.u;
import com.baidu.mobads.vo.c;
import com.baidu.mobads.vo.d;
import java.util.HashMap;
import org.json.JSONException;

public class a extends b implements IXNonLinearAdSlot {
  private WebView A;
  
  private c y;
  
  private IXHybridAdRenderer z;
  
  public a(WebView paramWebView) {
    super(paramWebView.getContext());
    this.A = paramWebView;
    setActivity(paramWebView.getContext());
    this.o = IXAdConstants4PDK.SlotType.SLOT_TYPE_JSSDK;
    this.y = new c(getApplicationContext(), getActivity(), this.o);
  }
  
  public d a() {
    return this.y;
  }
  
  public void a(IXAdContainer paramIXAdContainer, HashMap<String, Object> paramHashMap) {
    try {
      this.z = (IXHybridAdRenderer)this.h;
      this.z.setCustomerWebView(this.A);
    } catch (Exception exception) {
      this.z = null;
    } 
    start();
  }
  
  public void a(b paramb, u paramu, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("{'ad':[{'id':99999999,'url':'");
    stringBuilder.append(this.y.b());
    stringBuilder.append("', type='");
    stringBuilder.append(IXAdInstanceInfo.CreativeType.HYBRID.getValue());
    stringBuilder.append("'}],'n':1}");
    String str = stringBuilder.toString();
    try {
      setAdResponseInfo((IXAdResponseInfo)new c(str));
    } catch (JSONException jSONException) {}
    b("XAdMouldeLoader ad-server requesting success");
  }
  
  public boolean a(WebView paramWebView, String paramString) {
    IXHybridAdRenderer iXHybridAdRenderer = this.z;
    return (iXHybridAdRenderer == null) ? false : iXHybridAdRenderer.shouldOverrideUrlLoading(paramWebView, paramString);
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
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\production\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */