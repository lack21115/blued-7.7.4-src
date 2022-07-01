package com.google.thirdparty.publicsuffix;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import java.util.List;

final class TrieParser {
  private static final Joiner a = Joiner.a("");
  
  private static int a(List<CharSequence> paramList, CharSequence paramCharSequence, int paramInt, ImmutableMap.Builder<String, PublicSuffixType> paramBuilder) {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface length : ()I
    //   6: istore #8
    //   8: iload_2
    //   9: istore #6
    //   11: iconst_0
    //   12: istore #4
    //   14: iload #4
    //   16: istore #5
    //   18: iload #6
    //   20: iload #8
    //   22: if_icmpge -> 102
    //   25: aload_1
    //   26: iload #6
    //   28: invokeinterface charAt : (I)C
    //   33: istore #4
    //   35: iload #4
    //   37: istore #5
    //   39: iload #4
    //   41: bipush #38
    //   43: if_icmpeq -> 102
    //   46: iload #4
    //   48: istore #5
    //   50: iload #4
    //   52: bipush #63
    //   54: if_icmpeq -> 102
    //   57: iload #4
    //   59: istore #5
    //   61: iload #4
    //   63: bipush #33
    //   65: if_icmpeq -> 102
    //   68: iload #4
    //   70: istore #5
    //   72: iload #4
    //   74: bipush #58
    //   76: if_icmpeq -> 102
    //   79: iload #4
    //   81: bipush #44
    //   83: if_icmpne -> 93
    //   86: iload #4
    //   88: istore #5
    //   90: goto -> 102
    //   93: iload #6
    //   95: iconst_1
    //   96: iadd
    //   97: istore #6
    //   99: goto -> 14
    //   102: aload_0
    //   103: iconst_0
    //   104: aload_1
    //   105: iload_2
    //   106: iload #6
    //   108: invokeinterface subSequence : (II)Ljava/lang/CharSequence;
    //   113: invokestatic b : (Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    //   116: invokeinterface add : (ILjava/lang/Object;)V
    //   121: iload #5
    //   123: bipush #33
    //   125: if_icmpeq -> 149
    //   128: iload #5
    //   130: bipush #63
    //   132: if_icmpeq -> 149
    //   135: iload #5
    //   137: bipush #58
    //   139: if_icmpeq -> 149
    //   142: iload #5
    //   144: bipush #44
    //   146: if_icmpne -> 178
    //   149: getstatic com/google/thirdparty/publicsuffix/TrieParser.a : Lcom/google/common/base/Joiner;
    //   152: aload_0
    //   153: invokevirtual a : (Ljava/lang/Iterable;)Ljava/lang/String;
    //   156: astore #9
    //   158: aload #9
    //   160: invokevirtual length : ()I
    //   163: ifle -> 178
    //   166: aload_3
    //   167: aload #9
    //   169: iload #5
    //   171: invokestatic a : (C)Lcom/google/thirdparty/publicsuffix/PublicSuffixType;
    //   174: invokevirtual b : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;
    //   177: pop
    //   178: iload #6
    //   180: iconst_1
    //   181: iadd
    //   182: istore #6
    //   184: iload #6
    //   186: istore #7
    //   188: iload #5
    //   190: bipush #63
    //   192: if_icmpeq -> 266
    //   195: iload #6
    //   197: istore #7
    //   199: iload #5
    //   201: bipush #44
    //   203: if_icmpeq -> 266
    //   206: iload #6
    //   208: istore #7
    //   210: iload #6
    //   212: iload #8
    //   214: if_icmpge -> 266
    //   217: iload #6
    //   219: aload_0
    //   220: aload_1
    //   221: iload #6
    //   223: aload_3
    //   224: invokestatic a : (Ljava/util/List;Ljava/lang/CharSequence;ILcom/google/common/collect/ImmutableMap$Builder;)I
    //   227: iadd
    //   228: istore #7
    //   230: aload_1
    //   231: iload #7
    //   233: invokeinterface charAt : (I)C
    //   238: bipush #63
    //   240: if_icmpeq -> 260
    //   243: iload #7
    //   245: istore #6
    //   247: aload_1
    //   248: iload #7
    //   250: invokeinterface charAt : (I)C
    //   255: bipush #44
    //   257: if_icmpne -> 206
    //   260: iload #7
    //   262: iconst_1
    //   263: iadd
    //   264: istore #7
    //   266: aload_0
    //   267: iconst_0
    //   268: invokeinterface remove : (I)Ljava/lang/Object;
    //   273: pop
    //   274: iload #7
    //   276: iload_2
    //   277: isub
    //   278: ireturn
  }
  
  static ImmutableMap<String, PublicSuffixType> a(CharSequence paramCharSequence) {
    ImmutableMap.Builder<String, PublicSuffixType> builder = ImmutableMap.k();
    int j = paramCharSequence.length();
    for (int i = 0; i < j; i += a(Lists.b(), paramCharSequence, i, builder));
    return builder.b();
  }
  
  private static CharSequence b(CharSequence paramCharSequence) {
    return (new StringBuilder(paramCharSequence)).reverse();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\thirdparty\publicsuffix\TrieParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */