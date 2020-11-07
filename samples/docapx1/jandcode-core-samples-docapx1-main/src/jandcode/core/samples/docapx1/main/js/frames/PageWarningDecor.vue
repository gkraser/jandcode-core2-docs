<template>
    <PageWarning>
        Что то пошло не так. Наверное..
    </PageWarning>
</template>

<script>
import {apx} from '../vendor'

export default {
    extends: apx.JcFrame,
    created() {
        this.title = 'Внимание'
    },
    initFrame() {
    },
    data() {
        return {}
    },
    methods: {},
}
</script>
