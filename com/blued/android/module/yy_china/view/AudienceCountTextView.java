package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.observer.AudienceCountObserver;

public class AudienceCountTextView extends AppCompatTextView implements AudienceCountObserver {
  private BaseYYStudioFragment a;
  
  public AudienceCountTextView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public AudienceCountTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(int paramInt) {
    this.a.a(new Runnable(this, paramInt) {
          public void run() {
            AudienceCountTextView audienceCountTextView = this.b;
            audienceCountTextView.setText(String.format(audienceCountTextView.getResources().getString(R.string.yy_audience_count), new Object[] { Integer.valueOf(this.a) }));
          }
        });
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\view\AudienceCountTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */