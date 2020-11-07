<template>
    <Page>
        <div>Параметры фрейма (params): {{ JSON.stringify(params) }}</div>
    </Page>
</template>

<script>
import {apx} from '../vendor'

export default {
    extends: apx.JcFrame,
    created() {
        this.title = 'Показ фрейма с параметрами'
    },
    initFrame() {
    },
    data() {
        return {}
    },
    methods: {},
}
</script>
