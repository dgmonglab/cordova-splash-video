function splashvideo() {}


splashvideo.install = function() {
    if (!window.plugins) {
        window.plugins = {};
    }

    window.plugins.splashvideo = new splashvideo();
    console.log("splashvideo start")
    return window.plugins.splashvideo;
};

cordova.addConstructor(splashvideo.install);
