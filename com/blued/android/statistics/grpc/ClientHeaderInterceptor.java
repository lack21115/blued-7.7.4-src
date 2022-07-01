package com.blued.android.statistics.grpc;

import android.text.TextUtils;
import com.blued.android.statistics.util.Utils;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall;
import io.grpc.ForwardingClientCallListener;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ClientHeaderInterceptor implements ClientInterceptor {
  private ConcurrentHashMap<String, String> a;
  
  public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> paramMethodDescriptor, CallOptions paramCallOptions, Channel paramChannel) {
    return (ClientCall<ReqT, RespT>)new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(this, paramChannel.newCall(paramMethodDescriptor, paramCallOptions)) {
        public void start(ClientCall.Listener<RespT> param1Listener, Metadata param1Metadata) {
          if (ClientHeaderInterceptor.a(this.a) != null && ClientHeaderInterceptor.a(this.a).size() > 0)
            for (Map.Entry entry : ClientHeaderInterceptor.a(this.a).entrySet()) {
              Metadata.Key key = Utils.a((String)entry.getKey());
              if (param1Metadata.containsKey(key))
                param1Metadata.removeAll(key); 
              String str = (String)entry.getValue();
              if (!TextUtils.isEmpty(str))
                param1Metadata.put(key, str); 
            }  
          super.start((ClientCall.Listener)new ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT>(this, param1Listener) {
                public void onHeaders(Metadata param2Metadata) {
                  super.onHeaders(param2Metadata);
                }
              }param1Metadata);
        }
      };
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\statistics\grpc\ClientHeaderInterceptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */