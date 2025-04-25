import { WebPlugin } from '@capacitor/core';

import type { JitsiPluginPlugin } from './definitions';

export class JitsiPluginWeb extends WebPlugin implements JitsiPluginPlugin {
  createRoom(): Promise<{ meetingId: string; }> {
    throw new Error('Method not implemented.');
  }
  createMeetingId(): Promise<{ meetingId: string; }> {
    throw new Error('Method not implemented.');
  }
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }

  async testPluginMethod(options: { msg: string }): Promise<{ value: string }> {
    alert(options.msg);
    return { value: options.msg };
  }

  async joinCall(options: {meetingId: string, userName: string}): Promise<void> {
    alert(`joinCall is not implemented on web. Room: ${options.meetingId}`);
  }

  async startCall(): Promise<{ room: string }> {
    const generatedRoom = 'web-room-' + Math.random().toString(36).substring(2, 10);
    alert(`startCall is not implemented on web. Room: ${generatedRoom}`);
    return { room: generatedRoom };
  }
}

