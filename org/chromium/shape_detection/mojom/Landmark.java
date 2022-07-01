package org.chromium.shape_detection.mojom;

import org.chromium.gfx.mojom.PointF;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Struct;

public final class Landmark extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  
  private static final DataHeader[] VERSION_ARRAY;
  
  public PointF[] locations;
  
  public int type;
  
  static {
    DataHeader[] arrayOfDataHeader = new DataHeader[1];
    arrayOfDataHeader[0] = new DataHeader(24, 0);
    VERSION_ARRAY = arrayOfDataHeader;
    DEFAULT_STRUCT_INFO = arrayOfDataHeader[0];
    throw new VerifyError("bad dex opcode");
  }
  
  private Landmark() {
    super(24);
  }
  
  public Landmark(byte paramByte) {
    this();
  }
  
  public static Landmark decode(Decoder paramDecoder) {
    if (paramDecoder == null)
      return null; 
    paramDecoder.increaseStackDepth();
    try {
      paramDecoder.readAndValidateDataHeader(VERSION_ARRAY);
      Landmark landmark = new Landmark();
      boolean bool = false;
      Decoder decoder = paramDecoder.readPointer(8, false);
      DataHeader dataHeader = decoder.readDataHeaderForPointerArray(-1);
      landmark.locations = new PointF[dataHeader.elementsOrVersion];
      int i;
      for (i = 0; i < dataHeader.elementsOrVersion; i++) {
        Decoder decoder1 = decoder.readPointer((i << 3) + 8, false);
        landmark.locations[i] = PointF.decode(decoder1);
      } 
      landmark.type = paramDecoder.readInt(16);
      i = landmark.type;
      switch (i) {
        default:
          i = bool;
          break;
        case 0:
        case 1:
        case 2:
          i = 1;
          break;
      } 
      if (i != 0)
        return landmark; 
      throw new DeserializationException("Invalid enum value.");
    } finally {
      paramDecoder.decreaseStackDepth();
    } 
  }
  
  protected final void encode(Encoder paramEncoder) {
    paramEncoder = paramEncoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    if (this.locations == null) {
      paramEncoder.encodeNullPointer(8, false);
    } else {
      Encoder encoder = paramEncoder.encodePointerArray(this.locations.length, 8, -1);
      for (int i = 0; i < this.locations.length; i++)
        encoder.encode((Struct)this.locations[i], (i << 3) + 8, false); 
    } 
    paramEncoder.encode(this.type, 16);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\shape_detection\mojom\Landmark.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */