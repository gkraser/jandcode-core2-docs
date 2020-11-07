<template>
    <div class="jc-frame jc-decor-page">

        <div class="q-pa-md text-warning-100 bg-warning">
            <div class="text-size-xl">{{ own.title }}</div>
        </div>

        <div class="jc-frame--body" :class="bodyClass" :style="bodyStyle">
            <slot name="default">
            </slot>
        </div>
    </div>
</template>

<script>
import {apx} from '../vendor'

export default {
    extends: apx.JcDecorFrame,
}
</script>
