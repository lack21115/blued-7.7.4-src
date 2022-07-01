package com.facebook.stetho.inspector.elements.android;

import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.Util;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

abstract class ViewHighlighter {
  public static ViewHighlighter newInstance() {
    if (Build.VERSION.SDK_INT >= 18)
      return new OverlayHighlighter(); 
    LogUtil.w("Running on pre-JBMR2: View highlighting is not supported");
    return new NoopHighlighter();
  }
  
  public abstract void clearHighlight();
  
  public abstract void setHighlightedView(View paramView, @Nullable Rect paramRect, int paramInt);
  
  static final class NoopHighlighter extends ViewHighlighter {
    private NoopHighlighter() {}
    
    public void clearHighlight() {}
    
    public void setHighlightedView(View param1View, @Nullable Rect param1Rect, int param1Int) {}
  }
  
  static final class OverlayHighlighter extends ViewHighlighter {
    private AtomicReference<Rect> mBoundsToHighlight = new AtomicReference<Rect>();
    
    private AtomicInteger mContentColor = new AtomicInteger();
    
    private final Rect mEmptyRect = new Rect();
    
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    
    private final ViewHighlightOverlays mHighlightOverlays = ViewHighlightOverlays.newInstance();
    
    private final Runnable mHighlightViewOnUiThreadRunnable = new Runnable() {
        public void run() {
          ViewHighlighter.OverlayHighlighter.this.highlightViewOnUiThread();
        }
      };
    
    private final Rect mHighlightedBounds = new Rect();
    
    private View mHighlightedView;
    
    private AtomicReference<View> mViewToHighlight = new AtomicReference<View>();
    
    private void highlightViewOnUiThread() {
      View view2 = this.mViewToHighlight.getAndSet(null);
      Rect rect2 = this.mBoundsToHighlight.getAndSet(null);
      Rect rect1 = rect2;
      if (rect2 == null)
        rect1 = this.mEmptyRect; 
      if (view2 == this.mHighlightedView && this.mHighlightedBounds.equals(rect1))
        return; 
      View view1 = this.mHighlightedView;
      if (view1 != null)
        this.mHighlightOverlays.removeHighlight(view1); 
      if (view2 != null)
        this.mHighlightOverlays.highlightView(view2, rect1, this.mContentColor.get()); 
      this.mHighlightedView = view2;
      if (rect1 == null) {
        this.mHighlightedBounds.setEmpty();
        return;
      } 
      this.mHighlightedBounds.set(rect1);
    }
    
    private void setHighlightedViewImpl(@Nullable View param1View, @Nullable Rect param1Rect, int param1Int) {
      this.mHandler.removeCallbacks(this.mHighlightViewOnUiThreadRunnable);
      this.mViewToHighlight.set(param1View);
      this.mBoundsToHighlight.set(param1Rect);
      this.mContentColor.set(param1Int);
      this.mHandler.postDelayed(this.mHighlightViewOnUiThreadRunnable, 100L);
    }
    
    public void clearHighlight() {
      setHighlightedViewImpl(null, null, 0);
    }
    
    public void setHighlightedView(View param1View, @Nullable Rect param1Rect, int param1Int) {
      setHighlightedViewImpl((View)Util.throwIfNull(param1View), param1Rect, param1Int);
    }
  }
  
  class null implements Runnable {
    public void run() {
      this.this$0.highlightViewOnUiThread();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\elements\android\ViewHighlighter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */