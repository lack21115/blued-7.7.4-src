package com.blued.android.module.shortvideo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.manager.ObserverMgr;
import com.blued.android.module.shortvideo.model.EventType;
import com.blued.android.module.shortvideo.utils.StvViewUtils;

public class StvShineTabsView extends FrameLayout implements View.OnClickListener {
  private View a;
  
  private View b;
  
  private View c;
  
  private RelativeLayout d;
  
  private RelativeLayout e;
  
  private RelativeLayout f;
  
  private TextView g;
  
  private TextView h;
  
  private TextView i;
  
  public StvShineTabsView(Context paramContext) {
    super(paramContext);
    c();
  }
  
  public StvShineTabsView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  public StvShineTabsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private void c() {
    View view = LayoutInflater.from(getContext()).inflate(R.layout.stv_shine_tabs_v, null);
    this.d = (RelativeLayout)view.findViewById(R.id.stv_channel_album_tab);
    this.d.setOnClickListener(this);
    this.e = (RelativeLayout)view.findViewById(R.id.stv_channel_shortvideo_tab);
    this.e.setOnClickListener(this);
    this.f = (RelativeLayout)view.findViewById(R.id.stv_channel_camera_tab);
    this.f.setOnClickListener(this);
    this.g = (TextView)view.findViewById(R.id.stv_channel_local);
    this.h = (TextView)view.findViewById(R.id.stv_channel_shortvideo);
    this.i = (TextView)view.findViewById(R.id.stv_channel_camera);
    this.a = view.findViewById(R.id.stv_channel_local_icon);
    this.b = view.findViewById(R.id.stv_channel_shortvideo_icon);
    this.c = view.findViewById(R.id.stv_channel_camera_icon);
    addView(view);
  }
  
  private void d() {
    this.g.setSelected(true);
    this.a.setVisibility(0);
    this.h.setSelected(false);
    this.b.setVisibility(4);
    this.i.setSelected(false);
    this.c.setVisibility(4);
  }
  
  private void e() {
    this.g.setSelected(false);
    this.a.setVisibility(4);
    this.h.setSelected(true);
    this.b.setVisibility(0);
    this.i.setSelected(false);
    this.c.setVisibility(4);
  }
  
  private void f() {
    this.g.setSelected(false);
    this.a.setVisibility(4);
    this.h.setSelected(false);
    this.b.setVisibility(4);
    this.i.setSelected(true);
    this.c.setVisibility(0);
  }
  
  public void a() {
    if (getVisibility() == 4)
      setVisibility(0); 
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt1 == 3) {
      f();
      this.e.setVisibility(8);
      this.d.setVisibility(8);
      return;
    } 
    if (paramInt1 == 6) {
      e();
      this.e.setVisibility(0);
      this.d.setVisibility(8);
      this.f.setVisibility(8);
      return;
    } 
    if (paramInt1 >= 60) {
      e();
      this.e.setVisibility(0);
      this.d.setVisibility(8);
      this.f.setVisibility(8);
      return;
    } 
    if (paramInt1 == 1 || paramInt1 == 7) {
      if (paramInt3 != 1) {
        if (paramInt3 == 2)
          d(); 
      } else {
        e();
      } 
      this.f.setVisibility(8);
      this.d.setVisibility(0);
      return;
    } 
    if (paramInt3 != 1) {
      if (paramInt3 == 5)
        f(); 
    } else {
      e();
    } 
    this.d.setVisibility(8);
    this.f.setVisibility(0);
  }
  
  public void b() {
    if (getVisibility() == 0)
      setVisibility(4); 
  }
  
  public void onClick(View paramView) {
    StvViewUtils.a(paramView);
    int i = paramView.getId();
    if (i == R.id.stv_channel_album_tab) {
      ObserverMgr.a().a(EventType.VALUE.t);
      return;
    } 
    if (i == R.id.stv_channel_shortvideo_tab) {
      ObserverMgr.a().a(EventType.VALUE.u);
      return;
    } 
    if (i == R.id.stv_channel_camera_tab)
      ObserverMgr.a().a(EventType.VALUE.v); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\view\StvShineTabsView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */