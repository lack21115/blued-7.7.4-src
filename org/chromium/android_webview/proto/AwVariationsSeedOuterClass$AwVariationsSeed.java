package org.chromium.android_webview.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import com.google.protobuf.UninitializedMessageException;
import java.io.InputStream;

public final class AwVariationsSeedOuterClass$AwVariationsSeed extends GeneratedMessageLite implements AwVariationsSeedOuterClass$AwVariationsSeedOrBuilder {
  private static final AwVariationsSeedOuterClass$AwVariationsSeed DEFAULT_INSTANCE = new AwVariationsSeedOuterClass$AwVariationsSeed();
  
  private static volatile Parser PARSER;
  
  private int bitField0_;
  
  public String country_ = "";
  
  public String date_ = "";
  
  public boolean isGzipCompressed_;
  
  public ByteString seedData_ = ByteString.EMPTY;
  
  public String signature_ = "";
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static AwVariationsSeedOuterClass$AwVariationsSeed$Builder newBuilder() {
    AwVariationsSeedOuterClass$AwVariationsSeed awVariationsSeedOuterClass$AwVariationsSeed = DEFAULT_INSTANCE;
    GeneratedMessageLite.Builder builder = (GeneratedMessageLite.Builder)awVariationsSeedOuterClass$AwVariationsSeed.dynamicMethod(GeneratedMessageLite.MethodToInvoke.NEW_BUILDER, null, null);
    builder.mergeFrom(awVariationsSeedOuterClass$AwVariationsSeed);
    return (AwVariationsSeedOuterClass$AwVariationsSeed$Builder)builder;
  }
  
  public static AwVariationsSeedOuterClass$AwVariationsSeed parseFrom(InputStream paramInputStream) {
    CodedInputStream codedInputStream;
    CodedInputStream.StreamDecoder streamDecoder;
    AwVariationsSeedOuterClass$AwVariationsSeed awVariationsSeedOuterClass$AwVariationsSeed = DEFAULT_INSTANCE;
    if (paramInputStream == null) {
      codedInputStream = CodedInputStream.newInstance(Internal.EMPTY_BYTE_ARRAY);
    } else {
      streamDecoder = new CodedInputStream.StreamDecoder((InputStream)codedInputStream, 4096, (byte)0);
    } 
    GeneratedMessageLite generatedMessageLite = GeneratedMessageLite.parsePartialFrom(awVariationsSeedOuterClass$AwVariationsSeed, (CodedInputStream)streamDecoder, ExtensionRegistryLite.getEmptyRegistry());
    if (generatedMessageLite == null || generatedMessageLite.isInitialized())
      return (AwVariationsSeedOuterClass$AwVariationsSeed)generatedMessageLite; 
    throw (new UninitializedMessageException()).asInvalidProtocolBufferException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic org/chromium/android_webview/proto/AwVariationsSeedOuterClass$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 550, 2 -> 546, 3 -> 544, 4 -> 535, 5 -> 373, 6 -> 108, 7 -> 369, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic org/chromium/android_webview/proto/AwVariationsSeedOuterClass$AwVariationsSeed.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 104
    //   70: ldc org/chromium/android_webview/proto/AwVariationsSeedOuterClass$AwVariationsSeed
    //   72: monitorenter
    //   73: getstatic org/chromium/android_webview/proto/AwVariationsSeedOuterClass$AwVariationsSeed.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 92
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: dup
    //   83: getstatic org/chromium/android_webview/proto/AwVariationsSeedOuterClass$AwVariationsSeed.DEFAULT_INSTANCE : Lorg/chromium/android_webview/proto/AwVariationsSeedOuterClass$AwVariationsSeed;
    //   86: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   89: putstatic org/chromium/android_webview/proto/AwVariationsSeedOuterClass$AwVariationsSeed.PARSER : Lcom/google/protobuf/Parser;
    //   92: ldc org/chromium/android_webview/proto/AwVariationsSeedOuterClass$AwVariationsSeed
    //   94: monitorexit
    //   95: goto -> 104
    //   98: astore_1
    //   99: ldc org/chromium/android_webview/proto/AwVariationsSeedOuterClass$AwVariationsSeed
    //   101: monitorexit
    //   102: aload_1
    //   103: athrow
    //   104: getstatic org/chromium/android_webview/proto/AwVariationsSeedOuterClass$AwVariationsSeed.PARSER : Lcom/google/protobuf/Parser;
    //   107: areturn
    //   108: aload_2
    //   109: checkcast com/google/protobuf/CodedInputStream
    //   112: astore_1
    //   113: iconst_0
    //   114: istore #4
    //   116: iload #4
    //   118: ifne -> 369
    //   121: aload_1
    //   122: invokevirtual readTag : ()I
    //   125: istore #5
    //   127: iload #5
    //   129: ifeq -> 327
    //   132: iload #5
    //   134: bipush #10
    //   136: if_icmpeq -> 304
    //   139: iload #5
    //   141: bipush #18
    //   143: if_icmpeq -> 281
    //   146: iload #5
    //   148: bipush #26
    //   150: if_icmpeq -> 258
    //   153: iload #5
    //   155: bipush #32
    //   157: if_icmpeq -> 236
    //   160: iload #5
    //   162: bipush #42
    //   164: if_icmpeq -> 214
    //   167: iload #5
    //   169: bipush #7
    //   171: iand
    //   172: iconst_4
    //   173: if_icmpne -> 182
    //   176: iconst_0
    //   177: istore #6
    //   179: goto -> 558
    //   182: aload_0
    //   183: getfield unknownFields : Lcom/google/protobuf/UnknownFieldSetLite;
    //   186: invokestatic getDefaultInstance : ()Lcom/google/protobuf/UnknownFieldSetLite;
    //   189: if_acmpne -> 199
    //   192: aload_0
    //   193: invokestatic newInstance : ()Lcom/google/protobuf/UnknownFieldSetLite;
    //   196: putfield unknownFields : Lcom/google/protobuf/UnknownFieldSetLite;
    //   199: aload_0
    //   200: getfield unknownFields : Lcom/google/protobuf/UnknownFieldSetLite;
    //   203: iload #5
    //   205: aload_1
    //   206: invokevirtual mergeFieldFrom : (ILcom/google/protobuf/CodedInputStream;)Z
    //   209: istore #6
    //   211: goto -> 558
    //   214: aload_0
    //   215: aload_0
    //   216: getfield bitField0_ : I
    //   219: bipush #16
    //   221: ior
    //   222: putfield bitField0_ : I
    //   225: aload_0
    //   226: aload_1
    //   227: invokevirtual readBytes : ()Lcom/google/protobuf/ByteString;
    //   230: putfield seedData_ : Lcom/google/protobuf/ByteString;
    //   233: goto -> 566
    //   236: aload_0
    //   237: aload_0
    //   238: getfield bitField0_ : I
    //   241: bipush #8
    //   243: ior
    //   244: putfield bitField0_ : I
    //   247: aload_0
    //   248: aload_1
    //   249: invokevirtual readBool : ()Z
    //   252: putfield isGzipCompressed_ : Z
    //   255: goto -> 116
    //   258: aload_1
    //   259: invokevirtual readString : ()Ljava/lang/String;
    //   262: astore_2
    //   263: aload_0
    //   264: aload_0
    //   265: getfield bitField0_ : I
    //   268: iconst_4
    //   269: ior
    //   270: putfield bitField0_ : I
    //   273: aload_0
    //   274: aload_2
    //   275: putfield date_ : Ljava/lang/String;
    //   278: goto -> 116
    //   281: aload_1
    //   282: invokevirtual readString : ()Ljava/lang/String;
    //   285: astore_2
    //   286: aload_0
    //   287: aload_0
    //   288: getfield bitField0_ : I
    //   291: iconst_2
    //   292: ior
    //   293: putfield bitField0_ : I
    //   296: aload_0
    //   297: aload_2
    //   298: putfield country_ : Ljava/lang/String;
    //   301: goto -> 116
    //   304: aload_1
    //   305: invokevirtual readString : ()Ljava/lang/String;
    //   308: astore_2
    //   309: aload_0
    //   310: aload_0
    //   311: getfield bitField0_ : I
    //   314: iconst_1
    //   315: ior
    //   316: putfield bitField0_ : I
    //   319: aload_0
    //   320: aload_2
    //   321: putfield signature_ : Ljava/lang/String;
    //   324: goto -> 116
    //   327: iconst_1
    //   328: istore #4
    //   330: goto -> 116
    //   333: astore_1
    //   334: goto -> 367
    //   337: astore_1
    //   338: new java/lang/RuntimeException
    //   341: dup
    //   342: new com/google/protobuf/InvalidProtocolBufferException
    //   345: dup
    //   346: aload_1
    //   347: invokevirtual getMessage : ()Ljava/lang/String;
    //   350: invokespecial <init> : (Ljava/lang/String;)V
    //   353: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   356: athrow
    //   357: astore_1
    //   358: new java/lang/RuntimeException
    //   361: dup
    //   362: aload_1
    //   363: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   366: athrow
    //   367: aload_1
    //   368: athrow
    //   369: getstatic org/chromium/android_webview/proto/AwVariationsSeedOuterClass$AwVariationsSeed.DEFAULT_INSTANCE : Lorg/chromium/android_webview/proto/AwVariationsSeedOuterClass$AwVariationsSeed;
    //   372: areturn
    //   373: aload_2
    //   374: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   377: astore_1
    //   378: aload_3
    //   379: checkcast org/chromium/android_webview/proto/AwVariationsSeedOuterClass$AwVariationsSeed
    //   382: astore_2
    //   383: aload_0
    //   384: aload_1
    //   385: aload_0
    //   386: invokevirtual hasSignature : ()Z
    //   389: aload_0
    //   390: getfield signature_ : Ljava/lang/String;
    //   393: aload_2
    //   394: invokevirtual hasSignature : ()Z
    //   397: aload_2
    //   398: getfield signature_ : Ljava/lang/String;
    //   401: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   406: putfield signature_ : Ljava/lang/String;
    //   409: aload_0
    //   410: aload_1
    //   411: aload_0
    //   412: invokevirtual hasCountry : ()Z
    //   415: aload_0
    //   416: getfield country_ : Ljava/lang/String;
    //   419: aload_2
    //   420: invokevirtual hasCountry : ()Z
    //   423: aload_2
    //   424: getfield country_ : Ljava/lang/String;
    //   427: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   432: putfield country_ : Ljava/lang/String;
    //   435: aload_0
    //   436: aload_1
    //   437: aload_0
    //   438: invokevirtual hasDate : ()Z
    //   441: aload_0
    //   442: getfield date_ : Ljava/lang/String;
    //   445: aload_2
    //   446: invokevirtual hasDate : ()Z
    //   449: aload_2
    //   450: getfield date_ : Ljava/lang/String;
    //   453: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   458: putfield date_ : Ljava/lang/String;
    //   461: aload_0
    //   462: aload_1
    //   463: aload_0
    //   464: invokevirtual hasIsGzipCompressed : ()Z
    //   467: aload_0
    //   468: getfield isGzipCompressed_ : Z
    //   471: aload_2
    //   472: invokevirtual hasIsGzipCompressed : ()Z
    //   475: aload_2
    //   476: getfield isGzipCompressed_ : Z
    //   479: invokeinterface visitBoolean : (ZZZZ)Z
    //   484: putfield isGzipCompressed_ : Z
    //   487: aload_0
    //   488: aload_1
    //   489: aload_0
    //   490: invokevirtual hasSeedData : ()Z
    //   493: aload_0
    //   494: getfield seedData_ : Lcom/google/protobuf/ByteString;
    //   497: aload_2
    //   498: invokevirtual hasSeedData : ()Z
    //   501: aload_2
    //   502: getfield seedData_ : Lcom/google/protobuf/ByteString;
    //   505: invokeinterface visitByteString : (ZLcom/google/protobuf/ByteString;ZLcom/google/protobuf/ByteString;)Lcom/google/protobuf/ByteString;
    //   510: putfield seedData_ : Lcom/google/protobuf/ByteString;
    //   513: aload_1
    //   514: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   517: if_acmpne -> 533
    //   520: aload_0
    //   521: aload_0
    //   522: getfield bitField0_ : I
    //   525: aload_2
    //   526: getfield bitField0_ : I
    //   529: ior
    //   530: putfield bitField0_ : I
    //   533: aload_0
    //   534: areturn
    //   535: new org/chromium/android_webview/proto/AwVariationsSeedOuterClass$AwVariationsSeed$Builder
    //   538: dup
    //   539: iconst_0
    //   540: invokespecial <init> : (B)V
    //   543: areturn
    //   544: aconst_null
    //   545: areturn
    //   546: getstatic org/chromium/android_webview/proto/AwVariationsSeedOuterClass$AwVariationsSeed.DEFAULT_INSTANCE : Lorg/chromium/android_webview/proto/AwVariationsSeedOuterClass$AwVariationsSeed;
    //   549: areturn
    //   550: new org/chromium/android_webview/proto/AwVariationsSeedOuterClass$AwVariationsSeed
    //   553: dup
    //   554: invokespecial <init> : ()V
    //   557: areturn
    //   558: iload #6
    //   560: ifne -> 566
    //   563: goto -> 327
    //   566: goto -> 116
    // Exception table:
    //   from	to	target	type
    //   73	92	98	finally
    //   92	95	98	finally
    //   99	102	98	finally
    //   121	127	357	com/google/protobuf/InvalidProtocolBufferException
    //   121	127	337	java/io/IOException
    //   121	127	333	finally
    //   182	199	357	com/google/protobuf/InvalidProtocolBufferException
    //   182	199	337	java/io/IOException
    //   182	199	333	finally
    //   199	211	357	com/google/protobuf/InvalidProtocolBufferException
    //   199	211	337	java/io/IOException
    //   199	211	333	finally
    //   214	233	357	com/google/protobuf/InvalidProtocolBufferException
    //   214	233	337	java/io/IOException
    //   214	233	333	finally
    //   236	255	357	com/google/protobuf/InvalidProtocolBufferException
    //   236	255	337	java/io/IOException
    //   236	255	333	finally
    //   258	278	357	com/google/protobuf/InvalidProtocolBufferException
    //   258	278	337	java/io/IOException
    //   258	278	333	finally
    //   281	301	357	com/google/protobuf/InvalidProtocolBufferException
    //   281	301	337	java/io/IOException
    //   281	301	333	finally
    //   304	324	357	com/google/protobuf/InvalidProtocolBufferException
    //   304	324	337	java/io/IOException
    //   304	324	333	finally
    //   338	357	333	finally
    //   358	367	333	finally
  }
  
  public final int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    int j = this.bitField0_;
    i = 0;
    if ((j & 0x1) == 1)
      i = 0 + CodedOutputStream.computeStringSize(1, this.signature_); 
    j = i;
    if ((this.bitField0_ & 0x2) == 2)
      j = i + CodedOutputStream.computeStringSize(2, this.country_); 
    i = j;
    if ((this.bitField0_ & 0x4) == 4)
      i = j + CodedOutputStream.computeStringSize(3, this.date_); 
    j = i;
    if ((this.bitField0_ & 0x8) == 8)
      j = i + CodedOutputStream.computeBoolSize$2563259(4); 
    i = j;
    if ((this.bitField0_ & 0x10) == 16)
      i = j + CodedOutputStream.computeBytesSize(5, this.seedData_); 
    i += this.unknownFields.getSerializedSize();
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public final boolean hasCountry() {
    return ((this.bitField0_ & 0x2) == 2);
  }
  
  public final boolean hasDate() {
    return ((this.bitField0_ & 0x4) == 4);
  }
  
  public final boolean hasIsGzipCompressed() {
    return ((this.bitField0_ & 0x8) == 8);
  }
  
  public final boolean hasSeedData() {
    return ((this.bitField0_ & 0x10) == 16);
  }
  
  public final boolean hasSignature() {
    return ((this.bitField0_ & 0x1) == 1);
  }
  
  public final void writeTo(CodedOutputStream paramCodedOutputStream) {
    if ((this.bitField0_ & 0x1) == 1)
      paramCodedOutputStream.writeString(1, this.signature_); 
    if ((this.bitField0_ & 0x2) == 2)
      paramCodedOutputStream.writeString(2, this.country_); 
    if ((this.bitField0_ & 0x4) == 4)
      paramCodedOutputStream.writeString(3, this.date_); 
    if ((this.bitField0_ & 0x8) == 8)
      paramCodedOutputStream.writeBool(4, this.isGzipCompressed_); 
    if ((this.bitField0_ & 0x10) == 16)
      paramCodedOutputStream.writeBytes(5, this.seedData_); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\proto\AwVariationsSeedOuterClass$AwVariationsSeed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */