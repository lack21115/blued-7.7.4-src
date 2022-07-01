package org.chromium.mojo.bindings;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import org.chromium.mojo.system.MojoException;

public final class DelegatingConnectionErrorHandler implements ConnectionErrorHandler {
  final Set mHandlers = Collections.newSetFromMap(new WeakHashMap<Object, Boolean>());
  
  public final void onConnectionError(MojoException paramMojoException) {
    Iterator<ConnectionErrorHandler> iterator = this.mHandlers.iterator();
    while (iterator.hasNext())
      ((ConnectionErrorHandler)iterator.next()).onConnectionError(paramMojoException); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\bindings\DelegatingConnectionErrorHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */