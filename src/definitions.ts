declare module "@capacitor/core"{
  interface pluginRegistry{
    JitsiPlugin: JitsiPluginPlugin
  }
}


export interface JitsiPluginPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  testPluginMethod(options: {msg: string}): Promise <{value: string}>;
}
