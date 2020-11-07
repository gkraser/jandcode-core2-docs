<template>
    <MyFrameDecor>
        Текст
    </MyFrameDecor>
</template>

<script>
import {apx} from '../vendor'
import MyFrameDecor from './_components/MyFrameDecor'

export default {
    extends: apx.JcFrame,
    components: {
        MyFrameDecor
    },
    props: {},
    created() {
        this.title = 'Заголовок фрейма'
    },
    initFrame() {
    },
    data() {
        return {}
    },
    methods: {},
}
</script>
