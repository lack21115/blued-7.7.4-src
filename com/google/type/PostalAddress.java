package com.google.type;

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
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;

public final class PostalAddress extends GeneratedMessageV3 implements PostalAddressOrBuilder {
  public static final int ADDRESS_LINES_FIELD_NUMBER = 9;
  
  public static final int ADMINISTRATIVE_AREA_FIELD_NUMBER = 6;
  
  private static final PostalAddress DEFAULT_INSTANCE = new PostalAddress();
  
  public static final int LANGUAGE_CODE_FIELD_NUMBER = 3;
  
  public static final int LOCALITY_FIELD_NUMBER = 7;
  
  public static final int ORGANIZATION_FIELD_NUMBER = 11;
  
  private static final Parser<PostalAddress> PARSER = (Parser<PostalAddress>)new AbstractParser<PostalAddress>() {
      public PostalAddress a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new PostalAddress(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int POSTAL_CODE_FIELD_NUMBER = 4;
  
  public static final int RECIPIENTS_FIELD_NUMBER = 10;
  
  public static final int REGION_CODE_FIELD_NUMBER = 2;
  
  public static final int REVISION_FIELD_NUMBER = 1;
  
  public static final int SORTING_CODE_FIELD_NUMBER = 5;
  
  public static final int SUBLOCALITY_FIELD_NUMBER = 8;
  
  private static final long serialVersionUID = 0L;
  
  private LazyStringList addressLines_;
  
  private volatile Object administrativeArea_;
  
  private int bitField0_;
  
  private volatile Object languageCode_;
  
  private volatile Object locality_;
  
  private byte memoizedIsInitialized = -1;
  
  private volatile Object organization_;
  
  private volatile Object postalCode_;
  
  private LazyStringList recipients_;
  
  private volatile Object regionCode_;
  
  private int revision_;
  
  private volatile Object sortingCode_;
  
  private volatile Object sublocality_;
  
  private PostalAddress() {
    this.regionCode_ = "";
    this.languageCode_ = "";
    this.postalCode_ = "";
    this.sortingCode_ = "";
    this.administrativeArea_ = "";
    this.locality_ = "";
    this.sublocality_ = "";
    this.addressLines_ = LazyStringArrayList.EMPTY;
    this.recipients_ = LazyStringArrayList.EMPTY;
    this.organization_ = "";
  }
  
  private PostalAddress(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
          String str;
          int n = paramCodedInputStream.readTag();
          switch (n) {
            case 90:
              j = i;
              k = i;
              m = i;
              this.organization_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            case 82:
              j = i;
              k = i;
              m = i;
              str = paramCodedInputStream.readStringRequireUtf8();
              n = i;
              if ((i & 0x200) == 0) {
                j = i;
                k = i;
                m = i;
                this.recipients_ = (LazyStringList)new LazyStringArrayList();
                n = i | 0x200;
              } 
              j = n;
              k = n;
              m = n;
              this.recipients_.add(str);
              i = n;
              continue;
            case 74:
              j = i;
              k = i;
              m = i;
              str = paramCodedInputStream.readStringRequireUtf8();
              n = i;
              if ((i & 0x100) == 0) {
                j = i;
                k = i;
                m = i;
                this.addressLines_ = (LazyStringList)new LazyStringArrayList();
                n = i | 0x100;
              } 
              j = n;
              k = n;
              m = n;
              this.addressLines_.add(str);
              i = n;
              continue;
            case 66:
              j = i;
              k = i;
              m = i;
              this.sublocality_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            case 58:
              j = i;
              k = i;
              m = i;
              this.locality_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            case 50:
              j = i;
              k = i;
              m = i;
              this.administrativeArea_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            case 42:
              j = i;
              k = i;
              m = i;
              this.sortingCode_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            case 34:
              j = i;
              k = i;
              m = i;
              this.postalCode_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            case 26:
              j = i;
              k = i;
              m = i;
              this.languageCode_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            case 18:
              j = i;
              k = i;
              m = i;
              this.regionCode_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            case 8:
              j = i;
              k = i;
              m = i;
              this.revision_ = paramCodedInputStream.readInt32();
              continue;
            case 0:
              bool = true;
              continue;
          } 
          j = i;
          k = i;
          m = i;
          boolean bool1 = parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, n);
          if (!bool1);
          continue;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          j = m;
          throw invalidProtocolBufferException.setUnfinishedMessage(this);
        } catch (IOException iOException) {
          j = k;
          throw (new InvalidProtocolBufferException(iOException)).setUnfinishedMessage(this);
        } finally {}
        if ((j & 0x100) != 0)
          this.addressLines_ = this.addressLines_.getUnmodifiableView(); 
        if ((j & 0x200) != 0)
          this.recipients_ = this.recipients_.getUnmodifiableView(); 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        throw paramCodedInputStream;
      } 
      if ((i & 0x100) != 0)
        this.addressLines_ = this.addressLines_.getUnmodifiableView(); 
      if ((i & 0x200) != 0)
        this.recipients_ = this.recipients_.getUnmodifiableView(); 
      this.unknownFields = builder.build();
      makeExtensionsImmutable();
      return;
    } 
    throw new NullPointerException();
  }
  
  private PostalAddress(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static PostalAddress getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return PostalAddressProto.a;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(PostalAddress paramPostalAddress) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramPostalAddress);
  }
  
  public static PostalAddress parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (PostalAddress)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static PostalAddress parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (PostalAddress)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static PostalAddress parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (PostalAddress)PARSER.parseFrom(paramByteString);
  }
  
  public static PostalAddress parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (PostalAddress)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static PostalAddress parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (PostalAddress)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static PostalAddress parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (PostalAddress)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static PostalAddress parseFrom(InputStream paramInputStream) throws IOException {
    return (PostalAddress)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static PostalAddress parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (PostalAddress)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static PostalAddress parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (PostalAddress)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static PostalAddress parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (PostalAddress)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static PostalAddress parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (PostalAddress)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static PostalAddress parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (PostalAddress)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<PostalAddress> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof PostalAddress))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return (getRevision() != paramObject.getRevision()) ? false : (!getRegionCode().equals(paramObject.getRegionCode()) ? false : (!getLanguageCode().equals(paramObject.getLanguageCode()) ? false : (!getPostalCode().equals(paramObject.getPostalCode()) ? false : (!getSortingCode().equals(paramObject.getSortingCode()) ? false : (!getAdministrativeArea().equals(paramObject.getAdministrativeArea()) ? false : (!getLocality().equals(paramObject.getLocality()) ? false : (!getSublocality().equals(paramObject.getSublocality()) ? false : (!getAddressLinesList().equals(paramObject.getAddressLinesList()) ? false : (!getRecipientsList().equals(paramObject.getRecipientsList()) ? false : (!getOrganization().equals(paramObject.getOrganization()) ? false : (!!this.unknownFields.equals(((PostalAddress)paramObject).unknownFields))))))))))));
  }
  
  public String getAddressLines(int paramInt) {
    return (String)this.addressLines_.get(paramInt);
  }
  
  public ByteString getAddressLinesBytes(int paramInt) {
    return this.addressLines_.getByteString(paramInt);
  }
  
  public int getAddressLinesCount() {
    return this.addressLines_.size();
  }
  
  public ProtocolStringList getAddressLinesList() {
    return (ProtocolStringList)this.addressLines_;
  }
  
  public String getAdministrativeArea() {
    Object object = this.administrativeArea_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.administrativeArea_ = object;
    return (String)object;
  }
  
  public ByteString getAdministrativeAreaBytes() {
    Object object = this.administrativeArea_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.administrativeArea_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public PostalAddress getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public String getLanguageCode() {
    Object object = this.languageCode_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.languageCode_ = object;
    return (String)object;
  }
  
  public ByteString getLanguageCodeBytes() {
    Object object = this.languageCode_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.languageCode_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public String getLocality() {
    Object object = this.locality_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.locality_ = object;
    return (String)object;
  }
  
  public ByteString getLocalityBytes() {
    Object object = this.locality_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.locality_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public String getOrganization() {
    Object object = this.organization_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.organization_ = object;
    return (String)object;
  }
  
  public ByteString getOrganizationBytes() {
    Object object = this.organization_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.organization_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public Parser<PostalAddress> getParserForType() {
    return PARSER;
  }
  
  public String getPostalCode() {
    Object object = this.postalCode_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.postalCode_ = object;
    return (String)object;
  }
  
  public ByteString getPostalCodeBytes() {
    Object object = this.postalCode_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.postalCode_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public String getRecipients(int paramInt) {
    return (String)this.recipients_.get(paramInt);
  }
  
  public ByteString getRecipientsBytes(int paramInt) {
    return this.recipients_.getByteString(paramInt);
  }
  
  public int getRecipientsCount() {
    return this.recipients_.size();
  }
  
  public ProtocolStringList getRecipientsList() {
    return (ProtocolStringList)this.recipients_;
  }
  
  public String getRegionCode() {
    Object object = this.regionCode_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.regionCode_ = object;
    return (String)object;
  }
  
  public ByteString getRegionCodeBytes() {
    Object object = this.regionCode_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.regionCode_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public int getRevision() {
    return this.revision_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    i = this.revision_;
    boolean bool = false;
    if (i != 0) {
      j = CodedOutputStream.computeInt32Size(1, i) + 0;
    } else {
      j = 0;
    } 
    i = j;
    if (!getRegionCodeBytes().isEmpty())
      i = j + GeneratedMessageV3.computeStringSize(2, this.regionCode_); 
    int j = i;
    if (!getLanguageCodeBytes().isEmpty())
      j = i + GeneratedMessageV3.computeStringSize(3, this.languageCode_); 
    i = j;
    if (!getPostalCodeBytes().isEmpty())
      i = j + GeneratedMessageV3.computeStringSize(4, this.postalCode_); 
    j = i;
    if (!getSortingCodeBytes().isEmpty())
      j = i + GeneratedMessageV3.computeStringSize(5, this.sortingCode_); 
    i = j;
    if (!getAdministrativeAreaBytes().isEmpty())
      i = j + GeneratedMessageV3.computeStringSize(6, this.administrativeArea_); 
    j = i;
    if (!getLocalityBytes().isEmpty())
      j = i + GeneratedMessageV3.computeStringSize(7, this.locality_); 
    i = j;
    if (!getSublocalityBytes().isEmpty())
      i = j + GeneratedMessageV3.computeStringSize(8, this.sublocality_); 
    int k = 0;
    j = 0;
    while (k < this.addressLines_.size()) {
      j += computeStringSizeNoTag(this.addressLines_.getRaw(k));
      k++;
    } 
    int n = getAddressLinesList().size();
    int m = 0;
    for (k = bool; k < this.recipients_.size(); k++)
      m += computeStringSizeNoTag(this.recipients_.getRaw(k)); 
    j = i + j + n * 1 + m + getRecipientsList().size() * 1;
    i = j;
    if (!getOrganizationBytes().isEmpty())
      i = j + GeneratedMessageV3.computeStringSize(11, this.organization_); 
    i += this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public String getSortingCode() {
    Object object = this.sortingCode_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.sortingCode_ = object;
    return (String)object;
  }
  
  public ByteString getSortingCodeBytes() {
    Object object = this.sortingCode_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.sortingCode_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public String getSublocality() {
    Object object = this.sublocality_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.sublocality_ = object;
    return (String)object;
  }
  
  public ByteString getSublocalityBytes() {
    Object object = this.sublocality_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.sublocality_ = object;
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
    int j = ((((((((((((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getRevision()) * 37 + 2) * 53 + getRegionCode().hashCode()) * 37 + 3) * 53 + getLanguageCode().hashCode()) * 37 + 4) * 53 + getPostalCode().hashCode()) * 37 + 5) * 53 + getSortingCode().hashCode()) * 37 + 6) * 53 + getAdministrativeArea().hashCode()) * 37 + 7) * 53 + getLocality().hashCode()) * 37 + 8) * 53 + getSublocality().hashCode();
    int i = j;
    if (getAddressLinesCount() > 0)
      i = (j * 37 + 9) * 53 + getAddressLinesList().hashCode(); 
    j = i;
    if (getRecipientsCount() > 0)
      j = (i * 37 + 10) * 53 + getRecipientsList().hashCode(); 
    i = ((j * 37 + 11) * 53 + getOrganization().hashCode()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return PostalAddressProto.b.ensureFieldAccessorsInitialized(PostalAddress.class, Builder.class);
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
    int j;
    int i = this.revision_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(1, i); 
    if (!getRegionCodeBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 2, this.regionCode_); 
    if (!getLanguageCodeBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 3, this.languageCode_); 
    if (!getPostalCodeBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 4, this.postalCode_); 
    if (!getSortingCodeBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 5, this.sortingCode_); 
    if (!getAdministrativeAreaBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 6, this.administrativeArea_); 
    if (!getLocalityBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 7, this.locality_); 
    if (!getSublocalityBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 8, this.sublocality_); 
    byte b = 0;
    i = 0;
    while (true) {
      j = b;
      if (i < this.addressLines_.size()) {
        GeneratedMessageV3.writeString(paramCodedOutputStream, 9, this.addressLines_.getRaw(i));
        i++;
        continue;
      } 
      break;
    } 
    while (j < this.recipients_.size()) {
      GeneratedMessageV3.writeString(paramCodedOutputStream, 10, this.recipients_.getRaw(j));
      j++;
    } 
    if (!getOrganizationBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 11, this.organization_); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PostalAddressOrBuilder {
    private LazyStringList addressLines_ = LazyStringArrayList.EMPTY;
    
    private Object administrativeArea_ = "";
    
    private int bitField0_;
    
    private Object languageCode_ = "";
    
    private Object locality_ = "";
    
    private Object organization_ = "";
    
    private Object postalCode_ = "";
    
    private LazyStringList recipients_ = LazyStringArrayList.EMPTY;
    
    private Object regionCode_ = "";
    
    private int revision_;
    
    private Object sortingCode_ = "";
    
    private Object sublocality_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensureAddressLinesIsMutable() {
      if ((this.bitField0_ & 0x100) == 0) {
        this.addressLines_ = (LazyStringList)new LazyStringArrayList(this.addressLines_);
        this.bitField0_ |= 0x100;
      } 
    }
    
    private void ensureRecipientsIsMutable() {
      if ((this.bitField0_ & 0x200) == 0) {
        this.recipients_ = (LazyStringList)new LazyStringArrayList(this.recipients_);
        this.bitField0_ |= 0x200;
      } 
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return PostalAddressProto.a;
    }
    
    private void maybeForceBuilderInitialization() {
      PostalAddress.alwaysUseFieldBuilders;
    }
    
    public Builder addAddressLines(String param1String) {
      if (param1String != null) {
        ensureAddressLinesIsMutable();
        this.addressLines_.add(param1String);
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder addAddressLinesBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        PostalAddress.checkByteStringIsUtf8(param1ByteString);
        ensureAddressLinesIsMutable();
        this.addressLines_.add(param1ByteString);
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder addAllAddressLines(Iterable<String> param1Iterable) {
      ensureAddressLinesIsMutable();
      AbstractMessageLite.Builder.addAll(param1Iterable, (List)this.addressLines_);
      onChanged();
      return this;
    }
    
    public Builder addAllRecipients(Iterable<String> param1Iterable) {
      ensureRecipientsIsMutable();
      AbstractMessageLite.Builder.addAll(param1Iterable, (List)this.recipients_);
      onChanged();
      return this;
    }
    
    public Builder addRecipients(String param1String) {
      if (param1String != null) {
        ensureRecipientsIsMutable();
        this.recipients_.add(param1String);
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder addRecipientsBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        PostalAddress.checkByteStringIsUtf8(param1ByteString);
        ensureRecipientsIsMutable();
        this.recipients_.add(param1ByteString);
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public PostalAddress build() {
      PostalAddress postalAddress = buildPartial();
      if (postalAddress.isInitialized())
        return postalAddress; 
      throw newUninitializedMessageException(postalAddress);
    }
    
    public PostalAddress buildPartial() {
      PostalAddress postalAddress = new PostalAddress(this);
      int i = this.bitField0_;
      PostalAddress.access$402(postalAddress, this.revision_);
      PostalAddress.access$502(postalAddress, this.regionCode_);
      PostalAddress.access$602(postalAddress, this.languageCode_);
      PostalAddress.access$702(postalAddress, this.postalCode_);
      PostalAddress.access$802(postalAddress, this.sortingCode_);
      PostalAddress.access$902(postalAddress, this.administrativeArea_);
      PostalAddress.access$1002(postalAddress, this.locality_);
      PostalAddress.access$1102(postalAddress, this.sublocality_);
      if ((this.bitField0_ & 0x100) != 0) {
        this.addressLines_ = this.addressLines_.getUnmodifiableView();
        this.bitField0_ &= 0xFFFFFEFF;
      } 
      PostalAddress.access$1202(postalAddress, this.addressLines_);
      if ((this.bitField0_ & 0x200) != 0) {
        this.recipients_ = this.recipients_.getUnmodifiableView();
        this.bitField0_ &= 0xFFFFFDFF;
      } 
      PostalAddress.access$1302(postalAddress, this.recipients_);
      PostalAddress.access$1402(postalAddress, this.organization_);
      PostalAddress.access$1502(postalAddress, 0);
      onBuilt();
      return postalAddress;
    }
    
    public Builder clear() {
      super.clear();
      this.revision_ = 0;
      this.regionCode_ = "";
      this.languageCode_ = "";
      this.postalCode_ = "";
      this.sortingCode_ = "";
      this.administrativeArea_ = "";
      this.locality_ = "";
      this.sublocality_ = "";
      this.addressLines_ = LazyStringArrayList.EMPTY;
      this.bitField0_ &= 0xFFFFFEFF;
      this.recipients_ = LazyStringArrayList.EMPTY;
      this.bitField0_ &= 0xFFFFFDFF;
      this.organization_ = "";
      return this;
    }
    
    public Builder clearAddressLines() {
      this.addressLines_ = LazyStringArrayList.EMPTY;
      this.bitField0_ &= 0xFFFFFEFF;
      onChanged();
      return this;
    }
    
    public Builder clearAdministrativeArea() {
      this.administrativeArea_ = PostalAddress.getDefaultInstance().getAdministrativeArea();
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearLanguageCode() {
      this.languageCode_ = PostalAddress.getDefaultInstance().getLanguageCode();
      onChanged();
      return this;
    }
    
    public Builder clearLocality() {
      this.locality_ = PostalAddress.getDefaultInstance().getLocality();
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearOrganization() {
      this.organization_ = PostalAddress.getDefaultInstance().getOrganization();
      onChanged();
      return this;
    }
    
    public Builder clearPostalCode() {
      this.postalCode_ = PostalAddress.getDefaultInstance().getPostalCode();
      onChanged();
      return this;
    }
    
    public Builder clearRecipients() {
      this.recipients_ = LazyStringArrayList.EMPTY;
      this.bitField0_ &= 0xFFFFFDFF;
      onChanged();
      return this;
    }
    
    public Builder clearRegionCode() {
      this.regionCode_ = PostalAddress.getDefaultInstance().getRegionCode();
      onChanged();
      return this;
    }
    
    public Builder clearRevision() {
      this.revision_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearSortingCode() {
      this.sortingCode_ = PostalAddress.getDefaultInstance().getSortingCode();
      onChanged();
      return this;
    }
    
    public Builder clearSublocality() {
      this.sublocality_ = PostalAddress.getDefaultInstance().getSublocality();
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public String getAddressLines(int param1Int) {
      return (String)this.addressLines_.get(param1Int);
    }
    
    public ByteString getAddressLinesBytes(int param1Int) {
      return this.addressLines_.getByteString(param1Int);
    }
    
    public int getAddressLinesCount() {
      return this.addressLines_.size();
    }
    
    public ProtocolStringList getAddressLinesList() {
      return (ProtocolStringList)this.addressLines_.getUnmodifiableView();
    }
    
    public String getAdministrativeArea() {
      Object object = this.administrativeArea_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.administrativeArea_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getAdministrativeAreaBytes() {
      Object object = this.administrativeArea_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.administrativeArea_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public PostalAddress getDefaultInstanceForType() {
      return PostalAddress.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return PostalAddressProto.a;
    }
    
    public String getLanguageCode() {
      Object object = this.languageCode_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.languageCode_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getLanguageCodeBytes() {
      Object object = this.languageCode_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.languageCode_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getLocality() {
      Object object = this.locality_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.locality_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getLocalityBytes() {
      Object object = this.locality_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.locality_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getOrganization() {
      Object object = this.organization_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.organization_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getOrganizationBytes() {
      Object object = this.organization_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.organization_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getPostalCode() {
      Object object = this.postalCode_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.postalCode_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getPostalCodeBytes() {
      Object object = this.postalCode_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.postalCode_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getRecipients(int param1Int) {
      return (String)this.recipients_.get(param1Int);
    }
    
    public ByteString getRecipientsBytes(int param1Int) {
      return this.recipients_.getByteString(param1Int);
    }
    
    public int getRecipientsCount() {
      return this.recipients_.size();
    }
    
    public ProtocolStringList getRecipientsList() {
      return (ProtocolStringList)this.recipients_.getUnmodifiableView();
    }
    
    public String getRegionCode() {
      Object object = this.regionCode_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.regionCode_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getRegionCodeBytes() {
      Object object = this.regionCode_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.regionCode_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public int getRevision() {
      return this.revision_;
    }
    
    public String getSortingCode() {
      Object object = this.sortingCode_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.sortingCode_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getSortingCodeBytes() {
      Object object = this.sortingCode_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.sortingCode_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getSublocality() {
      Object object = this.sublocality_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.sublocality_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getSublocalityBytes() {
      Object object = this.sublocality_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.sublocality_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return PostalAddressProto.b.ensureFieldAccessorsInitialized(PostalAddress.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        PostalAddress postalAddress = (PostalAddress)PostalAddress.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        PostalAddress postalAddress = (PostalAddress)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((PostalAddress)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof PostalAddress)
        return mergeFrom((PostalAddress)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeFrom(PostalAddress param1PostalAddress) {
      if (param1PostalAddress == PostalAddress.getDefaultInstance())
        return this; 
      if (param1PostalAddress.getRevision() != 0)
        setRevision(param1PostalAddress.getRevision()); 
      if (!param1PostalAddress.getRegionCode().isEmpty()) {
        this.regionCode_ = param1PostalAddress.regionCode_;
        onChanged();
      } 
      if (!param1PostalAddress.getLanguageCode().isEmpty()) {
        this.languageCode_ = param1PostalAddress.languageCode_;
        onChanged();
      } 
      if (!param1PostalAddress.getPostalCode().isEmpty()) {
        this.postalCode_ = param1PostalAddress.postalCode_;
        onChanged();
      } 
      if (!param1PostalAddress.getSortingCode().isEmpty()) {
        this.sortingCode_ = param1PostalAddress.sortingCode_;
        onChanged();
      } 
      if (!param1PostalAddress.getAdministrativeArea().isEmpty()) {
        this.administrativeArea_ = param1PostalAddress.administrativeArea_;
        onChanged();
      } 
      if (!param1PostalAddress.getLocality().isEmpty()) {
        this.locality_ = param1PostalAddress.locality_;
        onChanged();
      } 
      if (!param1PostalAddress.getSublocality().isEmpty()) {
        this.sublocality_ = param1PostalAddress.sublocality_;
        onChanged();
      } 
      if (!param1PostalAddress.addressLines_.isEmpty()) {
        if (this.addressLines_.isEmpty()) {
          this.addressLines_ = param1PostalAddress.addressLines_;
          this.bitField0_ &= 0xFFFFFEFF;
        } else {
          ensureAddressLinesIsMutable();
          this.addressLines_.addAll((Collection)param1PostalAddress.addressLines_);
        } 
        onChanged();
      } 
      if (!param1PostalAddress.recipients_.isEmpty()) {
        if (this.recipients_.isEmpty()) {
          this.recipients_ = param1PostalAddress.recipients_;
          this.bitField0_ &= 0xFFFFFDFF;
        } else {
          ensureRecipientsIsMutable();
          this.recipients_.addAll((Collection)param1PostalAddress.recipients_);
        } 
        onChanged();
      } 
      if (!param1PostalAddress.getOrganization().isEmpty()) {
        this.organization_ = param1PostalAddress.organization_;
        onChanged();
      } 
      mergeUnknownFields(param1PostalAddress.unknownFields);
      onChanged();
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setAddressLines(int param1Int, String param1String) {
      if (param1String != null) {
        ensureAddressLinesIsMutable();
        this.addressLines_.set(param1Int, param1String);
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setAdministrativeArea(String param1String) {
      if (param1String != null) {
        this.administrativeArea_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setAdministrativeAreaBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        PostalAddress.checkByteStringIsUtf8(param1ByteString);
        this.administrativeArea_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setLanguageCode(String param1String) {
      if (param1String != null) {
        this.languageCode_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setLanguageCodeBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        PostalAddress.checkByteStringIsUtf8(param1ByteString);
        this.languageCode_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setLocality(String param1String) {
      if (param1String != null) {
        this.locality_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setLocalityBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        PostalAddress.checkByteStringIsUtf8(param1ByteString);
        this.locality_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setOrganization(String param1String) {
      if (param1String != null) {
        this.organization_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setOrganizationBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        PostalAddress.checkByteStringIsUtf8(param1ByteString);
        this.organization_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setPostalCode(String param1String) {
      if (param1String != null) {
        this.postalCode_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setPostalCodeBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        PostalAddress.checkByteStringIsUtf8(param1ByteString);
        this.postalCode_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRecipients(int param1Int, String param1String) {
      if (param1String != null) {
        ensureRecipientsIsMutable();
        this.recipients_.set(param1Int, param1String);
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRegionCode(String param1String) {
      if (param1String != null) {
        this.regionCode_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRegionCodeBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        PostalAddress.checkByteStringIsUtf8(param1ByteString);
        this.regionCode_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setRevision(int param1Int) {
      this.revision_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setSortingCode(String param1String) {
      if (param1String != null) {
        this.sortingCode_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setSortingCodeBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        PostalAddress.checkByteStringIsUtf8(param1ByteString);
        this.sortingCode_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setSublocality(String param1String) {
      if (param1String != null) {
        this.sublocality_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setSublocalityBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        PostalAddress.checkByteStringIsUtf8(param1ByteString);
        this.sublocality_ = param1ByteString;
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\type\PostalAddress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */