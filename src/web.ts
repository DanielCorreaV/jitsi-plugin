import { WebPlugin } from '@capacitor/core';

import type { JitsiPluginPlugin } from './definitions';

export class JitsiPluginWeb extends WebPlugin implements JitsiPluginPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }

  async testPluginMethod(options: { msg: string }): Promise<{ value: string }> {
    alert(options.msg);
    return { value: options.msg };
  }

  async joinCall(options: { room: string }): Promise<void> {
    alert(`joinCall is not implemented on web. Room: ${options.room}`);
  }

  async startCall(): Promise<{ room: string }> {
    const generatedRoom = 'web-room-' + Math.random().toString(36).substring(2, 10);
    alert(`startCall is not implemented on web. Room: ${generatedRoom}`);
    return { room: generatedRoom };
  }
}

