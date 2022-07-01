package com.blued.android.module.shortvideo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.manager.ObserverMgr;
import com.blued.android.module.shortvideo.model.EventType;
import com.blued.android.module.shortvideo.observer.EventObserver;
import com.blued.android.module.shortvideo.presenter.EditPresenter;
import com.blued.android.module.shortvideo.utils.StvViewUtils;

public class EditMainView extends FrameLayout implements View.OnClickListener, EventObserver {
  private TextView a;
  
  private CheckBox b;
  
  private View c;
  
  private EditPresenter d;
  
  public EditMainView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public EditMainView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EditMainView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    g();
  }
  
  private void g() {
    this.c = LayoutInflater.from(getContext()).inflate(R.layout.edit_main_view, (ViewGroup)this);
    this.a = (TextView)this.c.findViewById(R.id.stv_edit_finish);
    this.b = (CheckBox)this.c.findViewById(R.id.stv_delete_auto_cb);
  }
  
  private void h() {
    this.b.setVisibility(0);
    this.a.setText(R.string.stv_send);
  }
  
  private void i() {
    this.b.setVisibility(8);
    this.a.setText(R.string.stv_send);
  }
  
  private void j() {
    this.b.setVisibility(8);
    this.a.setText(R.string.stv_upload);
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
    if (paramInt1 != 0) {
      if (paramInt1 != 1)
        if (paramInt1 != 7) {
          if (paramInt1 != 61)
            return; 
        } else {
          i();
          return;
        }  
      h();
      this.b.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              int i = EditMainView.a(this.a).u() ^ true;
              EditMainView.b(this.a).setSelected(i);
              EditMainView.a(this.a).d(i);
            }
          });
      return;
    } 
    j();
  }
  
  public void a(EventType.VALUE paramVALUE) {
    switch (null.a[paramVALUE.ordinal()]) {
      default:
        return;
      case 4:
      case 5:
      case 6:
        a();
        return;
      case 1:
      case 2:
      case 3:
        break;
    } 
    b();
  }
  
  public void a(EditPresenter paramEditPresenter) {
    this.d = paramEditPresenter;
    this.a.setOnClickListener(this);
  }
  
  public void b() {
    if (getVisibility() == 0)
      StvViewUtils.b(getContext(), (View)this); 
  }
  
  public void c() {
    ObserverMgr.a().a(this);
  }
  
  public void d() {}
  
  public void e() {
    ObserverMgr.a().b(this);
  }
  
  public void f() {}
  
  public void onClick(View paramView) {
    StvViewUtils.a(paramView);
    if (paramView.getId() == R.id.stv_edit_finish)
      ObserverMgr.a().a(EventType.VALUE.w); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\view\EditMainView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */