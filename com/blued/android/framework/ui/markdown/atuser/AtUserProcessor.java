package com.blued.android.framework.ui.markdown.atuser;

import java.util.regex.Pattern;
import org.commonmark.node.Text;
import org.commonmark.parser.delimiter.DelimiterProcessor;
import org.commonmark.parser.delimiter.DelimiterRun;

public class AtUserProcessor implements DelimiterProcessor {
  public static final Pattern a = Pattern.compile("@\\(name:([^\\n\\r`~\\!@#\\$%\\^&\\*\\(\\)\\+=\\|'\\:;'\\,\\[\\]\\.\\<\\>/\\?！@#￥%……（）——\\{\\}【】‘；：”“’。，、？]+),id:([A-Za-z0-9]+)\\)");
  
  public char a() {
    return '@';
  }
  
  public int a(DelimiterRun paramDelimiterRun1, DelimiterRun paramDelimiterRun2) {
    return (paramDelimiterRun1.c() >= 1 && paramDelimiterRun2.c() >= 1) ? 1 : 0;
  }
  
  public void a(Text paramText1, Text paramText2, int paramInt) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual h : ()Lorg/commonmark/node/Node;
    //   4: astore #6
    //   6: aload #6
    //   8: instanceof org/commonmark/node/Text
    //   11: ifeq -> 169
    //   14: aload #6
    //   16: invokevirtual h : ()Lorg/commonmark/node/Node;
    //   19: aload_2
    //   20: if_acmpne -> 169
    //   23: aload #6
    //   25: checkcast org/commonmark/node/Text
    //   28: invokevirtual a : ()Ljava/lang/String;
    //   31: astore #4
    //   33: aload #4
    //   35: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   38: ifne -> 169
    //   41: new java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial <init> : ()V
    //   48: astore #5
    //   50: aload #5
    //   52: bipush #64
    //   54: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload #5
    //   60: aload #4
    //   62: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload #5
    //   68: bipush #41
    //   70: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload #5
    //   76: invokevirtual toString : ()Ljava/lang/String;
    //   79: astore #4
    //   81: getstatic com/blued/android/framework/ui/markdown/atuser/AtUserProcessor.a : Ljava/util/regex/Pattern;
    //   84: aload #4
    //   86: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   89: astore #4
    //   91: aload #4
    //   93: invokevirtual matches : ()Z
    //   96: ifeq -> 169
    //   99: aload #4
    //   101: iconst_1
    //   102: invokevirtual group : (I)Ljava/lang/String;
    //   105: astore #7
    //   107: aload #4
    //   109: iconst_2
    //   110: invokevirtual group : (I)Ljava/lang/String;
    //   113: astore #5
    //   115: aload #5
    //   117: astore #4
    //   119: aload #5
    //   121: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   124: ifne -> 134
    //   127: aload #5
    //   129: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   132: astore #4
    //   134: aload #4
    //   136: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   139: ifne -> 169
    //   142: new com/blued/android/framework/ui/markdown/atuser/AtUserNode
    //   145: dup
    //   146: aload #7
    //   148: aload #4
    //   150: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   153: astore #4
    //   155: aload_1
    //   156: aload #4
    //   158: invokevirtual d : (Lorg/commonmark/node/Node;)V
    //   161: aload #6
    //   163: invokevirtual l : ()V
    //   166: goto -> 172
    //   169: aconst_null
    //   170: astore #4
    //   172: aload #4
    //   174: ifnonnull -> 203
    //   177: aload_1
    //   178: new org/commonmark/node/Text
    //   181: dup
    //   182: ldc '@'
    //   184: invokespecial <init> : (Ljava/lang/String;)V
    //   187: invokevirtual d : (Lorg/commonmark/node/Node;)V
    //   190: aload_2
    //   191: new org/commonmark/node/Text
    //   194: dup
    //   195: ldc ')'
    //   197: invokespecial <init> : (Ljava/lang/String;)V
    //   200: invokevirtual d : (Lorg/commonmark/node/Node;)V
    //   203: return
  }
  
  public char b() {
    return ')';
  }
  
  public int c() {
    return 1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framewor\\ui\markdown\atuser\AtUserProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */