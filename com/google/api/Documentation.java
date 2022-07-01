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

public final class Documentation extends GeneratedMessageV3 implements DocumentationOrBuilder {
  private static final Documentation DEFAULT_INSTANCE = new Documentation();
  
  public static final int DOCUMENTATION_ROOT_URL_FIELD_NUMBER = 4;
  
  public static final int OVERVIEW_FIELD_NUMBER = 2;
  
  public static final int PAGES_FIELD_NUMBER = 5;
  
  private static final Parser<Documentation> PARSER = (Parser<Documentation>)new AbstractParser<Documentation>() {
      public Documentation a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new Documentation(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int RULES_FIELD_NUMBER = 3;
  
  public static final int SUMMARY_FIELD_NUMBER = 1;
  
  private static final long serialVersionUID = 0L;
  
  private int bitField0_;
  
  private volatile Object documentationRootUrl_;
  
  private byte memoizedIsInitialized = -1;
  
  private volatile Object overview_;
  
  private List<Page> pages_;
  
  private List<DocumentationRule> rules_;
  
  private volatile Object summary_;
  
  private Documentation() {
    this.summary_ = "";
    this.pages_ = Collections.emptyList();
    this.rules_ = Collections.emptyList();
    this.documentationRootUrl_ = "";
    this.overview_ = "";
  }
  
  private Documentation(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
                  if (n != 34) {
                    if (n != 42) {
                      j = i;
                      k = i;
                      m = i;
                      if (!parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, n))
                        continue; 
                      continue;
                    } 
                    n = i;
                    if ((i & 0x2) == 0) {
                      j = i;
                      k = i;
                      m = i;
                      this.pages_ = new ArrayList<Page>();
                      n = i | 0x2;
                    } 
                    j = n;
                    k = n;
                    m = n;
                    this.pages_.add(paramCodedInputStream.readMessage(Page.parser(), paramExtensionRegistryLite));
                    i = n;
                    continue;
                  } 
                  j = i;
                  k = i;
                  m = i;
                  this.documentationRootUrl_ = paramCodedInputStream.readStringRequireUtf8();
                  continue;
                } 
                n = i;
                if ((i & 0x4) == 0) {
                  j = i;
                  k = i;
                  m = i;
                  this.rules_ = new ArrayList<DocumentationRule>();
                  n = i | 0x4;
                } 
                j = n;
                k = n;
                m = n;
                this.rules_.add(paramCodedInputStream.readMessage(DocumentationRule.parser(), paramExtensionRegistryLite));
                i = n;
                continue;
              } 
              j = i;
              k = i;
              m = i;
              this.overview_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            } 
            j = i;
            k = i;
            m = i;
            this.summary_ = paramCodedInputStream.readStringRequireUtf8();
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
          this.rules_ = Collections.unmodifiableList(this.rules_); 
        if ((j & 0x2) != 0)
          this.pages_ = Collections.unmodifiableList(this.pages_); 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        throw paramCodedInputStream;
        bool = true;
      } 
      if ((i & 0x4) != 0)
        this.rules_ = Collections.unmodifiableList(this.rules_); 
      if ((i & 0x2) != 0)
        this.pages_ = Collections.unmodifiableList(this.pages_); 
      this.unknownFields = builder.build();
      makeExtensionsImmutable();
      return;
    } 
    throw new NullPointerException();
  }
  
  private Documentation(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static Documentation getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return DocumentationProto.a;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Documentation paramDocumentation) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramDocumentation);
  }
  
  public static Documentation parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Documentation)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static Documentation parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Documentation)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Documentation parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Documentation)PARSER.parseFrom(paramByteString);
  }
  
  public static Documentation parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Documentation)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Documentation parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Documentation)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static Documentation parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Documentation)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Documentation parseFrom(InputStream paramInputStream) throws IOException {
    return (Documentation)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static Documentation parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Documentation)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Documentation parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (Documentation)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static Documentation parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Documentation)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Documentation parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Documentation)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static Documentation parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Documentation)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Documentation> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof Documentation))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getSummary().equals(paramObject.getSummary()) ? false : (!getPagesList().equals(paramObject.getPagesList()) ? false : (!getRulesList().equals(paramObject.getRulesList()) ? false : (!getDocumentationRootUrl().equals(paramObject.getDocumentationRootUrl()) ? false : (!getOverview().equals(paramObject.getOverview()) ? false : (!!this.unknownFields.equals(((Documentation)paramObject).unknownFields))))));
  }
  
  public Documentation getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public String getDocumentationRootUrl() {
    Object object = this.documentationRootUrl_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.documentationRootUrl_ = object;
    return (String)object;
  }
  
  public ByteString getDocumentationRootUrlBytes() {
    Object object = this.documentationRootUrl_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.documentationRootUrl_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public String getOverview() {
    Object object = this.overview_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.overview_ = object;
    return (String)object;
  }
  
  public ByteString getOverviewBytes() {
    Object object = this.overview_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.overview_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public Page getPages(int paramInt) {
    return this.pages_.get(paramInt);
  }
  
  public int getPagesCount() {
    return this.pages_.size();
  }
  
  public List<Page> getPagesList() {
    return this.pages_;
  }
  
  public PageOrBuilder getPagesOrBuilder(int paramInt) {
    return this.pages_.get(paramInt);
  }
  
  public List<? extends PageOrBuilder> getPagesOrBuilderList() {
    return (List)this.pages_;
  }
  
  public Parser<Documentation> getParserForType() {
    return PARSER;
  }
  
  public DocumentationRule getRules(int paramInt) {
    return this.rules_.get(paramInt);
  }
  
  public int getRulesCount() {
    return this.rules_.size();
  }
  
  public List<DocumentationRule> getRulesList() {
    return this.rules_;
  }
  
  public DocumentationRuleOrBuilder getRulesOrBuilder(int paramInt) {
    return this.rules_.get(paramInt);
  }
  
  public List<? extends DocumentationRuleOrBuilder> getRulesOrBuilderList() {
    return (List)this.rules_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    boolean bool = getSummaryBytes().isEmpty();
    byte b = 0;
    if (!bool) {
      i = GeneratedMessageV3.computeStringSize(1, this.summary_) + 0;
    } else {
      i = 0;
    } 
    int j = i;
    if (!getOverviewBytes().isEmpty())
      j = i + GeneratedMessageV3.computeStringSize(2, this.overview_); 
    i = j;
    for (j = 0; j < this.rules_.size(); j++)
      i += CodedOutputStream.computeMessageSize(3, (MessageLite)this.rules_.get(j)); 
    int k = b;
    j = i;
    if (!getDocumentationRootUrlBytes().isEmpty()) {
      j = i + GeneratedMessageV3.computeStringSize(4, this.documentationRootUrl_);
      k = b;
    } 
    while (k < this.pages_.size()) {
      j += CodedOutputStream.computeMessageSize(5, (MessageLite)this.pages_.get(k));
      k++;
    } 
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public String getSummary() {
    Object object = this.summary_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.summary_ = object;
    return (String)object;
  }
  
  public ByteString getSummaryBytes() {
    Object object = this.summary_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.summary_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public final UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }
  
  public int hashCode() {
    if (this.memoizedHashCode != 0)
      return this.memoizedHashCode; 
    int j = ((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getSummary().hashCode();
    int i = j;
    if (getPagesCount() > 0)
      i = (j * 37 + 5) * 53 + getPagesList().hashCode(); 
    j = i;
    if (getRulesCount() > 0)
      j = (i * 37 + 3) * 53 + getRulesList().hashCode(); 
    i = ((((j * 37 + 4) * 53 + getDocumentationRootUrl().hashCode()) * 37 + 2) * 53 + getOverview().hashCode()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return DocumentationProto.b.ensureFieldAccessorsInitialized(Documentation.class, Builder.class);
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
    if (!getSummaryBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.summary_); 
    if (!getOverviewBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 2, this.overview_); 
    boolean bool = false;
    int i;
    for (i = 0; i < this.rules_.size(); i++)
      paramCodedOutputStream.writeMessage(3, (MessageLite)this.rules_.get(i)); 
    i = bool;
    if (!getDocumentationRootUrlBytes().isEmpty()) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 4, this.documentationRootUrl_);
      i = bool;
    } 
    while (i < this.pages_.size()) {
      paramCodedOutputStream.writeMessage(5, (MessageLite)this.pages_.get(i));
      i++;
    } 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DocumentationOrBuilder {
    private int bitField0_;
    
    private Object documentationRootUrl_ = "";
    
    private Object overview_ = "";
    
    private RepeatedFieldBuilderV3<Page, Page.Builder, PageOrBuilder> pagesBuilder_;
    
    private List<Page> pages_ = Collections.emptyList();
    
    private RepeatedFieldBuilderV3<DocumentationRule, DocumentationRule.Builder, DocumentationRuleOrBuilder> rulesBuilder_;
    
    private List<DocumentationRule> rules_ = Collections.emptyList();
    
    private Object summary_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensurePagesIsMutable() {
      if ((this.bitField0_ & 0x2) == 0) {
        this.pages_ = new ArrayList<Page>(this.pages_);
        this.bitField0_ |= 0x2;
      } 
    }
    
    private void ensureRulesIsMutable() {
      if ((this.bitField0_ & 0x4) == 0) {
        this.rules_ = new ArrayList<DocumentationRule>(this.rules_);
        this.bitField0_ |= 0x4;
      } 
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return DocumentationProto.a;
    }
    
    private RepeatedFieldBuilderV3<Page, Page.Builder, PageOrBuilder> getPagesFieldBuilder() {
      if (this.pagesBuilder_ == null) {
        boolean bool;
        List<Page> list = this.pages_;
        if ((this.bitField0_ & 0x2) != 0) {
          bool = true;
        } else {
          bool = false;
        } 
        this.pagesBuilder_ = new RepeatedFieldBuilderV3(list, bool, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.pages_ = null;
      } 
      return this.pagesBuilder_;
    }
    
    private RepeatedFieldBuilderV3<DocumentationRule, DocumentationRule.Builder, DocumentationRuleOrBuilder> getRulesFieldBuilder() {
      if (this.rulesBuilder_ == null) {
        boolean bool;
        List<DocumentationRule> list = this.rules_;
        if ((this.bitField0_ & 0x4) != 0) {
          bool = true;
        } else {
          bool = false;
        } 
        this.rulesBuilder_ = new RepeatedFieldBuilderV3(list, bool, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.rules_ = null;
      } 
      return this.rulesBuilder_;
    }
    
    private void maybeForceBuilderInitialization() {
      if (Documentation.alwaysUseFieldBuilders) {
        getPagesFieldBuilder();
        getRulesFieldBuilder();
      } 
    }
    
    public Builder addAllPages(Iterable<? extends Page> param1Iterable) {
      RepeatedFieldBuilderV3<Page, Page.Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.pagesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensurePagesIsMutable();
        AbstractMessageLite.Builder.addAll(param1Iterable, this.pages_);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addAllMessages(param1Iterable);
      return this;
    }
    
    public Builder addAllRules(Iterable<? extends DocumentationRule> param1Iterable) {
      RepeatedFieldBuilderV3<DocumentationRule, DocumentationRule.Builder, DocumentationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureRulesIsMutable();
        AbstractMessageLite.Builder.addAll(param1Iterable, this.rules_);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addAllMessages(param1Iterable);
      return this;
    }
    
    public Builder addPages(int param1Int, Page.Builder param1Builder) {
      RepeatedFieldBuilderV3<Page, Page.Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.pagesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensurePagesIsMutable();
        this.pages_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addPages(int param1Int, Page param1Page) {
      RepeatedFieldBuilderV3<Page, Page.Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.pagesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Page != null) {
          ensurePagesIsMutable();
          this.pages_.add(param1Int, param1Page);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Page);
      return this;
    }
    
    public Builder addPages(Page.Builder param1Builder) {
      RepeatedFieldBuilderV3<Page, Page.Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.pagesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensurePagesIsMutable();
        this.pages_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addPages(Page param1Page) {
      RepeatedFieldBuilderV3<Page, Page.Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.pagesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Page != null) {
          ensurePagesIsMutable();
          this.pages_.add(param1Page);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Page);
      return this;
    }
    
    public Page.Builder addPagesBuilder() {
      return (Page.Builder)getPagesFieldBuilder().addBuilder((AbstractMessage)Page.getDefaultInstance());
    }
    
    public Page.Builder addPagesBuilder(int param1Int) {
      return (Page.Builder)getPagesFieldBuilder().addBuilder(param1Int, (AbstractMessage)Page.getDefaultInstance());
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public Builder addRules(int param1Int, DocumentationRule.Builder param1Builder) {
      RepeatedFieldBuilderV3<DocumentationRule, DocumentationRule.Builder, DocumentationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureRulesIsMutable();
        this.rules_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addRules(int param1Int, DocumentationRule param1DocumentationRule) {
      RepeatedFieldBuilderV3<DocumentationRule, DocumentationRule.Builder, DocumentationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1DocumentationRule != null) {
          ensureRulesIsMutable();
          this.rules_.add(param1Int, param1DocumentationRule);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1DocumentationRule);
      return this;
    }
    
    public Builder addRules(DocumentationRule.Builder param1Builder) {
      RepeatedFieldBuilderV3<DocumentationRule, DocumentationRule.Builder, DocumentationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureRulesIsMutable();
        this.rules_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addRules(DocumentationRule param1DocumentationRule) {
      RepeatedFieldBuilderV3<DocumentationRule, DocumentationRule.Builder, DocumentationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1DocumentationRule != null) {
          ensureRulesIsMutable();
          this.rules_.add(param1DocumentationRule);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1DocumentationRule);
      return this;
    }
    
    public DocumentationRule.Builder addRulesBuilder() {
      return (DocumentationRule.Builder)getRulesFieldBuilder().addBuilder((AbstractMessage)DocumentationRule.getDefaultInstance());
    }
    
    public DocumentationRule.Builder addRulesBuilder(int param1Int) {
      return (DocumentationRule.Builder)getRulesFieldBuilder().addBuilder(param1Int, (AbstractMessage)DocumentationRule.getDefaultInstance());
    }
    
    public Documentation build() {
      Documentation documentation = buildPartial();
      if (documentation.isInitialized())
        return documentation; 
      throw newUninitializedMessageException(documentation);
    }
    
    public Documentation buildPartial() {
      Documentation documentation = new Documentation(this);
      int i = this.bitField0_;
      Documentation.access$402(documentation, this.summary_);
      RepeatedFieldBuilderV3<Page, Page.Builder, PageOrBuilder> repeatedFieldBuilderV31 = this.pagesBuilder_;
      if (repeatedFieldBuilderV31 == null) {
        if ((this.bitField0_ & 0x2) != 0) {
          this.pages_ = Collections.unmodifiableList(this.pages_);
          this.bitField0_ &= 0xFFFFFFFD;
        } 
        Documentation.access$502(documentation, this.pages_);
      } else {
        Documentation.access$502(documentation, repeatedFieldBuilderV31.build());
      } 
      RepeatedFieldBuilderV3<DocumentationRule, DocumentationRule.Builder, DocumentationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if ((this.bitField0_ & 0x4) != 0) {
          this.rules_ = Collections.unmodifiableList(this.rules_);
          this.bitField0_ &= 0xFFFFFFFB;
        } 
        Documentation.access$602(documentation, this.rules_);
      } else {
        Documentation.access$602(documentation, repeatedFieldBuilderV3.build());
      } 
      Documentation.access$702(documentation, this.documentationRootUrl_);
      Documentation.access$802(documentation, this.overview_);
      Documentation.access$902(documentation, 0);
      onBuilt();
      return documentation;
    }
    
    public Builder clear() {
      super.clear();
      this.summary_ = "";
      RepeatedFieldBuilderV3<Page, Page.Builder, PageOrBuilder> repeatedFieldBuilderV31 = this.pagesBuilder_;
      if (repeatedFieldBuilderV31 == null) {
        this.pages_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFD;
      } else {
        repeatedFieldBuilderV31.clear();
      } 
      RepeatedFieldBuilderV3<DocumentationRule, DocumentationRule.Builder, DocumentationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.rules_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFB;
      } else {
        repeatedFieldBuilderV3.clear();
      } 
      this.documentationRootUrl_ = "";
      this.overview_ = "";
      return this;
    }
    
    public Builder clearDocumentationRootUrl() {
      this.documentationRootUrl_ = Documentation.getDefaultInstance().getDocumentationRootUrl();
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearOverview() {
      this.overview_ = Documentation.getDefaultInstance().getOverview();
      onChanged();
      return this;
    }
    
    public Builder clearPages() {
      RepeatedFieldBuilderV3<Page, Page.Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.pagesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.pages_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFD;
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clearRules() {
      RepeatedFieldBuilderV3<DocumentationRule, DocumentationRule.Builder, DocumentationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.rules_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFB;
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clearSummary() {
      this.summary_ = Documentation.getDefaultInstance().getSummary();
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public Documentation getDefaultInstanceForType() {
      return Documentation.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return DocumentationProto.a;
    }
    
    public String getDocumentationRootUrl() {
      Object object = this.documentationRootUrl_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.documentationRootUrl_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getDocumentationRootUrlBytes() {
      Object object = this.documentationRootUrl_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.documentationRootUrl_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getOverview() {
      Object object = this.overview_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.overview_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getOverviewBytes() {
      Object object = this.overview_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.overview_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public Page getPages(int param1Int) {
      RepeatedFieldBuilderV3<Page, Page.Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.pagesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.pages_.get(param1Int) : (Page)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public Page.Builder getPagesBuilder(int param1Int) {
      return (Page.Builder)getPagesFieldBuilder().getBuilder(param1Int);
    }
    
    public List<Page.Builder> getPagesBuilderList() {
      return getPagesFieldBuilder().getBuilderList();
    }
    
    public int getPagesCount() {
      RepeatedFieldBuilderV3<Page, Page.Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.pagesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.pages_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<Page> getPagesList() {
      RepeatedFieldBuilderV3<Page, Page.Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.pagesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.pages_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public PageOrBuilder getPagesOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<Page, Page.Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.pagesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.pages_.get(param1Int) : (PageOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends PageOrBuilder> getPagesOrBuilderList() {
      RepeatedFieldBuilderV3<Page, Page.Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.pagesBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList((List)this.pages_);
    }
    
    public DocumentationRule getRules(int param1Int) {
      RepeatedFieldBuilderV3<DocumentationRule, DocumentationRule.Builder, DocumentationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.rules_.get(param1Int) : (DocumentationRule)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public DocumentationRule.Builder getRulesBuilder(int param1Int) {
      return (DocumentationRule.Builder)getRulesFieldBuilder().getBuilder(param1Int);
    }
    
    public List<DocumentationRule.Builder> getRulesBuilderList() {
      return getRulesFieldBuilder().getBuilderList();
    }
    
    public int getRulesCount() {
      RepeatedFieldBuilderV3<DocumentationRule, DocumentationRule.Builder, DocumentationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.rules_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<DocumentationRule> getRulesList() {
      RepeatedFieldBuilderV3<DocumentationRule, DocumentationRule.Builder, DocumentationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.rules_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public DocumentationRuleOrBuilder getRulesOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<DocumentationRule, DocumentationRule.Builder, DocumentationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.rules_.get(param1Int) : (DocumentationRuleOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends DocumentationRuleOrBuilder> getRulesOrBuilderList() {
      RepeatedFieldBuilderV3<DocumentationRule, DocumentationRule.Builder, DocumentationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList((List)this.rules_);
    }
    
    public String getSummary() {
      Object object = this.summary_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.summary_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getSummaryBytes() {
      Object object = this.summary_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.summary_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return DocumentationProto.b.ensureFieldAccessorsInitialized(Documentation.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(Documentation param1Documentation) {
      if (param1Documentation == Documentation.getDefaultInstance())
        return this; 
      if (!param1Documentation.getSummary().isEmpty()) {
        this.summary_ = param1Documentation.summary_;
        onChanged();
      } 
      RepeatedFieldBuilderV3<Page, Page.Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.pagesBuilder_;
      RepeatedFieldBuilderV3 repeatedFieldBuilderV31 = null;
      if (repeatedFieldBuilderV3 == null) {
        if (!param1Documentation.pages_.isEmpty()) {
          if (this.pages_.isEmpty()) {
            this.pages_ = param1Documentation.pages_;
            this.bitField0_ &= 0xFFFFFFFD;
          } else {
            ensurePagesIsMutable();
            this.pages_.addAll(param1Documentation.pages_);
          } 
          onChanged();
        } 
      } else if (!param1Documentation.pages_.isEmpty()) {
        if (this.pagesBuilder_.isEmpty()) {
          this.pagesBuilder_.dispose();
          this.pagesBuilder_ = null;
          this.pages_ = param1Documentation.pages_;
          this.bitField0_ &= 0xFFFFFFFD;
          if (Documentation.alwaysUseFieldBuilders) {
            repeatedFieldBuilderV3 = getPagesFieldBuilder();
          } else {
            repeatedFieldBuilderV3 = null;
          } 
          this.pagesBuilder_ = repeatedFieldBuilderV3;
        } else {
          this.pagesBuilder_.addAllMessages(param1Documentation.pages_);
        } 
      } 
      if (this.rulesBuilder_ == null) {
        if (!param1Documentation.rules_.isEmpty()) {
          if (this.rules_.isEmpty()) {
            this.rules_ = param1Documentation.rules_;
            this.bitField0_ &= 0xFFFFFFFB;
          } else {
            ensureRulesIsMutable();
            this.rules_.addAll(param1Documentation.rules_);
          } 
          onChanged();
        } 
      } else if (!param1Documentation.rules_.isEmpty()) {
        if (this.rulesBuilder_.isEmpty()) {
          this.rulesBuilder_.dispose();
          this.rulesBuilder_ = null;
          this.rules_ = param1Documentation.rules_;
          this.bitField0_ &= 0xFFFFFFFB;
          repeatedFieldBuilderV3 = repeatedFieldBuilderV31;
          if (Documentation.alwaysUseFieldBuilders)
            repeatedFieldBuilderV3 = (RepeatedFieldBuilderV3)getRulesFieldBuilder(); 
          this.rulesBuilder_ = (RepeatedFieldBuilderV3)repeatedFieldBuilderV3;
        } else {
          this.rulesBuilder_.addAllMessages(param1Documentation.rules_);
        } 
      } 
      if (!param1Documentation.getDocumentationRootUrl().isEmpty()) {
        this.documentationRootUrl_ = param1Documentation.documentationRootUrl_;
        onChanged();
      } 
      if (!param1Documentation.getOverview().isEmpty()) {
        this.overview_ = param1Documentation.overview_;
        onChanged();
      } 
      mergeUnknownFields(param1Documentation.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        Documentation documentation = (Documentation)Documentation.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        Documentation documentation = (Documentation)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((Documentation)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof Documentation)
        return mergeFrom((Documentation)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder removePages(int param1Int) {
      RepeatedFieldBuilderV3<Page, Page.Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.pagesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensurePagesIsMutable();
        this.pages_.remove(param1Int);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.remove(param1Int);
      return this;
    }
    
    public Builder removeRules(int param1Int) {
      RepeatedFieldBuilderV3<DocumentationRule, DocumentationRule.Builder, DocumentationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureRulesIsMutable();
        this.rules_.remove(param1Int);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.remove(param1Int);
      return this;
    }
    
    public Builder setDocumentationRootUrl(String param1String) {
      if (param1String != null) {
        this.documentationRootUrl_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setDocumentationRootUrlBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        Documentation.checkByteStringIsUtf8(param1ByteString);
        this.documentationRootUrl_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setOverview(String param1String) {
      if (param1String != null) {
        this.overview_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setOverviewBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        Documentation.checkByteStringIsUtf8(param1ByteString);
        this.overview_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setPages(int param1Int, Page.Builder param1Builder) {
      RepeatedFieldBuilderV3<Page, Page.Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.pagesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensurePagesIsMutable();
        this.pages_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setPages(int param1Int, Page param1Page) {
      RepeatedFieldBuilderV3<Page, Page.Builder, PageOrBuilder> repeatedFieldBuilderV3 = this.pagesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Page != null) {
          ensurePagesIsMutable();
          this.pages_.set(param1Int, param1Page);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Page);
      return this;
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setRules(int param1Int, DocumentationRule.Builder param1Builder) {
      RepeatedFieldBuilderV3<DocumentationRule, DocumentationRule.Builder, DocumentationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureRulesIsMutable();
        this.rules_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setRules(int param1Int, DocumentationRule param1DocumentationRule) {
      RepeatedFieldBuilderV3<DocumentationRule, DocumentationRule.Builder, DocumentationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1DocumentationRule != null) {
          ensureRulesIsMutable();
          this.rules_.set(param1Int, param1DocumentationRule);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1DocumentationRule);
      return this;
    }
    
    public Builder setSummary(String param1String) {
      if (param1String != null) {
        this.summary_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setSummaryBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        Documentation.checkByteStringIsUtf8(param1ByteString);
        this.summary_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\Documentation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */