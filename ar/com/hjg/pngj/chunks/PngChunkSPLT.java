package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;

public class PngChunkSPLT extends PngChunkMultiple {
  private String h;
  
  private int i;
  
  private int[] j;
  
  public PngChunkSPLT(ImageInfo paramImageInfo) {
    super("sPLT", paramImageInfo);
  }
  
  public void a(ChunkRaw paramChunkRaw) {
    // Byte code:
    //   0: iconst_0
    //   1: istore #5
    //   3: iconst_0
    //   4: istore_2
    //   5: iload_2
    //   6: aload_1
    //   7: getfield d : [B
    //   10: arraylength
    //   11: if_icmpge -> 33
    //   14: aload_1
    //   15: getfield d : [B
    //   18: iload_2
    //   19: baload
    //   20: ifne -> 26
    //   23: goto -> 35
    //   26: iload_2
    //   27: iconst_1
    //   28: iadd
    //   29: istore_2
    //   30: goto -> 5
    //   33: iconst_m1
    //   34: istore_2
    //   35: iload_2
    //   36: ifle -> 389
    //   39: iload_2
    //   40: aload_1
    //   41: getfield d : [B
    //   44: arraylength
    //   45: iconst_2
    //   46: isub
    //   47: if_icmpgt -> 389
    //   50: aload_0
    //   51: aload_1
    //   52: getfield d : [B
    //   55: iconst_0
    //   56: iload_2
    //   57: invokestatic a : ([BII)Ljava/lang/String;
    //   60: putfield h : Ljava/lang/String;
    //   63: aload_0
    //   64: aload_1
    //   65: getfield d : [B
    //   68: iload_2
    //   69: iconst_1
    //   70: iadd
    //   71: invokestatic a : ([BI)I
    //   74: putfield i : I
    //   77: iload_2
    //   78: iconst_2
    //   79: iadd
    //   80: istore #4
    //   82: aload_1
    //   83: getfield d : [B
    //   86: arraylength
    //   87: istore_3
    //   88: aload_0
    //   89: getfield i : I
    //   92: bipush #8
    //   94: if_icmpne -> 103
    //   97: bipush #6
    //   99: istore_2
    //   100: goto -> 106
    //   103: bipush #10
    //   105: istore_2
    //   106: iload_3
    //   107: iload #4
    //   109: isub
    //   110: iload_2
    //   111: idiv
    //   112: istore #9
    //   114: aload_0
    //   115: iload #9
    //   117: iconst_5
    //   118: imul
    //   119: newarray int
    //   121: putfield j : [I
    //   124: iconst_0
    //   125: istore_3
    //   126: iload #5
    //   128: istore_2
    //   129: iload_2
    //   130: iload #9
    //   132: if_icmpge -> 388
    //   135: aload_0
    //   136: getfield i : I
    //   139: bipush #8
    //   141: if_icmpne -> 231
    //   144: aload_1
    //   145: getfield d : [B
    //   148: astore #12
    //   150: iload #4
    //   152: iconst_1
    //   153: iadd
    //   154: istore #5
    //   156: aload #12
    //   158: iload #4
    //   160: invokestatic a : ([BI)I
    //   163: istore #7
    //   165: aload_1
    //   166: getfield d : [B
    //   169: astore #12
    //   171: iload #5
    //   173: iconst_1
    //   174: iadd
    //   175: istore #4
    //   177: aload #12
    //   179: iload #5
    //   181: invokestatic a : ([BI)I
    //   184: istore #8
    //   186: aload_1
    //   187: getfield d : [B
    //   190: astore #12
    //   192: iload #4
    //   194: iconst_1
    //   195: iadd
    //   196: istore #5
    //   198: aload #12
    //   200: iload #4
    //   202: invokestatic a : ([BI)I
    //   205: istore #6
    //   207: aload_1
    //   208: getfield d : [B
    //   211: astore #12
    //   213: iload #5
    //   215: iconst_1
    //   216: iadd
    //   217: istore #4
    //   219: aload #12
    //   221: iload #5
    //   223: invokestatic a : ([BI)I
    //   226: istore #5
    //   228: goto -> 299
    //   231: aload_1
    //   232: getfield d : [B
    //   235: iload #4
    //   237: invokestatic b : ([BI)I
    //   240: istore #7
    //   242: iload #4
    //   244: iconst_2
    //   245: iadd
    //   246: istore #4
    //   248: aload_1
    //   249: getfield d : [B
    //   252: iload #4
    //   254: invokestatic b : ([BI)I
    //   257: istore #8
    //   259: iload #4
    //   261: iconst_2
    //   262: iadd
    //   263: istore #4
    //   265: aload_1
    //   266: getfield d : [B
    //   269: iload #4
    //   271: invokestatic b : ([BI)I
    //   274: istore #6
    //   276: iload #4
    //   278: iconst_2
    //   279: iadd
    //   280: istore #4
    //   282: aload_1
    //   283: getfield d : [B
    //   286: iload #4
    //   288: invokestatic b : ([BI)I
    //   291: istore #5
    //   293: iload #4
    //   295: iconst_2
    //   296: iadd
    //   297: istore #4
    //   299: aload_1
    //   300: getfield d : [B
    //   303: iload #4
    //   305: invokestatic b : ([BI)I
    //   308: istore #10
    //   310: aload_0
    //   311: getfield j : [I
    //   314: astore #12
    //   316: iload_3
    //   317: iconst_1
    //   318: iadd
    //   319: istore #11
    //   321: aload #12
    //   323: iload_3
    //   324: iload #7
    //   326: iastore
    //   327: iload #11
    //   329: iconst_1
    //   330: iadd
    //   331: istore_3
    //   332: aload #12
    //   334: iload #11
    //   336: iload #8
    //   338: iastore
    //   339: iload_3
    //   340: iconst_1
    //   341: iadd
    //   342: istore #7
    //   344: aload #12
    //   346: iload_3
    //   347: iload #6
    //   349: iastore
    //   350: iload #7
    //   352: iconst_1
    //   353: iadd
    //   354: istore #6
    //   356: aload #12
    //   358: iload #7
    //   360: iload #5
    //   362: iastore
    //   363: iload #6
    //   365: iconst_1
    //   366: iadd
    //   367: istore_3
    //   368: aload #12
    //   370: iload #6
    //   372: iload #10
    //   374: iastore
    //   375: iload_2
    //   376: iconst_1
    //   377: iadd
    //   378: istore_2
    //   379: iload #4
    //   381: iconst_2
    //   382: iadd
    //   383: istore #4
    //   385: goto -> 129
    //   388: return
    //   389: new ar/com/hjg/pngj/PngjException
    //   392: dup
    //   393: ldc 'bad sPLT chunk: no separator found'
    //   395: invokespecial <init> : (Ljava/lang/String;)V
    //   398: athrow
  }
  
  public String e() {
    return this.h;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\chunks\PngChunkSPLT.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */