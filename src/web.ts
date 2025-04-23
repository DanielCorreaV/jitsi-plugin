import { WebPlugin } from '@capacitor/core';

import type { JitsiPluginPlugin } from './definitions';

export class JitsiPluginWeb extends WebPlugin implements JitsiPluginPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }

  async testPluginMethod(options: {msg: string}): Promise <{value: string}>{
    alert(options.msg);
    return {value: options.msg};
  }
}
