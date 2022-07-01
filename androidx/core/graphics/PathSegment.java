package androidx.core.graphics;

import android.graphics.PointF;
import androidx.core.util.Preconditions;

public final class PathSegment {
  private final PointF a;
  
  private final float b;
  
  private final PointF c;
  
  private final float d;
  
  public PathSegment(PointF paramPointF1, float paramFloat1, PointF paramPointF2, float paramFloat2) {
    this.a = (PointF)Preconditions.checkNotNull(paramPointF1, "start == null");
    this.b = paramFloat1;
    this.c = (PointF)Preconditions.checkNotNull(paramPointF2, "end == null");
    this.d = paramFloat2;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof PathSegment))
      return false; 
    paramObject = paramObject;
    return (Float.compare(this.b, ((PathSegment)paramObject).b) == 0 && Float.compare(this.d, ((PathSegment)paramObject).d) == 0 && this.a.equals(((PathSegment)paramObject).a) && this.c.equals(((PathSegment)paramObject).c));
  }
  
  public PointF getEnd() {
    return this.c;
  }
  
  public float getEndFraction() {
    return this.d;
  }
  
  public PointF getStart() {
    return this.a;
  }
  
  public float getStartFraction() {
    return this.b;
  }
  
  public int hashCode() {
    byte b;
    int j = this.a.hashCode();
    float f = this.b;
    int i = 0;
    if (f != 0.0F) {
      b = Float.floatToIntBits(f);
    } else {
      b = 0;
    } 
    int k = this.c.hashCode();
    f = this.d;
    if (f != 0.0F)
      i = Float.floatToIntBits(f); 
    return ((j * 31 + b) * 31 + k) * 31 + i;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("PathSegment{start=");
    stringBuilder.append(this.a);
    stringBuilder.append(", startFraction=");
    stringBuilder.append(this.b);
    stringBuilder.append(", end=");
    stringBuilder.append(this.c);
    stringBuilder.append(", endFraction=");
    stringBuilder.append(this.d);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\graphics\PathSegment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */