'use strict'
var express = require('express');
var router = express.Router();
var bodyParser = require('body-parser');
router.use(bodyParser.urlencoded({ extended: true }));
router.use(bodyParser.json());
const ActivitiesController = require('../controllers/activities.controller.js')

router.get('/test',async(req,res)=>{
    res.sendStatus(200);
      res.json({
        success : true,
        message : "API Connecté"
      });
})
router.post('/new', async(req, res)=>{
    const name = req.body.name;
    const description = req.body.description;
    const importanceLevel = req.body.importanceLevel;
    const time = req.body.time;
   
    const p = await ActivitiesController.createActivities(name,description,importanceLevel,time);
    if(p === undefined){
      res.send(400);
      res.json({
        success : false,
        message : "Impossible de creer cette tache"
      });
    } 
    else{
      res.sendStatus(201).end;
    } 
  
   });

module.exports = router;