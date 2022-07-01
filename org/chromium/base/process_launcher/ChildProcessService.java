package org.chromium.base.process_launcher;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import java.util.List;
import java.util.concurrent.Semaphore;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.build.BuildHooksAndroid;

public abstract class ChildProcessService extends Service {
  private static boolean sCreateCalled;
  
  private final Semaphore mActivitySemaphore = new Semaphore(1);
  
  private boolean mBindToCallerCheck;
  
  private final IChildProcessService$Stub mBinder = new ChildProcessService$1(this);
  
  private final Object mBinderLock = new Object();
  
  private int mBoundCallingPid;
  
  private String[] mCommandLineParams;
  
  final ChildProcessServiceDelegate mDelegate;
  
  private FileDescriptorInfo[] mFdInfos;
  
  private boolean mLibraryInitialized;
  
  private final Object mLibraryInitializedLock = new Object();
  
  private Thread mMainThread;
  
  private boolean mServiceBound;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public ChildProcessService(ChildProcessServiceDelegate paramChildProcessServiceDelegate) {
    this.mDelegate = paramChildProcessServiceDelegate;
  }
  
  private static native void nativeExitChildProcess();
  
  private static native void nativeRegisterFileDescriptors(String[] paramArrayOfString, int[] paramArrayOfint1, int[] paramArrayOfint2, long[] paramArrayOflong1, long[] paramArrayOflong2);
  
  public Context createConfigurationContext(Configuration paramConfiguration) {
    if (Build.VERSION.SDK_INT < 17)
      return null; 
    if (!BuildHooksAndroid.isEnabled())
      return super.createConfigurationContext(paramConfiguration); 
    super.createConfigurationContext(paramConfiguration);
    return BuildHooksAndroid.createConfigurationContext$6263c3eb();
  }
  
  public AssetManager getAssets() {
    return !BuildHooksAndroid.isEnabled() ? super.getAssets() : BuildHooksAndroid.getAssets$49f66a90();
  }
  
  public Resources getResources() {
    return !BuildHooksAndroid.isEnabled() ? super.getResources() : BuildHooksAndroid.getResources$177d0c3c();
  }
  
  public Resources.Theme getTheme() {
    return !BuildHooksAndroid.isEnabled() ? super.getTheme() : BuildHooksAndroid.getTheme$21e91261();
  }
  
  public IBinder onBind(Intent paramIntent) {
    assert false;
    throw new AssertionError();
  }
  
  public void onCreate() {
    super.onCreate();
    Log.i("ChildProcessService", "Creating new ChildProcessService pid=%d", new Object[] { Integer.valueOf(Process.myPid()) });
    if (!sCreateCalled) {
      sCreateCalled = true;
      ContextUtils.initApplicationContext(getApplicationContext());
      this.mMainThread = new Thread(new ChildProcessService$2(this), "ChildProcessMain");
      this.mMainThread.start();
      return;
    } 
    throw new RuntimeException("Illegal child process reuse.");
  }
  
  public void onDestroy() {
    super.onDestroy();
    Log.i("ChildProcessService", "Destroying ChildProcessService pid=%d", new Object[] { Integer.valueOf(Process.myPid()) });
    if (this.mActivitySemaphore.tryAcquire()) {
      System.exit(0);
      return;
    } 
    Object object = this.mLibraryInitializedLock;
    /* monitor enter ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
    try {
      while (!this.mLibraryInitialized)
        this.mLibraryInitializedLock.wait(); 
    } catch (InterruptedException interruptedException) {
    
    } finally {
      Exception exception;
    } 
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
    this.mDelegate.onDestroy();
  }
  
  public void setTheme(int paramInt) {
    if (!BuildHooksAndroid.isEnabled()) {
      super.setTheme(paramInt);
      return;
    } 
    BuildHooksAndroid.get();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\process_launcher\ChildProcessService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */