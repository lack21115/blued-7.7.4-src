package org.chromium.components.autofill;

import org.chromium.ui.DropdownItemBase;

public class AutofillSuggestion extends DropdownItemBase {
  private final int mIconId;
  
  private final boolean mIsBoldLabel;
  
  final boolean mIsDeletable;
  
  private final boolean mIsIconAtStart;
  
  private final boolean mIsMultilineLabel;
  
  private final String mLabel;
  
  private final String mSublabel;
  
  public final int mSuggestionId;
  
  public AutofillSuggestion(String paramString1, String paramString2, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
    this.mLabel = paramString1;
    this.mSublabel = paramString2;
    this.mIconId = paramInt1;
    this.mIsIconAtStart = paramBoolean1;
    this.mSuggestionId = paramInt2;
    this.mIsDeletable = paramBoolean2;
    this.mIsMultilineLabel = paramBoolean3;
    this.mIsBoldLabel = paramBoolean4;
  }
  
  public final int getIconId() {
    return this.mIconId;
  }
  
  public final String getLabel() {
    return this.mLabel;
  }
  
  public final int getLabelFontColorResId() {
    return (this.mSuggestionId == -1) ? R$color.insecure_context_payment_disabled_message_text : super.getLabelFontColorResId();
  }
  
  public final String getSublabel() {
    return this.mSublabel;
  }
  
  public final boolean isBoldLabel() {
    return this.mIsBoldLabel;
  }
  
  public final boolean isIconAtStart() {
    return this.mIsIconAtStart ? true : super.isIconAtStart();
  }
  
  public final boolean isMultilineLabel() {
    return this.mIsMultilineLabel;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\components\autofill\AutofillSuggestion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */