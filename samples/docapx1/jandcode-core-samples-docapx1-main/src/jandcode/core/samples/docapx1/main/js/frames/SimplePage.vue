<template>
    <Page>
        <template #toolbar>
            <jc-action icon="mail"/>
            <jc-action icon="calendar"/>
        </template>
        Страница
    </Page>
</template>

<script>
import {apx} from '../vendor'

export default {
    extends: apx.JcFrame,
    created() {
        this.title = 'Простая страница'
        this.title2 = 'Есть мелкий заголовок'
        this.icon = 'frame'
    },
}
</script>
