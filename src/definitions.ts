declare module "@capacitor/core"{
  interface pluginRegistry{
    JitsiPlugin: JitsiPluginPlugin
  }
}


export interface JitsiPluginPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  testPluginMethod(options: { msg: string }): Promise<{ value: string }>;
  
  joinCall(options: { meetingId: string, userName: string }): Promise<void>;
  startCall(): Promise<{ room: string }>;
  createRoom(): Promise<{ meetingId: string }>;
}
