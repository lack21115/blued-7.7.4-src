package org.chromium.content.browser;

import android.view.MotionEvent;
import android.view.View;

public class MotionEventSynthesizerImpl {
  long mDownTimeInMs;
  
  final MotionEvent.PointerCoords[] mPointerCoords;
  
  final MotionEvent.PointerProperties[] mPointerProperties;
  
  final View mTarget;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private MotionEventSynthesizerImpl(View paramView) {
    assert false;
    throw new AssertionError();
  }
  
  public static MotionEventSynthesizerImpl create(View paramView) {
    return new MotionEventSynthesizerImpl(paramView);
  }
  
  public final void setPointer(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    assert false;
    throw new AssertionError();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\MotionEventSynthesizerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */