package com.amap.api.services.interfaces;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.help.Inputtips;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.help.Tip;
import java.util.ArrayList;

public interface IInputtipsSearch {
  InputtipsQuery getQuery();
  
  ArrayList<Tip> requestInputtips() throws AMapException;
  
  void requestInputtips(String paramString1, String paramString2) throws AMapException;
  
  void requestInputtips(String paramString1, String paramString2, String paramString3) throws AMapException;
  
  void requestInputtipsAsyn();
  
  void setInputtipsListener(Inputtips.InputtipsListener paramInputtipsListener);
  
  void setQuery(InputtipsQuery paramInputtipsQuery);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\interfaces\IInputtipsSearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */