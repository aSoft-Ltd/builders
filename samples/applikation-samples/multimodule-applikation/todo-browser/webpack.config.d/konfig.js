config.resolve.modules.push("/media/andylamax/63C23C360914D355/aSoft/OSS Libs/builders/code/samples/applikation-samples/multimodule-applikation/todo-browser/build/resources/main")
config.module.rules.push({
    test: /\.(png|jpe?g|gif|svg)$/i,
    use: [
      {
        loader: 'file-loader',
      },
    ],
});