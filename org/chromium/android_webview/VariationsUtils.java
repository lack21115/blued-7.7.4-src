package org.chromium.android_webview;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.UninitializedMessageException;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import org.chromium.android_webview.proto.AwVariationsSeedOuterClass;
import org.chromium.base.Log;
import org.chromium.base.PathUtils;
import org.chromium.components.variations.firstrun.VariationsSeedFetcher;

public final class VariationsUtils {
  public static void closeSafely(Closeable paramCloseable) {
    if (paramCloseable != null)
      try {
        paramCloseable.close();
        return;
      } catch (IOException iOException) {
        StringBuilder stringBuilder = new StringBuilder("Failed to close ");
        stringBuilder.append(paramCloseable);
        Log.e("VariationsUtils", stringBuilder.toString(), new Object[0]);
      }  
  }
  
  public static File getNewSeedFile() {
    return new File(PathUtils.getDataDirectory(), "variations_seed_new");
  }
  
  public static File getSeedFile() {
    return new File(PathUtils.getDataDirectory(), "variations_seed");
  }
  
  public static File getStampFile() {
    return new File(PathUtils.getDataDirectory(), "variations_stamp");
  }
  
  public static VariationsSeedFetcher.SeedInfo readSeedFile(File paramFile) {
    // Byte code:
    //   0: new java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial <init> : (Ljava/io/File;)V
    //   8: astore_2
    //   9: aload_2
    //   10: astore_1
    //   11: aload_2
    //   12: invokestatic parseFrom : (Ljava/io/InputStream;)Lorg/chromium/android_webview/proto/AwVariationsSeedOuterClass$AwVariationsSeed;
    //   15: astore_3
    //   16: aload_2
    //   17: astore_1
    //   18: aload_3
    //   19: invokevirtual hasSignature : ()Z
    //   22: ifeq -> 196
    //   25: aload_2
    //   26: astore_1
    //   27: aload_3
    //   28: invokevirtual hasCountry : ()Z
    //   31: ifeq -> 196
    //   34: aload_2
    //   35: astore_1
    //   36: aload_3
    //   37: invokevirtual hasDate : ()Z
    //   40: ifeq -> 196
    //   43: aload_2
    //   44: astore_1
    //   45: aload_3
    //   46: invokevirtual hasIsGzipCompressed : ()Z
    //   49: ifeq -> 196
    //   52: aload_2
    //   53: astore_1
    //   54: aload_3
    //   55: invokevirtual hasSeedData : ()Z
    //   58: ifne -> 64
    //   61: goto -> 196
    //   64: aload_2
    //   65: astore_1
    //   66: new org/chromium/components/variations/firstrun/VariationsSeedFetcher$SeedInfo
    //   69: dup
    //   70: invokespecial <init> : ()V
    //   73: astore #4
    //   75: aload_2
    //   76: astore_1
    //   77: aload #4
    //   79: aload_3
    //   80: getfield signature_ : Ljava/lang/String;
    //   83: putfield signature : Ljava/lang/String;
    //   86: aload_2
    //   87: astore_1
    //   88: aload #4
    //   90: aload_3
    //   91: getfield country_ : Ljava/lang/String;
    //   94: putfield country : Ljava/lang/String;
    //   97: aload_2
    //   98: astore_1
    //   99: aload #4
    //   101: aload_3
    //   102: getfield date_ : Ljava/lang/String;
    //   105: putfield date : Ljava/lang/String;
    //   108: aload_2
    //   109: astore_1
    //   110: aload #4
    //   112: aload_3
    //   113: getfield isGzipCompressed_ : Z
    //   116: putfield isGzipCompressed : Z
    //   119: aload_2
    //   120: astore_1
    //   121: aload #4
    //   123: aload_3
    //   124: getfield seedData_ : Lcom/google/protobuf/ByteString;
    //   127: invokevirtual toByteArray : ()[B
    //   130: putfield seedData : [B
    //   133: aload_2
    //   134: astore_1
    //   135: aload #4
    //   137: invokevirtual parseDate : ()Ljava/util/Date;
    //   140: pop
    //   141: aload_2
    //   142: invokestatic closeSafely : (Ljava/io/Closeable;)V
    //   145: aload #4
    //   147: areturn
    //   148: astore_3
    //   149: aload_2
    //   150: astore_1
    //   151: new java/lang/StringBuilder
    //   154: dup
    //   155: ldc 'Malformed seed date: '
    //   157: invokespecial <init> : (Ljava/lang/String;)V
    //   160: astore #4
    //   162: aload_2
    //   163: astore_1
    //   164: aload #4
    //   166: aload_3
    //   167: invokevirtual getMessage : ()Ljava/lang/String;
    //   170: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload_2
    //   175: astore_1
    //   176: ldc 'VariationsUtils'
    //   178: aload #4
    //   180: invokevirtual toString : ()Ljava/lang/String;
    //   183: iconst_0
    //   184: anewarray java/lang/Object
    //   187: invokestatic e : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   190: aload_2
    //   191: invokestatic closeSafely : (Ljava/io/Closeable;)V
    //   194: aconst_null
    //   195: areturn
    //   196: aload_2
    //   197: invokestatic closeSafely : (Ljava/io/Closeable;)V
    //   200: aconst_null
    //   201: areturn
    //   202: astore_3
    //   203: goto -> 222
    //   206: astore_0
    //   207: aload_2
    //   208: invokestatic closeSafely : (Ljava/io/Closeable;)V
    //   211: aconst_null
    //   212: areturn
    //   213: astore_0
    //   214: aconst_null
    //   215: astore_1
    //   216: goto -> 289
    //   219: astore_3
    //   220: aconst_null
    //   221: astore_2
    //   222: aload_2
    //   223: astore_1
    //   224: new java/lang/StringBuilder
    //   227: dup
    //   228: ldc 'Failed reading seed file "'
    //   230: invokespecial <init> : (Ljava/lang/String;)V
    //   233: astore #4
    //   235: aload_2
    //   236: astore_1
    //   237: aload #4
    //   239: aload_0
    //   240: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload_2
    //   245: astore_1
    //   246: aload #4
    //   248: ldc '": '
    //   250: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload_2
    //   255: astore_1
    //   256: aload #4
    //   258: aload_3
    //   259: invokevirtual getMessage : ()Ljava/lang/String;
    //   262: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload_2
    //   267: astore_1
    //   268: ldc 'VariationsUtils'
    //   270: aload #4
    //   272: invokevirtual toString : ()Ljava/lang/String;
    //   275: iconst_0
    //   276: anewarray java/lang/Object
    //   279: invokestatic e : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   282: aload_2
    //   283: invokestatic closeSafely : (Ljava/io/Closeable;)V
    //   286: aconst_null
    //   287: areturn
    //   288: astore_0
    //   289: aload_1
    //   290: invokestatic closeSafely : (Ljava/io/Closeable;)V
    //   293: aload_0
    //   294: athrow
    // Exception table:
    //   from	to	target	type
    //   0	9	219	java/io/IOException
    //   0	9	213	finally
    //   11	16	206	com/google/protobuf/InvalidProtocolBufferException
    //   11	16	202	java/io/IOException
    //   11	16	288	finally
    //   18	25	202	java/io/IOException
    //   18	25	288	finally
    //   27	34	202	java/io/IOException
    //   27	34	288	finally
    //   36	43	202	java/io/IOException
    //   36	43	288	finally
    //   45	52	202	java/io/IOException
    //   45	52	288	finally
    //   54	61	202	java/io/IOException
    //   54	61	288	finally
    //   66	75	202	java/io/IOException
    //   66	75	288	finally
    //   77	86	202	java/io/IOException
    //   77	86	288	finally
    //   88	97	202	java/io/IOException
    //   88	97	288	finally
    //   99	108	202	java/io/IOException
    //   99	108	288	finally
    //   110	119	202	java/io/IOException
    //   110	119	288	finally
    //   121	133	202	java/io/IOException
    //   121	133	288	finally
    //   135	141	148	java/text/ParseException
    //   135	141	202	java/io/IOException
    //   135	141	288	finally
    //   151	162	202	java/io/IOException
    //   151	162	288	finally
    //   164	174	202	java/io/IOException
    //   164	174	288	finally
    //   176	190	202	java/io/IOException
    //   176	190	288	finally
    //   224	235	288	finally
    //   237	244	288	finally
    //   246	254	288	finally
    //   256	266	288	finally
    //   268	282	288	finally
  }
  
  public static void replaceOldWithNewSeed() {
    File file1 = getSeedFile();
    File file2 = getNewSeedFile();
    if (!file2.renameTo(file1)) {
      StringBuilder stringBuilder = new StringBuilder("Failed to replace old seed ");
      stringBuilder.append(file1);
      stringBuilder.append(" with new seed ");
      stringBuilder.append(file2);
      Log.e("VariationsUtils", stringBuilder.toString(), new Object[0]);
    } 
  }
  
  public static void updateStampTime() {
    File file = getStampFile();
    try {
      if (!file.createNewFile())
        file.setLastModified((new Date()).getTime()); 
      return;
    } catch (IOException iOException) {
      StringBuilder stringBuilder = new StringBuilder("Failed to write ");
      stringBuilder.append(file);
      Log.e("VariationsUtils", stringBuilder.toString(), new Object[0]);
      return;
    } 
  }
  
  public static boolean writeSeed(FileOutputStream paramFileOutputStream, VariationsSeedFetcher.SeedInfo paramSeedInfo) {
    try {
      AwVariationsSeedOuterClass.AwVariationsSeed.Builder builder = AwVariationsSeedOuterClass.AwVariationsSeed.newBuilder();
      String str = paramSeedInfo.signature;
      builder.copyOnWrite();
      AwVariationsSeedOuterClass.AwVariationsSeed.access$100((AwVariationsSeedOuterClass.AwVariationsSeed)builder.instance, str);
      str = paramSeedInfo.country;
      builder.copyOnWrite();
      AwVariationsSeedOuterClass.AwVariationsSeed.access$400((AwVariationsSeedOuterClass.AwVariationsSeed)builder.instance, str);
      str = paramSeedInfo.date;
      builder.copyOnWrite();
      AwVariationsSeedOuterClass.AwVariationsSeed.access$700((AwVariationsSeedOuterClass.AwVariationsSeed)builder.instance, str);
      boolean bool = paramSeedInfo.isGzipCompressed;
      builder.copyOnWrite();
      AwVariationsSeedOuterClass.AwVariationsSeed.access$1000((AwVariationsSeedOuterClass.AwVariationsSeed)builder.instance, bool);
      ByteString byteString = ByteString.copyFrom(paramSeedInfo.seedData);
      builder.copyOnWrite();
      AwVariationsSeedOuterClass.AwVariationsSeed.access$1200((AwVariationsSeedOuterClass.AwVariationsSeed)builder.instance, byteString);
      GeneratedMessageLite generatedMessageLite = builder.buildPartial();
      if (generatedMessageLite.isInitialized()) {
        AwVariationsSeedOuterClass.AwVariationsSeed awVariationsSeed = (AwVariationsSeedOuterClass.AwVariationsSeed)generatedMessageLite;
        CodedOutputStream codedOutputStream = CodedOutputStream.newInstance(paramFileOutputStream, CodedOutputStream.computePreferredBufferSize(awVariationsSeed.getSerializedSize()));
        awVariationsSeed.writeTo(codedOutputStream);
        codedOutputStream.flush();
        closeSafely(paramFileOutputStream);
        return true;
      } 
      throw new UninitializedMessageException();
    } catch (IOException iOException) {
      StringBuilder stringBuilder = new StringBuilder("Failed writing seed file: ");
      stringBuilder.append(iOException.getMessage());
      Log.e("VariationsUtils", stringBuilder.toString(), new Object[0]);
      closeSafely(paramFileOutputStream);
      return false;
    } finally {}
    closeSafely(paramFileOutputStream);
    throw paramSeedInfo;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\VariationsUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */