package org.chromium.support_lib_glue;

import org.chromium.support_lib_boundary.WebMessageCallbackBoundaryInterface;

final class SupportLibWebMessageCallbackAdapter {
  WebMessageCallbackBoundaryInterface mImpl;
  
  SupportLibWebMessageCallbackAdapter(WebMessageCallbackBoundaryInterface paramWebMessageCallbackBoundaryInterface) {
    this.mImpl = paramWebMessageCallbackBoundaryInterface;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\support_lib_glue\SupportLibWebMessageCallbackAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */