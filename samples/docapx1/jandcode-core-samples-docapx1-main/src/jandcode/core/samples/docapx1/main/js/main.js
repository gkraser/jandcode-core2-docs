import {apx, Vue} from './vendor'
import App from './App'
import Home from './frames/Home'
import {DecorFrameWarning} from './components'

export function run() {

    // для просмотра api, который предоставляет apx
    console.info("apx", apx);

    let routes = [
        {path: '', frame: Home},
        {
            path: '/frames/withparams/:id/:code',
            frame: 'jandcode/core/samples/docapx1/main/js/frames/ShowFrameWithParams.vue'
        },
    ]

    apx.app.run(() => {

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
