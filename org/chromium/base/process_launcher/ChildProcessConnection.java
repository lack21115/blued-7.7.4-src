package org.chromium.base.process_launcher;

import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import java.util.Arrays;
import org.chromium.base.MemoryPressureListener;
import org.chromium.base.TraceEvent;
import org.chromium.base.memory.MemoryPressureCallback;

public class ChildProcessConnection {
  private static final int[] sAllBindingStateCounts;
  
  private int[] mAllBindingStateCountsWhenDied;
  
  private final boolean mBindToCaller;
  
  private int mBindingState;
  
  private int mBindingStateCurrentOrWhenDied;
  
  public final Object mClientThreadLock = new Object();
  
  ChildProcessConnection$ConnectionCallback mConnectionCallback;
  
  ChildProcessConnection$ConnectionParams mConnectionParams;
  
  private boolean mDidOnServiceConnected;
  
  public boolean mKilledByUs;
  
  final Handler mLauncherHandler = new Handler();
  
  private MemoryPressureCallback mMemoryPressureCallback;
  
  final ChildProcessConnection$ChildServiceConnection mModerateBinding;
  
  int mModerateBindingCount;
  
  private int mPid;
  
  public IChildProcessService mService;
  
  private final Bundle mServiceBundle;
  
  ChildProcessConnection$ServiceCallback mServiceCallback;
  
  boolean mServiceConnectComplete;
  
  boolean mServiceDisconnected;
  
  public final ChildProcessConnection$ChildServiceConnection mStrongBinding;
  
  public int mStrongBindingCount;
  
  boolean mUnbound;
  
  final ChildProcessConnection$ChildServiceConnection mWaivedBinding;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public ChildProcessConnection(Context paramContext, ComponentName paramComponentName, boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle) {
    this(paramContext, paramComponentName, paramBoolean1, paramBoolean2, paramBundle, null);
  }
  
  private ChildProcessConnection(Context paramContext, ComponentName paramComponentName, boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle, ChildProcessConnection$ChildServiceConnectionFactory paramChildProcessConnection$ChildServiceConnectionFactory) {
    assert false;
    throw new AssertionError();
  }
  
  public final void addModerateBinding() {
    assert false;
    throw new AssertionError();
  }
  
  public final int[] bindingStateCountsCurrentOrWhenDied() {
    synchronized (this.mClientThreadLock) {
      if (this.mAllBindingStateCountsWhenDied != null)
        return Arrays.copyOf(this.mAllBindingStateCountsWhenDied, 4); 
      synchronized (sAllBindingStateCounts) {
        return Arrays.copyOf(sAllBindingStateCounts, 4);
      } 
    } 
  }
  
  public final int bindingStateCurrentOrWhenDied() {
    synchronized (this.mClientThreadLock) {
      return this.mBindingStateCurrentOrWhenDied;
    } 
  }
  
  final void doConnectionSetup() {
    try {
      TraceEvent.begin("ChildProcessConnection.doConnectionSetup");
      assert false;
      throw new AssertionError();
    } finally {
      TraceEvent.end("ChildProcessConnection.doConnectionSetup");
    } 
  }
  
  public final int getPid() {
    assert false;
    throw new AssertionError();
  }
  
  public final boolean isConnected() {
    return (this.mService != null);
  }
  
  public final boolean isKilledByUs() {
    synchronized (this.mClientThreadLock) {
      return this.mKilledByUs;
    } 
  }
  
  public final boolean isRunningOnLauncherThread() {
    return (this.mLauncherHandler.getLooper() == Looper.myLooper());
  }
  
  public final void notifyChildProcessDied() {
    if (this.mServiceCallback != null) {
      ChildProcessConnection$ServiceCallback childProcessConnection$ServiceCallback = this.mServiceCallback;
      this.mServiceCallback = null;
      childProcessConnection$ServiceCallback.onChildProcessDied(this);
    } 
  }
  
  public final void removeModerateBinding() {
    assert false;
    throw new AssertionError();
  }
  
  public final void stop() {
    assert false;
    throw new AssertionError();
  }
  
  public final void unbind() {
    assert false;
    throw new AssertionError();
  }
  
  public final void updateBindingState() {
    // Byte code:
    //   0: aload_0
    //   1: getfield mBindingState : I
    //   4: istore_1
    //   5: aload_0
    //   6: getfield mUnbound : Z
    //   9: ifeq -> 20
    //   12: aload_0
    //   13: iconst_0
    //   14: putfield mBindingState : I
    //   17: goto -> 94
    //   20: aload_0
    //   21: getfield mStrongBinding : Lorg/chromium/base/process_launcher/ChildProcessConnection$ChildServiceConnection;
    //   24: invokeinterface isBound : ()Z
    //   29: ifeq -> 40
    //   32: aload_0
    //   33: iconst_3
    //   34: putfield mBindingState : I
    //   37: goto -> 94
    //   40: aload_0
    //   41: getfield mModerateBinding : Lorg/chromium/base/process_launcher/ChildProcessConnection$ChildServiceConnection;
    //   44: invokeinterface isBound : ()Z
    //   49: ifeq -> 60
    //   52: aload_0
    //   53: iconst_2
    //   54: putfield mBindingState : I
    //   57: goto -> 94
    //   60: getstatic org/chromium/base/process_launcher/ChildProcessConnection.$assertionsDisabled : Z
    //   63: ifne -> 89
    //   66: aload_0
    //   67: getfield mWaivedBinding : Lorg/chromium/base/process_launcher/ChildProcessConnection$ChildServiceConnection;
    //   70: invokeinterface isBound : ()Z
    //   75: ifeq -> 81
    //   78: goto -> 89
    //   81: new java/lang/AssertionError
    //   84: dup
    //   85: invokespecial <init> : ()V
    //   88: athrow
    //   89: aload_0
    //   90: iconst_1
    //   91: putfield mBindingState : I
    //   94: aload_0
    //   95: getfield mBindingState : I
    //   98: iload_1
    //   99: if_icmpeq -> 185
    //   102: getstatic org/chromium/base/process_launcher/ChildProcessConnection.sAllBindingStateCounts : [I
    //   105: astore_2
    //   106: aload_2
    //   107: monitorenter
    //   108: iload_1
    //   109: ifeq -> 152
    //   112: getstatic org/chromium/base/process_launcher/ChildProcessConnection.$assertionsDisabled : Z
    //   115: ifne -> 137
    //   118: getstatic org/chromium/base/process_launcher/ChildProcessConnection.sAllBindingStateCounts : [I
    //   121: iload_1
    //   122: iaload
    //   123: ifle -> 129
    //   126: goto -> 137
    //   129: new java/lang/AssertionError
    //   132: dup
    //   133: invokespecial <init> : ()V
    //   136: athrow
    //   137: getstatic org/chromium/base/process_launcher/ChildProcessConnection.sAllBindingStateCounts : [I
    //   140: astore_3
    //   141: aload_3
    //   142: iload_1
    //   143: aload_3
    //   144: iload_1
    //   145: iaload
    //   146: iconst_1
    //   147: isub
    //   148: iastore
    //   149: goto -> 152
    //   152: aload_0
    //   153: getfield mBindingState : I
    //   156: ifeq -> 176
    //   159: getstatic org/chromium/base/process_launcher/ChildProcessConnection.sAllBindingStateCounts : [I
    //   162: astore_3
    //   163: aload_0
    //   164: getfield mBindingState : I
    //   167: istore_1
    //   168: aload_3
    //   169: iload_1
    //   170: aload_3
    //   171: iload_1
    //   172: iaload
    //   173: iconst_1
    //   174: iadd
    //   175: iastore
    //   176: aload_2
    //   177: monitorexit
    //   178: goto -> 185
    //   181: aload_2
    //   182: monitorexit
    //   183: aload_3
    //   184: athrow
    //   185: aload_0
    //   186: getfield mUnbound : Z
    //   189: ifne -> 215
    //   192: aload_0
    //   193: getfield mClientThreadLock : Ljava/lang/Object;
    //   196: astore_2
    //   197: aload_2
    //   198: monitorenter
    //   199: aload_0
    //   200: aload_0
    //   201: getfield mBindingState : I
    //   204: putfield mBindingStateCurrentOrWhenDied : I
    //   207: aload_2
    //   208: monitorexit
    //   209: return
    //   210: astore_3
    //   211: aload_2
    //   212: monitorexit
    //   213: aload_3
    //   214: athrow
    //   215: return
    //   216: astore_3
    //   217: goto -> 181
    // Exception table:
    //   from	to	target	type
    //   112	126	216	finally
    //   129	137	216	finally
    //   137	141	216	finally
    //   152	168	216	finally
    //   176	178	216	finally
    //   181	183	216	finally
    //   199	209	210	finally
    //   211	213	210	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\process_launcher\ChildProcessConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */