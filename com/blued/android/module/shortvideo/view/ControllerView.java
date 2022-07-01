package com.blued.android.module.shortvideo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.manager.ObserverMgr;
import com.blued.android.module.shortvideo.model.EventType;
import com.blued.android.module.shortvideo.observer.EventObserver;
import com.blued.android.module.shortvideo.observer.ReturnObserver;
import com.blued.android.module.shortvideo.presenter.ShinePresenter;
import com.blued.android.module.shortvideo.utils.StvViewUtils;
import com.blued.android.module.shortvideo.utils.VideoConfigData;

public class ControllerView extends FrameLayout implements View.OnClickListener, EventObserver, ReturnObserver {
  private ImageView a;
  
  private ImageView b;
  
  private ImageView c;
  
  private LinearLayout d;
  
  private TextView e;
  
  private TextView f;
  
  private TextView g;
  
  private StvShineTabsView h;
  
  private ShinePresenter i;
  
  public ControllerView(Context paramContext) {
    super(paramContext);
    h();
  }
  
  public ControllerView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    h();
  }
  
  public ControllerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    h();
  }
  
  private double a(int paramInt) {
    return VideoConfigData.f[paramInt];
  }
  
  private int a(double paramDouble) {
    for (int i = 0; i < VideoConfigData.f.length; i++) {
      if (VideoConfigData.f[i] == paramDouble)
        return i; 
    } 
    return 3;
  }
  
  private void a(boolean paramBoolean) {
    if (this.i == null)
      return; 
    if (paramBoolean) {
      this.a.setSelected(true);
      this.b.setActivated(false);
      this.b.setVisibility(4);
      this.c.setVisibility(4);
      this.h.b();
      return;
    } 
    this.a.setSelected(false);
    if (this.i.z()) {
      this.b.setVisibility(0);
      this.c.setVisibility(0);
      this.b.setEnabled(true);
      if (this.i.A()) {
        this.c.setEnabled(true);
      } else {
        this.c.setEnabled(false);
      } 
    } else {
      this.b.setVisibility(4);
      this.c.setVisibility(4);
    } 
    this.h.a();
  }
  
  private void b(boolean paramBoolean) {
    LinearLayout linearLayout = this.d;
    if (linearLayout != null) {
      byte b;
      if (paramBoolean) {
        b = 0;
      } else {
        b = 4;
      } 
      linearLayout.setVisibility(b);
    } 
  }
  
  private void h() {
    View view = LayoutInflater.from(getContext()).inflate(R.layout.controller_view, null);
    this.b = (ImageView)view.findViewById(R.id.stv_delete);
    this.a = (ImageView)view.findViewById(R.id.stv_record);
    this.c = (ImageView)view.findViewById(R.id.stv_concat);
    this.b.setOnClickListener(this);
    this.a.setOnClickListener(this);
    this.a.setSelected(false);
    this.c.setOnClickListener(this);
    this.b.setActivated(false);
    this.b.setVisibility(4);
    this.c.setVisibility(4);
    this.d = (LinearLayout)view.findViewById(R.id.stv_speed_v);
    this.e = (TextView)view.findViewById(R.id.stv_speed_2);
    this.f = (TextView)view.findViewById(R.id.stv_speed_3);
    this.g = (TextView)view.findViewById(R.id.stv_speed_4);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.h = (StvShineTabsView)view.findViewById(R.id.stv_shine_tabs);
    StvViewUtils.a((View)this.c, false);
    b(false);
    addView(view);
  }
  
  private void i() {
    this.e.setSelected(false);
    this.f.setSelected(false);
    this.g.setSelected(false);
    this.i.a(a(0));
    ObserverMgr.a().a(EventType.VALUE.f);
  }
  
  private void j() {
    this.e.setSelected(true);
    this.f.setSelected(false);
    this.g.setSelected(false);
    this.i.a(a(1));
    ObserverMgr.a().a(EventType.VALUE.f);
  }
  
  private void k() {
    this.e.setSelected(false);
    this.f.setSelected(true);
    this.g.setSelected(false);
    this.i.a(a(2));
    ObserverMgr.a().a(EventType.VALUE.f);
  }
  
  private void l() {
    this.e.setSelected(false);
    this.f.setSelected(false);
    this.g.setSelected(true);
    this.i.a(a(3));
    ObserverMgr.a().a(EventType.VALUE.f);
  }
  
  private void m() {
    this.e.setSelected(false);
    this.f.setSelected(false);
    this.g.setSelected(false);
    this.i.a(a(4));
    ObserverMgr.a().a(EventType.VALUE.f);
  }
  
  private void setSpeedV(int paramInt) {
    if (this.i == null)
      return; 
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt != 2) {
          if (paramInt != 3) {
            if (paramInt != 4)
              return; 
            m();
            return;
          } 
          l();
          return;
        } 
        k();
        return;
      } 
      j();
      return;
    } 
    i();
  }
  
  public void a() {
    if (getVisibility() == 8)
      postDelayed(new Runnable(this) {
            public void run() {
              this.a.setVisibility(0);
              StvViewUtils.a(this.a.getContext(), (View)this.a);
            }
          }200L); 
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3) {
    this.h.a(paramInt1, paramInt2, paramInt3);
    if (paramInt3 == 5) {
      this.b.setVisibility(4);
      this.c.setVisibility(4);
    } 
  }
  
  public void a(int paramInt, long paramLong) {
    if (this.i == null)
      return; 
    boolean bool2 = false;
    if (paramInt > 0) {
      this.b.setVisibility(0);
      this.c.setVisibility(0);
    } else {
      this.b.setVisibility(4);
      this.c.setVisibility(4);
    } 
    ImageView imageView = this.b;
    if (paramInt > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    imageView.setEnabled(bool1);
    imageView = this.c;
    boolean bool1 = bool2;
    if (paramLong >= this.i.x() * this.i.y())
      bool1 = true; 
    StvViewUtils.a((View)imageView, bool1);
  }
  
  public void a(EventType.VALUE paramVALUE) {
    switch (null.a[paramVALUE.ordinal()]) {
      default:
        return;
      case 6:
        a(false);
        return;
      case 3:
        a(false);
      case 4:
      case 5:
        a();
        return;
      case 1:
      case 2:
        break;
    } 
    b();
  }
  
  public void a(EventType.VALUE paramVALUE, boolean paramBoolean) {
    if (paramBoolean) {
      int i = null.a[paramVALUE.ordinal()];
      if (i != 4) {
        if (i != 7) {
          if (i != 8)
            return; 
          this.b.setActivated(false);
          return;
        } 
        a(false);
        return;
      } 
      a(true);
    } 
  }
  
  public void a(ShinePresenter paramShinePresenter) {
    this.i = paramShinePresenter;
    paramShinePresenter = this.i;
    if (paramShinePresenter == null)
      return; 
    setSpeedV(a(paramShinePresenter.y()));
    a(0, 0L);
  }
  
  public void b() {
    if (getVisibility() == 0)
      StvViewUtils.b(getContext(), (View)this); 
  }
  
  public void c() {
    this.a.setEnabled(false);
    ObserverMgr.a().a(this);
    ObserverMgr.a().a(this);
  }
  
  public void d() {
    if (this.i.n() != 5)
      a(false); 
  }
  
  public void e() {
    ObserverMgr.a().b(this);
    ObserverMgr.a().b(this);
  }
  
  public void f() {
    this.a.setEnabled(true);
  }
  
  public void g() {}
  
  public void onClick(View paramView) {
    if (this.i == null)
      return; 
    StvViewUtils.a(paramView);
    int i = paramView.getId();
    if (i == R.id.stv_record) {
      if (this.i.n() == 5) {
        ObserverMgr.a().a(EventType.VALUE.s);
        return;
      } 
      if (paramView.isSelected()) {
        ObserverMgr.a().a(EventType.VALUE.h);
        a(false);
        return;
      } 
      ObserverMgr.a().a(EventType.VALUE.g);
      return;
    } 
    if (i == R.id.stv_delete) {
      if (paramView.isActivated()) {
        ObserverMgr.a().a(EventType.VALUE.j);
        return;
      } 
      ObserverMgr.a().a(EventType.VALUE.i);
      paramView.setActivated(true);
      return;
    } 
    if (i == R.id.stv_concat) {
      ObserverMgr.a().a(EventType.VALUE.k);
      return;
    } 
    if (i == R.id.stv_speed_2) {
      j();
      return;
    } 
    if (i == R.id.stv_speed_3) {
      k();
      return;
    } 
    if (i == R.id.stv_speed_4)
      l(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\view\ControllerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */