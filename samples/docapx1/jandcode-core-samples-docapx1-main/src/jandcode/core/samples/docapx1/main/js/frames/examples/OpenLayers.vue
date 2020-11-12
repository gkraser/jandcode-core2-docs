<template>
    <Page>
        <div ref="map1" style="width:800px;height:400px;"></div>
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
    initFrame() {
    },
    mounted() {
        let map = new ol.Map({
            target: this.$refs.map1,
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
}
</script>
