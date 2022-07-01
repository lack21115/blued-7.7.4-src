package com.google.api;

import com.google.protobuf.AnyProto;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.TimestampProto;

public final class DistributionProto {
  static final Descriptors.Descriptor a = a().getMessageTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable b = new GeneratedMessageV3.FieldAccessorTable(a, new String[] { "Count", "Mean", "SumOfSquaredDeviation", "Range", "BucketOptions", "BucketCounts", "Exemplars" });
  
  static final Descriptors.Descriptor c = a.getNestedTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable d = new GeneratedMessageV3.FieldAccessorTable(c, new String[] { "Min", "Max" });
  
  static final Descriptors.Descriptor e = a.getNestedTypes().get(1);
  
  static final GeneratedMessageV3.FieldAccessorTable f = new GeneratedMessageV3.FieldAccessorTable(e, new String[] { "LinearBuckets", "ExponentialBuckets", "ExplicitBuckets", "Options" });
  
  static final Descriptors.Descriptor g = e.getNestedTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable h = new GeneratedMessageV3.FieldAccessorTable(g, new String[] { "NumFiniteBuckets", "Width", "Offset" });
  
  static final Descriptors.Descriptor i = e.getNestedTypes().get(1);
  
  static final GeneratedMessageV3.FieldAccessorTable j = new GeneratedMessageV3.FieldAccessorTable(i, new String[] { "NumFiniteBuckets", "GrowthFactor", "Scale" });
  
  static final Descriptors.Descriptor k = e.getNestedTypes().get(2);
  
  static final GeneratedMessageV3.FieldAccessorTable l = new GeneratedMessageV3.FieldAccessorTable(k, new String[] { "Bounds" });
  
  static final Descriptors.Descriptor m = a.getNestedTypes().get(2);
  
  static final GeneratedMessageV3.FieldAccessorTable n = new GeneratedMessageV3.FieldAccessorTable(m, new String[] { "Value", "Timestamp", "Attachments" });
  
  private static Descriptors.FileDescriptor o;
  
  static {
    AnyProto.getDescriptor();
    TimestampProto.getDescriptor();
  }
  
  public static Descriptors.FileDescriptor a() {
    return o;
  }
  
  static {
    Descriptors.FileDescriptor.InternalDescriptorAssigner internalDescriptorAssigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor param1FileDescriptor) {
          DistributionProto.a(param1FileDescriptor);
          return null;
        }
      };
    Descriptors.FileDescriptor fileDescriptor1 = AnyProto.getDescriptor();
    Descriptors.FileDescriptor fileDescriptor2 = TimestampProto.getDescriptor();
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\035google/api/distribution.proto\022\ngoogle.api\032\031google/protobuf/any.proto\032\037google/protobuf/timestamp.proto\"Ù\006\n\fDistribution\022\r\n\005count\030\001 \001(\003\022\f\n\004mean\030\002 \001(\001\022 \n\030sum_of_squared_deviation\030\003 \001(\001\022-\n\005range\030\004 \001(\0132\036.google.api.Distribution.Range\022>\n\016bucket_options\030\006 \001(\0132&.google.api.Distribution.BucketOptions\022\025\n\rbucket_counts\030\007 \003(\003\0224\n\texemplars\030\n \003(\0132!.google.api.Distribution.Exemplar\032!\n\005Range\022\013\n\003min\030\001 \001(\001\022\013\n\003max\030\002 \001(\001\032µ\003\n\rBucketOptions\022G\n\016linear_buckets\030\001 \001(\0132-.google.api.Distribution.BucketOptions.LinearH\000\022Q\n\023exponential_buckets\030\002 \001(\01322.google.api.Distribution.BucketOptions.ExponentialH\000\022K\n\020explicit_buckets\030\003 \001(\0132/.google.api.Distribution.BucketOptions.ExplicitH\000\032C\n\006Linear\022\032\n\022num_finite_buckets\030\001 \001(\005\022\r\n\005width\030\002 \001(\001\022\016\n\006offset\030\003 \001(\001\032O\n\013Exponential\022\032\n\022num_finite_buckets\030\001 \001(\005\022\025\n\rgrowth_factor\030\002 \001(\001\022\r\n\005scale\030\003 \001(\001\032\032\n\bExplicit\022\016\n\006bounds\030\001 \003(\001B\t\n\007options\032s\n\bExemplar\022\r\n\005value\030\001 \001(\001\022-\n\ttimestamp\030\002 \001(\0132\032.google.protobuf.Timestamp\022)\n\013attachments\030\003 \003(\0132\024.google.protobuf.AnyBq\n\016com.google.apiB\021DistributionProtoP\001ZCgoogle.golang.org/genproto/googleapis/api/distribution;distribution¢\002\004GAPIb\006proto3" }, new Descriptors.FileDescriptor[] { fileDescriptor1, fileDescriptor2 }, internalDescriptorAssigner);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\DistributionProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */