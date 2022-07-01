package org.chromium.base.process_launcher;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import java.util.List;

public interface ChildProcessServiceDelegate {
  SparseArray getFileDescriptorsIdsToKeys();
  
  boolean loadNativeLibrary(Context paramContext);
  
  void onBeforeMain();
  
  void onConnectionSetup(Bundle paramBundle, List paramList);
  
  void onDestroy();
  
  void onServiceBound(Intent paramIntent);
  
  void preloadNativeLibrary$faab20d();
  
  void runMain();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\process_launcher\ChildProcessServiceDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */