package com.blued.android.views;

import android.content.Context;
import android.view.View;
import com.soft.blued.customview.MoreOptionFromBtm;
import com.soft.blued.ui.share_custom.Model.ShareOption;
import java.util.ArrayList;
import java.util.List;

public class WebBtmOptions extends MoreOptionFromBtm {
  public WebBtmOptions(Context paramContext, View.OnClickListener paramOnClickListener) {
    super(paramContext, true, true, paramOnClickListener);
  }
  
  public List<ShareOption> a() {
    ArrayList<ShareOption> arrayList = new ArrayList();
    arrayList.add(new ShareOption(2131232652, 2131756132));
    arrayList.add(new ShareOption(2131232656, 2131758326));
    arrayList.add(new ShareOption(2131232658, 2131758547));
    return arrayList;
  }
  
  public void a(List<ShareOption> paramList1, List<ShareOption> paramList2) {
    // Byte code:
    //   0: aload_0
    //   1: getfield f : Lcom/soft/blued/ui/share_custom/Model/ShareEntity;
    //   4: getfield r : Ljava/lang/String;
    //   7: ldc 'open'
    //   9: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   12: ifeq -> 78
    //   15: aload_1
    //   16: invokeinterface iterator : ()Ljava/util/Iterator;
    //   21: astore_2
    //   22: aload_2
    //   23: invokeinterface hasNext : ()Z
    //   28: ifeq -> 53
    //   31: aload_2
    //   32: invokeinterface next : ()Ljava/lang/Object;
    //   37: checkcast com/soft/blued/ui/share_custom/Model/ShareOption
    //   40: getfield iconResourceId : I
    //   43: ldc 2131232715
    //   45: if_icmpne -> 22
    //   48: iconst_1
    //   49: istore_3
    //   50: goto -> 55
    //   53: iconst_0
    //   54: istore_3
    //   55: iload_3
    //   56: ifne -> 135
    //   59: aload_1
    //   60: iconst_0
    //   61: new com/soft/blued/ui/share_custom/Model/ShareOption
    //   64: dup
    //   65: ldc 2131232715
    //   67: ldc 2131758763
    //   69: invokespecial <init> : (II)V
    //   72: invokeinterface add : (ILjava/lang/Object;)V
    //   77: return
    //   78: aload_0
    //   79: getfield f : Lcom/soft/blued/ui/share_custom/Model/ShareEntity;
    //   82: getfield r : Ljava/lang/String;
    //   85: ldc 'close'
    //   87: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   90: ifeq -> 135
    //   93: aload_1
    //   94: invokeinterface iterator : ()Ljava/util/Iterator;
    //   99: astore_1
    //   100: aload_1
    //   101: invokeinterface hasNext : ()Z
    //   106: ifeq -> 135
    //   109: aload_1
    //   110: invokeinterface next : ()Ljava/lang/Object;
    //   115: checkcast com/soft/blued/ui/share_custom/Model/ShareOption
    //   118: getfield iconResourceId : I
    //   121: ldc 2131232715
    //   123: if_icmpne -> 100
    //   126: aload_1
    //   127: invokeinterface remove : ()V
    //   132: goto -> 100
    //   135: return
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\views\WebBtmOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */