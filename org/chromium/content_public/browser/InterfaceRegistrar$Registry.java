package org.chromium.content_public.browser;

import java.util.ArrayList;
import java.util.List;
import org.chromium.services.service_manager.InterfaceRegistry;

public final class InterfaceRegistrar$Registry {
  public static InterfaceRegistrar$Registry sContextRegistry;
  
  public static InterfaceRegistrar$Registry sRenderFrameHostRegistry;
  
  public static InterfaceRegistrar$Registry sWebContentsRegistry;
  
  public List mRegistrars = new ArrayList();
  
  public final void applyRegistrars(InterfaceRegistry paramInterfaceRegistry, Object paramObject) {
    paramObject = this.mRegistrars.iterator();
    while (paramObject.hasNext())
      ((InterfaceRegistrar)paramObject.next()).registerInterfaces$360607a1(paramInterfaceRegistry); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content_public\browser\InterfaceRegistrar$Registry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */