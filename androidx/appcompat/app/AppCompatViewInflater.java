package androidx.appcompat.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.collection.ArrayMap;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class AppCompatViewInflater {
  private static final Class<?>[] a = new Class[] { Context.class, AttributeSet.class };
  
  private static final int[] b = new int[] { 16843375 };
  
  private static final String[] c = new String[] { "android.widget.", "android.view.", "android.webkit." };
  
  private static final Map<String, Constructor<? extends View>> d = (Map<String, Constructor<? extends View>>)new ArrayMap();
  
  private final Object[] e = new Object[2];
  
  private static Context a(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean1, boolean paramBoolean2) {
    int i;
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.View, 0, 0);
    if (paramBoolean1) {
      i = typedArray.getResourceId(R.styleable.View_android_theme, 0);
    } else {
      i = 0;
    } 
    int j = i;
    if (paramBoolean2) {
      j = i;
      if (!i) {
        i = typedArray.getResourceId(R.styleable.View_theme, 0);
        j = i;
        if (i != 0) {
          Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
          j = i;
        } 
      } 
    } 
    typedArray.recycle();
    Context context = paramContext;
    if (j != 0) {
      if (paramContext instanceof ContextThemeWrapper) {
        context = paramContext;
        return (Context)((((ContextThemeWrapper)paramContext).getThemeResId() != j) ? new ContextThemeWrapper(paramContext, j) : context);
      } 
    } else {
      return context;
    } 
    return (Context)new ContextThemeWrapper(paramContext, j);
  }
  
  private View a(Context paramContext, String paramString1, String paramString2) throws ClassNotFoundException, InflateException {
    Constructor constructor1 = d.get(paramString1);
    Constructor<? extends View> constructor = constructor1;
    if (constructor1 == null) {
      if (paramString2 != null)
        try {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramString2);
          stringBuilder.append(paramString1);
          paramString2 = stringBuilder.toString();
          constructor = Class.forName(paramString2, false, paramContext.getClassLoader()).<View>asSubclass(View.class).getConstructor(a);
          d.put(paramString1, constructor);
          constructor.setAccessible(true);
          return constructor.newInstance(this.e);
        } catch (Exception exception) {
          return null;
        }  
    } else {
      constructor.setAccessible(true);
      return constructor.newInstance(this.e);
    } 
    paramString2 = paramString1;
    constructor = Class.forName(paramString2, false, paramContext.getClassLoader()).<View>asSubclass(View.class).getConstructor(a);
    d.put(paramString1, constructor);
    constructor.setAccessible(true);
    return constructor.newInstance(this.e);
  }
  
  private void a(View paramView, AttributeSet paramAttributeSet) {
    Context context = paramView.getContext();
    if (context instanceof ContextWrapper) {
      if (Build.VERSION.SDK_INT >= 15 && !ViewCompat.hasOnClickListeners(paramView))
        return; 
      TypedArray typedArray = context.obtainStyledAttributes(paramAttributeSet, b);
      String str = typedArray.getString(0);
      if (str != null)
        paramView.setOnClickListener(new DeclaredOnClickListener(paramView, str)); 
      typedArray.recycle();
    } 
  }
  
  private void a(View paramView, String paramString) {
    if (paramView != null)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getName());
    stringBuilder.append(" asked to inflate view for <");
    stringBuilder.append(paramString);
    stringBuilder.append(">, but returned null");
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  private View b(Context paramContext, String paramString, AttributeSet paramAttributeSet) {
    String str = paramString;
    if (paramString.equals("view"))
      str = paramAttributeSet.getAttributeValue(null, "class"); 
    try {
      Object[] arrayOfObject1;
      this.e[0] = paramContext;
      this.e[1] = paramAttributeSet;
      if (-1 == str.indexOf('.')) {
        int i;
        for (i = 0; i < c.length; i++) {
          View view = a(paramContext, str, c[i]);
          if (view != null)
            return view; 
        } 
        return null;
      } 
      return a((Context)arrayOfObject1, str, (String)null);
    } catch (Exception exception) {
      return null;
    } finally {
      Object[] arrayOfObject = this.e;
      arrayOfObject[0] = null;
      arrayOfObject[1] = null;
    } 
  }
  
  protected View a(Context paramContext, String paramString, AttributeSet paramAttributeSet) {
    return null;
  }
  
  final View a(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
    // Byte code:
    //   0: iload #5
    //   2: ifeq -> 18
    //   5: aload_1
    //   6: ifnull -> 18
    //   9: aload_1
    //   10: invokevirtual getContext : ()Landroid/content/Context;
    //   13: astore #10
    //   15: goto -> 21
    //   18: aload_3
    //   19: astore #10
    //   21: iload #6
    //   23: ifne -> 34
    //   26: aload #10
    //   28: astore_1
    //   29: iload #7
    //   31: ifeq -> 46
    //   34: aload #10
    //   36: aload #4
    //   38: iload #6
    //   40: iload #7
    //   42: invokestatic a : (Landroid/content/Context;Landroid/util/AttributeSet;ZZ)Landroid/content/Context;
    //   45: astore_1
    //   46: aload_1
    //   47: astore #10
    //   49: iload #8
    //   51: ifeq -> 60
    //   54: aload_1
    //   55: invokestatic wrap : (Landroid/content/Context;)Landroid/content/Context;
    //   58: astore #10
    //   60: iconst_m1
    //   61: istore #9
    //   63: aload_2
    //   64: invokevirtual hashCode : ()I
    //   67: lookupswitch default -> 188, -1946472170 -> 396, -1455429095 -> 379, -1346021293 -> 362, -938935918 -> 346, -937446323 -> 331, -658531749 -> 315, -339785223 -> 300, 776382189 -> 284, 799298502 -> 268, 1125864064 -> 253, 1413872058 -> 237, 1601505219 -> 221, 1666676343 -> 206, 2001146706 -> 191
    //   188: goto -> 410
    //   191: aload_2
    //   192: ldc 'Button'
    //   194: invokevirtual equals : (Ljava/lang/Object;)Z
    //   197: ifeq -> 410
    //   200: iconst_2
    //   201: istore #9
    //   203: goto -> 410
    //   206: aload_2
    //   207: ldc 'EditText'
    //   209: invokevirtual equals : (Ljava/lang/Object;)Z
    //   212: ifeq -> 410
    //   215: iconst_3
    //   216: istore #9
    //   218: goto -> 410
    //   221: aload_2
    //   222: ldc 'CheckBox'
    //   224: invokevirtual equals : (Ljava/lang/Object;)Z
    //   227: ifeq -> 410
    //   230: bipush #6
    //   232: istore #9
    //   234: goto -> 410
    //   237: aload_2
    //   238: ldc 'AutoCompleteTextView'
    //   240: invokevirtual equals : (Ljava/lang/Object;)Z
    //   243: ifeq -> 410
    //   246: bipush #9
    //   248: istore #9
    //   250: goto -> 410
    //   253: aload_2
    //   254: ldc 'ImageView'
    //   256: invokevirtual equals : (Ljava/lang/Object;)Z
    //   259: ifeq -> 410
    //   262: iconst_1
    //   263: istore #9
    //   265: goto -> 410
    //   268: aload_2
    //   269: ldc 'ToggleButton'
    //   271: invokevirtual equals : (Ljava/lang/Object;)Z
    //   274: ifeq -> 410
    //   277: bipush #13
    //   279: istore #9
    //   281: goto -> 410
    //   284: aload_2
    //   285: ldc 'RadioButton'
    //   287: invokevirtual equals : (Ljava/lang/Object;)Z
    //   290: ifeq -> 410
    //   293: bipush #7
    //   295: istore #9
    //   297: goto -> 410
    //   300: aload_2
    //   301: ldc 'Spinner'
    //   303: invokevirtual equals : (Ljava/lang/Object;)Z
    //   306: ifeq -> 410
    //   309: iconst_4
    //   310: istore #9
    //   312: goto -> 410
    //   315: aload_2
    //   316: ldc 'SeekBar'
    //   318: invokevirtual equals : (Ljava/lang/Object;)Z
    //   321: ifeq -> 410
    //   324: bipush #12
    //   326: istore #9
    //   328: goto -> 410
    //   331: aload_2
    //   332: ldc 'ImageButton'
    //   334: invokevirtual equals : (Ljava/lang/Object;)Z
    //   337: ifeq -> 410
    //   340: iconst_5
    //   341: istore #9
    //   343: goto -> 410
    //   346: aload_2
    //   347: ldc_w 'TextView'
    //   350: invokevirtual equals : (Ljava/lang/Object;)Z
    //   353: ifeq -> 410
    //   356: iconst_0
    //   357: istore #9
    //   359: goto -> 410
    //   362: aload_2
    //   363: ldc_w 'MultiAutoCompleteTextView'
    //   366: invokevirtual equals : (Ljava/lang/Object;)Z
    //   369: ifeq -> 410
    //   372: bipush #10
    //   374: istore #9
    //   376: goto -> 410
    //   379: aload_2
    //   380: ldc_w 'CheckedTextView'
    //   383: invokevirtual equals : (Ljava/lang/Object;)Z
    //   386: ifeq -> 410
    //   389: bipush #8
    //   391: istore #9
    //   393: goto -> 410
    //   396: aload_2
    //   397: ldc_w 'RatingBar'
    //   400: invokevirtual equals : (Ljava/lang/Object;)Z
    //   403: ifeq -> 410
    //   406: bipush #11
    //   408: istore #9
    //   410: iload #9
    //   412: tableswitch default -> 484, 0 -> 731, 1 -> 713, 2 -> 695, 3 -> 677, 4 -> 659, 5 -> 641, 6 -> 623, 7 -> 605, 8 -> 587, 9 -> 569, 10 -> 551, 11 -> 533, 12 -> 515, 13 -> 497
    //   484: aload_0
    //   485: aload #10
    //   487: aload_2
    //   488: aload #4
    //   490: invokevirtual a : (Landroid/content/Context;Ljava/lang/String;Landroid/util/AttributeSet;)Landroid/view/View;
    //   493: astore_1
    //   494: goto -> 746
    //   497: aload_0
    //   498: aload #10
    //   500: aload #4
    //   502: invokevirtual n : (Landroid/content/Context;Landroid/util/AttributeSet;)Landroidx/appcompat/widget/AppCompatToggleButton;
    //   505: astore_1
    //   506: aload_0
    //   507: aload_1
    //   508: aload_2
    //   509: invokespecial a : (Landroid/view/View;Ljava/lang/String;)V
    //   512: goto -> 746
    //   515: aload_0
    //   516: aload #10
    //   518: aload #4
    //   520: invokevirtual m : (Landroid/content/Context;Landroid/util/AttributeSet;)Landroidx/appcompat/widget/AppCompatSeekBar;
    //   523: astore_1
    //   524: aload_0
    //   525: aload_1
    //   526: aload_2
    //   527: invokespecial a : (Landroid/view/View;Ljava/lang/String;)V
    //   530: goto -> 746
    //   533: aload_0
    //   534: aload #10
    //   536: aload #4
    //   538: invokevirtual l : (Landroid/content/Context;Landroid/util/AttributeSet;)Landroidx/appcompat/widget/AppCompatRatingBar;
    //   541: astore_1
    //   542: aload_0
    //   543: aload_1
    //   544: aload_2
    //   545: invokespecial a : (Landroid/view/View;Ljava/lang/String;)V
    //   548: goto -> 746
    //   551: aload_0
    //   552: aload #10
    //   554: aload #4
    //   556: invokevirtual k : (Landroid/content/Context;Landroid/util/AttributeSet;)Landroidx/appcompat/widget/AppCompatMultiAutoCompleteTextView;
    //   559: astore_1
    //   560: aload_0
    //   561: aload_1
    //   562: aload_2
    //   563: invokespecial a : (Landroid/view/View;Ljava/lang/String;)V
    //   566: goto -> 746
    //   569: aload_0
    //   570: aload #10
    //   572: aload #4
    //   574: invokevirtual j : (Landroid/content/Context;Landroid/util/AttributeSet;)Landroidx/appcompat/widget/AppCompatAutoCompleteTextView;
    //   577: astore_1
    //   578: aload_0
    //   579: aload_1
    //   580: aload_2
    //   581: invokespecial a : (Landroid/view/View;Ljava/lang/String;)V
    //   584: goto -> 746
    //   587: aload_0
    //   588: aload #10
    //   590: aload #4
    //   592: invokevirtual i : (Landroid/content/Context;Landroid/util/AttributeSet;)Landroidx/appcompat/widget/AppCompatCheckedTextView;
    //   595: astore_1
    //   596: aload_0
    //   597: aload_1
    //   598: aload_2
    //   599: invokespecial a : (Landroid/view/View;Ljava/lang/String;)V
    //   602: goto -> 746
    //   605: aload_0
    //   606: aload #10
    //   608: aload #4
    //   610: invokevirtual h : (Landroid/content/Context;Landroid/util/AttributeSet;)Landroidx/appcompat/widget/AppCompatRadioButton;
    //   613: astore_1
    //   614: aload_0
    //   615: aload_1
    //   616: aload_2
    //   617: invokespecial a : (Landroid/view/View;Ljava/lang/String;)V
    //   620: goto -> 746
    //   623: aload_0
    //   624: aload #10
    //   626: aload #4
    //   628: invokevirtual g : (Landroid/content/Context;Landroid/util/AttributeSet;)Landroidx/appcompat/widget/AppCompatCheckBox;
    //   631: astore_1
    //   632: aload_0
    //   633: aload_1
    //   634: aload_2
    //   635: invokespecial a : (Landroid/view/View;Ljava/lang/String;)V
    //   638: goto -> 746
    //   641: aload_0
    //   642: aload #10
    //   644: aload #4
    //   646: invokevirtual f : (Landroid/content/Context;Landroid/util/AttributeSet;)Landroidx/appcompat/widget/AppCompatImageButton;
    //   649: astore_1
    //   650: aload_0
    //   651: aload_1
    //   652: aload_2
    //   653: invokespecial a : (Landroid/view/View;Ljava/lang/String;)V
    //   656: goto -> 746
    //   659: aload_0
    //   660: aload #10
    //   662: aload #4
    //   664: invokevirtual e : (Landroid/content/Context;Landroid/util/AttributeSet;)Landroidx/appcompat/widget/AppCompatSpinner;
    //   667: astore_1
    //   668: aload_0
    //   669: aload_1
    //   670: aload_2
    //   671: invokespecial a : (Landroid/view/View;Ljava/lang/String;)V
    //   674: goto -> 746
    //   677: aload_0
    //   678: aload #10
    //   680: aload #4
    //   682: invokevirtual d : (Landroid/content/Context;Landroid/util/AttributeSet;)Landroidx/appcompat/widget/AppCompatEditText;
    //   685: astore_1
    //   686: aload_0
    //   687: aload_1
    //   688: aload_2
    //   689: invokespecial a : (Landroid/view/View;Ljava/lang/String;)V
    //   692: goto -> 746
    //   695: aload_0
    //   696: aload #10
    //   698: aload #4
    //   700: invokevirtual c : (Landroid/content/Context;Landroid/util/AttributeSet;)Landroidx/appcompat/widget/AppCompatButton;
    //   703: astore_1
    //   704: aload_0
    //   705: aload_1
    //   706: aload_2
    //   707: invokespecial a : (Landroid/view/View;Ljava/lang/String;)V
    //   710: goto -> 746
    //   713: aload_0
    //   714: aload #10
    //   716: aload #4
    //   718: invokevirtual b : (Landroid/content/Context;Landroid/util/AttributeSet;)Landroidx/appcompat/widget/AppCompatImageView;
    //   721: astore_1
    //   722: aload_0
    //   723: aload_1
    //   724: aload_2
    //   725: invokespecial a : (Landroid/view/View;Ljava/lang/String;)V
    //   728: goto -> 746
    //   731: aload_0
    //   732: aload #10
    //   734: aload #4
    //   736: invokevirtual a : (Landroid/content/Context;Landroid/util/AttributeSet;)Landroidx/appcompat/widget/AppCompatTextView;
    //   739: astore_1
    //   740: aload_0
    //   741: aload_1
    //   742: aload_2
    //   743: invokespecial a : (Landroid/view/View;Ljava/lang/String;)V
    //   746: aload_1
    //   747: astore #11
    //   749: aload_1
    //   750: ifnonnull -> 773
    //   753: aload_1
    //   754: astore #11
    //   756: aload_3
    //   757: aload #10
    //   759: if_acmpeq -> 773
    //   762: aload_0
    //   763: aload #10
    //   765: aload_2
    //   766: aload #4
    //   768: invokespecial b : (Landroid/content/Context;Ljava/lang/String;Landroid/util/AttributeSet;)Landroid/view/View;
    //   771: astore #11
    //   773: aload #11
    //   775: ifnull -> 786
    //   778: aload_0
    //   779: aload #11
    //   781: aload #4
    //   783: invokespecial a : (Landroid/view/View;Landroid/util/AttributeSet;)V
    //   786: aload #11
    //   788: areturn
  }
  
  protected AppCompatTextView a(Context paramContext, AttributeSet paramAttributeSet) {
    return new AppCompatTextView(paramContext, paramAttributeSet);
  }
  
  protected AppCompatImageView b(Context paramContext, AttributeSet paramAttributeSet) {
    return new AppCompatImageView(paramContext, paramAttributeSet);
  }
  
  protected AppCompatButton c(Context paramContext, AttributeSet paramAttributeSet) {
    return new AppCompatButton(paramContext, paramAttributeSet);
  }
  
  protected AppCompatEditText d(Context paramContext, AttributeSet paramAttributeSet) {
    return new AppCompatEditText(paramContext, paramAttributeSet);
  }
  
  protected AppCompatSpinner e(Context paramContext, AttributeSet paramAttributeSet) {
    return new AppCompatSpinner(paramContext, paramAttributeSet);
  }
  
  protected AppCompatImageButton f(Context paramContext, AttributeSet paramAttributeSet) {
    return new AppCompatImageButton(paramContext, paramAttributeSet);
  }
  
  protected AppCompatCheckBox g(Context paramContext, AttributeSet paramAttributeSet) {
    return new AppCompatCheckBox(paramContext, paramAttributeSet);
  }
  
  protected AppCompatRadioButton h(Context paramContext, AttributeSet paramAttributeSet) {
    return new AppCompatRadioButton(paramContext, paramAttributeSet);
  }
  
  protected AppCompatCheckedTextView i(Context paramContext, AttributeSet paramAttributeSet) {
    return new AppCompatCheckedTextView(paramContext, paramAttributeSet);
  }
  
  protected AppCompatAutoCompleteTextView j(Context paramContext, AttributeSet paramAttributeSet) {
    return new AppCompatAutoCompleteTextView(paramContext, paramAttributeSet);
  }
  
  protected AppCompatMultiAutoCompleteTextView k(Context paramContext, AttributeSet paramAttributeSet) {
    return new AppCompatMultiAutoCompleteTextView(paramContext, paramAttributeSet);
  }
  
  protected AppCompatRatingBar l(Context paramContext, AttributeSet paramAttributeSet) {
    return new AppCompatRatingBar(paramContext, paramAttributeSet);
  }
  
  protected AppCompatSeekBar m(Context paramContext, AttributeSet paramAttributeSet) {
    return new AppCompatSeekBar(paramContext, paramAttributeSet);
  }
  
  protected AppCompatToggleButton n(Context paramContext, AttributeSet paramAttributeSet) {
    return new AppCompatToggleButton(paramContext, paramAttributeSet);
  }
  
  static class DeclaredOnClickListener implements View.OnClickListener {
    private final View a;
    
    private final String b;
    
    private Method c;
    
    private Context d;
    
    public DeclaredOnClickListener(View param1View, String param1String) {
      this.a = param1View;
      this.b = param1String;
    }
    
    private void a(Context param1Context, String param1String) {
      while (true) {
        String str;
        if (param1Context != null) {
          try {
            if (!param1Context.isRestricted()) {
              Method method = param1Context.getClass().getMethod(this.b, new Class[] { View.class });
              if (method != null) {
                this.c = method;
                this.d = param1Context;
                return;
              } 
            } 
          } catch (NoSuchMethodException noSuchMethodException) {}
          if (param1Context instanceof ContextWrapper) {
            param1Context = ((ContextWrapper)param1Context).getBaseContext();
            continue;
          } 
          param1Context = null;
          continue;
        } 
        int i = this.a.getId();
        if (i == -1) {
          str = "";
        } else {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(" with id '");
          stringBuilder1.append(this.a.getContext().getResources().getResourceEntryName(i));
          stringBuilder1.append("'");
          str = stringBuilder1.toString();
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Could not find method ");
        stringBuilder.append(this.b);
        stringBuilder.append("(View) in a parent or ancestor Context for android:onClick attribute defined on view ");
        stringBuilder.append(this.a.getClass());
        stringBuilder.append(str);
        throw new IllegalStateException(stringBuilder.toString());
      } 
    }
    
    public void onClick(View param1View) {
      if (this.c == null)
        a(this.a.getContext(), this.b); 
      try {
        this.c.invoke(this.d, new Object[] { param1View });
        return;
      } catch (IllegalAccessException illegalAccessException) {
        throw new IllegalStateException("Could not execute non-public method for android:onClick", illegalAccessException);
      } catch (InvocationTargetException invocationTargetException) {
        throw new IllegalStateException("Could not execute method for android:onClick", invocationTargetException);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\app\AppCompatViewInflater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */