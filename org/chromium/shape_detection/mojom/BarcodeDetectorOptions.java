package org.chromium.shape_detection.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Struct;

public final class BarcodeDetectorOptions extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  
  private static final DataHeader[] VERSION_ARRAY;
  
  private int[] formats;
  
  static {
    DataHeader[] arrayOfDataHeader = new DataHeader[1];
    arrayOfDataHeader[0] = new DataHeader(16, 0);
    VERSION_ARRAY = arrayOfDataHeader;
    DEFAULT_STRUCT_INFO = arrayOfDataHeader[0];
    throw new VerifyError("bad dex opcode");
  }
  
  private BarcodeDetectorOptions() {
    super(16);
  }
  
  public static BarcodeDetectorOptions decode(Decoder paramDecoder) {
    if (paramDecoder == null)
      return null; 
    paramDecoder.increaseStackDepth();
    try {
      paramDecoder.readAndValidateDataHeader(VERSION_ARRAY);
      BarcodeDetectorOptions barcodeDetectorOptions = new BarcodeDetectorOptions();
      int i = 0;
      barcodeDetectorOptions.formats = paramDecoder.readInts(8, 0, -1);
      while (i < barcodeDetectorOptions.formats.length) {
        BarcodeFormat.validate(barcodeDetectorOptions.formats[i]);
        i++;
      } 
      return barcodeDetectorOptions;
    } finally {
      paramDecoder.decreaseStackDepth();
    } 
  }
  
  protected final void encode(Encoder paramEncoder) {
    paramEncoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO).encode(this.formats, 8, 0, -1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\shape_detection\mojom\BarcodeDetectorOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */