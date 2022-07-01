package org.chromium.support_lib_boundary;

import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import java.lang.reflect.InvocationHandler;

public interface WebkitToCompatConverterBoundaryInterface {
  Object convertSafeBrowsingResponse(InvocationHandler paramInvocationHandler);
  
  InvocationHandler convertSafeBrowsingResponse(Object paramObject);
  
  Object convertServiceWorkerSettings(InvocationHandler paramInvocationHandler);
  
  InvocationHandler convertServiceWorkerSettings(Object paramObject);
  
  InvocationHandler convertSettings(WebSettings paramWebSettings);
  
  Object convertWebMessagePort(InvocationHandler paramInvocationHandler);
  
  InvocationHandler convertWebMessagePort(Object paramObject);
  
  Object convertWebResourceError(InvocationHandler paramInvocationHandler);
  
  InvocationHandler convertWebResourceError(Object paramObject);
  
  InvocationHandler convertWebResourceRequest(WebResourceRequest paramWebResourceRequest);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\support_lib_boundary\WebkitToCompatConverterBoundaryInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */