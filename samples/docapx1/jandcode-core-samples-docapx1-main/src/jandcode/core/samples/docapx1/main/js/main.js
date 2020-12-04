import {apx, Vue} from './vendor'
import App from './App'
import Home from './frames/Home'
import {DecorFrameWarning} from './components'

export function run() {

    if (Jc.cfg.envDev) {  // только в dev-режиме
        // для просмотра api, который предоставляет apx
        console.info("apx", apx);
    }

    let routes = [
        {path: '', frame: Home},
        {
            path: '/frames/withparams/:id/:code',
            frame: 'jandcode/core/samples/docapx1/main/js/frames/ShowFrameWithParams.vue'
        },
        {
            path: '/frames/dialog1',
            frame: 'jandcode/core/samples/docapx1/main/js/frames/ShowDialog.vue'
        },
    ]

    // перед тем, как приложение запустится
    apx.app.onBeforeRun(async () => {
        // загрузим routes
        let res = await apx.dao('docapx1/api').invoke("frames/routes")
        routes.push(...res)
    })

    apx.app.run(() => {

        if (Jc.cfg.envDev) {
            // для просмотра routes
            console.info("routes", routes);
        }

        apx.app.frameRouter.addRoutes(routes)

        // регистрация глобальных декораторов
        apx.frame.componentHolder.set('frame.PageWarning', DecorFrameWarning)

        let vm = new Vue({
            render(h) {
                return h(App)
            }
        })
        vm.$mount("#jc-app")

    })

}
