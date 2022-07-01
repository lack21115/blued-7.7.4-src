package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.File;

public class BitmapEncoder implements ResourceEncoder<Bitmap> {
  public static final Option<Integer> a = Option.a("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", Integer.valueOf(90));
  
  public static final Option<Bitmap.CompressFormat> b = Option.a("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");
  
  private final ArrayPool c = null;
  
  @Deprecated
  public BitmapEncoder() {}
  
  public BitmapEncoder(ArrayPool paramArrayPool) {}
  
  private Bitmap.CompressFormat a(Bitmap paramBitmap, Options paramOptions) {
    Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat)paramOptions.a(b);
    return (compressFormat != null) ? compressFormat : (paramBitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG);
  }
  
  public EncodeStrategy a(Options paramOptions) {
    return EncodeStrategy.b;
  }
  
  public boolean a(Resource<Bitmap> paramResource, File paramFile, Options paramOptions) {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface f : ()Ljava/lang/Object;
    //   6: checkcast android/graphics/Bitmap
    //   9: astore #11
    //   11: aload_0
    //   12: aload #11
    //   14: aload_3
    //   15: invokespecial a : (Landroid/graphics/Bitmap;Lcom/bumptech/glide/load/Options;)Landroid/graphics/Bitmap$CompressFormat;
    //   18: astore #12
    //   20: ldc 'encode: [%dx%d] %s'
    //   22: aload #11
    //   24: invokevirtual getWidth : ()I
    //   27: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   30: aload #11
    //   32: invokevirtual getHeight : ()I
    //   35: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   38: aload #12
    //   40: invokestatic a : (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   43: invokestatic a : ()J
    //   46: lstore #5
    //   48: aload_3
    //   49: getstatic com/bumptech/glide/load/resource/bitmap/BitmapEncoder.a : Lcom/bumptech/glide/load/Option;
    //   52: invokevirtual a : (Lcom/bumptech/glide/load/Option;)Ljava/lang/Object;
    //   55: checkcast java/lang/Integer
    //   58: invokevirtual intValue : ()I
    //   61: istore #4
    //   63: iconst_0
    //   64: istore #7
    //   66: iconst_0
    //   67: istore #8
    //   69: aconst_null
    //   70: astore #10
    //   72: aconst_null
    //   73: astore #9
    //   75: new java/io/FileOutputStream
    //   78: dup
    //   79: aload_2
    //   80: invokespecial <init> : (Ljava/io/File;)V
    //   83: astore_1
    //   84: aload_0
    //   85: getfield c : Lcom/bumptech/glide/load/engine/bitmap_recycle/ArrayPool;
    //   88: ifnull -> 109
    //   91: new com/bumptech/glide/load/data/BufferedOutputStream
    //   94: dup
    //   95: aload_1
    //   96: aload_0
    //   97: getfield c : Lcom/bumptech/glide/load/engine/bitmap_recycle/ArrayPool;
    //   100: invokespecial <init> : (Ljava/io/OutputStream;Lcom/bumptech/glide/load/engine/bitmap_recycle/ArrayPool;)V
    //   103: astore_2
    //   104: aload_2
    //   105: astore_1
    //   106: goto -> 109
    //   109: aload_1
    //   110: astore #9
    //   112: aload_1
    //   113: astore #10
    //   115: aload #11
    //   117: aload #12
    //   119: iload #4
    //   121: aload_1
    //   122: invokevirtual compress : (Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   125: pop
    //   126: aload_1
    //   127: astore #9
    //   129: aload_1
    //   130: astore #10
    //   132: aload_1
    //   133: invokevirtual close : ()V
    //   136: iconst_1
    //   137: istore #7
    //   139: aload_1
    //   140: invokevirtual close : ()V
    //   143: goto -> 202
    //   146: astore_2
    //   147: aload_1
    //   148: astore #9
    //   150: aload_2
    //   151: astore_1
    //   152: goto -> 319
    //   155: astore_2
    //   156: goto -> 167
    //   159: astore_1
    //   160: goto -> 319
    //   163: astore_2
    //   164: aload #10
    //   166: astore_1
    //   167: aload_1
    //   168: astore #9
    //   170: ldc 'BitmapEncoder'
    //   172: iconst_3
    //   173: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   176: ifeq -> 191
    //   179: aload_1
    //   180: astore #9
    //   182: ldc 'BitmapEncoder'
    //   184: ldc 'Failed to encode Bitmap'
    //   186: aload_2
    //   187: invokestatic d : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   190: pop
    //   191: aload_1
    //   192: ifnull -> 202
    //   195: iload #8
    //   197: istore #7
    //   199: goto -> 139
    //   202: ldc 'BitmapEncoder'
    //   204: iconst_2
    //   205: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   208: ifeq -> 313
    //   211: new java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial <init> : ()V
    //   218: astore_1
    //   219: aload_1
    //   220: ldc 'Compressed with type: '
    //   222: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload_1
    //   227: aload #12
    //   229: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload_1
    //   234: ldc ' of size '
    //   236: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload_1
    //   241: aload #11
    //   243: invokestatic a : (Landroid/graphics/Bitmap;)I
    //   246: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload_1
    //   251: ldc ' in '
    //   253: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload_1
    //   258: lload #5
    //   260: invokestatic a : (J)D
    //   263: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: aload_1
    //   268: ldc ', options format: '
    //   270: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload_1
    //   275: aload_3
    //   276: getstatic com/bumptech/glide/load/resource/bitmap/BitmapEncoder.b : Lcom/bumptech/glide/load/Option;
    //   279: invokevirtual a : (Lcom/bumptech/glide/load/Option;)Ljava/lang/Object;
    //   282: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: aload_1
    //   287: ldc ', hasAlpha: '
    //   289: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload_1
    //   294: aload #11
    //   296: invokevirtual hasAlpha : ()Z
    //   299: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: ldc 'BitmapEncoder'
    //   305: aload_1
    //   306: invokevirtual toString : ()Ljava/lang/String;
    //   309: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   312: pop
    //   313: invokestatic a : ()V
    //   316: iload #7
    //   318: ireturn
    //   319: aload #9
    //   321: ifnull -> 329
    //   324: aload #9
    //   326: invokevirtual close : ()V
    //   329: aload_1
    //   330: athrow
    //   331: astore_1
    //   332: invokestatic a : ()V
    //   335: aload_1
    //   336: athrow
    //   337: astore_1
    //   338: goto -> 202
    //   341: astore_2
    //   342: goto -> 329
    // Exception table:
    //   from	to	target	type
    //   43	63	331	finally
    //   75	84	163	java/io/IOException
    //   75	84	159	finally
    //   84	104	155	java/io/IOException
    //   84	104	146	finally
    //   115	126	163	java/io/IOException
    //   115	126	159	finally
    //   132	136	163	java/io/IOException
    //   132	136	159	finally
    //   139	143	337	java/io/IOException
    //   139	143	331	finally
    //   170	179	159	finally
    //   182	191	159	finally
    //   202	313	331	finally
    //   324	329	341	java/io/IOException
    //   324	329	331	finally
    //   329	331	331	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\bitmap\BitmapEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */