package org.chromium.android_webview;

import java.io.InputStream;
import java.util.Map;
import org.chromium.base.annotations.CalledByNative;

public class AwWebResourceResponse {
  private String mCharset;
  
  private InputStream mData;
  
  private String mMimeType;
  
  private String mReasonPhrase;
  
  private String[] mResponseHeaderNames;
  
  private String[] mResponseHeaderValues;
  
  public Map mResponseHeaders;
  
  private int mStatusCode;
  
  public AwWebResourceResponse(String paramString1, String paramString2, InputStream paramInputStream) {
    this.mMimeType = paramString1;
    this.mCharset = paramString2;
    this.mData = paramInputStream;
  }
  
  public AwWebResourceResponse(String paramString1, String paramString2, InputStream paramInputStream, int paramInt, String paramString3, Map paramMap) {
    this(paramString1, paramString2, paramInputStream);
    this.mStatusCode = paramInt;
    this.mReasonPhrase = paramString3;
    this.mResponseHeaders = paramMap;
  }
  
  private void fillInResponseHeaderNamesAndValuesIfNeeded() {
    if (this.mResponseHeaders != null) {
      if (this.mResponseHeaderNames != null)
        return; 
      this.mResponseHeaderNames = new String[this.mResponseHeaders.size()];
      this.mResponseHeaderValues = new String[this.mResponseHeaders.size()];
      int i = 0;
      for (Map.Entry entry : this.mResponseHeaders.entrySet()) {
        this.mResponseHeaderNames[i] = (String)entry.getKey();
        this.mResponseHeaderValues[i] = (String)entry.getValue();
        i++;
      } 
      return;
    } 
  }
  
  @CalledByNative
  private String[] getResponseHeaderNames() {
    fillInResponseHeaderNamesAndValuesIfNeeded();
    return this.mResponseHeaderNames;
  }
  
  @CalledByNative
  private String[] getResponseHeaderValues() {
    fillInResponseHeaderNamesAndValuesIfNeeded();
    return this.mResponseHeaderValues;
  }
  
  @CalledByNative
  public String getCharset() {
    return this.mCharset;
  }
  
  @CalledByNative
  public InputStream getData() {
    return this.mData;
  }
  
  @CalledByNative
  public String getMimeType() {
    return this.mMimeType;
  }
  
  @CalledByNative
  public String getReasonPhrase() {
    return this.mReasonPhrase;
  }
  
  @CalledByNative
  public int getStatusCode() {
    return this.mStatusCode;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwWebResourceResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */