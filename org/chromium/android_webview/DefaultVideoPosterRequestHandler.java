package org.chromium.android_webview;

import android.util.Log;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Random;
import org.chromium.base.ThreadUtils;

public final class DefaultVideoPosterRequestHandler {
  private AwContentsClient mContentClient;
  
  String mDefaultVideoPosterURL;
  
  public DefaultVideoPosterRequestHandler(AwContentsClient paramAwContentsClient) {
    long l = (new Random()).nextLong();
    StringBuilder stringBuilder = new StringBuilder("android-webview-video-poster:default_video_poster/");
    stringBuilder.append(String.valueOf(l));
    this.mDefaultVideoPosterURL = stringBuilder.toString();
    this.mContentClient = paramAwContentsClient;
  }
  
  static void closeOutputStream(OutputStream paramOutputStream) {
    try {
      paramOutputStream.close();
      return;
    } catch (IOException iOException) {
      Log.e("DefaultVideoPosterRequestHandler", null, iOException);
      return;
    } 
  }
  
  public final AwWebResourceResponse shouldInterceptRequest(String paramString) {
    if (!this.mDefaultVideoPosterURL.equals(paramString))
      return null; 
    try {
      AwContentsClient awContentsClient = this.mContentClient;
      PipedInputStream pipedInputStream = new PipedInputStream();
      ThreadUtils.runOnUiThread(new DefaultVideoPosterRequestHandler$$Lambda$0(awContentsClient, new PipedOutputStream(pipedInputStream)));
      return new AwWebResourceResponse("image/png", null, pipedInputStream);
    } catch (IOException iOException) {
      Log.e("DefaultVideoPosterRequestHandler", null, iOException);
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\DefaultVideoPosterRequestHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */