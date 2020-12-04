<template>
    <Page>
        <div class="row q-px-md">
            <jc-btn label="Обработка ok/cancel" @click="simpleOkCancel"/>
        </div>
    </Page>
</template>

<script>
import {apx} from '../vendor'
import DemoDialog1 from './_components/DemoDialog1'

export default {
    extends: apx.JcFrame,
    created() {
        this.title = 'Показ диалогов'
    },
    initFrame() {
    },
    data() {
        return {}
    },
    methods: {

        simpleOkCancel() {
            apx.showDialog({
                frame: DemoDialog1,
                onOk: async function(frameInst) {
                    let res

                    res = await apx.dao('docapx1/api').invoke("dummy/curTime", 100)
                    console.info("res-1", res);

                    res = await apx.dao('docapx1/api').invoke("dummy/curTime", 100)
                    console.info("res-2", res);

                    res = await apx.dao('docapx1/api').invoke("dummy/curTime", 100)
                    console.info("res-3", res);

                    await apx.showError("Нажата ok, а ок нажимать нельзя")

                    return false
                },
                onCancel: function(frameInst) {
                    apx.showMsg("Нажата cancel, ее можно нажимать, окно закрыто")
                },
            })
        }

    },
}
</script>
