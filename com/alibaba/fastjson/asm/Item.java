package com.alibaba.fastjson.asm;

final class Item {
  int hashCode;
  
  int index;
  
  int intVal;
  
  long longVal;
  
  Item next;
  
  String strVal1;
  
  String strVal2;
  
  String strVal3;
  
  int type;
  
  Item() {}
  
  Item(int paramInt, Item paramItem) {
    this.index = paramInt;
    this.type = paramItem.type;
    this.intVal = paramItem.intVal;
    this.longVal = paramItem.longVal;
    this.strVal1 = paramItem.strVal1;
    this.strVal2 = paramItem.strVal2;
    this.strVal3 = paramItem.strVal3;
    this.hashCode = paramItem.hashCode;
  }
  
  boolean isEqualTo(Item paramItem) {
    int i = this.type;
    if (i != 1)
      if (i != 15) {
        if (i != 12) {
          if (i != 13)
            switch (i) {
              default:
                return (paramItem.strVal1.equals(this.strVal1) && paramItem.strVal2.equals(this.strVal2) && paramItem.strVal3.equals(this.strVal3));
              case 3:
              case 4:
                return (paramItem.intVal == this.intVal);
              case 5:
              case 6:
                return (paramItem.longVal == this.longVal);
              case 7:
              case 8:
                break;
            }  
        } else {
          return (paramItem.strVal1.equals(this.strVal1) && paramItem.strVal2.equals(this.strVal2));
        } 
        return paramItem.strVal1.equals(this.strVal1);
      }  
    return paramItem.strVal1.equals(this.strVal1);
  }
  
  void set(int paramInt) {
    this.type = 3;
    this.intVal = paramInt;
    this.hashCode = Integer.MAX_VALUE & this.type + paramInt;
  }
  
  void set(int paramInt, String paramString1, String paramString2, String paramString3) {
    this.type = paramInt;
    this.strVal1 = paramString1;
    this.strVal2 = paramString2;
    this.strVal3 = paramString3;
    if (paramInt != 1 && paramInt != 7 && paramInt != 8)
      if (paramInt != 12) {
        if (paramInt != 13) {
          this.hashCode = paramInt + paramString1.hashCode() * paramString2.hashCode() * paramString3.hashCode() & Integer.MAX_VALUE;
          return;
        } 
      } else {
        this.hashCode = paramInt + paramString1.hashCode() * paramString2.hashCode() & Integer.MAX_VALUE;
        return;
      }  
    this.hashCode = paramInt + paramString1.hashCode() & Integer.MAX_VALUE;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\asm\Item.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */