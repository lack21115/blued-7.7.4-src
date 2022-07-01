package androidx.core.graphics;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.ArrayList;
import java.util.Collection;

public final class PathUtils {
  public static Collection<PathSegment> flatten(Path paramPath) {
    return flatten(paramPath, 0.5F);
  }
  
  public static Collection<PathSegment> flatten(Path paramPath, float paramFloat) {
    float[] arrayOfFloat = paramPath.approximate(paramFloat);
    int j = arrayOfFloat.length / 3;
    ArrayList<PathSegment> arrayList = new ArrayList(j);
    int i;
    for (i = 1; i < j; i++) {
      int k = i * 3;
      int m = (i - 1) * 3;
      paramFloat = arrayOfFloat[k];
      float f1 = arrayOfFloat[k + 1];
      float f2 = arrayOfFloat[k + 2];
      float f3 = arrayOfFloat[m];
      float f4 = arrayOfFloat[m + 1];
      float f5 = arrayOfFloat[m + 2];
      if (paramFloat != f3 && (f1 != f4 || f2 != f5))
        arrayList.add(new PathSegment(new PointF(f4, f5), f3, new PointF(f1, f2), paramFloat)); 
    } 
    return arrayList;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\graphics\PathUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */