package com.huawei.hms.framework.network.grs;

import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.restclient.hianalytics.RCEventListener;
import com.huawei.hms.framework.network.restclient.hwhttp.Interceptor;
import com.huawei.hms.framework.network.restclient.hwhttp.RealInterceptorChain;
import com.huawei.hms.framework.network.restclient.hwhttp.Request;
import com.huawei.hms.framework.network.restclient.hwhttp.Response;
import com.huawei.hms.framework.network.restclient.hwhttp.plugin.PluginInterceptor;
import com.huawei.hms.framework.network.restclient.hwhttp.url.HttpUrl;

public class f implements PluginInterceptor {
  private static final String a = "f";
  
  public Response intercept(Interceptor.Chain paramChain) {
    RealInterceptorChain realInterceptorChain = (RealInterceptorChain)paramChain;
    Request request = realInterceptorChain.request();
    String str = request.getUrl().getUrl();
    if (GrsManager.isGRSSchema(str)) {
      Logger.v(a, "request url is grs schema.");
      RCEventListener rCEventListener = realInterceptorChain.getRCEventListener();
      rCEventListener.convertGrsStart(str);
      str = GrsManager.getInstance().parseGrs(str);
      request = request.newBuilder().url(new HttpUrl(str)).build();
      Logger.v(a, "origin url is grs schema and by intercepted,and now request is:%s", new Object[] { request.toString() });
      rCEventListener.convertGrsEnd(str);
      return realInterceptorChain.proceed(request);
    } 
    return realInterceptorChain.proceed(request);
  }
  
  public String pluginName() {
    return f.class.getSimpleName();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\network\grs\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */