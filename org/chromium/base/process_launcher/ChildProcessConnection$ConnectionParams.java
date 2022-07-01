package org.chromium.base.process_launcher;

import android.os.Bundle;
import java.util.List;

final class ChildProcessConnection$ConnectionParams {
  final List mClientInterfaces;
  
  final Bundle mConnectionBundle;
  
  ChildProcessConnection$ConnectionParams(Bundle paramBundle, List paramList) {
    this.mConnectionBundle = paramBundle;
    this.mClientInterfaces = paramList;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\process_launcher\ChildProcessConnection$ConnectionParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */