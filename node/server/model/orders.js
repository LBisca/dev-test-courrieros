var mongoose = require('mongoose')

var Order = mongoose.model('company', {
    companyName: {
        type: String,
        required: true
    },
    order: {
        type: String,
        required: true
    },
    distance: {
        type: String,
        required: true
    }
})

module.exports = { Order }