package androidx.loader.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.os.OperationCanceledException;
import androidx.core.util.TimeUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

public abstract class AsyncTaskLoader<D> extends Loader<D> {
  volatile LoadTask a;
  
  volatile LoadTask b;
  
  long c;
  
  long d = -10000L;
  
  Handler e;
  
  private final Executor f;
  
  public AsyncTaskLoader(Context paramContext) {
    this(paramContext, ModernAsyncTask.THREAD_POOL_EXECUTOR);
  }
  
  private AsyncTaskLoader(Context paramContext, Executor paramExecutor) {
    super(paramContext);
    this.f = paramExecutor;
  }
  
  protected void a() {
    super.a();
    cancelLoad();
    this.a = new LoadTask(this);
    c();
  }
  
  void a(LoadTask paramLoadTask, D paramD) {
    onCanceled(paramD);
    if (this.b == paramLoadTask) {
      rollbackContentChanged();
      this.d = SystemClock.uptimeMillis();
      this.b = null;
      deliverCancellation();
      c();
    } 
  }
  
  void b(LoadTask paramLoadTask, D paramD) {
    if (this.a != paramLoadTask) {
      a(paramLoadTask, paramD);
      return;
    } 
    if (isAbandoned()) {
      onCanceled(paramD);
      return;
    } 
    commitContentChanged();
    this.d = SystemClock.uptimeMillis();
    this.a = null;
    deliverResult(paramD);
  }
  
  protected boolean b() {
    if (this.a != null) {
      if (!this.r)
        this.u = true; 
      if (this.b != null) {
        if (this.a.a) {
          this.a.a = false;
          this.e.removeCallbacks(this.a);
        } 
        this.a = null;
        return false;
      } 
      if (this.a.a) {
        this.a.a = false;
        this.e.removeCallbacks(this.a);
        this.a = null;
        return false;
      } 
      boolean bool = this.a.cancel(false);
      if (bool) {
        this.b = this.a;
        cancelLoadInBackground();
      } 
      this.a = null;
      return bool;
    } 
    return false;
  }
  
  void c() {
    if (this.b == null && this.a != null) {
      if (this.a.a) {
        this.a.a = false;
        this.e.removeCallbacks(this.a);
      } 
      if (this.c > 0L && SystemClock.uptimeMillis() < this.d + this.c) {
        this.a.a = true;
        this.e.postAtTime(this.a, this.d + this.c);
        return;
      } 
      this.a.executeOnExecutor(this.f, (Void[])null);
    } 
  }
  
  public void cancelLoadInBackground() {}
  
  protected D d() {
    return loadInBackground();
  }
  
  @Deprecated
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    if (this.a != null) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mTask=");
      paramPrintWriter.print(this.a);
      paramPrintWriter.print(" waiting=");
      paramPrintWriter.println(this.a.a);
    } 
    if (this.b != null) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mCancellingTask=");
      paramPrintWriter.print(this.b);
      paramPrintWriter.print(" waiting=");
      paramPrintWriter.println(this.b.a);
    } 
    if (this.c != 0L) {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mUpdateThrottle=");
      TimeUtils.formatDuration(this.c, paramPrintWriter);
      paramPrintWriter.print(" mLastLoadCompleteTime=");
      TimeUtils.formatDuration(this.d, SystemClock.uptimeMillis(), paramPrintWriter);
      paramPrintWriter.println();
    } 
  }
  
  public boolean isLoadInBackgroundCanceled() {
    return (this.b != null);
  }
  
  public abstract D loadInBackground();
  
  public void onCanceled(D paramD) {}
  
  public void setUpdateThrottle(long paramLong) {
    this.c = paramLong;
    if (paramLong != 0L)
      this.e = new Handler(); 
  }
  
  public void waitForLoader() {
    LoadTask loadTask = this.a;
    if (loadTask != null)
      loadTask.waitForLoader(); 
  }
  
  final class LoadTask extends ModernAsyncTask<Void, Void, D> implements Runnable {
    boolean a;
    
    private final CountDownLatch e = new CountDownLatch(1);
    
    LoadTask(AsyncTaskLoader this$0) {}
    
    protected D a(Void... param1VarArgs) {
      try {
        return (D)this.b.d();
      } catch (OperationCanceledException operationCanceledException) {
        if (isCancelled())
          return null; 
        throw operationCanceledException;
      } 
    }
    
    protected void a(D param1D) {
      try {
        this.b.b(this, param1D);
        return;
      } finally {
        this.e.countDown();
      } 
    }
    
    protected void b(D param1D) {
      try {
        this.b.a(this, param1D);
        return;
      } finally {
        this.e.countDown();
      } 
    }
    
    public void run() {
      this.a = false;
      this.b.c();
    }
    
    public void waitForLoader() {
      try {
        this.e.await();
        return;
      } catch (InterruptedException interruptedException) {
        return;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\loader\content\AsyncTaskLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */