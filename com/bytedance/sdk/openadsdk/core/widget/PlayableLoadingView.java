package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.utils.ab;
import java.util.Locale;

public class PlayableLoadingView extends FrameLayout {
  private ProgressBar a;
  
  private TextView b;
  
  private TextView c;
  
  public PlayableLoadingView(Context paramContext) {
    super(paramContext);
    a(paramContext);
  }
  
  public PlayableLoadingView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public PlayableLoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext) {
    setBackgroundColor(Color.parseColor("#0D1833"));
    setClickable(true);
    setVisibility(8);
    LayoutInflater.from(paramContext).inflate(ab.f(paramContext, "tt_playable_loading_layout"), (ViewGroup)this, true);
    this.a = (ProgressBar)findViewById(ab.e(paramContext, "tt_playable_pb_view"));
    this.b = (TextView)findViewById(ab.e(paramContext, "tt_playable_progress_tip"));
    this.c = (TextView)findViewById(ab.e(paramContext, "tt_playable_play"));
  }
  
  public void a() {
    setVisibility(8);
  }
  
  public void b() {
    setVisibility(0);
  }
  
  public TextView getPlayView() {
    return this.c;
  }
  
  public void setProgress(int paramInt) {
    int i = paramInt;
    if (paramInt < 0)
      i = 0; 
    paramInt = i;
    if (i > 100)
      paramInt = 100; 
    ProgressBar progressBar = this.a;
    if (progressBar != null)
      progressBar.setProgress(paramInt); 
    TextView textView = this.b;
    if (textView != null)
      textView.setText(String.format(Locale.getDefault(), "%d%%", new Object[] { Integer.valueOf(paramInt) })); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\widget\PlayableLoadingView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */