package androidx.transition;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.core.content.res.TypedArrayUtils;
import java.io.IOException;
import java.lang.reflect.Constructor;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class TransitionInflater {
  private static final Class<?>[] a = new Class[] { Context.class, AttributeSet.class };
  
  private static final ArrayMap<String, Constructor<?>> b = new ArrayMap();
  
  private final Context c;
  
  private TransitionInflater(Context paramContext) {
    this.c = paramContext;
  }
  
  private Transition a(XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Transition paramTransition) throws XmlPullParserException, IOException {
    TransitionSet transitionSet;
    Transition transition;
    int i = paramXmlPullParser.getDepth();
    if (paramTransition instanceof TransitionSet) {
      transitionSet = (TransitionSet)paramTransition;
    } else {
      transitionSet = null;
    } 
    label79: while (true) {
      transition = null;
      while (true) {
        int j = paramXmlPullParser.next();
        if ((j != 3 || paramXmlPullParser.getDepth() > i) && j != 1) {
          StringBuilder stringBuilder;
          Transition transition1;
          if (j != 2)
            continue; 
          String str = paramXmlPullParser.getName();
          if ("fade".equals(str)) {
            transition1 = new Fade(this.c, paramAttributeSet);
          } else {
            ChangeBounds changeBounds;
            if ("changeBounds".equals(transition1)) {
              changeBounds = new ChangeBounds(this.c, paramAttributeSet);
            } else {
              Slide slide;
              if ("slide".equals(changeBounds)) {
                slide = new Slide(this.c, paramAttributeSet);
              } else {
                Explode explode;
                if ("explode".equals(slide)) {
                  explode = new Explode(this.c, paramAttributeSet);
                } else {
                  ChangeImageTransform changeImageTransform;
                  if ("changeImageTransform".equals(explode)) {
                    changeImageTransform = new ChangeImageTransform(this.c, paramAttributeSet);
                  } else {
                    ChangeTransform changeTransform;
                    if ("changeTransform".equals(changeImageTransform)) {
                      changeTransform = new ChangeTransform(this.c, paramAttributeSet);
                    } else {
                      ChangeClipBounds changeClipBounds;
                      if ("changeClipBounds".equals(changeTransform)) {
                        changeClipBounds = new ChangeClipBounds(this.c, paramAttributeSet);
                      } else {
                        AutoTransition autoTransition;
                        if ("autoTransition".equals(changeClipBounds)) {
                          autoTransition = new AutoTransition(this.c, paramAttributeSet);
                        } else {
                          ChangeScroll changeScroll;
                          if ("changeScroll".equals(autoTransition)) {
                            changeScroll = new ChangeScroll(this.c, paramAttributeSet);
                          } else {
                            TransitionSet transitionSet1;
                            if ("transitionSet".equals(changeScroll)) {
                              transitionSet1 = new TransitionSet(this.c, paramAttributeSet);
                            } else if ("transition".equals(transitionSet1)) {
                              transition1 = (Transition)a(paramAttributeSet, Transition.class, "transition");
                            } else if ("targets".equals(transition1)) {
                              b(paramXmlPullParser, paramAttributeSet, paramTransition);
                              transition1 = transition;
                            } else if ("arcMotion".equals(transition1)) {
                              if (paramTransition != null) {
                                paramTransition.setPathMotion(new ArcMotion(this.c, paramAttributeSet));
                                transition1 = transition;
                              } else {
                                throw new RuntimeException("Invalid use of arcMotion element");
                              } 
                            } else if ("pathMotion".equals(transition1)) {
                              if (paramTransition != null) {
                                paramTransition.setPathMotion((PathMotion)a(paramAttributeSet, PathMotion.class, "pathMotion"));
                                transition1 = transition;
                              } else {
                                throw new RuntimeException("Invalid use of pathMotion element");
                              } 
                            } else if ("patternPathMotion".equals(transition1)) {
                              if (paramTransition != null) {
                                paramTransition.setPathMotion(new PatternPathMotion(this.c, paramAttributeSet));
                                transition1 = transition;
                              } else {
                                throw new RuntimeException("Invalid use of patternPathMotion element");
                              } 
                            } else {
                              stringBuilder = new StringBuilder();
                              stringBuilder.append("Unknown scene name: ");
                              stringBuilder.append(paramXmlPullParser.getName());
                              throw new RuntimeException(stringBuilder.toString());
                            } 
                          } 
                        } 
                      } 
                    } 
                  } 
                } 
              } 
            } 
          } 
          transition = transition1;
          if (transition1 != null) {
            if (!paramXmlPullParser.isEmptyElementTag())
              a(paramXmlPullParser, (AttributeSet)stringBuilder, transition1); 
            if (transitionSet != null) {
              transitionSet.addTransition(transition1);
              continue label79;
            } 
            if (paramTransition == null) {
              transition = transition1;
              continue;
            } 
            throw new InflateException("Could not add transition to another transition.");
          } 
          continue;
        } 
        break;
      } 
      break;
    } 
    return transition;
  }
  
  private TransitionManager a(XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, ViewGroup paramViewGroup) throws XmlPullParserException, IOException {
    int i = paramXmlPullParser.getDepth();
    TransitionManager transitionManager = null;
    while (true) {
      int j = paramXmlPullParser.next();
      if ((j != 3 || paramXmlPullParser.getDepth() > i) && j != 1) {
        if (j != 2)
          continue; 
        String str = paramXmlPullParser.getName();
        if (str.equals("transitionManager")) {
          transitionManager = new TransitionManager();
          continue;
        } 
        if (str.equals("transition") && transitionManager != null) {
          a(paramAttributeSet, paramXmlPullParser, paramViewGroup, transitionManager);
          continue;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown scene name: ");
        stringBuilder.append(paramXmlPullParser.getName());
        throw new RuntimeException(stringBuilder.toString());
      } 
      break;
    } 
    return transitionManager;
  }
  
  private Object a(AttributeSet paramAttributeSet, Class<?> paramClass, String paramString) {
    StringBuilder stringBuilder2;
    String str = paramAttributeSet.getAttributeValue(null, "class");
    if (str != null)
      try {
        synchronized (b) {
          Constructor<?> constructor2 = (Constructor)b.get(str);
          Constructor<?> constructor1 = constructor2;
          if (constructor2 == null) {
            Class<?> clazz = Class.forName(str, false, this.c.getClassLoader()).asSubclass(paramClass);
            constructor1 = constructor2;
            if (clazz != null) {
              constructor1 = clazz.getConstructor(a);
              constructor1.setAccessible(true);
              b.put(str, constructor1);
            } 
          } 
          paramAttributeSet = (AttributeSet)constructor1.newInstance(new Object[] { this.c, paramAttributeSet });
          return paramAttributeSet;
        } 
      } catch (Exception exception) {
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Could not instantiate ");
        stringBuilder2.append(paramClass);
        stringBuilder2.append(" class ");
        stringBuilder2.append(str);
        throw new InflateException(stringBuilder2.toString(), exception);
      }  
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append((String)stringBuilder2);
    stringBuilder1.append(" tag must have a 'class' attribute");
    throw new InflateException(stringBuilder1.toString());
  }
  
  private void a(AttributeSet paramAttributeSet, XmlPullParser paramXmlPullParser, ViewGroup paramViewGroup, TransitionManager paramTransitionManager) throws Resources.NotFoundException {
    Scene scene1;
    Scene scene2;
    TypedArray typedArray = this.c.obtainStyledAttributes(paramAttributeSet, Styleable.b);
    int i = TypedArrayUtils.getNamedResourceId(typedArray, paramXmlPullParser, "transition", 2, -1);
    int j = TypedArrayUtils.getNamedResourceId(typedArray, paramXmlPullParser, "fromScene", 0, -1);
    XmlPullParser xmlPullParser = null;
    if (j < 0) {
      paramAttributeSet = null;
    } else {
      scene1 = Scene.getSceneForLayout(paramViewGroup, j, this.c);
    } 
    j = TypedArrayUtils.getNamedResourceId(typedArray, paramXmlPullParser, "toScene", 1, -1);
    if (j < 0) {
      paramXmlPullParser = xmlPullParser;
    } else {
      scene2 = Scene.getSceneForLayout(paramViewGroup, j, this.c);
    } 
    if (i >= 0) {
      Transition transition = inflateTransition(i);
      if (transition != null)
        if (scene2 != null) {
          if (scene1 == null) {
            paramTransitionManager.setTransition(scene2, transition);
          } else {
            paramTransitionManager.setTransition(scene1, scene2, transition);
          } 
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("No toScene for transition ID ");
          stringBuilder.append(i);
          throw new RuntimeException(stringBuilder.toString());
        }  
    } 
    typedArray.recycle();
  }
  
  private void b(XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Transition paramTransition) throws XmlPullParserException, IOException {
    int i = paramXmlPullParser.getDepth();
    while (true) {
      TypedArray typedArray;
      int j = paramXmlPullParser.next();
      if ((j != 3 || paramXmlPullParser.getDepth() > i) && j != 1) {
        if (j != 2)
          continue; 
        if (paramXmlPullParser.getName().equals("target")) {
          typedArray = this.c.obtainStyledAttributes(paramAttributeSet, Styleable.a);
          j = TypedArrayUtils.getNamedResourceId(typedArray, paramXmlPullParser, "targetId", 1, 0);
          if (j != 0) {
            paramTransition.addTarget(j);
          } else {
            j = TypedArrayUtils.getNamedResourceId(typedArray, paramXmlPullParser, "excludeId", 2, 0);
            if (j != 0) {
              paramTransition.excludeTarget(j, true);
            } else {
              String str = TypedArrayUtils.getNamedString(typedArray, paramXmlPullParser, "targetName", 4);
              if (str != null) {
                paramTransition.addTarget(str);
              } else {
                str = TypedArrayUtils.getNamedString(typedArray, paramXmlPullParser, "excludeName", 5);
                if (str != null) {
                  paramTransition.excludeTarget(str, true);
                } else {
                  String str1 = TypedArrayUtils.getNamedString(typedArray, paramXmlPullParser, "excludeClass", 3);
                  if (str1 != null) {
                    str = str1;
                    try {
                      paramTransition.excludeTarget(Class.forName(str1), true);
                      typedArray.recycle();
                    } catch (ClassNotFoundException classNotFoundException) {
                      typedArray.recycle();
                      StringBuilder stringBuilder = new StringBuilder();
                      stringBuilder.append("Could not create ");
                      stringBuilder.append(str);
                      throw new RuntimeException(stringBuilder.toString(), classNotFoundException);
                    } 
                    continue;
                  } 
                  str = str1;
                  str1 = TypedArrayUtils.getNamedString(typedArray, (XmlPullParser)classNotFoundException, "targetClass", 0);
                  if (str1 != null) {
                    str = str1;
                    paramTransition.addTarget(Class.forName(str1));
                  } 
                } 
              } 
            } 
          } 
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Unknown scene name: ");
          stringBuilder.append(classNotFoundException.getName());
          throw new RuntimeException(stringBuilder.toString());
        } 
      } else {
        break;
      } 
      typedArray.recycle();
    } 
  }
  
  public static TransitionInflater from(Context paramContext) {
    return new TransitionInflater(paramContext);
  }
  
  public Transition inflateTransition(int paramInt) {
    Exception exception;
    XmlResourceParser xmlResourceParser = this.c.getResources().getXml(paramInt);
    try {
      Transition transition = a((XmlPullParser)xmlResourceParser, Xml.asAttributeSet((XmlPullParser)xmlResourceParser), (Transition)null);
      xmlResourceParser.close();
      return transition;
    } catch (XmlPullParserException xmlPullParserException) {
      throw new InflateException(xmlPullParserException.getMessage(), xmlPullParserException);
    } catch (IOException null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(xmlResourceParser.getPositionDescription());
      stringBuilder.append(": ");
      stringBuilder.append(exception.getMessage());
      throw new InflateException(stringBuilder.toString(), exception);
    } finally {}
    xmlResourceParser.close();
    throw exception;
  }
  
  public TransitionManager inflateTransitionManager(int paramInt, ViewGroup paramViewGroup) {
    XmlResourceParser xmlResourceParser = this.c.getResources().getXml(paramInt);
    try {
      TransitionManager transitionManager = a((XmlPullParser)xmlResourceParser, Xml.asAttributeSet((XmlPullParser)xmlResourceParser), paramViewGroup);
      xmlResourceParser.close();
      return transitionManager;
    } catch (XmlPullParserException xmlPullParserException) {
      InflateException inflateException = new InflateException(xmlPullParserException.getMessage());
      inflateException.initCause((Throwable)xmlPullParserException);
      throw inflateException;
    } catch (IOException iOException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(xmlResourceParser.getPositionDescription());
      stringBuilder.append(": ");
      stringBuilder.append(iOException.getMessage());
      InflateException inflateException = new InflateException(stringBuilder.toString());
      inflateException.initCause(iOException);
      throw inflateException;
    } finally {}
    xmlResourceParser.close();
    throw paramViewGroup;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\transition\TransitionInflater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */