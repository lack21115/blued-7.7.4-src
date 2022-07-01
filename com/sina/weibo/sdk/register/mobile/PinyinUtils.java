package com.sina.weibo.sdk.register.mobile;

import android.content.Context;
import android.text.TextUtils;

public class PinyinUtils {
  private static final int DISTINGUISH_LEN = 10;
  
  private static final char FIRST_CHINA = '一';
  
  private static final char LAST_CHINA = '龥';
  
  private static final String[] PINYIN = new String[] { 
      "a", "ai", "an", "ang", "ao", "ba", "bai", "ban", "bang", "bao", 
      "bei", "ben", "beng", "bi", "bian", "biao", "bie", "bin", "bing", "bo", 
      "bu", "ca", "cai", "can", "cang", "cao", "ce", "cen", "ceng", "cha", 
      "chai", "chan", "chang", "chao", "che", "chen", "cheng", "chi", "chong", "chou", 
      "chu", "chuai", "chuan", "chuang", "chui", "chun", "chuo", "ci", "cong", "cou", 
      "cu", "cuan", "cui", "cun", "cuo", "da", "dai", "dan", "dang", "dao", 
      "de", "deng", "di", "dia", "dian", "diao", "die", "ding", "diu", "dong", 
      "dou", "du", "duan", "dui", "dun", "duo", "e", "ei", "en", "er", 
      "fa", "fan", "fang", "fei", "fen", "feng", "fo", "fou", "fu", "ga", 
      "gai", "gan", "gang", "gao", "ge", "gei", "gen", "geng", "gong", "gou", 
      "gu", "gua", "guai", "guan", "guang", "gui", "gun", "guo", "ha", "hai", 
      "han", "hang", "hao", "he", "hei", "hen", "heng", "hong", "hou", "hu", 
      "hua", "huai", "huan", "huang", "hui", "hun", "huo", "ji", "jia", "jian", 
      "jiang", "jiao", "jie", "jin", "jing", "jiong", "jiu", "ju", "juan", "jue", 
      "jun", "ka", "kai", "kan", "kang", "kao", "ke", "ken", "keng", "kong", 
      "kou", "ku", "kua", "kuai", "kuan", "kuang", "kui", "kun", "kuo", "la", 
      "lai", "lan", "lang", "lao", "le", "lei", "leng", "li", "lia", "lian", 
      "liang", "liao", "lie", "lin", "ling", "liu", "long", "lou", "lu", "luan", 
      "lun", "luo", "lv", "lve", "m", "ma", "mai", "man", "mang", "mao", 
      "me", "mei", "men", "meng", "mi", "mian", "miao", "mie", "min", "ming", 
      "miu", "mo", "mou", "mu", "na", "nai", "nan", "nang", "nao", "ne", 
      "nei", "nen", "neng", "ng", "ni", "nian", "niang", "niao", "nie", "nin", 
      "ning", "niu", "none", "nong", "nou", "nu", "nuan", "nuo", "nv", "nve", 
      "o", "ou", "pa", "pai", "pan", "pang", "pao", "pei", "pen", "peng", 
      "pi", "pian", "piao", "pie", "pin", "ping", "po", "pou", "pu", "qi", 
      "qia", "qian", "qiang", "qiao", "qie", "qin", "qing", "qiong", "qiu", "qu", 
      "quan", "que", "qun", "ran", "rang", "rao", "re", "ren", "reng", "ri", 
      "rong", "rou", "ru", "ruan", "rui", "run", "ruo", "sa", "sai", "san", 
      "sang", "sao", "se", "sen", "seng", "sha", "shai", "shan", "shang", "shao", 
      "she", "shei", "shen", "sheng", "shi", "shou", "shu", "shua", "shuai", "shuan", 
      "shuang", "shui", "shun", "shuo", "si", "song", "sou", "su", "suan", "sui", 
      "sun", "suo", "ta", "tai", "tan", "tang", "tao", "te", "teng", "ti", 
      "tian", "tiao", "tie", "ting", "tong", "tou", "tu", "tuan", "tui", "tun", 
      "tuo", "wa", "wai", "wan", "wang", "wei", "wen", "weng", "wo", "wu", 
      "xi", "xia", "xian", "xiang", "xiao", "xie", "xin", "xing", "xiong", "xiu", 
      "xu", "xuan", "xue", "xun", "ya", "yan", "yang", "yao", "ye", "yi", 
      "yiao", "yin", "ying", "yo", "yong", "you", "yu", "yuan", "yue", "yun", 
      "za", "zai", "zan", "zang", "zao", "ze", "zei", "zen", "zeng", "zha", 
      "zhai", "zhan", "zhang", "zhao", "zhe", "zhei", "zhen", "zheng", "zhi", "zhong", 
      "zhou", "zhu", "zhua", "zhuai", "zhuan", "zhuang", "zhui", "zhun", "zhuo", "zi", 
      "zong", "zou", "zu", "zuan", "zui", "zun", "zuo" };
  
  private static final char SPECIAL_HANZI = '〇';
  
  private static final String SPECIAL_HANZI_PINYIN = "LING";
  
  private static volatile boolean isLoad = false;
  
  private static PinyinUtils sInstance;
  
  private static short[] sPinyinIndex;
  
  private boolean distinguish(char[] paramArrayOfchar1, char[] paramArrayOfchar2, String[] paramArrayOfString, int paramInt) {
    String str = new String(paramArrayOfchar1);
    int i = 0;
    int j = 0;
    while (true) {
      if (i >= paramInt)
        return true; 
      int k = str.indexOf(paramArrayOfString[i].charAt(0), j);
      j = k;
      if (k == -1)
        j = str.indexOf(paramArrayOfchar2[i], k); 
      if (j == -1)
        return false; 
      j++;
      i++;
    } 
  }
  
  public static PinyinUtils getInstance(Context paramContext) {
    // Byte code:
    //   0: ldc com/sina/weibo/sdk/register/mobile/PinyinUtils
    //   2: monitorenter
    //   3: getstatic com/sina/weibo/sdk/register/mobile/PinyinUtils.sInstance : Lcom/sina/weibo/sdk/register/mobile/PinyinUtils;
    //   6: ifnonnull -> 19
    //   9: new com/sina/weibo/sdk/register/mobile/PinyinUtils
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/sina/weibo/sdk/register/mobile/PinyinUtils.sInstance : Lcom/sina/weibo/sdk/register/mobile/PinyinUtils;
    //   19: aload_0
    //   20: invokestatic loadData : (Landroid/content/Context;)V
    //   23: getstatic com/sina/weibo/sdk/register/mobile/PinyinUtils.sInstance : Lcom/sina/weibo/sdk/register/mobile/PinyinUtils;
    //   26: astore_0
    //   27: ldc com/sina/weibo/sdk/register/mobile/PinyinUtils
    //   29: monitorexit
    //   30: aload_0
    //   31: areturn
    //   32: astore_0
    //   33: ldc com/sina/weibo/sdk/register/mobile/PinyinUtils
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	32	finally
    //   19	27	32	finally
  }
  
  public static PinyinUtils getObject() {
    return sInstance;
  }
  
  private String getPinyin(char paramChar) {
    if (!isLoad)
      return ""; 
    if (paramChar == '〇')
      return "LING"; 
    if (paramChar < '一' || paramChar > '龥')
      return String.valueOf(paramChar); 
    String str2 = PINYIN[sPinyinIndex[paramChar - 19968]];
    String str1 = str2;
    if (str2 == null)
      str1 = ""; 
    return str1;
  }
  
  private static void loadData(Context paramContext) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #6
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore #5
    //   8: getstatic com/sina/weibo/sdk/register/mobile/PinyinUtils.isLoad : Z
    //   11: ifeq -> 15
    //   14: return
    //   15: aload_0
    //   16: invokevirtual getAssets : ()Landroid/content/res/AssetManager;
    //   19: ldc_w 'pinyinindex'
    //   22: invokevirtual open : (Ljava/lang/String;)Ljava/io/InputStream;
    //   25: astore_0
    //   26: aload_0
    //   27: astore_2
    //   28: new java/io/DataInputStream
    //   31: dup
    //   32: aload_0
    //   33: invokespecial <init> : (Ljava/io/InputStream;)V
    //   36: astore #4
    //   38: aload #4
    //   40: invokevirtual available : ()I
    //   43: iconst_1
    //   44: ishr
    //   45: i2l
    //   46: l2i
    //   47: newarray short
    //   49: putstatic com/sina/weibo/sdk/register/mobile/PinyinUtils.sPinyinIndex : [S
    //   52: iconst_0
    //   53: istore_1
    //   54: iload_1
    //   55: getstatic com/sina/weibo/sdk/register/mobile/PinyinUtils.sPinyinIndex : [S
    //   58: arraylength
    //   59: if_icmplt -> 80
    //   62: iconst_1
    //   63: putstatic com/sina/weibo/sdk/register/mobile/PinyinUtils.isLoad : Z
    //   66: aload #4
    //   68: invokevirtual close : ()V
    //   71: aload_0
    //   72: ifnull -> 181
    //   75: aload_0
    //   76: invokevirtual close : ()V
    //   79: return
    //   80: getstatic com/sina/weibo/sdk/register/mobile/PinyinUtils.sPinyinIndex : [S
    //   83: iload_1
    //   84: aload #4
    //   86: invokevirtual readShort : ()S
    //   89: sastore
    //   90: iload_1
    //   91: iconst_1
    //   92: iadd
    //   93: istore_1
    //   94: goto -> 54
    //   97: astore_2
    //   98: goto -> 192
    //   101: goto -> 123
    //   104: goto -> 155
    //   107: astore_2
    //   108: aconst_null
    //   109: astore #4
    //   111: aload #4
    //   113: astore_0
    //   114: goto -> 192
    //   117: aconst_null
    //   118: astore_0
    //   119: aload #5
    //   121: astore #4
    //   123: aload #4
    //   125: astore_3
    //   126: aload_0
    //   127: astore_2
    //   128: iconst_0
    //   129: putstatic com/sina/weibo/sdk/register/mobile/PinyinUtils.isLoad : Z
    //   132: aload #4
    //   134: ifnull -> 142
    //   137: aload #4
    //   139: invokevirtual close : ()V
    //   142: aload_0
    //   143: ifnull -> 181
    //   146: goto -> 75
    //   149: aconst_null
    //   150: astore_0
    //   151: aload #6
    //   153: astore #4
    //   155: aload #4
    //   157: astore_3
    //   158: aload_0
    //   159: astore_2
    //   160: iconst_0
    //   161: putstatic com/sina/weibo/sdk/register/mobile/PinyinUtils.isLoad : Z
    //   164: aload #4
    //   166: ifnull -> 174
    //   169: aload #4
    //   171: invokevirtual close : ()V
    //   174: aload_0
    //   175: ifnull -> 181
    //   178: goto -> 75
    //   181: return
    //   182: astore #5
    //   184: aload_2
    //   185: astore_0
    //   186: aload_3
    //   187: astore #4
    //   189: aload #5
    //   191: astore_2
    //   192: aload #4
    //   194: ifnull -> 202
    //   197: aload #4
    //   199: invokevirtual close : ()V
    //   202: aload_0
    //   203: ifnull -> 210
    //   206: aload_0
    //   207: invokevirtual close : ()V
    //   210: aload_2
    //   211: athrow
    //   212: astore_0
    //   213: goto -> 149
    //   216: astore_0
    //   217: goto -> 117
    //   220: astore_2
    //   221: aload #6
    //   223: astore #4
    //   225: goto -> 155
    //   228: astore_2
    //   229: aload #5
    //   231: astore #4
    //   233: goto -> 123
    //   236: astore_2
    //   237: goto -> 104
    //   240: astore_2
    //   241: goto -> 101
    //   244: astore_0
    //   245: return
    //   246: astore_0
    //   247: goto -> 210
    // Exception table:
    //   from	to	target	type
    //   8	14	212	java/io/IOException
    //   8	14	216	java/lang/Exception
    //   8	14	107	finally
    //   15	26	212	java/io/IOException
    //   15	26	216	java/lang/Exception
    //   15	26	107	finally
    //   28	38	220	java/io/IOException
    //   28	38	228	java/lang/Exception
    //   28	38	182	finally
    //   38	52	236	java/io/IOException
    //   38	52	240	java/lang/Exception
    //   38	52	97	finally
    //   54	66	236	java/io/IOException
    //   54	66	240	java/lang/Exception
    //   54	66	97	finally
    //   66	71	244	java/io/IOException
    //   75	79	244	java/io/IOException
    //   80	90	236	java/io/IOException
    //   80	90	240	java/lang/Exception
    //   80	90	97	finally
    //   128	132	182	finally
    //   137	142	244	java/io/IOException
    //   160	164	182	finally
    //   169	174	244	java/io/IOException
    //   197	202	246	java/io/IOException
    //   206	210	246	java/io/IOException
  }
  
  private char[] subCharRangeArray(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
    char[] arrayOfChar = new char[paramInt2 - paramInt1 + 1];
    boolean bool = false;
    int i = paramInt1;
    for (paramInt1 = bool;; paramInt1++) {
      if (i > paramInt2)
        return arrayOfChar; 
      arrayOfChar[paramInt1] = paramArrayOfchar[i];
      i++;
    } 
  }
  
  private String[] subStringRangeArray(String[] paramArrayOfString, int paramInt1, int paramInt2) {
    String[] arrayOfString = new String[paramInt2 - paramInt1 + 1];
    boolean bool = false;
    int i = paramInt1;
    for (paramInt1 = bool;; paramInt1++) {
      if (i > paramInt2)
        return arrayOfString; 
      arrayOfString[paramInt1] = paramArrayOfString[i];
      i++;
    } 
  }
  
  public int distinguish(char[] paramArrayOfchar1, int paramInt1, char[] paramArrayOfchar2, String[] paramArrayOfString, int paramInt2, int paramInt3) {
    if (paramInt1 == 0 && (paramArrayOfchar1[0] == paramArrayOfchar2[0] || paramArrayOfchar1[0] == paramArrayOfString[0].charAt(0)))
      return (paramArrayOfchar1.length != 1) ? distinguish(paramArrayOfchar1, 1, paramArrayOfchar2, paramArrayOfString, 0, 1) : 0; 
    if (paramArrayOfString[paramInt2].length() > paramInt3 && paramInt1 < paramArrayOfchar1.length && (paramArrayOfchar1[paramInt1] == paramArrayOfchar2[paramInt2] || paramArrayOfchar1[paramInt1] == paramArrayOfString[paramInt2].charAt(paramInt3)))
      return (paramInt1 == paramArrayOfchar1.length - 1) ? (distinguish(paramArrayOfchar1, paramArrayOfchar2, paramArrayOfString, paramInt2) ? paramInt2 : -1) : distinguish(paramArrayOfchar1, paramInt1 + 1, paramArrayOfchar2, paramArrayOfString, paramInt2, paramInt3 + 1); 
    int i = paramArrayOfString.length;
    paramInt3 = paramInt2 + 1;
    if (i > paramInt3 && paramInt1 < paramArrayOfchar1.length && (paramArrayOfchar1[paramInt1] == paramArrayOfchar2[paramInt3] || paramArrayOfchar1[paramInt1] == paramArrayOfString[paramInt3].charAt(0)))
      return (paramInt1 == paramArrayOfchar1.length - 1) ? (distinguish(paramArrayOfchar1, paramArrayOfchar2, paramArrayOfString, paramInt2) ? paramInt3 : -1) : distinguish(paramArrayOfchar1, 1 + paramInt1, paramArrayOfchar2, paramArrayOfString, paramInt3, 1); 
    if (paramArrayOfString.length > paramInt3)
      for (paramInt2 = 1;; paramInt2++) {
        if (paramInt2 >= paramInt1)
          return -1; 
        if (distinguish(paramArrayOfchar1, paramInt1 - paramInt2, paramArrayOfchar2, paramArrayOfString, paramInt3, 0) != -1)
          return paramInt3; 
      }  
    return -1;
  }
  
  public MatchedResult getMatchedResult(String paramString1, String paramString2) {
    MatchedResult matchedResult = new MatchedResult();
    matchedResult.start = -1;
    matchedResult.end = -1;
    if (!isLoad)
      return matchedResult; 
    if (!TextUtils.isEmpty(paramString1)) {
      if (TextUtils.isEmpty(paramString2))
        return matchedResult; 
      String str1 = paramString1.toUpperCase();
      String str2 = paramString2.toUpperCase();
      paramString1 = str1;
      paramString2 = str2;
      if (Math.min(str1.length(), str2.length()) > 10) {
        paramString1 = str1.substring(0, 10);
        paramString2 = str2.substring(0, 10);
      } 
      int i = paramString1.indexOf(paramString2);
      if (i >= 0) {
        matchedResult.start = i;
        matchedResult.end = i + paramString2.length() - 1;
      } 
      char[] arrayOfChar = new char[paramString2.length()];
      for (i = 0;; i++) {
        char[] arrayOfChar1;
        if (i >= paramString2.length()) {
          arrayOfChar1 = new char[paramString1.length()];
          String[] arrayOfString = new String[paramString1.length()];
          int j = paramString1.length();
          for (i = 0;; i++) {
            if (i >= j) {
              j = arrayOfChar[0];
              for (i = 0;; i++) {
                if (i >= arrayOfString.length)
                  return matchedResult; 
                char c1 = arrayOfString[i].charAt(0);
                char c2 = arrayOfChar1[i];
                if (c1 == j || c2 == j) {
                  int k = distinguish(arrayOfChar, 0, subCharRangeArray(arrayOfChar1, i, arrayOfChar1.length - 1), subStringRangeArray(arrayOfString, i, arrayOfString.length - 1), 0, 0);
                  if (k != -1) {
                    matchedResult.start = i;
                    matchedResult.end = i + k;
                    return matchedResult;
                  } 
                } 
              } 
              break;
            } 
            char c = paramString1.charAt(i);
            arrayOfChar1[i] = c;
            String str = getPinyin(c);
            if (!TextUtils.isEmpty(str)) {
              arrayOfString[i] = str.toUpperCase();
            } else {
              arrayOfString[i] = (new StringBuilder(String.valueOf(c))).toString();
            } 
          } 
          break;
        } 
        arrayOfChar[i] = arrayOfChar1.charAt(i);
      } 
    } 
    return matchedResult;
  }
  
  public String getPinyin(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return ""; 
    if (!isLoad)
      return ""; 
    StringBuilder stringBuilder = new StringBuilder();
    int j = paramString.length();
    for (int i = 0;; i++) {
      if (i >= j)
        return stringBuilder.toString(); 
      stringBuilder.append(getPinyin(paramString.charAt(i)));
    } 
  }
  
  public static class MatchedResult {
    public int end = -1;
    
    public int start = -1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\register\mobile\PinyinUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */