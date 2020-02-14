'use strict'
// get an instance of mongoose and mongoose.Schema
var mongoose = require('mongoose');
var Schema = mongoose.Schema;

// set up a mongoose model and pass it using module.exports
module.exports = mongoose.model('Activities', new Schema({ 
  name:{ type : String,
         required : true,
        },
  description: { type : String,
           required : true,
        },
  importanceLevel:{ type : Number,
            required : true
        },
  time: {type : Date,
            required : true,
        }
}));