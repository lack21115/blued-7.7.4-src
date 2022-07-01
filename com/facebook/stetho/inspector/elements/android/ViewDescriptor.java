package com.facebook.stetho.inspector.elements.android;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewDebug;
import com.facebook.stetho.common.ExceptionUtil;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.ReflectionUtil;
import com.facebook.stetho.common.StringUtil;
import com.facebook.stetho.common.android.ResourcesUtil;
import com.facebook.stetho.inspector.elements.AbstractChainedDescriptor;
import com.facebook.stetho.inspector.elements.AttributeAccumulator;
import com.facebook.stetho.inspector.elements.ComputedStyleAccumulator;
import com.facebook.stetho.inspector.elements.StyleAccumulator;
import com.facebook.stetho.inspector.elements.StyleRuleNameAccumulator;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

final class ViewDescriptor extends AbstractChainedDescriptor<View> implements HighlightableDescriptor<View> {
  private static final String ACCESSIBILITY_STYLE_RULE_NAME = "Accessibility Properties";
  
  private static final String ID_NAME = "id";
  
  private static final String NONE_MAPPING = "<no mapping>";
  
  private static final String NONE_VALUE = "(none)";
  
  private static final String VIEW_STYLE_RULE_NAME = "<this_view>";
  
  private static final boolean sHasSupportNodeInfo;
  
  private final MethodInvoker mMethodInvoker;
  
  @Nullable
  private volatile List<ViewCSSProperty> mViewProperties;
  
  @Nullable
  private Pattern mWordBoundaryPattern;
  
  static {
    boolean bool;
    if (ReflectionUtil.tryGetClassForName("androidx.core.view.accessibility.AccessibilityNodeInfoCompat") != null) {
      bool = true;
    } else {
      bool = false;
    } 
    sHasSupportNodeInfo = bool;
  }
  
  public ViewDescriptor() {
    this(new MethodInvoker());
  }
  
  public ViewDescriptor(MethodInvoker paramMethodInvoker) {
    this.mMethodInvoker = paramMethodInvoker;
  }
  
  private static boolean canFlagsBeMappedToString(@Nullable ViewDebug.ExportedProperty paramExportedProperty) {
    return (paramExportedProperty != null && paramExportedProperty.flagMapping() != null && (paramExportedProperty.flagMapping()).length > 0);
  }
  
  private static boolean canIntBeMappedToString(@Nullable ViewDebug.ExportedProperty paramExportedProperty) {
    return (paramExportedProperty != null && paramExportedProperty.mapping() != null && (paramExportedProperty.mapping()).length > 0);
  }
  
  private static String capitalize(String paramString) {
    String str = paramString;
    if (paramString != null) {
      str = paramString;
      if (paramString.length() != 0) {
        if (Character.isTitleCase(paramString.charAt(0)))
          return paramString; 
        StringBuilder stringBuilder = new StringBuilder(paramString);
        stringBuilder.setCharAt(0, Character.toTitleCase(stringBuilder.charAt(0)));
        str = stringBuilder.toString();
      } 
    } 
    return str;
  }
  
  private String convertViewPropertyNameToCSSName(String paramString) {
    String[] arrayOfString = getWordBoundaryPattern().split(paramString);
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < arrayOfString.length; i++) {
      if (!arrayOfString[i].equals("get") && !arrayOfString[i].equals("m")) {
        stringBuilder.append(arrayOfString[i].toLowerCase());
        if (i < arrayOfString.length - 1)
          stringBuilder.append('-'); 
      } 
    } 
    return stringBuilder.toString();
  }
  
  @Nullable
  private static String getIdAttribute(View paramView) {
    int i = paramView.getId();
    return (i == -1) ? null : ResourcesUtil.getIdStringQuietly(paramView, paramView.getResources(), i);
  }
  
  private void getIdStyle(View paramView, StyleAccumulator paramStyleAccumulator) {
    String str = getIdAttribute(paramView);
    if (str == null) {
      paramStyleAccumulator.store("id", "(none)", false);
      return;
    } 
    paramStyleAccumulator.store("id", str, false);
  }
  
  private void getStyleFromInteger(String paramString, Integer paramInteger, @Nullable ViewDebug.ExportedProperty paramExportedProperty, StyleAccumulator paramStyleAccumulator) {
    // Byte code:
    //   0: invokestatic getInstance : ()Lcom/facebook/stetho/inspector/helper/IntegerFormatter;
    //   3: aload_2
    //   4: aload_3
    //   5: invokevirtual format : (Ljava/lang/Integer;Landroid/view/ViewDebug$ExportedProperty;)Ljava/lang/String;
    //   8: astore #6
    //   10: aload_3
    //   11: invokestatic canIntBeMappedToString : (Landroid/view/ViewDebug$ExportedProperty;)Z
    //   14: ifeq -> 79
    //   17: new java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial <init> : ()V
    //   24: astore #5
    //   26: aload #5
    //   28: aload #6
    //   30: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload #5
    //   36: ldc ' ('
    //   38: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload #5
    //   44: aload_2
    //   45: invokevirtual intValue : ()I
    //   48: aload_3
    //   49: invokestatic mapIntToStringUsingAnnotation : (ILandroid/view/ViewDebug$ExportedProperty;)Ljava/lang/String;
    //   52: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload #5
    //   58: ldc ')'
    //   60: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload #4
    //   66: aload_1
    //   67: aload #5
    //   69: invokevirtual toString : ()Ljava/lang/String;
    //   72: iconst_0
    //   73: invokeinterface store : (Ljava/lang/String;Ljava/lang/String;Z)V
    //   78: return
    //   79: aload_3
    //   80: invokestatic canFlagsBeMappedToString : (Landroid/view/ViewDebug$ExportedProperty;)Z
    //   83: ifeq -> 148
    //   86: new java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial <init> : ()V
    //   93: astore #5
    //   95: aload #5
    //   97: aload #6
    //   99: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload #5
    //   105: ldc ' ('
    //   107: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload #5
    //   113: aload_2
    //   114: invokevirtual intValue : ()I
    //   117: aload_3
    //   118: invokestatic mapFlagsToStringUsingAnnotation : (ILandroid/view/ViewDebug$ExportedProperty;)Ljava/lang/String;
    //   121: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload #5
    //   127: ldc ')'
    //   129: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload #4
    //   135: aload_1
    //   136: aload #5
    //   138: invokevirtual toString : ()Ljava/lang/String;
    //   141: iconst_0
    //   142: invokeinterface store : (Ljava/lang/String;Ljava/lang/String;Z)V
    //   147: return
    //   148: iconst_1
    //   149: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   152: astore #5
    //   154: aload_2
    //   155: invokevirtual intValue : ()I
    //   158: ifne -> 178
    //   161: aload_3
    //   162: invokestatic canFlagsBeMappedToString : (Landroid/view/ViewDebug$ExportedProperty;)Z
    //   165: ifne -> 178
    //   168: aload #5
    //   170: astore_2
    //   171: aload_3
    //   172: invokestatic canIntBeMappedToString : (Landroid/view/ViewDebug$ExportedProperty;)Z
    //   175: ifeq -> 183
    //   178: iconst_0
    //   179: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   182: astore_2
    //   183: aload #4
    //   185: aload_1
    //   186: aload #6
    //   188: aload_2
    //   189: invokevirtual booleanValue : ()Z
    //   192: invokeinterface store : (Ljava/lang/String;Ljava/lang/String;Z)V
    //   197: return
  }
  
  private void getStyleFromValue(View paramView, String paramString, Object paramObject, @Nullable ViewDebug.ExportedProperty paramExportedProperty, StyleAccumulator paramStyleAccumulator) {
    String str;
    if (paramString.equals("id")) {
      getIdStyle(paramView, paramStyleAccumulator);
      return;
    } 
    if (paramObject instanceof Integer) {
      getStyleFromInteger(paramString, (Integer)paramObject, paramExportedProperty, paramStyleAccumulator);
      return;
    } 
    boolean bool = paramObject instanceof Float;
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool5 = true;
    boolean bool6 = true;
    boolean bool7 = true;
    boolean bool1 = true;
    if (bool) {
      str = String.valueOf(paramObject);
      if (((Float)paramObject).floatValue() != 0.0F)
        bool1 = false; 
      paramStyleAccumulator.store(paramString, str, bool1);
      return;
    } 
    if (paramObject instanceof Boolean) {
      paramStyleAccumulator.store(paramString, String.valueOf(paramObject), false);
      return;
    } 
    if (paramObject instanceof Short) {
      str = String.valueOf(paramObject);
      if (((Short)paramObject).shortValue() == 0) {
        bool1 = bool2;
      } else {
        bool1 = false;
      } 
      paramStyleAccumulator.store(paramString, str, bool1);
      return;
    } 
    if (paramObject instanceof Long) {
      str = String.valueOf(paramObject);
      if (((Long)paramObject).longValue() == 0L) {
        bool1 = bool3;
      } else {
        bool1 = false;
      } 
      paramStyleAccumulator.store(paramString, str, bool1);
      return;
    } 
    if (paramObject instanceof Double) {
      str = String.valueOf(paramObject);
      if (((Double)paramObject).doubleValue() == 0.0D) {
        bool1 = bool4;
      } else {
        bool1 = false;
      } 
      paramStyleAccumulator.store(paramString, str, bool1);
      return;
    } 
    if (paramObject instanceof Byte) {
      str = String.valueOf(paramObject);
      if (((Byte)paramObject).byteValue() == 0) {
        bool1 = bool5;
      } else {
        bool1 = false;
      } 
      paramStyleAccumulator.store(paramString, str, bool1);
      return;
    } 
    if (paramObject instanceof Character) {
      str = String.valueOf(paramObject);
      if (((Character)paramObject).charValue() == '\000') {
        bool1 = bool6;
      } else {
        bool1 = false;
      } 
      paramStyleAccumulator.store(paramString, str, bool1);
      return;
    } 
    if (paramObject instanceof CharSequence) {
      str = String.valueOf(paramObject);
      if (((CharSequence)paramObject).length() == 0) {
        bool1 = bool7;
      } else {
        bool1 = false;
      } 
      paramStyleAccumulator.store(paramString, str, bool1);
      return;
    } 
    getStylesFromObject((View)str, paramString, paramObject, paramExportedProperty, paramStyleAccumulator);
  }
  
  private void getStylesFromObject(View paramView, String paramString, Object paramObject, @Nullable ViewDebug.ExportedProperty paramExportedProperty, StyleAccumulator paramStyleAccumulator) {
    if (paramExportedProperty == null || !paramExportedProperty.deepExport() || paramObject == null)
      return; 
    Field[] arrayOfField = paramObject.getClass().getFields();
    int j = arrayOfField.length;
    for (int i = 0;; i++) {
      if (i < j) {
        Field field = arrayOfField[i];
        if (!Modifier.isStatic(field.getModifiers())) {
          try {
            field.setAccessible(true);
            Object object = field.get(paramObject);
            String str = field.getName();
            byte b = -1;
            switch (str.hashCode()) {
              case 2064613305:
                if (str.equals("bottomMargin"))
                  b = 0; 
                break;
              case 1928835221:
                if (str.equals("leftMargin"))
                  b = 2; 
                break;
              case -414179485:
                if (str.equals("topMargin"))
                  b = 1; 
                break;
              case -599904534:
                if (str.equals("rightMargin"))
                  b = 3; 
                break;
            } 
            if (b != 0) {
              if (b != 1) {
                if (b != 2) {
                  if (b != 3) {
                    String str1 = paramExportedProperty.prefix();
                    if (str1 != null) {
                      StringBuilder stringBuilder = new StringBuilder();
                      stringBuilder.append(str1);
                      stringBuilder.append(str);
                      str = stringBuilder.toString();
                    } 
                    str = convertViewPropertyNameToCSSName(str);
                  } else {
                    str = "margin-right";
                  } 
                } else {
                  str = "margin-left";
                } 
              } else {
                str = "margin-top";
              } 
            } else {
              str = "margin-bottom";
            } 
            getStyleFromValue(paramView, str, object, field.<ViewDebug.ExportedProperty>getAnnotation(ViewDebug.ExportedProperty.class), paramStyleAccumulator);
            i++;
          } catch (IllegalAccessException illegalAccessException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("failed to get property of name: \"");
            stringBuilder.append(paramString);
            stringBuilder.append("\" of object: ");
            stringBuilder.append(String.valueOf(paramObject));
            LogUtil.e(illegalAccessException, stringBuilder.toString());
            return;
          } 
          continue;
        } 
      } else {
        break;
      } 
    } 
  }
  
  private List<ViewCSSProperty> getViewProperties() {
    // Byte code:
    //   0: aload_0
    //   1: getfield mViewProperties : Ljava/util/List;
    //   4: ifnonnull -> 207
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield mViewProperties : Ljava/util/List;
    //   13: ifnonnull -> 195
    //   16: new java/util/ArrayList
    //   19: dup
    //   20: invokespecial <init> : ()V
    //   23: astore #4
    //   25: ldc android/view/View
    //   27: invokevirtual getDeclaredMethods : ()[Ljava/lang/reflect/Method;
    //   30: astore #5
    //   32: aload #5
    //   34: arraylength
    //   35: istore_3
    //   36: iconst_0
    //   37: istore_2
    //   38: iconst_0
    //   39: istore_1
    //   40: iload_1
    //   41: iload_3
    //   42: if_icmpge -> 100
    //   45: aload #5
    //   47: iload_1
    //   48: aaload
    //   49: astore #6
    //   51: aload #6
    //   53: ldc android/view/ViewDebug$ExportedProperty
    //   55: invokevirtual getAnnotation : (Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   58: checkcast android/view/ViewDebug$ExportedProperty
    //   61: astore #7
    //   63: aload #7
    //   65: ifnull -> 212
    //   68: aload #4
    //   70: new com/facebook/stetho/inspector/elements/android/ViewDescriptor$MethodBackedCSSProperty
    //   73: dup
    //   74: aload_0
    //   75: aload #6
    //   77: aload_0
    //   78: aload #6
    //   80: invokevirtual getName : ()Ljava/lang/String;
    //   83: invokespecial convertViewPropertyNameToCSSName : (Ljava/lang/String;)Ljava/lang/String;
    //   86: aload #7
    //   88: invokespecial <init> : (Lcom/facebook/stetho/inspector/elements/android/ViewDescriptor;Ljava/lang/reflect/Method;Ljava/lang/String;Landroid/view/ViewDebug$ExportedProperty;)V
    //   91: invokeinterface add : (Ljava/lang/Object;)Z
    //   96: pop
    //   97: goto -> 212
    //   100: ldc android/view/View
    //   102: invokevirtual getDeclaredFields : ()[Ljava/lang/reflect/Field;
    //   105: astore #5
    //   107: aload #5
    //   109: arraylength
    //   110: istore_3
    //   111: iload_2
    //   112: istore_1
    //   113: iload_1
    //   114: iload_3
    //   115: if_icmpge -> 173
    //   118: aload #5
    //   120: iload_1
    //   121: aaload
    //   122: astore #6
    //   124: aload #6
    //   126: ldc android/view/ViewDebug$ExportedProperty
    //   128: invokevirtual getAnnotation : (Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   131: checkcast android/view/ViewDebug$ExportedProperty
    //   134: astore #7
    //   136: aload #7
    //   138: ifnull -> 219
    //   141: aload #4
    //   143: new com/facebook/stetho/inspector/elements/android/ViewDescriptor$FieldBackedCSSProperty
    //   146: dup
    //   147: aload_0
    //   148: aload #6
    //   150: aload_0
    //   151: aload #6
    //   153: invokevirtual getName : ()Ljava/lang/String;
    //   156: invokespecial convertViewPropertyNameToCSSName : (Ljava/lang/String;)Ljava/lang/String;
    //   159: aload #7
    //   161: invokespecial <init> : (Lcom/facebook/stetho/inspector/elements/android/ViewDescriptor;Ljava/lang/reflect/Field;Ljava/lang/String;Landroid/view/ViewDebug$ExportedProperty;)V
    //   164: invokeinterface add : (Ljava/lang/Object;)Z
    //   169: pop
    //   170: goto -> 219
    //   173: aload #4
    //   175: new com/facebook/stetho/inspector/elements/android/ViewDescriptor$1
    //   178: dup
    //   179: aload_0
    //   180: invokespecial <init> : (Lcom/facebook/stetho/inspector/elements/android/ViewDescriptor;)V
    //   183: invokestatic sort : (Ljava/util/List;Ljava/util/Comparator;)V
    //   186: aload_0
    //   187: aload #4
    //   189: invokestatic unmodifiableList : (Ljava/util/List;)Ljava/util/List;
    //   192: putfield mViewProperties : Ljava/util/List;
    //   195: aload_0
    //   196: monitorexit
    //   197: goto -> 207
    //   200: astore #4
    //   202: aload_0
    //   203: monitorexit
    //   204: aload #4
    //   206: athrow
    //   207: aload_0
    //   208: getfield mViewProperties : Ljava/util/List;
    //   211: areturn
    //   212: iload_1
    //   213: iconst_1
    //   214: iadd
    //   215: istore_1
    //   216: goto -> 40
    //   219: iload_1
    //   220: iconst_1
    //   221: iadd
    //   222: istore_1
    //   223: goto -> 113
    // Exception table:
    //   from	to	target	type
    //   9	36	200	finally
    //   51	63	200	finally
    //   68	97	200	finally
    //   100	111	200	finally
    //   124	136	200	finally
    //   141	170	200	finally
    //   173	195	200	finally
    //   195	197	200	finally
    //   202	204	200	finally
  }
  
  private Pattern getWordBoundaryPattern() {
    if (this.mWordBoundaryPattern == null)
      this.mWordBoundaryPattern = Pattern.compile("(?<=\\p{Lower})(?=\\p{Upper})"); 
    return this.mWordBoundaryPattern;
  }
  
  private static String mapFlagsToStringUsingAnnotation(int paramInt, @Nullable ViewDebug.ExportedProperty paramExportedProperty) {
    if (canFlagsBeMappedToString(paramExportedProperty)) {
      StringBuilder stringBuilder;
      ViewDebug.FlagToString[] arrayOfFlagToString = paramExportedProperty.flagMapping();
      int j = arrayOfFlagToString.length;
      paramExportedProperty = null;
      int i = 0;
      boolean bool = false;
      while (i < j) {
        boolean bool2;
        StringBuilder stringBuilder1;
        ViewDebug.FlagToString flagToString = arrayOfFlagToString[i];
        boolean bool3 = flagToString.outputIf();
        if ((flagToString.mask() & paramInt) == flagToString.equals()) {
          bool2 = true;
        } else {
          bool2 = false;
        } 
        boolean bool1 = bool;
        ViewDebug.ExportedProperty exportedProperty = paramExportedProperty;
        if (bool3 == bool2) {
          exportedProperty = paramExportedProperty;
          if (paramExportedProperty == null)
            stringBuilder1 = new StringBuilder(); 
          if (bool)
            stringBuilder1.append(" | "); 
          stringBuilder1.append(flagToString.name());
          bool1 = true;
        } 
        i++;
        bool = bool1;
        stringBuilder = stringBuilder1;
      } 
      return bool ? stringBuilder.toString() : "<no mapping>";
    } 
    throw new IllegalStateException("Cannot map using this annotation");
  }
  
  private static String mapIntToStringUsingAnnotation(int paramInt, @Nullable ViewDebug.ExportedProperty paramExportedProperty) {
    if (canIntBeMappedToString(paramExportedProperty)) {
      for (ViewDebug.IntToString intToString : paramExportedProperty.mapping()) {
        if (intToString.from() == paramInt)
          return intToString.to(); 
      } 
      return "<no mapping>";
    } 
    throw new IllegalStateException("Cannot map using this annotation");
  }
  
  @Nullable
  public Object getElementToHighlightAtPosition(View paramView, int paramInt1, int paramInt2, Rect paramRect) {
    paramRect.set(0, 0, paramView.getWidth(), paramView.getHeight());
    return paramView;
  }
  
  @Nullable
  public View getViewAndBoundsForHighlighting(View paramView, Rect paramRect) {
    return paramView;
  }
  
  protected void onGetAttributes(View paramView, AttributeAccumulator paramAttributeAccumulator) {
    String str = getIdAttribute(paramView);
    if (str != null)
      paramAttributeAccumulator.store("id", str); 
  }
  
  protected void onGetComputedStyles(View paramView, ComputedStyleAccumulator paramComputedStyleAccumulator) {
    paramComputedStyleAccumulator.store("left", Integer.toString(paramView.getLeft()));
    paramComputedStyleAccumulator.store("top", Integer.toString(paramView.getTop()));
    paramComputedStyleAccumulator.store("right", Integer.toString(paramView.getRight()));
    paramComputedStyleAccumulator.store("bottom", Integer.toString(paramView.getBottom()));
  }
  
  protected String onGetNodeName(View paramView) {
    String str = paramView.getClass().getName();
    return StringUtil.removePrefix(str, "android.view.", StringUtil.removePrefix(str, "android.widget."));
  }
  
  protected void onGetStyleRuleNames(View paramView, StyleRuleNameAccumulator paramStyleRuleNameAccumulator) {
    paramStyleRuleNameAccumulator.store("<this_view>", false);
    if (sHasSupportNodeInfo)
      paramStyleRuleNameAccumulator.store("Accessibility Properties", false); 
  }
  
  protected void onGetStyles(View paramView, String paramString, StyleAccumulator paramStyleAccumulator) {
    List<ViewCSSProperty> list;
    if ("<this_view>".equals(paramString)) {
      list = getViewProperties();
      int i = 0;
      int j = list.size();
      while (i < j) {
        ViewCSSProperty viewCSSProperty = list.get(i);
        try {
          getStyleFromValue(paramView, viewCSSProperty.getCSSName(), viewCSSProperty.getValue(paramView), viewCSSProperty.getAnnotation(), paramStyleAccumulator);
        } catch (Exception exception) {
          if (exception instanceof IllegalAccessException || exception instanceof InvocationTargetException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("failed to get style property ");
            stringBuilder.append(viewCSSProperty.getCSSName());
            stringBuilder.append(" of element= ");
            stringBuilder.append(paramView.toString());
            LogUtil.e(exception, stringBuilder.toString());
          } else {
            throw ExceptionUtil.propagate(exception);
          } 
        } 
        i++;
      } 
    } else if ("Accessibility Properties".equals(list) && sHasSupportNodeInfo) {
      boolean bool = AccessibilityNodeInfoWrapper.getIgnored(paramView);
      getStyleFromValue(paramView, "ignored", Boolean.valueOf(bool), null, paramStyleAccumulator);
      if (bool)
        getStyleFromValue(paramView, "ignored-reasons", AccessibilityNodeInfoWrapper.getIgnoredReasons(paramView), null, paramStyleAccumulator); 
      getStyleFromValue(paramView, "focusable", Boolean.valueOf(bool ^ true), null, paramStyleAccumulator);
      if (!bool) {
        getStyleFromValue(paramView, "focusable-reasons", AccessibilityNodeInfoWrapper.getFocusableReasons(paramView), null, paramStyleAccumulator);
        getStyleFromValue(paramView, "focused", Boolean.valueOf(AccessibilityNodeInfoWrapper.getIsAccessibilityFocused(paramView)), null, paramStyleAccumulator);
        getStyleFromValue(paramView, "description", AccessibilityNodeInfoWrapper.getDescription(paramView), null, paramStyleAccumulator);
        getStyleFromValue(paramView, "actions", AccessibilityNodeInfoWrapper.getActions(paramView), null, paramStyleAccumulator);
      } 
    } 
  }
  
  protected void onSetAttributesAsText(View paramView, String paramString) {
    for (Map.Entry entry : parseSetAttributesAsTextArg(paramString).entrySet()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("set");
      stringBuilder.append(capitalize((String)entry.getKey()));
      String str2 = stringBuilder.toString();
      String str1 = (String)entry.getValue();
      this.mMethodInvoker.invoke(paramView, str2, str1);
    } 
  }
  
  final class FieldBackedCSSProperty extends ViewCSSProperty {
    private final Field mField;
    
    public FieldBackedCSSProperty(Field param1Field, @Nullable String param1String, ViewDebug.ExportedProperty param1ExportedProperty) {
      super(param1String, param1ExportedProperty);
      this.mField = param1Field;
      this.mField.setAccessible(true);
    }
    
    public Object getValue(View param1View) throws InvocationTargetException, IllegalAccessException {
      return this.mField.get(param1View);
    }
  }
  
  final class MethodBackedCSSProperty extends ViewCSSProperty {
    private final Method mMethod;
    
    public MethodBackedCSSProperty(Method param1Method, @Nullable String param1String, ViewDebug.ExportedProperty param1ExportedProperty) {
      super(param1String, param1ExportedProperty);
      this.mMethod = param1Method;
      this.mMethod.setAccessible(true);
    }
    
    public Object getValue(View param1View) throws InvocationTargetException, IllegalAccessException {
      return this.mMethod.invoke(param1View, new Object[0]);
    }
  }
  
  abstract class ViewCSSProperty {
    private final ViewDebug.ExportedProperty mAnnotation;
    
    private final String mCSSName;
    
    public ViewCSSProperty(@Nullable String param1String, ViewDebug.ExportedProperty param1ExportedProperty) {
      this.mCSSName = param1String;
      this.mAnnotation = param1ExportedProperty;
    }
    
    @Nullable
    public final ViewDebug.ExportedProperty getAnnotation() {
      return this.mAnnotation;
    }
    
    public final String getCSSName() {
      return this.mCSSName;
    }
    
    public abstract Object getValue(View param1View) throws InvocationTargetException, IllegalAccessException;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\elements\android\ViewDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */