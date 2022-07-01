package android.support.v7.widget;

import android.content.pm.ResolveInfo;
import java.math.BigDecimal;

public final class ActivityChooserModel$ActivityResolveInfo implements Comparable {
  public final ResolveInfo resolveInfo;
  
  public float weight;
  
  public ActivityChooserModel$ActivityResolveInfo(ResolveInfo paramResolveInfo) {
    this.resolveInfo = paramResolveInfo;
  }
  
  public final boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null)
      return false; 
    if (getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    return !(Float.floatToIntBits(this.weight) != Float.floatToIntBits(((ActivityChooserModel$ActivityResolveInfo)paramObject).weight));
  }
  
  public final int hashCode() {
    return Float.floatToIntBits(this.weight) + 31;
  }
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[");
    stringBuilder.append("resolveInfo:");
    stringBuilder.append(this.resolveInfo.toString());
    stringBuilder.append("; weight:");
    stringBuilder.append(new BigDecimal(this.weight));
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\ActivityChooserModel$ActivityResolveInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */