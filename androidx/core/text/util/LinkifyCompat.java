package androidx.core.text.util;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.core.util.PatternsCompat;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class LinkifyCompat {
  private static final String[] a = new String[0];
  
  private static final Comparator<LinkSpec> b = new Comparator<LinkSpec>() {
      public int compare(LinkifyCompat.LinkSpec param1LinkSpec1, LinkifyCompat.LinkSpec param1LinkSpec2) {
        return (param1LinkSpec1.c < param1LinkSpec2.c) ? -1 : ((param1LinkSpec1.c > param1LinkSpec2.c) ? 1 : ((param1LinkSpec1.d < param1LinkSpec2.d) ? 1 : ((param1LinkSpec1.d > param1LinkSpec2.d) ? -1 : 0)));
      }
    };
  
  private static String a(String paramString) {
    return (Build.VERSION.SDK_INT >= 28) ? WebView.findAddress(paramString) : FindAddress.a(paramString);
  }
  
  private static String a(String paramString, String[] paramArrayOfString, Matcher paramMatcher, Linkify.TransformFilter paramTransformFilter) {
    int j;
    String str2 = paramString;
    if (paramTransformFilter != null)
      str2 = paramTransformFilter.transformUrl(paramMatcher, paramString); 
    int i = 0;
    while (true) {
      j = paramArrayOfString.length;
      boolean bool = true;
      if (i < j) {
        if (str2.regionMatches(true, 0, paramArrayOfString[i], 0, paramArrayOfString[i].length())) {
          j = bool;
          paramString = str2;
          if (!str2.regionMatches(false, 0, paramArrayOfString[i], 0, paramArrayOfString[i].length())) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(paramArrayOfString[i]);
            stringBuilder.append(str2.substring(paramArrayOfString[i].length()));
            String str = stringBuilder.toString();
            j = bool;
          } 
          break;
        } 
        i++;
        continue;
      } 
      j = 0;
      paramString = str2;
      break;
    } 
    String str1 = paramString;
    if (j == 0) {
      str1 = paramString;
      if (paramArrayOfString.length > 0) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramArrayOfString[0]);
        stringBuilder.append(paramString);
        str1 = stringBuilder.toString();
      } 
    } 
    return str1;
  }
  
  private static void a(TextView paramTextView) {
    if (!(paramTextView.getMovementMethod() instanceof LinkMovementMethod) && paramTextView.getLinksClickable())
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance()); 
  }
  
  private static void a(String paramString, int paramInt1, int paramInt2, Spannable paramSpannable) {
    paramSpannable.setSpan(new URLSpan(paramString), paramInt1, paramInt2, 33);
  }
  
  private static void a(ArrayList<LinkSpec> paramArrayList, Spannable paramSpannable) {
    String str = paramSpannable.toString();
    int i = 0;
    while (true) {
      try {
        String str1 = a(str);
        if (str1 != null) {
          int k = str.indexOf(str1);
          if (k < 0)
            return; 
          LinkSpec linkSpec = new LinkSpec();
          int j = str1.length() + k;
          linkSpec.c = k + i;
          i += j;
          linkSpec.d = i;
          str = str.substring(j);
          try {
            str1 = URLEncoder.encode(str1, "UTF-8");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("geo:0,0?q=");
            stringBuilder.append(str1);
            linkSpec.b = stringBuilder.toString();
            paramArrayList.add(linkSpec);
          } catch (UnsupportedEncodingException unsupportedEncodingException) {}
          continue;
        } 
        return;
      } catch (UnsupportedOperationException unsupportedOperationException) {
        return;
      } 
    } 
  }
  
  private static void a(ArrayList<LinkSpec> paramArrayList, Spannable paramSpannable, Pattern paramPattern, String[] paramArrayOfString, Linkify.MatchFilter paramMatchFilter, Linkify.TransformFilter paramTransformFilter) {
    Matcher matcher = paramPattern.matcher((CharSequence)paramSpannable);
    while (matcher.find()) {
      int i = matcher.start();
      int j = matcher.end();
      if (paramMatchFilter == null || paramMatchFilter.acceptMatch((CharSequence)paramSpannable, i, j)) {
        LinkSpec linkSpec = new LinkSpec();
        linkSpec.b = a(matcher.group(0), paramArrayOfString, matcher, paramTransformFilter);
        linkSpec.c = i;
        linkSpec.d = j;
        paramArrayList.add(linkSpec);
      } 
    } 
  }
  
  private static boolean a() {
    return (Build.VERSION.SDK_INT >= 28);
  }
  
  public static void addLinks(TextView paramTextView, Pattern paramPattern, String paramString) {
    if (a()) {
      Linkify.addLinks(paramTextView, paramPattern, paramString);
      return;
    } 
    addLinks(paramTextView, paramPattern, paramString, (String[])null, (Linkify.MatchFilter)null, (Linkify.TransformFilter)null);
  }
  
  public static void addLinks(TextView paramTextView, Pattern paramPattern, String paramString, Linkify.MatchFilter paramMatchFilter, Linkify.TransformFilter paramTransformFilter) {
    if (a()) {
      Linkify.addLinks(paramTextView, paramPattern, paramString, paramMatchFilter, paramTransformFilter);
      return;
    } 
    addLinks(paramTextView, paramPattern, paramString, (String[])null, paramMatchFilter, paramTransformFilter);
  }
  
  public static void addLinks(TextView paramTextView, Pattern paramPattern, String paramString, String[] paramArrayOfString, Linkify.MatchFilter paramMatchFilter, Linkify.TransformFilter paramTransformFilter) {
    if (a()) {
      Linkify.addLinks(paramTextView, paramPattern, paramString, paramArrayOfString, paramMatchFilter, paramTransformFilter);
      return;
    } 
    SpannableString spannableString = SpannableString.valueOf(paramTextView.getText());
    if (addLinks((Spannable)spannableString, paramPattern, paramString, paramArrayOfString, paramMatchFilter, paramTransformFilter)) {
      paramTextView.setText((CharSequence)spannableString);
      a(paramTextView);
    } 
  }
  
  public static boolean addLinks(Spannable paramSpannable, int paramInt) {
    if (a())
      return Linkify.addLinks(paramSpannable, paramInt); 
    if (paramInt == 0)
      return false; 
    URLSpan[] arrayOfURLSpan = (URLSpan[])paramSpannable.getSpans(0, paramSpannable.length(), URLSpan.class);
    for (int i = arrayOfURLSpan.length - 1; i >= 0; i--)
      paramSpannable.removeSpan(arrayOfURLSpan[i]); 
    if ((paramInt & 0x4) != 0)
      Linkify.addLinks(paramSpannable, 4); 
    ArrayList<LinkSpec> arrayList = new ArrayList();
    if ((paramInt & 0x1) != 0) {
      Pattern pattern = PatternsCompat.AUTOLINK_WEB_URL;
      Linkify.MatchFilter matchFilter = Linkify.sUrlMatchFilter;
      a(arrayList, paramSpannable, pattern, new String[] { "http://", "https://", "rtsp://" }, matchFilter, null);
    } 
    if ((paramInt & 0x2) != 0)
      a(arrayList, paramSpannable, PatternsCompat.AUTOLINK_EMAIL_ADDRESS, new String[] { "mailto:" }, null, null); 
    if ((paramInt & 0x8) != 0)
      a(arrayList, paramSpannable); 
    b(arrayList, paramSpannable);
    if (arrayList.size() == 0)
      return false; 
    for (LinkSpec linkSpec : arrayList) {
      if (linkSpec.a == null)
        a(linkSpec.b, linkSpec.c, linkSpec.d, paramSpannable); 
    } 
    return true;
  }
  
  public static boolean addLinks(Spannable paramSpannable, Pattern paramPattern, String paramString) {
    return a() ? Linkify.addLinks(paramSpannable, paramPattern, paramString) : addLinks(paramSpannable, paramPattern, paramString, (String[])null, (Linkify.MatchFilter)null, (Linkify.TransformFilter)null);
  }
  
  public static boolean addLinks(Spannable paramSpannable, Pattern paramPattern, String paramString, Linkify.MatchFilter paramMatchFilter, Linkify.TransformFilter paramTransformFilter) {
    return a() ? Linkify.addLinks(paramSpannable, paramPattern, paramString, paramMatchFilter, paramTransformFilter) : addLinks(paramSpannable, paramPattern, paramString, (String[])null, paramMatchFilter, paramTransformFilter);
  }
  
  public static boolean addLinks(Spannable paramSpannable, Pattern paramPattern, String paramString, String[] paramArrayOfString, Linkify.MatchFilter paramMatchFilter, Linkify.TransformFilter paramTransformFilter) {
    // Byte code:
    //   0: invokestatic a : ()Z
    //   3: ifeq -> 18
    //   6: aload_0
    //   7: aload_1
    //   8: aload_2
    //   9: aload_3
    //   10: aload #4
    //   12: aload #5
    //   14: invokestatic addLinks : (Landroid/text/Spannable;Ljava/util/regex/Pattern;Ljava/lang/String;[Ljava/lang/String;Landroid/text/util/Linkify$MatchFilter;Landroid/text/util/Linkify$TransformFilter;)Z
    //   17: ireturn
    //   18: aload_2
    //   19: astore #10
    //   21: aload_2
    //   22: ifnonnull -> 30
    //   25: ldc_w ''
    //   28: astore #10
    //   30: aload_3
    //   31: ifnull -> 42
    //   34: aload_3
    //   35: astore_2
    //   36: aload_3
    //   37: arraylength
    //   38: iconst_1
    //   39: if_icmpge -> 46
    //   42: getstatic androidx/core/text/util/LinkifyCompat.a : [Ljava/lang/String;
    //   45: astore_2
    //   46: aload_2
    //   47: arraylength
    //   48: iconst_1
    //   49: iadd
    //   50: anewarray java/lang/String
    //   53: astore #11
    //   55: aload #11
    //   57: iconst_0
    //   58: aload #10
    //   60: getstatic java/util/Locale.ROOT : Ljava/util/Locale;
    //   63: invokevirtual toLowerCase : (Ljava/util/Locale;)Ljava/lang/String;
    //   66: aastore
    //   67: iconst_0
    //   68: istore #6
    //   70: iload #6
    //   72: aload_2
    //   73: arraylength
    //   74: if_icmpge -> 116
    //   77: aload_2
    //   78: iload #6
    //   80: aaload
    //   81: astore_3
    //   82: iload #6
    //   84: iconst_1
    //   85: iadd
    //   86: istore #6
    //   88: aload_3
    //   89: ifnonnull -> 99
    //   92: ldc_w ''
    //   95: astore_3
    //   96: goto -> 107
    //   99: aload_3
    //   100: getstatic java/util/Locale.ROOT : Ljava/util/Locale;
    //   103: invokevirtual toLowerCase : (Ljava/util/Locale;)Ljava/lang/String;
    //   106: astore_3
    //   107: aload #11
    //   109: iload #6
    //   111: aload_3
    //   112: aastore
    //   113: goto -> 70
    //   116: aload_1
    //   117: aload_0
    //   118: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   121: astore_1
    //   122: iconst_0
    //   123: istore #8
    //   125: aload_1
    //   126: invokevirtual find : ()Z
    //   129: ifeq -> 201
    //   132: aload_1
    //   133: invokevirtual start : ()I
    //   136: istore #6
    //   138: aload_1
    //   139: invokevirtual end : ()I
    //   142: istore #7
    //   144: aload #4
    //   146: ifnull -> 166
    //   149: aload #4
    //   151: aload_0
    //   152: iload #6
    //   154: iload #7
    //   156: invokeinterface acceptMatch : (Ljava/lang/CharSequence;II)Z
    //   161: istore #9
    //   163: goto -> 169
    //   166: iconst_1
    //   167: istore #9
    //   169: iload #9
    //   171: ifeq -> 125
    //   174: aload_1
    //   175: iconst_0
    //   176: invokevirtual group : (I)Ljava/lang/String;
    //   179: aload #11
    //   181: aload_1
    //   182: aload #5
    //   184: invokestatic a : (Ljava/lang/String;[Ljava/lang/String;Ljava/util/regex/Matcher;Landroid/text/util/Linkify$TransformFilter;)Ljava/lang/String;
    //   187: iload #6
    //   189: iload #7
    //   191: aload_0
    //   192: invokestatic a : (Ljava/lang/String;IILandroid/text/Spannable;)V
    //   195: iconst_1
    //   196: istore #8
    //   198: goto -> 125
    //   201: iload #8
    //   203: ireturn
  }
  
  public static boolean addLinks(TextView paramTextView, int paramInt) {
    if (a())
      return Linkify.addLinks(paramTextView, paramInt); 
    if (paramInt == 0)
      return false; 
    CharSequence charSequence = paramTextView.getText();
    if (charSequence instanceof Spannable) {
      if (addLinks((Spannable)charSequence, paramInt)) {
        a(paramTextView);
        return true;
      } 
      return false;
    } 
    SpannableString spannableString = SpannableString.valueOf(charSequence);
    if (addLinks((Spannable)spannableString, paramInt)) {
      a(paramTextView);
      paramTextView.setText((CharSequence)spannableString);
      return true;
    } 
    return false;
  }
  
  private static void b(ArrayList<LinkSpec> paramArrayList, Spannable paramSpannable) {
    int i = paramSpannable.length();
    int j = 0;
    URLSpan[] arrayOfURLSpan = (URLSpan[])paramSpannable.getSpans(0, i, URLSpan.class);
    for (i = 0; i < arrayOfURLSpan.length; i++) {
      LinkSpec linkSpec = new LinkSpec();
      linkSpec.a = arrayOfURLSpan[i];
      linkSpec.c = paramSpannable.getSpanStart(arrayOfURLSpan[i]);
      linkSpec.d = paramSpannable.getSpanEnd(arrayOfURLSpan[i]);
      paramArrayList.add(linkSpec);
    } 
    Collections.sort(paramArrayList, b);
    int k = paramArrayList.size();
    for (i = j; i < k - 1; i = m) {
      LinkSpec linkSpec1 = paramArrayList.get(i);
      int m = i + 1;
      LinkSpec linkSpec2 = paramArrayList.get(m);
      if (linkSpec1.c <= linkSpec2.c && linkSpec1.d > linkSpec2.c) {
        if (linkSpec2.d <= linkSpec1.d || linkSpec1.d - linkSpec1.c > linkSpec2.d - linkSpec2.c) {
          j = m;
        } else if (linkSpec1.d - linkSpec1.c < linkSpec2.d - linkSpec2.c) {
          j = i;
        } else {
          j = -1;
        } 
        if (j != -1) {
          URLSpan uRLSpan = ((LinkSpec)paramArrayList.get(j)).a;
          if (uRLSpan != null)
            paramSpannable.removeSpan(uRLSpan); 
          paramArrayList.remove(j);
          k--;
          continue;
        } 
      } 
    } 
  }
  
  static class LinkSpec {
    URLSpan a;
    
    String b;
    
    int c;
    
    int d;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface LinkifyMask {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\tex\\util\LinkifyCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */