package com.google.rpc;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Help extends GeneratedMessageV3 implements HelpOrBuilder {
  private static final Help DEFAULT_INSTANCE = new Help();
  
  public static final int LINKS_FIELD_NUMBER = 1;
  
  private static final Parser<Help> PARSER = (Parser<Help>)new AbstractParser<Help>() {
      public Help a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new Help(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  private static final long serialVersionUID = 0L;
  
  private List<Link> links_;
  
  private byte memoizedIsInitialized = -1;
  
  private Help() {
    this.links_ = Collections.emptyList();
  }
  
  private Help(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    this();
    if (paramExtensionRegistryLite != null) {
      UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
      boolean bool = false;
      int i = 0;
      while (!bool) {
        int j = i;
        int k = i;
        int m = i;
        try {
          int n = paramCodedInputStream.readTag();
          if (n != 0) {
            if (n != 10) {
              j = i;
              k = i;
              m = i;
              if (!parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, n))
                continue; 
              continue;
            } 
            n = i;
            if ((i & 0x1) == 0) {
              j = i;
              k = i;
              m = i;
              this.links_ = new ArrayList<Link>();
              n = i | 0x1;
            } 
            j = n;
            k = n;
            m = n;
            this.links_.add(paramCodedInputStream.readMessage(Link.parser(), paramExtensionRegistryLite));
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
          this.links_ = Collections.unmodifiableList(this.links_); 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        throw paramCodedInputStream;
        bool = true;
      } 
      if ((i & 0x1) != 0)
        this.links_ = Collections.unmodifiableList(this.links_); 
      this.unknownFields = builder.build();
      makeExtensionsImmutable();
      return;
    } 
    throw new NullPointerException();
  }
  
  private Help(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static Help getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return ErrorDetailsProto.u;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Help paramHelp) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramHelp);
  }
  
  public static Help parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Help)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static Help parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Help)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Help parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Help)PARSER.parseFrom(paramByteString);
  }
  
  public static Help parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Help)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Help parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Help)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static Help parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Help)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Help parseFrom(InputStream paramInputStream) throws IOException {
    return (Help)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static Help parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Help)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Help parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (Help)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static Help parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Help)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Help parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Help)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static Help parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Help)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Help> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof Help))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getLinksList().equals(paramObject.getLinksList()) ? false : (!!this.unknownFields.equals(((Help)paramObject).unknownFields));
  }
  
  public Help getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public Link getLinks(int paramInt) {
    return this.links_.get(paramInt);
  }
  
  public int getLinksCount() {
    return this.links_.size();
  }
  
  public List<Link> getLinksList() {
    return this.links_;
  }
  
  public LinkOrBuilder getLinksOrBuilder(int paramInt) {
    return this.links_.get(paramInt);
  }
  
  public List<? extends LinkOrBuilder> getLinksOrBuilderList() {
    return (List)this.links_;
  }
  
  public Parser<Help> getParserForType() {
    return PARSER;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    i = 0;
    int j = 0;
    while (i < this.links_.size()) {
      j += CodedOutputStream.computeMessageSize(1, (MessageLite)this.links_.get(i));
      i++;
    } 
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public final UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }
  
  public int hashCode() {
    if (this.memoizedHashCode != 0)
      return this.memoizedHashCode; 
    int j = 779 + getDescriptor().hashCode();
    int i = j;
    if (getLinksCount() > 0)
      i = (j * 37 + 1) * 53 + getLinksList().hashCode(); 
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return ErrorDetailsProto.v.ensureFieldAccessorsInitialized(Help.class, Builder.class);
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
  
  protected Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent) {
    return new Builder(paramBuilderParent);
  }
  
  public Builder toBuilder() {
    return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    for (int i = 0; i < this.links_.size(); i++)
      paramCodedOutputStream.writeMessage(1, (MessageLite)this.links_.get(i)); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HelpOrBuilder {
    private int bitField0_;
    
    private RepeatedFieldBuilderV3<Help.Link, Help.Link.Builder, Help.LinkOrBuilder> linksBuilder_;
    
    private List<Help.Link> links_ = Collections.emptyList();
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensureLinksIsMutable() {
      if ((this.bitField0_ & 0x1) == 0) {
        this.links_ = new ArrayList<Help.Link>(this.links_);
        this.bitField0_ |= 0x1;
      } 
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ErrorDetailsProto.u;
    }
    
    private RepeatedFieldBuilderV3<Help.Link, Help.Link.Builder, Help.LinkOrBuilder> getLinksFieldBuilder() {
      if (this.linksBuilder_ == null) {
        List<Help.Link> list = this.links_;
        int i = this.bitField0_;
        boolean bool = true;
        if ((i & 0x1) == 0)
          bool = false; 
        this.linksBuilder_ = new RepeatedFieldBuilderV3(list, bool, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.links_ = null;
      } 
      return this.linksBuilder_;
    }
    
    private void maybeForceBuilderInitialization() {
      if (Help.alwaysUseFieldBuilders)
        getLinksFieldBuilder(); 
    }
    
    public Builder addAllLinks(Iterable<? extends Help.Link> param1Iterable) {
      RepeatedFieldBuilderV3<Help.Link, Help.Link.Builder, Help.LinkOrBuilder> repeatedFieldBuilderV3 = this.linksBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureLinksIsMutable();
        AbstractMessageLite.Builder.addAll(param1Iterable, this.links_);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addAllMessages(param1Iterable);
      return this;
    }
    
    public Builder addLinks(int param1Int, Help.Link.Builder param1Builder) {
      RepeatedFieldBuilderV3<Help.Link, Help.Link.Builder, Help.LinkOrBuilder> repeatedFieldBuilderV3 = this.linksBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureLinksIsMutable();
        this.links_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addLinks(int param1Int, Help.Link param1Link) {
      RepeatedFieldBuilderV3<Help.Link, Help.Link.Builder, Help.LinkOrBuilder> repeatedFieldBuilderV3 = this.linksBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Link != null) {
          ensureLinksIsMutable();
          this.links_.add(param1Int, param1Link);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Link);
      return this;
    }
    
    public Builder addLinks(Help.Link.Builder param1Builder) {
      RepeatedFieldBuilderV3<Help.Link, Help.Link.Builder, Help.LinkOrBuilder> repeatedFieldBuilderV3 = this.linksBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureLinksIsMutable();
        this.links_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addLinks(Help.Link param1Link) {
      RepeatedFieldBuilderV3<Help.Link, Help.Link.Builder, Help.LinkOrBuilder> repeatedFieldBuilderV3 = this.linksBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Link != null) {
          ensureLinksIsMutable();
          this.links_.add(param1Link);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Link);
      return this;
    }
    
    public Help.Link.Builder addLinksBuilder() {
      return (Help.Link.Builder)getLinksFieldBuilder().addBuilder((AbstractMessage)Help.Link.getDefaultInstance());
    }
    
    public Help.Link.Builder addLinksBuilder(int param1Int) {
      return (Help.Link.Builder)getLinksFieldBuilder().addBuilder(param1Int, (AbstractMessage)Help.Link.getDefaultInstance());
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public Help build() {
      Help help = buildPartial();
      if (help.isInitialized())
        return help; 
      throw newUninitializedMessageException(help);
    }
    
    public Help buildPartial() {
      Help help = new Help(this);
      int i = this.bitField0_;
      RepeatedFieldBuilderV3<Help.Link, Help.Link.Builder, Help.LinkOrBuilder> repeatedFieldBuilderV3 = this.linksBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if ((i & 0x1) != 0) {
          this.links_ = Collections.unmodifiableList(this.links_);
          this.bitField0_ &= 0xFFFFFFFE;
        } 
        Help.access$1502(help, this.links_);
      } else {
        Help.access$1502(help, repeatedFieldBuilderV3.build());
      } 
      onBuilt();
      return help;
    }
    
    public Builder clear() {
      super.clear();
      RepeatedFieldBuilderV3<Help.Link, Help.Link.Builder, Help.LinkOrBuilder> repeatedFieldBuilderV3 = this.linksBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.links_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFE;
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearLinks() {
      RepeatedFieldBuilderV3<Help.Link, Help.Link.Builder, Help.LinkOrBuilder> repeatedFieldBuilderV3 = this.linksBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.links_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFE;
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public Help getDefaultInstanceForType() {
      return Help.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return ErrorDetailsProto.u;
    }
    
    public Help.Link getLinks(int param1Int) {
      RepeatedFieldBuilderV3<Help.Link, Help.Link.Builder, Help.LinkOrBuilder> repeatedFieldBuilderV3 = this.linksBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.links_.get(param1Int) : (Help.Link)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public Help.Link.Builder getLinksBuilder(int param1Int) {
      return (Help.Link.Builder)getLinksFieldBuilder().getBuilder(param1Int);
    }
    
    public List<Help.Link.Builder> getLinksBuilderList() {
      return getLinksFieldBuilder().getBuilderList();
    }
    
    public int getLinksCount() {
      RepeatedFieldBuilderV3<Help.Link, Help.Link.Builder, Help.LinkOrBuilder> repeatedFieldBuilderV3 = this.linksBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.links_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<Help.Link> getLinksList() {
      RepeatedFieldBuilderV3<Help.Link, Help.Link.Builder, Help.LinkOrBuilder> repeatedFieldBuilderV3 = this.linksBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.links_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public Help.LinkOrBuilder getLinksOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<Help.Link, Help.Link.Builder, Help.LinkOrBuilder> repeatedFieldBuilderV3 = this.linksBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.links_.get(param1Int) : (Help.LinkOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends Help.LinkOrBuilder> getLinksOrBuilderList() {
      RepeatedFieldBuilderV3<Help.Link, Help.Link.Builder, Help.LinkOrBuilder> repeatedFieldBuilderV3 = this.linksBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList((List)this.links_);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ErrorDetailsProto.v.ensureFieldAccessorsInitialized(Help.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        Help help = (Help)Help.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        Help help = (Help)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((Help)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof Help)
        return mergeFrom((Help)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeFrom(Help param1Help) {
      if (param1Help == Help.getDefaultInstance())
        return this; 
      if (this.linksBuilder_ == null) {
        if (!param1Help.links_.isEmpty()) {
          if (this.links_.isEmpty()) {
            this.links_ = param1Help.links_;
            this.bitField0_ &= 0xFFFFFFFE;
          } else {
            ensureLinksIsMutable();
            this.links_.addAll(param1Help.links_);
          } 
          onChanged();
        } 
      } else if (!param1Help.links_.isEmpty()) {
        if (this.linksBuilder_.isEmpty()) {
          this.linksBuilder_.dispose();
          RepeatedFieldBuilderV3<Help.Link, Help.Link.Builder, Help.LinkOrBuilder> repeatedFieldBuilderV3 = null;
          this.linksBuilder_ = null;
          this.links_ = param1Help.links_;
          this.bitField0_ &= 0xFFFFFFFE;
          if (Help.alwaysUseFieldBuilders)
            repeatedFieldBuilderV3 = getLinksFieldBuilder(); 
          this.linksBuilder_ = repeatedFieldBuilderV3;
        } else {
          this.linksBuilder_.addAllMessages(param1Help.links_);
        } 
      } 
      mergeUnknownFields(param1Help.unknownFields);
      onChanged();
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder removeLinks(int param1Int) {
      RepeatedFieldBuilderV3<Help.Link, Help.Link.Builder, Help.LinkOrBuilder> repeatedFieldBuilderV3 = this.linksBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureLinksIsMutable();
        this.links_.remove(param1Int);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.remove(param1Int);
      return this;
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setLinks(int param1Int, Help.Link.Builder param1Builder) {
      RepeatedFieldBuilderV3<Help.Link, Help.Link.Builder, Help.LinkOrBuilder> repeatedFieldBuilderV3 = this.linksBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureLinksIsMutable();
        this.links_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setLinks(int param1Int, Help.Link param1Link) {
      RepeatedFieldBuilderV3<Help.Link, Help.Link.Builder, Help.LinkOrBuilder> repeatedFieldBuilderV3 = this.linksBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Link != null) {
          ensureLinksIsMutable();
          this.links_.set(param1Int, param1Link);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Link);
      return this;
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
  
  public static final class Link extends GeneratedMessageV3 implements LinkOrBuilder {
    private static final Link DEFAULT_INSTANCE = new Link();
    
    public static final int DESCRIPTION_FIELD_NUMBER = 1;
    
    private static final Parser<Link> PARSER = (Parser<Link>)new AbstractParser<Link>() {
        public Help.Link a(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new Help.Link(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int URL_FIELD_NUMBER = 2;
    
    private static final long serialVersionUID = 0L;
    
    private volatile Object description_;
    
    private byte memoizedIsInitialized = -1;
    
    private volatile Object url_;
    
    private Link() {
      this.description_ = "";
      this.url_ = "";
    }
    
    private Link(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        for (boolean bool = false; !bool; bool = true) {
          try {
            int i = param1CodedInputStream.readTag();
            if (i != 0) {
              if (i != 10) {
                if (i != 18) {
                  if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i))
                    continue; 
                  continue;
                } 
                this.url_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              } 
              this.description_ = param1CodedInputStream.readStringRequireUtf8();
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
    
    private Link(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static Link getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ErrorDetailsProto.w;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(Link param1Link) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1Link);
    }
    
    public static Link parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (Link)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static Link parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Link)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Link parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (Link)PARSER.parseFrom(param1ByteString);
    }
    
    public static Link parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Link)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static Link parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (Link)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static Link parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Link)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static Link parseFrom(InputStream param1InputStream) throws IOException {
      return (Link)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static Link parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Link)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Link parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (Link)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static Link parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Link)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static Link parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (Link)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static Link parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Link)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<Link> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof Link))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return !getDescription().equals(param1Object.getDescription()) ? false : (!getUrl().equals(param1Object.getUrl()) ? false : (!!this.unknownFields.equals(((Link)param1Object).unknownFields)));
    }
    
    public Link getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public String getDescription() {
      Object object = this.description_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.description_ = object;
      return (String)object;
    }
    
    public ByteString getDescriptionBytes() {
      Object object = this.description_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.description_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public Parser<Link> getParserForType() {
      return PARSER;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      i = 0;
      if (!getDescriptionBytes().isEmpty())
        i = 0 + GeneratedMessageV3.computeStringSize(1, this.description_); 
      int j = i;
      if (!getUrlBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(2, this.url_); 
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }
    
    public String getUrl() {
      Object object = this.url_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.url_ = object;
      return (String)object;
    }
    
    public ByteString getUrlBytes() {
      Object object = this.url_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.url_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int i = (((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getDescription().hashCode()) * 37 + 2) * 53 + getUrl().hashCode()) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ErrorDetailsProto.x.ensureFieldAccessorsInitialized(Link.class, Builder.class);
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
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (!getDescriptionBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 1, this.description_); 
      if (!getUrlBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 2, this.url_); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Help.LinkOrBuilder {
      private Object description_ = "";
      
      private Object url_ = "";
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return ErrorDetailsProto.w;
      }
      
      private void maybeForceBuilderInitialization() {
        Help.Link.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public Help.Link build() {
        Help.Link link = buildPartial();
        if (link.isInitialized())
          return link; 
        throw newUninitializedMessageException(link);
      }
      
      public Help.Link buildPartial() {
        Help.Link link = new Help.Link(this);
        Help.Link.access$402(link, this.description_);
        Help.Link.access$502(link, this.url_);
        onBuilt();
        return link;
      }
      
      public Builder clear() {
        super.clear();
        this.description_ = "";
        this.url_ = "";
        return this;
      }
      
      public Builder clearDescription() {
        this.description_ = Help.Link.getDefaultInstance().getDescription();
        onChanged();
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearUrl() {
        this.url_ = Help.Link.getDefaultInstance().getUrl();
        onChanged();
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public Help.Link getDefaultInstanceForType() {
        return Help.Link.getDefaultInstance();
      }
      
      public String getDescription() {
        Object object = this.description_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.description_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getDescriptionBytes() {
        Object object = this.description_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.description_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return ErrorDetailsProto.w;
      }
      
      public String getUrl() {
        Object object = this.url_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.url_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getUrlBytes() {
        Object object = this.url_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.url_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return ErrorDetailsProto.x.ensureFieldAccessorsInitialized(Help.Link.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          Help.Link link = (Help.Link)Help.Link.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          Help.Link link = (Help.Link)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((Help.Link)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof Help.Link)
          return mergeFrom((Help.Link)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public Builder mergeFrom(Help.Link param2Link) {
        if (param2Link == Help.Link.getDefaultInstance())
          return this; 
        if (!param2Link.getDescription().isEmpty()) {
          this.description_ = param2Link.description_;
          onChanged();
        } 
        if (!param2Link.getUrl().isEmpty()) {
          this.url_ = param2Link.url_;
          onChanged();
        } 
        mergeUnknownFields(param2Link.unknownFields);
        onChanged();
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setDescription(String param2String) {
        if (param2String != null) {
          this.description_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setDescriptionBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          Help.Link.checkByteStringIsUtf8(param2ByteString);
          this.description_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public final Builder setUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setUrl(String param2String) {
        if (param2String != null) {
          this.url_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setUrlBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          Help.Link.checkByteStringIsUtf8(param2ByteString);
          this.url_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
    }
  }
  
  static final class null extends AbstractParser<Link> {
    public Help.Link a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new Help.Link(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Link.Builder> implements LinkOrBuilder {
    private Object description_ = "";
    
    private Object url_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ErrorDetailsProto.w;
    }
    
    private void maybeForceBuilderInitialization() {
      Help.Link.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public Help.Link build() {
      Help.Link link = buildPartial();
      if (link.isInitialized())
        return link; 
      throw newUninitializedMessageException(link);
    }
    
    public Help.Link buildPartial() {
      Help.Link link = new Help.Link(this);
      Help.Link.access$402(link, this.description_);
      Help.Link.access$502(link, this.url_);
      onBuilt();
      return link;
    }
    
    public Builder clear() {
      super.clear();
      this.description_ = "";
      this.url_ = "";
      return this;
    }
    
    public Builder clearDescription() {
      this.description_ = Help.Link.getDefaultInstance().getDescription();
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearUrl() {
      this.url_ = Help.Link.getDefaultInstance().getUrl();
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public Help.Link getDefaultInstanceForType() {
      return Help.Link.getDefaultInstance();
    }
    
    public String getDescription() {
      Object object = this.description_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.description_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getDescriptionBytes() {
      Object object = this.description_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.description_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return ErrorDetailsProto.w;
    }
    
    public String getUrl() {
      Object object = this.url_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.url_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getUrlBytes() {
      Object object = this.url_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.url_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ErrorDetailsProto.x.ensureFieldAccessorsInitialized(Help.Link.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        Help.Link link = (Help.Link)Help.Link.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        Help.Link link = (Help.Link)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((Help.Link)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof Help.Link)
        return mergeFrom((Help.Link)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeFrom(Help.Link param1Link) {
      if (param1Link == Help.Link.getDefaultInstance())
        return this; 
      if (!param1Link.getDescription().isEmpty()) {
        this.description_ = param1Link.description_;
        onChanged();
      } 
      if (!param1Link.getUrl().isEmpty()) {
        this.url_ = param1Link.url_;
        onChanged();
      } 
      mergeUnknownFields(param1Link.unknownFields);
      onChanged();
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setDescription(String param1String) {
      if (param1String != null) {
        this.description_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setDescriptionBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        Help.Link.checkByteStringIsUtf8(param1ByteString);
        this.description_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setUrl(String param1String) {
      if (param1String != null) {
        this.url_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setUrlBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        Help.Link.checkByteStringIsUtf8(param1ByteString);
        this.url_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
  }
  
  public static interface LinkOrBuilder extends MessageOrBuilder {
    String getDescription();
    
    ByteString getDescriptionBytes();
    
    String getUrl();
    
    ByteString getUrlBytes();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\rpc\Help.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */