package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.module.live_china.R;

public class GrabBoxNumView extends FrameLayout {
  private View a;
  
  private Context b;
  
  private LayoutInflater c;
  
  private TextView d;
  
  private ImageView e;
  
  public GrabBoxNumView(Context paramContext) {
    super(paramContext);
    this.b = paramContext;
    a();
  }
  
  public GrabBoxNumView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.b = paramContext;
    a();
  }
  
  private void a() {
    this.c = LayoutInflater.from(this.b);
    this.a = this.c.inflate(R.layout.grab_box_wandou_toast, (ViewGroup)this, true);
    this.d = (TextView)this.a.findViewById(R.id.grab_box_num);
    this.e = (ImageView)this.a.findViewById(R.id.grab_box_icon);
    setVisibility(8);
  }
  
  public void a(int paramInt, String paramString) {
    ImageLoader.a(null, paramString).a(this.e);
    TextView textView = this.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    textView.setText(stringBuilder.toString());
    setVisibility(0);
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            this.a.setVisibility(8);
          }
        },  1500L);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\GrabBoxNumView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */