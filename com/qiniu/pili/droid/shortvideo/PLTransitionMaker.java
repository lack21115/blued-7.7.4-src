package com.qiniu.pili.droid.shortvideo;

import android.view.View;
import android.view.ViewGroup;
import com.qiniu.pili.droid.shortvideo.core.QosManager;
import com.qiniu.pili.droid.shortvideo.core.s;

public class PLTransitionMaker {
  private s mTransitionMakerCore;
  
  public PLTransitionMaker(ViewGroup paramViewGroup, PLVideoEncodeSetting paramPLVideoEncodeSetting) {
    this.mTransitionMakerCore = new s(paramViewGroup, paramPLVideoEncodeSetting);
  }
  
  public void addImage(PLImageView paramPLImageView) {
    this.mTransitionMakerCore.a(paramPLImageView);
  }
  
  public void addText(PLTextView paramPLTextView) {
    this.mTransitionMakerCore.a(paramPLTextView);
  }
  
  public void addTransition(PLImageView paramPLImageView, PLTransition paramPLTransition) {
    this.mTransitionMakerCore.a((View)paramPLImageView, paramPLTransition);
  }
  
  public void addTransition(PLTextView paramPLTextView, PLTransition paramPLTransition) {
    this.mTransitionMakerCore.a((View)paramPLTextView, paramPLTransition);
  }
  
  public void cancelSave() {
    this.mTransitionMakerCore.d();
  }
  
  public void destroy() {
    this.mTransitionMakerCore.e();
  }
  
  public void play() {
    this.mTransitionMakerCore.c();
  }
  
  public void removeAllResource() {
    this.mTransitionMakerCore.a();
  }
  
  public void save(String paramString, PLVideoSaveListener paramPLVideoSaveListener) {
    this.mTransitionMakerCore.a(paramString, paramPLVideoSaveListener);
    QosManager.a().a(QosManager.KeyPoint.transition_make);
    QosManager.a().a(this.mTransitionMakerCore.f());
  }
  
  public void setBackgroundColor(int paramInt) {
    this.mTransitionMakerCore.b(paramInt);
  }
  
  public void setDuration(int paramInt) {
    this.mTransitionMakerCore.a(paramInt);
  }
  
  public void stop() {
    this.mTransitionMakerCore.b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLTransitionMaker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */