export interface JitsiPluginPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
