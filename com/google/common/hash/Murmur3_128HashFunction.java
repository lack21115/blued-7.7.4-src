package com.google.common.hash;

import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@Immutable
final class Murmur3_128HashFunction extends AbstractHashFunction implements Serializable {
  static final HashFunction a = new Murmur3_128HashFunction(0);
  
  static final HashFunction b = new Murmur3_128HashFunction(Hashing.a);
  
  private final int c;
  
  Murmur3_128HashFunction(int paramInt) {
    this.c = paramInt;
  }
  
  public Hasher a() {
    return new Murmur3_128Hasher(this.c);
  }
  
  public int b() {
    return 128;
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    boolean bool = paramObject instanceof Murmur3_128HashFunction;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool) {
      paramObject = paramObject;
      bool1 = bool2;
      if (this.c == ((Murmur3_128HashFunction)paramObject).c)
        bool1 = true; 
    } 
    return bool1;
  }
  
  public int hashCode() {
    return getClass().hashCode() ^ this.c;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Hashing.murmur3_128(");
    stringBuilder.append(this.c);
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
  
  static final class Murmur3_128Hasher extends AbstractStreamingHasher {
    private long a;
    
    private long b;
    
    private int c;
    
    Murmur3_128Hasher(int param1Int) {
      super(16);
      long l = param1Int;
      this.a = l;
      this.b = l;
      this.c = 0;
    }
    
    private void a(long param1Long1, long param1Long2) {
      long l = this.a;
      this.a = d(param1Long1) ^ l;
      this.a = Long.rotateLeft(this.a, 27);
      param1Long1 = this.a;
      l = this.b;
      this.a = param1Long1 + l;
      this.a = this.a * 5L + 1390208809L;
      this.b = e(param1Long2) ^ l;
      this.b = Long.rotateLeft(this.b, 31);
      this.b += this.a;
      this.b = this.b * 5L + 944331445L;
    }
    
    private static long c(long param1Long) {
      param1Long = (param1Long ^ param1Long >>> 33L) * -49064778989728563L;
      param1Long = (param1Long ^ param1Long >>> 33L) * -4265267296055464877L;
      return param1Long ^ param1Long >>> 33L;
    }
    
    private static long d(long param1Long) {
      return Long.rotateLeft(param1Long * -8663945395140668459L, 31) * 5545529020109919103L;
    }
    
    private static long e(long param1Long) {
      return Long.rotateLeft(param1Long * 5545529020109919103L, 33) * -8663945395140668459L;
    }
    
    protected void a(ByteBuffer param1ByteBuffer) {
      a(param1ByteBuffer.getLong(), param1ByteBuffer.getLong());
      this.c += 16;
    }
    
    protected HashCode b() {
      long l1 = this.a;
      int i = this.c;
      this.a = l1 ^ i;
      this.b ^= i;
      long l2 = this.a;
      l1 = this.b;
      this.a = l2 + l1;
      l2 = this.a;
      this.b = l1 + l2;
      this.a = c(l2);
      this.b = c(this.b);
      l1 = this.a;
      l2 = this.b;
      this.a = l1 + l2;
      this.b = l2 + this.a;
      return HashCode.a(ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.a).putLong(this.b).array());
    }
    
    protected void b(ByteBuffer param1ByteBuffer) {
      // Byte code:
      //   0: aload_0
      //   1: aload_0
      //   2: getfield c : I
      //   5: aload_1
      //   6: invokevirtual remaining : ()I
      //   9: iadd
      //   10: putfield c : I
      //   13: aload_1
      //   14: invokevirtual remaining : ()I
      //   17: tableswitch default -> 92, 1 -> 376, 2 -> 356, 3 -> 336, 4 -> 316, 5 -> 296, 6 -> 276, 7 -> 257, 8 -> 244, 9 -> 226, 10 -> 205, 11 -> 184, 12 -> 163, 13 -> 142, 14 -> 121, 15 -> 102
      //   92: new java/lang/AssertionError
      //   95: dup
      //   96: ldc 'Should never get here.'
      //   98: invokespecial <init> : (Ljava/lang/Object;)V
      //   101: athrow
      //   102: aload_1
      //   103: bipush #14
      //   105: invokevirtual get : (I)B
      //   108: invokestatic a : (B)I
      //   111: i2l
      //   112: bipush #48
      //   114: lshl
      //   115: lconst_0
      //   116: lxor
      //   117: lstore_2
      //   118: goto -> 123
      //   121: lconst_0
      //   122: lstore_2
      //   123: lload_2
      //   124: aload_1
      //   125: bipush #13
      //   127: invokevirtual get : (I)B
      //   130: invokestatic a : (B)I
      //   133: i2l
      //   134: bipush #40
      //   136: lshl
      //   137: lxor
      //   138: lstore_2
      //   139: goto -> 144
      //   142: lconst_0
      //   143: lstore_2
      //   144: lload_2
      //   145: aload_1
      //   146: bipush #12
      //   148: invokevirtual get : (I)B
      //   151: invokestatic a : (B)I
      //   154: i2l
      //   155: bipush #32
      //   157: lshl
      //   158: lxor
      //   159: lstore_2
      //   160: goto -> 165
      //   163: lconst_0
      //   164: lstore_2
      //   165: lload_2
      //   166: aload_1
      //   167: bipush #11
      //   169: invokevirtual get : (I)B
      //   172: invokestatic a : (B)I
      //   175: i2l
      //   176: bipush #24
      //   178: lshl
      //   179: lxor
      //   180: lstore_2
      //   181: goto -> 186
      //   184: lconst_0
      //   185: lstore_2
      //   186: lload_2
      //   187: aload_1
      //   188: bipush #10
      //   190: invokevirtual get : (I)B
      //   193: invokestatic a : (B)I
      //   196: i2l
      //   197: bipush #16
      //   199: lshl
      //   200: lxor
      //   201: lstore_2
      //   202: goto -> 207
      //   205: lconst_0
      //   206: lstore_2
      //   207: lload_2
      //   208: aload_1
      //   209: bipush #9
      //   211: invokevirtual get : (I)B
      //   214: invokestatic a : (B)I
      //   217: i2l
      //   218: bipush #8
      //   220: lshl
      //   221: lxor
      //   222: lstore_2
      //   223: goto -> 228
      //   226: lconst_0
      //   227: lstore_2
      //   228: lload_2
      //   229: aload_1
      //   230: bipush #8
      //   232: invokevirtual get : (I)B
      //   235: invokestatic a : (B)I
      //   238: i2l
      //   239: lxor
      //   240: lstore_2
      //   241: goto -> 246
      //   244: lconst_0
      //   245: lstore_2
      //   246: aload_1
      //   247: invokevirtual getLong : ()J
      //   250: lconst_0
      //   251: lxor
      //   252: lstore #4
      //   254: goto -> 393
      //   257: aload_1
      //   258: bipush #6
      //   260: invokevirtual get : (I)B
      //   263: invokestatic a : (B)I
      //   266: i2l
      //   267: bipush #48
      //   269: lshl
      //   270: lconst_0
      //   271: lxor
      //   272: lstore_2
      //   273: goto -> 278
      //   276: lconst_0
      //   277: lstore_2
      //   278: lload_2
      //   279: aload_1
      //   280: iconst_5
      //   281: invokevirtual get : (I)B
      //   284: invokestatic a : (B)I
      //   287: i2l
      //   288: bipush #40
      //   290: lshl
      //   291: lxor
      //   292: lstore_2
      //   293: goto -> 298
      //   296: lconst_0
      //   297: lstore_2
      //   298: lload_2
      //   299: aload_1
      //   300: iconst_4
      //   301: invokevirtual get : (I)B
      //   304: invokestatic a : (B)I
      //   307: i2l
      //   308: bipush #32
      //   310: lshl
      //   311: lxor
      //   312: lstore_2
      //   313: goto -> 318
      //   316: lconst_0
      //   317: lstore_2
      //   318: lload_2
      //   319: aload_1
      //   320: iconst_3
      //   321: invokevirtual get : (I)B
      //   324: invokestatic a : (B)I
      //   327: i2l
      //   328: bipush #24
      //   330: lshl
      //   331: lxor
      //   332: lstore_2
      //   333: goto -> 338
      //   336: lconst_0
      //   337: lstore_2
      //   338: lload_2
      //   339: aload_1
      //   340: iconst_2
      //   341: invokevirtual get : (I)B
      //   344: invokestatic a : (B)I
      //   347: i2l
      //   348: bipush #16
      //   350: lshl
      //   351: lxor
      //   352: lstore_2
      //   353: goto -> 358
      //   356: lconst_0
      //   357: lstore_2
      //   358: lload_2
      //   359: aload_1
      //   360: iconst_1
      //   361: invokevirtual get : (I)B
      //   364: invokestatic a : (B)I
      //   367: i2l
      //   368: bipush #8
      //   370: lshl
      //   371: lxor
      //   372: lstore_2
      //   373: goto -> 378
      //   376: lconst_0
      //   377: lstore_2
      //   378: aload_1
      //   379: iconst_0
      //   380: invokevirtual get : (I)B
      //   383: invokestatic a : (B)I
      //   386: i2l
      //   387: lload_2
      //   388: lxor
      //   389: lstore #4
      //   391: lconst_0
      //   392: lstore_2
      //   393: aload_0
      //   394: getfield a : J
      //   397: lstore #6
      //   399: aload_0
      //   400: lload #4
      //   402: invokestatic d : (J)J
      //   405: lload #6
      //   407: lxor
      //   408: putfield a : J
      //   411: aload_0
      //   412: getfield b : J
      //   415: lstore #4
      //   417: aload_0
      //   418: lload_2
      //   419: invokestatic e : (J)J
      //   422: lload #4
      //   424: lxor
      //   425: putfield b : J
      //   428: return
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\hash\Murmur3_128HashFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */