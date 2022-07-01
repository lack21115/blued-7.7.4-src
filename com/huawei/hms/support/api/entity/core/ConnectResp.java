package com.huawei.hms.support.api.entity.core;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ConnectResp implements IMessageEntity {
  @Packed
  public List<Integer> protocolVersion = Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2) });
  
  @Packed
  public String sessionId;
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("protocol version:");
    Iterator<Integer> iterator = this.protocolVersion.iterator();
    while (iterator.hasNext()) {
      stringBuilder.append(iterator.next());
      stringBuilder.append(',');
    } 
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\entity\core\ConnectResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */