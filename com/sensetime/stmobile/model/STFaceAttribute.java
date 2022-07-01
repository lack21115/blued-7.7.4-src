package com.sensetime.stmobile.model;

public class STFaceAttribute {
  public Attribute[] arrayAttribute;
  
  public int attribute_count;
  
  public static String getFaceAttributeString(STFaceAttribute paramSTFaceAttribute) {
    String str3 = null;
    int i = 0;
    String str2 = "";
    String str1 = "男";
    while (true) {
      Attribute[] arrayOfAttribute = paramSTFaceAttribute.arrayAttribute;
      if (i < arrayOfAttribute.length) {
        if ((arrayOfAttribute[i]).category.equals("attractive"))
          str3 = (paramSTFaceAttribute.arrayAttribute[i]).label; 
        if ((paramSTFaceAttribute.arrayAttribute[i]).category.equals("gender"))
          if ((paramSTFaceAttribute.arrayAttribute[i]).label.equals("male")) {
            str1 = "男";
          } else {
            str1 = "女";
          }  
        if ((paramSTFaceAttribute.arrayAttribute[i]).category.equals("age"))
          str2 = (paramSTFaceAttribute.arrayAttribute[i]).label; 
        i++;
        continue;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("颜值:");
      stringBuilder.append(str3);
      stringBuilder.append("  性别:");
      stringBuilder.append(str1);
      stringBuilder.append("  年龄:");
      stringBuilder.append(str2);
      return stringBuilder.toString();
    } 
  }
  
  public static class Attribute {
    public String category;
    
    public String label;
    
    public float score;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sensetime\stmobile\model\STFaceAttribute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */