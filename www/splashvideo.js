function splashvideo() {}


splashvideo.install = function() {
    if (!window.plugins) {
        window.plugins = {};
    }

    window.plugins.wallpaper = new splashvideo();
    return window.plugins.splashvideo;
};

cordova.addConstructor(splashvideo.install);
