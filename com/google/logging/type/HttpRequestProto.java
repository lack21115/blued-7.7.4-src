package com.google.logging.type;

import com.google.api.AnnotationsProto;
import com.google.protobuf.Descriptors;
import com.google.protobuf.DurationProto;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessageV3;

public final class HttpRequestProto {
  static final Descriptors.Descriptor a = a().getMessageTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable b = new GeneratedMessageV3.FieldAccessorTable(a, new String[] { 
        "RequestMethod", "RequestUrl", "RequestSize", "Status", "ResponseSize", "UserAgent", "RemoteIp", "ServerIp", "Referer", "Latency", 
        "CacheLookup", "CacheHit", "CacheValidatedWithOriginServer", "CacheFillBytes", "Protocol" });
  
  private static Descriptors.FileDescriptor c;
  
  static {
    DurationProto.getDescriptor();
    AnnotationsProto.a();
  }
  
  public static Descriptors.FileDescriptor a() {
    return c;
  }
  
  static {
    Descriptors.FileDescriptor.InternalDescriptorAssigner internalDescriptorAssigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor param1FileDescriptor) {
          HttpRequestProto.a(param1FileDescriptor);
          return null;
        }
      };
    Descriptors.FileDescriptor fileDescriptor1 = DurationProto.getDescriptor();
    Descriptors.FileDescriptor fileDescriptor2 = AnnotationsProto.a();
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n&google/logging/type/http_request.proto\022\023google.logging.type\032\036google/protobuf/duration.proto\032\034google/api/annotations.proto\"ï\002\n\013HttpRequest\022\026\n\016request_method\030\001 \001(\t\022\023\n\013request_url\030\002 \001(\t\022\024\n\frequest_size\030\003 \001(\003\022\016\n\006status\030\004 \001(\005\022\025\n\rresponse_size\030\005 \001(\003\022\022\n\nuser_agent\030\006 \001(\t\022\021\n\tremote_ip\030\007 \001(\t\022\021\n\tserver_ip\030\r \001(\t\022\017\n\007referer\030\b \001(\t\022*\n\007latency\030\016 \001(\0132\031.google.protobuf.Duration\022\024\n\fcache_lookup\030\013 \001(\b\022\021\n\tcache_hit\030\t \001(\b\022*\n\"cache_validated_with_origin_server\030\n \001(\b\022\030\n\020cache_fill_bytes\030\f \001(\003\022\020\n\bprotocol\030\017 \001(\tB\001\n\027com.google.logging.typeB\020HttpRequestProtoP\001Z8google.golang.org/genproto/googleapis/logging/type;ltypeª\002\031Google.Cloud.Logging.TypeÊ\002\031Google\\Cloud\\Logging\\Typeb\006proto3" }, new Descriptors.FileDescriptor[] { fileDescriptor1, fileDescriptor2 }, internalDescriptorAssigner);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\logging\type\HttpRequestProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */