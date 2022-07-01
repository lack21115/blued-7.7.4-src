package com.google.api;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessageV3;

public final class AuthProto {
  static final Descriptors.Descriptor a = a().getMessageTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable b = new GeneratedMessageV3.FieldAccessorTable(a, new String[] { "Rules", "Providers" });
  
  static final Descriptors.Descriptor c = a().getMessageTypes().get(1);
  
  static final GeneratedMessageV3.FieldAccessorTable d = new GeneratedMessageV3.FieldAccessorTable(c, new String[] { "Selector", "Oauth", "AllowWithoutCredential", "Requirements" });
  
  static final Descriptors.Descriptor e = a().getMessageTypes().get(2);
  
  static final GeneratedMessageV3.FieldAccessorTable f = new GeneratedMessageV3.FieldAccessorTable(e, new String[] { "Id", "Issuer", "JwksUri", "Audiences", "AuthorizationUrl" });
  
  static final Descriptors.Descriptor g = a().getMessageTypes().get(3);
  
  static final GeneratedMessageV3.FieldAccessorTable h = new GeneratedMessageV3.FieldAccessorTable(g, new String[] { "CanonicalScopes" });
  
  static final Descriptors.Descriptor i = a().getMessageTypes().get(4);
  
  static final GeneratedMessageV3.FieldAccessorTable j = new GeneratedMessageV3.FieldAccessorTable(i, new String[] { "ProviderId", "Audiences" });
  
  private static Descriptors.FileDescriptor k;
  
  public static Descriptors.FileDescriptor a() {
    return k;
  }
  
  static {
    Descriptors.FileDescriptor.InternalDescriptorAssigner internalDescriptorAssigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor param1FileDescriptor) {
          AuthProto.a(param1FileDescriptor);
          return null;
        }
      };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\025google/api/auth.proto\022\ngoogle.api\"l\n\016Authentication\022-\n\005rules\030\003 \003(\0132\036.google.api.AuthenticationRule\022+\n\tproviders\030\004 \003(\0132\030.google.api.AuthProvider\"©\001\n\022AuthenticationRule\022\020\n\bselector\030\001 \001(\t\022,\n\005oauth\030\002 \001(\0132\035.google.api.OAuthRequirements\022 \n\030allow_without_credential\030\005 \001(\b\0221\n\frequirements\030\007 \003(\0132\033.google.api.AuthRequirement\"j\n\fAuthProvider\022\n\n\002id\030\001 \001(\t\022\016\n\006issuer\030\002 \001(\t\022\020\n\bjwks_uri\030\003 \001(\t\022\021\n\taudiences\030\004 \001(\t\022\031\n\021authorization_url\030\005 \001(\t\"-\n\021OAuthRequirements\022\030\n\020canonical_scopes\030\001 \001(\t\"9\n\017AuthRequirement\022\023\n\013provider_id\030\001 \001(\t\022\021\n\taudiences\030\002 \001(\tBk\n\016com.google.apiB\tAuthProtoP\001ZEgoogle.golang.org/genproto/googleapis/api/serviceconfig;serviceconfig¢\002\004GAPIb\006proto3" }, new Descriptors.FileDescriptor[0], internalDescriptorAssigner);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\AuthProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */