<template>
    <Page>
        <div class="col q-col-gutter-md">
            <div>Параметры фрейма (params): {{ JSON.stringify(params) }}</div>
            <template v-if="frameWrapper.routeInfo">
                <div v-if="!frameWrapper.routeInfo.pageHash">
                    Сейчас в адресной строке параметры, которые были получены из
                    вызова showFrame(). Туда попали только простые параметры.
                </div>
                <div>
                    Измените параметры (можете добавить) в адресной строке и нажмите
                    Enter.
                    Или просто обновите страницу.
                    Фрейм получит только те параметры, которые в адресной строке.
                </div>
                <div>
                    routeInfo: {{ JSON.stringify(frameWrapper.routeInfo) }}
                </div>
            </template>
        </div>
    </Page>
</template>

<script>
import {apx} from '../vendor'

export default {
    extends: apx.JcFrame,
    created() {
        this.title = 'Показ фрейма с параметрами'
        if (this.frameWrapper.routeInfo && this.frameWrapper.routeInfo.pageHash) {
            this.title = this.title + " (route, from address bar)"
        }
    },
    initFrame() {
    },
    data() {
        return {}
    },
    methods: {},
}
</script>
