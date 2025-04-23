import { registerPlugin } from '@capacitor/core';

import type { JitsiPluginPlugin } from './definitions';

const JitsiPlugin = registerPlugin<JitsiPluginPlugin>('JitsiPlugin', {
  web: () => import('./web').then((m) => new m.JitsiPluginWeb()),
});

export * from './definitions';
export { JitsiPlugin };
