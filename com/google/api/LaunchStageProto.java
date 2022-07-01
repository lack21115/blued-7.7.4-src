package com.google.api;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;

public final class LaunchStageProto {
  private static Descriptors.FileDescriptor a;
  
  static {
    Descriptors.FileDescriptor.InternalDescriptorAssigner internalDescriptorAssigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor param1FileDescriptor) {
          LaunchStageProto.a(param1FileDescriptor);
          return null;
        }
      };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\035google/api/launch_stage.proto\022\ngoogle.api*j\n\013LaunchStage\022\034\n\030LAUNCH_STAGE_UNSPECIFIED\020\000\022\020\n\fEARLY_ACCESS\020\001\022\t\n\005ALPHA\020\002\022\b\n\004BETA\020\003\022\006\n\002GA\020\004\022\016\n\nDEPRECATED\020\005BZ\n\016com.google.apiB\020LaunchStageProtoP\001Z-google.golang.org/genproto/googleapis/api;api¢\002\004GAPIb\006proto3" }, new Descriptors.FileDescriptor[0], internalDescriptorAssigner);
  }
  
  public static Descriptors.FileDescriptor a() {
    return a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\LaunchStageProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */