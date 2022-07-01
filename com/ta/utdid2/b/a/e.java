package com.ta.utdid2.b.a;

import android.util.Xml;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

class e {
  public static final Object a(XmlPullParser paramXmlPullParser, String[] paramArrayOfString) throws XmlPullParserException, IOException {
    int i = paramXmlPullParser.getEventType();
    while (true) {
      if (i == 2)
        return b(paramXmlPullParser, paramArrayOfString); 
      if (i != 3) {
        if (i != 4)
          try {
            i = paramXmlPullParser.next();
            if (i != 1)
              continue; 
            throw new XmlPullParserException("Unexpected end of document");
          } catch (Exception exception) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Unexpected call next(): ");
            stringBuilder2.append(paramXmlPullParser.getName());
            throw new XmlPullParserException(stringBuilder2.toString());
          }  
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Unexpected text: ");
        stringBuilder1.append(paramXmlPullParser.getText());
        throw new XmlPullParserException(stringBuilder1.toString());
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unexpected end tag at: ");
      stringBuilder.append(paramXmlPullParser.getName());
      throw new XmlPullParserException(stringBuilder.toString());
    } 
  }
  
  public static final ArrayList a(XmlPullParser paramXmlPullParser, String paramString, String[] paramArrayOfString) throws XmlPullParserException, IOException {
    ArrayList<Object> arrayList = new ArrayList();
    int i = paramXmlPullParser.getEventType();
    while (true) {
      if (i == 2) {
        arrayList.add(b(paramXmlPullParser, paramArrayOfString));
      } else if (i == 3) {
        if (paramXmlPullParser.getName().equals(paramString))
          return arrayList; 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Expected ");
        stringBuilder1.append(paramString);
        stringBuilder1.append(" end tag at: ");
        stringBuilder1.append(paramXmlPullParser.getName());
        throw new XmlPullParserException(stringBuilder1.toString());
      } 
      i = paramXmlPullParser.next();
      if (i != 1)
        continue; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Document ended before ");
      stringBuilder.append(paramString);
      stringBuilder.append(" end tag");
      throw new XmlPullParserException(stringBuilder.toString());
    } 
  }
  
  public static final HashMap a(InputStream paramInputStream) throws XmlPullParserException, IOException {
    XmlPullParser xmlPullParser = Xml.newPullParser();
    xmlPullParser.setInput(paramInputStream, null);
    return (HashMap)a(xmlPullParser, new String[1]);
  }
  
  public static final HashMap a(XmlPullParser paramXmlPullParser, String paramString, String[] paramArrayOfString) throws XmlPullParserException, IOException {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    int i = paramXmlPullParser.getEventType();
    while (true) {
      StringBuilder stringBuilder2;
      if (i == 2) {
        Object object = b(paramXmlPullParser, paramArrayOfString);
        if (paramArrayOfString[0] != null) {
          hashMap.put(paramArrayOfString[0], object);
        } else {
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append("Map value without name attribute: ");
          stringBuilder2.append(paramXmlPullParser.getName());
          throw new XmlPullParserException(stringBuilder2.toString());
        } 
      } else if (i == 3) {
        if (paramXmlPullParser.getName().equals(stringBuilder2))
          return hashMap; 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected ");
        stringBuilder.append((String)stringBuilder2);
        stringBuilder.append(" end tag at: ");
        stringBuilder.append(paramXmlPullParser.getName());
        throw new XmlPullParserException(stringBuilder.toString());
      } 
      i = paramXmlPullParser.next();
      if (i != 1)
        continue; 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Document ended before ");
      stringBuilder1.append((String)stringBuilder2);
      stringBuilder1.append(" end tag");
      throw new XmlPullParserException(stringBuilder1.toString());
    } 
  }
  
  public static final void a(Object paramObject, String paramString, XmlSerializer paramXmlSerializer) throws XmlPullParserException, IOException {
    StringBuilder stringBuilder;
    String str;
    if (paramObject == null) {
      paramXmlSerializer.startTag(null, "null");
      if (paramString != null)
        paramXmlSerializer.attribute(null, "name", paramString); 
      paramXmlSerializer.endTag(null, "null");
      return;
    } 
    if (paramObject instanceof String) {
      paramXmlSerializer.startTag(null, "string");
      if (paramString != null)
        paramXmlSerializer.attribute(null, "name", paramString); 
      paramXmlSerializer.text(paramObject.toString());
      paramXmlSerializer.endTag(null, "string");
      return;
    } 
    if (paramObject instanceof Integer) {
      str = "int";
    } else if (paramObject instanceof Long) {
      str = "long";
    } else if (paramObject instanceof Float) {
      str = "float";
    } else if (paramObject instanceof Double) {
      str = "double";
    } else if (paramObject instanceof Boolean) {
      str = "boolean";
    } else {
      if (paramObject instanceof byte[]) {
        a((byte[])paramObject, paramString, paramXmlSerializer);
        return;
      } 
      if (paramObject instanceof int[]) {
        a((int[])paramObject, paramString, paramXmlSerializer);
        return;
      } 
      if (paramObject instanceof Map) {
        a((Map)paramObject, paramString, paramXmlSerializer);
        return;
      } 
      if (paramObject instanceof List) {
        a((List)paramObject, paramString, paramXmlSerializer);
        return;
      } 
      if (paramObject instanceof CharSequence) {
        paramXmlSerializer.startTag(null, "string");
        if (paramString != null)
          paramXmlSerializer.attribute(null, "name", paramString); 
        paramXmlSerializer.text(paramObject.toString());
        paramXmlSerializer.endTag(null, "string");
        return;
      } 
      stringBuilder = new StringBuilder();
      stringBuilder.append("writeValueXml: unable to write value ");
      stringBuilder.append(paramObject);
      throw new RuntimeException(stringBuilder.toString());
    } 
    paramXmlSerializer.startTag(null, str);
    if (stringBuilder != null)
      paramXmlSerializer.attribute(null, "name", (String)stringBuilder); 
    paramXmlSerializer.attribute(null, "value", paramObject.toString());
    paramXmlSerializer.endTag(null, str);
  }
  
  public static final void a(List paramList, String paramString, XmlSerializer paramXmlSerializer) throws XmlPullParserException, IOException {
    if (paramList == null) {
      paramXmlSerializer.startTag(null, "null");
      paramXmlSerializer.endTag(null, "null");
      return;
    } 
    paramXmlSerializer.startTag(null, "list");
    if (paramString != null)
      paramXmlSerializer.attribute(null, "name", paramString); 
    int j = paramList.size();
    for (int i = 0; i < j; i++)
      a(paramList.get(i), (String)null, paramXmlSerializer); 
    paramXmlSerializer.endTag(null, "list");
  }
  
  public static final void a(Map paramMap, OutputStream paramOutputStream) throws XmlPullParserException, IOException {
    a a = new a();
    a.setOutput(paramOutputStream, "utf-8");
    a.startDocument(null, Boolean.valueOf(true));
    a.setFeature(a.d(), true);
    a(paramMap, (String)null, a);
    a.endDocument();
  }
  
  public static final void a(Map paramMap, String paramString, XmlSerializer paramXmlSerializer) throws XmlPullParserException, IOException {
    if (paramMap == null) {
      paramXmlSerializer.startTag(null, "null");
      paramXmlSerializer.endTag(null, "null");
      return;
    } 
    Iterator<Map.Entry> iterator = paramMap.entrySet().iterator();
    paramXmlSerializer.startTag(null, "map");
    if (paramString != null)
      paramXmlSerializer.attribute(null, "name", paramString); 
    while (iterator.hasNext()) {
      Map.Entry entry = iterator.next();
      a(entry.getValue(), (String)entry.getKey(), paramXmlSerializer);
    } 
    paramXmlSerializer.endTag(null, "map");
  }
  
  public static final void a(byte[] paramArrayOfbyte, String paramString, XmlSerializer paramXmlSerializer) throws XmlPullParserException, IOException {
    if (paramArrayOfbyte == null) {
      paramXmlSerializer.startTag(null, "null");
      paramXmlSerializer.endTag(null, "null");
      return;
    } 
    paramXmlSerializer.startTag(null, "byte-array");
    if (paramString != null)
      paramXmlSerializer.attribute(null, "name", paramString); 
    int j = paramArrayOfbyte.length;
    paramXmlSerializer.attribute(null, "num", Integer.toString(j));
    StringBuilder stringBuilder = new StringBuilder(paramArrayOfbyte.length * 2);
    for (int i = 0; i < j; i++) {
      byte b = paramArrayOfbyte[i];
      int k = b >> 4;
      if (k >= 10) {
        k = k + 97 - 10;
      } else {
        k += 48;
      } 
      stringBuilder.append(k);
      k = b & 0xFF;
      if (k >= 10) {
        k = k + 97 - 10;
      } else {
        k += 48;
      } 
      stringBuilder.append(k);
    } 
    paramXmlSerializer.text(stringBuilder.toString());
    paramXmlSerializer.endTag(null, "byte-array");
  }
  
  public static final void a(int[] paramArrayOfint, String paramString, XmlSerializer paramXmlSerializer) throws XmlPullParserException, IOException {
    if (paramArrayOfint == null) {
      paramXmlSerializer.startTag(null, "null");
      paramXmlSerializer.endTag(null, "null");
      return;
    } 
    paramXmlSerializer.startTag(null, "int-array");
    if (paramString != null)
      paramXmlSerializer.attribute(null, "name", paramString); 
    int j = paramArrayOfint.length;
    paramXmlSerializer.attribute(null, "num", Integer.toString(j));
    for (int i = 0; i < j; i++) {
      paramXmlSerializer.startTag(null, "item");
      paramXmlSerializer.attribute(null, "value", Integer.toString(paramArrayOfint[i]));
      paramXmlSerializer.endTag(null, "item");
    } 
    paramXmlSerializer.endTag(null, "int-array");
  }
  
  public static final int[] a(XmlPullParser paramXmlPullParser, String paramString, String[] paramArrayOfString) throws XmlPullParserException, IOException {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: ldc 'num'
    //   4: invokeinterface getAttributeValue : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   9: invokestatic parseInt : (Ljava/lang/String;)I
    //   12: istore_3
    //   13: iload_3
    //   14: newarray int
    //   16: astore_2
    //   17: iconst_0
    //   18: istore_3
    //   19: aload_0
    //   20: invokeinterface getEventType : ()I
    //   25: istore #4
    //   27: iload #4
    //   29: iconst_2
    //   30: if_icmpne -> 130
    //   33: aload_0
    //   34: invokeinterface getName : ()Ljava/lang/String;
    //   39: ldc_w 'item'
    //   42: invokevirtual equals : (Ljava/lang/Object;)Z
    //   45: ifeq -> 91
    //   48: aload_2
    //   49: iload_3
    //   50: aload_0
    //   51: aconst_null
    //   52: ldc 'value'
    //   54: invokeinterface getAttributeValue : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   59: invokestatic parseInt : (Ljava/lang/String;)I
    //   62: iastore
    //   63: iload_3
    //   64: istore #5
    //   66: goto -> 228
    //   69: new org/xmlpull/v1/XmlPullParserException
    //   72: dup
    //   73: ldc_w 'Not a number in value attribute in item'
    //   76: invokespecial <init> : (Ljava/lang/String;)V
    //   79: athrow
    //   80: new org/xmlpull/v1/XmlPullParserException
    //   83: dup
    //   84: ldc_w 'Need value attribute in item'
    //   87: invokespecial <init> : (Ljava/lang/String;)V
    //   90: athrow
    //   91: new java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial <init> : ()V
    //   98: astore_1
    //   99: aload_1
    //   100: ldc_w 'Expected item tag at: '
    //   103: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload_1
    //   108: aload_0
    //   109: invokeinterface getName : ()Ljava/lang/String;
    //   114: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: new org/xmlpull/v1/XmlPullParserException
    //   121: dup
    //   122: aload_1
    //   123: invokevirtual toString : ()Ljava/lang/String;
    //   126: invokespecial <init> : (Ljava/lang/String;)V
    //   129: athrow
    //   130: iload_3
    //   131: istore #5
    //   133: iload #4
    //   135: iconst_3
    //   136: if_icmpne -> 228
    //   139: aload_0
    //   140: invokeinterface getName : ()Ljava/lang/String;
    //   145: aload_1
    //   146: invokevirtual equals : (Ljava/lang/Object;)Z
    //   149: ifeq -> 154
    //   152: aload_2
    //   153: areturn
    //   154: aload_0
    //   155: invokeinterface getName : ()Ljava/lang/String;
    //   160: ldc_w 'item'
    //   163: invokevirtual equals : (Ljava/lang/Object;)Z
    //   166: ifeq -> 177
    //   169: iload_3
    //   170: iconst_1
    //   171: iadd
    //   172: istore #5
    //   174: goto -> 228
    //   177: new java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial <init> : ()V
    //   184: astore_2
    //   185: aload_2
    //   186: ldc 'Expected '
    //   188: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload_2
    //   193: aload_1
    //   194: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload_2
    //   199: ldc ' end tag at: '
    //   201: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload_2
    //   206: aload_0
    //   207: invokeinterface getName : ()Ljava/lang/String;
    //   212: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: new org/xmlpull/v1/XmlPullParserException
    //   219: dup
    //   220: aload_2
    //   221: invokevirtual toString : ()Ljava/lang/String;
    //   224: invokespecial <init> : (Ljava/lang/String;)V
    //   227: athrow
    //   228: aload_0
    //   229: invokeinterface next : ()I
    //   234: istore #4
    //   236: iload #4
    //   238: iconst_1
    //   239: if_icmpeq -> 248
    //   242: iload #5
    //   244: istore_3
    //   245: goto -> 27
    //   248: new java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial <init> : ()V
    //   255: astore_0
    //   256: aload_0
    //   257: ldc 'Document ended before '
    //   259: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload_0
    //   264: aload_1
    //   265: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload_0
    //   270: ldc ' end tag'
    //   272: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: new org/xmlpull/v1/XmlPullParserException
    //   279: dup
    //   280: aload_0
    //   281: invokevirtual toString : ()Ljava/lang/String;
    //   284: invokespecial <init> : (Ljava/lang/String;)V
    //   287: athrow
    //   288: new org/xmlpull/v1/XmlPullParserException
    //   291: dup
    //   292: ldc_w 'Not a number in num attribute in byte-array'
    //   295: invokespecial <init> : (Ljava/lang/String;)V
    //   298: athrow
    //   299: new org/xmlpull/v1/XmlPullParserException
    //   302: dup
    //   303: ldc_w 'Need num attribute in byte-array'
    //   306: invokespecial <init> : (Ljava/lang/String;)V
    //   309: athrow
    //   310: astore_0
    //   311: goto -> 299
    //   314: astore_0
    //   315: goto -> 288
    //   318: astore_0
    //   319: goto -> 80
    //   322: astore_0
    //   323: goto -> 69
    // Exception table:
    //   from	to	target	type
    //   0	13	310	java/lang/NullPointerException
    //   0	13	314	java/lang/NumberFormatException
    //   48	63	318	java/lang/NullPointerException
    //   48	63	322	java/lang/NumberFormatException
  }
  
  private static Object b(XmlPullParser paramXmlPullParser, String[] paramArrayOfString) throws XmlPullParserException, IOException {
    StringBuilder stringBuilder1;
    StringBuilder stringBuilder2;
    Boolean bool;
    StringBuilder stringBuilder3;
    String str1 = null;
    String str2 = paramXmlPullParser.getAttributeValue(null, "name");
    String str3 = paramXmlPullParser.getName();
    if (!str3.equals("null")) {
      if (str3.equals("string")) {
        str1 = "";
        while (true) {
          int i = paramXmlPullParser.next();
          if (i != 1) {
            if (i == 3) {
              if (paramXmlPullParser.getName().equals("string")) {
                paramArrayOfString[0] = str2;
                return str1;
              } 
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("Unexpected end tag in <string>: ");
              stringBuilder.append(paramXmlPullParser.getName());
              throw new XmlPullParserException(stringBuilder.toString());
            } 
            if (i == 4) {
              stringBuilder3 = new StringBuilder();
              stringBuilder3.append(str1);
              stringBuilder3.append(paramXmlPullParser.getText());
              str1 = stringBuilder3.toString();
              continue;
            } 
            if (i != 2)
              continue; 
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Unexpected start tag in <string>: ");
            stringBuilder2.append(paramXmlPullParser.getName());
            throw new XmlPullParserException(stringBuilder2.toString());
          } 
          throw new XmlPullParserException("Unexpected end of document in <string>");
        } 
      } 
      if (stringBuilder3.equals("int")) {
        Integer integer = Integer.valueOf(Integer.parseInt(paramXmlPullParser.getAttributeValue(null, "value")));
      } else if (stringBuilder3.equals("long")) {
        Long long_ = Long.valueOf(paramXmlPullParser.getAttributeValue(null, "value"));
      } else if (stringBuilder3.equals("float")) {
        Float float_ = Float.valueOf(paramXmlPullParser.getAttributeValue(null, "value"));
      } else if (stringBuilder3.equals("double")) {
        Double double_ = Double.valueOf(paramXmlPullParser.getAttributeValue(null, "value"));
      } else if (stringBuilder3.equals("boolean")) {
        bool = Boolean.valueOf(paramXmlPullParser.getAttributeValue(null, "value"));
      } else {
        int[] arrayOfInt;
        HashMap hashMap;
        if (stringBuilder3.equals("int-array")) {
          paramXmlPullParser.next();
          arrayOfInt = a(paramXmlPullParser, "int-array", (String[])stringBuilder2);
          stringBuilder2[0] = (StringBuilder)str2;
          return arrayOfInt;
        } 
        if (stringBuilder3.equals("map")) {
          arrayOfInt.next();
          hashMap = a((XmlPullParser)arrayOfInt, "map", (String[])stringBuilder2);
          stringBuilder2[0] = (StringBuilder)str2;
          return hashMap;
        } 
        if (stringBuilder3.equals("list")) {
          hashMap.next();
          ArrayList arrayList = a((XmlPullParser)hashMap, "list", (String[])stringBuilder2);
          stringBuilder2[0] = (StringBuilder)str2;
          return arrayList;
        } 
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Unknown tag: ");
        stringBuilder1.append((String)stringBuilder3);
        throw new XmlPullParserException(stringBuilder1.toString());
      } 
    } 
    while (true) {
      int i = stringBuilder1.next();
      if (i != 1) {
        if (i == 3) {
          if (stringBuilder1.getName().equals(stringBuilder3)) {
            stringBuilder2[0] = (StringBuilder)str2;
            return bool;
          } 
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append("Unexpected end tag in <");
          stringBuilder2.append((String)stringBuilder3);
          stringBuilder2.append(">: ");
          stringBuilder2.append(stringBuilder1.getName());
          throw new XmlPullParserException(stringBuilder2.toString());
        } 
        if (i != 4) {
          if (i != 2)
            continue; 
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append("Unexpected start tag in <");
          stringBuilder2.append((String)stringBuilder3);
          stringBuilder2.append(">: ");
          stringBuilder2.append(stringBuilder1.getName());
          throw new XmlPullParserException(stringBuilder2.toString());
        } 
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Unexpected text in <");
        stringBuilder2.append((String)stringBuilder3);
        stringBuilder2.append(">: ");
        stringBuilder2.append(stringBuilder1.getName());
        throw new XmlPullParserException(stringBuilder2.toString());
      } 
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Unexpected end of document in <");
      stringBuilder1.append((String)stringBuilder3);
      stringBuilder1.append(">");
      throw new XmlPullParserException(stringBuilder1.toString());
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\t\\utdid2\b\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */