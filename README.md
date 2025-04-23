# jitsi-plugin

plugin for jitcall

## Install

```bash
npm install jitsi-plugin
npx cap sync
```

## API

<docgen-index>

* [`echo(...)`](#echo)
* [`testPluginMethod(...)`](#testpluginmethod)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### echo(...)

```typescript
echo(options: { value: string; }) => Promise<{ value: string; }>
```

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ value: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### testPluginMethod(...)

```typescript
testPluginMethod(options: { msg: string; }) => Promise<{ value: string; }>
```

| Param         | Type                          |
| ------------- | ----------------------------- |
| **`options`** | <code>{ msg: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------

</docgen-api>
