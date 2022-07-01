package com.loopj.android.http;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.util.ByteArrayBuffer;

public abstract class AsyncHttpResponseHandler implements ResponseHandlerInterface {
  protected static final int BUFFER_SIZE = 4096;
  
  protected static final int CANCEL_MESSAGE = 6;
  
  public static final String DEFAULT_CHARSET = "UTF-8";
  
  protected static final int FAILURE_MESSAGE = 1;
  
  protected static final int FINISH_MESSAGE = 3;
  
  private static final String LOG_TAG = "AsyncHttpResponseHandler";
  
  protected static final int PROGRESS_MESSAGE = 4;
  
  protected static final int RETRY_MESSAGE = 5;
  
  protected static final int START_MESSAGE = 2;
  
  protected static final int SUCCESS_MESSAGE = 0;
  
  public static final String UTF8_BOM = "﻿";
  
  private Handler handler;
  
  private Looper looper = null;
  
  private Header[] requestHeaders = null;
  
  private URI requestURI = null;
  
  private String responseCharset = "UTF-8";
  
  private boolean useSynchronousMode;
  
  public AsyncHttpResponseHandler() {
    this(null);
  }
  
  public AsyncHttpResponseHandler(Looper paramLooper) {
    Looper looper = paramLooper;
    if (paramLooper == null)
      looper = Looper.myLooper(); 
    this.looper = looper;
    setUseSynchronousMode(false);
  }
  
  public String getCharset() {
    String str2 = this.responseCharset;
    String str1 = str2;
    if (str2 == null)
      str1 = "UTF-8"; 
    return str1;
  }
  
  public Header[] getRequestHeaders() {
    return this.requestHeaders;
  }
  
  public URI getRequestURI() {
    return this.requestURI;
  }
  
  byte[] getResponseData(HttpEntity paramHttpEntity) throws IOException {
    if (paramHttpEntity != null) {
      InputStream inputStream = paramHttpEntity.getContent();
      if (inputStream != null) {
        long l = paramHttpEntity.getContentLength();
        if (l <= 2147483647L) {
          int i;
          int j = l cmp 0L;
          if (j <= 0) {
            i = 4096;
          } else {
            i = (int)l;
          } 
          try {
            null = new ByteArrayBuffer(i);
            try {
              byte[] arrayOfByte = new byte[4096];
              i = 0;
              while (true) {
                int k = inputStream.read(arrayOfByte);
                if (k != -1 && !Thread.currentThread().isInterrupted()) {
                  long l1;
                  i += k;
                  null.append(arrayOfByte, 0, k);
                  if (j <= 0) {
                    l1 = 1L;
                  } else {
                    l1 = l;
                  } 
                  sendProgressMessage(i, (int)l1);
                  continue;
                } 
                return null.toByteArray();
              } 
            } finally {
              AsyncHttpClient.silentCloseInputStream(inputStream);
              AsyncHttpClient.endEntityViaReflection(paramHttpEntity);
            } 
          } catch (OutOfMemoryError outOfMemoryError) {
            System.gc();
            throw new IOException("File too large to fit into available memory");
          } 
        } 
        throw new IllegalArgumentException("HTTP entity too large to be buffered in memory");
      } 
    } 
    return null;
  }
  
  public boolean getUseSynchronousMode() {
    return this.useSynchronousMode;
  }
  
  protected void handleMessage(Message paramMessage) {
    switch (paramMessage.what) {
      default:
        return;
      case 6:
        onCancel();
        return;
      case 5:
        arrayOfObject = (Object[])paramMessage.obj;
        if (arrayOfObject != null && arrayOfObject.length == 1) {
          onRetry(((Integer)arrayOfObject[0]).intValue());
          return;
        } 
        Log.e("AsyncHttpResponseHandler", "RETRY_MESSAGE didn't get enough params");
        return;
      case 4:
        arrayOfObject = (Object[])((Message)arrayOfObject).obj;
        if (arrayOfObject != null && arrayOfObject.length >= 2)
          try {
            return;
          } finally {
            arrayOfObject = null;
            Log.e("AsyncHttpResponseHandler", "custom onProgress contains an error", (Throwable)arrayOfObject);
          }  
        Log.e("AsyncHttpResponseHandler", "PROGRESS_MESSAGE didn't got enough params");
        return;
      case 3:
        onFinish();
        return;
      case 2:
        onStart();
        return;
      case 1:
        arrayOfObject = (Object[])((Message)arrayOfObject).obj;
        if (arrayOfObject != null && arrayOfObject.length >= 4) {
          onFailure(((Integer)arrayOfObject[0]).intValue(), (Header[])arrayOfObject[1], (byte[])arrayOfObject[2], (Throwable)arrayOfObject[3]);
          return;
        } 
        Log.e("AsyncHttpResponseHandler", "FAILURE_MESSAGE didn't got enough params");
        return;
      case 0:
        break;
    } 
    Object[] arrayOfObject = (Object[])((Message)arrayOfObject).obj;
    if (arrayOfObject != null && arrayOfObject.length >= 3) {
      onSuccess(((Integer)arrayOfObject[0]).intValue(), (Header[])arrayOfObject[1], (byte[])arrayOfObject[2]);
      return;
    } 
    Log.e("AsyncHttpResponseHandler", "SUCCESS_MESSAGE didn't got enough params");
  }
  
  protected Message obtainMessage(int paramInt, Object paramObject) {
    return Message.obtain(this.handler, paramInt, paramObject);
  }
  
  public void onCancel() {
    Log.d("AsyncHttpResponseHandler", "Request got cancelled");
  }
  
  public abstract void onFailure(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfbyte, Throwable paramThrowable);
  
  public void onFinish() {}
  
  public void onPostProcessResponse(ResponseHandlerInterface paramResponseHandlerInterface, HttpResponse paramHttpResponse) {}
  
  public void onPreProcessResponse(ResponseHandlerInterface paramResponseHandlerInterface, HttpResponse paramHttpResponse) {}
  
  public void onProgress(int paramInt1, int paramInt2) {
    double d;
    if (paramInt2 > 0) {
      d = paramInt1 * 1.0D / paramInt2 * 100.0D;
    } else {
      d = -1.0D;
    } 
    Log.v("AsyncHttpResponseHandler", String.format("Progress %d from %d (%2.0f%%)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Double.valueOf(d) }));
  }
  
  public void onRetry(int paramInt) {
    Log.d("AsyncHttpResponseHandler", String.format("Request retry no. %d", new Object[] { Integer.valueOf(paramInt) }));
  }
  
  public void onStart() {}
  
  public abstract void onSuccess(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfbyte);
  
  protected void postRunnable(Runnable paramRunnable) {
    if (paramRunnable != null) {
      if (!getUseSynchronousMode()) {
        Handler handler = this.handler;
        if (handler != null) {
          boolean bool;
          if (handler != null) {
            bool = true;
          } else {
            bool = false;
          } 
          AssertUtils.asserts(bool, "handler should not be null!");
          this.handler.post(paramRunnable);
          return;
        } 
      } 
      paramRunnable.run();
    } 
  }
  
  public final void sendCancelMessage() {
    sendMessage(obtainMessage(6, null));
  }
  
  public final void sendFailureMessage(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfbyte, Throwable paramThrowable) {
    sendMessage(obtainMessage(1, new Object[] { Integer.valueOf(paramInt), paramArrayOfHeader, paramArrayOfbyte, paramThrowable }));
  }
  
  public final void sendFinishMessage() {
    sendMessage(obtainMessage(3, null));
  }
  
  protected void sendMessage(Message paramMessage) {
    if (getUseSynchronousMode() || this.handler == null) {
      handleMessage(paramMessage);
      return;
    } 
    if (!Thread.currentThread().isInterrupted()) {
      boolean bool;
      if (this.handler != null) {
        bool = true;
      } else {
        bool = false;
      } 
      AssertUtils.asserts(bool, "handler should not be null!");
      this.handler.sendMessage(paramMessage);
      return;
    } 
  }
  
  public final void sendProgressMessage(int paramInt1, int paramInt2) {
    sendMessage(obtainMessage(4, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
  }
  
  public void sendResponseMessage(HttpResponse paramHttpResponse) throws IOException {
    if (!Thread.currentThread().isInterrupted()) {
      StatusLine statusLine = paramHttpResponse.getStatusLine();
      byte[] arrayOfByte = getResponseData(paramHttpResponse.getEntity());
      if (!Thread.currentThread().isInterrupted()) {
        if (statusLine.getStatusCode() >= 300) {
          sendFailureMessage(statusLine.getStatusCode(), paramHttpResponse.getAllHeaders(), arrayOfByte, (Throwable)new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase()));
          return;
        } 
        sendSuccessMessage(statusLine.getStatusCode(), paramHttpResponse.getAllHeaders(), arrayOfByte);
      } 
    } 
  }
  
  public final void sendRetryMessage(int paramInt) {
    sendMessage(obtainMessage(5, new Object[] { Integer.valueOf(paramInt) }));
  }
  
  public final void sendStartMessage() {
    sendMessage(obtainMessage(2, null));
  }
  
  public final void sendSuccessMessage(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfbyte) {
    sendMessage(obtainMessage(0, new Object[] { Integer.valueOf(paramInt), paramArrayOfHeader, paramArrayOfbyte }));
  }
  
  public void setCharset(String paramString) {
    this.responseCharset = paramString;
  }
  
  public void setRequestHeaders(Header[] paramArrayOfHeader) {
    this.requestHeaders = paramArrayOfHeader;
  }
  
  public void setRequestURI(URI paramURI) {
    this.requestURI = paramURI;
  }
  
  public void setUseSynchronousMode(boolean paramBoolean) {
    boolean bool = paramBoolean;
    if (!paramBoolean) {
      bool = paramBoolean;
      if (this.looper == null) {
        bool = true;
        Log.w("AsyncHttpResponseHandler", "Current thread has not called Looper.prepare(). Forcing synchronous mode.");
      } 
    } 
    if (!bool && this.handler == null) {
      this.handler = new ResponderHandler(this, this.looper);
    } else if (bool && this.handler != null) {
      this.handler = null;
    } 
    this.useSynchronousMode = bool;
  }
  
  static class ResponderHandler extends Handler {
    private final AsyncHttpResponseHandler mResponder;
    
    ResponderHandler(AsyncHttpResponseHandler param1AsyncHttpResponseHandler, Looper param1Looper) {
      super(param1Looper);
      this.mResponder = param1AsyncHttpResponseHandler;
    }
    
    public void handleMessage(Message param1Message) {
      this.mResponder.handleMessage(param1Message);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loopj\android\http\AsyncHttpResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */