package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.NotFoundException;

final class FieldParser {
  private static final Object a = new Object();
  
  private static final Object[][] b;
  
  private static final Object[][] c;
  
  private static final Object[][] d;
  
  private static final Object[][] e;
  
  static {
    Integer integer2 = Integer.valueOf(18);
    Object[] arrayOfObject4 = { "00", integer2 };
    Object[] arrayOfObject5 = { "01", Integer.valueOf(14) };
    Object[] arrayOfObject6 = { "02", Integer.valueOf(14) };
    Integer integer4 = Integer.valueOf(3);
    Object object1 = a;
    Integer integer3 = Integer.valueOf(20);
    Object[] arrayOfObject7 = { "10", object1, integer3 };
    Integer integer1 = Integer.valueOf(6);
    Object[] arrayOfObject8 = { "11", integer1 };
    Object[] arrayOfObject9 = { "12", integer1 };
    Object[] arrayOfObject10 = { "13", integer1 };
    Object[] arrayOfObject11 = { "15", integer1 };
    Object[] arrayOfObject12 = { "17", integer1 };
    Object[] arrayOfObject13 = { "20", Integer.valueOf(2) };
    Object[] arrayOfObject14 = { "21", a, integer3 };
    Object[] arrayOfObject15 = { "22", a, Integer.valueOf(29) };
    Object[] arrayOfObject16 = { "30", a, Integer.valueOf(8) };
    Object object3 = a;
    object1 = Integer.valueOf(13);
    Object[] arrayOfObject17 = { "37", object3, Integer.valueOf(8) };
    Object object4 = a;
    object3 = Integer.valueOf(30);
    Object[] arrayOfObject18 = { "90", object4, object3 };
    Object object7 = a;
    object4 = Integer.valueOf(15);
    b = new Object[][] { 
        arrayOfObject4, arrayOfObject5, arrayOfObject6, arrayOfObject7, arrayOfObject8, arrayOfObject9, arrayOfObject10, arrayOfObject11, arrayOfObject12, arrayOfObject13, 
        arrayOfObject14, arrayOfObject15, arrayOfObject16, arrayOfObject17, arrayOfObject18, { "91", object7, object3 }, { "92", a, object3 }, { "93", a, object3 }, { "94", a, object3 }, { "95", a, object3 }, 
        { "96", a, object3 }, { "97", a, object3 }, { "98", a, object3 }, { "99", a, object3 } };
    arrayOfObject5 = new Object[] { "240", a, object3 };
    Object object6 = a;
    arrayOfObject6 = new Object[] { "242", a, integer1 };
    arrayOfObject7 = new Object[] { "250", a, object3 };
    arrayOfObject8 = new Object[] { "251", a, object3 };
    arrayOfObject9 = new Object[] { "253", a, Integer.valueOf(17) };
    arrayOfObject10 = new Object[] { "254", a, integer3 };
    arrayOfObject11 = new Object[] { "400", a, object3 };
    arrayOfObject12 = new Object[] { "401", a, object3 };
    arrayOfObject13 = new Object[] { "402", Integer.valueOf(17) };
    arrayOfObject14 = new Object[] { "403", a, object3 };
    arrayOfObject15 = new Object[] { "410", object1 };
    arrayOfObject16 = new Object[] { "411", object1 };
    arrayOfObject17 = new Object[] { "413", object1 };
    object7 = new Object[] { "414", object1 };
    arrayOfObject18 = new Object[] { "420", a, integer3 };
    Object[] arrayOfObject19 = { "421", a, object4 };
    Object[] arrayOfObject20 = { "422", integer4 };
    Object[] arrayOfObject21 = { "423", a, object4 };
    Object[] arrayOfObject22 = { "424", integer4 };
    Object[] arrayOfObject23 = { "425", integer4 };
    Object[] arrayOfObject3 = { "426", integer4 };
    c = new Object[][] { 
        arrayOfObject5, { "241", object6, object3 }, arrayOfObject6, arrayOfObject7, arrayOfObject8, arrayOfObject9, arrayOfObject10, arrayOfObject11, arrayOfObject12, arrayOfObject13, 
        arrayOfObject14, arrayOfObject15, arrayOfObject16, { "412", object1 }, arrayOfObject17, (Object[])object7, arrayOfObject18, arrayOfObject19, arrayOfObject20, arrayOfObject21, 
        arrayOfObject22, arrayOfObject23, arrayOfObject3 };
    arrayOfObject5 = new Object[] { "311", integer1 };
    arrayOfObject6 = new Object[] { "312", integer1 };
    arrayOfObject7 = new Object[] { "313", integer1 };
    arrayOfObject8 = new Object[] { "315", integer1 };
    arrayOfObject9 = new Object[] { "320", integer1 };
    arrayOfObject10 = new Object[] { "322", integer1 };
    arrayOfObject11 = new Object[] { "324", integer1 };
    arrayOfObject12 = new Object[] { "328", integer1 };
    arrayOfObject13 = new Object[] { "329", integer1 };
    arrayOfObject14 = new Object[] { "330", integer1 };
    arrayOfObject15 = new Object[] { "331", integer1 };
    arrayOfObject16 = new Object[] { "335", integer1 };
    arrayOfObject17 = new Object[] { "340", integer1 };
    object7 = new Object[] { "341", integer1 };
    arrayOfObject18 = new Object[] { "342", integer1 };
    arrayOfObject19 = new Object[] { "344", integer1 };
    arrayOfObject20 = new Object[] { "345", integer1 };
    arrayOfObject21 = new Object[] { "351", integer1 };
    arrayOfObject22 = new Object[] { "352", integer1 };
    arrayOfObject23 = new Object[] { "354", integer1 };
    Object[] arrayOfObject24 = { "355", integer1 };
    Object[] arrayOfObject25 = { "356", integer1 };
    Object[] arrayOfObject26 = { "357", integer1 };
    Object[] arrayOfObject27 = { "360", integer1 };
    Object[] arrayOfObject28 = { "364", integer1 };
    Object[] arrayOfObject29 = { "367", integer1 };
    Object[] arrayOfObject30 = { "390", a, object4 };
    Object[] arrayOfObject31 = { "391", a, integer2 };
    Object object5 = a;
    Object[] arrayOfObject32 = { "393", a, integer2 };
    object6 = a;
    d = new Object[][] { 
        { "310", integer1 }, arrayOfObject5, arrayOfObject6, arrayOfObject7, { "314", integer1 }, arrayOfObject8, { "316", integer1 }, arrayOfObject9, { "321", integer1 }, arrayOfObject10, 
        { "323", integer1 }, arrayOfObject11, { "325", integer1 }, { "326", integer1 }, { "327", integer1 }, arrayOfObject12, arrayOfObject13, arrayOfObject14, arrayOfObject15, { "332", integer1 }, 
        { "333", integer1 }, { "334", integer1 }, arrayOfObject16, { "336", integer1 }, arrayOfObject17, (Object[])object7, arrayOfObject18, { "343", integer1 }, arrayOfObject19, arrayOfObject20, 
        { "346", integer1 }, { "347", integer1 }, { "348", integer1 }, { "349", integer1 }, { "350", integer1 }, arrayOfObject21, arrayOfObject22, { "353", integer1 }, arrayOfObject23, arrayOfObject24, 
        arrayOfObject25, arrayOfObject26, arrayOfObject27, { "361", integer1 }, { "362", integer1 }, { "363", integer1 }, arrayOfObject28, { "365", integer1 }, { "366", integer1 }, arrayOfObject29, 
        { "368", integer1 }, { "369", integer1 }, arrayOfObject30, arrayOfObject31, { "392", object5, object4 }, arrayOfObject32, { "703", object6, object3 } };
    object4 = new Object[] { "7002", a, object3 };
    object5 = new Object[] { "8001", Integer.valueOf(14) };
    Object[] arrayOfObject2 = { "8002", a, integer3 };
    object6 = new Object[] { "8003", a, object3 };
    arrayOfObject5 = new Object[] { "8004", a, object3 };
    arrayOfObject6 = new Object[] { "8005", integer1 };
    arrayOfObject7 = new Object[] { "8006", integer2 };
    object3 = new Object[] { "8007", a, object3 };
    arrayOfObject8 = new Object[] { "8008", a, Integer.valueOf(12) };
    arrayOfObject9 = new Object[] { "8018", integer2 };
    Object object2 = a;
    Object[] arrayOfObject1 = { "8100", integer1 };
    arrayOfObject10 = new Object[] { "8101", Integer.valueOf(10) };
    arrayOfObject11 = new Object[] { "8102", Integer.valueOf(2) };
    arrayOfObject12 = new Object[] { "8110", a, Integer.valueOf(70) };
    arrayOfObject13 = new Object[] { "8200", a, Integer.valueOf(70) };
    e = new Object[][] { 
        { "7001", object1 }, (Object[])object4, { "7003", Integer.valueOf(10) }, (Object[])object5, arrayOfObject2, (Object[])object6, arrayOfObject5, arrayOfObject6, arrayOfObject7, (Object[])object3, 
        arrayOfObject8, arrayOfObject9, { "8020", object2, Integer.valueOf(25) }, arrayOfObject1, arrayOfObject10, arrayOfObject11, arrayOfObject12, arrayOfObject13 };
  }
  
  private static String a(int paramInt1, int paramInt2, String paramString) throws NotFoundException {
    if (paramString.length() >= paramInt1) {
      String str = paramString.substring(0, paramInt1);
      int i = paramString.length();
      paramInt2 += paramInt1;
      if (i >= paramInt2) {
        String str1 = paramString.substring(paramInt1, paramInt2);
        paramString = paramString.substring(paramInt2);
        StringBuilder stringBuilder2 = new StringBuilder("(");
        stringBuilder2.append(str);
        stringBuilder2.append(')');
        stringBuilder2.append(str1);
        str = stringBuilder2.toString();
        paramString = a(paramString);
        if (paramString == null)
          return str; 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str);
        stringBuilder1.append(paramString);
        return stringBuilder1.toString();
      } 
      throw NotFoundException.a();
    } 
    throw NotFoundException.a();
  }
  
  static String a(String paramString) throws NotFoundException {
    if (paramString.isEmpty())
      return null; 
    if (paramString.length() >= 2) {
      String str = paramString.substring(0, 2);
      for (Object[] arrayOfObject : b) {
        if (arrayOfObject[0].equals(str))
          return (arrayOfObject[1] == a) ? b(2, ((Integer)arrayOfObject[2]).intValue(), paramString) : a(2, ((Integer)arrayOfObject[1]).intValue(), paramString); 
      } 
      if (paramString.length() >= 3) {
        str = paramString.substring(0, 3);
        for (Object[] arrayOfObject : c) {
          if (arrayOfObject[0].equals(str))
            return (arrayOfObject[1] == a) ? b(3, ((Integer)arrayOfObject[2]).intValue(), paramString) : a(3, ((Integer)arrayOfObject[1]).intValue(), paramString); 
        } 
        for (Object[] arrayOfObject : d) {
          if (arrayOfObject[0].equals(str))
            return (arrayOfObject[1] == a) ? b(4, ((Integer)arrayOfObject[2]).intValue(), paramString) : a(4, ((Integer)arrayOfObject[1]).intValue(), paramString); 
        } 
        if (paramString.length() >= 4) {
          str = paramString.substring(0, 4);
          for (Object[] arrayOfObject : e) {
            if (arrayOfObject[0].equals(str))
              return (arrayOfObject[1] == a) ? b(4, ((Integer)arrayOfObject[2]).intValue(), paramString) : a(4, ((Integer)arrayOfObject[1]).intValue(), paramString); 
          } 
          throw NotFoundException.a();
        } 
        throw NotFoundException.a();
      } 
      throw NotFoundException.a();
    } 
    throw NotFoundException.a();
  }
  
  private static String b(int paramInt1, int paramInt2, String paramString) throws NotFoundException {
    String str1 = paramString.substring(0, paramInt1);
    int j = paramString.length();
    int i = paramInt2 + paramInt1;
    paramInt2 = i;
    if (j < i)
      paramInt2 = paramString.length(); 
    String str2 = paramString.substring(paramInt1, paramInt2);
    paramString = paramString.substring(paramInt2);
    StringBuilder stringBuilder2 = new StringBuilder("(");
    stringBuilder2.append(str1);
    stringBuilder2.append(')');
    stringBuilder2.append(str2);
    str1 = stringBuilder2.toString();
    paramString = a(paramString);
    if (paramString == null)
      return str1; 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(str1);
    stringBuilder1.append(paramString);
    return stringBuilder1.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\FieldParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */