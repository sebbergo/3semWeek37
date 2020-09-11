//1
var array = ["Lars", "Jan", "Peter", "Bo", "Frederik"]

//console.log(array)

function filterNames(array, amount){
    var filteredNames = array.filter(function(word){
        return word.length <= amount
    });
    return filteredNames
}

var newArray = filterNames(array, 3)

//console.log(newArray)

//2
var upperArray = array.map(word => word.toUpperCase())

//console.log(upperArray)

//3
function htmlArray (array){
    var returnArr = array
    array.unshift("<ul>")
    array.push("<ul>")
    
    returnArr = array.join("<li>")
    
    return returnArr
}

//console.log(htmlArray(array))

//4
var cars = [
  { id: 1, year: 1997, make: 'Ford', model: 'E350', price: 3000 },
  { id: 2, year: 1999, make: 'Chevy', model: 'Venture', price: 4900 },
  { id: 3, year: 2000, make: 'Chevy', model: 'Venture', price: 5000 },
  { id: 4, year: 1996, make: 'Jeep', model: 'Grand Cherokee', price: 4799 },
  { id: 5, year: 2005, make: 'Volvo', model: 'V70', price: 44799 }
];

//a
var newCars = cars.filter(c => c.year > 1999)

//console.log(newCars)

var volvoCars = cars.filter(c => c.make === "Volvo")

//console.log(volvoCars)

var below5000Cars = cars.filter(c => c.price < 5000)

//console.log(below5000Cars)

//4a
sqlCars = cars.filter(x => x.year > 1999).map(x => 'INSERT INTO cars (id,year,make,model,price) VALUES \n\
('+ x.id +', '+x.year+', '+x.make+', '+x.model+', '+x.price+');')

//console.log(sqlCars.join(""))

//Asynchronus Callbacks
//1
var msgPrinter = function(msg,delay){
  setTimeout(function(){
    console.log(msg);
  },delay);
};
/*
console.log("aaaaaaaaaa");
msgPrinter ("bbbbbbbbbb",2000);
console.log("dddddddddd");
msgPrinter ("eeeeeeeeee",1000);
console.log("ffffffffff");
*/

/*
 * 1. a
 * 2. d
 * 3. f
 * 4. e
 * 5. b
 */

//this and constructor functions
//1
function Person(name){
  this.name = name;
  console.log("Name: "+ this.name);
  setTimeout(function(){
    console.log("Hi  "+this.name);  //Explain this
  },2000);
}
//call it like this (do it, even if you know it’s silly ;-)
Person("Kurt Wonnegut");  //This calls the function
console.log("I'm global: "+ name);  //Explain this