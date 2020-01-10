var request = require('request');
var base_url = "http://apitest:8080/";    

describe("When testing 'api/products/1'", function(){
    it("should respond with the URL of a cat GIF", function(done) {
        request(base_url + 'api/products/1', function(error, response, body){
            product = JSON.parse(body)
            expect(product["description"]).toMatch('resistor');
            done();
        });
    });
});
