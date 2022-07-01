package com.blued.android.module.shortvideo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.SeekBar;
import com.blued.android.module.base.data_statistics.StatisticsProxy;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.manager.ObserverMgr;
import com.blued.android.module.shortvideo.model.EventType;
import com.blued.android.module.shortvideo.observer.EventObserver;
import com.blued.android.module.shortvideo.presenter.EditPresenter;
import com.blued.android.module.shortvideo.utils.StvViewUtils;

public class EditVolumeView extends EditBottomBaseView implements SeekBar.OnSeekBarChangeListener, EventObserver {
  private View d;
  
  private SeekBar e;
  
  private SeekBar f;
  
  private EditPresenter g;
  
  public EditVolumeView(Context paramContext) {
    super(paramContext);
  }
  
  public EditVolumeView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public EditVolumeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a() {
    this.d = LayoutInflater.from(getContext()).inflate(R.layout.edit_adjust_audio_mix_v, null);
    this.e = (SeekBar)this.d.findViewById(R.id.stv_adjust_fg_volume);
    this.e.setOnSeekBarChangeListener(this);
    this.f = (SeekBar)this.d.findViewById(R.id.stv_adjust_bg_volume);
    this.f.setOnSeekBarChangeListener(this);
  }
  
  public void a(EventType.VALUE paramVALUE) {
    if (paramVALUE == EventType.VALUE.e)
      c(); 
  }
  
  public void a(EditPresenter paramEditPresenter) {
    this.g = paramEditPresenter;
    this.e.setMax(100);
    this.f.setMax(100);
    this.f.setEnabled(false);
  }
  
  protected void b() {
    StvViewUtils.a((View)this.c, 30, 46, 30, 60);
  }
  
  public void c() {
    super.c();
    EditPresenter editPresenter = this.g;
    if (editPresenter == null)
      return; 
    editPresenter.h(4);
    if (this.g.t() < 60)
      StatisticsProxy.a().a("sv_page", "volumn"); 
    this.e.setProgress(this.g.k());
    if (!this.g.i() && this.g.j()) {
      this.f.setEnabled(true);
      this.f.setProgress(this.g.l());
      return;
    } 
    this.f.setEnabled(false);
  }
  
  protected void e() {
    ObserverMgr.a().a(EventType.VALUE.p);
    d();
  }
  
  protected void f() {}
  
  protected boolean g() {
    return true;
  }
  
  protected View getContentV() {
    return this.d;
  }
  
  protected int getTitleId() {
    return R.string.stv_adjust_volume_title;
  }
  
  public void h() {
    ObserverMgr.a().a(this);
  }
  
  public void i() {}
  
  public void j() {
    ObserverMgr.a().b(this);
  }
  
  public void k() {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {
    int i;
    EditPresenter editPresenter = this.g;
    if (editPresenter == null)
      return; 
    if (paramSeekBar == this.e) {
      int j = editPresenter.l();
      i = paramInt;
      paramInt = j;
    } else {
      i = editPresenter.k();
    } 
    if (!this.g.j())
      paramInt = 0; 
    this.g.a(i, paramInt);
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\view\EditVolumeView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */