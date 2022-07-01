package com.google.geo.type;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessageV3;
import com.google.type.LatLngProto;

public final class ViewportProto {
  static final Descriptors.Descriptor a = a().getMessageTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable b = new GeneratedMessageV3.FieldAccessorTable(a, new String[] { "Low", "High" });
  
  private static Descriptors.FileDescriptor c;
  
  static {
    LatLngProto.a();
  }
  
  public static Descriptors.FileDescriptor a() {
    return c;
  }
  
  static {
    Descriptors.FileDescriptor.InternalDescriptorAssigner internalDescriptorAssigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor param1FileDescriptor) {
          ViewportProto.a(param1FileDescriptor);
          return null;
        }
      };
    Descriptors.FileDescriptor fileDescriptor = LatLngProto.a();
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\036google/geo/type/viewport.proto\022\017google.geo.type\032\030google/type/latlng.proto\"O\n\bViewport\022 \n\003low\030\001 \001(\0132\023.google.type.LatLng\022!\n\004high\030\002 \001(\0132\023.google.type.LatLngBo\n\023com.google.geo.typeB\rViewportProtoP\001Z@google.golang.org/genproto/googleapis/geo/type/viewport;viewport¢\002\004GGTPb\006proto3" }, new Descriptors.FileDescriptor[] { fileDescriptor }, internalDescriptorAssigner);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\geo\type\ViewportProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */