var { mongoose } = require('../server/db/mongoose')
var reader = require('../controller/reader.js')

var conn = mongoose.connection

var company = reader.readCsv().then((data) => {
    console.log('Success!')
    conn.collection('companies').insert(data)
})
