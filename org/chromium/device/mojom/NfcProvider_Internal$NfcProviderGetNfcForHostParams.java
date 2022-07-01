package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

final class NfcProvider_Internal$NfcProviderGetNfcForHostParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  
  private static final DataHeader[] VERSION_ARRAY;
  
  public int hostId;
  
  public InterfaceRequest nfc;
  
  static {
    DataHeader[] arrayOfDataHeader = new DataHeader[1];
    arrayOfDataHeader[0] = new DataHeader(16, 0);
    VERSION_ARRAY = arrayOfDataHeader;
    DEFAULT_STRUCT_INFO = arrayOfDataHeader[0];
    throw new VerifyError("bad dex opcode");
  }
  
  private NfcProvider_Internal$NfcProviderGetNfcForHostParams() {
    super(16);
  }
  
  public NfcProvider_Internal$NfcProviderGetNfcForHostParams(byte paramByte) {
    this();
  }
  
  private static NfcProvider_Internal$NfcProviderGetNfcForHostParams decode(Decoder paramDecoder) {
    if (paramDecoder == null)
      return null; 
    paramDecoder.increaseStackDepth();
    try {
      paramDecoder.readAndValidateDataHeader(VERSION_ARRAY);
      NfcProvider_Internal$NfcProviderGetNfcForHostParams nfcProvider_Internal$NfcProviderGetNfcForHostParams = new NfcProvider_Internal$NfcProviderGetNfcForHostParams();
      nfcProvider_Internal$NfcProviderGetNfcForHostParams.hostId = paramDecoder.readInt(8);
      nfcProvider_Internal$NfcProviderGetNfcForHostParams.nfc = paramDecoder.readInterfaceRequest(12, false);
      return nfcProvider_Internal$NfcProviderGetNfcForHostParams;
    } finally {
      paramDecoder.decreaseStackDepth();
    } 
  }
  
  public static NfcProvider_Internal$NfcProviderGetNfcForHostParams deserialize(Message paramMessage) {
    return decode(new Decoder(paramMessage));
  }
  
  protected final void encode(Encoder paramEncoder) {
    paramEncoder = paramEncoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    paramEncoder.encode(this.hostId, 8);
    paramEncoder.encode(this.nfc, 12, false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\mojom\NfcProvider_Internal$NfcProviderGetNfcForHostParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */