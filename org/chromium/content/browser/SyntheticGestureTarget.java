package org.chromium.content.browser;

import android.view.MotionEvent;
import android.view.View;
import org.chromium.base.annotations.CalledByNative;

public class SyntheticGestureTarget {
  private final MotionEventSynthesizerImpl mMotionEventSynthesizer;
  
  private SyntheticGestureTarget(View paramView) {
    this.mMotionEventSynthesizer = MotionEventSynthesizerImpl.create(paramView);
  }
  
  @CalledByNative
  private static SyntheticGestureTarget create(View paramView) {
    return new SyntheticGestureTarget(paramView);
  }
  
  @CalledByNative
  private void inject(int paramInt1, int paramInt2, long paramLong) {
    MotionEventSynthesizerImpl motionEventSynthesizerImpl2;
    MotionEventSynthesizerImpl motionEventSynthesizerImpl1 = this.mMotionEventSynthesizer;
    switch (paramInt1) {
      default:
        if (MotionEventSynthesizerImpl.$assertionsDisabled)
          return; 
        throw new AssertionError("Unreached");
      case 5:
      case 6:
      case 7:
        if (MotionEventSynthesizerImpl.$assertionsDisabled || paramInt2 == 1) {
          byte b = 9;
          if (6 == paramInt1)
            b = 10; 
          if (7 == paramInt1)
            b = 7; 
          MotionEvent motionEvent1 = MotionEvent.obtain(motionEventSynthesizerImpl1.mDownTimeInMs, paramLong, b, paramInt2, motionEventSynthesizerImpl1.mPointerProperties, motionEventSynthesizerImpl1.mPointerCoords, 0, 0, 1.0F, 1.0F, 0, 0, 0, 0);
          motionEventSynthesizerImpl1.mTarget.dispatchGenericMotionEvent(motionEvent1);
          motionEvent1.recycle();
          return;
        } 
        throw new AssertionError();
      case 4:
        if (MotionEventSynthesizerImpl.$assertionsDisabled || paramInt2 == 1) {
          MotionEvent motionEvent1 = MotionEvent.obtain(motionEventSynthesizerImpl1.mDownTimeInMs, paramLong, 8, paramInt2, motionEventSynthesizerImpl1.mPointerProperties, motionEventSynthesizerImpl1.mPointerCoords, 0, 0, 1.0F, 1.0F, 0, 0, 0, 0);
          motionEventSynthesizerImpl1.mTarget.dispatchGenericMotionEvent(motionEvent1);
          motionEvent1.recycle();
          return;
        } 
        throw new AssertionError();
      case 3:
        motionEventSynthesizerImpl2 = motionEventSynthesizerImpl1;
        if (paramInt2 > 1)
          if (MotionEventSynthesizerImpl.$assertionsDisabled || paramInt2 == 2) {
            MotionEvent motionEvent1 = MotionEvent.obtain(motionEventSynthesizerImpl2.mDownTimeInMs, paramLong, 262, paramInt2, motionEventSynthesizerImpl2.mPointerProperties, motionEventSynthesizerImpl2.mPointerCoords, 0, 0, 1.0F, 1.0F, 0, 0, 0, 0);
            motionEventSynthesizerImpl2.mTarget.dispatchTouchEvent(motionEvent1);
            motionEvent1.recycle();
          } else {
            throw new AssertionError();
          }  
        motionEvent = MotionEvent.obtain(motionEventSynthesizerImpl1.mDownTimeInMs, paramLong, 1, 1, motionEventSynthesizerImpl1.mPointerProperties, motionEventSynthesizerImpl1.mPointerCoords, 0, 0, 1.0F, 1.0F, 0, 0, 0, 0);
        motionEventSynthesizerImpl1.mTarget.dispatchTouchEvent(motionEvent);
        motionEvent.recycle();
        return;
      case 2:
        motionEvent = MotionEvent.obtain(motionEventSynthesizerImpl1.mDownTimeInMs, paramLong, 3, 1, motionEventSynthesizerImpl1.mPointerProperties, motionEventSynthesizerImpl1.mPointerCoords, 0, 0, 1.0F, 1.0F, 0, 0, 0, 0);
        motionEventSynthesizerImpl1.mTarget.dispatchTouchEvent(motionEvent);
        motionEvent.recycle();
        return;
      case 1:
        motionEvent = MotionEvent.obtain(motionEventSynthesizerImpl1.mDownTimeInMs, paramLong, 2, paramInt2, motionEventSynthesizerImpl1.mPointerProperties, motionEventSynthesizerImpl1.mPointerCoords, 0, 0, 1.0F, 1.0F, 0, 0, 0, 0);
        motionEventSynthesizerImpl1.mTarget.dispatchTouchEvent(motionEvent);
        motionEvent.recycle();
        return;
      case 0:
        break;
    } 
    motionEventSynthesizerImpl1.mDownTimeInMs = paramLong;
    MotionEvent motionEvent = MotionEvent.obtain(motionEventSynthesizerImpl1.mDownTimeInMs, paramLong, 0, 1, motionEventSynthesizerImpl1.mPointerProperties, motionEventSynthesizerImpl1.mPointerCoords, 0, 0, 1.0F, 1.0F, 0, 0, 0, 0);
    motionEventSynthesizerImpl1.mTarget.dispatchTouchEvent(motionEvent);
    motionEvent.recycle();
    if (paramInt2 > 1) {
      if (MotionEventSynthesizerImpl.$assertionsDisabled || paramInt2 == 2) {
        motionEvent = MotionEvent.obtain(motionEventSynthesizerImpl1.mDownTimeInMs, paramLong, 261, paramInt2, motionEventSynthesizerImpl1.mPointerProperties, motionEventSynthesizerImpl1.mPointerCoords, 0, 0, 1.0F, 1.0F, 0, 0, 0, 0);
        motionEventSynthesizerImpl1.mTarget.dispatchTouchEvent(motionEvent);
        motionEvent.recycle();
        return;
      } 
      throw new AssertionError();
    } 
  }
  
  @CalledByNative
  private void setPointer(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.mMotionEventSynthesizer.setPointer(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  @CalledByNative
  private void setScrollDeltas(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    MotionEventSynthesizerImpl motionEventSynthesizerImpl = this.mMotionEventSynthesizer;
    motionEventSynthesizerImpl.setPointer(0, paramInt1, paramInt2, 0);
    motionEventSynthesizerImpl.mPointerCoords[0].setAxisValue(10, paramInt3);
    motionEventSynthesizerImpl.mPointerCoords[0].setAxisValue(9, paramInt4);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\SyntheticGestureTarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */