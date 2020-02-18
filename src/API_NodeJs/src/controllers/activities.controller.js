'use strict'

const Activities = require('../../src/models/activities');
//const datetime = require('node-datetime')

class ActivitiesController{

        async createActivities(name,description,importanceLevel,timeString){
        const time = new Date(timeString);
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
        async listActivitiesEnd(){
            return await Activities.find({
                isEnd : true
            });
        }
        async listActivitiesWorking(){
            return await Activities.find({
                isEnd : false
            });
        }
        async setEndActivities(id){
            var activitie = await Activities.findOne({
                _id : id
            });
         
            activitie.isEnd = true;
            activitie.save(function(err){
                if(err) throw err;
            });
            const p = "Tache terminée";
            return p;
            
        }
}
module.exports = new ActivitiesController();