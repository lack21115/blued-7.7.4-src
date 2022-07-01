package com.google.api;

import com.google.protobuf.AnyProto;
import com.google.protobuf.ApiProto;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.TypeProto;
import com.google.protobuf.WrappersProto;

public final class ServiceProto {
  static final Descriptors.Descriptor a = a().getMessageTypes().get(0);
  
  static final GeneratedMessageV3.FieldAccessorTable b = new GeneratedMessageV3.FieldAccessorTable(a, new String[] { 
        "ConfigVersion", "Name", "Id", "Title", "ProducerProjectId", "Apis", "Types", "Enums", "Documentation", "Backend", 
        "Http", "Quota", "Authentication", "Context", "Usage", "Endpoints", "Control", "Logs", "Metrics", "MonitoredResources", 
        "Billing", "Logging", "Monitoring", "SystemParameters", "SourceInfo" });
  
  private static Descriptors.FileDescriptor c;
  
  static {
    AuthProto.a();
    BackendProto.a();
    BillingProto.a();
    ContextProto.a();
    ControlProto.a();
    DocumentationProto.a();
    EndpointProto.a();
    HttpProto.a();
    LabelProto.a();
    LogProto.a();
    LoggingProto.a();
    MetricProto.a();
    MonitoredResourceProto.a();
    MonitoringProto.a();
    QuotaProto.a();
    ResourceProto.a();
    SourceInfoProto.a();
    SystemParameterProto.a();
    UsageProto.a();
    AnyProto.getDescriptor();
    ApiProto.getDescriptor();
    TypeProto.getDescriptor();
    WrappersProto.getDescriptor();
  }
  
  public static Descriptors.FileDescriptor a() {
    return c;
  }
  
  static {
    Descriptors.FileDescriptor.InternalDescriptorAssigner internalDescriptorAssigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor param1FileDescriptor) {
          ServiceProto.a(param1FileDescriptor);
          return null;
        }
      };
    Descriptors.FileDescriptor fileDescriptor1 = AuthProto.a();
    Descriptors.FileDescriptor fileDescriptor2 = BackendProto.a();
    Descriptors.FileDescriptor fileDescriptor3 = BillingProto.a();
    Descriptors.FileDescriptor fileDescriptor4 = ContextProto.a();
    Descriptors.FileDescriptor fileDescriptor5 = ControlProto.a();
    Descriptors.FileDescriptor fileDescriptor6 = DocumentationProto.a();
    Descriptors.FileDescriptor fileDescriptor7 = EndpointProto.a();
    Descriptors.FileDescriptor fileDescriptor8 = HttpProto.a();
    Descriptors.FileDescriptor fileDescriptor9 = LabelProto.a();
    Descriptors.FileDescriptor fileDescriptor10 = LogProto.a();
    Descriptors.FileDescriptor fileDescriptor11 = LoggingProto.a();
    Descriptors.FileDescriptor fileDescriptor12 = MetricProto.a();
    Descriptors.FileDescriptor fileDescriptor13 = MonitoredResourceProto.a();
    Descriptors.FileDescriptor fileDescriptor14 = MonitoringProto.a();
    Descriptors.FileDescriptor fileDescriptor15 = QuotaProto.a();
    Descriptors.FileDescriptor fileDescriptor16 = ResourceProto.a();
    Descriptors.FileDescriptor fileDescriptor17 = SourceInfoProto.a();
    Descriptors.FileDescriptor fileDescriptor18 = SystemParameterProto.a();
    Descriptors.FileDescriptor fileDescriptor19 = UsageProto.a();
    Descriptors.FileDescriptor fileDescriptor20 = AnyProto.getDescriptor();
    Descriptors.FileDescriptor fileDescriptor21 = ApiProto.getDescriptor();
    Descriptors.FileDescriptor fileDescriptor22 = TypeProto.getDescriptor();
    Descriptors.FileDescriptor fileDescriptor23 = WrappersProto.getDescriptor();
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\030google/api/service.proto\022\ngoogle.api\032\025google/api/auth.proto\032\030google/api/backend.proto\032\030google/api/billing.proto\032\030google/api/context.proto\032\030google/api/control.proto\032\036google/api/documentation.proto\032\031google/api/endpoint.proto\032\025google/api/http.proto\032\026google/api/label.proto\032\024google/api/log.proto\032\030google/api/logging.proto\032\027google/api/metric.proto\032#google/api/monitored_resource.proto\032\033google/api/monitoring.proto\032\026google/api/quota.proto\032\031google/api/resource.proto\032\034google/api/source_info.proto\032!google/api/system_parameter.proto\032\026google/api/usage.proto\032\031google/protobuf/any.proto\032\031google/protobuf/api.proto\032\032google/protobuf/type.proto\032\036google/protobuf/wrappers.proto\"Ö\007\n\007Service\0224\n\016config_version\030\024 \001(\0132\034.google.protobuf.UInt32Value\022\f\n\004name\030\001 \001(\t\022\n\n\002id\030! \001(\t\022\r\n\005title\030\002 \001(\t\022\033\n\023producer_project_id\030\026 \001(\t\022\"\n\004apis\030\003 \003(\0132\024.google.protobuf.Api\022$\n\005types\030\004 \003(\0132\025.google.protobuf.Type\022$\n\005enums\030\005 \003(\0132\025.google.protobuf.Enum\0220\n\rdocumentation\030\006 \001(\0132\031.google.api.Documentation\022$\n\007backend\030\b \001(\0132\023.google.api.Backend\022\036\n\004http\030\t \001(\0132\020.google.api.Http\022 \n\005quota\030\n \001(\0132\021.google.api.Quota\0222\n\016authentication\030\013 \001(\0132\032.google.api.Authentication\022$\n\007context\030\f \001(\0132\023.google.api.Context\022 \n\005usage\030\017 \001(\0132\021.google.api.Usage\022'\n\tendpoints\030\022 \003(\0132\024.google.api.Endpoint\022$\n\007control\030\025 \001(\0132\023.google.api.Control\022'\n\004logs\030\027 \003(\0132\031.google.api.LogDescriptor\022-\n\007metrics\030\030 \003(\0132\034.google.api.MetricDescriptor\022D\n\023monitored_resources\030\031 \003(\0132'.google.api.MonitoredResourceDescriptor\022$\n\007billing\030\032 \001(\0132\023.google.api.Billing\022$\n\007logging\030\033 \001(\0132\023.google.api.Logging\022*\n\nmonitoring\030\034 \001(\0132\026.google.api.Monitoring\0227\n\021system_parameters\030\035 \001(\0132\034.google.api.SystemParameters\022+\n\013source_info\030% \001(\0132\026.google.api.SourceInfoBn\n\016com.google.apiB\fServiceProtoP\001ZEgoogle.golang.org/genproto/googleapis/api/serviceconfig;serviceconfig¢\002\004GAPIb\006proto3" }, new Descriptors.FileDescriptor[] { 
          fileDescriptor1, fileDescriptor2, fileDescriptor3, fileDescriptor4, fileDescriptor5, fileDescriptor6, fileDescriptor7, fileDescriptor8, fileDescriptor9, fileDescriptor10, 
          fileDescriptor11, fileDescriptor12, fileDescriptor13, fileDescriptor14, fileDescriptor15, fileDescriptor16, fileDescriptor17, fileDescriptor18, fileDescriptor19, fileDescriptor20, 
          fileDescriptor21, fileDescriptor22, fileDescriptor23 }, internalDescriptorAssigner);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\ServiceProto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */