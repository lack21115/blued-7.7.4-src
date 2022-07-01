package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.Loader;
import android.support.v4.util.DebugUtils;
import java.io.PrintWriter;

final class LoaderManagerImpl$LoaderInfo implements Loader.OnLoadCanceledListener, Loader.OnLoadCompleteListener {
  private Bundle mArgs;
  
  LoaderManager$LoaderCallbacks mCallbacks;
  
  Object mData;
  
  boolean mDeliveredData;
  
  private boolean mDestroyed;
  
  boolean mHaveData;
  
  final int mId;
  
  boolean mListenerRegistered;
  
  Loader mLoader;
  
  private LoaderManagerImpl$LoaderInfo mPendingLoader;
  
  boolean mReportNextStart;
  
  boolean mRetaining;
  
  boolean mRetainingStarted;
  
  boolean mStarted;
  
  final void callOnLoadFinished(Loader paramLoader, Object paramObject) {
    if (this.mCallbacks != null) {
      String str = null;
      if (this.this$0.mHost != null) {
        str = this.this$0.mHost.mFragmentManager.mNoTransactionsBecause;
        this.this$0.mHost.mFragmentManager.mNoTransactionsBecause = "onLoadFinished";
      } 
      try {
        if (LoaderManagerImpl.DEBUG) {
          StringBuilder stringBuilder2 = new StringBuilder("  onLoadFinished in ");
          stringBuilder2.append(paramLoader);
          stringBuilder2.append(": ");
          StringBuilder stringBuilder1 = new StringBuilder(64);
          DebugUtils.buildShortClassTag(paramObject, stringBuilder1);
          stringBuilder1.append("}");
          stringBuilder2.append(stringBuilder1.toString());
        } 
        if (this.this$0.mHost != null)
          this.this$0.mHost.mFragmentManager.mNoTransactionsBecause = str; 
        return;
      } finally {
        if (this.this$0.mHost != null)
          this.this$0.mHost.mFragmentManager.mNoTransactionsBecause = str; 
      } 
    } 
  }
  
  final void destroy() {
    LoaderManagerImpl$LoaderInfo loaderManagerImpl$LoaderInfo = this;
    while (true) {
      if (LoaderManagerImpl.DEBUG)
        (new StringBuilder("  Destroying: ")).append(loaderManagerImpl$LoaderInfo); 
      loaderManagerImpl$LoaderInfo.mDestroyed = true;
      boolean bool = loaderManagerImpl$LoaderInfo.mDeliveredData;
      loaderManagerImpl$LoaderInfo.mDeliveredData = false;
      if (loaderManagerImpl$LoaderInfo.mCallbacks != null && loaderManagerImpl$LoaderInfo.mLoader != null && loaderManagerImpl$LoaderInfo.mHaveData && bool) {
        String str;
        if (LoaderManagerImpl.DEBUG)
          (new StringBuilder("  Resetting: ")).append(loaderManagerImpl$LoaderInfo); 
        if (loaderManagerImpl$LoaderInfo.this$0.mHost != null) {
          str = loaderManagerImpl$LoaderInfo.this$0.mHost.mFragmentManager.mNoTransactionsBecause;
          loaderManagerImpl$LoaderInfo.this$0.mHost.mFragmentManager.mNoTransactionsBecause = "onLoaderReset";
        } else {
          str = null;
        } 
        if (loaderManagerImpl$LoaderInfo.this$0.mHost != null)
          loaderManagerImpl$LoaderInfo.this$0.mHost.mFragmentManager.mNoTransactionsBecause = str; 
      } 
      loaderManagerImpl$LoaderInfo.mCallbacks = null;
      loaderManagerImpl$LoaderInfo.mData = null;
      loaderManagerImpl$LoaderInfo.mHaveData = false;
      if (loaderManagerImpl$LoaderInfo.mLoader != null) {
        if (loaderManagerImpl$LoaderInfo.mListenerRegistered) {
          loaderManagerImpl$LoaderInfo.mListenerRegistered = false;
          loaderManagerImpl$LoaderInfo.mLoader.unregisterListener(loaderManagerImpl$LoaderInfo);
          loaderManagerImpl$LoaderInfo.mLoader.unregisterOnLoadCanceledListener(loaderManagerImpl$LoaderInfo);
        } 
        Loader loader = loaderManagerImpl$LoaderInfo.mLoader;
        loader.mReset = true;
        loader.mStarted = false;
        loader.mAbandoned = false;
        loader.mContentChanged = false;
        loader.mProcessingChange = false;
      } 
      if (loaderManagerImpl$LoaderInfo.mPendingLoader != null) {
        loaderManagerImpl$LoaderInfo = loaderManagerImpl$LoaderInfo.mPendingLoader;
        continue;
      } 
      break;
    } 
  }
  
  public final void dump$ec96877$79f041d6(String paramString, PrintWriter paramPrintWriter) {
    LoaderManagerImpl$LoaderInfo loaderManagerImpl$LoaderInfo = this;
    while (true) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mId=");
      paramPrintWriter.print(loaderManagerImpl$LoaderInfo.mId);
      paramPrintWriter.print(" mArgs=");
      paramPrintWriter.println(loaderManagerImpl$LoaderInfo.mArgs);
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mCallbacks=");
      paramPrintWriter.println(loaderManagerImpl$LoaderInfo.mCallbacks);
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mLoader=");
      paramPrintWriter.println(loaderManagerImpl$LoaderInfo.mLoader);
      if (loaderManagerImpl$LoaderInfo.mLoader != null) {
        Loader loader = loaderManagerImpl$LoaderInfo.mLoader;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramString);
        stringBuilder.append("  ");
        String str = stringBuilder.toString();
        paramPrintWriter.print(str);
        paramPrintWriter.print("mId=");
        paramPrintWriter.print(loader.mId);
        paramPrintWriter.print(" mListener=");
        paramPrintWriter.println(loader.mListener);
        if (loader.mStarted || loader.mContentChanged || loader.mProcessingChange) {
          paramPrintWriter.print(str);
          paramPrintWriter.print("mStarted=");
          paramPrintWriter.print(loader.mStarted);
          paramPrintWriter.print(" mContentChanged=");
          paramPrintWriter.print(loader.mContentChanged);
          paramPrintWriter.print(" mProcessingChange=");
          paramPrintWriter.println(loader.mProcessingChange);
        } 
        if (loader.mAbandoned || loader.mReset) {
          paramPrintWriter.print(str);
          paramPrintWriter.print("mAbandoned=");
          paramPrintWriter.print(loader.mAbandoned);
          paramPrintWriter.print(" mReset=");
          paramPrintWriter.println(loader.mReset);
        } 
      } 
      if (loaderManagerImpl$LoaderInfo.mHaveData || loaderManagerImpl$LoaderInfo.mDeliveredData) {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mHaveData=");
        paramPrintWriter.print(loaderManagerImpl$LoaderInfo.mHaveData);
        paramPrintWriter.print("  mDeliveredData=");
        paramPrintWriter.println(loaderManagerImpl$LoaderInfo.mDeliveredData);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mData=");
        paramPrintWriter.println(loaderManagerImpl$LoaderInfo.mData);
      } 
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStarted=");
      paramPrintWriter.print(loaderManagerImpl$LoaderInfo.mStarted);
      paramPrintWriter.print(" mReportNextStart=");
      paramPrintWriter.print(loaderManagerImpl$LoaderInfo.mReportNextStart);
      paramPrintWriter.print(" mDestroyed=");
      paramPrintWriter.println(loaderManagerImpl$LoaderInfo.mDestroyed);
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mRetaining=");
      paramPrintWriter.print(loaderManagerImpl$LoaderInfo.mRetaining);
      paramPrintWriter.print(" mRetainingStarted=");
      paramPrintWriter.print(loaderManagerImpl$LoaderInfo.mRetainingStarted);
      paramPrintWriter.print(" mListenerRegistered=");
      paramPrintWriter.println(loaderManagerImpl$LoaderInfo.mListenerRegistered);
      if (loaderManagerImpl$LoaderInfo.mPendingLoader != null) {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Pending Loader ");
        paramPrintWriter.print(loaderManagerImpl$LoaderInfo.mPendingLoader);
        paramPrintWriter.println(":");
        loaderManagerImpl$LoaderInfo = loaderManagerImpl$LoaderInfo.mPendingLoader;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramString);
        stringBuilder.append("  ");
        paramString = stringBuilder.toString();
        continue;
      } 
      break;
    } 
  }
  
  final void stop() {
    if (LoaderManagerImpl.DEBUG)
      (new StringBuilder("  Stopping: ")).append(this); 
    this.mStarted = false;
    if (!this.mRetaining && this.mLoader != null && this.mListenerRegistered) {
      this.mListenerRegistered = false;
      this.mLoader.unregisterListener(this);
      this.mLoader.unregisterOnLoadCanceledListener(this);
      this.mLoader.mStarted = false;
    } 
  }
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder(64);
    stringBuilder.append("LoaderInfo{");
    stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    stringBuilder.append(" #");
    stringBuilder.append(this.mId);
    stringBuilder.append(" : ");
    DebugUtils.buildShortClassTag(this.mLoader, stringBuilder);
    stringBuilder.append("}}");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\LoaderManagerImpl$LoaderInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */