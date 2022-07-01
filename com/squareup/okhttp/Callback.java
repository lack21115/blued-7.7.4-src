package com.squareup.okhttp;

import java.io.IOException;

public interface Callback {
  void onFailure(Request paramRequest, IOException paramIOException);
  
  void onResponse(Response paramResponse) throws IOException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\Callback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */