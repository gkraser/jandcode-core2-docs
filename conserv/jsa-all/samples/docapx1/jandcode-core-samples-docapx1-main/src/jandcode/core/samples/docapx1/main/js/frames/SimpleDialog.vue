<template>
    <Dialog>
        <template #toolbar>
            <jc-action icon="mail"/>
            <jc-action icon="calendar"/>
        </template>
        Диалог
    </Dialog>
</template>

<script>
import {apx} from '../vendor'

export default {
    extends: apx.JcFrame,
    created() {
        this.title = 'Простой диалог'
        this.icon = 'frame'
    },
}
</script>
