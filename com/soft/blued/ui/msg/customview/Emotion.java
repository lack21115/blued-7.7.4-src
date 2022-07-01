package com.soft.blued.ui.msg.customview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import androidx.collection.ArrayMap;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.soft.blued.customview.selectabletextview.SelectedImageSpan;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Emotion {
  public static String[] a;
  
  public static String[] b;
  
  public static int[] c;
  
  private static Pattern d;
  
  private static Map<String, Integer> f;
  
  private Context e;
  
  public Emotion(Context paramContext) {
    this.e = paramContext;
    c();
    if (d == null) {
      d = a();
      int j = b.length;
      c = new int[j];
      for (int i = 0; i < j; i++) {
        try {
          int k = paramContext.getResources().getIdentifier(b[i], "drawable", paramContext.getPackageName());
          c[i] = k;
        } catch (Exception exception) {
          exception.printStackTrace();
        } 
      } 
      f = (Map<String, Integer>)b();
    } 
  }
  
  public static CharSequence a(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
    Object object2;
    if (TextUtils.isEmpty(paramCharSequence))
      return paramCharSequence; 
    try {
      Matcher matcher = d.matcher(paramCharSequence);
      SpannableStringBuilder spannableStringBuilder = null;
      while (true) {
        object2 = spannableStringBuilder;
        SpannableStringBuilder spannableStringBuilder1 = spannableStringBuilder;
        try {
          if (matcher.find()) {
            SpannableStringBuilder spannableStringBuilder3 = spannableStringBuilder;
            if (spannableStringBuilder == null) {
              object2 = spannableStringBuilder;
              spannableStringBuilder3 = new SpannableStringBuilder(paramCharSequence);
            } 
            object2 = spannableStringBuilder3;
            int i = ((Integer)f.get(matcher.group())).intValue();
            object2 = spannableStringBuilder3;
            Drawable drawable = AppInfo.d().getResources().getDrawable(i);
            if (paramInt2 == 3) {
              object2 = spannableStringBuilder3;
              drawable.setBounds(0, 0, AppMethods.a(25), AppMethods.a(25));
              object2 = spannableStringBuilder3;
              SelectedImageSpan selectedImageSpan = new SelectedImageSpan(drawable, 1);
            } else {
              object2 = spannableStringBuilder3;
              drawable.setBounds(0, 0, AppMethods.a(2) + paramInt1, AppMethods.a(2) + paramInt1);
              if (paramInt2 == 0) {
                object2 = spannableStringBuilder3;
                SelectedImageSpan selectedImageSpan = new SelectedImageSpan(drawable, 0);
              } else if (paramInt2 == 1) {
                object2 = spannableStringBuilder3;
                SelectedImageSpan selectedImageSpan = new SelectedImageSpan(drawable, 1);
              } else {
                spannableStringBuilder1 = null;
              } 
            } 
            SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder3;
            if (spannableStringBuilder1 != null) {
              object2 = spannableStringBuilder3;
              spannableStringBuilder3.setSpan(spannableStringBuilder1, matcher.start(), matcher.end(), 33);
              spannableStringBuilder2 = spannableStringBuilder3;
            } 
            continue;
          } 
        } catch (Exception null) {
          exception.printStackTrace();
          spannableStringBuilder1 = (SpannableStringBuilder)object2;
        } 
        if (spannableStringBuilder1 != null) {
          spannableStringBuilder1.append(" ");
          return (CharSequence)spannableStringBuilder1;
        } 
        return paramCharSequence;
      } 
    } catch (Exception exception) {
      object2 = null;
    } 
    exception.printStackTrace();
    Object object1 = object2;
  }
  
  private Pattern a() {
    StringBuilder stringBuilder = new StringBuilder(a.length * 3);
    try {
      stringBuilder.append('(');
      String[] arrayOfString = a;
      int j = arrayOfString.length;
      for (int i = 0; i < j; i++) {
        stringBuilder.append(Pattern.quote(arrayOfString[i]));
        stringBuilder.append('|');
      } 
      stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), ")");
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return Pattern.compile(stringBuilder.toString());
  }
  
  private ArrayMap<String, Integer> b() {
    ArrayMap<String, Integer> arrayMap = new ArrayMap(a.length);
    int i = 0;
    while (true) {
      String[] arrayOfString = a;
      if (i < arrayOfString.length) {
        arrayMap.put(arrayOfString[i], Integer.valueOf(c[i]));
        i++;
        continue;
      } 
      return arrayMap;
    } 
  }
  
  private void c() {
    // Byte code:
    //   0: invokestatic d : ()Landroid/content/Context;
    //   3: invokevirtual getAssets : ()Landroid/content/res/AssetManager;
    //   6: ldc 'emotion.txt'
    //   8: invokevirtual open : (Ljava/lang/String;)Ljava/io/InputStream;
    //   11: astore #4
    //   13: new java/io/BufferedReader
    //   16: dup
    //   17: new java/io/InputStreamReader
    //   20: dup
    //   21: aload #4
    //   23: getstatic com/google/common/base/Charsets.c : Ljava/nio/charset/Charset;
    //   26: invokespecial <init> : (Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   29: invokespecial <init> : (Ljava/io/Reader;)V
    //   32: astore_3
    //   33: new java/lang/StringBuffer
    //   36: dup
    //   37: invokespecial <init> : ()V
    //   40: astore_2
    //   41: aload_3
    //   42: invokevirtual readLine : ()Ljava/lang/String;
    //   45: astore #5
    //   47: aload #5
    //   49: ifnull -> 62
    //   52: aload_2
    //   53: aload #5
    //   55: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   58: pop
    //   59: goto -> 41
    //   62: invokestatic f : ()Lcom/google/gson/Gson;
    //   65: aload_2
    //   66: invokevirtual toString : ()Ljava/lang/String;
    //   69: ldc [Lcom/soft/blued/ui/msg/model/DefaultEmotionModel;
    //   71: invokevirtual fromJson : (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   74: checkcast [Lcom/soft/blued/ui/msg/model/DefaultEmotionModel;
    //   77: astore_2
    //   78: getstatic com/soft/blued/ui/msg/customview/Emotion.a : [Ljava/lang/String;
    //   81: ifnonnull -> 137
    //   84: aload_2
    //   85: arraylength
    //   86: anewarray java/lang/String
    //   89: putstatic com/soft/blued/ui/msg/customview/Emotion.a : [Ljava/lang/String;
    //   92: aload_2
    //   93: arraylength
    //   94: anewarray java/lang/String
    //   97: putstatic com/soft/blued/ui/msg/customview/Emotion.b : [Ljava/lang/String;
    //   100: iconst_0
    //   101: istore_1
    //   102: iload_1
    //   103: aload_2
    //   104: arraylength
    //   105: if_icmpge -> 137
    //   108: getstatic com/soft/blued/ui/msg/customview/Emotion.a : [Ljava/lang/String;
    //   111: iload_1
    //   112: aload_2
    //   113: iload_1
    //   114: aaload
    //   115: getfield name : Ljava/lang/String;
    //   118: aastore
    //   119: getstatic com/soft/blued/ui/msg/customview/Emotion.b : [Ljava/lang/String;
    //   122: iload_1
    //   123: aload_2
    //   124: iload_1
    //   125: aaload
    //   126: getfield pid : Ljava/lang/String;
    //   129: aastore
    //   130: iload_1
    //   131: iconst_1
    //   132: iadd
    //   133: istore_1
    //   134: goto -> 102
    //   137: aload #4
    //   139: ifnull -> 147
    //   142: aload #4
    //   144: invokevirtual close : ()V
    //   147: aload_3
    //   148: invokevirtual close : ()V
    //   151: return
    //   152: astore_2
    //   153: goto -> 168
    //   156: astore_2
    //   157: aconst_null
    //   158: astore_3
    //   159: goto -> 168
    //   162: astore_2
    //   163: aconst_null
    //   164: astore_3
    //   165: aload_3
    //   166: astore #4
    //   168: aload_2
    //   169: invokevirtual printStackTrace : ()V
    //   172: aload #4
    //   174: ifnull -> 185
    //   177: aload #4
    //   179: invokevirtual close : ()V
    //   182: goto -> 185
    //   185: aload_3
    //   186: ifnull -> 198
    //   189: aload_3
    //   190: invokevirtual close : ()V
    //   193: return
    //   194: aload_2
    //   195: invokevirtual printStackTrace : ()V
    //   198: return
    //   199: astore_2
    //   200: aload #4
    //   202: ifnull -> 213
    //   205: aload #4
    //   207: invokevirtual close : ()V
    //   210: goto -> 213
    //   213: aload_3
    //   214: ifnull -> 228
    //   217: aload_3
    //   218: invokevirtual close : ()V
    //   221: goto -> 228
    //   224: aload_3
    //   225: invokevirtual printStackTrace : ()V
    //   228: aload_2
    //   229: athrow
    //   230: astore_2
    //   231: goto -> 194
    //   234: astore_3
    //   235: goto -> 224
    // Exception table:
    //   from	to	target	type
    //   0	13	162	finally
    //   13	33	156	finally
    //   33	41	152	finally
    //   41	47	152	finally
    //   52	59	152	finally
    //   62	100	152	finally
    //   102	130	152	finally
    //   142	147	230	java/io/IOException
    //   147	151	230	java/io/IOException
    //   168	172	199	finally
    //   177	182	230	java/io/IOException
    //   189	193	230	java/io/IOException
    //   205	210	234	java/io/IOException
    //   217	221	234	java/io/IOException
  }
  
  public SpannableString a(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("");
    SpannableString spannableString = new SpannableString(stringBuilder.toString());
    Matcher matcher = d.matcher(paramString);
    if (matcher.find()) {
      int i = ((Integer)f.get(matcher.group())).intValue();
      Drawable drawable = this.e.getResources().getDrawable(i);
      drawable.setBounds(0, 0, AppMethods.a(25), AppMethods.a(25));
      spannableString.setSpan(new ImageSpan(drawable), 0, spannableString.length(), 33);
    } 
    return spannableString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\customview\Emotion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */