package com.facebook.stetho.inspector.elements.android;

import android.app.Dialog;
import android.graphics.Rect;
import android.view.View;
import android.view.Window;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.inspector.elements.AbstractChainedDescriptor;
import com.facebook.stetho.inspector.elements.Descriptor;
import javax.annotation.Nullable;

final class DialogDescriptor extends AbstractChainedDescriptor<Dialog> implements HighlightableDescriptor<Dialog> {
  @Nullable
  public Object getElementToHighlightAtPosition(Dialog<Dialog> paramDialog, int paramInt1, int paramInt2, Rect paramRect) {
    Dialog<Dialog> dialog;
    Descriptor.Host host = getHost();
    if (host instanceof AndroidDescriptorHost) {
      Window window = paramDialog.getWindow();
      HighlightableDescriptor highlightableDescriptor = ((AndroidDescriptorHost)host).getHighlightableDescriptor(window);
    } else {
      dialog = null;
      paramDialog = dialog;
    } 
    return (paramDialog == null) ? null : paramDialog.getElementToHighlightAtPosition(dialog, paramInt1, paramInt2, paramRect);
  }
  
  @Nullable
  public View getViewAndBoundsForHighlighting(Dialog<Dialog> paramDialog, Rect paramRect) {
    Dialog<Dialog> dialog;
    Descriptor.Host host = getHost();
    if (host instanceof AndroidDescriptorHost) {
      Window window = paramDialog.getWindow();
      HighlightableDescriptor highlightableDescriptor = ((AndroidDescriptorHost)host).getHighlightableDescriptor(window);
    } else {
      dialog = null;
      paramDialog = dialog;
    } 
    return (paramDialog == null) ? null : paramDialog.getViewAndBoundsForHighlighting(dialog, paramRect);
  }
  
  protected void onGetChildren(Dialog paramDialog, Accumulator<Object> paramAccumulator) {
    Window window = paramDialog.getWindow();
    if (window != null)
      paramAccumulator.store(window); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\elements\android\DialogDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */