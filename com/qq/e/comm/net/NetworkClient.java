package com.qq.e.comm.net;

import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.net.rr.Response;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

public interface NetworkClient {
  Future<Response> submit(Request paramRequest);
  
  Future<Response> submit(Request paramRequest, Priority paramPriority);
  
  void submit(Request paramRequest, NetworkCallBack paramNetworkCallBack);
  
  void submit(Request paramRequest, Priority paramPriority, NetworkCallBack paramNetworkCallBack);
  
  void submit(Request paramRequest, Priority paramPriority, NetworkCallBack paramNetworkCallBack, Executor paramExecutor);
  
  public enum Priority {
    High(1),
    Low(1),
    Mid(2);
    
    private int a;
    
    static {
    
    }
    
    Priority(int param1Int1) {
      this.a = param1Int1;
    }
    
    public final int value() {
      return this.a;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\net\NetworkClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */