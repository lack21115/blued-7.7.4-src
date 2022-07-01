package org.chromium.base.process_launcher;

import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;

final class ChildConnectionAllocator$ConnectionFactoryImpl implements ChildConnectionAllocator$ConnectionFactory {
  private ChildConnectionAllocator$ConnectionFactoryImpl() {}
  
  public final ChildProcessConnection createConnection(Context paramContext, ComponentName paramComponentName, boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle) {
    return new ChildProcessConnection(paramContext, paramComponentName, paramBoolean1, paramBoolean2, paramBundle);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\process_launcher\ChildConnectionAllocator$ConnectionFactoryImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */