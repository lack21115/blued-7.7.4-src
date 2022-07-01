package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYObserverManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.observer.WaittingCountObserver;

public class YYWaittingView extends FrameLayout implements View.OnClickListener, WaittingCountObserver {
  private BaseYYStudioFragment a;
  
  private TextView b;
  
  private int c = 0;
  
  private ShapeTextView d;
  
  public YYWaittingView(Context paramContext) {
    super(paramContext);
    a();
  }
  
  public YYWaittingView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public YYWaittingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a() {
    LayoutInflater.from(getContext()).inflate(R.layout.view_yy_waitting_layout, (ViewGroup)this, true);
    this.b = (TextView)findViewById(R.id.tv_waitting_count);
    this.d = (ShapeTextView)findViewById(R.id.tv_process);
    setOnClickListener(this);
  }
  
  public void a(int paramInt) {
    this.c = paramInt;
    this.a.a(new Runnable(this, paramInt) {
          public void run() {
            TextView textView = YYWaittingView.a(this.b);
            String str = this.b.getResources().getString(R.string.yy_waitting_count);
            int i = this.a;
            byte b = 0;
            textView.setText(String.format(str, new Object[] { Integer.valueOf(i) }));
            ShapeTextView shapeTextView = YYWaittingView.b(this.b);
            if (this.a <= 0)
              b = 8; 
            shapeTextView.setVisibility(b);
          }
        });
  }
  
  public void a(BaseYYStudioFragment paramBaseYYStudioFragment) {
    this.a = paramBaseYYStudioFragment;
    if (YYRoomInfoManager.d().b() != null)
      this.c = YYRoomInfoManager.d().b().getWaittingCount(); 
    a(this.c);
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    Logger.e("observer", new Object[] { "YYWaittingView onAttachedToWindow ... " });
    YYObserverManager.a().a(this);
  }
  
  public void onClick(View paramView) {
    this.a.A();
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    Logger.e("observer", new Object[] { "YYWaittingView onAttachedToWindow ... " });
    YYObserverManager.a().b(this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\view\YYWaittingView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */