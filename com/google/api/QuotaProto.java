package com.google.api;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessageV3;

public final class QuotaProto {
  static final Descriptors.Descriptor a = a().getMessageTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable b = new GeneratedMessageV3.FieldAccessorTable(a, new String[] { "Limits", "MetricRules" });
  
  static final Descriptors.Descriptor c = a().getMessageTypes().get(1);
  
  static final GeneratedMessageV3.FieldAccessorTable d = new GeneratedMessageV3.FieldAccessorTable(c, new String[] { "Selector", "MetricCosts" });
  
  static final Descriptors.Descriptor e = c.getNestedTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable f = new GeneratedMessageV3.FieldAccessorTable(e, new String[] { "Key", "Value" });
  
  static final Descriptors.Descriptor g = a().getMessageTypes().get(2);
  
  static final GeneratedMessageV3.FieldAccessorTable h = new GeneratedMessageV3.FieldAccessorTable(g, new String[] { "Name", "Description", "DefaultLimit", "MaxLimit", "FreeTier", "Duration", "Metric", "Unit", "Values", "DisplayName" });
  
  static final Descriptors.Descriptor i = g.getNestedTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable j = new GeneratedMessageV3.FieldAccessorTable(i, new String[] { "Key", "Value" });
  
  private static Descriptors.FileDescriptor k;
  
  public static Descriptors.FileDescriptor a() {
    return k;
  }
  
  static {
    Descriptors.FileDescriptor.InternalDescriptorAssigner internalDescriptorAssigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor param1FileDescriptor) {
          QuotaProto.a(param1FileDescriptor);
          return null;
        }
      };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\026google/api/quota.proto\022\ngoogle.api\"]\n\005Quota\022&\n\006limits\030\003 \003(\0132\026.google.api.QuotaLimit\022,\n\fmetric_rules\030\004 \003(\0132\026.google.api.MetricRule\"\001\n\nMetricRule\022\020\n\bselector\030\001 \001(\t\022=\n\fmetric_costs\030\002 \003(\0132'.google.api.MetricRule.MetricCostsEntry\0322\n\020MetricCostsEntry\022\013\n\003key\030\001 \001(\t\022\r\n\005value\030\002 \001(\003:\0028\001\"\002\n\nQuotaLimit\022\f\n\004name\030\006 \001(\t\022\023\n\013description\030\002 \001(\t\022\025\n\rdefault_limit\030\003 \001(\003\022\021\n\tmax_limit\030\004 \001(\003\022\021\n\tfree_tier\030\007 \001(\003\022\020\n\bduration\030\005 \001(\t\022\016\n\006metric\030\b \001(\t\022\f\n\004unit\030\t \001(\t\0222\n\006values\030\n \003(\0132\".google.api.QuotaLimit.ValuesEntry\022\024\n\fdisplay_name\030\f \001(\t\032-\n\013ValuesEntry\022\013\n\003key\030\001 \001(\t\022\r\n\005value\030\002 \001(\003:\0028\001Bl\n\016com.google.apiB\nQuotaProtoP\001ZEgoogle.golang.org/genproto/googleapis/api/serviceconfig;serviceconfig¢\002\004GAPIb\006proto3" }, new Descriptors.FileDescriptor[0], internalDescriptorAssigner);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\QuotaProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */