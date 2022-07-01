package org.chromium.content_public.browser;

import android.os.Handler;
import org.chromium.base.annotations.UsedByReflection;

@UsedByReflection
public interface SmartClipProvider {
  @UsedByReflection
  void extractSmartClipData(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  @UsedByReflection
  void setSmartClipResultHandler(Handler paramHandler);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content_public\browser\SmartClipProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */