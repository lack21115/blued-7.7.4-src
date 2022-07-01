package com.github.mikephil.charting.components;

import android.graphics.Canvas;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;

public interface IMarker {
  void a(Canvas paramCanvas, float paramFloat1, float paramFloat2);
  
  void a(Entry paramEntry, Highlight paramHighlight);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\components\IMarker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */