package com.android.webview.chromium;

import android.webkit.ClientCertRequest;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import org.chromium.android_webview.AwContentsClientBridge;
import org.chromium.base.ThreadUtils;

final class WebViewContentsClientAdapter$ClientCertRequestImpl extends ClientCertRequest {
  private final AwContentsClientBridge.ClientCertificateRequestCallback mCallback;
  
  private final String mHost;
  
  private final String[] mKeyTypes;
  
  private final int mPort;
  
  private final Principal[] mPrincipals;
  
  public WebViewContentsClientAdapter$ClientCertRequestImpl(AwContentsClientBridge.ClientCertificateRequestCallback paramClientCertificateRequestCallback, String[] paramArrayOfString, Principal[] paramArrayOfPrincipal, String paramString, int paramInt) {
    this.mCallback = paramClientCertificateRequestCallback;
    this.mKeyTypes = paramArrayOfString;
    this.mPrincipals = paramArrayOfPrincipal;
    this.mHost = paramString;
    this.mPort = paramInt;
  }
  
  public final void cancel() {
    ThreadUtils.runOnUiThread((Runnable)new Object(this.mCallback));
  }
  
  public final String getHost() {
    return this.mHost;
  }
  
  public final String[] getKeyTypes() {
    return this.mKeyTypes;
  }
  
  public final int getPort() {
    return this.mPort;
  }
  
  public final Principal[] getPrincipals() {
    return this.mPrincipals;
  }
  
  public final void ignore() {
    ThreadUtils.runOnUiThread((Runnable)new Object(this.mCallback));
  }
  
  public final void proceed(PrivateKey paramPrivateKey, X509Certificate[] paramArrayOfX509Certificate) {
    ThreadUtils.runOnUiThread((Runnable)new Object(this.mCallback, paramPrivateKey, paramArrayOfX509Certificate));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\WebViewContentsClientAdapter$ClientCertRequestImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */