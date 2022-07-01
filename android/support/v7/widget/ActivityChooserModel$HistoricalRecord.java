package android.support.v7.widget;

import android.content.ComponentName;
import java.math.BigDecimal;

public final class ActivityChooserModel$HistoricalRecord {
  public final ComponentName activity;
  
  public final long time;
  
  public final float weight;
  
  public ActivityChooserModel$HistoricalRecord(ComponentName paramComponentName, long paramLong, float paramFloat) {
    this.activity = paramComponentName;
    this.time = paramLong;
    this.weight = paramFloat;
  }
  
  public ActivityChooserModel$HistoricalRecord(String paramString, long paramLong, float paramFloat) {
    this(ComponentName.unflattenFromString(paramString), paramLong, paramFloat);
  }
  
  public final boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null)
      return false; 
    if (getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    if (this.activity == null) {
      if (((ActivityChooserModel$HistoricalRecord)paramObject).activity != null)
        return false; 
    } else if (!this.activity.equals(((ActivityChooserModel$HistoricalRecord)paramObject).activity)) {
      return false;
    } 
    return (this.time != ((ActivityChooserModel$HistoricalRecord)paramObject).time) ? false : (!(Float.floatToIntBits(this.weight) != Float.floatToIntBits(((ActivityChooserModel$HistoricalRecord)paramObject).weight)));
  }
  
  public final int hashCode() {
    int i;
    if (this.activity == null) {
      i = 0;
    } else {
      i = this.activity.hashCode();
    } 
    return ((i + 31) * 31 + (int)(this.time ^ this.time >>> 32L)) * 31 + Float.floatToIntBits(this.weight);
  }
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[");
    stringBuilder.append("; activity:");
    stringBuilder.append(this.activity);
    stringBuilder.append("; time:");
    stringBuilder.append(this.time);
    stringBuilder.append("; weight:");
    stringBuilder.append(new BigDecimal(this.weight));
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\ActivityChooserModel$HistoricalRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */