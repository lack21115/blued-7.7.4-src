package org.chromium.support_lib_glue;

import java.lang.reflect.InvocationHandler;
import org.chromium.android_webview.AwServiceWorkerController;
import org.chromium.support_lib_boundary.ServiceWorkerClientBoundaryInterface;
import org.chromium.support_lib_boundary.ServiceWorkerControllerBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

final class SupportLibServiceWorkerControllerAdapter implements ServiceWorkerControllerBoundaryInterface {
  private AwServiceWorkerController mAwServiceWorkerController;
  
  SupportLibServiceWorkerControllerAdapter(AwServiceWorkerController paramAwServiceWorkerController) {
    this.mAwServiceWorkerController = paramAwServiceWorkerController;
  }
  
  public final InvocationHandler getServiceWorkerWebSettings() {
    return BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new SupportLibServiceWorkerSettingsAdapter(this.mAwServiceWorkerController.mServiceWorkerSettings));
  }
  
  public final void setServiceWorkerClient(InvocationHandler paramInvocationHandler) {
    this.mAwServiceWorkerController.setServiceWorkerClient(new SupportLibServiceWorkerClientAdapter((ServiceWorkerClientBoundaryInterface)BoundaryInterfaceReflectionUtil.castToSuppLibClass(ServiceWorkerClientBoundaryInterface.class, paramInvocationHandler)));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\support_lib_glue\SupportLibServiceWorkerControllerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */