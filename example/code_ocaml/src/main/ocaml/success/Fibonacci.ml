(* Executed when you Run your code *)
let main() =
    ();;

let rec fibonacci n =
    if n == 1 || n == 0 then n
    else fibonacci (n - 1) + fibonacci (n - 2);;