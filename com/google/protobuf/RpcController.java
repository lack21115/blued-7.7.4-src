package com.google.protobuf;

public interface RpcController {
  String errorText();
  
  boolean failed();
  
  boolean isCanceled();
  
  void notifyOnCancel(RpcCallback<Object> paramRpcCallback);
  
  void reset();
  
  void setFailed(String paramString);
  
  void startCancel();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\RpcController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */