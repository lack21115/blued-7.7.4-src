package org.chromium.skia.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo_base.mojom.BigBuffer;

public final class Bitmap extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  
  private static final DataHeader[] VERSION_ARRAY;
  
  public ImageInfo imageInfo;
  
  public BigBuffer pixelData;
  
  private long rowBytes;
  
  static {
    DataHeader[] arrayOfDataHeader = new DataHeader[1];
    arrayOfDataHeader[0] = new DataHeader(40, 0);
    VERSION_ARRAY = arrayOfDataHeader;
    DEFAULT_STRUCT_INFO = arrayOfDataHeader[0];
    throw new VerifyError("bad dex opcode");
  }
  
  private Bitmap() {
    super(40);
  }
  
  public static Bitmap decode(Decoder paramDecoder) {
    if (paramDecoder == null)
      return null; 
    paramDecoder.increaseStackDepth();
    try {
      paramDecoder.readAndValidateDataHeader(VERSION_ARRAY);
      Bitmap bitmap = new Bitmap();
      bitmap.imageInfo = ImageInfo.decode(paramDecoder.readPointer(8, false));
      bitmap.rowBytes = paramDecoder.readLong(16);
      bitmap.pixelData = BigBuffer.decode(paramDecoder, 24);
      return bitmap;
    } finally {
      paramDecoder.decreaseStackDepth();
    } 
  }
  
  protected final void encode(Encoder paramEncoder) {
    paramEncoder = paramEncoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    paramEncoder.encode(this.imageInfo, 8, false);
    paramEncoder.encode(this.rowBytes, 16);
    paramEncoder.encode((Union)this.pixelData, 24, false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\skia\mojom\Bitmap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */