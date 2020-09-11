//1)

//Observe: no return type, no type on parameters
function add(n1, n2){
   return n1 +n2;
}

var sub = function(n1,n2){
  return n1 - n2
} 

var cb = function(n1,n2, callback){
    if(typeof n1 === "number" && typeof callback === "function"){
        return "Result from the two numbers: "+n1+"+"+n2+"="+callback(n1,n2);
    }
};

function mul(n1, n2){
    return n1/n2
}

//2)

console.log( add(1,2) )     // What will this print?
//3
console.log( add )          // What will it print and what does add represent?
//0, it represent the function add which puts n1 and n2 together

console.log( add(1,2,3) ) ; // What will it print
//It ignores the last parameter, since it only takes to and returns that sum, 3

console.log( add(1) );      // What will it print
//Returns NaN, since it misses a parameter

console.log( cb(3,3,add) ); // What will it print
//It returns a String with 3 + 3 = and takes the callback function and returns the sum, 6

console.log( cb(4,3,sub) ); // What will it print
//It returns a String with 4 + 3 = and takes the callback function and returns, 1

try{
console.log(cb(3,3,add())); // What will it print (and what was the problem)
//The problem is the parantethese in the add function, wich then ignores the other parameters
}catch(e){
    console.log("Enten var callback functionen skrevet forkert ellers havde du andet end tal i dine parametre")
}

console.log(cb(3,"hh",add));// What will it print
//This will print 3 + "hh" = 3hh

//3)
console.log(cb(4,2,mul));