package com.blued.android.module.player.media.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.module.player.media.R;

public class NoDataAndLoadFailView extends LinearLayout {
  private Context a;
  
  private View b;
  
  private ImageView c;
  
  private TextView d;
  
  private TextView e;
  
  private int f;
  
  private int g;
  
  private int h;
  
  private int i;
  
  private boolean j = false;
  
  private ViewGroup k;
  
  public NoDataAndLoadFailView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    b();
  }
  
  public NoDataAndLoadFailView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    b();
  }
  
  private void b() {
    NoDataAndLoadFailView noDataAndLoadFailView;
    LayoutInflater layoutInflater = LayoutInflater.from(this.a);
    int i = R.layout.item_ll_nodata;
    ViewGroup viewGroup2 = this.k;
    ViewGroup viewGroup1 = viewGroup2;
    if (viewGroup2 == null)
      noDataAndLoadFailView = this; 
    this.b = layoutInflater.inflate(i, (ViewGroup)noDataAndLoadFailView);
    this.b.setVisibility(8);
    this.c = (ImageView)this.b.findViewById(R.id.img_nodata);
    this.d = (TextView)this.b.findViewById(R.id.tv_nodata);
    this.e = (TextView)this.b.findViewById(R.id.tv_reload);
    this.f = R.drawable.icon_no_data_posted;
    this.g = R.string.foudation_media_no_content_for_now;
    this.h = R.drawable.icon_data_load_failed;
    this.i = R.string.foudation_media_connecting_failed;
    a();
  }
  
  public void a() {
    this.b.setVisibility(8);
  }
  
  public boolean getIfViewVisible() {
    return (this.b.getVisibility() == 0);
  }
  
  public void setBackgroundColorRes(int paramInt) {
    this.b.findViewById(R.id.ll_main).setBackgroundColor(this.a.getResources().getColor(paramInt));
  }
  
  public void setBtnStr(int paramInt) {
    this.e.setText(paramInt);
  }
  
  public void setFailStr(int paramInt) {
    this.i = paramInt;
  }
  
  public void setFailimg(int paramInt) {
    this.h = paramInt;
  }
  
  public void setIfBtnVisibility(int paramInt) {
    if (paramInt == 0) {
      this.j = true;
      return;
    } 
    this.j = false;
  }
  
  public void setListener(NoDataViewListener paramNoDataViewListener) {
    this.e.setOnClickListener(new View.OnClickListener(this, paramNoDataViewListener) {
          public void onClick(View param1View) {
            this.a.a();
          }
        });
    this.j = true;
  }
  
  public void setNoDataImg(int paramInt) {
    this.f = paramInt;
  }
  
  public void setNoDataStr(int paramInt) {
    this.g = paramInt;
  }
  
  public static interface NoDataViewListener {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\player\media\view\NoDataAndLoadFailView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */