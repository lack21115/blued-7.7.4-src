package com.qq.e.comm.net.rr;

import java.io.IOException;
import java.net.HttpURLConnection;

public class S2SSResponse extends AbstractResponse {
  public S2SSResponse(HttpURLConnection paramHttpURLConnection) {
    super(paramHttpURLConnection);
  }
  
  public byte[] getBytesContent() throws IllegalStateException, IOException {
    try {
      return a.b(super.getBytesContent());
    } catch (b b) {
      b.printStackTrace();
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\net\rr\S2SSResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */