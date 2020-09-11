//A
var boys = ["Peter", "Lars", "Ole"]
var girls = ["Janne", "Hanne", "Sanne"]

var mixedGenders = boys.concat(girls)

//console.log(mixedGenders)

//B
var all = boys.concat(girls)

//C
var commaAll = all.join()
var dashAll = all.join('-')
//console.log(dashAll)

//D
all.push("Lone", "Gitte")
//console.log(all)

//E
all.unshift("Hans", "Kurt")
//console.log(all)

//F
all.shift("Hans")

//console.log(all)

//G
all.pop("Gitte")

//console.log(all)

//H
all.splice(3, 2)

//console.log(all)

//I
all.reverse()

//console.log(all)

//J
all.sort()

//console.log(all)

//K
//Det bliver senere

//L
var upperCaseArray = all.map(n=> n.toUpperCase())

//console.log(upperCaseArray)

//M

        
function filterNames(array, index, letter){
    var filteredNames = array.filter(function(word){
        return word[index] === letter
    });
    return filteredNames
}

var newArray = filterNames(upperCaseArray, 0, 'L')
console.log(newArray)