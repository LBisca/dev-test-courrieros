const fs = require('fs');
const CsvReadableStream = require('csv-reader');

var groupBy = (array, key) => {
    return array.reduce((acc, element) => {
        var name = element[key]
        if (acc[name] == null) {
            acc[name] = [element]
        } else {
            acc[name].push(element)
        }

        return acc;
    }, {});
};

var sumBy = (array, key) => {
    return array.reduce((acc, element) => {
        return acc + element[key]
    }, 0)
}

async function readCsv() {
    return new Promise((resolve, reject) => {
        let inputStream = fs.createReadStream('../resources/client_orders.csv', 'utf8')
        var orderList = []
        var totalList = []

        inputStream.pipe(CsvReadableStream({ parseNumbers: true, parseBooleans: true, trim: true }))
        .on('data', row => {
            let co2 = (row[2] / 1000) * 0.113
            orderList.push({ name: row[0], order: row[1], distance: row[2], co2: co2 })
        })
        .on('end', data => {
            orderList = groupBy(orderList, 'name')

            for (var company in orderList) {
                let companyOrders = orderList[company]
                let total = sumBy(companyOrders, "co2")

                totalList.push({
                    name: company,
                    total: total
                });
            }
        
            resolve(totalList)    
        });
    })   
}


module.exports = {readCsv}