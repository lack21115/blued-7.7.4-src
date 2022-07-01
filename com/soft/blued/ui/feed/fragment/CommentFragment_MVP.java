package com.soft.blued.ui.feed.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import java.util.List;

public final class CommentFragment_MVP implements MvpDispatcher {
  private void a(CommentFragment paramCommentFragment, String paramString) {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual hashCode : ()I
    //   4: istore_3
    //   5: iload_3
    //   6: ldc -2055076317
    //   8: if_icmpeq -> 34
    //   11: iload_3
    //   12: ldc -1106079055
    //   14: if_icmpeq -> 20
    //   17: goto -> 48
    //   20: aload_2
    //   21: ldc 'comment_state'
    //   23: invokevirtual equals : (Ljava/lang/Object;)Z
    //   26: ifeq -> 48
    //   29: iconst_1
    //   30: istore_3
    //   31: goto -> 50
    //   34: aload_2
    //   35: ldc 'comment_success'
    //   37: invokevirtual equals : (Ljava/lang/Object;)Z
    //   40: ifeq -> 48
    //   43: iconst_0
    //   44: istore_3
    //   45: goto -> 50
    //   48: iconst_m1
    //   49: istore_3
    //   50: iload_3
    //   51: ifeq -> 65
    //   54: iload_3
    //   55: iconst_1
    //   56: if_icmpeq -> 60
    //   59: return
    //   60: aload_1
    //   61: invokevirtual E : ()V
    //   64: return
    //   65: aload_1
    //   66: invokevirtual F : ()V
    //   69: return
  }
  
  public void a(MvpFragment paramMvpFragment, String paramString, List paramList) {
    // Byte code:
    //   0: aload_1
    //   1: checkcast com/soft/blued/ui/feed/fragment/CommentFragment
    //   4: astore_1
    //   5: aload_3
    //   6: ifnull -> 186
    //   9: aload_3
    //   10: invokeinterface size : ()I
    //   15: ifle -> 186
    //   18: iconst_0
    //   19: istore #4
    //   21: aload_3
    //   22: iconst_0
    //   23: invokeinterface get : (I)Ljava/lang/Object;
    //   28: astore #6
    //   30: aload #6
    //   32: ifnull -> 186
    //   35: aload_2
    //   36: invokevirtual hashCode : ()I
    //   39: istore #5
    //   41: iload #5
    //   43: ldc -602415628
    //   45: if_icmpeq -> 95
    //   48: iload #5
    //   50: ldc 3321751
    //   52: if_icmpeq -> 80
    //   55: iload #5
    //   57: ldc 950398559
    //   59: if_icmpeq -> 65
    //   62: goto -> 107
    //   65: aload_2
    //   66: ldc 'comment'
    //   68: invokevirtual equals : (Ljava/lang/Object;)Z
    //   71: ifeq -> 107
    //   74: iconst_2
    //   75: istore #4
    //   77: goto -> 110
    //   80: aload_2
    //   81: ldc 'like'
    //   83: invokevirtual equals : (Ljava/lang/Object;)Z
    //   86: ifeq -> 107
    //   89: iconst_1
    //   90: istore #4
    //   92: goto -> 110
    //   95: aload_2
    //   96: ldc 'comments'
    //   98: invokevirtual equals : (Ljava/lang/Object;)Z
    //   101: ifeq -> 107
    //   104: goto -> 110
    //   107: iconst_m1
    //   108: istore #4
    //   110: iload #4
    //   112: ifeq -> 170
    //   115: iload #4
    //   117: iconst_1
    //   118: if_icmpeq -> 150
    //   121: iload #4
    //   123: iconst_2
    //   124: if_icmpeq -> 130
    //   127: goto -> 186
    //   130: ldc com/soft/blued/ui/feed/model/FeedComment
    //   132: aload #6
    //   134: invokevirtual isInstance : (Ljava/lang/Object;)Z
    //   137: ifeq -> 186
    //   140: aload_1
    //   141: aload #6
    //   143: checkcast com/soft/blued/ui/feed/model/FeedComment
    //   146: invokevirtual a : (Lcom/soft/blued/ui/feed/model/FeedComment;)V
    //   149: return
    //   150: ldc com/soft/blued/ui/feed/model/FeedComment
    //   152: aload #6
    //   154: invokevirtual isInstance : (Ljava/lang/Object;)Z
    //   157: ifeq -> 186
    //   160: aload_1
    //   161: aload #6
    //   163: checkcast com/soft/blued/ui/feed/model/FeedComment
    //   166: invokevirtual b : (Lcom/soft/blued/ui/feed/model/FeedComment;)V
    //   169: return
    //   170: ldc com/soft/blued/ui/feed/model/FeedComment
    //   172: aload #6
    //   174: invokevirtual isInstance : (Ljava/lang/Object;)Z
    //   177: ifeq -> 186
    //   180: aload_1
    //   181: aload_3
    //   182: invokevirtual a : (Ljava/util/List;)V
    //   185: return
    //   186: aload_0
    //   187: aload_1
    //   188: aload_2
    //   189: invokespecial a : (Lcom/soft/blued/ui/feed/fragment/CommentFragment;Ljava/lang/String;)V
    //   192: return
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\fragment\CommentFragment_MVP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */