package org.chromium.support_lib_boundary;

import java.lang.reflect.InvocationHandler;

public interface WebMessageBoundaryInterface extends FeatureFlagHolderBoundaryInterface {
  String getData();
  
  InvocationHandler[] getPorts();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\support_lib_boundary\WebMessageBoundaryInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */