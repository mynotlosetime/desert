/**
 * Created by Дмитрий on 28.01.2017.
 */
var webpack = require('webpack');
var HtmlWebpackPlugin = require('html-webpack-plugin');
var ExtractTextPlugin = require('extract-text-webpack-plugin');
var helpers = require('./helpers');

module.exports = {
    entry: {
        'vendor': './src/vendor.ts',
        'main':  './src/main.ts'
    },

    resolve: {
        extensions: ['.ts', '.js']
    },

    module: {
        rules: [
            {
                test: /\.ts$/,
                loaders: 'awesome-typescript-loader!angular2-template-loader?keepUrl=true'
            },
            {
                test: /\.html$/,
                loader: 'html-loader?minimize=true',
                exclude: [helpers.root('index.html')]
            },
            {
                test: /\.(png|jpe?g|gif|svg|woff|woff2|ttf|eot|ico)$/,
                loader: 'file-loader?name=assets/[name].[hash].[ext]'
            },
            {
                test: /\.sass/,

                loader: ExtractTextPlugin.extract({
                    fallbackLoader: 'style-loader',
                    loader: 'css-loader?sourceMap!sass-loader?sourceMap'
                })
            },
            {
                test: /\.css$/,
                include: helpers.root('src', 'app'),
                loader: 'raw-loader'
            }
        ]
    },

    plugins: [
        // Workaround for angular/angular#11580
        new webpack.ContextReplacementPlugin(
            // The (\\|\/) piece accounts for path separators in *nix and Windows
            /angular(\\|\/)core(\\|\/)(esm(\\|\/)src|src)(\\|\/)linker/,
            helpers.root('./src'), // location of your src
            {} // a map of your routes
        ),

        new webpack.optimize.CommonsChunkPlugin({
            name: ['main','vendor']
        }),

        new HtmlWebpackPlugin({
            template: './index.html'
        })
    ]
};