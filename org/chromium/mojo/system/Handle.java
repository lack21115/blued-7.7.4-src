package org.chromium.mojo.system;

import java.io.Closeable;

public interface Handle extends Closeable {
  void close();
  
  Core getCore();
  
  boolean isValid();
  
  int releaseNativeHandle();
  
  UntypedHandle toUntypedHandle();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\system\Handle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */