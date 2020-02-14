'use strict';

class RouterBuilder {
    build(app) {  
        app.use('/activities',require('./activities.route'));  
    }
}

module.exports = new RouterBuilder();