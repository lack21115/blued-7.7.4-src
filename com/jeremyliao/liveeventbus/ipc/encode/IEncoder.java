package com.jeremyliao.liveeventbus.ipc.encode;

import android.content.Intent;

public interface IEncoder {
  void encode(Intent paramIntent, Object paramObject) throws EncodeException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\jeremyliao\liveeventbus\ipc\encode\IEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */