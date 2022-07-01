package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Struct;

public final class NfcRecord extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  
  private static final DataHeader[] VERSION_ARRAY;
  
  public byte[] data;
  
  public String mediaType;
  
  public int recordType;
  
  static {
    DataHeader[] arrayOfDataHeader = new DataHeader[1];
    arrayOfDataHeader[0] = new DataHeader(32, 0);
    VERSION_ARRAY = arrayOfDataHeader;
    DEFAULT_STRUCT_INFO = arrayOfDataHeader[0];
    throw new VerifyError("bad dex opcode");
  }
  
  private NfcRecord() {
    super(32);
  }
  
  public NfcRecord(byte paramByte) {
    this();
  }
  
  public static NfcRecord decode(Decoder paramDecoder) {
    if (paramDecoder == null)
      return null; 
    paramDecoder.increaseStackDepth();
    try {
      paramDecoder.readAndValidateDataHeader(VERSION_ARRAY);
      NfcRecord nfcRecord = new NfcRecord();
      nfcRecord.recordType = paramDecoder.readInt(8);
      NfcRecordType.validate(nfcRecord.recordType);
      nfcRecord.mediaType = paramDecoder.readString(16, true);
      nfcRecord.data = paramDecoder.readBytes(24, 0, -1);
      return nfcRecord;
    } finally {
      paramDecoder.decreaseStackDepth();
    } 
  }
  
  protected final void encode(Encoder paramEncoder) {
    paramEncoder = paramEncoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    paramEncoder.encode(this.recordType, 8);
    paramEncoder.encode(this.mediaType, 16, true);
    paramEncoder.encode(this.data, 24, 0, -1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\mojom\NfcRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */