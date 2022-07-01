package androidx.core.graphics;

import android.graphics.Path;
import android.util.Log;
import java.util.ArrayList;

public class PathParser {
  private static int a(String paramString, int paramInt) {
    while (paramInt < paramString.length()) {
      char c = paramString.charAt(paramInt);
      if (((c - 65) * (c - 90) <= 0 || (c - 97) * (c - 122) <= 0) && c != 'e' && c != 'E')
        return paramInt; 
      paramInt++;
    } 
    return paramInt;
  }
  
  private static void a(String paramString, int paramInt, ExtractFloatResult paramExtractFloatResult) {
    paramExtractFloatResult.b = false;
    int i = paramInt;
    boolean bool1 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    while (i < paramString.length()) {
      char c = paramString.charAt(i);
      if (c != ' ') {
        if (c != 'E' && c != 'e') {
          switch (c) {
            default:
              bool1 = false;
              break;
            case '.':
              if (!bool3) {
                bool1 = false;
                bool3 = true;
                break;
              } 
              paramExtractFloatResult.b = true;
            case '-':
            
            case ',':
              bool1 = false;
              bool2 = true;
              break;
          } 
        } else {
          bool1 = true;
        } 
        if (bool2)
          break; 
        continue;
      } 
      i++;
    } 
    paramExtractFloatResult.a = i;
  }
  
  private static void a(ArrayList<PathDataNode> paramArrayList, char paramChar, float[] paramArrayOffloat) {
    paramArrayList.add(new PathDataNode(paramChar, paramArrayOffloat));
  }
  
  private static float[] a(String paramString) {
    if (paramString.charAt(0) == 'z' || paramString.charAt(0) == 'Z')
      return new float[0]; 
    try {
      float[] arrayOfFloat = new float[paramString.length()];
      ExtractFloatResult extractFloatResult = new ExtractFloatResult();
      int k = paramString.length();
      int i = 1;
      for (int j = 0;; j = m) {
        int m;
        int n;
        if (i < k) {
          a(paramString, i, extractFloatResult);
          n = extractFloatResult.a;
          m = j;
          if (i < n) {
            arrayOfFloat[j] = Float.parseFloat(paramString.substring(i, n));
            m = j + 1;
          } 
          if (extractFloatResult.b) {
            i = n;
            j = m;
            continue;
          } 
        } else {
          return a(arrayOfFloat, 0, j);
        } 
        i = n + 1;
      } 
    } catch (NumberFormatException numberFormatException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("error in parsing \"");
      stringBuilder.append(paramString);
      stringBuilder.append("\"");
      throw new RuntimeException(stringBuilder.toString(), numberFormatException);
    } 
  }
  
  static float[] a(float[] paramArrayOffloat, int paramInt1, int paramInt2) {
    if (paramInt1 <= paramInt2) {
      int i = paramArrayOffloat.length;
      if (paramInt1 >= 0 && paramInt1 <= i) {
        paramInt2 -= paramInt1;
        i = Math.min(paramInt2, i - paramInt1);
        float[] arrayOfFloat = new float[paramInt2];
        System.arraycopy(paramArrayOffloat, paramInt1, arrayOfFloat, 0, i);
        return arrayOfFloat;
      } 
      throw new ArrayIndexOutOfBoundsException();
    } 
    throw new IllegalArgumentException();
  }
  
  public static boolean canMorph(PathDataNode[] paramArrayOfPathDataNode1, PathDataNode[] paramArrayOfPathDataNode2) {
    if (paramArrayOfPathDataNode1 != null) {
      if (paramArrayOfPathDataNode2 == null)
        return false; 
      if (paramArrayOfPathDataNode1.length != paramArrayOfPathDataNode2.length)
        return false; 
      int i = 0;
      while (i < paramArrayOfPathDataNode1.length) {
        if ((paramArrayOfPathDataNode1[i]).mType == (paramArrayOfPathDataNode2[i]).mType) {
          if ((paramArrayOfPathDataNode1[i]).mParams.length != (paramArrayOfPathDataNode2[i]).mParams.length)
            return false; 
          i++;
          continue;
        } 
        return false;
      } 
      return true;
    } 
    return false;
  }
  
  public static PathDataNode[] createNodesFromPathData(String paramString) {
    if (paramString == null)
      return null; 
    ArrayList<PathDataNode> arrayList = new ArrayList();
    int j = 1;
    int i = 0;
    while (j < paramString.length()) {
      j = a(paramString, j);
      String str = paramString.substring(i, j).trim();
      if (str.length() > 0) {
        float[] arrayOfFloat = a(str);
        a(arrayList, str.charAt(0), arrayOfFloat);
      } 
      i = j;
      j++;
    } 
    if (j - i == 1 && i < paramString.length())
      a(arrayList, paramString.charAt(i), new float[0]); 
    return arrayList.<PathDataNode>toArray(new PathDataNode[arrayList.size()]);
  }
  
  public static Path createPathFromPathData(String paramString) {
    Path path = new Path();
    PathDataNode[] arrayOfPathDataNode = createNodesFromPathData(paramString);
    if (arrayOfPathDataNode != null)
      try {
        PathDataNode.nodesToPath(arrayOfPathDataNode, path);
        return path;
      } catch (RuntimeException runtimeException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Error in parsing ");
        stringBuilder.append(paramString);
        throw new RuntimeException(stringBuilder.toString(), runtimeException);
      }  
    return null;
  }
  
  public static PathDataNode[] deepCopyNodes(PathDataNode[] paramArrayOfPathDataNode) {
    if (paramArrayOfPathDataNode == null)
      return null; 
    PathDataNode[] arrayOfPathDataNode = new PathDataNode[paramArrayOfPathDataNode.length];
    for (int i = 0; i < paramArrayOfPathDataNode.length; i++)
      arrayOfPathDataNode[i] = new PathDataNode(paramArrayOfPathDataNode[i]); 
    return arrayOfPathDataNode;
  }
  
  public static boolean interpolatePathDataNodes(PathDataNode[] paramArrayOfPathDataNode1, PathDataNode[] paramArrayOfPathDataNode2, PathDataNode[] paramArrayOfPathDataNode3, float paramFloat) {
    if (paramArrayOfPathDataNode1 != null && paramArrayOfPathDataNode2 != null && paramArrayOfPathDataNode3 != null) {
      if (paramArrayOfPathDataNode1.length == paramArrayOfPathDataNode2.length && paramArrayOfPathDataNode2.length == paramArrayOfPathDataNode3.length) {
        boolean bool = canMorph(paramArrayOfPathDataNode2, paramArrayOfPathDataNode3);
        int i = 0;
        if (!bool)
          return false; 
        while (i < paramArrayOfPathDataNode1.length) {
          paramArrayOfPathDataNode1[i].interpolatePathDataNode(paramArrayOfPathDataNode2[i], paramArrayOfPathDataNode3[i], paramFloat);
          i++;
        } 
        return true;
      } 
      throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes must have the same length");
    } 
    throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes cannot be null");
  }
  
  public static void updateNodes(PathDataNode[] paramArrayOfPathDataNode1, PathDataNode[] paramArrayOfPathDataNode2) {
    for (int i = 0; i < paramArrayOfPathDataNode2.length; i++) {
      (paramArrayOfPathDataNode1[i]).mType = (paramArrayOfPathDataNode2[i]).mType;
      for (int j = 0; j < (paramArrayOfPathDataNode2[i]).mParams.length; j++)
        (paramArrayOfPathDataNode1[i]).mParams[j] = (paramArrayOfPathDataNode2[i]).mParams[j]; 
    } 
  }
  
  static class ExtractFloatResult {
    int a;
    
    boolean b;
  }
  
  public static class PathDataNode {
    public float[] mParams;
    
    public char mType;
    
    PathDataNode(char param1Char, float[] param1ArrayOffloat) {
      this.mType = param1Char;
      this.mParams = param1ArrayOffloat;
    }
    
    PathDataNode(PathDataNode param1PathDataNode) {
      this.mType = param1PathDataNode.mType;
      float[] arrayOfFloat = param1PathDataNode.mParams;
      this.mParams = PathParser.a(arrayOfFloat, 0, arrayOfFloat.length);
    }
    
    private static void a(Path param1Path, double param1Double1, double param1Double2, double param1Double3, double param1Double4, double param1Double5, double param1Double6, double param1Double7, double param1Double8, double param1Double9) {
      int i = (int)Math.ceil(Math.abs(param1Double9 * 4.0D / Math.PI));
      double d4 = Math.cos(param1Double7);
      double d5 = Math.sin(param1Double7);
      double d1 = Math.cos(param1Double8);
      double d3 = Math.sin(param1Double8);
      param1Double7 = -param1Double3;
      double d7 = param1Double7 * d4;
      double d8 = param1Double4 * d5;
      param1Double7 *= d5;
      double d9 = param1Double4 * d4;
      double d6 = param1Double9 / i;
      double d2 = d3 * param1Double7 + d1 * d9;
      param1Double9 = d7 * d3 - d8 * d1;
      int j = 0;
      d3 = param1Double8;
      d1 = param1Double6;
      param1Double8 = param1Double5;
      param1Double4 = param1Double7;
      param1Double7 = d6;
      param1Double6 = d5;
      param1Double5 = d4;
      while (true) {
        d5 = param1Double3;
        if (j < i) {
          d6 = d3 + param1Double7;
          double d10 = Math.sin(d6);
          double d12 = Math.cos(d6);
          d4 = param1Double1 + d5 * param1Double5 * d12 - d8 * d10;
          double d11 = param1Double2 + d5 * param1Double6 * d12 + d9 * d10;
          d5 = d7 * d10 - d8 * d12;
          d10 = d10 * param1Double4 + d12 * d9;
          d3 = d6 - d3;
          d12 = Math.tan(d3 / 2.0D);
          d3 = Math.sin(d3) * (Math.sqrt(d12 * 3.0D * d12 + 4.0D) - 1.0D) / 3.0D;
          param1Path.rLineTo(0.0F, 0.0F);
          param1Path.cubicTo((float)(param1Double8 + param1Double9 * d3), (float)(d1 + d2 * d3), (float)(d4 - d3 * d5), (float)(d11 - d3 * d10), (float)d4, (float)d11);
          j++;
          d1 = d11;
          d3 = d6;
          d2 = d10;
          param1Double9 = d5;
          param1Double8 = d4;
          continue;
        } 
        break;
      } 
    }
    
    private static void a(Path param1Path, float param1Float1, float param1Float2, float param1Float3, float param1Float4, float param1Float5, float param1Float6, float param1Float7, boolean param1Boolean1, boolean param1Boolean2) {
      double d5 = Math.toRadians(param1Float7);
      double d6 = Math.cos(d5);
      double d7 = Math.sin(d5);
      double d8 = param1Float1;
      double d9 = param1Float2;
      double d10 = param1Float5;
      double d1 = (d8 * d6 + d9 * d7) / d10;
      double d2 = -param1Float1;
      double d11 = param1Float6;
      double d4 = (d2 * d7 + d9 * d6) / d11;
      double d3 = param1Float3;
      d2 = param1Float4;
      double d12 = (d3 * d6 + d2 * d7) / d10;
      double d13 = (-param1Float3 * d7 + d2 * d6) / d11;
      double d15 = d1 - d12;
      double d14 = d4 - d13;
      d3 = (d1 + d12) / 2.0D;
      d2 = (d4 + d13) / 2.0D;
      double d16 = d15 * d15 + d14 * d14;
      if (d16 == 0.0D) {
        Log.w("PathParser", " Points are coincident");
        return;
      } 
      double d17 = 1.0D / d16 - 0.25D;
      if (d17 < 0.0D) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Points are too far apart ");
        stringBuilder.append(d16);
        Log.w("PathParser", stringBuilder.toString());
        float f = (float)(Math.sqrt(d16) / 1.99999D);
        a(param1Path, param1Float1, param1Float2, param1Float3, param1Float4, param1Float5 * f, param1Float6 * f, param1Float7, param1Boolean1, param1Boolean2);
        return;
      } 
      d16 = Math.sqrt(d17);
      d15 *= d16;
      d14 = d16 * d14;
      if (param1Boolean1 == param1Boolean2) {
        d3 -= d14;
        d2 += d15;
      } else {
        d3 += d14;
        d2 -= d15;
      } 
      d14 = Math.atan2(d4 - d2, d1 - d3);
      d4 = Math.atan2(d13 - d2, d12 - d3) - d14;
      int i = d4 cmp 0.0D;
      if (i >= 0) {
        param1Boolean1 = true;
      } else {
        param1Boolean1 = false;
      } 
      d1 = d4;
      if (param1Boolean2 != param1Boolean1)
        if (i > 0) {
          d1 = d4 - 6.283185307179586D;
        } else {
          d1 = d4 + 6.283185307179586D;
        }  
      d3 *= d10;
      d2 *= d11;
      a(param1Path, d3 * d6 - d2 * d7, d3 * d7 + d2 * d6, d10, d11, d8, d9, d5, d14, d1);
    }
    
    private static void a(Path param1Path, float[] param1ArrayOffloat1, char param1Char1, char param1Char2, float[] param1ArrayOffloat2) {
      // Byte code:
      //   0: aload_1
      //   1: iconst_0
      //   2: faload
      //   3: fstore #11
      //   5: aload_1
      //   6: iconst_1
      //   7: faload
      //   8: fstore #12
      //   10: aload_1
      //   11: iconst_2
      //   12: faload
      //   13: fstore #13
      //   15: aload_1
      //   16: iconst_3
      //   17: faload
      //   18: fstore #14
      //   20: aload_1
      //   21: iconst_4
      //   22: faload
      //   23: fstore #10
      //   25: aload_1
      //   26: iconst_5
      //   27: faload
      //   28: fstore #9
      //   30: fload #11
      //   32: fstore #5
      //   34: fload #12
      //   36: fstore #6
      //   38: fload #13
      //   40: fstore #7
      //   42: fload #14
      //   44: fstore #8
      //   46: iload_3
      //   47: lookupswitch default -> 216, 65 -> 336, 67 -> 313, 72 -> 291, 76 -> 232, 77 -> 232, 81 -> 269, 83 -> 269, 84 -> 232, 86 -> 291, 90 -> 238, 97 -> 336, 99 -> 313, 104 -> 291, 108 -> 232, 109 -> 232, 113 -> 269, 115 -> 269, 116 -> 232, 118 -> 291, 122 -> 238
      //   216: fload #14
      //   218: fstore #8
      //   220: fload #13
      //   222: fstore #7
      //   224: fload #12
      //   226: fstore #6
      //   228: fload #11
      //   230: fstore #5
      //   232: iconst_2
      //   233: istore #15
      //   235: goto -> 356
      //   238: aload_0
      //   239: invokevirtual close : ()V
      //   242: aload_0
      //   243: fload #10
      //   245: fload #9
      //   247: invokevirtual moveTo : (FF)V
      //   250: fload #10
      //   252: fstore #5
      //   254: fload #5
      //   256: fstore #7
      //   258: fload #9
      //   260: fstore #6
      //   262: fload #6
      //   264: fstore #8
      //   266: goto -> 232
      //   269: iconst_4
      //   270: istore #15
      //   272: fload #11
      //   274: fstore #5
      //   276: fload #12
      //   278: fstore #6
      //   280: fload #13
      //   282: fstore #7
      //   284: fload #14
      //   286: fstore #8
      //   288: goto -> 356
      //   291: iconst_1
      //   292: istore #15
      //   294: fload #11
      //   296: fstore #5
      //   298: fload #12
      //   300: fstore #6
      //   302: fload #13
      //   304: fstore #7
      //   306: fload #14
      //   308: fstore #8
      //   310: goto -> 356
      //   313: bipush #6
      //   315: istore #15
      //   317: fload #11
      //   319: fstore #5
      //   321: fload #12
      //   323: fstore #6
      //   325: fload #13
      //   327: fstore #7
      //   329: fload #14
      //   331: fstore #8
      //   333: goto -> 356
      //   336: bipush #7
      //   338: istore #15
      //   340: fload #14
      //   342: fstore #8
      //   344: fload #13
      //   346: fstore #7
      //   348: fload #12
      //   350: fstore #6
      //   352: fload #11
      //   354: fstore #5
      //   356: iconst_0
      //   357: istore #17
      //   359: iload_2
      //   360: istore #16
      //   362: iload #17
      //   364: istore_2
      //   365: iload_3
      //   366: istore #17
      //   368: iload_2
      //   369: aload #4
      //   371: arraylength
      //   372: if_icmpge -> 2139
      //   375: iload #17
      //   377: bipush #65
      //   379: if_icmpeq -> 1985
      //   382: iload #17
      //   384: bipush #67
      //   386: if_icmpeq -> 1869
      //   389: iload #17
      //   391: bipush #72
      //   393: if_icmpeq -> 1843
      //   396: iload #17
      //   398: bipush #81
      //   400: if_icmpeq -> 1749
      //   403: iload #17
      //   405: bipush #86
      //   407: if_icmpeq -> 1723
      //   410: iload #17
      //   412: bipush #97
      //   414: if_icmpeq -> 1583
      //   417: iload #17
      //   419: bipush #99
      //   421: if_icmpeq -> 1440
      //   424: iload #17
      //   426: bipush #104
      //   428: if_icmpeq -> 1412
      //   431: iload #17
      //   433: bipush #113
      //   435: if_icmpeq -> 1312
      //   438: iload #17
      //   440: bipush #118
      //   442: if_icmpeq -> 1287
      //   445: iload #17
      //   447: bipush #76
      //   449: if_icmpeq -> 1242
      //   452: iload #17
      //   454: bipush #77
      //   456: if_icmpeq -> 1172
      //   459: iload #17
      //   461: bipush #83
      //   463: if_icmpeq -> 1027
      //   466: iload #17
      //   468: bipush #84
      //   470: if_icmpeq -> 916
      //   473: iload #17
      //   475: bipush #108
      //   477: if_icmpeq -> 861
      //   480: iload #17
      //   482: bipush #109
      //   484: if_icmpeq -> 793
      //   487: iload #17
      //   489: bipush #115
      //   491: if_icmpeq -> 635
      //   494: iload #17
      //   496: bipush #116
      //   498: if_icmpeq -> 504
      //   501: goto -> 2128
      //   504: iload #16
      //   506: bipush #113
      //   508: if_icmpeq -> 544
      //   511: iload #16
      //   513: bipush #116
      //   515: if_icmpeq -> 544
      //   518: iload #16
      //   520: bipush #81
      //   522: if_icmpeq -> 544
      //   525: iload #16
      //   527: bipush #84
      //   529: if_icmpne -> 535
      //   532: goto -> 544
      //   535: fconst_0
      //   536: fstore #8
      //   538: fconst_0
      //   539: fstore #7
      //   541: goto -> 558
      //   544: fload #5
      //   546: fload #7
      //   548: fsub
      //   549: fstore #7
      //   551: fload #6
      //   553: fload #8
      //   555: fsub
      //   556: fstore #8
      //   558: iload_2
      //   559: iconst_0
      //   560: iadd
      //   561: istore #16
      //   563: aload #4
      //   565: iload #16
      //   567: faload
      //   568: fstore #11
      //   570: iload_2
      //   571: iconst_1
      //   572: iadd
      //   573: istore #17
      //   575: aload_0
      //   576: fload #7
      //   578: fload #8
      //   580: fload #11
      //   582: aload #4
      //   584: iload #17
      //   586: faload
      //   587: invokevirtual rQuadTo : (FFFF)V
      //   590: fload #5
      //   592: aload #4
      //   594: iload #16
      //   596: faload
      //   597: fadd
      //   598: fstore #11
      //   600: fload #6
      //   602: aload #4
      //   604: iload #17
      //   606: faload
      //   607: fadd
      //   608: fstore #12
      //   610: fload #8
      //   612: fload #6
      //   614: fadd
      //   615: fstore #8
      //   617: fload #7
      //   619: fload #5
      //   621: fadd
      //   622: fstore #7
      //   624: fload #12
      //   626: fstore #6
      //   628: fload #11
      //   630: fstore #5
      //   632: goto -> 501
      //   635: iload #16
      //   637: bipush #99
      //   639: if_icmpeq -> 675
      //   642: iload #16
      //   644: bipush #115
      //   646: if_icmpeq -> 675
      //   649: iload #16
      //   651: bipush #67
      //   653: if_icmpeq -> 675
      //   656: iload #16
      //   658: bipush #83
      //   660: if_icmpne -> 666
      //   663: goto -> 675
      //   666: fconst_0
      //   667: fstore #7
      //   669: fconst_0
      //   670: fstore #8
      //   672: goto -> 689
      //   675: fload #6
      //   677: fload #8
      //   679: fsub
      //   680: fstore #8
      //   682: fload #5
      //   684: fload #7
      //   686: fsub
      //   687: fstore #7
      //   689: iload_2
      //   690: iconst_0
      //   691: iadd
      //   692: istore #16
      //   694: aload #4
      //   696: iload #16
      //   698: faload
      //   699: fstore #11
      //   701: iload_2
      //   702: iconst_1
      //   703: iadd
      //   704: istore #17
      //   706: aload #4
      //   708: iload #17
      //   710: faload
      //   711: fstore #12
      //   713: iload_2
      //   714: iconst_2
      //   715: iadd
      //   716: istore #18
      //   718: aload #4
      //   720: iload #18
      //   722: faload
      //   723: fstore #13
      //   725: iload_2
      //   726: iconst_3
      //   727: iadd
      //   728: istore #19
      //   730: aload_0
      //   731: fload #7
      //   733: fload #8
      //   735: fload #11
      //   737: fload #12
      //   739: fload #13
      //   741: aload #4
      //   743: iload #19
      //   745: faload
      //   746: invokevirtual rCubicTo : (FFFFFF)V
      //   749: aload #4
      //   751: iload #16
      //   753: faload
      //   754: fload #5
      //   756: fadd
      //   757: fstore #12
      //   759: aload #4
      //   761: iload #17
      //   763: faload
      //   764: fload #6
      //   766: fadd
      //   767: fstore #7
      //   769: fload #5
      //   771: aload #4
      //   773: iload #18
      //   775: faload
      //   776: fadd
      //   777: fstore #8
      //   779: aload #4
      //   781: iload #19
      //   783: faload
      //   784: fstore #11
      //   786: fload #12
      //   788: fstore #5
      //   790: goto -> 1557
      //   793: iload_2
      //   794: iconst_0
      //   795: iadd
      //   796: istore #16
      //   798: fload #5
      //   800: aload #4
      //   802: iload #16
      //   804: faload
      //   805: fadd
      //   806: fstore #5
      //   808: iload_2
      //   809: iconst_1
      //   810: iadd
      //   811: istore #17
      //   813: fload #6
      //   815: aload #4
      //   817: iload #17
      //   819: faload
      //   820: fadd
      //   821: fstore #6
      //   823: iload_2
      //   824: ifle -> 844
      //   827: aload_0
      //   828: aload #4
      //   830: iload #16
      //   832: faload
      //   833: aload #4
      //   835: iload #17
      //   837: faload
      //   838: invokevirtual rLineTo : (FF)V
      //   841: goto -> 501
      //   844: aload_0
      //   845: aload #4
      //   847: iload #16
      //   849: faload
      //   850: aload #4
      //   852: iload #17
      //   854: faload
      //   855: invokevirtual rMoveTo : (FF)V
      //   858: goto -> 1231
      //   861: iload_2
      //   862: iconst_0
      //   863: iadd
      //   864: istore #16
      //   866: aload #4
      //   868: iload #16
      //   870: faload
      //   871: fstore #11
      //   873: iload_2
      //   874: iconst_1
      //   875: iadd
      //   876: istore #17
      //   878: aload_0
      //   879: fload #11
      //   881: aload #4
      //   883: iload #17
      //   885: faload
      //   886: invokevirtual rLineTo : (FF)V
      //   889: fload #5
      //   891: aload #4
      //   893: iload #16
      //   895: faload
      //   896: fadd
      //   897: fstore #5
      //   899: aload #4
      //   901: iload #17
      //   903: faload
      //   904: fstore #11
      //   906: fload #6
      //   908: fload #11
      //   910: fadd
      //   911: fstore #6
      //   913: goto -> 501
      //   916: iload #16
      //   918: bipush #113
      //   920: if_icmpeq -> 952
      //   923: iload #16
      //   925: bipush #116
      //   927: if_icmpeq -> 952
      //   930: iload #16
      //   932: bipush #81
      //   934: if_icmpeq -> 952
      //   937: fload #6
      //   939: fstore #12
      //   941: fload #5
      //   943: fstore #11
      //   945: iload #16
      //   947: bipush #84
      //   949: if_icmpne -> 970
      //   952: fload #5
      //   954: fconst_2
      //   955: fmul
      //   956: fload #7
      //   958: fsub
      //   959: fstore #11
      //   961: fload #6
      //   963: fconst_2
      //   964: fmul
      //   965: fload #8
      //   967: fsub
      //   968: fstore #12
      //   970: iload_2
      //   971: iconst_0
      //   972: iadd
      //   973: istore #16
      //   975: aload #4
      //   977: iload #16
      //   979: faload
      //   980: fstore #5
      //   982: iload_2
      //   983: iconst_1
      //   984: iadd
      //   985: istore #17
      //   987: aload_0
      //   988: fload #11
      //   990: fload #12
      //   992: fload #5
      //   994: aload #4
      //   996: iload #17
      //   998: faload
      //   999: invokevirtual quadTo : (FFFF)V
      //   1002: aload #4
      //   1004: iload #16
      //   1006: faload
      //   1007: fstore #5
      //   1009: aload #4
      //   1011: iload #17
      //   1013: faload
      //   1014: fstore #6
      //   1016: fload #12
      //   1018: fstore #8
      //   1020: fload #11
      //   1022: fstore #7
      //   1024: goto -> 2128
      //   1027: iload #16
      //   1029: bipush #99
      //   1031: if_icmpeq -> 1063
      //   1034: iload #16
      //   1036: bipush #115
      //   1038: if_icmpeq -> 1063
      //   1041: iload #16
      //   1043: bipush #67
      //   1045: if_icmpeq -> 1063
      //   1048: fload #6
      //   1050: fstore #12
      //   1052: fload #5
      //   1054: fstore #11
      //   1056: iload #16
      //   1058: bipush #83
      //   1060: if_icmpne -> 1081
      //   1063: fload #5
      //   1065: fconst_2
      //   1066: fmul
      //   1067: fload #7
      //   1069: fsub
      //   1070: fstore #11
      //   1072: fload #6
      //   1074: fconst_2
      //   1075: fmul
      //   1076: fload #8
      //   1078: fsub
      //   1079: fstore #12
      //   1081: iload_2
      //   1082: iconst_0
      //   1083: iadd
      //   1084: istore #16
      //   1086: aload #4
      //   1088: iload #16
      //   1090: faload
      //   1091: fstore #5
      //   1093: iload_2
      //   1094: iconst_1
      //   1095: iadd
      //   1096: istore #17
      //   1098: aload #4
      //   1100: iload #17
      //   1102: faload
      //   1103: fstore #6
      //   1105: iload_2
      //   1106: iconst_2
      //   1107: iadd
      //   1108: istore #18
      //   1110: aload #4
      //   1112: iload #18
      //   1114: faload
      //   1115: fstore #7
      //   1117: iload_2
      //   1118: iconst_3
      //   1119: iadd
      //   1120: istore #19
      //   1122: aload_0
      //   1123: fload #11
      //   1125: fload #12
      //   1127: fload #5
      //   1129: fload #6
      //   1131: fload #7
      //   1133: aload #4
      //   1135: iload #19
      //   1137: faload
      //   1138: invokevirtual cubicTo : (FFFFFF)V
      //   1141: aload #4
      //   1143: iload #16
      //   1145: faload
      //   1146: fstore #5
      //   1148: aload #4
      //   1150: iload #17
      //   1152: faload
      //   1153: fstore #7
      //   1155: aload #4
      //   1157: iload #18
      //   1159: faload
      //   1160: fstore #11
      //   1162: aload #4
      //   1164: iload #19
      //   1166: faload
      //   1167: fstore #6
      //   1169: goto -> 1568
      //   1172: iload_2
      //   1173: iconst_0
      //   1174: iadd
      //   1175: istore #16
      //   1177: aload #4
      //   1179: iload #16
      //   1181: faload
      //   1182: fstore #5
      //   1184: iload_2
      //   1185: iconst_1
      //   1186: iadd
      //   1187: istore #17
      //   1189: aload #4
      //   1191: iload #17
      //   1193: faload
      //   1194: fstore #6
      //   1196: iload_2
      //   1197: ifle -> 1217
      //   1200: aload_0
      //   1201: aload #4
      //   1203: iload #16
      //   1205: faload
      //   1206: aload #4
      //   1208: iload #17
      //   1210: faload
      //   1211: invokevirtual lineTo : (FF)V
      //   1214: goto -> 501
      //   1217: aload_0
      //   1218: aload #4
      //   1220: iload #16
      //   1222: faload
      //   1223: aload #4
      //   1225: iload #17
      //   1227: faload
      //   1228: invokevirtual moveTo : (FF)V
      //   1231: fload #6
      //   1233: fstore #9
      //   1235: fload #5
      //   1237: fstore #10
      //   1239: goto -> 501
      //   1242: iload_2
      //   1243: iconst_0
      //   1244: iadd
      //   1245: istore #16
      //   1247: aload #4
      //   1249: iload #16
      //   1251: faload
      //   1252: fstore #5
      //   1254: iload_2
      //   1255: iconst_1
      //   1256: iadd
      //   1257: istore #17
      //   1259: aload_0
      //   1260: fload #5
      //   1262: aload #4
      //   1264: iload #17
      //   1266: faload
      //   1267: invokevirtual lineTo : (FF)V
      //   1270: aload #4
      //   1272: iload #16
      //   1274: faload
      //   1275: fstore #5
      //   1277: aload #4
      //   1279: iload #17
      //   1281: faload
      //   1282: fstore #6
      //   1284: goto -> 501
      //   1287: iload_2
      //   1288: iconst_0
      //   1289: iadd
      //   1290: istore #16
      //   1292: aload_0
      //   1293: fconst_0
      //   1294: aload #4
      //   1296: iload #16
      //   1298: faload
      //   1299: invokevirtual rLineTo : (FF)V
      //   1302: aload #4
      //   1304: iload #16
      //   1306: faload
      //   1307: fstore #11
      //   1309: goto -> 906
      //   1312: iload_2
      //   1313: iconst_0
      //   1314: iadd
      //   1315: istore #16
      //   1317: aload #4
      //   1319: iload #16
      //   1321: faload
      //   1322: fstore #7
      //   1324: iload_2
      //   1325: iconst_1
      //   1326: iadd
      //   1327: istore #17
      //   1329: aload #4
      //   1331: iload #17
      //   1333: faload
      //   1334: fstore #8
      //   1336: iload_2
      //   1337: iconst_2
      //   1338: iadd
      //   1339: istore #18
      //   1341: aload #4
      //   1343: iload #18
      //   1345: faload
      //   1346: fstore #11
      //   1348: iload_2
      //   1349: iconst_3
      //   1350: iadd
      //   1351: istore #19
      //   1353: aload_0
      //   1354: fload #7
      //   1356: fload #8
      //   1358: fload #11
      //   1360: aload #4
      //   1362: iload #19
      //   1364: faload
      //   1365: invokevirtual rQuadTo : (FFFF)V
      //   1368: aload #4
      //   1370: iload #16
      //   1372: faload
      //   1373: fload #5
      //   1375: fadd
      //   1376: fstore #12
      //   1378: aload #4
      //   1380: iload #17
      //   1382: faload
      //   1383: fload #6
      //   1385: fadd
      //   1386: fstore #7
      //   1388: fload #5
      //   1390: aload #4
      //   1392: iload #18
      //   1394: faload
      //   1395: fadd
      //   1396: fstore #8
      //   1398: aload #4
      //   1400: iload #19
      //   1402: faload
      //   1403: fstore #11
      //   1405: fload #12
      //   1407: fstore #5
      //   1409: goto -> 1557
      //   1412: iload_2
      //   1413: iconst_0
      //   1414: iadd
      //   1415: istore #16
      //   1417: aload_0
      //   1418: aload #4
      //   1420: iload #16
      //   1422: faload
      //   1423: fconst_0
      //   1424: invokevirtual rLineTo : (FF)V
      //   1427: fload #5
      //   1429: aload #4
      //   1431: iload #16
      //   1433: faload
      //   1434: fadd
      //   1435: fstore #5
      //   1437: goto -> 501
      //   1440: aload #4
      //   1442: iload_2
      //   1443: iconst_0
      //   1444: iadd
      //   1445: faload
      //   1446: fstore #7
      //   1448: aload #4
      //   1450: iload_2
      //   1451: iconst_1
      //   1452: iadd
      //   1453: faload
      //   1454: fstore #8
      //   1456: iload_2
      //   1457: iconst_2
      //   1458: iadd
      //   1459: istore #16
      //   1461: aload #4
      //   1463: iload #16
      //   1465: faload
      //   1466: fstore #11
      //   1468: iload_2
      //   1469: iconst_3
      //   1470: iadd
      //   1471: istore #17
      //   1473: aload #4
      //   1475: iload #17
      //   1477: faload
      //   1478: fstore #12
      //   1480: iload_2
      //   1481: iconst_4
      //   1482: iadd
      //   1483: istore #18
      //   1485: aload #4
      //   1487: iload #18
      //   1489: faload
      //   1490: fstore #13
      //   1492: iload_2
      //   1493: iconst_5
      //   1494: iadd
      //   1495: istore #19
      //   1497: aload_0
      //   1498: fload #7
      //   1500: fload #8
      //   1502: fload #11
      //   1504: fload #12
      //   1506: fload #13
      //   1508: aload #4
      //   1510: iload #19
      //   1512: faload
      //   1513: invokevirtual rCubicTo : (FFFFFF)V
      //   1516: aload #4
      //   1518: iload #16
      //   1520: faload
      //   1521: fload #5
      //   1523: fadd
      //   1524: fstore #12
      //   1526: aload #4
      //   1528: iload #17
      //   1530: faload
      //   1531: fload #6
      //   1533: fadd
      //   1534: fstore #7
      //   1536: fload #5
      //   1538: aload #4
      //   1540: iload #18
      //   1542: faload
      //   1543: fadd
      //   1544: fstore #8
      //   1546: aload #4
      //   1548: iload #19
      //   1550: faload
      //   1551: fstore #11
      //   1553: fload #12
      //   1555: fstore #5
      //   1557: fload #6
      //   1559: fload #11
      //   1561: fadd
      //   1562: fstore #6
      //   1564: fload #8
      //   1566: fstore #11
      //   1568: fload #7
      //   1570: fstore #8
      //   1572: fload #5
      //   1574: fstore #7
      //   1576: fload #11
      //   1578: fstore #5
      //   1580: goto -> 501
      //   1583: iload_2
      //   1584: iconst_5
      //   1585: iadd
      //   1586: istore #16
      //   1588: aload #4
      //   1590: iload #16
      //   1592: faload
      //   1593: fstore #7
      //   1595: iload_2
      //   1596: bipush #6
      //   1598: iadd
      //   1599: istore #17
      //   1601: aload #4
      //   1603: iload #17
      //   1605: faload
      //   1606: fstore #8
      //   1608: aload #4
      //   1610: iload_2
      //   1611: iconst_0
      //   1612: iadd
      //   1613: faload
      //   1614: fstore #11
      //   1616: aload #4
      //   1618: iload_2
      //   1619: iconst_1
      //   1620: iadd
      //   1621: faload
      //   1622: fstore #12
      //   1624: aload #4
      //   1626: iload_2
      //   1627: iconst_2
      //   1628: iadd
      //   1629: faload
      //   1630: fstore #13
      //   1632: aload #4
      //   1634: iload_2
      //   1635: iconst_3
      //   1636: iadd
      //   1637: faload
      //   1638: fconst_0
      //   1639: fcmpl
      //   1640: ifeq -> 1649
      //   1643: iconst_1
      //   1644: istore #20
      //   1646: goto -> 1652
      //   1649: iconst_0
      //   1650: istore #20
      //   1652: aload #4
      //   1654: iload_2
      //   1655: iconst_4
      //   1656: iadd
      //   1657: faload
      //   1658: fconst_0
      //   1659: fcmpl
      //   1660: ifeq -> 1669
      //   1663: iconst_1
      //   1664: istore #21
      //   1666: goto -> 1672
      //   1669: iconst_0
      //   1670: istore #21
      //   1672: aload_0
      //   1673: fload #5
      //   1675: fload #6
      //   1677: fload #7
      //   1679: fload #5
      //   1681: fadd
      //   1682: fload #8
      //   1684: fload #6
      //   1686: fadd
      //   1687: fload #11
      //   1689: fload #12
      //   1691: fload #13
      //   1693: iload #20
      //   1695: iload #21
      //   1697: invokestatic a : (Landroid/graphics/Path;FFFFFFFZZ)V
      //   1700: fload #5
      //   1702: aload #4
      //   1704: iload #16
      //   1706: faload
      //   1707: fadd
      //   1708: fstore #5
      //   1710: fload #6
      //   1712: aload #4
      //   1714: iload #17
      //   1716: faload
      //   1717: fadd
      //   1718: fstore #6
      //   1720: goto -> 2120
      //   1723: iload_2
      //   1724: iconst_0
      //   1725: iadd
      //   1726: istore #16
      //   1728: aload_0
      //   1729: fload #5
      //   1731: aload #4
      //   1733: iload #16
      //   1735: faload
      //   1736: invokevirtual lineTo : (FF)V
      //   1739: aload #4
      //   1741: iload #16
      //   1743: faload
      //   1744: fstore #6
      //   1746: goto -> 2128
      //   1749: iload_2
      //   1750: istore #16
      //   1752: iload #16
      //   1754: iconst_0
      //   1755: iadd
      //   1756: istore #17
      //   1758: aload #4
      //   1760: iload #17
      //   1762: faload
      //   1763: fstore #5
      //   1765: iload #16
      //   1767: iconst_1
      //   1768: iadd
      //   1769: istore #18
      //   1771: aload #4
      //   1773: iload #18
      //   1775: faload
      //   1776: fstore #6
      //   1778: iload #16
      //   1780: iconst_2
      //   1781: iadd
      //   1782: istore #19
      //   1784: aload #4
      //   1786: iload #19
      //   1788: faload
      //   1789: fstore #7
      //   1791: iload #16
      //   1793: iconst_3
      //   1794: iadd
      //   1795: istore #16
      //   1797: aload_0
      //   1798: fload #5
      //   1800: fload #6
      //   1802: fload #7
      //   1804: aload #4
      //   1806: iload #16
      //   1808: faload
      //   1809: invokevirtual quadTo : (FFFF)V
      //   1812: aload #4
      //   1814: iload #17
      //   1816: faload
      //   1817: fstore #7
      //   1819: aload #4
      //   1821: iload #18
      //   1823: faload
      //   1824: fstore #8
      //   1826: aload #4
      //   1828: iload #19
      //   1830: faload
      //   1831: fstore #5
      //   1833: aload #4
      //   1835: iload #16
      //   1837: faload
      //   1838: fstore #6
      //   1840: goto -> 2128
      //   1843: iload_2
      //   1844: iconst_0
      //   1845: iadd
      //   1846: istore #16
      //   1848: aload_0
      //   1849: aload #4
      //   1851: iload #16
      //   1853: faload
      //   1854: fload #6
      //   1856: invokevirtual lineTo : (FF)V
      //   1859: aload #4
      //   1861: iload #16
      //   1863: faload
      //   1864: fstore #5
      //   1866: goto -> 2128
      //   1869: iload_2
      //   1870: istore #16
      //   1872: aload #4
      //   1874: iload #16
      //   1876: iconst_0
      //   1877: iadd
      //   1878: faload
      //   1879: fstore #5
      //   1881: aload #4
      //   1883: iload #16
      //   1885: iconst_1
      //   1886: iadd
      //   1887: faload
      //   1888: fstore #6
      //   1890: iload #16
      //   1892: iconst_2
      //   1893: iadd
      //   1894: istore #17
      //   1896: aload #4
      //   1898: iload #17
      //   1900: faload
      //   1901: fstore #7
      //   1903: iload #16
      //   1905: iconst_3
      //   1906: iadd
      //   1907: istore #18
      //   1909: aload #4
      //   1911: iload #18
      //   1913: faload
      //   1914: fstore #8
      //   1916: iload #16
      //   1918: iconst_4
      //   1919: iadd
      //   1920: istore #19
      //   1922: aload #4
      //   1924: iload #19
      //   1926: faload
      //   1927: fstore #11
      //   1929: iload #16
      //   1931: iconst_5
      //   1932: iadd
      //   1933: istore #16
      //   1935: aload_0
      //   1936: fload #5
      //   1938: fload #6
      //   1940: fload #7
      //   1942: fload #8
      //   1944: fload #11
      //   1946: aload #4
      //   1948: iload #16
      //   1950: faload
      //   1951: invokevirtual cubicTo : (FFFFFF)V
      //   1954: aload #4
      //   1956: iload #19
      //   1958: faload
      //   1959: fstore #5
      //   1961: aload #4
      //   1963: iload #16
      //   1965: faload
      //   1966: fstore #6
      //   1968: aload #4
      //   1970: iload #17
      //   1972: faload
      //   1973: fstore #7
      //   1975: aload #4
      //   1977: iload #18
      //   1979: faload
      //   1980: fstore #8
      //   1982: goto -> 2128
      //   1985: iload_2
      //   1986: istore #16
      //   1988: iload #16
      //   1990: iconst_5
      //   1991: iadd
      //   1992: istore #17
      //   1994: aload #4
      //   1996: iload #17
      //   1998: faload
      //   1999: fstore #7
      //   2001: iload #16
      //   2003: bipush #6
      //   2005: iadd
      //   2006: istore #18
      //   2008: aload #4
      //   2010: iload #18
      //   2012: faload
      //   2013: fstore #8
      //   2015: aload #4
      //   2017: iload #16
      //   2019: iconst_0
      //   2020: iadd
      //   2021: faload
      //   2022: fstore #11
      //   2024: aload #4
      //   2026: iload #16
      //   2028: iconst_1
      //   2029: iadd
      //   2030: faload
      //   2031: fstore #12
      //   2033: aload #4
      //   2035: iload #16
      //   2037: iconst_2
      //   2038: iadd
      //   2039: faload
      //   2040: fstore #13
      //   2042: aload #4
      //   2044: iload #16
      //   2046: iconst_3
      //   2047: iadd
      //   2048: faload
      //   2049: fconst_0
      //   2050: fcmpl
      //   2051: ifeq -> 2060
      //   2054: iconst_1
      //   2055: istore #20
      //   2057: goto -> 2063
      //   2060: iconst_0
      //   2061: istore #20
      //   2063: aload #4
      //   2065: iload #16
      //   2067: iconst_4
      //   2068: iadd
      //   2069: faload
      //   2070: fconst_0
      //   2071: fcmpl
      //   2072: ifeq -> 2081
      //   2075: iconst_1
      //   2076: istore #21
      //   2078: goto -> 2084
      //   2081: iconst_0
      //   2082: istore #21
      //   2084: aload_0
      //   2085: fload #5
      //   2087: fload #6
      //   2089: fload #7
      //   2091: fload #8
      //   2093: fload #11
      //   2095: fload #12
      //   2097: fload #13
      //   2099: iload #20
      //   2101: iload #21
      //   2103: invokestatic a : (Landroid/graphics/Path;FFFFFFFZZ)V
      //   2106: aload #4
      //   2108: iload #17
      //   2110: faload
      //   2111: fstore #5
      //   2113: aload #4
      //   2115: iload #18
      //   2117: faload
      //   2118: fstore #6
      //   2120: fload #6
      //   2122: fstore #8
      //   2124: fload #5
      //   2126: fstore #7
      //   2128: iload_2
      //   2129: iload #15
      //   2131: iadd
      //   2132: istore_2
      //   2133: iload_3
      //   2134: istore #16
      //   2136: goto -> 365
      //   2139: aload_1
      //   2140: iconst_0
      //   2141: fload #5
      //   2143: fastore
      //   2144: aload_1
      //   2145: iconst_1
      //   2146: fload #6
      //   2148: fastore
      //   2149: aload_1
      //   2150: iconst_2
      //   2151: fload #7
      //   2153: fastore
      //   2154: aload_1
      //   2155: iconst_3
      //   2156: fload #8
      //   2158: fastore
      //   2159: aload_1
      //   2160: iconst_4
      //   2161: fload #10
      //   2163: fastore
      //   2164: aload_1
      //   2165: iconst_5
      //   2166: fload #9
      //   2168: fastore
      //   2169: return
    }
    
    public static void nodesToPath(PathDataNode[] param1ArrayOfPathDataNode, Path param1Path) {
      float[] arrayOfFloat = new float[6];
      char c = 'm';
      for (int i = 0; i < param1ArrayOfPathDataNode.length; i++) {
        a(param1Path, arrayOfFloat, c, (param1ArrayOfPathDataNode[i]).mType, (param1ArrayOfPathDataNode[i]).mParams);
        c = (param1ArrayOfPathDataNode[i]).mType;
      } 
    }
    
    public void interpolatePathDataNode(PathDataNode param1PathDataNode1, PathDataNode param1PathDataNode2, float param1Float) {
      this.mType = param1PathDataNode1.mType;
      int i = 0;
      while (true) {
        float[] arrayOfFloat = param1PathDataNode1.mParams;
        if (i < arrayOfFloat.length) {
          this.mParams[i] = arrayOfFloat[i] * (1.0F - param1Float) + param1PathDataNode2.mParams[i] * param1Float;
          i++;
          continue;
        } 
        break;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\graphics\PathParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */