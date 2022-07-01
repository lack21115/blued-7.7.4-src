package com.qq.e.comm.net.rr;

import java.net.HttpURLConnection;

public class S2SSRequest extends AbstractRequest {
  public S2SSRequest(String paramString, byte[] paramArrayOfbyte) {
    super(paramString, Request.Method.POST, paramArrayOfbyte);
  }
  
  public byte[] getPostData() throws Exception {
    return a.a(super.getPostData());
  }
  
  public Response initResponse(HttpURLConnection paramHttpURLConnection) {
    return new S2SSResponse(paramHttpURLConnection);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\net\rr\S2SSRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */