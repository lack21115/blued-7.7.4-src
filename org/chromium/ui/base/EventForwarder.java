package org.chromium.ui.base;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.KeyEvent;
import android.view.MotionEvent;
import org.chromium.base.TraceEvent;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.ui.display.DisplayAndroid;

public class EventForwarder {
  public float mCurrentTouchOffsetX;
  
  public float mCurrentTouchOffsetY;
  
  public final boolean mIsDragDropEnabled;
  
  private int mLastMouseButtonState;
  
  public long mNativeEventForwarder;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private EventForwarder(long paramLong, boolean paramBoolean) {
    this.mNativeEventForwarder = paramLong;
    this.mIsDragDropEnabled = paramBoolean;
  }
  
  @CalledByNative
  private static EventForwarder create(long paramLong, boolean paramBoolean) {
    return new EventForwarder(paramLong, paramBoolean);
  }
  
  @CalledByNative
  private void destroy() {
    this.mNativeEventForwarder = 0L;
  }
  
  @TargetApi(23)
  public static int getMouseEventActionButton(MotionEvent paramMotionEvent) {
    return (Build.VERSION.SDK_INT >= 23) ? paramMotionEvent.getActionButton() : 0;
  }
  
  private boolean hasTouchEventOffset() {
    return (this.mCurrentTouchOffsetX != 0.0F || this.mCurrentTouchOffsetY != 0.0F);
  }
  
  private native void nativeCancelFling(long paramLong1, long paramLong2, boolean paramBoolean);
  
  private native void nativeDoubleTap(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  private native WindowAndroid nativeGetJavaWindowAndroid(long paramLong);
  
  private native boolean nativeOnGestureEvent(long paramLong1, int paramInt, long paramLong2, float paramFloat);
  
  private native void nativeOnMouseEvent(long paramLong1, long paramLong2, int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  private native boolean nativeOnTouchEvent(long paramLong1, MotionEvent paramMotionEvent, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt5, int paramInt6, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, int paramInt7, int paramInt8, int paramInt9, int paramInt10, boolean paramBoolean);
  
  private native void nativeScrollBy(long paramLong, float paramFloat1, float paramFloat2);
  
  private native void nativeScrollTo(long paramLong, float paramFloat1, float paramFloat2);
  
  private native void nativeStartFling(long paramLong1, long paramLong2, float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2);
  
  private boolean sendNativeMouseEvent(MotionEvent paramMotionEvent) {
    assert false;
    throw new AssertionError();
  }
  
  public final MotionEvent createOffsetMotionEventIfNeeded(MotionEvent paramMotionEvent) {
    if (!hasTouchEventOffset())
      return paramMotionEvent; 
    paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
    paramMotionEvent.offsetLocation(this.mCurrentTouchOffsetX, this.mCurrentTouchOffsetY);
    return paramMotionEvent;
  }
  
  public final float getEventSourceScaling() {
    DisplayAndroid displayAndroid = (nativeGetJavaWindowAndroid(this.mNativeEventForwarder)).mDisplayAndroid;
    return DisplayAndroid.getAndroidUIScaling();
  }
  
  public native boolean nativeDispatchKeyEvent(long paramLong, KeyEvent paramKeyEvent);
  
  public native void nativeOnDragEvent(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String[] paramArrayOfString, String paramString);
  
  public native boolean nativeOnGenericMotionEvent(long paramLong1, MotionEvent paramMotionEvent, long paramLong2);
  
  public native boolean nativeOnKeyUp(long paramLong, KeyEvent paramKeyEvent, int paramInt);
  
  public final boolean onHoverEvent(MotionEvent paramMotionEvent) {
    Exception exception1;
    boolean bool;
    Exception exception2;
    TraceEvent.begin("onHoverEvent");
    try {
    
    } finally {
      Exception exception = null;
      bool = false;
      exception2 = exception1;
    } 
    if (bool)
      exception2.recycle(); 
    TraceEvent.end("onHoverEvent");
    throw exception1;
  }
  
  public final boolean onMouseEvent(MotionEvent paramMotionEvent) {
    TraceEvent.begin("sendMouseEvent");
    boolean bool3 = false;
    boolean bool1 = false;
    MotionEvent motionEvent1 = paramMotionEvent;
    boolean bool2 = bool3;
    MotionEvent motionEvent2 = paramMotionEvent;
    try {
      if (hasTouchEventOffset()) {
        bool2 = bool3;
        motionEvent2 = paramMotionEvent;
        motionEvent1 = createOffsetMotionEventIfNeeded(paramMotionEvent);
        bool1 = true;
      } 
      bool2 = bool1;
      motionEvent2 = motionEvent1;
      updateMouseEventState(motionEvent1);
      bool2 = bool1;
      motionEvent2 = motionEvent1;
      return sendNativeMouseEvent(motionEvent1);
    } finally {
      if (bool2)
        motionEvent2.recycle(); 
      TraceEvent.end("sendMouseEvent");
    } 
  }
  
  public final boolean sendTouchEvent(MotionEvent paramMotionEvent, boolean paramBoolean) {
    assert false;
    throw new AssertionError();
  }
  
  public final void startFling(long paramLong, float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2) {
    if (this.mNativeEventForwarder == 0L)
      return; 
    nativeStartFling(this.mNativeEventForwarder, paramLong, paramFloat1, paramFloat2, paramBoolean1, paramBoolean2);
  }
  
  public final void updateMouseEventState(MotionEvent paramMotionEvent) {
    int i = paramMotionEvent.getActionMasked();
    if (i == 11 || i == 12)
      this.mLastMouseButtonState = paramMotionEvent.getButtonState(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\base\EventForwarder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */