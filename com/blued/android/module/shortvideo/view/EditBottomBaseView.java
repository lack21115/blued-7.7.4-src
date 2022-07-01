package com.blued.android.module.shortvideo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.utils.StvViewUtils;

public abstract class EditBottomBaseView extends RelativeLayout implements View.OnClickListener {
  protected TextView a;
  
  protected TextView b;
  
  protected ViewGroup c;
  
  private ImageView d;
  
  private long e = 0L;
  
  public EditBottomBaseView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public EditBottomBaseView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EditBottomBaseView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    j();
  }
  
  private void j() {
    a();
    View view = LayoutInflater.from(getContext()).inflate(R.layout.edit_bottom_base_view, null);
    this.d = (ImageView)view.findViewById(R.id.btnBack);
    this.d.setOnClickListener(this);
    this.b = (TextView)view.findViewById(R.id.stv_editor_bottom_save);
    this.b.setOnClickListener(this);
    this.a = (TextView)view.findViewById(R.id.stv_editor_bottom_title);
    this.c = (ViewGroup)view.findViewById(R.id.stv_editor_bottom_content);
    this.c.addView(getContentV(), (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -2));
    if (g()) {
      this.a.setVisibility(0);
      this.d.setVisibility(8);
      if (getTitleId() != -1)
        this.a.setText(getTitleId()); 
    } else {
      this.d.setVisibility(0);
      this.a.setVisibility(8);
    } 
    b();
    addView(view);
    setBackgroundColor(getResources().getColor(R.color.stv_bottom_transparent_bg));
  }
  
  protected abstract void a();
  
  protected abstract void b();
  
  public void c() {
    if (getVisibility() == 8)
      postDelayed(new Runnable(this) {
            public void run() {
              this.a.setVisibility(0);
              StvViewUtils.a(this.a.getContext(), (View)this.a);
            }
          }200L); 
  }
  
  public void d() {
    if (getVisibility() == 0)
      StvViewUtils.b(getContext(), (View)this); 
  }
  
  protected abstract void e();
  
  protected abstract void f();
  
  protected abstract boolean g();
  
  protected abstract View getContentV();
  
  protected abstract int getTitleId();
  
  public void h() {}
  
  public void i() {}
  
  public void k() {}
  
  public void onClick(View paramView) {
    if (this.e == 0L) {
      this.e = System.currentTimeMillis();
    } else if (System.currentTimeMillis() - this.e <= 300L) {
      this.e = System.currentTimeMillis();
      return;
    } 
    StvViewUtils.a(paramView);
    int i = paramView.getId();
    if (i == R.id.stv_editor_bottom_save) {
      e();
      return;
    } 
    if (i == R.id.btnBack)
      f(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\view\EditBottomBaseView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */