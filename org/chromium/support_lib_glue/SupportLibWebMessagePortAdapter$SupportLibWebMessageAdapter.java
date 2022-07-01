package org.chromium.support_lib_glue;

import java.lang.reflect.InvocationHandler;
import org.chromium.content_public.browser.MessagePort;
import org.chromium.support_lib_boundary.WebMessageBoundaryInterface;

final class SupportLibWebMessagePortAdapter$SupportLibWebMessageAdapter implements WebMessageBoundaryInterface {
  private String mData;
  
  private MessagePort[] mPorts;
  
  SupportLibWebMessagePortAdapter$SupportLibWebMessageAdapter(String paramString, MessagePort[] paramArrayOfMessagePort) {
    this.mData = paramString;
    this.mPorts = paramArrayOfMessagePort;
  }
  
  public final String getData() {
    return this.mData;
  }
  
  public final InvocationHandler[] getPorts() {
    return SupportLibWebMessagePortAdapter.fromMessagePorts(this.mPorts);
  }
  
  public final String[] getSupportedFeatures() {
    return new String[0];
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\support_lib_glue\SupportLibWebMessagePortAdapter$SupportLibWebMessageAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */