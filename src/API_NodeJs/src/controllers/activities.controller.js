'use strict'

const Activities = require('../../src/models/activities');
//const datetime = require('node-datetime')

class ActivitiesController{

        async createActivities(name,description,importanceLevel,time){

        var newActivities = new Activities({
            name:name,
            description: description,
            importanceLevel:importanceLevel,
            time:time
        });

        newActivities.save(function(err){
            if(err) throw err;
        });

        return newActivities;
        }
        async getById(id){
            return  Attraction.findOne({
                _id : id
            });
        };
}
module.exports = new ActivitiesController();