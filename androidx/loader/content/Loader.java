package androidx.loader.content;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import androidx.core.util.DebugUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class Loader<D> {
  int n;
  
  OnLoadCompleteListener<D> o;
  
  OnLoadCanceledListener<D> p;
  
  Context q;
  
  boolean r = false;
  
  boolean s = false;
  
  boolean t = true;
  
  boolean u = false;
  
  boolean v = false;
  
  public Loader(Context paramContext) {
    this.q = paramContext.getApplicationContext();
  }
  
  protected void a() {}
  
  public void abandon() {
    this.s = true;
    h();
  }
  
  protected boolean b() {
    return false;
  }
  
  public boolean cancelLoad() {
    return b();
  }
  
  public void commitContentChanged() {
    this.v = false;
  }
  
  public String dataToString(D paramD) {
    StringBuilder stringBuilder = new StringBuilder(64);
    DebugUtils.buildShortClassTag(paramD, stringBuilder);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
  
  public void deliverCancellation() {
    OnLoadCanceledListener<D> onLoadCanceledListener = this.p;
    if (onLoadCanceledListener != null)
      onLoadCanceledListener.onLoadCanceled(this); 
  }
  
  public void deliverResult(D paramD) {
    OnLoadCompleteListener<D> onLoadCompleteListener = this.o;
    if (onLoadCompleteListener != null)
      onLoadCompleteListener.onLoadComplete(this, paramD); 
  }
  
  @Deprecated
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mId=");
    paramPrintWriter.print(this.n);
    paramPrintWriter.print(" mListener=");
    paramPrintWriter.println(this.o);
    if (this.r || this.u || this.v) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStarted=");
      paramPrintWriter.print(this.r);
      paramPrintWriter.print(" mContentChanged=");
      paramPrintWriter.print(this.u);
      paramPrintWriter.print(" mProcessingChange=");
      paramPrintWriter.println(this.v);
    } 
    if (this.s || this.t) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mAbandoned=");
      paramPrintWriter.print(this.s);
      paramPrintWriter.print(" mReset=");
      paramPrintWriter.println(this.t);
    } 
  }
  
  protected void e() {}
  
  protected void f() {}
  
  public void forceLoad() {
    a();
  }
  
  protected void g() {}
  
  public Context getContext() {
    return this.q;
  }
  
  public int getId() {
    return this.n;
  }
  
  protected void h() {}
  
  public boolean isAbandoned() {
    return this.s;
  }
  
  public boolean isReset() {
    return this.t;
  }
  
  public boolean isStarted() {
    return this.r;
  }
  
  public void onContentChanged() {
    if (this.r) {
      forceLoad();
      return;
    } 
    this.u = true;
  }
  
  public void registerListener(int paramInt, OnLoadCompleteListener<D> paramOnLoadCompleteListener) {
    if (this.o == null) {
      this.o = paramOnLoadCompleteListener;
      this.n = paramInt;
      return;
    } 
    throw new IllegalStateException("There is already a listener registered");
  }
  
  public void registerOnLoadCanceledListener(OnLoadCanceledListener<D> paramOnLoadCanceledListener) {
    if (this.p == null) {
      this.p = paramOnLoadCanceledListener;
      return;
    } 
    throw new IllegalStateException("There is already a listener registered");
  }
  
  public void reset() {
    g();
    this.t = true;
    this.r = false;
    this.s = false;
    this.u = false;
    this.v = false;
  }
  
  public void rollbackContentChanged() {
    if (this.v)
      onContentChanged(); 
  }
  
  public final void startLoading() {
    this.r = true;
    this.t = false;
    this.s = false;
    e();
  }
  
  public void stopLoading() {
    this.r = false;
    f();
  }
  
  public boolean takeContentChanged() {
    boolean bool = this.u;
    this.u = false;
    this.v |= bool;
    return bool;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(64);
    DebugUtils.buildShortClassTag(this, stringBuilder);
    stringBuilder.append(" id=");
    stringBuilder.append(this.n);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
  
  public void unregisterListener(OnLoadCompleteListener<D> paramOnLoadCompleteListener) {
    OnLoadCompleteListener<D> onLoadCompleteListener = this.o;
    if (onLoadCompleteListener != null) {
      if (onLoadCompleteListener == paramOnLoadCompleteListener) {
        this.o = null;
        return;
      } 
      throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    } 
    throw new IllegalStateException("No listener register");
  }
  
  public void unregisterOnLoadCanceledListener(OnLoadCanceledListener<D> paramOnLoadCanceledListener) {
    OnLoadCanceledListener<D> onLoadCanceledListener = this.p;
    if (onLoadCanceledListener != null) {
      if (onLoadCanceledListener == paramOnLoadCanceledListener) {
        this.p = null;
        return;
      } 
      throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    } 
    throw new IllegalStateException("No listener register");
  }
  
  public final class ForceLoadContentObserver extends ContentObserver {
    public ForceLoadContentObserver(Loader this$0) {
      super(new Handler());
    }
    
    public boolean deliverSelfNotifications() {
      return true;
    }
    
    public void onChange(boolean param1Boolean) {
      this.a.onContentChanged();
    }
  }
  
  public static interface OnLoadCanceledListener<D> {
    void onLoadCanceled(Loader<D> param1Loader);
  }
  
  public static interface OnLoadCompleteListener<D> {
    void onLoadComplete(Loader<D> param1Loader, D param1D);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\loader\content\Loader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */