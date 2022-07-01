package androidx.loader.app;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.collection.SparseArrayCompat;
import androidx.core.util.DebugUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

class LoaderManagerImpl extends LoaderManager {
  static boolean a = false;
  
  private final LifecycleOwner b;
  
  private final LoaderViewModel c;
  
  LoaderManagerImpl(LifecycleOwner paramLifecycleOwner, ViewModelStore paramViewModelStore) {
    this.b = paramLifecycleOwner;
    this.c = LoaderViewModel.a(paramViewModelStore);
  }
  
  private <D> Loader<D> a(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<D> paramLoaderCallbacks, Loader<D> paramLoader) {
    try {
      this.c.a();
      Loader<D> loader = paramLoaderCallbacks.onCreateLoader(paramInt, paramBundle);
      if (loader != null) {
        if (!loader.getClass().isMemberClass() || Modifier.isStatic(loader.getClass().getModifiers())) {
          LoaderInfo<D> loaderInfo = new LoaderInfo<D>(paramInt, paramBundle, loader, paramLoader);
          if (a) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("  Created new loader ");
            stringBuilder1.append(loaderInfo);
            Log.v("LoaderManager", stringBuilder1.toString());
          } 
          this.c.a(paramInt, loaderInfo);
          return loaderInfo.a(this.b, paramLoaderCallbacks);
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Object returned from onCreateLoader must not be a non-static inner member class: ");
        stringBuilder.append(loader);
        throw new IllegalArgumentException(stringBuilder.toString());
      } 
      throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
    } finally {
      this.c.c();
    } 
  }
  
  public void destroyLoader(int paramInt) {
    if (!this.c.b()) {
      if (Looper.getMainLooper() == Looper.myLooper()) {
        if (a) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("destroyLoader in ");
          stringBuilder.append(this);
          stringBuilder.append(" of ");
          stringBuilder.append(paramInt);
          Log.v("LoaderManager", stringBuilder.toString());
        } 
        LoaderInfo<?> loaderInfo = this.c.a(paramInt);
        if (loaderInfo != null) {
          loaderInfo.a(true);
          this.c.b(paramInt);
        } 
        return;
      } 
      throw new IllegalStateException("destroyLoader must be called on the main thread");
    } 
    throw new IllegalStateException("Called while creating a loader");
  }
  
  @Deprecated
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
    this.c.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  public <D> Loader<D> getLoader(int paramInt) {
    if (!this.c.b()) {
      LoaderInfo<?> loaderInfo = this.c.a(paramInt);
      return (Loader)((loaderInfo != null) ? loaderInfo.a() : null);
    } 
    throw new IllegalStateException("Called while creating a loader");
  }
  
  public boolean hasRunningLoaders() {
    return this.c.d();
  }
  
  public <D> Loader<D> initLoader(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<D> paramLoaderCallbacks) {
    if (!this.c.b()) {
      if (Looper.getMainLooper() == Looper.myLooper()) {
        LoaderInfo<?> loaderInfo = this.c.a(paramInt);
        if (a) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("initLoader in ");
          stringBuilder.append(this);
          stringBuilder.append(": args=");
          stringBuilder.append(paramBundle);
          Log.v("LoaderManager", stringBuilder.toString());
        } 
        if (loaderInfo == null)
          return a(paramInt, paramBundle, paramLoaderCallbacks, null); 
        if (a) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("  Re-using existing loader ");
          stringBuilder.append(loaderInfo);
          Log.v("LoaderManager", stringBuilder.toString());
        } 
        return (Loader)loaderInfo.a(this.b, paramLoaderCallbacks);
      } 
      throw new IllegalStateException("initLoader must be called on the main thread");
    } 
    throw new IllegalStateException("Called while creating a loader");
  }
  
  public void markForRedelivery() {
    this.c.e();
  }
  
  public <D> Loader<D> restartLoader(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<D> paramLoaderCallbacks) {
    if (!this.c.b()) {
      if (Looper.getMainLooper() == Looper.myLooper()) {
        if (a) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("restartLoader in ");
          stringBuilder.append(this);
          stringBuilder.append(": args=");
          stringBuilder.append(paramBundle);
          Log.v("LoaderManager", stringBuilder.toString());
        } 
        LoaderInfo<?> loaderInfo = this.c.a(paramInt);
        Loader<?> loader = null;
        if (loaderInfo != null)
          loader = loaderInfo.a(false); 
        return a(paramInt, paramBundle, paramLoaderCallbacks, (Loader)loader);
      } 
      throw new IllegalStateException("restartLoader must be called on the main thread");
    } 
    throw new IllegalStateException("Called while creating a loader");
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);
    stringBuilder.append("LoaderManager{");
    stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    stringBuilder.append(" in ");
    DebugUtils.buildShortClassTag(this.b, stringBuilder);
    stringBuilder.append("}}");
    return stringBuilder.toString();
  }
  
  public static class LoaderInfo<D> extends MutableLiveData<D> implements Loader.OnLoadCompleteListener<D> {
    private final int a;
    
    private final Bundle b;
    
    private final Loader<D> c;
    
    private LifecycleOwner d;
    
    private LoaderManagerImpl.LoaderObserver<D> e;
    
    private Loader<D> f;
    
    LoaderInfo(int param1Int, Bundle param1Bundle, Loader<D> param1Loader1, Loader<D> param1Loader2) {
      this.a = param1Int;
      this.b = param1Bundle;
      this.c = param1Loader1;
      this.f = param1Loader2;
      this.c.registerListener(param1Int, this);
    }
    
    Loader<D> a() {
      return this.c;
    }
    
    Loader<D> a(LifecycleOwner param1LifecycleOwner, LoaderManager.LoaderCallbacks<D> param1LoaderCallbacks) {
      LoaderManagerImpl.LoaderObserver<D> loaderObserver1 = new LoaderManagerImpl.LoaderObserver<D>(this.c, param1LoaderCallbacks);
      observe(param1LifecycleOwner, loaderObserver1);
      LoaderManagerImpl.LoaderObserver<D> loaderObserver2 = this.e;
      if (loaderObserver2 != null)
        removeObserver(loaderObserver2); 
      this.d = param1LifecycleOwner;
      this.e = loaderObserver1;
      return this.c;
    }
    
    Loader<D> a(boolean param1Boolean) {
      if (LoaderManagerImpl.a) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("  Destroying: ");
        stringBuilder.append(this);
        Log.v("LoaderManager", stringBuilder.toString());
      } 
      this.c.cancelLoad();
      this.c.abandon();
      LoaderManagerImpl.LoaderObserver<D> loaderObserver = this.e;
      if (loaderObserver != null) {
        removeObserver(loaderObserver);
        if (param1Boolean)
          loaderObserver.b(); 
      } 
      this.c.unregisterListener(this);
      if ((loaderObserver != null && !loaderObserver.a()) || param1Boolean) {
        this.c.reset();
        return this.f;
      } 
      return this.c;
    }
    
    void b() {
      LifecycleOwner lifecycleOwner = this.d;
      LoaderManagerImpl.LoaderObserver<D> loaderObserver = this.e;
      if (lifecycleOwner != null && loaderObserver != null) {
        super.removeObserver(loaderObserver);
        observe(lifecycleOwner, loaderObserver);
      } 
    }
    
    boolean c() {
      boolean bool = hasActiveObservers();
      boolean bool1 = false;
      if (!bool)
        return false; 
      LoaderManagerImpl.LoaderObserver<D> loaderObserver = this.e;
      bool = bool1;
      if (loaderObserver != null) {
        bool = bool1;
        if (!loaderObserver.a())
          bool = true; 
      } 
      return bool;
    }
    
    public void dump(String param1String, FileDescriptor param1FileDescriptor, PrintWriter param1PrintWriter, String[] param1ArrayOfString) {
      param1PrintWriter.print(param1String);
      param1PrintWriter.print("mId=");
      param1PrintWriter.print(this.a);
      param1PrintWriter.print(" mArgs=");
      param1PrintWriter.println(this.b);
      param1PrintWriter.print(param1String);
      param1PrintWriter.print("mLoader=");
      param1PrintWriter.println(this.c);
      Loader<D> loader = this.c;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(param1String);
      stringBuilder.append("  ");
      loader.dump(stringBuilder.toString(), param1FileDescriptor, param1PrintWriter, param1ArrayOfString);
      if (this.e != null) {
        param1PrintWriter.print(param1String);
        param1PrintWriter.print("mCallbacks=");
        param1PrintWriter.println(this.e);
        LoaderManagerImpl.LoaderObserver<D> loaderObserver = this.e;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(param1String);
        stringBuilder1.append("  ");
        loaderObserver.dump(stringBuilder1.toString(), param1PrintWriter);
      } 
      param1PrintWriter.print(param1String);
      param1PrintWriter.print("mData=");
      param1PrintWriter.println(a().dataToString(getValue()));
      param1PrintWriter.print(param1String);
      param1PrintWriter.print("mStarted=");
      param1PrintWriter.println(hasActiveObservers());
    }
    
    public void onActive() {
      if (LoaderManagerImpl.a) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("  Starting: ");
        stringBuilder.append(this);
        Log.v("LoaderManager", stringBuilder.toString());
      } 
      this.c.startLoading();
    }
    
    public void onInactive() {
      if (LoaderManagerImpl.a) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("  Stopping: ");
        stringBuilder.append(this);
        Log.v("LoaderManager", stringBuilder.toString());
      } 
      this.c.stopLoading();
    }
    
    public void onLoadComplete(Loader<D> param1Loader, D param1D) {
      if (LoaderManagerImpl.a) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onLoadComplete: ");
        stringBuilder.append(this);
        Log.v("LoaderManager", stringBuilder.toString());
      } 
      if (Looper.myLooper() == Looper.getMainLooper()) {
        setValue(param1D);
        return;
      } 
      if (LoaderManagerImpl.a)
        Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread"); 
      postValue(param1D);
    }
    
    public void removeObserver(Observer<? super D> param1Observer) {
      super.removeObserver(param1Observer);
      this.d = null;
      this.e = null;
    }
    
    public void setValue(D param1D) {
      super.setValue(param1D);
      Loader<D> loader = this.f;
      if (loader != null) {
        loader.reset();
        this.f = null;
      } 
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder(64);
      stringBuilder.append("LoaderInfo{");
      stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      stringBuilder.append(" #");
      stringBuilder.append(this.a);
      stringBuilder.append(" : ");
      DebugUtils.buildShortClassTag(this.c, stringBuilder);
      stringBuilder.append("}}");
      return stringBuilder.toString();
    }
  }
  
  static class LoaderObserver<D> implements Observer<D> {
    private final Loader<D> a;
    
    private final LoaderManager.LoaderCallbacks<D> b;
    
    private boolean c = false;
    
    LoaderObserver(Loader<D> param1Loader, LoaderManager.LoaderCallbacks<D> param1LoaderCallbacks) {
      this.a = param1Loader;
      this.b = param1LoaderCallbacks;
    }
    
    boolean a() {
      return this.c;
    }
    
    void b() {
      if (this.c) {
        if (LoaderManagerImpl.a) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("  Resetting: ");
          stringBuilder.append(this.a);
          Log.v("LoaderManager", stringBuilder.toString());
        } 
        this.b.onLoaderReset(this.a);
      } 
    }
    
    public void dump(String param1String, PrintWriter param1PrintWriter) {
      param1PrintWriter.print(param1String);
      param1PrintWriter.print("mDeliveredData=");
      param1PrintWriter.println(this.c);
    }
    
    public void onChanged(D param1D) {
      if (LoaderManagerImpl.a) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("  onLoadFinished in ");
        stringBuilder.append(this.a);
        stringBuilder.append(": ");
        stringBuilder.append(this.a.dataToString(param1D));
        Log.v("LoaderManager", stringBuilder.toString());
      } 
      this.b.onLoadFinished(this.a, param1D);
      this.c = true;
    }
    
    public String toString() {
      return this.b.toString();
    }
  }
  
  static class LoaderViewModel extends ViewModel {
    private static final ViewModelProvider.Factory a = new ViewModelProvider.Factory() {
        public <T extends ViewModel> T create(Class<T> param2Class) {
          return (T)new LoaderManagerImpl.LoaderViewModel();
        }
      };
    
    private SparseArrayCompat<LoaderManagerImpl.LoaderInfo> b = new SparseArrayCompat();
    
    private boolean c = false;
    
    static LoaderViewModel a(ViewModelStore param1ViewModelStore) {
      return (LoaderViewModel)(new ViewModelProvider(param1ViewModelStore, a)).get(LoaderViewModel.class);
    }
    
    <D> LoaderManagerImpl.LoaderInfo<D> a(int param1Int) {
      return (LoaderManagerImpl.LoaderInfo<D>)this.b.get(param1Int);
    }
    
    void a() {
      this.c = true;
    }
    
    void a(int param1Int, LoaderManagerImpl.LoaderInfo param1LoaderInfo) {
      this.b.put(param1Int, param1LoaderInfo);
    }
    
    void b(int param1Int) {
      this.b.remove(param1Int);
    }
    
    boolean b() {
      return this.c;
    }
    
    void c() {
      this.c = false;
    }
    
    boolean d() {
      int j = this.b.size();
      for (int i = 0; i < j; i++) {
        if (((LoaderManagerImpl.LoaderInfo)this.b.valueAt(i)).c())
          return true; 
      } 
      return false;
    }
    
    public void dump(String param1String, FileDescriptor param1FileDescriptor, PrintWriter param1PrintWriter, String[] param1ArrayOfString) {
      if (this.b.size() > 0) {
        param1PrintWriter.print(param1String);
        param1PrintWriter.println("Loaders:");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(param1String);
        stringBuilder.append("    ");
        String str = stringBuilder.toString();
        int i;
        for (i = 0; i < this.b.size(); i++) {
          LoaderManagerImpl.LoaderInfo loaderInfo = (LoaderManagerImpl.LoaderInfo)this.b.valueAt(i);
          param1PrintWriter.print(param1String);
          param1PrintWriter.print("  #");
          param1PrintWriter.print(this.b.keyAt(i));
          param1PrintWriter.print(": ");
          param1PrintWriter.println(loaderInfo.toString());
          loaderInfo.dump(str, param1FileDescriptor, param1PrintWriter, param1ArrayOfString);
        } 
      } 
    }
    
    void e() {
      int j = this.b.size();
      for (int i = 0; i < j; i++)
        ((LoaderManagerImpl.LoaderInfo)this.b.valueAt(i)).b(); 
    }
    
    public void onCleared() {
      super.onCleared();
      int j = this.b.size();
      for (int i = 0; i < j; i++)
        ((LoaderManagerImpl.LoaderInfo)this.b.valueAt(i)).a(true); 
      this.b.clear();
    }
  }
  
  static final class null implements ViewModelProvider.Factory {
    public <T extends ViewModel> T create(Class<T> param1Class) {
      return (T)new LoaderManagerImpl.LoaderViewModel();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\loader\app\LoaderManagerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */