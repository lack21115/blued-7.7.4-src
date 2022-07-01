package org.chromium.content.browser;

import android.os.Handler;
import java.util.ArrayList;
import java.util.List;
import org.chromium.base.ThreadUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.content.app.ContentMain;
import org.chromium.content_public.browser.BrowserStartupController;

public class BrowserStartupControllerImpl implements BrowserStartupController {
  private static BrowserStartupControllerImpl sInstance;
  
  private static boolean sShouldStartGpuProcessOnBrowserStartup;
  
  final List mAsyncStartupCallbacks = new ArrayList();
  
  private int mCurrentBrowserStartType = 0;
  
  boolean mFullBrowserStartupDone;
  
  private boolean mHasCalledContentStart;
  
  private boolean mHasStartedInitializingBrowserProcess;
  
  private boolean mLaunchFullBrowserAfterServiceManagerStart;
  
  private int mLibraryProcessType;
  
  private boolean mPostResourceExtractionTasksCompleted;
  
  private final List mServiceManagerCallbacks = new ArrayList();
  
  private boolean mStartupSuccess;
  
  private TracingControllerAndroid mTracingController;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private BrowserStartupControllerImpl(int paramInt) {
    this.mLibraryProcessType = paramInt;
    ThreadUtils.postOnUiThread(new BrowserStartupControllerImpl$1(this));
  }
  
  @CalledByNative
  static void browserStartupComplete(int paramInt) {
    if (sInstance != null)
      sInstance.executeEnqueuedCallbacks(paramInt); 
  }
  
  private int contentStart() {
    boolean bool;
    if (this.mCurrentBrowserStartType == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    int i = ContentMain.start(bool);
    this.mHasCalledContentStart = true;
    if (!bool)
      this.mLaunchFullBrowserAfterServiceManagerStart = false; 
    return i;
  }
  
  private void enqueueCallbackExecution(int paramInt) {
    (new Handler()).post(new BrowserStartupControllerImpl$3(this, paramInt));
  }
  
  private void executeEnqueuedCallbacks(int paramInt) {
    assert false;
    throw new AssertionError("Callback from browser startup from wrong thread.");
  }
  
  public static BrowserStartupController get(int paramInt) {
    assert false;
    throw new AssertionError("Tried to start the browser on the wrong thread.");
  }
  
  private static native void nativeFlushStartupTasks();
  
  private static native boolean nativeIsOfficialBuild();
  
  private static native void nativeSetCommandLineFlags(boolean paramBoolean);
  
  @CalledByNative
  static void serviceManagerStartupComplete() {
    if (sInstance != null) {
      BrowserStartupControllerImpl browserStartupControllerImpl = sInstance;
      if (browserStartupControllerImpl.mLaunchFullBrowserAfterServiceManagerStart) {
        browserStartupControllerImpl.mCurrentBrowserStartType = 0;
        if (browserStartupControllerImpl.contentStart() > 0) {
          browserStartupControllerImpl.enqueueCallbackExecution(1);
          return;
        } 
      } else if (browserStartupControllerImpl.mCurrentBrowserStartType == 1) {
        browserStartupControllerImpl.executeEnqueuedCallbacks(-1);
      } 
    } 
  }
  
  @CalledByNative
  static boolean shouldStartGpuProcessOnBrowserStartup() {
    return sShouldStartGpuProcessOnBrowserStartup;
  }
  
  public final void startBrowserProcessesSync(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mFullBrowserStartupDone : Z
    //   4: ifne -> 215
    //   7: aload_0
    //   8: getfield mHasStartedInitializingBrowserProcess : Z
    //   11: istore_3
    //   12: iconst_0
    //   13: istore_2
    //   14: iload_3
    //   15: ifeq -> 25
    //   18: aload_0
    //   19: getfield mPostResourceExtractionTasksCompleted : Z
    //   22: ifne -> 138
    //   25: ldc 'cr.BrowserStartup'
    //   27: ldc 'Initializing chromium process, singleProcess=%b'
    //   29: iconst_1
    //   30: anewarray java/lang/Object
    //   33: dup
    //   34: iconst_0
    //   35: iload_1
    //   36: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   39: aastore
    //   40: invokestatic i : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   43: invokestatic allowThreadDiskReads : ()Landroid/os/StrictMode$ThreadPolicy;
    //   46: astore #4
    //   48: invokestatic getInstance : ()Lorg/chromium/base/library_loader/LibraryLoader;
    //   51: aload_0
    //   52: getfield mLibraryProcessType : I
    //   55: invokevirtual ensureInitialized : (I)V
    //   58: aload #4
    //   60: invokestatic setThreadPolicy : (Landroid/os/StrictMode$ThreadPolicy;)V
    //   63: new org/chromium/content/browser/BrowserStartupControllerImpl$5
    //   66: dup
    //   67: aload_0
    //   68: iload_1
    //   69: aconst_null
    //   70: invokespecial <init> : (Lorg/chromium/content/browser/BrowserStartupControllerImpl;ZLjava/lang/Runnable;)V
    //   73: astore #4
    //   75: invokestatic get : ()Lorg/chromium/ui/resources/ResourceExtractor;
    //   78: astore #5
    //   80: aload #5
    //   82: getfield mExtractTask : Lorg/chromium/ui/resources/ResourceExtractor$ExtractTask;
    //   85: ifnull -> 131
    //   88: invokestatic shouldSkipPakExtraction : ()Z
    //   91: ifeq -> 97
    //   94: goto -> 131
    //   97: aload #5
    //   99: getfield mExtractTask : Lorg/chromium/ui/resources/ResourceExtractor$ExtractTask;
    //   102: getfield mFuture : Ljava/util/concurrent/FutureTask;
    //   105: invokevirtual get : ()Ljava/lang/Object;
    //   108: pop
    //   109: goto -> 131
    //   112: astore #5
    //   114: getstatic org/chromium/ui/resources/ResourceExtractor.$assertionsDisabled : Z
    //   117: ifeq -> 123
    //   120: goto -> 131
    //   123: new java/lang/AssertionError
    //   126: dup
    //   127: invokespecial <init> : ()V
    //   130: athrow
    //   131: aload #4
    //   133: invokeinterface run : ()V
    //   138: aload_0
    //   139: getfield mHasCalledContentStart : Z
    //   142: ifne -> 165
    //   145: aload_0
    //   146: iconst_0
    //   147: putfield mCurrentBrowserStartType : I
    //   150: aload_0
    //   151: invokespecial contentStart : ()I
    //   154: ifle -> 193
    //   157: aload_0
    //   158: iconst_1
    //   159: invokespecial enqueueCallbackExecution : (I)V
    //   162: goto -> 195
    //   165: aload_0
    //   166: getfield mCurrentBrowserStartType : I
    //   169: iconst_1
    //   170: if_icmpne -> 193
    //   173: aload_0
    //   174: iconst_0
    //   175: putfield mCurrentBrowserStartType : I
    //   178: aload_0
    //   179: invokespecial contentStart : ()I
    //   182: ifle -> 193
    //   185: aload_0
    //   186: iconst_1
    //   187: invokespecial enqueueCallbackExecution : (I)V
    //   190: goto -> 195
    //   193: iconst_1
    //   194: istore_2
    //   195: iload_2
    //   196: ifeq -> 215
    //   199: invokestatic nativeFlushStartupTasks : ()V
    //   202: goto -> 215
    //   205: astore #5
    //   207: aload #4
    //   209: invokestatic setThreadPolicy : (Landroid/os/StrictMode$ThreadPolicy;)V
    //   212: aload #5
    //   214: athrow
    //   215: getstatic org/chromium/content/browser/BrowserStartupControllerImpl.$assertionsDisabled : Z
    //   218: ifne -> 239
    //   221: aload_0
    //   222: getfield mFullBrowserStartupDone : Z
    //   225: ifeq -> 231
    //   228: goto -> 239
    //   231: new java/lang/AssertionError
    //   234: dup
    //   235: invokespecial <init> : ()V
    //   238: athrow
    //   239: aload_0
    //   240: getfield mStartupSuccess : Z
    //   243: ifeq -> 247
    //   246: return
    //   247: new org/chromium/base/library_loader/ProcessInitException
    //   250: dup
    //   251: invokespecial <init> : ()V
    //   254: athrow
    // Exception table:
    //   from	to	target	type
    //   48	58	205	finally
    //   97	109	112	java/lang/Exception
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\BrowserStartupControllerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */