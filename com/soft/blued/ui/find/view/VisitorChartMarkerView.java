package com.soft.blued.ui.find.view;

import android.content.Context;
import android.widget.TextView;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;
import com.soft.blued.ui.find.model.VisitorCountExtra;
import com.soft.blued.utils.StringUtils;

public class VisitorChartMarkerView extends MarkerView {
  private final TextView a;
  
  private final TextView b;
  
  private Context c;
  
  public VisitorChartMarkerView(Context paramContext, int paramInt) {
    super(paramContext, paramInt);
    this.c = paramContext;
    this.a = (TextView)findViewById(2131300697);
    this.b = (TextView)findViewById(2131300670);
  }
  
  public void a(Entry paramEntry, Highlight paramHighlight) {
    VisitorCountExtra._history_track _history_track = (VisitorCountExtra._history_track)paramEntry.h();
    this.a.setText(_history_track.date);
    TextView textView = this.b;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(StringUtils.a(String.valueOf(_history_track.count)));
    stringBuilder.append(this.c.getResources().getString(2131759015));
    textView.setText(stringBuilder.toString());
    super.a(paramEntry, paramHighlight);
  }
  
  public MPPointF getOffset() {
    return new MPPointF(-(getWidth() / 2), -getHeight());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\view\VisitorChartMarkerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */