package com.baidu.mobads.f;

import android.os.Build;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.openad.d.a;
import com.baidu.mobads.openad.d.b;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.HashMap;

class l implements Runnable {
  l(k paramk) {}
  
  public void run() {
    try {
      double d;
      IXAdURIUitls iXAdURIUitls = XAdSDKFoundationFacade.getInstance().getURIUitls();
      if (this.a.a) {
        d = g.b.a;
      } else {
        d = 0.0D;
      } 
      boolean bool = this.a.a;
      m m = new m(this, d);
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("");
      stringBuilder.append(d);
      hashMap.put("v", stringBuilder.toString());
      hashMap.put("os", "android");
      hashMap.put("tp", XAdSDKFoundationFacade.getInstance().getCommonUtils().getTextEncoder(Build.MODEL));
      hashMap.put("bdr", XAdSDKFoundationFacade.getInstance().getCommonUtils().getTextEncoder(Build.VERSION.SDK));
      b b = new b(iXAdURIUitls.addParameters(g.j(), hashMap), "");
      b.e = 1;
      g.a(this.a.b, new a());
      g.i(this.a.b).addEventListener("URLLoader.Load.Complete", m);
      g.i(this.a.b).addEventListener("URLLoader.Load.Error", m);
      g.i(this.a.b).a(b);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\f\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */