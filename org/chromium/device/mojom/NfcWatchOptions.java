package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Struct;

public final class NfcWatchOptions extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  
  private static final DataHeader[] VERSION_ARRAY;
  
  public String mediaType;
  
  public int mode;
  
  public NfcRecordTypeFilter recordFilter;
  
  public String url;
  
  static {
    DataHeader[] arrayOfDataHeader = new DataHeader[1];
    arrayOfDataHeader[0] = new DataHeader(40, 0);
    VERSION_ARRAY = arrayOfDataHeader;
    DEFAULT_STRUCT_INFO = arrayOfDataHeader[0];
    throw new VerifyError("bad dex opcode");
  }
  
  private NfcWatchOptions() {
    super(40);
  }
  
  public static NfcWatchOptions decode(Decoder paramDecoder) {
    if (paramDecoder == null)
      return null; 
    paramDecoder.increaseStackDepth();
    try {
      paramDecoder.readAndValidateDataHeader(VERSION_ARRAY);
      NfcWatchOptions nfcWatchOptions = new NfcWatchOptions();
      boolean bool = true;
      nfcWatchOptions.url = paramDecoder.readString(8, true);
      nfcWatchOptions.recordFilter = NfcRecordTypeFilter.decode(paramDecoder.readPointer(16, true));
      nfcWatchOptions.mediaType = paramDecoder.readString(24, true);
      nfcWatchOptions.mode = paramDecoder.readInt(32);
      int i = nfcWatchOptions.mode;
      switch (i) {
        default:
          bool = false;
          break;
        case 0:
        case 1:
          break;
      } 
      if (bool)
        return nfcWatchOptions; 
      throw new DeserializationException("Invalid enum value.");
    } finally {
      paramDecoder.decreaseStackDepth();
    } 
  }
  
  protected final void encode(Encoder paramEncoder) {
    paramEncoder = paramEncoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    paramEncoder.encode(this.url, 8, true);
    paramEncoder.encode(this.recordFilter, 16, true);
    paramEncoder.encode(this.mediaType, 24, true);
    paramEncoder.encode(this.mode, 32);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\mojom\NfcWatchOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */