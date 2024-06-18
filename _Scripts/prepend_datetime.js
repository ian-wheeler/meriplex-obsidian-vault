const moment = require('moment');

function prependDatetime(filename) {
    const datetime = moment().format('YYYYMMDDHHmmss');
    const newFilename = `${datetime}_${filename}`;
    return newFilename;
}

module.exports = prependDatetime;
