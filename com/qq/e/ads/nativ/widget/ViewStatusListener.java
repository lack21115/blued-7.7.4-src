package com.qq.e.ads.nativ.widget;

import android.view.MotionEvent;

public interface ViewStatusListener {
  void onAttachToWindow();
  
  void onDetachFromWindow();
  
  void onDispatchTouchEvent(MotionEvent paramMotionEvent);
  
  void onWindowFocusChanged(boolean paramBoolean);
  
  void onWindowVisibilityChanged(int paramInt);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\ads\nativ\widget\ViewStatusListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */