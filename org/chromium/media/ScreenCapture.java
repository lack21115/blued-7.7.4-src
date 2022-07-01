package org.chromium.media;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.hardware.display.VirtualDisplay;
import android.media.ImageReader;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import java.nio.ByteBuffer;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;

@TargetApi(21)
public class ScreenCapture extends Fragment {
  private Handler mBackgroundHandler;
  
  private ScreenCapture$CaptureState mCaptureState = ScreenCapture$CaptureState.STOPPED;
  
  private final Object mCaptureStateLock = new Object();
  
  private ScreenCapture$DeviceOrientation mCurrentOrientation;
  
  private Display mDisplay;
  
  private int mFormat;
  
  private int mHeight;
  
  private ImageReader mImageReader;
  
  private MediaProjection mMediaProjection;
  
  private MediaProjectionManager mMediaProjectionManager;
  
  private final long mNativeScreenCaptureMachineAndroid;
  
  private int mResultCode;
  
  private Intent mResultData;
  
  private int mScreenDensity;
  
  private Surface mSurface;
  
  private HandlerThread mThread;
  
  private VirtualDisplay mVirtualDisplay;
  
  private int mWidth;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private ScreenCapture(long paramLong) {
    this.mNativeScreenCaptureMachineAndroid = paramLong;
  }
  
  private void changeCaptureStateAndNotify(ScreenCapture$CaptureState paramScreenCapture$CaptureState) {
    synchronized (this.mCaptureStateLock) {
      this.mCaptureState = paramScreenCapture$CaptureState;
      this.mCaptureStateLock.notifyAll();
      return;
    } 
  }
  
  private void createImageReaderWithFormat() {
    if (this.mImageReader != null)
      this.mImageReader.close(); 
    this.mImageReader = ImageReader.newInstance(this.mWidth, this.mHeight, this.mFormat, 2);
    this.mSurface = this.mImageReader.getSurface();
    ScreenCapture$CrImageReaderListener screenCapture$CrImageReaderListener = new ScreenCapture$CrImageReaderListener(this, (byte)0);
    this.mImageReader.setOnImageAvailableListener(screenCapture$CrImageReaderListener, this.mBackgroundHandler);
  }
  
  @CalledByNative
  static ScreenCapture createScreenCaptureMachine(long paramLong) {
    return (Build.VERSION.SDK_INT >= 21) ? new ScreenCapture(paramLong) : null;
  }
  
  private void createVirtualDisplay() {
    if (this.mVirtualDisplay != null)
      this.mVirtualDisplay.release(); 
    this.mVirtualDisplay = this.mMediaProjection.createVirtualDisplay("ScreenCapture", this.mWidth, this.mHeight, this.mScreenDensity, 16, this.mSurface, null, null);
  }
  
  private boolean maybeDoRotation() {
    char c;
    ScreenCapture$DeviceOrientation screenCapture$DeviceOrientation;
    switch (this.mDisplay.getRotation()) {
      default:
        assert false;
      case 3:
        c = 'Ď';
        break;
      case 2:
        c = '´';
        break;
      case 1:
        c = 'Z';
        break;
      case 0:
        c = Character.MIN_VALUE;
        break;
    } 
    if (c != 'Z' && c != 'Ď') {
      screenCapture$DeviceOrientation = ScreenCapture$DeviceOrientation.PORTRAIT;
    } else {
      screenCapture$DeviceOrientation = ScreenCapture$DeviceOrientation.LANDSCAPE;
    } 
    if (screenCapture$DeviceOrientation == this.mCurrentOrientation)
      return false; 
    this.mCurrentOrientation = screenCapture$DeviceOrientation;
    if ((screenCapture$DeviceOrientation == ScreenCapture$DeviceOrientation.LANDSCAPE && this.mWidth < this.mHeight) || (screenCapture$DeviceOrientation == ScreenCapture$DeviceOrientation.PORTRAIT && this.mHeight < this.mWidth)) {
      int i = this.mWidth;
      int j = this.mHeight;
      int k = this.mWidth;
      this.mHeight = k;
      this.mWidth = i + j - k;
    } 
    nativeOnOrientationChange(this.mNativeScreenCaptureMachineAndroid, c);
    return true;
  }
  
  private native void nativeOnActivityResult(long paramLong, boolean paramBoolean);
  
  private native void nativeOnI420FrameAvailable(long paramLong1, ByteBuffer paramByteBuffer1, int paramInt1, ByteBuffer paramByteBuffer2, ByteBuffer paramByteBuffer3, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong2);
  
  private native void nativeOnOrientationChange(long paramLong, int paramInt);
  
  private native void nativeOnRGBAFrameAvailable(long paramLong1, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong2);
  
  @CalledByNative
  public boolean allocate(int paramInt1, int paramInt2) {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.mMediaProjectionManager = (MediaProjectionManager)ContextUtils.sApplicationContext.getSystemService("media_projection");
    if (this.mMediaProjectionManager == null) {
      Log.e("cr_ScreenCapture", "mMediaProjectionManager is null", new Object[0]);
      return false;
    } 
    this.mDisplay = ((WindowManager)ContextUtils.sApplicationContext.getSystemService("window")).getDefaultDisplay();
    DisplayMetrics displayMetrics = new DisplayMetrics();
    this.mDisplay.getMetrics(displayMetrics);
    this.mScreenDensity = displayMetrics.densityDpi;
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    boolean bool = true;
    if (paramInt1 != 1)
      return; 
    if (paramInt2 == -1) {
      this.mResultCode = paramInt2;
      this.mResultData = paramIntent;
      changeCaptureStateAndNotify(ScreenCapture$CaptureState.ALLOWED);
    } 
    long l = this.mNativeScreenCaptureMachineAndroid;
    if (paramInt2 != -1)
      bool = false; 
    nativeOnActivityResult(l, bool);
  }
  
  public void onAttach(Activity paramActivity) {
    super.onAttach(paramActivity);
    changeCaptureStateAndNotify(ScreenCapture$CaptureState.ATTACHED);
  }
  
  public void onAttach(Context paramContext) {
    super.onAttach(paramContext);
    changeCaptureStateAndNotify(ScreenCapture$CaptureState.ATTACHED);
  }
  
  public void onDetach() {
    super.onDetach();
    stopCapture();
  }
  
  @CalledByNative
  public boolean startCapture() {
    synchronized (this.mCaptureStateLock) {
      if (this.mCaptureState != ScreenCapture$CaptureState.ALLOWED) {
        Log.e("cr_ScreenCapture", "startCapture() invoked without user permission.", new Object[0]);
        return false;
      } 
      this.mMediaProjection = this.mMediaProjectionManager.getMediaProjection(this.mResultCode, this.mResultData);
      if (this.mMediaProjection == null) {
        Log.e("cr_ScreenCapture", "mMediaProjection is null", new Object[0]);
        return false;
      } 
      this.mMediaProjection.registerCallback(new ScreenCapture$MediaProjectionCallback(this, (byte)0), null);
      this.mThread = new HandlerThread("ScreenCapture");
      this.mThread.start();
      this.mBackgroundHandler = new Handler(this.mThread.getLooper());
      this.mFormat = 1;
      maybeDoRotation();
      createImageReaderWithFormat();
      createVirtualDisplay();
      changeCaptureStateAndNotify(ScreenCapture$CaptureState.STARTED);
      return true;
    } 
  }
  
  @CalledByNative
  public boolean startPrompt() {
    // Byte code:
    //   0: invokestatic getLastTrackedFocusedActivity : ()Landroid/app/Activity;
    //   3: astore_1
    //   4: aload_1
    //   5: ifnonnull -> 22
    //   8: ldc 'cr_ScreenCapture'
    //   10: ldc_w 'activity is null'
    //   13: iconst_0
    //   14: anewarray java/lang/Object
    //   17: invokestatic e : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   20: iconst_0
    //   21: ireturn
    //   22: aload_1
    //   23: invokevirtual getFragmentManager : ()Landroid/app/FragmentManager;
    //   26: invokevirtual beginTransaction : ()Landroid/app/FragmentTransaction;
    //   29: astore_1
    //   30: aload_1
    //   31: aload_0
    //   32: ldc_w 'screencapture'
    //   35: invokevirtual add : (Landroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;
    //   38: pop
    //   39: aload_1
    //   40: invokevirtual commit : ()I
    //   43: pop
    //   44: aload_0
    //   45: getfield mCaptureStateLock : Ljava/lang/Object;
    //   48: astore_1
    //   49: aload_1
    //   50: monitorenter
    //   51: aload_0
    //   52: getfield mCaptureState : Lorg/chromium/media/ScreenCapture$CaptureState;
    //   55: astore_2
    //   56: getstatic org/chromium/media/ScreenCapture$CaptureState.ATTACHED : Lorg/chromium/media/ScreenCapture$CaptureState;
    //   59: astore_3
    //   60: aload_2
    //   61: aload_3
    //   62: if_acmpeq -> 109
    //   65: aload_0
    //   66: getfield mCaptureStateLock : Ljava/lang/Object;
    //   69: invokevirtual wait : ()V
    //   72: goto -> 51
    //   75: astore_2
    //   76: new java/lang/StringBuilder
    //   79: dup
    //   80: ldc_w 'ScreenCaptureException: '
    //   83: invokespecial <init> : (Ljava/lang/String;)V
    //   86: astore_3
    //   87: aload_3
    //   88: aload_2
    //   89: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: ldc 'cr_ScreenCapture'
    //   95: aload_3
    //   96: invokevirtual toString : ()Ljava/lang/String;
    //   99: iconst_0
    //   100: anewarray java/lang/Object
    //   103: invokestatic e : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: goto -> 72
    //   109: aload_1
    //   110: monitorexit
    //   111: aload_0
    //   112: aload_0
    //   113: getfield mMediaProjectionManager : Landroid/media/projection/MediaProjectionManager;
    //   116: invokevirtual createScreenCaptureIntent : ()Landroid/content/Intent;
    //   119: iconst_1
    //   120: invokevirtual startActivityForResult : (Landroid/content/Intent;I)V
    //   123: iconst_1
    //   124: ireturn
    //   125: astore_1
    //   126: new java/lang/StringBuilder
    //   129: dup
    //   130: ldc_w 'ScreenCaptureException '
    //   133: invokespecial <init> : (Ljava/lang/String;)V
    //   136: astore_2
    //   137: aload_2
    //   138: aload_1
    //   139: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: ldc 'cr_ScreenCapture'
    //   145: aload_2
    //   146: invokevirtual toString : ()Ljava/lang/String;
    //   149: iconst_0
    //   150: anewarray java/lang/Object
    //   153: invokestatic e : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   156: iconst_0
    //   157: ireturn
    //   158: astore_2
    //   159: aload_1
    //   160: monitorexit
    //   161: aload_2
    //   162: athrow
    //   163: astore_1
    //   164: new java/lang/StringBuilder
    //   167: dup
    //   168: ldc_w 'ScreenCaptureExcaption '
    //   171: invokespecial <init> : (Ljava/lang/String;)V
    //   174: astore_2
    //   175: aload_2
    //   176: aload_1
    //   177: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: ldc 'cr_ScreenCapture'
    //   183: aload_2
    //   184: invokevirtual toString : ()Ljava/lang/String;
    //   187: iconst_0
    //   188: anewarray java/lang/Object
    //   191: invokestatic e : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   194: iconst_0
    //   195: ireturn
    // Exception table:
    //   from	to	target	type
    //   39	44	163	java/lang/RuntimeException
    //   51	60	158	finally
    //   65	72	75	java/lang/InterruptedException
    //   65	72	158	finally
    //   76	106	158	finally
    //   109	111	158	finally
    //   111	123	125	android/content/ActivityNotFoundException
    //   159	161	158	finally
  }
  
  @CalledByNative
  public void stopCapture() {
    synchronized (this.mCaptureStateLock) {
      if (this.mMediaProjection != null && this.mCaptureState == ScreenCapture$CaptureState.STARTED) {
        this.mMediaProjection.stop();
        changeCaptureStateAndNotify(ScreenCapture$CaptureState.STOPPING);
        while (true) {
          ScreenCapture$CaptureState screenCapture$CaptureState1 = this.mCaptureState;
          ScreenCapture$CaptureState screenCapture$CaptureState2 = ScreenCapture$CaptureState.STOPPED;
          if (screenCapture$CaptureState1 != screenCapture$CaptureState2) {
            try {
              this.mCaptureStateLock.wait();
            } catch (InterruptedException interruptedException) {
              StringBuilder stringBuilder = new StringBuilder("ScreenCaptureEvent: ");
              stringBuilder.append(interruptedException);
              Log.e("cr_ScreenCapture", stringBuilder.toString(), new Object[0]);
            } 
            continue;
          } 
          break;
        } 
      } else {
        changeCaptureStateAndNotify(ScreenCapture$CaptureState.STOPPED);
      } 
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\ScreenCapture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */