package com.baidu.mobads.component;

import android.content.Context;
import android.view.KeyEvent;
import android.widget.RelativeLayout;

public class XAdView extends RelativeLayout {
  public static final String TAG = "BDAdView";
  
  private Listener mListener;
  
  public XAdView(Context paramContext) {
    super(paramContext);
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    Listener listener = this.mListener;
    if (listener != null)
      listener.onAttachedToWindow(); 
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    Listener listener = this.mListener;
    if (listener != null)
      listener.onDetachedFromWindow(); 
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    Listener listener = this.mListener;
    if (listener != null)
      return listener.onKeyDown(paramInt, paramKeyEvent); 
    super.onKeyDown(paramInt, paramKeyEvent);
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean) {
      Listener listener = this.mListener;
      if (listener != null)
        listener.onLayoutComplete(getWidth(), getHeight()); 
    } 
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {
    super.onWindowFocusChanged(paramBoolean);
    Listener listener = this.mListener;
    if (listener != null)
      listener.onWindowFocusChanged(paramBoolean); 
  }
  
  protected void onWindowVisibilityChanged(int paramInt) {
    super.onWindowVisibilityChanged(paramInt);
    Listener listener = this.mListener;
    if (listener != null)
      listener.onWindowVisibilityChanged(paramInt); 
  }
  
  public void setListener(Listener paramListener) {
    this.mListener = paramListener;
  }
  
  public static interface Listener {
    void onAttachedToWindow();
    
    void onDetachedFromWindow();
    
    boolean onKeyDown(int param1Int, KeyEvent param1KeyEvent);
    
    void onLayoutComplete(int param1Int1, int param1Int2);
    
    void onWindowFocusChanged(boolean param1Boolean);
    
    void onWindowVisibilityChanged(int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\component\XAdView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */