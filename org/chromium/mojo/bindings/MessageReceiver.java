package org.chromium.mojo.bindings;

import java.io.Closeable;

public interface MessageReceiver extends Closeable {
  boolean accept(Message paramMessage);
  
  void close();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\bindings\MessageReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */