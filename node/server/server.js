var express = require('express')

var { mongoose } = require('./db/mongoose')
var { Order } = require('./model/orders')

var app = express()
const port = process.env.PORT || 3000

app.get('/client/total', (req, res) => {
    Order.find().then((company) => {
        res.send({ company })
    }, (e) => {
        res.status(400).send(e)
    })
})

app.listen(port, () => {
    console.log(`Starting at the ${port} port`)
})