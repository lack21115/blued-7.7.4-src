package android.support.v7.view.menu;

import android.support.v7.widget.MenuItemHoverListener;
import android.view.MenuItem;

final class CascadingMenuPopup$3 implements MenuItemHoverListener {
  public final void onItemHoverEnter(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem) {
    // Byte code:
    //   0: aload_0
    //   1: getfield this$0 : Landroid/support/v7/view/menu/CascadingMenuPopup;
    //   4: getfield mSubMenuHoverHandler : Landroid/os/Handler;
    //   7: astore #8
    //   9: aconst_null
    //   10: astore #7
    //   12: aload #8
    //   14: aconst_null
    //   15: invokevirtual removeCallbacksAndMessages : (Ljava/lang/Object;)V
    //   18: aload_0
    //   19: getfield this$0 : Landroid/support/v7/view/menu/CascadingMenuPopup;
    //   22: getfield mShowingMenus : Ljava/util/List;
    //   25: invokeinterface size : ()I
    //   30: istore #4
    //   32: iconst_0
    //   33: istore_3
    //   34: iload_3
    //   35: iload #4
    //   37: if_icmpge -> 73
    //   40: aload_1
    //   41: aload_0
    //   42: getfield this$0 : Landroid/support/v7/view/menu/CascadingMenuPopup;
    //   45: getfield mShowingMenus : Ljava/util/List;
    //   48: iload_3
    //   49: invokeinterface get : (I)Ljava/lang/Object;
    //   54: checkcast android/support/v7/view/menu/CascadingMenuPopup$CascadingMenuInfo
    //   57: getfield menu : Landroid/support/v7/view/menu/MenuBuilder;
    //   60: if_acmpne -> 66
    //   63: goto -> 75
    //   66: iload_3
    //   67: iconst_1
    //   68: iadd
    //   69: istore_3
    //   70: goto -> 34
    //   73: iconst_m1
    //   74: istore_3
    //   75: iload_3
    //   76: iconst_m1
    //   77: if_icmpne -> 81
    //   80: return
    //   81: iload_3
    //   82: iconst_1
    //   83: iadd
    //   84: istore_3
    //   85: iload_3
    //   86: aload_0
    //   87: getfield this$0 : Landroid/support/v7/view/menu/CascadingMenuPopup;
    //   90: getfield mShowingMenus : Ljava/util/List;
    //   93: invokeinterface size : ()I
    //   98: if_icmpge -> 122
    //   101: aload_0
    //   102: getfield this$0 : Landroid/support/v7/view/menu/CascadingMenuPopup;
    //   105: getfield mShowingMenus : Ljava/util/List;
    //   108: iload_3
    //   109: invokeinterface get : (I)Ljava/lang/Object;
    //   114: checkcast android/support/v7/view/menu/CascadingMenuPopup$CascadingMenuInfo
    //   117: astore #7
    //   119: goto -> 122
    //   122: new android/support/v7/view/menu/CascadingMenuPopup$3$1
    //   125: dup
    //   126: aload_0
    //   127: aload #7
    //   129: aload_2
    //   130: aload_1
    //   131: invokespecial <init> : (Landroid/support/v7/view/menu/CascadingMenuPopup$3;Landroid/support/v7/view/menu/CascadingMenuPopup$CascadingMenuInfo;Landroid/view/MenuItem;Landroid/support/v7/view/menu/MenuBuilder;)V
    //   134: astore_2
    //   135: invokestatic uptimeMillis : ()J
    //   138: lstore #5
    //   140: aload_0
    //   141: getfield this$0 : Landroid/support/v7/view/menu/CascadingMenuPopup;
    //   144: getfield mSubMenuHoverHandler : Landroid/os/Handler;
    //   147: aload_2
    //   148: aload_1
    //   149: lload #5
    //   151: ldc2_w 200
    //   154: ladd
    //   155: invokevirtual postAtTime : (Ljava/lang/Runnable;Ljava/lang/Object;J)Z
    //   158: pop
    //   159: return
  }
  
  public final void onItemHoverExit(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem) {
    CascadingMenuPopup.this.mSubMenuHoverHandler.removeCallbacksAndMessages(paramMenuBuilder);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\view\menu\CascadingMenuPopup$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */