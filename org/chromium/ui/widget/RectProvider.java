package org.chromium.ui.widget;

import android.graphics.Rect;

public class RectProvider {
  RectProvider$Observer mObserver;
  
  protected final Rect mRect = new Rect();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public final Rect getRect() {
    return this.mRect;
  }
  
  protected final void notifyRectHidden() {
    if (this.mObserver != null)
      this.mObserver.onRectHidden(); 
  }
  
  public void startObserving(RectProvider$Observer paramRectProvider$Observer) {
    assert false;
    throw new AssertionError();
  }
  
  public void stopObserving() {
    this.mObserver = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\widget\RectProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */