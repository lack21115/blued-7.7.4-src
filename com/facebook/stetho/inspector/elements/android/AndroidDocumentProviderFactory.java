package com.facebook.stetho.inspector.elements.android;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import com.facebook.stetho.common.ThreadBound;
import com.facebook.stetho.common.UncheckedCallable;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.common.android.HandlerUtil;
import com.facebook.stetho.inspector.elements.DescriptorProvider;
import com.facebook.stetho.inspector.elements.DocumentProvider;
import com.facebook.stetho.inspector.elements.DocumentProviderFactory;
import java.util.List;

public final class AndroidDocumentProviderFactory implements ThreadBound, DocumentProviderFactory {
  private final Application mApplication;
  
  private final List<DescriptorProvider> mDescriptorProviders;
  
  private final Handler mHandler;
  
  public AndroidDocumentProviderFactory(Application paramApplication, List<DescriptorProvider> paramList) {
    this.mApplication = (Application)Util.throwIfNull(paramApplication);
    this.mDescriptorProviders = (List<DescriptorProvider>)Util.throwIfNull(paramList);
    this.mHandler = new Handler(Looper.getMainLooper());
  }
  
  public boolean checkThreadAccess() {
    return HandlerUtil.checkThreadAccess(this.mHandler);
  }
  
  public DocumentProvider create() {
    return new AndroidDocumentProvider(this.mApplication, this.mDescriptorProviders, this);
  }
  
  public <V> V postAndWait(UncheckedCallable<V> paramUncheckedCallable) {
    return (V)HandlerUtil.postAndWait(this.mHandler, paramUncheckedCallable);
  }
  
  public void postAndWait(Runnable paramRunnable) {
    HandlerUtil.postAndWait(this.mHandler, paramRunnable);
  }
  
  public void postDelayed(Runnable paramRunnable, long paramLong) {
    if (this.mHandler.postDelayed(paramRunnable, paramLong))
      return; 
    throw new RuntimeException("Handler.postDelayed() returned false");
  }
  
  public void removeCallbacks(Runnable paramRunnable) {
    this.mHandler.removeCallbacks(paramRunnable);
  }
  
  public void verifyThreadAccess() {
    HandlerUtil.verifyThreadAccess(this.mHandler);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\elements\android\AndroidDocumentProviderFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */