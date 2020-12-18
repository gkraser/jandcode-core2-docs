<template>
    <Page body-fit>
        <div class="col row bg-primary-100">
            <div class="col" ref="map"></div>
            <!-- следим за размером контейнера и перерисовываем карту: -->
            <q-resize-observer @resize="onResize"/>
        </div>
    </Page>
</template>

<script>
import {apx} from '../../vendor'

// подключаем OpenLayers
import ol from '../../vendor/ol'

export default {
    extends: apx.JcFrame,
    created() {
        this.title = 'OpenLayers'
    },
    frameInit() {
    },
    mounted() {
        this.map = new ol.Map({
            target: this.$refs.map,
            layers: [
                new ol.layer.Tile({
                    source: new ol.source.OSM()
                })
            ],
            view: new ol.View({
                center: ol.proj.fromLonLat([68.4, 46.9]),
                zoom: 4
            })
        });
    },
    methods: {
        onResize(ev) {
            if (this.map) {
                this.map.updateSize()
            }
        }
    }
}
</script>
