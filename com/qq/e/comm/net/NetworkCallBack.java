package com.qq.e.comm.net;

import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.net.rr.Response;

public interface NetworkCallBack {
  void onException(Exception paramException);
  
  void onResponse(Request paramRequest, Response paramResponse);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\net\NetworkCallBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */