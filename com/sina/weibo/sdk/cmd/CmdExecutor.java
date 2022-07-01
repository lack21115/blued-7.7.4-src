package com.sina.weibo.sdk.cmd;

interface CmdExecutor<T extends BaseCmd> {
  boolean doExecutor(T paramT);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\cmd\CmdExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */