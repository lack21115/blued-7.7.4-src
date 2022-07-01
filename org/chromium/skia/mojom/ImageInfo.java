package org.chromium.skia.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Struct;

public final class ImageInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  
  private static final DataHeader[] VERSION_ARRAY;
  
  private int alphaType;
  
  public int colorType;
  
  public int height;
  
  private int profileType;
  
  public int width;
  
  static {
    DataHeader[] arrayOfDataHeader = new DataHeader[1];
    arrayOfDataHeader[0] = new DataHeader(32, 0);
    VERSION_ARRAY = arrayOfDataHeader;
    DEFAULT_STRUCT_INFO = arrayOfDataHeader[0];
    throw new VerifyError("bad dex opcode");
  }
  
  private ImageInfo() {
    super(32);
  }
  
  public static ImageInfo decode(Decoder paramDecoder) {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_0
    //   7: invokevirtual increaseStackDepth : ()V
    //   10: aload_0
    //   11: getstatic org/chromium/skia/mojom/ImageInfo.VERSION_ARRAY : [Lorg/chromium/mojo/bindings/DataHeader;
    //   14: invokevirtual readAndValidateDataHeader : ([Lorg/chromium/mojo/bindings/DataHeader;)Lorg/chromium/mojo/bindings/DataHeader;
    //   17: pop
    //   18: new org/chromium/skia/mojom/ImageInfo
    //   21: dup
    //   22: invokespecial <init> : ()V
    //   25: astore_3
    //   26: aload_3
    //   27: aload_0
    //   28: bipush #8
    //   30: invokevirtual readInt : (I)I
    //   33: putfield colorType : I
    //   36: aload_3
    //   37: getfield colorType : I
    //   40: istore_1
    //   41: iconst_1
    //   42: istore_2
    //   43: iload_1
    //   44: tableswitch default -> 247, 0 -> 252, 1 -> 252, 2 -> 252, 3 -> 252, 4 -> 252, 5 -> 252, 6 -> 252, 7 -> 252
    //   92: iload_1
    //   93: ifeq -> 230
    //   96: aload_3
    //   97: aload_0
    //   98: bipush #12
    //   100: invokevirtual readInt : (I)I
    //   103: putfield alphaType : I
    //   106: aload_3
    //   107: getfield alphaType : I
    //   110: tableswitch default -> 257, 0 -> 262, 1 -> 262, 2 -> 262, 3 -> 262
    //   140: iload_1
    //   141: ifeq -> 220
    //   144: aload_3
    //   145: aload_0
    //   146: bipush #16
    //   148: invokevirtual readInt : (I)I
    //   151: putfield profileType : I
    //   154: aload_3
    //   155: getfield profileType : I
    //   158: tableswitch default -> 267, 0 -> 272, 1 -> 272
    //   180: iload_1
    //   181: ifeq -> 210
    //   184: aload_3
    //   185: aload_0
    //   186: bipush #20
    //   188: invokevirtual readInt : (I)I
    //   191: putfield width : I
    //   194: aload_3
    //   195: aload_0
    //   196: bipush #24
    //   198: invokevirtual readInt : (I)I
    //   201: putfield height : I
    //   204: aload_0
    //   205: invokevirtual decreaseStackDepth : ()V
    //   208: aload_3
    //   209: areturn
    //   210: new org/chromium/mojo/bindings/DeserializationException
    //   213: dup
    //   214: ldc 'Invalid enum value.'
    //   216: invokespecial <init> : (Ljava/lang/String;)V
    //   219: athrow
    //   220: new org/chromium/mojo/bindings/DeserializationException
    //   223: dup
    //   224: ldc 'Invalid enum value.'
    //   226: invokespecial <init> : (Ljava/lang/String;)V
    //   229: athrow
    //   230: new org/chromium/mojo/bindings/DeserializationException
    //   233: dup
    //   234: ldc 'Invalid enum value.'
    //   236: invokespecial <init> : (Ljava/lang/String;)V
    //   239: athrow
    //   240: astore_3
    //   241: aload_0
    //   242: invokevirtual decreaseStackDepth : ()V
    //   245: aload_3
    //   246: athrow
    //   247: iconst_0
    //   248: istore_1
    //   249: goto -> 92
    //   252: iconst_1
    //   253: istore_1
    //   254: goto -> 92
    //   257: iconst_0
    //   258: istore_1
    //   259: goto -> 140
    //   262: iconst_1
    //   263: istore_1
    //   264: goto -> 140
    //   267: iconst_0
    //   268: istore_1
    //   269: goto -> 180
    //   272: iload_2
    //   273: istore_1
    //   274: goto -> 180
    // Exception table:
    //   from	to	target	type
    //   10	41	240	finally
    //   96	140	240	finally
    //   144	180	240	finally
    //   184	204	240	finally
    //   210	220	240	finally
    //   220	230	240	finally
    //   230	240	240	finally
  }
  
  protected final void encode(Encoder paramEncoder) {
    paramEncoder = paramEncoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    paramEncoder.encode(this.colorType, 8);
    paramEncoder.encode(this.alphaType, 12);
    paramEncoder.encode(this.profileType, 16);
    paramEncoder.encode(this.width, 20);
    paramEncoder.encode(this.height, 24);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\skia\mojom\ImageInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */