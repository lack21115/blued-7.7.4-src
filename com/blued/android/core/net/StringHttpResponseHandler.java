package com.blued.android.core.net;

import android.text.TextUtils;
import java.io.IOException;
import okhttp3.ResponseBody;

public abstract class StringHttpResponseHandler extends HttpResponseHandler<String> {
  public StringHttpResponseHandler() {}
  
  public StringHttpResponseHandler(boolean paramBoolean) {
    super(paramBoolean);
  }
  
  public long getResponseLength(String paramString) {
    return TextUtils.isEmpty(paramString) ? 0L : paramString.length();
  }
  
  public String getResponseType() {
    return "string";
  }
  
  protected String parseResponse(int paramInt, ResponseBody paramResponseBody) throws IOException {
    return (paramResponseBody == null) ? null : paramResponseBody.g();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\net\StringHttpResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */