<template>
    <Dialog>
        <div v-for="i in 10">
            Немного текста {{ i }}
        </div>
    </Dialog>
</template>

<script>
import {apx} from './vendor'

export default {
    extends: apx.JcFrame,
    created() {
        this.title = 'DemoDialog'
    },
    initFrame() {
    },
    data() {
        return {}
    },
    methods: {},
}
</script>
