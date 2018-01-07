const path = require("path");
const HtmlWebpackPlugin = require("html-webpack-plugin");

const APP_DIR = path.resolve(__dirname + "/app");
const DIST_DIR = path.resolve(__dirname + "/dist");

const config = {
    entry: APP_DIR + "/components/main/index.tsx",
    output: {
        path: DIST_DIR,
        filename: "bundle.js"
    },
    resolve: {
        extensions: [".ts", ".tsx", ".js", ".jsx"]
    },
    module: {
        rules: [
            {
                test: /\.tsx?$/, loaders: ["babel-loader","ts-loader"]
            },
            {
                test: /\.css$/, loaders: ["style-loader", "css-loader"]
            }
        ]
    },
    devServer: {
        port: 8000
    },
    plugins:[
        new HtmlWebpackPlugin({
            template: APP_DIR + "/index.html"
        })
    ]
};

module.exports = config;
