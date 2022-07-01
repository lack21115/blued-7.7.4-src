package org.chromium.mojo.bindings;

public class MessageHeader {
  private static final DataHeader MESSAGE_WITH_REQUEST_ID_STRUCT_INFO;
  
  private static final DataHeader SIMPLE_MESSAGE_STRUCT_INFO;
  
  final DataHeader mDataHeader;
  
  final int mFlags;
  
  long mRequestId;
  
  public final int mType;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public MessageHeader(int paramInt) {
    this.mDataHeader = SIMPLE_MESSAGE_STRUCT_INFO;
    this.mType = paramInt;
    this.mFlags = 0;
    this.mRequestId = 0L;
  }
  
  public MessageHeader(int paramInt1, int paramInt2, long paramLong) {
    assert false;
    throw new AssertionError();
  }
  
  MessageHeader(Message paramMessage) {
    StringBuilder stringBuilder1;
    Decoder decoder = new Decoder(paramMessage);
    this.mDataHeader = decoder.readDataHeader();
    DataHeader dataHeader = this.mDataHeader;
    if (dataHeader.elementsOrVersion >= 0) {
      if (dataHeader.size >= 24) {
        if (dataHeader.elementsOrVersion != 0 || dataHeader.size == 24) {
          if (dataHeader.elementsOrVersion != 1 || dataHeader.size == 32) {
            if (decoder.readInt(8) == 0) {
              this.mType = decoder.readInt(12);
              this.mFlags = decoder.readInt(16);
              if (mustHaveRequestId(this.mFlags)) {
                if (this.mDataHeader.size >= 32) {
                  this.mRequestId = decoder.readLong(24);
                  return;
                } 
                stringBuilder1 = new StringBuilder("Incorrect message size, expecting at least 32 for a message with a request identifier, but got: ");
                stringBuilder1.append(this.mDataHeader.size);
                throw new DeserializationException(stringBuilder1.toString());
              } 
              this.mRequestId = 0L;
              return;
            } 
            throw new DeserializationException("Non-zero interface ID, expecting zero since associated interfaces are not yet supported.");
          } 
          StringBuilder stringBuilder4 = new StringBuilder("Incorrect message size for a message with 1 fields, expecting 32, but got: ");
          stringBuilder4.append(((DataHeader)stringBuilder1).size);
          throw new DeserializationException(stringBuilder4.toString());
        } 
        StringBuilder stringBuilder3 = new StringBuilder("Incorrect message size for a message with 0 fields, expecting 24, but got: ");
        stringBuilder3.append(((DataHeader)stringBuilder1).size);
        throw new DeserializationException(stringBuilder3.toString());
      } 
      StringBuilder stringBuilder = new StringBuilder("Incorrect message size, expecting at least 24, but got: ");
      stringBuilder.append(((DataHeader)stringBuilder1).size);
      throw new DeserializationException(stringBuilder.toString());
    } 
    StringBuilder stringBuilder2 = new StringBuilder("Incorrect number of fields, expecting at least 0, but got: ");
    stringBuilder2.append(((DataHeader)stringBuilder1).elementsOrVersion);
    throw new DeserializationException(stringBuilder2.toString());
  }
  
  static boolean mustHaveRequestId(int paramInt) {
    return ((paramInt & 0x3) != 0);
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (paramObject == null)
      return false; 
    if (getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    return (BindingsHelper.equals(this.mDataHeader, ((MessageHeader)paramObject).mDataHeader) && this.mFlags == ((MessageHeader)paramObject).mFlags && this.mRequestId == ((MessageHeader)paramObject).mRequestId && this.mType == ((MessageHeader)paramObject).mType);
  }
  
  public final long getRequestId() {
    assert false;
    throw new AssertionError();
  }
  
  public final boolean hasFlag(int paramInt) {
    return ((this.mFlags & paramInt) == paramInt);
  }
  
  public int hashCode() {
    int i;
    if (this.mDataHeader == null) {
      i = 0;
    } else {
      i = this.mDataHeader.hashCode();
    } 
    return (((i + 31) * 31 + this.mFlags) * 31 + (int)(this.mRequestId ^ this.mRequestId >>> 32L)) * 31 + this.mType;
  }
  
  public final boolean validateHeader(int paramInt) {
    return ((this.mFlags & 0x3) == paramInt);
  }
  
  public final boolean validateHeader(int paramInt1, int paramInt2) {
    return (this.mType == paramInt1 && validateHeader(paramInt2));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\bindings\MessageHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */