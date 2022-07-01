package com.soft.blued.ui.msg_group.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import java.util.List;

public final class GroupInfoFragment_MVP implements MvpDispatcher {
  private void a(GroupInfoFragment paramGroupInfoFragment, String paramString) {
    byte b;
    if (paramString.hashCode() == 570759793 && paramString.equals("apply_succeed")) {
      b = 0;
    } else {
      b = -1;
    } 
    if (b != 0)
      return; 
    paramGroupInfoFragment.E();
  }
  
  public void a(MvpFragment paramMvpFragment, String paramString, List paramList) {
    // Byte code:
    //   0: aload_1
    //   1: checkcast com/soft/blued/ui/msg_group/fragment/GroupInfoFragment
    //   4: astore_1
    //   5: aload_3
    //   6: ifnull -> 182
    //   9: aload_3
    //   10: invokeinterface size : ()I
    //   15: ifle -> 182
    //   18: iconst_0
    //   19: istore #4
    //   21: aload_3
    //   22: iconst_0
    //   23: invokeinterface get : (I)Ljava/lang/Object;
    //   28: astore_3
    //   29: aload_3
    //   30: ifnull -> 182
    //   33: aload_2
    //   34: invokevirtual hashCode : ()I
    //   37: istore #5
    //   39: iload #5
    //   41: ldc -889473228
    //   43: if_icmpeq -> 90
    //   46: iload #5
    //   48: ldc -346952246
    //   50: if_icmpeq -> 75
    //   53: iload #5
    //   55: ldc 1282170478
    //   57: if_icmpeq -> 63
    //   60: goto -> 105
    //   63: aload_2
    //   64: ldc 'group_info'
    //   66: invokevirtual equals : (Ljava/lang/Object;)Z
    //   69: ifeq -> 105
    //   72: goto -> 108
    //   75: aload_2
    //   76: ldc 'switch_top'
    //   78: invokevirtual equals : (Ljava/lang/Object;)Z
    //   81: ifeq -> 105
    //   84: iconst_1
    //   85: istore #4
    //   87: goto -> 108
    //   90: aload_2
    //   91: ldc 'switch'
    //   93: invokevirtual equals : (Ljava/lang/Object;)Z
    //   96: ifeq -> 105
    //   99: iconst_2
    //   100: istore #4
    //   102: goto -> 108
    //   105: iconst_m1
    //   106: istore #4
    //   108: iload #4
    //   110: ifeq -> 164
    //   113: iload #4
    //   115: iconst_1
    //   116: if_icmpeq -> 146
    //   119: iload #4
    //   121: iconst_2
    //   122: if_icmpeq -> 128
    //   125: goto -> 182
    //   128: ldc com/soft/blued/ui/msg_group/model/GroupInfoModel
    //   130: aload_3
    //   131: invokevirtual isInstance : (Ljava/lang/Object;)Z
    //   134: ifeq -> 182
    //   137: aload_1
    //   138: aload_3
    //   139: checkcast com/soft/blued/ui/msg_group/model/GroupInfoModel
    //   142: invokevirtual b : (Lcom/soft/blued/ui/msg_group/model/GroupInfoModel;)V
    //   145: return
    //   146: ldc java/lang/Integer
    //   148: aload_3
    //   149: invokevirtual isInstance : (Ljava/lang/Object;)Z
    //   152: ifeq -> 182
    //   155: aload_1
    //   156: aload_3
    //   157: checkcast java/lang/Integer
    //   160: invokevirtual a : (Ljava/lang/Integer;)V
    //   163: return
    //   164: ldc com/soft/blued/ui/msg_group/model/GroupInfoModel
    //   166: aload_3
    //   167: invokevirtual isInstance : (Ljava/lang/Object;)Z
    //   170: ifeq -> 182
    //   173: aload_1
    //   174: aload_3
    //   175: checkcast com/soft/blued/ui/msg_group/model/GroupInfoModel
    //   178: invokevirtual a : (Lcom/soft/blued/ui/msg_group/model/GroupInfoModel;)V
    //   181: return
    //   182: aload_0
    //   183: aload_1
    //   184: aload_2
    //   185: invokespecial a : (Lcom/soft/blued/ui/msg_group/fragment/GroupInfoFragment;Ljava/lang/String;)V
    //   188: return
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg_group\fragment\GroupInfoFragment_MVP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */