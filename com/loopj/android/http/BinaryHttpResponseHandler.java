package com.loopj.android.http;

import android.util.Log;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;

public abstract class BinaryHttpResponseHandler extends AsyncHttpResponseHandler {
  private static final String LOG_TAG = "BinaryHttpResponseHandler";
  
  private String[] mAllowedContentTypes = new String[] { "application/octet-stream", "image/jpeg", "image/png", "image/gif" };
  
  public BinaryHttpResponseHandler() {}
  
  public BinaryHttpResponseHandler(String[] paramArrayOfString) {
    if (paramArrayOfString != null) {
      this.mAllowedContentTypes = paramArrayOfString;
      return;
    } 
    Log.e("BinaryHttpResponseHandler", "Constructor passed allowedContentTypes was null !");
  }
  
  public String[] getAllowedContentTypes() {
    return this.mAllowedContentTypes;
  }
  
  public abstract void onFailure(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfbyte, Throwable paramThrowable);
  
  public abstract void onSuccess(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfbyte);
  
  public final void sendResponseMessage(HttpResponse paramHttpResponse) throws IOException {
    StatusLine statusLine = paramHttpResponse.getStatusLine();
    Header[] arrayOfHeader = paramHttpResponse.getHeaders("Content-Type");
    if (arrayOfHeader.length != 1) {
      sendFailureMessage(statusLine.getStatusCode(), paramHttpResponse.getAllHeaders(), null, (Throwable)new HttpResponseException(statusLine.getStatusCode(), "None, or more than one, Content-Type Header found!"));
      return;
    } 
    int i = 0;
    Header header = arrayOfHeader[0];
    String[] arrayOfString = getAllowedContentTypes();
    int j = arrayOfString.length;
    boolean bool = false;
    while (i < j) {
      String str = arrayOfString[i];
      try {
        boolean bool1 = Pattern.matches(str, header.getValue());
        if (bool1)
          bool = true; 
      } catch (PatternSyntaxException patternSyntaxException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Given pattern is not valid: ");
        stringBuilder.append(str);
        Log.e("BinaryHttpResponseHandler", stringBuilder.toString(), patternSyntaxException);
      } 
      i++;
    } 
    if (!bool) {
      sendFailureMessage(statusLine.getStatusCode(), paramHttpResponse.getAllHeaders(), null, (Throwable)new HttpResponseException(statusLine.getStatusCode(), "Content-Type not allowed!"));
      return;
    } 
    super.sendResponseMessage(paramHttpResponse);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loopj\android\http\BinaryHttpResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */