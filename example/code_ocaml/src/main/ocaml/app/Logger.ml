let log_current_test received n =
    Printf.printf "> fibonacci(%i) = %i\n" n received;;

let log_no_match expected =
    Printf.eprintf "----------------------------------------------------\n";
    Printf.eprintf "The result does not match the expected value: %i\n" expected;
    Printf.eprintf "----------------------------------------------------\n";;

let log_exception e =
    Printf.eprintf "----------------------------------------------------\n";
    Printf.eprintf "An error occurred during runtime.\n";
    Printf.eprintf "Details:\n";
    let msg = Printexc.to_string e in
    Printf.eprintf "%s\n" msg;;

let log_success () =
    Printf.printf "Everything went well, good job!\n";
    Printf.printf "----------------------------------------------------\n";;
