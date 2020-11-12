<template>
    <Page body-fit body-class="bg-warning-300">

        <div class="col row bg-primary-300">

            <q-card class="col q-mr-md">
                <q-card-section>
                    В атрибутах Page ставим body-fit, в первый
                    компонент, который собственно растягиваем,
                    ставим class="col"
                </q-card-section>
            </q-card>

            <q-card class="col-3">
                <q-card-section>
                    Card2
                </q-card-section>
            </q-card>

        </div>

    </Page>
</template>

<script>
import {apx} from '../../vendor'

export default {
    extends: apx.JcFrame,
    created() {
        this.title = 'Растягивание тела фрейма'
    },
}
</script>
