package org.chromium.mojo.system;

public interface Watcher {
  void cancel();
  
  void destroy();
  
  int start(Handle paramHandle, Core$HandleSignals paramCore$HandleSignals, Watcher$Callback paramWatcher$Callback);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\system\Watcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */