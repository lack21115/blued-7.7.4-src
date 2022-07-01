package com.loopj.android.http;

import android.os.Message;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.util.ByteArrayBuffer;

public abstract class DataAsyncHttpResponseHandler extends AsyncHttpResponseHandler {
  private static final String LOG_TAG = "DataAsyncHttpResponseHandler";
  
  protected static final int PROGRESS_DATA_MESSAGE = 6;
  
  public static byte[] copyOfRange(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws ArrayIndexOutOfBoundsException, IllegalArgumentException, NullPointerException {
    if (paramInt1 <= paramInt2) {
      int i = paramArrayOfbyte.length;
      if (paramInt1 >= 0 && paramInt1 <= i) {
        paramInt2 -= paramInt1;
        i = Math.min(paramInt2, i - paramInt1);
        byte[] arrayOfByte = new byte[paramInt2];
        System.arraycopy(paramArrayOfbyte, paramInt1, arrayOfByte, 0, i);
        return arrayOfByte;
      } 
      throw new ArrayIndexOutOfBoundsException();
    } 
    throw new IllegalArgumentException();
  }
  
  byte[] getResponseData(HttpEntity paramHttpEntity) throws IOException {
    if (paramHttpEntity != null) {
      InputStream inputStream = paramHttpEntity.getContent();
      if (inputStream != null) {
        long l = paramHttpEntity.getContentLength();
        if (l <= 2147483647L) {
          long l1 = l;
          if (l < 0L)
            l1 = 4096L; 
          try {
            null = new ByteArrayBuffer((int)l1);
            try {
              byte[] arrayOfByte = new byte[4096];
              while (true) {
                int i = inputStream.read(arrayOfByte);
                if (i != -1 && !Thread.currentThread().isInterrupted()) {
                  null.append(arrayOfByte, 0, i);
                  sendProgressDataMessage(copyOfRange(arrayOfByte, 0, i));
                  continue;
                } 
                break;
              } 
              return null.toByteArray();
            } finally {
              AsyncHttpClient.silentCloseInputStream(inputStream);
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
  
  protected void handleMessage(Message paramMessage) {
    super.handleMessage(paramMessage);
    if (paramMessage.what != 6)
      return; 
    Object[] arrayOfObject = (Object[])paramMessage.obj;
    if (arrayOfObject != null && arrayOfObject.length >= 1)
      try {
        return;
      } finally {
        arrayOfObject = null;
        Log.e("DataAsyncHttpResponseHandler", "custom onProgressData contains an error", (Throwable)arrayOfObject);
      }  
    Log.e("DataAsyncHttpResponseHandler", "PROGRESS_DATA_MESSAGE didn't got enough params");
  }
  
  public void onProgressData(byte[] paramArrayOfbyte) {
    Log.d("DataAsyncHttpResponseHandler", "onProgressData(byte[]) was not overriden, but callback was received");
  }
  
  public final void sendProgressDataMessage(byte[] paramArrayOfbyte) {
    sendMessage(obtainMessage(6, new Object[] { paramArrayOfbyte }));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loopj\android\http\DataAsyncHttpResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */