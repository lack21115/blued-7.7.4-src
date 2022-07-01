package androidx.recyclerview.widget;

import java.util.List;

class OpReorderer {
  final Callback a;
  
  OpReorderer(Callback paramCallback) {
    this.a = paramCallback;
  }
  
  private void a(List<AdapterHelper.UpdateOp> paramList, int paramInt1, int paramInt2) {
    AdapterHelper.UpdateOp updateOp1 = paramList.get(paramInt1);
    AdapterHelper.UpdateOp updateOp2 = paramList.get(paramInt2);
    int i = updateOp2.a;
    if (i != 1) {
      if (i != 2) {
        if (i != 4)
          return; 
        b(paramList, paramInt1, updateOp1, paramInt2, updateOp2);
        return;
      } 
      a(paramList, paramInt1, updateOp1, paramInt2, updateOp2);
      return;
    } 
    c(paramList, paramInt1, updateOp1, paramInt2, updateOp2);
  }
  
  private int b(List<AdapterHelper.UpdateOp> paramList) {
    int i = paramList.size() - 1;
    for (boolean bool = false; i >= 0; bool = bool1) {
      boolean bool1;
      if (((AdapterHelper.UpdateOp)paramList.get(i)).a == 8) {
        bool1 = bool;
        if (bool)
          return i; 
      } else {
        bool1 = true;
      } 
      i--;
    } 
    return -1;
  }
  
  private void c(List<AdapterHelper.UpdateOp> paramList, int paramInt1, AdapterHelper.UpdateOp paramUpdateOp1, int paramInt2, AdapterHelper.UpdateOp paramUpdateOp2) {
    byte b;
    if (paramUpdateOp1.d < paramUpdateOp2.b) {
      b = -1;
    } else {
      b = 0;
    } 
    int i = b;
    if (paramUpdateOp1.b < paramUpdateOp2.b)
      i = b + 1; 
    if (paramUpdateOp2.b <= paramUpdateOp1.b)
      paramUpdateOp1.b += paramUpdateOp2.d; 
    if (paramUpdateOp2.b <= paramUpdateOp1.d)
      paramUpdateOp1.d += paramUpdateOp2.d; 
    paramUpdateOp2.b += i;
    paramList.set(paramInt1, paramUpdateOp2);
    paramList.set(paramInt2, paramUpdateOp1);
  }
  
  void a(List<AdapterHelper.UpdateOp> paramList) {
    while (true) {
      int i = b(paramList);
      if (i != -1) {
        a(paramList, i, i + 1);
        continue;
      } 
      break;
    } 
  }
  
  void a(List<AdapterHelper.UpdateOp> paramList, int paramInt1, AdapterHelper.UpdateOp paramUpdateOp1, int paramInt2, AdapterHelper.UpdateOp paramUpdateOp2) {
    // Byte code:
    //   0: aload_3
    //   1: getfield b : I
    //   4: istore #6
    //   6: aload_3
    //   7: getfield d : I
    //   10: istore #8
    //   12: iconst_0
    //   13: istore #7
    //   15: iload #6
    //   17: iload #8
    //   19: if_icmpge -> 63
    //   22: aload #5
    //   24: getfield b : I
    //   27: aload_3
    //   28: getfield b : I
    //   31: if_icmpne -> 57
    //   34: aload #5
    //   36: getfield d : I
    //   39: aload_3
    //   40: getfield d : I
    //   43: aload_3
    //   44: getfield b : I
    //   47: isub
    //   48: if_icmpne -> 57
    //   51: iconst_0
    //   52: istore #6
    //   54: goto -> 97
    //   57: iconst_0
    //   58: istore #6
    //   60: goto -> 106
    //   63: aload #5
    //   65: getfield b : I
    //   68: aload_3
    //   69: getfield d : I
    //   72: iconst_1
    //   73: iadd
    //   74: if_icmpne -> 103
    //   77: aload #5
    //   79: getfield d : I
    //   82: aload_3
    //   83: getfield b : I
    //   86: aload_3
    //   87: getfield d : I
    //   90: isub
    //   91: if_icmpne -> 103
    //   94: iconst_1
    //   95: istore #6
    //   97: iconst_1
    //   98: istore #7
    //   100: goto -> 106
    //   103: iconst_1
    //   104: istore #6
    //   106: aload_3
    //   107: getfield d : I
    //   110: aload #5
    //   112: getfield b : I
    //   115: if_icmpge -> 133
    //   118: aload #5
    //   120: aload #5
    //   122: getfield b : I
    //   125: iconst_1
    //   126: isub
    //   127: putfield b : I
    //   130: goto -> 202
    //   133: aload_3
    //   134: getfield d : I
    //   137: aload #5
    //   139: getfield b : I
    //   142: aload #5
    //   144: getfield d : I
    //   147: iadd
    //   148: if_icmpge -> 202
    //   151: aload #5
    //   153: aload #5
    //   155: getfield d : I
    //   158: iconst_1
    //   159: isub
    //   160: putfield d : I
    //   163: aload_3
    //   164: iconst_2
    //   165: putfield a : I
    //   168: aload_3
    //   169: iconst_1
    //   170: putfield d : I
    //   173: aload #5
    //   175: getfield d : I
    //   178: ifne -> 201
    //   181: aload_1
    //   182: iload #4
    //   184: invokeinterface remove : (I)Ljava/lang/Object;
    //   189: pop
    //   190: aload_0
    //   191: getfield a : Landroidx/recyclerview/widget/OpReorderer$Callback;
    //   194: aload #5
    //   196: invokeinterface recycleUpdateOp : (Landroidx/recyclerview/widget/AdapterHelper$UpdateOp;)V
    //   201: return
    //   202: aload_3
    //   203: getfield b : I
    //   206: istore #8
    //   208: aload #5
    //   210: getfield b : I
    //   213: istore #9
    //   215: aconst_null
    //   216: astore #11
    //   218: iload #8
    //   220: iload #9
    //   222: if_icmpgt -> 240
    //   225: aload #5
    //   227: aload #5
    //   229: getfield b : I
    //   232: iconst_1
    //   233: iadd
    //   234: putfield b : I
    //   237: goto -> 320
    //   240: aload_3
    //   241: getfield b : I
    //   244: aload #5
    //   246: getfield b : I
    //   249: aload #5
    //   251: getfield d : I
    //   254: iadd
    //   255: if_icmpge -> 320
    //   258: aload #5
    //   260: getfield b : I
    //   263: istore #8
    //   265: aload #5
    //   267: getfield d : I
    //   270: istore #9
    //   272: aload_3
    //   273: getfield b : I
    //   276: istore #10
    //   278: aload_0
    //   279: getfield a : Landroidx/recyclerview/widget/OpReorderer$Callback;
    //   282: iconst_2
    //   283: aload_3
    //   284: getfield b : I
    //   287: iconst_1
    //   288: iadd
    //   289: iload #8
    //   291: iload #9
    //   293: iadd
    //   294: iload #10
    //   296: isub
    //   297: aconst_null
    //   298: invokeinterface obtainUpdateOp : (IIILjava/lang/Object;)Landroidx/recyclerview/widget/AdapterHelper$UpdateOp;
    //   303: astore #11
    //   305: aload #5
    //   307: aload_3
    //   308: getfield b : I
    //   311: aload #5
    //   313: getfield b : I
    //   316: isub
    //   317: putfield d : I
    //   320: iload #7
    //   322: ifeq -> 355
    //   325: aload_1
    //   326: iload_2
    //   327: aload #5
    //   329: invokeinterface set : (ILjava/lang/Object;)Ljava/lang/Object;
    //   334: pop
    //   335: aload_1
    //   336: iload #4
    //   338: invokeinterface remove : (I)Ljava/lang/Object;
    //   343: pop
    //   344: aload_0
    //   345: getfield a : Landroidx/recyclerview/widget/OpReorderer$Callback;
    //   348: aload_3
    //   349: invokeinterface recycleUpdateOp : (Landroidx/recyclerview/widget/AdapterHelper$UpdateOp;)V
    //   354: return
    //   355: iload #6
    //   357: ifeq -> 472
    //   360: aload #11
    //   362: ifnull -> 417
    //   365: aload_3
    //   366: getfield b : I
    //   369: aload #11
    //   371: getfield b : I
    //   374: if_icmple -> 391
    //   377: aload_3
    //   378: aload_3
    //   379: getfield b : I
    //   382: aload #11
    //   384: getfield d : I
    //   387: isub
    //   388: putfield b : I
    //   391: aload_3
    //   392: getfield d : I
    //   395: aload #11
    //   397: getfield b : I
    //   400: if_icmple -> 417
    //   403: aload_3
    //   404: aload_3
    //   405: getfield d : I
    //   408: aload #11
    //   410: getfield d : I
    //   413: isub
    //   414: putfield d : I
    //   417: aload_3
    //   418: getfield b : I
    //   421: aload #5
    //   423: getfield b : I
    //   426: if_icmple -> 443
    //   429: aload_3
    //   430: aload_3
    //   431: getfield b : I
    //   434: aload #5
    //   436: getfield d : I
    //   439: isub
    //   440: putfield b : I
    //   443: aload_3
    //   444: getfield d : I
    //   447: aload #5
    //   449: getfield b : I
    //   452: if_icmple -> 581
    //   455: aload_3
    //   456: aload_3
    //   457: getfield d : I
    //   460: aload #5
    //   462: getfield d : I
    //   465: isub
    //   466: putfield d : I
    //   469: goto -> 581
    //   472: aload #11
    //   474: ifnull -> 529
    //   477: aload_3
    //   478: getfield b : I
    //   481: aload #11
    //   483: getfield b : I
    //   486: if_icmplt -> 503
    //   489: aload_3
    //   490: aload_3
    //   491: getfield b : I
    //   494: aload #11
    //   496: getfield d : I
    //   499: isub
    //   500: putfield b : I
    //   503: aload_3
    //   504: getfield d : I
    //   507: aload #11
    //   509: getfield b : I
    //   512: if_icmplt -> 529
    //   515: aload_3
    //   516: aload_3
    //   517: getfield d : I
    //   520: aload #11
    //   522: getfield d : I
    //   525: isub
    //   526: putfield d : I
    //   529: aload_3
    //   530: getfield b : I
    //   533: aload #5
    //   535: getfield b : I
    //   538: if_icmplt -> 555
    //   541: aload_3
    //   542: aload_3
    //   543: getfield b : I
    //   546: aload #5
    //   548: getfield d : I
    //   551: isub
    //   552: putfield b : I
    //   555: aload_3
    //   556: getfield d : I
    //   559: aload #5
    //   561: getfield b : I
    //   564: if_icmplt -> 581
    //   567: aload_3
    //   568: aload_3
    //   569: getfield d : I
    //   572: aload #5
    //   574: getfield d : I
    //   577: isub
    //   578: putfield d : I
    //   581: aload_1
    //   582: iload_2
    //   583: aload #5
    //   585: invokeinterface set : (ILjava/lang/Object;)Ljava/lang/Object;
    //   590: pop
    //   591: aload_3
    //   592: getfield b : I
    //   595: aload_3
    //   596: getfield d : I
    //   599: if_icmpeq -> 615
    //   602: aload_1
    //   603: iload #4
    //   605: aload_3
    //   606: invokeinterface set : (ILjava/lang/Object;)Ljava/lang/Object;
    //   611: pop
    //   612: goto -> 624
    //   615: aload_1
    //   616: iload #4
    //   618: invokeinterface remove : (I)Ljava/lang/Object;
    //   623: pop
    //   624: aload #11
    //   626: ifnull -> 638
    //   629: aload_1
    //   630: iload_2
    //   631: aload #11
    //   633: invokeinterface add : (ILjava/lang/Object;)V
    //   638: return
  }
  
  void b(List<AdapterHelper.UpdateOp> paramList, int paramInt1, AdapterHelper.UpdateOp paramUpdateOp1, int paramInt2, AdapterHelper.UpdateOp paramUpdateOp2) {
    // Byte code:
    //   0: aload_3
    //   1: getfield d : I
    //   4: istore #6
    //   6: aload #5
    //   8: getfield b : I
    //   11: istore #7
    //   13: aconst_null
    //   14: astore #9
    //   16: iload #6
    //   18: iload #7
    //   20: if_icmpge -> 38
    //   23: aload #5
    //   25: aload #5
    //   27: getfield b : I
    //   30: iconst_1
    //   31: isub
    //   32: putfield b : I
    //   35: goto -> 93
    //   38: aload_3
    //   39: getfield d : I
    //   42: aload #5
    //   44: getfield b : I
    //   47: aload #5
    //   49: getfield d : I
    //   52: iadd
    //   53: if_icmpge -> 93
    //   56: aload #5
    //   58: aload #5
    //   60: getfield d : I
    //   63: iconst_1
    //   64: isub
    //   65: putfield d : I
    //   68: aload_0
    //   69: getfield a : Landroidx/recyclerview/widget/OpReorderer$Callback;
    //   72: iconst_4
    //   73: aload_3
    //   74: getfield b : I
    //   77: iconst_1
    //   78: aload #5
    //   80: getfield c : Ljava/lang/Object;
    //   83: invokeinterface obtainUpdateOp : (IIILjava/lang/Object;)Landroidx/recyclerview/widget/AdapterHelper$UpdateOp;
    //   88: astore #8
    //   90: goto -> 96
    //   93: aconst_null
    //   94: astore #8
    //   96: aload_3
    //   97: getfield b : I
    //   100: aload #5
    //   102: getfield b : I
    //   105: if_icmpgt -> 123
    //   108: aload #5
    //   110: aload #5
    //   112: getfield b : I
    //   115: iconst_1
    //   116: iadd
    //   117: putfield b : I
    //   120: goto -> 197
    //   123: aload_3
    //   124: getfield b : I
    //   127: aload #5
    //   129: getfield b : I
    //   132: aload #5
    //   134: getfield d : I
    //   137: iadd
    //   138: if_icmpge -> 197
    //   141: aload #5
    //   143: getfield b : I
    //   146: aload #5
    //   148: getfield d : I
    //   151: iadd
    //   152: aload_3
    //   153: getfield b : I
    //   156: isub
    //   157: istore #6
    //   159: aload_0
    //   160: getfield a : Landroidx/recyclerview/widget/OpReorderer$Callback;
    //   163: iconst_4
    //   164: aload_3
    //   165: getfield b : I
    //   168: iconst_1
    //   169: iadd
    //   170: iload #6
    //   172: aload #5
    //   174: getfield c : Ljava/lang/Object;
    //   177: invokeinterface obtainUpdateOp : (IIILjava/lang/Object;)Landroidx/recyclerview/widget/AdapterHelper$UpdateOp;
    //   182: astore #9
    //   184: aload #5
    //   186: aload #5
    //   188: getfield d : I
    //   191: iload #6
    //   193: isub
    //   194: putfield d : I
    //   197: aload_1
    //   198: iload #4
    //   200: aload_3
    //   201: invokeinterface set : (ILjava/lang/Object;)Ljava/lang/Object;
    //   206: pop
    //   207: aload #5
    //   209: getfield d : I
    //   212: ifle -> 228
    //   215: aload_1
    //   216: iload_2
    //   217: aload #5
    //   219: invokeinterface set : (ILjava/lang/Object;)Ljava/lang/Object;
    //   224: pop
    //   225: goto -> 247
    //   228: aload_1
    //   229: iload_2
    //   230: invokeinterface remove : (I)Ljava/lang/Object;
    //   235: pop
    //   236: aload_0
    //   237: getfield a : Landroidx/recyclerview/widget/OpReorderer$Callback;
    //   240: aload #5
    //   242: invokeinterface recycleUpdateOp : (Landroidx/recyclerview/widget/AdapterHelper$UpdateOp;)V
    //   247: aload #8
    //   249: ifnull -> 261
    //   252: aload_1
    //   253: iload_2
    //   254: aload #8
    //   256: invokeinterface add : (ILjava/lang/Object;)V
    //   261: aload #9
    //   263: ifnull -> 275
    //   266: aload_1
    //   267: iload_2
    //   268: aload #9
    //   270: invokeinterface add : (ILjava/lang/Object;)V
    //   275: return
  }
  
  static interface Callback {
    AdapterHelper.UpdateOp obtainUpdateOp(int param1Int1, int param1Int2, int param1Int3, Object param1Object);
    
    void recycleUpdateOp(AdapterHelper.UpdateOp param1UpdateOp);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\recyclerview\widget\OpReorderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */