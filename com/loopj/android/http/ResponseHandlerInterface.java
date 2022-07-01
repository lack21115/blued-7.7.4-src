package com.loopj.android.http;

import java.io.IOException;
import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

public interface ResponseHandlerInterface {
  Header[] getRequestHeaders();
  
  URI getRequestURI();
  
  boolean getUseSynchronousMode();
  
  void onPostProcessResponse(ResponseHandlerInterface paramResponseHandlerInterface, HttpResponse paramHttpResponse);
  
  void onPreProcessResponse(ResponseHandlerInterface paramResponseHandlerInterface, HttpResponse paramHttpResponse);
  
  void sendCancelMessage();
  
  void sendFailureMessage(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfbyte, Throwable paramThrowable);
  
  void sendFinishMessage();
  
  void sendProgressMessage(int paramInt1, int paramInt2);
  
  void sendResponseMessage(HttpResponse paramHttpResponse) throws IOException;
  
  void sendRetryMessage(int paramInt);
  
  void sendStartMessage();
  
  void sendSuccessMessage(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfbyte);
  
  void setRequestHeaders(Header[] paramArrayOfHeader);
  
  void setRequestURI(URI paramURI);
  
  void setUseSynchronousMode(boolean paramBoolean);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loopj\android\http\ResponseHandlerInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */