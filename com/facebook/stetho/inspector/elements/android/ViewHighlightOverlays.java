package com.facebook.stetho.inspector.elements.android;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

abstract class ViewHighlightOverlays {
  static ViewHighlightOverlays newInstance() {
    return (ViewHighlightOverlays)((Build.VERSION.SDK_INT >= 18) ? new ViewHighlightOverlaysJellybeanMR2() : new NoOpViewHighlightOverlays());
  }
  
  abstract void highlightView(View paramView, Rect paramRect, int paramInt);
  
  abstract void removeHighlight(View paramView);
  
  static class NoOpViewHighlightOverlays extends ViewHighlightOverlays {
    private NoOpViewHighlightOverlays() {}
    
    void highlightView(View param1View, Rect param1Rect, int param1Int) {}
    
    void removeHighlight(View param1View) {}
  }
  
  static class ViewHighlightOverlaysJellybeanMR2 extends ViewHighlightOverlays {
    private static final int MARGIN_OVERLAY_COLOR = -1426797922;
    
    private static final int PADDING_OVERLAY_COLOR = -1430332746;
    
    private final HighlightDrawable[] mHighlightDrawables = new HighlightDrawable[] { this.mMainHighlightDrawable, new PaddingTopHighlightDrawable(), new PaddingBottomHighlightDrawable(), new PaddingRightHighlightDrawable(), new PaddingLeftHighlightDrawable(), new MarginTopHighlightDrawable(), new MarginBottomHighlightDrawable(), new MarginRightHighlightDrawable(), new MarginLeftHighlightDrawable() };
    
    private final MainHighlightDrawable mMainHighlightDrawable = new MainHighlightDrawable();
    
    void highlightView(View param1View, Rect param1Rect, int param1Int) {
      this.mMainHighlightDrawable.setColor(param1Int);
      boolean bool = param1Rect.isEmpty();
      param1Int = 0;
      if (bool) {
        this.mMainHighlightDrawable.setBounds(0, 0, param1View.getWidth(), param1View.getHeight());
      } else {
        this.mMainHighlightDrawable.setBounds(param1Rect);
      } 
      int i = this.mHighlightDrawables.length;
      while (param1Int < i) {
        HighlightDrawable highlightDrawable = this.mHighlightDrawables[param1Int];
        highlightDrawable.highlightView(param1View);
        param1View.getOverlay().add((Drawable)highlightDrawable);
        param1Int++;
      } 
    }
    
    void removeHighlight(View param1View) {
      for (HighlightDrawable highlightDrawable : this.mHighlightDrawables)
        param1View.getOverlay().remove((Drawable)highlightDrawable); 
    }
    
    static abstract class HighlightDrawable extends ColorDrawable {
      protected final Rect mMargins = new Rect();
      
      protected final Rect mPaddings = new Rect();
      
      public HighlightDrawable() {}
      
      HighlightDrawable(int param2Int) {
        super(param2Int);
      }
      
      void highlightView(View param2View) {
        ViewGroup.LayoutParams layoutParams = param2View.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
          ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)layoutParams;
          this.mMargins.left = marginLayoutParams.leftMargin;
          this.mMargins.top = marginLayoutParams.topMargin;
          this.mMargins.right = marginLayoutParams.rightMargin;
          this.mMargins.bottom = marginLayoutParams.bottomMargin;
        } else {
          Rect rect = this.mMargins;
          rect.left = 0;
          rect.top = 0;
          rect.right = 0;
          rect.bottom = 0;
        } 
        this.mPaddings.left = param2View.getPaddingLeft();
        this.mPaddings.top = param2View.getPaddingTop();
        this.mPaddings.right = param2View.getPaddingRight();
        this.mPaddings.bottom = param2View.getPaddingBottom();
      }
    }
    
    static class MainHighlightDrawable extends HighlightDrawable {
      public void draw(Canvas param2Canvas) {
        Rect rect = param2Canvas.getClipBounds();
        rect.inset(-(this.mMargins.right + this.mMargins.left), -(this.mMargins.top + this.mMargins.bottom));
        param2Canvas.clipRect(rect, Region.Op.REPLACE);
        super.draw(param2Canvas);
      }
      
      void highlightView(View param2View) {
        super.highlightView(param2View);
      }
    }
    
    static class MarginBottomHighlightDrawable extends HighlightDrawable {
      MarginBottomHighlightDrawable() {
        super(-1426797922);
      }
      
      public void draw(Canvas param2Canvas) {
        param2Canvas.translate(0.0F, (this.mMargins.bottom + this.mMargins.top));
        super.draw(param2Canvas);
      }
      
      void highlightView(View param2View) {
        super.highlightView(param2View);
        setBounds(0, param2View.getHeight() - this.mMargins.bottom, param2View.getWidth(), param2View.getHeight());
      }
    }
    
    static class MarginLeftHighlightDrawable extends HighlightDrawable {
      MarginLeftHighlightDrawable() {
        super(-1426797922);
      }
      
      public void draw(Canvas param2Canvas) {
        param2Canvas.translate(-(this.mMargins.left + this.mMargins.right), 0.0F);
        super.draw(param2Canvas);
      }
      
      void highlightView(View param2View) {
        super.highlightView(param2View);
        setBounds(0, 0, this.mMargins.left, param2View.getHeight() + this.mMargins.top + this.mMargins.bottom);
      }
    }
    
    static class MarginRightHighlightDrawable extends HighlightDrawable {
      MarginRightHighlightDrawable() {
        super(-1426797922);
      }
      
      public void draw(Canvas param2Canvas) {
        param2Canvas.translate(this.mMargins.right, -(this.mMargins.top + this.mMargins.bottom));
        super.draw(param2Canvas);
      }
      
      void highlightView(View param2View) {
        super.highlightView(param2View);
        setBounds(param2View.getWidth() - this.mMargins.right, 0, param2View.getWidth(), param2View.getHeight() + this.mMargins.top + this.mMargins.bottom);
      }
    }
    
    static class MarginTopHighlightDrawable extends HighlightDrawable {
      MarginTopHighlightDrawable() {
        super(-1426797922);
      }
      
      public void draw(Canvas param2Canvas) {
        param2Canvas.translate(0.0F, -this.mMargins.top);
        super.draw(param2Canvas);
      }
      
      void highlightView(View param2View) {
        super.highlightView(param2View);
        setBounds(0, 0, param2View.getWidth(), this.mMargins.top);
      }
    }
    
    static class PaddingBottomHighlightDrawable extends HighlightDrawable {
      PaddingBottomHighlightDrawable() {
        super(-1430332746);
      }
      
      void highlightView(View param2View) {
        super.highlightView(param2View);
        setBounds(this.mPaddings.left, param2View.getHeight() - this.mPaddings.bottom, param2View.getWidth() - this.mPaddings.right, param2View.getHeight());
      }
    }
    
    static class PaddingLeftHighlightDrawable extends HighlightDrawable {
      PaddingLeftHighlightDrawable() {
        super(-1430332746);
      }
      
      void highlightView(View param2View) {
        super.highlightView(param2View);
        setBounds(0, 0, this.mPaddings.left, param2View.getHeight());
      }
    }
    
    static class PaddingRightHighlightDrawable extends HighlightDrawable {
      PaddingRightHighlightDrawable() {
        super(-1430332746);
      }
      
      void highlightView(View param2View) {
        super.highlightView(param2View);
        setBounds(param2View.getWidth() - this.mPaddings.right, 0, param2View.getWidth(), param2View.getHeight());
      }
    }
    
    static class PaddingTopHighlightDrawable extends HighlightDrawable {
      PaddingTopHighlightDrawable() {
        super(-1430332746);
      }
      
      void highlightView(View param2View) {
        super.highlightView(param2View);
        setBounds(this.mPaddings.left, 0, param2View.getWidth() - this.mPaddings.right, this.mPaddings.top);
      }
    }
  }
  
  static abstract class HighlightDrawable extends ColorDrawable {
    protected final Rect mMargins = new Rect();
    
    protected final Rect mPaddings = new Rect();
    
    public HighlightDrawable() {}
    
    HighlightDrawable(int param1Int) {
      super(param1Int);
    }
    
    void highlightView(View param1View) {
      ViewGroup.LayoutParams layoutParams = param1View.getLayoutParams();
      if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)layoutParams;
        this.mMargins.left = marginLayoutParams.leftMargin;
        this.mMargins.top = marginLayoutParams.topMargin;
        this.mMargins.right = marginLayoutParams.rightMargin;
        this.mMargins.bottom = marginLayoutParams.bottomMargin;
      } else {
        Rect rect = this.mMargins;
        rect.left = 0;
        rect.top = 0;
        rect.right = 0;
        rect.bottom = 0;
      } 
      this.mPaddings.left = param1View.getPaddingLeft();
      this.mPaddings.top = param1View.getPaddingTop();
      this.mPaddings.right = param1View.getPaddingRight();
      this.mPaddings.bottom = param1View.getPaddingBottom();
    }
  }
  
  static class MainHighlightDrawable extends ViewHighlightOverlaysJellybeanMR2.HighlightDrawable {
    public void draw(Canvas param1Canvas) {
      Rect rect = param1Canvas.getClipBounds();
      rect.inset(-(this.mMargins.right + this.mMargins.left), -(this.mMargins.top + this.mMargins.bottom));
      param1Canvas.clipRect(rect, Region.Op.REPLACE);
      super.draw(param1Canvas);
    }
    
    void highlightView(View param1View) {
      super.highlightView(param1View);
    }
  }
  
  static class MarginBottomHighlightDrawable extends ViewHighlightOverlaysJellybeanMR2.HighlightDrawable {
    MarginBottomHighlightDrawable() {
      super(-1426797922);
    }
    
    public void draw(Canvas param1Canvas) {
      param1Canvas.translate(0.0F, (this.mMargins.bottom + this.mMargins.top));
      super.draw(param1Canvas);
    }
    
    void highlightView(View param1View) {
      super.highlightView(param1View);
      setBounds(0, param1View.getHeight() - this.mMargins.bottom, param1View.getWidth(), param1View.getHeight());
    }
  }
  
  static class MarginLeftHighlightDrawable extends ViewHighlightOverlaysJellybeanMR2.HighlightDrawable {
    MarginLeftHighlightDrawable() {
      super(-1426797922);
    }
    
    public void draw(Canvas param1Canvas) {
      param1Canvas.translate(-(this.mMargins.left + this.mMargins.right), 0.0F);
      super.draw(param1Canvas);
    }
    
    void highlightView(View param1View) {
      super.highlightView(param1View);
      setBounds(0, 0, this.mMargins.left, param1View.getHeight() + this.mMargins.top + this.mMargins.bottom);
    }
  }
  
  static class MarginRightHighlightDrawable extends ViewHighlightOverlaysJellybeanMR2.HighlightDrawable {
    MarginRightHighlightDrawable() {
      super(-1426797922);
    }
    
    public void draw(Canvas param1Canvas) {
      param1Canvas.translate(this.mMargins.right, -(this.mMargins.top + this.mMargins.bottom));
      super.draw(param1Canvas);
    }
    
    void highlightView(View param1View) {
      super.highlightView(param1View);
      setBounds(param1View.getWidth() - this.mMargins.right, 0, param1View.getWidth(), param1View.getHeight() + this.mMargins.top + this.mMargins.bottom);
    }
  }
  
  static class MarginTopHighlightDrawable extends ViewHighlightOverlaysJellybeanMR2.HighlightDrawable {
    MarginTopHighlightDrawable() {
      super(-1426797922);
    }
    
    public void draw(Canvas param1Canvas) {
      param1Canvas.translate(0.0F, -this.mMargins.top);
      super.draw(param1Canvas);
    }
    
    void highlightView(View param1View) {
      super.highlightView(param1View);
      setBounds(0, 0, param1View.getWidth(), this.mMargins.top);
    }
  }
  
  static class PaddingBottomHighlightDrawable extends ViewHighlightOverlaysJellybeanMR2.HighlightDrawable {
    PaddingBottomHighlightDrawable() {
      super(-1430332746);
    }
    
    void highlightView(View param1View) {
      super.highlightView(param1View);
      setBounds(this.mPaddings.left, param1View.getHeight() - this.mPaddings.bottom, param1View.getWidth() - this.mPaddings.right, param1View.getHeight());
    }
  }
  
  static class PaddingLeftHighlightDrawable extends ViewHighlightOverlaysJellybeanMR2.HighlightDrawable {
    PaddingLeftHighlightDrawable() {
      super(-1430332746);
    }
    
    void highlightView(View param1View) {
      super.highlightView(param1View);
      setBounds(0, 0, this.mPaddings.left, param1View.getHeight());
    }
  }
  
  static class PaddingRightHighlightDrawable extends ViewHighlightOverlaysJellybeanMR2.HighlightDrawable {
    PaddingRightHighlightDrawable() {
      super(-1430332746);
    }
    
    void highlightView(View param1View) {
      super.highlightView(param1View);
      setBounds(param1View.getWidth() - this.mPaddings.right, 0, param1View.getWidth(), param1View.getHeight());
    }
  }
  
  static class PaddingTopHighlightDrawable extends ViewHighlightOverlaysJellybeanMR2.HighlightDrawable {
    PaddingTopHighlightDrawable() {
      super(-1430332746);
    }
    
    void highlightView(View param1View) {
      super.highlightView(param1View);
      setBounds(this.mPaddings.left, 0, param1View.getWidth() - this.mPaddings.right, this.mPaddings.top);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\elements\android\ViewHighlightOverlays.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */