<template>
    <App>
        <template #toolbar-right>
            <jc-toolbar>
            </jc-toolbar>
        </template>

        <template #left>
            <q-item-label header>
                Меню
            </q-item-label>
            <jc-side-menu>
                <jc-side-menu-item label="Фреймы" icon="frame" opened>
                    <jc-side-menu-item label="Пустой фрейм" icon="frame"
                                       @click="sf('EmptyPage')"/>
                    <jc-side-menu-item label="Пустой диалог" icon="frame"
                                       @click="sd('EmptyDialog')"/>
                    <jc-side-menu-item label="Простая страница" icon="frame"
                                       @click="sf('SimplePage')"/>
                    <jc-side-menu-item label="Простой диалог" icon="frame"
                                       @click="sd('SimpleDialog')"/>
                    <jc-side-menu-item label="Собственный декоратор" icon="frame"
                                       @click="sf('MyDecor')"/>
                    <jc-side-menu-item label="Собственный глобальный декоратор"
                                       icon="frame"
                                       @click="sf('PageWarningDecor')"/>
                    <jc-side-menu-item label="Показ фрейма с параметрами (Promise)"
                                       icon="frame"
                                       @click="promiseShowFrame1()"/>
                    <jc-side-menu-item label="Показ фрейма с параметрами (async)"
                                       icon="frame"
                                       @click="asyncShowFrame1()"/>
                    <jc-side-menu-item label="Показ фрейма с параметрами (route)"
                                       icon="frame"
                                       @click="routeShowFrame1()"/>
                    <jc-side-menu-item label="Показ диалога" icon="frame"
                                       @click="sr('/frames/dialog1')"/>
                </jc-side-menu-item>
                <jc-side-menu-item label="Примеры" icon="frame">
                    <jc-side-menu-item label="OpenLayers" icon="frame"
                                       @click="sr('/examples/openLayers')"/>
                    <jc-side-menu-item label="Растягиевание тела фрейма" icon="frame"
                                       @click="sr('/examples/bodyFit')"/>
                </jc-side-menu-item>
            </jc-side-menu>
        </template>

    </App>
</template>

<script>
import {apx} from './vendor'

/**
 * Базовый путь каталога с фреймами
 */
let baseFramePath = "jandcode/core/samples/docapx1/main/js/frames/"

export default {
    extends: apx.JcApp,
    components: {},
    created() {
        this.title = 'Docapx1'
        this.left = true
    },
    data() {
        return {}
    },
    methods: {

        /**
         * Показ фрейма showFrame
         * @param shortName короткое имя без расширения, относительно каталога с фреймами
         * @param params параметры. Могут отсутствовать
         */
        sf(shortName, params) {
            apx.showFrame({
                frame: baseFramePath + shortName + ".vue",
                params: params
            })
        },

        /**
         * Показ диалого showDialog
         * @param shortName короткое имя без расширения, относительно каталога с фреймами
         * @param params параметры. Могут отсутствовать
         */
        sd(shortName, params) {
            apx.showDialog({
                frame: baseFramePath + shortName + ".vue",
                params: params
            })
        },

        /**
         * Показ фрейма через путь в роутинге.
         * @param routePath путь, который распознается роутингом.
         * @param params параметры. Могут отсутствовать
         */
        sr(routePath, params) {
            apx.showFrame({
                frame: routePath,
                params: params
            })
        },

        promiseShowFrame1() {
            //= promiseShowFrame1
            apx.showFrame({
                frame: baseFramePath + "ShowFrameWithParams.vue",
                params: {
                    internal: {
                        param2: 1
                    },
                    param1: 'promise'
                }
            }).then(function(frameInst) {
                frameInst.title = frameInst.title + " (promise)"
            })
            //=
        },

        async asyncShowFrame1() {
            //= asyncShowFrame1
            let frameInst = await apx.showFrame({
                frame: baseFramePath + "ShowFrameWithParams.vue",
                params: {
                    internal: {
                        param2: 1
                    },
                    param1: 'async'
                }
            })
            frameInst.title = frameInst.title + " (async)"
            //=
        },

        async routeShowFrame1() {
            //= routeShowFrame1
            let frameInst = await apx.showFrame({
                frame: '/frames/withparams/123/infocode',
                params: {
                    internal: {
                        param2: 1
                    },
                    param1: 'route',
                    param2: 2
                }
            })
            frameInst.title = frameInst.title + " (route, from action)"
            //=
        }
    }
}
</script>

