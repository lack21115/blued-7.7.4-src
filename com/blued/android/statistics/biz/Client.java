package com.blued.android.statistics.biz;

import com.blued.android.statistics.grpc.connect.ClientManager;
import com.blued.das.client.ClientProtos;
import com.google.protobuf.Any;
import com.google.protobuf.Message;

public final class Client {
  private Client() {}
  
  public static Client a() {
    return InstanceHolder.a();
  }
  
  public void a(Message paramMessage, long paramLong) {
    if (paramMessage == null)
      return; 
    try {
      ClientManager.a().a(ClientProtos.Request.newBuilder().setClientTime(System.currentTimeMillis()).setExtra(Any.pack(paramMessage)).setUid(paramLong).build());
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  static class InstanceHolder {
    private static final Client a = new Client();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\statistics\biz\Client.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */