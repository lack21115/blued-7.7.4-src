package org.chromium.content.browser;

import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;

final class PopupZoomer$1 extends GestureDetector.SimpleOnGestureListener {
  private boolean handleTapOrPress(MotionEvent paramMotionEvent, boolean paramBoolean) {
    if (PopupZoomer.access$000(PopupZoomer.this))
      return true; 
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (PopupZoomer.access$100(PopupZoomer.this, f1, f2)) {
      PopupZoomer.access$200(PopupZoomer.this);
      return true;
    } 
    if (PopupZoomer.access$400(PopupZoomer.this) != null) {
      PointF pointF = PopupZoomer.access$500(PopupZoomer.this, f1, f2);
      PopupZoomer.access$400(PopupZoomer.this).onResolveTapDisambiguation(paramMotionEvent.getEventTime(), pointF.x, pointF.y, paramBoolean);
      PopupZoomer.access$600(PopupZoomer.this);
    } 
    return true;
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent) {
    handleTapOrPress(paramMotionEvent, true);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2) {
    if (PopupZoomer.access$000(PopupZoomer.this))
      return true; 
    if (PopupZoomer.access$100(PopupZoomer.this, paramMotionEvent1.getX(), paramMotionEvent1.getY())) {
      PopupZoomer.access$200(PopupZoomer.this);
      return true;
    } 
    PopupZoomer.access$300(PopupZoomer.this, paramFloat1, paramFloat2);
    return true;
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent) {
    return handleTapOrPress(paramMotionEvent, false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\PopupZoomer$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */