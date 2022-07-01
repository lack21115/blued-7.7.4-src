package com.google.api;

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
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Page extends GeneratedMessageV3 implements PageOrBuilder {
  public static final int CONTENT_FIELD_NUMBER = 2;
  
  private static final Page DEFAULT_INSTANCE = new Page();
  
  public static final int NAME_FIELD_NUMBER = 1;
  
  private static final Parser<Page> PARSER = (Parser<Page>)new AbstractParser<Page>() {
      public Page a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new Page(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int SUBPAGES_FIELD_NUMBER = 3;
  
  private static final long serialVersionUID = 0L;
  
  private int bitField0_;
  
  private volatile Object content_;
  
  private byte memoizedIsInitialized = -1;
  
  private volatile Object name_;
  
  private List<Page> subpages_;
  
  private Page() {
    this.name_ = "";
    this.content_ = "";
    this.subpages_ = Collections.emptyList();
  }
  
  private Page(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
              if (n != 18) {
                if (n != 26) {
                  j = i;
                  k = i;
                  m = i;
                  if (!parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, n))
                    continue; 
                  continue;
                } 
                n = i;
                if ((i & 0x4) == 0) {
                  j = i;
                  k = i;
                  m = i;
                  this.subpages_ = new ArrayList<Page>();
                  n = i | 0x4;
                } 
                j = n;
                k = n;
                m = n;
                this.subpages_.add(paramCodedInputStream.readMessage(parser(), paramExtensionRegistryLite));
                i = n;
                continue;
              } 
              j = i;
              k = i;
              m = i;
              this.content_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            } 
            j = i;
            k = i;
            m = i;
            this.name_ = paramCodedInputStream.readStringRequireUtf8();
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
          this.subpages_ = Collections.unmodifiableList(this.subpages_); 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        throw paramCodedInputStream;
        bool = true;
      } 
      if ((i & 0x4) != 0)
        this.subpages_ = Collections.unmodifiableList(this.subpages_); 
      this.unknownFields = builder.build();
      makeExtensionsImmutable();
      return;
    } 
    throw new NullPointerException();
  }
  
  private Page(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static Page getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return DocumentationProto.e;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Page paramPage) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramPage);
  }
  
  public static Page parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Page)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static Page parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Page)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Page parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Page)PARSER.parseFrom(paramByteString);
  }
  
  public static Page parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Page)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Page parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Page)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static Page parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Page)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Page parseFrom(InputStream paramInputStream) throws IOException {
    return (Page)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static Page parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Page)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Page parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (Page)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static Page parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Page)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Page parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Page)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static Page parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Page)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Page> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof Page))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getName().equals(paramObject.getName()) ? false : (!getContent().equals(paramObject.getContent()) ? false : (!getSubpagesList().equals(paramObject.getSubpagesList()) ? false : (!!this.unknownFields.equals(((Page)paramObject).unknownFields))));
  }
  
  public String getContent() {
    Object object = this.content_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.content_ = object;
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
  
  public Page getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public String getName() {
    Object object = this.name_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.name_ = object;
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
  
  public Parser<Page> getParserForType() {
    return PARSER;
  }
  
  public int getSerializedSize() {
    byte b1;
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    boolean bool = getNameBytes().isEmpty();
    byte b2 = 0;
    if (!bool) {
      b1 = GeneratedMessageV3.computeStringSize(1, this.name_) + 0;
    } else {
      b1 = 0;
    } 
    i = b1;
    int j = b2;
    if (!getContentBytes().isEmpty()) {
      i = b1 + GeneratedMessageV3.computeStringSize(2, this.content_);
      j = b2;
    } 
    while (j < this.subpages_.size()) {
      i += CodedOutputStream.computeMessageSize(3, (MessageLite)this.subpages_.get(j));
      j++;
    } 
    i += this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public Page getSubpages(int paramInt) {
    return this.subpages_.get(paramInt);
  }
  
  public int getSubpagesCount() {
    return this.subpages_.size();
  }
  
  public List<Page> getSubpagesList() {
    return this.subpages_;
  }
  
  public PageOrBuilder getSubpagesOrBuilder(int paramInt) {
    return this.subpages_.get(paramInt);
  }
  
  public List<? extends PageOrBuilder> getSubpagesOrBuilderList() {
    return (List)this.subpages_;
  }
  
  public final UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }
  
  public int hashCode() {
    if (this.memoizedHashCode != 0)
      return this.memoizedHashCode; 
    int j = ((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getName().hashCode()) * 37 + 2) * 53 + getContent().hashCode();
    int i = j;
    if (getSubpagesCount() > 0)
      i = (j * 37 + 3) * 53 + getSubpagesList().hashCode(); 
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return DocumentationProto.f.ensureFieldAccessorsInitialized(Page.class, Builder.class);
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
    if (!getNameBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.name_); 
    if (!getContentBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 2, this.content_); 
    for (int i = 0; i < this.subpages_.size(); i++)
      paramCodedOutputStream.writeMessage(3, (MessageLite)this.subpages_.get(i)); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PageOrBuilder {
    private int bitField0_;
    
    private Object content_ = "";
    
    private Object name_ = "";
    
    private RepeatedFieldBuilderV3<Page, Builder, PageOrBuilder> subpagesBuilder_;
    
    private List<Page> subpages_ = Collections.emptyList();
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensureSubpagesIsMutable() {
      if ((this.bitField0_ & 0x4) == 0) {
        this.subpages_ = new ArrayList<Page>(this.subpages_);
        this.bitField0_ |= 0x4;
      } 
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return DocumentationProto.e;
    }
    
    private RepeatedFieldBuilderV3<Page, Builder, PageOrBuilder> getSubpagesFieldBuilder() {
      if (this.subpagesBuilder_ == null) {
        boolean bool;
        List<Page> list = this.subpages_;
        if ((this.bitField0_ & 0x4) != 0) {
          bool = true;
        } else {
          bool = false;
        } 
        this.subpagesBuilder_ = new RepeatedFieldBuilderV3(list, bool, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.subpages_ = null;
      } 
      return this.subpagesBuilder_;
    }
    
    private void maybeForceBuilderInitialization() {
      if (Page.alwaysUseFieldBuilders)
        getSubpagesFieldBuilder(); 
    }
    
    public Builder addAllSubpages(Iterable<? extends Page> param1Iterable) {
      RepeatedFieldBuilderV3<Page, Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.subpagesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureSubpagesIsMutable();
        AbstractMessageLite.Builder.addAll(param1Iterable, this.subpages_);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addAllMessages(param1Iterable);
      return this;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public Builder addSubpages(int param1Int, Builder param1Builder) {
      RepeatedFieldBuilderV3<Page, Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.subpagesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureSubpagesIsMutable();
        this.subpages_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addSubpages(int param1Int, Page param1Page) {
      RepeatedFieldBuilderV3<Page, Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.subpagesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Page != null) {
          ensureSubpagesIsMutable();
          this.subpages_.add(param1Int, param1Page);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Page);
      return this;
    }
    
    public Builder addSubpages(Builder param1Builder) {
      RepeatedFieldBuilderV3<Page, Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.subpagesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureSubpagesIsMutable();
        this.subpages_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addSubpages(Page param1Page) {
      RepeatedFieldBuilderV3<Page, Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.subpagesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Page != null) {
          ensureSubpagesIsMutable();
          this.subpages_.add(param1Page);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Page);
      return this;
    }
    
    public Builder addSubpagesBuilder() {
      return (Builder)getSubpagesFieldBuilder().addBuilder((AbstractMessage)Page.getDefaultInstance());
    }
    
    public Builder addSubpagesBuilder(int param1Int) {
      return (Builder)getSubpagesFieldBuilder().addBuilder(param1Int, (AbstractMessage)Page.getDefaultInstance());
    }
    
    public Page build() {
      Page page = buildPartial();
      if (page.isInitialized())
        return page; 
      throw newUninitializedMessageException(page);
    }
    
    public Page buildPartial() {
      Page page = new Page(this);
      int i = this.bitField0_;
      Page.access$402(page, this.name_);
      Page.access$502(page, this.content_);
      RepeatedFieldBuilderV3<Page, Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.subpagesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if ((this.bitField0_ & 0x4) != 0) {
          this.subpages_ = Collections.unmodifiableList(this.subpages_);
          this.bitField0_ &= 0xFFFFFFFB;
        } 
        Page.access$602(page, this.subpages_);
      } else {
        Page.access$602(page, repeatedFieldBuilderV3.build());
      } 
      Page.access$702(page, 0);
      onBuilt();
      return page;
    }
    
    public Builder clear() {
      super.clear();
      this.name_ = "";
      this.content_ = "";
      RepeatedFieldBuilderV3<Page, Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.subpagesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.subpages_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFB;
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clearContent() {
      this.content_ = Page.getDefaultInstance().getContent();
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearName() {
      this.name_ = Page.getDefaultInstance().getName();
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearSubpages() {
      RepeatedFieldBuilderV3<Page, Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.subpagesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.subpages_ = Collections.emptyList();
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
    
    public String getContent() {
      Object object = this.content_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.content_ = object;
        return (String)object;
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
    
    public Page getDefaultInstanceForType() {
      return Page.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return DocumentationProto.e;
    }
    
    public String getName() {
      Object object = this.name_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.name_ = object;
        return (String)object;
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
    
    public Page getSubpages(int param1Int) {
      RepeatedFieldBuilderV3<Page, Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.subpagesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.subpages_.get(param1Int) : (Page)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public Builder getSubpagesBuilder(int param1Int) {
      return (Builder)getSubpagesFieldBuilder().getBuilder(param1Int);
    }
    
    public List<Builder> getSubpagesBuilderList() {
      return getSubpagesFieldBuilder().getBuilderList();
    }
    
    public int getSubpagesCount() {
      RepeatedFieldBuilderV3<Page, Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.subpagesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.subpages_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<Page> getSubpagesList() {
      RepeatedFieldBuilderV3<Page, Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.subpagesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.subpages_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public PageOrBuilder getSubpagesOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<Page, Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.subpagesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.subpages_.get(param1Int) : (PageOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends PageOrBuilder> getSubpagesOrBuilderList() {
      RepeatedFieldBuilderV3<Page, Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.subpagesBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList((List)this.subpages_);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return DocumentationProto.f.ensureFieldAccessorsInitialized(Page.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(Page param1Page) {
      if (param1Page == Page.getDefaultInstance())
        return this; 
      if (!param1Page.getName().isEmpty()) {
        this.name_ = param1Page.name_;
        onChanged();
      } 
      if (!param1Page.getContent().isEmpty()) {
        this.content_ = param1Page.content_;
        onChanged();
      } 
      if (this.subpagesBuilder_ == null) {
        if (!param1Page.subpages_.isEmpty()) {
          if (this.subpages_.isEmpty()) {
            this.subpages_ = param1Page.subpages_;
            this.bitField0_ &= 0xFFFFFFFB;
          } else {
            ensureSubpagesIsMutable();
            this.subpages_.addAll(param1Page.subpages_);
          } 
          onChanged();
        } 
      } else if (!param1Page.subpages_.isEmpty()) {
        if (this.subpagesBuilder_.isEmpty()) {
          this.subpagesBuilder_.dispose();
          RepeatedFieldBuilderV3<Page, Builder, PageOrBuilder> repeatedFieldBuilderV3 = null;
          this.subpagesBuilder_ = null;
          this.subpages_ = param1Page.subpages_;
          this.bitField0_ &= 0xFFFFFFFB;
          if (Page.alwaysUseFieldBuilders)
            repeatedFieldBuilderV3 = getSubpagesFieldBuilder(); 
          this.subpagesBuilder_ = repeatedFieldBuilderV3;
        } else {
          this.subpagesBuilder_.addAllMessages(param1Page.subpages_);
        } 
      } 
      mergeUnknownFields(param1Page.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        Page page = (Page)Page.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        Page page = (Page)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((Page)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof Page)
        return mergeFrom((Page)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder removeSubpages(int param1Int) {
      RepeatedFieldBuilderV3<Page, Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.subpagesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureSubpagesIsMutable();
        this.subpages_.remove(param1Int);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.remove(param1Int);
      return this;
    }
    
    public Builder setContent(String param1String) {
      if (param1String != null) {
        this.content_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setContentBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        Page.checkByteStringIsUtf8(param1ByteString);
        this.content_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setName(String param1String) {
      if (param1String != null) {
        this.name_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setNameBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        Page.checkByteStringIsUtf8(param1ByteString);
        this.name_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setSubpages(int param1Int, Builder param1Builder) {
      RepeatedFieldBuilderV3<Page, Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.subpagesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureSubpagesIsMutable();
        this.subpages_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setSubpages(int param1Int, Page param1Page) {
      RepeatedFieldBuilderV3<Page, Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.subpagesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Page != null) {
          ensureSubpagesIsMutable();
          this.subpages_.set(param1Int, param1Page);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Page);
      return this;
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\Page.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */