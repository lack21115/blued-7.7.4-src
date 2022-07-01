package org.chromium.content.browser.accessibility;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.Arrays;
import org.chromium.content_public.browser.WebContents;

@TargetApi(26)
public class OWebContentsAccessibility extends LollipopWebContentsAccessibility {
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  OWebContentsAccessibility(WebContents paramWebContents) {
    super(paramWebContents);
  }
  
  public void addExtraDataToAccessibilityNodeInfo(int paramInt, AccessibilityNodeInfo paramAccessibilityNodeInfo, String paramString, Bundle paramBundle) {
    if (!paramString.equals("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY"))
      return; 
    if (!nativeAreInlineTextBoxesLoaded(this.mNativeObj, paramInt))
      nativeLoadInlineTextBoxes(this.mNativeObj, paramInt); 
    int j = paramBundle.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX", -1);
    int i = paramBundle.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH", -1);
    if (i > 0) {
      if (j < 0)
        return; 
      int[] arrayOfInt = nativeGetCharacterBoundingBoxes(this.mNativeObj, paramInt, j, i);
      if (arrayOfInt == null)
        return; 
      assert false;
      throw new AssertionError();
    } 
  }
  
  protected void setAccessibilityNodeInfoKitKatAttributes(AccessibilityNodeInfo paramAccessibilityNodeInfo, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, boolean paramBoolean3) {
    super.setAccessibilityNodeInfoKitKatAttributes(paramAccessibilityNodeInfo, paramBoolean1, paramBoolean2, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramBoolean3);
    paramAccessibilityNodeInfo.setHintText(paramString3);
    throw new VerifyError("bad dex opcode");
  }
  
  protected void setAccessibilityNodeInfoOAttributes(AccessibilityNodeInfo paramAccessibilityNodeInfo, boolean paramBoolean) {
    if (!paramBoolean)
      throw new VerifyError("bad dex opcode"); 
    paramAccessibilityNodeInfo.setAvailableExtraData(Arrays.asList(new String[] { "android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY" }));
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\accessibility\OWebContentsAccessibility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */