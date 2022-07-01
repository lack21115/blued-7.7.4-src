package org.chromium.shape_detection.mojom;

import org.chromium.gfx.mojom.PointF;
import org.chromium.gfx.mojom.RectF;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Struct;

public final class TextDetectionResult extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  
  private static final DataHeader[] VERSION_ARRAY;
  
  public RectF boundingBox;
  
  public PointF[] cornerPoints;
  
  public String rawValue;
  
  static {
    DataHeader[] arrayOfDataHeader = new DataHeader[1];
    arrayOfDataHeader[0] = new DataHeader(32, 0);
    VERSION_ARRAY = arrayOfDataHeader;
    DEFAULT_STRUCT_INFO = arrayOfDataHeader[0];
    throw new VerifyError("bad dex opcode");
  }
  
  private TextDetectionResult() {
    super(32);
  }
  
  public TextDetectionResult(byte paramByte) {
    this();
  }
  
  public static TextDetectionResult decode(Decoder paramDecoder) {
    if (paramDecoder == null)
      return null; 
    paramDecoder.increaseStackDepth();
    try {
      paramDecoder.readAndValidateDataHeader(VERSION_ARRAY);
      TextDetectionResult textDetectionResult = new TextDetectionResult();
      textDetectionResult.rawValue = paramDecoder.readString(8, false);
      textDetectionResult.boundingBox = RectF.decode(paramDecoder.readPointer(16, false));
      Decoder decoder = paramDecoder.readPointer(24, false);
      DataHeader dataHeader = decoder.readDataHeaderForPointerArray(-1);
      textDetectionResult.cornerPoints = new PointF[dataHeader.elementsOrVersion];
      for (int i = 0; i < dataHeader.elementsOrVersion; i++) {
        Decoder decoder1 = decoder.readPointer((i << 3) + 8, false);
        textDetectionResult.cornerPoints[i] = PointF.decode(decoder1);
      } 
      return textDetectionResult;
    } finally {
      paramDecoder.decreaseStackDepth();
    } 
  }
  
  protected final void encode(Encoder paramEncoder) {
    paramEncoder = paramEncoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    paramEncoder.encode(this.rawValue, 8, false);
    paramEncoder.encode((Struct)this.boundingBox, 16, false);
    if (this.cornerPoints == null) {
      paramEncoder.encodeNullPointer(24, false);
      return;
    } 
    paramEncoder = paramEncoder.encodePointerArray(this.cornerPoints.length, 24, -1);
    for (int i = 0; i < this.cornerPoints.length; i++)
      paramEncoder.encode((Struct)this.cornerPoints[i], (i << 3) + 8, false); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\shape_detection\mojom\TextDetectionResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */