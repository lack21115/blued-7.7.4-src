package org.chromium.support_lib_glue;

import android.net.Uri;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import com.android.webview.chromium.SharedWebViewChromium;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.VisualStateCallbackBoundaryInterface;
import org.chromium.support_lib_boundary.WebMessageBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

final class SupportLibWebViewChromium implements WebViewProviderBoundaryInterface {
  private final SharedWebViewChromium mSharedWebViewChromium;
  
  public SupportLibWebViewChromium(SharedWebViewChromium paramSharedWebViewChromium) {
    this.mSharedWebViewChromium = paramSharedWebViewChromium;
  }
  
  public final InvocationHandler[] createWebMessageChannel() {
    return SupportLibWebMessagePortAdapter.fromMessagePorts(this.mSharedWebViewChromium.createWebMessageChannel());
  }
  
  public final WebChromeClient getWebChromeClient() {
    return this.mSharedWebViewChromium.mWebChromeClient;
  }
  
  public final WebViewClient getWebViewClient() {
    return this.mSharedWebViewChromium.mWebViewClient;
  }
  
  public final void insertVisualStateCallback(long paramLong, InvocationHandler paramInvocationHandler) {
    VisualStateCallbackBoundaryInterface visualStateCallbackBoundaryInterface = (VisualStateCallbackBoundaryInterface)BoundaryInterfaceReflectionUtil.castToSuppLibClass(VisualStateCallbackBoundaryInterface.class, paramInvocationHandler);
    this.mSharedWebViewChromium.insertVisualStateCallback(paramLong, new SupportLibWebViewChromium$1(visualStateCallbackBoundaryInterface));
  }
  
  public final void postMessageToMainFrame(InvocationHandler paramInvocationHandler, Uri paramUri) {
    WebMessageBoundaryInterface webMessageBoundaryInterface = (WebMessageBoundaryInterface)BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebMessageBoundaryInterface.class, paramInvocationHandler);
    this.mSharedWebViewChromium.postMessageToMainFrame(webMessageBoundaryInterface.getData(), paramUri.toString(), SupportLibWebMessagePortAdapter.toMessagePorts(webMessageBoundaryInterface.getPorts()));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\support_lib_glue\SupportLibWebViewChromium.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */