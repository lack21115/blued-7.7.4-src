package androidx.core.view.accessibility;

import android.os.Build;
import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;
import java.util.List;

public class AccessibilityRecordCompat {
  private final AccessibilityRecord a;
  
  @Deprecated
  public AccessibilityRecordCompat(Object paramObject) {
    this.a = (AccessibilityRecord)paramObject;
  }
  
  public static int getMaxScrollX(AccessibilityRecord paramAccessibilityRecord) {
    return (Build.VERSION.SDK_INT >= 15) ? paramAccessibilityRecord.getMaxScrollX() : 0;
  }
  
  public static int getMaxScrollY(AccessibilityRecord paramAccessibilityRecord) {
    return (Build.VERSION.SDK_INT >= 15) ? paramAccessibilityRecord.getMaxScrollY() : 0;
  }
  
  @Deprecated
  public static AccessibilityRecordCompat obtain() {
    return new AccessibilityRecordCompat(AccessibilityRecord.obtain());
  }
  
  @Deprecated
  public static AccessibilityRecordCompat obtain(AccessibilityRecordCompat paramAccessibilityRecordCompat) {
    return new AccessibilityRecordCompat(AccessibilityRecord.obtain(paramAccessibilityRecordCompat.a));
  }
  
  public static void setMaxScrollX(AccessibilityRecord paramAccessibilityRecord, int paramInt) {
    if (Build.VERSION.SDK_INT >= 15)
      paramAccessibilityRecord.setMaxScrollX(paramInt); 
  }
  
  public static void setMaxScrollY(AccessibilityRecord paramAccessibilityRecord, int paramInt) {
    if (Build.VERSION.SDK_INT >= 15)
      paramAccessibilityRecord.setMaxScrollY(paramInt); 
  }
  
  public static void setSource(AccessibilityRecord paramAccessibilityRecord, View paramView, int paramInt) {
    if (Build.VERSION.SDK_INT >= 16)
      paramAccessibilityRecord.setSource(paramView, paramInt); 
  }
  
  @Deprecated
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof AccessibilityRecordCompat))
      return false; 
    paramObject = paramObject;
    AccessibilityRecord accessibilityRecord = this.a;
    if (accessibilityRecord == null) {
      if (((AccessibilityRecordCompat)paramObject).a != null)
        return false; 
    } else if (!accessibilityRecord.equals(((AccessibilityRecordCompat)paramObject).a)) {
      return false;
    } 
    return true;
  }
  
  @Deprecated
  public int getAddedCount() {
    return this.a.getAddedCount();
  }
  
  @Deprecated
  public CharSequence getBeforeText() {
    return this.a.getBeforeText();
  }
  
  @Deprecated
  public CharSequence getClassName() {
    return this.a.getClassName();
  }
  
  @Deprecated
  public CharSequence getContentDescription() {
    return this.a.getContentDescription();
  }
  
  @Deprecated
  public int getCurrentItemIndex() {
    return this.a.getCurrentItemIndex();
  }
  
  @Deprecated
  public int getFromIndex() {
    return this.a.getFromIndex();
  }
  
  @Deprecated
  public Object getImpl() {
    return this.a;
  }
  
  @Deprecated
  public int getItemCount() {
    return this.a.getItemCount();
  }
  
  @Deprecated
  public int getMaxScrollX() {
    return getMaxScrollX(this.a);
  }
  
  @Deprecated
  public int getMaxScrollY() {
    return getMaxScrollY(this.a);
  }
  
  @Deprecated
  public Parcelable getParcelableData() {
    return this.a.getParcelableData();
  }
  
  @Deprecated
  public int getRemovedCount() {
    return this.a.getRemovedCount();
  }
  
  @Deprecated
  public int getScrollX() {
    return this.a.getScrollX();
  }
  
  @Deprecated
  public int getScrollY() {
    return this.a.getScrollY();
  }
  
  @Deprecated
  public AccessibilityNodeInfoCompat getSource() {
    return AccessibilityNodeInfoCompat.a(this.a.getSource());
  }
  
  @Deprecated
  public List<CharSequence> getText() {
    return this.a.getText();
  }
  
  @Deprecated
  public int getToIndex() {
    return this.a.getToIndex();
  }
  
  @Deprecated
  public int getWindowId() {
    return this.a.getWindowId();
  }
  
  @Deprecated
  public int hashCode() {
    AccessibilityRecord accessibilityRecord = this.a;
    return (accessibilityRecord == null) ? 0 : accessibilityRecord.hashCode();
  }
  
  @Deprecated
  public boolean isChecked() {
    return this.a.isChecked();
  }
  
  @Deprecated
  public boolean isEnabled() {
    return this.a.isEnabled();
  }
  
  @Deprecated
  public boolean isFullScreen() {
    return this.a.isFullScreen();
  }
  
  @Deprecated
  public boolean isPassword() {
    return this.a.isPassword();
  }
  
  @Deprecated
  public boolean isScrollable() {
    return this.a.isScrollable();
  }
  
  @Deprecated
  public void recycle() {
    this.a.recycle();
  }
  
  @Deprecated
  public void setAddedCount(int paramInt) {
    this.a.setAddedCount(paramInt);
  }
  
  @Deprecated
  public void setBeforeText(CharSequence paramCharSequence) {
    this.a.setBeforeText(paramCharSequence);
  }
  
  @Deprecated
  public void setChecked(boolean paramBoolean) {
    this.a.setChecked(paramBoolean);
  }
  
  @Deprecated
  public void setClassName(CharSequence paramCharSequence) {
    this.a.setClassName(paramCharSequence);
  }
  
  @Deprecated
  public void setContentDescription(CharSequence paramCharSequence) {
    this.a.setContentDescription(paramCharSequence);
  }
  
  @Deprecated
  public void setCurrentItemIndex(int paramInt) {
    this.a.setCurrentItemIndex(paramInt);
  }
  
  @Deprecated
  public void setEnabled(boolean paramBoolean) {
    this.a.setEnabled(paramBoolean);
  }
  
  @Deprecated
  public void setFromIndex(int paramInt) {
    this.a.setFromIndex(paramInt);
  }
  
  @Deprecated
  public void setFullScreen(boolean paramBoolean) {
    this.a.setFullScreen(paramBoolean);
  }
  
  @Deprecated
  public void setItemCount(int paramInt) {
    this.a.setItemCount(paramInt);
  }
  
  @Deprecated
  public void setMaxScrollX(int paramInt) {
    setMaxScrollX(this.a, paramInt);
  }
  
  @Deprecated
  public void setMaxScrollY(int paramInt) {
    setMaxScrollY(this.a, paramInt);
  }
  
  @Deprecated
  public void setParcelableData(Parcelable paramParcelable) {
    this.a.setParcelableData(paramParcelable);
  }
  
  @Deprecated
  public void setPassword(boolean paramBoolean) {
    this.a.setPassword(paramBoolean);
  }
  
  @Deprecated
  public void setRemovedCount(int paramInt) {
    this.a.setRemovedCount(paramInt);
  }
  
  @Deprecated
  public void setScrollX(int paramInt) {
    this.a.setScrollX(paramInt);
  }
  
  @Deprecated
  public void setScrollY(int paramInt) {
    this.a.setScrollY(paramInt);
  }
  
  @Deprecated
  public void setScrollable(boolean paramBoolean) {
    this.a.setScrollable(paramBoolean);
  }
  
  @Deprecated
  public void setSource(View paramView) {
    this.a.setSource(paramView);
  }
  
  @Deprecated
  public void setSource(View paramView, int paramInt) {
    setSource(this.a, paramView, paramInt);
  }
  
  @Deprecated
  public void setToIndex(int paramInt) {
    this.a.setToIndex(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\view\accessibility\AccessibilityRecordCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */