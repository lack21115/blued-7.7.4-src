package com.facebook.stetho.inspector.elements.android;

import android.graphics.Rect;
import android.view.View;
import android.view.Window;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.inspector.elements.AbstractChainedDescriptor;
import com.facebook.stetho.inspector.elements.Descriptor;
import javax.annotation.Nullable;

final class WindowDescriptor extends AbstractChainedDescriptor<Window> implements HighlightableDescriptor<Window> {
  @Nullable
  public Object getElementToHighlightAtPosition(Window<Window> paramWindow, int paramInt1, int paramInt2, Rect paramRect) {
    Window<Window> window;
    Descriptor.Host host = getHost();
    if (host instanceof AndroidDescriptorHost) {
      View view = paramWindow.peekDecorView();
      HighlightableDescriptor highlightableDescriptor = ((AndroidDescriptorHost)host).getHighlightableDescriptor(view);
    } else {
      window = null;
      paramWindow = window;
    } 
    return (paramWindow == null) ? null : paramWindow.getElementToHighlightAtPosition(window, paramInt1, paramInt2, paramRect);
  }
  
  @Nullable
  public View getViewAndBoundsForHighlighting(Window paramWindow, Rect paramRect) {
    return paramWindow.peekDecorView();
  }
  
  protected void onGetChildren(Window paramWindow, Accumulator<Object> paramAccumulator) {
    View view = paramWindow.peekDecorView();
    if (view != null)
      paramAccumulator.store(view); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\elements\android\WindowDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */