package android.support.v4.graphics;

import android.graphics.Path;
import android.util.Log;

public final class PathParser$PathDataNode {
  public float[] mParams;
  
  public char mType;
  
  PathParser$PathDataNode(char paramChar, float[] paramArrayOffloat) {
    this.mType = paramChar;
    this.mParams = paramArrayOffloat;
  }
  
  PathParser$PathDataNode(PathParser$PathDataNode paramPathParser$PathDataNode) {
    this.mType = paramPathParser$PathDataNode.mType;
    this.mParams = PathParser.copyOfRange(paramPathParser$PathDataNode.mParams, 0, paramPathParser$PathDataNode.mParams.length);
  }
  
  private static void arcToBezier(Path paramPath, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8, double paramDouble9) {
    int i = (int)Math.ceil(Math.abs(paramDouble9 * 4.0D / Math.PI));
    double d5 = Math.cos(paramDouble7);
    double d7 = Math.sin(paramDouble7);
    double d1 = Math.cos(paramDouble8);
    double d2 = Math.sin(paramDouble8);
    paramDouble7 = -paramDouble3;
    double d9 = paramDouble7 * d5;
    double d10 = paramDouble4 * d7;
    double d6 = paramDouble7 * d7;
    paramDouble7 = paramDouble4 * d5;
    double d8 = paramDouble9 / i;
    int j = 0;
    double d3 = d2 * d6 + d1 * paramDouble7;
    d1 = d9 * d2 - d10 * d1;
    d2 = paramDouble6;
    paramDouble9 = paramDouble5;
    double d4 = paramDouble8;
    paramDouble4 = d7;
    paramDouble5 = d5;
    paramDouble6 = d6;
    paramDouble8 = d8;
    while (true) {
      d5 = paramDouble3;
      if (j < i) {
        d6 = d4 + paramDouble8;
        d8 = Math.sin(d6);
        double d12 = Math.cos(d6);
        d7 = paramDouble1 + d5 * paramDouble5 * d12 - d10 * d8;
        double d11 = paramDouble2 + d5 * paramDouble4 * d12 + paramDouble7 * d8;
        d5 = d9 * d8 - d10 * d12;
        d8 = d8 * paramDouble6 + d12 * paramDouble7;
        d4 = d6 - d4;
        d12 = Math.tan(d4 / 2.0D);
        d4 = Math.sin(d4) * (Math.sqrt(d12 * 3.0D * d12 + 4.0D) - 1.0D) / 3.0D;
        paramPath.rLineTo(0.0F, 0.0F);
        paramPath.cubicTo((float)(paramDouble9 + d1 * d4), (float)(d2 + d3 * d4), (float)(d7 - d4 * d5), (float)(d11 - d4 * d8), (float)d7, (float)d11);
        j++;
        d2 = d11;
        paramDouble9 = d7;
        d4 = d6;
        d3 = d8;
        d1 = d5;
        continue;
      } 
      break;
    } 
  }
  
  private static void drawArc(Path paramPath, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, boolean paramBoolean1, boolean paramBoolean2) {
    float f = paramFloat5;
    paramFloat5 = paramFloat6;
    paramFloat6 = f;
    while (true) {
      f = paramFloat1;
      double d5 = Math.toRadians(paramFloat7);
      double d6 = Math.cos(d5);
      double d7 = Math.sin(d5);
      double d8 = f;
      double d9 = paramFloat2;
      double d10 = paramFloat6;
      double d1 = (d8 * d6 + d9 * d7) / d10;
      double d2 = -f;
      double d11 = paramFloat5;
      double d4 = (d2 * d7 + d9 * d6) / d11;
      double d3 = paramFloat3;
      d2 = paramFloat4;
      double d12 = (d3 * d6 + d2 * d7) / d10;
      double d13 = (-paramFloat3 * d7 + d2 * d6) / d11;
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
        StringBuilder stringBuilder = new StringBuilder("Points are too far apart ");
        stringBuilder.append(d16);
        Log.w("PathParser", stringBuilder.toString());
        f = (float)(Math.sqrt(d16) / 1.99999D);
        paramFloat6 *= f;
        paramFloat5 *= f;
        continue;
      } 
      d16 = Math.sqrt(d17);
      d15 *= d16;
      d14 = d16 * d14;
      if (paramBoolean1 == paramBoolean2) {
        d3 -= d14;
        d2 += d15;
      } else {
        d3 += d14;
        d2 -= d15;
      } 
      d14 = Math.atan2(d4 - d2, d1 - d3);
      d4 = Math.atan2(d13 - d2, d12 - d3) - d14;
      if (d4 >= 0.0D) {
        paramBoolean1 = true;
      } else {
        paramBoolean1 = false;
      } 
      d1 = d4;
      if (paramBoolean2 != paramBoolean1)
        if (d4 > 0.0D) {
          d1 = d4 - 6.283185307179586D;
        } else {
          d1 = d4 + 6.283185307179586D;
        }  
      d3 *= d10;
      d2 *= d11;
      arcToBezier(paramPath, d3 * d6 - d2 * d7, d3 * d7 + d2 * d6, d10, d11, d8, d9, d5, d14, d1);
      return;
    } 
  }
  
  public static void nodesToPath(PathParser$PathDataNode[] paramArrayOfPathParser$PathDataNode, Path paramPath) {
    float[] arrayOfFloat = new float[6];
    int j = 109;
    int i = 0;
    while (true) {
      PathParser$PathDataNode[] arrayOfPathParser$PathDataNode = paramArrayOfPathParser$PathDataNode;
      if (i < arrayOfPathParser$PathDataNode.length) {
        byte b;
        int k = (arrayOfPathParser$PathDataNode[i]).mType;
        float[] arrayOfFloat1 = (arrayOfPathParser$PathDataNode[i]).mParams;
        float f1 = arrayOfFloat[0];
        float f2 = arrayOfFloat[1];
        float f3 = arrayOfFloat[2];
        float f4 = arrayOfFloat[3];
        float f6 = arrayOfFloat[4];
        float f5 = arrayOfFloat[5];
        switch (k) {
          default:
            b = 2;
            break;
          case 'Z':
          case 'z':
            paramPath.close();
            paramPath.moveTo(f6, f5);
            f1 = f6;
            f3 = f1;
            f2 = f5;
            f4 = f2;
          case 'Q':
          case 'S':
          case 'q':
          case 's':
            b = 4;
            break;
          case 'L':
          case 'M':
          case 'T':
          case 'l':
          case 'm':
          case 't':
            b = 2;
            break;
          case 'H':
          case 'V':
          case 'h':
          case 'v':
            b = 1;
            break;
          case 'C':
          case 'c':
            b = 6;
            break;
          case 'A':
          case 'a':
            b = 7;
            break;
        } 
        int n = 0;
        float f7 = f2;
        int m = i;
        i = n;
        f2 = f1;
        f1 = f7;
        while (i < arrayOfFloat1.length) {
          float f8;
          float f9;
          int i1;
          int i2;
          boolean bool1;
          boolean bool2;
          float[] arrayOfFloat2;
          f7 = 0.0F;
          switch (k) {
            case 118:
              paramPath.rLineTo(0.0F, arrayOfFloat1[i]);
              f1 += arrayOfFloat1[i];
              break;
            case 116:
              if (j == 113 || j == 116 || j == 81 || j == 84) {
                f3 = f2 - f3;
                f4 = f1 - f4;
              } else {
                f4 = 0.0F;
                f3 = f7;
              } 
              f7 = arrayOfFloat1[i];
              j = i + 1;
              paramPath.rQuadTo(f3, f4, f7, arrayOfFloat1[j]);
              f7 = f2 + arrayOfFloat1[i];
              f8 = f1 + arrayOfFloat1[j];
              f4 += f1;
              f3 += f2;
              f1 = f8;
              f2 = f7;
              break;
            case 115:
              if (j == 99 || j == 115 || j == 67 || j == 83) {
                f4 = f1 - f4;
                f3 = f2 - f3;
              } else {
                f3 = 0.0F;
                f4 = 0.0F;
              } 
              f7 = arrayOfFloat1[i];
              j = i + 1;
              f8 = arrayOfFloat1[j];
              n = i + 2;
              f9 = arrayOfFloat1[n];
              i1 = i + 3;
              paramPath.rCubicTo(f3, f4, f7, f8, f9, arrayOfFloat1[i1]);
              f3 = f2 + arrayOfFloat1[i];
              f4 = f1 + arrayOfFloat1[j];
              f7 = arrayOfFloat1[n] + f2;
              f2 = f1 + arrayOfFloat1[i1];
              f1 = f7;
              f7 = f1;
              f1 = f2;
              f2 = f7;
              break;
            case 113:
              f3 = arrayOfFloat1[i];
              j = i + 1;
              f4 = arrayOfFloat1[j];
              n = i + 2;
              f7 = arrayOfFloat1[n];
              i1 = i + 3;
              paramPath.rQuadTo(f3, f4, f7, arrayOfFloat1[i1]);
              f3 = arrayOfFloat1[i];
              f4 = arrayOfFloat1[j];
              f8 = arrayOfFloat1[n];
              f7 = f1 + arrayOfFloat1[i1];
              f4 += f1;
              f3 = f2 + f3;
              f2 = f8 + f2;
              f1 = f7;
              break;
            case 109:
              f2 += arrayOfFloat1[i];
              j = i + 1;
              f1 += arrayOfFloat1[j];
              if (i > 0) {
                paramPath.rLineTo(arrayOfFloat1[i], arrayOfFloat1[j]);
                break;
              } 
              paramPath.rMoveTo(arrayOfFloat1[i], arrayOfFloat1[j]);
              f5 = f1;
              f6 = f2;
              break;
            case 108:
              f7 = arrayOfFloat1[i];
              j = i + 1;
              paramPath.rLineTo(f7, arrayOfFloat1[j]);
              f2 += arrayOfFloat1[i];
              f1 += arrayOfFloat1[j];
              break;
            case 104:
              paramPath.rLineTo(arrayOfFloat1[i], 0.0F);
              f2 += arrayOfFloat1[i];
              break;
            case 99:
              f3 = arrayOfFloat1[i];
              f4 = arrayOfFloat1[i + 1];
              j = i + 2;
              f7 = arrayOfFloat1[j];
              n = i + 3;
              f8 = arrayOfFloat1[n];
              i1 = i + 4;
              f9 = arrayOfFloat1[i1];
              i2 = i + 5;
              paramPath.rCubicTo(f3, f4, f7, f8, f9, arrayOfFloat1[i2]);
              f3 = f2 + arrayOfFloat1[j];
              f4 = f1 + arrayOfFloat1[n];
              f2 = arrayOfFloat1[i1] + f2;
              f7 = f1 + arrayOfFloat1[i2];
              f1 = f2;
              f2 = f7;
              f7 = f1;
              f1 = f2;
              f2 = f7;
              break;
            case 97:
              j = i + 5;
              f3 = arrayOfFloat1[j];
              n = i + 6;
              f4 = arrayOfFloat1[n];
              f7 = arrayOfFloat1[i];
              f8 = arrayOfFloat1[i + 1];
              f9 = arrayOfFloat1[i + 2];
              if (arrayOfFloat1[i + 3] != 0.0F) {
                bool1 = true;
              } else {
                bool1 = false;
              } 
              if (arrayOfFloat1[i + 4] != 0.0F) {
                bool2 = true;
              } else {
                bool2 = false;
              } 
              arrayOfFloat2 = arrayOfFloat1;
              drawArc(paramPath, f2, f1, f3 + f2, f4 + f1, f7, f8, f9, bool1, bool2);
              f2 += arrayOfFloat2[j];
              f1 += arrayOfFloat2[n];
              f4 = f1;
              f3 = f2;
              break;
            case 86:
              j = i;
              arrayOfFloat2 = arrayOfFloat1;
              paramPath.lineTo(f2, arrayOfFloat2[j]);
              f1 = arrayOfFloat2[j];
              break;
            case 84:
              f7 = f1;
              n = i;
              arrayOfFloat2 = arrayOfFloat1;
              f8 = f2;
            case 83:
              n = i;
              arrayOfFloat2 = arrayOfFloat1;
              if (j == 99 || j == 115 || j == 67 || j == 83) {
                f1 = f1 * 2.0F - f4;
                f3 = f2 * 2.0F - f3;
                f2 = f1;
                f1 = f3;
              } else {
                f3 = f1;
                f1 = f2;
                f2 = f3;
              } 
              f3 = arrayOfFloat2[n];
              j = n + 1;
              f4 = arrayOfFloat2[j];
              i1 = n + 2;
              f7 = arrayOfFloat2[i1];
              i2 = n + 3;
              paramPath.cubicTo(f1, f2, f3, f4, f7, arrayOfFloat2[i2]);
              f3 = arrayOfFloat2[n];
              f4 = arrayOfFloat2[j];
              f2 = arrayOfFloat2[i1];
              f1 = arrayOfFloat2[i2];
              break;
            case 81:
              j = i;
              arrayOfFloat2 = arrayOfFloat1;
              f1 = arrayOfFloat2[j];
              n = j + 1;
              f2 = arrayOfFloat2[n];
              i1 = j + 2;
              f3 = arrayOfFloat2[i1];
              i2 = j + 3;
              paramPath.quadTo(f1, f2, f3, arrayOfFloat2[i2]);
              f3 = arrayOfFloat2[j];
              f4 = arrayOfFloat2[n];
              f2 = arrayOfFloat2[i1];
              f1 = arrayOfFloat2[i2];
              break;
            case 77:
              j = i;
              arrayOfFloat2 = arrayOfFloat1;
              f2 = arrayOfFloat2[j];
              n = j + 1;
              f1 = arrayOfFloat2[n];
              if (j > 0) {
                paramPath.lineTo(arrayOfFloat2[j], arrayOfFloat2[n]);
                break;
              } 
              paramPath.moveTo(arrayOfFloat2[j], arrayOfFloat2[n]);
              f5 = f1;
              f6 = f2;
              break;
            case 76:
              j = i;
              arrayOfFloat2 = arrayOfFloat1;
              f1 = arrayOfFloat2[j];
              n = j + 1;
              paramPath.lineTo(f1, arrayOfFloat2[n]);
              f2 = arrayOfFloat2[j];
              f1 = arrayOfFloat2[n];
              break;
            case 72:
              j = i;
              arrayOfFloat2 = arrayOfFloat1;
              paramPath.lineTo(arrayOfFloat2[j], f1);
              f2 = arrayOfFloat2[j];
              break;
            case 67:
              j = i;
              arrayOfFloat2 = arrayOfFloat1;
              f1 = arrayOfFloat2[j];
              f2 = arrayOfFloat2[j + 1];
              n = j + 2;
              f3 = arrayOfFloat2[n];
              i1 = j + 3;
              f4 = arrayOfFloat2[i1];
              i2 = j + 4;
              f7 = arrayOfFloat2[i2];
              j += 5;
              paramPath.cubicTo(f1, f2, f3, f4, f7, arrayOfFloat2[j]);
              f2 = arrayOfFloat2[i2];
              f1 = arrayOfFloat2[j];
              f3 = arrayOfFloat2[n];
              f4 = arrayOfFloat2[i1];
              break;
            case 65:
              j = i;
              arrayOfFloat2 = arrayOfFloat1;
              n = j + 5;
              f3 = arrayOfFloat2[n];
              i1 = j + 6;
              f4 = arrayOfFloat2[i1];
              f7 = arrayOfFloat2[j];
              f8 = arrayOfFloat2[j + 1];
              f9 = arrayOfFloat2[j + 2];
              if (arrayOfFloat2[j + 3] != 0.0F) {
                bool1 = true;
              } else {
                bool1 = false;
              } 
              if (arrayOfFloat2[j + 4] != 0.0F) {
                bool2 = true;
              } else {
                bool2 = false;
              } 
              drawArc(paramPath, f2, f1, f3, f4, f7, f8, f9, bool1, bool2);
              f2 = arrayOfFloat2[n];
              f1 = arrayOfFloat2[i1];
              f4 = f1;
              f3 = f2;
              break;
          } 
          continue;
          i += b;
          n = m;
          m = k;
          j = k;
          k = m;
          m = n;
        } 
        arrayOfFloat[0] = f2;
        arrayOfFloat[1] = f1;
        arrayOfFloat[2] = f3;
        arrayOfFloat[3] = f4;
        arrayOfFloat[4] = f6;
        arrayOfFloat[5] = f5;
        j = (paramArrayOfPathParser$PathDataNode[m]).mType;
        i = m + 1;
        continue;
      } 
      break;
    } 
  }
  
  public final void interpolatePathDataNode(PathParser$PathDataNode paramPathParser$PathDataNode1, PathParser$PathDataNode paramPathParser$PathDataNode2, float paramFloat) {
    int i;
    for (i = 0; i < paramPathParser$PathDataNode1.mParams.length; i++)
      this.mParams[i] = paramPathParser$PathDataNode1.mParams[i] * (1.0F - paramFloat) + paramPathParser$PathDataNode2.mParams[i] * paramFloat; 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\graphics\PathParser$PathDataNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */