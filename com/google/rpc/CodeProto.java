package com.google.rpc;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;

public final class CodeProto {
  private static Descriptors.FileDescriptor a;
  
  static {
    Descriptors.FileDescriptor.InternalDescriptorAssigner internalDescriptorAssigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor param1FileDescriptor) {
          CodeProto.a(param1FileDescriptor);
          return null;
        }
      };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\025google/rpc/code.proto\022\ngoogle.rpc*·\002\n\004Code\022\006\n\002OK\020\000\022\r\n\tCANCELLED\020\001\022\013\n\007UNKNOWN\020\002\022\024\n\020INVALID_ARGUMENT\020\003\022\025\n\021DEADLINE_EXCEEDED\020\004\022\r\n\tNOT_FOUND\020\005\022\022\n\016ALREADY_EXISTS\020\006\022\025\n\021PERMISSION_DENIED\020\007\022\023\n\017UNAUTHENTICATED\020\020\022\026\n\022RESOURCE_EXHAUSTED\020\b\022\027\n\023FAILED_PRECONDITION\020\t\022\013\n\007ABORTED\020\n\022\020\n\fOUT_OF_RANGE\020\013\022\021\n\rUNIMPLEMENTED\020\f\022\f\n\bINTERNAL\020\r\022\017\n\013UNAVAILABLE\020\016\022\r\n\tDATA_LOSS\020\017BX\n\016com.google.rpcB\tCodeProtoP\001Z3google.golang.org/genproto/googleapis/rpc/code;code¢\002\003RPCb\006proto3" }, new Descriptors.FileDescriptor[0], internalDescriptorAssigner);
  }
  
  public static Descriptors.FileDescriptor a() {
    return a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\rpc\CodeProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */