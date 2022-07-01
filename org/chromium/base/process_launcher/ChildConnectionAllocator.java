package org.chromium.base.process_launcher;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class ChildConnectionAllocator {
  private final boolean mBindAsExternalService;
  
  private final boolean mBindToCaller;
  
  public final ChildProcessConnection[] mChildProcessConnections;
  
  public ChildConnectionAllocator$ConnectionFactory mConnectionFactory;
  
  final ArrayList mFreeConnectionIndices;
  
  final Runnable mFreeSlotCallback;
  
  private final Handler mLauncherHandler;
  
  private final String mPackageName;
  
  final Queue mPendingAllocations = new ArrayDeque();
  
  private final String mServiceClassName;
  
  private final boolean mUseStrongBinding;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private ChildConnectionAllocator(Handler paramHandler, Runnable paramRunnable, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt) {
    int i = 0;
    this.mConnectionFactory = new ChildConnectionAllocator$ConnectionFactoryImpl((byte)0);
    this.mFreeSlotCallback = paramRunnable;
    this.mLauncherHandler = paramHandler;
    assert false;
    throw new AssertionError();
  }
  
  public static ChildConnectionAllocator create(Context paramContext, Handler paramHandler, Runnable paramRunnable, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    PackageManager packageManager = paramContext.getPackageManager();
    try {
      byte b;
      ApplicationInfo applicationInfo = packageManager.getApplicationInfo(paramString1, 128);
      if (applicationInfo.metaData != null) {
        b = applicationInfo.metaData.getInt(paramString3, -1);
      } else {
        b = -1;
      } 
      if (b >= 0)
        try {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramString2);
          stringBuilder.append("0");
          packageManager.getServiceInfo(new ComponentName(paramString1, stringBuilder.toString()), 0);
          return new ChildConnectionAllocator(paramHandler, paramRunnable, paramString1, paramString2, paramBoolean1, paramBoolean2, paramBoolean3, b);
        } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
          throw new RuntimeException("Illegal meta data value: the child service doesn't exist");
        }  
      throw new RuntimeException("Illegal meta data value for number of child services");
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      throw new RuntimeException("Could not get application info.");
    } 
  }
  
  public static ChildConnectionAllocator createForTest(Runnable paramRunnable, String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    return new ChildConnectionAllocator(new Handler(), paramRunnable, paramString1, paramString2, paramBoolean1, paramBoolean2, paramBoolean3, paramInt);
  }
  
  private boolean isRunningOnLauncherThread() {
    return (this.mLauncherHandler.getLooper() == Looper.myLooper());
  }
  
  public final ChildProcessConnection allocate(Context paramContext, Bundle paramBundle, ChildProcessConnection$ServiceCallback paramChildProcessConnection$ServiceCallback) {
    assert false;
    throw new AssertionError();
  }
  
  public final boolean isConnectionFromAllocator(ChildProcessConnection paramChildProcessConnection) {
    ChildProcessConnection[] arrayOfChildProcessConnection = this.mChildProcessConnections;
    int j = arrayOfChildProcessConnection.length;
    for (int i = 0; i < j; i++) {
      if (arrayOfChildProcessConnection[i] == paramChildProcessConnection)
        return true; 
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\process_launcher\ChildConnectionAllocator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */