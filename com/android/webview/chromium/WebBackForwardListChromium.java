package com.android.webview.chromium;

import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import java.util.ArrayList;
import java.util.List;
import org.chromium.content_public.browser.NavigationHistory;

public final class WebBackForwardListChromium extends WebBackForwardList {
  private final int mCurrentIndex;
  
  private final List mHistroryItemList;
  
  private WebBackForwardListChromium(List paramList, int paramInt) {
    this.mHistroryItemList = paramList;
    this.mCurrentIndex = paramInt;
  }
  
  WebBackForwardListChromium(NavigationHistory paramNavigationHistory) {
    this.mCurrentIndex = paramNavigationHistory.mCurrentEntryIndex;
    this.mHistroryItemList = new ArrayList(paramNavigationHistory.mEntries.size());
    for (int i = 0; i < paramNavigationHistory.mEntries.size(); i++)
      this.mHistroryItemList.add(new WebHistoryItemChromium(paramNavigationHistory.getEntryAtIndex(i))); 
  }
  
  private WebBackForwardListChromium clone() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/util/ArrayList
    //   5: dup
    //   6: aload_0
    //   7: invokevirtual getSize : ()I
    //   10: invokespecial <init> : (I)V
    //   13: astore_2
    //   14: iconst_0
    //   15: istore_1
    //   16: iload_1
    //   17: aload_0
    //   18: invokevirtual getSize : ()I
    //   21: if_icmpge -> 54
    //   24: aload_2
    //   25: aload_0
    //   26: getfield mHistroryItemList : Ljava/util/List;
    //   29: iload_1
    //   30: invokeinterface get : (I)Ljava/lang/Object;
    //   35: checkcast com/android/webview/chromium/WebHistoryItemChromium
    //   38: invokevirtual clone : ()Lcom/android/webview/chromium/WebHistoryItemChromium;
    //   41: invokeinterface add : (Ljava/lang/Object;)Z
    //   46: pop
    //   47: iload_1
    //   48: iconst_1
    //   49: iadd
    //   50: istore_1
    //   51: goto -> 16
    //   54: new com/android/webview/chromium/WebBackForwardListChromium
    //   57: dup
    //   58: aload_2
    //   59: aload_0
    //   60: getfield mCurrentIndex : I
    //   63: invokespecial <init> : (Ljava/util/List;I)V
    //   66: astore_2
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_2
    //   70: areturn
    //   71: astore_2
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_2
    //   75: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	71	finally
    //   16	47	71	finally
    //   54	67	71	finally
  }
  
  public final int getCurrentIndex() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mCurrentIndex : I
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public final WebHistoryItem getCurrentItem() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual getSize : ()I
    //   6: istore_1
    //   7: iload_1
    //   8: ifne -> 15
    //   11: aload_0
    //   12: monitorexit
    //   13: aconst_null
    //   14: areturn
    //   15: aload_0
    //   16: aload_0
    //   17: invokevirtual getCurrentIndex : ()I
    //   20: invokevirtual getItemAtIndex : (I)Landroid/webkit/WebHistoryItem;
    //   23: astore_2
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_2
    //   27: areturn
    //   28: astore_2
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_2
    //   32: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	28	finally
    //   15	24	28	finally
  }
  
  public final WebHistoryItem getItemAtIndex(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: iflt -> 40
    //   6: iload_1
    //   7: aload_0
    //   8: invokevirtual getSize : ()I
    //   11: if_icmplt -> 17
    //   14: goto -> 40
    //   17: aload_0
    //   18: getfield mHistroryItemList : Ljava/util/List;
    //   21: iload_1
    //   22: invokeinterface get : (I)Ljava/lang/Object;
    //   27: checkcast android/webkit/WebHistoryItem
    //   30: astore_2
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_2
    //   34: areturn
    //   35: astore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_2
    //   39: athrow
    //   40: aload_0
    //   41: monitorexit
    //   42: aconst_null
    //   43: areturn
    // Exception table:
    //   from	to	target	type
    //   6	14	35	finally
    //   17	31	35	finally
  }
  
  public final int getSize() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mHistroryItemList : Ljava/util/List;
    //   6: invokeinterface size : ()I
    //   11: istore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: iload_1
    //   15: ireturn
    //   16: astore_2
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_2
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	16	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\WebBackForwardListChromium.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */