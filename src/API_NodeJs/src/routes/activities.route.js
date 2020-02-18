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
router.post('/setEnd', async(req,res) =>{

    const name = req.body.name;
    
    const p = await ActivitiesController.setEndActivities(name);

    res.sendStatus(200);
    res.json(p);
})
router.post('/new', async(req, res)=>{
    const name = req.body.name;
    const description = req.body.description;
    const importanceLevel = req.body.importanceLevel;
    const time = req.body.time;
    
    const isExist = await ActivitiesController.isExist(name);
    if(isExist){
        res.json({
          success : false,
          message : "Une tache avec le meme nom existe déja"
        });
        res.send(400);
        
    }
    const p = await ActivitiesController.createActivities(name,description,importanceLevel,time);
    if(p === undefined){
      res.send(200);
      res.json({
        success : false,
        message : "Impossible de creer cette tache"
      });
    } 
    else{
      res.sendStatus(201).end;
    } 
  
});
router.get('/', async(req, res)=>{
    const p = await ActivitiesController.listActivities();
    if(p)
    {
        res.json(p);
    }
    else{
        res.sendStatus(403);
       res.json({
        success : false,
        message : "Erreur de listage"
        });
    }
     
});
router.get('/workingActivities',async(req,res)=>{
    const p = await ActivitiesController.listActivitiesWorking();
    if(p)
    {
        res.json(p);
    }
    else{
        res.sendStatus(403);
       res.json({
        success : false,
        message : "Erreur de listage"
        });
    }
})
router.get('/EndActivities',async(req,res)=>{
  const p = await ActivitiesController.listActivitiesEnd();
  if(p)
  {
      res.json(p);
  }
  else{
      res.sendStatus(403);
     res.json({
      success : false,
      message : "Erreur de listage"
      });
  }
})
module.exports = router;