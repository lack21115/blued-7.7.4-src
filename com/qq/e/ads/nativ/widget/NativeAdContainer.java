package com.qq.e.ads.nativ.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.qq.e.comm.util.GDTLogger;

public class NativeAdContainer extends FrameLayout {
  private ViewStatusListener a;
  
  private ViewStatus b = ViewStatus.INIT;
  
  static {
    NativeAdContainer.class.getSimpleName();
  }
  
  public NativeAdContainer(Context paramContext) {
    super(paramContext);
  }
  
  public NativeAdContainer(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public NativeAdContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent) {
    ViewStatusListener viewStatusListener = this.a;
    if (viewStatusListener != null)
      viewStatusListener.onDispatchTouchEvent(paramMotionEvent); 
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    GDTLogger.d("NativeAdContainer onAttachedToWindow");
    this.b = ViewStatus.ATTACHED;
    ViewStatusListener viewStatusListener = this.a;
    if (viewStatusListener != null)
      viewStatusListener.onAttachToWindow(); 
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    GDTLogger.d("NativeAdContainer onDetachedFromWindow");
    this.b = ViewStatus.DETACHED;
    ViewStatusListener viewStatusListener = this.a;
    if (viewStatusListener != null)
      viewStatusListener.onDetachFromWindow(); 
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {
    super.onWindowFocusChanged(paramBoolean);
    StringBuilder stringBuilder = new StringBuilder("onWindowFocusChanged: hasWindowFocus: ");
    stringBuilder.append(paramBoolean);
    GDTLogger.d(stringBuilder.toString());
    ViewStatusListener viewStatusListener = this.a;
    if (viewStatusListener != null)
      viewStatusListener.onWindowFocusChanged(paramBoolean); 
  }
  
  protected void onWindowVisibilityChanged(int paramInt) {
    super.onWindowVisibilityChanged(paramInt);
    StringBuilder stringBuilder = new StringBuilder("onWindowVisibilityChanged: visibility: ");
    stringBuilder.append(paramInt);
    GDTLogger.d(stringBuilder.toString());
    ViewStatusListener viewStatusListener = this.a;
    if (viewStatusListener != null)
      viewStatusListener.onWindowVisibilityChanged(paramInt); 
  }
  
  public void setViewStatusListener(ViewStatusListener paramViewStatusListener) {
    this.a = paramViewStatusListener;
    if (this.a != null) {
      int i = null.a[this.b.ordinal()];
      if (i != 1) {
        if (i != 2)
          return; 
        this.a.onDetachFromWindow();
        return;
      } 
      this.a.onAttachToWindow();
    } 
  }
  
  enum ViewStatus {
    ATTACHED, DETACHED, INIT;
    
    static {
    
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\ads\nativ\widget\NativeAdContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */