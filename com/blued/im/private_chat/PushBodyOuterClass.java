package com.blued.im.private_chat;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class PushBodyOuterClass {
  private static Descriptors.FileDescriptor descriptor;
  
  private static final Descriptors.Descriptor internal_static_com_blued_im_private_chat_PushBody_descriptor = getDescriptor().getMessageTypes().get(0);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_im_private_chat_PushBody_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_im_private_chat_PushBody_descriptor, new String[] { "Contents", "Profile", "Extra" });
  
  static {
    PushProfileOuterClass.getDescriptor();
    PushBodyExtraOuterClass.getDescriptor();
  }
  
  public static Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {
    registerAllExtensions((ExtensionRegistryLite)paramExtensionRegistry);
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  static {
    Descriptors.FileDescriptor fileDescriptor1 = PushProfileOuterClass.getDescriptor();
    Descriptors.FileDescriptor fileDescriptor2 = PushBodyExtraOuterClass.getDescriptor();
    descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\016PushBody.proto\022\031com.blued.im.private_chat\032\021PushProfile.proto\032\023PushBodyExtra.proto\"\001\n\bPushBody\022\020\n\bcontents\030\001 \001(\t\0227\n\007profile\030\002 \001(\0132&.com.blued.im.private_chat.PushProfile\0227\n\005extra\030\003 \001(\0132(.com.blued.im.private_chat.PushBodyExtraB\016¢\002\013PrivateChatb\006proto3" }, new Descriptors.FileDescriptor[] { fileDescriptor1, fileDescriptor2 });
  }
  
  public static final class PushBody extends GeneratedMessageV3 implements PushBodyOrBuilder {
    public static final int CONTENTS_FIELD_NUMBER = 1;
    
    private static final PushBody DEFAULT_INSTANCE = new PushBody();
    
    public static final int EXTRA_FIELD_NUMBER = 3;
    
    private static final Parser<PushBody> PARSER = (Parser<PushBody>)new AbstractParser<PushBody>() {
        public PushBodyOuterClass.PushBody parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new PushBodyOuterClass.PushBody(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int PROFILE_FIELD_NUMBER = 2;
    
    private static final long serialVersionUID = 0L;
    
    private volatile Object contents_;
    
    private PushBodyExtraOuterClass.PushBodyExtra extra_;
    
    private byte memoizedIsInitialized = -1;
    
    private PushProfileOuterClass.PushProfile profile_;
    
    private PushBody() {
      this.contents_ = "";
    }
    
    private PushBody(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        for (boolean bool = false; !bool; bool = true) {
          try {
            int i = param1CodedInputStream.readTag();
            if (i != 0) {
              if (i != 10) {
                PushProfileOuterClass.PushProfile.Builder builder1;
                PushBodyExtraOuterClass.PushBodyExtra.Builder builder3 = null;
                PushBodyExtraOuterClass.PushBodyExtra.Builder builder2 = null;
                if (i != 18) {
                  if (i != 26) {
                    if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i))
                      continue; 
                    continue;
                  } 
                  if (this.extra_ != null)
                    builder2 = this.extra_.toBuilder(); 
                  this.extra_ = (PushBodyExtraOuterClass.PushBodyExtra)param1CodedInputStream.readMessage(PushBodyExtraOuterClass.PushBodyExtra.parser(), param1ExtensionRegistryLite);
                  if (builder2 != null) {
                    builder2.mergeFrom(this.extra_);
                    this.extra_ = builder2.buildPartial();
                  } 
                  continue;
                } 
                builder2 = builder3;
                if (this.profile_ != null)
                  builder1 = this.profile_.toBuilder(); 
                this.profile_ = (PushProfileOuterClass.PushProfile)param1CodedInputStream.readMessage(PushProfileOuterClass.PushProfile.parser(), param1ExtensionRegistryLite);
                if (builder1 != null) {
                  builder1.mergeFrom(this.profile_);
                  this.profile_ = builder1.buildPartial();
                } 
                continue;
              } 
              this.contents_ = param1CodedInputStream.readStringRequireUtf8();
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
    
    private PushBody(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static PushBody getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return PushBodyOuterClass.internal_static_com_blued_im_private_chat_PushBody_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(PushBody param1PushBody) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1PushBody);
    }
    
    public static PushBody parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (PushBody)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static PushBody parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (PushBody)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static PushBody parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (PushBody)PARSER.parseFrom(param1ByteString);
    }
    
    public static PushBody parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (PushBody)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static PushBody parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (PushBody)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static PushBody parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (PushBody)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static PushBody parseFrom(InputStream param1InputStream) throws IOException {
      return (PushBody)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static PushBody parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (PushBody)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static PushBody parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (PushBody)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static PushBody parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (PushBody)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static PushBody parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (PushBody)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static PushBody parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (PushBody)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<PushBody> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof PushBody))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return !getContents().equals(param1Object.getContents()) ? false : ((hasProfile() != param1Object.hasProfile()) ? false : ((hasProfile() && !getProfile().equals(param1Object.getProfile())) ? false : ((hasExtra() != param1Object.hasExtra()) ? false : ((hasExtra() && !getExtra().equals(param1Object.getExtra())) ? false : (!!this.unknownFields.equals(((PushBody)param1Object).unknownFields))))));
    }
    
    public String getContents() {
      Object object = this.contents_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.contents_ = object;
      return (String)object;
    }
    
    public ByteString getContentsBytes() {
      Object object = this.contents_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.contents_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public PushBody getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public PushBodyExtraOuterClass.PushBodyExtra getExtra() {
      PushBodyExtraOuterClass.PushBodyExtra pushBodyExtra2 = this.extra_;
      PushBodyExtraOuterClass.PushBodyExtra pushBodyExtra1 = pushBodyExtra2;
      if (pushBodyExtra2 == null)
        pushBodyExtra1 = PushBodyExtraOuterClass.PushBodyExtra.getDefaultInstance(); 
      return pushBodyExtra1;
    }
    
    public PushBodyExtraOuterClass.PushBodyExtraOrBuilder getExtraOrBuilder() {
      return getExtra();
    }
    
    public Parser<PushBody> getParserForType() {
      return PARSER;
    }
    
    public PushProfileOuterClass.PushProfile getProfile() {
      PushProfileOuterClass.PushProfile pushProfile2 = this.profile_;
      PushProfileOuterClass.PushProfile pushProfile1 = pushProfile2;
      if (pushProfile2 == null)
        pushProfile1 = PushProfileOuterClass.PushProfile.getDefaultInstance(); 
      return pushProfile1;
    }
    
    public PushProfileOuterClass.PushProfileOrBuilder getProfileOrBuilder() {
      return getProfile();
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if (!getContentsBytes().isEmpty())
        j = 0 + GeneratedMessageV3.computeStringSize(1, this.contents_); 
      i = j;
      if (this.profile_ != null)
        i = j + CodedOutputStream.computeMessageSize(2, (MessageLite)getProfile()); 
      j = i;
      if (this.extra_ != null)
        j = i + CodedOutputStream.computeMessageSize(3, (MessageLite)getExtra()); 
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }
    
    public boolean hasExtra() {
      return (this.extra_ != null);
    }
    
    public boolean hasProfile() {
      return (this.profile_ != null);
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int j = ((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getContents().hashCode();
      int i = j;
      if (hasProfile())
        i = (j * 37 + 2) * 53 + getProfile().hashCode(); 
      j = i;
      if (hasExtra())
        j = (i * 37 + 3) * 53 + getExtra().hashCode(); 
      i = j * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return PushBodyOuterClass.internal_static_com_blued_im_private_chat_PushBody_fieldAccessorTable.ensureFieldAccessorsInitialized(PushBody.class, Builder.class);
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
      return new PushBody();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (!getContentsBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 1, this.contents_); 
      if (this.profile_ != null)
        param1CodedOutputStream.writeMessage(2, (MessageLite)getProfile()); 
      if (this.extra_ != null)
        param1CodedOutputStream.writeMessage(3, (MessageLite)getExtra()); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PushBodyOuterClass.PushBodyOrBuilder {
      private Object contents_ = "";
      
      private SingleFieldBuilderV3<PushBodyExtraOuterClass.PushBodyExtra, PushBodyExtraOuterClass.PushBodyExtra.Builder, PushBodyExtraOuterClass.PushBodyExtraOrBuilder> extraBuilder_;
      
      private PushBodyExtraOuterClass.PushBodyExtra extra_;
      
      private SingleFieldBuilderV3<PushProfileOuterClass.PushProfile, PushProfileOuterClass.PushProfile.Builder, PushProfileOuterClass.PushProfileOrBuilder> profileBuilder_;
      
      private PushProfileOuterClass.PushProfile profile_;
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return PushBodyOuterClass.internal_static_com_blued_im_private_chat_PushBody_descriptor;
      }
      
      private SingleFieldBuilderV3<PushBodyExtraOuterClass.PushBodyExtra, PushBodyExtraOuterClass.PushBodyExtra.Builder, PushBodyExtraOuterClass.PushBodyExtraOrBuilder> getExtraFieldBuilder() {
        if (this.extraBuilder_ == null) {
          this.extraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.extra_ = null;
        } 
        return this.extraBuilder_;
      }
      
      private SingleFieldBuilderV3<PushProfileOuterClass.PushProfile, PushProfileOuterClass.PushProfile.Builder, PushProfileOuterClass.PushProfileOrBuilder> getProfileFieldBuilder() {
        if (this.profileBuilder_ == null) {
          this.profileBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getProfile(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.profile_ = null;
        } 
        return this.profileBuilder_;
      }
      
      private void maybeForceBuilderInitialization() {
        PushBodyOuterClass.PushBody.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public PushBodyOuterClass.PushBody build() {
        PushBodyOuterClass.PushBody pushBody = buildPartial();
        if (pushBody.isInitialized())
          return pushBody; 
        throw newUninitializedMessageException(pushBody);
      }
      
      public PushBodyOuterClass.PushBody buildPartial() {
        PushBodyOuterClass.PushBody pushBody = new PushBodyOuterClass.PushBody(this);
        PushBodyOuterClass.PushBody.access$602(pushBody, this.contents_);
        SingleFieldBuilderV3<PushProfileOuterClass.PushProfile, PushProfileOuterClass.PushProfile.Builder, PushProfileOuterClass.PushProfileOrBuilder> singleFieldBuilderV31 = this.profileBuilder_;
        if (singleFieldBuilderV31 == null) {
          PushBodyOuterClass.PushBody.access$702(pushBody, this.profile_);
        } else {
          PushBodyOuterClass.PushBody.access$702(pushBody, (PushProfileOuterClass.PushProfile)singleFieldBuilderV31.build());
        } 
        SingleFieldBuilderV3<PushBodyExtraOuterClass.PushBodyExtra, PushBodyExtraOuterClass.PushBodyExtra.Builder, PushBodyExtraOuterClass.PushBodyExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
        if (singleFieldBuilderV3 == null) {
          PushBodyOuterClass.PushBody.access$802(pushBody, this.extra_);
        } else {
          PushBodyOuterClass.PushBody.access$802(pushBody, (PushBodyExtraOuterClass.PushBodyExtra)singleFieldBuilderV3.build());
        } 
        onBuilt();
        return pushBody;
      }
      
      public Builder clear() {
        super.clear();
        this.contents_ = "";
        if (this.profileBuilder_ == null) {
          this.profile_ = null;
        } else {
          this.profile_ = null;
          this.profileBuilder_ = null;
        } 
        if (this.extraBuilder_ == null) {
          this.extra_ = null;
          return this;
        } 
        this.extra_ = null;
        this.extraBuilder_ = null;
        return this;
      }
      
      public Builder clearContents() {
        this.contents_ = PushBodyOuterClass.PushBody.getDefaultInstance().getContents();
        onChanged();
        return this;
      }
      
      public Builder clearExtra() {
        if (this.extraBuilder_ == null) {
          this.extra_ = null;
          onChanged();
          return this;
        } 
        this.extra_ = null;
        this.extraBuilder_ = null;
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearProfile() {
        if (this.profileBuilder_ == null) {
          this.profile_ = null;
          onChanged();
          return this;
        } 
        this.profile_ = null;
        this.profileBuilder_ = null;
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public String getContents() {
        Object object = this.contents_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.contents_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getContentsBytes() {
        Object object = this.contents_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.contents_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public PushBodyOuterClass.PushBody getDefaultInstanceForType() {
        return PushBodyOuterClass.PushBody.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return PushBodyOuterClass.internal_static_com_blued_im_private_chat_PushBody_descriptor;
      }
      
      public PushBodyExtraOuterClass.PushBodyExtra getExtra() {
        PushBodyExtraOuterClass.PushBodyExtra pushBodyExtra;
        SingleFieldBuilderV3<PushBodyExtraOuterClass.PushBodyExtra, PushBodyExtraOuterClass.PushBodyExtra.Builder, PushBodyExtraOuterClass.PushBodyExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
        if (singleFieldBuilderV3 == null) {
          PushBodyExtraOuterClass.PushBodyExtra pushBodyExtra1 = this.extra_;
          pushBodyExtra = pushBodyExtra1;
          if (pushBodyExtra1 == null)
            pushBodyExtra = PushBodyExtraOuterClass.PushBodyExtra.getDefaultInstance(); 
          return pushBodyExtra;
        } 
        return (PushBodyExtraOuterClass.PushBodyExtra)pushBodyExtra.getMessage();
      }
      
      public PushBodyExtraOuterClass.PushBodyExtra.Builder getExtraBuilder() {
        onChanged();
        return (PushBodyExtraOuterClass.PushBodyExtra.Builder)getExtraFieldBuilder().getBuilder();
      }
      
      public PushBodyExtraOuterClass.PushBodyExtraOrBuilder getExtraOrBuilder() {
        SingleFieldBuilderV3<PushBodyExtraOuterClass.PushBodyExtra, PushBodyExtraOuterClass.PushBodyExtra.Builder, PushBodyExtraOuterClass.PushBodyExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
        if (singleFieldBuilderV3 != null)
          return (PushBodyExtraOuterClass.PushBodyExtraOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
        PushBodyExtraOuterClass.PushBodyExtra pushBodyExtra2 = this.extra_;
        PushBodyExtraOuterClass.PushBodyExtra pushBodyExtra1 = pushBodyExtra2;
        if (pushBodyExtra2 == null)
          pushBodyExtra1 = PushBodyExtraOuterClass.PushBodyExtra.getDefaultInstance(); 
        return pushBodyExtra1;
      }
      
      public PushProfileOuterClass.PushProfile getProfile() {
        PushProfileOuterClass.PushProfile pushProfile;
        SingleFieldBuilderV3<PushProfileOuterClass.PushProfile, PushProfileOuterClass.PushProfile.Builder, PushProfileOuterClass.PushProfileOrBuilder> singleFieldBuilderV3 = this.profileBuilder_;
        if (singleFieldBuilderV3 == null) {
          PushProfileOuterClass.PushProfile pushProfile1 = this.profile_;
          pushProfile = pushProfile1;
          if (pushProfile1 == null)
            pushProfile = PushProfileOuterClass.PushProfile.getDefaultInstance(); 
          return pushProfile;
        } 
        return (PushProfileOuterClass.PushProfile)pushProfile.getMessage();
      }
      
      public PushProfileOuterClass.PushProfile.Builder getProfileBuilder() {
        onChanged();
        return (PushProfileOuterClass.PushProfile.Builder)getProfileFieldBuilder().getBuilder();
      }
      
      public PushProfileOuterClass.PushProfileOrBuilder getProfileOrBuilder() {
        SingleFieldBuilderV3<PushProfileOuterClass.PushProfile, PushProfileOuterClass.PushProfile.Builder, PushProfileOuterClass.PushProfileOrBuilder> singleFieldBuilderV3 = this.profileBuilder_;
        if (singleFieldBuilderV3 != null)
          return (PushProfileOuterClass.PushProfileOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
        PushProfileOuterClass.PushProfile pushProfile2 = this.profile_;
        PushProfileOuterClass.PushProfile pushProfile1 = pushProfile2;
        if (pushProfile2 == null)
          pushProfile1 = PushProfileOuterClass.PushProfile.getDefaultInstance(); 
        return pushProfile1;
      }
      
      public boolean hasExtra() {
        return (this.extraBuilder_ != null || this.extra_ != null);
      }
      
      public boolean hasProfile() {
        return (this.profileBuilder_ != null || this.profile_ != null);
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return PushBodyOuterClass.internal_static_com_blued_im_private_chat_PushBody_fieldAccessorTable.ensureFieldAccessorsInitialized(PushBodyOuterClass.PushBody.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeExtra(PushBodyExtraOuterClass.PushBodyExtra param2PushBodyExtra) {
        PushBodyExtraOuterClass.PushBodyExtra pushBodyExtra;
        SingleFieldBuilderV3<PushBodyExtraOuterClass.PushBodyExtra, PushBodyExtraOuterClass.PushBodyExtra.Builder, PushBodyExtraOuterClass.PushBodyExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
        if (singleFieldBuilderV3 == null) {
          pushBodyExtra = this.extra_;
          if (pushBodyExtra != null) {
            this.extra_ = PushBodyExtraOuterClass.PushBodyExtra.newBuilder(pushBodyExtra).mergeFrom(param2PushBodyExtra).buildPartial();
          } else {
            this.extra_ = param2PushBodyExtra;
          } 
          onChanged();
          return this;
        } 
        pushBodyExtra.mergeFrom((AbstractMessage)param2PushBodyExtra);
        return this;
      }
      
      public Builder mergeFrom(PushBodyOuterClass.PushBody param2PushBody) {
        if (param2PushBody == PushBodyOuterClass.PushBody.getDefaultInstance())
          return this; 
        if (!param2PushBody.getContents().isEmpty()) {
          this.contents_ = param2PushBody.contents_;
          onChanged();
        } 
        if (param2PushBody.hasProfile())
          mergeProfile(param2PushBody.getProfile()); 
        if (param2PushBody.hasExtra())
          mergeExtra(param2PushBody.getExtra()); 
        mergeUnknownFields(param2PushBody.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          PushBodyOuterClass.PushBody pushBody = (PushBodyOuterClass.PushBody)PushBodyOuterClass.PushBody.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          PushBodyOuterClass.PushBody pushBody = (PushBodyOuterClass.PushBody)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((PushBodyOuterClass.PushBody)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof PushBodyOuterClass.PushBody)
          return mergeFrom((PushBodyOuterClass.PushBody)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public Builder mergeProfile(PushProfileOuterClass.PushProfile param2PushProfile) {
        PushProfileOuterClass.PushProfile pushProfile;
        SingleFieldBuilderV3<PushProfileOuterClass.PushProfile, PushProfileOuterClass.PushProfile.Builder, PushProfileOuterClass.PushProfileOrBuilder> singleFieldBuilderV3 = this.profileBuilder_;
        if (singleFieldBuilderV3 == null) {
          pushProfile = this.profile_;
          if (pushProfile != null) {
            this.profile_ = PushProfileOuterClass.PushProfile.newBuilder(pushProfile).mergeFrom(param2PushProfile).buildPartial();
          } else {
            this.profile_ = param2PushProfile;
          } 
          onChanged();
          return this;
        } 
        pushProfile.mergeFrom((AbstractMessage)param2PushProfile);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setContents(String param2String) {
        if (param2String != null) {
          this.contents_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setContentsBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          PushBodyOuterClass.PushBody.checkByteStringIsUtf8(param2ByteString);
          this.contents_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setExtra(PushBodyExtraOuterClass.PushBodyExtra.Builder param2Builder) {
        SingleFieldBuilderV3<PushBodyExtraOuterClass.PushBodyExtra, PushBodyExtraOuterClass.PushBodyExtra.Builder, PushBodyExtraOuterClass.PushBodyExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.extra_ = param2Builder.build();
          onChanged();
          return this;
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setExtra(PushBodyExtraOuterClass.PushBodyExtra param2PushBodyExtra) {
        SingleFieldBuilderV3<PushBodyExtraOuterClass.PushBodyExtra, PushBodyExtraOuterClass.PushBodyExtra.Builder, PushBodyExtraOuterClass.PushBodyExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (param2PushBodyExtra != null) {
            this.extra_ = param2PushBodyExtra;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2PushBodyExtra);
        return this;
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setProfile(PushProfileOuterClass.PushProfile.Builder param2Builder) {
        SingleFieldBuilderV3<PushProfileOuterClass.PushProfile, PushProfileOuterClass.PushProfile.Builder, PushProfileOuterClass.PushProfileOrBuilder> singleFieldBuilderV3 = this.profileBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.profile_ = param2Builder.build();
          onChanged();
          return this;
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setProfile(PushProfileOuterClass.PushProfile param2PushProfile) {
        SingleFieldBuilderV3<PushProfileOuterClass.PushProfile, PushProfileOuterClass.PushProfile.Builder, PushProfileOuterClass.PushProfileOrBuilder> singleFieldBuilderV3 = this.profileBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (param2PushProfile != null) {
            this.profile_ = param2PushProfile;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2PushProfile);
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
  
  static final class null extends AbstractParser<PushBody> {
    public PushBodyOuterClass.PushBody parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new PushBodyOuterClass.PushBody(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<PushBody.Builder> implements PushBodyOrBuilder {
    private Object contents_ = "";
    
    private SingleFieldBuilderV3<PushBodyExtraOuterClass.PushBodyExtra, PushBodyExtraOuterClass.PushBodyExtra.Builder, PushBodyExtraOuterClass.PushBodyExtraOrBuilder> extraBuilder_;
    
    private PushBodyExtraOuterClass.PushBodyExtra extra_;
    
    private SingleFieldBuilderV3<PushProfileOuterClass.PushProfile, PushProfileOuterClass.PushProfile.Builder, PushProfileOuterClass.PushProfileOrBuilder> profileBuilder_;
    
    private PushProfileOuterClass.PushProfile profile_;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return PushBodyOuterClass.internal_static_com_blued_im_private_chat_PushBody_descriptor;
    }
    
    private SingleFieldBuilderV3<PushBodyExtraOuterClass.PushBodyExtra, PushBodyExtraOuterClass.PushBodyExtra.Builder, PushBodyExtraOuterClass.PushBodyExtraOrBuilder> getExtraFieldBuilder() {
      if (this.extraBuilder_ == null) {
        this.extraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.extra_ = null;
      } 
      return this.extraBuilder_;
    }
    
    private SingleFieldBuilderV3<PushProfileOuterClass.PushProfile, PushProfileOuterClass.PushProfile.Builder, PushProfileOuterClass.PushProfileOrBuilder> getProfileFieldBuilder() {
      if (this.profileBuilder_ == null) {
        this.profileBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getProfile(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.profile_ = null;
      } 
      return this.profileBuilder_;
    }
    
    private void maybeForceBuilderInitialization() {
      PushBodyOuterClass.PushBody.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public PushBodyOuterClass.PushBody build() {
      PushBodyOuterClass.PushBody pushBody = buildPartial();
      if (pushBody.isInitialized())
        return pushBody; 
      throw newUninitializedMessageException(pushBody);
    }
    
    public PushBodyOuterClass.PushBody buildPartial() {
      PushBodyOuterClass.PushBody pushBody = new PushBodyOuterClass.PushBody(this);
      PushBodyOuterClass.PushBody.access$602(pushBody, this.contents_);
      SingleFieldBuilderV3<PushProfileOuterClass.PushProfile, PushProfileOuterClass.PushProfile.Builder, PushProfileOuterClass.PushProfileOrBuilder> singleFieldBuilderV31 = this.profileBuilder_;
      if (singleFieldBuilderV31 == null) {
        PushBodyOuterClass.PushBody.access$702(pushBody, this.profile_);
      } else {
        PushBodyOuterClass.PushBody.access$702(pushBody, (PushProfileOuterClass.PushProfile)singleFieldBuilderV31.build());
      } 
      SingleFieldBuilderV3<PushBodyExtraOuterClass.PushBodyExtra, PushBodyExtraOuterClass.PushBodyExtra.Builder, PushBodyExtraOuterClass.PushBodyExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
      if (singleFieldBuilderV3 == null) {
        PushBodyOuterClass.PushBody.access$802(pushBody, this.extra_);
      } else {
        PushBodyOuterClass.PushBody.access$802(pushBody, (PushBodyExtraOuterClass.PushBodyExtra)singleFieldBuilderV3.build());
      } 
      onBuilt();
      return pushBody;
    }
    
    public Builder clear() {
      super.clear();
      this.contents_ = "";
      if (this.profileBuilder_ == null) {
        this.profile_ = null;
      } else {
        this.profile_ = null;
        this.profileBuilder_ = null;
      } 
      if (this.extraBuilder_ == null) {
        this.extra_ = null;
        return this;
      } 
      this.extra_ = null;
      this.extraBuilder_ = null;
      return this;
    }
    
    public Builder clearContents() {
      this.contents_ = PushBodyOuterClass.PushBody.getDefaultInstance().getContents();
      onChanged();
      return this;
    }
    
    public Builder clearExtra() {
      if (this.extraBuilder_ == null) {
        this.extra_ = null;
        onChanged();
        return this;
      } 
      this.extra_ = null;
      this.extraBuilder_ = null;
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearProfile() {
      if (this.profileBuilder_ == null) {
        this.profile_ = null;
        onChanged();
        return this;
      } 
      this.profile_ = null;
      this.profileBuilder_ = null;
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public String getContents() {
      Object object = this.contents_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.contents_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getContentsBytes() {
      Object object = this.contents_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.contents_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public PushBodyOuterClass.PushBody getDefaultInstanceForType() {
      return PushBodyOuterClass.PushBody.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return PushBodyOuterClass.internal_static_com_blued_im_private_chat_PushBody_descriptor;
    }
    
    public PushBodyExtraOuterClass.PushBodyExtra getExtra() {
      PushBodyExtraOuterClass.PushBodyExtra pushBodyExtra;
      SingleFieldBuilderV3<PushBodyExtraOuterClass.PushBodyExtra, PushBodyExtraOuterClass.PushBodyExtra.Builder, PushBodyExtraOuterClass.PushBodyExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
      if (singleFieldBuilderV3 == null) {
        PushBodyExtraOuterClass.PushBodyExtra pushBodyExtra1 = this.extra_;
        pushBodyExtra = pushBodyExtra1;
        if (pushBodyExtra1 == null)
          pushBodyExtra = PushBodyExtraOuterClass.PushBodyExtra.getDefaultInstance(); 
        return pushBodyExtra;
      } 
      return (PushBodyExtraOuterClass.PushBodyExtra)pushBodyExtra.getMessage();
    }
    
    public PushBodyExtraOuterClass.PushBodyExtra.Builder getExtraBuilder() {
      onChanged();
      return (PushBodyExtraOuterClass.PushBodyExtra.Builder)getExtraFieldBuilder().getBuilder();
    }
    
    public PushBodyExtraOuterClass.PushBodyExtraOrBuilder getExtraOrBuilder() {
      SingleFieldBuilderV3<PushBodyExtraOuterClass.PushBodyExtra, PushBodyExtraOuterClass.PushBodyExtra.Builder, PushBodyExtraOuterClass.PushBodyExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
      if (singleFieldBuilderV3 != null)
        return (PushBodyExtraOuterClass.PushBodyExtraOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      PushBodyExtraOuterClass.PushBodyExtra pushBodyExtra2 = this.extra_;
      PushBodyExtraOuterClass.PushBodyExtra pushBodyExtra1 = pushBodyExtra2;
      if (pushBodyExtra2 == null)
        pushBodyExtra1 = PushBodyExtraOuterClass.PushBodyExtra.getDefaultInstance(); 
      return pushBodyExtra1;
    }
    
    public PushProfileOuterClass.PushProfile getProfile() {
      PushProfileOuterClass.PushProfile pushProfile;
      SingleFieldBuilderV3<PushProfileOuterClass.PushProfile, PushProfileOuterClass.PushProfile.Builder, PushProfileOuterClass.PushProfileOrBuilder> singleFieldBuilderV3 = this.profileBuilder_;
      if (singleFieldBuilderV3 == null) {
        PushProfileOuterClass.PushProfile pushProfile1 = this.profile_;
        pushProfile = pushProfile1;
        if (pushProfile1 == null)
          pushProfile = PushProfileOuterClass.PushProfile.getDefaultInstance(); 
        return pushProfile;
      } 
      return (PushProfileOuterClass.PushProfile)pushProfile.getMessage();
    }
    
    public PushProfileOuterClass.PushProfile.Builder getProfileBuilder() {
      onChanged();
      return (PushProfileOuterClass.PushProfile.Builder)getProfileFieldBuilder().getBuilder();
    }
    
    public PushProfileOuterClass.PushProfileOrBuilder getProfileOrBuilder() {
      SingleFieldBuilderV3<PushProfileOuterClass.PushProfile, PushProfileOuterClass.PushProfile.Builder, PushProfileOuterClass.PushProfileOrBuilder> singleFieldBuilderV3 = this.profileBuilder_;
      if (singleFieldBuilderV3 != null)
        return (PushProfileOuterClass.PushProfileOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      PushProfileOuterClass.PushProfile pushProfile2 = this.profile_;
      PushProfileOuterClass.PushProfile pushProfile1 = pushProfile2;
      if (pushProfile2 == null)
        pushProfile1 = PushProfileOuterClass.PushProfile.getDefaultInstance(); 
      return pushProfile1;
    }
    
    public boolean hasExtra() {
      return (this.extraBuilder_ != null || this.extra_ != null);
    }
    
    public boolean hasProfile() {
      return (this.profileBuilder_ != null || this.profile_ != null);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return PushBodyOuterClass.internal_static_com_blued_im_private_chat_PushBody_fieldAccessorTable.ensureFieldAccessorsInitialized(PushBodyOuterClass.PushBody.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeExtra(PushBodyExtraOuterClass.PushBodyExtra param1PushBodyExtra) {
      PushBodyExtraOuterClass.PushBodyExtra pushBodyExtra;
      SingleFieldBuilderV3<PushBodyExtraOuterClass.PushBodyExtra, PushBodyExtraOuterClass.PushBodyExtra.Builder, PushBodyExtraOuterClass.PushBodyExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
      if (singleFieldBuilderV3 == null) {
        pushBodyExtra = this.extra_;
        if (pushBodyExtra != null) {
          this.extra_ = PushBodyExtraOuterClass.PushBodyExtra.newBuilder(pushBodyExtra).mergeFrom(param1PushBodyExtra).buildPartial();
        } else {
          this.extra_ = param1PushBodyExtra;
        } 
        onChanged();
        return this;
      } 
      pushBodyExtra.mergeFrom((AbstractMessage)param1PushBodyExtra);
      return this;
    }
    
    public Builder mergeFrom(PushBodyOuterClass.PushBody param1PushBody) {
      if (param1PushBody == PushBodyOuterClass.PushBody.getDefaultInstance())
        return this; 
      if (!param1PushBody.getContents().isEmpty()) {
        this.contents_ = param1PushBody.contents_;
        onChanged();
      } 
      if (param1PushBody.hasProfile())
        mergeProfile(param1PushBody.getProfile()); 
      if (param1PushBody.hasExtra())
        mergeExtra(param1PushBody.getExtra()); 
      mergeUnknownFields(param1PushBody.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        PushBodyOuterClass.PushBody pushBody = (PushBodyOuterClass.PushBody)PushBodyOuterClass.PushBody.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        PushBodyOuterClass.PushBody pushBody = (PushBodyOuterClass.PushBody)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((PushBodyOuterClass.PushBody)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof PushBodyOuterClass.PushBody)
        return mergeFrom((PushBodyOuterClass.PushBody)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeProfile(PushProfileOuterClass.PushProfile param1PushProfile) {
      PushProfileOuterClass.PushProfile pushProfile;
      SingleFieldBuilderV3<PushProfileOuterClass.PushProfile, PushProfileOuterClass.PushProfile.Builder, PushProfileOuterClass.PushProfileOrBuilder> singleFieldBuilderV3 = this.profileBuilder_;
      if (singleFieldBuilderV3 == null) {
        pushProfile = this.profile_;
        if (pushProfile != null) {
          this.profile_ = PushProfileOuterClass.PushProfile.newBuilder(pushProfile).mergeFrom(param1PushProfile).buildPartial();
        } else {
          this.profile_ = param1PushProfile;
        } 
        onChanged();
        return this;
      } 
      pushProfile.mergeFrom((AbstractMessage)param1PushProfile);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setContents(String param1String) {
      if (param1String != null) {
        this.contents_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setContentsBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        PushBodyOuterClass.PushBody.checkByteStringIsUtf8(param1ByteString);
        this.contents_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setExtra(PushBodyExtraOuterClass.PushBodyExtra.Builder param1Builder) {
      SingleFieldBuilderV3<PushBodyExtraOuterClass.PushBodyExtra, PushBodyExtraOuterClass.PushBodyExtra.Builder, PushBodyExtraOuterClass.PushBodyExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.extra_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setExtra(PushBodyExtraOuterClass.PushBodyExtra param1PushBodyExtra) {
      SingleFieldBuilderV3<PushBodyExtraOuterClass.PushBodyExtra, PushBodyExtraOuterClass.PushBodyExtra.Builder, PushBodyExtraOuterClass.PushBodyExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1PushBodyExtra != null) {
          this.extra_ = param1PushBodyExtra;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1PushBodyExtra);
      return this;
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setProfile(PushProfileOuterClass.PushProfile.Builder param1Builder) {
      SingleFieldBuilderV3<PushProfileOuterClass.PushProfile, PushProfileOuterClass.PushProfile.Builder, PushProfileOuterClass.PushProfileOrBuilder> singleFieldBuilderV3 = this.profileBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.profile_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setProfile(PushProfileOuterClass.PushProfile param1PushProfile) {
      SingleFieldBuilderV3<PushProfileOuterClass.PushProfile, PushProfileOuterClass.PushProfile.Builder, PushProfileOuterClass.PushProfileOrBuilder> singleFieldBuilderV3 = this.profileBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1PushProfile != null) {
          this.profile_ = param1PushProfile;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1PushProfile);
      return this;
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
  
  public static interface PushBodyOrBuilder extends MessageOrBuilder {
    String getContents();
    
    ByteString getContentsBytes();
    
    PushBodyExtraOuterClass.PushBodyExtra getExtra();
    
    PushBodyExtraOuterClass.PushBodyExtraOrBuilder getExtraOrBuilder();
    
    PushProfileOuterClass.PushProfile getProfile();
    
    PushProfileOuterClass.PushProfileOrBuilder getProfileOrBuilder();
    
    boolean hasExtra();
    
    boolean hasProfile();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\im\private_chat\PushBodyOuterClass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */