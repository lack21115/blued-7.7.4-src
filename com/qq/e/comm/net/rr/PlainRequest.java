package com.qq.e.comm.net.rr;

import java.net.HttpURLConnection;
import java.util.Map;

public class PlainRequest extends AbstractRequest {
  public PlainRequest(String paramString, Request.Method paramMethod, byte[] paramArrayOfbyte) {
    super(paramString, paramMethod, paramArrayOfbyte);
  }
  
  public PlainRequest(String paramString, Map<String, String> paramMap, Request.Method paramMethod) {
    super(paramString, paramMap, paramMethod);
  }
  
  public Response initResponse(HttpURLConnection paramHttpURLConnection) {
    return new PlainResponse(paramHttpURLConnection);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\net\rr\PlainRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */