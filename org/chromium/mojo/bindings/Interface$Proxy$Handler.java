package org.chromium.mojo.bindings;

import java.io.Closeable;
import org.chromium.mojo.system.MessagePipeHandle;

public interface Interface$Proxy$Handler extends Closeable {
  int getVersion();
  
  MessagePipeHandle passHandle();
  
  void setErrorHandler(ConnectionErrorHandler paramConnectionErrorHandler);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\bindings\Interface$Proxy$Handler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */