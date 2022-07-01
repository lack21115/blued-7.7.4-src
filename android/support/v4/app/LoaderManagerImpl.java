package android.support.v4.app;

import android.support.v4.content.Loader;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.SparseArrayCompat;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

final class LoaderManagerImpl extends LoaderManager {
  static boolean DEBUG = false;
  
  FragmentHostCallback mHost;
  
  private SparseArrayCompat mInactiveLoaders = new SparseArrayCompat();
  
  final SparseArrayCompat mLoaders = new SparseArrayCompat();
  
  boolean mRetaining;
  
  boolean mStarted;
  
  final String mWho;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  LoaderManagerImpl(String paramString, FragmentHostCallback paramFragmentHostCallback, boolean paramBoolean) {
    this.mWho = paramString;
    this.mHost = paramFragmentHostCallback;
    this.mStarted = paramBoolean;
  }
  
  final void doDestroy() {
    if (!this.mRetaining) {
      if (DEBUG)
        (new StringBuilder("Destroying Active in ")).append(this); 
      for (int j = this.mLoaders.size() - 1; j >= 0; j--)
        ((LoaderManagerImpl$LoaderInfo)this.mLoaders.valueAt(j)).destroy(); 
      this.mLoaders.clear();
    } 
    if (DEBUG)
      (new StringBuilder("Destroying Inactive in ")).append(this); 
    for (int i = this.mInactiveLoaders.size() - 1; i >= 0; i--)
      ((LoaderManagerImpl$LoaderInfo)this.mInactiveLoaders.valueAt(i)).destroy(); 
    this.mInactiveLoaders.clear();
    this.mHost = null;
  }
  
  final void doReportNextStart() {
    for (int i = this.mLoaders.size() - 1; i >= 0; i--)
      ((LoaderManagerImpl$LoaderInfo)this.mLoaders.valueAt(i)).mReportNextStart = true; 
  }
  
  final void doReportStart() {
    for (int i = this.mLoaders.size() - 1; i >= 0; i--) {
      LoaderManagerImpl$LoaderInfo loaderManagerImpl$LoaderInfo = (LoaderManagerImpl$LoaderInfo)this.mLoaders.valueAt(i);
      if (loaderManagerImpl$LoaderInfo.mStarted && loaderManagerImpl$LoaderInfo.mReportNextStart) {
        loaderManagerImpl$LoaderInfo.mReportNextStart = false;
        if (loaderManagerImpl$LoaderInfo.mHaveData && !loaderManagerImpl$LoaderInfo.mRetaining)
          loaderManagerImpl$LoaderInfo.callOnLoadFinished(loaderManagerImpl$LoaderInfo.mLoader, loaderManagerImpl$LoaderInfo.mData); 
      } 
    } 
  }
  
  final void doRetain() {
    if (DEBUG)
      (new StringBuilder("Retaining in ")).append(this); 
    if (!this.mStarted) {
      RuntimeException runtimeException = new RuntimeException("here");
      runtimeException.fillInStackTrace();
      StringBuilder stringBuilder = new StringBuilder("Called doRetain when not started: ");
      stringBuilder.append(this);
      Log.w("LoaderManager", stringBuilder.toString(), runtimeException);
      return;
    } 
    this.mRetaining = true;
    this.mStarted = false;
    for (int i = this.mLoaders.size() - 1; i >= 0; i--) {
      LoaderManagerImpl$LoaderInfo loaderManagerImpl$LoaderInfo = (LoaderManagerImpl$LoaderInfo)this.mLoaders.valueAt(i);
      if (DEBUG)
        (new StringBuilder("  Retaining: ")).append(loaderManagerImpl$LoaderInfo); 
      loaderManagerImpl$LoaderInfo.mRetaining = true;
      loaderManagerImpl$LoaderInfo.mRetainingStarted = loaderManagerImpl$LoaderInfo.mStarted;
      loaderManagerImpl$LoaderInfo.mStarted = false;
      loaderManagerImpl$LoaderInfo.mCallbacks = null;
    } 
  }
  
  final void doStart() {
    if (DEBUG)
      (new StringBuilder("Starting in ")).append(this); 
    if (this.mStarted) {
      RuntimeException runtimeException = new RuntimeException("here");
      runtimeException.fillInStackTrace();
      StringBuilder stringBuilder = new StringBuilder("Called doStart when already started: ");
      stringBuilder.append(this);
      Log.w("LoaderManager", stringBuilder.toString(), runtimeException);
      return;
    } 
    this.mStarted = true;
    for (int i = this.mLoaders.size() - 1; i >= 0; i--) {
      LoaderManagerImpl$LoaderInfo loaderManagerImpl$LoaderInfo = (LoaderManagerImpl$LoaderInfo)this.mLoaders.valueAt(i);
      if (loaderManagerImpl$LoaderInfo.mRetaining && loaderManagerImpl$LoaderInfo.mRetainingStarted) {
        loaderManagerImpl$LoaderInfo.mStarted = true;
      } else if (!loaderManagerImpl$LoaderInfo.mStarted) {
        loaderManagerImpl$LoaderInfo.mStarted = true;
        if (DEBUG)
          (new StringBuilder("  Starting: ")).append(loaderManagerImpl$LoaderInfo); 
        if (loaderManagerImpl$LoaderInfo.mLoader == null && loaderManagerImpl$LoaderInfo.mCallbacks != null)
          loaderManagerImpl$LoaderInfo.mLoader = loaderManagerImpl$LoaderInfo.mCallbacks.onCreateLoader$e57f803(); 
        if (loaderManagerImpl$LoaderInfo.mLoader != null) {
          Loader loader;
          if (!loaderManagerImpl$LoaderInfo.mLoader.getClass().isMemberClass() || Modifier.isStatic(loaderManagerImpl$LoaderInfo.mLoader.getClass().getModifiers())) {
            if (!loaderManagerImpl$LoaderInfo.mListenerRegistered) {
              Loader loader1 = loaderManagerImpl$LoaderInfo.mLoader;
              int j = loaderManagerImpl$LoaderInfo.mId;
              if (loader1.mListener == null) {
                loader1.mListener = loaderManagerImpl$LoaderInfo;
                loader1.mId = j;
                loader1 = loaderManagerImpl$LoaderInfo.mLoader;
                if (loader1.mOnLoadCanceledListener == null) {
                  loader1.mOnLoadCanceledListener = loaderManagerImpl$LoaderInfo;
                  loaderManagerImpl$LoaderInfo.mListenerRegistered = true;
                } else {
                  throw new IllegalStateException("There is already a listener registered");
                } 
              } else {
                throw new IllegalStateException("There is already a listener registered");
              } 
            } 
            loader = loaderManagerImpl$LoaderInfo.mLoader;
            loader.mStarted = true;
            loader.mReset = false;
            loader.mAbandoned = false;
          } else {
            StringBuilder stringBuilder = new StringBuilder("Object returned from onCreateLoader must not be a non-static inner member class: ");
            stringBuilder.append(((LoaderManagerImpl$LoaderInfo)loader).mLoader);
            throw new IllegalArgumentException(stringBuilder.toString());
          } 
        } 
      } 
    } 
  }
  
  final void doStop() {
    if (DEBUG)
      (new StringBuilder("Stopping in ")).append(this); 
    if (!this.mStarted) {
      RuntimeException runtimeException = new RuntimeException("here");
      runtimeException.fillInStackTrace();
      StringBuilder stringBuilder = new StringBuilder("Called doStop when not started: ");
      stringBuilder.append(this);
      Log.w("LoaderManager", stringBuilder.toString(), runtimeException);
      return;
    } 
    for (int i = this.mLoaders.size() - 1; i >= 0; i--)
      ((LoaderManagerImpl$LoaderInfo)this.mLoaders.valueAt(i)).stop(); 
    this.mStarted = false;
  }
  
  public final void dump$ec96877(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter) {
    int i = this.mLoaders.size();
    boolean bool = false;
    if (i > 0) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Active Loaders:");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append("    ");
      String str = stringBuilder.toString();
      for (i = 0; i < this.mLoaders.size(); i++) {
        LoaderManagerImpl$LoaderInfo loaderManagerImpl$LoaderInfo = (LoaderManagerImpl$LoaderInfo)this.mLoaders.valueAt(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(this.mLoaders.keyAt(i));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(loaderManagerImpl$LoaderInfo.toString());
        loaderManagerImpl$LoaderInfo.dump$ec96877$79f041d6(str, paramPrintWriter);
      } 
    } 
    if (this.mInactiveLoaders.size() > 0) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Inactive Loaders:");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append("    ");
      String str = stringBuilder.toString();
      for (i = bool; i < this.mInactiveLoaders.size(); i++) {
        LoaderManagerImpl$LoaderInfo loaderManagerImpl$LoaderInfo = (LoaderManagerImpl$LoaderInfo)this.mInactiveLoaders.valueAt(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(this.mInactiveLoaders.keyAt(i));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(loaderManagerImpl$LoaderInfo.toString());
        loaderManagerImpl$LoaderInfo.dump$ec96877$79f041d6(str, paramPrintWriter);
      } 
    } 
  }
  
  public final boolean hasRunningLoaders() {
    int j = this.mLoaders.size();
    int i = 0;
    int k = 0;
    while (i < j) {
      byte b;
      LoaderManagerImpl$LoaderInfo loaderManagerImpl$LoaderInfo = (LoaderManagerImpl$LoaderInfo)this.mLoaders.valueAt(i);
      if (loaderManagerImpl$LoaderInfo.mStarted && !loaderManagerImpl$LoaderInfo.mDeliveredData) {
        b = 1;
      } else {
        b = 0;
      } 
      k |= b;
      i++;
    } 
    return k;
  }
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);
    stringBuilder.append("LoaderManager{");
    stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    stringBuilder.append(" in ");
    DebugUtils.buildShortClassTag(this.mHost, stringBuilder);
    stringBuilder.append("}}");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\LoaderManagerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */