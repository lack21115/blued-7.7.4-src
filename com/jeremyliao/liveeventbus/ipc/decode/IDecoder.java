package com.jeremyliao.liveeventbus.ipc.decode;

import android.content.Intent;

public interface IDecoder {
  Object decode(Intent paramIntent) throws DecodeException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\jeremyliao\liveeventbus\ipc\decode\IDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */