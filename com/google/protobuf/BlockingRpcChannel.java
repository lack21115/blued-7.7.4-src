package com.google.protobuf;

public interface BlockingRpcChannel {
  Message callBlockingMethod(Descriptors.MethodDescriptor paramMethodDescriptor, RpcController paramRpcController, Message paramMessage1, Message paramMessage2) throws ServiceException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\BlockingRpcChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */