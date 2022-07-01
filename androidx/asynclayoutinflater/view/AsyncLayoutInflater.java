package androidx.asynclayoutinflater.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.Pools;
import java.util.concurrent.ArrayBlockingQueue;

public final class AsyncLayoutInflater {
  LayoutInflater a;
  
  Handler b;
  
  InflateThread c;
  
  private Handler.Callback d = new Handler.Callback(this) {
      public boolean handleMessage(Message param1Message) {
        AsyncLayoutInflater.InflateRequest inflateRequest = (AsyncLayoutInflater.InflateRequest)param1Message.obj;
        if (inflateRequest.d == null)
          inflateRequest.d = this.a.a.inflate(inflateRequest.c, inflateRequest.b, false); 
        inflateRequest.e.onInflateFinished(inflateRequest.d, inflateRequest.c, inflateRequest.b);
        this.a.c.releaseRequest(inflateRequest);
        return true;
      }
    };
  
  public AsyncLayoutInflater(Context paramContext) {
    this.a = new BasicInflater(paramContext);
    this.b = new Handler(this.d);
    this.c = InflateThread.getInstance();
  }
  
  public void inflate(int paramInt, ViewGroup paramViewGroup, OnInflateFinishedListener paramOnInflateFinishedListener) {
    if (paramOnInflateFinishedListener != null) {
      InflateRequest inflateRequest = this.c.obtainRequest();
      inflateRequest.a = this;
      inflateRequest.c = paramInt;
      inflateRequest.b = paramViewGroup;
      inflateRequest.e = paramOnInflateFinishedListener;
      this.c.enqueue(inflateRequest);
      return;
    } 
    throw new NullPointerException("callback argument may not be null!");
  }
  
  static class BasicInflater extends LayoutInflater {
    private static final String[] a = new String[] { "android.widget.", "android.webkit.", "android.app." };
    
    BasicInflater(Context param1Context) {
      super(param1Context);
    }
    
    public LayoutInflater cloneInContext(Context param1Context) {
      return new BasicInflater(param1Context);
    }
    
    protected View onCreateView(String param1String, AttributeSet param1AttributeSet) throws ClassNotFoundException {
      String[] arrayOfString = a;
      int j = arrayOfString.length;
      int i = 0;
      while (true) {
        if (i < j) {
          String str = arrayOfString[i];
          try {
            View view = createView(param1String, str, param1AttributeSet);
            if (view != null)
              return view; 
          } catch (ClassNotFoundException classNotFoundException) {}
          i++;
          continue;
        } 
        return super.onCreateView(param1String, param1AttributeSet);
      } 
    }
  }
  
  static class InflateRequest {
    AsyncLayoutInflater a;
    
    ViewGroup b;
    
    int c;
    
    View d;
    
    AsyncLayoutInflater.OnInflateFinishedListener e;
  }
  
  static class InflateThread extends Thread {
    private static final InflateThread a = new InflateThread();
    
    private ArrayBlockingQueue<AsyncLayoutInflater.InflateRequest> b = new ArrayBlockingQueue<AsyncLayoutInflater.InflateRequest>(10);
    
    private Pools.SynchronizedPool<AsyncLayoutInflater.InflateRequest> c = new Pools.SynchronizedPool(10);
    
    static {
      a.start();
    }
    
    public static InflateThread getInstance() {
      return a;
    }
    
    public void enqueue(AsyncLayoutInflater.InflateRequest param1InflateRequest) {
      try {
        this.b.put(param1InflateRequest);
        return;
      } catch (InterruptedException interruptedException) {
        throw new RuntimeException("Failed to enqueue async inflate request", interruptedException);
      } 
    }
    
    public AsyncLayoutInflater.InflateRequest obtainRequest() {
      AsyncLayoutInflater.InflateRequest inflateRequest2 = (AsyncLayoutInflater.InflateRequest)this.c.acquire();
      AsyncLayoutInflater.InflateRequest inflateRequest1 = inflateRequest2;
      if (inflateRequest2 == null)
        inflateRequest1 = new AsyncLayoutInflater.InflateRequest(); 
      return inflateRequest1;
    }
    
    public void releaseRequest(AsyncLayoutInflater.InflateRequest param1InflateRequest) {
      param1InflateRequest.e = null;
      param1InflateRequest.a = null;
      param1InflateRequest.b = null;
      param1InflateRequest.c = 0;
      param1InflateRequest.d = null;
      this.c.release(param1InflateRequest);
    }
    
    public void run() {
      while (true)
        runInner(); 
    }
    
    public void runInner() {
      try {
        AsyncLayoutInflater.InflateRequest inflateRequest = this.b.take();
        try {
          inflateRequest.d = inflateRequest.a.a.inflate(inflateRequest.c, inflateRequest.b, false);
        } catch (RuntimeException runtimeException) {
          Log.w("AsyncLayoutInflater", "Failed to inflate resource in the background! Retrying on the UI thread", runtimeException);
        } 
        Message.obtain(inflateRequest.a.b, 0, inflateRequest).sendToTarget();
        return;
      } catch (InterruptedException interruptedException) {
        Log.w("AsyncLayoutInflater", interruptedException);
        return;
      } 
    }
  }
  
  public static interface OnInflateFinishedListener {
    void onInflateFinished(View param1View, int param1Int, ViewGroup param1ViewGroup);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\asynclayoutinflater\view\AsyncLayoutInflater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */