package org.chromium.support_lib_glue;

import java.lang.reflect.InvocationHandler;
import org.chromium.base.annotations.UsedByReflection;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

@UsedByReflection
public class SupportLibReflectionUtil {
  @UsedByReflection
  public static InvocationHandler createWebViewProviderFactory() {
    return BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new SupportLibWebViewChromiumFactory());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\support_lib_glue\SupportLibReflectionUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */