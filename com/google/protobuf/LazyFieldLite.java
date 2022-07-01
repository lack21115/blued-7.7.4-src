package com.google.protobuf;

public class LazyFieldLite {
  ByteString delayedBytes;
  
  private ExtensionRegistryLite extensionRegistry;
  
  volatile ByteString memoizedBytes;
  
  volatile MessageLite value;
  
  static {
    ExtensionRegistryLite.getEmptyRegistry();
    throw new VerifyError("bad dex opcode");
  }
  
  private ByteString toByteString() {
    // Byte code:
    //   0: aload_0
    //   1: getfield memoizedBytes : Lcom/google/protobuf/ByteString;
    //   4: ifnull -> 12
    //   7: aload_0
    //   8: getfield memoizedBytes : Lcom/google/protobuf/ByteString;
    //   11: areturn
    //   12: aload_0
    //   13: getfield delayedBytes : Lcom/google/protobuf/ByteString;
    //   16: ifnull -> 24
    //   19: aload_0
    //   20: getfield delayedBytes : Lcom/google/protobuf/ByteString;
    //   23: areturn
    //   24: aload_0
    //   25: monitorenter
    //   26: aload_0
    //   27: getfield memoizedBytes : Lcom/google/protobuf/ByteString;
    //   30: ifnull -> 42
    //   33: aload_0
    //   34: getfield memoizedBytes : Lcom/google/protobuf/ByteString;
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: areturn
    //   42: aload_0
    //   43: getfield value : Lcom/google/protobuf/MessageLite;
    //   46: ifnonnull -> 59
    //   49: aload_0
    //   50: getstatic com/google/protobuf/ByteString.EMPTY : Lcom/google/protobuf/ByteString;
    //   53: putfield memoizedBytes : Lcom/google/protobuf/ByteString;
    //   56: goto -> 72
    //   59: aload_0
    //   60: aload_0
    //   61: getfield value : Lcom/google/protobuf/MessageLite;
    //   64: invokeinterface toByteString : ()Lcom/google/protobuf/ByteString;
    //   69: putfield memoizedBytes : Lcom/google/protobuf/ByteString;
    //   72: aload_0
    //   73: getfield memoizedBytes : Lcom/google/protobuf/ByteString;
    //   76: astore_1
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_1
    //   80: areturn
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_1
    //   85: athrow
    // Exception table:
    //   from	to	target	type
    //   26	40	81	finally
    //   42	56	81	finally
    //   59	72	81	finally
    //   72	79	81	finally
    //   82	84	81	finally
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof LazyFieldLite))
      return false; 
    paramObject = paramObject;
    MessageLite messageLite1 = this.value;
    MessageLite messageLite2 = ((LazyFieldLite)paramObject).value;
    return (messageLite1 == null && messageLite2 == null) ? toByteString().equals(paramObject.toByteString()) : ((messageLite1 != null && messageLite2 != null) ? messageLite1.equals(messageLite2) : ((messageLite1 != null) ? messageLite1.equals(paramObject.getValue(messageLite1.getDefaultInstanceForType())) : getValue(messageLite2.getDefaultInstanceForType()).equals(messageLite2)));
  }
  
  public final MessageLite getValue(MessageLite paramMessageLite) {
    // Byte code:
    //   0: aload_0
    //   1: getfield value : Lcom/google/protobuf/MessageLite;
    //   4: ifnonnull -> 103
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield value : Lcom/google/protobuf/MessageLite;
    //   13: ifnull -> 21
    //   16: aload_0
    //   17: monitorexit
    //   18: goto -> 103
    //   21: aload_0
    //   22: getfield delayedBytes : Lcom/google/protobuf/ByteString;
    //   25: ifnull -> 65
    //   28: aload_0
    //   29: aload_1
    //   30: invokeinterface getParserForType : ()Lcom/google/protobuf/Parser;
    //   35: aload_0
    //   36: getfield delayedBytes : Lcom/google/protobuf/ByteString;
    //   39: aload_0
    //   40: getfield extensionRegistry : Lcom/google/protobuf/ExtensionRegistryLite;
    //   43: invokeinterface parseFrom : (Lcom/google/protobuf/ByteString;Lcom/google/protobuf/ExtensionRegistryLite;)Ljava/lang/Object;
    //   48: checkcast com/google/protobuf/MessageLite
    //   51: putfield value : Lcom/google/protobuf/MessageLite;
    //   54: aload_0
    //   55: aload_0
    //   56: getfield delayedBytes : Lcom/google/protobuf/ByteString;
    //   59: putfield memoizedBytes : Lcom/google/protobuf/ByteString;
    //   62: goto -> 93
    //   65: aload_0
    //   66: aload_1
    //   67: putfield value : Lcom/google/protobuf/MessageLite;
    //   70: aload_0
    //   71: getstatic com/google/protobuf/ByteString.EMPTY : Lcom/google/protobuf/ByteString;
    //   74: putfield memoizedBytes : Lcom/google/protobuf/ByteString;
    //   77: goto -> 93
    //   80: astore_2
    //   81: aload_0
    //   82: aload_1
    //   83: putfield value : Lcom/google/protobuf/MessageLite;
    //   86: aload_0
    //   87: getstatic com/google/protobuf/ByteString.EMPTY : Lcom/google/protobuf/ByteString;
    //   90: putfield memoizedBytes : Lcom/google/protobuf/ByteString;
    //   93: aload_0
    //   94: monitorexit
    //   95: goto -> 103
    //   98: astore_1
    //   99: aload_0
    //   100: monitorexit
    //   101: aload_1
    //   102: athrow
    //   103: aload_0
    //   104: getfield value : Lcom/google/protobuf/MessageLite;
    //   107: areturn
    // Exception table:
    //   from	to	target	type
    //   9	18	98	finally
    //   21	62	80	com/google/protobuf/InvalidProtocolBufferException
    //   21	62	98	finally
    //   65	77	80	com/google/protobuf/InvalidProtocolBufferException
    //   65	77	98	finally
    //   81	93	98	finally
    //   93	95	98	finally
    //   99	101	98	finally
  }
  
  public int hashCode() {
    return 1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\LazyFieldLite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */