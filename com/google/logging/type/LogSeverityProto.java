package com.google.logging.type;

import com.google.api.AnnotationsProto;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;

public final class LogSeverityProto {
  private static Descriptors.FileDescriptor a;
  
  static {
    Descriptors.FileDescriptor.InternalDescriptorAssigner internalDescriptorAssigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor param1FileDescriptor) {
          LogSeverityProto.a(param1FileDescriptor);
          return null;
        }
      };
    Descriptors.FileDescriptor fileDescriptor = AnnotationsProto.a();
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n&google/logging/type/log_severity.proto\022\023google.logging.type\032\034google/api/annotations.proto*\001\n\013LogSeverity\022\013\n\007DEFAULT\020\000\022\t\n\005DEBUG\020d\022\t\n\004INFO\020È\001\022\013\n\006NOTICE\020¬\002\022\f\n\007WARNING\020\003\022\n\n\005ERROR\020ô\003\022\r\n\bCRITICAL\020Ø\004\022\n\n\005ALERT\020¼\005\022\016\n\tEMERGENCY\020 \006B\001\n\027com.google.logging.typeB\020LogSeverityProtoP\001Z8google.golang.org/genproto/googleapis/logging/type;ltypeª\002\031Google.Cloud.Logging.TypeÊ\002\031Google\\Cloud\\Logging\\Typeb\006proto3" }, new Descriptors.FileDescriptor[] { fileDescriptor }, internalDescriptorAssigner);
    AnnotationsProto.a();
  }
  
  public static Descriptors.FileDescriptor a() {
    return a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\logging\type\LogSeverityProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */