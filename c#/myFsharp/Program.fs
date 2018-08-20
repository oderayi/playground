// Learn more about F# at http://fsharp.org

open System

let greet (name, age) =
    printfn "Hello, your name is %s, and your age is %d." name age

let rec factorial n = 
        if n = 0 then 1 else n * factorial (n-1)

let rec greatestCommonFactor a b =
        if a = 0 then b
        elif a < b then greatestCommonFactor a (b - a)
        else greatestCommonFactor (a - b) b


[<EntryPoint>]
let main argv =
    greet ("Steven", 34)
    printfn "Factorial of 6 is: %d" (factorial 6)
    printfn "The Greatest Common Factor of 300 and 620 is %d" (greatestCommonFactor 300 620)
    0 // return an integer exit code
