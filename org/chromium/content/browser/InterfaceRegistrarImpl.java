package org.chromium.content.browser;

import org.chromium.base.ContextUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.content_public.browser.InterfaceRegistrar;
import org.chromium.content_public.browser.RenderFrameHost;
import org.chromium.content_public.browser.WebContents;
import org.chromium.mojo.system.impl.CoreImpl;
import org.chromium.services.service_manager.InterfaceRegistry;

class InterfaceRegistrarImpl {
  private static boolean sHasRegisteredRegistrars;
  
  @CalledByNative
  static void createInterfaceRegistryForContext(int paramInt) {
    ensureContentRegistrarsAreRegistered();
    InterfaceRegistry interfaceRegistry = InterfaceRegistry.create(CoreImpl.getInstance().acquireNativeHandle(paramInt).toMessagePipeHandle());
    if (InterfaceRegistrar.Registry.sContextRegistry != null)
      InterfaceRegistrar.Registry.sContextRegistry.applyRegistrars(interfaceRegistry, ContextUtils.sApplicationContext); 
  }
  
  @CalledByNative
  static void createInterfaceRegistryForRenderFrameHost(int paramInt, RenderFrameHost paramRenderFrameHost) {
    ensureContentRegistrarsAreRegistered();
    InterfaceRegistry interfaceRegistry = InterfaceRegistry.create(CoreImpl.getInstance().acquireNativeHandle(paramInt).toMessagePipeHandle());
    if (InterfaceRegistrar.Registry.sRenderFrameHostRegistry != null)
      InterfaceRegistrar.Registry.sRenderFrameHostRegistry.applyRegistrars(interfaceRegistry, paramRenderFrameHost); 
  }
  
  @CalledByNative
  static void createInterfaceRegistryForWebContents(int paramInt, WebContents paramWebContents) {
    ensureContentRegistrarsAreRegistered();
    InterfaceRegistry interfaceRegistry = InterfaceRegistry.create(CoreImpl.getInstance().acquireNativeHandle(paramInt).toMessagePipeHandle());
    if (InterfaceRegistrar.Registry.sWebContentsRegistry != null)
      InterfaceRegistrar.Registry.sWebContentsRegistry.applyRegistrars(interfaceRegistry, paramWebContents); 
  }
  
  private static void ensureContentRegistrarsAreRegistered() {
    if (sHasRegisteredRegistrars)
      return; 
    sHasRegisteredRegistrars = true;
    InterfaceRegistrarImpl$ContentContextInterfaceRegistrar interfaceRegistrarImpl$ContentContextInterfaceRegistrar = new InterfaceRegistrarImpl$ContentContextInterfaceRegistrar((byte)0);
    if (InterfaceRegistrar.Registry.sContextRegistry == null)
      InterfaceRegistrar.Registry.sContextRegistry = new InterfaceRegistrar.Registry(); 
    InterfaceRegistrar.Registry.sContextRegistry.mRegistrars.add(interfaceRegistrarImpl$ContentContextInterfaceRegistrar);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\InterfaceRegistrarImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */