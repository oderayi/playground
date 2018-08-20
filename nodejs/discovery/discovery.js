
/**
 * LoopBack Discovery Script
 * 
 * This is a model discovery script for LoopBack
 * This script assumes you have set up a datasource named "exposed_db" in your datasources.json file.
 * This script supports any database driver because it uses core LoopBack APIs.
 * 
 * Usage: 
 *   $ node ./server/discovery
 *
 * @file    /server/discovery.js
 * @author  Steven Oderayi
 * @license MIT
 *
 */

'use strict';

var app = require('./server');
var fs = require('fs');
var path = require('path');
const modelsDir = path.join(__dirname, '../common/models');
const modelConfigFile = path.join(__dirname, 'model-config.json');
var modelConfig = require('./model-config.json');

// FIXME: pass as parameter from cli
var ds = app.dataSources.exposed_db;

ds.connector.discoverModelDefinitions({views: true}, function(err, tables) {
  tables.forEach(function(tb) {
    console.log('Discovering: ' + tb.name + '...');
    let tableName = tb.name;
    let owner = tb.owner;
    ds.discoverSchema(tableName, function(err, schema) {
      fs.writeFileSync(
        path.join(modelsDir, schema.name + '.json'),
        JSON.stringify(schema, null, '  ')
      );
      modelConfig[schema.name] = {dataSource: ds.settings.name, public: true};
      fs.writeFileSync(
        modelConfigFile,
        JSON.stringify(modelConfig, null, '  ')
      );
    });
  });
});
