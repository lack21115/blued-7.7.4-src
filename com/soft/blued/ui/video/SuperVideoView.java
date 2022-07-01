package com.soft.blued.ui.video;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.imagecache.LoadOptions;
import com.soft.blued.customview.CircleProgressView;
import com.soft.blued.ui.photo.fragment.BasePhotoFragment;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.VideoLoadController;
import java.lang.ref.WeakReference;

public class SuperVideoView extends LinearLayout {
  public static WeakReference<SuperVideoView> a;
  
  private Context b;
  
  private LayoutInflater c;
  
  private View d;
  
  private ImageView e;
  
  private TextureVideoView f;
  
  private ImageView g;
  
  private TextView h;
  
  private CircleProgressView i;
  
  private LoadOptions j;
  
  private String k;
  
  private VideoLoadController.IVideoController l;
  
  public SuperVideoView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public SuperVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext) {
    this.b = paramContext;
    this.j = new LoadOptions();
    LoadOptions loadOptions = this.j;
    loadOptions.j = true;
    loadOptions.l = false;
    loadOptions.d = 2131231369;
    loadOptions.b = 2131231369;
  }
  
  public void a() {
    this.f.b();
  }
  
  public void b() {
    this.e.setVisibility(0);
    this.i.setVisibility(8);
    this.g.setImageResource(2131232667);
    this.g.setVisibility(0);
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    VideoLoadController.b(this.k, this.l);
  }
  
  protected void onFinishInflate() {
    super.onFinishInflate();
    this.c = LayoutInflater.from(this.b);
    this.d = this.c.inflate(2131494221, null);
    this.e = (ImageView)this.d.findViewById(2131299510);
    this.f = (TextureVideoView)this.d.findViewById(2131300236);
    this.g = (ImageView)this.d.findViewById(2131301605);
    this.h = (TextView)this.d.findViewById(2131301606);
    this.i = (CircleProgressView)this.d.findViewById(2131299530);
    addView(this.d);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\video\SuperVideoView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */