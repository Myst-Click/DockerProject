'use strict'

const Activities = require('../../src/models/activities');
//const datetime = require('node-datetime')

class ActivitiesController{

        async createActivities(name,description,importanceLevel,time){
        
        var newActivities = new Activities({
            name:name,
            description: description,
            importanceLevel:importanceLevel,
            time:time,
            isEnd:false
        });

        newActivities.save(function(err){
            if(err) throw err;
        });

        return newActivities;
        }
        async isExist(name){
            return await Activities.find({
                name:name
            })
        }
        async listActivities(){
            return await Activities.find();
        }
}
module.exports = new ActivitiesController();