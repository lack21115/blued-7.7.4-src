package com.facebook.stetho.inspector.screencast;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Base64OutputStream;
import android.view.View;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.inspector.elements.android.ActivityTracker;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.protocol.module.Page;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public final class ScreencastDispatcher {
  private static final long FRAME_DELAY = 200L;
  
  private final ActivityTracker mActivityTracker = ActivityTracker.get();
  
  private Handler mBackgroundHandler;
  
  private Bitmap mBitmap;
  
  private final BitmapFetchRunnable mBitmapFetchRunnable = new BitmapFetchRunnable();
  
  private Canvas mCanvas;
  
  private Page.ScreencastFrameEvent mEvent = new Page.ScreencastFrameEvent();
  
  private final EventDispatchRunnable mEventDispatchRunnable = new EventDispatchRunnable();
  
  private HandlerThread mHandlerThread;
  
  private boolean mIsRunning;
  
  private final Handler mMainHandler = new Handler(Looper.getMainLooper());
  
  private Page.ScreencastFrameEventMetadata mMetadata = new Page.ScreencastFrameEventMetadata();
  
  private JsonRpcPeer mPeer;
  
  private Page.StartScreencastRequest mRequest;
  
  private ByteArrayOutputStream mStream;
  
  private final RectF mTempDst = new RectF();
  
  private final RectF mTempSrc = new RectF();
  
  public void startScreencast(JsonRpcPeer paramJsonRpcPeer, Page.StartScreencastRequest paramStartScreencastRequest) {
    LogUtil.d("Starting screencast");
    this.mRequest = paramStartScreencastRequest;
    this.mHandlerThread = new HandlerThread("Screencast Thread");
    this.mHandlerThread.start();
    this.mPeer = paramJsonRpcPeer;
    this.mIsRunning = true;
    this.mStream = new ByteArrayOutputStream();
    this.mBackgroundHandler = new Handler(this.mHandlerThread.getLooper());
    this.mMainHandler.postDelayed(this.mBitmapFetchRunnable, 200L);
  }
  
  public void stopScreencast() {
    LogUtil.d("Stopping screencast");
    this.mBackgroundHandler.post(new CancellationRunnable());
  }
  
  class BitmapFetchRunnable implements Runnable {
    private BitmapFetchRunnable() {}
    
    private void updateScreenBitmap() {
      if (!ScreencastDispatcher.this.mIsRunning)
        return; 
      Activity activity = ScreencastDispatcher.this.mActivityTracker.tryGetTopActivity();
      if (activity == null)
        return; 
      View view = activity.getWindow().getDecorView();
      try {
        if (ScreencastDispatcher.this.mBitmap == null) {
          int i = view.getWidth();
          int j = view.getHeight();
          float f2 = ScreencastDispatcher.this.mRequest.maxWidth;
          float f1 = i;
          float f3 = f2 / f1;
          float f4 = ScreencastDispatcher.this.mRequest.maxHeight;
          f2 = j;
          f3 = Math.min(f3, f4 / f2);
          i = (int)(f1 * f3);
          j = (int)(f3 * f2);
          ScreencastDispatcher.access$802(ScreencastDispatcher.this, Bitmap.createBitmap(i, j, Bitmap.Config.RGB_565));
          ScreencastDispatcher.access$1002(ScreencastDispatcher.this, new Canvas(ScreencastDispatcher.this.mBitmap));
          Matrix matrix = new Matrix();
          ScreencastDispatcher.this.mTempSrc.set(0.0F, 0.0F, f1, f2);
          ScreencastDispatcher.this.mTempDst.set(0.0F, 0.0F, i, j);
          matrix.setRectToRect(ScreencastDispatcher.this.mTempSrc, ScreencastDispatcher.this.mTempDst, Matrix.ScaleToFit.CENTER);
          ScreencastDispatcher.this.mCanvas.setMatrix(matrix);
        } 
        view.draw(ScreencastDispatcher.this.mCanvas);
        return;
      } catch (OutOfMemoryError outOfMemoryError) {
        LogUtil.w("Out of memory trying to allocate screencast Bitmap.");
        return;
      } 
    }
    
    public void run() {
      updateScreenBitmap();
      ScreencastDispatcher.this.mBackgroundHandler.post(ScreencastDispatcher.this.mEventDispatchRunnable.withEndAction(this));
    }
  }
  
  class CancellationRunnable implements Runnable {
    private CancellationRunnable() {}
    
    public void run() {
      ScreencastDispatcher.this.mHandlerThread.interrupt();
      ScreencastDispatcher.this.mMainHandler.removeCallbacks(ScreencastDispatcher.this.mBitmapFetchRunnable);
      ScreencastDispatcher.this.mBackgroundHandler.removeCallbacks(ScreencastDispatcher.this.mEventDispatchRunnable);
      ScreencastDispatcher.access$602(ScreencastDispatcher.this, false);
      ScreencastDispatcher.access$1802(ScreencastDispatcher.this, null);
      ScreencastDispatcher.access$802(ScreencastDispatcher.this, null);
      ScreencastDispatcher.access$1002(ScreencastDispatcher.this, null);
      ScreencastDispatcher.access$1302(ScreencastDispatcher.this, null);
    }
  }
  
  class EventDispatchRunnable implements Runnable {
    private Runnable mEndAction;
    
    private EventDispatchRunnable() {}
    
    private EventDispatchRunnable withEndAction(Runnable param1Runnable) {
      this.mEndAction = param1Runnable;
      return this;
    }
    
    public void run() {
      if (ScreencastDispatcher.this.mIsRunning) {
        if (ScreencastDispatcher.this.mBitmap == null)
          return; 
        int i = ScreencastDispatcher.this.mBitmap.getWidth();
        int j = ScreencastDispatcher.this.mBitmap.getHeight();
        ScreencastDispatcher.this.mStream.reset();
        Base64OutputStream base64OutputStream = new Base64OutputStream(ScreencastDispatcher.this.mStream, 0);
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.valueOf(ScreencastDispatcher.this.mRequest.format.toUpperCase());
        ScreencastDispatcher.this.mBitmap.compress(compressFormat, ScreencastDispatcher.this.mRequest.quality, (OutputStream)base64OutputStream);
        ScreencastDispatcher.this.mEvent.data = ScreencastDispatcher.this.mStream.toString();
        ScreencastDispatcher.this.mMetadata.pageScaleFactor = 1;
        ScreencastDispatcher.this.mMetadata.deviceWidth = i;
        ScreencastDispatcher.this.mMetadata.deviceHeight = j;
        ScreencastDispatcher.this.mEvent.metadata = ScreencastDispatcher.this.mMetadata;
        ScreencastDispatcher.this.mPeer.invokeMethod("Page.screencastFrame", ScreencastDispatcher.this.mEvent, null);
        ScreencastDispatcher.this.mMainHandler.postDelayed(this.mEndAction, 200L);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\screencast\ScreencastDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */