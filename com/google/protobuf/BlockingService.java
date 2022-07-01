package com.google.protobuf;

public interface BlockingService {
  Message callBlockingMethod(Descriptors.MethodDescriptor paramMethodDescriptor, RpcController paramRpcController, Message paramMessage) throws ServiceException;
  
  Descriptors.ServiceDescriptor getDescriptorForType();
  
  Message getRequestPrototype(Descriptors.MethodDescriptor paramMethodDescriptor);
  
  Message getResponsePrototype(Descriptors.MethodDescriptor paramMethodDescriptor);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\BlockingService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */