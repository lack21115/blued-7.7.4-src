package org.chromium.support_lib_boundary;

import android.os.Handler;
import java.lang.reflect.InvocationHandler;

public interface WebMessagePortBoundaryInterface {
  void close();
  
  void postMessage(InvocationHandler paramInvocationHandler);
  
  void setWebMessageCallback(InvocationHandler paramInvocationHandler);
  
  void setWebMessageCallback(InvocationHandler paramInvocationHandler, Handler paramHandler);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\support_lib_boundary\WebMessagePortBoundaryInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */