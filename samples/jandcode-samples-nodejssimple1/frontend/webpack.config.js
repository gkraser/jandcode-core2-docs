// подключаем среду со всеми известными модулями
let mods = require("jc-nodejs-modules")

const path = require('path');

module.exports = {
    mode: 'development',
    entry: './src/index.js',
    output: {
        path: path.resolve(__dirname, '_gen/public'),
        filename: 'main.bundle.js',
        library: {
            name: 'MainApp',
            type: 'var',
        },
    },
    resolve: {
        modules: [
            // тут webpack будет искать модули
            ...mods.resolvePaths
        ],
    },
    resolveLoader: {
        modules: [
            // тут webpack будет искать модули
            ...mods.resolvePaths
        ],
    }

};
