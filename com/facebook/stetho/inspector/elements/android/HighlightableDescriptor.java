package com.facebook.stetho.inspector.elements.android;

import android.graphics.Rect;
import android.view.View;
import javax.annotation.Nullable;

public interface HighlightableDescriptor<E> {
  @Nullable
  Object getElementToHighlightAtPosition(E paramE, int paramInt1, int paramInt2, Rect paramRect);
  
  @Nullable
  View getViewAndBoundsForHighlighting(E paramE, Rect paramRect);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\elements\android\HighlightableDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */