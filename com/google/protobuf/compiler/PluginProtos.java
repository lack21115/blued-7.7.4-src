package com.google.protobuf.compiler;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class PluginProtos {
  private static Descriptors.FileDescriptor descriptor;
  
  private static final Descriptors.Descriptor internal_static_google_protobuf_compiler_CodeGeneratorRequest_descriptor;
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_compiler_CodeGeneratorRequest_fieldAccessorTable;
  
  private static final Descriptors.Descriptor internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor;
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_fieldAccessorTable;
  
  private static final Descriptors.Descriptor internal_static_google_protobuf_compiler_CodeGeneratorResponse_descriptor;
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_compiler_CodeGeneratorResponse_fieldAccessorTable;
  
  private static final Descriptors.Descriptor internal_static_google_protobuf_compiler_Version_descriptor = getDescriptor().getMessageTypes().get(0);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_google_protobuf_compiler_Version_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_google_protobuf_compiler_Version_descriptor, new String[] { "Major", "Minor", "Patch", "Suffix" });
  
  static {
    internal_static_google_protobuf_compiler_CodeGeneratorRequest_descriptor = getDescriptor().getMessageTypes().get(1);
    internal_static_google_protobuf_compiler_CodeGeneratorRequest_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_google_protobuf_compiler_CodeGeneratorRequest_descriptor, new String[] { "FileToGenerate", "Parameter", "ProtoFile", "CompilerVersion" });
    internal_static_google_protobuf_compiler_CodeGeneratorResponse_descriptor = getDescriptor().getMessageTypes().get(2);
    internal_static_google_protobuf_compiler_CodeGeneratorResponse_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_google_protobuf_compiler_CodeGeneratorResponse_descriptor, new String[] { "Error", "SupportedFeatures", "File" });
    internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor = internal_static_google_protobuf_compiler_CodeGeneratorResponse_descriptor.getNestedTypes().get(0);
    internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor, new String[] { "Name", "InsertionPoint", "Content" });
    DescriptorProtos.getDescriptor();
  }
  
  public static Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {
    registerAllExtensions((ExtensionRegistryLite)paramExtensionRegistry);
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  static {
    Descriptors.FileDescriptor fileDescriptor = DescriptorProtos.getDescriptor();
    descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n%google/protobuf/compiler/plugin.proto\022\030google.protobuf.compiler\032 google/protobuf/descriptor.proto\"F\n\007Version\022\r\n\005major\030\001 \001(\005\022\r\n\005minor\030\002 \001(\005\022\r\n\005patch\030\003 \001(\005\022\016\n\006suffix\030\004 \001(\t\"º\001\n\024CodeGeneratorRequest\022\030\n\020file_to_generate\030\001 \003(\t\022\021\n\tparameter\030\002 \001(\t\0228\n\nproto_file\030\017 \003(\0132$.google.protobuf.FileDescriptorProto\022;\n\020compiler_version\030\003 \001(\0132!.google.protobuf.compiler.Version\"\002\n\025CodeGeneratorResponse\022\r\n\005error\030\001 \001(\t\022\032\n\022supported_features\030\002 \001(\004\022B\n\004file\030\017 \003(\01324.google.protobuf.compiler.CodeGeneratorResponse.File\032>\n\004File\022\f\n\004name\030\001 \001(\t\022\027\n\017insertion_point\030\002 \001(\t\022\017\n\007content\030\017 \001(\t\"8\n\007Feature\022\020\n\fFEATURE_NONE\020\000\022\033\n\027FEATURE_PROTO3_OPTIONAL\020\001Bg\n\034com.google.protobuf.compilerB\fPluginProtosZ9github.com/golang/protobuf/protoc-gen-go/plugin;plugin_go" }, new Descriptors.FileDescriptor[] { fileDescriptor });
  }
  
  public static final class CodeGeneratorRequest extends GeneratedMessageV3 implements CodeGeneratorRequestOrBuilder {
    public static final int COMPILER_VERSION_FIELD_NUMBER = 3;
    
    private static final CodeGeneratorRequest DEFAULT_INSTANCE = new CodeGeneratorRequest();
    
    public static final int FILE_TO_GENERATE_FIELD_NUMBER = 1;
    
    public static final int PARAMETER_FIELD_NUMBER = 2;
    
    @Deprecated
    public static final Parser<CodeGeneratorRequest> PARSER = (Parser<CodeGeneratorRequest>)new AbstractParser<CodeGeneratorRequest>() {
        public PluginProtos.CodeGeneratorRequest parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new PluginProtos.CodeGeneratorRequest(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int PROTO_FILE_FIELD_NUMBER = 15;
    
    private static final long serialVersionUID = 0L;
    
    private int bitField0_;
    
    private PluginProtos.Version compilerVersion_;
    
    private LazyStringList fileToGenerate_;
    
    private byte memoizedIsInitialized = -1;
    
    private volatile Object parameter_;
    
    private List<DescriptorProtos.FileDescriptorProto> protoFile_;
    
    private CodeGeneratorRequest() {
      this.fileToGenerate_ = LazyStringArrayList.EMPTY;
      this.parameter_ = "";
      this.protoFile_ = Collections.emptyList();
    }
    
    private CodeGeneratorRequest(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        boolean bool = false;
        int i = 0;
        while (!bool) {
          int j = i;
          int k = i;
          int m = i;
          try {
            int n = param1CodedInputStream.readTag();
            if (n != 0) {
              if (n != 10) {
                if (n != 18) {
                  if (n != 26) {
                    if (n != 122) {
                      j = i;
                      k = i;
                      m = i;
                      if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, n))
                        continue; 
                      continue;
                    } 
                    n = i;
                    if ((i & 0x4) == 0) {
                      j = i;
                      k = i;
                      m = i;
                      this.protoFile_ = new ArrayList<DescriptorProtos.FileDescriptorProto>();
                      n = i | 0x4;
                    } 
                    j = n;
                    k = n;
                    m = n;
                    this.protoFile_.add(param1CodedInputStream.readMessage(DescriptorProtos.FileDescriptorProto.PARSER, param1ExtensionRegistryLite));
                    i = n;
                    continue;
                  } 
                  PluginProtos.Version.Builder builder1 = null;
                  j = i;
                  k = i;
                  m = i;
                  if ((this.bitField0_ & 0x2) != 0) {
                    j = i;
                    k = i;
                    m = i;
                    builder1 = this.compilerVersion_.toBuilder();
                  } 
                  j = i;
                  k = i;
                  m = i;
                  this.compilerVersion_ = (PluginProtos.Version)param1CodedInputStream.readMessage(PluginProtos.Version.PARSER, param1ExtensionRegistryLite);
                  if (builder1 != null) {
                    j = i;
                    k = i;
                    m = i;
                    builder1.mergeFrom(this.compilerVersion_);
                    j = i;
                    k = i;
                    m = i;
                    this.compilerVersion_ = builder1.buildPartial();
                  } 
                  j = i;
                  k = i;
                  m = i;
                  this.bitField0_ |= 0x2;
                  continue;
                } 
                j = i;
                k = i;
                m = i;
                ByteString byteString1 = param1CodedInputStream.readBytes();
                j = i;
                k = i;
                m = i;
                this.bitField0_ = 0x1 | this.bitField0_;
                j = i;
                k = i;
                m = i;
                this.parameter_ = byteString1;
                continue;
              } 
              j = i;
              k = i;
              m = i;
              ByteString byteString = param1CodedInputStream.readBytes();
              n = i;
              if ((i & 0x1) == 0) {
                j = i;
                k = i;
                m = i;
                this.fileToGenerate_ = (LazyStringList)new LazyStringArrayList();
                n = i | 0x1;
              } 
              j = n;
              k = n;
              m = n;
              this.fileToGenerate_.add(byteString);
              i = n;
              continue;
            } 
            continue;
          } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            j = m;
            throw invalidProtocolBufferException.setUnfinishedMessage(this);
          } catch (IOException iOException) {
            j = k;
            throw (new InvalidProtocolBufferException(iOException)).setUnfinishedMessage(this);
          } finally {}
          if ((j & 0x1) != 0)
            this.fileToGenerate_ = this.fileToGenerate_.getUnmodifiableView(); 
          if ((j & 0x4) != 0)
            this.protoFile_ = Collections.unmodifiableList(this.protoFile_); 
          this.unknownFields = builder.build();
          makeExtensionsImmutable();
          throw param1CodedInputStream;
          bool = true;
        } 
        if ((i & 0x1) != 0)
          this.fileToGenerate_ = this.fileToGenerate_.getUnmodifiableView(); 
        if ((i & 0x4) != 0)
          this.protoFile_ = Collections.unmodifiableList(this.protoFile_); 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        return;
      } 
      throw new NullPointerException();
    }
    
    private CodeGeneratorRequest(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static CodeGeneratorRequest getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorRequest_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(CodeGeneratorRequest param1CodeGeneratorRequest) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1CodeGeneratorRequest);
    }
    
    public static CodeGeneratorRequest parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (CodeGeneratorRequest)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static CodeGeneratorRequest parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (CodeGeneratorRequest)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static CodeGeneratorRequest parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (CodeGeneratorRequest)PARSER.parseFrom(param1ByteString);
    }
    
    public static CodeGeneratorRequest parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (CodeGeneratorRequest)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static CodeGeneratorRequest parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (CodeGeneratorRequest)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static CodeGeneratorRequest parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (CodeGeneratorRequest)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static CodeGeneratorRequest parseFrom(InputStream param1InputStream) throws IOException {
      return (CodeGeneratorRequest)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static CodeGeneratorRequest parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (CodeGeneratorRequest)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static CodeGeneratorRequest parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (CodeGeneratorRequest)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static CodeGeneratorRequest parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (CodeGeneratorRequest)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static CodeGeneratorRequest parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (CodeGeneratorRequest)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static CodeGeneratorRequest parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (CodeGeneratorRequest)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<CodeGeneratorRequest> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof CodeGeneratorRequest))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return !getFileToGenerateList().equals(param1Object.getFileToGenerateList()) ? false : ((hasParameter() != param1Object.hasParameter()) ? false : ((hasParameter() && !getParameter().equals(param1Object.getParameter())) ? false : (!getProtoFileList().equals(param1Object.getProtoFileList()) ? false : ((hasCompilerVersion() != param1Object.hasCompilerVersion()) ? false : ((hasCompilerVersion() && !getCompilerVersion().equals(param1Object.getCompilerVersion())) ? false : (!!this.unknownFields.equals(((CodeGeneratorRequest)param1Object).unknownFields)))))));
    }
    
    public PluginProtos.Version getCompilerVersion() {
      PluginProtos.Version version2 = this.compilerVersion_;
      PluginProtos.Version version1 = version2;
      if (version2 == null)
        version1 = PluginProtos.Version.getDefaultInstance(); 
      return version1;
    }
    
    public PluginProtos.VersionOrBuilder getCompilerVersionOrBuilder() {
      PluginProtos.Version version2 = this.compilerVersion_;
      PluginProtos.Version version1 = version2;
      if (version2 == null)
        version1 = PluginProtos.Version.getDefaultInstance(); 
      return version1;
    }
    
    public CodeGeneratorRequest getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public String getFileToGenerate(int param1Int) {
      return (String)this.fileToGenerate_.get(param1Int);
    }
    
    public ByteString getFileToGenerateBytes(int param1Int) {
      return this.fileToGenerate_.getByteString(param1Int);
    }
    
    public int getFileToGenerateCount() {
      return this.fileToGenerate_.size();
    }
    
    public ProtocolStringList getFileToGenerateList() {
      return (ProtocolStringList)this.fileToGenerate_;
    }
    
    public String getParameter() {
      Object object = this.parameter_;
      if (object instanceof String)
        return (String)object; 
      object = object;
      String str = object.toStringUtf8();
      if (object.isValidUtf8())
        this.parameter_ = str; 
      return str;
    }
    
    public ByteString getParameterBytes() {
      Object object = this.parameter_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.parameter_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public Parser<CodeGeneratorRequest> getParserForType() {
      return PARSER;
    }
    
    public DescriptorProtos.FileDescriptorProto getProtoFile(int param1Int) {
      return this.protoFile_.get(param1Int);
    }
    
    public int getProtoFileCount() {
      return this.protoFile_.size();
    }
    
    public List<DescriptorProtos.FileDescriptorProto> getProtoFileList() {
      return this.protoFile_;
    }
    
    public DescriptorProtos.FileDescriptorProtoOrBuilder getProtoFileOrBuilder(int param1Int) {
      return (DescriptorProtos.FileDescriptorProtoOrBuilder)this.protoFile_.get(param1Int);
    }
    
    public List<? extends DescriptorProtos.FileDescriptorProtoOrBuilder> getProtoFileOrBuilderList() {
      return (List)this.protoFile_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      byte b = 0;
      i = 0;
      int j = 0;
      while (i < this.fileToGenerate_.size()) {
        j += computeStringSizeNoTag(this.fileToGenerate_.getRaw(i));
        i++;
      } 
      j = j + 0 + getFileToGenerateList().size() * 1;
      i = j;
      if ((this.bitField0_ & 0x1) != 0)
        i = j + GeneratedMessageV3.computeStringSize(2, this.parameter_); 
      int k = b;
      j = i;
      if ((this.bitField0_ & 0x2) != 0) {
        j = i + CodedOutputStream.computeMessageSize(3, (MessageLite)getCompilerVersion());
        k = b;
      } 
      while (k < this.protoFile_.size()) {
        j += CodedOutputStream.computeMessageSize(15, (MessageLite)this.protoFile_.get(k));
        k++;
      } 
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }
    
    public boolean hasCompilerVersion() {
      return ((this.bitField0_ & 0x2) != 0);
    }
    
    public boolean hasParameter() {
      return ((this.bitField0_ & 0x1) != 0);
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int j = 779 + getDescriptor().hashCode();
      int i = j;
      if (getFileToGenerateCount() > 0)
        i = (j * 37 + 1) * 53 + getFileToGenerateList().hashCode(); 
      j = i;
      if (hasParameter())
        j = (i * 37 + 2) * 53 + getParameter().hashCode(); 
      i = j;
      if (getProtoFileCount() > 0)
        i = (j * 37 + 15) * 53 + getProtoFileList().hashCode(); 
      j = i;
      if (hasCompilerVersion())
        j = (i * 37 + 3) * 53 + getCompilerVersion().hashCode(); 
      i = j * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(CodeGeneratorRequest.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      byte b = this.memoizedIsInitialized;
      if (b == 1)
        return true; 
      if (b == 0)
        return false; 
      b = 0;
      while (b < getProtoFileCount()) {
        if (!getProtoFile(b).isInitialized()) {
          this.memoizedIsInitialized = 0;
          return false;
        } 
        int i = b + 1;
      } 
      this.memoizedIsInitialized = 1;
      return true;
    }
    
    public Builder newBuilderForType() {
      return newBuilder();
    }
    
    protected Builder newBuilderForType(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      return new Builder(param1BuilderParent);
    }
    
    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter param1UnusedPrivateParameter) {
      return new CodeGeneratorRequest();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      boolean bool = false;
      int i;
      for (i = 0; i < this.fileToGenerate_.size(); i++)
        GeneratedMessageV3.writeString(param1CodedOutputStream, 1, this.fileToGenerate_.getRaw(i)); 
      if ((this.bitField0_ & 0x1) != 0)
        GeneratedMessageV3.writeString(param1CodedOutputStream, 2, this.parameter_); 
      i = bool;
      if ((this.bitField0_ & 0x2) != 0) {
        param1CodedOutputStream.writeMessage(3, (MessageLite)getCompilerVersion());
        i = bool;
      } 
      while (i < this.protoFile_.size()) {
        param1CodedOutputStream.writeMessage(15, (MessageLite)this.protoFile_.get(i));
        i++;
      } 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PluginProtos.CodeGeneratorRequestOrBuilder {
      private int bitField0_;
      
      private SingleFieldBuilderV3<PluginProtos.Version, PluginProtos.Version.Builder, PluginProtos.VersionOrBuilder> compilerVersionBuilder_;
      
      private PluginProtos.Version compilerVersion_;
      
      private LazyStringList fileToGenerate_ = LazyStringArrayList.EMPTY;
      
      private Object parameter_ = "";
      
      private RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> protoFileBuilder_;
      
      private List<DescriptorProtos.FileDescriptorProto> protoFile_ = Collections.emptyList();
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      private void ensureFileToGenerateIsMutable() {
        if ((this.bitField0_ & 0x1) == 0) {
          this.fileToGenerate_ = (LazyStringList)new LazyStringArrayList(this.fileToGenerate_);
          this.bitField0_ |= 0x1;
        } 
      }
      
      private void ensureProtoFileIsMutable() {
        if ((this.bitField0_ & 0x4) == 0) {
          this.protoFile_ = new ArrayList<DescriptorProtos.FileDescriptorProto>(this.protoFile_);
          this.bitField0_ |= 0x4;
        } 
      }
      
      private SingleFieldBuilderV3<PluginProtos.Version, PluginProtos.Version.Builder, PluginProtos.VersionOrBuilder> getCompilerVersionFieldBuilder() {
        if (this.compilerVersionBuilder_ == null) {
          this.compilerVersionBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getCompilerVersion(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.compilerVersion_ = null;
        } 
        return this.compilerVersionBuilder_;
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorRequest_descriptor;
      }
      
      private RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> getProtoFileFieldBuilder() {
        if (this.protoFileBuilder_ == null) {
          boolean bool;
          List<DescriptorProtos.FileDescriptorProto> list = this.protoFile_;
          if ((this.bitField0_ & 0x4) != 0) {
            bool = true;
          } else {
            bool = false;
          } 
          this.protoFileBuilder_ = new RepeatedFieldBuilderV3(list, bool, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.protoFile_ = null;
        } 
        return this.protoFileBuilder_;
      }
      
      private void maybeForceBuilderInitialization() {
        if (PluginProtos.CodeGeneratorRequest.alwaysUseFieldBuilders) {
          getProtoFileFieldBuilder();
          getCompilerVersionFieldBuilder();
        } 
      }
      
      public Builder addAllFileToGenerate(Iterable<String> param2Iterable) {
        ensureFileToGenerateIsMutable();
        AbstractMessageLite.Builder.addAll(param2Iterable, (List)this.fileToGenerate_);
        onChanged();
        return this;
      }
      
      public Builder addAllProtoFile(Iterable<? extends DescriptorProtos.FileDescriptorProto> param2Iterable) {
        RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          ensureProtoFileIsMutable();
          AbstractMessageLite.Builder.addAll(param2Iterable, this.protoFile_);
          onChanged();
          return this;
        } 
        repeatedFieldBuilderV3.addAllMessages(param2Iterable);
        return this;
      }
      
      public Builder addFileToGenerate(String param2String) {
        if (param2String != null) {
          ensureFileToGenerateIsMutable();
          this.fileToGenerate_.add(param2String);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder addFileToGenerateBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          ensureFileToGenerateIsMutable();
          this.fileToGenerate_.add(param2ByteString);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder addProtoFile(int param2Int, DescriptorProtos.FileDescriptorProto.Builder param2Builder) {
        RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          ensureProtoFileIsMutable();
          this.protoFile_.add(param2Int, param2Builder.build());
          onChanged();
          return this;
        } 
        repeatedFieldBuilderV3.addMessage(param2Int, (AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder addProtoFile(int param2Int, DescriptorProtos.FileDescriptorProto param2FileDescriptorProto) {
        RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          if (param2FileDescriptorProto != null) {
            ensureProtoFileIsMutable();
            this.protoFile_.add(param2Int, param2FileDescriptorProto);
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        repeatedFieldBuilderV3.addMessage(param2Int, (AbstractMessage)param2FileDescriptorProto);
        return this;
      }
      
      public Builder addProtoFile(DescriptorProtos.FileDescriptorProto.Builder param2Builder) {
        RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          ensureProtoFileIsMutable();
          this.protoFile_.add(param2Builder.build());
          onChanged();
          return this;
        } 
        repeatedFieldBuilderV3.addMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder addProtoFile(DescriptorProtos.FileDescriptorProto param2FileDescriptorProto) {
        RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          if (param2FileDescriptorProto != null) {
            ensureProtoFileIsMutable();
            this.protoFile_.add(param2FileDescriptorProto);
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        repeatedFieldBuilderV3.addMessage((AbstractMessage)param2FileDescriptorProto);
        return this;
      }
      
      public DescriptorProtos.FileDescriptorProto.Builder addProtoFileBuilder() {
        return (DescriptorProtos.FileDescriptorProto.Builder)getProtoFileFieldBuilder().addBuilder((AbstractMessage)DescriptorProtos.FileDescriptorProto.getDefaultInstance());
      }
      
      public DescriptorProtos.FileDescriptorProto.Builder addProtoFileBuilder(int param2Int) {
        return (DescriptorProtos.FileDescriptorProto.Builder)getProtoFileFieldBuilder().addBuilder(param2Int, (AbstractMessage)DescriptorProtos.FileDescriptorProto.getDefaultInstance());
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public PluginProtos.CodeGeneratorRequest build() {
        PluginProtos.CodeGeneratorRequest codeGeneratorRequest = buildPartial();
        if (codeGeneratorRequest.isInitialized())
          return codeGeneratorRequest; 
        throw newUninitializedMessageException(codeGeneratorRequest);
      }
      
      public PluginProtos.CodeGeneratorRequest buildPartial() {
        byte b;
        PluginProtos.CodeGeneratorRequest codeGeneratorRequest = new PluginProtos.CodeGeneratorRequest(this);
        int j = this.bitField0_;
        if ((j & 0x1) != 0) {
          this.fileToGenerate_ = this.fileToGenerate_.getUnmodifiableView();
          this.bitField0_ &= 0xFFFFFFFE;
        } 
        PluginProtos.CodeGeneratorRequest.access$1902(codeGeneratorRequest, this.fileToGenerate_);
        if ((j & 0x2) != 0) {
          b = 1;
        } else {
          b = 0;
        } 
        PluginProtos.CodeGeneratorRequest.access$2002(codeGeneratorRequest, this.parameter_);
        RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          if ((this.bitField0_ & 0x4) != 0) {
            this.protoFile_ = Collections.unmodifiableList(this.protoFile_);
            this.bitField0_ &= 0xFFFFFFFB;
          } 
          PluginProtos.CodeGeneratorRequest.access$2102(codeGeneratorRequest, this.protoFile_);
        } else {
          PluginProtos.CodeGeneratorRequest.access$2102(codeGeneratorRequest, repeatedFieldBuilderV3.build());
        } 
        int i = b;
        if ((j & 0x8) != 0) {
          SingleFieldBuilderV3<PluginProtos.Version, PluginProtos.Version.Builder, PluginProtos.VersionOrBuilder> singleFieldBuilderV3 = this.compilerVersionBuilder_;
          if (singleFieldBuilderV3 == null) {
            PluginProtos.CodeGeneratorRequest.access$2202(codeGeneratorRequest, this.compilerVersion_);
          } else {
            PluginProtos.CodeGeneratorRequest.access$2202(codeGeneratorRequest, (PluginProtos.Version)singleFieldBuilderV3.build());
          } 
          i = b | 0x2;
        } 
        PluginProtos.CodeGeneratorRequest.access$2302(codeGeneratorRequest, i);
        onBuilt();
        return codeGeneratorRequest;
      }
      
      public Builder clear() {
        super.clear();
        this.fileToGenerate_ = LazyStringArrayList.EMPTY;
        this.bitField0_ &= 0xFFFFFFFE;
        this.parameter_ = "";
        this.bitField0_ &= 0xFFFFFFFD;
        RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          this.protoFile_ = Collections.emptyList();
          this.bitField0_ &= 0xFFFFFFFB;
        } else {
          repeatedFieldBuilderV3.clear();
        } 
        SingleFieldBuilderV3<PluginProtos.Version, PluginProtos.Version.Builder, PluginProtos.VersionOrBuilder> singleFieldBuilderV3 = this.compilerVersionBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.compilerVersion_ = null;
        } else {
          singleFieldBuilderV3.clear();
        } 
        this.bitField0_ &= 0xFFFFFFF7;
        return this;
      }
      
      public Builder clearCompilerVersion() {
        SingleFieldBuilderV3<PluginProtos.Version, PluginProtos.Version.Builder, PluginProtos.VersionOrBuilder> singleFieldBuilderV3 = this.compilerVersionBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.compilerVersion_ = null;
          onChanged();
        } else {
          singleFieldBuilderV3.clear();
        } 
        this.bitField0_ &= 0xFFFFFFF7;
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearFileToGenerate() {
        this.fileToGenerate_ = LazyStringArrayList.EMPTY;
        this.bitField0_ &= 0xFFFFFFFE;
        onChanged();
        return this;
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearParameter() {
        this.bitField0_ &= 0xFFFFFFFD;
        this.parameter_ = PluginProtos.CodeGeneratorRequest.getDefaultInstance().getParameter();
        onChanged();
        return this;
      }
      
      public Builder clearProtoFile() {
        RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          this.protoFile_ = Collections.emptyList();
          this.bitField0_ &= 0xFFFFFFFB;
          onChanged();
          return this;
        } 
        repeatedFieldBuilderV3.clear();
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public PluginProtos.Version getCompilerVersion() {
        PluginProtos.Version version;
        SingleFieldBuilderV3<PluginProtos.Version, PluginProtos.Version.Builder, PluginProtos.VersionOrBuilder> singleFieldBuilderV3 = this.compilerVersionBuilder_;
        if (singleFieldBuilderV3 == null) {
          PluginProtos.Version version1 = this.compilerVersion_;
          version = version1;
          if (version1 == null)
            version = PluginProtos.Version.getDefaultInstance(); 
          return version;
        } 
        return (PluginProtos.Version)version.getMessage();
      }
      
      public PluginProtos.Version.Builder getCompilerVersionBuilder() {
        this.bitField0_ |= 0x8;
        onChanged();
        return (PluginProtos.Version.Builder)getCompilerVersionFieldBuilder().getBuilder();
      }
      
      public PluginProtos.VersionOrBuilder getCompilerVersionOrBuilder() {
        SingleFieldBuilderV3<PluginProtos.Version, PluginProtos.Version.Builder, PluginProtos.VersionOrBuilder> singleFieldBuilderV3 = this.compilerVersionBuilder_;
        if (singleFieldBuilderV3 != null)
          return (PluginProtos.VersionOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
        PluginProtos.Version version2 = this.compilerVersion_;
        PluginProtos.Version version1 = version2;
        if (version2 == null)
          version1 = PluginProtos.Version.getDefaultInstance(); 
        return version1;
      }
      
      public PluginProtos.CodeGeneratorRequest getDefaultInstanceForType() {
        return PluginProtos.CodeGeneratorRequest.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorRequest_descriptor;
      }
      
      public String getFileToGenerate(int param2Int) {
        return (String)this.fileToGenerate_.get(param2Int);
      }
      
      public ByteString getFileToGenerateBytes(int param2Int) {
        return this.fileToGenerate_.getByteString(param2Int);
      }
      
      public int getFileToGenerateCount() {
        return this.fileToGenerate_.size();
      }
      
      public ProtocolStringList getFileToGenerateList() {
        return (ProtocolStringList)this.fileToGenerate_.getUnmodifiableView();
      }
      
      public String getParameter() {
        Object object = this.parameter_;
        if (!(object instanceof String)) {
          object = object;
          String str = object.toStringUtf8();
          if (object.isValidUtf8())
            this.parameter_ = str; 
          return str;
        } 
        return (String)object;
      }
      
      public ByteString getParameterBytes() {
        Object object = this.parameter_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.parameter_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public DescriptorProtos.FileDescriptorProto getProtoFile(int param2Int) {
        RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
        return (repeatedFieldBuilderV3 == null) ? this.protoFile_.get(param2Int) : (DescriptorProtos.FileDescriptorProto)repeatedFieldBuilderV3.getMessage(param2Int);
      }
      
      public DescriptorProtos.FileDescriptorProto.Builder getProtoFileBuilder(int param2Int) {
        return (DescriptorProtos.FileDescriptorProto.Builder)getProtoFileFieldBuilder().getBuilder(param2Int);
      }
      
      public List<DescriptorProtos.FileDescriptorProto.Builder> getProtoFileBuilderList() {
        return getProtoFileFieldBuilder().getBuilderList();
      }
      
      public int getProtoFileCount() {
        RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
        return (repeatedFieldBuilderV3 == null) ? this.protoFile_.size() : repeatedFieldBuilderV3.getCount();
      }
      
      public List<DescriptorProtos.FileDescriptorProto> getProtoFileList() {
        RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
        return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.protoFile_) : repeatedFieldBuilderV3.getMessageList();
      }
      
      public DescriptorProtos.FileDescriptorProtoOrBuilder getProtoFileOrBuilder(int param2Int) {
        RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
        return (repeatedFieldBuilderV3 == null) ? (DescriptorProtos.FileDescriptorProtoOrBuilder)this.protoFile_.get(param2Int) : (DescriptorProtos.FileDescriptorProtoOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param2Int);
      }
      
      public List<? extends DescriptorProtos.FileDescriptorProtoOrBuilder> getProtoFileOrBuilderList() {
        RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
        return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.protoFile_);
      }
      
      public boolean hasCompilerVersion() {
        return ((this.bitField0_ & 0x8) != 0);
      }
      
      public boolean hasParameter() {
        return ((this.bitField0_ & 0x2) != 0);
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(PluginProtos.CodeGeneratorRequest.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        for (int i = 0; i < getProtoFileCount(); i++) {
          if (!getProtoFile(i).isInitialized())
            return false; 
        } 
        return true;
      }
      
      public Builder mergeCompilerVersion(PluginProtos.Version param2Version) {
        // Byte code:
        //   0: aload_0
        //   1: getfield compilerVersionBuilder_ : Lcom/google/protobuf/SingleFieldBuilderV3;
        //   4: astore_2
        //   5: aload_2
        //   6: ifnonnull -> 68
        //   9: aload_0
        //   10: getfield bitField0_ : I
        //   13: bipush #8
        //   15: iand
        //   16: ifeq -> 56
        //   19: aload_0
        //   20: getfield compilerVersion_ : Lcom/google/protobuf/compiler/PluginProtos$Version;
        //   23: astore_2
        //   24: aload_2
        //   25: ifnull -> 56
        //   28: aload_2
        //   29: invokestatic getDefaultInstance : ()Lcom/google/protobuf/compiler/PluginProtos$Version;
        //   32: if_acmpeq -> 56
        //   35: aload_0
        //   36: aload_0
        //   37: getfield compilerVersion_ : Lcom/google/protobuf/compiler/PluginProtos$Version;
        //   40: invokestatic newBuilder : (Lcom/google/protobuf/compiler/PluginProtos$Version;)Lcom/google/protobuf/compiler/PluginProtos$Version$Builder;
        //   43: aload_1
        //   44: invokevirtual mergeFrom : (Lcom/google/protobuf/compiler/PluginProtos$Version;)Lcom/google/protobuf/compiler/PluginProtos$Version$Builder;
        //   47: invokevirtual buildPartial : ()Lcom/google/protobuf/compiler/PluginProtos$Version;
        //   50: putfield compilerVersion_ : Lcom/google/protobuf/compiler/PluginProtos$Version;
        //   53: goto -> 61
        //   56: aload_0
        //   57: aload_1
        //   58: putfield compilerVersion_ : Lcom/google/protobuf/compiler/PluginProtos$Version;
        //   61: aload_0
        //   62: invokevirtual onChanged : ()V
        //   65: goto -> 74
        //   68: aload_2
        //   69: aload_1
        //   70: invokevirtual mergeFrom : (Lcom/google/protobuf/AbstractMessage;)Lcom/google/protobuf/SingleFieldBuilderV3;
        //   73: pop
        //   74: aload_0
        //   75: aload_0
        //   76: getfield bitField0_ : I
        //   79: bipush #8
        //   81: ior
        //   82: putfield bitField0_ : I
        //   85: aload_0
        //   86: areturn
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          PluginProtos.CodeGeneratorRequest codeGeneratorRequest = (PluginProtos.CodeGeneratorRequest)PluginProtos.CodeGeneratorRequest.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          PluginProtos.CodeGeneratorRequest codeGeneratorRequest = (PluginProtos.CodeGeneratorRequest)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((PluginProtos.CodeGeneratorRequest)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof PluginProtos.CodeGeneratorRequest)
          return mergeFrom((PluginProtos.CodeGeneratorRequest)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public Builder mergeFrom(PluginProtos.CodeGeneratorRequest param2CodeGeneratorRequest) {
        if (param2CodeGeneratorRequest == PluginProtos.CodeGeneratorRequest.getDefaultInstance())
          return this; 
        if (!param2CodeGeneratorRequest.fileToGenerate_.isEmpty()) {
          if (this.fileToGenerate_.isEmpty()) {
            this.fileToGenerate_ = param2CodeGeneratorRequest.fileToGenerate_;
            this.bitField0_ &= 0xFFFFFFFE;
          } else {
            ensureFileToGenerateIsMutable();
            this.fileToGenerate_.addAll((Collection)param2CodeGeneratorRequest.fileToGenerate_);
          } 
          onChanged();
        } 
        if (param2CodeGeneratorRequest.hasParameter()) {
          this.bitField0_ |= 0x2;
          this.parameter_ = param2CodeGeneratorRequest.parameter_;
          onChanged();
        } 
        if (this.protoFileBuilder_ == null) {
          if (!param2CodeGeneratorRequest.protoFile_.isEmpty()) {
            if (this.protoFile_.isEmpty()) {
              this.protoFile_ = param2CodeGeneratorRequest.protoFile_;
              this.bitField0_ &= 0xFFFFFFFB;
            } else {
              ensureProtoFileIsMutable();
              this.protoFile_.addAll(param2CodeGeneratorRequest.protoFile_);
            } 
            onChanged();
          } 
        } else if (!param2CodeGeneratorRequest.protoFile_.isEmpty()) {
          if (this.protoFileBuilder_.isEmpty()) {
            this.protoFileBuilder_.dispose();
            RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = null;
            this.protoFileBuilder_ = null;
            this.protoFile_ = param2CodeGeneratorRequest.protoFile_;
            this.bitField0_ &= 0xFFFFFFFB;
            if (PluginProtos.CodeGeneratorRequest.alwaysUseFieldBuilders)
              repeatedFieldBuilderV3 = getProtoFileFieldBuilder(); 
            this.protoFileBuilder_ = repeatedFieldBuilderV3;
          } else {
            this.protoFileBuilder_.addAllMessages(param2CodeGeneratorRequest.protoFile_);
          } 
        } 
        if (param2CodeGeneratorRequest.hasCompilerVersion())
          mergeCompilerVersion(param2CodeGeneratorRequest.getCompilerVersion()); 
        mergeUnknownFields(param2CodeGeneratorRequest.unknownFields);
        onChanged();
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder removeProtoFile(int param2Int) {
        RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          ensureProtoFileIsMutable();
          this.protoFile_.remove(param2Int);
          onChanged();
          return this;
        } 
        repeatedFieldBuilderV3.remove(param2Int);
        return this;
      }
      
      public Builder setCompilerVersion(PluginProtos.Version.Builder param2Builder) {
        SingleFieldBuilderV3<PluginProtos.Version, PluginProtos.Version.Builder, PluginProtos.VersionOrBuilder> singleFieldBuilderV3 = this.compilerVersionBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.compilerVersion_ = param2Builder.build();
          onChanged();
        } else {
          singleFieldBuilderV3.setMessage((AbstractMessage)param2Builder.build());
        } 
        this.bitField0_ |= 0x8;
        return this;
      }
      
      public Builder setCompilerVersion(PluginProtos.Version param2Version) {
        SingleFieldBuilderV3<PluginProtos.Version, PluginProtos.Version.Builder, PluginProtos.VersionOrBuilder> singleFieldBuilderV3 = this.compilerVersionBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (param2Version != null) {
            this.compilerVersion_ = param2Version;
            onChanged();
          } else {
            throw new NullPointerException();
          } 
        } else {
          singleFieldBuilderV3.setMessage((AbstractMessage)param2Version);
        } 
        this.bitField0_ |= 0x8;
        return this;
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setFileToGenerate(int param2Int, String param2String) {
        if (param2String != null) {
          ensureFileToGenerateIsMutable();
          this.fileToGenerate_.set(param2Int, param2String);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setParameter(String param2String) {
        if (param2String != null) {
          this.bitField0_ |= 0x2;
          this.parameter_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setParameterBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          this.bitField0_ |= 0x2;
          this.parameter_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setProtoFile(int param2Int, DescriptorProtos.FileDescriptorProto.Builder param2Builder) {
        RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          ensureProtoFileIsMutable();
          this.protoFile_.set(param2Int, param2Builder.build());
          onChanged();
          return this;
        } 
        repeatedFieldBuilderV3.setMessage(param2Int, (AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setProtoFile(int param2Int, DescriptorProtos.FileDescriptorProto param2FileDescriptorProto) {
        RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          if (param2FileDescriptorProto != null) {
            ensureProtoFileIsMutable();
            this.protoFile_.set(param2Int, param2FileDescriptorProto);
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        repeatedFieldBuilderV3.setMessage(param2Int, (AbstractMessage)param2FileDescriptorProto);
        return this;
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public final Builder setUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param2UnknownFieldSet);
      }
    }
  }
  
  static final class null extends AbstractParser<CodeGeneratorRequest> {
    public PluginProtos.CodeGeneratorRequest parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new PluginProtos.CodeGeneratorRequest(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<CodeGeneratorRequest.Builder> implements CodeGeneratorRequestOrBuilder {
    private int bitField0_;
    
    private SingleFieldBuilderV3<PluginProtos.Version, PluginProtos.Version.Builder, PluginProtos.VersionOrBuilder> compilerVersionBuilder_;
    
    private PluginProtos.Version compilerVersion_;
    
    private LazyStringList fileToGenerate_ = LazyStringArrayList.EMPTY;
    
    private Object parameter_ = "";
    
    private RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> protoFileBuilder_;
    
    private List<DescriptorProtos.FileDescriptorProto> protoFile_ = Collections.emptyList();
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensureFileToGenerateIsMutable() {
      if ((this.bitField0_ & 0x1) == 0) {
        this.fileToGenerate_ = (LazyStringList)new LazyStringArrayList(this.fileToGenerate_);
        this.bitField0_ |= 0x1;
      } 
    }
    
    private void ensureProtoFileIsMutable() {
      if ((this.bitField0_ & 0x4) == 0) {
        this.protoFile_ = new ArrayList<DescriptorProtos.FileDescriptorProto>(this.protoFile_);
        this.bitField0_ |= 0x4;
      } 
    }
    
    private SingleFieldBuilderV3<PluginProtos.Version, PluginProtos.Version.Builder, PluginProtos.VersionOrBuilder> getCompilerVersionFieldBuilder() {
      if (this.compilerVersionBuilder_ == null) {
        this.compilerVersionBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getCompilerVersion(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.compilerVersion_ = null;
      } 
      return this.compilerVersionBuilder_;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorRequest_descriptor;
    }
    
    private RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> getProtoFileFieldBuilder() {
      if (this.protoFileBuilder_ == null) {
        boolean bool;
        List<DescriptorProtos.FileDescriptorProto> list = this.protoFile_;
        if ((this.bitField0_ & 0x4) != 0) {
          bool = true;
        } else {
          bool = false;
        } 
        this.protoFileBuilder_ = new RepeatedFieldBuilderV3(list, bool, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.protoFile_ = null;
      } 
      return this.protoFileBuilder_;
    }
    
    private void maybeForceBuilderInitialization() {
      if (PluginProtos.CodeGeneratorRequest.alwaysUseFieldBuilders) {
        getProtoFileFieldBuilder();
        getCompilerVersionFieldBuilder();
      } 
    }
    
    public Builder addAllFileToGenerate(Iterable<String> param1Iterable) {
      ensureFileToGenerateIsMutable();
      AbstractMessageLite.Builder.addAll(param1Iterable, (List)this.fileToGenerate_);
      onChanged();
      return this;
    }
    
    public Builder addAllProtoFile(Iterable<? extends DescriptorProtos.FileDescriptorProto> param1Iterable) {
      RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureProtoFileIsMutable();
        AbstractMessageLite.Builder.addAll(param1Iterable, this.protoFile_);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addAllMessages(param1Iterable);
      return this;
    }
    
    public Builder addFileToGenerate(String param1String) {
      if (param1String != null) {
        ensureFileToGenerateIsMutable();
        this.fileToGenerate_.add(param1String);
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder addFileToGenerateBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        ensureFileToGenerateIsMutable();
        this.fileToGenerate_.add(param1ByteString);
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder addProtoFile(int param1Int, DescriptorProtos.FileDescriptorProto.Builder param1Builder) {
      RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureProtoFileIsMutable();
        this.protoFile_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addProtoFile(int param1Int, DescriptorProtos.FileDescriptorProto param1FileDescriptorProto) {
      RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1FileDescriptorProto != null) {
          ensureProtoFileIsMutable();
          this.protoFile_.add(param1Int, param1FileDescriptorProto);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1FileDescriptorProto);
      return this;
    }
    
    public Builder addProtoFile(DescriptorProtos.FileDescriptorProto.Builder param1Builder) {
      RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureProtoFileIsMutable();
        this.protoFile_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addProtoFile(DescriptorProtos.FileDescriptorProto param1FileDescriptorProto) {
      RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1FileDescriptorProto != null) {
          ensureProtoFileIsMutable();
          this.protoFile_.add(param1FileDescriptorProto);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1FileDescriptorProto);
      return this;
    }
    
    public DescriptorProtos.FileDescriptorProto.Builder addProtoFileBuilder() {
      return (DescriptorProtos.FileDescriptorProto.Builder)getProtoFileFieldBuilder().addBuilder((AbstractMessage)DescriptorProtos.FileDescriptorProto.getDefaultInstance());
    }
    
    public DescriptorProtos.FileDescriptorProto.Builder addProtoFileBuilder(int param1Int) {
      return (DescriptorProtos.FileDescriptorProto.Builder)getProtoFileFieldBuilder().addBuilder(param1Int, (AbstractMessage)DescriptorProtos.FileDescriptorProto.getDefaultInstance());
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public PluginProtos.CodeGeneratorRequest build() {
      PluginProtos.CodeGeneratorRequest codeGeneratorRequest = buildPartial();
      if (codeGeneratorRequest.isInitialized())
        return codeGeneratorRequest; 
      throw newUninitializedMessageException(codeGeneratorRequest);
    }
    
    public PluginProtos.CodeGeneratorRequest buildPartial() {
      byte b;
      PluginProtos.CodeGeneratorRequest codeGeneratorRequest = new PluginProtos.CodeGeneratorRequest(this);
      int j = this.bitField0_;
      if ((j & 0x1) != 0) {
        this.fileToGenerate_ = this.fileToGenerate_.getUnmodifiableView();
        this.bitField0_ &= 0xFFFFFFFE;
      } 
      PluginProtos.CodeGeneratorRequest.access$1902(codeGeneratorRequest, this.fileToGenerate_);
      if ((j & 0x2) != 0) {
        b = 1;
      } else {
        b = 0;
      } 
      PluginProtos.CodeGeneratorRequest.access$2002(codeGeneratorRequest, this.parameter_);
      RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if ((this.bitField0_ & 0x4) != 0) {
          this.protoFile_ = Collections.unmodifiableList(this.protoFile_);
          this.bitField0_ &= 0xFFFFFFFB;
        } 
        PluginProtos.CodeGeneratorRequest.access$2102(codeGeneratorRequest, this.protoFile_);
      } else {
        PluginProtos.CodeGeneratorRequest.access$2102(codeGeneratorRequest, repeatedFieldBuilderV3.build());
      } 
      int i = b;
      if ((j & 0x8) != 0) {
        SingleFieldBuilderV3<PluginProtos.Version, PluginProtos.Version.Builder, PluginProtos.VersionOrBuilder> singleFieldBuilderV3 = this.compilerVersionBuilder_;
        if (singleFieldBuilderV3 == null) {
          PluginProtos.CodeGeneratorRequest.access$2202(codeGeneratorRequest, this.compilerVersion_);
        } else {
          PluginProtos.CodeGeneratorRequest.access$2202(codeGeneratorRequest, (PluginProtos.Version)singleFieldBuilderV3.build());
        } 
        i = b | 0x2;
      } 
      PluginProtos.CodeGeneratorRequest.access$2302(codeGeneratorRequest, i);
      onBuilt();
      return codeGeneratorRequest;
    }
    
    public Builder clear() {
      super.clear();
      this.fileToGenerate_ = LazyStringArrayList.EMPTY;
      this.bitField0_ &= 0xFFFFFFFE;
      this.parameter_ = "";
      this.bitField0_ &= 0xFFFFFFFD;
      RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.protoFile_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFB;
      } else {
        repeatedFieldBuilderV3.clear();
      } 
      SingleFieldBuilderV3<PluginProtos.Version, PluginProtos.Version.Builder, PluginProtos.VersionOrBuilder> singleFieldBuilderV3 = this.compilerVersionBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.compilerVersion_ = null;
      } else {
        singleFieldBuilderV3.clear();
      } 
      this.bitField0_ &= 0xFFFFFFF7;
      return this;
    }
    
    public Builder clearCompilerVersion() {
      SingleFieldBuilderV3<PluginProtos.Version, PluginProtos.Version.Builder, PluginProtos.VersionOrBuilder> singleFieldBuilderV3 = this.compilerVersionBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.compilerVersion_ = null;
        onChanged();
      } else {
        singleFieldBuilderV3.clear();
      } 
      this.bitField0_ &= 0xFFFFFFF7;
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearFileToGenerate() {
      this.fileToGenerate_ = LazyStringArrayList.EMPTY;
      this.bitField0_ &= 0xFFFFFFFE;
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearParameter() {
      this.bitField0_ &= 0xFFFFFFFD;
      this.parameter_ = PluginProtos.CodeGeneratorRequest.getDefaultInstance().getParameter();
      onChanged();
      return this;
    }
    
    public Builder clearProtoFile() {
      RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.protoFile_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFB;
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public PluginProtos.Version getCompilerVersion() {
      PluginProtos.Version version;
      SingleFieldBuilderV3<PluginProtos.Version, PluginProtos.Version.Builder, PluginProtos.VersionOrBuilder> singleFieldBuilderV3 = this.compilerVersionBuilder_;
      if (singleFieldBuilderV3 == null) {
        PluginProtos.Version version1 = this.compilerVersion_;
        version = version1;
        if (version1 == null)
          version = PluginProtos.Version.getDefaultInstance(); 
        return version;
      } 
      return (PluginProtos.Version)version.getMessage();
    }
    
    public PluginProtos.Version.Builder getCompilerVersionBuilder() {
      this.bitField0_ |= 0x8;
      onChanged();
      return (PluginProtos.Version.Builder)getCompilerVersionFieldBuilder().getBuilder();
    }
    
    public PluginProtos.VersionOrBuilder getCompilerVersionOrBuilder() {
      SingleFieldBuilderV3<PluginProtos.Version, PluginProtos.Version.Builder, PluginProtos.VersionOrBuilder> singleFieldBuilderV3 = this.compilerVersionBuilder_;
      if (singleFieldBuilderV3 != null)
        return (PluginProtos.VersionOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      PluginProtos.Version version2 = this.compilerVersion_;
      PluginProtos.Version version1 = version2;
      if (version2 == null)
        version1 = PluginProtos.Version.getDefaultInstance(); 
      return version1;
    }
    
    public PluginProtos.CodeGeneratorRequest getDefaultInstanceForType() {
      return PluginProtos.CodeGeneratorRequest.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorRequest_descriptor;
    }
    
    public String getFileToGenerate(int param1Int) {
      return (String)this.fileToGenerate_.get(param1Int);
    }
    
    public ByteString getFileToGenerateBytes(int param1Int) {
      return this.fileToGenerate_.getByteString(param1Int);
    }
    
    public int getFileToGenerateCount() {
      return this.fileToGenerate_.size();
    }
    
    public ProtocolStringList getFileToGenerateList() {
      return (ProtocolStringList)this.fileToGenerate_.getUnmodifiableView();
    }
    
    public String getParameter() {
      Object object = this.parameter_;
      if (!(object instanceof String)) {
        object = object;
        String str = object.toStringUtf8();
        if (object.isValidUtf8())
          this.parameter_ = str; 
        return str;
      } 
      return (String)object;
    }
    
    public ByteString getParameterBytes() {
      Object object = this.parameter_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.parameter_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public DescriptorProtos.FileDescriptorProto getProtoFile(int param1Int) {
      RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.protoFile_.get(param1Int) : (DescriptorProtos.FileDescriptorProto)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public DescriptorProtos.FileDescriptorProto.Builder getProtoFileBuilder(int param1Int) {
      return (DescriptorProtos.FileDescriptorProto.Builder)getProtoFileFieldBuilder().getBuilder(param1Int);
    }
    
    public List<DescriptorProtos.FileDescriptorProto.Builder> getProtoFileBuilderList() {
      return getProtoFileFieldBuilder().getBuilderList();
    }
    
    public int getProtoFileCount() {
      RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.protoFile_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<DescriptorProtos.FileDescriptorProto> getProtoFileList() {
      RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.protoFile_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public DescriptorProtos.FileDescriptorProtoOrBuilder getProtoFileOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
      return (repeatedFieldBuilderV3 == null) ? (DescriptorProtos.FileDescriptorProtoOrBuilder)this.protoFile_.get(param1Int) : (DescriptorProtos.FileDescriptorProtoOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends DescriptorProtos.FileDescriptorProtoOrBuilder> getProtoFileOrBuilderList() {
      RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.protoFile_);
    }
    
    public boolean hasCompilerVersion() {
      return ((this.bitField0_ & 0x8) != 0);
    }
    
    public boolean hasParameter() {
      return ((this.bitField0_ & 0x2) != 0);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(PluginProtos.CodeGeneratorRequest.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      for (int i = 0; i < getProtoFileCount(); i++) {
        if (!getProtoFile(i).isInitialized())
          return false; 
      } 
      return true;
    }
    
    public Builder mergeCompilerVersion(PluginProtos.Version param1Version) {
      // Byte code:
      //   0: aload_0
      //   1: getfield compilerVersionBuilder_ : Lcom/google/protobuf/SingleFieldBuilderV3;
      //   4: astore_2
      //   5: aload_2
      //   6: ifnonnull -> 68
      //   9: aload_0
      //   10: getfield bitField0_ : I
      //   13: bipush #8
      //   15: iand
      //   16: ifeq -> 56
      //   19: aload_0
      //   20: getfield compilerVersion_ : Lcom/google/protobuf/compiler/PluginProtos$Version;
      //   23: astore_2
      //   24: aload_2
      //   25: ifnull -> 56
      //   28: aload_2
      //   29: invokestatic getDefaultInstance : ()Lcom/google/protobuf/compiler/PluginProtos$Version;
      //   32: if_acmpeq -> 56
      //   35: aload_0
      //   36: aload_0
      //   37: getfield compilerVersion_ : Lcom/google/protobuf/compiler/PluginProtos$Version;
      //   40: invokestatic newBuilder : (Lcom/google/protobuf/compiler/PluginProtos$Version;)Lcom/google/protobuf/compiler/PluginProtos$Version$Builder;
      //   43: aload_1
      //   44: invokevirtual mergeFrom : (Lcom/google/protobuf/compiler/PluginProtos$Version;)Lcom/google/protobuf/compiler/PluginProtos$Version$Builder;
      //   47: invokevirtual buildPartial : ()Lcom/google/protobuf/compiler/PluginProtos$Version;
      //   50: putfield compilerVersion_ : Lcom/google/protobuf/compiler/PluginProtos$Version;
      //   53: goto -> 61
      //   56: aload_0
      //   57: aload_1
      //   58: putfield compilerVersion_ : Lcom/google/protobuf/compiler/PluginProtos$Version;
      //   61: aload_0
      //   62: invokevirtual onChanged : ()V
      //   65: goto -> 74
      //   68: aload_2
      //   69: aload_1
      //   70: invokevirtual mergeFrom : (Lcom/google/protobuf/AbstractMessage;)Lcom/google/protobuf/SingleFieldBuilderV3;
      //   73: pop
      //   74: aload_0
      //   75: aload_0
      //   76: getfield bitField0_ : I
      //   79: bipush #8
      //   81: ior
      //   82: putfield bitField0_ : I
      //   85: aload_0
      //   86: areturn
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        PluginProtos.CodeGeneratorRequest codeGeneratorRequest = (PluginProtos.CodeGeneratorRequest)PluginProtos.CodeGeneratorRequest.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        PluginProtos.CodeGeneratorRequest codeGeneratorRequest = (PluginProtos.CodeGeneratorRequest)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((PluginProtos.CodeGeneratorRequest)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof PluginProtos.CodeGeneratorRequest)
        return mergeFrom((PluginProtos.CodeGeneratorRequest)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeFrom(PluginProtos.CodeGeneratorRequest param1CodeGeneratorRequest) {
      if (param1CodeGeneratorRequest == PluginProtos.CodeGeneratorRequest.getDefaultInstance())
        return this; 
      if (!param1CodeGeneratorRequest.fileToGenerate_.isEmpty()) {
        if (this.fileToGenerate_.isEmpty()) {
          this.fileToGenerate_ = param1CodeGeneratorRequest.fileToGenerate_;
          this.bitField0_ &= 0xFFFFFFFE;
        } else {
          ensureFileToGenerateIsMutable();
          this.fileToGenerate_.addAll((Collection)param1CodeGeneratorRequest.fileToGenerate_);
        } 
        onChanged();
      } 
      if (param1CodeGeneratorRequest.hasParameter()) {
        this.bitField0_ |= 0x2;
        this.parameter_ = param1CodeGeneratorRequest.parameter_;
        onChanged();
      } 
      if (this.protoFileBuilder_ == null) {
        if (!param1CodeGeneratorRequest.protoFile_.isEmpty()) {
          if (this.protoFile_.isEmpty()) {
            this.protoFile_ = param1CodeGeneratorRequest.protoFile_;
            this.bitField0_ &= 0xFFFFFFFB;
          } else {
            ensureProtoFileIsMutable();
            this.protoFile_.addAll(param1CodeGeneratorRequest.protoFile_);
          } 
          onChanged();
        } 
      } else if (!param1CodeGeneratorRequest.protoFile_.isEmpty()) {
        if (this.protoFileBuilder_.isEmpty()) {
          this.protoFileBuilder_.dispose();
          RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = null;
          this.protoFileBuilder_ = null;
          this.protoFile_ = param1CodeGeneratorRequest.protoFile_;
          this.bitField0_ &= 0xFFFFFFFB;
          if (PluginProtos.CodeGeneratorRequest.alwaysUseFieldBuilders)
            repeatedFieldBuilderV3 = getProtoFileFieldBuilder(); 
          this.protoFileBuilder_ = repeatedFieldBuilderV3;
        } else {
          this.protoFileBuilder_.addAllMessages(param1CodeGeneratorRequest.protoFile_);
        } 
      } 
      if (param1CodeGeneratorRequest.hasCompilerVersion())
        mergeCompilerVersion(param1CodeGeneratorRequest.getCompilerVersion()); 
      mergeUnknownFields(param1CodeGeneratorRequest.unknownFields);
      onChanged();
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder removeProtoFile(int param1Int) {
      RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureProtoFileIsMutable();
        this.protoFile_.remove(param1Int);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.remove(param1Int);
      return this;
    }
    
    public Builder setCompilerVersion(PluginProtos.Version.Builder param1Builder) {
      SingleFieldBuilderV3<PluginProtos.Version, PluginProtos.Version.Builder, PluginProtos.VersionOrBuilder> singleFieldBuilderV3 = this.compilerVersionBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.compilerVersion_ = param1Builder.build();
        onChanged();
      } else {
        singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      } 
      this.bitField0_ |= 0x8;
      return this;
    }
    
    public Builder setCompilerVersion(PluginProtos.Version param1Version) {
      SingleFieldBuilderV3<PluginProtos.Version, PluginProtos.Version.Builder, PluginProtos.VersionOrBuilder> singleFieldBuilderV3 = this.compilerVersionBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1Version != null) {
          this.compilerVersion_ = param1Version;
          onChanged();
        } else {
          throw new NullPointerException();
        } 
      } else {
        singleFieldBuilderV3.setMessage((AbstractMessage)param1Version);
      } 
      this.bitField0_ |= 0x8;
      return this;
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setFileToGenerate(int param1Int, String param1String) {
      if (param1String != null) {
        ensureFileToGenerateIsMutable();
        this.fileToGenerate_.set(param1Int, param1String);
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setParameter(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x2;
        this.parameter_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setParameterBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x2;
        this.parameter_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setProtoFile(int param1Int, DescriptorProtos.FileDescriptorProto.Builder param1Builder) {
      RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureProtoFileIsMutable();
        this.protoFile_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setProtoFile(int param1Int, DescriptorProtos.FileDescriptorProto param1FileDescriptorProto) {
      RepeatedFieldBuilderV3<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.protoFileBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1FileDescriptorProto != null) {
          ensureProtoFileIsMutable();
          this.protoFile_.set(param1Int, param1FileDescriptorProto);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1FileDescriptorProto);
      return this;
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
  
  public static interface CodeGeneratorRequestOrBuilder extends MessageOrBuilder {
    PluginProtos.Version getCompilerVersion();
    
    PluginProtos.VersionOrBuilder getCompilerVersionOrBuilder();
    
    String getFileToGenerate(int param1Int);
    
    ByteString getFileToGenerateBytes(int param1Int);
    
    int getFileToGenerateCount();
    
    List<String> getFileToGenerateList();
    
    String getParameter();
    
    ByteString getParameterBytes();
    
    DescriptorProtos.FileDescriptorProto getProtoFile(int param1Int);
    
    int getProtoFileCount();
    
    List<DescriptorProtos.FileDescriptorProto> getProtoFileList();
    
    DescriptorProtos.FileDescriptorProtoOrBuilder getProtoFileOrBuilder(int param1Int);
    
    List<? extends DescriptorProtos.FileDescriptorProtoOrBuilder> getProtoFileOrBuilderList();
    
    boolean hasCompilerVersion();
    
    boolean hasParameter();
  }
  
  public static final class CodeGeneratorResponse extends GeneratedMessageV3 implements CodeGeneratorResponseOrBuilder {
    private static final CodeGeneratorResponse DEFAULT_INSTANCE = new CodeGeneratorResponse();
    
    public static final int ERROR_FIELD_NUMBER = 1;
    
    public static final int FILE_FIELD_NUMBER = 15;
    
    @Deprecated
    public static final Parser<CodeGeneratorResponse> PARSER = (Parser<CodeGeneratorResponse>)new AbstractParser<CodeGeneratorResponse>() {
        public PluginProtos.CodeGeneratorResponse parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new PluginProtos.CodeGeneratorResponse(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int SUPPORTED_FEATURES_FIELD_NUMBER = 2;
    
    private static final long serialVersionUID = 0L;
    
    private int bitField0_;
    
    private volatile Object error_;
    
    private List<File> file_;
    
    private byte memoizedIsInitialized = -1;
    
    private long supportedFeatures_;
    
    private CodeGeneratorResponse() {
      this.error_ = "";
      this.file_ = Collections.emptyList();
    }
    
    private CodeGeneratorResponse(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        boolean bool = false;
        int i = 0;
        while (!bool) {
          int j = i;
          int k = i;
          int m = i;
          try {
            int n = param1CodedInputStream.readTag();
            if (n != 0) {
              if (n != 10) {
                if (n != 16) {
                  if (n != 122) {
                    j = i;
                    k = i;
                    m = i;
                    if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, n))
                      continue; 
                    continue;
                  } 
                  n = i;
                  if ((i & 0x4) == 0) {
                    j = i;
                    k = i;
                    m = i;
                    this.file_ = new ArrayList<File>();
                    n = i | 0x4;
                  } 
                  j = n;
                  k = n;
                  m = n;
                  this.file_.add(param1CodedInputStream.readMessage(File.PARSER, param1ExtensionRegistryLite));
                  i = n;
                  continue;
                } 
                j = i;
                k = i;
                m = i;
                this.bitField0_ |= 0x2;
                j = i;
                k = i;
                m = i;
                this.supportedFeatures_ = param1CodedInputStream.readUInt64();
                continue;
              } 
              j = i;
              k = i;
              m = i;
              ByteString byteString = param1CodedInputStream.readBytes();
              j = i;
              k = i;
              m = i;
              this.bitField0_ = 0x1 | this.bitField0_;
              j = i;
              k = i;
              m = i;
              this.error_ = byteString;
              continue;
            } 
            continue;
          } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            j = m;
            throw invalidProtocolBufferException.setUnfinishedMessage(this);
          } catch (IOException iOException) {
            j = k;
            throw (new InvalidProtocolBufferException(iOException)).setUnfinishedMessage(this);
          } finally {}
          if ((j & 0x4) != 0)
            this.file_ = Collections.unmodifiableList(this.file_); 
          this.unknownFields = builder.build();
          makeExtensionsImmutable();
          throw param1CodedInputStream;
          bool = true;
        } 
        if ((i & 0x4) != 0)
          this.file_ = Collections.unmodifiableList(this.file_); 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        return;
      } 
      throw new NullPointerException();
    }
    
    private CodeGeneratorResponse(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static CodeGeneratorResponse getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(CodeGeneratorResponse param1CodeGeneratorResponse) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1CodeGeneratorResponse);
    }
    
    public static CodeGeneratorResponse parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (CodeGeneratorResponse)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static CodeGeneratorResponse parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (CodeGeneratorResponse)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static CodeGeneratorResponse parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (CodeGeneratorResponse)PARSER.parseFrom(param1ByteString);
    }
    
    public static CodeGeneratorResponse parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (CodeGeneratorResponse)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static CodeGeneratorResponse parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (CodeGeneratorResponse)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static CodeGeneratorResponse parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (CodeGeneratorResponse)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static CodeGeneratorResponse parseFrom(InputStream param1InputStream) throws IOException {
      return (CodeGeneratorResponse)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static CodeGeneratorResponse parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (CodeGeneratorResponse)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static CodeGeneratorResponse parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (CodeGeneratorResponse)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static CodeGeneratorResponse parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (CodeGeneratorResponse)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static CodeGeneratorResponse parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (CodeGeneratorResponse)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static CodeGeneratorResponse parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (CodeGeneratorResponse)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<CodeGeneratorResponse> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof CodeGeneratorResponse))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return (hasError() != param1Object.hasError()) ? false : ((hasError() && !getError().equals(param1Object.getError())) ? false : ((hasSupportedFeatures() != param1Object.hasSupportedFeatures()) ? false : ((hasSupportedFeatures() && getSupportedFeatures() != param1Object.getSupportedFeatures()) ? false : (!getFileList().equals(param1Object.getFileList()) ? false : (!!this.unknownFields.equals(((CodeGeneratorResponse)param1Object).unknownFields))))));
    }
    
    public CodeGeneratorResponse getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public String getError() {
      Object object = this.error_;
      if (object instanceof String)
        return (String)object; 
      object = object;
      String str = object.toStringUtf8();
      if (object.isValidUtf8())
        this.error_ = str; 
      return str;
    }
    
    public ByteString getErrorBytes() {
      Object object = this.error_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.error_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public File getFile(int param1Int) {
      return this.file_.get(param1Int);
    }
    
    public int getFileCount() {
      return this.file_.size();
    }
    
    public List<File> getFileList() {
      return this.file_;
    }
    
    public FileOrBuilder getFileOrBuilder(int param1Int) {
      return this.file_.get(param1Int);
    }
    
    public List<? extends FileOrBuilder> getFileOrBuilderList() {
      return (List)this.file_;
    }
    
    public Parser<CodeGeneratorResponse> getParserForType() {
      return PARSER;
    }
    
    public int getSerializedSize() {
      byte b1;
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      i = this.bitField0_;
      byte b2 = 0;
      if ((i & 0x1) != 0) {
        b1 = GeneratedMessageV3.computeStringSize(1, this.error_) + 0;
      } else {
        b1 = 0;
      } 
      i = b1;
      int j = b2;
      if ((this.bitField0_ & 0x2) != 0) {
        i = b1 + CodedOutputStream.computeUInt64Size(2, this.supportedFeatures_);
        j = b2;
      } 
      while (j < this.file_.size()) {
        i += CodedOutputStream.computeMessageSize(15, (MessageLite)this.file_.get(j));
        j++;
      } 
      i += this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public long getSupportedFeatures() {
      return this.supportedFeatures_;
    }
    
    public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }
    
    public boolean hasError() {
      return ((this.bitField0_ & 0x1) != 0);
    }
    
    public boolean hasSupportedFeatures() {
      return ((this.bitField0_ & 0x2) != 0);
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int j = 779 + getDescriptor().hashCode();
      int i = j;
      if (hasError())
        i = (j * 37 + 1) * 53 + getError().hashCode(); 
      j = i;
      if (hasSupportedFeatures())
        j = (i * 37 + 2) * 53 + Internal.hashLong(getSupportedFeatures()); 
      i = j;
      if (getFileCount() > 0)
        i = (j * 37 + 15) * 53 + getFileList().hashCode(); 
      i = i * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(CodeGeneratorResponse.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      byte b = this.memoizedIsInitialized;
      if (b == 1)
        return true; 
      if (b == 0)
        return false; 
      this.memoizedIsInitialized = 1;
      return true;
    }
    
    public Builder newBuilderForType() {
      return newBuilder();
    }
    
    protected Builder newBuilderForType(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      return new Builder(param1BuilderParent);
    }
    
    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter param1UnusedPrivateParameter) {
      return new CodeGeneratorResponse();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if ((this.bitField0_ & 0x1) != 0)
        GeneratedMessageV3.writeString(param1CodedOutputStream, 1, this.error_); 
      if ((this.bitField0_ & 0x2) != 0)
        param1CodedOutputStream.writeUInt64(2, this.supportedFeatures_); 
      for (int i = 0; i < this.file_.size(); i++)
        param1CodedOutputStream.writeMessage(15, (MessageLite)this.file_.get(i)); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PluginProtos.CodeGeneratorResponseOrBuilder {
      private int bitField0_;
      
      private Object error_ = "";
      
      private RepeatedFieldBuilderV3<PluginProtos.CodeGeneratorResponse.File, PluginProtos.CodeGeneratorResponse.File.Builder, PluginProtos.CodeGeneratorResponse.FileOrBuilder> fileBuilder_;
      
      private List<PluginProtos.CodeGeneratorResponse.File> file_ = Collections.emptyList();
      
      private long supportedFeatures_;
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      private void ensureFileIsMutable() {
        if ((this.bitField0_ & 0x4) == 0) {
          this.file_ = new ArrayList<PluginProtos.CodeGeneratorResponse.File>(this.file_);
          this.bitField0_ |= 0x4;
        } 
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_descriptor;
      }
      
      private RepeatedFieldBuilderV3<PluginProtos.CodeGeneratorResponse.File, PluginProtos.CodeGeneratorResponse.File.Builder, PluginProtos.CodeGeneratorResponse.FileOrBuilder> getFileFieldBuilder() {
        if (this.fileBuilder_ == null) {
          boolean bool;
          List<PluginProtos.CodeGeneratorResponse.File> list = this.file_;
          if ((this.bitField0_ & 0x4) != 0) {
            bool = true;
          } else {
            bool = false;
          } 
          this.fileBuilder_ = new RepeatedFieldBuilderV3(list, bool, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.file_ = null;
        } 
        return this.fileBuilder_;
      }
      
      private void maybeForceBuilderInitialization() {
        if (PluginProtos.CodeGeneratorResponse.alwaysUseFieldBuilders)
          getFileFieldBuilder(); 
      }
      
      public Builder addAllFile(Iterable<? extends PluginProtos.CodeGeneratorResponse.File> param2Iterable) {
        RepeatedFieldBuilderV3<PluginProtos.CodeGeneratorResponse.File, PluginProtos.CodeGeneratorResponse.File.Builder, PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          ensureFileIsMutable();
          AbstractMessageLite.Builder.addAll(param2Iterable, this.file_);
          onChanged();
          return this;
        } 
        repeatedFieldBuilderV3.addAllMessages(param2Iterable);
        return this;
      }
      
      public Builder addFile(int param2Int, PluginProtos.CodeGeneratorResponse.File.Builder param2Builder) {
        RepeatedFieldBuilderV3<PluginProtos.CodeGeneratorResponse.File, PluginProtos.CodeGeneratorResponse.File.Builder, PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          ensureFileIsMutable();
          this.file_.add(param2Int, param2Builder.build());
          onChanged();
          return this;
        } 
        repeatedFieldBuilderV3.addMessage(param2Int, (AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder addFile(int param2Int, PluginProtos.CodeGeneratorResponse.File param2File) {
        RepeatedFieldBuilderV3<PluginProtos.CodeGeneratorResponse.File, PluginProtos.CodeGeneratorResponse.File.Builder, PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          if (param2File != null) {
            ensureFileIsMutable();
            this.file_.add(param2Int, param2File);
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        repeatedFieldBuilderV3.addMessage(param2Int, (AbstractMessage)param2File);
        return this;
      }
      
      public Builder addFile(PluginProtos.CodeGeneratorResponse.File.Builder param2Builder) {
        RepeatedFieldBuilderV3<PluginProtos.CodeGeneratorResponse.File, PluginProtos.CodeGeneratorResponse.File.Builder, PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          ensureFileIsMutable();
          this.file_.add(param2Builder.build());
          onChanged();
          return this;
        } 
        repeatedFieldBuilderV3.addMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder addFile(PluginProtos.CodeGeneratorResponse.File param2File) {
        RepeatedFieldBuilderV3<PluginProtos.CodeGeneratorResponse.File, PluginProtos.CodeGeneratorResponse.File.Builder, PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          if (param2File != null) {
            ensureFileIsMutable();
            this.file_.add(param2File);
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        repeatedFieldBuilderV3.addMessage((AbstractMessage)param2File);
        return this;
      }
      
      public PluginProtos.CodeGeneratorResponse.File.Builder addFileBuilder() {
        return (PluginProtos.CodeGeneratorResponse.File.Builder)getFileFieldBuilder().addBuilder((AbstractMessage)PluginProtos.CodeGeneratorResponse.File.getDefaultInstance());
      }
      
      public PluginProtos.CodeGeneratorResponse.File.Builder addFileBuilder(int param2Int) {
        return (PluginProtos.CodeGeneratorResponse.File.Builder)getFileFieldBuilder().addBuilder(param2Int, (AbstractMessage)PluginProtos.CodeGeneratorResponse.File.getDefaultInstance());
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public PluginProtos.CodeGeneratorResponse build() {
        PluginProtos.CodeGeneratorResponse codeGeneratorResponse = buildPartial();
        if (codeGeneratorResponse.isInitialized())
          return codeGeneratorResponse; 
        throw newUninitializedMessageException(codeGeneratorResponse);
      }
      
      public PluginProtos.CodeGeneratorResponse buildPartial() {
        byte b;
        PluginProtos.CodeGeneratorResponse codeGeneratorResponse = new PluginProtos.CodeGeneratorResponse(this);
        int j = this.bitField0_;
        if ((j & 0x1) != 0) {
          b = 1;
        } else {
          b = 0;
        } 
        PluginProtos.CodeGeneratorResponse.access$4502(codeGeneratorResponse, this.error_);
        int i = b;
        if ((j & 0x2) != 0) {
          PluginProtos.CodeGeneratorResponse.access$4602(codeGeneratorResponse, this.supportedFeatures_);
          i = b | 0x2;
        } 
        RepeatedFieldBuilderV3<PluginProtos.CodeGeneratorResponse.File, PluginProtos.CodeGeneratorResponse.File.Builder, PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          if ((this.bitField0_ & 0x4) != 0) {
            this.file_ = Collections.unmodifiableList(this.file_);
            this.bitField0_ &= 0xFFFFFFFB;
          } 
          PluginProtos.CodeGeneratorResponse.access$4702(codeGeneratorResponse, this.file_);
        } else {
          PluginProtos.CodeGeneratorResponse.access$4702(codeGeneratorResponse, repeatedFieldBuilderV3.build());
        } 
        PluginProtos.CodeGeneratorResponse.access$4802(codeGeneratorResponse, i);
        onBuilt();
        return codeGeneratorResponse;
      }
      
      public Builder clear() {
        super.clear();
        this.error_ = "";
        this.bitField0_ &= 0xFFFFFFFE;
        this.supportedFeatures_ = 0L;
        this.bitField0_ &= 0xFFFFFFFD;
        RepeatedFieldBuilderV3<PluginProtos.CodeGeneratorResponse.File, PluginProtos.CodeGeneratorResponse.File.Builder, PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          this.file_ = Collections.emptyList();
          this.bitField0_ &= 0xFFFFFFFB;
          return this;
        } 
        repeatedFieldBuilderV3.clear();
        return this;
      }
      
      public Builder clearError() {
        this.bitField0_ &= 0xFFFFFFFE;
        this.error_ = PluginProtos.CodeGeneratorResponse.getDefaultInstance().getError();
        onChanged();
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearFile() {
        RepeatedFieldBuilderV3<PluginProtos.CodeGeneratorResponse.File, PluginProtos.CodeGeneratorResponse.File.Builder, PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          this.file_ = Collections.emptyList();
          this.bitField0_ &= 0xFFFFFFFB;
          onChanged();
          return this;
        } 
        repeatedFieldBuilderV3.clear();
        return this;
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearSupportedFeatures() {
        this.bitField0_ &= 0xFFFFFFFD;
        this.supportedFeatures_ = 0L;
        onChanged();
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public PluginProtos.CodeGeneratorResponse getDefaultInstanceForType() {
        return PluginProtos.CodeGeneratorResponse.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_descriptor;
      }
      
      public String getError() {
        Object object = this.error_;
        if (!(object instanceof String)) {
          object = object;
          String str = object.toStringUtf8();
          if (object.isValidUtf8())
            this.error_ = str; 
          return str;
        } 
        return (String)object;
      }
      
      public ByteString getErrorBytes() {
        Object object = this.error_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.error_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public PluginProtos.CodeGeneratorResponse.File getFile(int param2Int) {
        RepeatedFieldBuilderV3<PluginProtos.CodeGeneratorResponse.File, PluginProtos.CodeGeneratorResponse.File.Builder, PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
        return (repeatedFieldBuilderV3 == null) ? this.file_.get(param2Int) : (PluginProtos.CodeGeneratorResponse.File)repeatedFieldBuilderV3.getMessage(param2Int);
      }
      
      public PluginProtos.CodeGeneratorResponse.File.Builder getFileBuilder(int param2Int) {
        return (PluginProtos.CodeGeneratorResponse.File.Builder)getFileFieldBuilder().getBuilder(param2Int);
      }
      
      public List<PluginProtos.CodeGeneratorResponse.File.Builder> getFileBuilderList() {
        return getFileFieldBuilder().getBuilderList();
      }
      
      public int getFileCount() {
        RepeatedFieldBuilderV3<PluginProtos.CodeGeneratorResponse.File, PluginProtos.CodeGeneratorResponse.File.Builder, PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
        return (repeatedFieldBuilderV3 == null) ? this.file_.size() : repeatedFieldBuilderV3.getCount();
      }
      
      public List<PluginProtos.CodeGeneratorResponse.File> getFileList() {
        RepeatedFieldBuilderV3<PluginProtos.CodeGeneratorResponse.File, PluginProtos.CodeGeneratorResponse.File.Builder, PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
        return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.file_) : repeatedFieldBuilderV3.getMessageList();
      }
      
      public PluginProtos.CodeGeneratorResponse.FileOrBuilder getFileOrBuilder(int param2Int) {
        RepeatedFieldBuilderV3<PluginProtos.CodeGeneratorResponse.File, PluginProtos.CodeGeneratorResponse.File.Builder, PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
        return (repeatedFieldBuilderV3 == null) ? this.file_.get(param2Int) : (PluginProtos.CodeGeneratorResponse.FileOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param2Int);
      }
      
      public List<? extends PluginProtos.CodeGeneratorResponse.FileOrBuilder> getFileOrBuilderList() {
        RepeatedFieldBuilderV3<PluginProtos.CodeGeneratorResponse.File, PluginProtos.CodeGeneratorResponse.File.Builder, PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
        return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList((List)this.file_);
      }
      
      public long getSupportedFeatures() {
        return this.supportedFeatures_;
      }
      
      public boolean hasError() {
        return ((this.bitField0_ & 0x1) != 0);
      }
      
      public boolean hasSupportedFeatures() {
        return ((this.bitField0_ & 0x2) != 0);
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(PluginProtos.CodeGeneratorResponse.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          PluginProtos.CodeGeneratorResponse codeGeneratorResponse = (PluginProtos.CodeGeneratorResponse)PluginProtos.CodeGeneratorResponse.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          PluginProtos.CodeGeneratorResponse codeGeneratorResponse = (PluginProtos.CodeGeneratorResponse)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((PluginProtos.CodeGeneratorResponse)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof PluginProtos.CodeGeneratorResponse)
          return mergeFrom((PluginProtos.CodeGeneratorResponse)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public Builder mergeFrom(PluginProtos.CodeGeneratorResponse param2CodeGeneratorResponse) {
        if (param2CodeGeneratorResponse == PluginProtos.CodeGeneratorResponse.getDefaultInstance())
          return this; 
        if (param2CodeGeneratorResponse.hasError()) {
          this.bitField0_ |= 0x1;
          this.error_ = param2CodeGeneratorResponse.error_;
          onChanged();
        } 
        if (param2CodeGeneratorResponse.hasSupportedFeatures())
          setSupportedFeatures(param2CodeGeneratorResponse.getSupportedFeatures()); 
        if (this.fileBuilder_ == null) {
          if (!param2CodeGeneratorResponse.file_.isEmpty()) {
            if (this.file_.isEmpty()) {
              this.file_ = param2CodeGeneratorResponse.file_;
              this.bitField0_ &= 0xFFFFFFFB;
            } else {
              ensureFileIsMutable();
              this.file_.addAll(param2CodeGeneratorResponse.file_);
            } 
            onChanged();
          } 
        } else if (!param2CodeGeneratorResponse.file_.isEmpty()) {
          if (this.fileBuilder_.isEmpty()) {
            this.fileBuilder_.dispose();
            RepeatedFieldBuilderV3<PluginProtos.CodeGeneratorResponse.File, PluginProtos.CodeGeneratorResponse.File.Builder, PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = null;
            this.fileBuilder_ = null;
            this.file_ = param2CodeGeneratorResponse.file_;
            this.bitField0_ &= 0xFFFFFFFB;
            if (PluginProtos.CodeGeneratorResponse.alwaysUseFieldBuilders)
              repeatedFieldBuilderV3 = getFileFieldBuilder(); 
            this.fileBuilder_ = repeatedFieldBuilderV3;
          } else {
            this.fileBuilder_.addAllMessages(param2CodeGeneratorResponse.file_);
          } 
        } 
        mergeUnknownFields(param2CodeGeneratorResponse.unknownFields);
        onChanged();
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder removeFile(int param2Int) {
        RepeatedFieldBuilderV3<PluginProtos.CodeGeneratorResponse.File, PluginProtos.CodeGeneratorResponse.File.Builder, PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          ensureFileIsMutable();
          this.file_.remove(param2Int);
          onChanged();
          return this;
        } 
        repeatedFieldBuilderV3.remove(param2Int);
        return this;
      }
      
      public Builder setError(String param2String) {
        if (param2String != null) {
          this.bitField0_ |= 0x1;
          this.error_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setErrorBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          this.bitField0_ |= 0x1;
          this.error_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setFile(int param2Int, PluginProtos.CodeGeneratorResponse.File.Builder param2Builder) {
        RepeatedFieldBuilderV3<PluginProtos.CodeGeneratorResponse.File, PluginProtos.CodeGeneratorResponse.File.Builder, PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          ensureFileIsMutable();
          this.file_.set(param2Int, param2Builder.build());
          onChanged();
          return this;
        } 
        repeatedFieldBuilderV3.setMessage(param2Int, (AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setFile(int param2Int, PluginProtos.CodeGeneratorResponse.File param2File) {
        RepeatedFieldBuilderV3<PluginProtos.CodeGeneratorResponse.File, PluginProtos.CodeGeneratorResponse.File.Builder, PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          if (param2File != null) {
            ensureFileIsMutable();
            this.file_.set(param2Int, param2File);
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        repeatedFieldBuilderV3.setMessage(param2Int, (AbstractMessage)param2File);
        return this;
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public Builder setSupportedFeatures(long param2Long) {
        this.bitField0_ |= 0x2;
        this.supportedFeatures_ = param2Long;
        onChanged();
        return this;
      }
      
      public final Builder setUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param2UnknownFieldSet);
      }
    }
    
    public enum Feature implements ProtocolMessageEnum {
      FEATURE_NONE(0),
      FEATURE_PROTO3_OPTIONAL(1);
      
      public static final int FEATURE_NONE_VALUE = 0;
      
      public static final int FEATURE_PROTO3_OPTIONAL_VALUE = 1;
      
      private static final Feature[] VALUES = values();
      
      private static final Internal.EnumLiteMap<Feature> internalValueMap = new Internal.EnumLiteMap<Feature>() {
          public PluginProtos.CodeGeneratorResponse.Feature findValueByNumber(int param3Int) {
            return PluginProtos.CodeGeneratorResponse.Feature.forNumber(param3Int);
          }
        };
      
      private final int value;
      
      static {
      
      }
      
      Feature(int param2Int1) {
        this.value = param2Int1;
      }
      
      public static Feature forNumber(int param2Int) {
        return (param2Int != 0) ? ((param2Int != 1) ? null : FEATURE_PROTO3_OPTIONAL) : FEATURE_NONE;
      }
      
      public static final Descriptors.EnumDescriptor getDescriptor() {
        return PluginProtos.CodeGeneratorResponse.getDescriptor().getEnumTypes().get(0);
      }
      
      public static Internal.EnumLiteMap<Feature> internalGetValueMap() {
        return internalValueMap;
      }
      
      public final Descriptors.EnumDescriptor getDescriptorForType() {
        return getDescriptor();
      }
      
      public final int getNumber() {
        return this.value;
      }
      
      public final Descriptors.EnumValueDescriptor getValueDescriptor() {
        return getDescriptor().getValues().get(ordinal());
      }
    }
    
    static final class null implements Internal.EnumLiteMap<Feature> {
      public PluginProtos.CodeGeneratorResponse.Feature findValueByNumber(int param2Int) {
        return PluginProtos.CodeGeneratorResponse.Feature.forNumber(param2Int);
      }
    }
    
    public static final class File extends GeneratedMessageV3 implements FileOrBuilder {
      public static final int CONTENT_FIELD_NUMBER = 15;
      
      private static final File DEFAULT_INSTANCE = new File();
      
      public static final int INSERTION_POINT_FIELD_NUMBER = 2;
      
      public static final int NAME_FIELD_NUMBER = 1;
      
      @Deprecated
      public static final Parser<File> PARSER = (Parser<File>)new AbstractParser<File>() {
          public PluginProtos.CodeGeneratorResponse.File parsePartialFrom(CodedInputStream param3CodedInputStream, ExtensionRegistryLite param3ExtensionRegistryLite) throws InvalidProtocolBufferException {
            return new PluginProtos.CodeGeneratorResponse.File(param3CodedInputStream, param3ExtensionRegistryLite);
          }
        };
      
      private static final long serialVersionUID = 0L;
      
      private int bitField0_;
      
      private volatile Object content_;
      
      private volatile Object insertionPoint_;
      
      private byte memoizedIsInitialized = -1;
      
      private volatile Object name_;
      
      private File() {
        this.name_ = "";
        this.insertionPoint_ = "";
        this.content_ = "";
      }
      
      private File(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        if (param2ExtensionRegistryLite != null) {
          UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
          for (boolean bool = false; !bool; bool = true) {
            try {
              int i = param2CodedInputStream.readTag();
              if (i != 0) {
                if (i != 10) {
                  if (i != 18) {
                    if (i != 122) {
                      if (!parseUnknownField(param2CodedInputStream, builder, param2ExtensionRegistryLite, i))
                        continue; 
                      continue;
                    } 
                    ByteString byteString2 = param2CodedInputStream.readBytes();
                    this.bitField0_ |= 0x4;
                    this.content_ = byteString2;
                    continue;
                  } 
                  ByteString byteString1 = param2CodedInputStream.readBytes();
                  this.bitField0_ |= 0x2;
                  this.insertionPoint_ = byteString1;
                  continue;
                } 
                ByteString byteString = param2CodedInputStream.readBytes();
                this.bitField0_ = 0x1 | this.bitField0_;
                this.name_ = byteString;
                continue;
              } 
              continue;
            } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
              throw invalidProtocolBufferException.setUnfinishedMessage(this);
            } catch (IOException iOException) {
              throw (new InvalidProtocolBufferException(iOException)).setUnfinishedMessage(this);
            } finally {}
            this.unknownFields = builder.build();
            makeExtensionsImmutable();
            throw param2CodedInputStream;
          } 
          this.unknownFields = builder.build();
          makeExtensionsImmutable();
          return;
        } 
        throw new NullPointerException();
      }
      
      private File(GeneratedMessageV3.Builder<?> param2Builder) {
        super(param2Builder);
      }
      
      public static File getDefaultInstance() {
        return DEFAULT_INSTANCE;
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor;
      }
      
      public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
      }
      
      public static Builder newBuilder(File param2File) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(param2File);
      }
      
      public static File parseDelimitedFrom(InputStream param2InputStream) throws IOException {
        return (File)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param2InputStream);
      }
      
      public static File parseDelimitedFrom(InputStream param2InputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        return (File)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param2InputStream, param2ExtensionRegistryLite);
      }
      
      public static File parseFrom(ByteString param2ByteString) throws InvalidProtocolBufferException {
        return (File)PARSER.parseFrom(param2ByteString);
      }
      
      public static File parseFrom(ByteString param2ByteString, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return (File)PARSER.parseFrom(param2ByteString, param2ExtensionRegistryLite);
      }
      
      public static File parseFrom(CodedInputStream param2CodedInputStream) throws IOException {
        return (File)GeneratedMessageV3.parseWithIOException(PARSER, param2CodedInputStream);
      }
      
      public static File parseFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        return (File)GeneratedMessageV3.parseWithIOException(PARSER, param2CodedInputStream, param2ExtensionRegistryLite);
      }
      
      public static File parseFrom(InputStream param2InputStream) throws IOException {
        return (File)GeneratedMessageV3.parseWithIOException(PARSER, param2InputStream);
      }
      
      public static File parseFrom(InputStream param2InputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        return (File)GeneratedMessageV3.parseWithIOException(PARSER, param2InputStream, param2ExtensionRegistryLite);
      }
      
      public static File parseFrom(ByteBuffer param2ByteBuffer) throws InvalidProtocolBufferException {
        return (File)PARSER.parseFrom(param2ByteBuffer);
      }
      
      public static File parseFrom(ByteBuffer param2ByteBuffer, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return (File)PARSER.parseFrom(param2ByteBuffer, param2ExtensionRegistryLite);
      }
      
      public static File parseFrom(byte[] param2ArrayOfbyte) throws InvalidProtocolBufferException {
        return (File)PARSER.parseFrom(param2ArrayOfbyte);
      }
      
      public static File parseFrom(byte[] param2ArrayOfbyte, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return (File)PARSER.parseFrom(param2ArrayOfbyte, param2ExtensionRegistryLite);
      }
      
      public static Parser<File> parser() {
        return PARSER;
      }
      
      public boolean equals(Object param2Object) {
        if (param2Object == this)
          return true; 
        if (!(param2Object instanceof File))
          return super.equals(param2Object); 
        param2Object = param2Object;
        return (hasName() != param2Object.hasName()) ? false : ((hasName() && !getName().equals(param2Object.getName())) ? false : ((hasInsertionPoint() != param2Object.hasInsertionPoint()) ? false : ((hasInsertionPoint() && !getInsertionPoint().equals(param2Object.getInsertionPoint())) ? false : ((hasContent() != param2Object.hasContent()) ? false : ((hasContent() && !getContent().equals(param2Object.getContent())) ? false : (!!this.unknownFields.equals(((File)param2Object).unknownFields)))))));
      }
      
      public String getContent() {
        Object object = this.content_;
        if (object instanceof String)
          return (String)object; 
        object = object;
        String str = object.toStringUtf8();
        if (object.isValidUtf8())
          this.content_ = str; 
        return str;
      }
      
      public ByteString getContentBytes() {
        Object object = this.content_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.content_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public File getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
      }
      
      public String getInsertionPoint() {
        Object object = this.insertionPoint_;
        if (object instanceof String)
          return (String)object; 
        object = object;
        String str = object.toStringUtf8();
        if (object.isValidUtf8())
          this.insertionPoint_ = str; 
        return str;
      }
      
      public ByteString getInsertionPointBytes() {
        Object object = this.insertionPoint_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.insertionPoint_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public String getName() {
        Object object = this.name_;
        if (object instanceof String)
          return (String)object; 
        object = object;
        String str = object.toStringUtf8();
        if (object.isValidUtf8())
          this.name_ = str; 
        return str;
      }
      
      public ByteString getNameBytes() {
        Object object = this.name_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.name_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public Parser<File> getParserForType() {
        return PARSER;
      }
      
      public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1)
          return i; 
        int j = 0;
        if ((this.bitField0_ & 0x1) != 0)
          j = 0 + GeneratedMessageV3.computeStringSize(1, this.name_); 
        i = j;
        if ((this.bitField0_ & 0x2) != 0)
          i = j + GeneratedMessageV3.computeStringSize(2, this.insertionPoint_); 
        j = i;
        if ((this.bitField0_ & 0x4) != 0)
          j = i + GeneratedMessageV3.computeStringSize(15, this.content_); 
        i = j + this.unknownFields.getSerializedSize();
        this.memoizedSize = i;
        return i;
      }
      
      public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
      }
      
      public boolean hasContent() {
        return ((this.bitField0_ & 0x4) != 0);
      }
      
      public boolean hasInsertionPoint() {
        return ((this.bitField0_ & 0x2) != 0);
      }
      
      public boolean hasName() {
        return ((this.bitField0_ & 0x1) != 0);
      }
      
      public int hashCode() {
        if (this.memoizedHashCode != 0)
          return this.memoizedHashCode; 
        int j = 779 + getDescriptor().hashCode();
        int i = j;
        if (hasName())
          i = (j * 37 + 1) * 53 + getName().hashCode(); 
        j = i;
        if (hasInsertionPoint())
          j = (i * 37 + 2) * 53 + getInsertionPoint().hashCode(); 
        i = j;
        if (hasContent())
          i = (j * 37 + 15) * 53 + getContent().hashCode(); 
        i = i * 29 + this.unknownFields.hashCode();
        this.memoizedHashCode = i;
        return i;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_fieldAccessorTable.ensureFieldAccessorsInitialized(File.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        byte b = this.memoizedIsInitialized;
        if (b == 1)
          return true; 
        if (b == 0)
          return false; 
        this.memoizedIsInitialized = 1;
        return true;
      }
      
      public Builder newBuilderForType() {
        return newBuilder();
      }
      
      protected Builder newBuilderForType(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        return new Builder(param2BuilderParent);
      }
      
      public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter param2UnusedPrivateParameter) {
        return new File();
      }
      
      public Builder toBuilder() {
        return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
      }
      
      public void writeTo(CodedOutputStream param2CodedOutputStream) throws IOException {
        if ((this.bitField0_ & 0x1) != 0)
          GeneratedMessageV3.writeString(param2CodedOutputStream, 1, this.name_); 
        if ((this.bitField0_ & 0x2) != 0)
          GeneratedMessageV3.writeString(param2CodedOutputStream, 2, this.insertionPoint_); 
        if ((this.bitField0_ & 0x4) != 0)
          GeneratedMessageV3.writeString(param2CodedOutputStream, 15, this.content_); 
        this.unknownFields.writeTo(param2CodedOutputStream);
      }
      
      public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PluginProtos.CodeGeneratorResponse.FileOrBuilder {
        private int bitField0_;
        
        private Object content_ = "";
        
        private Object insertionPoint_ = "";
        
        private Object name_ = "";
        
        private Builder() {
          maybeForceBuilderInitialization();
        }
        
        private Builder(GeneratedMessageV3.BuilderParent param3BuilderParent) {
          super(param3BuilderParent);
          maybeForceBuilderInitialization();
        }
        
        public static final Descriptors.Descriptor getDescriptor() {
          return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor;
        }
        
        private void maybeForceBuilderInitialization() {
          PluginProtos.CodeGeneratorResponse.File.alwaysUseFieldBuilders;
        }
        
        public Builder addRepeatedField(Descriptors.FieldDescriptor param3FieldDescriptor, Object param3Object) {
          return (Builder)super.addRepeatedField(param3FieldDescriptor, param3Object);
        }
        
        public PluginProtos.CodeGeneratorResponse.File build() {
          PluginProtos.CodeGeneratorResponse.File file = buildPartial();
          if (file.isInitialized())
            return file; 
          throw newUninitializedMessageException(file);
        }
        
        public PluginProtos.CodeGeneratorResponse.File buildPartial() {
          PluginProtos.CodeGeneratorResponse.File file = new PluginProtos.CodeGeneratorResponse.File(this);
          int k = this.bitField0_;
          if ((k & 0x1) != 0) {
            j = 1;
          } else {
            j = 0;
          } 
          PluginProtos.CodeGeneratorResponse.File.access$3502(file, this.name_);
          int i = j;
          if ((k & 0x2) != 0)
            i = j | 0x2; 
          PluginProtos.CodeGeneratorResponse.File.access$3602(file, this.insertionPoint_);
          int j = i;
          if ((k & 0x4) != 0)
            j = i | 0x4; 
          PluginProtos.CodeGeneratorResponse.File.access$3702(file, this.content_);
          PluginProtos.CodeGeneratorResponse.File.access$3802(file, j);
          onBuilt();
          return file;
        }
        
        public Builder clear() {
          super.clear();
          this.name_ = "";
          this.bitField0_ &= 0xFFFFFFFE;
          this.insertionPoint_ = "";
          this.bitField0_ &= 0xFFFFFFFD;
          this.content_ = "";
          this.bitField0_ &= 0xFFFFFFFB;
          return this;
        }
        
        public Builder clearContent() {
          this.bitField0_ &= 0xFFFFFFFB;
          this.content_ = PluginProtos.CodeGeneratorResponse.File.getDefaultInstance().getContent();
          onChanged();
          return this;
        }
        
        public Builder clearField(Descriptors.FieldDescriptor param3FieldDescriptor) {
          return (Builder)super.clearField(param3FieldDescriptor);
        }
        
        public Builder clearInsertionPoint() {
          this.bitField0_ &= 0xFFFFFFFD;
          this.insertionPoint_ = PluginProtos.CodeGeneratorResponse.File.getDefaultInstance().getInsertionPoint();
          onChanged();
          return this;
        }
        
        public Builder clearName() {
          this.bitField0_ &= 0xFFFFFFFE;
          this.name_ = PluginProtos.CodeGeneratorResponse.File.getDefaultInstance().getName();
          onChanged();
          return this;
        }
        
        public Builder clearOneof(Descriptors.OneofDescriptor param3OneofDescriptor) {
          return (Builder)super.clearOneof(param3OneofDescriptor);
        }
        
        public Builder clone() {
          return (Builder)super.clone();
        }
        
        public String getContent() {
          Object object = this.content_;
          if (!(object instanceof String)) {
            object = object;
            String str = object.toStringUtf8();
            if (object.isValidUtf8())
              this.content_ = str; 
            return str;
          } 
          return (String)object;
        }
        
        public ByteString getContentBytes() {
          Object object = this.content_;
          if (object instanceof String) {
            object = ByteString.copyFromUtf8((String)object);
            this.content_ = object;
            return (ByteString)object;
          } 
          return (ByteString)object;
        }
        
        public PluginProtos.CodeGeneratorResponse.File getDefaultInstanceForType() {
          return PluginProtos.CodeGeneratorResponse.File.getDefaultInstance();
        }
        
        public Descriptors.Descriptor getDescriptorForType() {
          return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor;
        }
        
        public String getInsertionPoint() {
          Object object = this.insertionPoint_;
          if (!(object instanceof String)) {
            object = object;
            String str = object.toStringUtf8();
            if (object.isValidUtf8())
              this.insertionPoint_ = str; 
            return str;
          } 
          return (String)object;
        }
        
        public ByteString getInsertionPointBytes() {
          Object object = this.insertionPoint_;
          if (object instanceof String) {
            object = ByteString.copyFromUtf8((String)object);
            this.insertionPoint_ = object;
            return (ByteString)object;
          } 
          return (ByteString)object;
        }
        
        public String getName() {
          Object object = this.name_;
          if (!(object instanceof String)) {
            object = object;
            String str = object.toStringUtf8();
            if (object.isValidUtf8())
              this.name_ = str; 
            return str;
          } 
          return (String)object;
        }
        
        public ByteString getNameBytes() {
          Object object = this.name_;
          if (object instanceof String) {
            object = ByteString.copyFromUtf8((String)object);
            this.name_ = object;
            return (ByteString)object;
          } 
          return (ByteString)object;
        }
        
        public boolean hasContent() {
          return ((this.bitField0_ & 0x4) != 0);
        }
        
        public boolean hasInsertionPoint() {
          return ((this.bitField0_ & 0x2) != 0);
        }
        
        public boolean hasName() {
          return ((this.bitField0_ & 0x1) != 0);
        }
        
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
          return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_fieldAccessorTable.ensureFieldAccessorsInitialized(PluginProtos.CodeGeneratorResponse.File.class, Builder.class);
        }
        
        public final boolean isInitialized() {
          return true;
        }
        
        public Builder mergeFrom(CodedInputStream param3CodedInputStream, ExtensionRegistryLite param3ExtensionRegistryLite) throws IOException {
          CodedInputStream codedInputStream = null;
          try {
            PluginProtos.CodeGeneratorResponse.File file = (PluginProtos.CodeGeneratorResponse.File)PluginProtos.CodeGeneratorResponse.File.PARSER.parsePartialFrom(param3CodedInputStream, param3ExtensionRegistryLite);
            return this;
          } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            PluginProtos.CodeGeneratorResponse.File file = (PluginProtos.CodeGeneratorResponse.File)invalidProtocolBufferException.getUnfinishedMessage();
          } finally {
            param3ExtensionRegistryLite = null;
          } 
          if (param3CodedInputStream != null)
            mergeFrom((PluginProtos.CodeGeneratorResponse.File)param3CodedInputStream); 
          throw param3ExtensionRegistryLite;
        }
        
        public Builder mergeFrom(Message param3Message) {
          if (param3Message instanceof PluginProtos.CodeGeneratorResponse.File)
            return mergeFrom((PluginProtos.CodeGeneratorResponse.File)param3Message); 
          super.mergeFrom(param3Message);
          return this;
        }
        
        public Builder mergeFrom(PluginProtos.CodeGeneratorResponse.File param3File) {
          if (param3File == PluginProtos.CodeGeneratorResponse.File.getDefaultInstance())
            return this; 
          if (param3File.hasName()) {
            this.bitField0_ |= 0x1;
            this.name_ = param3File.name_;
            onChanged();
          } 
          if (param3File.hasInsertionPoint()) {
            this.bitField0_ |= 0x2;
            this.insertionPoint_ = param3File.insertionPoint_;
            onChanged();
          } 
          if (param3File.hasContent()) {
            this.bitField0_ |= 0x4;
            this.content_ = param3File.content_;
            onChanged();
          } 
          mergeUnknownFields(param3File.unknownFields);
          onChanged();
          return this;
        }
        
        public final Builder mergeUnknownFields(UnknownFieldSet param3UnknownFieldSet) {
          return (Builder)super.mergeUnknownFields(param3UnknownFieldSet);
        }
        
        public Builder setContent(String param3String) {
          if (param3String != null) {
            this.bitField0_ |= 0x4;
            this.content_ = param3String;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        }
        
        public Builder setContentBytes(ByteString param3ByteString) {
          if (param3ByteString != null) {
            this.bitField0_ |= 0x4;
            this.content_ = param3ByteString;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        }
        
        public Builder setField(Descriptors.FieldDescriptor param3FieldDescriptor, Object param3Object) {
          return (Builder)super.setField(param3FieldDescriptor, param3Object);
        }
        
        public Builder setInsertionPoint(String param3String) {
          if (param3String != null) {
            this.bitField0_ |= 0x2;
            this.insertionPoint_ = param3String;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        }
        
        public Builder setInsertionPointBytes(ByteString param3ByteString) {
          if (param3ByteString != null) {
            this.bitField0_ |= 0x2;
            this.insertionPoint_ = param3ByteString;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        }
        
        public Builder setName(String param3String) {
          if (param3String != null) {
            this.bitField0_ |= 0x1;
            this.name_ = param3String;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        }
        
        public Builder setNameBytes(ByteString param3ByteString) {
          if (param3ByteString != null) {
            this.bitField0_ |= 0x1;
            this.name_ = param3ByteString;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        }
        
        public Builder setRepeatedField(Descriptors.FieldDescriptor param3FieldDescriptor, int param3Int, Object param3Object) {
          return (Builder)super.setRepeatedField(param3FieldDescriptor, param3Int, param3Object);
        }
        
        public final Builder setUnknownFields(UnknownFieldSet param3UnknownFieldSet) {
          return (Builder)super.setUnknownFields(param3UnknownFieldSet);
        }
      }
    }
    
    static final class null extends AbstractParser<File> {
      public PluginProtos.CodeGeneratorResponse.File parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new PluginProtos.CodeGeneratorResponse.File(param2CodedInputStream, param2ExtensionRegistryLite);
      }
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<File.Builder> implements FileOrBuilder {
      private int bitField0_;
      
      private Object content_ = "";
      
      private Object insertionPoint_ = "";
      
      private Object name_ = "";
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        PluginProtos.CodeGeneratorResponse.File.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public PluginProtos.CodeGeneratorResponse.File build() {
        PluginProtos.CodeGeneratorResponse.File file = buildPartial();
        if (file.isInitialized())
          return file; 
        throw newUninitializedMessageException(file);
      }
      
      public PluginProtos.CodeGeneratorResponse.File buildPartial() {
        PluginProtos.CodeGeneratorResponse.File file = new PluginProtos.CodeGeneratorResponse.File(this);
        int k = this.bitField0_;
        if ((k & 0x1) != 0) {
          j = 1;
        } else {
          j = 0;
        } 
        PluginProtos.CodeGeneratorResponse.File.access$3502(file, this.name_);
        int i = j;
        if ((k & 0x2) != 0)
          i = j | 0x2; 
        PluginProtos.CodeGeneratorResponse.File.access$3602(file, this.insertionPoint_);
        int j = i;
        if ((k & 0x4) != 0)
          j = i | 0x4; 
        PluginProtos.CodeGeneratorResponse.File.access$3702(file, this.content_);
        PluginProtos.CodeGeneratorResponse.File.access$3802(file, j);
        onBuilt();
        return file;
      }
      
      public Builder clear() {
        super.clear();
        this.name_ = "";
        this.bitField0_ &= 0xFFFFFFFE;
        this.insertionPoint_ = "";
        this.bitField0_ &= 0xFFFFFFFD;
        this.content_ = "";
        this.bitField0_ &= 0xFFFFFFFB;
        return this;
      }
      
      public Builder clearContent() {
        this.bitField0_ &= 0xFFFFFFFB;
        this.content_ = PluginProtos.CodeGeneratorResponse.File.getDefaultInstance().getContent();
        onChanged();
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearInsertionPoint() {
        this.bitField0_ &= 0xFFFFFFFD;
        this.insertionPoint_ = PluginProtos.CodeGeneratorResponse.File.getDefaultInstance().getInsertionPoint();
        onChanged();
        return this;
      }
      
      public Builder clearName() {
        this.bitField0_ &= 0xFFFFFFFE;
        this.name_ = PluginProtos.CodeGeneratorResponse.File.getDefaultInstance().getName();
        onChanged();
        return this;
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public String getContent() {
        Object object = this.content_;
        if (!(object instanceof String)) {
          object = object;
          String str = object.toStringUtf8();
          if (object.isValidUtf8())
            this.content_ = str; 
          return str;
        } 
        return (String)object;
      }
      
      public ByteString getContentBytes() {
        Object object = this.content_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.content_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public PluginProtos.CodeGeneratorResponse.File getDefaultInstanceForType() {
        return PluginProtos.CodeGeneratorResponse.File.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor;
      }
      
      public String getInsertionPoint() {
        Object object = this.insertionPoint_;
        if (!(object instanceof String)) {
          object = object;
          String str = object.toStringUtf8();
          if (object.isValidUtf8())
            this.insertionPoint_ = str; 
          return str;
        } 
        return (String)object;
      }
      
      public ByteString getInsertionPointBytes() {
        Object object = this.insertionPoint_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.insertionPoint_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public String getName() {
        Object object = this.name_;
        if (!(object instanceof String)) {
          object = object;
          String str = object.toStringUtf8();
          if (object.isValidUtf8())
            this.name_ = str; 
          return str;
        } 
        return (String)object;
      }
      
      public ByteString getNameBytes() {
        Object object = this.name_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.name_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public boolean hasContent() {
        return ((this.bitField0_ & 0x4) != 0);
      }
      
      public boolean hasInsertionPoint() {
        return ((this.bitField0_ & 0x2) != 0);
      }
      
      public boolean hasName() {
        return ((this.bitField0_ & 0x1) != 0);
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_fieldAccessorTable.ensureFieldAccessorsInitialized(PluginProtos.CodeGeneratorResponse.File.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          PluginProtos.CodeGeneratorResponse.File file = (PluginProtos.CodeGeneratorResponse.File)PluginProtos.CodeGeneratorResponse.File.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          PluginProtos.CodeGeneratorResponse.File file = (PluginProtos.CodeGeneratorResponse.File)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((PluginProtos.CodeGeneratorResponse.File)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof PluginProtos.CodeGeneratorResponse.File)
          return mergeFrom((PluginProtos.CodeGeneratorResponse.File)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public Builder mergeFrom(PluginProtos.CodeGeneratorResponse.File param2File) {
        if (param2File == PluginProtos.CodeGeneratorResponse.File.getDefaultInstance())
          return this; 
        if (param2File.hasName()) {
          this.bitField0_ |= 0x1;
          this.name_ = param2File.name_;
          onChanged();
        } 
        if (param2File.hasInsertionPoint()) {
          this.bitField0_ |= 0x2;
          this.insertionPoint_ = param2File.insertionPoint_;
          onChanged();
        } 
        if (param2File.hasContent()) {
          this.bitField0_ |= 0x4;
          this.content_ = param2File.content_;
          onChanged();
        } 
        mergeUnknownFields(param2File.unknownFields);
        onChanged();
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setContent(String param2String) {
        if (param2String != null) {
          this.bitField0_ |= 0x4;
          this.content_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setContentBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          this.bitField0_ |= 0x4;
          this.content_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setInsertionPoint(String param2String) {
        if (param2String != null) {
          this.bitField0_ |= 0x2;
          this.insertionPoint_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setInsertionPointBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          this.bitField0_ |= 0x2;
          this.insertionPoint_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setName(String param2String) {
        if (param2String != null) {
          this.bitField0_ |= 0x1;
          this.name_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setNameBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          this.bitField0_ |= 0x1;
          this.name_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public final Builder setUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param2UnknownFieldSet);
      }
    }
    
    public static interface FileOrBuilder extends MessageOrBuilder {
      String getContent();
      
      ByteString getContentBytes();
      
      String getInsertionPoint();
      
      ByteString getInsertionPointBytes();
      
      String getName();
      
      ByteString getNameBytes();
      
      boolean hasContent();
      
      boolean hasInsertionPoint();
      
      boolean hasName();
    }
  }
  
  static final class null extends AbstractParser<CodeGeneratorResponse> {
    public PluginProtos.CodeGeneratorResponse parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new PluginProtos.CodeGeneratorResponse(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<CodeGeneratorResponse.Builder> implements CodeGeneratorResponseOrBuilder {
    private int bitField0_;
    
    private Object error_ = "";
    
    private RepeatedFieldBuilderV3<PluginProtos.CodeGeneratorResponse.File, PluginProtos.CodeGeneratorResponse.File.Builder, PluginProtos.CodeGeneratorResponse.FileOrBuilder> fileBuilder_;
    
    private List<PluginProtos.CodeGeneratorResponse.File> file_ = Collections.emptyList();
    
    private long supportedFeatures_;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensureFileIsMutable() {
      if ((this.bitField0_ & 0x4) == 0) {
        this.file_ = new ArrayList<PluginProtos.CodeGeneratorResponse.File>(this.file_);
        this.bitField0_ |= 0x4;
      } 
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_descriptor;
    }
    
    private RepeatedFieldBuilderV3<PluginProtos.CodeGeneratorResponse.File, PluginProtos.CodeGeneratorResponse.File.Builder, PluginProtos.CodeGeneratorResponse.FileOrBuilder> getFileFieldBuilder() {
      if (this.fileBuilder_ == null) {
        boolean bool;
        List<PluginProtos.CodeGeneratorResponse.File> list = this.file_;
        if ((this.bitField0_ & 0x4) != 0) {
          bool = true;
        } else {
          bool = false;
        } 
        this.fileBuilder_ = new RepeatedFieldBuilderV3(list, bool, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.file_ = null;
      } 
      return this.fileBuilder_;
    }
    
    private void maybeForceBuilderInitialization() {
      if (PluginProtos.CodeGeneratorResponse.alwaysUseFieldBuilders)
        getFileFieldBuilder(); 
    }
    
    public Builder addAllFile(Iterable<? extends PluginProtos.CodeGeneratorResponse.File> param1Iterable) {
      RepeatedFieldBuilderV3<PluginProtos.CodeGeneratorResponse.File, PluginProtos.CodeGeneratorResponse.File.Builder, PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureFileIsMutable();
        AbstractMessageLite.Builder.addAll(param1Iterable, this.file_);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addAllMessages(param1Iterable);
      return this;
    }
    
    public Builder addFile(int param1Int, PluginProtos.CodeGeneratorResponse.File.Builder param1Builder) {
      RepeatedFieldBuilderV3<PluginProtos.CodeGeneratorResponse.File, PluginProtos.CodeGeneratorResponse.File.Builder, PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureFileIsMutable();
        this.file_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addFile(int param1Int, PluginProtos.CodeGeneratorResponse.File param1File) {
      RepeatedFieldBuilderV3<PluginProtos.CodeGeneratorResponse.File, PluginProtos.CodeGeneratorResponse.File.Builder, PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1File != null) {
          ensureFileIsMutable();
          this.file_.add(param1Int, param1File);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1File);
      return this;
    }
    
    public Builder addFile(PluginProtos.CodeGeneratorResponse.File.Builder param1Builder) {
      RepeatedFieldBuilderV3<PluginProtos.CodeGeneratorResponse.File, PluginProtos.CodeGeneratorResponse.File.Builder, PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureFileIsMutable();
        this.file_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addFile(PluginProtos.CodeGeneratorResponse.File param1File) {
      RepeatedFieldBuilderV3<PluginProtos.CodeGeneratorResponse.File, PluginProtos.CodeGeneratorResponse.File.Builder, PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1File != null) {
          ensureFileIsMutable();
          this.file_.add(param1File);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1File);
      return this;
    }
    
    public PluginProtos.CodeGeneratorResponse.File.Builder addFileBuilder() {
      return (PluginProtos.CodeGeneratorResponse.File.Builder)getFileFieldBuilder().addBuilder((AbstractMessage)PluginProtos.CodeGeneratorResponse.File.getDefaultInstance());
    }
    
    public PluginProtos.CodeGeneratorResponse.File.Builder addFileBuilder(int param1Int) {
      return (PluginProtos.CodeGeneratorResponse.File.Builder)getFileFieldBuilder().addBuilder(param1Int, (AbstractMessage)PluginProtos.CodeGeneratorResponse.File.getDefaultInstance());
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public PluginProtos.CodeGeneratorResponse build() {
      PluginProtos.CodeGeneratorResponse codeGeneratorResponse = buildPartial();
      if (codeGeneratorResponse.isInitialized())
        return codeGeneratorResponse; 
      throw newUninitializedMessageException(codeGeneratorResponse);
    }
    
    public PluginProtos.CodeGeneratorResponse buildPartial() {
      byte b;
      PluginProtos.CodeGeneratorResponse codeGeneratorResponse = new PluginProtos.CodeGeneratorResponse(this);
      int j = this.bitField0_;
      if ((j & 0x1) != 0) {
        b = 1;
      } else {
        b = 0;
      } 
      PluginProtos.CodeGeneratorResponse.access$4502(codeGeneratorResponse, this.error_);
      int i = b;
      if ((j & 0x2) != 0) {
        PluginProtos.CodeGeneratorResponse.access$4602(codeGeneratorResponse, this.supportedFeatures_);
        i = b | 0x2;
      } 
      RepeatedFieldBuilderV3<PluginProtos.CodeGeneratorResponse.File, PluginProtos.CodeGeneratorResponse.File.Builder, PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if ((this.bitField0_ & 0x4) != 0) {
          this.file_ = Collections.unmodifiableList(this.file_);
          this.bitField0_ &= 0xFFFFFFFB;
        } 
        PluginProtos.CodeGeneratorResponse.access$4702(codeGeneratorResponse, this.file_);
      } else {
        PluginProtos.CodeGeneratorResponse.access$4702(codeGeneratorResponse, repeatedFieldBuilderV3.build());
      } 
      PluginProtos.CodeGeneratorResponse.access$4802(codeGeneratorResponse, i);
      onBuilt();
      return codeGeneratorResponse;
    }
    
    public Builder clear() {
      super.clear();
      this.error_ = "";
      this.bitField0_ &= 0xFFFFFFFE;
      this.supportedFeatures_ = 0L;
      this.bitField0_ &= 0xFFFFFFFD;
      RepeatedFieldBuilderV3<PluginProtos.CodeGeneratorResponse.File, PluginProtos.CodeGeneratorResponse.File.Builder, PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.file_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFB;
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clearError() {
      this.bitField0_ &= 0xFFFFFFFE;
      this.error_ = PluginProtos.CodeGeneratorResponse.getDefaultInstance().getError();
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearFile() {
      RepeatedFieldBuilderV3<PluginProtos.CodeGeneratorResponse.File, PluginProtos.CodeGeneratorResponse.File.Builder, PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.file_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFB;
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearSupportedFeatures() {
      this.bitField0_ &= 0xFFFFFFFD;
      this.supportedFeatures_ = 0L;
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public PluginProtos.CodeGeneratorResponse getDefaultInstanceForType() {
      return PluginProtos.CodeGeneratorResponse.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_descriptor;
    }
    
    public String getError() {
      Object object = this.error_;
      if (!(object instanceof String)) {
        object = object;
        String str = object.toStringUtf8();
        if (object.isValidUtf8())
          this.error_ = str; 
        return str;
      } 
      return (String)object;
    }
    
    public ByteString getErrorBytes() {
      Object object = this.error_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.error_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public PluginProtos.CodeGeneratorResponse.File getFile(int param1Int) {
      RepeatedFieldBuilderV3<PluginProtos.CodeGeneratorResponse.File, PluginProtos.CodeGeneratorResponse.File.Builder, PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.file_.get(param1Int) : (PluginProtos.CodeGeneratorResponse.File)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public PluginProtos.CodeGeneratorResponse.File.Builder getFileBuilder(int param1Int) {
      return (PluginProtos.CodeGeneratorResponse.File.Builder)getFileFieldBuilder().getBuilder(param1Int);
    }
    
    public List<PluginProtos.CodeGeneratorResponse.File.Builder> getFileBuilderList() {
      return getFileFieldBuilder().getBuilderList();
    }
    
    public int getFileCount() {
      RepeatedFieldBuilderV3<PluginProtos.CodeGeneratorResponse.File, PluginProtos.CodeGeneratorResponse.File.Builder, PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.file_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<PluginProtos.CodeGeneratorResponse.File> getFileList() {
      RepeatedFieldBuilderV3<PluginProtos.CodeGeneratorResponse.File, PluginProtos.CodeGeneratorResponse.File.Builder, PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.file_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public PluginProtos.CodeGeneratorResponse.FileOrBuilder getFileOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<PluginProtos.CodeGeneratorResponse.File, PluginProtos.CodeGeneratorResponse.File.Builder, PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.file_.get(param1Int) : (PluginProtos.CodeGeneratorResponse.FileOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends PluginProtos.CodeGeneratorResponse.FileOrBuilder> getFileOrBuilderList() {
      RepeatedFieldBuilderV3<PluginProtos.CodeGeneratorResponse.File, PluginProtos.CodeGeneratorResponse.File.Builder, PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList((List)this.file_);
    }
    
    public long getSupportedFeatures() {
      return this.supportedFeatures_;
    }
    
    public boolean hasError() {
      return ((this.bitField0_ & 0x1) != 0);
    }
    
    public boolean hasSupportedFeatures() {
      return ((this.bitField0_ & 0x2) != 0);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(PluginProtos.CodeGeneratorResponse.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        PluginProtos.CodeGeneratorResponse codeGeneratorResponse = (PluginProtos.CodeGeneratorResponse)PluginProtos.CodeGeneratorResponse.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        PluginProtos.CodeGeneratorResponse codeGeneratorResponse = (PluginProtos.CodeGeneratorResponse)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((PluginProtos.CodeGeneratorResponse)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof PluginProtos.CodeGeneratorResponse)
        return mergeFrom((PluginProtos.CodeGeneratorResponse)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeFrom(PluginProtos.CodeGeneratorResponse param1CodeGeneratorResponse) {
      if (param1CodeGeneratorResponse == PluginProtos.CodeGeneratorResponse.getDefaultInstance())
        return this; 
      if (param1CodeGeneratorResponse.hasError()) {
        this.bitField0_ |= 0x1;
        this.error_ = param1CodeGeneratorResponse.error_;
        onChanged();
      } 
      if (param1CodeGeneratorResponse.hasSupportedFeatures())
        setSupportedFeatures(param1CodeGeneratorResponse.getSupportedFeatures()); 
      if (this.fileBuilder_ == null) {
        if (!param1CodeGeneratorResponse.file_.isEmpty()) {
          if (this.file_.isEmpty()) {
            this.file_ = param1CodeGeneratorResponse.file_;
            this.bitField0_ &= 0xFFFFFFFB;
          } else {
            ensureFileIsMutable();
            this.file_.addAll(param1CodeGeneratorResponse.file_);
          } 
          onChanged();
        } 
      } else if (!param1CodeGeneratorResponse.file_.isEmpty()) {
        if (this.fileBuilder_.isEmpty()) {
          this.fileBuilder_.dispose();
          RepeatedFieldBuilderV3<PluginProtos.CodeGeneratorResponse.File, PluginProtos.CodeGeneratorResponse.File.Builder, PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = null;
          this.fileBuilder_ = null;
          this.file_ = param1CodeGeneratorResponse.file_;
          this.bitField0_ &= 0xFFFFFFFB;
          if (PluginProtos.CodeGeneratorResponse.alwaysUseFieldBuilders)
            repeatedFieldBuilderV3 = getFileFieldBuilder(); 
          this.fileBuilder_ = repeatedFieldBuilderV3;
        } else {
          this.fileBuilder_.addAllMessages(param1CodeGeneratorResponse.file_);
        } 
      } 
      mergeUnknownFields(param1CodeGeneratorResponse.unknownFields);
      onChanged();
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder removeFile(int param1Int) {
      RepeatedFieldBuilderV3<PluginProtos.CodeGeneratorResponse.File, PluginProtos.CodeGeneratorResponse.File.Builder, PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureFileIsMutable();
        this.file_.remove(param1Int);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.remove(param1Int);
      return this;
    }
    
    public Builder setError(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x1;
        this.error_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setErrorBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x1;
        this.error_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setFile(int param1Int, PluginProtos.CodeGeneratorResponse.File.Builder param1Builder) {
      RepeatedFieldBuilderV3<PluginProtos.CodeGeneratorResponse.File, PluginProtos.CodeGeneratorResponse.File.Builder, PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureFileIsMutable();
        this.file_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setFile(int param1Int, PluginProtos.CodeGeneratorResponse.File param1File) {
      RepeatedFieldBuilderV3<PluginProtos.CodeGeneratorResponse.File, PluginProtos.CodeGeneratorResponse.File.Builder, PluginProtos.CodeGeneratorResponse.FileOrBuilder> repeatedFieldBuilderV3 = this.fileBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1File != null) {
          ensureFileIsMutable();
          this.file_.set(param1Int, param1File);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1File);
      return this;
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setSupportedFeatures(long param1Long) {
      this.bitField0_ |= 0x2;
      this.supportedFeatures_ = param1Long;
      onChanged();
      return this;
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
  
  public enum Feature implements ProtocolMessageEnum {
    FEATURE_NONE(0),
    FEATURE_PROTO3_OPTIONAL(1);
    
    public static final int FEATURE_NONE_VALUE = 0;
    
    public static final int FEATURE_PROTO3_OPTIONAL_VALUE = 1;
    
    private static final Feature[] VALUES;
    
    private static final Internal.EnumLiteMap<Feature> internalValueMap = new Internal.EnumLiteMap<Feature>() {
        public PluginProtos.CodeGeneratorResponse.Feature findValueByNumber(int param3Int) {
          return PluginProtos.CodeGeneratorResponse.Feature.forNumber(param3Int);
        }
      };
    
    private final int value;
    
    static {
      VALUES = values();
    }
    
    Feature(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static Feature forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? null : FEATURE_PROTO3_OPTIONAL) : FEATURE_NONE;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return PluginProtos.CodeGeneratorResponse.getDescriptor().getEnumTypes().get(0);
    }
    
    public static Internal.EnumLiteMap<Feature> internalGetValueMap() {
      return internalValueMap;
    }
    
    public final Descriptors.EnumDescriptor getDescriptorForType() {
      return getDescriptor();
    }
    
    public final int getNumber() {
      return this.value;
    }
    
    public final Descriptors.EnumValueDescriptor getValueDescriptor() {
      return getDescriptor().getValues().get(ordinal());
    }
  }
  
  static final class null implements Internal.EnumLiteMap<CodeGeneratorResponse.Feature> {
    public PluginProtos.CodeGeneratorResponse.Feature findValueByNumber(int param1Int) {
      return PluginProtos.CodeGeneratorResponse.Feature.forNumber(param1Int);
    }
  }
  
  public static final class File extends GeneratedMessageV3 implements CodeGeneratorResponse.FileOrBuilder {
    public static final int CONTENT_FIELD_NUMBER = 15;
    
    private static final File DEFAULT_INSTANCE = new File();
    
    public static final int INSERTION_POINT_FIELD_NUMBER = 2;
    
    public static final int NAME_FIELD_NUMBER = 1;
    
    @Deprecated
    public static final Parser<File> PARSER = (Parser<File>)new AbstractParser<File>() {
        public PluginProtos.CodeGeneratorResponse.File parsePartialFrom(CodedInputStream param3CodedInputStream, ExtensionRegistryLite param3ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new PluginProtos.CodeGeneratorResponse.File(param3CodedInputStream, param3ExtensionRegistryLite);
        }
      };
    
    private static final long serialVersionUID = 0L;
    
    private int bitField0_;
    
    private volatile Object content_;
    
    private volatile Object insertionPoint_;
    
    private byte memoizedIsInitialized = -1;
    
    private volatile Object name_;
    
    private File() {
      this.name_ = "";
      this.insertionPoint_ = "";
      this.content_ = "";
    }
    
    private File(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        for (boolean bool = false; !bool; bool = true) {
          try {
            int i = param1CodedInputStream.readTag();
            if (i != 0) {
              if (i != 10) {
                if (i != 18) {
                  if (i != 122) {
                    if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i))
                      continue; 
                    continue;
                  } 
                  ByteString byteString2 = param1CodedInputStream.readBytes();
                  this.bitField0_ |= 0x4;
                  this.content_ = byteString2;
                  continue;
                } 
                ByteString byteString1 = param1CodedInputStream.readBytes();
                this.bitField0_ |= 0x2;
                this.insertionPoint_ = byteString1;
                continue;
              } 
              ByteString byteString = param1CodedInputStream.readBytes();
              this.bitField0_ = 0x1 | this.bitField0_;
              this.name_ = byteString;
              continue;
            } 
            continue;
          } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            throw invalidProtocolBufferException.setUnfinishedMessage(this);
          } catch (IOException iOException) {
            throw (new InvalidProtocolBufferException(iOException)).setUnfinishedMessage(this);
          } finally {}
          this.unknownFields = builder.build();
          makeExtensionsImmutable();
          throw param1CodedInputStream;
        } 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        return;
      } 
      throw new NullPointerException();
    }
    
    private File(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static File getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(File param1File) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1File);
    }
    
    public static File parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (File)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static File parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (File)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static File parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (File)PARSER.parseFrom(param1ByteString);
    }
    
    public static File parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (File)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static File parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (File)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static File parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (File)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static File parseFrom(InputStream param1InputStream) throws IOException {
      return (File)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static File parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (File)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static File parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (File)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static File parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (File)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static File parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (File)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static File parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (File)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<File> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof File))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return (hasName() != param1Object.hasName()) ? false : ((hasName() && !getName().equals(param1Object.getName())) ? false : ((hasInsertionPoint() != param1Object.hasInsertionPoint()) ? false : ((hasInsertionPoint() && !getInsertionPoint().equals(param1Object.getInsertionPoint())) ? false : ((hasContent() != param1Object.hasContent()) ? false : ((hasContent() && !getContent().equals(param1Object.getContent())) ? false : (!!this.unknownFields.equals(((File)param1Object).unknownFields)))))));
    }
    
    public String getContent() {
      Object object = this.content_;
      if (object instanceof String)
        return (String)object; 
      object = object;
      String str = object.toStringUtf8();
      if (object.isValidUtf8())
        this.content_ = str; 
      return str;
    }
    
    public ByteString getContentBytes() {
      Object object = this.content_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.content_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public File getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public String getInsertionPoint() {
      Object object = this.insertionPoint_;
      if (object instanceof String)
        return (String)object; 
      object = object;
      String str = object.toStringUtf8();
      if (object.isValidUtf8())
        this.insertionPoint_ = str; 
      return str;
    }
    
    public ByteString getInsertionPointBytes() {
      Object object = this.insertionPoint_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.insertionPoint_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getName() {
      Object object = this.name_;
      if (object instanceof String)
        return (String)object; 
      object = object;
      String str = object.toStringUtf8();
      if (object.isValidUtf8())
        this.name_ = str; 
      return str;
    }
    
    public ByteString getNameBytes() {
      Object object = this.name_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.name_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public Parser<File> getParserForType() {
      return PARSER;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if ((this.bitField0_ & 0x1) != 0)
        j = 0 + GeneratedMessageV3.computeStringSize(1, this.name_); 
      i = j;
      if ((this.bitField0_ & 0x2) != 0)
        i = j + GeneratedMessageV3.computeStringSize(2, this.insertionPoint_); 
      j = i;
      if ((this.bitField0_ & 0x4) != 0)
        j = i + GeneratedMessageV3.computeStringSize(15, this.content_); 
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }
    
    public boolean hasContent() {
      return ((this.bitField0_ & 0x4) != 0);
    }
    
    public boolean hasInsertionPoint() {
      return ((this.bitField0_ & 0x2) != 0);
    }
    
    public boolean hasName() {
      return ((this.bitField0_ & 0x1) != 0);
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int j = 779 + getDescriptor().hashCode();
      int i = j;
      if (hasName())
        i = (j * 37 + 1) * 53 + getName().hashCode(); 
      j = i;
      if (hasInsertionPoint())
        j = (i * 37 + 2) * 53 + getInsertionPoint().hashCode(); 
      i = j;
      if (hasContent())
        i = (j * 37 + 15) * 53 + getContent().hashCode(); 
      i = i * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_fieldAccessorTable.ensureFieldAccessorsInitialized(File.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      byte b = this.memoizedIsInitialized;
      if (b == 1)
        return true; 
      if (b == 0)
        return false; 
      this.memoizedIsInitialized = 1;
      return true;
    }
    
    public Builder newBuilderForType() {
      return newBuilder();
    }
    
    protected Builder newBuilderForType(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      return new Builder(param1BuilderParent);
    }
    
    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter param1UnusedPrivateParameter) {
      return new File();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if ((this.bitField0_ & 0x1) != 0)
        GeneratedMessageV3.writeString(param1CodedOutputStream, 1, this.name_); 
      if ((this.bitField0_ & 0x2) != 0)
        GeneratedMessageV3.writeString(param1CodedOutputStream, 2, this.insertionPoint_); 
      if ((this.bitField0_ & 0x4) != 0)
        GeneratedMessageV3.writeString(param1CodedOutputStream, 15, this.content_); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PluginProtos.CodeGeneratorResponse.FileOrBuilder {
      private int bitField0_;
      
      private Object content_ = "";
      
      private Object insertionPoint_ = "";
      
      private Object name_ = "";
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param3BuilderParent) {
        super(param3BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        PluginProtos.CodeGeneratorResponse.File.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param3FieldDescriptor, Object param3Object) {
        return (Builder)super.addRepeatedField(param3FieldDescriptor, param3Object);
      }
      
      public PluginProtos.CodeGeneratorResponse.File build() {
        PluginProtos.CodeGeneratorResponse.File file = buildPartial();
        if (file.isInitialized())
          return file; 
        throw newUninitializedMessageException(file);
      }
      
      public PluginProtos.CodeGeneratorResponse.File buildPartial() {
        PluginProtos.CodeGeneratorResponse.File file = new PluginProtos.CodeGeneratorResponse.File(this);
        int k = this.bitField0_;
        if ((k & 0x1) != 0) {
          j = 1;
        } else {
          j = 0;
        } 
        PluginProtos.CodeGeneratorResponse.File.access$3502(file, this.name_);
        int i = j;
        if ((k & 0x2) != 0)
          i = j | 0x2; 
        PluginProtos.CodeGeneratorResponse.File.access$3602(file, this.insertionPoint_);
        int j = i;
        if ((k & 0x4) != 0)
          j = i | 0x4; 
        PluginProtos.CodeGeneratorResponse.File.access$3702(file, this.content_);
        PluginProtos.CodeGeneratorResponse.File.access$3802(file, j);
        onBuilt();
        return file;
      }
      
      public Builder clear() {
        super.clear();
        this.name_ = "";
        this.bitField0_ &= 0xFFFFFFFE;
        this.insertionPoint_ = "";
        this.bitField0_ &= 0xFFFFFFFD;
        this.content_ = "";
        this.bitField0_ &= 0xFFFFFFFB;
        return this;
      }
      
      public Builder clearContent() {
        this.bitField0_ &= 0xFFFFFFFB;
        this.content_ = PluginProtos.CodeGeneratorResponse.File.getDefaultInstance().getContent();
        onChanged();
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param3FieldDescriptor) {
        return (Builder)super.clearField(param3FieldDescriptor);
      }
      
      public Builder clearInsertionPoint() {
        this.bitField0_ &= 0xFFFFFFFD;
        this.insertionPoint_ = PluginProtos.CodeGeneratorResponse.File.getDefaultInstance().getInsertionPoint();
        onChanged();
        return this;
      }
      
      public Builder clearName() {
        this.bitField0_ &= 0xFFFFFFFE;
        this.name_ = PluginProtos.CodeGeneratorResponse.File.getDefaultInstance().getName();
        onChanged();
        return this;
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param3OneofDescriptor) {
        return (Builder)super.clearOneof(param3OneofDescriptor);
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public String getContent() {
        Object object = this.content_;
        if (!(object instanceof String)) {
          object = object;
          String str = object.toStringUtf8();
          if (object.isValidUtf8())
            this.content_ = str; 
          return str;
        } 
        return (String)object;
      }
      
      public ByteString getContentBytes() {
        Object object = this.content_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.content_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public PluginProtos.CodeGeneratorResponse.File getDefaultInstanceForType() {
        return PluginProtos.CodeGeneratorResponse.File.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor;
      }
      
      public String getInsertionPoint() {
        Object object = this.insertionPoint_;
        if (!(object instanceof String)) {
          object = object;
          String str = object.toStringUtf8();
          if (object.isValidUtf8())
            this.insertionPoint_ = str; 
          return str;
        } 
        return (String)object;
      }
      
      public ByteString getInsertionPointBytes() {
        Object object = this.insertionPoint_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.insertionPoint_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public String getName() {
        Object object = this.name_;
        if (!(object instanceof String)) {
          object = object;
          String str = object.toStringUtf8();
          if (object.isValidUtf8())
            this.name_ = str; 
          return str;
        } 
        return (String)object;
      }
      
      public ByteString getNameBytes() {
        Object object = this.name_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.name_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public boolean hasContent() {
        return ((this.bitField0_ & 0x4) != 0);
      }
      
      public boolean hasInsertionPoint() {
        return ((this.bitField0_ & 0x2) != 0);
      }
      
      public boolean hasName() {
        return ((this.bitField0_ & 0x1) != 0);
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_fieldAccessorTable.ensureFieldAccessorsInitialized(PluginProtos.CodeGeneratorResponse.File.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(CodedInputStream param3CodedInputStream, ExtensionRegistryLite param3ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          PluginProtos.CodeGeneratorResponse.File file = (PluginProtos.CodeGeneratorResponse.File)PluginProtos.CodeGeneratorResponse.File.PARSER.parsePartialFrom(param3CodedInputStream, param3ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          PluginProtos.CodeGeneratorResponse.File file = (PluginProtos.CodeGeneratorResponse.File)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param3ExtensionRegistryLite = null;
        } 
        if (param3CodedInputStream != null)
          mergeFrom((PluginProtos.CodeGeneratorResponse.File)param3CodedInputStream); 
        throw param3ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param3Message) {
        if (param3Message instanceof PluginProtos.CodeGeneratorResponse.File)
          return mergeFrom((PluginProtos.CodeGeneratorResponse.File)param3Message); 
        super.mergeFrom(param3Message);
        return this;
      }
      
      public Builder mergeFrom(PluginProtos.CodeGeneratorResponse.File param3File) {
        if (param3File == PluginProtos.CodeGeneratorResponse.File.getDefaultInstance())
          return this; 
        if (param3File.hasName()) {
          this.bitField0_ |= 0x1;
          this.name_ = param3File.name_;
          onChanged();
        } 
        if (param3File.hasInsertionPoint()) {
          this.bitField0_ |= 0x2;
          this.insertionPoint_ = param3File.insertionPoint_;
          onChanged();
        } 
        if (param3File.hasContent()) {
          this.bitField0_ |= 0x4;
          this.content_ = param3File.content_;
          onChanged();
        } 
        mergeUnknownFields(param3File.unknownFields);
        onChanged();
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param3UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param3UnknownFieldSet);
      }
      
      public Builder setContent(String param3String) {
        if (param3String != null) {
          this.bitField0_ |= 0x4;
          this.content_ = param3String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setContentBytes(ByteString param3ByteString) {
        if (param3ByteString != null) {
          this.bitField0_ |= 0x4;
          this.content_ = param3ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setField(Descriptors.FieldDescriptor param3FieldDescriptor, Object param3Object) {
        return (Builder)super.setField(param3FieldDescriptor, param3Object);
      }
      
      public Builder setInsertionPoint(String param3String) {
        if (param3String != null) {
          this.bitField0_ |= 0x2;
          this.insertionPoint_ = param3String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setInsertionPointBytes(ByteString param3ByteString) {
        if (param3ByteString != null) {
          this.bitField0_ |= 0x2;
          this.insertionPoint_ = param3ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setName(String param3String) {
        if (param3String != null) {
          this.bitField0_ |= 0x1;
          this.name_ = param3String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setNameBytes(ByteString param3ByteString) {
        if (param3ByteString != null) {
          this.bitField0_ |= 0x1;
          this.name_ = param3ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param3FieldDescriptor, int param3Int, Object param3Object) {
        return (Builder)super.setRepeatedField(param3FieldDescriptor, param3Int, param3Object);
      }
      
      public final Builder setUnknownFields(UnknownFieldSet param3UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param3UnknownFieldSet);
      }
    }
  }
  
  static final class null extends AbstractParser<CodeGeneratorResponse.File> {
    public PluginProtos.CodeGeneratorResponse.File parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new PluginProtos.CodeGeneratorResponse.File(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<CodeGeneratorResponse.File.Builder> implements CodeGeneratorResponse.FileOrBuilder {
    private int bitField0_;
    
    private Object content_ = "";
    
    private Object insertionPoint_ = "";
    
    private Object name_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      PluginProtos.CodeGeneratorResponse.File.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public PluginProtos.CodeGeneratorResponse.File build() {
      PluginProtos.CodeGeneratorResponse.File file = buildPartial();
      if (file.isInitialized())
        return file; 
      throw newUninitializedMessageException(file);
    }
    
    public PluginProtos.CodeGeneratorResponse.File buildPartial() {
      PluginProtos.CodeGeneratorResponse.File file = new PluginProtos.CodeGeneratorResponse.File(this);
      int k = this.bitField0_;
      if ((k & 0x1) != 0) {
        j = 1;
      } else {
        j = 0;
      } 
      PluginProtos.CodeGeneratorResponse.File.access$3502(file, this.name_);
      int i = j;
      if ((k & 0x2) != 0)
        i = j | 0x2; 
      PluginProtos.CodeGeneratorResponse.File.access$3602(file, this.insertionPoint_);
      int j = i;
      if ((k & 0x4) != 0)
        j = i | 0x4; 
      PluginProtos.CodeGeneratorResponse.File.access$3702(file, this.content_);
      PluginProtos.CodeGeneratorResponse.File.access$3802(file, j);
      onBuilt();
      return file;
    }
    
    public Builder clear() {
      super.clear();
      this.name_ = "";
      this.bitField0_ &= 0xFFFFFFFE;
      this.insertionPoint_ = "";
      this.bitField0_ &= 0xFFFFFFFD;
      this.content_ = "";
      this.bitField0_ &= 0xFFFFFFFB;
      return this;
    }
    
    public Builder clearContent() {
      this.bitField0_ &= 0xFFFFFFFB;
      this.content_ = PluginProtos.CodeGeneratorResponse.File.getDefaultInstance().getContent();
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearInsertionPoint() {
      this.bitField0_ &= 0xFFFFFFFD;
      this.insertionPoint_ = PluginProtos.CodeGeneratorResponse.File.getDefaultInstance().getInsertionPoint();
      onChanged();
      return this;
    }
    
    public Builder clearName() {
      this.bitField0_ &= 0xFFFFFFFE;
      this.name_ = PluginProtos.CodeGeneratorResponse.File.getDefaultInstance().getName();
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public String getContent() {
      Object object = this.content_;
      if (!(object instanceof String)) {
        object = object;
        String str = object.toStringUtf8();
        if (object.isValidUtf8())
          this.content_ = str; 
        return str;
      } 
      return (String)object;
    }
    
    public ByteString getContentBytes() {
      Object object = this.content_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.content_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public PluginProtos.CodeGeneratorResponse.File getDefaultInstanceForType() {
      return PluginProtos.CodeGeneratorResponse.File.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor;
    }
    
    public String getInsertionPoint() {
      Object object = this.insertionPoint_;
      if (!(object instanceof String)) {
        object = object;
        String str = object.toStringUtf8();
        if (object.isValidUtf8())
          this.insertionPoint_ = str; 
        return str;
      } 
      return (String)object;
    }
    
    public ByteString getInsertionPointBytes() {
      Object object = this.insertionPoint_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.insertionPoint_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getName() {
      Object object = this.name_;
      if (!(object instanceof String)) {
        object = object;
        String str = object.toStringUtf8();
        if (object.isValidUtf8())
          this.name_ = str; 
        return str;
      } 
      return (String)object;
    }
    
    public ByteString getNameBytes() {
      Object object = this.name_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.name_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public boolean hasContent() {
      return ((this.bitField0_ & 0x4) != 0);
    }
    
    public boolean hasInsertionPoint() {
      return ((this.bitField0_ & 0x2) != 0);
    }
    
    public boolean hasName() {
      return ((this.bitField0_ & 0x1) != 0);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return PluginProtos.internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_fieldAccessorTable.ensureFieldAccessorsInitialized(PluginProtos.CodeGeneratorResponse.File.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        PluginProtos.CodeGeneratorResponse.File file = (PluginProtos.CodeGeneratorResponse.File)PluginProtos.CodeGeneratorResponse.File.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        PluginProtos.CodeGeneratorResponse.File file = (PluginProtos.CodeGeneratorResponse.File)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((PluginProtos.CodeGeneratorResponse.File)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof PluginProtos.CodeGeneratorResponse.File)
        return mergeFrom((PluginProtos.CodeGeneratorResponse.File)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeFrom(PluginProtos.CodeGeneratorResponse.File param1File) {
      if (param1File == PluginProtos.CodeGeneratorResponse.File.getDefaultInstance())
        return this; 
      if (param1File.hasName()) {
        this.bitField0_ |= 0x1;
        this.name_ = param1File.name_;
        onChanged();
      } 
      if (param1File.hasInsertionPoint()) {
        this.bitField0_ |= 0x2;
        this.insertionPoint_ = param1File.insertionPoint_;
        onChanged();
      } 
      if (param1File.hasContent()) {
        this.bitField0_ |= 0x4;
        this.content_ = param1File.content_;
        onChanged();
      } 
      mergeUnknownFields(param1File.unknownFields);
      onChanged();
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setContent(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x4;
        this.content_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setContentBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x4;
        this.content_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setInsertionPoint(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x2;
        this.insertionPoint_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setInsertionPointBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x2;
        this.insertionPoint_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setName(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x1;
        this.name_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setNameBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x1;
        this.name_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
  
  public static interface FileOrBuilder extends MessageOrBuilder {
    String getContent();
    
    ByteString getContentBytes();
    
    String getInsertionPoint();
    
    ByteString getInsertionPointBytes();
    
    String getName();
    
    ByteString getNameBytes();
    
    boolean hasContent();
    
    boolean hasInsertionPoint();
    
    boolean hasName();
  }
  
  public static interface CodeGeneratorResponseOrBuilder extends MessageOrBuilder {
    String getError();
    
    ByteString getErrorBytes();
    
    PluginProtos.CodeGeneratorResponse.File getFile(int param1Int);
    
    int getFileCount();
    
    List<PluginProtos.CodeGeneratorResponse.File> getFileList();
    
    PluginProtos.CodeGeneratorResponse.FileOrBuilder getFileOrBuilder(int param1Int);
    
    List<? extends PluginProtos.CodeGeneratorResponse.FileOrBuilder> getFileOrBuilderList();
    
    long getSupportedFeatures();
    
    boolean hasError();
    
    boolean hasSupportedFeatures();
  }
  
  public static final class Version extends GeneratedMessageV3 implements VersionOrBuilder {
    private static final Version DEFAULT_INSTANCE = new Version();
    
    public static final int MAJOR_FIELD_NUMBER = 1;
    
    public static final int MINOR_FIELD_NUMBER = 2;
    
    @Deprecated
    public static final Parser<Version> PARSER = (Parser<Version>)new AbstractParser<Version>() {
        public PluginProtos.Version parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new PluginProtos.Version(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int PATCH_FIELD_NUMBER = 3;
    
    public static final int SUFFIX_FIELD_NUMBER = 4;
    
    private static final long serialVersionUID = 0L;
    
    private int bitField0_;
    
    private int major_;
    
    private byte memoizedIsInitialized = -1;
    
    private int minor_;
    
    private int patch_;
    
    private volatile Object suffix_;
    
    private Version() {
      this.suffix_ = "";
    }
    
    private Version(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        for (boolean bool = false; !bool; bool = true) {
          try {
            int i = param1CodedInputStream.readTag();
            if (i != 0) {
              if (i != 8) {
                if (i != 16) {
                  if (i != 24) {
                    if (i != 34) {
                      if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i))
                        continue; 
                      continue;
                    } 
                    ByteString byteString = param1CodedInputStream.readBytes();
                    this.bitField0_ |= 0x8;
                    this.suffix_ = byteString;
                    continue;
                  } 
                  this.bitField0_ |= 0x4;
                  this.patch_ = param1CodedInputStream.readInt32();
                  continue;
                } 
                this.bitField0_ |= 0x2;
                this.minor_ = param1CodedInputStream.readInt32();
                continue;
              } 
              this.bitField0_ |= 0x1;
              this.major_ = param1CodedInputStream.readInt32();
              continue;
            } 
            continue;
          } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            throw invalidProtocolBufferException.setUnfinishedMessage(this);
          } catch (IOException iOException) {
            throw (new InvalidProtocolBufferException(iOException)).setUnfinishedMessage(this);
          } finally {}
          this.unknownFields = builder.build();
          makeExtensionsImmutable();
          throw param1CodedInputStream;
        } 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        return;
      } 
      throw new NullPointerException();
    }
    
    private Version(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static Version getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return PluginProtos.internal_static_google_protobuf_compiler_Version_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(Version param1Version) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1Version);
    }
    
    public static Version parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (Version)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static Version parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Version)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Version parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (Version)PARSER.parseFrom(param1ByteString);
    }
    
    public static Version parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Version)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static Version parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (Version)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static Version parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Version)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static Version parseFrom(InputStream param1InputStream) throws IOException {
      return (Version)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static Version parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Version)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Version parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (Version)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static Version parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Version)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static Version parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (Version)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static Version parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Version)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<Version> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof Version))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return (hasMajor() != param1Object.hasMajor()) ? false : ((hasMajor() && getMajor() != param1Object.getMajor()) ? false : ((hasMinor() != param1Object.hasMinor()) ? false : ((hasMinor() && getMinor() != param1Object.getMinor()) ? false : ((hasPatch() != param1Object.hasPatch()) ? false : ((hasPatch() && getPatch() != param1Object.getPatch()) ? false : ((hasSuffix() != param1Object.hasSuffix()) ? false : ((hasSuffix() && !getSuffix().equals(param1Object.getSuffix())) ? false : (!!this.unknownFields.equals(((Version)param1Object).unknownFields)))))))));
    }
    
    public Version getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public int getMajor() {
      return this.major_;
    }
    
    public int getMinor() {
      return this.minor_;
    }
    
    public Parser<Version> getParserForType() {
      return PARSER;
    }
    
    public int getPatch() {
      return this.patch_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if ((this.bitField0_ & 0x1) != 0)
        j = 0 + CodedOutputStream.computeInt32Size(1, this.major_); 
      i = j;
      if ((this.bitField0_ & 0x2) != 0)
        i = j + CodedOutputStream.computeInt32Size(2, this.minor_); 
      j = i;
      if ((this.bitField0_ & 0x4) != 0)
        j = i + CodedOutputStream.computeInt32Size(3, this.patch_); 
      i = j;
      if ((this.bitField0_ & 0x8) != 0)
        i = j + GeneratedMessageV3.computeStringSize(4, this.suffix_); 
      i += this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public String getSuffix() {
      Object object = this.suffix_;
      if (object instanceof String)
        return (String)object; 
      object = object;
      String str = object.toStringUtf8();
      if (object.isValidUtf8())
        this.suffix_ = str; 
      return str;
    }
    
    public ByteString getSuffixBytes() {
      Object object = this.suffix_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.suffix_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }
    
    public boolean hasMajor() {
      return ((this.bitField0_ & 0x1) != 0);
    }
    
    public boolean hasMinor() {
      return ((this.bitField0_ & 0x2) != 0);
    }
    
    public boolean hasPatch() {
      return ((this.bitField0_ & 0x4) != 0);
    }
    
    public boolean hasSuffix() {
      return ((this.bitField0_ & 0x8) != 0);
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int j = 779 + getDescriptor().hashCode();
      int i = j;
      if (hasMajor())
        i = (j * 37 + 1) * 53 + getMajor(); 
      j = i;
      if (hasMinor())
        j = (i * 37 + 2) * 53 + getMinor(); 
      i = j;
      if (hasPatch())
        i = (j * 37 + 3) * 53 + getPatch(); 
      j = i;
      if (hasSuffix())
        j = (i * 37 + 4) * 53 + getSuffix().hashCode(); 
      i = j * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return PluginProtos.internal_static_google_protobuf_compiler_Version_fieldAccessorTable.ensureFieldAccessorsInitialized(Version.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      byte b = this.memoizedIsInitialized;
      if (b == 1)
        return true; 
      if (b == 0)
        return false; 
      this.memoizedIsInitialized = 1;
      return true;
    }
    
    public Builder newBuilderForType() {
      return newBuilder();
    }
    
    protected Builder newBuilderForType(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      return new Builder(param1BuilderParent);
    }
    
    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter param1UnusedPrivateParameter) {
      return new Version();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if ((this.bitField0_ & 0x1) != 0)
        param1CodedOutputStream.writeInt32(1, this.major_); 
      if ((this.bitField0_ & 0x2) != 0)
        param1CodedOutputStream.writeInt32(2, this.minor_); 
      if ((this.bitField0_ & 0x4) != 0)
        param1CodedOutputStream.writeInt32(3, this.patch_); 
      if ((this.bitField0_ & 0x8) != 0)
        GeneratedMessageV3.writeString(param1CodedOutputStream, 4, this.suffix_); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PluginProtos.VersionOrBuilder {
      private int bitField0_;
      
      private int major_;
      
      private int minor_;
      
      private int patch_;
      
      private Object suffix_ = "";
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return PluginProtos.internal_static_google_protobuf_compiler_Version_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        PluginProtos.Version.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public PluginProtos.Version build() {
        PluginProtos.Version version = buildPartial();
        if (version.isInitialized())
          return version; 
        throw newUninitializedMessageException(version);
      }
      
      public PluginProtos.Version buildPartial() {
        PluginProtos.Version version = new PluginProtos.Version(this);
        int k = this.bitField0_;
        if ((k & 0x1) != 0) {
          PluginProtos.Version.access$602(version, this.major_);
          j = 1;
        } else {
          j = 0;
        } 
        int i = j;
        if ((k & 0x2) != 0) {
          PluginProtos.Version.access$702(version, this.minor_);
          i = j | 0x2;
        } 
        int j = i;
        if ((k & 0x4) != 0) {
          PluginProtos.Version.access$802(version, this.patch_);
          j = i | 0x4;
        } 
        i = j;
        if ((k & 0x8) != 0)
          i = j | 0x8; 
        PluginProtos.Version.access$902(version, this.suffix_);
        PluginProtos.Version.access$1002(version, i);
        onBuilt();
        return version;
      }
      
      public Builder clear() {
        super.clear();
        this.major_ = 0;
        this.bitField0_ &= 0xFFFFFFFE;
        this.minor_ = 0;
        this.bitField0_ &= 0xFFFFFFFD;
        this.patch_ = 0;
        this.bitField0_ &= 0xFFFFFFFB;
        this.suffix_ = "";
        this.bitField0_ &= 0xFFFFFFF7;
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearMajor() {
        this.bitField0_ &= 0xFFFFFFFE;
        this.major_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearMinor() {
        this.bitField0_ &= 0xFFFFFFFD;
        this.minor_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearPatch() {
        this.bitField0_ &= 0xFFFFFFFB;
        this.patch_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearSuffix() {
        this.bitField0_ &= 0xFFFFFFF7;
        this.suffix_ = PluginProtos.Version.getDefaultInstance().getSuffix();
        onChanged();
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public PluginProtos.Version getDefaultInstanceForType() {
        return PluginProtos.Version.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return PluginProtos.internal_static_google_protobuf_compiler_Version_descriptor;
      }
      
      public int getMajor() {
        return this.major_;
      }
      
      public int getMinor() {
        return this.minor_;
      }
      
      public int getPatch() {
        return this.patch_;
      }
      
      public String getSuffix() {
        Object object = this.suffix_;
        if (!(object instanceof String)) {
          object = object;
          String str = object.toStringUtf8();
          if (object.isValidUtf8())
            this.suffix_ = str; 
          return str;
        } 
        return (String)object;
      }
      
      public ByteString getSuffixBytes() {
        Object object = this.suffix_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.suffix_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public boolean hasMajor() {
        return ((this.bitField0_ & 0x1) != 0);
      }
      
      public boolean hasMinor() {
        return ((this.bitField0_ & 0x2) != 0);
      }
      
      public boolean hasPatch() {
        return ((this.bitField0_ & 0x4) != 0);
      }
      
      public boolean hasSuffix() {
        return ((this.bitField0_ & 0x8) != 0);
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return PluginProtos.internal_static_google_protobuf_compiler_Version_fieldAccessorTable.ensureFieldAccessorsInitialized(PluginProtos.Version.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          PluginProtos.Version version = (PluginProtos.Version)PluginProtos.Version.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          PluginProtos.Version version = (PluginProtos.Version)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((PluginProtos.Version)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof PluginProtos.Version)
          return mergeFrom((PluginProtos.Version)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public Builder mergeFrom(PluginProtos.Version param2Version) {
        if (param2Version == PluginProtos.Version.getDefaultInstance())
          return this; 
        if (param2Version.hasMajor())
          setMajor(param2Version.getMajor()); 
        if (param2Version.hasMinor())
          setMinor(param2Version.getMinor()); 
        if (param2Version.hasPatch())
          setPatch(param2Version.getPatch()); 
        if (param2Version.hasSuffix()) {
          this.bitField0_ |= 0x8;
          this.suffix_ = param2Version.suffix_;
          onChanged();
        } 
        mergeUnknownFields(param2Version.unknownFields);
        onChanged();
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setMajor(int param2Int) {
        this.bitField0_ |= 0x1;
        this.major_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setMinor(int param2Int) {
        this.bitField0_ |= 0x2;
        this.minor_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setPatch(int param2Int) {
        this.bitField0_ |= 0x4;
        this.patch_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public Builder setSuffix(String param2String) {
        if (param2String != null) {
          this.bitField0_ |= 0x8;
          this.suffix_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setSuffixBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          this.bitField0_ |= 0x8;
          this.suffix_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public final Builder setUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param2UnknownFieldSet);
      }
    }
  }
  
  static final class null extends AbstractParser<Version> {
    public PluginProtos.Version parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new PluginProtos.Version(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Version.Builder> implements VersionOrBuilder {
    private int bitField0_;
    
    private int major_;
    
    private int minor_;
    
    private int patch_;
    
    private Object suffix_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return PluginProtos.internal_static_google_protobuf_compiler_Version_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      PluginProtos.Version.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public PluginProtos.Version build() {
      PluginProtos.Version version = buildPartial();
      if (version.isInitialized())
        return version; 
      throw newUninitializedMessageException(version);
    }
    
    public PluginProtos.Version buildPartial() {
      PluginProtos.Version version = new PluginProtos.Version(this);
      int k = this.bitField0_;
      if ((k & 0x1) != 0) {
        PluginProtos.Version.access$602(version, this.major_);
        j = 1;
      } else {
        j = 0;
      } 
      int i = j;
      if ((k & 0x2) != 0) {
        PluginProtos.Version.access$702(version, this.minor_);
        i = j | 0x2;
      } 
      int j = i;
      if ((k & 0x4) != 0) {
        PluginProtos.Version.access$802(version, this.patch_);
        j = i | 0x4;
      } 
      i = j;
      if ((k & 0x8) != 0)
        i = j | 0x8; 
      PluginProtos.Version.access$902(version, this.suffix_);
      PluginProtos.Version.access$1002(version, i);
      onBuilt();
      return version;
    }
    
    public Builder clear() {
      super.clear();
      this.major_ = 0;
      this.bitField0_ &= 0xFFFFFFFE;
      this.minor_ = 0;
      this.bitField0_ &= 0xFFFFFFFD;
      this.patch_ = 0;
      this.bitField0_ &= 0xFFFFFFFB;
      this.suffix_ = "";
      this.bitField0_ &= 0xFFFFFFF7;
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearMajor() {
      this.bitField0_ &= 0xFFFFFFFE;
      this.major_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearMinor() {
      this.bitField0_ &= 0xFFFFFFFD;
      this.minor_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearPatch() {
      this.bitField0_ &= 0xFFFFFFFB;
      this.patch_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearSuffix() {
      this.bitField0_ &= 0xFFFFFFF7;
      this.suffix_ = PluginProtos.Version.getDefaultInstance().getSuffix();
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public PluginProtos.Version getDefaultInstanceForType() {
      return PluginProtos.Version.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return PluginProtos.internal_static_google_protobuf_compiler_Version_descriptor;
    }
    
    public int getMajor() {
      return this.major_;
    }
    
    public int getMinor() {
      return this.minor_;
    }
    
    public int getPatch() {
      return this.patch_;
    }
    
    public String getSuffix() {
      Object object = this.suffix_;
      if (!(object instanceof String)) {
        object = object;
        String str = object.toStringUtf8();
        if (object.isValidUtf8())
          this.suffix_ = str; 
        return str;
      } 
      return (String)object;
    }
    
    public ByteString getSuffixBytes() {
      Object object = this.suffix_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.suffix_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public boolean hasMajor() {
      return ((this.bitField0_ & 0x1) != 0);
    }
    
    public boolean hasMinor() {
      return ((this.bitField0_ & 0x2) != 0);
    }
    
    public boolean hasPatch() {
      return ((this.bitField0_ & 0x4) != 0);
    }
    
    public boolean hasSuffix() {
      return ((this.bitField0_ & 0x8) != 0);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return PluginProtos.internal_static_google_protobuf_compiler_Version_fieldAccessorTable.ensureFieldAccessorsInitialized(PluginProtos.Version.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        PluginProtos.Version version = (PluginProtos.Version)PluginProtos.Version.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        PluginProtos.Version version = (PluginProtos.Version)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((PluginProtos.Version)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof PluginProtos.Version)
        return mergeFrom((PluginProtos.Version)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeFrom(PluginProtos.Version param1Version) {
      if (param1Version == PluginProtos.Version.getDefaultInstance())
        return this; 
      if (param1Version.hasMajor())
        setMajor(param1Version.getMajor()); 
      if (param1Version.hasMinor())
        setMinor(param1Version.getMinor()); 
      if (param1Version.hasPatch())
        setPatch(param1Version.getPatch()); 
      if (param1Version.hasSuffix()) {
        this.bitField0_ |= 0x8;
        this.suffix_ = param1Version.suffix_;
        onChanged();
      } 
      mergeUnknownFields(param1Version.unknownFields);
      onChanged();
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setMajor(int param1Int) {
      this.bitField0_ |= 0x1;
      this.major_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setMinor(int param1Int) {
      this.bitField0_ |= 0x2;
      this.minor_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setPatch(int param1Int) {
      this.bitField0_ |= 0x4;
      this.patch_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setSuffix(String param1String) {
      if (param1String != null) {
        this.bitField0_ |= 0x8;
        this.suffix_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setSuffixBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        this.bitField0_ |= 0x8;
        this.suffix_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
  
  public static interface VersionOrBuilder extends MessageOrBuilder {
    int getMajor();
    
    int getMinor();
    
    int getPatch();
    
    String getSuffix();
    
    ByteString getSuffixBytes();
    
    boolean hasMajor();
    
    boolean hasMinor();
    
    boolean hasPatch();
    
    boolean hasSuffix();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\compiler\PluginProtos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */