package com.google.type;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessageV3;

public final class PostalAddressProto {
  static final Descriptors.Descriptor a = a().getMessageTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable b = new GeneratedMessageV3.FieldAccessorTable(a, new String[] { 
        "Revision", "RegionCode", "LanguageCode", "PostalCode", "SortingCode", "AdministrativeArea", "Locality", "Sublocality", "AddressLines", "Recipients", 
        "Organization" });
  
  private static Descriptors.FileDescriptor c;
  
  public static Descriptors.FileDescriptor a() {
    return c;
  }
  
  static {
    Descriptors.FileDescriptor.InternalDescriptorAssigner internalDescriptorAssigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor param1FileDescriptor) {
          PostalAddressProto.a(param1FileDescriptor);
          return null;
        }
      };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n google/type/postal_address.proto\022\013google.type\"ý\001\n\rPostalAddress\022\020\n\brevision\030\001 \001(\005\022\023\n\013region_code\030\002 \001(\t\022\025\n\rlanguage_code\030\003 \001(\t\022\023\n\013postal_code\030\004 \001(\t\022\024\n\fsorting_code\030\005 \001(\t\022\033\n\023administrative_area\030\006 \001(\t\022\020\n\blocality\030\007 \001(\t\022\023\n\013sublocality\030\b \001(\t\022\025\n\raddress_lines\030\t \003(\t\022\022\n\nrecipients\030\n \003(\t\022\024\n\forganization\030\013 \001(\tBu\n\017com.google.typeB\022PostalAddressProtoP\001ZFgoogle.golang.org/genproto/googleapis/type/postaladdress;postaladdress¢\002\003GTPb\006proto3" }, new Descriptors.FileDescriptor[0], internalDescriptorAssigner);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\type\PostalAddressProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */