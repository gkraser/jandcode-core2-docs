<template>
    <div>
        Диалог
    </div>
</template>

<script>
import {apx} from '../vendor'

export default {
    extends: apx.JcFrame,
    props: {},
    created() {
        this.title = 'Пустой диалог'
    },
    frameInit() {
    },
    data() {
        return {}
    },
    methods: {},
}
</script>
