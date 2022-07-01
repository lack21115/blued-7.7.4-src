package android.support.v4.graphics;

import android.graphics.Path;
import java.util.ArrayList;

public final class PathParser {
  private static void addNode(ArrayList<PathParser$PathDataNode> paramArrayList, char paramChar, float[] paramArrayOffloat) {
    paramArrayList.add(new PathParser$PathDataNode(paramChar, paramArrayOffloat));
  }
  
  public static boolean canMorph(PathParser$PathDataNode[] paramArrayOfPathParser$PathDataNode1, PathParser$PathDataNode[] paramArrayOfPathParser$PathDataNode2) {
    if (paramArrayOfPathParser$PathDataNode1 != null) {
      if (paramArrayOfPathParser$PathDataNode2 == null)
        return false; 
      if (paramArrayOfPathParser$PathDataNode1.length != paramArrayOfPathParser$PathDataNode2.length)
        return false; 
      int i = 0;
      while (i < paramArrayOfPathParser$PathDataNode1.length) {
        if ((paramArrayOfPathParser$PathDataNode1[i]).mType == (paramArrayOfPathParser$PathDataNode2[i]).mType) {
          if ((paramArrayOfPathParser$PathDataNode1[i]).mParams.length != (paramArrayOfPathParser$PathDataNode2[i]).mParams.length)
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
  
  static float[] copyOfRange(float[] paramArrayOffloat, int paramInt1, int paramInt2) {
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
  
  public static PathParser$PathDataNode[] createNodesFromPathData(String paramString) {
    if (paramString == null)
      return null; 
    ArrayList arrayList = new ArrayList();
    int j = 1;
    int i = 0;
    while (j < paramString.length()) {
      j = nextStart(paramString, j);
      String str = paramString.substring(i, j).trim();
      if (str.length() > 0) {
        float[] arrayOfFloat = getFloats(str);
        addNode(arrayList, str.charAt(0), arrayOfFloat);
      } 
      i = j;
      j++;
    } 
    if (j - i == 1 && i < paramString.length())
      addNode(arrayList, paramString.charAt(i), new float[0]); 
    return (PathParser$PathDataNode[])arrayList.toArray((Object[])new PathParser$PathDataNode[arrayList.size()]);
  }
  
  public static Path createPathFromPathData(String paramString) {
    Path path = new Path();
    PathParser$PathDataNode[] arrayOfPathParser$PathDataNode = createNodesFromPathData(paramString);
    if (arrayOfPathParser$PathDataNode != null)
      try {
        PathParser$PathDataNode.nodesToPath(arrayOfPathParser$PathDataNode, path);
        return path;
      } catch (RuntimeException runtimeException) {
        StringBuilder stringBuilder = new StringBuilder("Error in parsing ");
        stringBuilder.append(paramString);
        throw new RuntimeException(stringBuilder.toString(), runtimeException);
      }  
    return null;
  }
  
  public static PathParser$PathDataNode[] deepCopyNodes(PathParser$PathDataNode[] paramArrayOfPathParser$PathDataNode) {
    if (paramArrayOfPathParser$PathDataNode == null)
      return null; 
    PathParser$PathDataNode[] arrayOfPathParser$PathDataNode = new PathParser$PathDataNode[paramArrayOfPathParser$PathDataNode.length];
    for (int i = 0; i < paramArrayOfPathParser$PathDataNode.length; i++)
      arrayOfPathParser$PathDataNode[i] = new PathParser$PathDataNode(paramArrayOfPathParser$PathDataNode[i]); 
    return arrayOfPathParser$PathDataNode;
  }
  
  private static float[] getFloats(String paramString) {
    if (paramString.charAt(0) == 'z' || paramString.charAt(0) == 'Z')
      return new float[0]; 
    try {
      float[] arrayOfFloat = new float[paramString.length()];
      PathParser$ExtractFloatResult pathParser$ExtractFloatResult = new PathParser$ExtractFloatResult();
      int k = paramString.length();
      int i = 1;
      int j = 0;
      label45: while (true) {
        if (i < k) {
          pathParser$ExtractFloatResult.mEndWithNegOrDot = false;
          int n = i;
          int m = 0;
          boolean bool2 = false;
          boolean bool1 = false;
          while (true) {
            if (n < paramString.length()) {
              char c = paramString.charAt(n);
              if (c != ' ') {
                if (c != 'E' && c != 'e') {
                  switch (c) {
                    case '-':
                    
                    default:
                      m = 0;
                      break;
                    case '.':
                      if (!bool2) {
                        m = 0;
                        bool2 = true;
                        break;
                      } 
                      pathParser$ExtractFloatResult.mEndWithNegOrDot = true;
                    case ',':
                      m = 0;
                      bool1 = true;
                      break;
                  } 
                } else {
                  m = 1;
                } 
                if (!bool1) {
                  n++;
                  continue;
                } 
              } else {
              
              } 
            } 
            pathParser$ExtractFloatResult.mEndPosition = n;
            n = pathParser$ExtractFloatResult.mEndPosition;
            m = j;
            if (i < n) {
              arrayOfFloat[j] = Float.parseFloat(paramString.substring(i, n));
              m = j + 1;
            } 
            if (pathParser$ExtractFloatResult.mEndWithNegOrDot) {
              i = n;
              j = m;
              continue label45;
            } 
            continue;
            i = n + 1;
            j = m;
          } 
          break;
        } 
        return copyOfRange(arrayOfFloat, 0, j);
      } 
    } catch (NumberFormatException numberFormatException) {
      StringBuilder stringBuilder = new StringBuilder("error in parsing \"");
      stringBuilder.append(paramString);
      stringBuilder.append("\"");
      throw new RuntimeException(stringBuilder.toString(), numberFormatException);
    } 
  }
  
  private static int nextStart(String paramString, int paramInt) {
    while (paramInt < paramString.length()) {
      char c = paramString.charAt(paramInt);
      if (((c - 65) * (c - 90) <= 0 || (c - 97) * (c - 122) <= 0) && c != 'e' && c != 'E')
        return paramInt; 
      paramInt++;
    } 
    return paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\graphics\PathParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */