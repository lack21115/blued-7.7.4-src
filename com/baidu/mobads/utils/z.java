package com.baidu.mobads.utils;

import android.telephony.CellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.baidu.mobads.openad.e.e;

class z extends e.b {
  z(t paramt, CellLocation paramCellLocation) {}
  
  public Object a() {
    try {
      Object<String[]> object = (Object<String[]>)XAdSDKFoundationFacade.getInstance().getCommonUtils().a("cell");
    } finally {
      Exception exception = null;
    } 
    try {
      if (this.a != null) {
        String[] arrayOfString = new String[3];
        boolean bool = this.a instanceof GsmCellLocation;
        if (bool) {
          GsmCellLocation gsmCellLocation = (GsmCellLocation)this.a;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(gsmCellLocation.getCid());
          stringBuilder.append("");
          arrayOfString[0] = stringBuilder.toString();
          stringBuilder = new StringBuilder();
          stringBuilder.append(gsmCellLocation.getLac());
          stringBuilder.append("");
          arrayOfString[1] = stringBuilder.toString();
          arrayOfString[2] = "0";
        } else {
          String[] arrayOfString1 = this.a.toString().replace("[", "").replace("]", "").split(",");
          arrayOfString[0] = arrayOfString1[0];
          arrayOfString[1] = arrayOfString1[3];
          arrayOfString[2] = arrayOfString1[4];
        } 
        t.a.add(arrayOfString);
      } 
      XAdSDKFoundationFacade.getInstance().getCommonUtils().a("cell", t.a);
    } finally {
      Exception exception;
    } 
    return t.a;
  }
  
  public void a(Object paramObject) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobad\\utils\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */