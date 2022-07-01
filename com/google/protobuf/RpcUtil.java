package com.google.protobuf;

public final class RpcUtil {
  private static <Type extends Message> Type copyAsType(Type paramType, Message paramMessage) {
    return (Type)paramType.newBuilderForType().mergeFrom(paramMessage).build();
  }
  
  public static <Type extends Message> RpcCallback<Message> generalizeCallback(final RpcCallback<Type> originalCallback, final Class<Type> originalClass, final Type defaultInstance) {
    return new RpcCallback<Message>() {
        public void run(Message param1Message) {
          try {
            Message message = originalClass.cast(param1Message);
            param1Message = message;
          } catch (ClassCastException classCastException) {
            param1Message = (Message)RpcUtil.copyAsType((Type)defaultInstance, param1Message);
          } 
          originalCallback.run(param1Message);
        }
      };
  }
  
  public static <ParameterType> RpcCallback<ParameterType> newOneTimeCallback(final RpcCallback<ParameterType> originalCallback) {
    return new RpcCallback<ParameterType>() {
        private boolean alreadyCalled = false;
        
        public void run(ParameterType param1ParameterType) {
          // Byte code:
          //   0: aload_0
          //   1: monitorenter
          //   2: aload_0
          //   3: getfield alreadyCalled : Z
          //   6: ifne -> 27
          //   9: aload_0
          //   10: iconst_1
          //   11: putfield alreadyCalled : Z
          //   14: aload_0
          //   15: monitorexit
          //   16: aload_0
          //   17: getfield val$originalCallback : Lcom/google/protobuf/RpcCallback;
          //   20: aload_1
          //   21: invokeinterface run : (Ljava/lang/Object;)V
          //   26: return
          //   27: new com/google/protobuf/RpcUtil$AlreadyCalledException
          //   30: dup
          //   31: invokespecial <init> : ()V
          //   34: athrow
          //   35: astore_1
          //   36: aload_0
          //   37: monitorexit
          //   38: aload_1
          //   39: athrow
          // Exception table:
          //   from	to	target	type
          //   2	16	35	finally
          //   27	35	35	finally
          //   36	38	35	finally
        }
      };
  }
  
  public static <Type extends Message> RpcCallback<Type> specializeCallback(RpcCallback<Message> paramRpcCallback) {
    return (RpcCallback)paramRpcCallback;
  }
  
  public static final class AlreadyCalledException extends RuntimeException {
    private static final long serialVersionUID = 5469741279507848266L;
    
    public AlreadyCalledException() {
      super("This RpcCallback was already called and cannot be called multiple times.");
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\RpcUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */