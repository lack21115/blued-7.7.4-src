package org.chromium.support_lib_glue;

import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import com.android.webview.chromium.ContentSettingsAdapter;
import com.android.webview.chromium.SafeBrowsingResponseAdapter;
import com.android.webview.chromium.ServiceWorkerSettingsAdapter;
import com.android.webview.chromium.WebMessagePortAdapter;
import com.android.webview.chromium.WebResourceErrorAdapter;
import com.android.webview.chromium.WebResourceRequestAdapter;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;
import org.chromium.support_lib_callback_glue.SupportLibSafeBrowsingResponse;
import org.chromium.support_lib_callback_glue.SupportLibWebResourceError;

final class SupportLibWebkitToCompatConverterAdapter implements WebkitToCompatConverterBoundaryInterface {
  public final Object convertSafeBrowsingResponse(InvocationHandler paramInvocationHandler) {
    return new SafeBrowsingResponseAdapter(((SupportLibSafeBrowsingResponse)BoundaryInterfaceReflectionUtil.getDelegateFromInvocationHandler(paramInvocationHandler)).mCallback);
  }
  
  public final InvocationHandler convertSafeBrowsingResponse(Object paramObject) {
    return BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new SupportLibSafeBrowsingResponse(((SafeBrowsingResponseAdapter)paramObject).mCallback));
  }
  
  public final Object convertServiceWorkerSettings(InvocationHandler paramInvocationHandler) {
    return new ServiceWorkerSettingsAdapter(((SupportLibServiceWorkerSettingsAdapter)BoundaryInterfaceReflectionUtil.getDelegateFromInvocationHandler(paramInvocationHandler)).mAwServiceWorkerSettings);
  }
  
  public final InvocationHandler convertServiceWorkerSettings(Object paramObject) {
    return BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new SupportLibServiceWorkerSettingsAdapter(((ServiceWorkerSettingsAdapter)paramObject).mAwServiceWorkerSettings));
  }
  
  public final InvocationHandler convertSettings(WebSettings paramWebSettings) {
    return BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new SupportLibWebSettingsAdapter(((ContentSettingsAdapter)paramWebSettings).mAwSettings));
  }
  
  public final Object convertWebMessagePort(InvocationHandler paramInvocationHandler) {
    return new WebMessagePortAdapter(((SupportLibWebMessagePortAdapter)BoundaryInterfaceReflectionUtil.getDelegateFromInvocationHandler(paramInvocationHandler)).mPort);
  }
  
  public final InvocationHandler convertWebMessagePort(Object paramObject) {
    return BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new SupportLibWebMessagePortAdapter(((WebMessagePortAdapter)paramObject).mPort));
  }
  
  public final Object convertWebResourceError(InvocationHandler paramInvocationHandler) {
    return new WebResourceErrorAdapter(((SupportLibWebResourceError)BoundaryInterfaceReflectionUtil.getDelegateFromInvocationHandler(paramInvocationHandler)).mError);
  }
  
  public final InvocationHandler convertWebResourceError(Object paramObject) {
    return BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new SupportLibWebResourceError(((WebResourceErrorAdapter)paramObject).mError));
  }
  
  public final InvocationHandler convertWebResourceRequest(WebResourceRequest paramWebResourceRequest) {
    return BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new SupportLibWebResourceRequest(((WebResourceRequestAdapter)paramWebResourceRequest).mRequest));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\support_lib_glue\SupportLibWebkitToCompatConverterAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */