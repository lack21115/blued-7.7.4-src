package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;

public class PngChunkZTXT extends PngChunkTextVar {
  public PngChunkZTXT(ImageInfo paramImageInfo) {
    super("zTXt", paramImageInfo);
  }
  
  public void a(ChunkRaw paramChunkRaw) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iload_2
    //   3: aload_1
    //   4: getfield d : [B
    //   7: arraylength
    //   8: if_icmpge -> 29
    //   11: iload_2
    //   12: istore_3
    //   13: aload_1
    //   14: getfield d : [B
    //   17: iload_2
    //   18: baload
    //   19: ifeq -> 31
    //   22: iload_2
    //   23: iconst_1
    //   24: iadd
    //   25: istore_2
    //   26: goto -> 2
    //   29: iconst_m1
    //   30: istore_3
    //   31: iload_3
    //   32: iflt -> 108
    //   35: iload_3
    //   36: aload_1
    //   37: getfield d : [B
    //   40: arraylength
    //   41: iconst_2
    //   42: isub
    //   43: if_icmpgt -> 108
    //   46: aload_0
    //   47: aload_1
    //   48: getfield d : [B
    //   51: iconst_0
    //   52: iload_3
    //   53: invokestatic a : ([BII)Ljava/lang/String;
    //   56: putfield h : Ljava/lang/String;
    //   59: aload_1
    //   60: getfield d : [B
    //   63: iload_3
    //   64: iconst_1
    //   65: iadd
    //   66: baload
    //   67: ifne -> 98
    //   70: aload_0
    //   71: aload_1
    //   72: getfield d : [B
    //   75: iload_3
    //   76: iconst_2
    //   77: iadd
    //   78: aload_1
    //   79: getfield d : [B
    //   82: arraylength
    //   83: iload_3
    //   84: isub
    //   85: iconst_2
    //   86: isub
    //   87: iconst_0
    //   88: invokestatic a : ([BIIZ)[B
    //   91: invokestatic a : ([B)Ljava/lang/String;
    //   94: putfield i : Ljava/lang/String;
    //   97: return
    //   98: new ar/com/hjg/pngj/PngjException
    //   101: dup
    //   102: ldc 'bad zTXt chunk: unknown compression method'
    //   104: invokespecial <init> : (Ljava/lang/String;)V
    //   107: athrow
    //   108: new ar/com/hjg/pngj/PngjException
    //   111: dup
    //   112: ldc 'bad zTXt chunk: no separator found'
    //   114: invokespecial <init> : (Ljava/lang/String;)V
    //   117: athrow
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\chunks\PngChunkZTXT.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */