package com.baidu.mobad.video;

import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdProd;
import com.baidu.mobads.interfaces.IXLinearAdSlot;
import java.util.ArrayList;
import java.util.HashMap;

public class XAdSlotManager {
  private HashMap<String, IXAdProd> a = new HashMap<String, IXAdProd>();
  
  public void addAdSlot(IXAdProd paramIXAdProd) {
    this.a.put(paramIXAdProd.getId(), paramIXAdProd);
  }
  
  public Boolean containsAdSlot(String paramString) {
    return Boolean.valueOf(this.a.containsKey(paramString));
  }
  
  public IXAdProd retrieve1stAdSlotByType(IXAdConstants4PDK.SlotType paramSlotType) {
    ArrayList<IXAdProd> arrayList = retrieveAdSlotsByType(paramSlotType);
    return (arrayList.size() > 0) ? arrayList.get(0) : null;
  }
  
  public IXAdProd retrieveAdSlotById(String paramString) {
    return this.a.get(paramString);
  }
  
  public ArrayList<IXAdProd> retrieveAdSlotsByType(IXAdConstants4PDK.SlotType paramSlotType) {
    ArrayList<IXAdProd> arrayList = new ArrayList();
    for (IXAdProd iXAdProd : this.a.keySet()) {
      iXAdProd = this.a.get(iXAdProd);
      if (iXAdProd.getType() == paramSlotType)
        arrayList.add(iXAdProd); 
    } 
    return arrayList;
  }
  
  public IXAdProd retrievePauseAdSlot() {
    return retrieve1stAdSlotByType(IXAdConstants4PDK.SlotType.SLOT_TYPE_PAUSE_ROLL);
  }
  
  public IXLinearAdSlot retrievePostAdSlot() {
    return (IXLinearAdSlot)retrieve1stAdSlotByType(IXAdConstants4PDK.SlotType.SLOT_TYPE_POSTROLL);
  }
  
  public IXLinearAdSlot retrievePrerollAdSlot() {
    return (IXLinearAdSlot)retrieve1stAdSlotByType(IXAdConstants4PDK.SlotType.SLOT_TYPE_PREROLL);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobad\video\XAdSlotManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */