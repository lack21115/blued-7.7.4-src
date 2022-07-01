package org.chromium.content.browser;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import java.util.Map;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.process_launcher.ChildConnectionAllocator;
import org.chromium.base.process_launcher.ChildProcessConnection;
import org.chromium.base.process_launcher.ChildProcessLauncher;
import org.chromium.base.process_launcher.FileDescriptorInfo;
import org.chromium.base.process_launcher.IChildProcessService;

public final class ChildProcessLauncherHelperImpl {
  private static BindingManager sBindingManager;
  
  private static final Map sLauncherByPid;
  
  private static boolean sLinkerInitialized;
  
  private static long sLinkerLoadAddress;
  
  private static ChildConnectionAllocator sPrivilegedChildConnectionAllocator;
  
  private static ChildConnectionAllocator sSandboxedChildConnectionAllocator;
  
  private static ChildProcessRanking sSandboxedChildConnectionRanking;
  
  private static ChildConnectionAllocator.ConnectionFactory sSandboxedServiceFactoryForTesting;
  
  private static int sSandboxedServicesCountForTesting;
  
  private static String sSandboxedServicesNameForTesting;
  
  private static SpareChildConnection sSpareSandboxedConnection;
  
  private int mEffectiveImportance = 1;
  
  private final ChildProcessLauncher mLauncher;
  
  private final ChildProcessLauncher.Delegate mLauncherDelegate = new ChildProcessLauncherHelperImpl$1(this);
  
  private long mNativeChildProcessLauncherHelper;
  
  private final ChildProcessRanking mRanking;
  
  private final boolean mUseBindingManager;
  
  private boolean mVisible;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private ChildProcessLauncherHelperImpl(long paramLong, String[] paramArrayOfString, FileDescriptorInfo[] paramArrayOfFileDescriptorInfo, boolean paramBoolean, IBinder paramIBinder) {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private static ChildProcessLauncherHelperImpl createAndStart(long paramLong, String[] paramArrayOfString, FileDescriptorInfo[] paramArrayOfFileDescriptorInfo) {
    // Byte code:
    //   0: getstatic org/chromium/content/browser/ChildProcessLauncherHelperImpl.$assertionsDisabled : Z
    //   3: ifne -> 23
    //   6: invokestatic runningOnLauncherThread : ()Z
    //   9: ifeq -> 15
    //   12: goto -> 23
    //   15: new java/lang/AssertionError
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: athrow
    //   23: aload_2
    //   24: ldc 'type'
    //   26: invokestatic getSwitchValue : ([Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   29: astore #5
    //   31: ldc 'renderer'
    //   33: aload #5
    //   35: invokevirtual equals : (Ljava/lang/Object;)Z
    //   38: ifne -> 101
    //   41: ldc 'gpu-process'
    //   43: aload #5
    //   45: invokevirtual equals : (Ljava/lang/Object;)Z
    //   48: ifeq -> 57
    //   51: iconst_0
    //   52: istore #4
    //   54: goto -> 104
    //   57: getstatic org/chromium/content/browser/ChildProcessLauncherHelperImpl.$assertionsDisabled : Z
    //   60: ifne -> 84
    //   63: ldc 'utility'
    //   65: aload #5
    //   67: invokevirtual equals : (Ljava/lang/Object;)Z
    //   70: ifeq -> 76
    //   73: goto -> 84
    //   76: new java/lang/AssertionError
    //   79: dup
    //   80: invokespecial <init> : ()V
    //   83: athrow
    //   84: ldc 'network'
    //   86: aload_2
    //   87: ldc 'service-sandbox-type'
    //   89: invokestatic getSwitchValue : ([Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   92: invokevirtual equals : (Ljava/lang/Object;)Z
    //   95: ifeq -> 101
    //   98: goto -> 51
    //   101: iconst_1
    //   102: istore #4
    //   104: ldc 'gpu-process'
    //   106: aload #5
    //   108: invokevirtual equals : (Ljava/lang/Object;)Z
    //   111: ifeq -> 126
    //   114: new org/chromium/content/browser/GpuProcessCallback
    //   117: dup
    //   118: invokespecial <init> : ()V
    //   121: astore #5
    //   123: goto -> 132
    //   126: aconst_null
    //   127: astore #5
    //   129: goto -> 123
    //   132: new org/chromium/content/browser/ChildProcessLauncherHelperImpl
    //   135: dup
    //   136: lload_0
    //   137: aload_2
    //   138: aload_3
    //   139: iload #4
    //   141: aload #5
    //   143: invokespecial <init> : (J[Ljava/lang/String;[Lorg/chromium/base/process_launcher/FileDescriptorInfo;ZLandroid/os/IBinder;)V
    //   146: astore_2
    //   147: aload_2
    //   148: getfield mLauncher : Lorg/chromium/base/process_launcher/ChildProcessLauncher;
    //   151: iconst_1
    //   152: iconst_1
    //   153: invokevirtual start : (ZZ)Z
    //   156: pop
    //   157: aload_2
    //   158: areturn
  }
  
  private static BindingManager getBindingManager() {
    assert false;
    throw new AssertionError();
  }
  
  private static ChildProcessLauncherHelperImpl getByPid(int paramInt) {
    return (ChildProcessLauncherHelperImpl)sLauncherByPid.get(Integer.valueOf(paramInt));
  }
  
  private static ChildConnectionAllocator getConnectionAllocator(Context paramContext, boolean paramBoolean) {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private void getTerminationInfo(long paramLong) {
    ChildProcessConnection childProcessConnection = this.mLauncher.mConnection;
    if (childProcessConnection == null)
      return; 
    int[] arrayOfInt = childProcessConnection.bindingStateCountsCurrentOrWhenDied();
    nativeSetTerminationInfo(paramLong, childProcessConnection.bindingStateCurrentOrWhenDied(), childProcessConnection.isKilledByUs(), arrayOfInt[3], arrayOfInt[2], arrayOfInt[1]);
  }
  
  @CalledByNative
  private static FileDescriptorInfo makeFdInfo(int paramInt1, int paramInt2, boolean paramBoolean, long paramLong1, long paramLong2) {
    assert false;
    throw new AssertionError();
  }
  
  private static native void nativeOnChildProcessStarted(long paramLong, int paramInt);
  
  private static native void nativeSetTerminationInfo(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4);
  
  private static Bundle populateServiceBundle(Bundle paramBundle) {
    ChildProcessCreationParamsImpl.addIntentExtras(paramBundle);
    paramBundle.putBoolean("org.chromium.base.process_launcher.extra.bind_to_caller", ChildProcessCreationParamsImpl.getBindToCallerCheck());
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private void setPriority(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, int paramInt2) {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  static void stop(int paramInt) {
    assert false;
    throw new AssertionError();
  }
  
  public static void warmUp(Context paramContext) {
    assert false;
    throw new AssertionError();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\ChildProcessLauncherHelperImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */