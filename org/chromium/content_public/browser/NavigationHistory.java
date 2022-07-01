package org.chromium.content_public.browser;

import java.util.ArrayList;

public class NavigationHistory {
  public int mCurrentEntryIndex;
  
  public final ArrayList mEntries = new ArrayList();
  
  public final NavigationEntry getEntryAtIndex(int paramInt) {
    return this.mEntries.get(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content_public\browser\NavigationHistory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */