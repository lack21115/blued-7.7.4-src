package com.soft.blued.base.mvp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import java.lang.ref.WeakReference;

public abstract class MVPBasePresent<T> {
  protected WeakReference<T> a;
  
  public abstract void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void a(Bundle paramBundle);
  
  public void a(T paramT) {
    this.a = new WeakReference<T>(paramT);
  }
  
  public T aV_() {
    WeakReference<T> weakReference = this.a;
    return (weakReference != null) ? weakReference.get() : null;
  }
  
  public void b() {
    WeakReference<T> weakReference = this.a;
    if (weakReference != null) {
      weakReference.clear();
      this.a = null;
    } 
    c();
  }
  
  public abstract void b(Bundle paramBundle);
  
  public abstract void c();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\base\mvp\MVPBasePresent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */