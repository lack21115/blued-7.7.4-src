package ar.com.hjg.pngj;

import ar.com.hjg.pngj.chunks.ChunkRaw;

public abstract class ChunkReader {
  public final ChunkReaderMode a;
  
  protected int b;
  
  private final ChunkRaw c;
  
  private boolean d;
  
  private int e;
  
  public ChunkReader(int paramInt, String paramString, long paramLong, ChunkReaderMode paramChunkReaderMode) {
    boolean bool = false;
    this.b = 0;
    this.e = 0;
    if (paramChunkReaderMode != null && paramString.length() == 4 && paramInt >= 0) {
      boolean bool1;
      this.a = paramChunkReaderMode;
      if (paramChunkReaderMode == ChunkReaderMode.a) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      this.c = new ChunkRaw(paramInt, paramString, bool1);
      this.c.a(paramLong);
      if (paramChunkReaderMode == ChunkReaderMode.c) {
        bool1 = bool;
      } else {
        bool1 = true;
      } 
      this.d = bool1;
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Bad chunk paramenters: ");
    stringBuilder.append(paramChunkReaderMode);
    throw new PngjExceptionInternal(stringBuilder.toString());
  }
  
  public final int a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    // Byte code:
    //   0: iload_3
    //   1: ifne -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: iload_3
    //   7: iflt -> 374
    //   10: aload_0
    //   11: getfield b : I
    //   14: ifne -> 49
    //   17: aload_0
    //   18: getfield e : I
    //   21: ifne -> 49
    //   24: aload_0
    //   25: getfield d : Z
    //   28: ifeq -> 49
    //   31: aload_0
    //   32: getfield c : Lar/com/hjg/pngj/chunks/ChunkRaw;
    //   35: astore #7
    //   37: aload #7
    //   39: aload #7
    //   41: getfield b : [B
    //   44: iconst_0
    //   45: iconst_4
    //   46: invokevirtual a : ([BII)V
    //   49: aload_0
    //   50: getfield c : Lar/com/hjg/pngj/chunks/ChunkRaw;
    //   53: getfield a : I
    //   56: aload_0
    //   57: getfield b : I
    //   60: isub
    //   61: istore #4
    //   63: iload #4
    //   65: istore #5
    //   67: iload #4
    //   69: iload_3
    //   70: if_icmple -> 76
    //   73: iload_3
    //   74: istore #5
    //   76: iload #5
    //   78: ifgt -> 94
    //   81: iload_2
    //   82: istore #6
    //   84: iload_3
    //   85: istore #4
    //   87: aload_0
    //   88: getfield e : I
    //   91: ifne -> 219
    //   94: aload_0
    //   95: getfield d : Z
    //   98: ifeq -> 127
    //   101: aload_0
    //   102: getfield a : Lar/com/hjg/pngj/ChunkReader$ChunkReaderMode;
    //   105: getstatic ar/com/hjg/pngj/ChunkReader$ChunkReaderMode.a : Lar/com/hjg/pngj/ChunkReader$ChunkReaderMode;
    //   108: if_acmpeq -> 127
    //   111: iload #5
    //   113: ifle -> 127
    //   116: aload_0
    //   117: getfield c : Lar/com/hjg/pngj/chunks/ChunkRaw;
    //   120: aload_1
    //   121: iload_2
    //   122: iload #5
    //   124: invokevirtual a : ([BII)V
    //   127: aload_0
    //   128: getfield a : Lar/com/hjg/pngj/ChunkReader$ChunkReaderMode;
    //   131: getstatic ar/com/hjg/pngj/ChunkReader$ChunkReaderMode.a : Lar/com/hjg/pngj/ChunkReader$ChunkReaderMode;
    //   134: if_acmpne -> 174
    //   137: aload_0
    //   138: getfield c : Lar/com/hjg/pngj/chunks/ChunkRaw;
    //   141: getfield d : [B
    //   144: aload_1
    //   145: if_acmpeq -> 196
    //   148: iload #5
    //   150: ifle -> 196
    //   153: aload_1
    //   154: iload_2
    //   155: aload_0
    //   156: getfield c : Lar/com/hjg/pngj/chunks/ChunkRaw;
    //   159: getfield d : [B
    //   162: aload_0
    //   163: getfield b : I
    //   166: iload #5
    //   168: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   171: goto -> 196
    //   174: aload_0
    //   175: getfield a : Lar/com/hjg/pngj/ChunkReader$ChunkReaderMode;
    //   178: getstatic ar/com/hjg/pngj/ChunkReader$ChunkReaderMode.b : Lar/com/hjg/pngj/ChunkReader$ChunkReaderMode;
    //   181: if_acmpne -> 196
    //   184: aload_0
    //   185: aload_0
    //   186: getfield b : I
    //   189: aload_1
    //   190: iload_2
    //   191: iload #5
    //   193: invokevirtual a : (I[BII)V
    //   196: aload_0
    //   197: aload_0
    //   198: getfield b : I
    //   201: iload #5
    //   203: iadd
    //   204: putfield b : I
    //   207: iload_2
    //   208: iload #5
    //   210: iadd
    //   211: istore #6
    //   213: iload_3
    //   214: iload #5
    //   216: isub
    //   217: istore #4
    //   219: aload_0
    //   220: getfield b : I
    //   223: aload_0
    //   224: getfield c : Lar/com/hjg/pngj/chunks/ChunkRaw;
    //   227: getfield a : I
    //   230: if_icmpne -> 367
    //   233: iconst_4
    //   234: aload_0
    //   235: getfield e : I
    //   238: isub
    //   239: istore_2
    //   240: iload_2
    //   241: iload #4
    //   243: if_icmple -> 249
    //   246: goto -> 252
    //   249: iload_2
    //   250: istore #4
    //   252: iload #4
    //   254: istore_2
    //   255: iload #4
    //   257: ifle -> 369
    //   260: aload_1
    //   261: aload_0
    //   262: getfield c : Lar/com/hjg/pngj/chunks/ChunkRaw;
    //   265: getfield e : [B
    //   268: if_acmpeq -> 290
    //   271: aload_1
    //   272: iload #6
    //   274: aload_0
    //   275: getfield c : Lar/com/hjg/pngj/chunks/ChunkRaw;
    //   278: getfield e : [B
    //   281: aload_0
    //   282: getfield e : I
    //   285: iload #4
    //   287: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   290: aload_0
    //   291: aload_0
    //   292: getfield e : I
    //   295: iload #4
    //   297: iadd
    //   298: putfield e : I
    //   301: iload #4
    //   303: istore_2
    //   304: aload_0
    //   305: getfield e : I
    //   308: iconst_4
    //   309: if_icmpne -> 369
    //   312: aload_0
    //   313: getfield d : Z
    //   316: ifeq -> 357
    //   319: aload_0
    //   320: getfield a : Lar/com/hjg/pngj/ChunkReader$ChunkReaderMode;
    //   323: getstatic ar/com/hjg/pngj/ChunkReader$ChunkReaderMode.a : Lar/com/hjg/pngj/ChunkReader$ChunkReaderMode;
    //   326: if_acmpne -> 350
    //   329: aload_0
    //   330: getfield c : Lar/com/hjg/pngj/chunks/ChunkRaw;
    //   333: astore_1
    //   334: aload_1
    //   335: aload_1
    //   336: getfield d : [B
    //   339: iconst_0
    //   340: aload_0
    //   341: getfield c : Lar/com/hjg/pngj/chunks/ChunkRaw;
    //   344: getfield a : I
    //   347: invokevirtual a : ([BII)V
    //   350: aload_0
    //   351: getfield c : Lar/com/hjg/pngj/chunks/ChunkRaw;
    //   354: invokevirtual b : ()V
    //   357: aload_0
    //   358: invokevirtual c : ()V
    //   361: iload #4
    //   363: istore_2
    //   364: goto -> 369
    //   367: iconst_0
    //   368: istore_2
    //   369: iload #5
    //   371: iload_2
    //   372: iadd
    //   373: ireturn
    //   374: new ar/com/hjg/pngj/PngjException
    //   377: dup
    //   378: ldc 'negative length??'
    //   380: invokespecial <init> : (Ljava/lang/String;)V
    //   383: athrow
  }
  
  public ChunkRaw a() {
    return this.c;
  }
  
  protected abstract void a(int paramInt1, byte[] paramArrayOfbyte, int paramInt2, int paramInt3);
  
  public void a(boolean paramBoolean) {
    if (this.b == 0 || !paramBoolean || this.d) {
      this.d = paramBoolean;
      return;
    } 
    throw new PngjException("too late!");
  }
  
  public final boolean b() {
    return (this.e == 4);
  }
  
  protected abstract void c();
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null)
      return false; 
    if (getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    ChunkRaw chunkRaw = this.c;
    if (chunkRaw == null) {
      if (((ChunkReader)paramObject).c != null)
        return false; 
    } else if (!chunkRaw.equals(((ChunkReader)paramObject).c)) {
      return false;
    } 
    return true;
  }
  
  public int hashCode() {
    int i;
    ChunkRaw chunkRaw = this.c;
    if (chunkRaw == null) {
      i = 0;
    } else {
      i = chunkRaw.hashCode();
    } 
    return 31 + i;
  }
  
  public String toString() {
    return this.c.toString();
  }
  
  public enum ChunkReaderMode {
    a, b, c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\ChunkReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */