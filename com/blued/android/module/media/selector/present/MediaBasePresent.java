package com.blued.android.module.media.selector.present;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import java.lang.ref.WeakReference;

public abstract class MediaBasePresent<T> {
  protected WeakReference<T> b;
  
  public abstract void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void a(Bundle paramBundle);
  
  public void a(T paramT) {
    this.b = new WeakReference<T>(paramT);
  }
  
  public abstract void b(Bundle paramBundle);
  
  public abstract void j();
  
  public T p() {
    WeakReference<T> weakReference = this.b;
    return (weakReference != null) ? weakReference.get() : null;
  }
  
  public void q() {
    WeakReference<T> weakReference = this.b;
    if (weakReference != null) {
      weakReference.clear();
      this.b = null;
    } 
    j();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\media\selector\present\MediaBasePresent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */